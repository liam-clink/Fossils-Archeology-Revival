package fossilsarcheology.server.gen;

import fossilsarcheology.Revival;
import fossilsarcheology.server.gen.feature.AncientChestWorldGen;
import fossilsarcheology.server.gen.feature.AnuCastleWorldGen;
import fossilsarcheology.server.gen.feature.AztecWeaponsShopWorldGen;
import fossilsarcheology.server.gen.feature.FossilSiteWorldGen;
import fossilsarcheology.server.gen.feature.HellBoatWorldGen;
import fossilsarcheology.server.gen.feature.MoaiWorldGen;
import fossilsarcheology.server.gen.feature.TarSiteWorldGen;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenMiscStructures implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        random.setSeed(world.getSeed() * chunkX * chunkZ);
        if (Revival.CONFIG.generateHellShips) {
            Biome biome = world.getBiomeProvider().getBiomeGenerator(new BlockPos(chunkX * 16, 0, chunkZ * 16));
            if (BiomeDictionary.isBiomeOfType(biome, Type.NETHER)) {
                if (random.nextInt(48) == 0) {
                    new HellBoatWorldGen().generate(world, random, new BlockPos(chunkX * 16 + random.nextInt(16), 31, chunkZ * 16 + random.nextInt(16)));
                }
            }
        }
        if (Revival.CONFIG.generateMoai) {
            if (random.nextInt(100) == 0) {
                BlockPos position = world.getHeight(new BlockPos(chunkX * 16 + random.nextInt(16), 0, chunkZ * 16 + random.nextInt(16)));
                Biome biome = world.getBiomeProvider().getBiomeGenerator(position);
                if (BiomeDictionary.isBiomeOfType(biome, Type.BEACH) && !world.provider.getHasNoSky() && !world.provider.doesWaterVaporize() && world.getBlockState(position.down()) == Blocks.SAND.getDefaultState()) {
                    new MoaiWorldGen().generate(world, random, position.down(random.nextInt(4)));
                }
            }
            if (Revival.CONFIG.generateAztecWeaponShops) {
                if (random.nextInt(65) == 0) {
                    BlockPos position = world.getHeight(new BlockPos(chunkX * 16 + random.nextInt(16), 0, chunkZ * 16 + random.nextInt(16)));
                    Biome biome = world.getBiomeProvider().getBiomeGenerator(position);
                    if (BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE) && !world.provider.getHasNoSky() && !world.provider.doesWaterVaporize() && biome.topBlock == Blocks.GRASS.getDefaultState() && world.getBlockState(position.down()) == biome.topBlock) {
                        new AztecWeaponsShopWorldGen().generate(world, random, position.down(4));
                    }
                }
            }
            if (Revival.CONFIG.generateTarSites) {
                if (random.nextInt(600) == 0) {
                    BlockPos position = world.getHeight(new BlockPos(chunkX * 16 + random.nextInt(16), 0, chunkZ * 16 + random.nextInt(16)));
                    Biome biome = world.getBiomeProvider().getBiomeGenerator(position);
                    if (!world.provider.getHasNoSky() && !world.provider.doesWaterVaporize() && biome.topBlock == Blocks.GRASS.getDefaultState() && world.getBlockState(position.down()) == biome.topBlock) {
                        new TarSiteWorldGen().generate(world, random, position.down(3));
                    }
                }
            }
            if (Revival.CONFIG.generateFossilSites) {
                if (random.nextInt(600) == 0) {
                    BlockPos position = world.getHeight(new BlockPos(chunkX * 16 + random.nextInt(16), 0, chunkZ * 16 + random.nextInt(16)));
                    Biome biome = world.getBiomeProvider().getBiomeGenerator(position);
                    if (!world.provider.getHasNoSky() && !world.provider.doesWaterVaporize() && biome.topBlock == Blocks.GRASS.getDefaultState() && world.getBlockState(position.down()) == biome.topBlock) {
                        new FossilSiteWorldGen().generate(world, random, position.down(3));
                    }
                }
            }
            if (world.provider.getDimension() == Revival.CONFIG.dimensionIDDarknessLair && world.getChunkFromChunkCoords(chunkX, chunkZ) == world.getChunkFromBlockCoords(new BlockPos(-70, 0, -70))) {
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
                                world.setBlockState(new BlockPos(pos), Blocks.NETHERRACK.getDefaultState());
                            }
                        }
                    }
                }
            }
            if (world.provider.getDimension() == Revival.CONFIG.dimensionIDTreasure && world.getChunkFromChunkCoords(chunkX, chunkZ) == world.getChunkFromBlockCoords(new BlockPos(-80, 0, -120))) {
                new AncientChestWorldGen().generate(world, random, -80, 63, -120);
            }
        }
    }
}
