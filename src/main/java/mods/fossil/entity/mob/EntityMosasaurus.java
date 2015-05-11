package mods.fossil.entity.mob;

import io.netty.buffer.ByteBuf;

import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.AI.FossilAIWildIndividualBase;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.fossilAI.WaterDinoAIAttack;
import mods.fossil.fossilAI.WaterDinoAIEat;
import mods.fossil.fossilAI.WaterDinoAIHunt;
import mods.fossil.fossilAI.WaterDinoAIWander;
import mods.fossil.fossilEnums.EnumDinoType;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityMosasaurus extends EntitySwimmingDino
{
    private Entity targetedEntity;

    
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private double deltaX;
    private double deltaY;
    private double deltaZ;
    private double length;

    public static final double baseHealth = EnumDinoType.Mosasaurus.Health0;
    public static final double baseDamage = EnumDinoType.Mosasaurus.Strength0;
    public static final double baseSpeed = EnumDinoType.Mosasaurus.Speed0;
    
    public static final double maxHealth = EnumDinoType.Mosasaurus.HealthMax;
    public static final double maxDamage = EnumDinoType.Mosasaurus.StrengthMax;
    public static final double maxSpeed = EnumDinoType.Mosasaurus.SpeedMax;

    public EntityMosasaurus(World par1World)
    {
        super(par1World, EnumDinoType.Mosasaurus);
        /*
         * EDIT VARIABLES PER DINOSAUR TYPE
         */
        this.adultAge = EnumDinoType.Mosasaurus.AdultAge;
        // Set initial size for hitbox. (length/width, height)
        this.setSize(1.5F, 0.6F);
        // Size of dinosaur at day 0.
        this.minSize = 1.2F;
        // Size of dinosaur at age Adult.
        this.maxSize = 3.4F;
        this.experienceValue = 5;
        
        this.getNavigator().setCanSwim(true);
        this.tasks.addTask(6, new EntityAIAttackOnCollide(this, 1, true));
        this.tasks.addTask(7, new WaterDinoAIWander(this, 1.0D));
        this.tasks.addTask(3, new WaterDinoAIAttack(this, 0.009D)); // This is a multiplier! Large numbers do not work here. 0.022 is very fast as it is.
        this.tasks.addTask(5, new WaterDinoAIEat(this, 50, 0.002D));
        this.targetTasks.addTask(5, new WaterDinoAIHunt(this, EntityLiving.class, 50, false, 0.003D));
    }

    public boolean canBreatheUnderwater()
    {
        return true;
    }
    public void onLivingUpdate()
	{
		breakBlock(5);
		super.onLivingUpdate();
	}
    public String getTexture()
    {
        if (this.isModelized())
        {
            return super.getModelTexture();
        }

        switch (this.getSubSpecies())
        {
        case 1: 
            return "fossil:textures/mob/Mosasaur_Blue.png";

        case 2: default:
        	return "fossil:textures/mob/Mosasaur_Green.png";
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
    	
    	if(!this.isInWater())
        return Fossil.modid + ":" + "mosasaurus_living";
    	else
    	return Fossil.modid + ":" + "mosasaurus_outside";	
    }

    @Override
    public String getAttackSound()
    {
    	if(this.isModelized())
    		return null;
    	
    	return Fossil.modid + ":" + this.SelfType.toString().toLowerCase() + "_attack";
    }
    
    /**
     * Returns true if the Entity AI code should be run
     *
     * Overriding because Mosasaur are dumb.
     */
    @Override
    public boolean isAIEnabled()
    {
        return !this.isModelized();
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
    {
        return super.attackEntityFrom(par1DamageSource, par2);
    }

    /**
     * Called by a player entity when they collide with an entity
     */
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
    {
    	if(!this.isModelized()) {
	        if (par1EntityPlayer.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue() + 1)))
	        {
	            this.playSound("mob.attack", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
	        }
    	}
    }

    protected void entityInit()
    {
        super.entityInit();
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(baseHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
    }

    @Override
    public boolean attackEntityAsMob(Entity victim)
    {
        float attackDamage = (float) getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        int knockback = 0;

        if (victim instanceof EntityLivingBase)
        {
            attackDamage += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase) victim);
            knockback += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) victim);
        }

        boolean attacked = victim.attackEntityFrom(DamageSource.causeMobDamage(this), attackDamage);

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

            if (victim instanceof EntityLivingBase)
            {
                //EnchantmentThorns.func_92096_a(this, (EntityLivingBase) victim, rand);
            }

            setLastAttacker(victim);
        }

        return attacked;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 1.0F;
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.rand.nextInt(20) == 0 && super.getCanSpawnHere() && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }
    
    public EntityMosasaurus spawnBabyAnimal(EntityAnimal var1)
    {
        return new EntityMosasaurus(this.worldObj);
    }
    
    public boolean interact(EntityPlayer var1)
    {
        ItemStack var2 = var1.inventory.getCurrentItem();

        if (var2 != null)
        {
            if (!Fossil.DebugMode())
            {
                if (var2.getItem() == Fossil.chickenEss)
                {
                    if (!this.worldObj.isRemote)
                    {
                        Fossil.ShowMessage(StatCollector.translateToLocal(LocalizationStrings.STATUS_ESSENCE_FAIL), var1);
                        return true;
                    }
                }
            }
        }

        return super.interact(var1);
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
	
    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData)
    {
        par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);
        Random random = new Random();
        this.setSubSpecies(random.nextInt(2) + 1);
        this.setDinoAge(this.SelfType.AdultAge);
        this.updateSize();
        this.heal(200);
        return par1EntityLivingData;
    }
    
    @Override
    public EntityAgeable createChild(EntityAgeable var1)
    {
    	EntityMosasaurus baby = new EntityMosasaurus(this.worldObj);
    	baby.setSubSpecies(this.getSubSpecies());
    	return baby;
    }
}
