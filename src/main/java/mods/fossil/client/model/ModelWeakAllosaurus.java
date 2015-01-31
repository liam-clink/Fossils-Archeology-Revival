package mods.fossil.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWeakAllosaurus extends ModelBase
{
	  //fields
	    ModelRenderer rightCrest;
	    ModelRenderer lowerJaw;
	    ModelRenderer teeth;
	    ModelRenderer neck;
	    ModelRenderer upperBody;
	    ModelRenderer lowerBody;
	    ModelRenderer tail1;
	    ModelRenderer tail3;
	    ModelRenderer leftUpperLeg;
	    ModelRenderer rightUpperLeg;
	    ModelRenderer leftLowerLeg;
	    ModelRenderer rightLowerLeg;
	    ModelRenderer leftFoot;
	    ModelRenderer rightFoot;
	    ModelRenderer leftUpperArm;
	    ModelRenderer rightUpperArm;
	    ModelRenderer leftLowerArm;
	    ModelRenderer rightLowerArm;
	    ModelRenderer head;
	    ModelRenderer tail2;
	    ModelRenderer upperJaw;
	    ModelRenderer leftCrest;
	  
	  public ModelWeakAllosaurus()
	  {
	    textureWidth = 128;
	    textureHeight = 64;
	    
	      rightCrest = new ModelRenderer(this, 100, 0);
	      rightCrest.addBox(-0.5F, -1F, -1F, 1, 2, 2);
	      rightCrest.setRotationPoint(-1.5F, 18.3F, -9.3F);
	      rightCrest.setTextureSize(128, 64);
	      rightCrest.mirror = true;
	      setRotation(rightCrest, -0.6981317F, 0F, -0.3141593F);
	      rightCrest.mirror = false;
	      lowerJaw = new ModelRenderer(this, 80, 17);
	      lowerJaw.addBox(-1F, -1F, -5F, 2, 2, 5);
	      lowerJaw.setRotationPoint(0F, 23.3F, -10.5F);
	      lowerJaw.setTextureSize(128, 64);
	      lowerJaw.mirror = true;
	      setRotation(lowerJaw, -0.0872665F, 0F, 0F);
	      teeth = new ModelRenderer(this, 80, 10);
	      teeth.addBox(-1.5F, -0.5F, -5F, 3, 1, 5);
	      teeth.setRotationPoint(0F, 23F, -10.6F);
	      teeth.setTextureSize(128, 64);
	      teeth.mirror = true;
	      setRotation(teeth, 0F, 0F, 0F);
	      neck = new ModelRenderer(this, 100, 18);
	      neck.addBox(-1.5F, -2.5F, -8F, 3, 5, 8);
	      neck.setRotationPoint(0F, 19F, -2F);
	      neck.setTextureSize(128, 64);
	      neck.mirror = true;
	      setRotation(neck, 0.2268928F, 0F, 0F);
	      upperBody = new ModelRenderer(this, 75, 28);
	      upperBody.addBox(-2.5F, -3.5F, -7F, 5, 7, 7);
	      upperBody.setRotationPoint(0F, 19.5F, 4F);
	      upperBody.setTextureSize(128, 64);
	      upperBody.mirror = true;
	      setRotation(upperBody, 0.0523599F, 0F, 0F);
	      lowerBody = new ModelRenderer(this, 96, 41);
	      lowerBody.addBox(-3.5F, -4F, 0F, 7, 8, 7);
	      lowerBody.setRotationPoint(0F, 20F, 3F);
	      lowerBody.setTextureSize(128, 64);
	      lowerBody.mirror = true;
	      setRotation(lowerBody, 0F, 0F, 0F);
	      tail1 = new ModelRenderer(this, 67, 46);
	      tail1.addBox(-2.5F, -3F, 0F, 5, 6, 6);
	      tail1.setRotationPoint(0F, 19.5F, 9F);
	      tail1.setTextureSize(128, 64);
	      tail1.mirror = true;
	      setRotation(tail1, -0.1919862F, 0.2617994F, 0F);
	      tail3 = new ModelRenderer(this, 19, 48);
	      tail3.addBox(-1F, -1.5F, 0F, 2, 3, 10);
	      tail3.setRotationPoint(6.9F, 22.5F, 19F);
	      tail3.setTextureSize(128, 64);
	      tail3.mirror = true;
	      setRotation(tail3, 0F, 1.832596F, 0F);
	      leftUpperLeg = new ModelRenderer(this, 8, 26);
	      leftUpperLeg.addBox(0F, 0F, -2.5F, 3, 6, 5);
	      leftUpperLeg.setRotationPoint(3.4F, 18F, 8.5F);
	      leftUpperLeg.setTextureSize(128, 64);
	      leftUpperLeg.mirror = true;
	      setRotation(leftUpperLeg, 0F, 0F, 0F);
	      leftUpperLeg.mirror = false;
	      rightUpperLeg = new ModelRenderer(this, 8, 26);
	      rightUpperLeg.addBox(-3F, 0F, -2.5F, 3, 6, 5);
	      rightUpperLeg.setRotationPoint(-3.4F, 18F, 8.5F);
	      rightUpperLeg.setTextureSize(128, 64);
	      rightUpperLeg.mirror = true;
	      setRotation(rightUpperLeg, 0F, 0F, 0F);
	      leftLowerLeg = new ModelRenderer(this, 35, 26);
	      leftLowerLeg.addBox(-1F, 0F, -1F, 2, 7, 2);
	      leftLowerLeg.setRotationPoint(4.5F, 23F, 11F);
	      leftLowerLeg.setTextureSize(128, 64);
	      leftLowerLeg.mirror = true;
	      setRotation(leftLowerLeg, -1.570796F, 0F, 0F);
	      rightLowerLeg = new ModelRenderer(this, 35, 26);
	      rightLowerLeg.addBox(-1F, 0F, -1F, 2, 7, 2);
	      rightLowerLeg.setRotationPoint(-4.5F, 23F, 11F);
	      rightLowerLeg.setTextureSize(128, 64);
	      rightLowerLeg.mirror = true;
	      setRotation(rightLowerLeg, -1.570796F, 0F, 0F);
	      leftFoot = new ModelRenderer(this, 50, 23);
	      leftFoot.addBox(-1.5F, 0F, -3F, 3, 2, 4);
	      leftFoot.setRotationPoint(4.5F, 22F, 3F);
	      leftFoot.setTextureSize(128, 64);
	      leftFoot.mirror = true;
	      setRotation(leftFoot, 0F, 0F, 0F);
	      rightFoot = new ModelRenderer(this, 50, 23);
	      rightFoot.addBox(-1.5F, 0F, -3F, 3, 2, 4);
	      rightFoot.setRotationPoint(-4.5F, 22F, 3F);
	      rightFoot.setTextureSize(128, 64);
	      rightFoot.mirror = true;
	      setRotation(rightFoot, 0F, 0F, 0F);
	      leftUpperArm = new ModelRenderer(this, 10, 9);
	      leftUpperArm.addBox(0F, 0F, -1F, 2, 4, 2);
	      leftUpperArm.setRotationPoint(2.5F, 19.5F, -2.5F);
	      leftUpperArm.setTextureSize(128, 64);
	      leftUpperArm.mirror = true;
	      setRotation(leftUpperArm, 0.3346075F, 0F, 0F);
	      rightUpperArm = new ModelRenderer(this, 10, 9);
	      rightUpperArm.addBox(-2F, 0F, -1F, 2, 4, 2);
	      rightUpperArm.setRotationPoint(-2.5F, 19.5F, -2.5F);
	      rightUpperArm.setTextureSize(128, 64);
	      rightUpperArm.mirror = true;
	      setRotation(rightUpperArm, 0.3346075F, 0F, 0F);
	      leftLowerArm = new ModelRenderer(this, 20, 8);
	      leftLowerArm.addBox(-1.1F, 0F, 0F, 2, 5, 2);
	      leftLowerArm.setRotationPoint(3.5F, 22F, -0.5F);
	      leftLowerArm.setTextureSize(128, 64);
	      leftLowerArm.mirror = true;
	      setRotation(leftLowerArm, -1.570796F, 0F, 0F);
	      rightLowerArm = new ModelRenderer(this, 20, 8);
	      rightLowerArm.addBox(-0.9F, 0F, 0F, 2, 5, 2);
	      rightLowerArm.setRotationPoint(-3.5F, 22F, -0.5F);
	      rightLowerArm.setTextureSize(128, 64);
	      rightLowerArm.mirror = true;
	      setRotation(rightLowerArm, -1.570796F, 0F, 0F);
	      head = new ModelRenderer(this, 100, 6);
	      head.addBox(-2F, -3F, -4F, 4, 6, 4);
	      head.setRotationPoint(0F, 21F, -7F);
	      head.setTextureSize(128, 64);
	      head.mirror = true;
	      setRotation(head, 0F, 0F, 0F);
	      tail2 = new ModelRenderer(this, 39, 42);
	      tail2.addBox(-1.5F, -2F, 0F, 3, 4, 9);
	      tail2.setRotationPoint(1F, 20F, 14.26667F);
	      tail2.setTextureSize(128, 64);
	      tail2.mirror = true;
	      setRotation(tail2, -0.2617994F, 0.8726646F, 0F);
	      upperJaw = new ModelRenderer(this, 80, 0);
	      upperJaw.addBox(-1.5F, -2F, -5F, 3, 4, 5);
	      upperJaw.setRotationPoint(0F, 20.5F, -10.8F);
	      upperJaw.setTextureSize(128, 64);
	      upperJaw.mirror = true;
	      setRotation(upperJaw, 0F, 0F, 0F);
	      leftCrest = new ModelRenderer(this, 100, 0);
	      leftCrest.addBox(-0.5F, -1F, -1F, 1, 2, 2);
	      leftCrest.setRotationPoint(1.5F, 18.3F, -9.3F);
	      leftCrest.setTextureSize(128, 64);
	      leftCrest.mirror = true;
	      setRotation(leftCrest, -0.6981317F, 0F, 0.3141593F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    rightCrest.render(f5);
	    lowerJaw.render(f5);
	    teeth.render(f5);
	    neck.render(f5);
	    upperBody.render(f5);
	    lowerBody.render(f5);
	    tail1.render(f5);
	    tail3.render(f5);
	    leftUpperLeg.render(f5);
	    rightUpperLeg.render(f5);
	    leftLowerLeg.render(f5);
	    rightLowerLeg.render(f5);
	    leftFoot.render(f5);
	    rightFoot.render(f5);
	    leftUpperArm.render(f5);
	    rightUpperArm.render(f5);
	    leftLowerArm.render(f5);
	    rightLowerArm.render(f5);
	    head.render(f5);
	    tail2.render(f5);
	    upperJaw.render(f5);
	    leftCrest.render(f5);
	  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

}
