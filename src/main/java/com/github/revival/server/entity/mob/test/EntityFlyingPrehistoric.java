package com.github.revival.server.entity.mob.test;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.github.revival.server.enums.EnumOrderType;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.Activity;
import com.github.revival.server.enums.EnumPrehistoricAI.Attacking;
import com.github.revival.server.enums.EnumPrehistoricAI.Climbing;
import com.github.revival.server.enums.EnumPrehistoricAI.Following;
import com.github.revival.server.enums.EnumPrehistoricAI.Jumping;
import com.github.revival.server.enums.EnumPrehistoricAI.Moving;
import com.github.revival.server.enums.EnumPrehistoricAI.Response;
import com.github.revival.server.enums.EnumPrehistoricAI.Stalking;
import com.github.revival.server.enums.EnumPrehistoricAI.Taming;
import com.github.revival.server.enums.EnumPrehistoricAI.Untaming;
import com.github.revival.server.enums.EnumPrehistoricAI.WaterAbility;

public abstract class EntityFlyingPrehistoric extends EntityNewPrehistoric{

	public ChunkCoordinates currentTarget;
	public static final int FLYING_INDEX = 29;
	private boolean isFlying;
	public float flyProgress;

	public EntityFlyingPrehistoric(World world, EnumPrehistoric selfType) {
		super(world, selfType);
		this.tasks.addTask(11, new DinoAIFindAirTarget(this));
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(SLEEPING_INDEX, Byte.valueOf((byte) 0));
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
		boolean flying = isSleeping();
		if (flying && flyProgress < 20.0F) {
			flyProgress += 0.5F;
			if(sitProgress != 0)sitProgress = sleepProgress = 0F;
		} else if (!flying && flyProgress > 0.0F) {
			flyProgress -= 0.5F;
			if(sitProgress != 0)sitProgress = sleepProgress = 0F;
		}
		if(this.onGround && this.getRNG().nextInt(50) == 0 && !this.isMovementCeased() || this.getAttackTarget() != null && !this.isMovementCeased()){
			this.flyAround();
		}
		if(this.onGround && this.isFlying()){
			this.setFlying(false);
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
		this.setFlying(true);
		if (currentTarget != null){
			if(!isDirectPathBetweenPoints(new ChunkCoordinates(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)), currentTarget)){
				currentTarget = null;
			}
			if (!isTargetReachable() || this.getDistance(currentTarget.posX, currentTarget.posY, currentTarget.posZ) < 2.78F){
				currentTarget = null;
			}
			flyTowardsTarget();
		}
	}

	public void flyTowardsTarget()
	{
		if (currentTarget != null && isTargetReachable() && this.inWater)
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

	private boolean isTargetReachable(){
		return currentTarget == null ? false : worldObj.getBlock(currentTarget.posX, currentTarget.posY, currentTarget.posZ).getMaterial() == Material.air ? true : worldObj.getBlock(currentTarget.posX, currentTarget.posY + 3, currentTarget.posZ).getMaterial() == Material.air;
	}

	public boolean isDirectPathBetweenPoints(ChunkCoordinates vec1, ChunkCoordinates vec2)
	{
		return vec1.getDistanceSquaredToChunkCoordinates(vec2) > 16;
	}
	
	protected abstract double getFlySpeed();
}