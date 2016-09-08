package fossilsarcheology.server.entity.mob;

import fossilsarcheology.Revival;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.I18n;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityFriendlyPigZombie extends EntityTameable {
    private static final ItemStack DEFAULT_HELD_ITEM = new ItemStack(Items.GOLDEN_SWORD, 1);

    public EntityFriendlyPigZombie(World var1) {
        super(var1);
        this.setSize(0.5F, 1.9F);
        this.isImmuneToFire = true;
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(4, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.setTamed(false);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(19, (byte) 0);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    @Override
    public void onKillEntity(EntityLivingBase entity) {
        super.onKillEntity(entity);
        sendMessageToOwner("pigman.kill");
    }

    @Override
    public void setAttackTarget(EntityLivingBase mob) {
        super.setAttackTarget(mob);
        if (mob == null) {
            this.setAngry(false);
        } else if (!this.isTamed()) {
            this.setAngry(true);
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("Angry", this.isAngry());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setAngry(compound.getBoolean("Angry"));
    }

    @Override
    public boolean attackEntityFrom(DamageSource damage, float amount) {
        if (this.isEntityInvulnerable(damage)) {
            return false;
        } else {
            Entity entity = damage.getEntity();
            this.aiSit.setSitting(false);
            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
                amount = (amount + 1.0F) / 2.0F;
            }
            return super.attackEntityFrom(damage, amount);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        boolean damaged = entity.attackEntityFrom(DamageSource.causeMobDamage(this), 5);
        if (damaged) {
            int difficulty = this.worldObj.getDifficulty().getDifficultyId();
            if (this.getHeldItem(EnumHand.MAIN_HAND) == null && this.isBurning() && this.rand.nextFloat() < (float) difficulty * 0.3F) {
                entity.setFire(2 * difficulty);
            }
        }
        return damaged;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block block) {
        this.playSound(SoundEvents.ENTITY_ZOMBIE_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
        if (this.isTamed()) {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.0D);
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        }
    }

    public boolean isAngry() {
        return (this.dataManager.getWatchableObjectByte(16) & 2) != 0;
    }

    public void setAngry(boolean angry) {
        byte b0 = this.dataManager.getWatchableObjectByte(16);
        if (angry) {
            this.dataManager.updateObject(16, (byte) (b0 | 2));
        } else {
            this.dataManager.updateObject(16, (byte) (b0 & -3));
        }
    }

    public void sendMessageToOwner(String words) {
        if (this.getOwner() instanceof EntityPlayer) {
            Revival.messagePlayer(I18n.translateToLocal(words), (EntityPlayer) this.getOwner());
        }
    }

    @Override
    public boolean func_142018_a(EntityLivingBase entity, EntityLivingBase thisMobsOwner) {
        if (entity instanceof EntityWolf) {
            EntityWolf wolf = (EntityWolf) entity;
            if (wolf.isTamed() && wolf.getOwner() == thisMobsOwner) {
                return false;
            }
        }
        if (entity instanceof EntityFriendlyPigZombie) {
            EntityFriendlyPigZombie friendlyPigZombie = (EntityFriendlyPigZombie) entity;
            if (friendlyPigZombie.isTamed() && friendlyPigZombie.getOwner() == thisMobsOwner) {
                return false;
            }
        }
        return !(entity instanceof EntityPlayer && thisMobsOwner instanceof EntityPlayer && !((EntityPlayer) thisMobsOwner).canAttackPlayer((EntityPlayer) entity)) && (!(entity instanceof EntityHorse) || !((EntityHorse) entity).isTame());
    }

    @Override
    public boolean isAIDisabled() {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ZOMBIE_PIG_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound() {
        return SoundEvents.ENTITY_ZOMBIE_PIG_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_PIG_DEATH;
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand, ItemStack stack) {
        if (this.isOwner(player) && !this.worldObj.isRemote) {
            this.aiSit.setSitting(!this.isSitting());
            this.isJumping = false;
            this.getNavigator().clearPathEntity();
            this.setAttackTarget(null);
            this.sendMessageToOwner("pigman.sit");
            return true;
        }
        return false;
    }

    @Override
    public ItemStack getHeldItem(EnumHand hand) {
        return DEFAULT_HELD_ITEM;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageble) {
        return null;
    }
}
