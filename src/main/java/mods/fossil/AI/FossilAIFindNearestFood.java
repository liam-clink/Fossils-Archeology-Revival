package mods.fossil.AI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import mods.fossil.entity.mobs.EntityPrehistoric;
import mods.fossil.guiBlocks.TileEntityFeeder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class FossilAIFindNearestFood extends EntityAIBase {

	private EntityPrehistoric entity;
	
	public FossilAIFindNearestFood(EntityPrehistoric entity) {
		this.entity = entity;
	}
	
	@Override
	public boolean shouldExecute() {
		return entity.hungerLevel() > 0;
	}
	
	/**
	 * Finds all possible targets
	 */
	@Override
	public void startExecuting() {
		ArrayList<Entity> possibleMobTargets = new ArrayList<Entity>();
		ArrayList<Entity> possibleItemTargets = new ArrayList<Entity>();
		ArrayList<Vec3> possibleBlockTargets = new ArrayList<Vec3>();
		ArrayList<TileEntityFeeder> possibleFeeders = new ArrayList<TileEntityFeeder>();
		
		for(Object possibleFeeder: entity.worldObj.loadedTileEntityList) {
			if(possibleFeeder instanceof TileEntityFeeder) {
				if(canFindFeeder((TileEntityFeeder)possibleFeeder)) {
					if((entity.getType().eatsMeat() && ((TileEntityFeeder)possibleFeeder).MeatCurrent > 0) || (entity.getType().eatsVegetables() && ((TileEntityFeeder)possibleFeeder).VegCurrent > 0)) {
						possibleFeeders.add((TileEntityFeeder)possibleFeeder);
					}
				}
			}
		}
		
		for(Object possibleTarget: entity.worldObj.loadedEntityList) {
			if(possibleTarget instanceof EntityItem) {
				if(canFindEntity((Entity)possibleTarget)) {
					if(entity.getType().willEat(((EntityItem)possibleTarget).getEntityItem().getItem())) {
						possibleItemTargets.add((Entity)possibleTarget);
					}
				}
			} else if(possibleTarget instanceof EntityLiving) {
				if(canFindEntity((Entity)possibleTarget)) {
					if(entity.getType().willAttack((EntityLiving)possibleTarget)) {
						possibleMobTargets.add((Entity)possibleTarget);
					}
				}
			}
		}
		
		for(int i = (int)-entity.getType().getMaxAwarenessRadius(); i <= (int)entity.getType().getMaxAwarenessRadius(); i++) {
			int y = (int)Math.sqrt(Math.pow(entity.getType().getMaxAwarenessRadius(), 2) - Math.pow(i, 2));
			for(int j = -y; j <= y; j++) {
				for(int k = -4; k <= 4; k++) {
					if(entity.getType().willEat(entity.worldObj.getBlock(i, j, k))) {
						if(canFindBlock(Vec3.createVectorHelper(i, j, k))) {
							possibleBlockTargets.add(Vec3.createVectorHelper(i, j, k));
						}
					}
				}
			}
		}
		
		if(!possibleFeeders.isEmpty()) {
			Collections.sort(possibleFeeders, new Comparator<TileEntityFeeder>() {
				@Override
				public int compare(TileEntityFeeder o1, TileEntityFeeder o2) {
					return (int)(distanceToFeeder(o1) - distanceToFeeder(o2));
				}
			});
			for(TileEntityFeeder feeder: possibleFeeders) {
				// Set path and feed
			}
		}
		if(!possibleMobTargets.isEmpty()) {
			Collections.sort(possibleMobTargets, new Comparator<Entity>() {
				@Override
				public int compare(Entity arg0, Entity arg1) {
					return (int)(distanceToEntity(arg0) - distanceToEntity(arg1));
				}
			});
			for(Entity target: possibleMobTargets) {
				// Set path and attack
			}
		}
		if(!possibleItemTargets.isEmpty()) {
			Collections.sort(possibleItemTargets, new Comparator<Entity>() {
				@Override
				public int compare(Entity arg0, Entity arg1) {
					return (int)(distanceToEntity(arg0) - distanceToEntity(arg1));
				}
			});
			for(Entity target: possibleItemTargets) {
				// Set path and eat
			}
		}
		if(!possibleBlockTargets.isEmpty()) {
			Collections.sort(possibleBlockTargets, new Comparator<Vec3>() {
				@Override
				public int compare(Vec3 arg0, Vec3 arg1) {
					return (int)(distanceToLocation(arg0) - distanceToLocation(arg1));
				}
			});
			for(Vec3 target: possibleBlockTargets) {
				// Set path and eat
			}
		}
		
	}
	
	/**
	 * Calculates the distance to a location
	 * @param location
	 * @return
	 */
	private double distanceToLocation(Vec3 location) {
		return Math.sqrt(Math.pow(entity.posX - location.xCoord + 0.5, 2) + Math.pow(entity.posZ - location.zCoord + 0.5, 2));
	}
	
	/**
	 * Calculates the distance to an entity
	 * @param entity
	 * @return
	 */
	private double distanceToEntity(Entity entity) {
		return Math.sqrt(Math.pow(this.entity.posX - entity.posX, 2) + Math.pow(this.entity.posZ - entity.posZ, 2));
	}
	
	/**
	 * Calculates the distance to a feeder
	 * @param entity
	 * @return
	 */
	private double distanceToFeeder(TileEntityFeeder entity) {
		return Math.sqrt(Math.pow(this.entity.posX - entity.xCoord + 0.5, 2) + Math.pow(this.entity.posY - entity.yCoord + 0.5, 2));
	}
	
	/**
	 * Calculates the distance status of an entity.
	 * 0 - not aware, 1 - needs line of sight, 2 - immediately aware
	 * @param entity
	 * @return
	 */
	private int distanceStatus(Entity entity) {
		return distanceStatus(Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ));
	}
	
	/**
	 * Calculates the distance status of a feeder
	 * @param entity
	 * @return
	 */
	private int distanceStatus(TileEntityFeeder entity) {
		return distanceStatus(Vec3.createVectorHelper(entity.xCoord, entity.yCoord, entity.zCoord));
	}
	
	/**
	 * Calculates the distance status of a location
	 * @param location
	 * @return
	 */
	private int distanceStatus(Vec3 location) {
		double distance = this.distanceToLocation(location);
		if(distance < this.entity.getType().getImmediateAwarenessRadius()) {
			return 2;
		} else if(distance < this.entity.getType().getMaxAwarenessRadius()) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * Calculates whether the entity can be seen.  Checks both visibility and field of view
	 * @param entity
	 * @return
	 */
	private boolean canSeeEntity(Entity entity) {
		boolean canSeeAnyDir = this.entity.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.entity.posX, this.entity.posY, this.entity.posZ), Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ)) == null;
		boolean entityWithinFieldOfView = Vec3.createVectorHelper(entity.posX - this.entity.posX, entity.posY - this.entity.posY, entity.posZ - this.entity.posZ).normalize().dotProduct(this.entity.getLookVec()) > 0.8;
		return canSeeAnyDir && entityWithinFieldOfView;
	}
	
	/**
	 * Checks if the entity can see the block.  Only checks the possible 3 faces
	 * @param position
	 * @return
	 */
	private boolean rayTraceBlock(Vec3 position) {		
		if(entity.posY >= position.yCoord) {
			if(canSeeBlockFace(position, 0)) {
				return true;
			}
		} else {
			if(canSeeBlockFace(position, 1)) {
				return true;
			}
		}
		if(Math.abs(entity.posX - position.xCoord) >= Math.abs(entity.posZ - position.zCoord)) {
			if(entity.posX >= position.xCoord) {
				if(canSeeBlockFace(position, 2)) {
					return true;
				}
			} else {
				if(canSeeBlockFace(position, 3)) {
					return true;
				}
			}
		} else {
			if(entity.posZ >= position.zCoord) {
				if(canSeeBlockFace(position, 4)) {
					return true;
				}
			} else {
				if(canSeeBlockFace(position, 5)) {
					return true;
				}
			}
		}
		if(Math.abs(entity.posX - position.xCoord) >= Math.abs(entity.posZ - position.zCoord)) {
			if(entity.posZ >= position.zCoord) {
				if(canSeeBlockFace(position, 4)) {
					return true;
				}
			} else {
				if(canSeeBlockFace(position, 5)) {
					return true;
				}
			}
		} else {
			if(entity.posX >= position.xCoord) {
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
		MovingObjectPosition hit = entity.worldObj.rayTraceBlocks(Vec3.createVectorHelper(entity.posX, entity.posY + entity.getEyeHeight(), entity.posZ), target);
		return vec3Equals(Vec3.createVectorHelper(hit.blockX, hit.blockY, hit.blockZ),position);
	}
	
	/**
	 * Calculates whether the feeder can be seen.  Checks both visibility and field of view
	 * @param entity
	 * @return
	 */
	private boolean canSeeBlock(Vec3 position) {
		boolean canSeeAnyDir = rayTraceBlock(position);
		boolean entityWithinFieldOfView = Vec3.createVectorHelper(position.xCoord - this.entity.posX + 0.5, position.yCoord - this.entity.posY + 0.5, position.zCoord - this.entity.posZ + 0.5).normalize().dotProduct(this.entity.getLookVec()) > 0.8;
		return canSeeAnyDir && entityWithinFieldOfView;
	}
	
	/**
	 * Calculates whether or not the entity can be found
	 * @param entity
	 * @return
	 */
	private boolean canFindEntity(Entity entity) {
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
	private boolean canFindFeeder(TileEntityFeeder entity) {
		return canFindBlock(Vec3.createVectorHelper(entity.xCoord, entity.yCoord, entity.zCoord));
	}
	
	/**
	 * Calculates whether or not a block can be found
	 * @param block
	 * @return
	 */
	private boolean canFindBlock(Vec3 block) {
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
