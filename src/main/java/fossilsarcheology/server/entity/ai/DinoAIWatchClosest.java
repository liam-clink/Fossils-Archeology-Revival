package fossilsarcheology.server.entity.ai;


import fossilsarcheology.server.entity.prehistoric.EntityPrehistoric;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class DinoAIWatchClosest extends EntityAIBase {
	protected Entity closestEntity;
	private final EntityPrehistoric prehsitoric;
	private final float maxDistanceForPlayer;
	private int lookTime;
	private final float chance;
	private final Class watchedClass;

	public DinoAIWatchClosest(EntityPrehistoric prehsitoric, Class watchedClass, float distance) {
		this.prehsitoric = prehsitoric;
		this.watchedClass = watchedClass;
		this.maxDistanceForPlayer = distance;
		this.chance = 0.02F;
		this.setMutexBits(2);
	}

	public DinoAIWatchClosest(EntityPrehistoric prehsitoric, Class watchedClass, float distance, float chance) {
		this.prehsitoric = prehsitoric;
		this.watchedClass = watchedClass;
		this.maxDistanceForPlayer = distance;
		this.chance = chance;
		this.setMutexBits(2);
	}

	@Override
    public boolean shouldExecute() {
		if (this.prehsitoric.isSleeping()) {
			return false;
		}

		if (this.prehsitoric.getRNG().nextFloat() >= this.chance) {
			return false;
		} else {
			if (this.prehsitoric.getAttackTarget() != null) {
				this.closestEntity = this.prehsitoric.getAttackTarget();
			}

			if (this.watchedClass == EntityPlayer.class) {
				this.closestEntity = this.prehsitoric.world.getClosestPlayerToEntity(this.prehsitoric, (double) this.maxDistanceForPlayer);
			} else {
				this.closestEntity = this.prehsitoric.world.findNearestEntityWithinAABB(this.watchedClass, this.prehsitoric.getEntityBoundingBox().expand((double) this.maxDistanceForPlayer, 3.0D, (double) this.maxDistanceForPlayer), this.prehsitoric);
			}

			return this.closestEntity != null;
		}
	}

	@Override
    public boolean shouldContinueExecuting() {
		return this.closestEntity.isEntityAlive() && (!(this.prehsitoric.getDistanceSq(this.closestEntity) > (double) (this.maxDistanceForPlayer * this.maxDistanceForPlayer)) && this.lookTime > 0);
	}

	@Override
    public void startExecuting() {
		this.lookTime = 40 + this.prehsitoric.getRNG().nextInt(40);
	}

	@Override
    public void resetTask() {
		this.closestEntity = null;
	}

	@Override
    public void updateTask() {
		this.prehsitoric.getLookHelper().setLookPosition(this.closestEntity.posX, this.closestEntity.posY + (double) this.closestEntity.getEyeHeight(), this.closestEntity.posZ, 10.0F, (float) this.prehsitoric.getVerticalFaceSpeed());
		--this.lookTime;
	}
}
