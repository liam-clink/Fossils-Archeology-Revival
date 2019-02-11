package fossilsarcheology.server.compat.tinkers;

import fossilsarcheology.server.compat.thaumcraft.ThaumcraftCompat;
import net.minecraftforge.fml.common.Loader;
import slimeknights.tconstruct.library.book.TinkerBook;

public class TinkersCompatBridge {
    private static final String TC_MOD_ID = "tconstruct";

    public static void loadTinkersCompat() {
        if (Loader.isModLoaded(TC_MOD_ID)) {
            TinkersCompat.register();
        }
    }

    public static void loadTinkersPostInitCompat() {
        if (Loader.isModLoaded(TC_MOD_ID)) {
            TinkersCompat.post();
        }
    }

    public static void loadTinkersClientCompat() {
        if (Loader.isModLoaded(TC_MOD_ID)) {
            TinkersCompatClient.preInit();
        }
    }
}
