package com.github.revival.server.entity.mob.test;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.github.revival.server.enums.EnumPrehistoric;

public abstract class EntityFlyingPrehistoric extends EntityNewPrehistoric{

	public ChunkCoordinates currentTarget;
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
		this.flyAround();
		if(!this.isMovementBlocked() && rand.nextInt(400) == 0 && !this.worldObj.isRemote && this.isAdult() && this.riddenByEntity == null){
			this.setFlying(!this.isFlying());
		}
		if (this.isFlying()) {
			flyAround();
		}
		if(currentTarget == null && this.isFlying()){
			this.setFlying(false);
		}
		if (getEntityToAttack() != null) {
			currentTarget = new ChunkCoordinates((int) getEntityToAttack().posX, (int) ((int) getEntityToAttack().posY + getEntityToAttack().getEyeHeight()), (int) getEntityToAttack().posZ);
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
			if (!worldObj.isAirBlock(currentTarget.posX, currentTarget.posY, currentTarget.posZ) || currentTarget.posY == 0 || !isDirectPathBetweenPoints(Vec3.createVectorHelper(this.posX, this.posY, this.posZ), Vec3.createVectorHelper(currentTarget.posX, currentTarget.posY, currentTarget.posZ))) {
				currentTarget = null;
			}
		}

		if (currentTarget == null || rand.nextInt(30) == 0 || currentTarget.getDistanceSquared((int) posX, (int) posY, (int) posZ) < 10F) {
			currentTarget = new ChunkCoordinates((int) posX + rand.nextInt(120) - rand.nextInt(60), (int) posY + rand.nextInt(60) - 15, (int) posZ + rand.nextInt(120) - rand.nextInt(60));
		}
		flyTowardsTarget();
	}


	public void flyTowardsTarget()
	{
		if (currentTarget != null)
		{
			double targetX = currentTarget.posX + 0.5D - posX;
			double targetY = currentTarget.posY + 1D - posY;
			double targetZ = currentTarget.posZ + 0.5D - posZ;
			motionX += (Math.signum(targetX) * 0.5D - motionX) *  0.100000000372529 * getFlySpeed(); //0.10000000149011612D / 2;
			motionY += (Math.signum(targetY) * 0.5D - motionY) *  0.100000000372529 * getFlySpeed();//0.10000000149011612D / 2;
			motionZ += (Math.signum(targetZ) * 0.5D - motionZ) *  0.100000000372529 * getFlySpeed(); //0.10000000149011612D / 2;
			float angle = (float) (Math.atan2(motionZ, motionX) * 180.0D / Math.PI) - 90.0F;
			float rotation = MathHelper.wrapAngleTo180_float(angle - rotationYaw);
			moveForward = 0.5F;
			rotationYaw += rotation;
		}
	}

	public boolean isDirectPathBetweenPoints(ChunkCoordinates vec1, ChunkCoordinates vec2)
	{
		return vec1.getDistanceSquaredToChunkCoordinates(vec2) > 16;
	}
	
	protected abstract double getFlySpeed();
}