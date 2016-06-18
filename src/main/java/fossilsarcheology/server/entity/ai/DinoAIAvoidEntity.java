package fossilsarcheology.server.entity.ai;

import java.util.List;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;

import fossilsarcheology.server.entity.mob.test.EntityNewPrehistoric;

public class DinoAIAvoidEntity extends EntityAIBase {
	public final IEntitySelector field_98218_a = new IEntitySelector() {
		public boolean isEntityApplicable(Entity entity) {
			return entity.isEntityAlive() && DinoAIAvoidEntity.this.prehistoric.getEntitySenses().canSee(entity);
		}
	};
	private EntityNewPrehistoric prehistoric;
	private double farSpeed;
	private double nearSpeed;
	private Entity closestLivingEntity;
	private float distanceFromEntity;
	private PathEntity entityPathEntity;
	private PathNavigate entityPathNavigate;

	public DinoAIAvoidEntity(EntityNewPrehistoric prehistoric, float distance, double farSpeed, double nearSpeed) {
		this.prehistoric = prehistoric;
		this.distanceFromEntity = distance;
		this.farSpeed = farSpeed;
		this.nearSpeed = nearSpeed;
		this.entityPathNavigate = prehistoric.getNavigator();
		this.setMutexBits(1);
	}

	public boolean shouldExecute() {
		

		List list = this.prehistoric.worldObj.selectEntitiesWithinAABB(EntityLivingBase.class, this.prehistoric.boundingBox.expand((double) this.distanceFromEntity, 3.0D, (double) this.distanceFromEntity), this.field_98218_a);

		if (list.isEmpty()) {
			return false;
		}

		this.closestLivingEntity = (Entity) list.get(0);
		if(this.prehistoric.canDinoHunt(closestLivingEntity, false)){
			return false;
		}
		if (this.prehistoric.isTamed() && closestLivingEntity instanceof EntityPlayer) {
			return false;
		}
		Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockAwayFrom(this.prehistoric, 16, 7, Vec3.createVectorHelper(this.closestLivingEntity.posX, this.closestLivingEntity.posY, this.closestLivingEntity.posZ));

		if (vec3 == null) {
			return false;
		} else if (this.closestLivingEntity.getDistanceSq(vec3.xCoord, vec3.yCoord, vec3.zCoord) < this.closestLivingEntity.getDistanceSqToEntity(this.prehistoric)) {
			return false;
		} else {
			this.entityPathEntity = this.entityPathNavigate.getPathToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord);
			return this.entityPathEntity == null ? false : this.entityPathEntity.isDestinationSame(vec3);
		}
	}

	public boolean continueExecuting() {
		return !this.entityPathNavigate.noPath();
	}

	public void startExecuting() {
		this.entityPathNavigate.setPath(this.entityPathEntity, this.farSpeed);
	}

	public void resetTask() {
		this.closestLivingEntity = null;
	}

	public void updateTask() {
		if (this.prehistoric.getDistanceSqToEntity(this.closestLivingEntity) < 49.0D) {
			this.prehistoric.getNavigator().setSpeed(this.nearSpeed);
		} else {
			this.prehistoric.getNavigator().setSpeed(this.farSpeed);
		}
	}
}