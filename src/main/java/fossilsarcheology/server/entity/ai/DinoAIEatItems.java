package fossilsarcheology.server.entity.ai;

import fossilsarcheology.api.FoodMappings;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.EntityPrehistoricSwimming;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DinoAIEatItems extends EntityAIBase {
    private EntityItem targetItem;
    private EntityPrehistoric prehistoric;
    private ItemsSorter targetSorter;

    public DinoAIEatItems(EntityPrehistoric prehistoric) {
        super();
        this.prehistoric = prehistoric;
        this.targetSorter = new ItemsSorter(this, prehistoric);
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (this.prehistoric.getHunger() >= this.prehistoric.getMaxHunger()) {
            return false;
        }
        if (this.prehistoric.isMovementBlocked()) {
            return false;
        }
        if (this.prehistoric.getRNG().nextInt(1) != 0) {
            return false;
        }
        this.targetItem = this.getNearestItem(16);
        return this.targetItem != null;
    }

    @Override
    public boolean continueExecuting() {
        if (this.targetItem == null || !this.targetItem.isEntityAlive()) {
            return false;
        }
        if (this.prehistoric.getHunger() >= this.prehistoric.getMaxHunger()) {
            return false;
        }
        if (this.prehistoric.isMovementBlocked()) {
            return false;
        }
        return false;
    }

    @Override
    public void updateTask() {
        double distance = Math.sqrt(Math.pow(this.prehistoric.posX - this.targetItem.posX, 2.0D) + Math.pow(this.prehistoric.posZ - this.targetItem.posZ, 2.0D));
        if (distance < 16) {
            if (this.prehistoric.isAquatic()) {
                ((EntityPrehistoricSwimming) this.prehistoric).currentTarget = new BlockPos(this.targetItem);
            } else {
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
        List<EntityItem> nearbyItems = this.prehistoric.worldObj.getEntitiesWithinAABB(EntityItem.class, this.prehistoric.getEntityBoundingBox().expand(range, range, range));
        Collections.sort(nearbyItems, this.targetSorter);
        EntityItem nearest = null;
        for (EntityItem entityItem : nearbyItems) {
            ItemStack stack = entityItem.getEntityItem();
            if (stack != null) {
                if (FoodMappings.INSTANCE.getItemFoodAmount(stack.getItem(), this.prehistoric.type.diet) != 0 && this.prehistoric.getDistanceSqToEntity(entityItem) < range) {
                    nearest = entityItem;
                }
            }
        }
        return nearest;
    }

    public class ItemsSorter implements Comparator<EntityItem> {
        final EntityAIBase ai;
        private Entity entity;

        public ItemsSorter(EntityAIBase var1, Entity var2) {
            this.ai = var1;
            this.entity = var2;
        }

        @Override
        public int compare(EntityItem item1, EntityItem item2) {
            double distance1 = this.entity.getDistanceSqToEntity(item1);
            double distance2 = this.entity.getDistanceSqToEntity(item2);
            return distance1 < distance2 ? -1 : (distance1 > distance2 ? 1 : 0);
        }
    }
}
