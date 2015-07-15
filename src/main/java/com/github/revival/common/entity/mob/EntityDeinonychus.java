package com.github.revival.common.entity.mob;

import com.github.revival.Revival;
import com.github.revival.common.config.FossilConfig;
import com.github.revival.common.entity.ai.*;
import com.github.revival.common.enums.EnumPrehistoric;
import com.github.revival.common.enums.EnumPrehistoricAI.Jumping;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Vector;

public class EntityDeinonychus extends EntityDinosaur
{

	public static final double baseHealth = EnumPrehistoric.Deinonychus.Health0;
	public static final double baseDamage = EnumPrehistoric.Deinonychus.Strength0;
	public static final double baseSpeed = EnumPrehistoric.Deinonychus.Speed0;
	public static final double maxHealth = EnumPrehistoric.Deinonychus.HealthMax;
	public static final double maxDamage = EnumPrehistoric.Deinonychus.StrengthMax;
	public static final double maxSpeed = EnumPrehistoric.Deinonychus.SpeedMax;
	private final String texturePath;
	public boolean PreyChecked = false;
	public boolean SupportChecked = false;
	public Vector MemberList = new Vector();

	public EntityDeinonychus(World var1)
	{
		super(var1, EnumPrehistoric.Deinonychus);
		this.updateSize();

		this.adultAge = EnumPrehistoric.Deinonychus.AdultAge;
		// Set initial size for hitbox. (length/width, height)
		this.setSize(1.75F, 1.75F);
		// Size of dinosaur at day 0.
		this.minSize = 0.3F;
		// Size of dinosaur at age Adult.
		this.maxSize = 1.0F;

		if (!FossilConfig.featheredDeinonychus)
			texturePath = Revival.modid + ":textures/mob/" + this.SelfType.toString() + "/feathered/" + "Feathered_";
		else
			texturePath = Revival.modid + ":textures/mob/" + this.SelfType.toString() + "/";

		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, aiSit);
		this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(4, new DinoAIAttackOnCollide(this, 1.2D, true));
		this.tasks.addTask(5, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(6, new DinoAIFollowOwner(this, 1.0F, 10.0F, 2.0F));
		this.tasks.addTask(7, new DinoAIEat(this, 48));
		this.tasks.addTask(8, new DinoAIWander(this, 1.0D));
		this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(10, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(5, new DinoAIHunt(this, EntityLiving.class, 500, false));
		this.targetTasks.addTask(4, new DinoAITargetNonTamedExceptSelfClass(this, EntityLiving.class, 750, false));

		this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityTRex.class, 16.0F, 0.8D, 1.33D));
		this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntitySpinosaurus.class, 16.0F, 0.8D, 1.33D));
		this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityBrachiosaurus.class, 16.0F, 0.8D, 1.33D));
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(baseHealth);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(baseDamage);
	}
	protected void attackEntity(Entity entity, float f)
	{
		this.jump();
		super.attackEntity(entity, f);
	}
	protected void entityInit()
	{
		super.entityInit();
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
		return this.isAdult() || this.isTeen();
	}
	public boolean isAIEnabled()
	{
		return true;
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
			default:
			case 1:
				return texturePath + "Deinonychus_Grey_Adult.png";
			case 2:
				return texturePath + "Deinonychus_Black_Adult.png";
			case 3:
				return texturePath + "Deinonychus_Brown_Adult.png";
			}
		}
		else if (this.isTeen())
		{
			switch (this.getSubSpecies())
			{
			default:
			case 1:
				return texturePath + "Deinonychus_Grey_Teen.png";
			case 2:
				return texturePath + "Deinonychus_Black_Teen.png";
			case 3:
				return texturePath + "Deinonychus_Brown_Teen.png";
			}
		}
		else
		{
			switch (this.getSubSpecies())
			{
			default:
			case 1:
				return texturePath + "Deinonychus_Grey_Baby.png";
			case 2:
				return texturePath + "Deinonychus_Black_Baby.png";
			case 3:
				return texturePath + "Deinonychus_Brown_Baby.png";
			}
		}
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound var1)
	{
		super.writeEntityToNBT(var1);
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

	public float getEyeHeight()
	{
		return this.height * 0.8F;
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
		super.attackEntityFrom(damagesource, damageamount);
		if (this.isEntityInvulnerable())
		{
			return false;
		}
		else
		{
			Entity entity = damagesource.getEntity();
			this.aiSit.setSitting(false);


			if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
			{
				damageamount = (damageamount + 1.0F) / 2.0F;
			}

			return super.attackEntityFrom(damagesource, damageamount);
		}
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

	public void onUpdate()
	{
		super.onUpdate();
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

	public EntityAnimal spawnBabyAnimal(EntityAnimal var1)
	{
		return new EntityDeinonychus(this.worldObj);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1)
	{
		EntityDeinonychus baby = new EntityDeinonychus(this.worldObj);
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
	public Jumping aiJumpType(){
		return Jumping.TWOBLOCKS;
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
