package fossilsarcheology.server.gen;

import fossilsarcheology.Revival;
import fossilsarcheology.server.block.FABlockRegistry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class VolcanicRockGenerator implements IWorldGenerator {
    private void generateSurface(World world, Random random, int BlockX, int BlockZ) {
        if (Revival.CONFIG.generateVolcanicRock) {
            for (int i = 0; i < 10; i++) {
                int Xcoord = BlockX + random.nextInt(16);
                int Zcoord = BlockZ + random.nextInt(16);
                int Ycoord = random.nextInt(16);
                (new WorldGenMinable(FABlockRegistry.INSTANCE.volcanicRock.getDefaultState(), 6)).generate(world, random, new BlockPos(Xcoord, Ycoord, Zcoord));
            }
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
        }
    }
}