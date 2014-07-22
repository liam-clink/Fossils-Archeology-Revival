package mods.fossil.client.model;

import mods.fossil.entity.mob.EntityDinosaur;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCompsognathus extends ModelDinosaurs
{
    //fields
    ModelRenderer Neck;
    public ModelRenderer Head;
    ModelRenderer Body;
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer RightArm;
    ModelRenderer LeftArm;
    ModelRenderer LeftThigh;
    ModelRenderer RightThigh;
    ModelRenderer Tail;

    public ModelCompsognathus()
    {
        textureWidth = 64;
        textureHeight = 32;
        Neck = new ModelRenderer(this, 4, 4);
        Neck.addBox(-2F, -6F, -2F, 2, 4, 3);
        Neck.setRotationPoint(0F, 18F, -4F);
        Neck.setTextureSize(64, 32);
        Neck.mirror = true;
        setRotation(Neck, 0F, 0F, 0F);
        Head = new ModelRenderer(this, 14, 0);
        Head.addBox(-2F, -4F, -4F, 3, 3, 6);
        Head.setRotationPoint(-0.5F, 13F, -5F);
        Head.setTextureSize(64, 32);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Body = new ModelRenderer(this, 0, 19);
        Body.addBox(-3F, -4F, -3F, 4, 8, 5);
        Body.setRotationPoint(0F, 16F, 0F);
        Body.setTextureSize(64, 32);
        Body.mirror = true;
        setRotation(Body, ((float)Math.PI / 2F), 0F, 0F);
        RightLeg = new ModelRenderer(this, 38, 0);
        RightLeg.addBox(-1F, 0F, -3F, 3, 5, 3);
        RightLeg.setRotationPoint(-4F, 19F, 4F);
        RightLeg.setTextureSize(64, 32);
        RightLeg.mirror = true;
        setRotation(RightLeg, 0F, 0F, 0F);
        LeftLeg = new ModelRenderer(this, 38, 0);
        LeftLeg.addBox(-1F, 0F, -3F, 3, 5, 3);
        LeftLeg.setRotationPoint(1F, 19F, 4F);
        LeftLeg.setTextureSize(64, 32);
        LeftLeg.mirror = true;
        setRotation(LeftLeg, 0F, 0F, 0F);
        RightArm = new ModelRenderer(this, 0, 0);
        RightArm.addBox(0F, 0F, -3F, 1, 3, 1);
        RightArm.setRotationPoint(-4F, 19F, -1F);
        RightArm.setTextureSize(64, 32);
        RightArm.mirror = true;
        setRotation(RightArm, -0.5205006F, 0F, 0F);
        LeftArm = new ModelRenderer(this, 0, 0);
        LeftArm.addBox(-1F, 0F, -3F, 1, 3, 1);
        LeftArm.setRotationPoint(2F, 19F, -1F);
        LeftArm.setTextureSize(64, 32);
        LeftArm.mirror = true;
        setRotation(LeftArm, -0.5204921F, 0F, 0F);
        LeftThigh = new ModelRenderer(this, 38, 8);
        LeftThigh.addBox(0F, 0F, 0F, 1, 4, 2);
        LeftThigh.setRotationPoint(1F, 15F, 2F);
        LeftThigh.setTextureSize(64, 32);
        LeftThigh.mirror = true;
        setRotation(LeftThigh, 0F, 0F, 0F);
        RightThigh = new ModelRenderer(this, 38, 8);
        RightThigh.addBox(0F, 0F, 0F, 1, 4, 2);
        RightThigh.setRotationPoint(-4F, 15F, 2F);
        RightThigh.setTextureSize(64, 32);
        RightThigh.mirror = true;
        setRotation(RightThigh, 0F, 0F, 0F);
        Tail = new ModelRenderer(this, 18, 20);
        Tail.addBox(0F, 0F, 0F, 2, 2, 10);
        Tail.setRotationPoint(-2F, 14F, 4F);
        Tail.setTextureSize(64, 32);
        Tail.mirror = true;
        setRotation(Tail, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, ((EntityDinosaur)entity).isModelized());
        Neck.render(f5);
        Head.render(f5);
        Body.render(f5);
        RightLeg.render(f5);
        LeftLeg.render(f5);
        RightArm.render(f5);
        LeftArm.render(f5);
        LeftThigh.render(f5);
        RightThigh.render(f5);
        Tail.render(f5);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {
    	if(!var7){
	        this.Head.rotateAngleX = var5 / (180F / (float)Math.PI);
	        this.Head.rotateAngleY = var4 / (180F / (float)Math.PI);
	        this.RightThigh.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
	        this.LeftThigh.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
	        this.RightLeg.rotationPointX = this.RightThigh.rotationPointX;
	        this.RightLeg.rotationPointZ = this.RightThigh.rotationPointZ;
	        this.RightLeg.rotateAngleX = this.RightThigh.rotateAngleX;
	        this.LeftLeg.rotateAngleX = this.LeftThigh.rotateAngleX;
	        this.Tail.rotateAngleY = 0.05F * MathHelper.sin(var3 * (float)0.3F + var2);
	        this.Tail.rotateAngleX = 0.01F * MathHelper.sin(var3 * (float)0.3F + var2);
    	}
    	else {
            this.Head.rotateAngleX = 0;
            this.Head.rotateAngleY = 0;
            this.RightThigh.rotateAngleX = 0;
            this.LeftThigh.rotateAngleX = 0;
            this.RightLeg.rotationPointX = this.RightThigh.rotationPointX;;
            this.RightLeg.rotationPointZ = this.RightThigh.rotationPointZ;;
            this.RightLeg.rotateAngleX = 0;
            this.LeftLeg.rotateAngleX = 0;
            this.Tail.rotateAngleY = 0;
            this.Tail.rotateAngleX = 0;
    	}
    }
}
