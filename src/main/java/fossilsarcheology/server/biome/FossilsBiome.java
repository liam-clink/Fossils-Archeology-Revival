package fossilsarcheology.server.biome;

import fossilsarcheology.server.entity.mob.EntitySentryPigman;
import fossilsarcheology.server.gen.feature.HellMushroomWorldGen;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.Random;

public class FossilsBiome extends Biome {
    public int genSelector;

    public FossilsBiome(BiomeProperties properties, IBlockState topBlock, IBlockState fillerBlock, boolean clearAnimals, int lifeSelector, int genSelector) {
        super(properties);
        this.topBlock = topBlock;
        this.fillerBlock = fillerBlock;
        this.genSelector = genSelector;
        if (clearAnimals) {
            this.spawnableMonsterList.clear();
            this.spawnableCreatureList.clear();
            this.spawnableWaterCreatureList.clear();
            this.spawnableCaveCreatureList.clear();

        }
        if (lifeSelector == 0) {
            this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPigZombie.class, 200, 1, 8));
            this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySentryPigman.class, 200, 1, 4));
        }
    }

    @Override
    public void decorate(World world, Random rand, BlockPos pos) {
        super.decorate(world, rand, pos);
        if (genSelector == 0) {
            int generateX = pos.getX() + rand.nextInt(16) + 8;
            int generateZ = pos.getZ() + rand.nextInt(16) + 8;
            if (rand.nextInt(1) == 0) {
                BlockPos mushroomPosition = world.getHeight(new BlockPos(generateX, 0, generateZ));
                if (mushroomPosition.getY() < 57) {
                    HellMushroomWorldGen hellMushroom = new HellMushroomWorldGen();
                    hellMushroom.generate(world, rand, mushroomPosition.up());
                }
            }
        }
    }
}
