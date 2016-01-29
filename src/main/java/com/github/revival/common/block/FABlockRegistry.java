package com.github.revival.common.block;

import com.github.revival.Revival;
import com.github.revival.common.FARegistry;
import com.github.revival.common.api.INamedBlock;
import com.github.revival.common.api.ISubBlocksBlock;
import com.github.revival.common.creativetab.FATabRegistry;
import com.github.revival.common.handler.LocalizationStrings;
import com.google.common.collect.Lists;

import cpw.mods.fml.common.registry.GameRegistry;
import net.ilexiconn.llibrary.common.content.IContentHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.FluidRegistry;

import java.lang.reflect.Field;
import java.util.List;

public class FABlockRegistry extends FARegistry implements IContentHandler
{
	public static List<String> list = Lists.newArrayList();
	public static Block blockFossil;
	public static Block blockSkull;
	public static Block skullLantern;
	public static Block Limestone;
	public static Block LimestoneBrick;
	public static Block blockanalyzerIdle;
	public static Block blockanalyzerActive;
	public static Block blockcultivateIdle;
	public static Block blockcultivateActive;
	public static Block blockSlimeTrail;
	public static Block blockworktableIdle;
	public static Block blockworktableActive;
	public static Block denseSand;
	public static Block strongGlass;
	public static Block blockTimeMachine;
	public static Block ferns;
	public static Block drum;
	public static Block blockPermafrost;
	public static Block blockIcedStone;
	public static Block volcanicAsh;
	public static Block volcanicRock;
	public static Block tar;
	public static Block palmLog;
	public static Block palmLeaves;
	public static Block palmSap;
	public static Block palaePlanks;
	public static Block palaeSingleSlab;
	public static Block palaeDoubleSlab;
	public static Block palaeStairs;
	public static Block volcanicBrick;
	public static Block amberOre;
	public static Block ancientStone;
	public static Block ancientStonebrick;
	public static Block ancientWood;
	public static Block ancientWoodPillar;
	public static Block ancientGlass;
	public static Block ancientWoodPlate;
	public static Block ancientWoodStairs;
	public static Block ancientWoodSingleSlab;
	public static Block ancientWoodDoubleSlab;
	public static Block ancientStoneStairs;
	public static Block ancientStoneSingleSlab;
	public static Block ancientStoneDoubleSlab;
	public static Block obsidianSpikes;
	public static Block figurineBlock;
	public static Block anuTotem;
	public static Block anuPortal;
	public static Block homePortal;
	public static Block anubiteStatue;
	public static Block ancientChest;
	public static Block blockSifterIdle;
	public static Block blockSifterActive;
	public static Block volcanicStairs;
	public static Block volcanicSingleSlab;
	public static Block volcanicDoubleSlab;
	public static Block vaseAmphoraBlock;
	public static Block vaseKylixBlock;
	public static Block vaseVoluteBlock;
	public static Block sarcophagus;
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
	public static Block tempskya;

	public void init()
	{
		Revival.tar_material = new MaterialTar(MapColor.blackColor);
		Revival.tar_fluid = new FluidTar("tar").setBlock(tar);
		FluidRegistry.registerFluid(Revival.tar_fluid);

		skullLantern = new BlockFossilSkull(true).setLightLevel(1F);
		Limestone = new BlockLimestone(Material.rock);
		LimestoneBrick = new BlockLimestoneBrick(Material.rock);
		blockanalyzerIdle = new BlockAnalyzer(false);
		blockanalyzerActive = new BlockAnalyzer(true);
		blockcultivateIdle = new BlockCultivate(false);
		blockcultivateActive = new BlockCultivate(true);
		blockSlimeTrail = new BlockSlimeTrail().setHardness(0.3F).setBlockTextureName("fossil:Slime_Trail").setStepSound(Revival.soundTypeSlime).setBlockName(LocalizationStrings.BLOCK_SLIME_TRAIL_NAME).setCreativeTab(FATabRegistry.tabFBlocks);
		blockworktableIdle = new BlockWorktable(false);
		blockworktableActive = new BlockWorktable(true);
		denseSand = new BlockDenseSand();
		strongGlass = new BlockStrongGlass(Material.glass);
		//feederIdle = new BlockFeeder(false);
		//feederActive = new BlockFeeder(true);
		blockTimeMachine = new BlockTimeMachine();
		ferns = new BlockFern();
		drum = new BlockDrum();
		blockPermafrost = new BlockPermafrost();
		blockIcedStone = new BlockIcedStone();
		blockFossil = new BlockFossil();
		blockSkull = new BlockFossilSkull(false);
		palmLog = new BlockPalmLog();
		palmLeaves = new BlockPalmLeaves();
		palmSap = new BlockPalmSapling();
		palaePlanks = new BlockPalaePlanks();
		palaeDoubleSlab = new BlockPalaeSlab(true);
		palaeSingleSlab = new BlockPalaeSlab(false);
		palaeStairs = new BlockFossilStairs(palaePlanks, 0).setBlockName(LocalizationStrings.PALAE_STAIRS_NAME);
		volcanicAsh = new BlockVolcanicAsh();
		volcanicRock = new BlockVolcanicRock();
		volcanicBrick = new BlockVolcanicBrick();
		tar = new BlockTar();
		amberOre = new BlockAmberOre();
		ancientStone = new BlockAncientStone();
		ancientStonebrick = new BlockAncientStonebrick();
		ancientWood = new BlockAncientWood();
		ancientWoodPillar = new BlockAncientWoodPillar();
		ancientGlass = new BlockAncientGlass(Material.glass);
		ancientWoodPlate = new BlockAncientWoodPlate();
		ancientWoodStairs = new BlockFossilStairs(ancientWood, 0).setBlockName(LocalizationStrings.ANCIENT_WOOD_STAIRS_NAME);
		ancientWoodDoubleSlab = new BlockAncientWoodSlab(true);
		ancientWoodSingleSlab = new BlockAncientWoodSlab(false);
		ancientStoneStairs = new BlockFossilStairs(ancientStone, 0).setBlockName(LocalizationStrings.ANCIENT_STONE_STAIRS_NAME);
		ancientStoneDoubleSlab = new BlockAncientStoneSlab(true);
		ancientStoneSingleSlab = new BlockAncientStoneSlab(false);
		obsidianSpikes = new BlockSpikes().setCreativeTab(FATabRegistry.tabFBlocks).setHardness(50.0F).setResistance(2000.0F).setStepSound(Block.soundTypePiston).setBlockName("obsidianSpikes").setBlockTextureName("fossil:obsidianSpikes");
		figurineBlock = new BlockFigurine();
		anuTotem = new BlockAnuStatue();
		anuPortal = new BlockAnuPortal();
		homePortal = new BlockHomePortal();
		anubiteStatue = new BlockAnubiteStatue();
		ancientChest = new BlockAncientChest().setCreativeTab(FATabRegistry.tabFBlocks);
		blockSifterIdle = new BlockSifter(false);
		blockSifterActive = new BlockSifter(true);
		volcanicStairs = new BlockFossilStairs(volcanicBrick, 0).setBlockName(LocalizationStrings.VOLCANIC_STAIRS);
		volcanicDoubleSlab = new BlockVolcanicSlab(true);
		volcanicSingleSlab = new BlockVolcanicSlab(false);
		vaseVoluteBlock = new BlockVaseVolute();
		vaseAmphoraBlock = new BlockVaseAmphora();
		vaseKylixBlock = new BlockVaseKylix();
		sarcophagus = new BlockSarcophagus();
		dillhoffia = new BlockFossilPlant("plants/plant_dillhoffia", 1).setBlockName("plant_dillhoffia").setCreativeTab(FATabRegistry.tabFBlocks);
		sarracina = new BlockFossilTallPlant("plants/plant_sarracina").setBlockName("plant_sarracina").setCreativeTab(FATabRegistry.tabFBlocks);
		cephalotaxus = new BlockFossilPlant("plants/plant_cephalotaxus", 1).setBlockName("plant_cephalotaxus").setCreativeTab(FATabRegistry.tabFBlocks);
		licopodiophyta = new BlockFossilPlant("plants/plant_licopodiophyta", 1).setBlockName("plant_licopodiophyta").setCreativeTab(FATabRegistry.tabFBlocks);
		paleopanax = new BlockFossilTallPlant("plants/plant_paleopanax").setBlockName("plant_paleopanax").setCreativeTab(FATabRegistry.tabFBlocks);
		zamites = new BlockFossilPlant("plants/plant_zamites", 1).setBlockName("plant_zamites").setCreativeTab(FATabRegistry.tabFBlocks);
		bennettitales_small = new BlockFossilPlant("plants/plant_bennettitales_small", 1).setBlockName("plant_bennettitales_small").setCreativeTab(FATabRegistry.tabFBlocks);
		bennettitales_large = new BlockFossilTallPlant("plants/plant_bennettitales_large").setBlockName("plant_bennettitales_large").setCreativeTab(FATabRegistry.tabFBlocks);
		welwitschia = new BlockFossilPlant("plants/plant_welwitschia", 1).setBlockName("plant_welwitschia").setCreativeTab(FATabRegistry.tabFBlocks);
		horsetail_small = new BlockFossilPlant("plants/plant_horsetail_small", 1).setBlockName("plant_horsetail_small").setCreativeTab(FATabRegistry.tabFBlocks);
		horsetail_large = new BlockFossilTallPlant("plants/plant_horsetail_large").setBlockName("plant_horsetail_large").setCreativeTab(FATabRegistry.tabFBlocks);
		mutantPlant = new BlockFossilTallPlant("plants/plant_mutant").setBlockName("plant_mutant").setLightLevel(0.4F).setCreativeTab(FATabRegistry.tabFBlocks);
		tempskya = new BlockTempskya("plants/plant_tempskya").setBlockName("plant_tempskya").setCreativeTab(FATabRegistry.tabFBlocks);

		/*Blocks.fire.setFireInfo(FABlockRegistry.palmLeaves, 30, 60);
		Blocks.fire.setFireInfo(FABlockRegistry.palmLog, 5, 20);
		Blocks.fire.setFireInfo(FABlockRegistry.palaePlanks, 5, 20);
		Blocks.fire.setFireInfo(FABlockRegistry.palaeStairs, 5, 20);
		Blocks.fire.setFireInfo(FABlockRegistry.palaeSingleSlab, 5, 20);
		Blocks.fire.setFireInfo(FABlockRegistry.palaeDoubleSlab, 5, 20);
		Blocks.fire.setFireInfo(FABlockRegistry.blockworktableIdle, 5, 20);
		Blocks.fire.setFireInfo(FABlockRegistry.blockworktableActive, 5, 20);
		Blocks.fire.setFireInfo(FABlockRegistry.ancientWood, 5, 20);
		Blocks.fire.setFireInfo(FABlockRegistry.ancientWoodPillar, 5, 20);
		Blocks.fire.setFireInfo(FABlockRegistry.ancientWoodPlate, 5, 20);
		Blocks.fire.setFireInfo(FABlockRegistry.ancientWoodStairs, 5, 20);
		Blocks.fire.setFireInfo(FABlockRegistry.ancientWoodSingleSlab, 5, 20);
		Blocks.fire.setFireInfo(FABlockRegistry.ancientWoodDoubleSlab, 5, 20);
		Blocks.fire.setFireInfo(FABlockRegistry.ferns, 30, 60);
		Blocks.fire.setFireInfo(FABlockRegistry.bennettitales_large, 60, 100);
		Blocks.fire.setFireInfo(FABlockRegistry.bennettitales_small, 60, 100);
		Blocks.fire.setFireInfo(FABlockRegistry.cephalotaxus, 60, 100);
		Blocks.fire.setFireInfo(FABlockRegistry.dillhoffia, 60, 100);
		Blocks.fire.setFireInfo(FABlockRegistry.horsetail_large, 60, 100);
		Blocks.fire.setFireInfo(FABlockRegistry.horsetail_small, 60, 100);
		Blocks.fire.setFireInfo(FABlockRegistry.licopodiophyta, 60, 100);
		Blocks.fire.setFireInfo(FABlockRegistry.mutantPlant, 60, 100);
		Blocks.fire.setFireInfo(FABlockRegistry.paleopanax, 60, 100);
		Blocks.fire.setFireInfo(FABlockRegistry.sarracina, 60, 100);
		Blocks.fire.setFireInfo(FABlockRegistry.welwitschia, 60, 100);
		Blocks.fire.setFireInfo(FABlockRegistry.zamites, 60, 100);*/
	}

	public void initCreativeTabs()
	{

	}

	public void gameRegistry() throws Exception
	{
		initCreativeTabs();
		try
		{
			for (Field f : FABlockRegistry.class.getDeclaredFields())
			{
				Object obj = f.get(null);
				list.add(f.getName());
				if (obj instanceof Block)
					registerBlock((Block) obj);
				else if (obj instanceof Block[])
					for (Block block : (Block[]) obj)
						registerBlock(block);
			}
		}
		catch (IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
	}

	public void registerBlock(Block block)
	{
		String name = block.getUnlocalizedName();
		String[] strings = name.split("\\.");
		name = strings[strings.length - 1];
		if (block instanceof INamedBlock) name = ((INamedBlock) block).getBlockName();

		if (block instanceof ISubBlocksBlock)
		{
			GameRegistry.registerBlock(block, ((ISubBlocksBlock) block).getItemBlockClass(), name);
		}
		else GameRegistry.registerBlock(block, name);
	}
}
