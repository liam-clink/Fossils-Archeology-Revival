package com.github.revival.server.block;

import com.github.revival.server.api.INamedBlock;
import com.github.revival.server.api.ISubBlocksBlock;
import com.github.revival.server.block.sound.FossilSoundType;
import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import com.google.common.collect.Lists;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.lang.reflect.Field;
import java.util.List;

public enum FABlockRegistry {
    INSTANCE;

    public List<String> list = Lists.newArrayList();
    public Block blockFossil;
    public Block blockSkull;
    public Block skullLantern;
    public Block blockanalyzerIdle;
    public Block blockanalyzerActive;
    public Block blockcultivateIdle;
    public Block blockcultivateActive;
    public Block blockSlimeTrail;
    public Block blockworktableIdle;
    public Block blockworktableActive;
    public Block feederIdle;
    public Block feederActive;
    public Block denseSand;
    public Block strongGlass;
    public Block blockTimeMachine;
    public Block drum;
    public Block blockPermafrost;
    public Block blockIcedStone;
    public Block volcanicAsh;
    public Block volcanicRock;
    public Block tar;
    public Block palmLog;
    public Block palmLeaves;
    public Block palmSap;
    public Block palaePlanks;
    public Block palaeSingleSlab;
    public Block palaeDoubleSlab;
    public Block palaeStairs;
    public Block ancientWood;
    public Block ancientWoodPillar;
    public Block ancientWoodPlate;
    public Block ancientWoodStairs;
    public Block ancientWoodSingleSlab;
    public Block ancientWoodDoubleSlab;
    public Block volcanicBrick;
    public Block amberOre;
    public Block ancientStone;
    public Block ancientStonebrick;
    public Block ancientGlass;
    public Block ancientStoneStairs;
    public Block ancientStoneSingleSlab;
    public Block ancientStoneDoubleSlab;
    public Block obsidianSpikes;
    public Block figurineBlock;
    public Block anuTotem;
    public Block anuPortal;
    public Block homePortal;
    public Block anubiteStatue;
    public Block ancientChest;
    public Block blockSifterIdle;
    public Block blockSifterActive;
    public Block volcanicStairs;
    public Block volcanicSingleSlab;
    public Block volcanicDoubleSlab;
    public Block bubbleMachine;
    public Block vaseAmphoraBlock;
    public Block vaseKylixBlock;
    public Block vaseVoluteBlock;
    public Block sarcophagus;
    public Block ferns;
    public Block dillhoffia;
    public Block sarracina;
    public Block cephalotaxus;
    public Block licopodiophyta;
    public Block paleopanax;
    public Block zamites;
    public Block bennettitales_small;
    public Block bennettitales_large;
    public Block welwitschia;
    public Block horsetail_small;
    public Block horsetail_large;
    public Block mutantPlant;
    public Block tempskya;
    public Fluid tar_fluid;

    public Material tar_material;
    public FossilSoundType soundTypeSlime = new FossilSoundType(1.0F, 1.0F);

    public void init() {
        tar_material = new MaterialTar(MapColor.blackColor);
        tar_fluid = new FluidTar("tar").setBlock(tar);
        FluidRegistry.registerFluid(tar_fluid);
        skullLantern = new BlockFossilSkull(true).setLightLevel(1F);
        blockanalyzerIdle = new BlockAnalyzer(false);
        blockanalyzerActive = new BlockAnalyzer(true);
        blockcultivateIdle = new BlockCultivate(false);
        blockcultivateActive = new BlockCultivate(true);
        blockSlimeTrail = new BlockSlimeTrail().setHardness(0.3F).setBlockTextureName("fossil:Slime_Trail").setStepSound(soundTypeSlime).setBlockName(LocalizationStrings.BLOCK_SLIME_TRAIL_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        blockworktableIdle = new BlockWorktable(false);
        blockworktableActive = new BlockWorktable(true);
        denseSand = new BlockDenseSand();
        strongGlass = new BlockStrongGlass(Material.glass);
        feederIdle = new BlockFeeder(false);
        feederActive = new BlockFeeder(true);
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
        obsidianSpikes = new BlockSpikes().setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks).setHardness(50.0F).setResistance(2000.0F).setStepSound(Block.soundTypePiston).setBlockName("obsidianSpikes").setBlockTextureName("fossil:obsidianSpikes");
        figurineBlock = new BlockFigurine();
        anuTotem = new BlockAnuStatue();
        anuPortal = new BlockAnuPortal();
        homePortal = new BlockHomePortal();
        anubiteStatue = new BlockAnubiteStatue();
        ancientChest = new BlockAncientChest().setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        blockSifterIdle = new BlockSifter(false);
        blockSifterActive = new BlockSifter(true);
        volcanicStairs = new BlockFossilStairs(volcanicBrick, 0).setBlockName(LocalizationStrings.VOLCANIC_STAIRS);
        volcanicDoubleSlab = new BlockVolcanicSlab(true);
        volcanicSingleSlab = new BlockVolcanicSlab(false);
        bubbleMachine = new BlockBubbleMachine();
        vaseVoluteBlock = new BlockVaseVolute();
        vaseAmphoraBlock = new BlockVaseAmphora();
        vaseKylixBlock = new BlockVaseKylix();
        sarcophagus = new BlockSarcophagus();
        dillhoffia = new BlockFossilPlant("plants/plant_dillhoffia", 1).setBlockName("plant_dillhoffia").setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        sarracina = new BlockFossilTallPlant("plants/plant_sarracina").setBlockName("plant_sarracina").setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        cephalotaxus = new BlockFossilPlant("plants/plant_cephalotaxus", 1).setBlockName("plant_cephalotaxus").setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        licopodiophyta = new BlockFossilPlant("plants/plant_licopodiophyta", 1).setBlockName("plant_licopodiophyta").setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        paleopanax = new BlockFossilTallPlant("plants/plant_paleopanax").setBlockName("plant_paleopanax").setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        zamites = new BlockFossilPlant("plants/plant_zamites", 1).setBlockName("plant_zamites").setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        bennettitales_small = new BlockFossilPlant("plants/plant_bennettitales_small", 1).setBlockName("plant_bennettitales_small").setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        bennettitales_large = new BlockFossilTallPlant("plants/plant_bennettitales_large").setBlockName("plant_bennettitales_large").setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        welwitschia = new BlockFossilPlant("plants/plant_welwitschia", 1).setBlockName("plant_welwitschia").setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        horsetail_small = new BlockFossilPlant("plants/plant_horsetail_small", 1).setBlockName("plant_horsetail_small").setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        horsetail_large = new BlockFossilTallPlant("plants/plant_horsetail_large").setBlockName("plant_horsetail_large").setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        mutantPlant = new BlockFossilTallPlant("plants/plant_mutant").setBlockName("plant_mutant").setLightLevel(0.4F).setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        tempskya = new BlockTempskya("plants/plant_tempskya").setBlockTextureName("fossil:plants/plant_tempskya").setBlockName("plant_tempskya").setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);

        try {
            for (Field f : FABlockRegistry.class.getDeclaredFields()) {
                Object obj = f.get(this);
                list.add(f.getName());
                if (obj instanceof Block) {
                    registerBlock((Block) obj);
                } else if (obj instanceof Block[]) {
                    for (Block block : (Block[]) obj) {
                        registerBlock(block);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void registerBlock(Block block) {
        String name = block.getUnlocalizedName();
        String[] strings = name.split("\\.");
        name = strings[strings.length - 1];
        if (block instanceof INamedBlock) {
            name = ((INamedBlock) block).getBlockName();
        }

        if (block instanceof ISubBlocksBlock) {
            GameRegistry.registerBlock(block, ((ISubBlocksBlock) block).getItemBlockClass(), name);
        } else {
            GameRegistry.registerBlock(block, name);
        }
    }
}
