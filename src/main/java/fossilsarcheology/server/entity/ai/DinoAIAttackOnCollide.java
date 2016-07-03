package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.EntityToyBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class DinoAIAttackOnCollide extends EntityAIBase {
    private final EntityPrehistoric dino;
    private World worldObj;
    private int attackTick;
    private double speed;
    private boolean field_75437_f;
    private PathEntity entityPathEntity;
    private Class classTarget;

    public DinoAIAttackOnCollide(EntityPrehistoric entityNewPrehistoric, double speed, boolean par4) {
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
    }

    @Override
    public void resetTask() {
        this.dino.getNavigator().clearPathEntity();
    }

    @Override
    public void updateTask() {
        EntityLivingBase target = this.dino.getAttackTarget();
        if (target instanceof EntityToyBase && dino.ticksTillPlay > 0) {
            dino.setAttackTarget(null);
            return;
        }
        if(this.dino.riddenByEntity == null){
            this.dino.getNavigator().tryMoveToEntityLiving(target, speed);
        }
        this.attackTick = Math.max(this.attackTick - 1, 0);
        if (this.dino.getDistanceSq(target.posX, target.boundingBox.minY, target.posZ) < this.dino.width * 2.0F * this.dino.width * 2.0F + target.width) {
            if (this.dino.getHeldItem() != null) {
                this.dino.swingItem();
            }
            this.dino.getNavigator().clearPathEntity();
            this.dino.attackEntityAsMob(target);
        } else {
            this.dino.getLookHelper().setLookPositionWithEntity(target, 30.0F, 30.0F);
        }
    }
}
