package fossilsarcheology.server.structure.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.nio.ByteBuffer;

public interface CustomBlock {
    IBlockState getBlock(World world, BlockPos position, ByteBuffer data);

    void onPlace(World world, BlockPos position, ByteBuffer data);
}
