package fossilsarcheology.server.block;

import com.google.common.collect.Lists;
import fossilsarcheology.Revival;
import fossilsarcheology.server.block.sound.FossilSoundType;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.lang.reflect.Field;
import java.util.List;

public enum FABlockRegistry {
    INSTANCE;

    public List<String> list = Lists.newArrayList();
    public Block blockFossil;
    public Block blockSkull;
    public Block skullLantern;
    public Block analyzerIdle;
    public Block analyzerActive;
    public Block CULTIVATE_IDLE;
    public Block CULTIVATE_ACTIVE;
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
    public Block vaccinium;
    public Block osmunda;
    public Block crataegus;
    public Block florissantia;
    public Block ephedra;
    public Fluid tar_fluid;
    public Material tar_material;
    public FossilSoundType soundTypeSlime = new FossilSoundType(1.0F, 1.0F);

    public void init() {
        tar_material = new MaterialTar(MapColor.BLACK);
        tar_fluid = new FluidTar("tar").setBlock(tar);
        FluidRegistry.registerFluid(tar_fluid);
        skullLantern = new BlockFossilSkull(true).setLightLevel(1F);
        analyzerIdle = new BlockAnalyzer(false);
        analyzerActive = new BlockAnalyzer(true);
        CULTIVATE_IDLE = new BlockCultivate(false);
        CULTIVATE_ACTIVE = new BlockCultivate(true);
        blockSlimeTrail = new BlockSlimeTrail().setHardness(0.3F).setUnlocalizedName(LocalizationStrings.BLOCK_SLIME_TRAIL_NAME).setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        blockworktableIdle = new BlockWorktable(false);
        blockworktableActive = new BlockWorktable(true);
        denseSand = new BlockDenseSand();
        strongGlass = new BlockStrongGlass(Material.GLASS);
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
        palaeStairs = new BlockFossilStairs(palaePlanks, 0).setUnlocalizedName(LocalizationStrings.PALAE_STAIRS_NAME);
        volcanicAsh = new BlockVolcanicAsh();
        volcanicRock = new BlockVolcanicRock();
        volcanicBrick = new BlockVolcanicBrick();
        tar = new BlockTar();
        amberOre = new BlockAmberOre();
        ancientStone = new BlockAncientStone();
        ancientStonebrick = new BlockAncientStonebrick();
        ancientWood = new BlockAncientWood();
        ancientWoodPillar = new BlockAncientWoodPillar();
        ancientGlass = new BlockAncientGlass(Material.GLASS);
        ancientWoodPlate = new BlockAncientWoodPlate();
        ancientWoodStairs = new BlockFossilStairs(ancientWood, 0).setUnlocalizedName(LocalizationStrings.ANCIENT_WOOD_STAIRS_NAME);
        ancientWoodDoubleSlab = new BlockAncientWoodSlab(true);
        ancientWoodSingleSlab = new BlockAncientWoodSlab(false);
        ancientStoneStairs = new BlockFossilStairs(ancientStone, 0).setUnlocalizedName(LocalizationStrings.ANCIENT_STONE_STAIRS_NAME);
        ancientStoneDoubleSlab = new BlockAncientStoneSlab(true);
        ancientStoneSingleSlab = new BlockAncientStoneSlab(false);
        obsidianSpikes = new BlockSpikes().setCreativeTab(FATabRegistry.INSTANCE.BLOCKS).setHardness(50.0F).setResistance(2000.0F).setUnlocalizedName("obsidianSpikes").setBlockTextureName("fossil:obsidianSpikes");
        figurineBlock = new BlockFigurine();
        anuTotem = new BlockAnuStatue();
        anuPortal = new BlockAnuPortal();
        homePortal = new BlockHomePortal();
        anubiteStatue = new BlockAnubiteStatue();
        ancientChest = new BlockAncientChest().setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        blockSifterIdle = new BlockSifter(false);
        blockSifterActive = new BlockSifter(true);
        volcanicStairs = new BlockFossilStairs(volcanicBrick, 0).setUnlocalizedName(LocalizationStrings.VOLCANIC_STAIRS);
        volcanicDoubleSlab = new BlockVolcanicSlab(true);
        volcanicSingleSlab = new BlockVolcanicSlab(false);
        bubbleMachine = new BlockBubbleMachine();
        vaseVoluteBlock = new BlockVaseVolute();
        vaseAmphoraBlock = new BlockVaseAmphora();
        vaseKylixBlock = new BlockVaseKylix();
        sarcophagus = new BlockSarcophagus();
        dillhoffia = new BlockFossilPlant("plants/plant_dillhoffia").setUnlocalizedName("plant_dillhoffia").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        sarracina = new BlockFossilTallPlant("plants/plant_sarracina").setUnlocalizedName("plant_sarracina").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        cephalotaxus = new BlockFossilPlant("plants/plant_cephalotaxus").setUnlocalizedName("plant_cephalotaxus").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        licopodiophyta = new BlockFossilPlant("plants/plant_licopodiophyta").setUnlocalizedName("plant_licopodiophyta").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        paleopanax = new BlockFossilTallPlant("plants/plant_paleopanax").setUnlocalizedName("plant_paleopanax").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        zamites = new BlockFossilPlant("plants/plant_zamites").setUnlocalizedName("plant_zamites").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        bennettitales_small = new BlockFossilPlant("plants/plant_bennettitales_small").setUnlocalizedName("plant_bennettitales_small").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        bennettitales_large = new BlockFossilTallPlant("plants/plant_bennettitales_large").setUnlocalizedName("plant_bennettitales_large").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        welwitschia = new BlockFossilPlant("plants/plant_welwitschia").setUnlocalizedName("plant_welwitschia").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        horsetail_small = new BlockFossilPlant("plants/plant_horsetail_small").setUnlocalizedName("plant_horsetail_small").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        horsetail_large = new BlockFossilTallPlant("plants/plant_horsetail_large").setUnlocalizedName("plant_horsetail_large").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        mutantPlant = new BlockFossilTallPlant("plants/plant_mutant").setUnlocalizedName("plant_mutant").setLightLevel(0.4F).setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        vaccinium = new BlockFossilPlant("plants/plant_vaccinium").setUnlocalizedName("plant_vaccinium").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        tempskya = new BlockTempskya().setBlockTextureName("fossil:plants/plant_tempskya_1").setUnlocalizedName("plant_tempskya").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        crataegus = new BlockFossilTallPlant("plants/plant_crataegus").setUnlocalizedName("plant_crataegus").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        osmunda = new BlockFossilPlant("plants/plant_osmunda").setUnlocalizedName("plant_osmunda").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        florissantia = new BlockFossilPlant("plants/plant_florissantia").setUnlocalizedName("plant_florissantia").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        ephedra = new BlockFossilPlant("plants/plant_ephedra").setUnlocalizedName("plant_ephedra").setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        try {
            for (Field field : FABlockRegistry.class.getDeclaredFields()) {
                Object object = field.get(this);
                list.add(field.getName());
                if (object instanceof Block) {
                    registerBlock((Block) object);
                } else if (object instanceof Block[]) {
                    for (Block block : (Block[]) object) {
                        registerBlock(block);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void registerBlock(Block block) throws Exception {
        String[] split = block.getUnlocalizedName().split("\\.");
        ResourceLocation identifier = new ResourceLocation(Revival.MODID, split[split.length - 1]);
        if (block instanceof IBlockItem) {
            GameRegistry.register(((IBlockItem) block).getItemBlockClass().getConstructor(Block.class).newInstance(block), identifier);
        } else {
            GameRegistry.register(new ItemBlock(block));
        }
        GameRegistry.register(block, identifier);
    }
}
