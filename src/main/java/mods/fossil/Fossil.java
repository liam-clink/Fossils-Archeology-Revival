package mods.fossil;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import mods.fossil.blocks.BlockAmberOre;
import mods.fossil.blocks.BlockAncientGlass;
import mods.fossil.blocks.BlockAncientStone;
import mods.fossil.blocks.BlockAncientStoneSlab;
import mods.fossil.blocks.BlockAncientStonebrick;
import mods.fossil.blocks.BlockAncientWood;
import mods.fossil.blocks.BlockAncientWoodPillar;
import mods.fossil.blocks.BlockAncientWoodPlate;
import mods.fossil.blocks.BlockAncientWoodSlab;
import mods.fossil.blocks.BlockFern;
import mods.fossil.blocks.BlockFigurine;
import mods.fossil.blocks.BlockFigurineItem;
import mods.fossil.blocks.BlockFossil;
import mods.fossil.blocks.BlockFossilSkull;
import mods.fossil.blocks.BlockFossilStairs;
import mods.fossil.blocks.BlockIcedStone;
import mods.fossil.blocks.BlockMarble;
import mods.fossil.blocks.BlockPalaePlanks;
import mods.fossil.blocks.BlockPalaeSlab;
import mods.fossil.blocks.BlockPalmLeaves;
import mods.fossil.blocks.BlockPalmLog;
import mods.fossil.blocks.BlockPalmSapling;
import mods.fossil.blocks.BlockPermafrost;
import mods.fossil.blocks.BlockSarracenia;
import mods.fossil.blocks.BlockTar;
import mods.fossil.blocks.BlockVaseAmphora;
import mods.fossil.blocks.BlockVaseAmphoraItem;
import mods.fossil.blocks.BlockVaseKylix;
import mods.fossil.blocks.BlockVaseKylixItem;
import mods.fossil.blocks.BlockVaseVolute;
import mods.fossil.blocks.BlockVaseVoluteItem;
import mods.fossil.blocks.BlockVolcanicAsh;
import mods.fossil.blocks.BlockVolcanicBrick;
import mods.fossil.blocks.BlockVolcanicRock;
import mods.fossil.blocks.BlockVolcanicSlab;
import mods.fossil.client.FossilGuiHandler;
import mods.fossil.client.FossilOptions;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.client.renderer.tileentity.RenderFeeder;
import mods.fossil.enchantments.EnchantmentArcheology;
import mods.fossil.enchantments.EnchantmentPaleontology;
import mods.fossil.entity.BehaviorDodoEggDispense;
import mods.fossil.entity.BehaviorJavelinDispense;
import mods.fossil.entity.EntityAncientJavelin;
import mods.fossil.entity.EntityCultivatedDodoEgg;
import mods.fossil.entity.EntityDinoEgg;
import mods.fossil.entity.EntityDodoEgg;
import mods.fossil.entity.EntityJavelin;
import mods.fossil.entity.EntityMLighting;
import mods.fossil.entity.EntityStoneboard;
import mods.fossil.entity.EntityTerrorBirdEgg;
import mods.fossil.entity.mob.EntityBones;
import mods.fossil.entity.mob.EntityCoelacanth;
import mods.fossil.entity.mob.EntityDodo;
import mods.fossil.entity.mob.EntityElasmotherium;
import mods.fossil.entity.mob.EntityFailuresaurus;
import mods.fossil.entity.mob.EntityFriendlyPigZombie;
import mods.fossil.entity.mob.EntityMammoth;
import mods.fossil.entity.mob.EntityNautilus;
import mods.fossil.entity.mob.EntityPigBoss;
import mods.fossil.entity.mob.EntityPregnantCow;
import mods.fossil.entity.mob.EntityPregnantHorse;
import mods.fossil.entity.mob.EntityPregnantPig;
import mods.fossil.entity.mob.EntityPregnantSheep;
import mods.fossil.entity.mob.EntityQuagga;
import mods.fossil.entity.mob.EntitySmilodon;
import mods.fossil.entity.mob.EntityTerrorBird;
import mods.fossil.fossilEnums.EnumDinoFoodMob;
import mods.fossil.fossilEnums.EnumDinoType;
import mods.fossil.gens.FossilGenerator;
import mods.fossil.gens.TarGenerator;
import mods.fossil.gens.VolcanicRockGenerator;
import mods.fossil.gens.WorldGeneratorPalaeoraphe;
import mods.fossil.gens.structure.AcademyGenerator;
import mods.fossil.gens.structure.ShipWreckGenerator;
import mods.fossil.guiBlocks.BlockAnalyzer;
import mods.fossil.guiBlocks.BlockCultivate;
import mods.fossil.guiBlocks.BlockDrum;
import mods.fossil.guiBlocks.BlockFeeder;
import mods.fossil.guiBlocks.BlockSifter;
import mods.fossil.guiBlocks.BlockTimeMachine;
import mods.fossil.guiBlocks.BlockWorktable;
import mods.fossil.guiBlocks.TileEntityAnalyzer;
import mods.fossil.guiBlocks.TileEntityCultivate;
import mods.fossil.guiBlocks.TileEntityDrum;
import mods.fossil.guiBlocks.TileEntityFeeder;
import mods.fossil.guiBlocks.TileEntityFigurine;
import mods.fossil.guiBlocks.TileEntitySifter;
import mods.fossil.guiBlocks.TileEntityTimeMachine;
import mods.fossil.guiBlocks.TileEntityVase;
import mods.fossil.guiBlocks.TileEntityWorktable;
import mods.fossil.handler.FossilAchievementHandler;
import mods.fossil.handler.FossilConnectionEvent;
import mods.fossil.handler.FossilInteractEvent;
import mods.fossil.handler.FossilLivingEvent;
import mods.fossil.handler.FossilOreDictionary;
import mods.fossil.handler.FossilRecipeHandler;
import mods.fossil.handler.FossilSpawnEggs;
import mods.fossil.handler.FossilToolEvent;
import mods.fossil.handler.FossilTradeHandler;
import mods.fossil.items.ItemAmber;
import mods.fossil.items.ItemAncientEgg;
import mods.fossil.items.ItemAncientHelmet;
import mods.fossil.items.ItemAncientsword;
import mods.fossil.items.ItemBioFossil;
import mods.fossil.items.ItemChickenEss;
import mods.fossil.items.ItemCultivatedDodoEgg;
import mods.fossil.items.ItemDinosaurBones;
import mods.fossil.items.ItemDinosaurModels;
import mods.fossil.items.ItemDodoEgg;
import mods.fossil.items.ItemEmbryoSyringe;
import mods.fossil.items.ItemFeet;
import mods.fossil.items.ItemFemurs;
import mods.fossil.items.ItemFernSeed;
import mods.fossil.items.ItemFossilRecord;
import mods.fossil.items.ItemIcedMeat;
import mods.fossil.items.ItemJavelin;
import mods.fossil.items.ItemLivingCoelacanth;
import mods.fossil.items.ItemMagicConch;
import mods.fossil.items.ItemRibCage;
import mods.fossil.items.ItemSkullHelmet;
import mods.fossil.items.ItemSlabAncientStone;
import mods.fossil.items.ItemSlabAncientWood;
import mods.fossil.items.ItemSlabPalae;
import mods.fossil.items.ItemSlabVolcanic;
import mods.fossil.items.ItemStoneBoard;
import mods.fossil.items.ItemTerrorBirdEgg;
import mods.fossil.items.ItemWhip;
import mods.fossil.items.forge.ForgeAxe;
import mods.fossil.items.forge.ForgeFood;
import mods.fossil.items.forge.ForgeHoe;
import mods.fossil.items.forge.ForgeItem;
import mods.fossil.items.forge.ForgePickaxe;
import mods.fossil.items.forge.ForgeShovel;
import mods.fossil.items.forge.ForgeSword;
import mods.fossil.tabs.TabFBlocks;
import mods.fossil.tabs.TabFBones;
import mods.fossil.tabs.TabFCombat;
import mods.fossil.tabs.TabFFigurines;
import mods.fossil.tabs.TabFFood;
import mods.fossil.tabs.TabFItems;
import mods.fossil.tabs.TabFMaterial;
import mods.fossil.tabs.TabFTools;
import mods.fossil.util.FossilBonemealEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemSlab;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;

//import mods.fossil.gens.TarGenerator;
//import mods.fossil.gens.WorldGenAcademy;
//import mods.fossil.gens.WorldGenShips;
//import mods.fossil.gens.WorldGenWeaponShop;
//import mods.fossil.gens.WorldGeneratorVolcanicRock;

@Mod(modid = Fossil.modid, name = "Fossil/Archeology", version = Fossil.modversion)
//@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Fossil
{
    public static final String modid = "fossil";
    public static final String modversion = "1.7.10 Build 7.0rc1";

    /*
     * Set mod state here
     * 0 = Dev build
     * 1 = Beta build
     * 2 = Release build
     */
    public static final int modState = 1;

    @SidedProxy(clientSide = "mods.fossil.client.ClientProxy", serverSide = "mods.fossil.CommonProxy")
    public static CommonProxy proxy;

    @Instance("fossil")
    public static Fossil instance;

    public static final Logger Log = Logger.getLogger("FOSSILS");
    public static FossilGuiHandler GH = new FossilGuiHandler();
    public static FossilOptions FossilOptions;
    public static Properties LangProps = new Properties();
    public static Object ToPedia;

    //public static IChatListener messagerHandler = new FossilMessageHandler();

    public Configuration config;

    /*
     * If DebugMode = true
     * Dinosaur/Syringe times are accelerated but not disabled to allow for error checking.
     */
    //public static boolean DebugMode = FossilOptions.FossilDebug;
    public static boolean DebugMode() {
        return false;
    }
    
    public static final double MESSAGE_DISTANCE = 25.0D;

    public static CreativeTabs tabFBlocks = new TabFBlocks("Fossil Blocks");
    public static CreativeTabs tabFItems = new TabFItems("Fossil Items");
    public static CreativeTabs tabFFood = new TabFFood("Fossil Food");
    public static CreativeTabs tabFCombat = new TabFCombat("Fossil Combat");
    public static CreativeTabs tabFTools = new TabFTools("Fossil Deco");
    public static CreativeTabs tabFMaterial = new TabFMaterial("Fossil Material");
    public static CreativeTabs tabFFigurines = new TabFFigurines("Fossil Test");
    public static CreativeTabs tabFBones = new TabFBones("Fossil Bones");
    
    //Render IDs
	public static int feederRenderID;

    //enchantments
    public static Enchantment paleontology;
    public static Enchantment archeology;
    public static int e_archeologyID;
    public static int e_paleontologyID;
    
    //Blocks
    public static Block blockFossil;
    public static Block blockSkull;
    public static Block skullLantern;
    public static Block blockanalyzerIdle;
    public static Block blockanalyzerActive;
    public static Block blockcultivateIdle;
    public static Block blockcultivateActive;
    public static Block blockworktableIdle;
    public static Block blockworktableActive;
    public static Block blockTimeMachine;
    public static Block ferns;
    //public static Block fernUpper;
    public static Block drum;
    public static Block feederIdle;
    public static Block feederActive;
    public static Block blockPermafrost;
    public static Block blockIcedStone;
    public static Block volcanicAsh;
    public static Block volcanicRock;
    public static Block volcanicRockHot;
    public static Block tar;
    public static Block palmLog;
    public static Block palmLeaves;
    public static Block palmSap;
    public static Block palaePlanks;
    public static BlockSlab palaeSingleSlab;
    public static BlockSlab palaeDoubleSlab;
    public static Block palaeStairs;
    public static Block sarracina;
    public static Block volcanicBrick;
    public static Block amberOre;
    public static Block ancientStone;
    public static Block ancientStonebrick;
    public static Block ancientWood;
    public static Block ancientWoodPillar;
    public static Block ancientGlass;
    public static Block ancientWoodPlate;
    public static Block ancientWoodStairs;
    public static BlockSlab ancientWoodSingleSlab;
    public static BlockSlab ancientWoodDoubleSlab;
    public static Block ancientStoneStairs;
    public static BlockSlab ancientStoneSingleSlab;
    public static BlockSlab ancientStoneDoubleSlab;
    public static Block marble;
    public static Block figurineBlock;
    public static Block blockSifterIdle;
    public static Block blockSifterActive;
    public static Block volcanicStairs;
    public static BlockSlab volcanicSingleSlab;
    public static BlockSlab volcanicDoubleSlab;
    public static Block vaseAmphoraBlock;
    public static Block vaseKylixBlock;
    public static Block vaseVoluteBlock;

    //Items
    public static Item biofossil;
    public static Item relic;
    public static Item stoneboard;
    public static Item ancientSword;
    public static Item brokenSword;
    public static Item fernSeed;
    public static Item ancienthelmet;
    public static Item brokenhelmet;
    public static Item skullStick;
    public static Item gem;
    public static Item gemAxe;
    public static Item gemPickaxe;
    public static Item gemSword;
    public static Item gemHoe;
    public static Item gemShovel;
    public static Item dinoPedia;
    public static Item archNotebook;
    public static Item emptyShell;
    public static Item magicConch;
    public static Item icedMeat;
    public static Item woodjavelin;
    public static Item stonejavelin;
    public static Item ironjavelin;
    public static Item goldjavelin;
    public static Item diamondjavelin;
    public static Item ancientJavelin;
    public static Item whip;
    public static Item legBone;
    public static Item claw;
    public static Item foot;
    public static Item skull;
    public static Item brokenSapling;
    public static Item amber;
    public static Item ancientVase;
    public static Item ancientVaseBroken;
    public static Item boneArrow;
    public static Item boneBow;
    public static Item boneGlue;
    public static Item boneRod;
    public static Item boneSword;
    public static Item powderyString;
    public static Item animalCoin;
    public static Item dinoCoin;
    public static Item dodoEgg;
    public static Item cultivatedDodoEgg;
    public static Item dodoWing;
    public static Item dodoWingCooked;
    public static Item figurineItem;
    public static Item brokenHeadRelic;
    public static Item potteryShards;
    public static Item livingCoelacanth;
    public static Item terrorBirdEgg;
    public static Item cultivatedTerrorBirdEgg;
    public static Item terrorBirdMeat;
    public static Item terrorBirdMeatCooked;
    public static Item quaggaMeat;
    public static Item quaggaMeatCooked;

    //Bones
    public static Item dinosaurModels;
    public static Item armBone;
    public static Item dinoRibCage;
    public static Item vertebrae;
    
    //Armor
    public static Item skullHelmet;
    public static Item ribCage;
    public static Item femurs;
    public static Item feet;
    //public static Item newArmor;
    //public static Item newArmor;
    //public static Item newArmor;
    //public static Item newArmor;
    //public static Item newArmor;
    //public static Item newArmor;
    //public static Item newArmor;
    //public static Item newArmor;

    //DNA - See DinoEnum
    //public static Item[] DNAItems= new Item[EnumDinoType.values().length];

    //public static Item newDinoDNA;
    //public static Item newDinoDNA;
    //public static Item newDinoDNA;
    //public static Item newDinoDNA;
    //public static Item newDinoDNA;

    //Animal Dna
    //public static Item animalDNA;
    public static Item dnaPig;
    public static Item dnaSheep;
    public static Item dnaCow;
    public static Item dnaChicken;
    public static Item dnaSmilodon;
    public static Item dnaMammoth;
    public static Item dnaDodo;
    public static Item dnaCoelacanth;
    public static Item dnaHorse;
    public static Item dnaQuagga;
    public static Item dnaTerrorBird;
    public static Item dnaElasmotherium;

    //Mob DNA
    //public static Item mobDNA;
    //public static Item dnaPigZombie;
    //public static Item dnaZombie;
    //public static Item dnaGhast;
    //public static Item dnaWither;
    //public static Item dnaSpider;
    //public static Item dnaSkeleton;

    //Ancient Egg - See DinoEnum
    //public static Item[] EGGItems= new Item[EnumDinoType.values().length];

    //Embryos
    //public static Item embyoSyringe;
    public static Item embryoPig;
    public static Item embryoSheep;
    public static Item embryoCow;
    public static Item embryoChicken;
    public static Item embryoSmilodon;
    public static Item embryoMammoth;
    public static Item embryoHorse;
    public static Item embryoQuagga;
    public static Item embryoElasmotherium;

    //Item Food
    public static Item cookedChickenSoup;
    public static Item rawChickenSoup;
    public static Item chickenEss;
    public static Item sjl;
    //public static Item[] RAWItems= new Item[EnumDinoType.values().length];
    public static Item cookedDinoMeat;

    //Music Discs
    public static Item fossilrecordBones;

    static ArmorMaterial bone = EnumHelper.addArmorMaterial("Bone", 25, new int[] {2, 7, 6, 2}, 15);
    static ToolMaterial scarab = EnumHelper.addToolMaterial("Scarab", 3, 1861, 8.0F, 4.0F, 25);
    static ArmorMaterial scarabArmor = EnumHelper.addArmorMaterial("Scarab", 50, new int[]{3, 8, 6, 3}, 10);
    static ArmorMaterial RELIC = EnumHelper.addArmorMaterial("Relic", 5, new int[]{1, 3, 2, 1}, 15);	
    
    @Mod.EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
//       Localizations.loadLanguages();
    	//MinecraftForge.EVENT_BUS.register(new DinoSoundHandler());
        MinecraftForge.EVENT_BUS.register(new FossilBonemealEvent());
        FossilAchievementHandler.loadAchievements();
        VillagerRegistry.instance().registerVillageTradeHandler(10, new FossilTradeHandler());
    	VillagerRegistry.instance().registerVillagerId(10);
        config = new Configuration(event.getSuggestedConfigurationFile());

        
        try
        {
            config.load();
            //Enchantments
            e_paleontologyID = config.get(Configuration.CATEGORY_GENERAL, LocalizationStrings.ENCHANTMENT_PALEONTOLOGY, 90).getInt();
            e_archeologyID = config.get(Configuration.CATEGORY_GENERAL, LocalizationStrings.ENCHANTMENT_ARCHEOLOGY, 91).getInt();
            
            
            //Config options
            FossilOptions.Gen_Palaeoraphe = config.get("option", "Palaeoraphe", false).getBoolean(false);
            FossilOptions.Gen_Academy = config.get("option", "Academy", true).getBoolean(true);
            FossilOptions.Gen_Ships = config.get("option", "Ships", true).getBoolean(true);
            FossilOptions.Gen_Temple = config.get("option", "Temple", true).getBoolean(true);
            FossilOptions.Heal_Dinos = config.get("option", "Heal_Dinos", true).getBoolean(true);
            FossilOptions.Dinos_Starve = config.get("option", "Dinos_Starve", true).getBoolean(true);
            FossilOptions.Dino_Block_Breaking = config.get("option", "Dino_Block_Breaking", true).getBoolean(true);
            FossilOptions.Skull_Overlay = config.get("option", "Skull_Overlay", false).getBoolean(false);
            FossilOptions.LoginMessage = config.get("option", "Display_Login_Message", true).getBoolean(false);
            FossilOptions.Anu_Spawn = config.get("option", "Anu_Spawn", false).getBoolean(false);
            FossilOptions.Anu_Allowed_Overworld = config.get("option", "Anu_Allowed_Overworld", false).getBoolean(false);
            FossilOptions.AllowBreeding = config.get("option", "Allow_Dinosaur_Breeding", true).getBoolean(true);

            //Dinosaur Feathers
            FossilOptions.TRexFeathers = config.get("toggle_feathers", "TRex Feathers", false).getBoolean(false);
            FossilOptions.DeinonychusFeathers = config.get("toggle_feathers", "Deinonychus Feathers", true).getBoolean(true);
            FossilOptions.GallimimusFeathers = config.get("toggle_feathers",  "Gallimimus Feathers", false).getBoolean(false);
            FossilOptions.CompsognathusFeathers = config.get("toggle_feathers",  "Compsognathus Feathers", false).getBoolean(false);
            FossilOptions.VelociraptorFeathers = config.get("toggle_feathers",  "Velociraptor Feathers", false).getBoolean(false);

            
            //Enchantment Toggle
            FossilOptions.AllowTableEnchantments = config.get("option", "Allow Table Enchantments", true).getBoolean(true);
            FossilOptions.AllowBookEnchantments = config.get("option", "Allow Book Enchantments", true).getBoolean(true);


        }
        catch (Exception var7)
        {
        	System.out.println("Fossil Mod not loading configuration");
//            FMLLog.(Level.SEVERE, var7, "Fossil Mod Not loading configuration", new Object[0]);
        }
        finally
        {
            config.save();
        }
        

        if (event.getSide() == Side.CLIENT)
        {
          //  proxy.registerSounds();
        }


        
        if (event.getSide() == Side.CLIENT)
        {
            proxy.registerEvents();
        }
       
    }
    
    //@SuppressWarnings("static-access")
    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {	
       // LanguageRegistry.instance().addStringLocalization("itemGroup." + this.modid, "en_US", this.modid);
        
        //Enchantments
        paleontology = new EnchantmentPaleontology(e_paleontologyID, 2, EnumEnchantmentType.digger);
        archeology = new EnchantmentArcheology(e_archeologyID, 2, EnumEnchantmentType.digger);
        
        //Blocks
        skullLantern = new BlockFossilSkull(true).setHardness(1.0F).setLightLevel(0.9375F).setStepSound(Block.soundTypeStone).setBlockName(LocalizationStrings.SKULL_LANTERN_NAME).setCreativeTab(this.tabFBlocks);
        blockanalyzerIdle = new BlockAnalyzer(false).setHardness(3.0F).setStepSound(Block.soundTypeMetal).setBlockName(LocalizationStrings.BLOCK_ANALYZER_IDLE_NAME).setCreativeTab(this.tabFBlocks);
        blockanalyzerActive = new BlockAnalyzer(true).setLightLevel(0.9375F).setHardness(3.0F).setStepSound(Block.soundTypeMetal).setBlockName(LocalizationStrings.BLOCK_ANALYZER_ACTIVE_NAME);
        blockcultivateIdle = new BlockCultivate(false).setLightLevel(0.9375F).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setBlockName(LocalizationStrings.BLOCK_CULTIVATE_IDLE_NAME).setCreativeTab(this.tabFBlocks);
        blockcultivateActive = new BlockCultivate(true).setLightLevel(0.9375F).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setBlockName(LocalizationStrings.BLOCK_CULTIVATE_ACTIVE_NAME);
        blockworktableIdle = new BlockWorktable(false).setHardness(2.5F).setStepSound(Block.soundTypeWood).setBlockName(LocalizationStrings.BLOCK_WORKTABLE_IDLE_NAME).setCreativeTab(this.tabFBlocks);
        blockworktableActive = new BlockWorktable(true).setHardness(2.5F).setStepSound(Block.soundTypeWood).setBlockName(LocalizationStrings.BLOCK_WORKTABLE_ACTIVE_NAME);
        feederIdle = new BlockFeeder().setHardness(3.5F).setStepSound(Block.soundTypeStone).setBlockName(LocalizationStrings.FEEDER_IDLE_NAME);
        feederActive = new BlockFeeder().setHardness(3.5F).setStepSound(Block.soundTypeStone).setBlockName(LocalizationStrings.FEEDER_ACTIVE_NAME).setCreativeTab(this.tabFBlocks);
        blockTimeMachine = new BlockTimeMachine();
        ferns = new BlockFern();
        drum = new BlockDrum();
        blockPermafrost = new BlockPermafrost().setHardness(0.5F).setLightOpacity(3).setStepSound(Block.soundTypeGrass).setBlockName(LocalizationStrings.BLOCK_PERMAFROST_NAME).setCreativeTab(this.tabFBlocks);
        blockIcedStone = new BlockIcedStone().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName(LocalizationStrings.BLOCK_ICEDSTONE_NAME).setCreativeTab(this.tabFBlocks);
        blockFossil = new BlockFossil();
        blockSkull = new BlockFossilSkull(false).setHardness(1.0F).setStepSound(Block.soundTypeStone).setBlockName(LocalizationStrings.BLOCK_SKULL_NAME).setCreativeTab(this.tabFBlocks);
        palmLog = new BlockPalmLog().setStepSound(Block.soundTypeWood).setHardness(1.4F)/*.setResistance(1.0F)*/.setBlockName(LocalizationStrings.PALAE_LOG_NAME);
        palmLeaves = new BlockPalmLeaves().setStepSound(Block.soundTypeGrass).setHardness(0.2F).setResistance(1F).setBlockName(LocalizationStrings.PALAE_LEAVES_NAME);
        palmSap = new BlockPalmSapling();
        palaePlanks = new BlockPalaePlanks(Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName(LocalizationStrings.PALAE_PLANKS_NAME);
        palaeDoubleSlab = (BlockSlab) new BlockPalaeSlab(true).setBlockName(LocalizationStrings.PALAE_DOUBLESLAB_NAME);
        palaeSingleSlab = (BlockSlab) new BlockPalaeSlab(false).setBlockName(LocalizationStrings.PALAE_SINGLESLAB_NAME).setCreativeTab(this.tabFBlocks);
        palaeStairs = new BlockFossilStairs(palaePlanks, 0).setBlockName(LocalizationStrings.PALAE_STAIRS_NAME);
        volcanicAsh = new BlockVolcanicAsh().setHardness(0.2F).setStepSound(Block.soundTypeGrass).setBlockName(LocalizationStrings.VOLCANIC_ASH_NAME).setCreativeTab(this.tabFBlocks);
        volcanicRock = new BlockVolcanicRock().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockName(LocalizationStrings.VOLCANIC_ROCK_NAME).setCreativeTab(this.tabFBlocks);
        volcanicBrick = new BlockVolcanicBrick().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockName(LocalizationStrings.VOLCANIC_BRICK_NAME).setCreativeTab(this.tabFBlocks);
        sarracina = new BlockSarracenia().setHardness(0.5F).setStepSound(Block.soundTypeGrass).setBlockName(LocalizationStrings.SARRACINA_NAME).setCreativeTab(this.tabFBlocks);
        tar = new BlockTar(Material.water).setHardness(100.0F).setBlockName(LocalizationStrings.TAR_NAME);
        amberOre  = new BlockAmberOre(Material.rock).setHardness(3.0F).setBlockName(LocalizationStrings.AMBER_ORE_NAME);
        ancientStone  = new BlockAncientStone().setHardness(1.5F).setBlockName(LocalizationStrings.ANCIENT_STONE_NAME);
        ancientStonebrick  = new BlockAncientStonebrick().setHardness(1.5F).setBlockName(LocalizationStrings.ANCIENT_STONE_BRICK_NAME);
        ancientWood  = new BlockAncientWood(Material.wood).setHardness(2.0F).setBlockName(LocalizationStrings.ANCIENT_WOOD_NAME);
        ancientWoodPillar = new BlockAncientWoodPillar(Material.wood).setHardness(2.0F).setBlockName(LocalizationStrings.ANCIENT_WOOD_PILLAR_NAME);
        ancientGlass = new BlockAncientGlass(Material.glass, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setBlockName(LocalizationStrings.ANCIENT_GLASS_NAME);
        ancientWoodPlate = new BlockAncientWoodPlate(Material.wood).setHardness(0.6F).setBlockName(LocalizationStrings.ANCIENT_WOOD_PLATE_NAME);
        ancientWoodStairs = new BlockFossilStairs(ancientWood, 0).setBlockName(LocalizationStrings.ANCIENT_WOOD_STAIRS_NAME);
        ancientWoodDoubleSlab = (BlockSlab) new BlockAncientWoodSlab(true).setHardness(1.4F).setResistance(7.5F).setStepSound(Block.soundTypeWood).setBlockName(LocalizationStrings.ANCIENT_WOOD_DOUBLESLAB_NAME);
        ancientWoodSingleSlab = (BlockSlab)new BlockAncientWoodSlab(false).setHardness(1.4F).setResistance(7.5F).setStepSound(Block.soundTypeWood).setBlockName(LocalizationStrings.ANCIENT_WOOD_SINGLESLAB_NAME).setCreativeTab(this.tabFBlocks);
        ancientStoneStairs = new BlockFossilStairs(ancientStone, 0).setBlockName(LocalizationStrings.ANCIENT_STONE_STAIRS_NAME);
        ancientStoneDoubleSlab = (BlockSlab)new BlockAncientStoneSlab(true).setHardness(1.4F).setResistance(7.5F).setStepSound(Block.soundTypeWood).setBlockName(LocalizationStrings.ANCIENT_STONE_DOUBLESLAB_NAME);
        ancientStoneSingleSlab = (BlockSlab)new BlockAncientStoneSlab(false).setHardness(1.4F).setResistance(7.5F).setStepSound(Block.soundTypeWood).setBlockName(LocalizationStrings.ANCIENT_STONE_SINGLESLAB_NAME).setCreativeTab(this.tabFBlocks);
        marble  = new BlockMarble().setHardness(2.0F).setHardness(1.5F).setBlockName(LocalizationStrings.MARBLE_NAME);
        figurineBlock = new BlockFigurine().setBlockName(LocalizationStrings.FIGURINE_NAME);
        blockSifterIdle = new BlockSifter(false).setHardness(3.0F).setStepSound(Block.soundTypeMetal).setBlockName(LocalizationStrings.BLOCK_SIFTER_IDLE).setCreativeTab(this.tabFBlocks);
        blockSifterActive = new BlockSifter(true).setHardness(3.0F).setStepSound(Block.soundTypeMetal).setBlockName(LocalizationStrings.BLOCK_SIFTER_ACTIVE);
        volcanicStairs = new BlockFossilStairs(volcanicBrick, 0).setBlockName(LocalizationStrings.VOLCANIC_STAIRS);
        volcanicDoubleSlab = (BlockSlab)new BlockVolcanicSlab(true).setHardness(1.4F).setResistance(7.5F).setStepSound(Block.soundTypeStone).setBlockName(LocalizationStrings.VOLCANIC_DOUBLESLAB_NAME);
        volcanicSingleSlab = (BlockSlab)new BlockVolcanicSlab(false).setHardness(1.4F).setResistance(7.5F).setStepSound(Block.soundTypeStone).setBlockName(LocalizationStrings.VOLCANIC_SINGLESLAB_NAME).setCreativeTab(this.tabFBlocks);
        vaseVoluteBlock = new BlockVaseVolute().setBlockName(LocalizationStrings.VASE_VOLUTE);
        vaseAmphoraBlock = new BlockVaseAmphora().setBlockName(LocalizationStrings.VASE_AMPHORA);
        vaseKylixBlock = new BlockVaseKylix().setBlockName(LocalizationStrings.VASE_KYLIX);       

     //   Blocks.fire.setFireInfo(Fossil.ferns, 30, 60);
     //   Blocks.fire.setFireInfo(Fossil.palmLeaves, 30, 60);
      //  Blocks.fire.setFireInfo(Fossil.palaePlanks, 5, 20);
     //   Blocks.fire.setFireInfo(Fossil.tar, 500, 1);
      //  Blocks.fire.setFireInfo(Fossil.ancientWood, 10, 20);
     //   Blocks.fire.setFireInfo(Fossil.ancientWoodPlate, 5, 10);
     //   Blocks.fire.setFireInfo(Fossil.ancientWoodStairs, 10, 20);
        //Items
        biofossil = new ItemBioFossil().setUnlocalizedName(LocalizationStrings.BIO_FOSSIL_NAME).setCreativeTab(this.tabFItems);
        relic = new ForgeItem("Relic_Scrap").setUnlocalizedName(LocalizationStrings.RELIC_NAME).setCreativeTab(this.tabFItems);
        stoneboard = new ItemStoneBoard().setUnlocalizedName(LocalizationStrings.TABLET_NAME).setCreativeTab(this.tabFItems);
        ancientSword = new ItemAncientsword().setUnlocalizedName(LocalizationStrings.ANCIENT_SWORD_NAME).setCreativeTab(this.tabFCombat);
        brokenSword = new ForgeItem("Broken_Ancient_Sword").setMaxStackSize(1).setUnlocalizedName(LocalizationStrings.BROKEN_SWORD_NAME).setCreativeTab(this.tabFMaterial);
        fernSeed = new ItemFernSeed(Fossil.ferns);
        ancienthelmet = new ItemAncientHelmet(ArmorMaterial.IRON, 3, 0).setUnlocalizedName(LocalizationStrings.ANCIENT_HELMET_NAME).setCreativeTab(this.tabFCombat);
        brokenhelmet = new ForgeItem("Broken_Ancient_Helm").setMaxStackSize(1).setUnlocalizedName(LocalizationStrings.BROKEN_HELMET_NAME).setCreativeTab(this.tabFMaterial);
        skullStick = new ForgeItem("Skull_Stick").setUnlocalizedName(LocalizationStrings.SKULL_STICK_NAME).setCreativeTab(this.tabFItems);
        gem = new ForgeItem("Scarab_Gem").setUnlocalizedName(LocalizationStrings.SCARAB_GEM_NAME).setCreativeTab(this.tabFItems);
        gemAxe = new ForgeAxe(scarab, "Gem_Axe").setUnlocalizedName(LocalizationStrings.SCARAB_AXE_NAME).setCreativeTab(this.tabFTools);
        gemPickaxe = new ForgePickaxe(scarab, "Gem_Pickaxe").setUnlocalizedName(LocalizationStrings.SCARAB_PICKAXE_NAME).setCreativeTab(this.tabFTools);
        gemSword = new ForgeSword(scarab, "Gem_Sword").setUnlocalizedName(LocalizationStrings.SCARAB_SWORD_NAME).setCreativeTab(this.tabFCombat);;
        gemHoe = new ForgeHoe(scarab, "Gem_Hoe").setUnlocalizedName(LocalizationStrings.SCARAB_HOE_NAME).setCreativeTab(this.tabFTools);
        gemShovel = new ForgeShovel(scarab, "Gem_Shovel").setUnlocalizedName(LocalizationStrings.SCARAB_SHOVEL_NAME).setCreativeTab(this.tabFTools);
        dinoPedia = new ForgeItem("Dinopedia").setUnlocalizedName(LocalizationStrings.DINOPEDIA_NAME).setCreativeTab(this.tabFItems);
        emptyShell = new ForgeItem("Empty_Shell").setUnlocalizedName(LocalizationStrings.EMPTY_SHELL_NAME).setCreativeTab(this.tabFItems);
        magicConch = new ItemMagicConch().setUnlocalizedName(LocalizationStrings.MAGIC_CONCH_NAME).setCreativeTab(this.tabFTools);
        icedMeat = new ItemIcedMeat(ToolMaterial.EMERALD).setUnlocalizedName(LocalizationStrings.ICED_MEAT_NAME).setCreativeTab(this.tabFItems);
        amber = new ItemAmber().setUnlocalizedName(LocalizationStrings.AMBER_NAME).setCreativeTab(this.tabFItems);
        woodjavelin = new ItemJavelin(ToolMaterial.WOOD, "Wooden_Javelin").setUnlocalizedName(LocalizationStrings.WOOD_JAVELIN_NAME).setCreativeTab(this.tabFCombat);
        stonejavelin = new ItemJavelin(ToolMaterial.STONE, "Stone_Javelin").setUnlocalizedName(LocalizationStrings.STONE_JAVELIN_NAME).setCreativeTab(this.tabFCombat);
        ironjavelin = new ItemJavelin(ToolMaterial.IRON, "Iron_Javelin").setUnlocalizedName(LocalizationStrings.IRON_JAVELIN_NAME).setCreativeTab(this.tabFCombat);
        goldjavelin = new ItemJavelin(ToolMaterial.GOLD, "Gold_Javelin").setUnlocalizedName(LocalizationStrings.GOLD_JAVELIN_NAME).setCreativeTab(this.tabFCombat);
        diamondjavelin = new ItemJavelin(ToolMaterial.EMERALD, "Diamond_Javelin").setUnlocalizedName(LocalizationStrings.DIAMOND_JAVELIN_NAME).setCreativeTab(this.tabFCombat);
        ancientJavelin = new ItemJavelin(scarab, "Ancient_Javelin").setUnlocalizedName(LocalizationStrings.ANCIENT_JAVELIN_NAME).setCreativeTab(this.tabFCombat);
        whip = new ItemWhip().setUnlocalizedName(LocalizationStrings.WHIP_NAME).setCreativeTab(this.tabFTools);

        legBone = new ItemDinosaurBones("legBone").setUnlocalizedName(LocalizationStrings.LEGBONE_NAME);
        claw = new ItemDinosaurBones("uniqueItem").setUnlocalizedName(LocalizationStrings.CLAW_NAME);
        foot = new ItemDinosaurBones("foot").setUnlocalizedName(LocalizationStrings.FOOT_NAME);
        skull = new ItemDinosaurBones("skull").setUnlocalizedName(LocalizationStrings.SKULL_NAME);
        armBone = new ItemDinosaurBones("armBone").setUnlocalizedName(LocalizationStrings.ARM_BONE_NAME);
        dinoRibCage = new ItemDinosaurBones("dinoRibCage").setUnlocalizedName(LocalizationStrings.DINO_RIB_CAGE_NAME);
        vertebrae = new ItemDinosaurBones("vertebrae").setUnlocalizedName(LocalizationStrings.VERTEBRAE_NAME);
        //dinosaurModels = new ItemDinosaurModels().setUnlocalizedName(LocalizationStrings.DINOSAUR_MODELS).setCreativeTab(this.tabFBones);
        
        brokenSapling = new ForgeItem("Palae_Fossil").setUnlocalizedName(LocalizationStrings.BROKEN_SAPLING_NAME).setCreativeTab(this.tabFMaterial);
        dodoEgg = new ItemDodoEgg().setUnlocalizedName(LocalizationStrings.DODO_EGG_NAME);
        cultivatedDodoEgg = new ItemCultivatedDodoEgg().setUnlocalizedName(LocalizationStrings.CULTIVATED_DODO_EGG_NAME);
       // archNotebook = new ForgeItem("Arch_Notebook").setUnlocalizedName(LocalizationStrings.ARCH_NOTEBOOK_NAME).setCreativeTab(this.tabFItems);
        potteryShards = new ForgeItem("PotteryShard").setUnlocalizedName(LocalizationStrings.POTTERY_SHARDS).setCreativeTab(this.tabFItems);
       // brokenHeadRelic = new ItemHeadRelic(RELIC, 3, 0).setUnlocalizedName(LocalizationStrings.BROKEN_HEAD_RELIC).setCreativeTab(Fossil.tabFTest);
        livingCoelacanth = new ItemLivingCoelacanth(1).setUnlocalizedName(LocalizationStrings.LIVING_COELACANTH_NAME).setCreativeTab(this.tabFMaterial);
        terrorBirdEgg = new ItemTerrorBirdEgg(false).setUnlocalizedName(LocalizationStrings.TERROR_BIRD_EGG_NAME);
        cultivatedTerrorBirdEgg = new ItemTerrorBirdEgg(true).setUnlocalizedName(LocalizationStrings.CULTIVATED_TERROR_BIRD_EGG_NAME);
       
        //BoneArmor
        skullHelmet = new ItemSkullHelmet(bone, 3, 0).setUnlocalizedName(LocalizationStrings.SKULL_HELMET_NAME).setCreativeTab(Fossil.tabFCombat);
        ribCage = new ItemRibCage(bone, 3, 1).setUnlocalizedName(LocalizationStrings.RIBCAGE_NAME).setCreativeTab(Fossil.tabFCombat);
        femurs = new ItemFemurs(bone, 3, 2).setUnlocalizedName(LocalizationStrings.FEMURS_NAME).setCreativeTab(Fossil.tabFCombat);
        feet = new ItemFeet(bone, 3, 3).setUnlocalizedName(LocalizationStrings.FEET_NAME).setCreativeTab(this.tabFCombat);

        //Ancient Egg
        //Moved to fossilEnums.EnumDinoType

        for (int i = 0; i < EnumDinoType.values().length; i++)
        {
            EnumDinoType.values()[i].EggItem = new ItemAncientEgg(i).setUnlocalizedName("egg" + EnumDinoType.values()[i].name()).setCreativeTab(this.tabFMaterial);
        }

        //DNA
        //Moved to fossilEnums.EnumDinoType
        for (int i = 0; i < EnumDinoType.values().length; i++)
        {
            EnumDinoType.values()[i].DNAItem = new ForgeItem(EnumDinoType.values()[i].name() + "_DNA").setUnlocalizedName("dna" + EnumDinoType.values()[i].name()).setCreativeTab(this.tabFMaterial);
        }

        //animalDNA
        //animalDNA = new ItemNonDinoDNA(animalDNAID);
        dnaPig = new ForgeItem("Pig_DNA").setUnlocalizedName(LocalizationStrings.DNA_PIG_NAME).setCreativeTab(this.tabFMaterial);
        dnaSheep = new ForgeItem("Sheep_DNA").setUnlocalizedName(LocalizationStrings.DNA_SHEEP_NAME).setCreativeTab(this.tabFMaterial);
        dnaCow = new ForgeItem("Cow_DNA").setUnlocalizedName(LocalizationStrings.DNA_COW_NAME).setCreativeTab(this.tabFMaterial);
        dnaChicken = new ForgeItem("Chicken_DNA").setUnlocalizedName(LocalizationStrings.DNA_CHICKEN_NAME).setCreativeTab(this.tabFMaterial);
        dnaSmilodon = new ForgeItem("Smilodon_DNA").setUnlocalizedName(LocalizationStrings.DNA_SMILODON_NAME).setCreativeTab(this.tabFMaterial);
        dnaMammoth = new ForgeItem("Mammoth_DNA").setUnlocalizedName(LocalizationStrings.DNA_MAMMOTH_NAME).setCreativeTab(this.tabFMaterial);
        dnaDodo = new ForgeItem("Dodo_DNA").setUnlocalizedName(LocalizationStrings.DNA_DODO_NAME).setCreativeTab(this.tabFMaterial);
        dnaCoelacanth = new ForgeItem("Coelacanth_DNA").setUnlocalizedName(LocalizationStrings.DNA_COELACANTH_NAME).setCreativeTab(this.tabFMaterial);
        dnaHorse = new ForgeItem("Horse_DNA").setUnlocalizedName(LocalizationStrings.DNA_HORSE_NAME).setCreativeTab(this.tabFMaterial);
        dnaQuagga = new ForgeItem("Quagga_DNA").setUnlocalizedName(LocalizationStrings.DNA_QUAGGA_NAME).setCreativeTab(this.tabFMaterial);
        dnaTerrorBird = new ForgeItem("TerrorBird/TerrorBird_DNA").setUnlocalizedName(LocalizationStrings.DNA_TERROR_BIRD_NAME).setCreativeTab(this.tabFMaterial);
        dnaElasmotherium = new ForgeItem("Elasmotherium/Elasmotherium_DNA").setUnlocalizedName(LocalizationStrings.DNA_ELASMOTHERIUM_NAME).setCreativeTab(this.tabFMaterial);

        //Ebryos
        //embyoSyringe = new ItemEmbryoSyringe(embyoSyringeID);
        embryoPig = new ItemEmbryoSyringe(0).setUnlocalizedName(LocalizationStrings.EMBRYO_PIG_NAME).setCreativeTab(this.tabFItems);
        embryoSheep = new ItemEmbryoSyringe(1).setUnlocalizedName(LocalizationStrings.EMBRYO_SHEEP_NAME).setCreativeTab(this.tabFItems);
        embryoCow = new ItemEmbryoSyringe(2).setUnlocalizedName(LocalizationStrings.EMBRYO_COW_NAME).setCreativeTab(this.tabFItems);
        embryoChicken = new ItemEmbryoSyringe(3).setUnlocalizedName(LocalizationStrings.EMBRYO_CHICKEN_NAME).setCreativeTab(this.tabFItems);
        embryoSmilodon = new ItemEmbryoSyringe(4).setUnlocalizedName(LocalizationStrings.EMBRYO_SMILODON_NAME).setCreativeTab(this.tabFItems);
        embryoMammoth = new ItemEmbryoSyringe(5).setUnlocalizedName(LocalizationStrings.EMBRYO_MAMMOTH_NAME).setCreativeTab(this.tabFItems);
        embryoHorse = new ItemEmbryoSyringe(6).setUnlocalizedName(LocalizationStrings.EMBRYO_HORSE_NAME).setCreativeTab(this.tabFItems);
        embryoQuagga = new ItemEmbryoSyringe(7).setUnlocalizedName(LocalizationStrings.EMBRYO_QUAGGA_NAME).setCreativeTab(this.tabFItems);
        embryoElasmotherium = new ItemEmbryoSyringe(8).setUnlocalizedName(LocalizationStrings.EMBRYO_ELASMOTHERIUM_NAME).setCreativeTab(this.tabFItems);

        //Item Food
        //Moved to fossilEnums.EnumDinoType
        for (int i = 0; i < EnumDinoType.values().length; i++)
        {
            EnumDinoType.values()[i].DropItem = new ForgeFood(3, 0.3F, true, EnumDinoType.values()[i].name() + "_Meat").setUnlocalizedName("raw" + EnumDinoType.values()[i].name()).setCreativeTab(this.tabFFood);
        }

        cookedDinoMeat = new ForgeFood(8, 0.8F, true, "Dino_Steak").setUnlocalizedName(LocalizationStrings.DINO_STEAK_NAME).setCreativeTab(this.tabFFood);
        cookedChickenSoup = new ForgeItem("Cooked_Chicken_Soup").setUnlocalizedName(LocalizationStrings.COOKED_CHICKEN_SOUP_NAME).setMaxStackSize(1).setContainerItem(Items.bucket).setCreativeTab(this.tabFFood);
        rawChickenSoup = new ForgeItem("Raw_Chicken_Soup").setUnlocalizedName(LocalizationStrings.RAW_CHICKEN_SOUP_NAME).setMaxStackSize(1).setContainerItem(Items.bucket).setCreativeTab(this.tabFFood);
        chickenEss = new ItemChickenEss(10, 0.0F, false, "Essence_Of_Chicken").setUnlocalizedName(LocalizationStrings.EOC_NAME).setContainerItem(Items.glass_bottle).setCreativeTab(this.tabFFood);
        sjl = new ForgeFood(8, 2.0F, false, "Sio_Chiu_Le").setUnlocalizedName(LocalizationStrings.SJL_NAME).setCreativeTab(this.tabFFood);
        dodoWing = new ForgeFood(3, 0.3F, false, "Raw_Dodo_Wing").setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName(LocalizationStrings.DODO_WING_NAME).setCreativeTab(this.tabFFood);
        dodoWingCooked = new ForgeFood(8, 0.8F, false, "Cooked_Dodo_Wing").setUnlocalizedName(LocalizationStrings.DODO_WING_COOKED_NAME).setCreativeTab(this.tabFFood);
        terrorBirdMeat = new ForgeFood(2, 0.8F, false, "TerrorBird/TerrorBird_Meat").setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName(LocalizationStrings.TERROR_BIRD_MEAT).setCreativeTab(this.tabFFood);
        terrorBirdMeatCooked = new ForgeFood(4, 0.8F, false, "TerrorBird/TerrorBird_Meat_Cooked").setUnlocalizedName(LocalizationStrings.TERROR_BIRD_MEAT_COOKED).setCreativeTab(this.tabFFood);
        quaggaMeat = new ForgeFood(2, 0.8F, false, "Quagga_Meat").setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName(LocalizationStrings.QUAGGA_MEAT).setCreativeTab(this.tabFFood);
        quaggaMeatCooked = new ForgeFood(7, 1F, false, "Quagga_Meat_Cooked").setUnlocalizedName(LocalizationStrings.QUAGGA_MEAT_COOKED).setCreativeTab(this.tabFFood);
        
        // Music Discs
        fossilrecordBones = new ItemFossilRecord(LocalizationStrings.RECORD_BONES_NAME).setUnlocalizedName(LocalizationStrings.FOSSIL_RECORD_NAME);
        
        //Initiate some other things...
        BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.ancientJavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), -1));
        BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.woodjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 0));
        BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.stonejavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 1));
        BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.ironjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 2));
        BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.diamondjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 3));
        BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.goldjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 4));
        BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.dodoEgg, new BehaviorDodoEggDispense(MinecraftServer.getServer(), 5));

        
        //Item Registry
      GameRegistry.registerItem(biofossil, LocalizationStrings.BIO_FOSSIL_NAME);
      GameRegistry.registerItem(relic, LocalizationStrings.RELIC_NAME);
      GameRegistry.registerItem(stoneboard, LocalizationStrings.TABLET_NAME);
      GameRegistry.registerItem(ancientSword, LocalizationStrings.ANCIENT_SWORD_NAME); 
      GameRegistry.registerItem(brokenSword, LocalizationStrings.BROKEN_SWORD_NAME);
      GameRegistry.registerItem(fernSeed, LocalizationStrings.FERNSEED_NAME);
      GameRegistry.registerItem(ancienthelmet, LocalizationStrings.ANCIENT_HELMET_NAME);
      GameRegistry.registerItem(brokenhelmet, LocalizationStrings.BROKEN_HELMET_NAME);
      GameRegistry.registerItem(skullStick, LocalizationStrings.SKULL_STICK_NAME);
      GameRegistry.registerItem(gem, LocalizationStrings.SCARAB_GEM_NAME);
      GameRegistry.registerItem(gemAxe, LocalizationStrings.SCARAB_AXE_NAME);
      GameRegistry.registerItem(gemPickaxe, LocalizationStrings.SCARAB_PICKAXE_NAME);
      GameRegistry.registerItem(gemSword, LocalizationStrings.SCARAB_SWORD_NAME);
      GameRegistry.registerItem(gemHoe, LocalizationStrings.SCARAB_HOE_NAME); 
      GameRegistry.registerItem(gemShovel, LocalizationStrings.SCARAB_SHOVEL_NAME);
      GameRegistry.registerItem(dinoPedia, LocalizationStrings.DINOPEDIA_NAME);
      GameRegistry.registerItem(emptyShell, LocalizationStrings.EMPTY_SHELL_NAME);
      GameRegistry.registerItem(magicConch, LocalizationStrings.MAGIC_CONCH_NAME);
      GameRegistry.registerItem(icedMeat, LocalizationStrings.ICED_MEAT_NAME);
      GameRegistry.registerItem(amber, LocalizationStrings.AMBER_NAME);
      GameRegistry.registerItem(woodjavelin, LocalizationStrings.WOOD_JAVELIN_NAME);
      GameRegistry.registerItem(stonejavelin, LocalizationStrings.STONE_JAVELIN_NAME);
      GameRegistry.registerItem(ironjavelin, LocalizationStrings.IRON_JAVELIN_NAME);
      GameRegistry.registerItem(goldjavelin, LocalizationStrings.GOLD_JAVELIN_NAME);
      GameRegistry.registerItem(diamondjavelin, LocalizationStrings.DIAMOND_JAVELIN_NAME);
      GameRegistry.registerItem(ancientJavelin, LocalizationStrings.ANCIENT_JAVELIN_NAME);
		GameRegistry.registerItem(whip, LocalizationStrings.WHIP_NAME);
		GameRegistry.registerItem(legBone, LocalizationStrings.LEGBONE_NAME);
		GameRegistry.registerItem(claw, LocalizationStrings.CLAW_NAME);
		GameRegistry.registerItem(foot, LocalizationStrings.FOOT_NAME);
		GameRegistry.registerItem(skull, LocalizationStrings.SKULL_NAME);
		GameRegistry.registerItem(vertebrae, LocalizationStrings.VERTEBRAE_NAME);
		GameRegistry.registerItem(armBone, LocalizationStrings.ARM_BONE_NAME);
		GameRegistry.registerItem(dinoRibCage, LocalizationStrings.DINO_RIB_CAGE_NAME);
		//GameRegistry.registerItem(dinosaurModels, LocalizationStrings.DINOSAUR_MODELS);
		GameRegistry.registerItem(brokenSapling, LocalizationStrings.BROKEN_SAPLING_NAME);
		GameRegistry.registerItem(dodoEgg, LocalizationStrings.DODO_EGG_NAME);
		GameRegistry.registerItem(cultivatedDodoEgg, LocalizationStrings.CULTIVATED_DODO_EGG_NAME);
//		GameRegistry.registerItem(archNotebook, LocalizationStrings.ARCH_NOTEBOOK_NAME);
		GameRegistry.registerItem(potteryShards, LocalizationStrings.POTTERY_SHARDS);
//		GameRegistry.registerItem(brokenHeadRelic, LocalizationStrings.BROKEN_HEAD_RELIC);
		GameRegistry.registerItem(skullHelmet, LocalizationStrings.SKULL_HELMET_NAME);
		GameRegistry.registerItem(ribCage, LocalizationStrings.RIBCAGE_NAME);
		GameRegistry.registerItem(femurs, LocalizationStrings.FEMURS_NAME);
		GameRegistry.registerItem(feet, LocalizationStrings.FEET_NAME);
		GameRegistry.registerItem(dnaPig, LocalizationStrings.DNA_PIG_NAME);
		GameRegistry.registerItem(dnaSheep, LocalizationStrings.DNA_SHEEP_NAME);
		GameRegistry.registerItem(dnaCow, LocalizationStrings.DNA_COW_NAME);
		GameRegistry.registerItem(dnaHorse, LocalizationStrings.DNA_HORSE_NAME);
		GameRegistry.registerItem(dnaQuagga, LocalizationStrings.DNA_QUAGGA_NAME);
		GameRegistry.registerItem(dnaChicken, LocalizationStrings.DNA_CHICKEN_NAME);
		GameRegistry.registerItem(dnaSmilodon, LocalizationStrings.DNA_SMILODON_NAME);
		GameRegistry.registerItem(dnaMammoth, LocalizationStrings.DNA_MAMMOTH_NAME);
		GameRegistry.registerItem(dnaCoelacanth, LocalizationStrings.DNA_COELACANTH_NAME);
		GameRegistry.registerItem(dnaDodo, LocalizationStrings.DNA_DODO_NAME);
		GameRegistry.registerItem(dnaTerrorBird, LocalizationStrings.DNA_TERROR_BIRD_NAME);
		GameRegistry.registerItem(dnaElasmotherium, LocalizationStrings.DNA_ELASMOTHERIUM_NAME);
		GameRegistry.registerItem(embryoPig, LocalizationStrings.EMBRYO_PIG_NAME);
		GameRegistry.registerItem(embryoSheep, LocalizationStrings.EMBRYO_SHEEP_NAME);
		GameRegistry.registerItem(embryoCow, LocalizationStrings.EMBRYO_COW_NAME);
		GameRegistry.registerItem(embryoHorse, LocalizationStrings.EMBRYO_HORSE_NAME);
		GameRegistry.registerItem(embryoQuagga, LocalizationStrings.EMBRYO_QUAGGA_NAME);
		GameRegistry.registerItem(embryoChicken, LocalizationStrings.EMBRYO_CHICKEN_NAME);
		GameRegistry.registerItem(embryoSmilodon, LocalizationStrings.EMBRYO_SMILODON_NAME);
		GameRegistry.registerItem(embryoMammoth, LocalizationStrings.EMBRYO_MAMMOTH_NAME);
		GameRegistry.registerItem(embryoElasmotherium, LocalizationStrings.EMBRYO_ELASMOTHERIUM_NAME);
		GameRegistry.registerItem(cookedDinoMeat, LocalizationStrings.DINO_STEAK_NAME);
		GameRegistry.registerItem(cookedChickenSoup, LocalizationStrings.COOKED_CHICKEN_SOUP_NAME);
		GameRegistry.registerItem(rawChickenSoup, LocalizationStrings.RAW_CHICKEN_SOUP_NAME);
		GameRegistry.registerItem(chickenEss, LocalizationStrings.EOC_NAME);
		GameRegistry.registerItem(sjl, LocalizationStrings.SJL_NAME);
		GameRegistry.registerItem(dodoWing, LocalizationStrings.DODO_WING_NAME);
		GameRegistry.registerItem(dodoWingCooked, LocalizationStrings.DODO_WING_COOKED_NAME);
//		GameRegistry.registerItem(figurineItem, LocalizationStrings.FIGURINE_NAME);
		GameRegistry.registerItem(fossilrecordBones, LocalizationStrings.FOSSIL_RECORD_NAME);
		GameRegistry.registerItem(livingCoelacanth, LocalizationStrings.LIVING_COELACANTH_NAME);
		GameRegistry.registerItem(terrorBirdEgg, LocalizationStrings.TERROR_BIRD_EGG_NAME);
		GameRegistry.registerItem(cultivatedTerrorBirdEgg, LocalizationStrings.CULTIVATED_TERROR_BIRD_EGG_NAME);
		GameRegistry.registerItem(terrorBirdMeat, LocalizationStrings.TERROR_BIRD_MEAT);
		GameRegistry.registerItem(terrorBirdMeatCooked, LocalizationStrings.TERROR_BIRD_MEAT_COOKED);
		GameRegistry.registerItem(quaggaMeat,LocalizationStrings.QUAGGA_MEAT);
		GameRegistry.registerItem(quaggaMeatCooked,LocalizationStrings.QUAGGA_MEAT_COOKED);

	
		
		//Dinosaur Eggs
        for (int i = 0; i < EnumDinoType.values().length; i++)
        {
        	GameRegistry.registerItem(EnumDinoType.values()[i].EggItem, "egg" + EnumDinoType.values()[i].name());
        }

        //Dinosaur DNA
        for (int i = 0; i < EnumDinoType.values().length; i++)
        {
        	GameRegistry.registerItem(EnumDinoType.values()[i].DNAItem, "dna" + EnumDinoType.values()[i].name());
        }

        //Dinosaur Meat
        for (int i = 0; i < EnumDinoType.values().length; i++)
        {
        	GameRegistry.registerItem(EnumDinoType.values()[i].DropItem, "raw" + EnumDinoType.values()[i].name());
        }        

        //Block Registry
        GameRegistry.registerBlock(blockFossil, LocalizationStrings.BLOCK_FOSSIL_NAME);
        GameRegistry.registerBlock(blockSkull, LocalizationStrings.BLOCK_SKULL_NAME);
        GameRegistry.registerBlock(skullLantern, LocalizationStrings.SKULL_LANTERN_NAME);
        GameRegistry.registerBlock(blockanalyzerIdle, LocalizationStrings.BLOCK_ANALYZER_IDLE_NAME);
        GameRegistry.registerBlock(blockanalyzerActive, LocalizationStrings.BLOCK_ANALYZER_ACTIVE_NAME);
        GameRegistry.registerBlock(blockcultivateIdle, LocalizationStrings.BLOCK_CULTIVATE_IDLE_NAME);
        GameRegistry.registerBlock(blockcultivateActive, LocalizationStrings.BLOCK_CULTIVATE_ACTIVE_NAME);
        GameRegistry.registerBlock(blockworktableIdle, LocalizationStrings.BLOCK_WORKTABLE_IDLE_NAME);
        GameRegistry.registerBlock(blockworktableActive, LocalizationStrings.BLOCK_WORKTABLE_ACTIVE_NAME);
        GameRegistry.registerBlock(ferns, LocalizationStrings.FERN_BLOCK_NAME);
        GameRegistry.registerBlock(drum, LocalizationStrings.DRUM_NAME);
        GameRegistry.registerBlock(feederIdle, LocalizationStrings.FEEDER_IDLE_NAME);
        GameRegistry.registerBlock(feederActive, LocalizationStrings.FEEDER_ACTIVE_NAME);
        GameRegistry.registerBlock(blockPermafrost, LocalizationStrings.BLOCK_PERMAFROST_NAME);
        GameRegistry.registerBlock(blockIcedStone, LocalizationStrings.BLOCK_ICEDSTONE_NAME);
        GameRegistry.registerBlock(blockTimeMachine, LocalizationStrings.BLOCK_TIMEMACHINE_NAME);
        GameRegistry.registerBlock(palmLog, LocalizationStrings.PALAE_LOG_NAME);
        GameRegistry.registerBlock(palmLeaves, LocalizationStrings.PALAE_LEAVES_NAME);
        GameRegistry.registerBlock(palmSap, LocalizationStrings.PALAE_SAP_NAME);
        GameRegistry.registerBlock(palaeSingleSlab, ItemSlabPalae.class, LocalizationStrings.PALAE_SINGLESLAB_NAME);
        GameRegistry.registerBlock(palaeDoubleSlab, ItemSlabPalae.class, LocalizationStrings.PALAE_DOUBLESLAB_NAME);
        GameRegistry.registerBlock(palaeStairs, LocalizationStrings.PALAE_STAIRS_NAME);
        GameRegistry.registerBlock(palaePlanks, LocalizationStrings.PALAE_PLANKS_NAME);
        GameRegistry.registerBlock(volcanicAsh, LocalizationStrings.VOLCANIC_ASH_NAME);
        GameRegistry.registerBlock(volcanicBrick, LocalizationStrings.VOLCANIC_BRICK_NAME);
        GameRegistry.registerBlock(volcanicRock, LocalizationStrings.VOLCANIC_ROCK_NAME);
        GameRegistry.registerBlock(tar, LocalizationStrings.TAR_NAME);
        GameRegistry.registerBlock(sarracina, LocalizationStrings.SARRACINA_NAME);
        GameRegistry.registerBlock(amberOre, LocalizationStrings.AMBER_ORE_NAME);
        GameRegistry.registerBlock(ancientStone, LocalizationStrings.ANCIENT_STONE_NAME);
        GameRegistry.registerBlock(ancientStonebrick, LocalizationStrings.ANCIENT_STONE_BRICK_NAME);
        GameRegistry.registerBlock(ancientWood, LocalizationStrings.ANCIENT_WOOD_NAME);
        GameRegistry.registerBlock(ancientWoodPillar, LocalizationStrings.ANCIENT_WOOD_PILLAR_NAME);
        GameRegistry.registerBlock(ancientGlass, LocalizationStrings.ANCIENT_GLASS_NAME);
        GameRegistry.registerBlock(ancientWoodPlate, LocalizationStrings.ANCIENT_WOOD_PLATE_NAME);
        GameRegistry.registerBlock(ancientWoodStairs, LocalizationStrings.ANCIENT_WOOD_STAIRS_NAME);
        GameRegistry.registerBlock(ancientWoodSingleSlab, ItemSlabAncientWood.class, LocalizationStrings.ANCIENT_WOOD_SINGLESLAB_NAME);
        GameRegistry.registerBlock(ancientWoodDoubleSlab, ItemSlabAncientWood.class, LocalizationStrings.ANCIENT_WOOD_DOUBLESLAB_NAME);
        GameRegistry.registerBlock(ancientStoneStairs, LocalizationStrings.ANCIENT_STONE_STAIRS_NAME);
        GameRegistry.registerBlock(ancientStoneSingleSlab, ItemSlabAncientStone.class, LocalizationStrings.ANCIENT_STONE_SINGLESLAB_NAME);
        GameRegistry.registerBlock(ancientStoneDoubleSlab, ItemSlabAncientStone.class, LocalizationStrings.ANCIENT_STONE_DOUBLESLAB_NAME);
        GameRegistry.registerBlock(figurineBlock, BlockFigurineItem.class, modid + (figurineBlock.getUnlocalizedName().substring(5)));
        GameRegistry.registerBlock(blockSifterIdle, LocalizationStrings.BLOCK_SIFTER_IDLE);
        GameRegistry.registerBlock(blockSifterActive, LocalizationStrings.BLOCK_SIFTER_ACTIVE);
        GameRegistry.registerBlock(volcanicStairs, LocalizationStrings.VOLCANIC_STAIRS);
        GameRegistry.registerBlock(volcanicSingleSlab, ItemSlabVolcanic.class, LocalizationStrings.VOLCANIC_SINGLESLAB_NAME);
        GameRegistry.registerBlock(volcanicDoubleSlab, ItemSlabVolcanic.class, LocalizationStrings.VOLCANIC_DOUBLESLAB_NAME);
        GameRegistry.registerBlock(vaseVoluteBlock, BlockVaseVoluteItem.class, modid + (vaseVoluteBlock.getUnlocalizedName().substring(5)));
        GameRegistry.registerBlock(vaseAmphoraBlock, BlockVaseAmphoraItem.class, modid + (vaseAmphoraBlock.getUnlocalizedName().substring(5)));
        GameRegistry.registerBlock(vaseKylixBlock, BlockVaseKylixItem.class, modid + (vaseKylixBlock.getUnlocalizedName().substring(5)));

        EntityRegistry.registerModEntity(EntityStoneboard.class, 			"StoneBoard", 			1, this, 250, Integer.MAX_VALUE, false);
        EntityRegistry.registerModEntity(EntityJavelin.class, 				"Javelin", 				2, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityAncientJavelin.class, 		"AncientJavelin", 		3, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityMLighting.class, 			"FriendlyLighting", 	4, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityFailuresaurus.class, 		"Failuresaurus", 		5, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityBones.class, 				"Bones", 				6, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityDinoEgg.class, 				"DinoEgg", 				8, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityFriendlyPigZombie.class, 	"FriendlyPigZombie", 	12, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityPigBoss.class, 				"PigBoss", 				13, this, 250, 5, true);
        //EntityRegistry.registerModEntity(EntityPregnantSheep.class, 		"PregnantSheep", 		19, this, 250, 5, true);
        //EntityRegistry.registerModEntity(EntityPregnantCow.class, 		"PregnantCow", 			20, this, 250, 5, true);
        //EntityRegistry.registerModEntity(EntityPregnantPig.class, 		"PregnantPig", 			21, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntitySmilodon.class, 				"Smilodon", 			22, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityMammoth.class, 				"Mammoth", 				24, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityDodo.class,           		"Dodo",             	25, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityDodoEgg.class,           	"DodoEgg",              26, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityCultivatedDodoEgg.class, 	"CultivatedDodoEgg",    27, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityCoelacanth.class, 			"Coelacanth",    		28, this, 250, 5, true);
        //EntityRegistry.registerModEntity(EntityPregnantHorse.class, 		"PregnantHorse", 		29, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityQuagga.class, 				"Quagga", 				30, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityTerrorBird.class, 			"TerrorBird", 			31, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityTerrorBirdEgg.class,         "TerrorBirdEgg",        32, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityElasmotherium.class, 		"Elasmotherium", 		33, this, 250, 3, true);


        for (int i = 0; i < EnumDinoType.values().length; i++)
        {
            EntityRegistry.registerModEntity(EnumDinoType.values()[i].getDinoClass(), EnumDinoType.values()[i].name(), 200 + i, this, 250, 3, true);
        }
        
        EntityRegistry.addSpawn(EntityCoelacanth.class, 1, 2, 4, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean});
        EntityRegistry.addSpawn(EntityNautilus.class, 5, 4, 14, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.river, BiomeGenBase.ocean});

        FossilSpawnEggs.addSpawnEggs();
        //make the dino types complete by registering the dinos items
        EnumDinoType.init();
        EnumDinoFoodMob.init();
        GameRegistry.registerWorldGenerator(new FossilGenerator(), 0);
        
        if(FossilOptions.Gen_Palaeoraphe)
        GameRegistry.registerWorldGenerator(new WorldGeneratorPalaeoraphe(), 0);
        
        if(FossilOptions.Gen_Academy)
        GameRegistry.registerWorldGenerator(new AcademyGenerator(), 0);
        
        if(FossilOptions.Gen_Ships)
        GameRegistry.registerWorldGenerator(new ShipWreckGenerator(), 0);
        
        GameRegistry.registerWorldGenerator(new TarGenerator(), 0);
        GameRegistry.registerWorldGenerator(new VolcanicRockGenerator(), 0);
        
        /*
        GameRegistry.registerWorldGenerator(new WorldGenWeaponShop());
        */
        
        feederRenderID = RenderingRegistry.getNextAvailableRenderId();
        
        //NetworkRegistry.INSTANCE.registerChatListener(messagerHandler);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, GH);
        GameRegistry.registerTileEntity(TileEntityCultivate.class, LocalizationStrings.BLOCK_CULTIVATE_IDLE_NAME);
        GameRegistry.registerTileEntity(TileEntityAnalyzer.class, LocalizationStrings.BLOCK_ANALYZER_IDLE_NAME);
        GameRegistry.registerTileEntity(TileEntityWorktable.class, LocalizationStrings.BLOCK_WORKTABLE_IDLE_NAME);
        GameRegistry.registerTileEntity(TileEntityDrum.class, LocalizationStrings.DRUM_NAME);
        GameRegistry.registerTileEntity(TileEntityFeeder.class, LocalizationStrings.T_FEEDER_IDLE_NAME);
        GameRegistry.registerTileEntity(TileEntityTimeMachine.class, LocalizationStrings.BLOCK_TIMEMACHINE_NAME);
        GameRegistry.registerTileEntity(TileEntitySifter.class, LocalizationStrings.BLOCK_SIFTER_IDLE);
        GameRegistry.registerTileEntity(TileEntityFigurine.class, "figurineType");
        GameRegistry.registerTileEntity(TileEntityVase.class, "vaseType");
        //TickRegistry.registerTickHandler(new RenderHUD(), Side.CLIENT);
        RenderingRegistry.registerBlockHandler(2303, RenderFeeder.INSTANCE);
        proxy.registerTileEntitySpecialRenderer();
        proxy.registerRenderThings();
        FossilOreDictionary.oreRegistration();
        FossilRecipeHandler.addRecipe();
        //GameRegistry.registerPickupHandler(new FossilPickupHandler());
        //GameRegistry.registerCraftingHandler(new FossilCraftingHandler());
        proxy.registerChestLoot();
        MinecraftForge.EVENT_BUS.register(new FossilToolEvent());
        MinecraftForge.EVENT_BUS.register(new FossilLivingEvent());
        MinecraftForge.EVENT_BUS.register(new FossilInteractEvent());
        FMLCommonHandler.instance().bus().register(new FossilConnectionEvent());
}

    public static void ShowMessage(String var6, EntityPlayer var1)
    {
        if (var1 != null)
        {
        	IChatComponent message = new ChatComponentText(var6);
            var1.addChatMessage(message);
        }
    }

    public static void Console(String var0)
    {
        if (DebugMode())
        {
            FMLLog.log(Fossil.modid, org.apache.logging.log4j.Level.INFO, var0);
        }
    }
    
    public static void log(Level logLevel, String message)
    {
        Log.log(logLevel, message);
    }

    @Mod.EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {
    }
}