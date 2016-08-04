package fossilsarcheology.server.gen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeSwamp;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGeneratorPalaeoraphe implements IWorldGenerator {
    private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
        Biome biome = world.getBiomeGenForCoords(new BlockPos(chunkX, 0, chunkZ));
        WorldGenPalaeoraphe tree = new WorldGenPalaeoraphe();

        if ((biome instanceof BiomeSwamp)) // then add ||BiomeGenXYZ if you
        // want more.
        {
            for (int x = 0; x < 2; x++) {
                int i = chunkX + rand.nextInt(128);
                int k = chunkZ + rand.nextInt(128);
                int j = world.get(i, k);
                tree.generate(world, rand, i, j, k);
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
