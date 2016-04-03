package com.github.revival.server.gen;

import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.gen.feature.TarPitWorldGen;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenSwamp;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenSwamp;

import java.util.Random;

public class TarGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
                         IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);

            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    public void generateSurface(World world, Random random, int i, int j) {
        BiomeGenBase biomegenbase = world.getWorldChunkManager().getBiomeGenAt(
                i, j);
        WorldGenSwamp worldgenswamp = new WorldGenSwamp();

        if (biomegenbase instanceof BiomeGenSwamp) {
            for (int k = 0; k < 10; k++) {
                int l = i + random.nextInt(9);
                int i1 = random.nextInt(128);
                int j1 = j + random.nextInt(9);
                (new TarPitWorldGen(FABlockRegistry.INSTANCE.tar)).generate(world, random, l, i1,
                        j1);
            }
        }
    }

    private void generateNether(World world, Random random, int blockX,
                                int blockZ) {
    }
}