package com.github.revival.server.entity.mob.test;

import com.github.revival.server.enums.EnumPrehistoricAI.Response;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIHurtByTarget;

public class DinoAIHurtByTarget extends EntityAIHurtByTarget {

    public DinoAIHurtByTarget(EntityCreature mob) {
        super(mob, true);
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        if (this.taskOwner instanceof EntityNewPrehistoric) {
            EntityNewPrehistoric prehistoric = (EntityNewPrehistoric) this.taskOwner;
            if (prehistoric.aiResponseType() == Response.SCARED) {
                return false;
            }
        }
        return super.shouldExecute();
    }

}
