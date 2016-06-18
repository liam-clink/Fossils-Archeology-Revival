package fossilsarcheology.server.gen;

import fossilsarcheology.Revival;
import fossilsarcheology.server.block.FABlockRegistry;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class VolcanicRockGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    private void generateSurface(World world, Random random, int BlockX, int BlockZ) {
        if (Revival.CONFIG.generateVolcanicRock) {
            for (int i = 0; i < 10; i++) {
                int Xcoord = BlockX + random.nextInt(16);
                int Zcoord = BlockZ + random.nextInt(16);
                int Ycoord = random.nextInt(16);
                (new WorldGenMinable(FABlockRegistry.INSTANCE.volcanicRock, 6)).generate(world, random, Xcoord, Ycoord, Zcoord);
            }
        }
    }
}