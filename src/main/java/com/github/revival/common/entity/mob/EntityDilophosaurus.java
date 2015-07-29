package com.github.revival.common.entity.mob;

import com.github.revival.Revival;
import com.github.revival.client.gui.GuiPedia;
import com.github.revival.common.config.FossilConfig;
import com.github.revival.common.entity.ai.*;
import com.github.revival.common.enums.EnumPrehistoric;
import com.github.revival.common.enums.EnumOrderType;
import com.github.revival.common.enums.EnumSituation;
import com.github.revival.common.handler.LocalizationStrings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.Random;
import java.util.Vector;

public class EntityDilophosaurus extends EntityDinosaur
{
    public static final double baseHealth = EnumPrehistoric.Dilophosaurus.Health0;
    public static final double baseDamage = EnumPrehistoric.Dilophosaurus.Strength0;
    public static final double baseSpeed = EnumPrehistoric.Dilophosaurus.Speed0;
    public static final double maxHealth = EnumPrehistoric.Dilophosaurus.HealthMax;
    public static final double maxDamage = EnumPrehistoric.Dilophosaurus.StrengthMax;
    public static final double maxSpeed = EnumPrehistoric.Dilophosaurus.SpeedMax;

    public int LearningChestTick = 900;
    public boolean PreyChecked = false;
    public boolean SupportChecked = false;
    public Vector MemberList = new Vector();//ARE THEESE 5 DOING ANYTHING AND WORKING CORRECTLY?
    public float SwingAngle = -1000.0F;
    public int FleeingTick = 0;
    private boolean looksWithInterest;//IS THAT WORKING?
    private final String texturePath;

    public EntityDilophosaurus(World var1)
    {
        super(var1, EnumPrehistoric.Dilophosaurus);
        this.looksWithInterest = false;
        this.updateSize();
        /*
         * EDIT VARIABLES PER DINOSAUR TYPE
		 */
        this.adultAge = EnumPrehistoric.Dilophosaurus.AdultAge;
        // Set initial size for hitbox. (length/width, height)
        this.setSize(1.5F, 1.5F);
        // Size of dinosaur at day 0.
        this.minSize = 0.5F;
        // Size of dinosaur at age Adult.
        this.maxSize = 2.0F;

    	if(!FossilConfig.featheredDilophosaurus)
            texturePath = Revival.modid + ":textures/mob/" + this.SelfType.toString() + "/feathered/" + "Feathered_";
    	else
    		texturePath = Revival.modid + ":textures/mob/" + this.SelfType.toString() + "/";

        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new DinoAIAttackOnCollide(this, 1.2D, true));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0F, 5.0F, 2.0F));
        this.tasks.addTask(7, new DinoAIWander(this, 1.0D));
        this.tasks.addTask(7, new DinoAIEat(this, 48));
        this.targetTasks.addTask(7, new DinoAIHunt(this, EntityLiving.class, 500, false));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new DinoAITargetNonTamedExceptSelfClass(this, EntityLiving.class, 750, false));

        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityTyrannosaurus.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntitySpinosaurus.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityBrachiosaurus.class, 16.0F, 0.8D, 1.33D));
    }

    public boolean attackEntityAsMob(Entity var1)
    {
		/*
        if (this.rand.nextInt(16) < 4 && var1 instanceof EntityLiving)
        {
            //Has chance to blind the prey, after that handle normal attacking
            ((EntityLiving)var1).addPotionEffect(new PotionEffect(Potion.blindness.id, this.rand.nextInt(110) + 10, 0));
        }
		 */

        return super.attackEntityAsMob(var1);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(baseHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
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
		
		if(this.isAdult())
		{
			switch (this.getSubSpecies())
			{
			case 0: default:
				return texturePath + "Dilophosaurus_Adult.png";
			case 1: 
				return texturePath + "Dilophosaurus_Adult_Orange.png";
			}	
		}

		switch (this.getSubSpecies())
		{
		case 0: default:
			return texturePath + "Dilophosaurus_Baby.png";
		case 1: 
			return texturePath + "Dilophosaurus_Baby_Orange.png";
		}	
	}

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        var1.setInteger("LearningChestTick", this.LearningChestTick);
        //var1.setBoolean("Angry", this.isSelfAngry());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        //this.setSelfAngry(var1.getBoolean("Angry"));
        this.LearningChestTick = var1.getInteger("LearningChestTick");
        //this.setSelfSitting(var1.getBoolean("Sitting"));
        //this.InitSize();
        //this.OrderStatus = EnumOrderType.values()[var1.getByte("OrderStatus")];
		/*String var2 = var1.getString("Owner");

        if (var2.length() > 0)
        {
            this.setOwner(var2);
            this.setTamed(true);
        }*/
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    protected void updateEntityActionState()
    {
        //TODO
        super.updateEntityActionState();
        EntityLivingBase var1 = this.getOwner();

        if (!this.hasAttacked && !this.hasPath() && this.isTamed() && this.ridingEntity == null)
        {
            if (var1 != null)
            {
                EnumOrderType var10001 = this.OrderStatus;

                if (this.OrderStatus == EnumOrderType.Follow)
                {
                    float var2 = var1.getDistanceToEntity(this);

                    if (var2 > 5.0F)
                    {
                        this.getPathOrWalkableBlock(var1, var2);
                    }

                    if (!this.isAngry())
                    {
                        if (var2 < 5.0F)
                        {
                            //this.moveSpeed = 2.0F;
                            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.0D);
                        }
                        else
                        {
                            //                	        // Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
                            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
                        }
                    }
                }
            }
            else if (!this.isInWater())
            {
                this.setSitting(true);
            }
        }
        else if (this.isInWater())
        {
            this.setSitting(false);
        }

        if (!this.worldObj.isRemote)
        {
            this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));
        }
    }

    private boolean isNearbyChest()
    {
        TileEntity var5 = null;

        for (int var6 = -10; var6 <= 10; ++var6)
        {
            for (int var7 = 0; var7 <= 3; ++var7)
            {
                for (int var8 = -10; var8 <= 10; ++var8)
                {
                    var5 = this.worldObj.getTileEntity((int) (this.posX + (double) var6), (int) (this.posY + (double) var7), (int) (this.posZ + (double) var8));

                    if (var5 instanceof TileEntityChest)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (this.LearningChestTick > 0 && this.isNearbyChest() && this.isAdult())
        {
            this.LearningChestTick--;

            if (this.LearningChestTick == 0)
            {
                this.SendStatusMessage(EnumSituation.LearningChest);    //, this.SelfType);
            }
        }

		/*this.field_25054_c = this.field_25048_b;
        //HAS something todo with look with interest
        if (this.looksWithInterest)
        {
            this.field_25048_b += (1.0F - this.field_25048_b) * 0.4F;
        }
        else
        {
            this.field_25048_b += (0.0F - this.field_25048_b) * 0.4F;
        }*/

        if (this.looksWithInterest)
        {
            this.numTicksToChaseTarget = 10;
        }
    }

    public boolean getSelfShaking()
    {
        return false;
    }

	/*public float getShadingWhileShaking(float var1)
    {
        //return 0.75F + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * var1) / 2.0F * 0.25F;
    }

    public float getShakeAngle(float var1, float var2)
    {
        float var3 = (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * var1 + var2) / 1.8F;

        if (var3 < 0.0F)
        {
            var3 = 0.0F;
        }
        else if (var3 > 1.0F)
        {
            var3 = 1.0F;
        }

        return MathHelper.sin(var3 * (float)Math.PI) * MathHelper.sin(var3 * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
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
    public boolean attackEntityFrom(DamageSource damagesource, float damageamount)
    {
        Entity entity = damagesource.getEntity();
        boolean var4 = false;
        this.setSitting(false);

        if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
        {
            damageamount = (damageamount + 1) / 2;
        }

        if (super.attackEntityFrom(damagesource, damageamount))
        {
            if (!this.isAngry())
            {
                if (entity instanceof EntityArrow && ((EntityArrow) entity).shootingEntity != null)
                {
                    entity = ((EntityArrow) entity).shootingEntity;
                }

                if (entity instanceof EntityLiving)
                {
                    this.setTarget((EntityLiving) entity);
                }

                if (entity instanceof EntityPlayer && this.isTamed() && ((EntityPlayer) entity) == this.getOwner())
                {
                    //Hit by the owner->untame
                    this.SendStatusMessage(EnumSituation.Betrayed);
                    this.setTamed(false);
                    this.setOwner("");
                    this.setOwnerDisplayName("");
                    this.ItemInMouth = null;
                    this.setAngry(true);
                    this.setTarget(entity);
                    this.PreyChecked = true;
                    var4 = true;
                }
            }
            else if (entity != this && entity != null)
            {
                this.entityToAttack = entity;
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
        return this.isAngry() ? this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D) : null;
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity var1, float var2)
    {
        if (var1.isDead)
        {
            this.setTarget((Entity) null);
        }

        if (var2 > 2.0F && var2 < 5.0F && this.rand.nextInt(10) == 0)
        {
            if (this.onGround)
            {
                double var3 = var1.posX - this.posX;
                double var5 = var1.posZ - this.posZ;
                float var7 = MathHelper.sqrt_double(var3 * var3 + var5 * var5);
                this.motionX = var3 / (double) var7 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
                this.motionZ = var5 / (double) var7 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
                this.worldObj.playSoundAtEntity(this, "Raptor_attack", this.getSoundVolume() * 2.0F, 1.0F);
                this.jump();
            }
        }
        else if ((double) var2 < 1.899999976158142D && var1.boundingBox.maxY > this.boundingBox.minY && var1.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 20;
            var1.attackEntityFrom(DamageSource.causeMobDamage(this), 2 + this.getDinoAge());

            if (this.rand.nextInt(16) < 4 && var1 instanceof EntityLiving)
            {
                ((EntityLiving) var1).addPotionEffect(new PotionEffect(Potion.blindness.id, this.rand.nextInt(110) + 10, 0));
            }
        }
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
        //Add special item interaction code here
        return super.interact(var1);
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk()
    {
        return 10;
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float var1)
    {
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.fallDistance = var1;
        }

        int var2 = (int) Math.ceil((double) (var1 - 3.0F));

        if (var2 > 0)
        {
            this.attackEntityFrom(DamageSource.fall, 0);//Like cats, they don't suffer fall damage
        }
    }

    /**
     * Time remaining during which the Animal is sped up and flees.
     */
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
                int var7 = MathHelper.floor_double(this.posX + (double) this.rand.nextInt(13) - 6.0D);
                int var8 = MathHelper.floor_double(this.posY + (double) this.rand.nextInt(7) - 3.0D);
                int var9 = MathHelper.floor_double(this.posZ + (double) this.rand.nextInt(13) - 6.0D);
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

    //TODO TEXTURECHECK!!! when attacking!
    public boolean CheckSpace()
    {
        return !this.isEntityInsideOpaqueBlock();
    }

    @SideOnly(Side.CLIENT)
    public void ShowPedia(GuiPedia p0)
    {
        super.ShowPedia(p0);

        if (this.LearningChestTick == 0)
        {
            p0.AddStringLR(StatCollector.translateToLocal(LocalizationStrings.PEDIA_TEXT_CHEST), true);
        }
    }

    public EntityDilophosaurus spawnBabyAnimal(EntityAgeable var1)
    {
        return new EntityDilophosaurus(this.worldObj);
    }

	/*public boolean IsIdle()
    {
        return this.motionX < 0.03125D && this.motionY < 0.03125D && this.motionZ < 0.03125D;
    }*/

    /**
     * Sets the entity which is to be attacked.
     */
    public void setTarget(Entity var1)
    {
        super.setTarget(var1);
        //this.CheckSkin();
        //TODO change the skin to the aggressive one==>could be handled in gettexture
    }

    public EnumOrderType getOrderType()
    {
        return this.OrderStatus;
    }

	/*public float getGLX()
    {
        return (float)(0.20000000298023224D + 0.1D * (double)this.getDinoAge());
    }

    public float getGLY()
    {
        return (float)(0.3199999928474426D + 0.1D * (double)this.getDinoAge());
    }*/

	/*public EntityAgeable func_90011_a(EntityAgeable var1)
    {
        return this.spawnBabyAnimal(var1);
    }*/

    @Override
    public EntityAgeable createChild(EntityAgeable var1)
    {
        EntityDilophosaurus baby = new EntityDilophosaurus(this.worldObj);
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


        if (this.getDinoAge() <= this.adultAge)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Math.round(this.baseHealth + (healthStep * this.getDinoAge())));
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(Math.round(this.baseDamage + (attackStep * this.getDinoAge())));
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.baseSpeed + (speedStep * this.getDinoAge()));

            if (this.isTeen())
            {
                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5D);
            }
            else if (this.isAdult())
            {
                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(2.0D);
            }
            else
            {
                this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
            }
        }
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData)
    {
        par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);
        Random random = new Random();
        this.setSubSpecies(random.nextInt(2));
        this.setDinoAge(this.SelfType.AdultAge);
        this.updateSize();
        this.heal(200);
        return par1EntityLivingData;
    }

    @Override
    public void writeSpawnData(ByteBuf buffer)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void readSpawnData(ByteBuf additionalData)
    {
        // TODO Auto-generated method stub

    }
}
