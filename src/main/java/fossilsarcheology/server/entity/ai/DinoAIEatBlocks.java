package fossilsarcheology.server.entity.ai;

import fossilsarcheology.api.FoodMappings;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.EntityPrehistoricSwimming;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.ChunkCoordinates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DinoAIEatBlocks extends EntityAIBase {
    private ChunkCoordinates targetBlock;
    private EntityPrehistoric prehistoric;
    private double speed;
    private BlockSorter targetSorter;

    public DinoAIEatBlocks(EntityPrehistoric prehistoric, double speed) {
        super();
        this.prehistoric = prehistoric;
        this.speed = speed;
        this.targetSorter = new BlockSorter(this, prehistoric);
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
        int radius = 16;
        List<ChunkCoordinates> allBlocks = new ArrayList<ChunkCoordinates>();
        for (int x = (int) (prehistoric.posX) - (radius / 2); x < (int) (prehistoric.posX) + (radius / 2); x++) {
            for (int y = (int) (prehistoric.posY) - (radius / 2); y < (int) (prehistoric.posY) + (radius / 2); y++) {
                for (int z = (int) (prehistoric.posZ) - (radius / 2); z < (int) (prehistoric.posZ) + (radius / 2); z++) {
                    if (FoodMappings.INSTANCE.getBlockFoodAmount(prehistoric.worldObj.getBlock(pos), prehistoric.type.diet) > 0) {
                        allBlocks.add(new ChunkCoordinates(pos));
                    }
                }
            }
        }
        if (allBlocks.isEmpty()) {
            return false;
        }
        Collections.sort(allBlocks, this.targetSorter);
        this.targetBlock = allBlocks.get(0);
        return true;
    }

    @Override
    public boolean continueExecuting() {
        if (targetBlock == null) {
            return false;
        }
        if (prehistoric.getHunger() >= prehistoric.getMaxHunger()) {

            return false;
        }

        if (prehistoric.isMovementBlocked()) {
            return false;
        }
        return true;
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    @Override
    public void updateTask() {
        if (targetBlock != null) {
            Block block = prehistoric.worldObj.getBlock(this.targetBlock.posX, this.targetBlock.posY, this.targetBlock.posZ);
            if (FoodMappings.INSTANCE.getBlockFoodAmount(block, prehistoric.type.diet) > 0) {
                double d0 = prehistoric.getDistance(this.targetBlock.posX, this.targetBlock.posY, this.targetBlock.posZ);
                if (d0 * d0 < 6) {
                    prehistoric.setHunger(Math.min(100, prehistoric.getHunger() + FoodMappings.INSTANCE.getBlockFoodAmount(block, prehistoric.type.diet)));
                    prehistoric.setHealth(Math.min(prehistoric.getMaxHealth(), (int) (prehistoric.getHealth() + FoodMappings.INSTANCE.getBlockFoodAmount(block, prehistoric.type.diet) / 10)));
                    // prehistoric.doFoodEffect(Item.getItemFromBlock(block));
                    prehistoric.playSound("random.eat", 1, 1);
                    prehistoric.worldObj.func_147480_a(this.targetBlock.posX, this.targetBlock.posY, this.targetBlock.posZ, false);
                    targetBlock = null;
                    resetTask();
                    return;
                } else {
                    if (this.prehistoric.isAquatic()) {
                        ((EntityPrehistoricSwimming) prehistoric).currentTarget = new ChunkCoordinates((int) this.targetBlock.posX, (int) this.targetBlock.posY, (int) this.targetBlock.posZ);
                    } else {
                        if (prehistoric.getNavigator().noPath()) {
                            this.prehistoric.getNavigator().tryMoveToXYZ(this.targetBlock.posX, this.targetBlock.posY, this.targetBlock.posZ, 1D);
                        }
                    }
                }
            }
        }
    }

    public class BlockSorter implements Comparator {
        final EntityAIBase ai;
        private Entity entity;

        public BlockSorter(EntityAIBase ai, Entity entity) {
            this.ai = ai;
            this.entity = entity;
        }

        public int compareBlocks(ChunkCoordinates var1, ChunkCoordinates var2) {
            double var3 = this.getDistanceSqToVec(var1);
            double var5 = this.getDistanceSqToVec(var2);
            return var3 < var5 ? -1 : (var3 > var5 ? 1 : 0);
        }

        @Override
        public int compare(Object var1, Object var2) {
            return this.compareBlocks((ChunkCoordinates) var1, (ChunkCoordinates) var2);
        }

        public double getDistanceSqToVec(ChunkCoordinates vec3) {
            double d0 = entity.posX - vec3.posX;
            double d1 = entity.posY - vec3.posY;
            double d2 = entity.posZ - vec3.posZ;
            return d0 * d0 + d1 * d1 + d2 * d2;
        }
    }
}
