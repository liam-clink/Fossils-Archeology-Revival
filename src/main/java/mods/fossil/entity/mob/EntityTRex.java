package mods.fossil.entity.mob;

import io.netty.buffer.ByteBuf;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.client.gui.GuiPedia;
import mods.fossil.fossilAI.*;
import mods.fossil.fossilEnums.EnumDinoType;
import mods.fossil.handler.FossilAchievementHandler;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class EntityTRex extends EntityDinosaur
{
    private static float health = 10;
    public final int Areas = 15;
    //public final float HuntLimit = (float)this.getHungerLimit() * 0.8F;
    private boolean looksWithInterest;
    /*private float field_25048_b;
    private float field_25054_c;
    private boolean field_25052_g;*/
    public boolean Screaming;
    public int SkillTick = 0;
    public int WeakToDeath = 0;
    public int TooNearMessageTick = 0;
    public boolean SneakScream = false;
    //private final BlockBreakingRule blockBreakingBehavior;
    final EntityAIControlledByPlayer aiControlledByPlayer;
	private int Timer;
	private final String texturePath;
    
    public static final double baseHealth = EnumDinoType.TRex.Health0;
    public static final double baseDamage = EnumDinoType.TRex.Strength0;
    public static final double baseSpeed = EnumDinoType.TRex.Speed0;
    
    public static final double maxHealth = EnumDinoType.TRex.HealthMax;
    public static final double maxDamage = EnumDinoType.TRex.StrengthMax;
    public static final double maxSpeed = EnumDinoType.TRex.SpeedMax;
    
    public EntityTRex(World var1)
    {
        super(var1, EnumDinoType.TRex);
        //this.blockBreakingBehavior = new BlockBreakingRule(this.worldObj, this, 5.0F);
        this.looksWithInterest = false;
        this.updateSize();
        /*
         * EDIT VARIABLES PER DINOSAUR TYPE
         */
        this.adultAge = EnumDinoType.TRex.AdultAge;
        // Set initial size for hitbox. (length/width, height)
        this.setSize(1.5F, 1.25F);
        // Size of dinosaur at day 0.
        this.minSize = 1.0F;
        // Size of dinosaur at age Adult.
        this.maxSize = 4.5F;
        
    	if(Fossil.FossilOptions.TRexFeathers)
            texturePath = Fossil.modid + ":textures/mob/" + this.SelfType.toString() + "/feathered/" + "Feathered_";
    	else
    		texturePath = Fossil.modid + ":textures/mob/" + this.SelfType.toString() + "/";
        
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new DinoAIAttackOnCollide(this, 1.3D, true));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0F, 10.0F, 2.0F));
        this.tasks.addTask(4, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(4, new DinoAIEat(this, 60));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new DinoAITargetNonTamedExceptSelfClass(this, EntityLiving.class, 750, false));
        tasks.addTask(1, new DinoAIRideGround(this, 1)); // mutex all
        this.tasks.addTask(2, this.aiControlledByPlayer = new EntityAIControlledByPlayer(this, 0.3F));

        this.targetTasks.addTask(5, new DinoAIHunt(this, EntityLiving.class, 200, false));
        
        //this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    @Override
    public boolean isAIEnabled()
    {
        return !this.isModelized() && !this.isWeak();
    }
    
    /**
     * Return the AI task for player control.
     */
    public EntityAIControlledByPlayer getAIControlledByPlayer()
    {
        return this.aiControlledByPlayer;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(baseHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
    }

    /*
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    
    public boolean getCanSpawnHere()
    {
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    /*
     * Called to update the entity's position/logic.
     */
    
    public void onUpdate()
    {
        super.onUpdate();
    }

    public void moveEntityWithHeading(float par1, float par2)
    {
    	super.moveEntityWithHeading(par1, par2);
    	if(this.isWeak()) {
            this.motionX *= 0.0D;
            this.motionZ *= 0.0D;
            this.rotationPitch = this.rotationYaw = 0;
    	}
    }
    
    /**
     * Applies a velocity to each of the entities pushing them away from each other. Args: entity
     */
    
   /*
    public void applyEntityCollision(Entity var1)
    {
        if (var1 instanceof EntityLiving && !(var1 instanceof EntityPlayer) && this.getHunger() < this.SelfType.MaxHunger / 2 && this.onGround && this.getDinoAge() > 3)
        {
            ((EntityLiving)var1).attackEntityFrom(DamageSource.causeMobDamage(this), 10);
        }
    }
    */

    

    public float getEyeHeight()
    {
        return 2.0F + (float)this.getDinoAge() / 1.8F;
    }

    public float getRideHeight()
    {
        return this.getEyeHeight() + 0.2F;
    }
    /*
        /**
         * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
         * use in wolves.
         */
    public int getVerticalFaceSpeed()
    {
        return 50;
    }
    
    @SideOnly(Side.CLIENT)
    public int getTimer()
    {
        return this.Timer;
    }
    
    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte par1)
    {
        if (par1 == 4)
        {
        	this.Timer = 20;
        }

    }
    
    @Override
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
    	if(this.isModelized())
    		return null;
    	if(this.isWeak())
    	return Fossil.modid + ":" + this.SelfType.toString().toLowerCase() + "_weak";
    	
        return Fossil.modid + ":" + this.SelfType.toString().toLowerCase() + "_living";
    }

    /**
     * Disables a mob's ability to move on its own while true.
     */
    protected boolean isMovementCeased()
    {
        return this.isSitting() || this.isWeak();// || this.field_25052_g;
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float var2)
    {
    	if (this.isModelized())
    	{
            return super.attackEntityFrom(damageSource, var2);
    	}
    	
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else
        {
            Entity entity = damageSource.getEntity();

            if (damageSource.damageType.equals("arrow") && this.getDinoAge() >= 3)
            {
                return false;
            }
           
            if (var2 < 6 && entity != null && this.getDinoAge() >= 3)
            {
                return false;
            }
        }
        return super.attackEntityFrom(damageSource, var2);
    }

    public boolean isAngry()
    {
        return true;
    }
    
    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        return (this.isAngry() && !this.isTamed() && !this.isWeak()) ? this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D) : null;
    }

    @Override
    public boolean attackEntityAsMob(Entity victim)
    {
    	Random random = new Random();
        float attackDamage = (float) getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        int knockback = 0;

        if (victim instanceof EntityLivingBase)
        {
            attackDamage += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase) victim);
            knockback += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) victim);
        }
        boolean attacked = victim.attackEntityFrom(DamageSource.causeMobDamage(this), attackDamage);
        
        if (random.nextInt(10) == 1)
        	this.openMouth(true);
        
        if (attacked)
        {
            if (knockback > 0)
            {
                double vx = -Math.sin(Math.toRadians(rotationYaw)) * knockback * 0.5;
                double vy = 0.1;
                double vz = Math.cos(Math.toRadians(rotationYaw)) * knockback * 0.5;
                victim.addVelocity(vx, vy, vz);
                motionX *= 0.6;
                motionZ *= 0.6;
            }

            setLastAttacker(victim);
        }

        return attacked;
    }
    
    public void openMouth(boolean shouldScream)
    {
    	this.Timer = 20;
    	this.worldObj.setEntityState(this, (byte)4);
    	
    	if(shouldScream)
        this.worldObj.playSoundAtEntity(this, Fossil.modid + ":" + "trex_scream", this.getSoundVolume(), this.getSoundPitch());
    }
    
    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity entity, float var2)
    {
    	super.attackEntity(entity, var2);
    }

    /**
     * This method gets called when the entity kills another one.
     */
    @Override
    public void onKillEntity(EntityLivingBase var1)
    {
    	this.openMouth(true);
        super.onKillEntity(var1);

        
    }
    
    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemStack = player.inventory.getCurrentItem();

        if (itemStack != null)
        {
            if (itemStack.getItem() == Fossil.gem)
            {
                if (this.isWeak() && !this.isTamed())
                {
                	player.triggerAchievement(FossilAchievementHandler.TheKing);
                    this.heal(200);
                    this.increaseHunger(500);
                    this.setTamed(true);
                    setPathToEntity(null);
                    setAttackTarget(null);
                    this.setOwner(player.getUniqueID().toString());
                    this.setOwnerDisplayName(player.getCommandSenderName());
                    --itemStack.stackSize;

                    if (itemStack.stackSize <= 0)
                    {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
                    }

                    return true;
                }
                else
                {
                    if (!this.isWeak())
                    {
                        if (!this.worldObj.isRemote)
                        {
                            Fossil.ShowMessage(StatCollector.translateToLocal(LocalizationStrings.STATUS_GEM_ERROR_HEALTH), player);
                        }
                    }

                    if (!this.isAdult())
                    {
                        if (!this.worldObj.isRemote)
                        {
                            Fossil.ShowMessage(StatCollector.translateToLocal(LocalizationStrings.STATUS_GEM_ERROR_YOUNG), player);
                        }
                    }

                    return false;
                }
            }
            
            if (this.SelfType.FoodItemList.CheckItem(itemStack.getItem()) || this.SelfType.FoodBlockList.CheckBlock(Block.getBlockFromItem(itemStack.getItem())))
            {
            	return false;
            }

            if (!Fossil.DebugMode())
            {
                if (itemStack.getItem() == Fossil.chickenEss)
                {
                    if (!this.worldObj.isRemote)
                    {
                        Fossil.ShowMessage(StatCollector.translateToLocal(LocalizationStrings.STATUS_ESSENCE_FAIL), player);
                        return true;
                    }
                }
            }
        }

        return super.interact(player);
    }

    public boolean CheckSpace()
    {
        return !this.isEntityInsideOpaqueBlock();
    }

    public float getMountHeight()
    {
        return this.height;
    }
    
    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
        	 this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountHeight() + this.riddenByEntity.getYOffset(), this.posZ);
        }
    }

    /*
    private void Flee(Entity var1, int var2)
    {
        int var3 = (new Random()).nextInt(var2) + 1;
        int var4 = (int)Math.round(Math.sqrt(Math.pow((double)var2, 2.0D) - Math.pow((double)var3, 2.0D)));
        boolean var5 = false;
        int var6 = 0;
        boolean var7 = false;
        boolean var8 = false;
        boolean var9 = true;
        boolean var10 = true;
        boolean var11 = true;
        float var12 = -99999.0F;
        int var14;

        if (var1.posX <= this.posX)
        {
            var14 = (int)Math.round(this.posX) + var3;
        }
        else
        {
            var14 = (int)Math.round(this.posX) - var3;
        }

        int var15;

        if (var1.posZ <= this.posZ)
        {
            var15 = (int)Math.round(this.posZ) + var4;
        }
        else
        {
            var15 = (int)Math.round(this.posZ) - var4;
        }

        for (int var13 = 128; var13 > 0; --var13)
        {
            if (!this.worldObj.isAirBlock(var14, var13, var15))
            {
                var6 = var13;
                break;
            }
        }

        this.setTamed(false);
        this.setOwner("");
        this.setPathToEntity(this.worldObj.getEntityPathToXYZ(this, var14, var6, var15, (float)var2, true, false, true, false));
    }
    */
    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        
        if (this.Timer > 0)
        {
            --this.Timer;
        }
        /*
        if (!this.worldObj.isRemote)
        {
            this.Timer = Math.max(0, this.Timer - 1);
            

            this.Screaming = this.Timer > 0 ? true :false;
            }
            */
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

        if (this.isWeak())
        {
            switch (this.getSubSpecies())
            {
            case 1:
            	return texturePath + "TRex_Green_Weak.png";
            default:
            	return texturePath + "TRex_Weak.png";
            }
        }

        if (this.isAdult() && !this.isTamed())
        {
            switch (this.getSubSpecies())
            {
            case 1:
            	return texturePath + "TRex_Green_Adult.png";
            default:
            	return texturePath + "TRex_Adult.png";
            }
        }
        
        switch (this.getSubSpecies())
        {
        case 1:
        	return texturePath + "TRex_Green_Tame.png";
        default:
        	return texturePath + "TRex_Tame.png";
        }
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    /*
    protected void jump()
    {
        if (!this.isInWater())
        {
            if (this.riddenByEntity != null)
            {
                this.motionY += 0.6299999803304672D;
            }
            else
            {
                super.jump();
            }
        }
        else if (!this.onGround)
        {
            this.motionY -= 0.1D;
        }
    }
    */

    /**
     * Check if the dinosaur is in a weakened state.
     * @return
     */
    public boolean isWeak()
    {
        return (this.getHealth() < 8) && (this.getDinoAge() >= this.adultAge) && !this.isTamed();
        //return false;//this.getHealthData() < 8 && this.getDinoAge()>8 && !this.isTamed();
    }

    private void HandleWeak()
    {
        if (!this.worldObj.isRemote)
        {
            ++this.WeakToDeath;

            if (this.WeakToDeath >= 200)
            {
                this.attackEntityFrom(DamageSource.generic, 10);
            }
            else
            {
                this.setTarget((Entity)null);
                this.setPathToEntity((PathEntity)null);
                this.setAngry(false);
            }
        }
    }
    public void ShowPedia(GuiPedia p0)
    {
        super.ShowPedia(p0);

        if (this.isWeak())
        {
            p0.AddStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_TEXT_WEAK), true, 255, 40, 90);
        }

        if (!this.isWeak() && !this.isTamed()  && this.isAdult())
        {
            p0.AddStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_TEXT_CAUTION), true, 255, 40, 90);
        }
    }

    public EntityTRex spawnBabyAnimal(EntityAgeable var1)
    {
        return new EntityTRex(this.worldObj);
    }

    /**
     * This method returns a value to be applied directly to entity speed, this factor is less than 1 when a slowdown
     * potion effect is applied, more than 1 when a haste potion effect is applied and 2 for fleeing entities.
     */
    /*
    public float getSpeedModifier()
    {
        float var1 = 1.0F;

        if (this.IsHungry() || (attackingPlayer != null))
        {
            var1 *=1.5F;
        }
        else if (this.getDinoAge() < 3)
        {
    //           var1 = super.getSpeedModifier();

            if (this.fleeingTick > 0)
            {
                var1 *= 3.0F;
            }
        }
        else if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayerSP)
        {
            EntityPlayerSP var2 = (EntityPlayerSP)this.riddenByEntity;

            if (var2.movementInput.sneak)
            {
                var1 = 5.0F;
            }
        }

        return var1;
    }
    */
    /*
    public int BlockInteractive()
    {
        int destroyed=0;
        for (int var1 = (int)Math.round(this.boundingBox.minX) - 1; var1 <= (int)Math.round(this.boundingBox.maxX) + 1; ++var1)
        {
            for (int var2 = (int)Math.round(this.boundingBox.minY); var2 <= (int)Math.round(this.boundingBox.maxY); ++var2)
            {
                for (int var3 = (int)Math.round(this.boundingBox.minZ) - 1; var3 <= (int)Math.round(this.boundingBox.maxZ) + 1; ++var3)
                {
                    if (!this.worldObj.isAirBlock(var1, var2, var3))
                    {
                        int var4 = this.worldObj.getBlockId(var1, var2, var3);

                        if (!this.inWater)
                        {
                            if ((double)Block.blocksList[var4].getBlockHardness(this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ) < 5.0D)
                            {
                                if ((new Random()).nextInt(10) < 2)
                                {
                                    Block.blocksList[var4].dropBlockAsItem(this.worldObj, var1, var2, var3, 1, 0);
                                }

                                this.worldObj.setBlock(var1, var2, var3, 0);
                                destroyed++;
                                //this.RushTick = 10;
                            }
                        }
                    }
                }
            }
        }
        return destroyed;
    }
    */
    
    @Override
    public EntityAgeable createChild(EntityAgeable var1)
    {
    	EntityTRex baby = new EntityTRex(this.worldObj);
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
