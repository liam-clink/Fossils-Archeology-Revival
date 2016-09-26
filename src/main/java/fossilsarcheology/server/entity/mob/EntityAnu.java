package fossilsarcheology.server.entity.mob;

import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.EntityAnuLightning;
import fossilsarcheology.server.entity.FossilPlayerProperties;
import fossilsarcheology.server.entity.ai.AnuAIMelee;
import fossilsarcheology.server.entity.ai.AnuAIAvoidEntity;
import fossilsarcheology.server.entity.ai.AnuAIFireballAttack;
import fossilsarcheology.server.gen.feature.SpikesBlockWorldGen;
import fossilsarcheology.server.handler.FossilAchievementHandler;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.SkeletonType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityAnu extends EntityMob implements IBossDisplayData, IRangedAttackMob {
    private static final DataParameter<Byte> ATTACK_MODE = EntityDataManager.createKey(EntityAnu.class, DataSerializers.BYTE);

    public static final int TOTAL_HEALTH = 600;
    public static final int MIDDLE_HEALTH = 400;
    public static final int FINAL_HEALTH = 200;
    public static final int SONG_LENGTH = 4041;

    public int songCounter = 0;
    public boolean isFlying;
    private AnuAIAvoidEntity aiFear = new AnuAIAvoidEntity<>(this, EntityPlayer.class, 5.0F, 0.8D, 1.33D);
    private AnuAIMelee aiAttackOnCollide = new AnuAIMelee(this, 1.2D, false);
    private AnuAIFireballAttack aiFireballAttack = new AnuAIFireballAttack(this, 1.0D, 10, 20, 15.0F);
    private BlockPos currentTarget;

    public EntityAnu(World world) {
        super(world);
        this.setSize(1F, 1.8F);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityLivingBase.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.tasks.addTask(4, aiFear);
        this.tasks.addTask(5, aiFireballAttack);
        this.tasks.addTask(5, aiAttackOnCollide);
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, false, true));
        this.isImmuneToFire = true;
        this.experienceValue = 50;
    }

    public void setFlying(boolean state) {
        this.isFlying = state;
    }

    @Override
    public boolean isAIDisabled() {
        return false;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(600D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if (this.getAttackMode() == AttackMode.MELEE) {
            return "fossil:anu_living_healthy";
        } else if (this.getAttackMode() == AttackMode.RANGED_FLIGHT) {
            return "fossil:anu_living_middle";
        }
        return "fossil:anu_living_middle";
    }

    @Override
    protected SoundEvent getHurtSound() {
        return SoundEvents.ENTITY_ITEM_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_IRONGOLEM_DEATH;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        Entity targetEntity = source.getEntity();
        if (targetEntity instanceof EntityGhast) {
            return false;
        } else {
            if (targetEntity instanceof EntityPlayer) {
                if (this.getRNG().nextInt(10) == 0) {
                    if (damage > 0.0F) {
                        ItemStack heldItem = ((EntityPlayer) targetEntity).inventory.getCurrentItem();
                        if (heldItem != null) {
                            if (heldItem.getItem() == FAItemRegistry.INSTANCE.ancientSword) {

                                if (!this.worldObj.isRemote) {
                                    Revival.messagePlayer(I18n.translateToLocal("entity.fossil.PigBoss.name") + ": " + I18n.translateToLocal("anuSpeaker.mySword"), (EntityPlayer) targetEntity);
                                }

                                return super.attackEntityFrom(source, damage);
                            }

                            if (heldItem.getItem() != FAItemRegistry.INSTANCE.ancientSword && heldItem.getItem() instanceof ItemSword) {
                                if (!this.worldObj.isRemote) {
                                    Revival.messagePlayer(I18n.translateToLocal("entity.fossil.PigBoss.name") + ": " + I18n.translateToLocal("anuSpeaker.draw"), (EntityPlayer) targetEntity);
                                }
                                return super.attackEntityFrom(source, damage);
                            }

                            if (source.damageType.equals("arrow")) {
                                if (!this.worldObj.isRemote) {
                                    Revival.messagePlayer(I18n.translateToLocal("entity.fossil.PigBoss.name") + ": " + I18n.translateToLocal("anuSpeaker.coward"), (EntityPlayer) targetEntity);
                                }
                                return super.attackEntityFrom(source, damage);
                            }
                        }
                    }
                }
            }
        }
        return super.attackEntityFrom(source, damage);
    }

    @Override
    public void updateAITasks() {
        if (this.getAttackMode() == AttackMode.DEFENSE || this.getAttackMode() == AttackMode.RANGED_FLIGHT) {
            if (this.ticksExisted % 20 == 0) {
                this.heal(2.0F);
            }
        }
        super.updateAITasks();
    }

    @Override
    protected Entity findPlayerToAttack() {
        EntityPlayer player = this.worldObj.getNearestPlayerNotCreative(this, 16.0D);
        if (player != null && this.canEntityBeSeen(player)) {
            if (this.getRNG().nextInt(1) == 0) {
                Revival.messagePlayer(I18n.translateToLocal("entity.fossil.PigBoss.name") + ": " + I18n.translateToLocal("anuSpeaker.hello"), player);
            } else {
                Revival.messagePlayer(I18n.translateToLocal("entity.fossil.PigBoss.name") + ": " + I18n.translateToLocal("anuSpeaker.fewBeaten"), player);
            }
            super.findPlayerToAttack();
            return player;
        }
        return null;
    }

    @Override
    public void onDeath(DamageSource source) {
        if (source.getSourceOfDamage() instanceof EntityArrow || source.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) source.getEntity();
            this.onKillEntity(player);
            double deltaX = player.posX - this.posX;
            double deltaZ = player.posZ - this.posZ;
            if (deltaX * deltaX + deltaZ * deltaZ >= 2500.0D) {
                player.addStat(FossilAchievementHandler.anuDead);
            }
        }
        EntityAnuDead entity = new EntityAnuDead(this.worldObj);
        if (!this.worldObj.isRemote) {
            entity.setLocationAndAngles(this.posX + this.getRNG().nextInt(4), this.posY, this.posZ + this.getRNG().nextInt(4), this.rotationYaw, this.rotationPitch);
            this.worldObj.spawnEntityInWorld(entity);
        }
        entity.setHealth(0.0F);
        Revival.messagePlayer(I18n.translateToLocal("entity.fossil.PigBoss.name") + ": " + I18n.translateToLocal("anuSpeaker.no"), this.worldObj.getClosestPlayerToEntity(this, 50));
        super.onDeath(source);
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    protected void updateFallState(double y, boolean onGround, IBlockState state, BlockPos pos) {
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (this.getRNG().nextInt(4) == 0) {
            this.worldObj.addWeatherEffect(new EntityAnuLightning(this.worldObj, entity.posX, entity.posY, entity.posZ));
        }
        return super.attackEntityAsMob(entity);
    }

    public void spawnMobs(EntityLiving entity) {
        if (!this.worldObj.isRemote) {
            entity.setLocationAndAngles(this.posX + this.getRNG().nextInt(4), this.posY, this.posZ + this.getRNG().nextInt(4), this.rotationYaw, this.rotationPitch);
            this.worldObj.spawnEntityInWorld(entity);
            if (entity instanceof EntitySkeleton) {
                ((EntitySkeleton) entity).func_189768_a(SkeletonType.WITHER);
                entity.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.BOW));
            }
            if (entity instanceof EntitySentryPigman) {
                entity.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.IRON_SWORD));
            }
        }
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        this.dropItem(FAItemRegistry.INSTANCE.ancientKey, 1);
    }

    @Override
    public void onLivingUpdate() {
        if (songCounter < SONG_LENGTH) {
            songCounter++;
        }
        if (songCounter == SONG_LENGTH - 1) {
            songCounter = 0;
        }
        if (songCounter == 1) {
            Revival.PROXY.playSound("fossil:music.anu");
        }
        if (this.isDead) {
            Revival.PROXY.stopSound("fossil:music.anu");
        }
        if (this.attackingPlayer != null) {
            if (this.attackingPlayer.isDead) {
                Revival.PROXY.stopSound("fossil:music.anu");
            }
        }
        super.onLivingUpdate();
        if (this.getAttackMode() == AttackMode.RANGED_FLIGHT && !this.onGround && this.motionY < 0.0D) {
            this.motionY *= 0.6D;
        }
        if (this.getAttackMode() == AttackMode.RANGED_FLIGHT) {
            if (!worldObj.isRemote) {
                setFlying(true);
                if (!this.checkGround()) {
                    flyAround();
                }
                if (this.getAttackTarget() != null) {
                    currentTarget = new BlockPos((int) getAttackTarget().posX + rand.nextInt(20) - rand.nextInt(10), (int) ((int) getAttackTarget().posY + getAttackTarget().getEyeHeight()) + rand.nextInt(20) - rand.nextInt(10), (int) getAttackTarget().posZ + rand.nextInt(40) - rand.nextInt(10));
                    setFlying(false);
                    flyTowardsTarget();
                }
            }
        }
        if (this.getHealth() < MIDDLE_HEALTH && this.getAttackMode() != AttackMode.RANGED_FLIGHT) {
            this.setAttackMode(AttackMode.RANGED_FLIGHT);
        }
        if (this.getHealth() < FINAL_HEALTH && this.getAttackMode() != AttackMode.DEFENSE) {
            this.setAttackMode(AttackMode.DEFENSE);
        }
        if (this.getAttackMode() == AttackMode.RANGED_FLIGHT) {
            for (int i = 0; i < 2; ++i) {
                this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
            }
        }
        if (this.getAttackMode() == AttackMode.DEFENSE) {
            for (int i = 0; i < 2; ++i) {
                this.worldObj.spawnParticle(EnumParticleTypes.DRIP_LAVA, this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
            }
            int spikeChoice = this.getRNG().nextInt(250);
            int defenseChoice = this.getRNG().nextInt(500);
            int spawnPigmenChoice = this.getRNG().nextInt(250);
            int spawnWitherChoice = this.getRNG().nextInt(350);
            int spawnBlazeChoice = this.getRNG().nextInt(300);
            if (spikeChoice == 0) {
                this.playSound(SoundEvents.BLOCK_STONE_BREAK, 1, 1);
                new SpikesBlockWorldGen().generate(this.worldObj, this.getRNG(), this.getPosition());
            }
            if (defenseChoice == 0) {
                this.playSound(SoundEvents.BLOCK_STONE_BREAK, 1, 1);
                if (!worldObj.isRemote) {
                    BlockPos position = this.getPosition();
                    this.generateDefenseHutP1(position);
                    this.generateDefenseHutP2(position);
                    this.generateDefenseHutP2(position.up());
                    this.generateDefenseHutP2(position.up(2));
                    this.generateDefenseHutP1(position.up(4));
                }
            }
            if (spawnPigmenChoice == 0) {
                Revival.messagePlayer(I18n.translateToLocal("entity.fossil.PigBoss.name") + ": " + I18n.translateToLocal("anuSpeaker.trans"), this.worldObj.getClosestPlayerToEntity(this, 50));
                this.spawnMobs(new EntitySentryPigman(worldObj));
            }
            if (spawnWitherChoice == 0) {
                this.spawnMobs(new EntitySkeleton(worldObj));
                Revival.messagePlayer(I18n.translateToLocal("entity.fossil.PigBoss.name") + ": " + I18n.translateToLocal("anuSpeaker.archers"), this.worldObj.getClosestPlayerToEntity(this, 50));
            }
            if (spawnBlazeChoice == 0) {
                this.spawnMobs(new EntityBlaze(worldObj));
                Revival.messagePlayer(I18n.translateToLocal("entity.fossil.PigBoss.name") + ": " + I18n.translateToLocal("anuSpeaker.blaze"), this.worldObj.getClosestPlayerToEntity(this, 50));
            }
        }
    }

    public void flyTowardsTarget() {
        if (currentTarget != null) {
            double targetX = currentTarget.getX() + 0.5D - posX;
            double targetY = currentTarget.getY() + 1D - posY;
            double targetZ = currentTarget.getZ() + 0.5D - posZ;
            motionX += (Math.signum(targetX) * 0.5D - motionX) * 0.10000000149011612D;
            motionY += (Math.signum(targetY) * 0.699999988079071D - motionY) * 0.10000000149011612D;
            motionZ += (Math.signum(targetZ) * 0.5D - motionZ) * 0.10000000149011612D;
            float angle = (float) (Math.atan2(motionZ, motionX) * 180.0D / Math.PI) - 90.0F;
            float rotation = MathHelper.wrapDegrees(angle - rotationYaw);
            moveForward = 0.5F;
            rotationYaw += rotation;
        }
    }

    public void flyAround() {
        if (currentTarget != null) {
            if (!worldObj.isAirBlock(currentTarget) || currentTarget.getY() < 1) {
                currentTarget = null;
            }
        }
        if (currentTarget == null || rand.nextInt(30) == 0 || currentTarget.getDistance((int) posX, (int) posY, (int) posZ) < 10F) {
            currentTarget = new BlockPos((int) posX + rand.nextInt(20) - rand.nextInt(10), (int) posY + rand.nextInt(30) - 2, (int) posZ + rand.nextInt(20) - rand.nextInt(10));
        }
        flyTowardsTarget();
    }

    private void generateDefenseHutP2(BlockPos pos) {
        IBlockState state = Blocks.OBSIDIAN.setHardness(3).getDefaultState();
        this.worldObj.setBlockState(pos.add(-3, 0, 0), state);
        this.worldObj.setBlockState(x - 3, y, z + 1, state);
        this.worldObj.setBlockState(x - 3, y, z + 2, state);
        this.worldObj.setBlockState(x - 3, y, z - 1, state);
        this.worldObj.setBlockState(x - 3, y, z - 2, state);
        this.worldObj.setBlockState(x + 3, y, z, state);
        this.worldObj.setBlockState(x + 3, y, z + 1, state);
        this.worldObj.setBlockState(x + 3, y, z + 2, state);
        this.worldObj.setBlockState(x + 3, y, z - 1, state);
        this.worldObj.setBlockState(x + 3, y, z - 2, state);
        this.worldObj.setBlockState(pos.add(0, 0, 3), state);
        this.worldObj.setBlockState(x + 1, y, z + 3, state);
        this.worldObj.setBlockState(x + 2, y, z + 3, state);
        this.worldObj.setBlockState(x - 1, y, z + 3, state);
        this.worldObj.setBlockState(x - 2, y, z + 3, state);
        this.worldObj.setBlockState(pos.add(0, 0, -3), state);
        this.worldObj.setBlockState(x + 1, y, z - 3, state);
        this.worldObj.setBlockState(x + 2, y, z - 3, state);
        this.worldObj.setBlockState(x - 1, y, z - 3, state);
        this.worldObj.setBlockState(x - 2, y, z - 3, state);
    }

    private void generateDefenseHutP1(BlockPos pos) {
        IBlockState state = Blocks.OBSIDIAN.setHardness(3).getDefaultState();
        this.worldObj.setBlockState(x, y - 1, z, state);
        this.worldObj.setBlockState(x + 1, y - 1, z, state);
        this.worldObj.setBlockState(x + 2, y - 1, z, state);
        this.worldObj.setBlockState(x - 1, y - 1, z, state);
        this.worldObj.setBlockState(x - 2, y - 1, z, state);
        this.worldObj.setBlockState(x, y - 1, z + 1, state);
        this.worldObj.setBlockState(x + 1, y - 1, z + 1, state);
        this.worldObj.setBlockState(x + 2, y - 1, z + 1, state);
        this.worldObj.setBlockState(x - 1, y - 1, z + 1, state);
        this.worldObj.setBlockState(x - 2, y - 1, z + 1, state);
        this.worldObj.setBlockState(x, y - 1, z + 2, state);
        this.worldObj.setBlockState(x + 1, y - 1, z + 2, state);
        this.worldObj.setBlockState(x + 2, y - 1, z + 2, state);
        this.worldObj.setBlockState(x - 1, y - 1, z + 2, state);
        this.worldObj.setBlockState(x - 2, y - 1, z + 2, state);
        this.worldObj.setBlockState(x, y - 1, z - 1, state);
        this.worldObj.setBlockState(x + 1, y - 1, z - 1, state);
        this.worldObj.setBlockState(x + 2, y - 1, z - 1, state);
        this.worldObj.setBlockState(x - 1, y - 1, z - 1, state);
        this.worldObj.setBlockState(x - 2, y - 1, z - 1, state);
        this.worldObj.setBlockState(x, y - 1, z - 2, state);
        this.worldObj.setBlockState(x + 1, y - 1, z - 2, state);
        this.worldObj.setBlockState(x + 2, y - 1, z - 2, state);
        this.worldObj.setBlockState(x - 1, y - 1, z - 2, state);
        this.worldObj.setBlockState(x - 2, y - 1, z - 2, state);
    }

    public boolean checkGround() {
        return !this.onGround && this.worldObj.isAirBlock(this.getPosition().down());
    }

    @Nullable
    @Override
    public ItemStack getHeldItem(EnumHand hand) {
        return new ItemStack(FAItemRegistry.INSTANCE.ancientSword);
    }

    public void initializeMob() {
        this.setAttackMode(AttackMode.MELEE);
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(FAItemRegistry.INSTANCE.ancientSword));
        this.enchantEquipment();
        EntityPlayer player = this.worldObj.getClosestPlayer(posX, posY, posZ, 100F, false);
        if (player != null) {
            if (this.getRNG().nextInt(1) == 0) {
                Revival.messagePlayer(I18n.translateToLocal("entity.fossil.PigBoss.name") + ": " + I18n.translateToLocal("anuSpeaker.hello"), player);
            } else {
                Revival.messagePlayer(I18n.translateToLocal("entity.fossil.PigBoss.name") + ": " + I18n.translateToLocal("anuSpeaker.fewBeaten"), player);
            }
        }
    }

    public AttackMode getAttackMode() {
        return AttackMode.values()[this.dataManager.get(ATTACK_MODE)];
    }

    public void setAttackMode(AttackMode attackMode) {
        this.dataManager.set(ATTACK_MODE, (byte) attackMode.ordinal());
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setByte("AttackMode", (byte) this.getAttackMode().ordinal());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setAttackMode(AttackMode.values()[compound.getByte("AttackMode")]);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(ATTACK_MODE, (byte) 0);
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
        data = super.onInitialSpawn(difficulty, data);
        this.initializeMob();
        return data;
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase entity, float y) {
        double deltaX = entity.posX - this.posX;
        double deltaY = entity.getEntityBoundingBox().minY + (double) (entity.height / 2.0F) - (this.posY + (double) (this.height / 2.0F));
        double deltaZ = entity.posZ - this.posZ;
        this.worldObj.playEvent(null, 1008, this.getPosition(), 0);
        EntityLargeFireball fireball = new EntityLargeFireball(this.worldObj, this, deltaX, deltaY, deltaZ);
        fireball.explosionPower = 2;
        double offset = 4.0D;
        Vec3d look = this.getLook(1.0F);
        fireball.posX = this.posX + look.xCoord * offset;
        fireball.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
        fireball.posZ = this.posZ + look.zCoord * offset;
        this.worldObj.spawnEntityInWorld(fireball);
    }

    @Override
    public void onKillEntity(EntityLivingBase entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            FossilPlayerProperties.get(player).setKilledAnu(true);
        }
    }

    public enum AttackMode {
        MELEE,
        RANGED_FLIGHT,
        DEFENSE
    }
}
