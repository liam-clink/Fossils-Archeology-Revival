package mods.fossil.gens;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.fossilEnums.EnumDinoType;
import mods.fossil.gens.structure.academy.Academy1;
import mods.fossil.gens.structure.academy.Academy2;
import mods.fossil.gens.structure.academy.Academy3;
import mods.fossil.gens.structure.academy.Academy4;
import mods.fossil.gens.structure.academy.Academy5;
import mods.fossil.gens.structure.academy.Academy6;
import mods.fossil.gens.structure.academy.AcademyUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

import org.apache.logging.log4j.Level;

import coolalias.structuregenapi.util.LogHelper;
import coolalias.structuregenapi.util.Structure;
import coolalias.structuregenapi.util.StructureGeneratorBase;

public class FossilStructureGenerator extends StructureGeneratorBase
{
    /** List storing all structures currently available */
    public static final List<Structure> structures = new LinkedList<Structure>();

    int random_hole;
    // a better way would be to pass World in to the constructors and set the random_hole
    // value there, but I'm feeling lazy
    boolean value_set = false;

    int block_change;

    public FossilStructureGenerator(Entity entity, int[][][][] blocks)
    {
        super(entity, blocks);
    }

    public FossilStructureGenerator(Entity entity, int[][][][] blocks, int structureFacing)
    {
        super(entity, blocks, structureFacing);
    }

    public FossilStructureGenerator(Entity entity, int[][][][] blocks, int structureFacing, int offX, int offY, int offZ)
    {
        super(entity, blocks, structureFacing, offX, offY, offZ);
    }

    public FossilStructureGenerator()
    {
        super();
    }

    /**
    * Allows the use of block ids greater than 4096 as custom 'hooks' to trigger onCustomBlockAdded
    * @param fakeID Identifier for your 'event'. Absolute value must be greater than 4096
    * @param customData Custom data may be used to subtype events for given fakeID
    * @return Returns the real id of the block to spawn in the world; must be <= 4096
    */
    @Override
    public int getRealBlockID(int fakeID, int customData1)
    {
        LogHelper.log(Level.TRACE, "Getting real id from fake id: " + fakeID);

        switch (fakeID)
        {
            case AcademyUtil.CUSTOM_CHEST:
                return Block.getIdFromBlock(Blocks.chest);

            case AcademyUtil.SPAWN_VILLAGER:
                return Block.getIdFromBlock(Blocks.torch); // using this, the villager will be spawned post-generation

            case AcademyUtil.CUSTOM_SKULL:
                return Block.getIdFromBlock(Blocks.skull);

            case AcademyUtil.CUSTOM_SIGNWALL:
                return Block.getIdFromBlock(Blocks.wall_sign);

            case AcademyUtil.CUSTOM_SIGNPOST:
                return Block.getIdFromBlock(Blocks.standing_sign);

            case AcademyUtil.RANDOM_HOLE: // Used customData1 to store the real block id
                return customData1;

            case AcademyUtil.RANDOM_HOLE_L2: // Used customData1 to store the real block id
                return customData1;

            case AcademyUtil.RANDOM_HOLE_L3: // Used customData1 to store the real block id
                return customData1;

            case AcademyUtil.BIOME_BLOCK: // if we're doing anything funny like using RANDOM_HOLE
                return customData1;

            default:
                // note that SPAWN_VILLAGER would return 0 by default if we didn't set a custom id above,
                // which is what we would want for 'air' if we didn't care about post-gen spawning
                return 0;
        }
    }

    private EnumDinoType getDinosaur()
    {
        EnumDinoType[] var1 = EnumDinoType.values();
        int var2 = var1.length;
        Random var4 = new Random();
        EnumDinoType enumDinosaur;
        enumDinosaur = var1[var4.nextInt(var2)];
        return enumDinosaur;
    }
    /**
    * A custom 'hook' to allow setting of tile entities, spawning entities, etc.
    * @param fakeID The custom identifier used to distinguish between types
    * @param customData1 Custom data used to subtype events for given fakeID
    * @param customData2 Additional custom data
    */
    @Override
    public void onCustomBlockAdded(World world, int x, int y, int z, int fakeID, int customData1, int customData2)
    {
        if (!value_set)
        {
            // if using this method, this should only be done once per structure, preferably with a better method
            // sets one value of RANDOM_HOLE to remove from the structure, allowing for patterns
            random_hole = world.rand.nextInt(5);
            value_set = true;
        }

        int meta = world.getBlockMetadata(x, y, z);
        LogHelper.log(Level.TRACE, "Setting custom block info for fake id " + fakeID + " and customData1 " + customData1);
        LogHelper.log(Level.TRACE, "Custom block metadata from world = " + meta);

        switch (fakeID)
        {
            case AcademyUtil.CUSTOM_CHEST:
                Random rand = new Random();

                // Using the pre-made method addItemToTileInventory adds items to the first slot available

                // Here we use customData to subtype custom_chest:
                if (customData1 == AcademyUtil.RARE_LOOT_F1)
                {
                    for (int iterate = 0; iterate < rand.nextInt(3) + 3; iterate++)
                    {
                        int i = (new Random()).nextInt(EnumDinoType.values().length + 1); //+1 for the sapling
                        Item i0 = null;

                        if (i == 0)
                        {
                            i0 = Fossil.brokenSapling;
                        }
                        else
                        {
                            i0 = EnumDinoType.values()[i - 1].DNAItem;
                        }

                        int loot = (int)(Math.random() * 100);

                        if (loot < 80)
                        {
                            addItemToTileInventory(world, new ItemStack(i0, rand.nextInt(5)), x, y, z);
                        }
                    }
                }
                // Not our specific chest, so we'll do some generic stuff
                if (customData1 == AcademyUtil.COMMON_LOOT_F1)
                {
                    //How many times to iterate through the list for loot
                    for (int iterate = 0; iterate < rand.nextInt(12); iterate++)
                    {
                        int loot = rand.nextInt(100);

                        if (loot < 30)
                        {
                            addItemToTileInventory(world, new ItemStack(Items.paper, rand.nextInt(22)), x, y, z);
                        }
                        else if (loot < 40)
                        {
                            addItemToTileInventory(world, new ItemStack(Items.book, rand.nextInt(12)), x, y, z);
                        }
                        else if (loot < 50)
                        {
                            addItemToTileInventory(world, new ItemStack(Items.bone, rand.nextInt(22)), x, y, z);
                        }
                        else if (loot < 60)
                        {
                            addItemToTileInventory(world, new ItemStack(Items.writable_book, rand.nextInt(5)), x, y, z);
                        }
                        else if (loot < 75)
                        {
                            addItemToTileInventory(world, new ItemStack(Fossil.biofossil, rand.nextInt(22)), x, y, z);
                        }
                        else if (loot < 85)
                        {
                            addItemToTileInventory(world, new ItemStack(Fossil.woodjavelin, rand.nextInt(16)), x, y, z);
                        }
                        else if (loot < 95)
                        {
                            addItemToTileInventory(world, new ItemStack(Fossil.stonejavelin, rand.nextInt(16)), x, y, z);
                        }
                        else if (loot < 101)
                        {
                            addItemToTileInventory(world, new ItemStack(Fossil.drum, 1), x, y, z);
                        }
                    }
                }

                if (customData1 == AcademyUtil.RARE_LOOT_F2)
                {
                    for (int iterate = 0; iterate < rand.nextInt(1) + 3; iterate++)
                    {
                        int i = (new Random()).nextInt(10); //+1 for the sapling
                        
                        if (i < 3)
                        	addItemToTileInventory(world, new ItemStack(Fossil.dinoPedia, rand.nextInt(2)), x, y, z);
                        else if(i < 7)
                        	addItemToTileInventory(world, new ItemStack(Fossil.relic, rand.nextInt(10)), x, y, z);
                        else {
                        	addItemToTileInventory(world, new ItemStack(Fossil.potteryShards, rand.nextInt(10)), x, y, z);
                        }                 
                    }
                }
                // Not our specific chest, so we'll do some generic stuff
                if (customData1 == AcademyUtil.COMMON_LOOT_F2)
                {
                    //How many times to iterate through the list for loot
                    for (int iterate = 0; iterate < rand.nextInt(12); iterate++)
                    {
                        int loot = rand.nextInt(100);

                        if (loot < 40)
                        {
                            addItemToTileInventory(world, new ItemStack(Items.paper, rand.nextInt(22)), x, y, z);
                        }
                        else if (loot < 60)
                        {
                            addItemToTileInventory(world, new ItemStack(Items.dye , 0 , rand.nextInt(10)), x, y, z);
                        }
                        else if (loot < 80)
                        {
                            addItemToTileInventory(world, new ItemStack(Items.string, rand.nextInt(10)), x, y, z);
                        }
                        else if (loot < 90)
                        {
                            addItemToTileInventory(world, new ItemStack(Items.compass, rand.nextInt(2)), x, y, z);
                        }
                        else if (loot < 101)
                        {
                            addItemToTileInventory(world, new ItemStack(Items.map, rand.nextInt(5)), x, y, z);
                        }
                    }
                }
                
                if (customData1 == AcademyUtil.RARE_LOOT_F3)
                {
                    //How many times to iterate through the list for loot
                    for (int iterate = 0; iterate < rand.nextInt(4); iterate++)
                    {
                        int loot = rand.nextInt(100);
                        

                        
                        if (loot < 20)
                        {
                            addItemToTileInventory(world, new ItemStack(Fossil.ancientGlass, rand.nextInt(10)), x, y, z);
                        }
                        else if (loot < 40)
                        {
                            addItemToTileInventory(world, new ItemStack(Fossil.ancientWood, rand.nextInt(15)), x, y, z);
                        }
                        else if (loot < 50)
                        {
                            addItemToTileInventory(world, new ItemStack(Fossil.whip, 1), x, y, z);
                        }
                        else if (loot < 60)
                        {
                        addItemToTileInventory(world, (new ItemStack(Item.getItemFromBlock(Fossil.figurineBlock), rand.nextInt(2), rand.nextInt(15))), x, y, z);
                        }
                        else if (loot < 80)
                        {
                        	addItemToTileInventory(world, new ItemStack(Items.iron_ingot, rand.nextInt(15)), x, y, z);
                        }
                        else if (loot < 90)
                        {
                            addItemToTileInventory(world, new ItemStack(Fossil.fossilrecordBones, 1), x, y, z);
                        }
                        else if (loot < 101)
                        {
                            addItemToTileInventory(world, new ItemStack(Items.name_tag, rand.nextInt(2)), x, y, z);
                        }
                        
                    }
                }

                break;

            case AcademyUtil.CUSTOM_SIGNWALL: // no 'break' so it goes into the next case
            case AcademyUtil.CUSTOM_SIGNPOST:
                // An array that stores up to 4 Strings, the max capacity of a sign
                // Best to allocate the array to the size you need
                String[] text;

                // Set different text for each custom sign, using different colors
                if (customData1 == AcademyUtil.CUSTOM_SIGN_1)
                {
                    // max number of lines is 4; any more than that will be ignored
                    text = new String[5];
                    text[0] = EnumChatFormatting.DARK_RED + " BEWARE";
                    text[1] = EnumChatFormatting.DARK_RED + " NO ENTRY";
                    // the following string is too long and will automatically be truncated to the correct length
                    text[2] = EnumChatFormatting.DARK_BLUE + "Enter at your abcdefghijklm";
                    text[3] = EnumChatFormatting.DARK_GRAY + " own risk.";
                    text[4] = "Never prints!";
                }
                else
                {
                    // best to allocate only what is needed, here just one line
                    text = new String[1];
                    text[0] = EnumChatFormatting.BLACK + "Sign Post Text";
                }

                // Use this easy method to add text to the sign's tile entity:
                setSignText(world, text, x, y, z);
                break;

            case AcademyUtil.CUSTOM_SKULL:
                // Easily set the skull type or player name if you know it:
                setSkullData(world, customData1, x, y, z);
                break;

            case AcademyUtil.RANDOM_HOLE:

                // One way to generate holes would be to set a random int once per structure,
                // then remove only hole blocks with that value, allowing for custom patterns
                //if (random_hole == customData2)
                //world.setBlockToAir(x, y, z);

                // another way that doesn't use customData2 would be to use world.rand.nextFloat()
                // use whatever value you want to check against, I used 0.25F so 25% will become holes
                // this way is nice because we don't need to set customData2 for all these blocks
                if (world.rand.nextFloat() < 0.15F)
                {
                    world.setBlockToAir(x, y, z);
                }

                break;

            case AcademyUtil.RANDOM_HOLE_L2:

                // One way to generate holes would be to set a random int once per structure,
                // then remove only hole blocks with that value, allowing for custom patterns
                //if (random_hole == customData2)
                //world.setBlockToAir(x, y, z);

                // another way that doesn't use customData2 would be to use world.rand.nextFloat()
                // use whatever value you want to check against, I used 0.25F so 25% will become holes
                // this way is nice because we don't need to set customData2 for all these blocks
                if (world.rand.nextFloat() < 0.20F)
                {
                    world.setBlockToAir(x, y, z);
                }

                break;

            case AcademyUtil.RANDOM_HOLE_L3:

                // One way to generate holes would be to set a random int once per structure,
                // then remove only hole blocks with that value, allowing for custom patterns
                //if (random_hole == customData2)
                //world.setBlockToAir(x, y, z);

                // another way that doesn't use customData2 would be to use world.rand.nextFloat()
                // use whatever value you want to check against, I used 0.25F so 25% will become holes
                // this way is nice because we don't need to set customData2 for all these blocks
                if (world.rand.nextFloat() < 0.25F)
                {
                    world.setBlockToAir(x, y, z);
                }

                break;

            case AcademyUtil.SPAWN_VILLAGER:
                // here I'm using customData as the villagerID
                Entity bob = new EntityVillager(world, customData1);
                //Entity X = new EntityHorse(world);
                //((EntityHorse) X).func_110235_q(1026);
                // Now use the preset method to avoid spawning in walls
                spawnEntityInStructure(world, bob, x, y, z);
                break;

            case AcademyUtil.BIOME_BLOCK:
                BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);

                if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FOREST)
                		|| BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.JUNGLE)
                		|| BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.SWAMP))
                {
                    //Using a switch statement here if we want to change multiple blocks
                    switch (customData1)
                    {
                        case 1: // ancient stone
                            world.setBlock(x, y, z, Blocks.mossy_cobblestone);
                            break;

                        case 2: //stone brick
                            world.setBlock(x, y, z, Fossil.ancientWood);
                            break;

                        default:
                            world.setBlock(x, y, z, Blocks.obsidian);
                            break;
                    }
                }
                else if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.PLAINS)
                		|| BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.HILLS)
                		|| BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.COLD)
                		|| BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.WATER)
                		|| BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.WASTELAND)
                		|| BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.MOUNTAIN))
                {
                    switch (customData1)
                    {
                        case 1: // ancient stone
                            world.setBlock(x, y, z, Fossil.ancientStonebrick);
                            break;

                        case 2: //stone brick
                            world.setBlock(x, y, z, Blocks.stonebrick);
                            break;

                        default:
                            world.setBlock(x, y, z, Blocks.obsidian);
                            break;
                    }
                }
                else if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.BEACH)
                		|| BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.HOT)
                		|| BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.SANDY))
                {
                    switch (customData1)
                    {
                        case 1: // ancient stone
                            world.setBlock(x, y, z, Blocks.sandstone);
                            break;

                        case 2: //stone brick
                            world.setBlock(x, y, z, Blocks.sandstone);
                            break;

                        default:
                            world.setBlock(x, y, z, Blocks.obsidian);
                            break;
                    }
                }
                else
                {
                    switch (customData1)
                    {
                        case 1: // ancient stone
                            world.setBlock(x, y, z, Fossil.ancientStonebrick);
                            break;

                        case 2: //stone brick
                            world.setBlock(x, y, z, Blocks.stonebrick);
                            break;

                        default:
                            world.setBlock(x, y, z, Blocks.obsidian);
                            break;
                    }
                }

                //Since we're using customdata1 for the block change, we need 2 if we want to remove random blocks.
                switch (customData2)
                {
                    case 1:
                        if (world.rand.nextFloat() < 0.15F)
                        {
                            world.setBlockToAir(x, y, z);
                        }

                        break;

                    case 2:
                        if (world.rand.nextFloat() < 0.20F)
                        {
                            world.setBlockToAir(x, y, z);
                        }

                        break;

                    case 3:
                        if (world.rand.nextFloat() < 0.25F)
                        {
                            world.setBlockToAir(x, y, z);
                        }

                        break;

                    default:
                        break;
                }

                break;

            default:
                LogHelper.log(Level.WARN, "No custom method defined for id " + fakeID);
        }
    }

    /**
    * Add all structures to the Structure List
    */
    static
    {
        Structure structure = new Structure("Academy");
        structure.addBlockArray(Academy1.blockArrayAcademy);
        structure.addBlockArray(Academy2.blockArrayAcademy);
        structure.addBlockArray(Academy3.blockArrayAcademy);
        structure.addBlockArray(Academy4.blockArrayAcademy);
        structure.addBlockArray(Academy5.blockArrayAcademy);
        structure.addBlockArray(Academy6.blockArrayAcademy);
        structure.setStructureOffset(0, -1, 0);
        structures.add(structure);
        /*Structure structure = new Structure("Hut");
        structure.addBlockArray(StructureArrays.blockArrayNPCHut);
        structure.setFacing(StructureGeneratorBase.EAST);
        // has a buffer layer on the bottom in case no ground; spawn at y-1 for ground level
        structure.setStructureOffset(0, -1, 0);
        structures.add(structure);

        structure = new Structure("Blacksmith");
        structure.addBlockArray(StructureArrays.blockArrayNPCBlackSmith);
        structure.setFacing(StructureGeneratorBase.NORTH);
        structures.add(structure);

        structure = new Structure("Viking Shop");
        structure.addBlockArray(StructureArrays.blockArrayShop);
        structure.setFacing(StructureGeneratorBase.WEST);
        structures.add(structure);

        structure = new Structure("Redstone Dungeon");
        structure.addBlockArray(StructureArrays.blockArrayRedstone);
        //structure.setFacing(StructureGeneratorBase.EAST);
        structures.add(structure);

        structure = new Structure("Offset Test");
        structure.addBlockArray(StructureArrays.blockArraySpawnTest);
        /*
        structure.addBlockArray(StructureArrays.blockArrayOffsetTest1);
        structure.addBlockArray(StructureArrays.blockArrayOffsetTest2);
        structure.addBlockArray(StructureArrays.blockArrayOffsetTest2);
        structure.addBlockArray(StructureArrays.blockArrayOffsetTest2);
        structure.addBlockArray(StructureArrays.blockArrayOffsetTest1);
        */
        //structure.setFacing(StructureGeneratorBase.NORTH);
        //structures.add(structure);
    }
}