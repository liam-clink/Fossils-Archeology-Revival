package mods.fossil.client.model;

import mods.fossil.entity.mob.EntityDeinonychus;
import mods.fossil.entity.mob.EntityDinosaur;
import mods.fossil.entity.mob.EntityVelociraptor;
import mods.fossil.fossilEnums.EnumOrderType;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelVelociraptor extends ModelDinosaurs
{
	  //fields
	    ModelRenderer headpivot;
	    ModelRenderer velociraptor;
		private ModelRenderer head;
		private ModelRenderer lowerCrest;
		private ModelRenderer upperCrest;
		private ModelRenderer lowerJaw;
		private ModelRenderer upperJaw;
		private ModelRenderer lowerBody;
		private ModelRenderer leftUpperArm;
		private ModelRenderer upperBody;
		private ModelRenderer leftLowerArm;
		private ModelRenderer leftLowerWing;
		private ModelRenderer leftUpperWing;
		private ModelRenderer rightUpperArm;
		private ModelRenderer rightLowerArm;
		private ModelRenderer rightLowerWing;
		private ModelRenderer rightUpperWing;
		private ModelRenderer neck;
		private ModelRenderer headdummy;
		private ModelRenderer tail1;
		private ModelRenderer tail2;
		private ModelRenderer tail3;
		private ModelRenderer rightTailFeather3;
		private ModelRenderer leftTailFeather3;
		private ModelRenderer rightTailFeather2;
		private ModelRenderer leftTailFeather2;
		private ModelRenderer rightTailFeather1;
		private ModelRenderer leftTailFeather1;
		private ModelRenderer rightUpperLeg;
		private ModelRenderer rightLowerLeg;
		private ModelRenderer rightFoot;
		private ModelRenderer rightTalon1;
		private ModelRenderer rightTalon2;
		private ModelRenderer leftUpperLeg;
		private ModelRenderer leftLowerLeg;
		private ModelRenderer leftFoot;
		private ModelRenderer leftTalon1;
		private ModelRenderer leftTalon2;
	  
	  public ModelVelociraptor()
	  {
	    textureWidth = 128;
	    textureHeight = 64;
	    setTextureOffset("head.head", 0, 0);
	    setTextureOffset("lowerCrest.lowerCrest", 28, 10);
	    setTextureOffset("upperCrest.upperCrest", 28, 10);
	    setTextureOffset("lowerJaw.lowerJaw", 50, 0);
	    setTextureOffset("upperJaw.upperJaw", 28, 0);
	    setTextureOffset("lowerBody.lowerBody", 67, 11);
	    setTextureOffset("upperBody.upperBody", 68, 0);
	    setTextureOffset("leftUpperArm.leftUpperArm", 20, 15);
	    setTextureOffset("leftUpperWing.leftUpperWing", 20, 28);
	    setTextureOffset("leftLowerArm.leftLowerArm", 20, 22);
	    setTextureOffset("leftLowerWing.leftLowerWing", 20, 28);
	    setTextureOffset("rightUpperArm.rightUpperArm", 20, 15);
	    setTextureOffset("rightLowerArm.rightLowerArm", 20, 22);
	    setTextureOffset("rightLowerWing.rightLowerWing", 20, 28);
	    setTextureOffset("rightUpperWing.rightUpperWing", 20, 28);
	    setTextureOffset("neck.neck", 0, 15);
	    setTextureOffset("tail1.tail1", 90, 0);
	    setTextureOffset("tail2.tail2", 90, 10);
	    setTextureOffset("tail3.tail3", 51, 12);
	    setTextureOffset("rightTailFeather3.rightTailFeather3", 53, 20);
	    setTextureOffset("leftTailFeather3.leftTailFeather3", 53, 20);
	    setTextureOffset("rightTailFeather2.rightTailFeather2", 53, 20);
	    setTextureOffset("leftTailFeather2.leftTailFeather2", 53, 20);
	    setTextureOffset("rightTailFeather1.rightTailFeather1", 53, 20);
	    setTextureOffset("leftTailFeather1.leftTailFeather1", 53, 20);
	    setTextureOffset("rightUpperLeg.rightUpperLeg", 14, 35);
	    setTextureOffset("rightLowerLeg.rightLowerLeg", 2, 25);
	    setTextureOffset("rightFoot.rightFootrightLeg", 0, 34);
	    setTextureOffset("rightTalon1.rightTalon1", 0, 40);
	    setTextureOffset("rightTalon2.rightTalon2", 0, 40);
	    setTextureOffset("leftUpperLeg.leftUpperLeg", 14, 35);
	    setTextureOffset("leftLowerLeg.leftLowerLeg", 2, 25);
	    setTextureOffset("leftFoot.leftFootleftLeg", 0, 34);
	    setTextureOffset("leftTalon1.leftTalon1", 0, 40);
	    setTextureOffset("leftTalon2.leftTalon2", 0, 40);
	    
	    headpivot = new ModelRenderer(this, "headpivot");
	    headpivot.setRotationPoint(0F, 6F, -11F);
	    setRotation(headpivot, 0F, 0F, 0F);
	    headpivot.mirror = true;
	    head = new ModelRenderer(this, "head");
	    head.setRotationPoint(0F, 1F, -1F);
	    setRotation(head, 0F, 0F, 0F);
	    head.mirror = true;
	      head.addBox("head", -3F, -5F, -7F, 6, 7, 8);
	    lowerCrest = new ModelRenderer(this, "lowerCrest");
	    lowerCrest.setRotationPoint(0F, 0F, -1F);
	    setRotation(lowerCrest, 0F, 0F, 0F);
	    lowerCrest.mirror = true;
	      lowerCrest.addBox("lowerCrest", -0.5F, -1.5F, 0F, 1, 3, 4);
	      head.addChild(lowerCrest);
	    upperCrest = new ModelRenderer(this, "upperCrest");
	    upperCrest.setRotationPoint(0F, -3F, -1F);
	    setRotation(upperCrest, 0F, 0F, 0F);
	    upperCrest.mirror = true;
	      upperCrest.mirror = true;
	      upperCrest.addBox("upperCrest", -0.5F, -1.5F, 0F, 1, 3, 4);
	      upperCrest.mirror = false;
	      head.addChild(upperCrest);
	    lowerJaw = new ModelRenderer(this, "lowerJaw");
	    lowerJaw.setRotationPoint(0.5F, 1F, -7F);
	    setRotation(lowerJaw, 0F, 0F, 0F);
	    lowerJaw.mirror = true;
	      lowerJaw.addBox("lowerJaw", -2F, 0F, -5F, 3, 1, 6);
	      head.addChild(lowerJaw);
	    upperJaw = new ModelRenderer(this, "upperJaw");
	    upperJaw.setRotationPoint(0F, -3F, -7F);
	    setRotation(upperJaw, 0F, 0F, 0F);
	    upperJaw.mirror = true;
	      upperJaw.addBox("upperJaw", -2F, 0F, -6F, 4, 4, 6);
	      head.addChild(upperJaw);
	      headpivot.addChild(head);
	    velociraptor = new ModelRenderer(this, "velociraptor");
	    velociraptor.setRotationPoint(0F, 9, -2F);
	    setRotation(velociraptor, 0F, 0F, 0F);
	    velociraptor.mirror = true;
	    lowerBody = new ModelRenderer(this, "lowerBody");
	    lowerBody.setRotationPoint(0F, 0F, -2F);
	    setRotation(lowerBody, 0F, 0F, 0F);
	    lowerBody.mirror = true;
	      lowerBody.addBox("lowerBody", -4F, 0F, 0F, 8, 6, 7);
	    upperBody = new ModelRenderer(this, "upperBody");
	    upperBody.setRotationPoint(0F, 0F, -2F);
	    setRotation(upperBody, 0F, 0F, 0F);
	    upperBody.mirror = true;
	      upperBody.addBox("upperBody", -3F, 0F, -5F, 6, 6, 5);
	    leftUpperArm = new ModelRenderer(this, "leftUpperArm");
	    leftUpperArm.setRotationPoint(3F, 2F, -3F);
	    setRotation(leftUpperArm, 0F, 0F, 0F);
	    leftUpperArm.mirror = true;
	      leftUpperArm.addBox("leftUpperArm", 0F, 0F, -1.5F, 2, 3, 3);
	    leftUpperWing = new ModelRenderer(this, "leftUpperWing");
	    leftUpperWing.setRotationPoint(1F, 2F, 1.5F);
	    setRotation(leftUpperWing, 0F, 0F, 0F);
	    leftUpperWing.mirror = true;
	      leftUpperWing.addBox("leftUpperWing", -0.5F, 0F, -2F, 1, 3, 4);
	      leftUpperArm.addChild(leftUpperWing);
	    leftLowerArm = new ModelRenderer(this, "leftLowerArm");
	    leftLowerArm.setRotationPoint(1F, 3F, 1F);
	    setRotation(leftLowerArm, 0F, 0F, 0F);
	    leftLowerArm.mirror = true;
	      leftLowerArm.addBox("leftLowerArm", -0.9F, -1F, -4F, 2, 2, 4);
	    leftLowerWing = new ModelRenderer(this, "leftLowerWing");
	    leftLowerWing.setRotationPoint(0F, 1F, -0.5F);
	    setRotation(leftLowerWing, 0F, 0F, 0F);
	    leftLowerWing.mirror = true;
	      leftLowerWing.mirror = true;
	      leftLowerWing.addBox("leftLowerWing", -0.5F, 0F, -4F, 1, 3, 4);
	      leftLowerWing.mirror = false;
	      leftLowerArm.addChild(leftLowerWing);
	      leftUpperArm.addChild(leftLowerArm);
	      upperBody.addChild(leftUpperArm);
	    rightUpperArm = new ModelRenderer(this, "rightUpperArm");
	    rightUpperArm.setRotationPoint(-3F, 2F, -3F);
	    setRotation(rightUpperArm, 0F, 0F, 0F);
	    rightUpperArm.mirror = true;
	      rightUpperArm.addBox("rightUpperArm", -2F, 0F, -1.5F, 2, 3, 3);
	    rightLowerArm = new ModelRenderer(this, "rightLowerArm");
	    rightLowerArm.setRotationPoint(-1F, 3F, 1F);
	    setRotation(rightLowerArm, 0F, 0F, 0F);
	    rightLowerArm.mirror = true;
	      rightLowerArm.mirror = true;
	      rightLowerArm.addBox("rightLowerArm", -1.1F, -1F, -4F, 2, 2, 4);
	      rightLowerArm.mirror = false;
	    rightLowerWing = new ModelRenderer(this, "rightLowerWing");
	    rightLowerWing.setRotationPoint(0F, 1F, -0.5F);
	    setRotation(rightLowerWing, 0F, 0F, 0F);
	    rightLowerWing.mirror = true;
	      rightLowerWing.addBox("rightLowerWing", -0.5F, 0F, -4F, 1, 3, 4);
	      rightLowerArm.addChild(rightLowerWing);
	      rightUpperArm.addChild(rightLowerArm);
	    rightUpperWing = new ModelRenderer(this, "rightUpperWing");
	    rightUpperWing.setRotationPoint(-1F, 2F, 1.5F);
	    setRotation(rightUpperWing, 0F, 0F, 0F);
	    rightUpperWing.mirror = true;
	      rightUpperWing.mirror = true;
	      rightUpperWing.addBox("rightUpperWing", -0.6F, 0F, -2F, 1, 3, 4);
	      rightUpperWing.mirror = false;
	      rightUpperArm.addChild(rightUpperWing);
	      upperBody.addChild(rightUpperArm);
	    neck = new ModelRenderer(this, "neck");
	    neck.setRotationPoint(0F, 4F, -5F);
	    setRotation(neck, 0F, 0F, 0F);
	    neck.mirror = true;
	      neck.addBox("neck", -2F, -4F, -6F, 4, 4, 6);
	    headdummy = new ModelRenderer(this, "headdummy");
	    headdummy.setRotationPoint(0F, -1F, -6F);
	    setRotation(headdummy, 0F, 0F, 0F);
	    headdummy.mirror = true;
	      neck.addChild(headdummy);
	      upperBody.addChild(neck);
	      velociraptor.addChild(upperBody);
	    tail1 = new ModelRenderer(this, "tail1");
	    tail1.setRotationPoint(0F, 0F, 5F);
	    setRotation(tail1, 0F, 0F, 0F);
	    tail1.mirror = true;
	      tail1.addBox("tail1", -2F, 0F, 0F, 4, 4, 6);
	    tail2 = new ModelRenderer(this, "tail2");
	    tail2.setRotationPoint(0F, 2F, 6F);
	    setRotation(tail2, 0F, 0F, 0F);
	    tail2.mirror = true;
	      tail2.addBox("tail2", -2F, -2F, 0F, 4, 4, 3);
	    tail3 = new ModelRenderer(this, "tail3");
	    tail3.setRotationPoint(0F, -1F, 3F);
	    setRotation(tail3, 0F, 0F, 0F);
	    tail3.mirror = true;
	      tail3.addBox("tail3", -1F, -1F, 0F, 2, 2, 12);
	    rightTailFeather3 = new ModelRenderer(this, "rightTailFeather3");
	    rightTailFeather3.setRotationPoint(0F, 0F, 16.5F);
	    setRotation(rightTailFeather3, 0F, 0F, 0F);
	    rightTailFeather3.mirror = true;
	      rightTailFeather3.addBox("rightTailFeather3", -2F, -0.5F, -1.5F, 2, 1, 3);
	      tail3.addChild(rightTailFeather3);
	    leftTailFeather3 = new ModelRenderer(this, "leftTailFeather3");
	    leftTailFeather3.setRotationPoint(0F, 0F, 16.5F);
	    setRotation(leftTailFeather3, 0F, 0F, 0F);
	    leftTailFeather3.mirror = true;
	      leftTailFeather3.addBox("leftTailFeather3", 0F, -0.5F, -1.5F, 2, 1, 3);
	      tail3.addChild(leftTailFeather3);
	    rightTailFeather2 = new ModelRenderer(this, "rightTailFeather2");
	    rightTailFeather2.setRotationPoint(0F, 0F, 13.5F);
	    setRotation(rightTailFeather2, 0F, 0F, 0F);
	    rightTailFeather2.mirror = true;
	      rightTailFeather2.mirror = true;
	      rightTailFeather2.addBox("rightTailFeather2", -2F, -0.5F, -1.5F, 2, 1, 3);
	      rightTailFeather2.mirror = false;
	      tail3.addChild(rightTailFeather2);
	    leftTailFeather2 = new ModelRenderer(this, "leftTailFeather2");
	    leftTailFeather2.setRotationPoint(0F, 0F, 13.5F);
	    setRotation(leftTailFeather2, 0F, 0F, 0F);
	    leftTailFeather2.mirror = true;
	      leftTailFeather2.addBox("leftTailFeather2", 0F, -0.5F, -1.5F, 2, 1, 3);
	      tail3.addChild(leftTailFeather2);
	    rightTailFeather1 = new ModelRenderer(this, "rightTailFeather1");
	    rightTailFeather1.setRotationPoint(-0.5F, 0F, 10.5F);
	    setRotation(rightTailFeather1, 0F, 0F, 0F);
	    rightTailFeather1.mirror = true;
	      rightTailFeather1.mirror = true;
	      rightTailFeather1.addBox("rightTailFeather1", -2F, -0.5F, -1.5F, 2, 1, 3);
	      rightTailFeather1.mirror = false;
	      tail3.addChild(rightTailFeather1);
	    leftTailFeather1 = new ModelRenderer(this, "leftTailFeather1");
	    leftTailFeather1.setRotationPoint(0.5F, 0F, 10.5F);
	    setRotation(leftTailFeather1, 0F, 0F, 0F);
	    leftTailFeather1.mirror = true;
	      leftTailFeather1.addBox("leftTailFeather1", 0F, -0.5F, -1.5F, 2, 1, 3);
	      tail3.addChild(leftTailFeather1);
	      tail2.addChild(tail3);
	      tail1.addChild(tail2);
	      lowerBody.addChild(tail1);
	    rightUpperLeg = new ModelRenderer(this, "rightUpperLeg");
	    rightUpperLeg.setRotationPoint(-4F, 4F, 5F);
	    setRotation(rightUpperLeg, 0F, 0F, 0F);
	    rightUpperLeg.mirror = true;
	      rightUpperLeg.addBox("rightUpperLeg", -3F, 0F, -2.5F, 3, 5, 5);
	    rightLowerLeg = new ModelRenderer(this, "rightLowerLeg");
	    rightLowerLeg.setRotationPoint(-1F, 4F, 2.7F);
	    setRotation(rightLowerLeg, 0F, 0F, 0F);
	    rightLowerLeg.mirror = true;
	      rightLowerLeg.addBox("rightLowerLeg", -1.1F, -1F, -7F, 2, 2, 7);
	    rightFoot = new ModelRenderer(this, "rightFoot");
	    rightFoot.setRotationPoint(0F, -1F, -6F);
	    setRotation(rightFoot, 0F, 0F, 0F);
	    rightFoot.mirror = true;
	      rightFoot.addBox("rightFootrightLeg", -2F, 0F, -3F, 3, 2, 4);
	    rightTalon1 = new ModelRenderer(this, "rightTalon1");
	    rightTalon1.setRotationPoint(0F, 0.5F, -1F);
	    setRotation(rightTalon1, 0F, 0F, 0F);
	    rightTalon1.mirror = true;
	      rightTalon1.addBox("rightTalon1", -0.5F, -0.5F, -3F, 1, 1, 3);
	    rightTalon2 = new ModelRenderer(this, "rightTalon2");
	    rightTalon2.setRotationPoint(0F, 0F, -3F);
	    setRotation(rightTalon2, 0F, 0F, 0F);
	    rightTalon2.mirror = true;
	      rightTalon2.addBox("rightTalon2", -0.5F, -0.5F, -1F, 1, 1, 1);
	      rightTalon1.addChild(rightTalon2);
	      rightFoot.addChild(rightTalon1);
	      rightLowerLeg.addChild(rightFoot);
	      rightUpperLeg.addChild(rightLowerLeg);
	      lowerBody.addChild(rightUpperLeg);
	    leftUpperLeg = new ModelRenderer(this, "leftUpperLeg");
	    leftUpperLeg.setRotationPoint(4F, 4F, 5F);
	    setRotation(leftUpperLeg, 0F, 0F, 0F);
	    leftUpperLeg.mirror = true;
	      leftUpperLeg.mirror = true;
	      leftUpperLeg.addBox("leftUpperLeg", 0F, 0F, -2.5F, 3, 5, 5);
	      leftUpperLeg.mirror = false;
	    leftLowerLeg = new ModelRenderer(this, "leftLowerLeg");
	    leftLowerLeg.setRotationPoint(1F, 4F, 2.7F);
	    setRotation(leftLowerLeg, 0F, 0F, 0F);
	    leftLowerLeg.mirror = true;
	      leftLowerLeg.mirror = true;
	      leftLowerLeg.addBox("leftLowerLeg", -0.9F, -1F, -7F, 2, 2, 7);
	      leftLowerLeg.mirror = false;
	    leftFoot = new ModelRenderer(this, "leftFoot");
	    leftFoot.setRotationPoint(0F, -1F, -6F);
	    setRotation(leftFoot, 0F, 0F, 0F);
	    leftFoot.mirror = true;
	      leftFoot.addBox("leftFootleftLeg", -1F, 0F, -3F, 3, 2, 4);
	    leftTalon1 = new ModelRenderer(this, "leftTalon1");
	    leftTalon1.setRotationPoint(0F, 0.5F, -1F);
	    setRotation(leftTalon1, 0F, 0F, 0F);
	    leftTalon1.mirror = true;
	      leftTalon1.addBox("leftTalon1", -0.5F, -0.5F, -3F, 1, 1, 3);
	    leftTalon2 = new ModelRenderer(this, "leftTalon2");
	    leftTalon2.setRotationPoint(0F, 0F, -3F);
	    setRotation(leftTalon2, 0F, 0F, 0F);
	    leftTalon2.mirror = true;
	      leftTalon2.addBox("leftTalon2", -0.5F, -0.5F, -1F, 1, 1, 1);
	      leftTalon1.addChild(leftTalon2);
	      leftFoot.addChild(leftTalon1);
	      leftLowerLeg.addChild(leftFoot);
	      leftUpperLeg.addChild(leftLowerLeg);
	      lowerBody.addChild(leftUpperLeg);
	      velociraptor.addChild(lowerBody);
	  }

    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaur)var1).isModelized());
        headpivot.render(var7);
        velociraptor.render(var7);
    }
    
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean modelized)
    {
        
  	  if(!modelized){
		  this.head.rotateAngleX = -var5 / (180F / (float)Math.PI);
          this.head.rotateAngleY = var4 / (180F / (float)Math.PI);
		  this.tail1.rotateAngleY = 0.2F * MathHelper.sin(var3 * (float)0.1F + (var2+1));
		  this.tail3.rotateAngleY = 0.1F * MathHelper.sin(var3 * (float)0.1F + var2);
	  }
	  else {
		  this.modelPose();
	  }
    }
    
    public void setLivingAnimations(EntityLivingBase par1EntityLiving, float par2, float par3, float par4)
    {
  	  EntityVelociraptor entity = (EntityVelociraptor)par1EntityLiving;

      if (!entity.isAdult() && !entity.isTeen())
      {
      	  this.upperJaw.rotationPointZ = -5F;
      	  this.lowerJaw.rotationPointZ = -5F;
        }
        else
        {
      	  this.upperJaw.rotationPointZ = -7F;
      	  this.lowerJaw.rotationPointZ = -7F;
        }
      
  	  //if (entity.isSitting() || entity.OrderStatus == EnumOrderType.Stay)
  		//  this.sitPose();
  	  //else
  		  this.standingPose(par2, par3);


    }
    
    private void modelPose(){
  	  this.head.rotateAngleZ = 0;
  	  
        this.rightLowerLeg.rotateAngleX = 0;
        this.leftLowerLeg.rotateAngleX = 0;
        
        
        this.tail1.rotateAngleY = 0;
        this.tail2.rotateAngleY = 0;
    }
    
    private void standingPose(float speed, float range){
  	  
     	 // this.velociraptor.rotationPointY = 8F;
     	 // this.headpivot.rotationPointY = this.velociraptor.rotationPointY - 3F;
     	  
     	  this.head.rotateAngleX =  (float)Math.toRadians(5);
     	  this.lowerJaw.rotateAngleX = (float)Math.toRadians(-3);
     	  this.lowerBody.rotateAngleX = (float)Math.toRadians(-10);
     	  this.upperBody.rotateAngleX = (float)Math.toRadians(4);
     	  this.neck.rotateAngleX = (float)Math.toRadians(-49);
     	  this.lowerCrest.rotateAngleX = (float)Math.toRadians(25);
     	  this.upperCrest.rotateAngleX = (float)Math.toRadians(28);

     	  this.leftLowerArm.rotateAngleX = (float)Math.toRadians(57);
     	  this.rightLowerArm.rotateAngleX = (float)Math.toRadians(57);
     	  
     	  this.leftUpperWing.rotateAngleX = (float)Math.toRadians(40);
     	  this.rightUpperWing.rotateAngleX = (float)Math.toRadians(40);
     	  
     	  this.rightLowerLeg.rotateAngleX = (float)Math.toRadians(57);
     	  this.leftLowerLeg.rotateAngleX = (float)Math.toRadians(57);
     	  this.rightFoot.rotateAngleX = (float)Math.toRadians(-57);
     	  this.leftFoot.rotateAngleX = (float)Math.toRadians(-57);
     	  
     	  this.leftTalon1.rotateAngleX = (float)Math.toRadians(-50);
     	  this.leftTalon2.rotateAngleX = (float)Math.toRadians(80);
     	  this.rightTalon1.rotateAngleX = (float)Math.toRadians(-50);
     	  this.rightTalon2.rotateAngleX = (float)Math.toRadians(80);
     	  
    	  this.rightUpperLeg.rotateAngleX = (float)Math.toRadians(10) + MathHelper.cos(speed * 0.6662F + (float)Math.PI) * 1.0F * range;
          this.leftUpperLeg.rotateAngleX = (float)Math.toRadians(10) + MathHelper.cos(speed * 0.6662F) * 1.0F * range;
          
     	  this.tail3.rotateAngleX = (float)Math.toRadians(-1.6);
    }

}
