package com.github.revival.server.entity.ai;

import com.github.revival.server.entity.mob.EntityDinosaur;
import com.github.revival.server.enums.EnumOrderType;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public class DinoAIWander extends EntityAIBase {
    private EntityDinosaur entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private double speed;

    public DinoAIWander(EntityDinosaur var1, double par2) {
        this.entity = var1;
        this.speed = par2;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        if (this.entity.OrderStatus == null) {
            this.entity.OrderStatus = EnumOrderType.WANDER;
        }

        if (this.entity.getRNG().nextInt(120) != 0) {
            return false;
        } else if (this.entity.isTamed() && this.entity.OrderStatus != EnumOrderType.WANDER) {
            return false;
        } else {
            Vec3 vec3 = RandomPositionGenerator.findRandomTarget(this.entity, 10, 7);

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
        this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }
}
