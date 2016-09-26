package fossilsarcheology.server.entity.ai;

import fossilsarcheology.server.block.BlockFeeder;
import fossilsarcheology.server.block.entity.TileEntityFeeder;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.EntityPrehistoricSwimming;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DinoAIEatFeeders extends EntityAIBase {
    private BlockPos targetBlock;
    private EntityPrehistoric prehistoric;
    private BlockSorter targetSorter;
    private int feedingTicks;

    public DinoAIEatFeeders(EntityPrehistoric prehistoric) {
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
        List<BlockPos> allBlocks = new ArrayList<>();
        int radius = 16;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int x = (int) (this.prehistoric.posX) - (radius / 2); x < (int) (this.prehistoric.posX) + (radius / 2); x++) {
            for (int y = (int) (this.prehistoric.posY) - (radius / 2); y < (int) (this.prehistoric.posY) + (radius / 2); y++) {
                for (int z = (int) (this.prehistoric.posZ) - (radius / 2); z < (int) (this.prehistoric.posZ) + (radius / 2); z++) {
                    pos.setPos(x, y, z);
                    IBlockState state = this.prehistoric.worldObj.getBlockState(pos);
                    TileEntity tile = this.prehistoric.worldObj.getTileEntity(pos);
                    if (state.getBlock() instanceof BlockFeeder && tile instanceof TileEntityFeeder) {
                        if (!((TileEntityFeeder) tile).isEmpty(this.prehistoric.type)) {
                            allBlocks.add(pos);
                        }
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
        return this.targetBlock != null && this.prehistoric.getHunger() < this.prehistoric.getMaxHunger() && !this.prehistoric.isMovementBlocked() && this.prehistoric.worldObj.getBlockState(this.targetBlock).getBlock() instanceof BlockFeeder && this.prehistoric.worldObj.getTileEntity(this.targetBlock) instanceof TileEntityFeeder;
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    @Override
    public void updateTask() {
        if (this.targetBlock != null) {
            if (this.prehistoric.worldObj.getBlockState(this.targetBlock).getBlock() instanceof BlockFeeder && this.prehistoric.worldObj.getTileEntity(this.targetBlock) instanceof TileEntityFeeder) {
                TileEntityFeeder feeder = (TileEntityFeeder) this.prehistoric.worldObj.getTileEntity(this.targetBlock);
                double distance = this.prehistoric.getDistanceSq(this.targetBlock);
                if (distance < 6) {
                    if (this.feedingTicks < 30 && !feeder.isEmpty(this.prehistoric.type)) {
                        this.feedingTicks++;
                        feeder.feedDinosaur(this.prehistoric);
                        this.prehistoric.setHealth(Math.min(this.prehistoric.getMaxHealth(), (int) (this.prehistoric.getHealth() + this.feedingTicks / 4)));
                        this.prehistoric.doFoodEffect();
                    } else {
                        this.feedingTicks = 0;
                        this.targetBlock = null;
                        this.resetTask();
                    }
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
