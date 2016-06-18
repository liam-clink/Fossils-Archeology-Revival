package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.mob.test.EntityNewPrehistoric;
import fossilsarcheology.server.entity.mob.test.EntityToyBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class DinoAIAttackOnCollide extends EntityAIBase {
	private final EntityNewPrehistoric dino;
	private World worldObj;
	private int attackTick;
	private double speed;
	private boolean field_75437_f;
	private PathEntity entityPathEntity;
	private Class classTarget;
	private int field_75445_i;

	public DinoAIAttackOnCollide(EntityNewPrehistoric entityNewPrehistoric, double speed, boolean par4) {
		this.dino = entityNewPrehistoric;
		this.worldObj = entityNewPrehistoric.worldObj;
		this.speed = speed;
		this.field_75437_f = par4;
		this.setMutexBits(3);
	}

	@Override
	public boolean shouldExecute() {
		EntityLivingBase entitylivingbase = this.dino.getAttackTarget();

		if (entitylivingbase == null) {
			return false;
		} else if (!entitylivingbase.isEntityAlive()) {
			return false;
		} else if (this.dino.isMovementBlocked()) {
			return false;
		} else if (this.classTarget != null && !this.classTarget.isAssignableFrom(entitylivingbase.getClass())) {
			return false;
		} else {
			this.entityPathEntity = this.dino.getNavigator().getPathToEntityLiving(entitylivingbase);
			return this.entityPathEntity != null;
		}
	}

	@Override
	public boolean continueExecuting() {
		EntityLivingBase entitylivingbase = this.dino.getAttackTarget();
		return entitylivingbase != null && (entitylivingbase.isEntityAlive() && (!this.field_75437_f ? !this.dino.getNavigator().noPath() : this.dino.isWithinHomeDistance(MathHelper.floor_double(entitylivingbase.posX), MathHelper.floor_double(entitylivingbase.posY), MathHelper.floor_double(entitylivingbase.posZ))));
	}

	@Override
	public void startExecuting() {
		if(this.dino.riddenByEntity == null){
			this.dino.getNavigator().setPath(this.entityPathEntity, speed);
		}
		this.field_75445_i = 0;
	}

	@Override
	public void resetTask() {
		this.dino.getNavigator().clearPathEntity();
	}

	@Override
	public void updateTask() {
		EntityLivingBase entitylivingbase = this.dino.getAttackTarget();
		if (entitylivingbase instanceof EntityToyBase && dino.ticksTillPlay > 0) {
			dino.setAttackTarget(null);
			return;
		}
		this.dino.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
		if ((this.field_75437_f || this.dino.getEntitySenses().canSee(entitylivingbase)) && --this.field_75445_i <= 0) {
			this.field_75445_i = 4 + this.dino.getRNG().nextInt(7);

		}
		if(this.dino.riddenByEntity == null){
			this.dino.getNavigator().tryMoveToEntityLiving(entitylivingbase, speed);
		}
		this.attackTick = Math.max(this.attackTick - 1, 0);
		double d0 = (double) (this.dino.width * 8.0F * this.dino.width * 8.0F + entitylivingbase.width);

		if (this.dino.getDistanceSq(entitylivingbase.posX, entitylivingbase.boundingBox.minY, entitylivingbase.posZ) <= d0) {
			if (this.attackTick <= 0) {
				this.attackTick = 20;

				if (this.dino.getHeldItem() != null) {
					this.dino.swingItem();
				}
				this.dino.attackEntityAsMob(entitylivingbase);
			}
		}
	}
}
