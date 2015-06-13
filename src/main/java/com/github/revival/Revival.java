package com.github.revival;

import com.github.revival.client.renderer.tileentity.RenderFeeder;
import com.github.revival.common.CommonProxy;
import com.github.revival.common.ModState;
import com.github.revival.common.biome.BiomeBasic;
import com.github.revival.common.block.FABlockRegistry;
import com.github.revival.common.block.sound.FossilSoundType;
import com.github.revival.common.creativetab.FATabRegistry;
import com.github.revival.common.dimension.anu.WorldProviderAnu;
import com.github.revival.common.dimension.treasure.WorldProviderTreasure;
import com.github.revival.common.enchantment.EnchantmentArcheology;
import com.github.revival.common.enchantment.EnchantmentPaleontology;
import com.github.revival.common.entity.*;
import com.github.revival.common.entity.mob.*;
import com.github.revival.common.enums.EnumDinoFoodMob;
import com.github.revival.common.enums.EnumDinoType;
import com.github.revival.common.gen.*;
import com.github.revival.common.gen.structure.AcademyGenerator;
import com.github.revival.common.gen.structure.ShipWreckGenerator;
import com.github.revival.common.handler.*;
import com.github.revival.common.item.FAItemRegistry;
import com.github.revival.common.tileentity.*;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

import java.util.logging.Level;
import java.util.logging.Logger;

@Mod(modid = Revival.modid, name = "Fossil/Archeology", version = "${version}")

public class Revival
{
    public static final String modid = "fossil";
    public static final Logger Log = Logger.getLogger("FOSSILS");
    public static final FossilSoundType soundTypeSlime = new FossilSoundType(1.0F, 1.0F);
    public static ModState modState = ModState.DEV;
    @SidedProxy(clientSide = "com.github.revival.client.ClientProxy", serverSide = "com.github.revival.common.CommonProxy")
    public static CommonProxy proxy;
    @Instance("fossil")
    public static Revival instance;
    public static FossilGuiHandler GH = new FossilGuiHandler();
    public static com.github.revival.common.handler.FossilOptions FossilOptions;

    public static Object ToPedia;
    public static SimpleNetworkWrapper channel;

    public static int feederRenderID;

	public static Enchantment paleontology;
    public static Enchantment archeology;
    public static int e_archeologyID;
    public static int e_paleontologyID;
    public static int dimensionID_anu;
    public static int dimensionID_treasure;

	public static BiomeGenBase anuBiome;
    public static BiomeGenBase treasureBiome;
    public static ArmorMaterial bone = EnumHelper.addArmorMaterial("Bone", 25, new int[]{2, 7, 6, 2}, 15);
    public static ToolMaterial scarab = EnumHelper.addToolMaterial("Scarab", 3, 1861, 8.0F, 4.0F, 25);

	public static ToolMaterial toothDaggerMaterial = EnumHelper.addToolMaterial("toothDagger", 3, 250, 70.0F, 1.5F, 25);
    public Configuration config;

    public static boolean DebugMode()
    {
        return false;
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
            FMLLog.log(Revival.modid, org.apache.logging.log4j.Level.INFO, var0);
        }
    }

    public static void log(Level logLevel, String message)
    {
        Log.log(logLevel, message);
    }

    public static boolean isDNA(Item item)
    {
        if (item == FAItemRegistry.dnaChicken) return true;
        if (item == FAItemRegistry.dnaCoelacanth) return true;
        if (item == FAItemRegistry.dnaConfuciusornis) return true;
        if (item == FAItemRegistry.dnaCow) return true;
        if (item == FAItemRegistry.dnaDodo) return true;
        if (item == FAItemRegistry.dnaElasmotherium) return true;
        if (item == FAItemRegistry.dnaHorse) return true;
        if (item == FAItemRegistry.dnaMammoth) return true;
        if (item == FAItemRegistry.dnaPig) return true;
        if (item == FAItemRegistry.dnaQuagga) return true;
        if (item == FAItemRegistry.dnaSheep) return true;
        if (item == FAItemRegistry.dnaSmilodon) return true;
        if (item == FAItemRegistry.dnaTerrorBird) return true;
        else if (EnumDinoType.isDinoDNA(item)) return true;
        return false;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new FossilBonemealEvent());
        VillagerRegistry.instance().registerVillageTradeHandler(10, new FossilTradeHandler());
        VillagerRegistry.instance().registerVillagerId(10);
        config = new Configuration(event.getSuggestedConfigurationFile());

        try
        {
            config.load();

			e_paleontologyID = config.get(Configuration.CATEGORY_GENERAL, LocalizationStrings.ENCHANTMENT_PALEONTOLOGY, 90).getInt();
            e_archeologyID = config.get(Configuration.CATEGORY_GENERAL, LocalizationStrings.ENCHANTMENT_ARCHEOLOGY, 91).getInt();

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
            FossilOptions.DeveloperSpecials = config.get("option", "(Devs only)Allow Dev Specials", true).getBoolean(true);
            FossilOptions.CustomMainMenu = config.get("option", "Custom Main Menu", true).getBoolean(true);

            FossilOptions.TRexFeathers = config.get("toggle_scales", "Tyrannosaurus Scales", false).getBoolean(false);
            FossilOptions.DeinonychusFeathers = config.get("toggle_scales", "Deinonychus Scales", false).getBoolean(false);
            FossilOptions.GallimimusFeathers = config.get("toggle_scales", "Gallimimus Scales", false).getBoolean(false);
            FossilOptions.CompsognathusFeathers = config.get("toggle_scales", "Compsognathus Scales", false).getBoolean(false);
            FossilOptions.VelociraptorFeathers = config.get("toggle_scales", "Velociraptor Scales", false).getBoolean(false);
            FossilOptions.TriceratopsQuills = config.get("toggle_quills", "Triceratops Quills", true).getBoolean(true);

            FossilOptions.biomeIDDarknessLair = config.get("biome IDs", "Layer of Darkness ID:", 128).getInt();
            FossilOptions.biomeIDTreasure = config.get("biome IDs", "Treasure ID:", 127).getInt();
            FossilOptions.dimIDDarknessLair = config.get("dimension IDs", "Layer of Darkness ID:", -23).getInt();
            FossilOptions.dimIDTreasure = config.get("dimension IDs", "Ancient Treasure Room ID:", -34).getInt();

			FossilOptions.AllowTableEnchantments = config.get("option", "Allow Table Enchantments", true).getBoolean(true);
            FossilOptions.AllowBookEnchantments = config.get("option", "Allow Book Enchantments", true).getBoolean(true);

            ContentHelper.init(new FATabRegistry(), new FABlockRegistry(), new FAItemRegistry());
            FossilOreDictionary.oreRegistration();

        }
        catch (Exception var7)
        {
            System.out.println("Fossil Mod not loading configuration");
        }
        finally
        {
            config.save();
        }

        channel = NetworkRegistry.INSTANCE.newSimpleChannel("fossil");

        dimensionID_anu = FossilOptions.dimIDDarknessLair;
        dimensionID_treasure = FossilOptions.dimIDTreasure;

        DimensionManager.registerProviderType(dimensionID_anu, WorldProviderAnu.class, false);
        DimensionManager.registerDimension(dimensionID_anu, dimensionID_anu);
        DimensionManager.registerProviderType(dimensionID_treasure, WorldProviderTreasure.class, false);
        DimensionManager.registerDimension(dimensionID_treasure, dimensionID_treasure);

        paleontology = new EnchantmentPaleontology(e_paleontologyID, 2, EnumEnchantmentType.digger);
        archeology = new EnchantmentArcheology(e_archeologyID, 2, EnumEnchantmentType.digger);

        anuBiome = new BiomeBasic(FossilOptions.biomeIDDarknessLair, Blocks.netherrack, Blocks.netherrack, true, 0, 0).setDisableRain().setBiomeName(LocalizationStrings.BIOME_ANU).setTemperatureRainfall(0.8F, 0F).setHeight(new BiomeGenBase.Height(0F, 0F));
        treasureBiome = new BiomeBasic(FossilOptions.biomeIDTreasure, Blocks.air, Blocks.air, true, 1, 0).setDisableRain().setBiomeName(StatCollector.translateToLocal("biome.treasure.name")).setTemperatureRainfall(0.8F, 0F).setHeight(new BiomeGenBase.Height(0F, 0F));

        EntityRegistry.registerModEntity(EntityStoneboard.class, "StoneBoard", 1, this, 250, Integer.MAX_VALUE, false);
        EntityRegistry.registerModEntity(EntityJavelin.class, "Javelin", 2, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityAncientJavelin.class, "AncientJavelin", 3, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityMLighting.class, "FriendlyLighting", 4, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityFailuresaurus.class, "Failuresaurus", 5, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityBones.class, "Bones", 6, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityDinoEgg.class, "DinoEgg", 8, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityFriendlyPigZombie.class, "FriendlyPigZombie", 12, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityAnu.class, "PigBoss", 13, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntitySmilodon.class, "Smilodon", 22, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityMammoth.class, "Mammoth", 24, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityDodo.class, "Dodo", 25, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityDodoEgg.class, "DodoEgg", 26, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityCultivatedDodoEgg.class, "CultivatedDodoEgg", 27, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityCoelacanth.class, "Coelacanth", 28, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityQuagga.class, "Quagga", 30, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityTerrorBird.class, "TerrorBird", 31, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityTerrorBirdEgg.class, "TerrorBirdEgg", 32, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityElasmotherium.class, "Elasmotherium", 33, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityAnuEffect.class, "AnuEffect", 34, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityConfuciusornisEgg.class, "ConfuciusornisEgg", 35, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityCultivatedConfuciusornisEgg.class, "CultivatedConfuciusornisEgg", 36, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityConfuciusornis.class, "Confuciusornis", 37, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityCultivatedChickenEgg.class, "CultivatedChickenEgg", 38, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityAnubite.class, "Anubite", 39, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntitySentryPigman.class, "SentryPigman", 40, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityAnuDead.class, "AnuDead", 41, this, 250, 3, true);

        for (int i = 0; i < EnumDinoType.values().length; i++)
        {
            EntityRegistry.registerModEntity(EnumDinoType.values()[i].getDinoClass(), EnumDinoType.values()[i].name(), 200 + i, this, 250, 3, true);
        }

        EntityRegistry.addSpawn(EntityCoelacanth.class, 1, 2, 4, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.ocean});
        EntityRegistry.addSpawn(EntityNautilus.class, 5, 4, 14, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.river, BiomeGenBase.ocean});

        FossilSpawnEggs.addSpawnEggs();
        EnumDinoType.init();
        EnumDinoFoodMob.init();

        GameRegistry.registerWorldGenerator(new FossilGenerator(), 0);

        if (FossilOptions.Gen_Palaeoraphe) GameRegistry.registerWorldGenerator(new WorldGeneratorPalaeoraphe(), 0);
        if (FossilOptions.Gen_Academy) GameRegistry.registerWorldGenerator(new AcademyGenerator(), 0);
        if (FossilOptions.Gen_Ships) GameRegistry.registerWorldGenerator(new ShipWreckGenerator(), 0);

        GameRegistry.registerWorldGenerator(new WorldGenMiscStructures(), 0);

        GameRegistry.registerWorldGenerator(new TarGenerator(), 0);
        GameRegistry.registerWorldGenerator(new VolcanicRockGenerator(), 13);

        feederRenderID = RenderingRegistry.getNextAvailableRenderId();

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
        GameRegistry.registerTileEntity(TileEntityAnuTotem.class, LocalizationStrings.BLOCK_ANU_NAME);
        GameRegistry.registerTileEntity(TileEntityAnubiteStatue.class, "Anubite_Statue");
        GameRegistry.registerTileEntity(TileEntityAncientChest.class, "Ancient_Chest");
        GameRegistry.registerTileEntity(TileEntitySarcophagus.class, "sarcophagus");

        RenderingRegistry.registerBlockHandler(2303, RenderFeeder.INSTANCE);
        proxy.init();

        FossilRecipeHandler.addRecipe();

        FMLCommonHandler.instance().bus().register(new PickupHandler());
        FMLCommonHandler.instance().bus().register(new EventFossilAchivements());

        proxy.registerChestLoot();
        FossilAchievementHandler.loadAchievements();
        MinecraftForge.EVENT_BUS.register(new FossilToolEvent());
        MinecraftForge.EVENT_BUS.register(new FossilLivingEvent());
        MinecraftForge.EVENT_BUS.register(new FossilInteractEvent());

        FMLCommonHandler.instance().bus().register(new FossilConnectionEvent());
    }
}
