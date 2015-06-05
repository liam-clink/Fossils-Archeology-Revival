package mods.fossil.core;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.fossil.Fossil;
import mods.fossil.blocks.BlockFossilPlant;
import mods.fossil.blocks.BlockFossilTallPlant;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.items.ItemFossilSeeds;
import mods.fossil.items.forge.ForgeItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class FossilPlants {

	public static Item fossilSeed_fern;
	public static Item palaeSaplingFossil;
	public static Item fossilSeed;
	public static Item seed;
	
	public static Block dillhoffia;
	public static Block sarracina;
	public static Block cephalotaxus;
	public static Block licopodiophyta;
	public static Block paleopanax;
	public static Block zamites;
	public static Block bennettitales_small;
	public static Block bennettitales_large;
	public static Block welwitschia;
	public static Block horsetail_small;
	public static Block horsetail_large;
	public static Block mutantPlant;

	public static void init(){
		assign();
		register();
	}
	public static void assign(){
				//fossil seed
				fossilSeed_fern = new ForgeItem("plants/fossilSeed_fern").setUnlocalizedName("fossilSeed_fern").setCreativeTab(Fossil.tabFMaterial);
				palaeSaplingFossil = new ForgeItem("Palae_Fossil").setUnlocalizedName("fossilSapling_palae").setCreativeTab(Fossil.tabFMaterial);
				fossilSeed = new ItemFossilSeeds(true).setUnlocalizedName("fossilSeed").setCreativeTab(Fossil.tabFMaterial);
				//seed
				seed = new ItemFossilSeeds(false).setUnlocalizedName("seed").setCreativeTab(Fossil.tabFMaterial);
				//plant
				dillhoffia = new BlockFossilPlant("plants/plant_dillhoffia", 1).setBlockName("plant_dillhoffia").setCreativeTab(Fossil.tabFBlocks);
				sarracina = new BlockFossilTallPlant("plants/plant_sarracina").setBlockName("plant_sarracina").setCreativeTab(Fossil.tabFBlocks);
				cephalotaxus = new BlockFossilPlant("plants/plant_cephalotaxus", 1).setBlockName("plant_cephalotaxus").setCreativeTab(Fossil.tabFBlocks);
				licopodiophyta = new BlockFossilPlant("plants/plant_licopodiophyta", 1).setBlockName("plant_licopodiophyta").setCreativeTab(Fossil.tabFBlocks);
				paleopanax = new BlockFossilTallPlant("plants/plant_paleopanax").setBlockName("plant_paleopanax").setCreativeTab(Fossil.tabFBlocks);
				zamites = new BlockFossilPlant("plants/plant_zamites", 1).setBlockName("plant_zamites").setCreativeTab(Fossil.tabFBlocks);
				bennettitales_small = new BlockFossilPlant("plants/plant_bennettitales_small", 1).setBlockName("plant_bennettitales_small").setCreativeTab(Fossil.tabFBlocks);
				bennettitales_large = new BlockFossilTallPlant("plants/plant_bennettitales_large").setBlockName("plant_bennettitales_large").setCreativeTab(Fossil.tabFBlocks);
				welwitschia = new BlockFossilPlant("plants/plant_welwitschia", 1).setBlockName("plant_welwitschia").setCreativeTab(Fossil.tabFBlocks);
				horsetail_small = new BlockFossilPlant("plants/plant_horsetail_small", 1).setBlockName("plant_horsetail_small").setCreativeTab(Fossil.tabFBlocks);
				horsetail_large = new BlockFossilTallPlant("plants/plant_horsetail_large").setBlockName("plant_horsetail_large").setCreativeTab(Fossil.tabFBlocks);
				mutantPlant = new BlockFossilTallPlant("plants/plant_mutant").setBlockName("plant_mutant").setLightLevel(0.4F).setCreativeTab(Fossil.tabFBlocks);
	}
	public static void register(){
		GameRegistry.registerItem(fossilSeed_fern, "fossilSeed_fern");
		GameRegistry.registerItem(palaeSaplingFossil, "palaeSaplingFossil");
		GameRegistry.registerItem(fossilSeed, "fossilSeed");
		GameRegistry.registerItem(Fossil.fernSeed, LocalizationStrings.FERNSEED_NAME);
		GameRegistry.registerItem(seed, "seed");
		GameRegistry.registerBlock(dillhoffia, "plant_dillhoffia");
		GameRegistry.registerBlock(sarracina, "plant_sarracina");
		GameRegistry.registerBlock(cephalotaxus, "plant_cephalotaxus");
		GameRegistry.registerBlock(licopodiophyta, "plant_licopodiophyta");
		GameRegistry.registerBlock(paleopanax, "paleopanax");
		GameRegistry.registerBlock(zamites, "zamites");
		GameRegistry.registerBlock(bennettitales_small, "bennettitales_small");
		GameRegistry.registerBlock(bennettitales_large, "bennettitales_large");
		GameRegistry.registerBlock(welwitschia, "welwitschia");
		GameRegistry.registerBlock(horsetail_small, "horsetail_small");
		GameRegistry.registerBlock(horsetail_large, "horsetail_large");
		GameRegistry.registerBlock(mutantPlant, "mutantPlant");

	}
}
