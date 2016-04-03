package com.github.revival.server.entity.mob.test;

import com.github.revival.server.enums.EnumOrderType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class DinoAIFollow extends EntityAIBase {
    World theWorld;
    float maxDist;
    float minDist;
    private EntityNewPrehistoric DinoEntity;
    private EntityLivingBase theOwner;
    private double speed;
    private PathNavigate petPathfinder;
    private int counter;
    private boolean avoidsWater;

    public DinoAIFollow(EntityNewPrehistoric par1EntityTameable, double par2, float par4, float par5) {
        this.DinoEntity = par1EntityTameable;
        this.theWorld = par1EntityTameable.worldObj;
        this.speed = par2;
        this.petPathfinder = par1EntityTameable.getNavigator();
        this.minDist = par4;
        this.maxDist = par5;
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {
        if (!this.DinoEntity.isTamed()) {
            return false;
        } else {
            if (DinoEntity.currentOrder != EnumOrderType.FOLLOW) {
                return false;
            }

            EntityLivingBase entitylivingbase = this.DinoEntity.getOwner();

            if (entitylivingbase == null) {
                return false;
            } else if (this.DinoEntity.getOrderType() != null && this.DinoEntity.getOrderType() != EnumOrderType.FOLLOW) {
                return false;
            } else if (this.DinoEntity.isSitting()) {
                return false;
            } else if (this.DinoEntity.getDistanceSqToEntity(entitylivingbase) < (double) (this.minDist * this.minDist)) {
                return false;
            } else {
                this.theOwner = entitylivingbase;
                return true;
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    @Override
    public boolean continueExecuting() {
        return !this.petPathfinder.noPath() && this.DinoEntity.getDistanceSqToEntity(this.theOwner) > (double) (this.maxDist * this.maxDist) && !this.DinoEntity.isSitting();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        this.counter = 0;
        this.avoidsWater = this.DinoEntity.getNavigator().getAvoidsWater();
        this.DinoEntity.getNavigator().setAvoidsWater(false);
    }

    /**
     * Resets the task
     */
    @Override
    public void resetTask() {
        this.theOwner = null;
        this.petPathfinder.clearPathEntity();
        this.DinoEntity.getNavigator().setAvoidsWater(this.avoidsWater);
    }

    /**
     * Updates the task
     */
    @Override
    public void updateTask() {
        this.DinoEntity.getLookHelper().setLookPositionWithEntity(this.theOwner, 10.0F, (float) this.DinoEntity.getVerticalFaceSpeed());

        if (!this.DinoEntity.isSitting()) {
            if (--this.counter <= 0) {
                this.counter = 10;

                if (!this.petPathfinder.tryMoveToEntityLiving(this.theOwner, this.speed)) {
                    if (!this.DinoEntity.getLeashed()) {
                        if (this.DinoEntity.getDistanceSqToEntity(this.theOwner) >= 144.0D) {
                            int i = MathHelper.floor_double(this.theOwner.posX) - 2;
                            int j = MathHelper.floor_double(this.theOwner.posZ) - 2;
                            int k = MathHelper.floor_double(this.theOwner.boundingBox.minY);

                            for (int l = 0; l <= 4; ++l) {
                                for (int i1 = 0; i1 <= 4; ++i1) {
                                    if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && World.doesBlockHaveSolidTopSurface(this.theWorld, i + l, k - 1, j + i1) && !this.theWorld.getBlock(i + l, k, j + i1).isNormalCube() && !this.theWorld.getBlock(i + l, k + 1, j + i1).isNormalCube()) {
                                        this.DinoEntity.setLocationAndAngles((double) ((float) (i + l) + 0.5F), (double) k, (double) ((float) (j + i1) + 0.5F), this.DinoEntity.rotationYaw, this.DinoEntity.rotationPitch);
                                        this.petPathfinder.clearPathEntity();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
