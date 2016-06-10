package com.github.revival.server.gen;

import com.github.revival.Revival;
import com.github.revival.server.gen.feature.AncientChestWorldGen;
import com.github.revival.server.gen.feature.AnuCastleWorldGen;
import com.github.revival.server.gen.feature.HellBoatWorldGen;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import java.util.Random;

public class WorldGenMiscStructures implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ);
		if (Revival.CONFIG.generateHellShips) {
			if (BiomeDictionary.isBiomeOfType(biome, Type.NETHER)) {
				if (random.nextInt(48) == 0) {
					int Xcoord1 = chunkX * 16 + random.nextInt(16);
					int Ycoord1 = 31;
					int Zcoord1 = chunkZ * 16 + random.nextInt(16);

					new HellBoatWorldGen().generate(world, random, Xcoord1, Ycoord1, Zcoord1);
				}
			}
		}
		if (world.getChunkFromChunkCoords(chunkX, chunkZ) == world.getChunkFromBlockCoords(-70, -70) && world.provider.dimensionId == Revival.CONFIG.dimensionIDDarknessLair) {
			int counter = 0;
			counter++;
			if (counter == 1) {
				new AnuCastleWorldGen().generate(world, random, -70, 61, -70);
			}
		}
		if (world.getChunkFromChunkCoords(chunkX, chunkZ) == world.getChunkFromBlockCoords(-80, -120) && world.provider.dimensionId == Revival.CONFIG.dimensionIDTreasure) {
			int counter = 0;
			counter++;
			if (counter == 1) {
				new AncientChestWorldGen().generate(world, random, -80, 63, -120);
			}
		}
	}
}
