package fossilsarcheology.client.render.tileentity;

import fossilsarcheology.client.model.ModelSifter;
import fossilsarcheology.server.block.entity.TileEntitySifter;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntitySifterRenderer extends TileEntitySpecialRenderer {

    private static final ResourceLocation field_110638_a = new ResourceLocation("fossil:Sifter.png");
    private final ModelSifter modelSifter = new ModelSifter();
    private float yRotationAngle;
    private float speed;
    private double theta;
    private double angle;

    public TileEntitySifterRenderer() {
        yRotationAngle = 0.10F;
        speed = 0.10F;
    }

    public void renderTileEntityAt(TileEntitySifter tileentity, double x, double y, double z, float partialTickTime) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GlStateManager.rotate(180F, 1.0F, 0.0F, 1.0F);
        this.bindTexture(field_110638_a);

        this.modelSifter.sifter.rotateAngleZ = 1.57079633F;
        /*
         * if(entity.isPowered){ this.run(entity.animationOffset, 0.2F); }
		 */

        // this.modelSifter.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F,
        // 0.0625F);

        this.modelSifter.renderAll();
        GlStateManager.popMatrix();

    }

    private void run(long animationOffset, float speed) {
        long time = (System.currentTimeMillis() + animationOffset);
        double speedScale = (0.001 * 2 * Math.PI) / speed;
        this.angle = time * speedScale;
        if (this.angle <= 360) {
            this.angle -= 360;
        }

        this.modelSifter.sifter.offsetX = (float) Math.cos(this.angle) * 0.05F;
        this.modelSifter.sifter.offsetZ = (float) Math.sin(this.angle) * 0.05F;

    }

    @Override
    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
        this.renderTileEntityAt((TileEntitySifter) par1TileEntity, par2, par4, par6, par8);
    }

}
