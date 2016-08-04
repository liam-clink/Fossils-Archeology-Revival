package fossilsarcheology.client.render.tileentity;

import fossilsarcheology.client.model.ModelCultureVat;
import fossilsarcheology.client.model.ModelEmbryoGeneric;
import fossilsarcheology.client.model.ModelEmbryoPlant;
import fossilsarcheology.server.block.entity.TileEntityCultivate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntityCultivateRenderer extends TileEntitySpecialRenderer {
    public static final ResourceLocation texture = new ResourceLocation("fossil:textures/blocks/cultureVat/culturevat.png");
    public static final ResourceLocation textureEmbryoBasic = new ResourceLocation("fossil:textures/blocks/cultureVat/embryo_generic.png");
    private static final ResourceLocation textureEmbryoLimbless = new ResourceLocation("fossil:textures/blocks/cultureVat/embryo_legless.png");
    private static final ResourceLocation textureEmbryoPlant = new ResourceLocation("fossil:textures/blocks/cultureVat/embryo_plant.png");
    private static final ResourceLocation textureEmbryoSpore = new ResourceLocation("fossil:textures/blocks/cultureVat/embryo_spore.png");
    private ModelEmbryoGeneric model;
    private ModelEmbryoPlant modelPlant;
    private ModelCultureVat modelBlock;

    public TileEntityCultivateRenderer() {
        this.model = new ModelEmbryoGeneric();
        modelPlant = new ModelEmbryoPlant();
        this.modelBlock = new ModelCultureVat();

    }

    public void renderCultureVatAt(TileEntityCultivate tileentity, double x, double y, double z, float f) {

        float rot = Minecraft.getMinecraft().thePlayer.ticksExisted * 1;
        float bob = (float) (Math.sin(Minecraft.getMinecraft().thePlayer.ticksExisted * 0.1F) * 1 * 0.05F - 1 * 0.05F);

        GlStateManager.pushMatrix();
        GlStateManager.translate(0f, 0f, 0f);
        GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GlStateManager.rotate(180, 0F, 0F, 1F);
        GlStateManager.pushMatrix();
        if (tileentity.isActive) {
            if (tileentity.getDNAType() == 1) {
                GlStateManager.pushMatrix();
                GlStateManager.translate(0, 0.5F + bob, 0);
                GlStateManager.pushMatrix();
                GlStateManager.scale(0.5F, 0.5F, 0.5F);
                GlStateManager.rotate(rot, 0, 9, 0);
                this.bindTexture(textureEmbryoLimbless);
                model.render(0.0625F);
                GlStateManager.popMatrix();
                GlStateManager.popMatrix();
            } else if (tileentity.getDNAType() == 2) {
                GlStateManager.pushMatrix();
                GlStateManager.translate(0, 0.5F + bob, 0);
                GlStateManager.pushMatrix();
                GlStateManager.scale(0.5F, 0.5F, 0.5F);
                GlStateManager.rotate(rot, 0, 9, 0);
                this.bindTexture(textureEmbryoPlant);
                modelPlant.render(0.0625F);
                GlStateManager.popMatrix();
                GlStateManager.popMatrix();
            } else {
                GlStateManager.pushMatrix();
                GlStateManager.translate(0, 0.5F + bob, 0);
                GlStateManager.pushMatrix();
                GlStateManager.scale(0.5F, 0.5F, 0.5F);
                GlStateManager.rotate(rot, 0, 9, 0);
                this.bindTexture(textureEmbryoBasic);
                model.render(0.0625F);
                GlStateManager.popMatrix();
                GlStateManager.popMatrix();

            }

        }

        GlStateManager.enableBlend();
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.pushMatrix();
        this.bindTexture(texture);
        this.modelBlock.render(0.0625F);
        GlStateManager.popMatrix();
        GL11.glDisable(GL11.GL_BLEND);
        GlStateManager.popMatrix();
        GlStateManager.popMatrix();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float i1) {
        this.renderCultureVatAt((TileEntityCultivate) tileentity, pos, i1);
    }
}

//
