package fossilsarcheology.client.model;

import net.minecraft.client.model.ModelRenderer;

public class ModelVaseKylix extends ModelBlockBase {
    final ModelRenderer Base;
    final ModelRenderer Body;
    final ModelRenderer Neck;
    final ModelRenderer RightLip;
    final ModelRenderer LeftLip;
    final ModelRenderer FrontLip;
    final ModelRenderer BackLip;
    final ModelRenderer NubbinL;
    final ModelRenderer NubbinR;

    public ModelVaseKylix() {
        this.textureWidth = 32;
        this.textureHeight = 32;

        this.Base = new ModelRenderer(this, 0, 27);
        this.Base.addBox(-2F, 0F, -2F, 4, 1, 4);
        this.Base.setRotationPoint(0F, 23F, 0F);
        this.Base.setTextureSize(32, 32);
        this.Base.mirror = true;
        this.setRotation(this.Base, 0F, 0F, 0F);
        this.Body = new ModelRenderer(this, 0, 19);
        this.Body.addBox(-1F, 0F, -1F, 2, 5, 2);
        this.Body.setRotationPoint(0F, 18F, 0F);
        this.Body.setTextureSize(32, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0F, 0F, 0F);
        this.Neck = new ModelRenderer(this, 0, 9);
        this.Neck.addBox(-4F, 0F, -4F, 8, 1, 8);
        this.Neck.setRotationPoint(0F, 17F, 0F);
        this.Neck.setTextureSize(32, 32);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 0F, 0F, 0F);
        this.RightLip = new ModelRenderer(this, 0, 0);
        this.RightLip.addBox(0F, 0F, -4F, 1, 1, 8);
        this.RightLip.setRotationPoint(3F, 16F, 0F);
        this.RightLip.setTextureSize(32, 32);
        this.RightLip.mirror = true;
        this.setRotation(this.RightLip, 0F, 0F, 0F);
        this.RightLip.mirror = false;
        this.LeftLip = new ModelRenderer(this, 0, 0);
        this.LeftLip.addBox(-1F, 0F, -4F, 1, 1, 8);
        this.LeftLip.setRotationPoint(-3F, 16F, 0F);
        this.LeftLip.setTextureSize(32, 32);
        this.LeftLip.mirror = true;
        this.setRotation(this.LeftLip, 0F, 0F, 0F);
        this.FrontLip = new ModelRenderer(this, 11, 0);
        this.FrontLip.addBox(-3F, 0F, -1F, 6, 1, 1);
        this.FrontLip.setRotationPoint(0F, 16F, -3F);
        this.FrontLip.setTextureSize(32, 32);
        this.FrontLip.mirror = true;
        this.setRotation(this.FrontLip, 0F, 0F, 0F);
        this.BackLip = new ModelRenderer(this, 11, 0);
        this.BackLip.addBox(-3F, 0F, 0F, 6, 1, 1);
        this.BackLip.setRotationPoint(0F, 16F, 3F);
        this.BackLip.setTextureSize(32, 32);
        this.BackLip.mirror = true;
        this.setRotation(this.BackLip, 0F, 0F, 0F);
        this.NubbinL = new ModelRenderer(this, 0, 0);
        this.NubbinL.addBox(-1F, 0F, -1F, 2, 1, 2);
        this.NubbinL.setRotationPoint(4F, 16F, 0F);
        this.NubbinL.setTextureSize(32, 32);
        this.NubbinL.mirror = true;
        this.setRotation(this.NubbinL, 0F, 0F, -0.5402259F);
        this.NubbinR = new ModelRenderer(this, 0, 0);
        this.NubbinR.addBox(-2F, 0.5F, -1F, 2, 1, 2);
        this.NubbinR.setRotationPoint(-3F, 16F, 0F);
        this.NubbinR.setTextureSize(32, 32);
        this.NubbinR.mirror = true;
        this.setRotation(this.NubbinR, 0F, 0F, 0.5402318F);
        this.NubbinR.mirror = false;
    }

    @Override
    public void render(float scale) {
        this.Base.render(scale);
        this.Body.render(scale);
        this.Neck.render(scale);
        this.RightLip.render(scale);
        this.LeftLip.render(scale);
        this.FrontLip.render(scale);
        this.BackLip.render(scale);
        this.NubbinL.render(scale);
        this.NubbinR.render(scale);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
