package fossilsarcheology.client.render.tile;

import fossilsarcheology.client.model.ModelBlockBase;
import fossilsarcheology.server.block.VaseBlock;
import fossilsarcheology.server.block.VaseVariant;
import fossilsarcheology.server.block.entity.TileEntityVase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

import java.util.function.Function;

public class TileEntityVaseRenderer extends TileEntitySpecialRenderer<TileEntityVase> {
    private final ModelBlockBase vaseModel;
    private final Function<VaseVariant, ResourceLocation> texture;

    public TileEntityVaseRenderer(ModelBlockBase model, Function<VaseVariant, ResourceLocation> texture) {
        this.vaseModel = model;
        this.texture = texture;
    }

    @Override
    public void render(TileEntityVase te, double x, double y, double z, float scale, int destroyProgress, float alpha) {
        IBlockState state = te.getWorld().getBlockState(te.getPos());
        if (state.getBlock() instanceof VaseBlock) {
            GlStateManager.pushMatrix();
            GlStateManager.translate(x + 0.5F, y + 1.5F, z + 0.5F);
            GlStateManager.rotate(180F, 1.0F, 0.0F, 1.0F);
            this.renderBlock(state, te);
            GlStateManager.popMatrix();
        }
    }

    private void renderBlock(IBlockState state, TileEntityVase vase) {
        EnumFacing dir = vase.getVaseRotation();
        VaseVariant variant = state.getValue(VaseBlock.VARIANT);

        GlStateManager.pushMatrix();
        GlStateManager.rotate(dir.getHorizontalAngle(), 0F, 1F, 0F);

        this.bindTexture(this.texture.apply(variant));
        this.vaseModel.render(0.0625F);

        GlStateManager.popMatrix();
    }
}
