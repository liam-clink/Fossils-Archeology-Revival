package fossilsarcheology.server.dimension;

import fossilsarcheology.Revival;
import fossilsarcheology.server.dimension.anu.WorldProviderAnu;
import fossilsarcheology.server.dimension.treasure.WorldProviderTreasure;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class FADimensionHandler {
    public static final DimensionType ANU = DimensionType.register("anu", "_anu", Revival.CONFIG.dimensionIDDarknessLair, WorldProviderAnu.class, false);
    public static final DimensionType TREASURE = DimensionType.register("treasure", "_treasure", Revival.CONFIG.dimensionIDTreasure, WorldProviderTreasure.class, false);

    public static void init() {
        DimensionManager.registerDimension(Revival.CONFIG.dimensionIDDarknessLair, FADimensionHandler.ANU);
        DimensionManager.registerDimension(Revival.CONFIG.dimensionIDTreasure, FADimensionHandler.TREASURE);
    }
}
