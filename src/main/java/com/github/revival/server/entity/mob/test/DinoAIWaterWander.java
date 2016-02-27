package com.github.revival.server.entity.mob.test;

import com.github.revival.server.enums.EnumPrehistoricAI.Moving;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.ArrayList;

public class DinoAIWaterWander extends EntityAIBase {
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private double speed;
    private ArrayList collidingBoundingBoxes = new ArrayList();
    private NewPrehistoricEntity entity;
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;
    private float randomMotionSpeed;
    private Entity targetedEntity;
    private double deltaX;
    private double deltaY;
    private double deltaZ;
    private double length;


    private World worldObj;

    public DinoAIWaterWander(NewPrehistoricEntity dinosaur, double speed) {
        this.entity = dinosaur;
        this.speed = speed;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        if (entity.aiMovingType() != Moving.AQUATIC && entity.aiMovingType() != Moving.SEMIAQUATIC) {
            return false;
        }
        return !this.entity.isDead && this.entity.isInsideOfMaterial(Material.water);
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting() {
        return !this.entity.isDead;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void updateTask() {

        double d4 = 64.0D;
        double d0 = this.waypointX - this.entity.posX;
        double d1 = this.waypointY - this.entity.posY;
        double d2 = this.waypointZ - this.entity.posZ;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;

        if (d3 < 1.0D || d3 > 3600.0D) {
            //  if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3))
            //  {
            this.waypointX = this.entity.posX + (double) ((this.entity.getRNG().nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.waypointY = this.entity.posY + (double) ((this.entity.getRNG().nextFloat() * 2.0F - 1.0F) * 8.0F);
            this.waypointZ = this.entity.posZ + (double) ((this.entity.getRNG().nextFloat() * 2.0F - 1.0F) * 16.0F);
            //  }
        }

        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.entity.getRNG().nextInt(10) + 5;
            d3 = (double) MathHelper.sqrt_double(d3);

            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3)) {
                this.entity.motionX += d0 / d3 * 0.1D;
                this.entity.motionZ += d2 / d3 * 0.1D;

                if (this.entity.isInsideOfMaterial(Material.water)) {
                    this.entity.motionY += d1 / d3 * 0.1D;
                } else {
                    this.entity.motionY -= 0.08D;
                    this.entity.motionY *= 0.9800000190734863D;
                }

            } else {
                this.waypointX = this.entity.posX;
                this.waypointY = this.entity.posY;
                this.waypointZ = this.entity.posZ;
            }
        }

        this.entity.renderYawOffset = this.entity.rotationYaw = -((float) Math.atan2(this.entity.motionX, this.entity.motionZ)) * 180.0F / (float) Math.PI;

    }


    /**
     * True if the Mosasaur has an unobstructed line of travel to the waypoint.
     */
    private boolean isCourseTraversable(double par1, double par3, double par5, double par7) {
        double d4 = (this.waypointX - this.entity.posX) / par7;
        double d5 = (this.waypointY - this.entity.posY) / par7;
        double d6 = (this.waypointZ - this.entity.posZ) / par7;
        AxisAlignedBB axisalignedbb = this.entity.boundingBox.copy();
        axisalignedbb.offset(d4, d5, d6);

        for (int i = 1; (double) i < par7; ++i) {


            axisalignedbb.offset(d4, d5, d6);

            if (!this.entity.worldObj.getCollidingBoundingBoxes(this.entity, axisalignedbb).isEmpty()) {
                return false;
            }
        }

        return this.entity.worldObj.isAnyLiquid(axisalignedbb);
    }


}