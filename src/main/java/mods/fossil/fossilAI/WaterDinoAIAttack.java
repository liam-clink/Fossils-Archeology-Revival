package mods.fossil.fossilAI;

import java.util.Random;

import mods.fossil.entity.mob.EntityDinosaur;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class WaterDinoAIAttack extends EntityAIBase
{
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private double speed;
    
    private EntityDinosaur entity;
    
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;
    private float randomMotionSpeed;
    
    private Entity targetedEntity;
    
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
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

    public WaterDinoAIAttack(EntityDinosaur dinosaur, double speed)
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
    	this.targetedEntity = this.entity.worldObj.getClosestVulnerablePlayerToEntity(this.entity, 20.0D);
    	
    	return (this.entity.isInWater() && this.targetedEntity != null && this.targetedEntity.isInWater()
                &&  this.targetedEntity.getDistanceSqToEntity(this.entity) < distance * distance);
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
    	double distance = 64.0D;
    	this.targetedEntity = this.entity.worldObj.getClosestVulnerablePlayerToEntity(this.entity, 20.0D);
    	
        return (this.entity.isInWater() && this.targetedEntity != null && this.targetedEntity.isInWater()
                &&  this.targetedEntity.getDistanceSqToEntity(this.entity) < distance * distance);
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
                &&  this.targetedEntity.getDistanceSqToEntity(this.entity) < distance * distance)
        {
        	
            // Simple "pathfinding" to attack closest player.
            this.deltaX = this.targetedEntity.posX - this.entity.posX;
            this.deltaY = this.targetedEntity.posY - this.entity.posY;
            this.deltaZ = this.targetedEntity.posZ - this.entity.posZ;
            /*
            this.length = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
            deltaX /= length + 1.2D;
            deltaY /= length + 1.2D;
            deltaZ /= length + 1.2D;
            
            //Set waypoint for player's current location.
            this.waypointX += deltaX;
            this.waypointY += deltaY;
            this.waypointZ += deltaZ;
            //Now move.
            double d5 = this.targetedEntity.posX - this.entity.posX;
            double d6 = this.targetedEntity.posY - this.entity.posY;
            double d7 = this.targetedEntity.posZ - this.entity.posZ;
            */
            //rotate entity to face target
            this.entity.renderYawOffset = this.entity.rotationYaw = -((float)Math.atan2(deltaX, deltaZ)) * 180.0F / (float)Math.PI;
            Vec3 vec3 = this.entity.getLook(1.0F);
 
            
            
            //this.entityVector = Vec3.createVectorHelper(this.dinosaur.posX, this.dinosaur.posY, this.dinosaur.posZ);
            //this.targetVector = Vec3.createVectorHelper(this.destX, this.destY, this.destZ);
            
            
            //this.moveVector = targetVector.subtract(entityVector);
            
            //this.normalizedVector = this.moveVector.normalize();
            
            this.movePosX = this.deltaX;
            this.movePosY = this.deltaY;
            this.movePosZ = this.deltaZ;
            
            this.entity.addVelocity( deltaX * this.speed, deltaY * this.speed,  deltaZ * this.speed);
            this.entity.worldObj.playSoundAtEntity(this.entity, this.entity.getAttackSound(), 1F, 1F);

        }
        else
        {
            this.entity.renderYawOffset = this.entity.rotationYaw = -((float)Math.atan2(this.entity.motionX, this.entity.motionZ)) * 180.0F / (float)Math.PI;
        }
    }
}