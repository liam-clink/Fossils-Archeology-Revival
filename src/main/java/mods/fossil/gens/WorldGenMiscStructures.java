package mods.fossil.gens;

import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.client.FossilOptions;
import mods.fossil.gens.feature.WorldGenHellBoat;
import mods.fossil.gens.feature.WorldGenTarPit;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenSwamp;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenSwamp;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenMiscStructures implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{			 
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ);	
		if(FossilOptions.Gen_HellShips){
			if(BiomeDictionary.isBiomeOfType(biome, Type.NETHER))
			{
				if(random.nextInt(48) == 0){
					int Xcoord1 = chunkX * 16 + random.nextInt(16);
					int Ycoord1 = 31;
					int Zcoord1 = chunkZ * 16 + random.nextInt(16);

					new WorldGenHellBoat().generate(world, random, Xcoord1, Ycoord1, Zcoord1);
				}
			}
		}
	}
}