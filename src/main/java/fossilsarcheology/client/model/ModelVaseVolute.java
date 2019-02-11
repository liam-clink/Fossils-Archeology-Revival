package fossilsarcheology.client.model;

import net.minecraft.client.model.ModelRenderer;

public class ModelVaseVolute extends ModelBlockBase {
    final ModelRenderer Base;
    final ModelRenderer Body;
    final ModelRenderer Neck;
    final ModelRenderer LipF;
    final ModelRenderer LipB;
    final ModelRenderer LipR;
    final ModelRenderer LipL;
    final ModelRenderer HandleL2;
    final ModelRenderer HandleL1;
    final ModelRenderer HandleR1;
    final ModelRenderer HandleR2;

    public ModelVaseVolute() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.Base = new ModelRenderer(this, 0, 53);
        this.Base.addBox(-5F, 0F, -5F, 10, 1, 10);
        this.Base.setRotationPoint(0F, 23F, 0F);
        this.Base.setTextureSize(64, 64);
        this.Base.mirror = true;
        this.setRotation(this.Base, 0F, 0F, 0F);
        this.Body = new ModelRenderer(this, 0, 33);
        this.Body.addBox(-6F, 0F, -6F, 12, 7, 12);
        this.Body.setRotationPoint(0F, 16F, 0F);
        this.Body.setTextureSize(64, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0F, 0F, 0F);
        this.Neck = new ModelRenderer(this, 0, 17);
        this.Neck.addBox(-5F, 0F, -5F, 10, 5, 10);
        this.Neck.setRotationPoint(0F, 11F, 0F);
        this.Neck.setTextureSize(64, 64);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 0F, 0F, 0F);
        this.LipF = new ModelRenderer(this, 0, 12);
        this.LipF.addBox(-6F, 0F, -2F, 12, 1, 3);
        this.LipF.setRotationPoint(0F, 10F, -4F);
        this.LipF.setTextureSize(64, 64);
        this.LipF.mirror = true;
        this.setRotation(this.LipF, 0F, 0F, 0F);
        this.LipB = new ModelRenderer(this, 0, 12);
        this.LipB.addBox(-6F, 0F, -1F, 12, 1, 3);
        this.LipB.setRotationPoint(0F, 10F, 4F);
        this.LipB.setTextureSize(64, 64);
        this.LipB.mirror = true;
        this.setRotation(this.LipB, 0F, 0F, 0F);
        this.LipR = new ModelRenderer(this, 0, 4);
        this.LipR.addBox(-2F, 0F, -3F, 3, 1, 6);
        this.LipR.setRotationPoint(-4F, 10F, 0F);
        this.LipR.setTextureSize(64, 64);
        this.LipR.mirror = true;
        this.setRotation(this.LipR, 0F, 0F, 0F);
        this.LipL = new ModelRenderer(this, 0, 4);
        this.LipL.addBox(-1F, 0F, -3F, 3, 1, 6);
        this.LipL.setRotationPoint(4F, 10F, 0F);
        this.LipL.setTextureSize(64, 64);
        this.LipL.mirror = true;
        this.setRotation(this.LipL, 0F, 0F, 0F);
        this.HandleL2 = new ModelRenderer(this, 41, 16);
        this.HandleL2.addBox(-2F, -2F, -1F, 2, 2, 2);
        this.HandleL2.setRotationPoint(7F, 10F, 0F);
        this.HandleL2.setTextureSize(64, 64);
        this.HandleL2.mirror = true;
        this.setRotation(this.HandleL2, 0F, 0F, 0F);
        this.HandleL1 = new ModelRenderer(this, 41, 21);
        this.HandleL1.addBox(0F, -5F, -1F, 1, 7, 2);
        this.HandleL1.setRotationPoint(6F, 15F, 0F);
        this.HandleL1.setTextureSize(64, 64);
        this.HandleL1.mirror = true;
        this.setRotation(this.HandleL1, 0F, 0F, 0F);
        this.HandleR1 = new ModelRenderer(this, 41, 21);
        this.HandleR1.addBox(-1F, -5F, -1F, 1, 7, 2);
        this.HandleR1.setRotationPoint(-6F, 15F, 0F);
        this.HandleR1.setTextureSize(64, 64);
        this.HandleR1.mirror = true;
        this.setRotation(this.HandleR1, 0F, 0F, 0F);
        this.HandleR1.mirror = false;
        this.HandleR2 = new ModelRenderer(this, 41, 16);
        this.HandleR2.addBox(0F, -2F, -1F, 2, 2, 2);
        this.HandleR2.setRotationPoint(-7F, 10F, 0F);
        this.HandleR2.setTextureSize(64, 64);
        this.HandleR2.mirror = true;
        this.setRotation(this.HandleR2, 0F, 0F, 0F);
        this.HandleR2.mirror = false;
    }

    @Override
    public void render(float scale) {
        this.Base.render(scale);
        this.Body.render(scale);
        this.Neck.render(scale);
        this.LipF.render(scale);
        this.LipB.render(scale);
        this.LipR.render(scale);
        this.LipL.render(scale);
        this.HandleL2.render(scale);
        this.HandleL1.render(scale);
        this.HandleR1.render(scale);
        this.HandleR2.render(scale);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
