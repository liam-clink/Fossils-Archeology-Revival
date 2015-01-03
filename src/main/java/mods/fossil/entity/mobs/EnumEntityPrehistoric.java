package mods.fossil.entity.mobs;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;

public enum EnumEntityPrehistoric {
	
	;
	
	public static int FOOD_HABBIT_CARNIVORE = 0;
	public static int FOOD_HABBIT_HERBIVORE = 1;
	public static int FOOD_HABBIT_OMNIVORE = 2;
	
	private ArrayList<EnumEdibleFoodstuff> foodItems = new ArrayList<EnumEdibleFoodstuff>();
	private ArrayList<EnumEdibleFoodBlocks> foodBlocks = new ArrayList<EnumEdibleFoodBlocks>();
	private ArrayList<EnumEdibleFoodMob> foodMobs = new ArrayList<EnumEdibleFoodMob>();
	private ArrayList<EnumEntityPrehistoric> fleesFrom = new ArrayList<EnumEntityPrehistoric>();
	
	private double baseHealth;
	private double baseDamage;
	private double baseSpeed;
	private double baseStrength;
	private double maxHealth;
	private double maxDamage;
	private double maxSpeed;
	private double maxStrength;
	private double speedRunMult;
	private float baseSize;
	private float maxSize;
	private float baseExp;
	private float baseEyeHeight;
	private float baseBoundingBoxHeight;
	private float baseBoundingBoxWidth;
	private float expDaily;
	private float maxAwarenessRadius;
	private float immediateAwarenessRadius;
	private float herdWanderRadius;
	private float hungerLevel;
	private int maxHerdSize;
	private int targetFoodHabbit;
	private int maxHunger;
	private int adultAge;
	private int teenAge;
	private int hungerIfEaten;
	private int healIfEaten;
	private int ticksPerHungerDecrement;
	private boolean canFormHerds;
	private boolean tameable;
	private boolean rideable;
	private boolean canCarry;
	
	private final Class entityClass;
	
	private EnumEntityPrehistoric(Class entityClass, boolean tameable, boolean rideable, boolean canCarry, boolean canFormHerds, int targetFoodHabbit) {
		this.entityClass = entityClass;
		this.tameable = tameable;
		this.rideable = rideable;
		this.canCarry = canCarry;
		this.canFormHerds = canFormHerds;
		this.targetFoodHabbit = targetFoodHabbit;
	}
	
	public boolean shouldRunFromEntity(EntityPrehistoric e) {
		return fleesFrom.contains(e.getType());
	}
	
	public boolean willEat(Item item) {
		for(EnumEdibleFoodstuff foodItem: foodItems) {
			if(foodItem.isItem(item)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean willEat(Block block) {
		for(EnumEdibleFoodBlocks foodBlock: foodBlocks) {
			if(foodBlock.isBlock(block)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean willAttack(EntityLiving entity) {
		for(EnumEdibleFoodMob foodMob: foodMobs) {
			if(foodMob.isEntity(entity)) {
				return true;
			}
		}
		return false;
	}
	
	private void setDimensions(float baseBoundingBoxHeight, float baseBoundingBoxWidth, float baseEyeHeight) {
		this.baseBoundingBoxHeight = baseBoundingBoxHeight;
		this.baseBoundingBoxWidth = baseBoundingBoxWidth;
		this.baseEyeHeight = baseEyeHeight;
	}
	
	private void setBaseValues(double health, double damage, double speed, double strength, float size, float exp) {
		baseHealth = health;
		baseDamage = damage;
		baseSpeed = speed;
		baseStrength = strength;
		baseSize = size;
		baseExp = exp;
	}
	
	private void setMaxValues(double health, double damage, double speed, double strength, float size) {
		maxHealth = health;
		maxDamage = damage;
		maxSpeed = speed;
		maxStrength = strength;
		maxSize = size;
	}
	
	private void setHerdProperties(int maxHerdSize, float maxAwarenessRadius, float immediateAwarenessRadius, float herdWanderRadius) {
		this.maxHerdSize = maxHerdSize;
		this.maxAwarenessRadius = maxAwarenessRadius;
		this.immediateAwarenessRadius = immediateAwarenessRadius;
		this.herdWanderRadius = herdWanderRadius;
	}
	
	private void setAges(int teenAge, int adultAge) {
		this.teenAge = teenAge;
		this.adultAge = adultAge;
	}
	
	private void setIfEaten(int hunger, int health) {
		this.hungerIfEaten = hunger;
		this.healIfEaten = health;
	}
	
	private void setExpDaily(float expDaily) {
		this.expDaily = expDaily;
	}
	
	private void setSpeedRunMultiplier(double speedRunMult) {
		this.speedRunMult = speedRunMult;
	}
	
	private void setHungerProperties(float hungerLevel, int ticksPerHungerDecrement) {
		this.hungerLevel = hungerLevel;
		this.ticksPerHungerDecrement = ticksPerHungerDecrement;
	}
	
	public double getBaseHealth() {
		return baseHealth;
	}

	public double getBaseDamage() {
		return baseDamage;
	}

	public double getBaseSpeed() {
		return baseSpeed;
	}
	
	public double getBaseStrength() {
		return baseStrength;
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public double getMaxDamage() {
		return maxDamage;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}
	
	public double getMaxStrength() {
		return maxStrength;
	}

	public double getSpeedRunMult() {
		return speedRunMult;
	}

	public float getBaseSize() {
		return baseSize;
	}

	public float getMaxSize() {
		return maxSize;
	}

	public float getBaseEyeHeight() {
		return baseEyeHeight;
	}

	public float getBaseBoundingBoxHeight() {
		return baseBoundingBoxHeight;
	}

	public float getBaseBoundingBoxWidth() {
		return baseBoundingBoxWidth;
	}

	public float getBaseExp() {
		return baseExp;
	}

	public float getExpDaily() {
		return expDaily;
	}

	public float getMaxAwarenessRadius() {
		return maxAwarenessRadius;
	}

	public float getImmediateAwarenessRadius() {
		return immediateAwarenessRadius;
	}

	public float getHerdWanderRadius() {
		return herdWanderRadius;
	}
	
	public float getHungerLevel() {
		return hungerLevel;
	}

	public int getMaxHerdSize() {
		return maxHerdSize;
	}

	public int getTargetFoodHabbit() {
		return targetFoodHabbit;
	}

	public int getMaxHunger() {
		return maxHunger;
	}

	public int getAdultAge() {
		return adultAge;
	}

	public int getTeenAge() {
		return teenAge;
	}
	
	public int getHungerIfEaten() {
		return hungerIfEaten;
	}
	
	public int getHealthIfEaten() {
		return healIfEaten;
	}

	public int getTicksPerHungerDecrement() {
		return ticksPerHungerDecrement;
	}
	
	public boolean isCanFormHerds() {
		return canFormHerds;
	}

	public boolean isTameable() {
		return tameable;
	}

	public boolean isRideable() {
		return rideable;
	}

	public boolean isCanCarry() {
		return canCarry;
	}
	
	public boolean eatsMeat() {
		return targetFoodHabbit == this.FOOD_HABBIT_CARNIVORE || targetFoodHabbit == this.FOOD_HABBIT_OMNIVORE;
	}
	
	public boolean eatsVegetables() {
		return targetFoodHabbit == this.FOOD_HABBIT_HERBIVORE || targetFoodHabbit == this.FOOD_HABBIT_OMNIVORE;
	}

	public Class getEntityClass() {
		return entityClass;
	}

	public static void init() {

	}
	
}
