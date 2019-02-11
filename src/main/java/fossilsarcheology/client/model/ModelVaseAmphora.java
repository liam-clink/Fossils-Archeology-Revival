package fossilsarcheology.client.model;

import net.minecraft.client.model.ModelRenderer;

public class ModelVaseAmphora extends ModelBlockBase {

    final ModelRenderer Base;
    final ModelRenderer Body;
    final ModelRenderer Neck;
    final ModelRenderer RightHandle1;
    final ModelRenderer RightHandle2;
    final ModelRenderer LeftHandle1;
    final ModelRenderer LeftHandle2;
    final ModelRenderer RightHandle3;
    final ModelRenderer RightHandle4;
    final ModelRenderer LeftHandle3;
    final ModelRenderer LeftHandle4;
    final ModelRenderer BackLip;
    final ModelRenderer FrontLip;
    final ModelRenderer RightLip;
    final ModelRenderer LeftLip;

    public ModelVaseAmphora() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.Base = new ModelRenderer(this, 0, 0);
        this.Base.addBox(-6F, 0F, -6F, 12, 2, 12);
        this.Base.setRotationPoint(0F, 22F, 0F);
        this.Base.setTextureSize(64, 64);
        this.Base.mirror = true;
        this.setRotation(this.Base, 0F, 0F, 0F);
        this.Body = new ModelRenderer(this, 0, 16);
        this.Body.addBox(-4F, -7F, -4F, 8, 8, 8);
        this.Body.setRotationPoint(0F, 21F, 0F);
        this.Body.setTextureSize(64, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0F, 0F, 0F);
        this.Neck = new ModelRenderer(this, 0, 34);
        this.Neck.addBox(-3F, 0F, -3F, 6, 10, 6);
        this.Neck.setRotationPoint(0F, 4F, 0F);
        this.Neck.setTextureSize(64, 64);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 0F, 0F, 0F);
        this.RightHandle1 = new ModelRenderer(this, 0, 15);
        this.RightHandle1.addBox(0F, -6F, -1F, 1, 6, 2);
        this.RightHandle1.setRotationPoint(3F, 15F, 0F);
        this.RightHandle1.setTextureSize(64, 64);
        this.RightHandle1.mirror = true;
        this.setRotation(this.RightHandle1, 0F, 0F, 0.3733352F);
        this.RightHandle2 = new ModelRenderer(this, 0, 33);
        this.RightHandle2.addBox(0F, -4F, -1F, 1, 4, 2);
        this.RightHandle2.setRotationPoint(5F, 10F, 0F);
        this.RightHandle2.setTextureSize(64, 64);
        this.RightHandle2.mirror = true;
        this.setRotation(this.RightHandle2, 0F, 0F, 0F);
        this.LeftHandle1 = new ModelRenderer(this, 0, 15);
        this.LeftHandle1.mirror = true;
        this.LeftHandle1.addBox(-1F, -6F, -1F, 1, 6, 2);
        this.LeftHandle1.setRotationPoint(-3F, 15F, 0F);
        this.LeftHandle1.setTextureSize(64, 64);
        this.setRotation(this.LeftHandle1, 0F, 0F, -0.3733434F);
        this.LeftHandle2 = new ModelRenderer(this, 0, 33);
        this.LeftHandle2.mirror = true;
        this.LeftHandle2.addBox(-1F, -4F, -1F, 1, 4, 2);
        this.LeftHandle2.setRotationPoint(-5F, 10F, 0F);
        this.LeftHandle2.setTextureSize(64, 64);
        this.setRotation(this.LeftHandle2, 0F, 0F, 0F);
        this.RightHandle3 = new ModelRenderer(this, 0, 55);
        this.RightHandle3.addBox(0F, 0F, -1F, 1, 2, 2);
        this.RightHandle3.setRotationPoint(4F, 5F, 0F);
        this.RightHandle3.setTextureSize(64, 64);
        this.RightHandle3.mirror = true;
        this.setRotation(this.RightHandle3, 0F, 0F, -0.5948578F);
        this.RightHandle4 = new ModelRenderer(this, 0, 51);
        this.RightHandle4.addBox(0F, 0F, -1F, 2, 1, 2);
        this.RightHandle4.setRotationPoint(3F, 4F, 0F);
        this.RightHandle4.setTextureSize(64, 64);
        this.RightHandle4.mirror = true;
        this.setRotation(this.RightHandle4, 0F, 0F, 0.2602503F);
        this.RightHandle4.mirror = false;
        this.LeftHandle3 = new ModelRenderer(this, 0, 55);
        this.LeftHandle3.mirror = true;
        this.LeftHandle3.addBox(-1F, 0F, -1F, 1, 2, 2);
        this.LeftHandle3.setRotationPoint(-4F, 5F, 0F);
        this.LeftHandle3.setTextureSize(64, 64);
        this.setRotation(this.LeftHandle3, 0F, 0F, 0.5948606F);
        this.LeftHandle4 = new ModelRenderer(this, 0, 51);
        this.LeftHandle4.mirror = true;
        this.LeftHandle4.addBox(-2F, 0F, -1F, 2, 1, 2);
        this.LeftHandle4.setRotationPoint(-3F, 4F, 0F);
        this.LeftHandle4.setTextureSize(64, 64);
        this.setRotation(this.LeftHandle4, 0F, 0F, -0.260246F);
        this.BackLip = new ModelRenderer(this, 8, 58);
        this.BackLip.addBox(-3F, 0F, 0F, 8, 1, 2);
        this.BackLip.setRotationPoint(-1F, 3F, 2F);
        this.BackLip.setTextureSize(64, 64);
        this.BackLip.mirror = true;
        this.setRotation(this.BackLip, 0F, 0F, 0F);
        this.FrontLip = new ModelRenderer(this, 8, 58);
        this.FrontLip.addBox(-3F, 0F, -2F, 8, 1, 2);
        this.FrontLip.setRotationPoint(-1F, 3F, -2F);
        this.FrontLip.setTextureSize(64, 64);
        this.FrontLip.mirror = true;
        this.setRotation(this.FrontLip, 0F, 0F, 0F);
        this.RightLip = new ModelRenderer(this, 36, 0);
        this.RightLip.addBox(0F, 0F, -2F, 2, 1, 4);
        this.RightLip.setRotationPoint(2F, 3F, 0F);
        this.RightLip.setTextureSize(64, 64);
        this.RightLip.mirror = true;
        this.setRotation(this.RightLip, 0F, 0F, 0F);
        this.LeftLip = new ModelRenderer(this, 36, 0);
        this.LeftLip.addBox(-2F, 0F, -2F, 2, 1, 4);
        this.LeftLip.setRotationPoint(-2F, 3F, 0F);
        this.LeftLip.setTextureSize(64, 64);
        this.LeftLip.mirror = true;
        this.setRotation(this.LeftLip, 0F, 0F, 0F);
    }

    @Override
    public void render(float scale) {
        this.Base.render(scale);
        this.Body.render(scale);
        this.Neck.render(scale);
        this.RightHandle1.render(scale);
        this.RightHandle2.render(scale);
        this.LeftHandle1.render(scale);
        this.LeftHandle2.render(scale);
        this.RightHandle3.render(scale);
        this.RightHandle4.render(scale);
        this.LeftHandle3.render(scale);
        this.LeftHandle4.render(scale);
        this.BackLip.render(scale);
        this.FrontLip.render(scale);
        this.RightLip.render(scale);
        this.LeftLip.render(scale);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
