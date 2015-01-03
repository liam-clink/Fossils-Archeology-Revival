package mods.fossil.entity.mobs;

import mods.fossil.Fossil;
import mods.fossil.guiBlocks.TileEntityFeeder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class EntityPrehistoric extends EntityAgeable {
	
	public static int ticksPerAge = 12000;
	
	// Instance properties
	private int age;
	private float exp;
	private int hunger;
	private int status;
	private boolean inHerd;
	private boolean isWild;
	private boolean isStatue;
	private boolean canChangeStatus;
	private EnumEntityPrehistoric type;
	private String ownerDisplayName;
	private ItemStack itemCarrying;
	private EntityAIBase aiInControl;
	
	public EntityPrehistoric(World world, EnumEntityPrehistoric type) {
		super(world);
		this.type = type;
		this.exp = type.getBaseExp();
		this.hunger = type.getMaxHunger() / 2;
		this.setSize(type.getBaseBoundingBoxHeight(), type.getBaseBoundingBoxWidth());
	}
	
	/*
	 * 	TODO
	 * 		-Create ShowPedia2 (in EntityPrehistoric old)
	 * 		-Get sounds
	 */
	
	/**
	 * Method to add all mob ai
	 */
	abstract void addAI();
	
	public void eatFromFeeder(TileEntityFeeder feeder) {
		
	}
	
	@Override
	public void moveEntityWithHeading(float xHeading, float yHeading) {
		if(!isStatue()) {
			super.moveEntityWithHeading(xHeading, yHeading);
			if(this.riddenByEntity != null || this.isAdult()) {
				this.stepHeight = 1.0F;
			} else {
				this.stepHeight = 0.5F;
			}
		}
	}
	
	/**
	 * Runs when mob is attacked
	 */
	@Override
	public boolean attackEntityFrom(DamageSource attacker, float var2) {
		if(attacker.getEntity().equals(riddenByEntity)) {
			return false;
		}
		if(dropStatue()) {
			return true;
		}
		return super.attackEntityFrom(attacker, var2);
	}
	
	/**
	 * Executes when the mob kills an entity
	 * TODO
	 *      -Add hunger and health values for other mobs
	 */
	@Override
	public void onKillEntity(EntityLivingBase entity) {
		if(entity instanceof EntityPrehistoric) {
			addHunger(((EntityPrehistoric)entity).getType().getHungerIfEaten());
			heal(((EntityPrehistoric)entity).getType().getHealthIfEaten());
		}
	}
	
	public void holdItem(ItemStack item) {
		this.itemCarrying = new ItemStack(item.getItem(), item.getItemDamage());
	}
	
	public int pickupItem(ItemStack item) {
		// TODO
		if(type.willEat(item.getItem())) {
			eat(item);
		} else {
			holdItem(item);
		}
		return 0;
	}
	
	public int eat(ItemStack itemstack) {
		// Placeholder
		return 0;
	}
	
	public boolean dropStatue() {
		// Placeholder
		if(isStatue()) {
			return true;
		}
		return false;
	}
	
	public void setPathToEntity(Entity entity) {
		// TODO
	}
	
	public void setPathToPosition(Vec3 location) {
		// TODO
	}
	
	@Override
	public float getEyeHeight() {
		return type.getBaseEyeHeight() * this.getSize();
	}
	
	/**
	 * Interpolates the strength of the mob
	 * @return
	 */
	public double getStrength() {
		double step = (type.getMaxStrength() - type.getBaseStrength()) / (type.getAdultAge());
		if(this.age > type.getAdultAge()) {
			return type.getBaseStrength() + (step * type.getAdultAge());
		}
		return type.getBaseStrength() + (step * age);
	}
	
	/**
	 * Interpolates the size of the mob
	 * @return
	 */
	public float getSize() {
		float step = (type.getMaxSize() - type.getBaseSize()) / (type.getAdultAge());
		if(this.age > type.getAdultAge()) {
			return type.getBaseSize() + (step * type.getAdultAge());
		}
		return type.getBaseSize() + (step * age);
	}
	
	/**
	 * Sets the scale of the dinosaur
	 */
	@Override
	public void setScaleForAge(boolean child) {
		this.setScale(getSize());
	}
	
	/**
	 * Dino can't climb ladder
	 */
	@Override
	public boolean isOnLadder() {
		return false;
	}
	
	/**
	 * Gets the experience points of the mob
	 */
	@Override
	protected int getExperiencePoints(EntityPlayer player) {
		return (int) exp;
	}
	
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	/**
	 * Gets the age of the mob
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Increments the age of the mob
	 */
	public void incrementAge() {
		age++;
		exp += type.getExpDaily();
	}
	
	/**
	 * Gets the mob hunger
	 * @return
	 */
	public int getHunger() {
		return hunger;
	}
	
	/**
	 * Decrements the hunger
	 */
	public void decrementHunger() {
		if(hunger > 0) {
			hunger--;
		}
	}
	
	/**
	 * Adds hunger to hunger
	 * @param hunger
	 */
	public boolean addHunger(int hunger) {
		if(this.hunger >= type.getMaxHunger()) {
			this.hunger = type.getMaxHunger();
			return false;
		}
		this.hunger += hunger;
		if(this.hunger > type.getMaxHunger()) {
			this.hunger = type.getMaxHunger();
		}
		this.worldObj.playSoundAtEntity(this, "random.eat", this.getSoundVolume(), this.getSoundPitch());
		return true;
	}
	
	/**
	 * Gets the type of the mob for property referencing
	 * @return
	 */
	public EnumEntityPrehistoric getType() {
		return type;
	}
	
	/**
	 * Gets the owner's display name
	 * @return
	 */
	public String getOwnerDisplayName() {
		return ownerDisplayName;
	}
	
	/**
	 * Sets the owner's display name
	 * @param ownerDisplayName
	 */
	public void setOwnerDisplayName(String ownerDisplayName) {
		this.ownerDisplayName = ownerDisplayName;
	}
	
	public void setStatue(boolean isStatue) {
		this.isStatue = isStatue;
	}
	
	/**
	 * Returns true if the mob is a statue
	 * @return
	 */
	public boolean isStatue() {
		return isStatue;
	}
	
	/**
	 * Returns true if the mob is in a herd
	 * @return
	 */
	public boolean isInHerd() {
		return inHerd;
	}
	
	/**
	 * Returns true if the mob is wild
	 * @return
	 */
	public boolean isWild() {
		return isWild;
	}
	
	/**
	 * Returns true if the mob is an adult
	 * @return
	 */
	public boolean isAdult() {
		return this.age >= type.getAdultAge();
	}
	
	/**
	 * Returns true if the mob is a teen
	 * @return
	 */
	public boolean isTeen() {
		return this.age >= type.getTeenAge();
	}
	
	/**
	 * Returns true if the mob is a child
	 */
	public boolean isChild() {
		return this.age < type.getTeenAge();
	}
	
	public boolean hasOwner() {
		return ownerDisplayName == null || ownerDisplayName.isEmpty();
	}
	
	/**
	 * Returns 0 if not hungry, 1 if slightly hungry, 2 if deadly hungry
	 * @return
	 */
	public int hungerLevel() {
		float hungerRatio = ((float)hunger) / type.getMaxHunger();
		if(hungerRatio < type.getHungerLevel()) {
			if(hungerRatio < type.getHungerLevel() / 4) {
				return 2;
			}
			return 1;
		}
		return 0;
	}
	
	protected String getModelTexture() {
		return Fossil.modid + ":" + "textures/mob/DinosaurModels/DinoModel" + type.toString() + ".png";
	}
	
	public String getTexture() {
		// TODO
		return null;
	}
	
	/**
	 * Calculates the distance to a location
	 * @param location
	 * @return
	 */
	private double distanceToLocation(Vec3 location) {
		return Math.sqrt(Math.pow(posX - location.xCoord + 0.5, 2) + Math.pow(posZ - location.zCoord + 0.5, 2));
	}
	
	/**
	 * Calculates the distance to an entity
	 * @param entity
	 * @return
	 */
	private double distanceToEntity(Entity entity) {
		return Math.sqrt(Math.pow(posX - entity.posX, 2) + Math.pow(posZ - entity.posZ, 2));
	}
	
	/**
	 * Calculates the distance to a feeder
	 * @param entity
	 * @return
	 */
	private double distanceToFeeder(TileEntityFeeder entity) {
		return Math.sqrt(Math.pow(posX - entity.xCoord + 0.5, 2) + Math.pow(posY - entity.yCoord + 0.5, 2));
	}
	
	/**
	 * Calculates the distance status of a location
	 * 0 - not aware, 1 - needs line of sight, 2 - immediately aware
	 * @param location
	 * @return
	 */
	public int distanceStatus(Vec3 location) {
		double distance = this.distanceToLocation(location);
		if(distance < type.getImmediateAwarenessRadius()) {
			return 2;
		} else if(distance < type.getMaxAwarenessRadius()) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * Calculates the distance status of an entity.
	 * @param entity
	 * @return
	 */
	public int distanceStatus(Entity entity) {
		return distanceStatus(Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ));
	}
	
	/**
	 * Calculates the distance status of a feeder
	 * @param entity
	 * @return
	 */
	public int distanceStatus(TileEntityFeeder entity) {
		return distanceStatus(Vec3.createVectorHelper(entity.xCoord, entity.yCoord, entity.zCoord));
	}
	
	/**
	 * Calculates whether the entity can be seen.  Checks both visibility and field of view
	 * @param entity
	 * @return
	 */
	private boolean canSeeEntity(Entity entity) {
		boolean canSeeAnyDir = worldObj.rayTraceBlocks(Vec3.createVectorHelper(posX, posY, posZ), Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ)) == null;
		boolean entityWithinFieldOfView = Vec3.createVectorHelper(entity.posX - posX, entity.posY - posY, entity.posZ - posZ).normalize().dotProduct(getLookVec()) > 0.8;
		return canSeeAnyDir && entityWithinFieldOfView;
	}
	
	/**
	 * Checks if the entity can see the block.  Only checks the possible 3 faces
	 * @param position
	 * @return
	 */
	private boolean rayTraceBlock(Vec3 position) {		
		if(posY >= position.yCoord) {
			if(canSeeBlockFace(position, 0)) {
				return true;
			}
		} else {
			if(canSeeBlockFace(position, 1)) {
				return true;
			}
		}
		if(Math.abs(posX - position.xCoord) >= Math.abs(posZ - position.zCoord)) {
			if(posX >= position.xCoord) {
				if(canSeeBlockFace(position, 2)) {
					return true;
				}
			} else {
				if(canSeeBlockFace(position, 3)) {
					return true;
				}
			}
		} else {
			if(posZ >= position.zCoord) {
				if(canSeeBlockFace(position, 4)) {
					return true;
				}
			} else {
				if(canSeeBlockFace(position, 5)) {
					return true;
				}
			}
		}
		if(Math.abs(posX - position.xCoord) >= Math.abs(posZ - position.zCoord)) {
			if(posZ >= position.zCoord) {
				if(canSeeBlockFace(position, 4)) {
					return true;
				}
			} else {
				if(canSeeBlockFace(position, 5)) {
					return true;
				}
			}
		} else {
			if(posX >= position.xCoord) {
				if(canSeeBlockFace(position, 2)) {
					return true;
				}
			} else {
				if(canSeeBlockFace(position, 3)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns true if the entity can see a blocks face.
	 * 0 = y+
	 * 1 = y-
	 * 2 = x+
	 * 3 = x-
	 * 4 = z+
	 * 5 = z-
	 * @param position
	 * @param face
	 * @return
	 */
	private boolean canSeeBlockFace(Vec3 position, int face) {
		Vec3 target = null;
		switch(face) {
		case 0:
			target = position.addVector(0.5, 1.0, 0.5);
			break;
		case 1:
			target = position.addVector(0.5, 0.0, 0.5);
			break;
		case 2:
			target = position.addVector(1.0, 0.5, 0.5);
			break;
		case 3:
			target = position.addVector(0.0, 0.5, 0.5);
			break;
		case 4:
			target = position.addVector(0.5, 0.5, 1.0);
			break;
		case 5:
			target = position.addVector(0.5, 0.5, 0.0);
			break;
		}
		MovingObjectPosition hit = worldObj.rayTraceBlocks(Vec3.createVectorHelper(posX, posY + getEyeHeight(), posZ), target);
		return vec3Equals(Vec3.createVectorHelper(hit.blockX, hit.blockY, hit.blockZ),position);
	}
	
	/**
	 * Calculates whether the feeder can be seen.  Checks both visibility and field of view
	 * @param entity
	 * @return
	 */
	private boolean canSeeBlock(Vec3 position) {
		boolean canSeeAnyDir = rayTraceBlock(position);
		boolean blockWithinFieldOfView = Vec3.createVectorHelper(position.xCoord - posX + 0.5, position.yCoord - posY + 0.5, position.zCoord - posZ + 0.5).normalize().dotProduct(getLookVec()) > 0.8;
		return canSeeAnyDir && blockWithinFieldOfView;
	}
	
	/**
	 * Calculates whether or not the entity can be found
	 * @param entity
	 * @return
	 */
	public boolean canFindEntity(Entity entity) {
		switch(distanceStatus(entity)) {
		case 0:
			return false;
		case 1:
			return canSeeEntity(entity);
		case 2:
			return true;
		}
		return false;
	}
	
	/**
	 * Calculates whether or not the feeder can be found
	 * @param entity
	 * @return
	 */
	public boolean canFindFeeder(TileEntityFeeder entity) {
		return canFindBlock(Vec3.createVectorHelper(entity.xCoord, entity.yCoord, entity.zCoord));
	}
	
	/**
	 * Calculates whether or not a block can be found
	 * @param block
	 * @return
	 */
	public boolean canFindBlock(Vec3 block) {
		switch(distanceStatus(block)) {
		case 0:
			return false;
		case 1:
			return canSeeBlock(block);
		case 2:
			return true;
		}
		return false;
	}
	
	private boolean vec3Equals(Vec3 v1, Vec3 v2) {
		return v1.xCoord == v2.xCoord && v1.yCoord == v2.yCoord && v1.zCoord == v2.zCoord;
	}
	
}
