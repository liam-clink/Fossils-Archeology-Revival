package mods.fossil.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWeakTRex extends ModelBase
{
//fields
 ModelRenderer UpperBody;
 ModelRenderer LowerBody;
 ModelRenderer Arm2;
 ModelRenderer Arm1;
 ModelRenderer Thigh1;
 ModelRenderer Tail1;
 ModelRenderer Tail2;
 ModelRenderer Leg1;
 ModelRenderer Foot1;
 ModelRenderer Thigh2;
 ModelRenderer Leg2;
 ModelRenderer Foot2;
 ModelRenderer Tail3;
 ModelRenderer Head;
 ModelRenderer UpperJaw;
 ModelRenderer LowerJaw;
 ModelRenderer Neck;
 ModelRenderer UpperArm1;
 ModelRenderer UpperArm2;

public ModelWeakTRex()
{
 textureWidth = 128;
 textureHeight = 64;
 
   UpperBody = new ModelRenderer(this, 80, 0);
   UpperBody.addBox(0F, 0F, 0F, 6, 10, 10);
   UpperBody.setRotationPoint(1F, 14F, -6.5F);
   UpperBody.setTextureSize(128, 64);
   UpperBody.mirror = true;
   setRotation(UpperBody, 0.0872665F, 0F, 0F);
   LowerBody = new ModelRenderer(this, 57, 20);
   LowerBody.addBox(0F, 0F, 0F, 8, 11, 12);
   LowerBody.setRotationPoint(0F, 13F, 0F);
   LowerBody.setTextureSize(128, 64);
   LowerBody.mirror = true;
   setRotation(LowerBody, 0F, 0F, 0F);
   Arm2 = new ModelRenderer(this, 34, 33);
   Arm2.addBox(0F, 0F, 0F, 2, 2, 4);
   Arm2.setRotationPoint(-1F, 22F, -6F);
   Arm2.setTextureSize(128, 64);
   Arm2.mirror = true;
   setRotation(Arm2, 0F, 0F, 0F);
   Arm2.mirror = false;
   Arm1 = new ModelRenderer(this, 34, 33);
   Arm1.addBox(0F, 0F, 0F, 2, 2, 4);
   Arm1.setRotationPoint(7F, 22F, -6F);
   Arm1.setTextureSize(128, 64);
   Arm1.mirror = true;
   setRotation(Arm1, 0F, 0F, 0F);
   Thigh1 = new ModelRenderer(this, 0, 15);
   Thigh1.addBox(0F, 0F, 0F, 4, 8, 8);
   Thigh1.setRotationPoint(-2F, 15F, 2F);
   Thigh1.setTextureSize(128, 64);
   Thigh1.mirror = true;
   setRotation(Thigh1, 0F, 0F, 0F);
   Tail1 = new ModelRenderer(this, 36, 47);
   Tail1.addBox(0F, 0F, 0F, 6, 7, 10);
   Tail1.setRotationPoint(1F, 13.1F, 11F);
   Tail1.setTextureSize(128, 64);
   Tail1.mirror = true;
   setRotation(Tail1, -0.3616222F, 0.4972269F, 0F);
   Tail2 = new ModelRenderer(this, 74, 48);
   Tail2.addBox(0F, 0F, 0F, 4, 5, 10);
   Tail2.setRotationPoint(6F, 16.2F, 18F);
   Tail2.setTextureSize(128, 64);
   Tail2.mirror = true;
   setRotation(Tail2, -0.3626222F, 1.6273F, 0F);
   Tail2.mirror = false;
   Leg1 = new ModelRenderer(this, 0, 31);
   Leg1.addBox(0F, 0F, 0F, 2, 8, 3);
   Leg1.setRotationPoint(-2F, 20F, 10F);
   Leg1.setTextureSize(128, 64);
   Leg1.mirror = true;
   setRotation(Leg1, -1.570796F, 0F, 0F);
   Foot1 = new ModelRenderer(this, 0, 42);
   Foot1.addBox(0F, 0F, 0F, 3, 2, 8);
   Foot1.setRotationPoint(-3F, 22F, -2F);
   Foot1.setTextureSize(128, 64);
   Foot1.mirror = true;
   setRotation(Foot1, 0F, 0F, 0F);
   Thigh2 = new ModelRenderer(this, 0, 15);
   Thigh2.addBox(0F, 0F, 0F, 4, 8, 8);
   Thigh2.setRotationPoint(6F, 15F, 2F);
   Thigh2.setTextureSize(128, 64);
   Thigh2.mirror = true;
   setRotation(Thigh2, 0F, 0F, 0F);
   Thigh2.mirror = false;
   Leg2 = new ModelRenderer(this, 0, 31);
   Leg2.addBox(0F, 0F, 0F, 2, 8, 3);
   Leg2.setRotationPoint(7F, 20F, 10F);
   Leg2.setTextureSize(128, 64);
   Leg2.mirror = true;
   setRotation(Leg2, -1.570796F, 0F, 0F);
   Foot2 = new ModelRenderer(this, 0, 42);
   Foot2.addBox(0F, 0F, 0F, 3, 2, 8);
   Foot2.setRotationPoint(8F, 22F, -2F);
   Foot2.setTextureSize(128, 64);
   Foot2.mirror = true;
   setRotation(Foot2, 0F, 0F, 0F);
   Tail3 = new ModelRenderer(this, 103, 49);
   Tail3.addBox(0F, 0F, 0F, 2, 3, 8);
   Tail3.setRotationPoint(15F, 21F, 9F);
   Tail3.setTextureSize(128, 64);
   Tail3.mirror = true;
   setRotation(Tail3, 0F, -0.3616148F, 0F);
   Head = new ModelRenderer(this, 0, 0);
   Head.addBox(0F, 0F, 0F, 7, 8, 7);
   Head.setRotationPoint(0.5F, 15.5F, -17F);
   Head.setTextureSize(128, 64);
   Head.mirror = true;
   setRotation(Head, 0F, 0F, 0F);
   UpperJaw = new ModelRenderer(this, 28, 0);
   UpperJaw.addBox(0F, 0F, 0F, 5, 5, 7);
   UpperJaw.setRotationPoint(1.5F, 17F, -23F);
   UpperJaw.setTextureSize(128, 64);
   UpperJaw.mirror = true;
   setRotation(UpperJaw, 0F, 0F, 0F);
   LowerJaw = new ModelRenderer(this, 27, 12);
   LowerJaw.addBox(0F, 0F, 0F, 4, 2, 6);
   LowerJaw.setRotationPoint(2F, 21F, -22.5F);
   LowerJaw.setTextureSize(128, 64);
   LowerJaw.mirror = true;
   setRotation(LowerJaw, 0F, 0F, 0F);
   Neck = new ModelRenderer(this, 52, 0);
   Neck.addBox(0F, 0F, 0F, 5, 7, 9);
   Neck.setRotationPoint(1.5F, 16F, -12.5F);
   Neck.setTextureSize(128, 64);
   Neck.mirror = true;
   setRotation(Neck, 0.2443461F, 0F, 0F);
   UpperArm1 = new ModelRenderer(this, 34, 25);
   UpperArm1.addBox(0F, 0F, 0F, 2, 2, 5);
   UpperArm1.setRotationPoint(7F, 23F, -3.5F);
   UpperArm1.setTextureSize(128, 64);
   UpperArm1.mirror = true;
   setRotation(UpperArm1, 2.094395F, 0F, 0F);
   UpperArm2 = new ModelRenderer(this, 34, 25);
   UpperArm2.addBox(0F, 0F, 0F, 2, 2, 5);
   UpperArm2.setRotationPoint(-1F, 23F, -3.5F);
   UpperArm2.setTextureSize(128, 64);
   UpperArm2.mirror = true;
   setRotation(UpperArm2, 2.094395F, 0F, 0F);
   UpperArm2.mirror = false;
}

public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
{
 super.render(entity, f, f1, f2, f3, f4, f5);
 setRotationAngles(f, f1, f2, f3, f4, f5, entity);
 UpperBody.render(f5);
 LowerBody.render(f5);
 Arm2.render(f5);
 Arm1.render(f5);
 Thigh1.render(f5);
 Tail1.render(f5);
 Tail2.render(f5);
 Leg1.render(f5);
 Foot1.render(f5);
 Foot2.render(f5);
 Thigh2.render(f5);
 Leg2.render(f5);
 Foot1.render(f5);
 Tail3.render(f5);
 Head.render(f5);
 UpperJaw.render(f5);
 LowerJaw.render(f5);
 Neck.render(f5);
 UpperArm1.render(f5);
 UpperArm2.render(f5);
}

private void setRotation(ModelRenderer model, float x, float y, float z)
{
 model.rotateAngleX = x;
 model.rotateAngleY = y;
 model.rotateAngleZ = z;
}

}

