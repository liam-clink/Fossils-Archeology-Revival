package fossilsarcheology.server.entity;

import fossilsarcheology.server.enums.EnumPrehistoric;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class EntityPrehistoricFlying extends EntityPrehistoric {

	public ChunkCoordinates currentTarget;
	public static final int FLYING_INDEX = 29;
	private boolean isFlying;
	public float flyProgress;
	private int ticksFlying;

	public EntityPrehistoricFlying(World world, EnumPrehistoric type, double baseDamage, double maxDamage, double baseHealth, double maxHealth, double baseSpeed, double maxSpeed) {
		super(world, type, baseDamage, maxDamage, baseHealth, maxHealth, baseSpeed, maxSpeed);
	}

	public boolean isDirectPathBetweenPoints(Vec3 vec1, Vec3 vec2) {
		MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec1, Vec3.createVectorHelper(vec2.xCoord, vec2.yCoord + (double) this.height * 0.5D, vec2.zCoord), false);
		return movingobjectposition == null || movingobjectposition.typeOfHit != MovingObjectPosition.MovingObjectType.BLOCK;
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(FLYING_INDEX, (byte) 0);
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
			boolean isFlying = (this.dataWatcher.getWatchableObjectByte(FLYING_INDEX) & 1) != 0;
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
		if (this.isFlying() && getEntityToAttack() == null) {
			flyAround();
			ticksFlying++;
		} else if (getEntityToAttack() != null) {
			flyTowardsTarget();
		}
	}

	public void setFlying(boolean flying) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(FLYING_INDEX);

		if (flying) {
			this.dataWatcher.updateObject(FLYING_INDEX, (byte) (b0 | 1));
		} else {
			this.dataWatcher.updateObject(FLYING_INDEX, (byte) (b0 & -2));
		}

		if (!worldObj.isRemote) {
			this.isFlying = flying;
		}
	}

	public Vec3 getPosition() {
		return Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
	}

	public void flyAround() {
		if (currentTarget != null) {
			if (!isDirectPathBetweenPoints(this.getPosition(), Vec3.createVectorHelper(currentTarget.posX, currentTarget.posY, currentTarget.posZ))) {
				currentTarget = null;
			}
			if (!isTargetInAir() || this.getDistance(currentTarget.posX, currentTarget.posY, currentTarget.posZ) < 3F || ticksFlying > 6000) {
				currentTarget = null;
			}
			flyTowardsTarget();
		}
	}

	public void flyTowardsTarget() {
		if (currentTarget != null && isTargetInAir() && this.isFlying() && this.getDistanceSquared(Vec3.createVectorHelper(currentTarget.posX, this.posY, currentTarget.posZ)) > 3) {
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

	public float getDistanceSquared(Vec3 vec) {
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