package mods.fossil.entity.mob;

import io.netty.buffer.ByteBuf;

import java.util.Vector;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.client.gui.GuiPedia;
import mods.fossil.fossilAI.DinoAIAttackOnCollide;
import mods.fossil.fossilAI.DinoAIEat;
import mods.fossil.fossilAI.DinoAIFollowOwner;
import mods.fossil.fossilAI.DinoAIHunt;
import mods.fossil.fossilAI.DinoAIWander;
import mods.fossil.fossilEnums.EnumDinoType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityVelociraptor extends EntityDinosaur
{
    private boolean looksWithInterest;

    public int LearningChestTick = 900;
    public boolean PreyChecked = false;
    public boolean SupportChecked = false;
    public Vector MemberList = new Vector();
    
    public static final double baseHealth = EnumDinoType.Velociraptor.Health0;
    public static final double baseDamage = EnumDinoType.Velociraptor.Strength0;
    public static final double baseSpeed = EnumDinoType.Velociraptor.Speed0;
    
    public static final double maxHealth = EnumDinoType.Velociraptor.HealthMax;
    public static final double maxDamage = EnumDinoType.Velociraptor.StrengthMax;
    public static final double maxSpeed = EnumDinoType.Velociraptor.SpeedMax;
    
    public EntityVelociraptor(World var1)
    {
        super(var1, EnumDinoType.Velociraptor);
        this.looksWithInterest = false;
        this.updateSize();
        /*
         * EDIT VARIABLES PER DINOSAUR TYPE
         */
        this.adultAge = EnumDinoType.Velociraptor.AdultAge;
        // Set initial size for hitbox. (length/width, height)
        this.setSize(1.5F, 1.5F);
        // Size of dinosaur at day 0.
        this.minSize = 0.25F;
        // Size of dinosaur at age Adult.
        this.maxSize = 0.6F;
        
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityTRex.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntitySpinosaurus.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityBrachiosaurus.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(3, new DinoAIAttackOnCollide(this, 1.2D, true));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0F, 10.0F, 2.0F));
        this.tasks.addTask(6, new DinoAIEat(this, 60));
        this.tasks.addTask(7, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        //this.targetTasks.addTask(2, new DinoAITargetNonTamedExceptSelfClass(this, EntityLiving.class, 750, false));
        
        this.targetTasks.addTask(5, new DinoAIHunt(this, EntityLiving.class, 500, false));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(baseHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
    }

    /*protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(24, new Byte((byte)0));
    }*/

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    /**
     * Returns the texture's file path as a String.
     */
    public String getTexture()
    {
        if (this.isModelized())
        {
            return super.getModelTexture();
        }

        if (this.isAdult())
        {
            switch (this.getSubSpecies())
            {
                case 1:
                    return Fossil.modid + ":textures/mob/Velociraptor_Blue_Adult.png";

                case 2:
                    return Fossil.modid + ":textures/mob/Velociraptor_Green_Adult.png";

                case 3:
                    return Fossil.modid + ":textures/mob/Velociraptor_River_Adult.png";

                default:
                    return Fossil.modid + ":textures/mob/Velociraptor_Brown_Adult.png";
            }
        }

        switch (this.getSubSpecies())
        {
            case 1:
                return Fossil.modid + ":textures/mob/Velociraptor_Blue_Baby.png";

            case 2:
                return Fossil.modid + ":textures/mob/Velociraptor_Green_Baby.png";

            case 3:
                return Fossil.modid + ":textures/mob/Velociraptor_River_Baby.png";

            default:
                return Fossil.modid + ":textures/mob/Velociraptor_Brown_Baby.png";
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
        return this.isTamed() ? Fossil.modid + ":" + "velociraptor_living_tame" : Fossil.modid + ":" + "velociraptor_living_wild";
    }
    
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        var1.setInteger("LearningChestTick", this.LearningChestTick);
        /*if (this.ItemInMouth != null)
        {
            var1.setShort("Itemid", (short)this.ItemInMouth.itemID);
            var1.setByte("ItemCount", (byte)this.ItemInMouth.stackSize);
            var1.setShort("ItemDamage", (short)this.ItemInMouth.getItemDamage());
        }
        else
        {
            var1.setShort("Itemid", (short) - 1);
            var1.setByte("ItemCount", (byte)0);
            var1.setShort("ItemDamage", (short)0);
        }*/
        //var1.setBoolean("Angry", this.isSelfAngry());
        //var1.setBoolean("Sitting", this.isSelfSitting());
        //var1.setInteger("SubType", this.getSubSpecies());
        //this.isSelfAngry()
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        this.LearningChestTick = var1.getInteger("LearningChestTick");
        /*short var2 = var1.getShort("Itemid");
        byte var3 = var1.getByte("ItemCount");
        short var4 = var1.getShort("ItemDamage");

        if (var2 != -1)
        {
            this.ItemInMouth = new ItemStack(var2, var3, var4);
        }
        else
        {
            this.ItemInMouth = null;
        }*/
        //this.setSelfAngry(var1.getBoolean("Angry"));
        //this.setSelfSitting(var1.getBoolean("Sitting"));
        /*if (var1.hasKey("SubType"))
        {
            this.setSubSpecies(var1.getInteger("SubType"));
        }*/
        // this.InitSize();
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        /*this.field_25054_c = this.field_25048_b;

        if (this.looksWithInterest)
        {
            this.field_25048_b += (1.0F - this.field_25048_b) * 0.4F;
        }
        else
        {
            this.field_25048_b += (0.0F - this.field_25048_b) * 0.4F;
        }

        if (this.looksWithInterest)
        {
            this.numTicksToChaseTarget = 10;
        }*/
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
        boolean var4 = false;

        if (var3 != null && !(var3 instanceof EntityPlayer) && !(var3 instanceof EntityArrow))
        {
            var2 = (var2 + 1) / 2;
        }

        if (super.attackEntityFrom(var1, var2))
        {
            if (!this.isAngry())
            {
                if (var3 instanceof EntityPlayer)
                {
                    this.setTamed(false);
                  //  this.setOwner("");
                    this.ItemInMouth = null;
                    this.PreyChecked = true;
                    var4 = true;
                }

                if (var3 instanceof EntityArrow && ((EntityArrow)var3).shootingEntity != null)
                {
                    var3 = ((EntityArrow)var3).shootingEntity;
                }

                if (var3 instanceof EntityLiving)
                {
                    this.setAttackTarget((EntityLiving)var3);
                }
            }
            else if (var3 != this && var3 != null)
            {
                this.entityToAttack = var3;
            }

            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        return null;
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    /*
    protected void attackEntity(Entity var1, float var2)
    {
        if (var1.isDead)
        {
            this.setAttackTarget((EntityLiving)null);
        }

        if (var2 > 2.0F && var2 < 5.0F && this.rand.nextInt(10) == 0)
        {
            if (this.onGround)
            {
                double var3 = var1.posX - this.posX;
                double var5 = var1.posZ - this.posZ;
                float var7 = MathHelper.sqrt_double(var3 * var3 + var5 * var5);
                this.motionX = var3 / (double)var7 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
                this.motionZ = var5 / (double)var7 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
                this.worldObj.playSoundAtEntity(this, "Raptor_attack", this.getSoundVolume() * 2.0F, 1.0F);
                this.jump();
            }
        }
        else if ((double)var2 < 1.899999976158142D && var1.boundingBox.maxY > this.boundingBox.minY && var1.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 20;
            var1.attackEntityFrom(DamageSource.causeMobDamage(this), 2 + this.getDinoAge());
        }
    }
    */
    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
        ItemStack var2 = var1.inventory.getCurrentItem();

        if (var2 != null)
        {
            if (var2.getItem().getItemUseAction(var2) == EnumAction.bow)
            {
                return false;
            }
        }

        return super.interact(var1);
    }

    public void handleHealthUpdate(byte var1)
    {
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

    /*public boolean isSelfSitting()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }*/

    /*public void setSelfSitting(boolean var1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if (var1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 1)));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -2)));
        }
    }

    public void setTamed(boolean var1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if (var1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 4)));
        }
        else
        {
            this.ItemInMouth = null;
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -5)));
        }
    }*/

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    /*
    protected void fall(float var1)
    {
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.fallDistance = var1;
        }

        int var2 = (int)Math.ceil((double)(var1 - 3.0F));

        if (var2 > 0)
        {
            this.attackEntityFrom(DamageSource.fall, 0);
            int var3 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY - 0.20000000298023224D - (double)this.yOffset), MathHelper.floor_double(this.posZ));

            if (this.worldObj.isRemote)
            {
                return;
            }

            if (var3 > 0)
            {
                StepSound var4 = Block.blocksList[var3].stepSound;
                this.worldObj.playSoundAtEntity(this, var4.getBreakSound(), var4.getVolume() * 0.5F, var4.getPitch() * 0.75F);
            }
        }
    }
    */
    /**
     * Time remaining during which the Animal is sped up and flees.
     */
    /*
    protected void updateWanderPath()
    {
        boolean var1 = false;
        int var2 = -1;
        int var3 = -1;
        int var4 = -1;
        float var5 = -99999.0F;
        EnumOrderType var10001 = this.OrderStatus;

        if (this.OrderStatus == EnumOrderType.FreeMove || !this.isTamed())
        {
            for (int var6 = 0; var6 < 10; ++var6)
            {
                int var7 = MathHelper.floor_double(this.posX + (double)this.rand.nextInt(13) - 6.0D);
                int var8 = MathHelper.floor_double(this.posY + (double)this.rand.nextInt(7) - 3.0D);
                int var9 = MathHelper.floor_double(this.posZ + (double)this.rand.nextInt(13) - 6.0D);
                float var10 = this.getBlockPathWeight(var7, var8, var9);

                if (var10 > var5)
                {
                    var5 = var10;
                    var2 = var7;
                    var3 = var8;
                    var4 = var9;
                    var1 = true;
                }
            }

            if (var1)
            {
                this.setPathToEntity(this.worldObj.getEntityPathToXYZ(this, var2, var3, var4, 10.0F, true, false, true, false));
            }
        }
    }
    */

    /* private void InitSize()
     {
         this.CheckSkin();
         this.updateSize();
         this.setPosition(this.posX, this.posY, this.posZ);
     }

     public void updateSize()
     {
     	this.setSize((float)(0.30000001192092896D + 0.1D * (double)((float)this.getAge())), (float)(0.30000001192092896D + 0.1D * (double)((float)this.getAge())));
     }*/

    /*public boolean HandleEating(int var1)
    {
        if (this.getHunger() >= this.getHungerLimit())
        {
            return false;
        }
        else
        {
            this.increaseHunger(var1);
            this.showHeartsOrSmokeFX(false);

            if (this.getHunger() >= this.getHungerLimit())
            {
                this.setHunger(this.getHungerLimit());
            }

            return true;
        }
    }

    public boolean isLeartChest()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 16) == 0;
    }*/

    /*public void ChangeSubType(int var1)
    {
        if (var1 <= 2 && var1 >= 0)
        {
            this.setSubSpecies(var1);
            this.CheckSkin();
        }
    }*/

    @SideOnly(Side.CLIENT)
    public void ShowPedia(GuiPedia p0)
    {
        super.ShowPedia(p0);

        if (this.LearningChestTick == 0)
        {
            p0.AddStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_TEXT_CHEST), true);
        }
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal var1)
    {
        return new EntityVelociraptor(this.worldObj);
    }

    /*
    public boolean IsIdle()
    {
        return this.motionX < 0.03125D && this.motionY < 0.03125D && this.motionZ < 0.03125D;
    }
    */

    @Override
    public EntityAgeable createChild(EntityAgeable var1)
    {
    	EntityVelociraptor baby = new EntityVelociraptor(this.worldObj);
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
