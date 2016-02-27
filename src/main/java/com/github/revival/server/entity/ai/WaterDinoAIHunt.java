package com.github.revival.server.entity.ai;

import com.github.revival.server.config.FossilConfig;
import com.github.revival.server.entity.mob.DinosaurEntity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class WaterDinoAIHunt extends EntityAITarget {
    private final Class targetClass;
    private DinosaurEntity dinosaur;
    private DinoAINearestAttackableTargetSorter targetSorter;
    /**
     * This filter is applied to the Entity search.  Only matching entities will be targetted.  (null -> no
     * restrictions)
     */

    private EntityLivingBase targetEntity;
    private int attackCountdown;
    private double deltaX;
    private double deltaY;
    private double deltaZ;
    private double movePosX;
    private double movePosY;
    private double movePosZ;
    private int SEARCH_RANGE;
    private double speed;
    private World theWorld;

    public WaterDinoAIHunt(DinosaurEntity dinosaur, Class _class, int range, boolean par4, double speed) {
        super(dinosaur, par4);
        this.theWorld = dinosaur.worldObj;
        this.speed = speed;
        this.dinosaur = dinosaur;
        this.targetClass = _class;
        this.SEARCH_RANGE = range;
        this.targetSorter = new DinoAINearestAttackableTargetSorter(this, this.dinosaur);
    }

    public boolean isInterruptible() {
        return true;
    }

    @Override
    public boolean shouldExecute() {
        if (!theWorld.isRemote) {
            if (!FossilConfig.starvingDinos) {
                return false;
            }
        }

        if ((this.dinosaur.IsHungry() || this.dinosaur.IsDeadlyHungry()) && !this.dinosaur.SelfType.FoodMobList.IsEmpty()) {
            double d0 = this.getTargetDistance();

            if (this.getTargetDistance() > SEARCH_RANGE) {
                return false;
            }

            List list = this.dinosaur.worldObj.getEntitiesWithinAABB(EntityLiving.class, this.dinosaur.boundingBox.expand(d0, 2.0D, d0));
            Collections.sort(list, this.targetSorter);
            Iterator iterator = list.iterator();

            while (iterator.hasNext()) {
                EntityLiving entity = (EntityLiving) iterator.next();

                if (this.dinosaur.SelfType.FoodMobList.CheckMobByClass(entity.getClass())) {//It's food
                    if (!(entity instanceof DinosaurEntity) || (entity instanceof DinosaurEntity && ((DinosaurEntity) entity).isModelized() == false)) {//No modelized Dinos for Lunch!
                        this.targetEntity = entity;
                        //this.dinosaur.setAttackTarget(entity);
                        return true;
                    }
                }
            }
        }
        //this.targetEntity = null;
        return false;
    }


    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting() {
        return !this.targetEntity.isEntityAlive() ? false : (this.dinosaur.getDistanceSqToEntity(this.targetEntity) > SEARCH_RANGE ? false : this.shouldExecute());
    }

    /**
     * Resets the task
     */
    public void resetTask() {
        this.targetEntity = null;
        this.dinosaur.getNavigator().clearPathEntity();
    }

    /**
     * Updates the task
     */
    public void updateTask() {
        double distance = SEARCH_RANGE;
        this.dinosaur.getLookHelper().setLookPositionWithEntity(this.targetEntity, 30.0F, 30.0F);
        double d0 = (double) (this.dinosaur.width * 2.0F * this.dinosaur.width * 2.0F);
        double d1 = this.dinosaur.getDistanceSq(this.targetEntity.posX, this.targetEntity.boundingBox.minY, this.targetEntity.posZ);
        double d2 = 1.8D;

        if (d1 > d0 && d1 < 16.0D) {
            d2 = 1.0D;
        } else if (d1 < 225.0D) {
            d2 = 1.3D;
        }


        if (this.dinosaur.isInWater() && this.targetEntity != null && this.targetEntity.isInWater()
                && this.targetEntity.getDistanceSqToEntity(this.dinosaur) < distance * distance) {

            this.deltaX = this.targetEntity.posX - this.dinosaur.posX;
            this.deltaY = this.targetEntity.posY - this.dinosaur.posY;
            this.deltaZ = this.targetEntity.posZ - this.dinosaur.posZ;
            //rotate entity to face target
            this.dinosaur.renderYawOffset = this.dinosaur.rotationYaw = -((float) Math.atan2(deltaX, deltaZ)) * 180.0F / (float) Math.PI;

            this.movePosX = this.deltaX;
            this.movePosY = this.deltaY;
            this.movePosZ = this.deltaZ;

            this.dinosaur.addVelocity(deltaX * this.speed, deltaY * this.speed, deltaZ * this.speed);

            if (this.dinosaur.canEntityBeSeen(this.targetEntity)) {
                Vec3 vec3 = this.dinosaur.getLook(1.0F);
            }
        } else {
            this.dinosaur.renderYawOffset = this.dinosaur.rotationYaw = -((float) Math.atan2(this.dinosaur.motionX, this.dinosaur.motionZ)) * 180.0F / (float) Math.PI;
        }

        this.attackCountdown = Math.max(this.attackCountdown - 1, 0);

        if (d1 <= d0) {
            if (this.attackCountdown <= 0) {
                this.attackCountdown = 20;
                this.dinosaur.attackEntityAsMob(this.targetEntity);
            }
        }

    }

}