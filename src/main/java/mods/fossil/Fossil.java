package mods.fossil;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import mods.fossil.biome.BiomeBasic;
import mods.fossil.blocks.BlockAmberOre;
import mods.fossil.blocks.BlockAncientChest;
import mods.fossil.blocks.BlockAncientGlass;
import mods.fossil.blocks.BlockAncientStone;
import mods.fossil.blocks.BlockAncientStoneSlab;
import mods.fossil.blocks.BlockAncientStonebrick;
import mods.fossil.blocks.BlockAncientWood;
import mods.fossil.blocks.BlockAncientWoodPillar;
import mods.fossil.blocks.BlockAncientWoodPlate;
import mods.fossil.blocks.BlockAncientWoodSlab;
import mods.fossil.blocks.BlockAnuItem;
import mods.fossil.blocks.BlockAnuPortal;
import mods.fossil.blocks.BlockAnuTotem;
import mods.fossil.blocks.BlockAnubiteStatue;
import mods.fossil.blocks.BlockDenseSand;
import mods.fossil.blocks.BlockDillhoffiaFlower;
import mods.fossil.blocks.BlockFern;
import mods.fossil.blocks.BlockFigurine;
import mods.fossil.blocks.BlockFigurineItem;
import mods.fossil.blocks.BlockFossil;
import mods.fossil.blocks.BlockFossilSkull;
import mods.fossil.blocks.BlockFossilStairs;
import mods.fossil.blocks.BlockHomePortal;
import mods.fossil.blocks.BlockIcedStone;
import mods.fossil.blocks.BlockLimestone;
import mods.fossil.blocks.BlockLimestoneBrick;
import mods.fossil.blocks.BlockMagnoliaFlower;
import mods.fossil.blocks.BlockMarble;
import mods.fossil.blocks.BlockPalaePlanks;
import mods.fossil.blocks.BlockPalaeSlab;
import mods.fossil.blocks.BlockPalmLeaves;
import mods.fossil.blocks.BlockPalmLog;
import mods.fossil.blocks.BlockPalmSapling;
import mods.fossil.blocks.BlockPermafrost;
import mods.fossil.blocks.BlockSarcophagus;
import mods.fossil.blocks.BlockSlimeTrail;
import mods.fossil.blocks.BlockSpikes;
import mods.fossil.blocks.BlockStrongGlass;
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
import mods.fossil.blocks.FossilSoundType;
import mods.fossil.client.FossilGuiHandler;
import mods.fossil.client.FossilOptions;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.client.renderer.tileentity.RenderFeeder;
import mods.fossil.core.FossilFireSupport;
import mods.fossil.core.FossilPlants;
import mods.fossil.dimension.anu.WorldProviderAnu;
import mods.fossil.dimension.treasure.WorldProviderTreasure;
import mods.fossil.enchantments.EnchantmentArcheology;
import mods.fossil.enchantments.EnchantmentPaleontology;
import mods.fossil.entity.BehaviorConfuciusornisEggDispense;
import mods.fossil.entity.BehaviorDodoEggDispense;
import mods.fossil.entity.BehaviorJavelinDispense;
import mods.fossil.entity.EntityAncientJavelin;
import mods.fossil.entity.EntityAnuEffect;
import mods.fossil.entity.EntityDinoEgg;
import mods.fossil.entity.EntityJavelin;
import mods.fossil.entity.EntityMLighting;
import mods.fossil.entity.EntityStoneboard;
import mods.fossil.entity.EntityTerrorBirdEgg;
import mods.fossil.entity.mob.EntityAnu;
import mods.fossil.entity.mob.EntityAnuDead;
import mods.fossil.entity.mob.EntityAnubite;
import mods.fossil.entity.mob.EntityBones;
import mods.fossil.entity.mob.EntityCoelacanth;
import mods.fossil.entity.mob.EntityConfuciusornis;
import mods.fossil.entity.mob.EntityConfuciusornisEgg;
import mods.fossil.entity.mob.EntityCultivatedChickenEgg;
import mods.fossil.entity.mob.EntityCultivatedConfuciusornisEgg;
import mods.fossil.entity.mob.EntityCultivatedDodoEgg;
import mods.fossil.entity.mob.EntityDodo;
import mods.fossil.entity.mob.EntityDodoEgg;
import mods.fossil.entity.mob.EntityElasmotherium;
import mods.fossil.entity.mob.EntityFailuresaurus;
import mods.fossil.entity.mob.EntityFriendlyPigZombie;
import mods.fossil.entity.mob.EntityMammoth;
import mods.fossil.entity.mob.EntityNautilus;
import mods.fossil.entity.mob.EntityPigBoss;
import mods.fossil.entity.mob.EntityQuagga;
import mods.fossil.entity.mob.EntitySentryPigman;
import mods.fossil.entity.mob.EntitySmilodon;
import mods.fossil.entity.mob.EntityTerrorBird;
import mods.fossil.fossilEnums.EnumDinoFoodMob;
import mods.fossil.fossilEnums.EnumDinoType;
import mods.fossil.gens.FossilGenerator;
import mods.fossil.gens.TarGenerator;
import mods.fossil.gens.VolcanicRockGenerator;
import mods.fossil.gens.WorldGenMiscStructures;
import mods.fossil.gens.WorldGeneratorPalaeoraphe;
import mods.fossil.gens.feature.WorldGenHellBoat;
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
import mods.fossil.guiBlocks.TileEntityAncientChest;
import mods.fossil.guiBlocks.TileEntityAnuTotem;
import mods.fossil.guiBlocks.TileEntityAnubiteStatue;
import mods.fossil.guiBlocks.TileEntityCultivate;
import mods.fossil.guiBlocks.TileEntityDrum;
import mods.fossil.guiBlocks.TileEntityFeeder;
import mods.fossil.guiBlocks.TileEntityFigurine;
import mods.fossil.guiBlocks.TileEntitySarcophagus;
import mods.fossil.guiBlocks.TileEntitySifter;
import mods.fossil.guiBlocks.TileEntityTimeMachine;
import mods.fossil.guiBlocks.TileEntityVase;
import mods.fossil.guiBlocks.TileEntityWorktable;
import mods.fossil.handler.EventFossilAchivements;
import mods.fossil.handler.EventOverlay;
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
import mods.fossil.items.ItemAquaticScarabGem;
import mods.fossil.items.ItemBioFossil;
import mods.fossil.items.ItemBirdEgg;
import mods.fossil.items.ItemChickenEss;
import mods.fossil.items.ItemDinosaurBones;
import mods.fossil.items.ItemDominicanAmber;
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
import mods.fossil.items.ItemToothDagger;
import mods.fossil.items.ItemWhip;
import mods.fossil.items.blocks.BlockAnubiteItem;
import mods.fossil.items.blocks.ItemBlockTeir1;
import mods.fossil.items.blocks.ItemBlockTeir2;
import mods.fossil.items.blocks.ItemBlockTeir3;
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
import mods.fossil.tabs.TabFTest;
import mods.fossil.tabs.TabFTools;
import mods.fossil.util.FossilBonemealEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.StructureMineshaftPieces;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DimensionManager;
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
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = Fossil.modid, name = "Fossil/Archeology", version = Fossil.modversion)

public class Fossil
{
	/**
	 * The mod ID
	 */

	public static final String modid = "fossil";

	/**
	 * The mod version
	 */

	//Testing 

	public static final String modversion = "1.7.10 Build 7.2.0";

	/**
	 * The mod state
	 * 0 = Dev build
	 * 1 = Beta build
	 * 2 = Release build
	 */
	public static final int modState = 2;

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
	//	public static CreativeTabs tabFTest = new TabFTest("Pre Release");

	/*
	 * Render ID's
	 */

	public static int feederRenderID;

	/*
	 * Enchantments 
	 */

	public static Enchantment paleontology;
	public static Enchantment archeology;
	public static int e_archeologyID;
	public static int e_paleontologyID;
	public static int dimensionID_anu;
	public static int dimensionID_treasure;
	public static int dimensionID_prehistory = -22;

	/*
	 * Blocks 
	 */

	public static Block blockFossil;
	//public static Block blockDillhoffia;
	//public static Block blockMagnolia;
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
	public static Block palaeSingleSlab;
	public static Block palaeDoubleSlab;
	public static Block palaeStairs;
	//public static Block sarracina;
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
	public static Block marble;
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

	/*
	 * Items!
	 */

	public static Item biofossil;
	public static Item AquaticScarabGem;
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
	public static Item toothDagger;
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
	public static Item failuresaurusFlesh;
	public static Item cultivatedChickenEgg;
	public static Item dodoEgg;
	public static Item cultivatedDodoEgg;
	public static Item confuciusornisEgg;
	public static Item cultivatedConfuciusornisEgg;
	public static Item dodoWing;
	public static Item dodoWingCooked;
	public static Item confuciornisRaw;
	public static Item confuciornisCooked;
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
	public static Item ancientKey;
	public static Item ancientClock;

	/*
	 * Bones
	 */

	public static Item dinosaurModels;
	public static Item armBone;
	public static Item dinoRibCage;
	public static Item vertebrae;

	/*
	 * Armor
	 */

	public static Item skullHelmet;
	public static Item ribCage;
	public static Item femurs;
	public static Item feet;
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
	public static Item dnaConfuciusornis;


	/*
	 * Embryos
	 * public static Item embyoSyringe;
	 */

	public static Item embryoPig;
	public static Item DominicanAmber;
	public static Item embryoSheep;
	public static Item embryoCow;
	public static Item embryoChicken;
	public static Item embryoSmilodon;
	public static Item embryoMammoth;
	public static Item embryoHorse;
	public static Item embryoQuagga;
	public static Item embryoElasmotherium;

	/*
	 * Food
	 */

	public static Item cookedChickenSoup;
	public static Item rawChickenSoup;
	public static Item chickenEss;
	public static Item sjl;
	public static Item cookedDinoMeat;

	public static final String CHEST_HELLSHIP       = "hellship";

	//Block SoundTypes
	public static final FossilSoundType soundTypeSlime = new FossilSoundType(1.0F, 1.0F);
	//Biomes
	public static BiomeGenBase anuBiome;
	public static BiomeGenBase treasureBiome;

	/*
	 * Music Discs
	 */

	public static Item fossilrecordBones;
	public static Item recordNano_Anu;
	
	static ArmorMaterial bone = EnumHelper.addArmorMaterial("Bone", 25, new int[] {2, 7, 6, 2}, 15);
	static ToolMaterial scarab = EnumHelper.addToolMaterial("Scarab", 3, 1861, 8.0F, 4.0F, 25);
	static ArmorMaterial scarabArmor = EnumHelper.addArmorMaterial("Scarab", 50, new int[]{3, 8, 6, 3}, 10);
	static ArmorMaterial RELIC = EnumHelper.addArmorMaterial("Relic", 5, new int[]{1, 3, 2, 1}, 15);	
	static ToolMaterial toothDaggerMaterial = EnumHelper.addToolMaterial("toothDagger", 3, 250, 70.0F, 1.5F, 25);

	@Mod.EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new FossilBonemealEvent());
		VillagerRegistry.instance().registerVillageTradeHandler(10, new FossilTradeHandler());
		VillagerRegistry.instance().registerVillagerId(10);
		config = new Configuration(event.getSuggestedConfigurationFile());


		try {
			config.load();

			/* 
			 * Loads the config into the folder so
			 * the user can customize their stuffs
			 */

			//Enchantments
			e_paleontologyID = config.get(Configuration.CATEGORY_GENERAL, LocalizationStrings.ENCHANTMENT_PALEONTOLOGY, 90).getInt();
			e_archeologyID = config.get(Configuration.CATEGORY_GENERAL, LocalizationStrings.ENCHANTMENT_ARCHEOLOGY, 91).getInt();


			//Config options
			FossilOptions.Gen_Palaeoraphe = config.get("option", "Palaeoraphe", false).getBoolean(false);
			FossilOptions.Gen_HellShips = config.get("option", "Hell Ships", true).getBoolean(true);
			FossilOptions.Gen_Academy = config.get("option", "Academy", true).getBoolean(true);
			FossilOptions.Gen_Ships = config.get("option", "Ships", true).getBoolean(true);
			FossilOptions.Gen_Temple = config.get("option", "Temple", true).getBoolean(true);
			FossilOptions.Heal_Dinos = config.get("option", "Heal_Dinos", true).getBoolean(true);
			FossilOptions.Dinos_Starve = config.get("option", "Dinos_Starve", true).getBoolean(true);
			FossilOptions.Dino_Block_Breaking = config.get("option", "Dino_Block_Breaking", true).getBoolean(true);
			FossilOptions.Skull_Overlay = config.get("option", "Skull_Overlay", true).getBoolean(true);
			FossilOptions.LoginMessage = config.get("option", "Display_Login_Message", true).getBoolean(false);
			FossilOptions.Anu_Spawn = config.get("option", "Anu_Spawn", false).getBoolean(false);
			FossilOptions.Anu_Allowed_Overworld = config.get("option", "Anu_Allowed_Overworld", false).getBoolean(false);
			FossilOptions.AllowBreeding = config.get("option", "Allow_Dinosaur_Breeding", true).getBoolean(true);
			FossilOptions.DeveloperSpecials = config.get("option",  "(Devs only)Allow Dev Specials", true).getBoolean(true);

			//Dinosaur Feathers
			FossilOptions.TRexFeathers = config.get("toggle_scales", "Tyrannosaurus Scales", false).getBoolean(false);
			FossilOptions.DeinonychusFeathers = config.get("toggle_scales", "Deinonychus Scales", false).getBoolean(false);
			FossilOptions.GallimimusFeathers = config.get("toggle_scales",  "Gallimimus Scales", false).getBoolean(false);
			FossilOptions.CompsognathusFeathers = config.get("toggle_scales",  "Compsognathus Scales", false).getBoolean(false);
			FossilOptions.VelociraptorFeathers = config.get("toggle_scales",  "Velociraptor Scales", false).getBoolean(false);
			FossilOptions.TriceratopsQuills = config.get("toggle_quills",  "Triceratops Quills", true).getBoolean(true);

			//IDs
			FossilOptions.biomeIDDarknessLair = config.get("biome IDs", "Layer of Darkness ID:", 128).getInt();
			FossilOptions.biomeIDTreasure = config.get("biome IDs", "Treasure ID:", 127).getInt();
			FossilOptions.dimIDDarknessLair = config.get("biome IDs", "Layer of Darkness ID:", -23).getInt();
			FossilOptions.dimIDTreasure = config.get("dimension IDs", "Ancient Treasure Room ID:", -34).getInt();

			/*
			 * Toggle the enchantments (In the config)
			 */

			FossilOptions.AllowTableEnchantments = config.get("option", "Allow Table Enchantments", true).getBoolean(true);
			FossilOptions.AllowBookEnchantments = config.get("option", "Allow Book Enchantments", true).getBoolean(true);

			
		}
		catch (Exception var7)
		{
			System.out.println("Fossil Mod not loading configuration");
			//            FMLLog.(Level.SEVERE, var7, "Fossil Mod Not loading configuration", new Object[0]);
		}
		finally {
			config.save();
		}


		if (event.getSide() == Side.CLIENT) {
			//  proxy.registerSounds();
		}



		if (event.getSide() == Side.CLIENT) {
			proxy.registerEvents();
		}

	}

	/*
	 * This is where we register all the things in the mod.
	 */

	@Mod.EventHandler
	public void Init(FMLInitializationEvent event) {	

		dimensionID_anu = FossilOptions.dimIDDarknessLair;
		dimensionID_treasure = FossilOptions.dimIDTreasure;

		DimensionManager.registerProviderType(dimensionID_anu, WorldProviderAnu.class, false);
		DimensionManager.registerDimension(dimensionID_anu, dimensionID_anu);
		DimensionManager.registerProviderType(dimensionID_treasure, WorldProviderTreasure.class, false);
		DimensionManager.registerDimension(dimensionID_treasure, dimensionID_treasure);
		/*
		 * Enchantments
		 */

		paleontology = new EnchantmentPaleontology(e_paleontologyID, 2, EnumEnchantmentType.digger);
		archeology = new EnchantmentArcheology(e_archeologyID, 2, EnumEnchantmentType.digger);

		/*
		 * We make the blocks here :P
		 */

		skullLantern = new BlockFossilSkull(true).setLightLevel(1F);
		Limestone = new BlockLimestone(Material.rock);
		LimestoneBrick = new BlockLimestoneBrick(Material.rock);
		blockanalyzerIdle = new BlockAnalyzer(false);
		blockanalyzerActive = new BlockAnalyzer(true);
		blockcultivateIdle = new BlockCultivate(false);
		blockcultivateActive = new BlockCultivate(true);
		blockSlimeTrail = new BlockSlimeTrail().setHardness(0.3F).setBlockTextureName("fossil:Slime_Trail").setStepSound(soundTypeSlime).setBlockName(LocalizationStrings.BLOCK_SLIME_TRAIL_NAME).setCreativeTab(this.tabFBlocks);
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
		//sarracina = new BlockSarracenia();
		tar = new BlockTar();
		amberOre  = new BlockAmberOre();
		ancientStone  = new BlockAncientStone();
		ancientStonebrick  = new BlockAncientStonebrick();
		ancientWood  = new BlockAncientWood();
		ancientWoodPillar = new BlockAncientWoodPillar();
		ancientGlass = new BlockAncientGlass(Material.glass);
		ancientWoodPlate = new BlockAncientWoodPlate();
		ancientWoodStairs = new BlockFossilStairs(ancientWood, 0).setBlockName(LocalizationStrings.ANCIENT_WOOD_STAIRS_NAME);
		ancientWoodDoubleSlab = new BlockAncientWoodSlab(true);
		ancientWoodSingleSlab = new BlockAncientWoodSlab(false);
		ancientStoneStairs = new BlockFossilStairs(ancientStone, 0).setBlockName(LocalizationStrings.ANCIENT_STONE_STAIRS_NAME);
		ancientStoneDoubleSlab = new BlockAncientStoneSlab(true);
		ancientStoneSingleSlab = new BlockAncientStoneSlab(false);
		marble  = new BlockMarble();
		obsidianSpikes = new BlockSpikes().setCreativeTab(tabFBlocks).setHardness(50.0F).setResistance(2000.0F).setStepSound(Block.soundTypePiston).setBlockName("obsidianSpikes").setBlockTextureName("fossil:obsidianSpikes");
		figurineBlock = new BlockFigurine();
		anuTotem = new BlockAnuTotem();
		anuPortal = new BlockAnuPortal();
		homePortal = new BlockHomePortal();
		anubiteStatue = new BlockAnubiteStatue();
		ancientChest = new BlockAncientChest().setCreativeTab(tabFBlocks);
		blockSifterIdle = new BlockSifter(false);
		blockSifterActive = new BlockSifter(true);
		volcanicStairs = new BlockFossilStairs(volcanicBrick, 0).setBlockName(LocalizationStrings.VOLCANIC_STAIRS);
		volcanicDoubleSlab = new BlockVolcanicSlab(true);
		volcanicSingleSlab = new BlockVolcanicSlab(false);
		vaseVoluteBlock = new BlockVaseVolute();
		vaseAmphoraBlock = new BlockVaseAmphora();
		vaseKylixBlock = new BlockVaseKylix();       
		sarcophagus = new BlockSarcophagus();
		/*
		 * Blocks.fire.setFireInfo(Fossil.ferns, 30, 60);
		 * Blocks.fire.setFireInfo(Fossil.palmLeaves, 30, 60);
		 * Blocks.fire.setFireInfo(Fossil.palaePlanks, 5, 20);
		 * Blocks.fire.setFireInfo(Fossil.tar, 500, 1);
		 * Blocks.fire.setFireInfo(Fossil.ancientWood, 10, 20);
		 * Blocks.fire.setFireInfo(Fossil.ancientWoodPlate, 5, 10);
		 * Blocks.fire.setFireInfo(Fossil.ancientWoodStairs, 10, 20);
		 */

		/*
		 * Making the Items
		 * 
		 * dinosaurModels = new ItemDinosaurModels().setUnlocalizedName(LocalizationStrings.DINOSAUR_MODELS).setCreativeTab(this.tabFBones);
		 * archNotebook = new ForgeItem("Arch_Notebook").setUnlocalizedName(LocalizationStrings.ARCH_NOTEBOOK_NAME).setCreativeTab(this.tabFItems);
		 * brokenHeadRelic = new ItemHeadRelic(RELIC, 3, 0).setUnlocalizedName(LocalizationStrings.BROKEN_HEAD_RELIC).setCreativeTab(Fossil.tabFTest);
		 */

		biofossil = new ItemBioFossil();
		DominicanAmber = new ItemDominicanAmber();
		AquaticScarabGem = new ItemAquaticScarabGem().setUnlocalizedName("AquaticScarabGem");
		relic = new ForgeItem("Relic_Scrap").setUnlocalizedName(LocalizationStrings.RELIC_NAME).setCreativeTab(this.tabFItems);
		stoneboard = new ItemStoneBoard();
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
		toothDagger = new ItemToothDagger(toothDaggerMaterial).setTextureName("fossil:toothDagger").setUnlocalizedName("toothDagger").setCreativeTab(this.tabFCombat);
		whip = new ItemWhip().setUnlocalizedName(LocalizationStrings.WHIP_NAME).setCreativeTab(this.tabFTools);

		legBone = new ItemDinosaurBones("legBone").setUnlocalizedName(LocalizationStrings.LEGBONE_NAME);
		claw = new ItemDinosaurBones("uniqueItem").setUnlocalizedName(LocalizationStrings.CLAW_NAME);
		foot = new ItemDinosaurBones("foot").setUnlocalizedName(LocalizationStrings.FOOT_NAME);
		skull = new ItemDinosaurBones("skull").setUnlocalizedName(LocalizationStrings.SKULL_NAME);
		armBone = new ItemDinosaurBones("armBone").setUnlocalizedName(LocalizationStrings.ARM_BONE_NAME);
		dinoRibCage = new ItemDinosaurBones("dinoRibCage").setUnlocalizedName(LocalizationStrings.DINO_RIB_CAGE_NAME);
		vertebrae = new ItemDinosaurBones("vertebrae").setUnlocalizedName(LocalizationStrings.VERTEBRAE_NAME);

		brokenSapling = new ForgeItem("fossilPlant").setUnlocalizedName(LocalizationStrings.BROKEN_SAPLING_NAME).setCreativeTab(this.tabFMaterial);
		failuresaurusFlesh = new ForgeItem("flesh").setUnlocalizedName(LocalizationStrings.FAILURESAURUS_FLESH_NAME).setCreativeTab(this.tabFMaterial);
		cultivatedChickenEgg = new ItemBirdEgg(4).setUnlocalizedName("eggCultivatedChicken").setTextureName("fossil:Egg_Cultivated_Chicken");
		dodoEgg = new ItemBirdEgg(0).setUnlocalizedName(LocalizationStrings.DODO_EGG_NAME).setTextureName("fossil:Egg_Dodo");
		cultivatedDodoEgg = new ItemBirdEgg(1).setUnlocalizedName(LocalizationStrings.CULTIVATED_DODO_EGG_NAME).setTextureName("fossil:Egg_Cultivated_Dodo");
		confuciusornisEgg = new ItemBirdEgg(2).setUnlocalizedName("eggConfuciusornis").setTextureName("fossil:Egg_Confuciusornis");
		cultivatedConfuciusornisEgg = new ItemBirdEgg(3).setUnlocalizedName("eggCultivatedConfuciusornis").setTextureName("fossil:Egg_Cultivated_Confuciusornis");
		potteryShards = new ForgeItem("PotteryShard").setUnlocalizedName(LocalizationStrings.POTTERY_SHARDS).setCreativeTab(this.tabFItems);
		livingCoelacanth = new ItemLivingCoelacanth(1).setUnlocalizedName(LocalizationStrings.LIVING_COELACANTH_NAME).setCreativeTab(this.tabFMaterial);
		terrorBirdEgg = new ItemTerrorBirdEgg(false).setUnlocalizedName(LocalizationStrings.TERROR_BIRD_EGG_NAME);
		cultivatedTerrorBirdEgg = new ItemTerrorBirdEgg(true).setUnlocalizedName(LocalizationStrings.CULTIVATED_TERROR_BIRD_EGG_NAME);

		/*
		 * Making the bone armor
		 */

		skullHelmet = new ItemSkullHelmet(bone, 3, 0).setUnlocalizedName(LocalizationStrings.SKULL_HELMET_NAME).setCreativeTab(Fossil.tabFCombat);
		ribCage = new ItemRibCage(bone, 3, 1).setUnlocalizedName(LocalizationStrings.RIBCAGE_NAME).setCreativeTab(Fossil.tabFCombat);
		femurs = new ItemFemurs(bone, 3, 2).setUnlocalizedName(LocalizationStrings.FEMURS_NAME).setCreativeTab(Fossil.tabFCombat);
		feet = new ItemFeet(bone, 3, 3).setUnlocalizedName(LocalizationStrings.FEET_NAME).setCreativeTab(this.tabFCombat);

		/*
		 * Making the Ancient Eggs
		 * Moved to fossilEnums.EnumDinoType
		 */

		for (int i = 0; i < EnumDinoType.values().length; i++) {
			EnumDinoType.values()[i].EggItem = new ItemAncientEgg(i).setUnlocalizedName("egg" + EnumDinoType.values()[i].name()).setCreativeTab(this.tabFMaterial);
		}

		/*
		 * Making DNA
		 * 
		 * Moved to fossilEnums.EnumDinoType
		 */

		for (int i = 0; i < EnumDinoType.values().length; i++) {
			EnumDinoType.values()[i].DNAItem = new ForgeItem(EnumDinoType.values()[i].name() + "_DNA").setUnlocalizedName("dna" + EnumDinoType.values()[i].name()).setCreativeTab(this.tabFMaterial);
		}

		/*
		 * Making dino DNA
		 * 
		 * animalDNA = new ItemNonDinoDNA(animalDNAID);
		 */

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
		dnaConfuciusornis = new ForgeItem("Confuciusornis_DNA").setUnlocalizedName("dnaConfuciusornis").setCreativeTab(this.tabFMaterial);
		/*
		 * Making the Embryos
		 * 
		 * embyoSyringe = new ItemEmbryoSyringe(embyoSyringeID);
		 */

		embryoPig = new ItemEmbryoSyringe(0).setUnlocalizedName(LocalizationStrings.EMBRYO_PIG_NAME).setCreativeTab(this.tabFItems);
		embryoSheep = new ItemEmbryoSyringe(1).setUnlocalizedName(LocalizationStrings.EMBRYO_SHEEP_NAME).setCreativeTab(this.tabFItems);
		embryoCow = new ItemEmbryoSyringe(2).setUnlocalizedName(LocalizationStrings.EMBRYO_COW_NAME).setCreativeTab(this.tabFItems);
		embryoChicken = new ItemEmbryoSyringe(3).setUnlocalizedName(LocalizationStrings.EMBRYO_CHICKEN_NAME).setCreativeTab(this.tabFItems);
		embryoSmilodon = new ItemEmbryoSyringe(4).setUnlocalizedName(LocalizationStrings.EMBRYO_SMILODON_NAME).setCreativeTab(this.tabFItems);
		embryoMammoth = new ItemEmbryoSyringe(5).setUnlocalizedName(LocalizationStrings.EMBRYO_MAMMOTH_NAME).setCreativeTab(this.tabFItems);
		embryoHorse = new ItemEmbryoSyringe(6).setUnlocalizedName(LocalizationStrings.EMBRYO_HORSE_NAME).setCreativeTab(this.tabFItems);
		embryoQuagga = new ItemEmbryoSyringe(7).setUnlocalizedName(LocalizationStrings.EMBRYO_QUAGGA_NAME).setCreativeTab(this.tabFItems);
		embryoElasmotherium = new ItemEmbryoSyringe(8).setUnlocalizedName(LocalizationStrings.EMBRYO_ELASMOTHERIUM_NAME).setCreativeTab(this.tabFItems);
		ancientClock = new Item().setTextureName("apple_golden").setUnlocalizedName("ancientClock").setCreativeTab(tabFItems).setMaxStackSize(1);
		ancientKey = new ForgeItem("Ancient_Key").setUnlocalizedName("ancientKey").setCreativeTab(tabFItems);
		/*
		 * Item Food
		 * Moved to fossilEnums.EnumDinoType
		 */

		for (int i = 0; i < EnumDinoType.values().length; i++) {
			EnumDinoType.values()[i].DropItem = new ForgeFood(3, 0.3F, true, EnumDinoType.values()[i].name() + "_Meat").setUnlocalizedName("raw" + EnumDinoType.values()[i].name()).setCreativeTab(this.tabFFood);
		}

		/*
		 * Making the food of the mod :)
		 */

		cookedDinoMeat = new ForgeFood(8, 0.8F, true, "Dino_Steak").setUnlocalizedName(LocalizationStrings.DINO_STEAK_NAME).setCreativeTab(this.tabFFood);
		cookedChickenSoup = new ForgeItem("Cooked_Chicken_Soup").setUnlocalizedName(LocalizationStrings.COOKED_CHICKEN_SOUP_NAME).setMaxStackSize(1).setContainerItem(Items.bucket).setCreativeTab(this.tabFFood);
		rawChickenSoup = new ForgeItem("Raw_Chicken_Soup").setUnlocalizedName(LocalizationStrings.RAW_CHICKEN_SOUP_NAME).setMaxStackSize(1).setContainerItem(Items.bucket).setCreativeTab(this.tabFFood);
		chickenEss = new ItemChickenEss(10, 0.0F, false, "Essence_Of_Chicken").setUnlocalizedName(LocalizationStrings.EOC_NAME).setContainerItem(Items.glass_bottle).setCreativeTab(this.tabFFood);
		sjl = new ForgeFood(8, 2.0F, false, "Sio_Chiu_Le").setUnlocalizedName(LocalizationStrings.SJL_NAME).setCreativeTab(this.tabFFood);
		dodoWing = new ForgeFood(3, 0.3F, false, "Raw_Dodo_Wing").setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName(LocalizationStrings.DODO_WING_NAME).setCreativeTab(this.tabFFood);
		dodoWingCooked = new ForgeFood(8, 0.8F, false, "Cooked_Dodo_Wing").setUnlocalizedName(LocalizationStrings.DODO_WING_COOKED_NAME).setCreativeTab(this.tabFFood);
		confuciornisRaw = new ForgeFood(2, 0.3F, false, "RawConfuciornis").setUnlocalizedName("rawConfuciornis").setCreativeTab(this.tabFFood);
		confuciornisCooked = new ForgeFood(5, 0.8F, false, "CookedConfuciornis").setUnlocalizedName("cookedConfuciornis").setCreativeTab(this.tabFFood);
		terrorBirdMeat = new ForgeFood(2, 0.8F, false, "TerrorBird/TerrorBird_Meat").setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName(LocalizationStrings.TERROR_BIRD_MEAT).setCreativeTab(this.tabFFood);
		terrorBirdMeatCooked = new ForgeFood(4, 0.8F, false, "TerrorBird/TerrorBird_Meat_Cooked").setUnlocalizedName(LocalizationStrings.TERROR_BIRD_MEAT_COOKED).setCreativeTab(this.tabFFood);
		quaggaMeat = new ForgeFood(2, 0.8F, false, "Quagga_Meat").setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName(LocalizationStrings.QUAGGA_MEAT).setCreativeTab(this.tabFFood);
		quaggaMeatCooked = new ForgeFood(7, 1F, false, "Quagga_Meat_Cooked").setUnlocalizedName(LocalizationStrings.QUAGGA_MEAT_COOKED).setCreativeTab(this.tabFFood);

		//biomes
		
		anuBiome = new BiomeBasic(FossilOptions.biomeIDDarknessLair, Blocks.netherrack, Blocks.netherrack, true, 0, 0).setDisableRain().setBiomeName(LocalizationStrings.BIOME_ANU).setTemperatureRainfall(0.8F, 0F).setHeight(new BiomeGenBase.Height(0F, 0F));
		treasureBiome = new BiomeBasic(FossilOptions.biomeIDTreasure, Blocks.air, Blocks.air, true, 1, 0).setDisableRain().setBiomeName(StatCollector.translateToLocal("biome.treasure.name")).setTemperatureRainfall(0.8F, 0F).setHeight(new BiomeGenBase.Height(0F, 0F));

		/*
		 * Making the mod cds
		 */

		fossilrecordBones = new ItemFossilRecord(LocalizationStrings.RECORD_BONES_NAME).setUnlocalizedName(LocalizationStrings.FOSSIL_RECORD_NAME);
		recordNano_Anu = new ItemFossilRecord(LocalizationStrings.FOSSIL_RECORD_NANO_ANU).setUnlocalizedName(LocalizationStrings.RECORD_BONES_NAME);

		/*
		 * registers javlins to be shot
		 */

		BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.ancientJavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), -1));
		BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.woodjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 0));
		BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.stonejavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 1));
		BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.ironjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 2));
		BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.diamondjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 3));
		BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.goldjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 4));
		BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.dodoEgg, new BehaviorDodoEggDispense(MinecraftServer.getServer(), 5));
		BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.confuciusornisEgg, new BehaviorConfuciusornisEggDispense(MinecraftServer.getServer(), 6));


		/*
		 * Where we Register the items
		 * 
		 * GameRegistry.registerItem(figurineItem, LocalizationStrings.FIGURINE_NAME);
		 * GameRegistry.registerItem(brokenHeadRelic, LocalizationStrings.BROKEN_HEAD_RELIC);
		 * GameRegistry.registerItem(archNotebook, LocalizationStrings.ARCH_NOTEBOOK_NAME);
		 * GameRegistry.registerItem(dinosaurModels, LocalizationStrings.DINOSAUR_MODELS);
		 */

		GameRegistry.registerItem(biofossil, LocalizationStrings.BIO_FOSSIL_NAME);
		GameRegistry.registerItem(relic, LocalizationStrings.RELIC_NAME);
		GameRegistry.registerItem(stoneboard, LocalizationStrings.TABLET_NAME);
		GameRegistry.registerItem(ancientSword, LocalizationStrings.ANCIENT_SWORD_NAME); 
		GameRegistry.registerItem(brokenSword, LocalizationStrings.BROKEN_SWORD_NAME);
		GameRegistry.registerItem(ancienthelmet, LocalizationStrings.ANCIENT_HELMET_NAME);
		GameRegistry.registerItem(brokenhelmet, LocalizationStrings.BROKEN_HELMET_NAME);
		GameRegistry.registerItem(skullStick, LocalizationStrings.SKULL_STICK_NAME);
		GameRegistry.registerItem(gem, LocalizationStrings.SCARAB_GEM_NAME);
		GameRegistry.registerItem(AquaticScarabGem, "AquaticScarabGem");
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
		GameRegistry.registerItem(DominicanAmber, LocalizationStrings.DOMINICAN_AMBER_NAME);
		GameRegistry.registerItem(woodjavelin, LocalizationStrings.WOOD_JAVELIN_NAME);
		GameRegistry.registerItem(stonejavelin, LocalizationStrings.STONE_JAVELIN_NAME);
		GameRegistry.registerItem(ironjavelin, LocalizationStrings.IRON_JAVELIN_NAME);
		GameRegistry.registerItem(goldjavelin, LocalizationStrings.GOLD_JAVELIN_NAME);
		GameRegistry.registerItem(diamondjavelin, LocalizationStrings.DIAMOND_JAVELIN_NAME);
		GameRegistry.registerItem(ancientJavelin, LocalizationStrings.ANCIENT_JAVELIN_NAME);
		GameRegistry.registerItem(toothDagger, "toothDagger");
		GameRegistry.registerItem(whip, LocalizationStrings.WHIP_NAME);
		GameRegistry.registerItem(legBone, LocalizationStrings.LEGBONE_NAME);
		GameRegistry.registerItem(claw, LocalizationStrings.CLAW_NAME);
		GameRegistry.registerItem(foot, LocalizationStrings.FOOT_NAME);
		GameRegistry.registerItem(skull, LocalizationStrings.SKULL_NAME);
		GameRegistry.registerItem(vertebrae, LocalizationStrings.VERTEBRAE_NAME);
		GameRegistry.registerItem(armBone, LocalizationStrings.ARM_BONE_NAME);
		GameRegistry.registerItem(dinoRibCage, LocalizationStrings.DINO_RIB_CAGE_NAME);
		GameRegistry.registerItem(brokenSapling, LocalizationStrings.BROKEN_SAPLING_NAME);
		GameRegistry.registerItem(cultivatedChickenEgg, "eggCultivatedChicken");
		GameRegistry.registerItem(dodoEgg, LocalizationStrings.DODO_EGG_NAME);
		GameRegistry.registerItem(cultivatedDodoEgg, LocalizationStrings.CULTIVATED_DODO_EGG_NAME);
		GameRegistry.registerItem(confuciusornisEgg, "eggConfuciusornis");
		GameRegistry.registerItem(cultivatedConfuciusornisEgg, "eggCultivatedConfuciusornis");
		GameRegistry.registerItem(potteryShards, LocalizationStrings.POTTERY_SHARDS);
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
		//GameRegistry.registerItem(embryoChicken, LocalizationStrings.EMBRYO_CHICKEN_NAME);
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
		GameRegistry.registerItem(confuciornisRaw, "confuciornisRaw");
		GameRegistry.registerItem(confuciornisCooked, "confuciornisCooked");
		GameRegistry.registerItem(fossilrecordBones, LocalizationStrings.FOSSIL_RECORD_NAME);
		GameRegistry.registerItem(recordNano_Anu, LocalizationStrings.FOSSIL_RECORD_NANO_ANU);
		GameRegistry.registerItem(livingCoelacanth, LocalizationStrings.LIVING_COELACANTH_NAME);
		GameRegistry.registerItem(failuresaurusFlesh, LocalizationStrings.FAILURESAURUS_FLESH_NAME);
		GameRegistry.registerItem(terrorBirdEgg, LocalizationStrings.TERROR_BIRD_EGG_NAME);
		GameRegistry.registerItem(cultivatedTerrorBirdEgg, LocalizationStrings.CULTIVATED_TERROR_BIRD_EGG_NAME);
		GameRegistry.registerItem(terrorBirdMeat, LocalizationStrings.TERROR_BIRD_MEAT);
		GameRegistry.registerItem(terrorBirdMeatCooked, LocalizationStrings.TERROR_BIRD_MEAT_COOKED);
		GameRegistry.registerItem(quaggaMeat,LocalizationStrings.QUAGGA_MEAT);
		GameRegistry.registerItem(quaggaMeatCooked,LocalizationStrings.QUAGGA_MEAT_COOKED);



		/*
		 * Registers the dinosaur dna
		 */

		for (int i = 0; i < EnumDinoType.values().length; i++) {
			GameRegistry.registerItem(EnumDinoType.values()[i].DNAItem, "dna" + EnumDinoType.values()[i].name());
		}
		GameRegistry.registerItem(dnaConfuciusornis, "dnaConfuciusornis");

		/*
		 * Registers the dinosaur eggs
		 */

		for (int i = 0; i < EnumDinoType.values().length; i++) {
			GameRegistry.registerItem(EnumDinoType.values()[i].EggItem, "egg" + EnumDinoType.values()[i].name());
		}
		/*
		 * Registers the dinosaur meat
		 */

		for (int i = 0; i < EnumDinoType.values().length; i++) {
			GameRegistry.registerItem(EnumDinoType.values()[i].DropItem, "raw" + EnumDinoType.values()[i].name());
		}      
		GameRegistry.registerItem(ancientKey, "ancientKey");
		GameRegistry.registerItem(ancientClock, "ancientClock");

		/*
		 * Registers the blocks in the mod (Many importance, much wow)
		 */
		GameRegistry.registerBlock(blockFossil, LocalizationStrings.BLOCK_FOSSIL_NAME);
		//GameRegistry.registerBlock(blockMagnolia, LocalizationStrings.BLOCK_MAGNOLIA_NAME);
		//GameRegistry.registerBlock(Limestone, LocalizationStrings.BLOCK_LIMESTONE_NAME);
		//GameRegistry.registerBlock(LimestoneBrick, LocalizationStrings.BLOCK_LIMESTONEBRICK_NAME);
		GameRegistry.registerBlock(blockSkull, LocalizationStrings.BLOCK_SKULL_NAME);
		GameRegistry.registerBlock(skullLantern, LocalizationStrings.SKULL_LANTERN_NAME);
		GameRegistry.registerBlock(blockanalyzerIdle, LocalizationStrings.BLOCK_ANALYZER_IDLE_NAME);
		GameRegistry.registerBlock(blockanalyzerActive, LocalizationStrings.BLOCK_ANALYZER_ACTIVE_NAME);
		GameRegistry.registerBlock(blockcultivateIdle, LocalizationStrings.BLOCK_CULTIVATE_IDLE_NAME);
		GameRegistry.registerBlock(blockcultivateActive, LocalizationStrings.BLOCK_CULTIVATE_ACTIVE_NAME);
		GameRegistry.registerBlock(blockSlimeTrail, LocalizationStrings.BLOCK_SLIME_TRAIL_NAME);
		GameRegistry.registerBlock(blockworktableIdle, LocalizationStrings.BLOCK_WORKTABLE_IDLE_NAME);
		GameRegistry.registerBlock(blockworktableActive, LocalizationStrings.BLOCK_WORKTABLE_ACTIVE_NAME);
		GameRegistry.registerBlock(denseSand, "denseSand");
		GameRegistry.registerBlock(strongGlass, "strongGlass");
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
	//	GameRegistry.registerBlock(sarracina, LocalizationStrings.SARRACINA_NAME);
		//.registerBlock(blockDillhoffia, LocalizationStrings.BLOCK_DILLHOFFIA_NAME);
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
		GameRegistry.registerBlock(obsidianSpikes, "obsidianSpikes");
		GameRegistry.registerBlock(figurineBlock, BlockFigurineItem.class, modid + (figurineBlock.getUnlocalizedName().substring(5)));
		GameRegistry.registerBlock(anuTotem, BlockAnuItem.class, LocalizationStrings.BLOCK_ANU_NAME);
		GameRegistry.registerBlock(anuPortal,LocalizationStrings.BLOCK_ANU_PORTAL_NAME);
		GameRegistry.registerBlock(homePortal, "homePortal");
		GameRegistry.registerBlock(anubiteStatue, BlockAnubiteItem.class, "anubiteStatue");
		GameRegistry.registerBlock(ancientChest, "ancientChest");
		GameRegistry.registerBlock(blockSifterIdle, LocalizationStrings.BLOCK_SIFTER_IDLE);
		GameRegistry.registerBlock(blockSifterActive, LocalizationStrings.BLOCK_SIFTER_ACTIVE);
		GameRegistry.registerBlock(volcanicStairs, LocalizationStrings.VOLCANIC_STAIRS);
		GameRegistry.registerBlock(volcanicSingleSlab, ItemSlabVolcanic.class, LocalizationStrings.VOLCANIC_SINGLESLAB_NAME);
		GameRegistry.registerBlock(volcanicDoubleSlab, ItemSlabVolcanic.class, LocalizationStrings.VOLCANIC_DOUBLESLAB_NAME);
		GameRegistry.registerBlock(vaseVoluteBlock, BlockVaseVoluteItem.class, modid + (vaseVoluteBlock.getUnlocalizedName().substring(5)));
		GameRegistry.registerBlock(vaseAmphoraBlock, BlockVaseAmphoraItem.class, modid + (vaseAmphoraBlock.getUnlocalizedName().substring(5)));
		GameRegistry.registerBlock(vaseKylixBlock, BlockVaseKylixItem.class, modid + (vaseKylixBlock.getUnlocalizedName().substring(5)));
		GameRegistry.registerBlock(sarcophagus, "sarcophagus");
		FossilPlants.init();
		/*
		 * Registers the mob entities 
		 */

		EntityRegistry.registerModEntity(EntityStoneboard.class, 			"StoneBoard", 			1, this, 250, Integer.MAX_VALUE, false);
		EntityRegistry.registerModEntity(EntityJavelin.class, 				"Javelin", 				2, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityAncientJavelin.class, 		"AncientJavelin", 		3, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityMLighting.class, 			"FriendlyLighting", 	4, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityFailuresaurus.class, 		"Failuresaurus", 		5, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityBones.class, 				"Bones", 				6, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityDinoEgg.class, 				"DinoEgg", 				8, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityFriendlyPigZombie.class, 	"FriendlyPigZombie", 	12, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityAnu.class, 				"PigBoss", 				13, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntitySmilodon.class, 				"Smilodon", 			22, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityMammoth.class, 				"Mammoth", 				24, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityDodo.class,           		"Dodo",             	25, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityDodoEgg.class,           	"DodoEgg",              26, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityCultivatedDodoEgg.class, 	"CultivatedDodoEgg",    27, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityCoelacanth.class, 			"Coelacanth",    		28, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityQuagga.class, 				"Quagga", 				30, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityTerrorBird.class, 			"TerrorBird", 			31, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityTerrorBirdEgg.class,         "TerrorBirdEgg",        32, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityElasmotherium.class, 		"Elasmotherium", 		33, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityAnuEffect.class, 			"AnuEffect", 			34, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityConfuciusornisEgg.class,     "ConfuciusornisEgg",    35, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityCultivatedConfuciusornisEgg.class, "CultivatedConfuciusornisEgg",36, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityConfuciusornis.class, 		"Confuciusornis",       37, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityCultivatedChickenEgg.class,  "CultivatedChickenEgg", 38, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityAnubite.class,  				"Anubite", 				39, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntitySentryPigman.class,  		"SentryPigman", 		40, this, 250, 3, true);
		EntityRegistry.registerModEntity(EntityAnuDead.class,  				"AnuDead", 				41, this, 250, 3, true);


		for (int i = 0; i < EnumDinoType.values().length; i++)
		{
			EntityRegistry.registerModEntity(EnumDinoType.values()[i].getDinoClass(), EnumDinoType.values()[i].name(), 200 + i, this, 250, 3, true);
		}

		EntityRegistry.addSpawn(EntityCoelacanth.class, 1, 2, 4, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean});
		EntityRegistry.addSpawn(EntityNautilus.class, 5, 4, 14, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.river, BiomeGenBase.ocean});

		FossilSpawnEggs.addSpawnEggs();
		// Make the dino types complete by registering the dinos items
		EnumDinoType.init();
		EnumDinoFoodMob.init();

		/*
		 * Registering world generators
		 */
	
		GameRegistry.registerWorldGenerator(new FossilGenerator(), 0);

		if(FossilOptions.Gen_Palaeoraphe)
			GameRegistry.registerWorldGenerator(new WorldGeneratorPalaeoraphe(), 0);

		if(FossilOptions.Gen_Academy)
			GameRegistry.registerWorldGenerator(new AcademyGenerator(), 0);

		if(FossilOptions.Gen_Ships)
			GameRegistry.registerWorldGenerator(new ShipWreckGenerator(), 0);

		GameRegistry.registerWorldGenerator(new WorldGenMiscStructures(), 0);

		GameRegistry.registerWorldGenerator(new TarGenerator(), 0);
		GameRegistry.registerWorldGenerator(new VolcanicRockGenerator(), 13);


		/*
		 * Broken at the moment
		 * GameRegistry.registerWorldGenerator(new WorldGenWeaponShop());
		 */

		feederRenderID = RenderingRegistry.getNextAvailableRenderId();

		NetworkRegistry.INSTANCE.registerGuiHandler(this, GH);

		/*
		 * NetworkRegistry.INSTANCE.registerChatListener(messagerHandler);
		 * TickRegistry.registerTickHandler(new RenderHUD(), Side.CLIENT);
		 */

		GameRegistry.registerTileEntity(TileEntityCultivate.class, LocalizationStrings.BLOCK_CULTIVATE_IDLE_NAME);
		GameRegistry.registerTileEntity(TileEntityAnalyzer.class, LocalizationStrings.BLOCK_ANALYZER_IDLE_NAME);
		GameRegistry.registerTileEntity(TileEntityWorktable.class, LocalizationStrings.BLOCK_WORKTABLE_IDLE_NAME);
		GameRegistry.registerTileEntity(TileEntityDrum.class, LocalizationStrings.DRUM_NAME);
		GameRegistry.registerTileEntity(TileEntityFeeder.class, LocalizationStrings.T_FEEDER_IDLE_NAME);
		GameRegistry.registerTileEntity(TileEntityTimeMachine.class, LocalizationStrings.BLOCK_TIMEMACHINE_NAME);
		GameRegistry.registerTileEntity(TileEntitySifter.class, LocalizationStrings.BLOCK_SIFTER_IDLE);
		GameRegistry.registerTileEntity(TileEntityFigurine.class, "figurineType");
		GameRegistry.registerTileEntity(TileEntityVase.class, "vaseType");
		GameRegistry.registerTileEntity(TileEntityAnuTotem.class, LocalizationStrings.BLOCK_ANU_NAME);
		GameRegistry.registerTileEntity(TileEntityAnubiteStatue.class, "Anubite_Statue");
		GameRegistry.registerTileEntity(TileEntityAncientChest.class, "Ancient_Chest");
		GameRegistry.registerTileEntity(TileEntitySarcophagus.class, "sarcophagus");

		RenderingRegistry.registerBlockHandler(2303, RenderFeeder.INSTANCE);
		proxy.registerTileEntitySpecialRenderer();
		proxy.registerRenderThings();
		FossilOreDictionary.oreRegistration();
		FossilRecipeHandler.addRecipe();
		FossilFireSupport.setFireInfo();
		
		 //GameRegistry.registerPickupHandler(new FossilPickupHandler());
		FMLCommonHandler.instance().bus().register(new EventFossilAchivements());
		 

		proxy.registerChestLoot();
		FossilAchievementHandler.loadAchievements();
		MinecraftForge.EVENT_BUS.register(new FossilToolEvent());
		MinecraftForge.EVENT_BUS.register(new FossilLivingEvent());
		MinecraftForge.EVENT_BUS.register(new FossilInteractEvent());
		
		FMLCommonHandler.instance().bus().register(new FossilConnectionEvent());
	}

	public static void ShowMessage(String var6, EntityPlayer var1) {
		if (var1 != null) {
			IChatComponent message = new ChatComponentText(var6);
			var1.addChatMessage(message);
		}
	}

	public static void Console(String var0) {
		if (DebugMode()) {
			FMLLog.log(Fossil.modid, org.apache.logging.log4j.Level.INFO, var0);
		}
	}

	public static void log(Level logLevel, String message) {
		Log.log(logLevel, message);
	}

	@Mod.EventHandler
	public void PostInit(FMLPostInitializationEvent event) {
	}

	public static boolean isDNA(Item item){
		if(item == Fossil.dnaChicken){
			return true;

		}
		if(item == Fossil.dnaCoelacanth){
			return true;

		}
		if(item == Fossil.dnaConfuciusornis){
			return true;

		}
		if(item == Fossil.dnaCow){
			return true;

		}
		if(item == Fossil.dnaDodo){
			return true;

		}
		if(item == Fossil.dnaElasmotherium){
			return true;

		}
		if(item == Fossil.dnaHorse){
			return true;

		}
		if(item == Fossil.dnaMammoth){
			return true;

		}
		if(item == Fossil.dnaPig){
			return true;

		}	
		if(item == Fossil.dnaQuagga){
			return true;

		}	
		if(item == Fossil.dnaSheep){
			return true;

		}	
		if(item == Fossil.dnaSmilodon){
			return true;

		}	
		if(item == Fossil.dnaTerrorBird){
			return true;

		}	
		else if(EnumDinoType.isDinoDNA(item)){
			return true;

		}
		return false;

	}
}
