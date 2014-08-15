package mods.fossil.entity.mob;

import io.netty.buffer.ByteBuf;

import java.util.List;

import mods.fossil.fossilAI.DinoAIAttackOnCollide;
import mods.fossil.fossilAI.DinoAIEat;
import mods.fossil.fossilAI.DinoAIFollowOwner;
import mods.fossil.fossilAI.DinoAIRideGround;
import mods.fossil.fossilAI.DinoAIWander;
import mods.fossil.fossilEnums.EnumDinoType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityPachycephalosaurus extends EntityDinosaur
{
    private boolean looksWithInterest;
    /*public final float HuntLimit = (float)this.getHungerLimit() * 0.9F;
    private float field_25048_b;
    private float field_25054_c;
    private boolean isWolfShaking;
    private boolean field_25052_g;
    private float timeWolfIsShaking;
    private float prevTimeWolfIsShaking;
    public int SubSpecies = 1;
    public boolean isBaby = true;*/
    public int RushTick = 0;
    //public int BreedTick = 3000;
    public boolean Running = false;
    private int attackTimer;
    
    public static final double baseHealth = EnumDinoType.Pachycephalosaurus.Health0;
    public static final double baseDamage = EnumDinoType.Pachycephalosaurus.Strength0;
    public static final double baseSpeed = EnumDinoType.Pachycephalosaurus.Speed0;
    
    public static final double maxHealth = EnumDinoType.Pachycephalosaurus.HealthMax;
    public static final double maxDamage = EnumDinoType.Pachycephalosaurus.StrengthMax;
    public static final double maxSpeed = EnumDinoType.Pachycephalosaurus.SpeedMax;

    public EntityPachycephalosaurus(World var1)
    {
        super(var1, EnumDinoType.Pachycephalosaurus);
        this.looksWithInterest = false;
        this.updateSize();
        /*
         * EDIT VARIABLES PER DINOSAUR TYPE
         */
        this.adultAge = EnumDinoType.Pachycephalosaurus.AdultAge;
        // Set initial size for hitbox. (length/width, height)
        this.setSize(1.0F, 1.5F);
        // Size of dinosaur at day 0.
        this.minSize = 0.5F;
        // Size of dinosaur at age Adult.
        this.maxSize = 2.0F;
        
        //AI Tasks
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.0F));
        this.tasks.addTask(4, new DinoAIAttackOnCollide(this, 1.1D, true));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(7, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(7, new DinoAIEat(this, 24));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        tasks.addTask(1, new DinoAIRideGround(this, 1)); // mutex all
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        //this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(baseHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        this.attackTimer = 10;
        this.worldObj.setEntityState(this, (byte)4);
        boolean attacked = entity.attackEntityFrom(DamageSource.causeMobDamage(this), 
        		(float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue());
        
        if (attacked)
        {
	        if (this.rand.nextInt(16) < 8)
	        {
	            this.headButt(entity, this.rand.nextInt(2)+1);
	        }
	        this.setLastAttacker(entity);
        }

        return attacked;
    }

    private void headButt(Entity target, int amount)
    {
    	this.playSound("mob.irongolem.throw", 3.0F, 0.2F);

        int offsetX = target.posX > this.posX ? amount : -amount;
        int offsetZ = target.posZ > this.posZ ? amount : -amount;

        target.motionZ = (double)(offsetZ);
        target.motionZ = (double)(offsetX);
        //target.setVelocity((double)(offsetX), target.motionY, (double)(offsetZ));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return this.riddenByEntity == null;
    }

    public String getTexture()
    {
    	if (this.isModelized())
    	{
    		return super.getTexture();
    	}
    	
        switch (this.getSubSpecies())
        {
            case 1:
                return "fossil:textures/mob/Pachy-Lime.png";

            case 2:
                return "fossil:textures/mob/Pachy-Monochrome.png";

            case 3:
                return "fossil:textures/mob/Pachy-Pumpkin.png";

            default:
                return "fossil:textures/mob/Pachy-Pumpkin.png";
        }
    }
    
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    /*public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        //var1.setInteger("SubSpecies", this.SubSpecies);
        //var1.setBoolean("Angry", this.isSelfAngry());
        //var1.setBoolean("isBaby", this.isBaby);
    }*/

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    /*public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        //this.SubSpecies = var1.getInteger("SubSpecies");
        //this.isBaby = var1.getBoolean("isBaby");
        this.CheckSkin();
        //this.setSelfAngry(var1.getBoolean("Angry"));
        //this.setSelfSitting(var1.getBoolean("Sitting"));
        //this.InitSize();
    }*/

    protected void updateEntityActionState()
    {
        if (this.riddenByEntity == null)
        {
            super.updateEntityActionState();
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        
        if (this.looksWithInterest)
        {
            this.numTicksToChaseTarget = 10;
        }
    }

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

    /**
     * Disables a mob's ability to move on its own while true.
     */
    protected boolean isMovementCeased()
    {
        return this.isSitting();// || this.field_25052_g;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource var1, float var2)
    {
        Entity var3 = var1.getEntity();
        this.setSitting(false);

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
        }
        else if (var3 != this && var3 != null)
        {
            if (this.isTamed() && var3 instanceof EntityPlayer && var3 == this.getOwner())// ((EntityPlayer)var3).username.equalsIgnoreCase(this.getOwnerName()))
            {
                return true;
            }

            this.entityToAttack = var3;
        }

        return super.attackEntityFrom(var1, var2);
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
    
    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte var1)
    {
        if (var1 == 4)
        {
            this.attackTimer = 10;
        }

        if (var1 == 7)
        {
            this.showHeartsOrSmokeFX(true, true);
        }
        else if (var1 == 6)
        {
            this.showHeartsOrSmokeFX(false, false);
        }
        else if (var1 == 8)
        {
            //this.field_25052_g = true;
            //this.timeWolfIsShaking = 0.0F;
            //this.prevTimeWolfIsShaking = 0.0F;
        }
        else
        {
            super.handleHealthUpdate(var1);
        }
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
//            this.moveSpeed = 2.0F;
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -3)));
//            this.moveSpeed = 0.5F;
        }
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    public boolean CheckSpace()
    {
        return !this.isEntityInsideOpaqueBlock();
    }

    public void FaceToCoord(int var1, int var2, int var3)
    {
        double var4 = (double)var1;
        double var6 = (double)var3;
        float var8 = (float)(Math.atan2(var6, var4) * 180.0D / Math.PI) - 90.0F;
        this.rotationYaw = this.updateRotation(this.rotationYaw, var8, 360.0F);
    }

    private float updateRotation(float var1, float var2, float var3)
    {
        float var4;

        for (var4 = var2 - var1; var4 < -180.0F; var4 += 360.0F)
        {
            ;
        }

        while (var4 >= 180.0F)
        {
            var4 -= 360.0F;
        }

        if (var4 > var3)
        {
            var4 = var3;
        }

        if (var4 < -var3)
        {
            var4 = -var3;
        }

        return var1 + var4;
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
            super.applyEntityCollision(var1);
        }
    }

    public EntityPachycephalosaurus spawnBabyAnimal(EntityAgeable var1)
    {
        return new EntityPachycephalosaurus(this.worldObj);
    }

    /*public float getGLX()
    {
        return (float)(1.5D + 0.3D * (double)this.getDinoAge());
    }

    public float getGLY()
    {
        return (float)(1.5D + 0.3D * (double)this.getDinoAge());
    }*/

    /*public EntityAgeable func_90011_a(EntityAgeable var1)
    {
        return this.spawnBabyAnimal(var1);
    }*/

    @SideOnly(Side.CLIENT)
    public int getAttackTimer()
    {
        return this.attackTimer;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1)
    {
    	EntityPachycephalosaurus baby = new EntityPachycephalosaurus(this.worldObj);
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
