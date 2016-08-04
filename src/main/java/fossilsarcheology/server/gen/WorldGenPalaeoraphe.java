package fossilsarcheology.server.gen;

import fossilsarcheology.server.block.FABlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenPalaeoraphe extends WorldGenerator {
    public WorldGenPalaeoraphe() {
    }

    @Override
    public boolean generate(World world, Random random, BlockPos position) {
        Block ground = world.getBlockState(position.down()).getBlock();

        if (ground != Blocks.GRASS && ground != Blocks.DIRT || position.getY() >= 128 - 12 - 1) {
            return false;
        }

        // int deltaY = 5;
        int deltaY = random.nextInt(10);

        for (int logY = 0; logY <= deltaY + 10; logY++) {
            world.setBlockState(position.up(logY), FABlockRegistry.INSTANCE.palmLog.getDefaultState());
        }

        position = position.up(deltaY - 5);

        IBlockState leaves = FABlockRegistry.INSTANCE.palmLeaves.getDefaultState();

        world.setBlockState(position.add(0, 16, 0), leaves, 2);
        world.setBlockState(position.add(1, 15, 0), leaves, 2);
        world.setBlockState(position.add(2, 15, 0), leaves, 2);
        world.setBlockState(position.add(3, 15, 0), leaves, 2);
        world.setBlockState(position.add(4, 15, 0), leaves, 2);
        world.setBlockState(position.add(5, 14, 0), leaves, 2);
        world.setBlockState(position.add(0, 15, 1), leaves, 2);
        world.setBlockState(position.add(0, 15, 2), leaves, 2);
        world.setBlockState(position.add(0, 15, 3), leaves, 2);
        world.setBlockState(position.add(0, 15, 4), leaves, 2);
        world.setBlockState(position.add(0, 14, 5), leaves, 2);
        world.setBlockState(position.add(-1, 15, 0), leaves, 2);
        world.setBlockState(position.add(-2, 15, 0), leaves, 2);
        world.setBlockState(position.add(-3, 15, 0), leaves, 2);
        world.setBlockState(position.add(-4, 15, 0), leaves, 2);
        world.setBlockState(position.add(-5, 14, 0), leaves, 2);
        world.setBlockState(position.add(0, 15, -1), leaves, 2);
        world.setBlockState(position.add(0, 15, -2), leaves, 2);
        world.setBlockState(position.add(0, 15, -3), leaves, 2);
        world.setBlockState(position.add(0, 15, -4), leaves, 2);
        world.setBlockState(position.add(0, 14, -5), leaves, 2);
        world.setBlockState(position.add(1, 15, 1), leaves, 2);
        world.setBlockState(position.add(1, 15, -1), leaves, 2);
        world.setBlockState(position.add(-1, 15, 1), leaves, 2);
        world.setBlockState(position.add(-1, 15, -1), leaves, 2);
        world.setBlockState(position.add(2, 15, 2), leaves, 2);
        world.setBlockState(position.add(2, 15, -2), leaves, 2);
        world.setBlockState(position.add(-2, 15, 2), leaves, 2);
        world.setBlockState(position.add(-2, 15, -2), leaves, 2);
        world.setBlockState(position.add(3, 14, 3), leaves, 2);
        world.setBlockState(position.add(3, 14, -3), leaves, 2);
        world.setBlockState(position.add(-3, 14, 3), leaves, 2);
        world.setBlockState(position.add(-3, 14, -3), leaves, 2);
        /*
         * world.setBlockAndMetadata(x + 6, y + 14, z,
		 * Revival.palmLeaves, 2, 0); world.setBlockAndMetadata(x, y +
		 * 13, z + 6, Revival.palmLeaves, 2, 0);
		 * world.setBlockAndMetadata(x - 6, y + 13, z,
		 * Revival.palmLeaves, 2, 0); world.setBlockAndMetadata(x, y +
		 * 13, z - 6, Revival.palmLeaves, 2, 0);
		 */
        return true;
    }
}
