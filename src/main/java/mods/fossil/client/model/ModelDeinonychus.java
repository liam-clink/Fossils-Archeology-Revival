package mods.fossil.client.model;

import mods.fossil.Fossil;
import mods.fossil.entity.mob.EntityAnkylosaurus;
import mods.fossil.entity.mob.EntityDeinonychus;
import mods.fossil.entity.mob.EntityDinosaur;
import mods.fossil.entity.mob.EntityPachycephalosaurus;
import mods.fossil.fossilEnums.EnumOrderType;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelDeinonychus extends ModelBase
{
  //fields
private ModelRenderer Body;
private ModelRenderer RightLeg;
private ModelRenderer RightLowerLeg;
private ModelRenderer RightFoot;
private ModelRenderer RightClaw1;
private ModelRenderer RightClaw2;
private ModelRenderer LeftLeg;
private ModelRenderer LeftLowerLeg;
private ModelRenderer LeftUpperLeg;
private ModelRenderer LeftFoot;
private ModelRenderer LeftClaw1;
private ModelRenderer LeftClaw2;
private ModelRenderer Tail1;
private ModelRenderer Tail2;
private ModelRenderer Tail3;
private ModelRenderer RightTailFeather;
private ModelRenderer UpperBody;
private ModelRenderer LeftUpperArm;
private ModelRenderer LeftLowerArm;
private ModelRenderer Neck;
private ModelRenderer Head;
private ModelRenderer LowerJaw;
private ModelRenderer Crest;
private ModelRenderer RightUpperArm;
private ModelRenderer RightLowerArm;
private ModelRenderer UpperJaw;
  
  public ModelDeinonychus()
  {
    textureWidth = 128;
    textureHeight = 64;
    setTextureOffset("RightLeg.RightUpperLeg", 2, 36);
    setTextureOffset("RightLowerLeg.RightLowerLeg", 1, 25);
    setTextureOffset("RightFoot.RightFoot", 21, 34);
    setTextureOffset("RightClaw1.RightClaw1", 5, 20);
    setTextureOffset("RightClaw2.RightClaw2", 5, 16);
    setTextureOffset("Body.Body", 80, 20);
    setTextureOffset("LeftLeg.LeftUpperLeg", 2, 36);
    setTextureOffset("LeftLowerLeg.LeftLowerLeg", 1, 25);
    setTextureOffset("LeftFoot.LeftFoot", 21, 34);
    setTextureOffset("LeftClaw1.LeftClaw1", 5, 20);
    setTextureOffset("LeftClaw2.LeftClaw2", 5, 16);
    setTextureOffset("Tail1.Tail1", 86, 4);
    setTextureOffset("Tail2.Tail2", 50, 5);
    setTextureOffset("Tail3.Tail3", 62, 28);
    setTextureOffset("Tail3.RightTailFeather", 30, 31);
    setTextureOffset("Tail3.LeftTailFeather", 30, 31);
    setTextureOffset("UpperBody.UpperBody", 13, 48);
    setTextureOffset("LeftUpperArm.LeftUpperArm", 19, 17);
    setTextureOffset("LeftLowerArm.LeftLowerArm", 15, 3);
    setTextureOffset("LeftLowerArm.LeftWing", 36, 3);
    setTextureOffset("Neck.Neck", 46, 52);
    setTextureOffset("Head.Head", 68, 47);
    setTextureOffset("UpperJaw.UpperJaw", 97, 39);
    setTextureOffset("LowerJaw.LowerJaw", 97, 54);
    setTextureOffset("Crest.Crest", 30, 17);
    setTextureOffset("RightUpperArm.RightUpperArm", 19, 17);
    setTextureOffset("RightLowerArm.RightLowerArm", 15, 3);
    setTextureOffset("RightLowerArm.RightWing", 36, 3);
    
    Body = new ModelRenderer(this, "Body");
    Body.setRotationPoint(0F, 9.5F, 3F);
    setRotation(Body, 0F, 0F, 0F);
    RightLeg = new ModelRenderer(this, "RightLeg");
    RightLeg.setRotationPoint(-4F, 1.5F, 0.5F);
    setRotation(RightLeg, 0F, 0F, 0F);
      RightLeg.addBox("RightUpperLeg", -3F, 0F, -2.5F, 3, 6, 5);
    RightLowerLeg = new ModelRenderer(this, "RightLowerLeg");
    RightLowerLeg.setRotationPoint(-0.9F, 4F, 1.5F);
    setRotation(RightLowerLeg, 1.14355718F, 0F, 0F);
      RightLowerLeg.addBox("RightLowerLeg", -1F, 0.1F, -8F, 2, 2, 8);
    RightFoot = new ModelRenderer(this, "RightFoot");
    RightFoot.setRotationPoint(0F, 1F, -7.5F);
    setRotation(RightFoot, -1.14355718F, 0F, 0F);
      RightFoot.addBox("RightFoot", -1.5F, 0F, -4F, 3, 2, 4);
    RightClaw1 = new ModelRenderer(this, "RightClaw1");
    RightClaw1.setRotationPoint(1.5F, 1F, -2F);
    setRotation(RightClaw1, -1.04719755F, 0F, 0F);
      RightClaw1.addBox("RightClaw1", -0.5F, -0.5F, -3F, 1, 1, 3);
    RightClaw2 = new ModelRenderer(this, "RightClaw2");
    RightClaw2.setRotationPoint(0F, -0.5F, -3F);
    setRotation(RightClaw2, 1.3962634F, 0F, 0F);
      RightClaw2.addBox("RightClaw2", -0.5F, 0.0F, -2F, 1, 1, 2);
      RightClaw1.addChild(RightClaw2);
      RightFoot.addChild(RightClaw1);
      RightLowerLeg.addChild(RightFoot);
      RightLeg.addChild(RightLowerLeg);
      Body.addChild(RightLeg);
      Body.addBox("Body", -4F, -3F, -6F, 8, 7, 10);
    LeftLeg = new ModelRenderer(this, "LeftLeg");
    LeftLeg.setRotationPoint(4F, 1.5F, 0.5F);
    setRotation(LeftLeg, 0F, 0F, 0F);
    LeftLeg.mirror = true;
      LeftLeg.addBox("LeftUpperLeg", 0F, 0F, -2.5F, 3, 6, 5);
    LeftLowerLeg = new ModelRenderer(this, "LeftLowerLeg");
    LeftLowerLeg.setRotationPoint(1.1F, 4F, 1.5F);
    LeftLowerLeg.mirror = true;
    setRotation(LeftLowerLeg, 1.14355718F, 0F, 0F);
      LeftLowerLeg.addBox("LeftLowerLeg", -1F, 0.1F, -8F, 2, 2, 8);
    LeftFoot = new ModelRenderer(this, "LeftFoot");
    LeftFoot.setRotationPoint(0F, 1F, -7.5F);
    setRotation(LeftFoot, -1.14355718F, 0F, 0F);
    LeftFoot.mirror = true;
      LeftFoot.addBox("LeftFoot", -1.5F, 0F, -4F, 3, 2, 4);
    LeftClaw1 = new ModelRenderer(this, "LeftClaw1");
    LeftClaw1.setRotationPoint(-1.5F, 1F, -2F);
    setRotation(LeftClaw1, -1.04719755F, 0F, 0F);
      LeftClaw1.addBox("LeftClaw1", -0.5F, -0.5F, -3F, 1, 1, 3);
    LeftClaw2 = new ModelRenderer(this, "LeftClaw2");
    LeftClaw2.setRotationPoint(0F, -0.5F, -3F);
    setRotation(LeftClaw2, 1.3962634F, 0F, 0F);
      LeftClaw2.addBox("LeftClaw2", -0.5F, 0.0F, -2F, 1, 1, 2);
      LeftClaw1.addChild(LeftClaw2);
      LeftFoot.addChild(LeftClaw1);
      LeftLowerLeg.addChild(LeftFoot);
      LeftLeg.addChild(LeftLowerLeg);
      Body.addChild(LeftLeg);
    Tail1 = new ModelRenderer(this, "Tail1");
    Tail1.setRotationPoint(0F, -1F, 3F);
    setRotation(Tail1, -0.226177218F, 0F, 0F);
      Tail1.addBox("Tail1", -2F, -1F, 0F, 4, 5, 9);
    Tail2 = new ModelRenderer(this, "Tail2");
    Tail2.setRotationPoint(0F, 0F, 6F);
    setRotation(Tail2, -0.034906585F, 0F, 0F);
      Tail2.addBox("Tail2", -1F, 0F, 0F, 2, 3, 17);
    Tail3 = new ModelRenderer(this, "Tail3");
    Tail3.setRotationPoint(0F, 1.5F, 17F);
    setRotation(Tail3, 0F, 0F, 0F);
      Tail3.addBox("Tail3", -0.5F, -1F, 0F, 1, 2, 6);
      Tail3.addBox("RightTailFeather", -3F, -0.5F, -7F, 3, 1, 14);
      Tail3.addBox("LeftTailFeather", 0F, -0.5F, -7F, 3, 1, 14);
      Tail2.addChild(Tail3);
      Tail1.addChild(Tail2);
      Body.addChild(Tail1);
    UpperBody = new ModelRenderer(this, "UpperBody");
    UpperBody.setRotationPoint(0F, 3.5F, -6F);
    setRotation(UpperBody, -0.523598776F, 0F, 0F);
      UpperBody.addBox("UpperBody", -3F, -6F, -7F, 6, 6, 7);
    LeftUpperArm = new ModelRenderer(this, "LeftUpperArm");
    LeftUpperArm.setRotationPoint(3F, -2.5F, -3.5F);
    setRotation(LeftUpperArm, 0.174532925F, 0F, 0F);
    LeftUpperArm.mirror = true;
      LeftUpperArm.addBox("LeftUpperArm", 0F, 0F, -1.5F, 2, 5, 3);
    LeftLowerArm = new ModelRenderer(this, "LeftLowerArm");
    LeftLowerArm.setRotationPoint(0F, 3F, 0F);
    setRotation(LeftLowerArm, 0.437152618F, 0F, 0F);
    LeftLowerArm.mirror = true;
      LeftLowerArm.addBox("LeftLowerArm", -0.1F, 0F, -6F, 2, 2, 6);
      LeftLowerArm.addBox("LeftWing", 0.8F, 1F, -8F, 1, 5, 9);
      LeftUpperArm.addChild(LeftLowerArm);
      UpperBody.addChild(LeftUpperArm);
    Neck = new ModelRenderer(this, "Neck");
    Neck.setRotationPoint(0F, -3F, -7F);
    setRotation(Neck, -1.16183078F, 0F, 0F);
      Neck.addBox("Neck", -2F, -2F, -7F, 4, 4, 7);
    Head = new ModelRenderer(this, "Head");
    Head.setRotationPoint(0F, 0F, -6F);
    setRotation(Head, 0F, 0F, 0F);
      Head.addBox("Head", -2.5F, -5F, -5F, 5, 6, 7);  
    LowerJaw = new ModelRenderer(this, "LowerJaw");
    LowerJaw.setRotationPoint(0F, -1F, -4.5F);
    setRotation(LowerJaw, 0F, 0F, 0F);
      LowerJaw.addBox("LowerJaw", -1.5F, 0F, -7F, 3, 2, 7);
      Head.addChild(LowerJaw);
      UpperJaw = new ModelRenderer(this, "UpperJaw");
      UpperJaw.setRotationPoint(0F, -4.5F, -5F);
      setRotation(UpperJaw, 0.0872664626F, 0.0F, 0.0F);
        UpperJaw.addBox("UpperJaw", -2.0F, 0F, -7F, 4, 4, 8);
        Head.addChild(UpperJaw);
    Crest = new ModelRenderer(this, "Crest");
    Crest.setRotationPoint(0F, -5F, -3F);
    setRotation(Crest, 0.38468802F, 0F, 0F);
      Crest.addBox("Crest", -0.5F, 0F, 0F, 1, 5, 8);
      Head.addChild(Crest);
      Neck.addChild(Head);
      UpperBody.addChild(Neck);
    RightUpperArm = new ModelRenderer(this, "RightUpperArm");
    RightUpperArm.setRotationPoint(-3F, -2.5F, -3.5F);
    setRotation(RightUpperArm, 0.174532925F, 0F, 0F);
      RightUpperArm.addBox("RightUpperArm", -2F, 0F, -1.5F, 2, 5, 3);
    RightLowerArm = new ModelRenderer(this, "RightLowerArm");
    RightLowerArm.setRotationPoint(-1F, 3F, 0F);
    setRotation(RightLowerArm, 0.437152618F, 0F, 0F);
      RightLowerArm.addBox("RightLowerArm", -0.9F, 0F, -6F, 2, 2, 6);
      RightLowerArm.addBox("RightWing", -0.8F, 1F, -8F, 1, 5, 9);
      RightUpperArm.addChild(RightLowerArm);
      UpperBody.addChild(RightUpperArm);
      Body.addChild(UpperBody);
  }
  
  public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
  {
      super.render(var1, var2, var3, var4, var5, var6, var7);
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaur)var1).isModelized());
    Body.render(var7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean isModelized)
  {
	  this.Head.rotateAngleX =  1.68542955F;
	  
	  if(!isModelized){
	  this.Head.rotateAngleZ = var4 / (180F / (float)Math.PI);
      this.Tail1.rotateAngleY = 0.2F * MathHelper.sin(var3 * (float)0.1F + (var2+1));
      this.Tail2.rotateAngleY = 0.1F * MathHelper.sin(var3 * (float)0.1F + var2);
	  }
	  else {
		  this.modelPose();
	  }
  }

  public void setLivingAnimations(EntityLivingBase par1EntityLiving, float par2, float par3, float par4)
  {
	  EntityDeinonychus entity = (EntityDeinonychus)par1EntityLiving;

	  if (entity.isSitting() || entity.OrderStatus == EnumOrderType.Stay)
		  this.sitPose();
	  else
		  this.standingPose(par2, par3);
  }
  
  //////// poses ////////////
  private void modelPose(){
	  this.Head.rotateAngleZ = 0;
	  
      this.RightLeg.rotateAngleX = 0;
      this.LeftLeg.rotateAngleX = 0;
      
      
      this.Tail1.rotateAngleY = 0;
      this.Tail2.rotateAngleY = 0;
  }
  
  private void sitPose(){
	  this.Body.rotationPointY = 18F;
	  
	  //Arms
	  this.RightUpperArm.rotateAngleX = this.LeftUpperArm.rotateAngleX = (float)Math.toRadians(45);
	  this.RightLowerArm.rotateAngleX = this.LeftLowerArm.rotateAngleX = 0;
	  this.RightLowerArm.rotateAngleZ =  (float)Math.toRadians(45);
	  this.LeftLowerArm.rotateAngleZ = -(float)Math.toRadians(45);
	  
	  //Legs
	  this.RightLeg.rotationPointY = this.LeftLeg.rotationPointY = -0.5F;
	  this.RightLeg.rotateAngleX = (float)Math.toRadians(-45);
	  this.LeftLeg.rotateAngleX = (float)Math.toRadians(-45);
	  this.RightLowerLeg.rotateAngleX = (float)Math.toRadians(45);
	  this.LeftLowerLeg.rotateAngleX = (float)Math.toRadians(45);
	  this.RightLowerLeg.rotationPointY = this.LeftLowerLeg.rotationPointY = 2F;
	  this.RightLowerLeg.rotationPointZ = this.LeftLowerLeg.rotationPointZ = 4.5F; 
	  this.RightFoot.rotateAngleX = this.LeftFoot.rotateAngleX = 0;
	  
	  //Tail
	  this.Tail2.rotateAngleX = (float)Math.toRadians(10);
  }
  
  private void standingPose(float speed, float range){
	  this.Body.rotationPointY = 9.5F;
	  
	  
	  //Arms
	  this.RightUpperArm.rotateAngleX = this.LeftUpperArm.rotateAngleX = 0.174532925F;
	  this.RightLowerArm.rotateAngleX = this.LeftLowerArm.rotateAngleX = 0.437152618F;
	  this.RightLowerArm.rotateAngleZ = 0;
	  this.LeftLowerArm.rotateAngleZ = 0;
	  
	  //Legs
	  this.RightLeg.rotationPointY = this.LeftLeg.rotationPointY = 1.5F;
      this.RightLeg.rotateAngleX = MathHelper.cos(speed * 0.6662F + (float)Math.PI) * 1.4F * range;
      this.LeftLeg.rotateAngleX = MathHelper.cos(speed * 0.6662F) * 1.4F * range;
	  this.RightLowerLeg.rotateAngleX = 1.14355718F;
	  this.LeftLowerLeg.rotateAngleX = 1.14355718F;
	  this.RightLowerLeg.rotationPointY = this.LeftLowerLeg.rotationPointY = 4F;
	  this.RightLowerLeg.rotationPointZ = this.LeftLowerLeg.rotationPointZ = 1.5F;
	  this.RightFoot.rotateAngleX = this.LeftFoot.rotateAngleX = -1.14355718F;
	  
	  //Tail
	  this.Tail2.rotateAngleX = -0.034906585F;
	  
  }

}
