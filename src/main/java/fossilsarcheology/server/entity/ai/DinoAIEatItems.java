package fossilsarcheology.server.entity.ai;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.ChunkCoordinates;
import fossilsarcheology.api.FoodMappings;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.EntityPrehistoricSwimming;

public class DinoAIEatItems extends EntityAIBase {
	private EntityItem targetItem;
	private EntityPrehistoric prehistoric;
	private double speed;
	private ItemsSorter targetSorter;
	private int feedingTicks;

	public DinoAIEatItems(EntityPrehistoric prehistoric, double speed) {
		super();
		this.prehistoric = prehistoric;
		this.speed = speed;
		this.targetSorter = new ItemsSorter(this, prehistoric);
		this.setMutexBits(1);
	}

	@Override
	public boolean shouldExecute() {

		if (prehistoric.getHunger() >= prehistoric.getMaxHunger()) {
			return false;
		}
		if (prehistoric.isMovementBlocked()) {
			return false;
		}
		if (prehistoric.getRNG().nextInt(1) != 0) {
			return false;
		}
		this.targetItem = this.getNearestItem(16);
		if (this.targetItem != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean continueExecuting() {
		if (targetItem == null || !this.targetItem.isEntityAlive()) {
			return false;
		}
		if (prehistoric.getHunger() >= prehistoric.getMaxHunger()) {
			return false;
		}

		if (prehistoric.isMovementBlocked()) {
			return false;
		}
		return false;
	}

	@Override
	public void updateTask() {
		double distance = Math.sqrt(Math.pow(this.prehistoric.posX - this.targetItem.posX, 2.0D) + Math.pow(this.prehistoric.posZ - this.targetItem.posZ, 2.0D));
		if (distance < 16) {
			if(this.prehistoric.isAquatic()){
				((EntityPrehistoricSwimming)prehistoric).currentTarget = new ChunkCoordinates((int)this.targetItem.posX, (int)this.targetItem.posY, (int) this.targetItem.posZ);
			}else{
				this.prehistoric.getNavigator().tryMoveToXYZ(this.targetItem.posX, this.targetItem.posY, this.targetItem.posZ, 1D);
			}

			if (distance < 2.5D) {
				if (this.targetItem != null) {
					this.prehistoric.eatItem(this.targetItem.getEntityItem());
					this.targetItem.setDead();
				}
			}
		}
	}
	
	private EntityItem getNearestItem(int range) {
		List nearbyItems = this.prehistoric.worldObj.getEntitiesWithinAABB(EntityItem.class, this.prehistoric.boundingBox.expand(range, range, range));
		Collections.sort(nearbyItems, this.targetSorter);
		Iterator iterateNearbyItems = nearbyItems.iterator();
		EntityItem entityItem = null;

		while (iterateNearbyItems.hasNext()) {

			EntityItem entityItem1 = (EntityItem) iterateNearbyItems.next();
			if (entityItem1.getEntityItem() != null && entityItem1.getEntityItem().getItem() != null)
				if ((FoodMappings.INSTANCE.getItemFoodAmount(entityItem1.getEntityItem().getItem(), prehistoric.type.diet) != 0) && this.prehistoric.getDistanceSqToEntity(entityItem1) < range) {
					entityItem = entityItem1;
				}
		}
		return entityItem;
	}
	
	public class ItemsSorter implements Comparator {
		final EntityAIBase ai;
		private Entity entity;

		public ItemsSorter(EntityAIBase var1, Entity var2) {
			this.ai = var1;
			this.entity = var2;
		}

		public int func_48469_a(Entity var1, Entity var2) {
			double var3 = this.entity.getDistanceSqToEntity(var1);
			double var5 = this.entity.getDistanceSqToEntity(var2);
			return var3 < var5 ? -1 : (var3 > var5 ? 1 : 0);
		}

		@Override
		public int compare(Object var1, Object var2) {
			return this.func_48469_a((Entity) var1, (Entity) var2);
		}
	}
}
