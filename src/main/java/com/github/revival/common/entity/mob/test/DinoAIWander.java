package com.github.revival.common.entity.mob.test;

import com.github.revival.common.enums.EnumOrderType;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public class DinoAIWander extends EntityAIBase {
    private EntityNewPrehistoric entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;

    public DinoAIWander(EntityNewPrehistoric var1) {
        this.entity = var1;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        if (this.entity.currentOrder == null) {
            this.entity.currentOrder = EnumOrderType.FreeMove;
        }

        if (entity.isSitting()) {
            return false;
        }

        if (this.entity.getRNG().nextInt(20) != 0) {
            return false;
        } else if (this.entity.isTamed() && this.entity.currentOrder != EnumOrderType.FreeMove) {
            return false;
        } else {
            Vec3 vec3 = RandomPositionGenerator.findRandomTarget(this.entity, 30, 7);

            if (vec3 == null) {
                return false;
            } else {
                this.xPosition = vec3.xCoord;
                this.yPosition = vec3.yCoord;
                this.zPosition = vec3.zCoord;
                return true;
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting() {
        return !this.entity.getNavigator().noPath();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, 1);
    }
}
