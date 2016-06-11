package com.github.revival.server.entity.mob.test;

import com.github.revival.Revival;
import com.github.revival.server.api.IPrehistoricAI;
import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.block.entity.TileEntityNewFeeder;
import com.github.revival.server.entity.EntityDinoEgg;
import com.github.revival.server.enums.*;
import com.github.revival.server.enums.EnumPrehistoricAI.*;
import com.github.revival.server.handler.LocalizationStrings;
import com.github.revival.server.item.FAItemRegistry;
import com.github.revival.server.message.MessageFoodParticles;
import com.github.revival.server.message.MessageHappyParticles;
import com.github.revival.server.message.MessageSetDay;
import com.github.revival.server.message.MessageUpdateEgg;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fossilsarcheology.api.EnumDiet;
import fossilsarcheology.api.FoodMappings;
import net.ilexiconn.llibrary.client.model.tools.ChainBuffer;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
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
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class EntityNewPrehistoric extends EntityTameable implements IPrehistoricAI, IAnimatedEntity {

	public static Animation SPEAK_ANIMATION;
	public static Animation ATTACK_ANIMATION;
	public float minSize;
	public float maxSize;
	public int teenAge;
	public EnumPrehistoric type;
	public ItemStack ItemInMouth = null;
	public EnumOrderType currentOrder;
	public boolean hasFeatherToggle = false;
	public boolean featherToggle;
	public boolean hasTeenTexture = false;
	public boolean hasBabyTexture;
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
	public ChainBuffer chainBuffer;
	public float pediaScale;
	public boolean mood_nospace;
	public boolean mood_noplants;
	protected int nearByMobsAllowed;
	public int ticksTillPlay;
	public int ticksTillMate;
	public int prevAge;
	public boolean isDaytime;
	public Flock flockObj;
	public double baseDamage;
	public double maxDamage;
	public double baseHealth;
	public double maxHealth;
	public double baseSpeed;
	public double maxSpeed;

	public EntityNewPrehistoric(World world, EnumPrehistoric type, double baseDamage, double maxDamage, double baseHealth, double maxHealth, double baseSpeed, double maxSpeed) {
		super(world);
		this.setHunger(this.getMaxHunger() / 2);
		this.setScale(this.getAgeScale());
		SPEAK_ANIMATION = Animation.create(this.getSpeakLength());
		ATTACK_ANIMATION = Animation.create(this.getAttackLength());
		this.hasBabyTexture = true;
		this.type = type;
		this.pediaScale = 1.0F;
		this.nearByMobsAllowed = 15;
		this.currentOrder = EnumOrderType.WANDER;
		if (ticksTillMate == 0) {
			ticksTillMate = this.rand.nextInt(6000) + 6000;
		}
		if (FMLCommonHandler.instance().getSide().isClient()) {
			this.chainBuffer = new ChainBuffer();
		}
		this.baseDamage = baseDamage;
		this.maxDamage = maxDamage;
		this.baseHealth = baseHealth;
		this.maxHealth = maxHealth;
		this.baseSpeed = baseSpeed;
		this.maxSpeed = maxSpeed;
		this.updateAbilities();
		this.setHealth(this.getMaxHealth());
	}

	public static boolean isCannibalistic() {
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
		this.dataWatcher.addObject(18, 0);
		this.dataWatcher.addObject(19, 30);
		this.dataWatcher.addObject(20, 1);
		this.dataWatcher.addObject(21, (byte) -1);
		this.dataWatcher.addObject(22, 0);
		this.dataWatcher.addObject(23, (byte) 0);
		this.dataWatcher.addObject(24, 0);
		this.dataWatcher.addObject(25, 0);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("AgeTick", this.getAgeInTicks());
		compound.setInteger("Hunger", this.getHunger());
		compound.setBoolean("isModelized", this.isSkeleton());
		compound.setBoolean("Angry", this.isAngry());
		compound.setInteger("SubSpecies", this.getSubSpecies());
		compound.setInteger("Gender", this.getGender());
		compound.setBoolean("Sleeping", this.isSleeping);
		compound.setInteger("Mood", this.getMood());
		compound.setBoolean("Sitting", this.isSitting);
		compound.setBoolean("MoodNoSpace", this.mood_nospace);
		compound.setBoolean("MoodNoPlants", this.mood_noplants);
		compound.setInteger("TicksSincePlay", this.ticksTillPlay);
		compound.setInteger("TicksSinceMate", this.ticksTillMate);
		compound.setByte("CurrentOrder", (byte) this.currentOrder.ordinal());
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1D);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.setAgeinTicks(compound.getInteger("AgeTick"));
		this.setHunger(compound.getInteger("Hunger"));
		this.setSkeleton(compound.getBoolean("isModelized"));
		this.setAngry(compound.getBoolean("Angry"));
		this.setSubSpecies(compound.getInteger("SubSpecies"));
		this.setGender(compound.getInteger("Gender"));
		this.setSleeping(compound.getBoolean("Sleeping"));
		this.setSitting(compound.getBoolean("Sitting"));
		this.setMood(compound.getInteger("Mood"));
		this.setOrder(EnumOrderType.values()[compound.getByte("currentOrder")]);
		this.mood_nospace = compound.getBoolean("MoodNoSpace");
		this.mood_noplants = compound.getBoolean("MoodNoPlants");
		this.ticksTillPlay = compound.getInteger("TicksSincePlay");
		this.ticksTillMate = compound.getInteger("TicksSinceMate");
	}

	protected AxisAlignedBB getAttackBounds() {
		return this.boundingBox.expand(1.0F, 1.0F, 1.0F);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		Random random = new Random();
		this.setAgeInDays(this.getAdultAge());
		this.heal(200);
		this.setSpawnValues();
		this.setGender(random.nextInt(2));
		this.updateAbilities();
		ticksTillPlay = 0;
		ticksTillMate = 24000;
		return data;
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


	public boolean isDeadlyHungry() {
		return this.getHunger() < this.getMaxHunger() * (1 - this.type.HungryLevel);
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
			boolean isSleeping = (this.dataWatcher.getWatchableObjectByte(23) & 1) != 0;

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
					if (this.posY + dy >= 0 && this.posY + dy <= this.worldObj.getHeight() && FoodMappings.instance().getBlockFoodAmount(this.worldObj.getBlock(x, y, z), type.diet) != 0) {
						pos = Vec3.createVectorHelper(x, y, z);
						return pos;
					}

					if (this.posY + dy >= 0 && this.posY + dy <= this.worldObj.getHeight() && FoodMappings.instance().getBlockFoodAmount(this.worldObj.getBlock(x, y, z), type.diet) != 0) {
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

					if (this.posY + dy >= 0 && this.posY + dy <= this.worldObj.getHeight() && FoodMappings.instance().getBlockFoodAmount(this.worldObj.getBlock(x, y, z), type.diet) != 0) {
						pos = Vec3.createVectorHelper(x, y, z);
						return pos;
					}

					if (this.posY + dy >= 0 && this.posY + dy <= this.worldObj.getHeight() && FoodMappings.instance().getBlockFoodAmount(this.worldObj.getBlock(x, y, z), type.diet) != 0) {
						pos = Vec3.createVectorHelper(x, y, z);
						return pos;
					}
				}
			}
		}

		return null;
	}

	@Override
	public boolean allowLeashing() {
		return !this.getLeashed() && !(this instanceof IMob) && this.isTamed();
	}

	public void setOrder(EnumOrderType var1) {
		this.currentOrder = var1;
	}

	@Override
	protected boolean canDespawn() {
		return false;
	}

	public TileEntityNewFeeder getNearestFeeder(int feederRange) {
		for (int dx = -2; dx != -(feederRange + 1); dx += (dx < 0) ? (dx * -2) : (-(2 * dx + 1))) {
			for (int dy = -5; dy < 4; dy++) {
				for (int dz = -2; dz != -(feederRange + 1); dz += (dz < 0) ? (dz * -2) : (-(2 * dz + 1))) {
					if (this.posY + dy >= 0 && this.posY + dy <= this.worldObj.getHeight()) {
						TileEntity feeder = this.worldObj.getTileEntity(MathHelper.floor_double(this.posX + dx), MathHelper.floor_double(this.posY + dy), MathHelper.floor_double(this.posZ + dz));

						if (feeder != null && feeder instanceof TileEntityNewFeeder && !((TileEntityNewFeeder) feeder).isEmpty(type)) {
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

	public int getNearestBubbleBlock(int range, int type) {
		for (int r = 1; r <= range; r++) {
			for (int ds = -r; ds <= r; ds++) {
				for (int dy = 4; dy > -5; dy--) {
					int x = MathHelper.floor_double(this.posX + ds);
					int y = MathHelper.floor_double(this.posY + dy);
					int z = MathHelper.floor_double(this.posZ - r);
					if (this.posY + dy >= 0 && this.posY + dy <= this.worldObj.getHeight() && this.worldObj.getBlock(x, y, z) == FABlockRegistry.INSTANCE.bubbleMachine && this.worldObj.isBlockIndirectlyGettingPowered(x, y, z)) {
						switch (type) {
						case 0:
							return x;
						case 1:
							return y;
						case 2:
							return z;
						}
					}

					if (this.posY + dy >= 0 && this.posY + dy <= this.worldObj.getHeight() && this.worldObj.getBlock(x, y, z) == FABlockRegistry.INSTANCE.bubbleMachine && this.worldObj.isBlockIndirectlyGettingPowered(x, y, z)) {
						switch (type) {
						case 0:
							return x;
						case 1:
							return y;
						case 2:
							return z;
						}
					}
				}
			}

		}
		return 0;
	}

	public boolean isPlantBlock(Block block) {
		return block.getMaterial() == Material.grass || block.getMaterial() == Material.plants || block.getMaterial() == Material.leaves;
	}

	public boolean canSleep() {
		if (!this.onGround) {
			return false;
		}
		if (this.aiActivityType() == Activity.DIURINAL && !this.isDaytime()) {
			return true;
		}
		if (this.aiActivityType() == Activity.NOCTURNAL && this.isDaytime() && !this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), (int) this.boundingBox.minY, MathHelper.floor_double(this.posZ))) {
			return true;
		}
		return this.aiActivityType() == Activity.BOTH;
	}

	public boolean isDaytime() {
		if (worldObj.isRemote) {
			return isDaytime;
		} else {
			Revival.NETWORK_WRAPPER.sendToAll(new MessageSetDay(this.getEntityId(), this.worldObj.isDaytime()));
			return this.worldObj.isDaytime();
		}
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (this.getHunger() > this.getMaxHunger()) {
			this.setHunger(this.getMaxHunger());
		}
		if (this.getMood() > 100) {
			this.setMood(100);
		}
		if (this.getMood() < -100) {
			this.setMood(-100);
		}
		if (this.ticksTillPlay > 0) {
			this.ticksTillPlay--;
		}
		if (this.ticksTillMate > 0) {
			this.ticksTillMate--;
		}
		int blockX = MathHelper.floor_double(this.posX);
		int blockY = MathHelper.floor_double(this.boundingBox.minY) - 1;
		int blockZ = MathHelper.floor_double(this.posZ);
		if (this.getBlockUnder() == FABlockRegistry.INSTANCE.bubbleMachine && this.worldObj.isBlockIndirectlyGettingPowered(blockX, blockY, blockZ) && this.ticksTillPlay == 0) {
			this.jump();
			for (int i = 0; i < 1; ++i) {
				double dd = this.getRNG().nextGaussian() * 0.02D;
				double dd1 = this.getRNG().nextGaussian() * 0.02D;
				double dd2 = this.getRNG().nextGaussian() * 0.02D;
				Revival.PROXY.spawnPacketHeartParticles(this.worldObj, (float) (this.posX + (this.getRNG().nextFloat() * this.width * 2.0F) - this.width), (float) (this.posY + 0.5D + (this.getRNG().nextFloat() * this.height)), (float) (this.posZ + (this.getRNG().nextFloat() * this.width * 2.0F) - this.width), dd, dd1, dd2);
			}
			this.doPlayBonus(15);
		}
		if (ticksTillMate == 0 && this.getGender() == 1) {
			this.mate();
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
			ticksSitted++;
		}
		if (this.isSleeping()) {
			ticksSlept++;
		}

		if (!worldObj.isRemote && !this.isInWater() && !this.isSitting() && this.getRNG().nextInt(100) == 1 && !this.isRiding() && (this.getAnimation() == NO_ANIMATION || this.getAnimation() == SPEAK_ANIMATION) && !this.isSleeping()) {
			this.setSitting(true);
			ticksSitted = 0;
		}

		if (!worldObj.isRemote && !this.isInWater() && (this.isSitting() && ticksSitted > 100 && this.getRNG().nextInt(100) == 1 || this.getAttackTarget() != null) && !this.isSleeping()) {
			this.setSitting(false);
			ticksSitted = 0;
		}
		if (!worldObj.isRemote && !this.isInWater() && this.getRNG().nextInt(500) == 1 && this.canSleep() && (this.getAnimation() == NO_ANIMATION || this.getAnimation() == SPEAK_ANIMATION)) {
			this.setSitting(false);
			this.setSleeping(true);
			ticksSlept = 0;
		}

		if (!worldObj.isRemote && !this.isInWater() && (!this.canSleep() || (this.isSleeping() && ticksSlept > 200 && this.getRNG().nextInt(1000) == 1 || this.getAttackTarget() != null))) {
			this.setSitting(false);
			this.setSleeping(false);
			ticksSlept = 0;
		}

		if (breaksBlocks) {
			this.breakBlock(5);
		}

		if (this.doesFlock() && flockObj == null) {
			if (this.getNearbyFlock() != null) {
				this.getNearbyFlock().flockMembers.add(this);
			} else {
				flockObj = new Flock();
				flockObj.createFlock(this);
			}
		}
		if (this.flockObj != null) {
			if (this == flockObj.flockLeader) {
				this.flockObj.onUpdate();
			}
		}
	}

	public Block getBlockUnder() {
		int blockX = MathHelper.floor_double(this.posX);
		int blockY = MathHelper.floor_double(this.boundingBox.minY) - 1;
		int blockZ = MathHelper.floor_double(this.posZ);
		return this.worldObj.getBlock(blockX, blockY, blockZ);
	}

	public EntityNewPrehistoric findFlockLeader(List<EntityNewPrehistoric> flock) {
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

	@Override
	public void onUpdate() {
		super.onUpdate();
		this.setAgeinTicks(this.getAgeInTicks() + 1);
		if (this.getAgeInTicks() % 24000 == 0) {
			this.updateAbilities();
		}

		if (this.getAgeInTicks() % 1200 == 0 && this.getHunger() > 0) {
			this.setHunger(this.getHunger() - 1);
		}

		boolean sitting = isSitting();
		if (sitting && sitProgress < 20.0F) {
			sitProgress += 0.5F;
			if (sleepProgress != 0)
				sleepProgress = 0F;
		} else if (!sitting && sitProgress > 0.0F) {
			sitProgress -= 0.5F;
			if (sleepProgress != 0)
				sleepProgress = 0F;
		}
		boolean sleeping = isSleeping();
		if (sleeping && sleepProgress < 20.0F) {
			sleepProgress += 0.5F;
			if (sitProgress != 0)
				sitProgress = 0F;
		} else if (!sleeping && sleepProgress > 0.0F) {
			sleepProgress -= 0.5F;
			if (sitProgress != 0)
				sitProgress = 0F;
		}
		boolean climbing = this.aiClimbType() == Climbing.ARTHROPOD && (this.isBesideClimbableBlock() && !this.onGround);
		if (climbing && climbProgress < 20.0F) {
			climbProgress += 1F;
			if (sitProgress != 0)
				sitProgress = 0F;
		} else if (!climbing && climbProgress > 0.0F) {
			climbProgress -= 1F;
			if (sitProgress != 0)
				sitProgress = 0F;
		}
		if (!this.worldObj.isRemote) {
			if (this.aiClimbType() == Climbing.ARTHROPOD) {
				this.setBesideClimbableBlock(this.isCollidedHorizontally);
			} else {
				this.setBesideClimbableBlock(false);
			}
		}
		Revival.PROXY.calculateChainBuffer(this);
		AnimationHandler.INSTANCE.updateAnimations(this);
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
		return this.getClass() != clazz && clazz != EntityDinoEgg.class;
	}

	public float getAgeScale() {
		float step = (this.maxSize - this.minSize) / ((this.getAdultAge() * 24000) + 1);
		if (this.getAgeInTicks() > this.getAdultAge() * 24000) {
			return this.minSize + ((step) * this.getAdultAge() * 24000);
		}
		return this.minSize + ((step * this.getAgeInTicks()));
	}

	@Override
	protected int getExperiencePoints(EntityPlayer par1EntityPlayer) {
		return MathHelper.floor_float(this.type.Exp0 + (float) this.getAgeInDays() * this.type.ExpInc);
	}

	public void updateAbilities() {
		double healthStep = (maxHealth - baseHealth) / (this.getAdultAge());
		double attackStep = (maxDamage - baseDamage) / (this.getAdultAge());
		double speedStep = (maxSpeed - baseSpeed) / (this.getAdultAge());
		if (this.getAgeInDays() <= this.getAdultAge()) {
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Math.round(baseHealth + (healthStep * this.getAgeInDays())));
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(Math.round(baseDamage + (attackStep * this.getAgeInDays())));
			this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed + (speedStep * this.getAgeInDays()));
			if (this.developsResistance) {
				if (this.isTeen()) {
					this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5D);
				} else if (this.isAdult()) {
					this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(2.0D);
				} else {
					this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
				}
			}
		}
	}

	public void breakBlock(float hardness) {
		if (Revival.CONFIG.dinoBlockBreaking) {
			if (!isSkeleton() && this.isAdult() && this.isHungry()) {
				for (int a = (int) Math.round(this.boundingBox.minX) - 1; a <= (int) Math.round(this.boundingBox.maxX) + 1; a++) {
					for (int b = (int) Math.round(this.boundingBox.minY) + 1; (b <= (int) Math.round(this.boundingBox.maxY) + 3) && (b <= 127); b++) {
						for (int c = (int) Math.round(this.boundingBox.minZ) - 1; c <= (int) Math.round(this.boundingBox.maxZ) + 1; c++) {

							Block block = worldObj.getBlock(a, b, c);
							if (!(block instanceof BlockBush) && !(block instanceof BlockLiquid) && block != Blocks.bedrock && block != FABlockRegistry.INSTANCE.ancientGlass && block != FABlockRegistry.INSTANCE.strongGlass && block.getBlockHardness(worldObj, a, b, c) < hardness) {
								this.motionX *= 0.6D;
								this.motionZ *= 0.6D;
								if (block != Blocks.air) {
									if (!worldObj.isRemote) {
										worldObj.func_147480_a(a, b, c, true);
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
		this.setScale(this.getAgeScale());
	}

	public Entity createEgg(EntityAgeable entity) {
		Entity baby = null;
		if (this.type.type == EnumMobType.MAMMAL) {
			baby = this.type.invokeClass(this.worldObj);
		}
		if (this.type.type == EnumMobType.BIRD) {
			baby = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(this.type.birdEggItem));
		}
		if (this.type.type == EnumMobType.DINOSAUR) {
			// baby = new EntityItem(this.worldObj, this.posX, this.posY,
					// this.posZ, new ItemStack(this.selfType.birdEggItem));
			baby = new EntityDinoEgg(this.worldObj, this.type);
			((EntityDinoEgg) baby).selfType = this.type;
		}
		return baby;
	}

	public boolean isAdult() {
		return this.getAgeInDays() >= getAdultAge();
	}

	public boolean isTeen() {
		return this.getAgeInDays() >= teenAge && this.getAgeInDays() < getAdultAge();
	}

	@Override
	public boolean isChild() {
		return this.getAgeInDays() < teenAge;
	}

	public int getMaxHunger() {
		return 100;
	}

	public boolean isSkeleton() {
		return this.dataWatcher.getWatchableObjectByte(21) >= 0;
	}

	public void setSkeleton(boolean skeleton) {
		if (this.type.isModelable()) {
			this.dataWatcher.updateObject(21, (byte) (skeleton ? 0 : -1));
		}
	}

	public int getAgeInDays() {
		return this.dataWatcher.getWatchableObjectInt(20) / 24000;
	}

	public void setAgeInDays(int days) {
		this.dataWatcher.updateObject(20, days * 24000);
	}

	public int getAgeInTicks() {
		return this.dataWatcher.getWatchableObjectInt(20);
	}

	public void setAgeinTicks(int ticks) {
		this.dataWatcher.updateObject(20, ticks);
	}

	public int getHunger() {
		return this.dataWatcher.getWatchableObjectInt(19);
	}

	public void setHunger(int hunger) {
		if (this.getHunger() > this.getMaxHunger()) {
			this.dataWatcher.updateObject(19, 100);
		} else {
			this.dataWatcher.updateObject(19, hunger);
		}
	}

	public boolean increaseHunger(int hunger) {
		if (this.getHunger() >= this.getMaxHunger()) {
			return false;
		}
		this.setHunger(this.getHunger() + hunger);
		if (this.getHunger() > this.getMaxHunger()) {
			this.setHunger(this.getMaxHunger());
		}
		this.worldObj.playSoundAtEntity(this, "random.eat", this.getSoundVolume(), this.getSoundPitch());
		return true;
	}

	@Override
	public void onKillEntity(EntityLivingBase var1) {
		super.onKillEntity(var1);
		this.increaseHunger(FoodMappings.instance().getEntityFoodAmount(var1.getClass(), this.type.diet));
		this.heal(FoodMappings.instance().getEntityFoodAmount(var1.getClass(), this.type.diet) / 3);
		this.setMood(this.getMood() + 25);
	}

	public boolean isHungry() {
		return this.getHunger() < this.getMaxHunger() * 0.75F;
	}

	public boolean IsDeadlyHungry() {
		return this.getHunger() < this.getMaxHunger() * 0.25F;
	}

	public void sendStatusMessage(EnumSituation var1) {
		if (this.getOwner() != null && this.getDistanceToEntity(this.getOwner()) < 50.0F) {
			String Status1 = StatCollector.translateToLocal(("status." + var1.toString() + ".head"));
			String Dino = this.type.toString();
			String Status2 = StatCollector.translateToLocal("status." + var1.toString());
			Revival.showMessage(Status1 + Dino + " " + Status2, (EntityPlayer) this.getOwner());
		}
	}

	@Override
	public boolean isOnLadder() {
		if (this.aiMovingType() == Moving.AQUATIC || this.aiMovingType() == Moving.SEMIAQUATIC) {
			return false;
		} else
			return this.aiClimbType() == Climbing.ARTHROPOD && this.isBesideClimbableBlock();
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
		return this.dataWatcher.getWatchableObjectInt(20);
	}

	public void setSubSpecies(int var1) {
		this.dataWatcher.updateObject(20, var1);
	}

	public int getGender() {
		return this.dataWatcher.getWatchableObjectInt(24);
	}

	public void setGender(int var1) {
		this.dataWatcher.updateObject(24, var1);
	}

	public void setSleeping(boolean sleeping) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(23);

		if (sleeping) {
			this.dataWatcher.updateObject(23, (byte) (b0 | 1));
		} else {
			this.dataWatcher.updateObject(23, (byte) (b0 & -2));
		}

		if (!worldObj.isRemote) {
			this.isSleeping = sleeping;
		}
	}

	public int getMood() {
		return this.dataWatcher.getWatchableObjectInt(25);
	}

	public void setMood(int var1) {
		this.dataWatcher.updateObject(25, var1);
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
		if (i > 0) {
			this.setSitting(false);
			this.setSleeping(false);
		}
		if (dmg.getEntity() != null)
			this.setMood(this.getMood() - 5);
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
		return (this.dataWatcher.getWatchableObjectInt(22) & 1) != 0;
	}

	public void setBesideClimbableBlock(boolean isClollided) {
		int b0 = this.dataWatcher.getWatchableObjectInt(22);

		if (isClollided) {
			b0 = (byte) (b0 | 1);
		} else {
			b0 &= -2;
		}

		this.dataWatcher.updateObject(22, b0);
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
		super.jump();
		this.motionY = 1;
	}

	@Override
	public boolean interact(EntityPlayer player) {
		ItemStack itemstack = player.inventory.getCurrentItem();
		if (this.isSkeleton()) {
			if (itemstack == null) {
				if (player.isSneaking()) {
					this.nudgeEntity(player);
				} else {
					this.faceEntity(player, 360.0F, 360.0F);
				}
			} else {
				if (itemstack.getItem() == Items.bone) {
					// this.increaseDinoAge();

					if (!player.capabilities.isCreativeMode) {
						--itemstack.stackSize;
					}

					if (itemstack.stackSize <= 0) {
						player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
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
							this.func_152115_b(player.getUniqueID().toString());
							--itemstack.stackSize;
							if (itemstack.stackSize <= 0) {
								player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
							}
							return true;
						}
					}
				}
			}

			if (itemstack != null) {
				if (itemstack.getItem() == FAItemRegistry.INSTANCE.chickenEss && !player.worldObj.isRemote) {
					// Be grown up by chicken essence
					if (this.getAgeInDays() < this.getAdultAge() && this.getHunger() > 0) {
						if (this.getHunger() > 0) {
							if (!player.capabilities.isCreativeMode) {
								--itemstack.stackSize;
							}

							if (itemstack.stackSize <= 0) {
								player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
							}

							if (!player.capabilities.isCreativeMode) {
								player.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle, 1));
							}
							Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), Item.getIdFromItem(FAItemRegistry.INSTANCE.chickenEss)));
							// this.increaseDinoAge();
							this.setHunger(1 + (new Random()).nextInt(this.getHunger()));
							this.func_152115_b(player.getDisplayName());
							return true;
						}
					}

					if (!this.worldObj.isRemote) {
						Revival.showMessage(StatCollector.translateToLocal(LocalizationStrings.STATUS_ESSENCE_FAIL), player);
					}

					return false;
				}

				if (FoodMappings.instance().getItemFoodAmount(itemstack.getItem(), this.type.diet) != 0) {
					if (!player.worldObj.isRemote) {
						if (this.getMaxHunger() > this.getHunger() || this.getHealth() > this.getMaxHealth() && Revival.CONFIG.healingDinos) {

							this.setHunger(this.getHunger() + FoodMappings.instance().getItemFoodAmount(itemstack.getItem(), this.type.diet));
							if (!worldObj.isRemote)
								this.eatItem(itemstack);
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
								if (!this.isTamed() && this.type.isTameable() && (new Random()).nextInt(10) == 1) {
									this.setTamed(true);
									this.func_152115_b(player.getUniqueID().toString());
									this.worldObj.setEntityState(this, (byte) 35);
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

					if (FMLCommonHandler.instance().getSide().isClient() && itemstack.getItem() == FAItemRegistry.INSTANCE.dinoPedia) {

						this.setPedia();
						player.openGui(Revival.INSTANCE, 4, this.worldObj, (int) this.posX, (int) this.posY, (int) this.posZ);
						return true;
					}

					if (itemstack.getItem() == FAItemRegistry.INSTANCE.whip && this.type.isRideable() && this.isAdult() && !this.worldObj.isRemote) {

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

							this.setMood(this.getMood() - 1);
							Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), FABlockRegistry.INSTANCE.volcanicRock));
							if (getRNG().nextInt(15) == 0) {
								this.setMood(this.getMood() - 25);
								this.setTamed(true);
								Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), Item.getIdFromItem(Items.gold_ingot)));
								this.func_152115_b(player.getUniqueID().toString());
							}
						}
						this.setSitting(false);
						// this.setOrder(EnumOrderType.WANDER);

						// this.currentOrder = EnumOrderType.FreeMove;
						// setRidingPlayer(player);
					}

					if (this.getOrderItem() != null && itemstack.getItem() == this.getOrderItem() && this.isTamed() && func_152114_e(player) && !player.isRiding()) {
						// THIS DINOS ITEM TO BE CONTROLLED WITH
						if (!this.worldObj.isRemote) {
							this.isJumping = false;
							this.setPathToEntity(null);
							this.currentOrder = EnumOrderType.values()[(this.currentOrder.ordinal() + 1) % 3];

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
		// player.triggerAchievement(FossilAchievementHandler.theKing);

	}

	private boolean isWeak() {
		return (this.getHealth() < 8) && (this.getAgeInDays() >= this.getAdultAge()) && !this.isTamed();
	}

	protected void setPedia() {
		Revival.toPedia = this;
	}

	private void sendOrderMessage(EnumOrderType var1) {
		String S = StatCollector.translateToLocal(LocalizationStrings.ORDER_HEAD) + StatCollector.translateToLocal("order." + var1.toString().toLowerCase());
		Revival.showMessage(S, (EntityPlayer) this.getOwner());
	}

	public void nudgeEntity(EntityPlayer player) {
		this.setPositionAndUpdate(this.posX + (player.posX - this.posX) * 0.01F, this.posY, this.posZ + (player.posZ - this.posZ) * 0.01F);
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
		String gender = this.hasTeenTexture ? this.isTeen() ? "_teen" : isBaby ? "_baby" : this.getGender() == 0 ? "_female" : "_male" : this.isChild() ? "_baby" : this.getGender() == 0 ? "_female" : "_male";
		String sleeping = !this.isSleeping() ? "" : "_sleeping";
		String toggleList = this.hasFeatherToggle ? !this.featherToggle ? "_feathered" : "_scaled" : "";
		return "fossil:textures/model/" + type.toString().toLowerCase() + "_0/" + toggle + type.toString().toLowerCase() + gender + toggleList + sleeping + ".png";
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
		if (this.isSleeping()) {
			super.playLivingSound();
			if (this.getAnimation() != null) {
				if (this.getAnimation() == NO_ANIMATION && !worldObj.isRemote) {
					this.setAnimation(SPEAK_ANIMATION);
				}
			}
		}
	}

	public void knockbackEntity(Entity knockBackMob, float knockbackStrength, float knockbackStrengthUp) {
		if (!(knockBackMob instanceof EntityToyBase)) {
			knockBackMob.motionY += 0.4000000059604645D;
			knockBackMob(knockBackMob, 1, 0.4D, 1);
		}
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

	public boolean canDinoHunt(Entity target, boolean hunger) {

		if (this.type.diet != EnumDiet.HERBIVORE && this.type.diet != EnumDiet.NONE && canAttackClass(target.getClass())) {
			if (width >= target.width) {
				return (hunger ? isHungry() : true) || target instanceof EntityToyBase && this.ticksTillPlay == 0;
			}
		}
		return target instanceof EntityToyBase && this.ticksTillPlay == 0;
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

	public Flock getNearbyFlock() {
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
		if (!list.isEmpty()) {
			for (EntityNewPrehistoric mob : list) {
				if (mob.type == this.type && mob.flockObj != null && mob.flockObj.flockLeader == mob) {
					return mob.flockObj;
				}
			}
		}
		return null;
	}

	public void mate() {
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
		List<EntityNewPrehistoric> listOfFemales = new ArrayList<EntityNewPrehistoric>();
		if (!list.isEmpty()) {
			for (EntityNewPrehistoric mob : list) {
				if (mob.type == this.type && mob.isAdult() && mob.getGender() == 0 && mob.ticksTillMate == 0) {
					listOfFemales.add(mob);
				}
			}
		}
		if (!listOfFemales.isEmpty() && this.ticksTillMate == 0) {
			EntityNewPrehistoric prehistoric = listOfFemales.get(0);
			this.getNavigator().tryMoveToEntityLiving(prehistoric, 1);
			double distance = (double) (this.width * 8.0F * this.width * 8.0F + prehistoric.width);

			if (this.getDistanceSq(prehistoric.posX, prehistoric.boundingBox.minY, prehistoric.posZ) <= distance && prehistoric.onGround && this.onGround) {
				prehistoric.procreate(this);
				this.ticksTillMate = this.rand.nextInt(6000) + 6000;
				prehistoric.ticksTillMate = this.rand.nextInt(12000) + 24000;
			}
		}
	}

	public void procreate(EntityNewPrehistoric mob) {
		for (int i = 0; i < 7; ++i) {
			double dd = this.rand.nextGaussian() * 0.02D;
			double dd1 = this.rand.nextGaussian() * 0.02D;
			double dd2 = this.rand.nextGaussian() * 0.02D;
			Revival.PROXY.spawnPacketHeartParticles(this.worldObj, (float) (this.posX + (this.rand.nextFloat() * this.width * 2.0F) - this.width), (float) (this.posY + 0.5D + (this.rand.nextFloat() * this.height)), (float) (this.posZ + (this.rand.nextFloat() * this.width * 2.0F) - this.width), dd, dd1, dd2);
			Revival.PROXY.spawnPacketHeartParticles(mob.worldObj, (float) (mob.posX + (mob.rand.nextFloat() * mob.width * 2.0F) - mob.width), (float) (mob.posY + 0.5D + (mob.rand.nextFloat() * mob.height)), (float) (mob.posZ + (mob.rand.nextFloat() * mob.width * 2.0F) - mob.width), dd, dd1, dd2);

		}
		if (this.rand.nextInt(15) == 0)
			this.playSound("fossil:music.mating", 1, 1);
		Entity hatchling = this.createEgg(mob);
		if (hatchling != null && !worldObj.isRemote) {
			this.entityToAttack = null;
			mob.entityToAttack = null;
			hatchling.setPositionAndRotation(this.posX, this.posY + 1, this.posZ, this.rotationYaw, 0);
			if (hatchling instanceof EntityDinoEgg) {
				Revival.NETWORK_WRAPPER.sendToAll(new MessageUpdateEgg(hatchling.getEntityId(), this.type.ordinal()));
			} else {
				if (hatchling instanceof EntityNewPrehistoric) {
					((EntityNewPrehistoric) hatchling).onSpawnWithEgg(null);
					((EntityNewPrehistoric) hatchling).setAgeInDays(1);
				}
			}
			this.worldObj.spawnEntityInWorld(hatchling);
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
				if (mob.type == this.type && mob.isAdult()) {
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
			if (FoodMappings.instance().getItemFoodAmount(stack.getItem(), type.diet) != 0) {
				this.setMood(this.getMood() + 5);
				doFoodEffect(stack.getItem());
				Revival.NETWORK_WRAPPER.sendToAll(new MessageFoodParticles(getEntityId(), Item.getIdFromItem(stack.getItem())));
				this.setHunger(this.getHunger() + FoodMappings.instance().getItemFoodAmount(stack.getItem(), type.diet));
				stack.stackSize--;
			}
		}
	}

	public void eatBlock(int destX, int destY, int destZ) {
		Block block = worldObj.getBlock(destX, destY, destZ);
		if (FoodMappings.instance().getBlockFoodAmount(block, type.diet) != 0) {
			this.heal(Math.round(FoodMappings.instance().getBlockFoodAmount(block, type.diet) / 10));
			this.setHunger(this.getHunger() + FoodMappings.instance().getBlockFoodAmount(block, type.diet));
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
				if (mob.type.diet != EnumDiet.HERBIVORE) {
					return true;
				}
			} else {
				if (entity instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) entity;
					if (this.getOwner() == player) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return null;
	}
}
