package fossilsarcheology;

import fossilsarcheology.server.ServerProxy;
import fossilsarcheology.server.config.FossilConfig;
import fossilsarcheology.server.util.ReleaseType;
import net.ilexiconn.llibrary.server.config.Config;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Revival.MODID, name = "Fossils and Archeology Revival", version = Revival.VERSION, dependencies = "required-after:llibrary@[" + Revival.LLIBRARY_VERSION + ",)")
public class Revival {
    public static final String MODID = "fossil";
    public static final String VERSION = "8.0.0-develop";
    public static final ReleaseType RELEASE_TYPE = ReleaseType.parseVersion(VERSION);
    public static final String LLIBRARY_VERSION = "1.7.0";

    public static final Logger LOGGER = LogManager.getLogger("fossils");

    @SidedProxy(clientSide = "fossilsarcheology.client.ClientProxy", serverSide = "fossilsarcheology.server.ServerProxy")
    public static ServerProxy PROXY;
    
    @Config
    public static FossilConfig CONFIG;

    @Mod.Instance(MODID)
    public static Revival INSTANCE;

    public static void debug(String message) {
        if (RELEASE_TYPE.enableDebugging()) {
            LOGGER.debug(message);
        }
    }

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        PROXY.onPreInit();
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        PROXY.onInit();
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        PROXY.onPostInit();
    }
}
