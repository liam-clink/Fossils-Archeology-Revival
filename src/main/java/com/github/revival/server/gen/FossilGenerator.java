package com.github.revival.server.gen;

import com.github.revival.Revival;
import com.github.revival.server.block.FABlockRegistry;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class FossilGenerator implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for (int dimensionID : Revival.CONFIG.oreGenerationDimensions) {
			if (world.provider.dimensionId == dimensionID) {
				generateFossils(world, random, chunkX * 16, chunkZ * 16);
			}
		}
	}

	private void generateFossils(World world, Random random, int blockX, int blockZ) {
		if (Revival.CONFIG.generateFossils) {
			for (int i = 0; i < 38; i++) {
				int Xcoord = blockX + random.nextInt(16);
				int Ycoord = random.nextInt(100);
				int Zcoord = blockZ + random.nextInt(16);
				(new WorldGenMinable(FABlockRegistry.INSTANCE.blockFossil, 5 + random.nextInt(6))).generate(world, random, Xcoord, Ycoord, Zcoord);
			}
		}
		if (Revival.CONFIG.generatePermafrost) {
			for (int i = 0; i < 8; i++) {
				int Xcoord = blockX + random.nextInt(16);
				int Ycoord = random.nextInt(30);
				int Zcoord = blockZ + random.nextInt(16);
				(new WorldGenMinable(FABlockRegistry.INSTANCE.blockPermafrost, 2 + random.nextInt(4))).generate(world, random, Xcoord, Ycoord, Zcoord);
			}
		}
	}
}