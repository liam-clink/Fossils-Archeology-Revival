package com.github.revival.common.entity.mob.test;

import java.util.List;

import com.github.revival.common.enums.EnumPrehistoricAI.Response;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;

public class DinoAITerratorial extends EntityAIBase
{
    public final IEntitySelector selector = new IEntitySelector()
    {
        private static final String __OBFID = "CL_00001575";
        /**
         * Return whether the specified entity is applicable to this filter.
         */
        public boolean isEntityApplicable(Entity entity)
        {
            return entity.isEntityAlive() && DinoAITerratorial.this.theEntity.getEntitySenses().canSee(entity);
        }
    };
    /** The entity we are attached to */
    private EntityCreature theEntity;
    private Entity closestLivingEntity;
    private float distanceFromEntity;
    /** The PathEntity of our entity */
    private PathEntity entityPathEntity;
    /** The PathNavigate of our entity */
    private PathNavigate entityPathNavigate;
    /** The class of the entity we should avoid */
    private Class targetEntityClass;
    private static final String __OBFID = "CL_00001574";

    public DinoAITerratorial(EntityCreature creature, Class target, float distance)
    {
        this.theEntity = creature;
        this.targetEntityClass = target;
        this.distanceFromEntity = distance;
        this.entityPathNavigate = creature.getNavigator();
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	if(this.theEntity instanceof EntityNewPrehistoric){
    		EntityNewPrehistoric prehistoric = (EntityNewPrehistoric)theEntity;
    		if(prehistoric.aiResponseType() != Response.TERRITORIAL){
    			return false;
    		}
    	}
    	if(targetEntityClass == closestLivingEntity.getClass() && targetEntityClass != theEntity.getClass()){
    		if(closestLivingEntity.boundingBox.maxX * 1.5F < theEntity.boundingBox.maxX && closestLivingEntity.boundingBox.minX * 1.5F < theEntity.boundingBox.minX
    		&& closestLivingEntity.boundingBox.minZ * 1.5F < theEntity.boundingBox.minZ && closestLivingEntity.boundingBox.minZ  * 1.5F < theEntity.boundingBox.minZ){
    			return false;
    		}
    	}
        if (this.targetEntityClass == EntityPlayer.class)
        {
            if (this.theEntity instanceof EntityTameable && ((EntityTameable)this.theEntity).isTamed())
            {
                return false;
            }

            this.closestLivingEntity = this.theEntity.worldObj.getClosestPlayerToEntity(this.theEntity, (double)this.distanceFromEntity);

            if (this.closestLivingEntity == null)
            {
                return false;
            }
            
        }
        else
        {
            List list = this.theEntity.worldObj.selectEntitiesWithinAABB(this.targetEntityClass, this.theEntity.boundingBox.expand((double)this.distanceFromEntity, 3.0D, (double)this.distanceFromEntity), this.selector);

            if (list.isEmpty())
            {
                return false;
            }

            this.closestLivingEntity = (Entity)list.get(0);
        }
        if(closestLivingEntity.getClass() == targetEntityClass){
        	return true;
        }else{
        	return false;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.entityPathNavigate.noPath();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
    	theEntity.setAttackTarget((EntityLiving)closestLivingEntity);
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.closestLivingEntity = null;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
    }
}