package fossilsarcheology.server.gen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import cpw.mods.fml.common.IWorldGenerator;
import fossilsarcheology.Revival;
import fossilsarcheology.server.gen.feature.AncientChestWorldGen;
import fossilsarcheology.server.gen.feature.AnuCastleWorldGen;
import fossilsarcheology.server.gen.feature.AztecWeaponsShopWorldGen;
import fossilsarcheology.server.gen.feature.FossilSiteWorldGen;
import fossilsarcheology.server.gen.feature.HellBoatWorldGen;
import fossilsarcheology.server.gen.feature.MoaiWorldGen;
import fossilsarcheology.server.gen.feature.TarSiteWorldGen;

public class WorldGenMiscStructures implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		random.setSeed(world.getSeed() * chunkX * chunkZ);
		if (Revival.CONFIG.generateHellShips) {
			if (random.nextInt(100) == 0) {
				int Xcoord1 = chunkX * 16 + random.nextInt(16);
				int Zcoord1 = chunkZ * 16 + random.nextInt(16);
				int Ycoord1 = 32;
				if (world.provider.isHellWorld && world.getBlock(Xcoord1, 31, Zcoord1) == Blocks.lava) {
					new HellBoatWorldGen().generate(world, random, Xcoord1, Ycoord1, Zcoord1);
				}
			}
		}
		if (Revival.CONFIG.generateMoai) {
			if (random.nextInt(100) == 0) {
				int Xcoord1 = chunkX * 16 + random.nextInt(16);
				int Zcoord1 = chunkZ * 16 + random.nextInt(16);
				int Ycoord1 = world.getHeightValue(Xcoord1, Zcoord1);
				BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(Xcoord1, Zcoord1);
				if (BiomeDictionary.isBiomeOfType(biome, Type.BEACH) && !world.provider.hasNoSky && !world.provider.isHellWorld && world.getBlock(Xcoord1, Ycoord1 - 1, Zcoord1) == Blocks.sand) {
					new MoaiWorldGen().generate(world, random, Xcoord1, Ycoord1 - random.nextInt(4), Zcoord1);
				}
			}
			if (Revival.CONFIG.generateAztecWeaponShops) {
				if (random.nextInt(65) == 0) {
					int Xcoord1 = chunkX * 16 + random.nextInt(16);
					int Zcoord1 = chunkZ * 16 + random.nextInt(16);
					int Ycoord1 = world.getHeightValue(Xcoord1, Zcoord1);
					BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(Xcoord1, Zcoord1);
					if (BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE) && !world.provider.hasNoSky && !world.provider.isHellWorld && biome.topBlock == Blocks.grass && world.getBlock(Xcoord1, Ycoord1 - 1, Zcoord1) == biome.topBlock) {
						new AztecWeaponsShopWorldGen().generate(world, random, Xcoord1, Ycoord1 - 4, Zcoord1);
					}
				}
			}
			if (Revival.CONFIG.generateTarSites) {
				if (random.nextInt(1200) == 0) {
					int Xcoord1 = chunkX * 16 + random.nextInt(16);
					int Zcoord1 = chunkZ * 16 + random.nextInt(16);
					int Ycoord1 = world.getHeightValue(Xcoord1, Zcoord1);
					BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(Xcoord1, Zcoord1);
					if (!world.provider.hasNoSky && !world.provider.isHellWorld && biome.topBlock == Blocks.grass && world.getBlock(Xcoord1, Ycoord1 - 1, Zcoord1) == biome.topBlock) {
						new TarSiteWorldGen().generate(world, random, Xcoord1, Ycoord1 - 3, Zcoord1);
					}
				}
			}
			if (Revival.CONFIG.generateFossilSites) {
				if (random.nextInt(1200) == 0) {
					int Xcoord1 = chunkX * 16 + random.nextInt(16);
					int Zcoord1 = chunkZ * 16 + random.nextInt(16);
					int Ycoord1 = world.getHeightValue(Xcoord1, Zcoord1);
					BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(Xcoord1, Zcoord1);
					if (!world.provider.hasNoSky && !world.provider.isHellWorld && biome.topBlock == Blocks.grass && world.getBlock(Xcoord1, Ycoord1 - 1, Zcoord1) == biome.topBlock) {
						new FossilSiteWorldGen().generate(world, random, Xcoord1, Ycoord1 - 3, Zcoord1);
					}
				}
			}
			if (world.getChunkFromChunkCoords(chunkX, chunkZ) == world.getChunkFromBlockCoords(-70, -70) && world.provider.dimensionId == Revival.CONFIG.dimensionIDDarknessLair) {
				int counter = 0;
				counter++;
				if (counter == 1) {
					new AnuCastleWorldGen().generate(world, random, -70, 61, -70);
					int structurebase = 140;
					int base = 14;
					for (int y = 50; y < 63; y++) {
						base--;
						for (int x = -70 - base; x < structurebase - 70 + base; x++) {
							for (int z = -70 - base; z < structurebase - 70 + base; z++) {
								world.setBlock(x, y, z, Blocks.netherrack);
							}
						}
					}
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
}
