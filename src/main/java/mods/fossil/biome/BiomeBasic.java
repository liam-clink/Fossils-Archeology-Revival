package mods.fossil.biome;

import java.util.Random;
import mods.fossil.entity.mob.EntitySentryPigman;
import mods.fossil.gens.feature.WorldGenHellMushoom;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;

public class BiomeBasic extends BiomeGenBase{

	public int genSelector;
	public BiomeBasic(int id, Block topBlock, Block fillerBlock, boolean clearAnimals, int lifeSelector, int genSelector) {
		super(id);
		this.topBlock = topBlock;
		this.fillerBlock = fillerBlock;
		this.genSelector = genSelector;
		if(clearAnimals){
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();

		}
		if(genSelector == 0){
		}
		if(lifeSelector == 0){
			this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPigZombie.class, 200, 1, 8));
			this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySentryPigman.class, 200, 1, 4));
		}
		if(lifeSelector == 1){}

	}

	public void decorate(World world, Random rand, int x, int z)
	{
		super.decorate(world, rand, x, z);
		if(genSelector == 0){

			int k = x + rand.nextInt(16) + 8;
			int l = z + rand.nextInt(16) + 8;
			if(rand.nextInt(1) == 0){
				if( world.getHeightValue(k, l) < 57){
					WorldGenHellMushoom worldGenGiantMushroom = new WorldGenHellMushoom();
					worldGenGiantMushroom.generate(world, rand, k, world.getHeightValue(k, l) + 1, l);

				}
			}
		}
	}
}
