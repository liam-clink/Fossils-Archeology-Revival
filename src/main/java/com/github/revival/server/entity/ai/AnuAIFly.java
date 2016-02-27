package com.github.revival.server.entity.ai;

import com.github.revival.server.entity.mob.AnuEntity;
import net.minecraft.entity.ai.EntityAIBase;

public class AnuAIFly extends EntityAIBase {
    protected AnuEntity entity;

    public AnuAIFly(AnuEntity var1) {
        this.entity = var1;

    }


    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        return entity.getAttackMode() == 1;
    }


    /**
     * Updates the task
     */
    public void updateTask() {
    }
}
