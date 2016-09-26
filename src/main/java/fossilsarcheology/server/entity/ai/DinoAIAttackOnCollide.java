package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.EntityToyBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class DinoAIAttackOnCollide extends EntityAIBase {
    private final EntityPrehistoric entity;
    private int attackTick;
    private double speed;
    private boolean home;
    private Path entityPathEntity;

    public DinoAIAttackOnCollide(EntityPrehistoric entity, double speed, boolean home) {
        this.entity = entity;
        this.speed = speed;
        this.home = home;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute() {
        EntityLivingBase target = this.entity.getAttackTarget();
        if (target == null) {
            return false;
        } else if (!target.isEntityAlive()) {
            return false;
        } else if (this.entity.isMovementBlocked()) {
            return false;
        } else {
            this.entityPathEntity = this.entity.getNavigator().getPathToEntityLiving(target);
            return this.entityPathEntity != null;
        }
    }

    @Override
    public boolean continueExecuting() {
        EntityLivingBase target = this.entity.getAttackTarget();
        return target != null && (target.isEntityAlive() && (!this.home ? !this.entity.getNavigator().noPath() : this.entity.isWithinHomeDistanceFromPosition(new BlockPos(target))));
    }

    @Override
    public void startExecuting() {
        if (this.entity.getPassengers().isEmpty()) {
            this.entity.getNavigator().setPath(this.entityPathEntity, this.speed);
        }
    }

    @Override
    public void resetTask() {
        this.entity.getNavigator().clearPathEntity();
    }

    @Override
    public void updateTask() {
        EntityLivingBase target = this.entity.getAttackTarget();
        if (target instanceof EntityToyBase && this.entity.ticksTillPlay > 0) {
            this.entity.setAttackTarget(null);
            return;
        }
        if (this.entity.getPassengers().isEmpty()) {
            this.entity.getNavigator().tryMoveToEntityLiving(target, this.speed);
        }
        this.attackTick = Math.max(this.attackTick - 1, 0);
        if (this.entity.getDistanceSq(target.posX, target.getEntityBoundingBox().minY, target.posZ) < this.entity.width * 2.0F * this.entity.width * 2.0F + target.width) {
            if (this.entity.getHeldItem(EnumHand.MAIN_HAND) != null) {
                this.entity.swingArm(EnumHand.MAIN_HAND);
            }
            this.entity.getNavigator().clearPathEntity();
            this.entity.attackEntityAsMob(target);
        } else {
            this.entity.getLookHelper().setLookPositionWithEntity(target, 30.0F, 30.0F);
        }
    }
}
