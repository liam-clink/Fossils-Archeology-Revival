package com.github.revival.server.entity.mob.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import net.ilexiconn.llibrary.client.model.tools.ChainBuffer;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import org.lwjgl.opengl.GL11;

import com.github.revival.Revival;
import com.github.revival.client.gui.GuiPedia;
import com.github.revival.server.api.IPrehistoricAI;
import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.block.entity.TileEntityNewFeeder;
import com.github.revival.server.entity.EnumDiet;
import com.github.revival.server.entity.ai.DinoAIAttackOnCollide;
import com.github.revival.server.enums.EnumAnimation;
import com.github.revival.server.enums.EnumOrderType;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumPrehistoricAI.Activity;
import com.github.revival.server.enums.EnumPrehistoricAI.Attacking;
import com.github.revival.server.enums.EnumPrehistoricAI.Climbing;
import com.github.revival.server.enums.EnumPrehistoricAI.Following;
import com.github.revival.server.enums.EnumPrehistoricAI.Jumping;
import com.github.revival.server.enums.EnumPrehistoricAI.Moving;
import com.github.revival.server.enums.EnumPrehistoricAI.Response;
import com.github.revival.server.enums.EnumPrehistoricAI.Stalking;
import com.github.revival.server.enums.EnumPrehistoricAI.Taming;
import com.github.revival.server.enums.EnumPrehistoricAI.Untaming;
import com.github.revival.server.enums.EnumPrehistoricAI.WaterAbility;
import com.github.revival.server.enums.EnumPrehistoricMood;
import com.github.revival.server.enums.EnumSituation;
import com.github.revival.server.handler.LocalizationStrings;
import com.github.revival.server.item.FAItemRegistry;
import com.github.revival.server.message.MessageFoodParticles;
import com.github.revival.server.message.MessageHappyParticles;
import com.github.revival.server.message.MessageSetDay;
import com.github.revival.server.util.FoodMappings;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class EntityNewPrehistoric extends EntityTameable implements IPrehistoricAI, IAnimatedEntity {

	public static final int OWNER_DISPLAY_NAME_INDEX = 24;
	public static final int HUNGER_TICK_DATA_INDEX = 18;
	public static final int HUNGER_DATA_INDEX = 19;
	public static final int AGE_TICK_DATA_INDEX = 20;
	public static final int AGE_DATA_INDEX = 21;
	public static final int SUBSPECIES_INDEX = 22;
	public static final int MODELIZED_INDEX = 23;
	public static final int GENDER_INDEX = 25;
	public static final int CLIMBING_INDEX = 26;
	public static final int SLEEPING_INDEX = 27;
	public static final int MOOD_INDEX = 28;
	public static final byte HEART_MESSAGE = 35;
	public static final byte SMOKE_MESSAGE = 36;
	public static final byte AGING_MESSAGE = 37;
	protected static final ResourceLocation pediaclock = new ResourceLocation("fossil:textures/gui/PediaClock.png");
	protected static final ResourceLocation pediafood = new ResourceLocation("fossil:textures/gui/PediaFood.png");
	protected static final ResourceLocation pediaheart = new ResourceLocation("fossil:textures/gui/PediaHeart.png");
	public static Animation SPEAK_ANIMATION = Animation.create(20);
	public static Animation ATTACK_ANIMATION = Animation.create(20);
	public float minSize;
	public float maxSize;
	public int teenAge;
	public EnumPrehistoric selfType = null;
	public int BreedTick;
	public ItemStack ItemInMouth = null;
	public EnumOrderType currentOrder;
	public ChunkCoordinates currentHerdTarget;
	public float herdMemberRange = 32;
	public List<EntityNewPrehistoric> flock = new ArrayList<EntityNewPrehistoric>();
	public EntityNewPrehistoric flockLeader = null;
	public boolean isFlying;
	public ChunkCoordinates currentTarget;
	public Item favoriteFood;
	public boolean hasFeatherToggle = false;
	public boolean featherToggle;
	public boolean hasTeenTexture = false;
	public boolean hasBabyTexture;
	public int necklength = 2;
	public boolean clientSitting;
	public boolean clientSleeping;
	public float sitProgress;
	public int ticksSitted;
	protected boolean isSitting;
	public float sleepProgress;
	public float climbProgress;
	public int ticksSlept;
	protected boolean isSleeping;
	protected boolean developsResistance;
	protected boolean breaksBlocks;
	private Animation currentAnimation;
	private int animTick;
	@SideOnly(Side.CLIENT)
	public ChainBuffer tailBuffer = new ChainBuffer();
	public float jumpLength;
	public int ticksEating;
	public double attackSpeedBoost;
	public float pediaScale;
	public boolean mood_nospace;
	public boolean mood_noplants;
	protected int nearByMobsAllowed;
	public int ticksSprinted;
	public int ticksTillPlay;
	public int prevAge;
	public boolean isDaytime;

	public EntityNewPrehistoric(World world, EnumPrehistoric selfType) {
		super(world);
		this.updateSize();
		this.selfType = selfType;
		this.pediaScale = 1.0F;
		nearByMobsAllowed = 15;
		this.currentOrder = EnumOrderType.WANDER;
		//SPEAK_ANIMATION.duration = this.getSpeakLength();
		//ATTACK_ANIMATION.duration = this.getAttackLength();
		attackSpeedBoost = 1.3D;
		this.tasks.addTask(0, new DinoAIAge(this));
		this.tasks.addTask(0, new DinoAIHunger(this));
		this.tasks.addTask(0, aiSit);
		this.setHunger(100 / 2);
		this.tasks.addTask(7, new DinoAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(1, new DinoAITerratorial(this, EntityLivingBase.class, 4.0F));
		this.tasks.addTask(2, new DinoAIWaterAgressive(this, 0.009D));
		this.tasks.addTask(2, new DinoAIFish(this, 1));
		this.tasks.addTask(3, new DinoAIWander(this));
		this.tasks.addTask(3, new DinoAIWaterWander(this, 1));
		this.tasks.addTask(4, new DinoAIFollow(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(4, new DinoAIFollowWild(this, 1, favoriteFood));
		this.tasks.addTask(4, aiSit);
		this.tasks.addTask(5, new DinoAIFeeder(this, 48));
		this.tasks.addTask(5, new DinoAIWaterFeeder(this, 50, 0.0017D));
		this.tasks.addTask(6, new DinoAILookAtEntity(this, EntityLivingBase.class, 8));
		this.tasks.addTask(7, new DinoAIHideFromSun(this));
		this.tasks.addTask(8, new DinoAIRunAway(this, EntityLivingBase.class, 16.0F, this.getSpeed() / 2, this.getSpeed()));
		this.tasks.addTask(9, new DinoAIFlee(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new DinoAIAgressive(this, EntityLivingBase.class, 1, true, isCannibal()));
		this.targetTasks.addTask(3, new DinoAIHurtByTarget(this));
		//this.targetTasks.addTask(2, new EntityAITargetNonTamed(this, EntityLivingBase.class, 200, false));
		hasBabyTexture = true;
		this.setScale(this.getDinosaurSize());
	}

	public static boolean isCannibal() {
		return false;
	}

	public int getSpeakLength() {
		return 20;
	}

	public int getAttackLength() {
		return 20;
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(AGE_DATA_INDEX, 0);
		this.dataWatcher.addObject(AGE_TICK_DATA_INDEX, 0);
		this.dataWatcher.addObject(HUNGER_DATA_INDEX, 30);
		this.dataWatcher.addObject(HUNGER_TICK_DATA_INDEX, 300);
		this.dataWatcher.addObject(SUBSPECIES_INDEX, 1);
		this.dataWatcher.addObject(MODELIZED_INDEX, (byte) -1);
		this.dataWatcher.addObject(OWNER_DISPLAY_NAME_INDEX, "");
		this.dataWatcher.addObject(CLIMBING_INDEX, 0);
		this.dataWatcher.addObject(SLEEPING_INDEX, Byte.valueOf((byte) 0));
		this.dataWatcher.addObject(GENDER_INDEX, 0);
		this.dataWatcher.addObject(MOOD_INDEX, 0);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("isModelized", this.isModelized());
		compound.setBoolean("Angry", this.isAngry());
		compound.setInteger("Hunger", this.getHunger());
		compound.setInteger("HungerTick", this.getHungerTick());
		compound.setInteger("DinoAge", this.getDinoAge());
		compound.setInteger("AgeTick", this.getDinoAgeTick());
		compound.setInteger("SubSpecies", this.getSubSpecies());
		compound.setByte("currentOrder", (byte) this.currentOrder.ordinal());
		compound.setString("OwnerDisplayName", this.getOwnerDisplayName());
		compound.setInteger("Gender", this.getGender());
		compound.setBoolean("Sleeping", this.isSleeping);
		compound.setInteger("Mood", this.getMood());
		compound.setBoolean("Sitting", this.isSitting);
		compound.setBoolean("MoodNoSpace", this.mood_nospace);
		compound.setBoolean("MoodNoPlants", this.mood_noplants);
		compound.setInteger("TicksSincePlay", this.ticksTillPlay);

	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(19.0D);
		getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
		updateSize();
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		this.setDinoAge(compound.getInteger("DinoAge"));
		this.setDinoAgeTick(compound.getInteger("AgeTick"));
		this.setModelized(compound.getBoolean("isModelized"));
		this.setAngry(compound.getBoolean("Angry"));
		this.setHunger(compound.getInteger("Hunger"));
		this.setHungerTick(compound.getInteger("HungerTick"));
		this.setSubSpecies(compound.getInteger("SubSpecies"));
		this.setGender(compound.getInteger("Gender"));
		this.setSleeping(compound.getBoolean("Sleeping"));
		this.setSitting(compound.getBoolean("Sitting"));
		this.setMood(compound.getInteger("Mood"));
		this.setOrder(EnumOrderType.values()[compound.getByte("currentOrder")]);
		String owner;
		if (compound.hasKey("Owner", 8)) {
			owner = compound.getString("Owner");
			this.setOwnerDisplayName(owner);
		} else {
			this.setOwnerDisplayName(compound.getString("OwnerDisplayName"));
		}
		this.mood_nospace = compound.getBoolean("MoodNoSpace");
		this.mood_noplants = compound.getBoolean("MoodNoPlants");
		this.ticksTillPlay = compound.getInteger("TicksSincePlay");
	}

	protected AxisAlignedBB getAttackBounds() {
		return this.boundingBox.expand(1.0F, 1.0F, 1.0F);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData) {
		par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);
		Random random = new Random();
		this.setDinoAge(this.getAdultAge());
		this.updateSize();
		this.heal(200);
		this.setSpawnValues();
		this.setGender(random.nextInt(2));
		ticksTillPlay = 0;
		return par1EntityLivingData;
	}

	@Override
	public boolean isAIEnabled() {
		return true;
	}

	public void doPlayBonus(int playBonus) {
		ticksTillPlay = this.rand.nextInt(600) + 600;
		this.setMood(this.getMood() + playBonus);
		Revival.NETWORK_WRAPPER.sendToAll(new MessageHappyParticles(this.getEntityId()));
	}

	public abstract void setSpawnValues();

	public boolean isHungry() {
		return this.getHunger() < this.getMaxHunger()
				* this.selfType.HungryLevel;
	}

	public boolean isDeadlyHungry() {
		return this.getHunger() < this.getMaxHunger()
				* (1 - this.selfType.HungryLevel);
	}

	@Override
	protected boolean isMovementCeased() {
		return this.getOrderType() == EnumOrderType.STAY || this.isSitting() || this.isSleeping();
	}

	public EnumOrderType getOrderType() {
		return this.currentOrder;
	}

	@Override
	public boolean isMovementBlocked() {
		return this.getHealth() <= 0.0F || isSitting() || isSleeping();
	}

	@Override
	public boolean isSitting() {
		if (worldObj.isRemote) {
			boolean isSitting = (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;

			if ((isSitting != this.isSitting)) {
				ticksSitted = 0;
			}

			this.isSitting = isSitting;

			return isSitting;
		}

		return isSitting;
	}

	public boolean isSleeping() {
		if (worldObj.isRemote) {
			boolean isSleeping = (this.dataWatcher.getWatchableObjectByte(SLEEPING_INDEX) & 1) != 0;

			if ((isSleeping != this.isSleeping)) {
				ticksSlept = 0;
			}

			this.isSleeping = isSleeping;
			return isSleeping;
		}

		return isSleeping;
	}

	public Vec3 getBlockToEat(int range) {
		Vec3 pos;

		for (int r = 1; r <= range; r++) {
			for (int ds = -r; ds <= r; ds++) {
				for (int dy = 4; dy > -5; dy--) {
					int x = MathHelper.floor_double(this.posX + ds);
					int y = MathHelper.floor_double(this.posY + dy);
					int z = MathHelper.floor_double(this.posZ - r);
					if (this.posY + dy >= 0 && this.posY + dy <= this.worldObj.getHeight() && FoodMappings.instance().getBlockFoodAmount(this.worldObj.getBlock(x, y, z), selfType.diet) != 0) {
						pos = Vec3.createVectorHelper(x, y, z);
						return pos;
					}

					if (this.posY + dy >= 0 && this.posY + dy <= this.worldObj.getHeight() && FoodMappings.instance().getBlockFoodAmount(this.worldObj.getBlock(x, y, z), selfType.diet) != 0) {
						pos = Vec3.createVectorHelper(x, y, z);
						return pos;
					}
				}
			}

			for (int ds = -r + 1; ds <= r - 1; ds++) {
				for (int dy = 4; dy > -5; dy--) {
					int x = MathHelper.floor_double(this.posX + ds);
					int y = MathHelper.floor_double(this.posY + dy);
					int z = MathHelper.floor_double(this.posZ - r);

					if (this.posY + dy >= 0 && this.posY + dy <= this.worldObj.getHeight() && FoodMappings.instance().getBlockFoodAmount(this.worldObj.getBlock(x, y, z), selfType.diet) != 0) {
						pos = Vec3.createVectorHelper(x, y, z);
						return pos;
					}

					if (this.posY + dy >= 0 && this.posY + dy <= this.worldObj.getHeight() && FoodMappings.instance().getBlockFoodAmount(this.worldObj.getBlock(x, y, z), selfType.diet) != 0) {
						pos = Vec3.createVectorHelper(x, y, z);
						return pos;
					}
				}
			}
		}

		return null;
	}

	public void setOwner(String ownerName) {
		this.func_152115_b(ownerName);
	}

	@Override
	public boolean allowLeashing() {
		return !this.getLeashed() && !(this instanceof IMob) && this.isTamed();
	}

	public int BlockInteractive() {
		return 0;
	}

	public void setOrder(EnumOrderType var1) {
		this.currentOrder = var1;
	}

	@Override
	protected boolean canDespawn() {
		return false;
	}

	public TileEntityNewFeeder getNearestFeeder(int feederRange) {
		for (int dx = -2; dx != -(feederRange + 1); dx += (dx < 0) ? (dx * -2)
				: (-(2 * dx + 1))) {
			for (int dy = -5; dy < 4; dy++) {
				for (int dz = -2; dz != -(feederRange + 1); dz += (dz < 0) ? (dz * -2)
						: (-(2 * dz + 1))) {
					if (this.posY + dy >= 0
							&& this.posY + dy <= this.worldObj.getHeight()) {
						TileEntity feeder = this.worldObj.getTileEntity(MathHelper.floor_double(this.posX + dx), MathHelper.floor_double(this.posY + dy), MathHelper.floor_double(this.posZ + dz));

						if (feeder != null && feeder instanceof TileEntityNewFeeder && !((TileEntityNewFeeder) feeder).isEmpty(selfType)) {
							System.out.println(feeder);
							return (TileEntityNewFeeder) feeder;
						}
					}
				}
			}
		}

		return null;
	}

	public boolean arePlantsNearby(int range) {
		for (int r = 1; r <= range; r++) {
			for (int ds = -r; ds <= r; ds++) {
				for (int dy = 4; dy > -5; dy--) {
					int x = MathHelper.floor_double(this.posX + ds);
					int y = MathHelper.floor_double(this.posY + dy);
					int z = MathHelper.floor_double(this.posZ - r);
					if (this.posY + dy >= 0 && this.posY + dy <= this.worldObj.getHeight() && isPlantBlock(this.worldObj.getBlock(x, y, z))) {
						return true;
					}

					if (this.posY + dy >= 0 && this.posY + dy <= this.worldObj.getHeight() && isPlantBlock(this.worldObj.getBlock(x, y, z))) {
						return true;
					}
				}
			}
			for (int ds = -r + 1; ds <= r - 1; ds++) {
				for (int dy = 4; dy > -5; dy--) {
					int x = MathHelper.floor_double(this.posX + ds);
					int y = MathHelper.floor_double(this.posY + dy);
					int z = MathHelper.floor_double(this.posZ - r);

					if (this.posY + dy >= 0 && this.posY + dy <= this.worldObj.getHeight() && isPlantBlock(this.worldObj.getBlock(x, y, z))) {
						return true;
					}

					if (this.posY + dy >= 0 && this.posY + dy <= this.worldObj.getHeight() && isPlantBlock(this.worldObj.getBlock(x, y, z))) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean isPlantBlock(Block block) {
		return block.getMaterial() == Material.grass || block.getMaterial() == Material.plants || block.getMaterial() == Material.leaves;
	}

	public boolean canSleep() {
		if (this.aiActivityType() == Activity.DIURINAL && !this.isDaytime()) {
			return true;
		}
		if (this.aiActivityType() == Activity.NOCTURNAL && this.isDaytime() && !this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), (int)this.boundingBox.minY, MathHelper.floor_double(this.posZ))) {
			return true;
		}
		if (this.aiActivityType() == Activity.BOTH) {
			return true;
		}else{
			return false;
		}
	}

	public boolean isDaytime(){
		if(worldObj.isRemote){
			return isDaytime;
		}else{
			Revival.NETWORK_WRAPPER.sendToAll(new MessageSetDay(this.getEntityId(),this.worldObj.isDaytime()));
			return this.worldObj.isDaytime();
		}
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if(this.getAttackTarget() != null && !this.canAttackClass(this.getAttackTarget().getClass())){
			this.setAttackTarget(null);
		}
		if (this.getHunger() > 100) {
			this.setHunger(100);
		}
		if (this.getMood() > 100) {
			this.setMood(100);
		}
		if (this.getMood() < -100) {
			this.setMood(-100);
		}
		if(this.ticksTillPlay > 0){
			this.ticksTillPlay--;
		}
		if (!this.arePlantsNearby(16) && !mood_noplants) {
			boolean inital_mood_noplants = mood_noplants;
			this.mood_noplants = true;
			if (mood_noplants != inital_mood_noplants) {
				this.setMood(this.getMood() - 50);
			}
		}
		if (this.arePlantsNearby(16)) {
			boolean inital_mood_noplants = mood_noplants;
			this.mood_noplants = false;
			if (mood_noplants != inital_mood_noplants) {
				this.setMood(this.getMood() + 50);
			}
		}

		if (this.isThereNearbyTypes() && !mood_nospace) {
			boolean inital_mood_nospace = mood_nospace;
			this.mood_nospace = true;
			if (mood_nospace != inital_mood_nospace) {
				this.setMood(this.getMood() - 50);
			}
		}
		if (!this.isThereNearbyTypes()) {
			boolean inital_mood_nospace = mood_nospace;
			this.mood_nospace = false;
			if (mood_nospace != inital_mood_nospace) {
				this.setMood(this.getMood() + 50);
			}
		}

		if (this.isSitting()) {
			if (!this.getNavigator().noPath()) {
				this.getNavigator().clearPathEntity();
			}
			ticksSitted++;
		}
		if (this.isSleeping()) {
			if (!this.getNavigator().noPath()) {
				this.getNavigator().clearPathEntity();
			}
			ticksSlept++;
		}

		if (!worldObj.isRemote && !this.isSitting() && this.getRNG().nextInt(100) == 1 && !this.isRiding() && (this.getAnimation() == NO_ANIMATION || this.getAnimation() == SPEAK_ANIMATION) && !this.isSleeping()) {
			this.setSitting(true);
			ticksSitted = 0;
		}

		if (!worldObj.isRemote && (this.isSitting() && ticksSitted > 100 && this.getRNG().nextInt(100) == 1 || this.getAttackTarget() != null) && !this.isSleeping()) {
			this.setSitting(false);
			ticksSitted = 0;
		}
		if (!worldObj.isRemote && this.getRNG().nextInt(500) == 1 && this.canSleep() && (this.getAnimation() == NO_ANIMATION || this.getAnimation() == SPEAK_ANIMATION)) {
			this.setSitting(false);
			this.setSleeping(true);
			ticksSlept = 0;
		}

		if (!worldObj.isRemote && ( !this.canSleep() || (this.isSleeping() && ticksSlept > 200 && this.getRNG().nextInt(1000) == 1 || this.getAttackTarget() != null))) {
			this.setSitting(false);
			this.setSleeping(false);
			ticksSlept = 0;
		}

		if (breaksBlocks) {
			this.breakBlock(5);
		}

		if (this.aiMovingType() == Moving.FLIGHT) {
			if (this.riddenByEntity == null) {
				if (!this.isSitting()) {
					if (this.isAdult()) {
						if (!worldObj.isRemote) {
							if (getEntityToAttack() == null) {
								if (rand.nextInt(400) == 0) {
									if (!this.getOrderType().equals(EnumOrderType.STAY)) {
										isFlying = !isFlying;
									}
								}

								if (isFlying) {
									flyAround();
								} else {

								}

								if (getEntityToAttack() != null) {
									currentTarget = new ChunkCoordinates(
											(int) getEntityToAttack().posX,
											(int) ((int) getEntityToAttack().posY + getEntityToAttack()
													.getEyeHeight()),
													(int) getEntityToAttack().posZ);
									isFlying = false;
									flyTowardsTarget();
								}
							}
						}
					}
				}
			}
		}
		if (this.doesFlock()) {
			/*	IEntitySelector selector =IEntitySelector.selectAnything;
            List<Entity> entities = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand((double)herdMemberRange, 3.0D, (double)herdMemberRange), selector);
			for(Entity mob: entities){
				if(mob instanceof EntityNewPrehistoric){
					if(((EntityNewPrehistoric)mob).selfType == this.selfType){
						EntityNewPrehistoric member = (EntityNewPrehistoric)mob;
						flock.add(member);
						System.out.println("A Newb Dino joined the Flock!!!");

						if(member.isDead){
							System.out.println("Oh No!!! A dino Died and left the flock :(");
							flock.remove(member);
						}
						if(flockLeader == null || flockLeader.isDead){
							System.out.println("The Flock found a new Leader!!!");
							flockLeader = findLeader(flock);
						}
						member.motionX = flockLeader.motionX;
						member.motionY = flockLeader.motionY;
						member.motionZ = flockLeader.motionZ;

					}
					if(!worldObj.isRemote && flockLeader != null){
						if(flockLeader == this && this.rand.nextInt(100) == 0)
						{
							this.moveEntity((int) posX + rand.nextInt(90)
									- rand.nextInt(60), (int) posY + rand.nextInt(60) - 2,
									(int) posZ + rand.nextInt(90) - rand.nextInt(60));
						}
					}
				}
			}
		}*/
		}
	}

	public void flyTowardsTarget() {
		if (currentTarget != null) {
			double targetX = currentTarget.posX + 0.5D - posX;
			double targetY = currentTarget.posY + 1D - posY;
			double targetZ = currentTarget.posZ + 0.5D - posZ;
			motionX += (Math.signum(targetX) * 0.5D - motionX) * 0.10000000149011612D;
			motionY += (Math.signum(targetY) * 0.699999988079071D - motionY) * 0.10000000149011612D;
			motionZ += (Math.signum(targetZ) * 0.5D - motionZ) * 0.10000000149011612D;
			float angle = (float) (Math.atan2(motionZ, motionX) * 180.0D / Math.PI) - 90.0F;
			float rotation = MathHelper.wrapAngleTo180_float(angle
					- rotationYaw);
			moveForward = 0.5F;
			rotationYaw += rotation;
		}

	}

	public void flyAround() {
		if (currentTarget != null) {
			if (!worldObj.isAirBlock(currentTarget.posX, currentTarget.posY,
					currentTarget.posZ) || currentTarget.posY < 1) {
				currentTarget = null;
			}
		}

		if (currentTarget == null
				|| rand.nextInt(30) == 0
				|| currentTarget.getDistanceSquared((int) posX, (int) posY,
						(int) posZ) < 10F) {
			currentTarget = new ChunkCoordinates((int) posX + rand.nextInt(90)
					- rand.nextInt(60), (int) posY + rand.nextInt(60) - 2,
					(int) posZ + rand.nextInt(90) - rand.nextInt(60));
		}

		flyTowardsTarget();
	}

	public EntityNewPrehistoric findLeader(List<EntityNewPrehistoric> flock) {
		int index = new Random().nextInt(flock.size());
		return flock.get(index);
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

	@SideOnly(Side.CLIENT)
	public void showPedia2(GuiPedia p0, String mobName) {
		p0.reset();
		p0.addStringLR("", 150, false);
		String translatePath = "assets/fossil/dinopedia/" + Minecraft.getMinecraft().gameSettings.language + "/";
		//String bioFile = String.valueOf(mobName) + ".txt";
		String bioFile = "template.txt";
		if (getClass().getClassLoader().getResourceAsStream(translatePath) == null) {
			translatePath = "assets/fossil/dinopedia/" + "en_US" + "/";
		}

		if (getClass().getClassLoader().getResourceAsStream(translatePath + bioFile) != null) {
			InputStream fileReader = getClass().getClassLoader().getResourceAsStream(translatePath + bioFile);
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileReader));
				StringBuffer stringBuffer = new StringBuffer();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					GL11.glPushMatrix();
					GL11.glScalef(0.75F, 0.75F, 0.75F);
					p0.addStringLR(line, -125, false);
					GL11.glPopMatrix();
				}
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			p0.addStringLR("File not found.", false);
			GL11.glPushMatrix();
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			p0.addStringLR(translatePath + bioFile, 150, false);
			GL11.glPopMatrix();
		}
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		int currentAge = getDinoAge();
		if (currentAge != prevAge) {
			this.setScale(this.getDinosaurSize());
			prevAge = currentAge;
		}
		if (this.isSprinting()) {
			ticksSprinted++;
		}
		if (ticksSprinted == 40) {
			ticksSprinted = 0;
			this.setSprinting(false);
		}
		tailBuffer.calculateChainSwingBuffer(70, 10, 4, this);
		if (this.ridingEntity != null) {
			if (this.ridingEntity.isDead) {
				this.mountEntity(null);
				//this.posY += 1;
			}
		}
		boolean sitting = isSitting();
		if (sitting && sitProgress < 20.0F) {
			sitProgress += 0.5F;
			if(sleepProgress != 0)sleepProgress = 0F;
		} else if (!sitting && sitProgress > 0.0F) {
			sitProgress -= 0.5F;
			if(sleepProgress != 0)sleepProgress = 0F;
		}
		boolean sleeping = isSleeping();
		if (sleeping && sleepProgress < 20.0F) {
			sleepProgress += 0.5F;
			if(sitProgress != 0)sitProgress = 0F;
		} else if (!sleeping && sleepProgress > 0.0F) {
			sleepProgress -= 0.5F;
			if(sitProgress != 0)sitProgress = 0F;
		}
		boolean climbing = this.aiClimbType() == Climbing.ARTHROPOD ? this.isBesideClimbableBlock() && !this.onGround : false;
		if (climbing && climbProgress < 20.0F) {
			climbProgress += 1F;
			if(sitProgress != 0)sitProgress = 0F;
		} else if (!climbing && climbProgress > 0.0F) {
			climbProgress -= 1F;
			if(sitProgress != 0)sitProgress = 0F;
		}
		if(this.ticksExisted > 1)
			AnimationHandler.INSTANCE.updateAnimations(this);
		if (!this.worldObj.isRemote) {
			if(this.aiClimbType() == Climbing.ARTHROPOD){
				this.setBesideClimbableBlock(this.isCollidedHorizontally);
			}else{
				this.setBesideClimbableBlock(false);
			}
		}
	}

	public String getOwnerDisplayName() {
		return this.dataWatcher.getWatchableObjectString(OWNER_DISPLAY_NAME_INDEX);
	}

	public void setOwnerDisplayName(String displayName) {
		this.dataWatcher.updateObject(OWNER_DISPLAY_NAME_INDEX, displayName);
	}

	@Override
	public abstract Activity aiActivityType();

	@Override
	public abstract Attacking aiAttackType();

	@Override
	public abstract Climbing aiClimbType();

	@Override
	public abstract Following aiFollowType();

	@Override
	public abstract Jumping aiJumpType();

	@Override
	public abstract Response aiResponseType();

	@Override
	public abstract Stalking aiStalkType();

	@Override
	public abstract Taming aiTameType();

	@Override
	public abstract Untaming aiUntameType();

	@Override
	public abstract Moving aiMovingType();

	@Override
	public abstract WaterAbility aiWaterAbilityType();

	public abstract int getAdultAge();

	public abstract boolean doesFlock();

	@Override
	public boolean canAttackClass(Class clazz) {
		return this.getClass() != clazz;
	}

	public float getDinosaurSize() {
		float step;
		step = (this.maxSize - this.minSize) / (this.getAdultAge() + 1);

		if (this.getDinoAge() > this.getAdultAge()) {
			return this.minSize + (step * this.getAdultAge());
		}

		return this.minSize + (step * this.getDinoAge());
	}

	@Override
	protected int getExperiencePoints(EntityPlayer par1EntityPlayer) {
		return MathHelper.floor_float(this.selfType.Exp0
				+ (float) this.getDinoAge() * this.selfType.ExpInc);
	}

	public void updateSize() {
		this.jump();
	}

	public void breakBlock(float hardness) {
		if (Revival.CONFIG.dinoBlockBreaking) {
			if (!isModelized() && this.isAdult() && this.IsHungry()) {
				for (int a = (int) Math.round(this.boundingBox.minX) - 1; a <= (int) Math.round(this.boundingBox.maxX) + 1; a++) {
					for (int b = (int) Math.round(this.boundingBox.minY) + 1; (b <= (int) Math.round(this.boundingBox.maxY) + 3) && (b <= 127); b++) {
						for (int c = (int) Math.round(this.boundingBox.minZ) - 1; c <= (int) Math.round(this.boundingBox.maxZ) + 1; c++) {

							Block block = worldObj.getBlock(a, b, c);
							if (!(block instanceof BlockBush) && !(block instanceof BlockLiquid) && block != Blocks.bedrock && block != FABlockRegistry.INSTANCE.ancientGlass && block != FABlockRegistry.INSTANCE.strongGlass && block.getBlockHardness(worldObj, a, b, c) < hardness) {
								this.motionX *= 0.6D;
								this.motionZ *= 0.6D;

								Item item = block.getItemDropped(worldObj.getBlockMetadata(a, b, c), this.getRNG(), 1);
								int itemCount = block.quantityDropped(getRNG());
								int itemMeta = block.damageDropped(worldObj.getBlockMetadata(a, b, c));
								if (block != Blocks.air) {
									//this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_" + this.worldObj.getBlockMetadata(a, b, c), a + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width,b + 0.1D, c + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D);
									this.playSound(block.stepSound.getBreakSound(), 0.15F, 1.0F);
								}

								if (!worldObj.isRemote) {
									worldObj.setBlock(a, b, c, Blocks.air);
								}

								if (item != null) {
									float f = 0.7F;
									double d0 = (double) (this.getRNG().nextFloat() * f) + (double) (1.0F - f) * 0.5D;
									double d1 = (double) (this.getRNG().nextFloat() * f) + (double) (1.0F - f) * 0.5D;
									double d2 = (double) (this.getRNG().nextFloat() * f) + (double) (1.0F - f) * 0.5D;
									if (!worldObj.isRemote) {
										EntityItem entityitem = new EntityItem(worldObj, (double) a + d0, (double) b + d1, (double) c + d2, new ItemStack(item, itemCount, itemMeta));
										entityitem.delayBeforeCanPickup = 10;
										worldObj.spawnEntityInWorld(entityitem);

									}
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void setScaleForAge(boolean par1) {
		this.setScale(this.getDinosaurSize());
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return null;
	}

	public boolean isAdult() {
		return this.getDinoAge() >= getAdultAge();
	}

	public boolean isTeen() {
		return this.getDinoAge() >= teenAge
				&& this.getDinoAge() < getAdultAge();
	}

	@Override
	public boolean isChild() {
		return this.getDinoAge() < teenAge;
	}

	public int getMaxHunger() {
		return 100;
	}

	public boolean isModelized() {
		return this.dataWatcher.getWatchableObjectByte(MODELIZED_INDEX) >= 0;
	}

	public void setModelized(boolean var1) {
		if (this.selfType.isModelable()) {
			this.dataWatcher.updateObject(MODELIZED_INDEX, (byte) (var1 ? 0 : -1));
		}
	}

	public int getDinoAge() {
		return this.dataWatcher.getWatchableObjectInt(AGE_DATA_INDEX);
	}

	public void setDinoAge(int age) {
		this.dataWatcher.updateObject(AGE_DATA_INDEX, age);
	}

	public boolean increaseDinoAge() {
		if (this.getDinoAge() < this.selfType.MaxAge) {
			this.setDinoAge(this.getDinoAge() + 1);
			return true;
		}
		return false;
	}

	public int getDinoAgeTick() {
		return this.dataWatcher.getWatchableObjectInt(AGE_TICK_DATA_INDEX);
	}

	public void setDinoAgeTick(int var1) {
		this.dataWatcher.updateObject(AGE_TICK_DATA_INDEX, var1);
	}

	public void increaseDinoAgeTick() {
		this.setDinoAgeTick(this.getDinoAgeTick() + 1);
	}

	public int getHunger() {
		return this.dataWatcher.getWatchableObjectInt(HUNGER_DATA_INDEX);
	}

	public void setHunger(int var1) {
		if (this.getHunger() > this.getMaxHunger()) {
			this.dataWatcher.updateObject(HUNGER_DATA_INDEX, 100);
		} else {
			this.dataWatcher.updateObject(HUNGER_DATA_INDEX, var1);
		}
	}

	public boolean increaseHunger(int var1) {
		if (this.getHunger() >= this.getMaxHunger()) {
			return false;
		}

		this.setHunger(this.getHunger() + var1);

		if (this.getHunger() > this.getMaxHunger()) {
			this.setHunger(this.getMaxHunger());
		}

		this.worldObj.playSoundAtEntity(this, "random.eat",
				this.getSoundVolume(), this.getSoundPitch());
		return true;
	}

	@Override
	public void onKillEntity(EntityLivingBase var1) {
		super.onKillEntity(var1);
		this.increaseHunger(FoodMappings.instance().getEntityFoodAmount(var1.getClass(), this.selfType.diet));
		this.heal(FoodMappings.instance().getEntityFoodAmount(var1.getClass(), this.selfType.diet) / 3);
		this.setMood(this.getMood() + 25);
	}

	public void decreaseHunger() {
		if (this.getHunger() > 0) {
			this.setHunger(this.getHunger() - 1);
		}
	}

	public boolean IsHungry() {
		return this.getHunger() < this.getMaxHunger()
				* this.selfType.HungryLevel;
	}

	public boolean IsDeadlyHungry() {
		return this.getHunger() < this.getMaxHunger()
				* (1 - this.selfType.HungryLevel);
	}

	public int getHungerTick() {
		return this.dataWatcher.getWatchableObjectInt(HUNGER_TICK_DATA_INDEX);
	}

	public void setHungerTick(int var1) {
		this.dataWatcher.updateObject(HUNGER_TICK_DATA_INDEX, var1);
	}

	public void sendStatusMessage(EnumSituation var1) {
		if (this.getOwner() != null && this.getDistanceToEntity(this.getOwner()) < 50.0F) {
			String Status1 = StatCollector.translateToLocal(("status." + var1.toString() + ".head"));
			String Dino = this.selfType.toString();
			String Status2 = StatCollector.translateToLocal("status." + var1.toString());
			Revival.showMessage(Status1 + Dino + " " + Status2, (EntityPlayer) this.getOwner());
		}
	}

	@Override
	public void moveEntityWithHeading(float par1, float par2) {
		if (!isModelized() && !this.isSleeping()) {
			super.moveEntityWithHeading(par1, par2);

			// this.stepHeight = 0.5F;

			if (this.riddenByEntity != null || this.isAdult()) {
				this.stepHeight = 1.0F;
			}
		}


		if (this.aiMovingType() == Moving.AQUATIC || this.aiMovingType() == Moving.SEMIAQUATIC) {
			double d0;

			if (this.isInWater()) {
				this.moveFlying(par1, par2, 0.02F);
				this.moveEntity(this.motionX, this.motionY, this.motionZ);
				this.motionX *= 0.900000011920929D;
				this.motionY *= 0.900000011920929D;
				this.motionZ *= 0.900000011920929D;
			} else if (this.handleLavaMovement()) {
				this.moveFlying(par1, par2, 0.02F);
				this.moveEntity(this.motionX, this.motionY, this.motionZ);
				this.motionX *= 0.5D;
				this.motionY *= 0.5D;
				this.motionZ *= 0.5D;
			} else {
				if (this.aiMovingType() == Moving.AQUATIC) {
					float f2 = 0.91F;

					if (this.onGround) {
						f2 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ)).slipperiness * 0.91F;

					}

					float f3 = 0.16277136F / (f2 * f2 * f2);
					float f4;

					if (this.onGround) {
						f4 = this.getAIMoveSpeed() * f3;
					} else {
						f4 = this.jumpMovementFactor;
					}

					this.moveFlying(par1, par2, f4);
					f2 = 0.91F;

					if (this.onGround) {
						f2 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ)).slipperiness * 0.91F;

					}


					this.moveEntity(this.motionX, this.motionY, this.motionZ);

					if (this.isInsideOfMaterial(Material.water)) {
						this.motionY = 0.0D;
						this.motionX *= (double) f2;
						this.motionY *= (double) f2;
						this.motionZ *= (double) f2;
					} else {
						this.motionY -= 0.08D;
						this.motionY *= 0.9800000190734863D;
						this.motionX *= (double) f2;
						this.motionZ *= (double) f2;
					}
				} else {
					super.moveEntityWithHeading(par1, par2);
				}
			}

			this.prevLimbSwingAmount = this.limbSwingAmount;
			d0 = this.posX - this.prevPosX;
			double d1 = this.posZ - this.prevPosZ;
			float f6 = MathHelper.sqrt_double(d0 * d0 + d1 * d1) * 4.0F;

			if (f6 > 1.0F) {
				f6 = 1.0F;
			}

			this.limbSwingAmount += (f6 - this.limbSwingAmount) * 0.4F;
			this.limbSwing += this.limbSwingAmount;
		}
	}

	public void decreaseHungerTick() {
		if (this.getHungerTick() > 0) {
			this.setHungerTick(this.getHungerTick() - 1);
		}
	}

	@Override
	public boolean isOnLadder() {
		if (this.aiMovingType() == Moving.AQUATIC || this.aiMovingType() == Moving.SEMIAQUATIC) {
			return false;
		} else if (this.aiClimbType() == Climbing.ARTHROPOD) {
			return this.isBesideClimbableBlock();
		} else {
			return super.isOnLadder();
		}
	}

	public boolean isAngry() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
	}

	public void setAngry(boolean var1) {
		byte var2 = this.dataWatcher.getWatchableObjectByte(16);

		if (var1) {
			this.dataWatcher.updateObject(16, (byte) (var2 | 2));
		} else {
			this.dataWatcher.updateObject(16, (byte) (var2 & -3));
		}
	}

	public int getSubSpecies() {
		return this.dataWatcher.getWatchableObjectInt(SUBSPECIES_INDEX);
	}

	public void setSubSpecies(int var1) {
		this.dataWatcher.updateObject(SUBSPECIES_INDEX, var1);
	}

	public int getGender() {
		return this.dataWatcher.getWatchableObjectInt(GENDER_INDEX);
	}

	public void setGender(int var1) {
		this.dataWatcher.updateObject(GENDER_INDEX, var1);
	}

	public void setSleeping(boolean sleeping) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(SLEEPING_INDEX);

		if (sleeping) {
			this.dataWatcher.updateObject(SLEEPING_INDEX, Byte.valueOf((byte) (b0 | 1)));
		} else {
			this.dataWatcher.updateObject(SLEEPING_INDEX, Byte.valueOf((byte) (b0 & -2)));
		}

		if (!worldObj.isRemote) {
			this.isSleeping = sleeping;
		}
	}

	public int getMood() {
		return this.dataWatcher.getWatchableObjectInt(MOOD_INDEX);
	}

	public void setMood(int var1) {
		this.dataWatcher.updateObject(MOOD_INDEX, var1);
	}

	public EnumPrehistoricMood getMoodFace() {
		if (this.getMood() == 100) {
			return EnumPrehistoricMood.HAPPY;
		} else if (this.getMood() >= 50) {
			return EnumPrehistoricMood.CONTENT;
		} else if (this.getMood() == -100) {
			return EnumPrehistoricMood.ANGRY;
		} else if (this.getMood() <= -50) {
			return EnumPrehistoricMood.SAD;
		} else {
			return EnumPrehistoricMood.CALM;
		}
	}

	public int getScaledMood() {
		return (int) (71 * -(this.getMood() * 0.01));
	}

	@Override
	public void setSitting(boolean sitting) {
		super.setSitting(sitting);

		if (!worldObj.isRemote) {
			this.isSitting = sitting;
		}
	}

	@Override
	public void dismountEntity(Entity entity) {
		if (!worldObj.isRemote) {
			double d0 = entity.posX;
			double d1 = entity.boundingBox.minY + (double) this.height;
			double d2 = entity.posZ;
			byte b0 = 1;

			for (int i = -b0; i <= b0; ++i) {
				for (int j = -b0; j < b0; ++j) {
					if (i != 0 || j != 0) {
						int k = (int) (this.posX + (double) i);
						int l = (int) (this.posZ + (double) j);
						AxisAlignedBB axisalignedbb = this.boundingBox.getOffsetBoundingBox((double) i, 1.0D, (double) j);

						if (this.worldObj.func_147461_a(axisalignedbb).isEmpty()) {
							if (World.doesBlockHaveSolidTopSurface(this.worldObj, k, (int) this.posY, l)) {
								this.setPositionAndUpdate(this.posX + (double) i, this.posY + 2.0D, this.posZ + (double) j);
								return;
							}

							if (World.doesBlockHaveSolidTopSurface(this.worldObj, k, (int) this.posY - 1, l) || this.worldObj.getBlock(k, (int) this.posY - 1, l).getMaterial() == Material.water) {
								d0 = this.posX + (double) i;
								d1 = this.posY + 1.0D;
								d2 = this.posZ + (double) j;
							}
						}
					}
				}
			}

			this.setPositionAndUpdate(d0, d1, d2);
		}
	}

	@Override
	public boolean shouldDismountInWater(Entity rider) {
		return false;
	}

	@Override
	public boolean attackEntityFrom(DamageSource dmg, float i) {
		if (this.getLastAttacker() instanceof EntityPlayer) {
			if (this.getOwner() == this.getLastAttacker()) {
				this.setTamed(false);
				this.setMood(this.getMood() - 15);
				this.sendStatusMessage(EnumSituation.Betrayed);
			}
		}
		if (i > 0){
			this.setSitting(false);
			this.setSleeping(false);
		}
		if (dmg.getEntity() != null) this.setMood(this.getMood() - 5);
		if (this.getHurtSound() != null) {
			if (this.getAnimation() != null) {
				if (this.getAnimation() == NO_ANIMATION && worldObj.isRemote) {
					this.setAnimation(SPEAK_ANIMATION);
				}
			}
		}
		super.attackEntityFrom(dmg, i);
		return super.attackEntityFrom(dmg, i);
	}

	public boolean isBesideClimbableBlock() {
		return (this.dataWatcher.getWatchableObjectInt(CLIMBING_INDEX) & 1) != 0;
	}

	public void setBesideClimbableBlock(boolean isClollided) {
		int b0 = this.dataWatcher.getWatchableObjectInt(CLIMBING_INDEX);

		if (isClollided) {
			b0 = (byte) (b0 | 1);
		} else {
			b0 &= -2;
		}

		this.dataWatcher.updateObject(CLIMBING_INDEX, b0);
	}

	@Override
	protected void fall(float i) {
		if (this.aiClimbType() == Climbing.ARTHROPOD || this.aiMovingType() == Moving.WALKANDGLIDE || this.aiMovingType() == Moving.FLIGHT) {

		} else {
			super.fall(i);
		}
	}

	@Override
	public void jump() {
		if (this.aiJumpType() == Jumping.TWOBLOCKS) {
			this.motionY = 0.41999998688697815D * 2;

			if (this.isPotionActive(Potion.jump)) {
				this.motionY += (double) ((float) (this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
			}

			if (this.isSprinting()) {
				float f = this.rotationYaw * 0.017453292F;
				this.motionX -= (double) (MathHelper.sin(f) * 0.2F);
				this.motionZ += (double) (MathHelper.cos(f) * 0.2F);
			}

			this.isAirBorne = true;
			ForgeHooks.onLivingJump(this);
		} else {
			super.jump();
		}
	}

	@Override
	public boolean interact(EntityPlayer player) {
		ItemStack itemstack = player.inventory.getCurrentItem();
		if (this.isModelized()) {
			if (itemstack == null) {
				if (player.isSneaking()) {
					this.nudgeEntity(player);
				} else {
					this.faceEntity(player, 360.0F, 360.0F);
				}
			} else {
				if (itemstack.getItem() == Items.bone) {
					this.increaseDinoAge();

					if (!player.capabilities.isCreativeMode) {
						--itemstack.stackSize;
					}

					if (itemstack.stackSize <= 0) {
						player.inventory.setInventorySlotContents(
								player.inventory.currentItem, null);
					}

					return true;
				}
			}

		} else {

			if (itemstack != null) {
				if (itemstack.getItem() != null) {
					if (this.aiTameType() == Taming.GEM && itemstack.getItem() == FAItemRegistry.INSTANCE.gem || this.aiTameType() == Taming.BLUEGEM && itemstack.getItem() == FAItemRegistry.INSTANCE.gem_blue) {
						if (!this.isTamed()) {
							this.triggerTamingAcheivement(player);
							this.heal(200);
							this.increaseHunger(500);
							this.setTamed(true);
							setPathToEntity(null);
							setAttackTarget(null);
							this.setOwner(player.getUniqueID().toString());
							this.setOwnerDisplayName(player.getCommandSenderName());
							--itemstack.stackSize;
							if (itemstack.stackSize <= 0) {
								player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
							}
							return true;
						}
					}
				}
			}

			if (itemstack != null) {
				if (itemstack.getItem() == FAItemRegistry.INSTANCE.chickenEss && !player.worldObj.isRemote) {
					// Be grown up by chicken essence
					if (this.getDinoAge() < this.getAdultAge() && this.getHunger() > 0) {
						if (this.getHunger() > 0) {
							if (!player.capabilities.isCreativeMode) {
								--itemstack.stackSize;
							}

							if (itemstack.stackSize <= 0) {
								player.inventory.setInventorySlotContents(player.inventory.currentItem,
										null);
							}

							if (!player.capabilities.isCreativeMode) {
								player.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle, 1));
							}
							Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), Item.getIdFromItem(FAItemRegistry.INSTANCE.chickenEss)));
							this.increaseDinoAge();
							this.setHunger(1 + (new Random()).nextInt(this.getHunger()));
							this.setOwner(player.getDisplayName());
							return true;
						}
					}

					if (!this.worldObj.isRemote) {
						Revival.showMessage(StatCollector.translateToLocal(LocalizationStrings.STATUS_ESSENCE_FAIL), player);
					}

					return false;
				}

				if (FoodMappings.instance().getItemFoodAmount(itemstack.getItem(), this.selfType.diet) != 0) {
					if (!player.worldObj.isRemote) {
						if (this.getMaxHunger() > this.getHunger()) {

							this.setHunger(this.getHunger() + FoodMappings.instance().getItemFoodAmount(itemstack.getItem(), this.selfType.diet));
							if (!worldObj.isRemote) this.eatItem(itemstack);
							if (Revival.CONFIG.healingDinos) {
								this.heal(3);
							}
							if (this.getHunger() >= this.getMaxHunger()) {
								if (this.isTamed()) {
									this.sendStatusMessage(EnumSituation.Full);
								}

							}

							--itemstack.stackSize;
							if (this.aiTameType() == Taming.FEEDING) {
								if (!this.isTamed() && this.selfType.isTameable() && (new Random()).nextInt(10) == 1) {
									this.setTamed(true);
									this.setOwner(player.getUniqueID().toString());
									this.setOwnerDisplayName(player.getCommandSenderName());
									this.worldObj.setEntityState(this, HEART_MESSAGE);
								}
							}

							return true;
						} else {
							if (this.ItemInMouth == null) {
								return true;
							}
						}
					}

					return false;
				} else {

					if (itemstack.getItem() == Items.lead && this.allowLeashing()) {
						if (func_152114_e(player)) {
							this.setLeashedToEntity(player, true);
							--itemstack.stackSize;
							return true;
						}
					}

					if (FMLCommonHandler.instance().getSide().isClient()
							&& itemstack.getItem() == FAItemRegistry.INSTANCE.dinoPedia) {

						this.setPedia();
						player.openGui(Revival.INSTANCE, 4, this.worldObj, (int) this.posX, (int) this.posY, (int) this.posZ);
						return true;
					}

					if (itemstack.getItem() == FAItemRegistry.INSTANCE.whip
							&& this.selfType.isRideable() && this.isAdult()
							&& !this.worldObj.isRemote
							) {

						if (this.isTamed() && func_152114_e(player)) {
							if (this.getRidingPlayer() == null) {
								Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), FABlockRegistry.INSTANCE.volcanicRock));
								this.setOrder(EnumOrderType.WANDER);
								setRidingPlayer(player);
							} else if (this.getRidingPlayer() == player) {
								this.setSprinting(true);
								Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), FABlockRegistry.INSTANCE.volcanicRock));
								this.setMood(this.getMood() - 1);
							}
						} else {
							System.out.println(player.getDisplayName());

							this.setMood(this.getMood() - 1);
							Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), FABlockRegistry.INSTANCE.volcanicRock));
							if (getRNG().nextInt(15) == 0) {
								this.setMood(this.getMood() - 25);
								this.setTamed(true);
								Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), Item.getIdFromItem(Items.gold_ingot)));
								this.setOwner(player.getUniqueID().toString());
								this.setOwnerDisplayName(player.getCommandSenderName());
							}
						}
						this.setSitting(false);
						//this.setOrder(EnumOrderType.WANDER);


						// this.currentOrder = EnumOrderType.FreeMove;
						//	setRidingPlayer(player);
					}

					if (this.getOrderItem() != null
							&& itemstack.getItem() == this.getOrderItem()
							&& this.isTamed() && func_152114_e(player)
							&& !player.isRiding()) {
						// THIS DINOS ITEM TO BE CONTROLLED WITH
						if (!this.worldObj.isRemote) {
							this.isJumping = false;
							this.setPathToEntity(null);
							this.currentOrder = EnumOrderType.values()[(this.currentOrder
									.ordinal() + 1) % 3];

							this.sendOrderMessage(this.currentOrder);

							if (this.currentOrder == EnumOrderType.STAY) {
								this.getNavigator().clearPathEntity();
								this.setPathToEntity(null);
								this.setSitting(true);
							} else {
								this.setSitting(false);
							}
						}

						return true;
					}

				}
			}
		}
		return super.interact(player);

	}

	public abstract Item getOrderItem();

	private void triggerTamingAcheivement(EntityPlayer player) {
		//player.triggerAchievement(FossilAchievementHandler.theKing);

	}

	private boolean isWeak() {
		return (this.getHealth() < 8) && (this.getDinoAge() >= this.getAdultAge()) && !this.isTamed();
	}

	protected void setPedia() {
		Revival.toPedia = this;
	}

	private void sendOrderMessage(EnumOrderType var1) {
		String S = StatCollector.translateToLocal(LocalizationStrings.ORDER_HEAD) + StatCollector.translateToLocal("order." + var1.toString());
		Revival.showMessage(S, (EntityPlayer) this.getOwner());
	}

	public void nudgeEntity(EntityPlayer player) {
		this.setPositionAndUpdate(
				this.posX + (player.posX - this.posX) * 0.01F, this.posY,
				this.posZ + (player.posZ - this.posZ) * 0.01F);
	}

	public ArrayList<Class<? extends Entity>> preyList() {
		return new ArrayList<Class<? extends Entity>>();
	}

	public ArrayList<Class<? extends Entity>> preyBlacklist() {
		return new ArrayList<Class<? extends Entity>>();
	}

	public void playerRoar(EntityPlayer player) {
	}

	public void playerAttack(EntityPlayer player) {
	}

	public void playerJump(EntityPlayer player) {
	}

	public void playerFlyUp(EntityPlayer player) {
	}

	public void playerFlyDown(EntityPlayer player) {
	}

	public String getTexture() {
		String toggle = this.hasFeatherToggle ? !this.featherToggle ? "feathered/" : "scaled/" : "";
		boolean isBaby = this.isChild() && this.hasBabyTexture;
		String gender = this.hasTeenTexture ? this.isTeen() ? "_teen" : this.isChild() ? "_baby" : this.getGender() == 0 ? "_female" : "_male" : this.isChild() ? "_baby" : this.getGender() == 0 ? "_female" : "_male";
		String sleeping = !this.isSleeping() ? "" : "_sleeping";
		String toggleList = this.hasFeatherToggle ? !this.featherToggle ? "_feathered" : "_scaled" : "";
		return "fossil:textures/model/" + selfType.toString().toLowerCase() + "_0/" + toggle + selfType.toString().toLowerCase() + gender + toggleList + sleeping + ".png";
	}

	@SideOnly(Side.CLIENT)
	public void showPedia(GuiPedia p0) {

		p0.reset();
		//p0.printHappyBar(new ResourceLocation(Revival.MODID + ":"
		//		+ "textures/items/" + this.selfType.toString() + "_DNA.png"),
		//		((p0.xGui / 2) + (p0.xGui / 4)), 7, 16, 16); // 185

		/*
		 * LEFT PAGE
		 *
		 * OWNER: (+2) OWNER NAME RIDEABLE ORDER ABLE TO FLY ABLE TO CHEST
		 * DANGEROUS
		 */

		/*
		 * RIGHT PAGE
		 *
		 * CUSTOM NAME DINOSAUR NAME DINO AGE HEALTH HUNGER
		 */
		if (this.hasCustomNameTag()) {
			p0.printStringXY(this.getCustomNameTag(), GuiPedia.rightIndent, 24, 40,
					90, 245);
		}

		p0.printStringXY(
				StatCollector.translateToLocal("entity.fossil."
						+ this.selfType.toString() + ".name"), GuiPedia.rightIndent,
						34, 0, 0, 0);
		//p0.printHappyBar(pediaclock, GuiPedia.rightIndent, 46, 8, 8);
		//p0.printHappyBar(pediaheart, GuiPedia.rightIndent, 58, 9, 9);
		//p0.printHappyBar(pediafood, GuiPedia.rightIndent, 70, 9, 9);

		// Print "Day" after age
		if (this.getDinoAge() == 1) {
			p0.printStringXY(
					String.valueOf(this.getDinoAge())
					+ " "
					+ StatCollector
					.translateToLocal(LocalizationStrings.PEDIA_EGG_DAY),
					GuiPedia.rightIndent + 12, 46);
		} else {
			p0.printStringXY(
					String.valueOf(this.getDinoAge())
					+ " "
					+ StatCollector
					.translateToLocal(LocalizationStrings.PEDIA_EGG_DAYS),
					GuiPedia.rightIndent + 12, 46);
		}

		// Display Health
		p0.printStringXY(
				String.valueOf(this.getHealth()) + '/' + this.getMaxHealth(),
				GuiPedia.rightIndent + 12, 58);
		// Display Hunger
		p0.printStringXY(
				String.valueOf(this.getHunger()) + '/' + this.getMaxHunger(),
				GuiPedia.rightIndent + 12, 70);

		// Display owner name
		if (this.selfType.isTameable() && this.isTamed()) {
			if (this.getOwnerDisplayName().length() > 0) {
				p0.addStringLR(
						StatCollector
						.translateToLocal(LocalizationStrings.PEDIA_TEXT_OWNER),
						true);

				// //////////1.7.10 BLOCK //////////////

				String s0 = String.valueOf(this.getOwnerDisplayName());
				if (s0.length() > 11) {
					s0 = this.getOwnerDisplayName().substring(0, 11);
				}

				p0.addStringLR(s0, true);
				// /////////////////////////////////////

				// //////////1.7.2 BLOCK //////////////
				/*
				 * String s0 = this.getOwnerName(); if (s0.length() > 11) { s0 =
				 * this.getOwnerName().substring(0, 11); }
				 *
				 * p0.addStringLR(s0, true);
				 */
				// /////////////////////////////////////
			} else {
				p0.addStringLR(StatCollector.translateToLocal("Tamed"), true);
			}
		} else {
			p0.addStringLR(StatCollector.translateToLocal("Untamed"), true);
		}
		// Display if Rideable
		if (this.selfType.isRideable() && this.isAdult()) {
			p0.addStringLR(StatCollector
					.translateToLocal(LocalizationStrings.PEDIA_TEXT_RIDEABLE),
					true);
		}

		if (this.selfType.orderItem != null) {
			p0.addStringLR(
					StatCollector.translateToLocal("Order: "
							+ (new ItemStack(this.selfType.orderItem))
							.getDisplayName()), true);
		}

		for (int i = 0; i < this.selfType.FoodItemList.index; i++) {
			if (this.selfType.FoodItemList.getItem(i) != null) {
				p0.addMiniItem(this.selfType.FoodItemList.getItem(i));
			}
		}

	}

	public int getTailSegments() {
		return 3;
	}

	@Override
	public void updateRidden() {
		super.updateRidden();
		if (this.ridingEntity != null) {
			if (this.ridingEntity instanceof EntityPlayer) {
				this.setPosition(posX, posY - ((EntityPlayer) this.ridingEntity).yOffset, posZ);
			}
		}
	}

	private double getSpeed() {
		return 0.4D;
	}

	public float getMaleSize() {
		return 1.0F;
	}

	public String getOverlayTexture() {
		return "fossil:textures/blank.png";
	}

	public void triggerAnimation(EnumAnimation animation) {
		int animateID = animation.ordinal();
		Revival.PROXY.animate(animateID);
	}

	@Override
	public int getAnimationTick() {
		return animTick;
	}

	@Override
	public void setAnimationTick(int tick) {
		animTick = tick;
	}

	@Override
	public Animation getAnimation() {
		return currentAnimation;
	}

	@Override
	public void setAnimation(Animation animation) {
		currentAnimation = animation;
	}

	@Override
	public Animation[] getAnimations() {
		return new Animation[]{SPEAK_ANIMATION, ATTACK_ANIMATION};
	}

	@Override
	public void playLivingSound() {
		if(this.isSleeping()){
			super.playLivingSound();
			if (this.getAnimation() != null) {
				if (this.getAnimation() == NO_ANIMATION && !worldObj.isRemote) {
					this.setAnimation(SPEAK_ANIMATION);
				}
			}
		}
	}

	public void knockbackEntity(Entity knockBackMob, float knockbackStrength, float knockbackStrengthUp) {
		knockBackMob(knockBackMob, 1, 0.4D, 1);
	}

	public static void knockBackMob(Entity entity, double xMotion, double yMotion, double zMotion) {
		entity.isAirBorne = true;
		float f1 = MathHelper.sqrt_double(xMotion * xMotion + zMotion * zMotion);
		entity.motionX /= 2.0D;
		entity.motionY /= 2.0D;
		entity.motionZ /= 2.0D;
		entity.motionX -= xMotion / (double) f1;
		entity.motionY += yMotion;
		entity.motionZ -= zMotion / (double) f1;

	}

	@Override
	public void knockBack(Entity entity, float f, double x, double z) {
		if (entity != null && entity instanceof EntityNewPrehistoric) {
			if (this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue() <= 0 && this.onGround) {
				this.velocityChanged = false;
				knockBackMob(entity, 1, 0.4D, 1);
			}
		} else {
			super.knockBack(entity, f, x, z);
		}
	}

	public boolean canDinoHunt(Entity target) {
		if (this.selfType.diet != EnumDiet.HERBIVORE && this.selfType.diet != EnumDiet.NONE && canAttackClass(target.getClass())) {
			if (width >= target.width) {
				if (target instanceof EntityNewPrehistoric) {
					EntityNewPrehistoric mob = (EntityNewPrehistoric) target;
					if (mob.selfType.diet.fearIndex > selfType.diet.fearIndex) ;
				}
				return isHungry();
			}
		}
		return false;
		/*	if(this.selfType.diet != EnumDiet.HERBIVORE && this.selfType.diet != EnumDiet.NONE){
			if(mobBoundingBoxDistance >= targetBoundingBoxDistance){	
				return true;
				if(target instanceof EntityNewPrehistoric){
					EntityNewPrehistoric prehistoric = (EntityNewPrehistoric)target;
					if(prehistoric.selfType.diet.fearIndex <= mob.selfType.diet.fearIndex){

						return true;	
					}
				}else{
					return true;
				}
			}
		}
		return false; */
	}

	public EntityLivingBase getClosestEntity() {
		Entity targetEntity;
		EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter = new EntityAINearestAttackableTarget.Sorter(this);
		IEntitySelector targetEntitySelector = new IEntitySelector() {
			@Override
			public boolean isEntityApplicable(Entity entity) {
				return (entity instanceof EntityLivingBase);
			}
		};
		double d0 = 64;
		List list = worldObj.selectEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(d0, 4.0D, d0), targetEntitySelector);
		Collections.sort(list, theNearestAttackableTargetSorter);

		if (list.isEmpty()) {
			return null;
		} else {
			return (EntityLivingBase) list.get(0);
		}
	}

	public boolean isThereNearbyTypes() {
		Entity targetEntity;
		EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter = new EntityAINearestAttackableTarget.Sorter(this);
		IEntitySelector targetEntitySelector = new IEntitySelector() {
			@Override
			public boolean isEntityApplicable(Entity entity) {
				return (entity instanceof EntityNewPrehistoric);
			}
		};
		double d0 = 64;
		List<EntityNewPrehistoric> list = worldObj.selectEntitiesWithinAABB(EntityNewPrehistoric.class, this.boundingBox.expand(d0, 4.0D, d0), targetEntitySelector);
		Collections.sort(list, theNearestAttackableTargetSorter);

		if (list.isEmpty() || this.doesFlock()) {
			return false;
		} else {
			List<EntityNewPrehistoric> listOfType = new ArrayList<EntityNewPrehistoric>();
			for (EntityNewPrehistoric mob : list) {
				if (mob.selfType == this.selfType && mob.isAdult()) {
					listOfType.add(mob);
				}
			}
			return listOfType.size() > this.nearByMobsAllowed;
		}
	}

	public void doFoodEffect(Item item) {
		if (item != null) {
			spawnItemParticle(item);
		}
		this.worldObj.playSoundAtEntity(this, "random.eat", this.getSoundVolume(), this.getSoundPitch());
	}

	public void spawnItemParticle(Item item) {
		double motionX = rand.nextGaussian() * 0.07D;
		double motionY = rand.nextGaussian() * 0.07D;
		double motionZ = rand.nextGaussian() * 0.07D;
		float f = (float) (getRNG().nextFloat() * (this.boundingBox.maxX - this.boundingBox.minX) + this.boundingBox.minX);
		float f1 = (float) (getRNG().nextFloat() * (this.boundingBox.maxY - this.boundingBox.minY) + this.boundingBox.minY);
		float f2 = (float) (getRNG().nextFloat() * (this.boundingBox.maxZ - this.boundingBox.minZ) + this.boundingBox.minZ);
		worldObj.spawnParticle("iconcrack_" + Item.getIdFromItem(item) + "_0", f, f1, f2, motionX, motionY, motionZ);
	}

	public void eatItem(ItemStack stack) {
		if (stack != null && stack.stackSize > 0 && stack.getItem() != null) {
			if (FoodMappings.instance().getItemFoodAmount(stack.getItem(), selfType.diet) != 0) {
				this.setMood(this.getMood() + 5);
				doFoodEffect(stack.getItem());
				Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), Item.getIdFromItem(stack.getItem())));
				this.setHunger(this.getHunger() + FoodMappings.instance().getItemFoodAmount(stack.getItem(), selfType.diet));
				stack.stackSize--;
			}
		}
	}

	public void eatBlock(int destX, int destY, int destZ) {
		Block block = worldObj.getBlock(destX, destY, destZ);
		if (FoodMappings.instance().getBlockFoodAmount(block, selfType.diet) != 0) {
			this.heal(Math.round(FoodMappings.instance().getBlockFoodAmount(block, selfType.diet) / 10));
			doFoodEffect(Item.getItemFromBlock(block));
			Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), block));
		}
	}

	public String getTempermentString() {
		String s = null;
		if (this.aiResponseType() == Response.AGRESSIVE || this.aiResponseType() == Response.WATERAGRESSIVE) {
			s = "agressive";
		} else if (this.aiResponseType() == Response.SCARED) {
			s = "scared";
		} else if (this.aiResponseType() == Response.NONE || this.aiResponseType() == Response.WATERCALM) {
			s = "none";
		} else if (this.aiResponseType() == Response.TERITORIAL) {
			s = "territorial";
		}
		return "pedia.temperament." + s;
	}

	public boolean canRunFrom(Entity entity) {
		if (width <= entity.width) {
			if (entity instanceof EntityNewPrehistoric) {
				EntityNewPrehistoric mob = (EntityNewPrehistoric) entity;
				if (mob.selfType.diet != EnumDiet.HERBIVORE){
					return true;
				}
			}else{
				if(entity instanceof EntityPlayer){
					EntityPlayer player = (EntityPlayer)entity;
					if(this.getOwner() == player){
						return false;
					}
				}
				return true;		
			}
		}
		return false;
	}
	
	public void setNavigator(){
		float f = 0;
		try {
			ReflectionHelper.findField(EntityLiving.class, new String[]{"field_70699_by", "navigator"}).set(this, new PathNavigateClimber(this, this.worldObj));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
