package fossilsarcheology.client.render.tileentity;

import fossilsarcheology.client.model.ModelAnuTotem;
import fossilsarcheology.server.block.entity.TileEntityAnuTotem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntityAnuTotemRender extends TileEntitySpecialRenderer<TileEntityAnuTotem> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("fossil:textures/blocks/anuTotem.png");
    private static final ModelAnuTotem MODEL = new ModelAnuTotem();

    @Override
    public void renderTileEntityAt(TileEntityAnuTotem tile, double x, double y, double z, float partialTicks, int breakProgress) {
        int metadata = 0;
        if (tile.hasWorldObj()) {
            metadata = tile.getBlockMetadata();
        }
        short rotation = 0;
        if (metadata == 2) {
            rotation = 360;
        } else if (metadata == 3) {
            rotation = 180;
        } else if (metadata == 4) {
            rotation = 90;
        } else if (metadata == 5) {
            rotation = -90;
        }
        GlStateManager.pushMatrix();
        GlStateManager.translate(0f, 0f, 0f);
        GlStateManager.translate(x + 0.5F, y + 1.5F, z + 0.5F);
        GlStateManager.rotate(180, 0F, 0F, 1F);
        GlStateManager.rotate(rotation, 0.0F, -1.0F, 0.0F);
        this.bindTexture(TEXTURE);
        MODEL.renderBlock(0.0625F);
        GlStateManager.popMatrix();
    }
}
