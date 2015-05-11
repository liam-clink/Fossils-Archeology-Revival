package mods.fossil.entity.mob;

import io.netty.buffer.ByteBuf;
import mods.fossil.Fossil;
import mods.fossil.fossilAI.DinoAIEat;
import mods.fossil.fossilAI.DinoAIFollowOwner;
import mods.fossil.fossilAI.DinoAIRideGround;
import mods.fossil.fossilAI.DinoAIWander;
import mods.fossil.fossilEnums.EnumDinoType;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityGallimimus extends EntityDinosaur
{
    public boolean isTamed = false;

//    final float PUSHDOWN_HARDNESS = 5.0F;
    //final EntityAIControlledByPlayer aiControlledByPlayer;
    
    public static final double baseHealth = EnumDinoType.Gallimimus.Health0;
    public static final double baseDamage = EnumDinoType.Gallimimus.Strength0;
    public static final double baseSpeed = EnumDinoType.Gallimimus.Speed0;
    
    public static final double maxHealth = EnumDinoType.Gallimimus.HealthMax;
    public static final double maxDamage = EnumDinoType.Gallimimus.StrengthMax;
    public static final double maxSpeed = EnumDinoType.Gallimimus.SpeedMax;

	private final String texturePath;
	
    public EntityGallimimus(World var1)
    {
        super(var1, EnumDinoType.Gallimimus);
        this.updateSize();
        /*
         * EDIT VARIABLES PER DINOSAUR TYPE
         */
        this.adultAge = EnumDinoType.Gallimimus.AdultAge;
        // Set initial size for hitbox. (length/width, height)
        this.setSize(1.0F, 2.0F);
        // Size of dinosaur at day 0.
        this.minSize = 0.5F;
        // Size of dinosaur at age Adult.
        this.maxSize = 2.2F;
        
    	if(!Fossil.FossilOptions.GallimimusFeathers)
            texturePath = Fossil.modid + ":textures/mob/" + this.SelfType.toString() + "/feathered/" + "Feathered_";
    	else
    		texturePath = Fossil.modid + ":textures/mob/" + this.SelfType.toString() + "/";
        
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.2F));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.1D, true));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        tasks.addTask(1, new DinoAIRideGround(this, 1)); // mutex all
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        
        this.tasks.addTask(6, new DinoAIEat(this, 48));
        this.tasks.addTask(7, new DinoAIWander(this, 1.0D));
        
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityTRex.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntitySpinosaurus.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityDilophosaurus.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityDeinonychus.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityMosasaurus.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityLiopleurodon.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityBrachiosaurus.class, 4.0F, 0.8D, 1.33D));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(EnumDinoType.Gallimimus.Speed0);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(EnumDinoType.Gallimimus.Health0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(EnumDinoType.Gallimimus.Strength0);
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
        case 1:
        	return texturePath + "Gallimimus_Green.png";
        case 2:
        	return texturePath + "Gallimimus_LightBlue.png";
        case 3:
        	return texturePath + "Gallimimus_Orange.png";
        case 4:
            default:
                return texturePath + "Gallimimus_Brown.png";
        }
    }
    
    public int getVerticalFaceSpeed()
    {
        return this.isSitting() ? 70 : super.getVerticalFaceSpeed();
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
        //Add special item interaction code here
        return super.interact(var1);
    }

    public EntityGallimimus spawnBabyAnimal(EntityAnimal var1)
    {
        return new EntityGallimimus(this.worldObj);
    }

    public float getEyeHeight()
    {
        return (float)this.getDinoAge() / 3.2F;
    }

    public float getMountHeight()
    {
        return this.height/1.8F;
    }

    public void updateRiderPosition()
    {
    	super.updateRiderPosition();
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountHeight() + this.riddenByEntity.getYOffset(), this.posZ);

          //this.riddenByEntity.setPosition(this.posX, this.posY + (double)this.getHalfHeight(), this.posZ);
        }
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
    public EntityAgeable createChild(EntityAgeable var1)
    {
    	EntityGallimimus baby = new EntityGallimimus(this.worldObj);
    	baby.setSubSpecies(this.getSubSpecies());
    	return baby;
    }

}
