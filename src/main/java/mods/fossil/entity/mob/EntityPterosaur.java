package mods.fossil.entity.mob;

import io.netty.buffer.ByteBuf;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Random;

import mods.fossil.client.LocalizationStrings;
import mods.fossil.client.gui.GuiPedia;
import mods.fossil.fossilAI.DinoAIAttackOnCollide;
import mods.fossil.fossilAI.DinoAIControlledByPlayer;
import mods.fossil.fossilAI.DinoAIEat;
import mods.fossil.fossilAI.DinoAIFlying;
import mods.fossil.fossilAI.DinoAIFollowOwner;
import mods.fossil.fossilAI.DinoAIWander;
import mods.fossil.fossilEnums.EnumDinoType;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityPterosaur extends EntityFlyingDino {
	// base attributes
	public static final double BASE_SPEED_GROUND = 0.3;
	public static final double BASE_SPEED_AIR = 1.5;
	public static final double BASE_DAMAGE = 8;
	public static final int BASE_HEALTH = 60;
	public static final int BASE_SIZE = 4;
	public static final int HOME_RADIUS = 256;

	public static final double baseHealth = EnumDinoType.Pterosaur.Health0;
	public static final double baseDamage = EnumDinoType.Pterosaur.Strength0;
	public static final double baseSpeed = EnumDinoType.Pterosaur.Speed0;

	public static final double maxHealth = EnumDinoType.Pterosaur.HealthMax;
	public static final double maxDamage = EnumDinoType.Pterosaur.StrengthMax;
	public static final double maxSpeed = EnumDinoType.Pterosaur.SpeedMax;

	public ItemStack ItemInMouth = null;
	public int LearningChestTick = 900;
	public int SubType = 0;
	public int BreedTick = 3000;
	public float AirSpeed = 0.0F;
	public float AirAngle = 0.0F;
	public float AirPitch = 0.0F;
	public float LastAirPitch = .0F;
	public float moveSpeed = 1.0F;
	public boolean Landing = false;
	public float WingState = 0.0F;
	public int wingpause = 0;

	public EntityPterosaur(World var1) {
		super(var1, EnumDinoType.Pterosaur);
		this.updateSize();

		/*
		 * EDIT VARIABLES PER DINOSAUR TYPE
		 */
		this.adultAge = EnumDinoType.Pterosaur.AdultAge;
		// Set initial size for hitbox. (length/width, height)
		this.setSize(1.0F, 1.0F);
		// Size of dinosaur at day 0.
		this.minSize = 1.0F;
		// Size of dinosaur at age Adult.
		this.maxSize = 4.0F;

		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(3, new DinoAIAttackOnCollide(this, 1.1D, true));
		this.tasks.addTask(5, new DinoAIFollowOwner(this, 1.0F, 10.0F, 2.0F));
		this.tasks.addTask(7, new DinoAIEat(this, 48));
		this.tasks.addTask(7, new DinoAIFlying(this));
		this.tasks.addTask(2, new DinoAIControlledByPlayer(this));//, 0.34F));
		this.tasks.addTask(7, new DinoAIWander(this, 1.0D));

		this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityTRex.class,
				16.0F, 0.8D, 1.33D));
		this.tasks.addTask(4, new EntityAIAvoidEntity(this,
				EntitySpinosaurus.class, 16.0F, 0.8D, 1.33D));

		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));

		// this.tasks.addTask(1, new EntityAIRideGround(this, 1)); // mutex all

		// mutex 1: waypointing
		// mutex 2: continuous waypointing
		// this.airTasks.addTask(0, new EntityAIRideAir(this)); // mutex all
		// this.airTasks.addTask(0, new EntityAILand(this)); // mutex 0

	}

	/**
	 * Returns the texture's file path as a String.
	 */
	@Override
	public String getTexture() {
		if (this.isModelized()) {
			return super.getTexture();
		}

		switch (this.getSubSpecies()) {
		default:
			return "fossil:textures/mob/Pterosaur2.png";
		}
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(baseSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(baseHealth);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setBaseValue(baseDamage);
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they
	 * walk on. used for spiders and wolves to prevent them from trampling crops
	 */
	protected boolean canTriggerWalking() {
		return false;
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound var1) {
		super.writeEntityToNBT(var1);
	}

	public float getMountHeight() {
		return this.height * 0.75F;
	}

	public void updateRiderPosition() {
		if (this.riddenByEntity != null) {
			this.riddenByEntity.setPosition(
					this.posX,
					this.posY + this.getMountHeight()
							+ this.riddenByEntity.getYOffset(), this.posZ);
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound var1) {
		super.readEntityFromNBT(var1);
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this
	 * entity.
	 */
	public boolean getCanSpawnHere() {
		return this.worldObj.checkNoEntityCollision(this.boundingBox)
				&& this.worldObj.getCollidingBoundingBoxes(this,
						this.boundingBox).size() == 0
				&& !this.worldObj.isAnyLiquid(this.boundingBox);
	}

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */

	public void onLivingUpdate() {
		super.onLivingUpdate();
	}

	/**
	 * Called to update the entity's position/logic.
	 */

	public void onUpdate() {
		super.onUpdate();
	}

	public float getEyeHeight() {
		return this.height * 0.9F;
	}

	/**
	 * The speed it takes to move the entityliving's rotationPitch through the
	 * faceEntity method. This is only currently use in wolves.
	 */
	public int getVerticalFaceSpeed() {
		return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
	}

	/**
	 * Disables a mob's ability to move on its own while true.
	 */
	protected boolean isMovementCeased() {
		return this.isSitting();
	}

	/**
	 * Finds the closest player within 16 blocks to attack, or null if this
	 * Entity isn't interested in attacking (Animals, Spiders at day, peaceful
	 * PigZombies).
	 */
	protected Entity findPlayerToAttack() {
		return this.isAngry() ? this.worldObj
				.getClosestVulnerablePlayerToEntity(this, 16.0D) : null;
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource var1, float var2) {
		return this.modelizedDrop() ? true : super.attackEntityFrom(var1, var2);
	}

	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden
	 * by each mob to define their attack.
	 */
	protected void attackEntity(Entity var1, float var2) {
		if (var2 > 2.0F && var2 < 5.0F && this.rand.nextInt(10) == 0) {
			if (this.onGround) {
				double var3 = var1.posX - this.posX;
				double var5 = var1.posZ - this.posZ;
				float var7 = MathHelper.sqrt_double(var3 * var3 + var5 * var5);
				this.motionX = var3 / (double) var7 * 0.5D * 0.800000011920929D
						+ this.motionX * 0.20000000298023224D;
				this.motionZ = var5 / (double) var7 * 0.5D * 0.800000011920929D
						+ this.motionZ * 0.20000000298023224D;
				this.jump();
			}
		} else if ((double) var2 < 1.899999976158142D
				&& var1.boundingBox.maxY > this.boundingBox.minY
				&& var1.boundingBox.minY < this.boundingBox.maxY) {
			this.attackTime = 20;
			var1.attackEntityFrom(DamageSource.causeMobDamage(this),
					2 + this.getDinoAge());
		}
	}

	public float getHalfHeight() {
		return this.getEyeHeight() / 2.0F;
	}

	public boolean interact(EntityPlayer player) {
		return super.interact(player);
	}

	public boolean CheckSpace() {
		if (this.isEntityInsideOpaqueBlock()) {
			return true;
		} else {
			return false;
		}
	}

	@SideOnly(Side.CLIENT)
	public void ShowPedia(GuiPedia gui) {
		super.ShowPedia(gui);
		if (this.isAdult()) {
			gui.AddStringLR(StatCollector
					.translateToLocal(LocalizationStrings.PEDIA_TEXT_FLY), true);
		}
	}

	/**
	 * Causes this entity to do an upwards motion (jumping).
	 */
	public void jump() {
		this.motionY = 0.5D;
	}

	/**
	 * Takes in the distance the entity has fallen this tick and whether its on
	 * the ground to update the fall distance and deal fall damage if landing on
	 * the ground. Args: distanceFallenThisTick, onGround
	 * 
	 * protected void updateFallState(double par1, boolean par3) {}
	 */

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		EntityPterosaur baby = new EntityPterosaur(this.worldObj);
		baby.setSubSpecies(this.getSubSpecies());
		return baby;
	}

	public boolean isOwner(EntityPlayer player) {
		return player == this.getOwner();
	}

	public boolean isRiddenByOwner() {
		return riddenByEntity == getOwner();
	}

	public EntityPlayer getRidingPlayer() {
		if (riddenByEntity instanceof EntityPlayer) {
			return (EntityPlayer) riddenByEntity;
		} else {
			return null;
		}
	}

	public void setRidingPlayer(EntityPlayer player) {
		player.rotationYaw = this.rotationYaw;
		player.rotationPitch = this.rotationPitch;
		player.mountEntity(this);
	}

	/**
	 * This gets called when a dinosaur grows naturally or through Chicken
	 * Essence.
	 */
	@Override
	public void updateSize() {
		double healthStep;
		double attackStep;
		double speedStep;
		healthStep = (this.maxHealth - this.baseHealth) / (this.adultAge + 1);
		attackStep = (this.maxDamage - this.baseDamage) / (this.adultAge + 1);
		speedStep = (this.maxSpeed - this.baseSpeed) / (this.adultAge + 1);

		if (this.getDinoAge() <= this.adultAge) {
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
					.setBaseValue(
							Math.round(this.baseHealth
									+ (healthStep * this.getDinoAge())));
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
					.setBaseValue(
							Math.round(this.baseDamage
									+ (attackStep * this.getDinoAge())));
			this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
					.setBaseValue(
							this.baseSpeed + (speedStep * this.getDinoAge()));

			if (this.isTeen()) {
				this.getEntityAttribute(
						SharedMonsterAttributes.knockbackResistance)
						.setBaseValue(0.5D);
			} else if (this.isAdult()) {
				this.getEntityAttribute(
						SharedMonsterAttributes.knockbackResistance)
						.setBaseValue(2.0D);
			} else {
				this.getEntityAttribute(
						SharedMonsterAttributes.knockbackResistance)
						.setBaseValue(0.0D);
			}
		}
	}

	public float getGLX() {
		return (float)(0.8F+0.2*(float)this.getDinoAge());
	}

	public float getGLY() {
		return (float)(0.8F+0.2*(float)this.getDinoAge());
	}
	
	public float getGLZ() {
		return (float)(0.8F+0.2*(float)this.getDinoAge());
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