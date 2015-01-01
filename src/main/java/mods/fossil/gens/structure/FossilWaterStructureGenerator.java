package mods.fossil.gens.structure;

import coolalias.structuregenapi.util.LogHelper;
import coolalias.structuregenapi.util.Structure;
import coolalias.structuregenapi.util.StructureGeneratorBase;
import mods.fossil.Fossil;
import mods.fossil.client.FossilOptions;
import mods.fossil.fossilEnums.EnumDinoType;
import mods.fossil.gens.structure.shipwreck.ShipWreck1;
import mods.fossil.gens.structure.shipwreck.ShipWreck2;
import mods.fossil.gens.structure.shipwreck.ShipWreck3;
import mods.fossil.gens.structure.shipwreck.ShipWreckUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.Level;

public class FossilWaterStructureGenerator extends StructureGeneratorBase {
	/** List storing all structures currently available */
	public static final List<Structure> structures = new LinkedList();

	int random_hole;
	// a better way would be to pass World in to the constructors and set the
	// random_hole
	// value there, but I'm feeling lazy
	boolean value_set = false;

	public FossilWaterStructureGenerator(Entity entity, int[][][][] blocks) {
		super(entity, blocks);
	}

	public FossilWaterStructureGenerator(Entity entity, int[][][][] blocks,
			int structureFacing) {
		super(entity, blocks, structureFacing);
	}

	public FossilWaterStructureGenerator(Entity entity, int[][][][] blocks,
			int structureFacing, int offX, int offY, int offZ) {
		super(entity, blocks, structureFacing, offX, offY, offZ);
	}

	public FossilWaterStructureGenerator() {
		super();
	}

	/**
	 * Allows the use of block ids greater than 4096 as custom 'hooks' to
	 * trigger onCustomBlockAdded
	 * 
	 * @param fakeID
	 *            Identifier for your 'event'. Absolute value must be greater
	 *            than 4096
	 * @param customData
	 *            Custom data may be used to subtype events for given fakeID
	 * @return Returns the real id of the block to spawn in the world; must be
	 *         <= 4096
	 */
	@Override
	public int getRealBlockID(int fakeID, int customData1) {
		LogHelper.log(Level.TRACE, "Getting real id from fake id: " + fakeID);

		switch (fakeID) {
		case ShipWreckUtil.CUSTOM_CHEST:
			return Block.getIdFromBlock(Blocks.chest);

		case ShipWreckUtil.CUSTOM_DISPENSER:
			return Block.getIdFromBlock(Blocks.dispenser);

		case ShipWreckUtil.ITEM_FRAME: // same as PAINTING
			return Block.getIdFromBlock(Blocks.torch);

		case ShipWreckUtil.PAINTING:
			return Block.getIdFromBlock(Blocks.torch); // need to do
														// post-generation
														// setting of this
														// entity

		case ShipWreckUtil.SPAWN_VILLAGER:
			return Block.getIdFromBlock(Blocks.torch); // using this, the
														// villager will be
														// spawned
														// post-generation

		case ShipWreckUtil.CUSTOM_SKULL:
			return Block.getIdFromBlock(Blocks.skull);

		case ShipWreckUtil.CUSTOM_SIGNWALL:
			return Block.getIdFromBlock(Blocks.wall_sign);

		case ShipWreckUtil.CUSTOM_SIGNPOST:
			return Block.getIdFromBlock(Blocks.standing_sign);

		case ShipWreckUtil.RANDOM_HOLE: // Used customData1 to store the real
										// block id
			return customData1;

		default:
			// note that SPAWN_VILLAGER would return 0 by default if we didn't
			// set a custom id above,
			// which is what we would want for 'air' if we didn't care about
			// post-gen spawning
			return 0;
		}
	}

	private EnumDinoType getDinosaur() {
		EnumDinoType[] var1 = EnumDinoType.values();
		int var2 = var1.length;
		Random var4 = new Random();
		EnumDinoType enumDinosaur;
		enumDinosaur = var1[var4.nextInt(var2)];
		return enumDinosaur;
	}

	/**
	 * A custom 'hook' to allow setting of tile entities, spawning entities,
	 * etc.
	 * 
	 * @param fakeID
	 *            The custom identifier used to distinguish between types
	 * @param customData1
	 *            Custom data used to subtype events for given fakeID
	 * @param customData2
	 *            Additional custom data
	 */
	@Override
	public void onCustomBlockAdded(World world, int x, int y, int z,
			int fakeID, int customData1, int customData2) {
		if (!value_set) {
			// if using this method, this should only be done once per
			// structure, preferably with a better method
			// sets one value of RANDOM_HOLE to remove from the structure,
			// allowing for patterns
			random_hole = world.rand.nextInt(5);
			value_set = true;
		}

		int meta = world.getBlockMetadata(x, y, z);
		LogHelper.log(Level.TRACE, "Setting custom block info for fake id "
				+ fakeID + " and customData1 " + customData1);
		LogHelper
				.log(Level.TRACE, "Custom block metadata from world = " + meta);

		switch (fakeID) {
		case ShipWreckUtil.CUSTOM_CHEST:
			Random rand = new Random();

			// Using the pre-made method addItemToTileInventory adds items to
			// the first slot available

			// Here we use customData to subtype custom_chest:
			if (customData1 == ShipWreckUtil.RARE_LOOT) {
				// How many times to iterate through the list for loot
				for (int iterate = 0; iterate < rand.nextInt(4); iterate++) {
					int loot = rand.nextInt(100);

					if (loot < 20) {
						addItemToTileInventory(world, new ItemStack(
								Items.leather, rand.nextInt(20) + 1), x, y, z);
					} else if (loot < 40) {
						addItemToTileInventory(world, new ItemStack(
								Items.golden_sword, rand.nextInt(2) + 1), x, y,
								z);
					} else if (loot < 50) {
						addItemToTileInventory(world, new ItemStack(
								Items.compass, 1), x, y, z);
					} else if (loot < 60) {
						addItemToTileInventory(
								world,
								(new ItemStack(
										Item.getItemFromBlock(Fossil.figurineBlock),
										rand.nextInt(2) + 1, rand.nextInt(15))),
								x, y, z);
					} else if (loot < 80) {
						addItemToTileInventory(world, new ItemStack(
								Items.gold_nugget, rand.nextInt(32) + 1), x, y,
								z);
					} else if (loot < 90) {
						addItemToTileInventory(world, new ItemStack(
								Fossil.ironjavelin, rand.nextInt(16) + 1), x,
								y, z);
					} else if (loot < 101) {
						addItemToTileInventory(world, new ItemStack(
								Items.name_tag, rand.nextInt(2) + 1), x, y, z);
					}

				}
			}
			// Not our specific chest, so we'll do some generic stuff
			if (customData1 == ShipWreckUtil.COMMON_LOOT) {
				// How many times to iterate through the list for loot
				for (int iterate = 0; iterate < rand.nextInt(7); iterate++) {
					int loot = (int) (Math.random() * 100);

					if (loot < 20) {
						addItemToTileInventory(world, new ItemStack(
								Items.leather, rand.nextInt(6) + 1), x, y, z);
					} else if (loot < 40) {
						addItemToTileInventory(world, new ItemStack(Items.book,
								rand.nextInt(2) + 1), x, y, z);
					} else if (loot < 60) {
						addItemToTileInventory(world, new ItemStack(
								Items.fishing_rod, rand.nextInt(1) + 1), x, y,
								z);
					} else if (loot < 70) {
						addItemToTileInventory(world, new ItemStack(
								Items.gunpowder, rand.nextInt(10) + 1), x, y, z);
					} else if (loot < 85) {
						addItemToTileInventory(world, new ItemStack(
								Fossil.woodjavelin, rand.nextInt(8) + 1), x, y,
								z);
					} else if (loot < 95) {
						addItemToTileInventory(world, new ItemStack(
								Items.iron_sword, rand.nextInt(1) + 1), x, y, z);
					} else {
						addItemToTileInventory(world, new ItemStack(
								Items.iron_ingot, rand.nextInt(8) + 1), x, y, z);
					}
				}
			}

			break;

		case ShipWreckUtil.CUSTOM_DISPENSER:
			// We're going to take advantage of addItemToTileInventory's return
			// value to fill
			// the container to the brim; note that this way is better than the
			// for loop from
			// above because it doesn't waste processing time - it stops as soon
			// as it is full
			boolean addmore = true;

			while (addmore) {
				// Here we use customData as the itemID to place
				addmore = addItemToTileInventory(world,
						new ItemStack(Item.getItemById(customData1), 64, 0), x,
						y, z);
			}

			break;

		case ShipWreckUtil.CUSTOM_SIGNWALL: // no 'break' so it goes into the
											// next case
		case ShipWreckUtil.CUSTOM_SIGNPOST:
			// An array that stores up to 4 Strings, the max capacity of a sign
			// Best to allocate the array to the size you need
			String[] text;

			// Set different text for each custom sign, using different colors
			if (customData1 == ShipWreckUtil.CUSTOM_SIGN_1) {
				// max number of lines is 4; any more than that will be ignored
				text = new String[5];
				text[0] = EnumChatFormatting.DARK_RED + " BEWARE";
				text[1] = EnumChatFormatting.DARK_RED + " NO ENTRY";
				// the following string is too long and will automatically be
				// truncated to the correct length
				text[2] = EnumChatFormatting.DARK_BLUE
						+ "Enter at your abcdefghijklm";
				text[3] = EnumChatFormatting.DARK_GRAY + " own risk.";
				text[4] = "Never prints!";
			} else {
				// best to allocate only what is needed, here just one line
				text = new String[1];
				text[0] = EnumChatFormatting.BLACK + "Sign Post Text";
			}

			// Use this easy method to add text to the sign's tile entity:
			setSignText(world, text, x, y, z);
			break;

		case ShipWreckUtil.CUSTOM_SKULL:
			// Easily set the skull type or player name if you know it:
			setSkullData(world, customData1, x, y, z);
			break;

		case ShipWreckUtil.ITEM_FRAME:
			ItemStack frame = new ItemStack(Items.item_frame);
			// To save you lots of trouble, there are ready-made methods to
			// handle placing
			// hanging entities and set ItemFrame items (with or without
			// rotation)
			// You need to store the returned facing from setHangingEntity to
			// use later methods
			int facing = setHangingEntity(world, frame, x, y, z);
			// Use this method for default rotation:
			setItemFrameStack(world,
					new ItemStack(Item.getItemById(customData1), 1, 0), x, y,
					z, facing);
			// or this one if you want to specify rotation:
			// setItemFrameStack(world, x, y, z, facing, new
			// ItemStack(customData,1,0),2);
			break;

		case ShipWreckUtil.PAINTING:
			ItemStack painting = new ItemStack(Items.painting);
			facing = setHangingEntity(world, painting, x, y, z);
			// choose painting you want based on custom data; look at EnumArt
			// for painting names
			String custom = (customData1 == 1 ? "Aztec" : "Bomb");
			// use following method to set painting and update client
			// automatically
			setPaintingArt(world, custom, x, y, z, facing);
			break;

		case ShipWreckUtil.RANDOM_HOLE:

			// One way to generate holes would be to set a random int once per
			// structure,
			// then remove only hole blocks with that value, allowing for custom
			// patterns
			// if (random_hole == customData2)
			// world.setBlockToAir(x, y, z);

			// another way that doesn't use customData2 would be to use
			// world.rand.nextFloat()
			// use whatever value you want to check against, I used 0.25F so 25%
			// will become holes
			// this way is nice because we don't need to set customData2 for all
			// these blocks
			if (world.rand.nextFloat() < 0.25F) {
				world.setBlockToAir(x, y, z);
			}

			break;

		case ShipWreckUtil.SPAWN_VILLAGER:
			// here I'm using customData as the villagerID
			Entity bob = new EntityVillager(world, customData1);
			// Entity X = new EntityHorse(world);
			// ((EntityHorse) X).func_110235_q(1026);
			// Now use the preset method to avoid spawning in walls
			spawnEntityInStructure(world, bob, x, y, z);
			break;

		default:
			LogHelper.log(Level.WARN, "No custom method defined for id "
					+ fakeID);
		}
	}

	/**
	 * Add all structures to the Structure List
	 */
	static {
		Structure structure = new Structure("ShipWreck");
		if (FossilOptions.Gen_Ships) {
			structure.addBlockArray(ShipWreck1.blockArrayShipWreck1);
			structure.addBlockArray(ShipWreck2.blockArrayShipWreck2);
			structure.addBlockArray(ShipWreck3.blockArrayShipWreck3);
			structure.setFacing(StructureGeneratorBase.EAST);
			// has a buffer layer on the bottom in case no ground; spawn at y-1
			// for ground level
			structure.setStructureOffset(0, -10, 0);
			structures.add(structure);
		}

		/*
		 * Structure structure = new Structure("Hut");
		 * structure.addBlockArray(StructureArrays.blockArrayNPCHut);
		 * structure.setFacing(StructureGeneratorBase.EAST); // has a buffer
		 * layer on the bottom in case no ground; spawn at y-1 for ground level
		 * structure.setStructureOffset(0, -1, 0); structures.add(structure);
		 * 
		 * structure = new Structure("Blacksmith");
		 * structure.addBlockArray(StructureArrays.blockArrayNPCBlackSmith);
		 * structure.setFacing(StructureGeneratorBase.NORTH);
		 * structures.add(structure);
		 * 
		 * structure = new Structure("Viking Shop");
		 * structure.addBlockArray(StructureArrays.blockArrayShop);
		 * structure.setFacing(StructureGeneratorBase.WEST);
		 * structures.add(structure);
		 * 
		 * structure = new Structure("Redstone Dungeon");
		 * structure.addBlockArray(StructureArrays.blockArrayRedstone);
		 * //structure.setFacing(StructureGeneratorBase.EAST);
		 * structures.add(structure);
		 * 
		 * structure = new Structure("Offset Test");
		 * structure.addBlockArray(StructureArrays.blockArraySpawnTest); /*
		 * structure.addBlockArray(StructureArrays.blockArrayOffsetTest1);
		 * structure.addBlockArray(StructureArrays.blockArrayOffsetTest2);
		 * structure.addBlockArray(StructureArrays.blockArrayOffsetTest2);
		 * structure.addBlockArray(StructureArrays.blockArrayOffsetTest2);
		 * structure.addBlockArray(StructureArrays.blockArrayOffsetTest1);
		 */
		// structure.setFacing(StructureGeneratorBase.NORTH);
		// structures.add(structure);
	}
}