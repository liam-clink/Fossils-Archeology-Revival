package fossilsarcheology.server.world.gen;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

@Deprecated
public class BlockUtils {
    private static final BlockPos.MutableBlockPos MUTABLE_POS = new BlockPos.MutableBlockPos();

    @Deprecated
    public static void setBlock(World world, int x, int y, int z, Block block, int meta, int flags) {
        MUTABLE_POS.setPos(x, y, z);
        world.setBlockState(MUTABLE_POS, block.getStateFromMeta(meta), flags);
    }

    @Deprecated
    public static Block getBlock(World world, int x, int y, int z) {
        MUTABLE_POS.setPos(x, y, z);
        return world.getBlockState(MUTABLE_POS).getBlock();
    }

    @Deprecated
    public static int getBlockMeta(World world, int x, int y, int z) {
        MUTABLE_POS.setPos(x, y, z);
        IBlockState state = world.getBlockState(MUTABLE_POS);
        return state.getBlock().getMetaFromState(state);
    }

    @Deprecated
    public static void setChest(World world, int x, int y, int z, Block block, int meta, int flags, ResourceLocation loot) {
        world.setBlockState(new BlockPos(x, y, z), block.getStateFromMeta(meta), 3);
        if (block instanceof BlockChest) {
            TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
            if (entity instanceof TileEntityChest) {
                ((TileEntityChest) entity).setLootTable(loot, new Random().nextLong());
            }
        }
    }
}
