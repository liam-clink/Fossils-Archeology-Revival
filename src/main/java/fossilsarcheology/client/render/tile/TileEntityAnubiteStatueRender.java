package fossilsarcheology.client.render.tile;

import fossilsarcheology.client.model.ModelAnubite;
import fossilsarcheology.server.block.AnubiteStatueBlock;
import fossilsarcheology.server.block.entity.TileEntityAnubiteStatue;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntityAnubiteStatueRender extends TileEntitySpecialRenderer<TileEntityAnubiteStatue> {
    public static final ResourceLocation texture = new ResourceLocation("fossil:textures/model/Anubite_ancient_statue.png");
    private static final ModelAnubite modelBlock = new ModelAnubite();

    public TileEntityAnubiteStatueRender() {
    }

    public void renderTileEntityAt(TileEntityAnubiteStatue tileentity, double x, double y, double z, float f, int destroy) {
        short short1 = 0;
        if (tileentity != null && tileentity.hasWorld()) {
            int i  = tileentity.getBlockType().getStateFromMeta(tileentity.getBlockMetadata()).getValue(AnubiteStatueBlock.FACING).getHorizontalIndex();
            switch(i){
                case 0:
                    short1 = 180;
                    break;
                case 1:
                    short1 = -90;
                    break;
                case 2:
                    short1 = 0;
                    break;
                case 3:
                    short1 = 90;
            }
        }

        GL11.glPushMatrix();
        GL11.glTranslatef(0f, 0f, 0f);
        GL11.glTranslated((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180, 0F, 0F, 1F);
        GL11.glRotatef((float) short1, 0.0F, 1.0F, 0.0F);
        GL11.glPushMatrix();
        this.bindTexture(texture);
        this.modelBlock.renderBlock(0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
