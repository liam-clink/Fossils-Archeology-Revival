package com.github.revival.common.entity.mob.test;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.github.revival.common.enums.EnumPrehistoricAI.Moving;
import com.github.revival.common.enums.EnumPrehistoricAI.Response;
import com.github.revival.common.enums.EnumPrehistoricAI.WaterAbility;

public class DinoAIWaterAgressive extends EntityAIBase
{
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private double speed;
    private EntityNewPrehistoric entity;
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;
    private float randomMotionSpeed;
    private Entity targetedEntity;
    private double deltaX;
    private double deltaY;
    private double deltaZ;
    private double length;
    
    private Random rand = new Random();
    
    private World worldObj;
    private double movePosX;
    private double movePosY;
    private double movePosZ;
    private Vec3 entityVector;
    private Vec3 targetVector;
    private Vec3 moveVector;
    private Vec3 normalizedVector;

    public DinoAIWaterAgressive(EntityNewPrehistoric dinosaur, double speed)
    {
        this.entity = dinosaur;
        this.speed = speed;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        double distance = 64.0D;
        if(entity.aiMovingType() != Moving.AQUATIC || entity.aiMovingType() != Moving.SEMIAQUATIC){
        	return false;
        }
        if(entity.aiWaterAbilityType() != WaterAbility.ATTACK || entity.aiResponseType() != Response.WATERAGRESSIVE){
        	return false;
        }
        this.targetedEntity = this.entity.worldObj.getClosestVulnerablePlayerToEntity(this.entity, 20.0D);
        if(entity.preyBlacklist().contains(targetedEntity)){
        	return false;
        }
		if(targetedEntity != null){

    		if(targetedEntity.width * 1.5F > entity.width || this.entity.preyBlacklist().contains(targetedEntity)){
    			return false;
    		}
		}
        return (this.entity.isInWater() && this.targetedEntity != null && this.targetedEntity.isInWater()
                && this.targetedEntity.getDistanceSqToEntity(this.entity) < distance * distance);
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        double distance = 64.0D;
        this.targetedEntity = this.entity.worldObj.getClosestVulnerablePlayerToEntity(this.entity, 20.0D);

        return (this.entity.isInWater() && this.targetedEntity != null && this.targetedEntity.isInWater()
                && this.targetedEntity.getDistanceSqToEntity(this.entity) < distance * distance);
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void updateTask()
    {
        double distance = 64.0D;

        if (this.targetedEntity != null && this.targetedEntity.isDead)
        {
            this.targetedEntity = null;
        }

        //this.targetedEntity = this.worldObj.getClosestVulnerablePlayerToEntity(this, 100.0D);
        this.targetedEntity = this.entity.worldObj.getClosestVulnerablePlayerToEntity(this.entity, 20.0D);

        if (this.entity.isInWater() && this.targetedEntity != null && this.targetedEntity.isInWater()
                && this.targetedEntity.getDistanceSqToEntity(this.entity) < distance * distance)
        {

            // Simple "pathfinding" to attack closest player.
            this.deltaX = this.targetedEntity.posX - this.entity.posX;
            this.deltaY = this.targetedEntity.posY - this.entity.posY;
            this.deltaZ = this.targetedEntity.posZ - this.entity.posZ;

            this.entity.renderYawOffset = this.entity.rotationYaw = -((float) Math.atan2(deltaX, deltaZ)) * 180.0F / (float) Math.PI;
            Vec3 vec3 = this.entity.getLook(1.0F);

            this.movePosX = this.deltaX;
            this.movePosY = this.deltaY;
            this.movePosZ = this.deltaZ;
            
            this.entity.addVelocity(deltaX * this.speed, deltaY * this.speed, deltaZ * this.speed);

        }
        else
        {
            this.entity.renderYawOffset = this.entity.rotationYaw = -((float) Math.atan2(this.entity.motionX, this.entity.motionZ)) * 180.0F / (float) Math.PI;
        }
    }
}