package fossilsarcheology.server.entity;

import com.google.common.base.Predicate;
import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.ai.FishAIWaterFindTarget;
import fossilsarcheology.server.entity.prehistoric.EntityNautilus;
import fossilsarcheology.server.entity.prehistoric.PrehistoricEntityType;
import fossilsarcheology.server.item.FAItemRegistry;
import net.ilexiconn.llibrary.client.model.tools.ChainBuffer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public abstract class EntityFishBase extends EntityTameable {
    public PrehistoricEntityType selfType;
    public BlockPos currentTarget;
    @SideOnly(Side.CLIENT)
    public ChainBuffer chainBuffer;

    public EntityFishBase(World par1World, PrehistoricEntityType selfType) {
        super(par1World);
        this.tasks.addTask(1, new FishAIWaterFindTarget(this, 0));
        this.tasks.addTask(2, new EntityAILookIdle(this));
        this.selfType = selfType;
        if (FMLCommonHandler.instance().getSide().isClient()) {
            this.chainBuffer = new ChainBuffer();
        }
    }

    public boolean isAIEnabled() {
        return true;
    }

    public abstract String getTexture();@Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    private void setPedia() {
        Revival.PEDIA_OBJECT = this;
    }

    @Override
    protected Item getDropItem() {
        return Items.FISH;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    private void swimAround() {
        if (!isInsideNautilusShell()) {
            if (currentTarget != null) {
                if (!isDirectPathBetweenPoints(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)), currentTarget)) {
                    currentTarget = null;
                }
                if (!isTargetInWater() || this.getDistance(currentTarget.getX(), currentTarget.getY(), currentTarget.getZ()) < 1.78F) {
                    currentTarget = null;
                }
                swimTowardsTarget();
            }
        }
    }

    public void swimTowardsTarget() {
        if (currentTarget != null && isTargetInWater() && this.inWater) {
            double targetX = currentTarget.getX() + 0.5D - posX;
            double targetY = currentTarget.getY() + 1D - posY;
            double targetZ = currentTarget.getZ() + 0.5D - posZ;
            motionX += (Math.signum(targetX) * 0.5D - motionX) * 0.100000000372529 * getSwimSpeed(); // 0.10000000149011612D
            // /
            // 2;
            motionY += (Math.signum(targetY) * 0.5D - motionY) * 0.100000000372529 * getSwimSpeed();// 0.10000000149011612D
            // /
            // 2;
            motionZ += (Math.signum(targetZ) * 0.5D - motionZ) * 0.100000000372529 * getSwimSpeed(); // 0.10000000149011612D
            // /
            // 2;
            float angle = (float) (Math.atan2(motionZ, motionX) * 180.0D / Math.PI) - 90.0F;
            float rotation = MathHelper.wrapDegrees(angle - rotationYaw);
            moveForward = 0.5F;
            rotationYaw += rotation;
        }
    }

    protected abstract double getSwimSpeed();

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(this.height != 1F){
            this.height = 1F;
        }
        swimAround();
        Revival.PROXY.calculateChainBuffer(this);
        if (this.isInWater() && this.getClosestMate() != null && this.getGrowingAge() == 0 && this.getClosestMate().getGrowingAge() == 0 && !this.worldObj.isRemote) {
            this.setGrowingAge(12000);
            this.getClosestMate().setGrowingAge(12000);
            this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(this.selfType.eggItem)));
        }
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata){
        this.setGrowingAge(12000);
        return super.onInitialSpawn(difficulty, livingdata);
    }

    public EntityFishBase getClosestMate() {
        EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter = new EntityAINearestAttackableTarget.Sorter(this);
        List<EntityFishBase> list = worldObj.getEntitiesWithinAABB(EntityFishBase.class, this.getEntityBoundingBox().expand(2.0D, 2.0D, 2.0D), null);
        Collections.sort(list, theNearestAttackableTargetSorter);

        if (list.isEmpty()) {
            return null;
        } else {
            for (EntityFishBase entity : list) {
                if (entity != this)
                    return entity.selfType == this.selfType ? entity : null;
            }
            return null;
        }
    }

    public boolean isInsideNautilusShell() {
        return this instanceof EntityNautilus && ((EntityNautilus) this).isInShell();
    }

    public boolean isInWater(){
        return this.inWater || this.isChild() & this.isInsideOfMaterial(Material.WATER);
    }

    public void moveEntityWithHeading(float x, float z) {
        double d0;
        float f6;
        if (!worldObj.isRemote) {
            float f4;
            float f5;

            if (this.isInWater()) {
                d0 = this.posY;
                f4 = 0.8F;
                f5 = 0.02F;

                this.moveEntity(this.motionX, this.motionY, this.motionZ);
                this.motionX *= (double) f4;
                this.motionX *= 0.900000011920929D;
                this.motionY *= 0.900000011920929D;
                this.motionZ *= 0.900000011920929D;
                this.motionZ *= (double) f4;
            } else {
                float f2 = 0.91F;

                if (this.onGround && !this.isChild()) {
                    f2 = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.getEntityBoundingBox().minY) - 1, MathHelper.floor_double(this.posZ))).getBlock().slipperiness * 0.91F;
                }

                float f3 = 0.16277136F / (f2 * f2 * f2);

                if (this.onGround && !this.isChild()) {
                    f4 = this.getAIMoveSpeed() * f3;
                } else {
                    f4 = this.jumpMovementFactor;
                }

                this.moveRelative(x, z, f4);
                f2 = 0.91F;

                if (this.onGround && !this.isChild()) {
                    f2 = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.getEntityBoundingBox().minY) - 1, MathHelper.floor_double(this.posZ))).getBlock().slipperiness * 0.91F;
                }

                if (this.isOnLadder()) {
                    f5 = 0.15F;
                    this.motionX = MathHelper.clamp_double(this.motionX, (double) (-f5), (double) f5);
                    this.motionZ = MathHelper.clamp_double(this.motionZ, (double) (-f5), (double) f5);
                    this.fallDistance = 0.0F;

                    if (this.motionY < -0.15D) {
                        this.motionY = -0.15D;
                    }
                }

                this.moveEntity(this.motionX, this.motionY, this.motionZ);

                if (this.isCollidedHorizontally && this.isOnLadder()) {
                    this.motionY = 0.2D;
                }

                if (this.worldObj.isRemote && (!this.worldObj.isBlockLoaded(new BlockPos((int) this.posX, 0, (int) this.posZ))) || !this.worldObj.getChunkFromBlockCoords(new BlockPos((int) this.posX, 0, (int) this.posZ)).isLoaded()) {
                    if (this.posY > 0.0D) {
                        this.motionY = -0.1D;
                    } else {
                        this.motionY = 0.0D;
                    }
                } else {
                    this.motionY -= 0.08D;
                }

                this.motionY *= 0.9800000190734863D;
                this.motionX *= (double) f2;
                this.motionZ *= (double) f2;
            }
        }

        this.prevLimbSwingAmount = this.limbSwingAmount;
        d0 = this.posX - this.prevPosX;
        double d1 = this.posZ - this.prevPosZ;
        f6 = MathHelper.sqrt_double(d0 * d0 + d1 * d1) * 4.0F;

        if (f6 > 1.0F) {
            f6 = 1.0F;
        }

        this.limbSwingAmount += (f6 - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
    }

    protected boolean isTargetInWater() {
        return currentTarget != null && (worldObj.getBlockState(new BlockPos(currentTarget.getX(), currentTarget.getY(), currentTarget.getZ())).getMaterial() == Material.WATER && worldObj.getBlockState(new BlockPos(currentTarget.getX(), currentTarget.getY() + 1, currentTarget.getZ())).getMaterial() == Material.WATER);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack) {

        if (stack != null && FMLCommonHandler.instance().getSide().isClient() && stack.getItem() == FAItemRegistry.DINOPEDIA) {
            this.setPedia();
            player.openGui(Revival.INSTANCE, 4, this.worldObj, (int) this.posX, (int) this.posY, (int) this.posZ);
            return true;
        }
        if (this.isInsideNautilusShell()) {
            if (stack != null && stack.getItem() == Items.FLINT) {
                ((EntityNautilus) this).setInShell(false);
                ((EntityNautilus) this).ticksToShell = 60;
            } else {
                this.playSound(SoundEvents.ENTITY_ITEM_BREAK, 1, this.getRNG().nextFloat() + 0.8F);
                return false;
            }
        }
        if (stack == null && this.getGrowingAge() > 0) {
            ItemStack var3 = new ItemStack(this.selfType.fishItem, 1);

            if (player.inventory.addItemStackToInventory(var3)) {
                if (!this.worldObj.isRemote) {
                    this.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 1, this.getRNG().nextFloat() + 0.8F);
                    this.setDead();
                }

                return true;
            }
        }

        return super.processInteract(player, hand, stack);
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.checkNoEntityCollision(this.getEntityBoundingBox());
    }

    public int getTalkInterval() {
        return 120;
    }

    protected boolean canDespawn() {
        return true;
    }

    protected int getExperiencePoints(EntityPlayer player) {
        return 1 + this.worldObj.rand.nextInt(3);
    }

    public void onEntityUpdate() {
        int i = this.getAir();
        super.onEntityUpdate();
        if (!this.isInsideNautilusShell()) {
            if (this.isEntityAlive() && !this.isInWater()) {
                --i;
                this.setAir(i);

                if (this.getAir() == -20) {
                    this.setAir(0);
                    this.attackEntityFrom(DamageSource.drown, 2.0F);
                }
            } else {
                this.setAir(300);
            }
        }
    }

    public EntityAgeable createChild(EntityAgeable entity) {
        return null;
    }

    public boolean isDirectPathBetweenPoints(BlockPos pos1, BlockPos pos2) {
        Vec3d vec1 = new Vec3d(pos1);
        Vec3d vec2 = new Vec3d(pos2);
        return vec1.squareDistanceTo(vec2) > 16;
    }

    @Override
    public boolean shouldDismountInWater(Entity rider) {
        return false;
    }

}
