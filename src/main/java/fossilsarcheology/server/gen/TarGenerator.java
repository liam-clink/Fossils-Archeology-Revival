package fossilsarcheology.server.gen;

import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.gen.feature.TarPitWorldGen;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeSwamp;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class TarGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case 0:
                generateOverworld(world, random, chunkX * 16, chunkZ * 16);
                break;
        }
    }

    private void generateOverworld(World world, Random random, int x, int z) {
        Biome biome = world.getBiomeGenForCoords(new BlockPos(x, 0, z));
        if (biome instanceof BiomeSwamp) {
            for (int i = 0; i < 10; i++) {
                (new TarPitWorldGen(FABlockRegistry.INSTANCE.tar)).generate(world, random, new BlockPos(x + random.nextInt(9), random.nextInt(128), z + random.nextInt(9)));
            }
        }
    }
}