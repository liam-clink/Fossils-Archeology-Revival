package mods.fossil.entity.mob;

import io.netty.buffer.ByteBuf;

import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import mods.fossil.Fossil;
import mods.fossil.fossilAI.DinoAIAttackOnCollide;
import mods.fossil.fossilAI.DinoAIEat;
import mods.fossil.fossilAI.DinoAIFishing;
import mods.fossil.fossilAI.DinoAIFollowOwner;
import mods.fossil.fossilAI.DinoAIRideGround;
import mods.fossil.fossilAI.DinoAIWander;
import mods.fossil.fossilAI.WaterDinoAIEat;
import mods.fossil.fossilAI.WaterDinoAIHunt;
import mods.fossil.fossilAI.WaterDinoAIWander;
import mods.fossil.fossilEnums.EnumDinoType;
import mods.fossil.fossilEnums.EnumOrderType;
import mods.fossil.util.MathX;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityPlesiosaur extends EntitySwimmingDino
{
    private boolean looksWithInterest;
    //public final float HuntLimit = (float)(this.getHungerLimit() * 4 / 5);
    /*private float field_25048_b;
    private float field_25054_c;//For the interesting looking angle!
    private boolean isWolfShaking;
    private boolean field_25052_g;
    public int SubSpecies = 1;
    public boolean isBaby = true;*/
    //public int RushTick = 0;

    public float TargetY = 0.0F;
    private float randomMotionSpeed;
    private float randomMotionVecX = 0.0F;
    private float randomMotionVecY = 0.0F;
    private float randomMotionVecZ = 0.0F;
    //protected final int AGE_LIMIT = 18;
    
    public static final double baseHealth = EnumDinoType.Plesiosaur.Health0;
    public static final double baseDamage = EnumDinoType.Plesiosaur.Strength0;
    public static final double baseSpeed = EnumDinoType.Plesiosaur.Speed0;
    
    public static final double maxHealth = EnumDinoType.Plesiosaur.HealthMax;
    public static final double maxDamage = EnumDinoType.Plesiosaur.StrengthMax;
    public static final double maxSpeed = EnumDinoType.Plesiosaur.SpeedMax;
    
    private WaterDinoAIWander aiWaterDinoWander = new WaterDinoAIWander(this, 1.0D);
    private DinoAIWander aiDinoWander = new DinoAIWander(this, 1.0D);
    
    private WaterDinoAIHunt aiWaterDinoHunt = new WaterDinoAIHunt(this, EntityLiving.class, 500, false, 0.002D);
    
    private WaterDinoAIEat aiWaterDinoEat = new WaterDinoAIEat(this, 50, 0.0017D);
    private DinoAIEat aiDinoEat = new DinoAIEat(this, 20);

    public EntityPlesiosaur(World var1)
    {
        super(var1, EnumDinoType.Plesiosaur);
        this.looksWithInterest = false;
        this.setSubSpecies((new Random()).nextInt(3) + 1);
        this.updateSize();
        /*
         * EDIT VARIABLES PER DINOSAUR TYPE
         */
        this.adultAge = EnumDinoType.Plesiosaur.AdultAge;
        // Set initial size for hitbox. (length/width, height)
        this.setSize(1.0F, 1.0F);
        // Size of dinosaur at day 0.
        this.minSize = 1.0F;
        // Size of dinosaur at age Adult.
        this.maxSize = 6.0F;
        
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(6, this.aiWaterDinoWander);
        this.tasks.addTask(5, this.aiWaterDinoEat);
        this.tasks.addTask(5, this.aiWaterDinoHunt);
        this.tasks.addTask(3, new DinoAIAttackOnCollide(this, 1.1D, true));
        this.tasks.addTask(4, new DinoAIFollowOwner(this, 5.0F, 2.0F, 1.0F));
        this.tasks.addTask(8, new DinoAIFishing(this, /*this.HuntLimit,*/ 1));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(11, new EntityAILookIdle(this));
        tasks.addTask(1, new DinoAIRideGround(this, 3)); // mutex all


       // this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityMosasaurus.class, 16.0F, 0.8D, 1.33D));
      //  this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityLiopleurodon.class, 16.0F, 0.8D, 1.33D));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(baseHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
    }

    @Override
    public boolean isAIEnabled()
    {
        return !this.isModelized();
    }
    
    @Override
    public boolean shouldDismountInWater(Entity rider){
        return false;
    }
    public void onLivingUpdate()
	{
		breakBlock(5);
		super.onLivingUpdate();
	}
    /**
     * Returns the texture's file path as a String.
     */
    @Override
    public String getTexture()
    {
        if (this.isModelized())
        {
            return super.getTexture();
        }

        switch (this.getSubSpecies())
        {
            default:
                return "fossil:textures/mob/Plesiosaur_adult.png";
        }
    }

    public boolean canBreatheUnderwater()
    {
        return true;
    }
    
    /*
    protected void updateEntityActionState()
    {
        if (!this.isModelized())
        {
            if (this.riddenByEntity == null)
            {
                super.updateEntityActionState();

                if (!this.isOnSurface() && (double)this.TargetY < this.posY)
                {
                    this.TargetY = (float)(this.posY++);
                }
                

                if (!this.isSitting() && !this.hasPath() && (new Random()).nextInt(1000) == 5)
                {
                    this.FindFish(2);
                }

                if (!this.worldObj.isRemote)
                {
                    this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));
                }
            }
        }
    }
*/
    
    public boolean isOnSurface()
    {
        return this.worldObj.isAirBlock((int)Math.floor(this.posX), (int)Math.floor(this.posY + (double)(this.getEyeHeight() / 2.0F)), (int)Math.floor(this.posZ));
    }
    

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        /*
        if(this.isInWater()){
        	this.tasks.removeTask(this.aiDinoWander);
        	this.tasks.removeTask(this.aiDinoEat);
        	this.tasks.addTask(6, this.aiWaterDinoWander);
        	this.tasks.addTask(5, this.aiWaterDinoEat);
        	this.tasks.addTask(5, this.aiWaterDinoHunt);
        }
        else {
        	this.tasks.removeTask(this.aiWaterDinoWander);
        	this.tasks.removeTask(this.aiWaterDinoEat);
        	this.tasks.removeTask(this.aiWaterDinoHunt);
        	this.tasks.addTask(6, this.aiDinoWander);
        	this.tasks.addTask(5, this.aiDinoEat);
        }
        */
    }

    /**
     * Takes a coordinate in and returns a weight to determine how likely this creature will try to path to the block.
     * Args: x, y, z
     */
    public float getBlockPathWeight(int var1, int var2, int var3)
    {
        return 0.5F - this.worldObj.getLightBrightness(var1, var2, var3);
    }

    /*public float getInterestedAngle(float var1)
    {
        return (this.field_25054_c + (this.field_25048_b - this.field_25054_c) * var1) * 0.15F * (float)Math.PI;
    }*/

    public float getEyeHeight()
    {
        return this.height * 0.8F;
    }

    /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed()
    {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }

    protected void getPathOrWalkableBlock(Entity var1, float var2)
    {
        PathEntity var3 = this.worldObj.getPathEntityToEntity(this, var1, 16.0F, true, false, true, false);
        this.setPathToEntity(var3);
    }

    /**
     * Disables a mob's ability to move on its own while true.
     */
    protected boolean isMovementCeased()
    {
        return this.isSitting() || this.isModelized();// || this.field_25052_g;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource var1, float var2)
    {
        if (this.modelizedDrop())
        {
            return true;
        }
        else
        {
            Entity var3 = var1.getEntity();

            if (var3 != null && !(var3 instanceof EntityPlayer) && !(var3 instanceof EntityArrow))
            {
                var2 = (var2 + 1) / 2;
            }

            if (!super.attackEntityFrom(var1, var2))
            {
                return false;
            }
            else
            {
                if (!this.isTamed() && !this.isSelfAngry())
                {
                    if (var3 instanceof EntityPlayer)
                    {
                        this.setSelfAngry(true);
                        this.entityToAttack = var3;
                    }

                    if (var3 instanceof EntityArrow && ((EntityArrow)var3).shootingEntity != null)
                    {
                        var3 = ((EntityArrow)var3).shootingEntity;
                    }

                    if (var3 instanceof EntityLiving)
                    {
                        ;
                    }
                }
                else if (var3 != this && var3 != null)
                {
                    if (this.isTamed() && var3 instanceof EntityPlayer && var3 == this.getOwner())
                    {
                        return true;
                    }

                    this.entityToAttack = var3;
                }

                return true;
            }
        }
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        return this.isSelfAngry() ? this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D) : null;
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
        //Add special item interaction code here
        return super.interact(var1);
    }

    public boolean isSelfAngry()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
    }

    public void setSelfAngry(boolean var1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if (var1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 2)));
            //this.moveSpeed = 2.0F;
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -3)));
            //this.moveSpeed = 0.5F;
        }
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    /*private void InitSize()
    {
        this.updateSize();
        this.setPosition(this.posX, this.posY, this.posZ);
        this.moveSpeed = this.getSpeed();//0.5F + (float)(this.getDinoAge() * 3);
    }*/

    public boolean CheckSpace()
    {
        if (!this.isInWater())
        {
            return !this.isEntityInsideOpaqueBlock();
        }
        else
        {
            for (int var1 = 0; var1 < 8; ++var1)
            {
                float var2 = ((float)((var1 >> 0) % 2) - 0.5F) * this.width * 0.9F;
                float var3 = ((float)((var1 >> 1) % 2) - 0.5F) * 0.1F;
                float var4 = ((float)((var1 >> 2) % 2) - 0.5F) * this.width * 0.9F;
                int var5 = MathHelper.floor_double(this.posX + (double)var2);
                int var6 = MathHelper.floor_double(this.posY + (double)this.getEyeHeight() + (double)var3);
                int var7 = MathHelper.floor_double(this.posZ + (double)var4);
                Block var8 = this.worldObj.getBlock(var1, var5, var6);

                if (var8 != null && var8 != Blocks.water && var8 != Blocks.flowing_water)
                {
                    return false;
                }
            }

            return true;
        }
    }

    public float getMountHeight()
    {
        return this.height/2;
    }
    
    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
        	 this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountHeight() + this.riddenByEntity.getYOffset(), this.posZ);
        }
    }

    private boolean FindFish(int var1)
    {
        if (this.isSitting())
        {
            return false;
        }
        else
        {
            List var2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(1.0D, 0.0D, 1.0D));

            if (var2 != null)
            {
                for (int var3 = 0; var3 < var2.size(); ++var3)
                {
                    if (var2.get(var3) instanceof EntityItem)
                    {
                        EntityItem var4 = (EntityItem)var2.get(var3);

                        if (var4.getEntityItem().getItem() == Items.fish || var4.getEntityItem().getItem() == Items.cooked_fished)
                        {
                            this.increaseHunger(10);
                            this.worldObj.playSoundAtEntity(this, "random.pop", 0.2F, (((new Random()).nextFloat() - (new Random()).nextFloat()) * 0.7F + 1.0F) * 2.0F);
                            var4.setDead();
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    /*protected void jump()
    {
        if (this.isInWater() && this.isCollidedHorizontally && this.riddenByEntity == null)
        {
            super.jump();
        }
    }*/

    /**
     * Checks if this entity is inside water (if inWater field is true as a result of handleWaterMovement() returning
     * true)
     */
    public boolean isInWater()
    {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.4000000059604645D, 0.0D).contract(0.001D, 0.001D, 0.001D), Material.water, this);
    }

    public float HandleRiding(float Speed, float SpeedBoosted)
    {
        /*if (this.RushTick > 0)
        {
            --this.RushTick;
        }

        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayerSP)
        {
            if (this.onGround || this.isInWater())
            {
                if (((EntityPlayerSP)this.riddenByEntity).movementInput.jump)
                {
                    this.jump();
                    ((EntityPlayerSP)this.riddenByEntity).movementInput.jump = false;
                }

                for (this.rotationYaw -= ((EntityPlayerSP)this.riddenByEntity).movementInput.moveStrafe * 5.0F; this.rotationYaw < -180.0F; this.rotationYaw += 360.0F)
                {
                    ;
                }

                while (this.rotationYaw >= 180.0F)
                {
                    this.rotationYaw -= 360.0F;
                }

                this.moveForward = ((EntityPlayerSP)this.riddenByEntity).movementInput.moveForward * this.moveSpeed;
            }

            if (((EntityPlayerSP)this.riddenByEntity).movementInput.sneak)
            {
                this.TargetY = (float)this.posY - 0.5F;
            }
            else if (this.isOnSurface())
            {
                this.TargetY = (float)this.posY;
            }
            else if (((EntityPlayerSP)this.riddenByEntity).movementInput.moveForward == 0.0F)
            {
                this.TargetY = (float)this.posY + 0.2F;
            }
            else
            {
                this.TargetY = (float)this.posY;
            }
        }*/
        if (this.RiderForward > 0)
        {
            Speed += (this.getAIMoveSpeed() * (this.isInWater() ? 3.2F : 1.3F) - Speed) * 0.1F * this.RiderForward;
        }
        else if (Speed > 0)
        {
            Speed += (this.getAIMoveSpeed() * (this.isInWater() ? 3.2F : 1.3F) - Speed) * 0.4F * this.RiderForward; //Break faster

            if (Speed < 0)
            {
                Speed = 0;
            }
        }
        else
        {
            Speed += (this.getAIMoveSpeed() * (this.isInWater() ? 3.2F : 1.3F) - Speed) * 0.06F * this.RiderForward;
        }

        this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw - (this.isInWater() ? this.RiderStrafe * 2.0F : this.RiderStrafe * 5.0F));

        if (this.isInWater())
        {
            if (this.RiderJump)
            {
                this.motionY += (0.4F - this.motionY) * 0.1F;
            }
            else if (this.RiderSneak)
            {
                this.motionY += (-0.4F - this.motionY) * 0.1F;
            }
            else
            {
                this.motionY += this.motionY < 0 ? 0.01F : -0.01F;    //Make the upwards motion slower
            }
/*
            if ((this.isOnSurface() && this.motionY > 0F) || (this.motionY > -0.01F && this.motionY < 0.01F))
            {
                this.motionY = 0.0F;
            }

            if (this.RiderJump && this.isOnSurface())
            {
                this.jump();
            }
            */
        }
        else
        {
            if (this.RiderJump)
            {
                this.getJumpHelper().setJumping();
                this.RiderJump = false;
            }
        }

        this.moveEntityWithHeading(0.0F, Speed + Speed * (0.3F + 0.85F * MathHelper.sin(SpeedBoosted * (float)Math.PI)));
        //this.posY+=this.motionY;
        return Speed;
    }

    /**
     * Applies a velocity to each of the entities pushing them away from each other. Args: entity
     */
    public void applyEntityCollision(Entity var1)
    {
        if (var1 instanceof EntityLiving && !(var1 instanceof EntityPlayer) && this.riddenByEntity != null && this.onGround)
        {
            this.onKillEntity((EntityLiving)var1);
            ((EntityLiving)var1).attackEntityFrom(DamageSource.causeMobDamage(this), 10);
        }
        else
        {
            if (!this.isInWater())
            {
                super.applyEntityCollision(var1);
            }
        }
    }

    /**
     * This method gets called when the entity kills another one.
     */
    public void onKillEntity(EntityLiving var1)
    {
        super.onKillEntity(var1);

        if (var1 instanceof EntityNautilus)
        {
            this.increaseHunger(100);
        }

        if (Fossil.FossilOptions.Heal_Dinos)
        {
            this.heal(5);
        }
    }

    public void SetOrder(EnumOrderType var1)
    {
        this.setPathToEntity((PathEntity)null);
        this.setTarget((Entity)null);
        this.OrderStatus = var1;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1)
    {
    	EntityPlesiosaur baby = new EntityPlesiosaur(this.worldObj);
    	baby.setSubSpecies(this.getSubSpecies());
    	return baby;
    }
    
    /**
     * This gets called when a dinosaur grows naturally or through Chicken Essence.
     */
    @Override
    public void updateSize()
    {
        double healthStep;
        double attackStep;
        double speedStep;
        healthStep = (this.maxHealth - this.baseHealth) / (this.adultAge + 1);
        attackStep = (this.maxDamage - this.baseDamage) / (this.adultAge + 1);
        speedStep = (this.maxSpeed - this.baseSpeed) / (this.adultAge + 1);
        
        
    	if(this.getDinoAge() <= this.adultAge){
	        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Math.round(this.baseHealth + (healthStep * this.getDinoAge())));
	        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(Math.round(this.baseDamage + (attackStep * this.getDinoAge())));
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.baseSpeed + (speedStep * this.getDinoAge()));
	
	        if (this.isTeen()) {
	        	this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5D);
	        }
	        else if (this.isAdult()){
	            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(2.0D);
	        }
	        else {
	            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
	        }
    	}
    }

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readSpawnData(ByteBuf additionalData) {
		// TODO Auto-generated method stub
		
	}
}