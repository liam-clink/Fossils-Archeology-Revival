package com.github.revival.common.gen;

import com.github.revival.common.config.FossilConfig;
import com.github.revival.common.gen.feature.WorldGenAncientChest;
import com.github.revival.common.gen.feature.WorldGenAnuCastle;
import com.github.revival.common.gen.feature.WorldGenHellBoat;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import java.util.Random;

public class WorldGenMiscStructures implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ);
        if (FossilConfig.generateHellShips)
        {
            if (BiomeDictionary.isBiomeOfType(biome, Type.NETHER))
            {
                if (random.nextInt(48) == 0)
                {
                    int Xcoord1 = chunkX * 16 + random.nextInt(16);
                    int Ycoord1 = 31;
                    int Zcoord1 = chunkZ * 16 + random.nextInt(16);

                    new WorldGenHellBoat().generate(world, random, Xcoord1, Ycoord1, Zcoord1);
                }
            }
        }
        if (world.getChunkFromChunkCoords(chunkX, chunkZ) == world.getChunkFromBlockCoords(-70, -70) && world.provider.dimensionId == FossilConfig.dimIdDarknessLair)
        {
            int counter = 0;
            counter++;
            if (counter == 1)
            {
                new WorldGenAnuCastle().generate(world, random, -70, 61, -70);
            }
        }
        if (world.getChunkFromChunkCoords(chunkX, chunkZ) == world.getChunkFromBlockCoords(-80, -120) && world.provider.dimensionId == FossilConfig.dimIdTreasure)
        {
            int counter = 0;
            counter++;
            if (counter == 1)
            {
                new WorldGenAncientChest().generate(world, random, -80, 63, -120);
            }
        }
    }
}
