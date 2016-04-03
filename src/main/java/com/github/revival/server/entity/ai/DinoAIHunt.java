package com.github.revival.server.entity.ai;

import com.github.revival.server.config.FossilConfig;
import com.github.revival.server.entity.mob.EntityDinosaur;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class DinoAIHunt extends EntityAITarget {
    private final Class targetClass;
    private EntityDinosaur dinosaur;
    private DinoAINearestAttackableTargetSorter targetSorter;
    /**
     * This filter is applied to the Entity search.  Only matching entities will be targetted.  (null -> no
     * restrictions)
     */

    private EntityLivingBase targetEntity;
    private int attackCountdown;
    private int SEARCH_RANGE;
    private World theWorld;

    public DinoAIHunt(EntityDinosaur dinosaur, Class _class, int range, boolean par4) {
        super(dinosaur, par4);
        this.theWorld = dinosaur.worldObj;
        this.dinosaur = dinosaur;
        this.targetClass = _class;
        this.SEARCH_RANGE = range;
        this.targetSorter = new DinoAINearestAttackableTargetSorter(this, this.dinosaur);
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
                    if (!(entity instanceof EntityDinosaur) || (entity instanceof EntityDinosaur && !((EntityDinosaur) entity).isModelized())) {//No modelized Dinos for Lunch!
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
    @Override
    public boolean continueExecuting() {
        return this.targetEntity.isEntityAlive() && (this.dinosaur.getDistanceSqToEntity(this.targetEntity) <= 225.0D && (!this.dinosaur.getNavigator().noPath() || this.shouldExecute()));
    }

    /**
     * Resets the task
     */
    @Override
    public void resetTask() {
        this.targetEntity = null;
        this.dinosaur.getNavigator().clearPathEntity();
    }

    /**
     * Updates the task
     */
    @Override
    public void updateTask() {

        this.dinosaur.getLookHelper().setLookPositionWithEntity(this.targetEntity, 30.0F, 30.0F);
        double d0 = (double) (this.dinosaur.width * 2.0F * this.dinosaur.width * 2.0F);
        double d1 = this.dinosaur.getDistanceSq(this.targetEntity.posX, this.targetEntity.boundingBox.minY, this.targetEntity.posZ);
        double d2 = 1.8D;

        if (d1 > d0 && d1 < 16.0D) {
            d2 = 1.0D;
        } else if (d1 < 225.0D) {
            d2 = 1.3D;
        }

        this.dinosaur.getNavigator().tryMoveToEntityLiving(this.targetEntity, d2);
        this.attackCountdown = Math.max(this.attackCountdown - 1, 0);

        if (d1 <= d0) {
            if (this.attackCountdown <= 0) {
                this.attackCountdown = 20;
                this.dinosaur.attackEntityAsMob(this.targetEntity);
            }
        }
    }

}
