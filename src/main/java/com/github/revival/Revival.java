package com.github.revival;

import com.github.revival.client.renderer.tileentity.RenderFeeder;
import com.github.revival.server.ModState;
import com.github.revival.server.ServerProxy;
import com.github.revival.server.biome.BasicBiome;
import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.block.entity.TileEntityAnalyzer;
import com.github.revival.server.block.entity.TileEntityAncientChest;
import com.github.revival.server.block.entity.TileEntityAnuTotem;
import com.github.revival.server.block.entity.TileEntityAnubiteStatue;
import com.github.revival.server.block.entity.TileEntityCultivate;
import com.github.revival.server.block.entity.TileEntityDrum;
import com.github.revival.server.block.entity.TileEntityFeeder;
import com.github.revival.server.block.entity.TileEntityFigurine;
import com.github.revival.server.block.entity.TileEntitySarcophagus;
import com.github.revival.server.block.entity.TileEntitySifter;
import com.github.revival.server.block.entity.TileEntityTimeMachine;
import com.github.revival.server.block.entity.TileEntityVase;
import com.github.revival.server.block.entity.TileEntityWorktable;
import com.github.revival.server.block.sound.FossilSoundType;
import com.github.revival.server.config.FossilConfig;
import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.dimension.anu.WorldProviderAnu;
import com.github.revival.server.dimension.treasure.WorldProviderTreasure;
import com.github.revival.server.enchantment.ArcheologyEnchantment;
import com.github.revival.server.enchantment.PaleontologyEnchantment;
import com.github.revival.server.entity.EntityAncientJavelin;
import com.github.revival.server.entity.EntityAnuEffect;
import com.github.revival.server.entity.EntityDinoEgg;
import com.github.revival.server.entity.EntityJavelin;
import com.github.revival.server.entity.EntityMLighting;
import com.github.revival.server.entity.EntityStoneboard;
import com.github.revival.server.entity.EntityTerrorBirdEgg;
import com.github.revival.server.entity.mob.EntityAnu;
import com.github.revival.server.entity.mob.EntityAnuDead;
import com.github.revival.server.entity.mob.EntityAnubite;
import com.github.revival.server.entity.mob.EntityBones;
import com.github.revival.server.entity.mob.EntityCoelacanth;
import com.github.revival.server.entity.mob.EntityDodo;
import com.github.revival.server.entity.mob.EntityDodoEgg;
import com.github.revival.server.entity.mob.EntityElasmotherium;
import com.github.revival.server.entity.mob.EntityFailuresaurus;
import com.github.revival.server.entity.mob.EntityFriendlyPigZombie;
import com.github.revival.server.entity.mob.EntityMammoth;
import com.github.revival.server.entity.mob.EntityNautilus;
import com.github.revival.server.entity.mob.EntityQuagga;
import com.github.revival.server.entity.mob.EntitySentryPigman;
import com.github.revival.server.entity.mob.EntitySmilodon;
import com.github.revival.server.entity.mob.EntityTarSlime;
import com.github.revival.server.entity.mob.EntityTerrorBird;
import com.github.revival.server.enums.EnumDinoFoodMob;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.gen.FossilGenerator;
import com.github.revival.server.gen.TarGenerator;
import com.github.revival.server.gen.VolcanicRockGenerator;
import com.github.revival.server.gen.WorldGenMiscStructures;
import com.github.revival.server.gen.WorldGeneratorPalaeoraphe;
import com.github.revival.server.gen.structure.AcademyGenerator;
import com.github.revival.server.gen.structure.ShipWreckGenerator;
import com.github.revival.server.handler.EventFossilAchivements;
import com.github.revival.server.handler.EventPlayer;
import com.github.revival.server.handler.FossilAchievementHandler;
import com.github.revival.server.handler.FossilBonemealEvent;
import com.github.revival.server.handler.FossilConnectionEvent;
import com.github.revival.server.handler.FossilGuiHandler;
import com.github.revival.server.handler.FossilInteractEvent;
import com.github.revival.server.handler.FossilLivingEvent;
import com.github.revival.server.handler.FossilOreDictionary;
import com.github.revival.server.handler.FossilRecipes;
import com.github.revival.server.handler.FossilSpawnEggs;
import com.github.revival.server.handler.FossilToolEvent;
import com.github.revival.server.handler.FossilTradeHandler;
import com.github.revival.server.handler.LocalizationStrings;
import com.github.revival.server.handler.PickupHandler;
import com.github.revival.server.item.FAItemRegistry;
import com.github.revival.server.message.MessageFoodParticles;
import com.github.revival.server.util.FossilFoodMappings;
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
import cpw.mods.fml.relauncher.Side;
import net.ilexiconn.llibrary.server.config.ConfigHandler;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import org.apache.logging.log4j.Level;

@Mod(modid = Revival.MODID, name = "Fossils and Archeology Revival", version = Revival.VERSION, dependencies = "required-after:llibrary@[" + Revival.LLIBRARY_VERSION + ",)")
public class Revival {
    public static final String MODID = "fossil";
    public static final ModState STATE = ModState.DEV;
    public static final String VERSION = "7.3.0-develop";
    public static final String LLIBRARY_VERSION = "1.0.0";
    public static final FossilSoundType soundTypeSlime = new FossilSoundType(1.0F, 1.0F);
    @SidedProxy(clientSide = "com.github.revival.client.ClientProxy", serverSide = "com.github.revival.server.ServerProxy")
    public static ServerProxy proxy;
    @Instance(MODID)
    public static Revival instance;
    public static FossilGuiHandler guiHandler = new FossilGuiHandler();
    public static Object toPedia;
    public static int feederRenderID;
    public static Enchantment paleontology;
    public static Enchantment archeology;
    public static BiomeGenBase anuBiome;
    public static BiomeGenBase treasureBiome;
    public static ArmorMaterial bone = EnumHelper.addArmorMaterial("Bone", 25, new int[]{2, 7, 6, 2}, 15);
    public static ToolMaterial scarab = EnumHelper.addToolMaterial("Scarab", 3, 1861, 8.0F, 4.0F, 25);
    public static ToolMaterial toothDaggerMaterial = EnumHelper.addToolMaterial("toothDagger", 3, 250, 70.0F, 1.5F, 25);
    public static Material tar_material;
    public static Fluid tar_fluid;
    public Configuration config;
    public static SimpleNetworkWrapper channel;

    public static boolean enableDebugging() {
        return STATE == ModState.DEV;
    }

    public static void showMessage(String message, EntityPlayer player) {
        if (player != null) {
            player.addChatMessage(new ChatComponentText(message));
        }
    }

    public static void printDebug(String message) {
        if (enableDebugging()) {
            FMLLog.log(Revival.MODID, Level.INFO, message);
        }
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        channel = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
        channel.registerMessage(MessageFoodParticles.class, MessageFoodParticles.class, 0, Side.CLIENT);
        MinecraftForge.EVENT_BUS.register(new FossilBonemealEvent());
        MinecraftForge.EVENT_BUS.register(new EventPlayer());
        VillagerRegistry.instance().registerVillageTradeHandler(10, new FossilTradeHandler());
        VillagerRegistry.instance().registerVillagerId(10);

        ConfigHandler.INSTANCE.registerConfig(this, event.getSuggestedConfigurationFile(), new FossilConfig());
        FATabRegistry.INSTANCE.init();
        FABlockRegistry.INSTANCE.init();
        FAItemRegistry.INSTANCE.init();
        EnumPrehistoric.init();
        FossilOreDictionary.oreRegistration();
        FossilFoodMappings.init();
        DimensionManager.registerProviderType(FossilConfig.dimensionIDDarknessLair, WorldProviderAnu.class, false);
        DimensionManager.registerDimension(FossilConfig.dimensionIDDarknessLair, FossilConfig.dimensionIDDarknessLair);
        DimensionManager.registerProviderType(FossilConfig.dimensionIDTreasure, WorldProviderTreasure.class, false);
        DimensionManager.registerDimension(FossilConfig.dimensionIDTreasure, FossilConfig.dimensionIDTreasure);

        paleontology = new PaleontologyEnchantment(FossilConfig.enchantmentIDPaleontology, 2, EnumEnchantmentType.digger);
        archeology = new ArcheologyEnchantment(FossilConfig.enchantmentIDArcheology, 2, EnumEnchantmentType.digger);

        anuBiome = new BasicBiome(FossilConfig.biomeIDDarknessLair, Blocks.netherrack, Blocks.netherrack, true, 0, 0).setDisableRain().setBiomeName(LocalizationStrings.BIOME_ANU).setTemperatureRainfall(0.8F, 0F).setHeight(new BiomeGenBase.Height(0F, 0F));
        treasureBiome = new BasicBiome(FossilConfig.biomeIDTreasure, Blocks.air, Blocks.air, true, 1, 0).setDisableRain().setBiomeName(StatCollector.translateToLocal("biome.treasure.name")).setTemperatureRainfall(0.8F, 0F).setHeight(new BiomeGenBase.Height(0F, 0F));

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
        EntityRegistry.registerModEntity(EntityCoelacanth.class, "Coelacanth", 28, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityQuagga.class, "Quagga", 30, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityTerrorBird.class, "TerrorBird", 31, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityTerrorBirdEgg.class, "TerrorBirdEgg", 32, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityElasmotherium.class, "Elasmotherium", 33, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityAnuEffect.class, "AnuEffect", 34, this, 250, 5, true);
        EntityRegistry.registerModEntity(EntityAnubite.class, "Anubite", 39, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntitySentryPigman.class, "SentryPigman", 40, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityAnuDead.class, "AnuDead", 41, this, 250, 3, true);
        EntityRegistry.registerModEntity(EntityTarSlime.class, "TarSlime", 42, this, 250, 3, true);

        for (int i = 0; i < EnumPrehistoric.values().length; i++) {
            EntityRegistry.registerModEntity(EnumPrehistoric.values()[i].getDinoClass(), EnumPrehistoric.values()[i].name(), 200 + i, this, 250, 3, true);
        }

        EntityRegistry.addSpawn(EntityCoelacanth.class, 1, 2, 4, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
        EntityRegistry.addSpawn(EntityNautilus.class, 5, 4, 14, EnumCreatureType.waterCreature, BiomeGenBase.river, BiomeGenBase.ocean);

        FossilSpawnEggs.addSpawnEggs();
        EnumDinoFoodMob.init();

        GameRegistry.registerWorldGenerator(new FossilGenerator(), 0);

        if (FossilConfig.generatePalaeoraphe) {
            GameRegistry.registerWorldGenerator(new WorldGeneratorPalaeoraphe(), 0);
        }
        if (FossilConfig.generateAcademy) {
            GameRegistry.registerWorldGenerator(new AcademyGenerator(), 0);
        }
        if (FossilConfig.generateShips) {
            GameRegistry.registerWorldGenerator(new ShipWreckGenerator(), 0);
        }

        GameRegistry.registerWorldGenerator(new WorldGenMiscStructures(), 0);

        GameRegistry.registerWorldGenerator(new TarGenerator(), 0);
        GameRegistry.registerWorldGenerator(new VolcanicRockGenerator(), 13);

        feederRenderID = RenderingRegistry.getNextAvailableRenderId();

        NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);

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

        FossilRecipes.addRecipe();

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
