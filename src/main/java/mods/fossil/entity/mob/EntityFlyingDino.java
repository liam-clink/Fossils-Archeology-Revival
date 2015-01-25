package mods.fossil.entity.mob;

import io.netty.buffer.ByteBuf;
import mods.fossil.fossilEnums.EnumDinoType;
import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.util.Vec3;

;

public class EntityFlyingDino extends EntityDinosaur {

	public EntityFlyingDino(World world, EnumDinoType dinoType) {
		super(world, dinoType);
		this.getNavigator().setCanSwim(true);
	}

	/**
	 * Takes in the distance the entity has fallen this tick and whether its on
	 * the ground to update the fall distance and deal fall damage if landing on
	 * the ground. Args: distanceFallenThisTick, onGround
	 */
	protected void updateFallState(double par1, boolean par3) {
		// Intentionally left blank.
	}

	public static boolean isFlying;
	public ChunkCoordinates currentDragonTarget;

	@Override
	protected void fall(float par1) {
	}

	public void setFlying(boolean state) {
		isFlying = state;

	}

	public void onLivingUpdate() {
		if (motionY < 0.0D) {
			motionY *= 0.6D;
		}
		if (this.riddenByEntity == null) {
			if (!this.isSitting()) {
				if (!worldObj.isRemote) {
					if (getEntityToAttack() == null) {
						if (rand.nextInt(400) == 0)
							if (!isFlying)
								setFlying(true);
							else
								setFlying(false);

						if (isFlying)
							flyAround();
						else {
							// Does nothing on ground but normal stuff!
						}

						if (getEntityToAttack() != null) {
							currentDragonTarget = new ChunkCoordinates(
									(int) getEntityToAttack().posX,
									(int) ((int) getEntityToAttack().posY + getEntityToAttack()
											.getEyeHeight()),
									(int) getEntityToAttack().posZ);
							setFlying(false);
							flyTowardsTarget();
						}
					}
				}
			}
		}

		super.onLivingUpdate();

	}

	public void flyTowardsTarget() {
		if (currentDragonTarget != null) {
			double targetX = currentDragonTarget.posX + 0.5D - posX;
			double targetY = currentDragonTarget.posY + 1D - posY;
			double targetZ = currentDragonTarget.posZ + 0.5D - posZ;
			motionX += (Math.signum(targetX) * 0.5D - motionX) * 0.10000000149011612D;
			motionY += (Math.signum(targetY) * 0.699999988079071D - motionY) * 0.10000000149011612D;
			motionZ += (Math.signum(targetZ) * 0.5D - motionZ) * 0.10000000149011612D;
			float angle = (float) (Math.atan2(motionZ, motionX) * 180.0D / Math.PI) - 90.0F;
			float rotation = MathHelper.wrapAngleTo180_float(angle
					- rotationYaw);
			moveForward = 0.5F;
			rotationYaw += rotation;
		}

	}

	public void flyAround() {
		if (currentDragonTarget != null)
			if (!worldObj.isAirBlock(currentDragonTarget.posX,
					currentDragonTarget.posY, currentDragonTarget.posZ)
					|| currentDragonTarget.posY < 1)
				currentDragonTarget = null;

		if (currentDragonTarget == null
				|| rand.nextInt(30) == 0
				|| currentDragonTarget.getDistanceSquared((int) posX,
						(int) posY, (int) posZ) < 10F)
			currentDragonTarget = new ChunkCoordinates((int) posX
					+ rand.nextInt(90) - rand.nextInt(60), (int) posY
					+ rand.nextInt(60) - 2, (int) posZ + rand.nextInt(90)
					- rand.nextInt(60));

		flyTowardsTarget();
	}

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readSpawnData(ByteBuf additionalData) {
		// TODO Auto-generated method stub
		
	}
}