package com.github.revival.server.entity.mob.test;

import com.github.revival.server.enums.EnumOrderType;

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
    @Override
    public boolean shouldExecute() {
        if (this.entity.currentOrder == null) {
            this.entity.currentOrder = EnumOrderType.WANDER;
        }
    	if(!entity.canWander){
    		return false;
    	}
        if (entity.isMovementBlocked()) {
            return false;
        }
        if (this.entity instanceof EntityFlyingPrehistoric && ((EntityFlyingPrehistoric)this.entity).isFlying()) {
            return false;
        }
        if (this.entity.getRNG().nextInt(120) != 0) {
            return false;
        } else if (this.entity.isTamed() && this.entity.currentOrder != EnumOrderType.WANDER) {
            return false;
        } else {
            Vec3 vec3 = RandomPositionGenerator.findRandomTarget(this.entity, 10, 7);
            System.out.print(vec3);
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
    @Override
    public boolean continueExecuting() {
        return !this.entity.getNavigator().noPath();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, 1);
    }
}
