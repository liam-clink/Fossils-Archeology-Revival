package fossilsarcheology;

import fossilsarcheology.client.render.tileentity.RenderFeeder;
import fossilsarcheology.server.ModState;
import fossilsarcheology.server.ServerProxy;
import fossilsarcheology.server.biome.FABiomeRegistry;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.config.FossilConfig;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.dimension.anu.WorldProviderAnu;
import fossilsarcheology.server.dimension.treasure.WorldProviderTreasure;
import fossilsarcheology.server.enchantment.FAEnchantmentRegistry;
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.gen.structure.AcademyGenerator;
import fossilsarcheology.server.gen.structure.ShipWreckGenerator;
import fossilsarcheology.server.item.FAItemRegistry;
import fossilsarcheology.server.util.FossilFoodMappings;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import fossilsarcheology.server.block.entity.*;
import fossilsarcheology.server.gen.*;
import fossilsarcheology.server.handler.*;
import fossilsarcheology.server.message.*;
import net.ilexiconn.llibrary.server.config.Config;
import net.ilexiconn.llibrary.server.network.NetworkWrapper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.Level;

@Mod(modid = Revival.MODID, name = "Fossils and Archeology Revival", version = Revival.VERSION, dependencies = "required-after:llibrary@[" + Revival.LLIBRARY_VERSION + ",)")
public class Revival {
    public static final String MODID = "fossil";
    public static final ModState STATE = ModState.DEV;
    public static final String VERSION = "7.3.0-develop";
    public static final String LLIBRARY_VERSION = "1.3.0";

    @SidedProxy(clientSide = "fossilsarcheology.client.ClientProxy", serverSide = "fossilsarcheology.server.ServerProxy")
    public static ServerProxy PROXY;
    @Instance(MODID)
    public static Revival INSTANCE;
    @NetworkWrapper({MessageFoodParticles.class, MessageSetDay.class, MessageRollBall.class, MessageHappyParticles.class, MessageUpdateEgg.class, MessageUpdateNautilus.class})
    public static SimpleNetworkWrapper NETWORK_WRAPPER;
    @Config
    public static FossilConfig CONFIG;

    public static Object toPedia;

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
        MinecraftForge.EVENT_BUS.register(new FossilBonemealEvent());
        MinecraftForge.EVENT_BUS.register(new EventPlayer());
        VillagerRegistry.instance().registerVillageTradeHandler(CONFIG.villagerId, new FossilTradeHandler());
        VillagerRegistry.instance().registerVillagerId(CONFIG.villagerId);

        FATabRegistry.INSTANCE.init();
        FABlockRegistry.INSTANCE.init();
        FAItemRegistry.INSTANCE.init();
        FABiomeRegistry.INSTANCE.init();
        FAEnchantmentRegistry.INSTANCE.init();

        EnumPrehistoric.init();
        FossilOreDictionary.oreRegistration();
        FossilFoodMappings.init();
        DimensionManager.registerProviderType(Revival.CONFIG.dimensionIDDarknessLair, WorldProviderAnu.class, false);
        DimensionManager.registerDimension(Revival.CONFIG.dimensionIDDarknessLair, Revival.CONFIG.dimensionIDDarknessLair);
        DimensionManager.registerProviderType(Revival.CONFIG.dimensionIDTreasure, WorldProviderTreasure.class, false);
        DimensionManager.registerDimension(Revival.CONFIG.dimensionIDTreasure, Revival.CONFIG.dimensionIDTreasure);

        FossilEntities.registerEntities();
        GameRegistry.registerWorldGenerator(new FossilGenerator(), 0);

        if (Revival.CONFIG.generatePalaeoraphe) {
            GameRegistry.registerWorldGenerator(new WorldGeneratorPalaeoraphe(), 0);
        }
        if (Revival.CONFIG.generateAcademy) {
            GameRegistry.registerWorldGenerator(new AcademyGenerator(), 0);
        }
        if (Revival.CONFIG.generateShips) {
            GameRegistry.registerWorldGenerator(new ShipWreckGenerator(), 0);
        }

        GameRegistry.registerWorldGenerator(new WorldGenMiscStructures(), 0);

        GameRegistry.registerWorldGenerator(new TarGenerator(), 0);
        GameRegistry.registerWorldGenerator(new VolcanicRockGenerator(), 13);

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new FossilGuiHandler());

        GameRegistry.registerTileEntity(TileEntityCultivate.class, LocalizationStrings.BLOCK_CULTIVATE_IDLE_NAME);
        GameRegistry.registerTileEntity(TileEntityAnalyzer.class, LocalizationStrings.BLOCK_ANALYZER_IDLE_NAME);
        GameRegistry.registerTileEntity(TileEntityWorktable.class, LocalizationStrings.BLOCK_WORKTABLE_IDLE_NAME);
        GameRegistry.registerTileEntity(TileEntityDrum.class, LocalizationStrings.DRUM_NAME);
        GameRegistry.registerTileEntity(TileEntityTimeMachine.class, LocalizationStrings.BLOCK_TIMEMACHINE_NAME);
        GameRegistry.registerTileEntity(TileEntitySifter.class, LocalizationStrings.BLOCK_SIFTER_IDLE);
        GameRegistry.registerTileEntity(TileEntityFigurine.class, "figurineType");
        GameRegistry.registerTileEntity(TileEntityVase.class, "vaseType");
        GameRegistry.registerTileEntity(TileEntityAnuTotem.class, LocalizationStrings.BLOCK_ANU_NAME);
        GameRegistry.registerTileEntity(TileEntityAnubiteStatue.class, "Anubite_Statue");
        GameRegistry.registerTileEntity(TileEntityAncientChest.class, "Ancient_Chest");
        GameRegistry.registerTileEntity(TileEntitySarcophagus.class, "sarcophagus");

        RenderingRegistry.registerBlockHandler(2303, RenderFeeder.INSTANCE);
        PROXY.init();

        FossilRecipes.addRecipe();

        FMLCommonHandler.instance().bus().register(new PickupHandler());
        FMLCommonHandler.instance().bus().register(new EventFossilAchivements());

        PROXY.registerChestLoot();
        FossilAchievementHandler.loadAchievements();
        MinecraftForge.EVENT_BUS.register(new FossilToolEvent());
        MinecraftForge.EVENT_BUS.register(new FossilLivingEvent());
        MinecraftForge.EVENT_BUS.register(new FossilInteractEvent());

        FMLCommonHandler.instance().bus().register(new FossilConnectionEvent());
    }
}
