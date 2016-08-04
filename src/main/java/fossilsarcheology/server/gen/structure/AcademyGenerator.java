package fossilsarcheology.server.gen.structure;

import fossilsarcheology.Revival;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class AcademyGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case -1:
                // not currently generating anything in the nether
                // generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 0:
                // Recall that a chunk is only 16x16 blocks in area, so this is
                // quite a lot of structures
                if (random.nextInt(999) < 1) // This doesn't seem to actually corellate with anything.
                {
                    generateStructure(world, random, chunkX * 16, chunkZ * 16);
                    break;
                } else {
                    break;
                }

            default:
                break;
        }
    }

    private void generateStructure(World world, Random rand, int chunkX, int chunkZ) {
        // Need to create a new instance each time or the generate() methods may
        // overlap themselves and cause a crash
        // WorldGeneratorAcademy gen = new WorldGeneratorAcademy();
        FossilStructureGenerator generator = new FossilStructureGenerator();
        // if((biome instanceof BiomeGenDesert) || (biome instanceof
        // BiomeGenJungle) || (biome instanceof BiomeGenTaiga) || (biome
        // instanceof BiomeGenPlains))// then add ||BiomeGenXYZ if you want
        // more.
        // {
        // This will store a random index of the structure to generate
        int structure = rand.nextInt(FossilStructureGenerator.structures.size());
        // nice way of getting a height to work from; it returns the topmost
        // non-air block at an x/z position, such as tall grass, dirt or leaves
        BlockPos position = world.getHeight(new BlockPos(chunkX + rand.nextInt(16), 0, chunkZ + rand.nextInt(16)));

        // find ground level, ignoring blocks such as grass and water

        while (!world.isSideSolid(position, EnumFacing.UP) && (!world.isSideSolid(position.add(10, 0, 11), EnumFacing.UP) || !world.isSideSolid(position.add(-10, 0, -11), EnumFacing.UP) || !world.isSideSolid(position.add(10, 0, -11), EnumFacing.UP) || !world.isSideSolid(position.add(-10, 0, 11), EnumFacing.UP))) {
            position = position.down();
        }

        if ((world.isSideSolid(position, EnumFacing.UP) || !world.isSideSolid(position.add(10, 0, 11), EnumFacing.UP) || !world.isSideSolid(position.add(-10, 0, -11), EnumFacing.UP) || !world.isSideSolid(position.add(10, 0, -11), EnumFacing.UP) || !world.isSideSolid(position.add(-10, 0, 11), EnumFacing.UP)) && world.canSeeSky(position) || world.getBlockState(position.up()).getBlock() == Blocks.WATER) {
            return;
        } else {
            Revival.printDebug("Gen: Academy Spawn at " + position.getX() + ", " + position.getY() + ", " + position.getZ());
        }

        int widthX = FossilStructureGenerator.structures.get(structure).getWidthX();
        int widthZ = FossilStructureGenerator.structures.get(structure).getWidthZ();
        int height = FossilStructureGenerator.structures.get(structure).getHeight();
        // Set structure and random facing, then generate; no offset needed here
        generator.setStructure(FossilStructureGenerator.structures.get(structure));
        generator.setStructureFacing(rand.nextInt(4));
        generator.generate(world, rand, position);
    }

    // }
}
