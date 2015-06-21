package com.github.revival.common.entity.ai;

import com.github.revival.Revival;
import com.github.revival.common.config.FossilConfig;
import com.github.revival.common.entity.mob.EntityDinosaur;
import com.github.revival.common.tileentity.TileEntityFeeder;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class WaterDinoAIEat extends EntityAIBase
{
    private static final int NO_TARGET = -1;
    private static final int ITEM = 1;
    private static final int BLOCK = 2;
    private static final int MOB = 3;
    private static final int FEEDER = 4;
    // the range in which the dino is able to look for items
    private final int SEARCH_RANGE;
    // the range the dino is able to get the item when in
    private final int USE_RANGE = 3;
    protected EntityCreature taskOwner;
    private EntityDinosaur dinosaur;
    private double destX;
    private double destY;
    private double destZ;
    private int typeofTarget = NO_TARGET;
    private int TimeAtThisTarget = 0;
    // The item the dino is going to take
    private TileEntityFeeder targetFeeder;
    private EntityItem targetItem;
    private EntityLiving targetMob;
    private Vec3 targetBlock;
    private EntityLivingBase targetEntity;
    private DinoAINearestAttackableTargetSorter targetSorter;

    private World theWorld;

    private double deltaX;

    private double movePosX;

    private double movePosY;

    private double movePosZ;

    private double deltaY;

    private double deltaZ;

    private double speed;

    private int entityPosX;

    private int entityPosY;

    private int entityPosZ;

    /**
     * Creates The AI, Input: Dino, Speed, searching range
     */
    public WaterDinoAIEat(EntityDinosaur Dino0, int Range0, double speed)
    {
        this.theWorld = Dino0.worldObj;
        this.targetMob = null;
        this.targetFeeder = null;
        this.dinosaur = Dino0;
        this.speed = speed;
        this.setMutexBits(1);
        this.SEARCH_RANGE = Range0;
        this.targetSorter = new DinoAINearestAttackableTargetSorter(this, this.dinosaur);
        this.TimeAtThisTarget = 0;
    }

    /**
     * Determine if this AI Task is interruptible by a higher (= lower value) priority task.
     */
    public boolean isInterruptible()
    {
        return true;
    }
    
    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        int Range = this.SEARCH_RANGE;// Current Searching range

        if (!theWorld.isRemote)
        {
            if (!FossilConfig.starvingDinos)
                return false;
        }
        
        if (!this.dinosaur.IsHungry() && !this.dinosaur.IsDeadlyHungry())
        {
            this.typeofTarget = NO_TARGET;
            return false;
        }

        PathNavigate pathnavigate = this.dinosaur.getNavigator();
        PathEntity pathentity = pathnavigate.getPath();

        if (pathentity != null && !pathentity.isFinished())
        {
            PathPoint pathpoint = pathentity.getFinalPathPoint();
            this.entityPosX = pathpoint.xCoord;
            this.entityPosY = pathpoint.yCoord + 1;
            this.entityPosZ = pathpoint.zCoord;

            if (this.dinosaur.getDistanceSq((double) this.entityPosX, this.dinosaur.posY, (double) this.entityPosZ) <= 5.25D)
            {
                //Feeder has priority over other food sources.
                if (this.dinosaur.SelfType.useFeeder())
                {
                    //targetFeeder = this.dinosaur.GetNearestFeeder(Range/2);
                    this.targetFeeder = null;

                    if (this.targetFeeder != null)
                    {
                        Revival.Console("Found Feeder at: " + this.targetFeeder.xCoord + ", " + this.targetFeeder.yCoord + ", " + this.targetFeeder.zCoord);
                        this.destX = this.targetFeeder.xCoord;
                        this.destY = this.targetFeeder.yCoord;
                        this.destZ = this.targetFeeder.zCoord;
                        this.typeofTarget = FEEDER;
                        return true;
                    }
                }
            }
        }
        //Check for items and then blocks.
        if (!this.dinosaur.SelfType.FoodItemList.IsEmpty())
        {
            this.targetItem = this.getNearestItem2(this.SEARCH_RANGE);
            if (this.targetItem != null)
            {
                this.destX = targetItem.posX;
                this.destY = targetItem.posY;
                this.destZ = targetItem.posZ;
                this.typeofTarget = ITEM;
                return true;
            }

            if (!this.dinosaur.SelfType.FoodBlockList.IsEmpty())//Hasn't found anything and has blocks it can look for
            {
                Vec3 targetBlock = this.dinosaur.getBlockToEat(this.SEARCH_RANGE);
                
                if (targetBlock != null)//Found Item, go there and eat it
                {
                    this.destX = targetBlock.xCoord;
                    this.destY = targetBlock.yCoord;
                    this.destZ = targetBlock.zCoord;
                    this.typeofTarget = BLOCK;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    @Override
    public boolean continueExecuting()
    {
        double Distance = Math.sqrt(Math.pow(this.dinosaur.posX - this.destX, 2.0D) + Math.pow(this.dinosaur.posZ - this.destZ, 2.0D));

        if (!this.dinosaur.IsHungry())
        {
            return false;
        }
        
        if (Distance > this.SEARCH_RANGE)
        {
            Revival.Console("Target too far, discontinuing task. Distance: " + Distance + ", Range: " + this.SEARCH_RANGE);
            return false;
        }

        switch (this.typeofTarget)
        {
            case NO_TARGET:
            default:
                return false;
            case ITEM:
                return this.targetItem.isEntityAlive() && this.targetItem != null;
            case BLOCK:
                return this.dinosaur.SelfType.FoodBlockList.CheckBlock(this.dinosaur.worldObj.getBlock((int) destX, (int) destY, (int) destZ)) && this.targetBlock != null;
            case MOB:
                return this.targetMob != null && this.targetMob.isEntityAlive();
            case FEEDER:
                return !this.targetFeeder.isInvalid();
            //return targetFeeder != null;

        }

        //return ((this.dinosaur.IsHungry() || this.dinosaur.IsDeadlyHungry()) && (this.typeofTarget != -1));
    }

    /**
     * Updates the task
     */
    @Override
    public void updateTask()
    {
        int Range = this.SEARCH_RANGE;
        this.dinosaur.setSitting(false);
        double Distance = Math.sqrt(Math.pow(this.dinosaur.posX - this.destX, 2.0D) + Math.pow(this.dinosaur.posZ - this.destZ, 2.0D));

        
        if (Distance > Range)
        {
            endTask();
        }
        

        if (this.typeofTarget == FEEDER)
        {

            if (this.targetFeeder == null)
                endTask();

            if (Distance < SEARCH_RANGE)
            {

                this.moveToTarget(this.destX, this.destY, this.destZ);
                this.TimeAtThisTarget++;
                if (Distance < 4.5D)
                {
                    if (this.targetFeeder != null)
                    {
                        int healval = MathHelper.floor_double(this.targetFeeder.Feed(this.dinosaur, this.dinosaur.SelfType) / 15D);
                        this.dinosaur.heal(healval);
                    }
                }
            }
            if (this.TimeAtThisTarget == 100)
            {
                endTask();
            }
            else
            {
                endTask();
            }

        }

        if (this.typeofTarget == ITEM)
        {
            if (this.targetItem == null)
                endTask();
            if (Distance < SEARCH_RANGE)
            {
                this.moveToTarget(this.destX, this.destY, this.destZ);
                if (Distance < 2.5)
                {

                    if (this.targetItem != null && this.targetItem.isEntityAlive())
                    {
                        int i = this.dinosaur.PickUpItem(this.targetItem.getEntityItem());

                        if (i > 0)
                        {
                            this.targetItem.getEntityItem().stackSize = i;
                            endTask();
                        }
                        else
                        {
                            this.targetItem.setDead();
                            endTask();
                        }
                    }
                }
            }
            else
            {
                endTask();
            }
        }

        if (this.typeofTarget == BLOCK)
        {
            if (!this.dinosaur.SelfType.FoodBlockList.CheckBlock(this.dinosaur.worldObj.getBlock((int) destX, (int) destY, (int) destZ)))
                endTask();
            if (Distance < SEARCH_RANGE)
            {
                this.dinosaur.getNavigator().tryMoveToXYZ(this.destX, this.destY, this.destZ, 1.0D);
                if (Distance < 2.5)
                {
                    if (this.dinosaur.SelfType.FoodBlockList.CheckBlock(this.dinosaur.worldObj.getBlock((int) destX, (int) destY, (int) destZ)))
                    {
                        this.dinosaur.heal(this.dinosaur.SelfType.FoodBlockList.getBlockHeal(this.dinosaur.worldObj.getBlock((int) destX, (int) destY, (int) destZ)));
                        this.dinosaur.increaseHunger(this.dinosaur.SelfType.FoodBlockList.getBlockFood(Item.getItemFromBlock(this.dinosaur.worldObj.getBlock((int) destX, (int) destY, (int) destZ))));
                        this.dinosaur.worldObj.setBlock((int) destX, (int) destY, (int) destZ, Blocks.air, 0, 2);

                        this.TimeAtThisTarget++;
                        if (this.TimeAtThisTarget == 20)
                        {
                            endTask();
                        }
                    }
                }
            }
            else
            {
                endTask();
            }
        }
    }

    public void endTask()
    {
//        this.dinosaur.getNavigator().clearPathEntity();
        this.TimeAtThisTarget = 0;
        targetItem = null;
        targetBlock = null;
        targetFeeder = null;
        this.targetEntity = null;
        this.typeofTarget = NO_TARGET;
    }
    
    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.TimeAtThisTarget = 0;
        targetItem = null;
        targetBlock = null;
        targetFeeder = null;
        this.targetEntity = null;
        this.typeofTarget = NO_TARGET;
    }

    private TileEntityFeeder getNearbyFeeder()
    {
        double range = 36;
        List<TileEntity> nearbyEntities = theWorld.getEntitiesWithinAABB(TileEntityFeeder.class, this.dinosaur.boundingBox.expand(range, range, range));

        for (TileEntity entityFeeder : nearbyEntities)
        {
            TileEntityFeeder nearbyFeeder = (TileEntityFeeder) entityFeeder;

            if (this.dinosaur.SelfType.useFeeder())
            {
                return nearbyFeeder;
            }
        }

        return null;
    }

    private EntityItem getNearestItem2(int SEARCH_RANGE)
    {
        List nearbyItems = this.dinosaur.worldObj.getEntitiesWithinAABB(EntityItem.class, this.dinosaur.boundingBox.expand(SEARCH_RANGE, SEARCH_RANGE, SEARCH_RANGE));
        Collections.sort(nearbyItems, this.targetSorter);
        Iterator iterateNearbyItems = nearbyItems.iterator();
        EntityItem entityItem = null;

        while (iterateNearbyItems.hasNext())
        {

            EntityItem entityItem1 = (EntityItem) iterateNearbyItems.next();

            if ((this.dinosaur.SelfType.FoodItemList.CheckItem(entityItem1.getEntityItem().getItem())
                    || this.dinosaur.SelfType.FoodBlockList.CheckBlock(Block.getBlockFromItem(entityItem1.getEntityItem().getItem()))
                    && this.dinosaur.getDistanceSqToEntity(entityItem1) < SEARCH_RANGE))
            {
                entityItem = entityItem1;
                //SEARCH_RANGE = (int) this.dinosaur.getDistanceSqToEntity(entityItem);
            }
        }
        return entityItem;
    }

    private void moveToTarget(double destX, double destY, double destZ)
    {
        double distance = 64.0D;

        // Simple "pathfinding" to attack closest player.
        this.deltaX = this.destX - this.dinosaur.posX;
        this.deltaY = this.destY - this.dinosaur.posY;
        this.deltaZ = this.destZ - this.dinosaur.posZ;
        //rotate entity to face target
        this.dinosaur.renderYawOffset = this.dinosaur.rotationYaw = -((float) Math.atan2(deltaX, deltaZ)) * 180.0F / (float) Math.PI;

        this.movePosX = this.deltaX;
        this.movePosY = this.deltaY;
        this.movePosZ = this.deltaZ;
        
        this.dinosaur.addVelocity(deltaX * this.speed, deltaY * this.speed, deltaZ * this.speed);
    }

}