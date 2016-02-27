package com.github.revival.server.entity.ai;

import com.github.revival.server.entity.mob.test.NewPrehistoricEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class DinoAILeapAtTarget extends EntityAIBase {
    NewPrehistoricEntity dino;
    EntityLivingBase leapTarget;

    public DinoAILeapAtTarget(NewPrehistoricEntity dino) {
        this.dino = dino;
        this.setMutexBits(5);
    }

    public boolean shouldExecute() {
        this.leapTarget = this.dino.getAttackTarget();

        if (dino.getAnimation() == dino.animation_attack) {
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
            return d0 >= 4.0D && d0 <= 16.0D ? (!this.dino.onGround ? false : this.dino.getRNG().nextInt(5) == 0) : false;
        }
    }

    public boolean continueExecuting() {
        return !this.dino.onGround;
    }

    public void startExecuting() {
        if (dino.getAnimation() != dino.animation_attack) {
            dino.setAnimation(dino.animation_attack);
        }
    }

}