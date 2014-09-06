package mods.fossil.client.model;

import org.lwjgl.opengl.GL11;

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

public class ModelDeinonychus extends ModelDinosaurs
{
	  //fields
    ModelRenderer headpivot;
    ModelRenderer deinonychus;
	private ModelRenderer head;
	private ModelRenderer lowerJaw;
	private ModelRenderer upperJaw;
	private ModelRenderer crest;
	private ModelRenderer lowerBody;
	private ModelRenderer tail1;
	private ModelRenderer tail2;
	private ModelRenderer rightTailFeather;
	private ModelRenderer rightUpperLeg;
	private ModelRenderer rightLowerLeg;
	private ModelRenderer rightFoot;
	private ModelRenderer RightClaw;
	private ModelRenderer RightClaw2;
	private ModelRenderer leftUpperLeg;
	private ModelRenderer leftLowerLeg;
	private ModelRenderer leftFoot;
	private ModelRenderer LeftClaw1;
	private ModelRenderer LeftClaw2;
	private ModelRenderer upperBody;
	private ModelRenderer leftUpperArm;
	private ModelRenderer leftLowerArm;
	private ModelRenderer leftWing2;
	private ModelRenderer Leftarm2;
	private ModelRenderer RightArm;
	private ModelRenderer RightWing1;
	private ModelRenderer RightArm2;
	private ModelRenderer RightWing2;
	private ModelRenderer neck;
	private ModelRenderer headdummy;
	private ModelRenderer rightTalon1;
	private ModelRenderer rightTalon2;
	private ModelRenderer leftTalon1;
	private ModelRenderer leftTalon2;
	private ModelRenderer leftUpperWing;
	private ModelRenderer rightUpperArm;
	private ModelRenderer rightUpperWing;
	private ModelRenderer rightLowerArm;
	private ModelRenderer rightLowerWing;
  
  public ModelDeinonychus()
  {
	    textureWidth = 128;
	    textureHeight = 64;
	    setTextureOffset("head.head", 68, 47);
	    setTextureOffset("lowerJaw.lowerJaw", 97, 54);
	    setTextureOffset("upperJaw.upperJaw", 97, 39);
	    setTextureOffset("crest.crest", 30, 17);
	    setTextureOffset("lowerBody.lowerBody", 80, 20);
	    setTextureOffset("tail1.tail1", 86, 4);
	    setTextureOffset("tail2.tail2", 50, 5);
	    setTextureOffset("tail2.rightTailFeather", 30, 31);
	    setTextureOffset("tail2.leftTailFeather", 30, 31);
	    setTextureOffset("tail2.tail3", 62, 28);
	    setTextureOffset("rightUpperLeg.rightUpperLeg", 2, 36);
	    setTextureOffset("rightLowerLeg.rightLowerLeg", 1, 25);
	    setTextureOffset("rightFoot.rightFoot", 21, 34);
	    setTextureOffset("rightTalon1.rightTalon1", 5, 20);
	    setTextureOffset("rightTalon2.rightTalon2", 5, 16);
	    setTextureOffset("leftUpperLeg.leftUpperLeg", 2, 36);
	    setTextureOffset("leftLowerLeg.leftLowerLeg", 1, 25);
	    setTextureOffset("leftFoot.leftFoot", 21, 34);
	    setTextureOffset("leftTalon1.leftTalon1", 5, 20);
	    setTextureOffset("leftTalon2.leftTalon2", 5, 16);
	    setTextureOffset("upperBody.upperBody", 13, 48);
	    setTextureOffset("leftUpperArm.leftUpperArm", 19, 17);
	    setTextureOffset("leftUpperWing.leftUpperWing", 37, 6);
	    setTextureOffset("leftLowerArm.leftLowerArm", 15, 3);
	    setTextureOffset("leftLowerArm.leftLowerWing", 36, 3);
	    setTextureOffset("rightUpperArm.rightUpperArm", 19, 17);
	    setTextureOffset("rightUpperWing.rightUpperWing", 37, 6);
	    setTextureOffset("rightLowerArm.rightLowerArm", 15, 3);
	    setTextureOffset("rightLowerArm.rightLowerWing", 36, 3);
	    setTextureOffset("neck.neck", 46, 52);
	    
	    headpivot = new ModelRenderer(this, "headpivot");
	    headpivot.setRotationPoint(0F, 12F, -11F);
	    setRotation(headpivot, 0F, 0F, 0F);
	    headpivot.mirror = true;
	    head = new ModelRenderer(this, "head");
	    head.setRotationPoint(0F, -1F, -1F);
	    setRotation(head, 0F, 0F, 0F);
	    head.mirror = true;
	      head.addBox("head", -2.5F, -5F, -6F, 5, 6, 7);
	    lowerJaw = new ModelRenderer(this, "lowerJaw");
	    lowerJaw.setRotationPoint(0F, -0.9F, -5F);
	    setRotation(lowerJaw, 0F, 0F, 0F);
	    lowerJaw.mirror = true;
	      lowerJaw.addBox("lowerJaw", -1.5F, 0F, -7F, 3, 2, 7);
	      head.addChild(lowerJaw);
	    upperJaw = new ModelRenderer(this, "upperJaw");
	    upperJaw.setRotationPoint(0F, -5F, -4.5F);
	    setRotation(upperJaw, 0F, 0F, 0F);
	    upperJaw.mirror = true;
	      upperJaw.addBox("upperJaw", -2F, 0F, -8F, 4, 4, 8);
	      head.addChild(upperJaw);
	    crest = new ModelRenderer(this, "crest");
	    crest.setRotationPoint(0F, -2F, -2F);
	    setRotation(crest, -0.4461433F, 0F, 0F);
	    crest.mirror = true;
	      crest.addBox("crest", -0.5F, -3F, 0.5F, 1, 5, 8);
	      head.addChild(crest);
	      headpivot.addChild(head);
	    deinonychus = new ModelRenderer(this, "deinonychus");
	    deinonychus.setRotationPoint(0F, 14F, 3F);
	    setRotation(deinonychus, 0F, 0F, 0F);
	    deinonychus.mirror = true;
	    lowerBody = new ModelRenderer(this, "lowerBody");
	    lowerBody.setRotationPoint(0F, -3F, -5F);
	    setRotation(lowerBody, 0F, 0F, 0F);
	    lowerBody.mirror = true;
	      lowerBody.addBox("lowerBody", -4F, 0F, 0F, 8, 7, 10);
	    tail1 = new ModelRenderer(this, "tail1");
	    tail1.setRotationPoint(0F, 3.5F, 9F);
	    setRotation(tail1, 0F, 0F, 0F);
	    tail1.mirror = true;
	      tail1.addBox("tail1", -2F, -3F, 0F, 4, 5, 9);
	    tail2 = new ModelRenderer(this, "tail2");
	    tail2.setRotationPoint(0F, -1F, 9F);
	    setRotation(tail2, 0F, 0F, 0F);
	    tail2.mirror = true;
	      tail2.addBox("tail2", -1F, -1.5F, 0F, 2, 3, 17);
	      tail2.addBox("tail3", -0.5F, -1.1F, 17F, 1, 2, 6);
	      tail2.addBox("leftTailFeather", 0F, -0.5F, 11F, 3, 1, 14);
	      tail2.mirror = false;
	      tail2.addBox("rightTailFeather", -3F, -0.5F, 11F, 3, 1, 14);
	      tail1.addChild(tail2);
	      lowerBody.addChild(tail1);
	    rightUpperLeg = new ModelRenderer(this, "rightUpperLeg");
	    rightUpperLeg.setRotationPoint(-3F, 2F, 1.5F);
	    setRotation(rightUpperLeg, 0F, 0F, 0F);
	    rightUpperLeg.mirror = false;
	      rightUpperLeg.addBox("rightUpperLeg", -3F, 0F, -2F, 3, 6, 5);
	    rightLowerLeg = new ModelRenderer(this, "rightLowerLeg");
	    rightLowerLeg.setRotationPoint(0F, 6F, 2F);
	    setRotation(rightLowerLeg, 0F, 0F, 0F);
	    rightLowerLeg.mirror = true;
	      rightLowerLeg.addBox("rightLowerLeg", -2.1F, -0.9F, -6.5F, 2, 2, 8);
	    rightFoot = new ModelRenderer(this, "rightFoot");
	    rightFoot.setRotationPoint(0F, 1F, -5.5F);
	    setRotation(rightFoot, 0F, 0F, 0F);
	    rightFoot.mirror = true;
	      rightFoot.addBox("rightFoot", -2.6F, 0F, -4F, 3, 2, 4);
	    rightTalon1 = new ModelRenderer(this, "rightTalon1");
	    rightTalon1.setRotationPoint(0F, 0F, -1F);
	    setRotation(rightTalon1, 0F, 0F, 0F);
	    rightTalon1.mirror = true;
	      rightTalon1.addBox("rightTalon1", 0F, 0F, -3F, 1, 1, 3);
	    rightTalon2 = new ModelRenderer(this, "rightTalon2");
	    rightTalon2.setRotationPoint(1F, 1F, -3F);
	    setRotation(rightTalon2, 0F, 0F, 0F);
	    rightTalon2.mirror = true;
	      rightTalon2.addBox("rightTalon2", -1F, -1F, -1.5F, 1, 1, 2);
	      rightTalon1.addChild(rightTalon2);
	      rightFoot.addChild(rightTalon1);
	      rightLowerLeg.addChild(rightFoot);
	      rightUpperLeg.addChild(rightLowerLeg);
	      deinonychus.addChild(rightUpperLeg);
	    leftUpperLeg = new ModelRenderer(this, "leftUpperLeg");
	    leftUpperLeg.setRotationPoint(3F, 2F, 1.5F);
	    setRotation(leftUpperLeg, 0F, 0F, 0F);
	    leftUpperLeg.mirror = true;
	      leftUpperLeg.mirror = true;
	      leftUpperLeg.addBox("leftUpperLeg", 0F, 0F, -2F, 3, 6, 5);
	      leftUpperLeg.mirror = false;
	    leftLowerLeg = new ModelRenderer(this, "leftLowerLeg");
	    leftLowerLeg.setRotationPoint(0F, 6F, 2F);
	    setRotation(leftLowerLeg, 0F, 0F, 0F);
	    leftLowerLeg.mirror = true;
	      leftLowerLeg.addBox("leftLowerLeg", -0.1F, -0.9F, -6.5F, 2, 2, 8);
	    leftFoot = new ModelRenderer(this, "leftFoot");
	    leftFoot.setRotationPoint(0F, 1F, -5.5F);
	    setRotation(leftFoot, 0F, 0F, 0F);
	    leftFoot.mirror = true;
	      leftFoot.addBox("leftFoot", -0.6F, 0F, -4F, 3, 2, 4);
	    leftTalon1 = new ModelRenderer(this, "leftTalon1");
	    leftTalon1.setRotationPoint(-1F, 0F, -1F);
	    setRotation(leftTalon1, 0F, 0F, 0F);
	    leftTalon1.mirror = true;
	      leftTalon1.addBox("leftTalon1", 0F, 0F, -3F, 1, 1, 3);
	    leftTalon2 = new ModelRenderer(this, "leftTalon2");
	    leftTalon2.setRotationPoint(0F, 1F, -3F);
	    setRotation(leftTalon2, 0F, 0F, 0F);
	    leftTalon2.mirror = true;
	      leftTalon2.addBox("leftTalon2", 0F, -1F, -1.5F, 1, 1, 2);
	      leftTalon1.addChild(leftTalon2);
	      leftFoot.addChild(leftTalon1);
	      leftLowerLeg.addChild(leftFoot);
	      leftUpperLeg.addChild(leftLowerLeg);
	      deinonychus.addChild(leftUpperLeg);
	    upperBody = new ModelRenderer(this, "upperBody");
	    upperBody.setRotationPoint(1F, 0F, -5F);
	    setRotation(upperBody, 0F, 0F, 0F);
	    upperBody.mirror = true;
	      upperBody.addBox("upperBody", -4F, -3F, -6.9F, 6, 6, 7);
	    leftUpperArm = new ModelRenderer(this, "leftUpperArm");
	    leftUpperArm.setRotationPoint(2F, 1F, -4F);
	    setRotation(leftUpperArm, 0F, 0F, 0F);
	    leftUpperArm.mirror = true;
	      leftUpperArm.mirror = true;
	      leftUpperArm.addBox("leftUpperArm", 0F, -1F, -1F, 2, 5, 3);
	      leftUpperArm.mirror = false;
	    leftUpperWing = new ModelRenderer(this, "leftUpperWing");
	    leftUpperWing.setRotationPoint(0F, -2.9F, 1F);
	    setRotation(leftUpperWing, 0F, 0F, 0F);
	      leftUpperWing.addBox("leftUpperWing", 1.1F, 0F, -9F, 1, 4, 7);
	      leftUpperWing.mirror = false;
	      leftUpperArm.addChild(leftUpperWing);
	    leftLowerArm = new ModelRenderer(this, "leftLowerArm");
	    leftLowerArm.setRotationPoint(0F, 3F, 0F);
	    setRotation(leftLowerArm, 0F, 0F, 0F);
	    leftLowerArm.mirror = true;
	      leftLowerArm.mirror = true;
	      leftLowerArm.addBox("leftLowerArm", 0.1F, -1F, -7F, 2, 2, 6);
	      leftLowerArm.mirror = false;
	      leftLowerArm.addBox("leftLowerWing", 1.2F, 0F, -8F, 1, 5, 9);
	      leftUpperArm.addChild(leftLowerArm);
	      upperBody.addChild(leftUpperArm);
	    rightUpperArm = new ModelRenderer(this, "rightUpperArm");
	    rightUpperArm.setRotationPoint(-4F, 1F, -4F);
	    setRotation(rightUpperArm, 0F, 0F, 0F);
	    rightUpperArm.mirror = false;
	      rightUpperArm.addBox("rightUpperArm", -2F, -1F, -1F, 2, 5, 3);
	    rightUpperWing = new ModelRenderer(this, "rightUpperWing");
	    rightUpperWing.setRotationPoint(0F, -2.9F, 1F);
	    setRotation(rightUpperWing, 0F, 0F, 0F);
	    rightUpperWing.mirror = true;
	      rightUpperWing.addBox("rightUpperWing", -2.1F, 0F, -9F, 1, 4, 7);
	      rightUpperArm.addChild(rightUpperWing);
	    rightLowerArm = new ModelRenderer(this, "rightLowerArm");
	    rightLowerArm.setRotationPoint(0F, 3F, 0F);
	    setRotation(rightLowerArm, 0F, 0F, 0F);
	    rightLowerArm.mirror = false;
	      rightLowerArm.addBox("rightLowerArm", -1.9F, -1F, -7F, 2, 2, 6);
	      rightLowerArm.addBox("rightLowerWing", -1.8F, 0F, -8F, 1, 5, 9);
	      rightUpperArm.addChild(rightLowerArm);
	      upperBody.addChild(rightUpperArm);
	    neck = new ModelRenderer(this, "neck");
	    neck.setRotationPoint(-1F, -0.5F, -5F);
	    setRotation(neck, 0F, 0F, 0F);
	    neck.mirror = true;
	      neck.addBox("neck", -2F, -1.5F, -7F, 4, 4, 7);
	    headdummy = new ModelRenderer(this, "headdummy");
	    headdummy.setRotationPoint(0F, 3.6F, 0F);
	    setRotation(headdummy, 0F, 0F, 0F);
	    headdummy.mirror = true;
	      neck.addChild(headdummy);
	      upperBody.addChild(neck);
	      deinonychus.addChild(upperBody);
	      deinonychus.addChild(lowerBody);
	  }
  
  public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
  {
      super.render(var1, var2, var3, var4, var5, var6, var7);
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaur)var1).isModelized());

    deinonychus.render(var7);
    headpivot.render(var7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean isModelized)
  {
	  this.crest.rotateAngleX = (float)Math.toRadians(24);
	  this.head.rotateAngleX =  (float)Math.toRadians(11);
	  this.upperJaw.rotateAngleX = (float)Math.toRadians(3);
	  this.lowerJaw.rotateAngleX = (float)Math.toRadians(-5);
	  this.leftTalon1.rotateAngleX = (float)Math.toRadians(-50);
	  this.leftTalon2.rotateAngleX = (float)Math.toRadians(80);
	  this.rightTalon1.rotateAngleX = (float)Math.toRadians(-50);
	  this.rightTalon2.rotateAngleX = (float)Math.toRadians(80);
	  
	  if(!isModelized){
		  this.head.rotateAngleX = -var5 / (180F / (float)Math.PI);
          this.head.rotateAngleY = var4 / (180F / (float)Math.PI);
		  this.tail1.rotateAngleY = 0.2F * MathHelper.sin(var3 * (float)0.1F + (var2+1));
		  this.tail2.rotateAngleY = 0.1F * MathHelper.sin(var3 * (float)0.1F + var2);
	  }
	  else {
		  this.modelPose();
	  }
  }

  public void setLivingAnimations(EntityLivingBase par1EntityLiving, float par2, float par3, float par4)
  {
	  EntityDeinonychus entity = (EntityDeinonychus)par1EntityLiving;
	  
      if (!entity.isAdult() && !entity.isTeen())
      {
    	  this.upperJaw.rotationPointZ = -2.5F;
    	  this.lowerJaw.rotationPointZ = -3;
      }
      else
      {
    	  this.upperJaw.rotationPointZ = -4.5F;
    	  this.lowerJaw.rotationPointZ = -5;
      }

	  if (entity.isSitting() || entity.OrderStatus == EnumOrderType.Stay)
		  this.sitPose();
	  else
	  {
		  this.standingPose(par2, par3);


	  }
  }
  
  //////// poses ////////////
  private void modelPose(){
	  this.head.rotateAngleZ = 0;
	  this.head.rotateAngleX = 0;
	  this.head.rotateAngleY = 0;
      
	  this.rightLowerLeg.rotateAngleX = (float)Math.toRadians(65);
	  this.leftLowerLeg.rotateAngleX = (float)Math.toRadians(65);
      
      this.tail1.rotateAngleY = 0;
      this.tail2.rotateAngleY = 0;
  }
  
  private void sitPose(){
	  this.deinonychus.rotationPointY = 16;
	  this.headpivot.rotationPointY = 11;
	  this.headpivot.rotationPointZ = -11;
	  
	  this.lowerBody.rotateAngleX = (float)Math.toRadians(0);
	  this.upperBody.rotateAngleX = (float)Math.toRadians(-20);
	  this.neck.rotateAngleX = (float)Math.toRadians(-30);
	  
	  //Arms
	  this.rightUpperArm.rotateAngleX = this.leftUpperArm.rotateAngleX = (float)Math.toRadians(45);
	  this.rightLowerArm.rotateAngleX = this.leftLowerArm.rotateAngleX = 0;
	  this.rightLowerArm.rotateAngleZ = (float)Math.toRadians(45);
	  this.leftLowerArm.rotateAngleZ = -(float)Math.toRadians(45);
	  
	  //Legs
	  //this.rightLowerLeg.rotationPointY = this.leftLowerLeg.rotationPointY = -0.5F;
	  this.rightLowerLeg.rotationPointY = this.leftLowerLeg.rotationPointY = 3F;
	  this.rightLowerLeg.rotationPointZ = this.leftLowerLeg.rotationPointZ = 3.5F; 
	  
	  this.rightUpperLeg.rotateAngleX = (float)Math.toRadians(-45);
	  this.leftUpperLeg.rotateAngleX = (float)Math.toRadians(-45);
	  this.rightLowerLeg.rotateAngleX = (float)Math.toRadians(45);
	  this.leftLowerLeg.rotateAngleX = (float)Math.toRadians(45);

	  this.rightFoot.rotationPointY = this.leftFoot.rotationPointY = -1;
	  this.rightFoot.rotateAngleX = this.leftFoot.rotateAngleX = 0;
	  
	  //Tail
	  this.tail1.rotateAngleX = (float)Math.toRadians(-10);
	  this.tail2.rotateAngleX = (float)Math.toRadians(10);

  }
  
  private void standingPose(float speed, float range){
	  
	  this.deinonychus.rotationPointY = 8F;
	  this.headpivot.rotationPointY = this.deinonychus.rotationPointY - 3F;
	  this.headpivot.rotationPointZ = -11;


	  this.lowerBody.rotateAngleX = (float)Math.toRadians(-8);
	  this.upperBody.rotateAngleX = (float)Math.toRadians(5);
	  this.neck.rotateAngleX = (float)Math.toRadians(-54);
	  
	  
	  this.leftUpperArm.rotateAngleX = (float)Math.toRadians(-6);
	  this.rightUpperArm.rotateAngleX = (float)Math.toRadians(-6);
	  this.leftLowerArm.rotateAngleX = (float)Math.toRadians(45);
	  this.rightLowerArm.rotateAngleX = (float)Math.toRadians(45);
	  this.leftLowerArm.rotateAngleZ = (float)Math.toRadians(0);
	  this.rightLowerArm.rotateAngleZ = (float)Math.toRadians(0);
	  
	  this.leftUpperWing.rotateAngleX = (float)Math.toRadians(90);
	  this.rightUpperWing.rotateAngleX = (float)Math.toRadians(90);
	  
	  this.rightLowerLeg.rotationPointY = this.leftLowerLeg.rotationPointY = 6F;
	  this.rightLowerLeg.rotationPointZ = this.leftLowerLeg.rotationPointZ = 2F; 


	  this.rightLowerLeg.rotateAngleX = (float)Math.toRadians(65);
	  this.leftLowerLeg.rotateAngleX = (float)Math.toRadians(65);
	  this.rightFoot.rotateAngleX = (float)Math.toRadians(-65);
	  this.leftFoot.rotateAngleX = (float)Math.toRadians(-65);
	  
	  this.rightUpperLeg.rotateAngleX = MathHelper.cos(speed * 0.6662F + (float)Math.PI) * 1.0F * range;
      this.leftUpperLeg.rotateAngleX = MathHelper.cos(speed * 0.6662F) * 1.0F * range;
	  
	  this.tail1.rotateAngleX = (float)Math.toRadians(7);
	  this.tail2.rotateAngleX = (float)Math.toRadians(6);


	  
  }

}
