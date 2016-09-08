package fossilsarcheology.server.gen.feature;

import fossilsarcheology.server.block.FABlockRegistry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class SpikesBlockWorldGen extends WorldGenerator {
    @Override
    public boolean generate(World world, Random rand, BlockPos position) {
        BlockPos.MutableBlockPos spike = new BlockPos.MutableBlockPos();
        for (int i = 0; i < 64; ++i) {
            spike.setPos(position.getX() + rand.nextInt(8) - rand.nextInt(8), position.getY() + rand.nextInt(4) - rand.nextInt(4), position.getZ() + rand.nextInt(8) - rand.nextInt(8));
            if (world.isAirBlock(spike) && world.getBlockState(spike.down()).isOpaqueCube() && FABlockRegistry.INSTANCE.obsidianSpikes.canPlaceBlockAt(world, spike)) {
                world.setBlockState(spike, FABlockRegistry.INSTANCE.obsidianSpikes.getDefaultState());
            }
        }
        return true;
    }
}