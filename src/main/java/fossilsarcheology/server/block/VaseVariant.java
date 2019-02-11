package fossilsarcheology.server.block;

import fossilsarcheology.Revival;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;

public enum VaseVariant implements IStringSerializable {
    DAMAGED("damaged"),
    RESTORED("restored"),
    RED_FIGURE("red_figure"),
    BLACK_FIGURE("black_figure"),
    PORCELAIN("porcelain");

    private final String name;
    private final ResourceLocation voluteTexture;
    private final ResourceLocation amphoraTexture;
    private final ResourceLocation kylixTexture;

    VaseVariant(String name) {
        this.name = name;
        this.voluteTexture = new ResourceLocation(Revival.MODID, "textures/blocks/vases/vase_" + name + "_volute.png");
        this.amphoraTexture = new ResourceLocation(Revival.MODID, "textures/blocks/vases/vase_" + name + "_amphora.png");
        this.kylixTexture = new ResourceLocation(Revival.MODID, "textures/blocks/vases/vase_" + name + "_kylix.png");
    }

    public static VaseVariant get(int meta) {
        return values()[meta % values().length];
    }

    @Override
    public String getName() {
        return this.name;
    }

    public ResourceLocation getVoluteTexture() {
        return this.voluteTexture;
    }

    public ResourceLocation getAmphoraTexture() {
        return this.amphoraTexture;
    }

    public ResourceLocation getKylixTexture() {
        return this.kylixTexture;
    }
}
