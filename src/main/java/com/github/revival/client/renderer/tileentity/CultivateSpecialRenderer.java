package com.github.revival.client.renderer.tileentity;

import com.github.revival.client.model.BlockModel;
import com.github.revival.client.model.EmbryoGenericModel;
import com.github.revival.client.model.EmbryoPlantModel;
import com.github.revival.server.block.entity.CultivateTile;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


public class CultivateSpecialRenderer extends TileEntitySpecialRenderer {
    public static final ResourceLocation texture = new ResourceLocation("fossil:textures/blocks/cultureVat/culturevat.png");
    public static final ResourceLocation textureEmbryoBasic = new ResourceLocation("fossil:textures/blocks/cultureVat/embryo_generic.png");
    private static final ResourceLocation textureEmbryoLimbless = new ResourceLocation("fossil:textures/blocks/cultureVat/embryo_legless.png");
    private static final ResourceLocation textureEmbryoPlant = new ResourceLocation("fossil:textures/blocks/cultureVat/embryo_plant.png");
    private static final ResourceLocation textureEmbryoSpore = new ResourceLocation("fossil:textures/blocks/cultureVat/embryo_spore.png");
    private EmbryoGenericModel model;
    private EmbryoPlantModel modelPlant;

    private BlockModel modelBlock;

    public CultivateSpecialRenderer() {
        this.model = new EmbryoGenericModel();
        modelPlant = new EmbryoPlantModel();
        this.modelBlock = new BlockModel();

    }

    public void renderCultureVatAt(CultivateTile tileentity, double x, double y, double z, float f) {

        float rot = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);


        GL11.glPushMatrix();
        GL11.glTranslatef(0f, 0f, 0f);
        GL11.glTranslated((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180, 0F, 0F, 1F);
        GL11.glPushMatrix();
        if (tileentity.isActive) {

            if (tileentity.getDNAType() == 1) {
                GL11.glPushMatrix();
                GL11.glTranslatef(0, 0.5F, 0);
                GL11.glPushMatrix();
                GL11.glScalef(0.5F, 0.5F, 0.5F);
                GL11.glRotatef(rot, 0, 9, 0);
                this.bindTexture(textureEmbryoLimbless);
                model.render(0.0625F);
                GL11.glPopMatrix();
                GL11.glPopMatrix();
            } else if (tileentity.getDNAType() == 2) {
                GL11.glPushMatrix();
                GL11.glTranslatef(0, 0.5F, 0);
                GL11.glPushMatrix();
                GL11.glScalef(0.5F, 0.5F, 0.5F);
                GL11.glRotatef(rot, 0, 9, 0);
                this.bindTexture(textureEmbryoPlant);
                modelPlant.render(0.0625F);
                GL11.glPopMatrix();
                GL11.glPopMatrix();
            } else {
                GL11.glPushMatrix();
                GL11.glTranslatef(0, 0.5F, 0);
                GL11.glPushMatrix();
                GL11.glScalef(0.5F, 0.5F, 0.5F);
                GL11.glRotatef(rot, 0, 9, 0);
                this.bindTexture(textureEmbryoBasic);
                model.render(0.0625F);
                GL11.glPopMatrix();
                GL11.glPopMatrix();

            }

        }


        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glPushMatrix();
        this.bindTexture(texture);
        this.modelBlock.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
        this.renderCultureVatAt((CultivateTile) tileentity, x, y, z, f);
    }
}

//					
