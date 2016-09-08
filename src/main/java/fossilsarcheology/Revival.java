package fossilsarcheology;

import fossilsarcheology.server.ServerProxy;
import fossilsarcheology.server.biome.FABiomeRegistry;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.block.entity.TileEntityAnalyzer;
import fossilsarcheology.server.block.entity.TileEntityAncientChest;
import fossilsarcheology.server.block.entity.TileEntityAnuTotem;
import fossilsarcheology.server.block.entity.TileEntityAnubiteStatue;
import fossilsarcheology.server.block.entity.TileEntityCultivate;
import fossilsarcheology.server.block.entity.TileEntityDrum;
import fossilsarcheology.server.block.entity.TileEntityFigurine;
import fossilsarcheology.server.block.entity.TileEntitySarcophagus;
import fossilsarcheology.server.block.entity.TileEntitySifter;
import fossilsarcheology.server.block.entity.TileEntityTimeMachine;
import fossilsarcheology.server.block.entity.TileEntityVase;
import fossilsarcheology.server.block.entity.TileEntityWorktable;
import fossilsarcheology.server.config.FossilConfig;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.dimension.FADimensionHandler;
import fossilsarcheology.server.enchantment.FAEnchantmentRegistry;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import fossilsarcheology.server.gen.FossilGenerator;
import fossilsarcheology.server.gen.TarGenerator;
import fossilsarcheology.server.gen.VolcanicRockGenerator;
import fossilsarcheology.server.gen.WorldGenMiscStructures;
import fossilsarcheology.server.gen.WorldGeneratorPalaeoraphe;
import fossilsarcheology.server.gen.structure.AcademyGenerator;
import fossilsarcheology.server.gen.structure.ShipWreckGenerator;
import fossilsarcheology.server.handler.EventFossilAchivements;
import fossilsarcheology.server.handler.EventPlayer;
import fossilsarcheology.server.handler.FossilAchievementHandler;
import fossilsarcheology.server.handler.FossilBonemealEvent;
import fossilsarcheology.server.handler.FossilConnectionEvent;
import fossilsarcheology.server.handler.FossilEntities;
import fossilsarcheology.server.handler.FossilGuiHandler;
import fossilsarcheology.server.handler.FossilInteractEvent;
import fossilsarcheology.server.handler.FossilLivingEvent;
import fossilsarcheology.server.handler.FossilOreDictionary;
import fossilsarcheology.server.handler.FossilRecipes;
import fossilsarcheology.server.handler.FossilToolEvent;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.handler.PickupHandler;
import fossilsarcheology.server.item.FAItemRegistry;
import fossilsarcheology.server.message.MessageFoodParticles;
import fossilsarcheology.server.message.MessageHappyParticles;
import fossilsarcheology.server.message.MessageJavelinType;
import fossilsarcheology.server.message.MessageRollBall;
import fossilsarcheology.server.message.MessageSetDay;
import fossilsarcheology.server.message.MessageUpdateEgg;
import fossilsarcheology.server.message.MessageUpdateNautilus;
import fossilsarcheology.server.util.FossilFoodMappings;
import fossilsarcheology.server.util.ReleaseType;
import fossilsarcheology.server.villager.ArcheaologistProfession;
import net.ilexiconn.llibrary.server.config.Config;
import net.ilexiconn.llibrary.server.network.NetworkWrapper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import org.apache.logging.log4j.Level;

@Mod(modid = Revival.MODID, name = "Fossils and Archeology Revival", version = Revival.VERSION, dependencies = "required-after:llibrary@[" + Revival.LLIBRARY_VERSION + ",)")
public class Revival {
    public static final String MODID = "fossil";
    public static final String VERSION = "8.0.0-develop";
    public static final ReleaseType RELEASE_TYPE = ReleaseType.parseVersion(VERSION);
    public static final String LLIBRARY_VERSION = "1.5.0";

    @SidedProxy(clientSide = "fossilsarcheology.client.ClientProxy", serverSide = "fossilsarcheology.server.ServerProxy")
    public static ServerProxy PROXY;
    @Mod.Instance(MODID)
    public static Revival INSTANCE;
    @NetworkWrapper({ MessageFoodParticles.class, MessageSetDay.class, MessageJavelinType.class, MessageRollBall.class, MessageHappyParticles.class, MessageUpdateEgg.class, MessageUpdateNautilus.class })
    public static SimpleNetworkWrapper NETWORK_WRAPPER;
    @Config
    public static FossilConfig CONFIG;

    public static Object toPedia;

    public static void messagePlayer(String message, EntityPlayer player) {
        if (player != null) {
            player.addChatMessage(new TextComponentString(message));
            System.out.println(player);
        }
    }

    public static void printDebug(String message) {
        if (RELEASE_TYPE.enableDebugging()) {
            FMLLog.log(Revival.MODID, Level.INFO, message);
        }
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new FossilBonemealEvent());
        MinecraftForge.EVENT_BUS.register(new EventPlayer());
        VillagerRegistry.instance().register(new ArcheaologistProfession());
        FATabRegistry.INSTANCE.init();
        FABlockRegistry.INSTANCE.init();
        FAItemRegistry.INSTANCE.init();
        FABiomeRegistry.INSTANCE.init();
        FAEnchantmentRegistry.INSTANCE.init();

        PrehistoricEntityType.init();
        FossilOreDictionary.oreRegistration();
        FossilFoodMappings.init();

        FADimensionHandler.init();

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

        //RenderingRegistry.registerBlockHandler(2303, RenderFeeder.INSTANCE);
        PROXY.init();

        FossilRecipes.addRecipe();

        MinecraftForge.EVENT_BUS.register(new PickupHandler());
        MinecraftForge.EVENT_BUS.register(new EventFossilAchivements());

        PROXY.registerChestLoot();
        FossilAchievementHandler.loadAchievements();

        MinecraftForge.EVENT_BUS.register(new FossilToolEvent());
        MinecraftForge.EVENT_BUS.register(new FossilLivingEvent());
        MinecraftForge.EVENT_BUS.register(new FossilInteractEvent());
        MinecraftForge.EVENT_BUS.register(new FossilConnectionEvent());
    }
}
