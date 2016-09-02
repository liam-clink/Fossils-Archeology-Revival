package fossilsarcheology.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

public class ModelCultureVat extends ModelBase {
    ModelRenderer main;
    ModelRenderer bottom;
    ModelRenderer opening;
    ModelRenderer opening1;

    public ModelCultureVat() {
        textureWidth = 64;
        textureHeight = 128;

        main = new ModelRenderer(this, 0, 0);
        main.addBox(-8F, -14F, -8F, 16, 14, 16);
        main.setRotationPoint(0F, 22F, 0F);
        main.setTextureSize(64, 128);
        main.mirror = true;
        setRotation(main, 0F, 0F, 0F);
        bottom = new ModelRenderer(this, 0, 30);
        bottom.addBox(-8F, 0F, -8F, 16, 2, 16);
        bottom.setRotationPoint(0F, 22F, 0F);
        bottom.setTextureSize(64, 128);
        bottom.mirror = true;
        setRotation(bottom, 0F, 0F, 0F);
        opening = new ModelRenderer(this, 0, 48);
        opening.addBox(-4F, 0F, -4F, 8, 0, 8);
        opening.setRotationPoint(0F, 8F, 0F);
        opening.setTextureSize(64, 128);
        opening.mirror = true;
        setRotation(opening, 0F, 0F, 0F);
        opening1 = new ModelRenderer(this, -8, 48);
        opening1.addBox(-4F, 0F, -4F, 8, 0, 8);
        opening1.setRotationPoint(0F, 8.0001F, 0F);
        opening1.setTextureSize(64, 128);
        opening1.mirror = true;
    }

    public void render(float f5) {
        GlStateManager.pushMatrix();
        opening.render(f5);
        opening1.render(f5);
        bottom.render(f5);
        main.render(f5);
        GlStateManager.popMatrix();
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

}
