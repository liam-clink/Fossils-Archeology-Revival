package fossilsarcheology.server.entity;

import fossilsarcheology.server.enums.PrehistoricEntityType;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class EntityPrehistoricFlying extends EntityPrehistoric {

    public ChunkCoordinates currentTarget;
    public static final int FLYING_INDEX = 29;
    private boolean isFlying;
    public float flyProgress;
    private int ticksFlying;

    public EntityPrehistoricFlying(World world, PrehistoricEntityType type, double baseDamage, double maxDamage, double baseHealth, double maxHealth, double baseSpeed, double maxSpeed) {
        super(world, type, baseDamage, maxDamage, baseHealth, maxHealth, baseSpeed, maxSpeed);
    }

    public boolean isDirectPathBetweenPoints(Vec3d vec1, Vec3d vec2) {
        RayTraceResult result = this.worldObj.rayTraceBlocks(vec1, new Vec3d(vec2.xCoord, vec2.yCoord + (double) this.height * 0.5D, vec2.zCoord), false);
        return result == null || result.typeOfHit != RayTraceResult.Type.BLOCK;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(FLYING_INDEX, (byte) 0);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("Flying", this.isFlying);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setFlying(compound.getBoolean("Flying"));

    }

    public boolean isFlying() {
        if (worldObj.isRemote) {
            boolean isFlying = (this.dataManager.getWatchableObjectByte(FLYING_INDEX) & 1) != 0;
            this.isFlying = isFlying;
            return isFlying;
        }

        return isFlying;
    }

    @Override
    public void jump() {
        super.jump();
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        boolean flying = isFlying();
        if (!this.onGround && this.motionY < 0.0D) {
            this.motionY *= 0.6D;
        }
        if (flying && flyProgress < 20.0F) {
            flyProgress += 0.5F;
            if (sitProgress != 0)
                sitProgress = sleepProgress = 0F;
        } else if (!flying && flyProgress > 0.0F) {
            flyProgress -= 0.5F;
            if (sitProgress != 0)
                sitProgress = sleepProgress = 0F;
        }
        if (!this.isFlying() && !this.isMovementBlocked() && rand.nextInt(400) == 0 && !this.worldObj.isRemote && this.isAdult() && this.riddenByEntity == null && this.onGround) {
            this.setFlying(true);
        }
        if (ticksFlying > 80 && this.onGround) {
            this.setFlying(false);
        }
        if (!this.isFlying() && this.currentTarget != null && !this.onGround) {
            this.setFlying(true);
        }
        if (this.isFlying() && getEntityToAttack() == null) {
            flyAround();
            ticksFlying++;
        } else if (getEntityToAttack() != null) {
            flyTowardsTarget();
        }
    }

    public boolean canSleep() {
        if (super.canSleep() && this.isFlying() && this.onGround) {
            this.setFlying(false);
            return super.canSleep();
        }
        return super.canSleep();
    }

    public void setFlying(boolean flying) {
        byte b0 = this.dataManager.getWatchableObjectByte(FLYING_INDEX);

        if (flying) {
            this.dataManager.updateObject(FLYING_INDEX, (byte) (b0 | 1));
        } else {
            this.dataManager.updateObject(FLYING_INDEX, (byte) (b0 & -2));
        }

        if (!worldObj.isRemote) {
            this.isFlying = flying;
        }
    }

    public Vec3d getPosition() {
        return new Vec3d(this.posX, this.posY, this.posZ);
    }

    public void flyAround() {
        if (currentTarget != null) {
            if (!isDirectPathBetweenPoints(this.getPosition(), new Vec3d(currentTarget.posX, currentTarget.posY, currentTarget.posZ))) {
                currentTarget = null;
            }
            if (!isTargetInAir() || this.getDistance(currentTarget.posX, currentTarget.posY, currentTarget.posZ) < 3F || ticksFlying > 6000) {
                currentTarget = null;
            }
            flyTowardsTarget();
        }
    }

    public void flyTowardsTarget() {
        if (currentTarget != null && isTargetInAir() && this.isFlying() && this.getDistanceSquared(new Vec3d(currentTarget.posX, this.posY, currentTarget.posZ)) > 3) {
            double targetX = currentTarget.posX + 0.5D - posX;
            double targetY = currentTarget.posY + 1D - posY;
            double targetZ = currentTarget.posZ + 0.5D - posZ;
            motionX += (Math.signum(targetX) * 0.5D - motionX) * 0.100000000372529 * getFlySpeed();
            motionY += (Math.signum(targetY) * 0.5D - motionY) * 0.100000000372529 * getFlySpeed();
            motionZ += (Math.signum(targetZ) * 0.5D - motionZ) * 0.100000000372529 * getFlySpeed();
            float angle = (float) (Math.atan2(motionZ, motionX) * 180.0D / Math.PI) - 90.0F;
            float rotation = MathHelper.wrapAngleTo180_float(angle - rotationYaw);
            moveForward = 0.5F;
            rotationYaw += rotation;
        } else {
            this.currentTarget = null;
        }
    }

    protected boolean isTargetInAir() {
        return currentTarget != null && (worldObj.getBlock(currentTarget.posX, currentTarget.posY, currentTarget.posZ).getMaterial() == Material.air && worldObj.getBlock(currentTarget.posX, currentTarget.posY + 1, currentTarget.posZ).getMaterial() == Material.air);
    }

    public float getDistanceSquared(Vec3d vec) {
        float f = (float) (this.posX - vec.xCoord);
        float f1 = (float) (this.posY - vec.yCoord);
        float f2 = (float) (this.posZ - vec.zCoord);
        return f * f + f1 * f1 + f2 * f2;
    }

    public boolean isDirectPathBetweenPoints(ChunkCoordinates vec1, ChunkCoordinates vec2) {
        return vec1.getDistanceSquaredToChunkCoordinates(vec2) > 20;
    }

    protected abstract double getFlySpeed();
}