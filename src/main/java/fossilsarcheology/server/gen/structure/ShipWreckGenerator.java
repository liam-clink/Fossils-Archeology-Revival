package fossilsarcheology.server.gen.structure;

import fossilsarcheology.Revival;
import fossilsarcheology.server.structure.util.Structure;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ShipWreckGenerator implements IWorldGenerator {
    private void generateStructure(World world, Random rand, int chunkX, int chunkZ) {
        // Need to create a new instance each time or the generate() methods may
        // overlap themselves and cause a crash
        // WorldGeneratorAcademy gen = new WorldGeneratorAcademy();
        FossilWaterStructureGenerator gen = new FossilWaterStructureGenerator();
        // This will store a random index of the structure to
        // generate
        int structure = rand.nextInt(FossilWaterStructureGenerator.structures.size());

        // nice way of getting a height to work from; it returns the topmost
        // non-air block at an x/z position, such as tall grass, dirt or leaves
        BlockPos position = world.getHeight(new BlockPos(chunkX + rand.nextInt(16), 0, chunkZ + rand.nextInt(16)));

        // find ground level, ignoring blocks such as grass and water

        while ((!world.isSideSolid(position, EnumFacing.UP))// && y >
            // world.provider.getAverageGroundLevel())
            // && (!world.doesBlockHaveSolidTopSurface(world, x + 10, y+4, z + 11)
            // || !world.doesBlockHaveSolidTopSurface(world, x - 10, y+4, z - 11)
            // || !world.doesBlockHaveSolidTopSurface(world, x + 10, y+4, z - 11)
            // || !world.doesBlockHaveSolidTopSurface(world, x - 10, y+4, z + 11))
                ) {
            position = position.down();
        }

        if (!world.isSideSolid(position, EnumFacing.UP) || world.getBlockState(position.up(2)).getBlock() != Blocks.WATER
            // || !world.doesBlockHaveSolidTopSurface(world, x + 10, y, z + 11)
            // || !world.doesBlockHaveSolidTopSurface(world, x - 10, y, z - 11)
            // || !world.doesBlockHaveSolidTopSurface(world, x + 10, y, z - 11)
            // || !world.doesBlockHaveSolidTopSurface(world, x - 10, y, z + 11))
            // && world.canBlockSeeTheSky(pos)
                ) {
            return;
        } else {
            Revival.printDebug("Gen: Shipwreck Spawn at " + position.getX() + ", " + position.getY() + ", " + position.getZ());
        }

        int widthX = ((Structure) FossilWaterStructureGenerator.structures.get(structure)).getSizeX();
        int widthZ = ((Structure) FossilWaterStructureGenerator.structures.get(structure)).getSizeZ();
        int height = ((Structure) FossilWaterStructureGenerator.structures.get(structure)).getHeight();
        // Set structure and random facing, then generate; no offset needed here
        gen.setStructure((Structure) FossilWaterStructureGenerator.structures.get(structure));
        gen.setStructureFacing(rand.nextInt(4));
        gen.generate(world, rand, position.down(rand.nextInt(3) + 3));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case -1:
                // not currently generating anything in the nether
                // generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;

            case 0:

                // 25% chance of a single structure per chunk; could make a weighted
                // list
                // Recall that a chunk is only 16x16 blocks in area, so this is
                // quite a lot of structures
                if (random.nextInt(1500) < 1)// Revival.fossilOptions.Debug_Gen_Rate_Shipwreck)
                {
                    generateStructure(world, random, chunkX * 16, chunkZ * 16);
                }

                break;

            default:
                break;
        }
    }
}
