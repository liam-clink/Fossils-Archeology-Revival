package mods.fossil.core;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.fossil.Fossil;
import mods.fossil.blocks.BlockFossilPlant;
import mods.fossil.blocks.BlockFossilTallPlant;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.items.ItemFossilSeed;
import mods.fossil.items.forge.ForgeItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class FossilPlants {

	public static Item fossilSeed_fern;

	public static Item fossilSeed_dillhoffia;
	public static Item fossilSeed_sarracina;
	
	public static Item seed_dillhoffia;
	public static Item seed_sarracina;
	
	public static Block dillhoffia;
	public static Block sarracina;
	public static Block cephalotaxus;
	public static Block licopodiophyta;
	public static Block paleopanax;
	public static Block zamites;
	public static Block bennettitales_small;
	public static Block bennettitales_large;
	public static Block welwitschia;

	public static void init(){
		assign();
		register();
	}
	public static void assign(){
				//dna
				fossilSeed_fern = new ForgeItem("plants/fossilSeed_fern").setUnlocalizedName("fossilSeed_fern").setCreativeTab(Fossil.tabFMaterial);
				fossilSeed_dillhoffia = new ForgeItem("plants/fossilSeed_dillhoffia").setUnlocalizedName("fossilSeed_dillhoffia").setCreativeTab(Fossil.tabFMaterial);
				fossilSeed_sarracina = new ForgeItem("plants/fossilSeed_sarracina").setUnlocalizedName("fossilSeed_sarracina").setCreativeTab(Fossil.tabFMaterial);
				//seed
				seed_dillhoffia = new ItemFossilSeed("plants/seed_dillhoffia", dillhoffia).setUnlocalizedName("seed_dillhoffia").setCreativeTab(Fossil.tabFMaterial);
				seed_sarracina = new ItemFossilSeed("plants/seed_sarracina", sarracina).setUnlocalizedName("seed_sarracina").setCreativeTab(Fossil.tabFMaterial);
				//plant
				dillhoffia = new BlockFossilPlant("plants/plant_dillhoffia", 1).setBlockName("plant_dillhoffia").setCreativeTab(Fossil.tabFBlocks);
				sarracina = new BlockFossilPlant("plants/plant_sarracina", 1).setBlockName("plant_sarracina").setCreativeTab(Fossil.tabFBlocks);
				cephalotaxus = new BlockFossilPlant("plants/plant_cephalotaxus", 1).setBlockName("plant_cephalotaxus").setCreativeTab(Fossil.tabFBlocks);
				licopodiophyta = new BlockFossilPlant("plants/plant_licopodiophyta", 1).setBlockName("plant_licopodiophyta").setCreativeTab(Fossil.tabFBlocks);
				paleopanax = new BlockFossilTallPlant("plants/plant_paleopanax").setBlockName("plant_paleopanax").setCreativeTab(Fossil.tabFBlocks);
				zamites = new BlockFossilPlant("plants/plant_zamites", 1).setBlockName("plant_zamites").setCreativeTab(Fossil.tabFBlocks);
				bennettitales_small = new BlockFossilPlant("plants/plant_bennettitales_small", 1).setBlockName("plant_bennettitales_small").setCreativeTab(Fossil.tabFBlocks);
				bennettitales_large = new BlockFossilTallPlant("plants/plant_bennettitales_large").setBlockName("plant_bennettitales_large").setCreativeTab(Fossil.tabFBlocks);
				welwitschia = new BlockFossilPlant("plants/plant_welwitschia", 1).setBlockName("plant_welwitschia").setCreativeTab(Fossil.tabFBlocks);

	}
	public static void register(){
		GameRegistry.registerItem(fossilSeed_fern, "fossilSeed_fern");
		GameRegistry.registerItem(Fossil.fernSeed, LocalizationStrings.FERNSEED_NAME);

		GameRegistry.registerBlock(dillhoffia, "plant_dillhoffia");
		GameRegistry.registerBlock(sarracina, "plant_sarracina");
		GameRegistry.registerBlock(cephalotaxus, "plant_cephalotaxus");
		GameRegistry.registerBlock(licopodiophyta, "plant_licopodiophyta");
		GameRegistry.registerBlock(paleopanax, "paleopanax");
		GameRegistry.registerBlock(zamites, "zamites");
		GameRegistry.registerBlock(bennettitales_small, "bennettitales_small");
		GameRegistry.registerBlock(bennettitales_large, "bennettitales_large");
		GameRegistry.registerBlock(welwitschia, "welwitschia");

	}
}
