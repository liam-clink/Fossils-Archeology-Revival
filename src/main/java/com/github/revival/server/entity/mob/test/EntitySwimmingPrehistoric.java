package com.github.revival.server.entity.mob.test;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.github.revival.server.enums.EnumPrehistoric;

public abstract class EntitySwimmingPrehistoric extends EntityNewPrehistoric {

	public boolean movesOnLand;
	public ChunkCoordinates currentTarget;
	protected boolean isAmphibious;
	public static Animation FISH_ANIMATION;

	public EntitySwimmingPrehistoric(World world, EnumPrehistoric type, double baseDamage, double maxDamage, double baseHealth, double maxHealth, double baseSpeed, double maxSpeed) {
		super(world, type, baseDamage, maxDamage, baseHealth, maxHealth, baseSpeed, maxSpeed);
		this.getNavigator().setAvoidsWater(false);
		this.hasBabyTexture = false;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}

	public boolean isDirectPathBetweenPoints(Vec3 vec1, Vec3 vec2) {
		MovingObjectPosition movingobjectposition = this.worldObj.func_147447_a(vec1, Vec3.createVectorHelper(vec2.xCoord, vec2.yCoord + (double) this.height * 0.5D, vec2.zCoord), false, true, false);
		return movingobjectposition == null || movingobjectposition.typeOfHit != MovingObjectPosition.MovingObjectType.BLOCK;
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	public boolean isOnLadder() {
		return false;
	}

	public void onLivingUpdate() {
		super.onLivingUpdate();
		swimAround();
	}

	private void swimAround() {
		if (currentTarget != null) {
			if (!isDirectPathBetweenPoints(this.getPosition(), Vec3.createVectorHelper(currentTarget.posX, currentTarget.posY, currentTarget.posZ))) {
				currentTarget = null;
			}
			if (!isTargetInWater() || this.getDistance(currentTarget.posX, currentTarget.posY, currentTarget.posZ) < 1.78F) {
				currentTarget = null;
			}
			swimTowardsTarget();
		}
	}

	public void swimTowardsTarget() {
		if (currentTarget != null && isTargetInWater() && this.inWater) {
			double targetX = currentTarget.posX + 0.5D - posX;
			double targetY = currentTarget.posY + 1D - posY;
			double targetZ = currentTarget.posZ + 0.5D - posZ;
			motionX += (Math.signum(targetX) * 0.5D - motionX) * 0.100000000372529 * getSwimSpeed() * (this.isAdult() ? 1 : 0.5F);
			motionY += (Math.signum(targetY) * 0.5D - motionY) * 0.100000000372529 * getSwimSpeed();
			motionZ += (Math.signum(targetZ) * 0.5D - motionZ) * 0.100000000372529 * getSwimSpeed() * (this.isAdult() ? 1 : 0.5F);
			float angle = (float) (Math.atan2(motionZ, motionX) * 180.0D / Math.PI) - 90.0F;
			float rotation = MathHelper.wrapAngleTo180_float(angle - rotationYaw);
			moveForward = 0.5F;
			rotationYaw += rotation;
		}
	}

	protected abstract double getSwimSpeed();

	protected boolean isTargetInWater() {
		return currentTarget != null && (worldObj.getBlock(currentTarget.posX, currentTarget.posY, currentTarget.posZ).getMaterial() == Material.water && worldObj.getBlock(currentTarget.posX, currentTarget.posY + 1, currentTarget.posZ).getMaterial() == Material.water);
	}

	public void moveEntityWithHeading(float x, float z) {
			if(this.isAmphibious){
				if(this.isInWater()){
					moveEntityWithHeadingWater(x, z);
				}else{
					super.moveEntityWithHeading(x, z);
				}
			}else{
				moveEntityWithHeadingWater(x, z);
			}
	}

	public void moveEntityWithHeadingWater(float x, float z) {
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

				if (this.onGround) {
					f2 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ)).slipperiness * 0.91F;
				}

				float f3 = 0.16277136F / (f2 * f2 * f2);

				if (this.onGround) {
					f4 = this.getAIMoveSpeed() * f3;
				} else {
					f4 = this.jumpMovementFactor;
				}

				this.moveFlying(x, z, f4);
				f2 = 0.91F;

				if (this.onGround) {
					f2 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ)).slipperiness * 0.91F;
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

				if (this.worldObj.isRemote && (!this.worldObj.blockExists((int) this.posX, 0, (int) this.posZ)) || !this.worldObj.getChunkFromBlockCoords((int) this.posX, (int) this.posZ).isChunkLoaded) {
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

	
	public Vec3 getPosition() {
		return Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
	}
}
