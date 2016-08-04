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

public class FossilGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        for (int dimensionID : Revival.CONFIG.oreGenerationDimensions) {
            if (world.provider.getDimension() == dimensionID) {
                generateFossils(world, random, chunkX * 16, chunkZ * 16);
            }
        }
    }

    private void generateFossils(World world, Random random, int blockX, int blockZ) {
        if (Revival.CONFIG.generateFossils) {
            for (int i = 0; i < 38; i++) {
                (new WorldGenMinable(FABlockRegistry.INSTANCE.blockFossil.getDefaultState(), 5 + random.nextInt(6))).generate(world, random, new BlockPos(blockX + random.nextInt(16), random.nextInt(100), blockZ + random.nextInt(16)));
            }
        }
        if (Revival.CONFIG.generatePermafrost) {
            for (int i = 0; i < 8; i++) {
                (new WorldGenMinable(FABlockRegistry.INSTANCE.blockPermafrost.getDefaultState(), 2 + random.nextInt(4))).generate(world, random, new BlockPos(blockX + random.nextInt(16), random.nextInt(30), blockZ + random.nextInt(16)));
            }
        }
    }
}