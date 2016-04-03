package com.github.revival.server.entity.ai;

import com.github.revival.server.entity.mob.EntityBones;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIDeadBones extends EntityAIBase {
    private EntityBones asker;

    public EntityAIDeadBones(EntityBones var1) {
        this.asker = var1;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {
        return true;
    }

    /**
     * Updates the task
     */
    @Override
    public void updateTask() {
        float var1 = this.asker.rotationYaw;
        this.asker.rotationPitch = 45.0F;
        this.asker.rotationYaw = var1;
    }
}
