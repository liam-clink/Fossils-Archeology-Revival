package com.github.revival.server.entity.ai;

import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class DinoAILeapAtTarget extends EntityAIBase {
    EntityNewPrehistoric dino;
    EntityLivingBase leapTarget;

    public DinoAILeapAtTarget(EntityNewPrehistoric dino) {
        this.dino = dino;
        this.setMutexBits(5);
    }

    @Override
    public boolean shouldExecute() {
        this.leapTarget = this.dino.getAttackTarget();

        if (dino.getAnimation() == EntityNewPrehistoric.ATTACK_ANIMATION) {
            return false;
        }
        if (dino.isSitting()) {
            return false;
        }
        if (dino.ridingEntity != null) {
            return false;
        }
        if (this.leapTarget == null) {
            return false;
        } else {
            double d0 = this.dino.getDistanceSqToEntity(this.leapTarget);
            return (d0 >= 1.0D && d0 <= 16.0D) && (this.dino.onGround && this.dino.getRNG().nextInt(5) == 0) && !dino.isMovementBlocked();
        }
    }

    @Override
    public boolean continueExecuting() {
        return !this.dino.onGround;
    }

    @Override
    public void startExecuting() {
        if (dino.getAnimation() != EntityNewPrehistoric.ATTACK_ANIMATION) {
            dino.setAnimation(EntityNewPrehistoric.ATTACK_ANIMATION);
        }
    }

}