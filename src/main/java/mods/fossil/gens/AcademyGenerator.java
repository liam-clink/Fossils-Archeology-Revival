package mods.fossil.gens;

import cpw.mods.fml.common.IWorldGenerator;
import mods.fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class AcademyGenerator implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
                         IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
            case -1:
                // not currently generating anything in the nether
                // generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;

            case 0:

                // Recall that a chunk is only 16x16 blocks in area, so this is quite a lot of structures
                if (random.nextInt(999) < 1) //This doesn't seem to actually corellate with anything.
                {
                    generateStructure(world, random, chunkX * 16, chunkZ * 16);
                }
                break;

            default:
                break;
        }
    }

    private final void generateStructure(World world, Random rand, int chunkX, int chunkZ)
    {
        BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ);
        // Need to create a new instance each time or the generate() methods may overlap themselves and cause a crash
        //WorldGeneratorAcademy gen = new WorldGeneratorAcademy();
        FossilStructureGenerator gen = new FossilStructureGenerator();
        //  if((biome instanceof BiomeGenDesert) || (biome instanceof BiomeGenJungle) || (biome instanceof BiomeGenTaiga) || (biome instanceof BiomeGenPlains))// then add ||BiomeGenXYZ if you want more.
        // {
        int struct; // This will store a random index of the structure to generate
        struct = rand.nextInt(gen.structures.size());
        int x = chunkX + rand.nextInt(16);
        int z = chunkZ + rand.nextInt(16);
        // nice way of getting a height to work from; it returns the topmost
        // non-air block at an x/z position, such as tall grass, dirt or leaves
        int y = world.getHeightValue(x, z);

        // find ground level, ignoring blocks such as grass and water

        while ((!world.doesBlockHaveSolidTopSurface(world, x, y, z))//  && y > world.provider.getAverageGroundLevel())
                && (!world.doesBlockHaveSolidTopSurface(world, x + 10, y, z + 11)
                    || !world.doesBlockHaveSolidTopSurface(world, x - 10, y, z - 11)
                    || !world.doesBlockHaveSolidTopSurface(world, x + 10, y, z - 11)
                    || !world.doesBlockHaveSolidTopSurface(world, x - 10, y, z + 11))
              )
        {
            --y;
        }

        if (!world.doesBlockHaveSolidTopSurface(world, x, y, z)
                || !world.doesBlockHaveSolidTopSurface(world, x + 10, y, z + 11)
                || !world.doesBlockHaveSolidTopSurface(world, x - 10, y, z - 11)
                || !world.doesBlockHaveSolidTopSurface(world, x + 10, y, z - 11)
                || !world.doesBlockHaveSolidTopSurface(world, x - 10, y, z + 11)
                || !world.canBlockSeeTheSky(x, y, z)
                || Block.getIdFromBlock(world.getBlock(x, y + 1, z)) == Block.getIdFromBlock(Blocks.water))
        {
            return;
        }
        else
        {
            Fossil.Console("Gen: Academy Spawn at " + x + ", " + y + ", " + z);
        }

        int widthX = gen.structures.get(struct).getWidthX();
        int widthZ = gen.structures.get(struct).getWidthZ();
        int height = gen.structures.get(struct).getHeight();
        // Set structure and random facing, then generate; no offset needed here
        gen.setStructure(gen.structures.get(struct));
        gen.setStructureFacing(rand.nextInt(4));
        gen.generate(world, rand, x, y, z);
    }

    //}
}
