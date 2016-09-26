package fossilsarcheology.server.entity.ai;

import fossilsarcheology.api.FoodMappings;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.EntityPrehistoricSwimming;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DinoAIEatBlocks extends EntityAIBase {
    private BlockPos targetBlock;
    private EntityPrehistoric prehistoric;
    private BlockSorter targetSorter;

    public DinoAIEatBlocks(EntityPrehistoric prehistoric) {
        super();
        this.prehistoric = prehistoric;
        this.targetSorter = new BlockSorter(this, prehistoric);
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
        int radius = 16;
        List<BlockPos> allBlocks = new ArrayList<>();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int x = (int) (this.prehistoric.posX) - (radius / 2); x < (int) (this.prehistoric.posX) + (radius / 2); x++) {
            for (int y = (int) (this.prehistoric.posY) - (radius / 2); y < (int) (this.prehistoric.posY) + (radius / 2); y++) {
                for (int z = (int) (this.prehistoric.posZ) - (radius / 2); z < (int) (this.prehistoric.posZ) + (radius / 2); z++) {
                    pos.setPos(x, y, z);
                    if (FoodMappings.INSTANCE.getBlockFoodAmount(this.prehistoric.worldObj.getBlockState(pos).getBlock(), this.prehistoric.type.diet) > 0) {
                        allBlocks.add(pos);
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
        return this.targetBlock != null && this.prehistoric.getHunger() < this.prehistoric.getMaxHunger() && !this.prehistoric.isMovementBlocked();
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    @Override
    public void updateTask() {
        if (this.targetBlock != null) {
            Block block = this.prehistoric.worldObj.getBlockState(this.targetBlock).getBlock();
            if (FoodMappings.INSTANCE.getBlockFoodAmount(block, this.prehistoric.type.diet) > 0) {
                double distance = this.prehistoric.getDistanceSq(this.targetBlock);
                if (distance < 6) {
                    this.prehistoric.setHunger(Math.min(100, this.prehistoric.getHunger() + FoodMappings.INSTANCE.getBlockFoodAmount(block, this.prehistoric.type.diet)));
                    this.prehistoric.setHealth(Math.min(this.prehistoric.getMaxHealth(), (int) (this.prehistoric.getHealth() + FoodMappings.INSTANCE.getBlockFoodAmount(block, this.prehistoric.type.diet) / 10)));
                    this.prehistoric.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1, 1);
                    this.prehistoric.worldObj.destroyBlock(this.targetBlock, false);
                    this.targetBlock = null;
                    this.resetTask();
                } else {
                    if (this.prehistoric.isAquatic()) {
                        ((EntityPrehistoricSwimming) this.prehistoric).currentTarget = this.targetBlock;
                    } else {
                        if (this.prehistoric.getNavigator().noPath()) {
                            this.prehistoric.getNavigator().tryMoveToXYZ(this.targetBlock.getX(), this.targetBlock.getY(), this.targetBlock.getZ(), 1D);
                        }
                    }
                }
            }
        }
    }

    public class BlockSorter implements Comparator<BlockPos> {
        final EntityAIBase ai;
        private Entity entity;

        public BlockSorter(EntityAIBase ai, Entity entity) {
            this.ai = ai;
            this.entity = entity;
        }

        @Override
        public int compare(BlockPos pos1, BlockPos pos2) {
            double distance1 = this.entity.getDistanceSq(pos1);
            double distance2 = this.entity.getDistanceSq(pos2);
            return distance1 < distance2 ? -1 : (distance1 > distance2 ? 1 : 0);
        }
    }
}
