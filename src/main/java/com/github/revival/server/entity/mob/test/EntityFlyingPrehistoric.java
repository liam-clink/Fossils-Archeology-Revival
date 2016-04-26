package com.github.revival.server.entity.mob.test;

import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.github.revival.server.enums.EnumPrehistoric;

public abstract class EntityFlyingPrehistoric extends EntityNewPrehistoric{

	public Vec3 currentTarget;
	public static final int FLYING_INDEX = 29;
	private boolean isFlying;
	public float flyProgress;

	public EntityFlyingPrehistoric(World world, EnumPrehistoric selfType) {
		super(world, selfType);
	}

	public boolean isDirectPathBetweenPoints(Vec3 vec1, Vec3 vec2)
	{
		MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec1, Vec3.createVectorHelper(vec2.xCoord, vec2.yCoord + (double)this.height * 0.5D, vec2.zCoord), false);
		return movingobjectposition == null || movingobjectposition.typeOfHit != MovingObjectPosition.MovingObjectType.BLOCK;
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(FLYING_INDEX, Byte.valueOf((byte) 0));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("Flying", this.isFlying);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
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
	public void onLivingUpdate(){
		super.onLivingUpdate();
		this.motionY *= 0.6;
		boolean flying = isFlying();
		if (flying && flyProgress < 20.0F) {
			flyProgress += 0.5F;
			if(sitProgress != 0)sitProgress = sleepProgress = 0F;
		} else if (!flying && flyProgress > 0.0F) {
			flyProgress -= 0.5F;
			if(sitProgress != 0)sitProgress = sleepProgress = 0F;
		}
		if(!this.isMovementBlocked() && rand.nextInt(400) == 0 && !this.worldObj.isRemote && this.isAdult() && this.riddenByEntity == null && this.onGround){
			this.setFlying(true);
		}
		if (this.isFlying()) {
			flyAround();
		}
		if (getEntityToAttack() != null) {
			currentTarget = Vec3.createVectorHelper(getEntityToAttack().posX, getEntityToAttack().posY + getEntityToAttack().height, getEntityToAttack().posZ);
			flyTowardsTarget();
		}
	}

	public void setFlying(boolean flying) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(FLYING_INDEX);

		if (flying) {
			this.dataWatcher.updateObject(FLYING_INDEX, Byte.valueOf((byte) (b0 | 1)));
		} else {
			this.dataWatcher.updateObject(FLYING_INDEX, Byte.valueOf((byte) (b0 & -2)));
		}

		if (!worldObj.isRemote) {
			this.isFlying = flying;
		}
	}

	public void flyAround() {
		if (currentTarget != null) {
			if (!worldObj.isAirBlock((int)currentTarget.xCoord, (int)currentTarget.yCoord, (int)currentTarget.zCoord) || getDistanceSquared(currentTarget) > 1 || currentTarget.yCoord < 1 || !isDirectPathBetweenPoints(Vec3.createVectorHelper(this.posX, this.posY, this.posZ), Vec3.createVectorHelper(currentTarget.xCoord, currentTarget.yCoord, currentTarget.zCoord))) {
				currentTarget = null;
			}
		}

		if (currentTarget == null || rand.nextInt(140) == 0) {
			resetTarget(90, 90);
		}
		flyTowardsTarget();
	}

	protected void resetTarget(int xz, int y){
		currentTarget = Vec3.createVectorHelper(this.posX + this.rand.nextInt(2 * xz) - xz, this.posY + this.rand.nextInt(2 * y), this.posZ + this.rand.nextInt(2 * xz) - xz);
	}

	public void flyTowardsTarget()
	{
		if (currentTarget != null) {
			double targetX = currentTarget.xCoord + 0.5D - posX;
			double targetY = currentTarget.yCoord + 1D - posY;
			double targetZ = currentTarget.zCoord + 0.5D - posZ;
			motionX += (Math.signum(targetX) * 0.5D - motionX) * 0.10000000149011612D * this.getFlySpeed();
			motionY += (Math.signum(targetY) * 0.699999988079071D - motionY) * 0.10000000149011612D;
			motionZ += (Math.signum(targetZ) * 0.5D - motionZ) * 0.10000000149011612D * this.getFlySpeed();
			float angle = (float) (Math.atan2(motionZ, motionX) * 180.0D / Math.PI) - 90.0F;
			float rotation = MathHelper.wrapAngleTo180_float(angle
					- rotationYaw);
			moveForward = 0.5F;
			rotationYaw += rotation;
		}
	}

	public float getDistanceSquared(Vec3 vec)
	{
		float f = (float)(this.posX - vec.xCoord);
		float f1 = (float)(this.posY - vec.yCoord);
		float f2 = (float)(this.posZ - vec.zCoord);
		return f * f + f1 * f1 + f2 * f2;
	}

	public boolean isDirectPathBetweenPoints(ChunkCoordinates vec1, ChunkCoordinates vec2)
	{
		return vec1.getDistanceSquaredToChunkCoordinates(vec2) > 16;
	}

	protected abstract double getFlySpeed();
}