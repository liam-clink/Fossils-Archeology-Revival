package mods.fossil.client.model;

import mods.fossil.Fossil;
import mods.fossil.entity.mob.EntityDeinonychus;
import mods.fossil.entity.mob.EntityDinosaur;
import mods.fossil.entity.mob.EntityGallimimus;
import mods.fossil.fossilEnums.EnumOrderType;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelGallimimus extends ModelDinosaurs
{
  //fields
    ModelRenderer lowerBody;
    ModelRenderer head;
    ModelRenderer lowerJaw;
    ModelRenderer upperJaw;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer upperBody;
    ModelRenderer rightUpperArm;
    ModelRenderer rightLowerArm;
    ModelRenderer leftUpperArm;
    ModelRenderer leftLowerArm;
    ModelRenderer neck;
    ModelRenderer leftUpperLeg;
    ModelRenderer rightUpperLeg;
    ModelRenderer leftLowerLeg;
    ModelRenderer rightLowerLeg;
    ModelRenderer leftFoot;
    ModelRenderer rightFoot;
	private ModelRenderer headpivot;
	private ModelRenderer gallimimus;
	private ModelRenderer headdummy;
	private ModelRenderer crest;
	private ModelRenderer tailFeather;
  
  public ModelGallimimus()
  {
	    textureWidth = 128;
	    textureHeight = 64;
	    setTextureOffset("head.head", 46, 11);
	    setTextureOffset("crest.crest", 16, -4);
	    setTextureOffset("lowerJaw.lowerJaw", 52, 0);
	    setTextureOffset("upperJaw.upperJaw", 52, 5);
	    setTextureOffset("lowerBody.lowerBody", 3, 36);
	    setTextureOffset("tail1.tail1", 22, 0);
	    setTextureOffset("tail2.tail2", 0, 12);
	    setTextureOffset("tailFeather.tailFeather", 16, -4);
	    setTextureOffset("upperBody.upperBody", 42, 22);
	    setTextureOffset("rightUpperArm.rightUpperWing", 32, 13);
	    setTextureOffset("rightUpperArm.rightUpperArm", 16, 54);
	    setTextureOffset("rightLowerArm.rightLowerArm", 8, 0);
	    setTextureOffset("rightLowerArm.rightLowerWing", 32, 13);
	    setTextureOffset("neck.neck", 42, 0);
	    setTextureOffset("leftUpperArm.leftUpperWing", 32, 13);
	    setTextureOffset("leftUpperArm.leftUpperArm", 16, 54);
	    setTextureOffset("leftLowerArm.leftLowerWing", 32, 13);
	    setTextureOffset("leftLowerArm.leftLowerArm", 8, 0);
	    setTextureOffset("leftUpperLeg.leftUpperLeg", 0, 12);
	    setTextureOffset("leftLowerLeg.leftLowerLeg", 0, 0);
	    setTextureOffset("leftFoot.leftFoot", 22, 10);
	    setTextureOffset("rightUpperLeg.rightUpperLeg", 0, 12);
	    setTextureOffset("rightLowerLeg.rightLowerLeg", 0, 0);
	    setTextureOffset("rightFoot.rightFoot", 22, 10);
	    
	    headpivot = new ModelRenderer(this, "headpivot");
	    headpivot.setRotationPoint(0F, -4F, -12.5F);
	    setRotation(headpivot, 0F, 0F, 0F);
	    headpivot.mirror = true;
	    head = new ModelRenderer(this, "head");
	    head.setRotationPoint(0F, 2F, 0.8666667F);
	    setRotation(head, 0F, 0F, 0F);
	    head.mirror = false;
	      head.addBox("head", -2F, -4F, -5F, 4, 5, 5);
	    crest = new ModelRenderer(this, "crest");
	    crest.setRotationPoint(0, 0, 0);
	    setRotation(crest, 0F, 0F, 0F);
	    crest.addBox("crest", 0F, -4.1F, -2F, 1, 4, 5);
	    lowerJaw = new ModelRenderer(this, "lowerJaw");
	    lowerJaw.setRotationPoint(0F, -0.5F, -5F);
	    setRotation(lowerJaw, 0F, 0F, 0F);
	    lowerJaw.mirror = true;
	      lowerJaw.addBox("lowerJaw", -1F, 0F, -4F, 2, 1, 4);
	      head.addChild(crest);
	      head.addChild(lowerJaw);
	    upperJaw = new ModelRenderer(this, "upperJaw");
	    upperJaw.setRotationPoint(0F, -1.5F, -5F);
	    setRotation(upperJaw, 0F, 0F, 0F);
	    upperJaw.mirror = true;
	      upperJaw.addBox("upperJaw", -1F, -1F, -4F, 2, 2, 4);
	      head.addChild(upperJaw);
	      headpivot.addChild(head);
	    gallimimus = new ModelRenderer(this, "gallimimus");
	    gallimimus.setRotationPoint(0F, 9F, -3F);
	    setRotation(gallimimus, 0F, 0F, 0F);
	    gallimimus.mirror = true;
	    lowerBody = new ModelRenderer(this, "lowerBody");
	    lowerBody.setRotationPoint(0F, -3F, 0F);
	    setRotation(lowerBody, 0F, 0F, 0F);
	    lowerBody.mirror = true;
	      lowerBody.addBox("lowerBody", -4F, 0F, 0F, 8, 7, 10);
	    tail1 = new ModelRenderer(this, "tail1");
	    tail1.setRotationPoint(0F, 3F, 10F);
	    setRotation(tail1, 0F, 0F, 0F);
	    tail1.mirror = true;
	      tail1.addBox("tail1", -2F, -2.5F, 0F, 4, 4, 6);
	    tail2 = new ModelRenderer(this, "tail2");
	    tail2.setRotationPoint(0F, 0F, 6F);
	    setRotation(tail2, 0F, 0F, 0F);
	    tail2.mirror = true;
	      tail2.addBox("tail2", -1F, -1F, 0F, 2, 2, 18);
	      tail1.addChild(tail2);
	    tailFeather = new ModelRenderer(this, "tailFeather");
	    tailFeather.setRotationPoint(0F, 0F, 16F);
	    setRotation(tailFeather, 0F, 0F, 0F);
	    tailFeather.addBox("tailFeather", 0F, -1.5F, 0F, 1, 3, 5);
	    tail2.addChild(tailFeather);
	      lowerBody.addChild(tail1);
	      gallimimus.addChild(lowerBody);
	    upperBody = new ModelRenderer(this, "upperBody");
	    upperBody.setRotationPoint(0F, -2.5F, 0F);
	    setRotation(upperBody, 0F, 0F, 0F);
	    upperBody.mirror = true;
	      upperBody.addBox("upperBody", -2.5F, 0F, -5F, 5, 6, 6);
	    rightUpperArm = new ModelRenderer(this, "rightUpperArm");
	    rightUpperArm.setRotationPoint(-2.5F, 2F, -3.4F);
	    setRotation(rightUpperArm, 0F, 0F, 0F);
	    rightUpperArm.mirror = true;
	      rightUpperArm.addBox("rightUpperWing", -1.9F, 0.5F, 0.5F, 1, 6, 4);
	      rightUpperArm.addBox("rightUpperArm", -2F, 0F, -1F, 2, 5, 2);
	    rightLowerArm = new ModelRenderer(this, "rightLowerArm");
	    rightLowerArm.setRotationPoint(-1.5F, 4F, 0F);
	    setRotation(rightLowerArm, 0F, 0F, 0F);
	    rightLowerArm.mirror = true;
	      rightLowerArm.addBox("rightLowerArm", -1F, 0F, 0F, 2, 5, 2);
	      rightLowerArm.addBox("rightLowerWing", -0.5F, -1.5F, 1.5F, 1, 6, 4);
	      rightUpperArm.addChild(rightLowerArm);
	      upperBody.addChild(rightUpperArm);
	    neck = new ModelRenderer(this, "neck");
	    neck.setRotationPoint(0F, 2F, -4F);
	    setRotation(neck, 0F, 0F, 0F);
	    neck.mirror = true;
	      neck.addBox("neck", -1F, -14F, -2F, 2, 14, 2);
	    headdummy = new ModelRenderer(this, "headdummy");
	    headdummy.setRotationPoint(0F, 0F, 0F);
	    setRotation(headdummy, 0F, 0F, 0F);
	    headdummy.mirror = true;
	      neck.addChild(headdummy);
	      upperBody.addChild(neck);
	    leftUpperArm = new ModelRenderer(this, "leftUpperArm");
	    leftUpperArm.setRotationPoint(1.5F, 2F, -3.6F);
	    setRotation(leftUpperArm, 0F, 0F, 0F);
	    leftUpperArm.mirror = true;
	      leftUpperArm.addBox("leftUpperWing", 1.9F, 0.5F, 0.5F, 1, 6, 4);
	      leftUpperArm.addBox("leftUpperArm", 1F, 0F, -1F, 2, 5, 2);
	    leftLowerArm = new ModelRenderer(this, "leftLowerArm");
	    leftLowerArm.setRotationPoint(2.5F, 4F, 0F);
	    setRotation(leftLowerArm, 0F, 0F, 0F);
	    leftLowerArm.mirror = true;
	      leftLowerArm.addBox("leftLowerWing", -0.5F, -1.5F, 1.5F, 1, 6, 4);
	      leftLowerArm.mirror = true;
	      leftLowerArm.addBox("leftLowerArm", -1F, 0F, 0F, 2, 5, 2);
	      leftLowerArm.mirror = false;
	      leftUpperArm.addChild(leftLowerArm);
	      upperBody.addChild(leftUpperArm);
	      gallimimus.addChild(upperBody);
	    leftUpperLeg = new ModelRenderer(this, "leftUpperLeg");
	    leftUpperLeg.setRotationPoint(3F, 0F, 9F);
	    setRotation(leftUpperLeg, 0F, 0F, 0F);
	    leftUpperLeg.mirror = true;
	      leftUpperLeg.addBox("leftUpperLeg", 1F, 0F, -4F, 3, 6, 5);
	    leftLowerLeg = new ModelRenderer(this, "leftLowerLeg");
	    leftLowerLeg.setRotationPoint(2F, 4F, 0F);
	    setRotation(leftLowerLeg, 0F, 0F, 0F);
	    leftLowerLeg.mirror = true;
	      leftLowerLeg.addBox("leftLowerLeg", -1F, 0F, 0F, 2, 10, 2);
	    leftFoot = new ModelRenderer(this, "leftFoot");
	    leftFoot.setRotationPoint(0F, 9F, 1F);
	    setRotation(leftFoot, 0F, 0F, 0F);
	    leftFoot.mirror = true;
	      leftFoot.addBox("leftFoot", -1F, 0F, -3F, 3, 2, 3);
	      leftLowerLeg.addChild(leftFoot);
	      leftUpperLeg.addChild(leftLowerLeg);
	      gallimimus.addChild(leftUpperLeg);
	    rightUpperLeg = new ModelRenderer(this, "rightUpperLeg");
	    rightUpperLeg.setRotationPoint(-3F, 0F, 9F);
	    setRotation(rightUpperLeg, 0F, 0F, 0F);
	    rightUpperLeg.mirror = true;
	      rightUpperLeg.addBox("rightUpperLeg", -4F, 0F, -4F, 3, 6, 5);
	    rightLowerLeg = new ModelRenderer(this, "rightLowerLeg");
	    rightLowerLeg.setRotationPoint(-2F, 4F, 0F);
	    setRotation(rightLowerLeg, 0F, 0F, 0F);
	    rightLowerLeg.mirror = true;
	      rightLowerLeg.addBox("rightLowerLeg", -1F, 0F, 0F, 2, 10, 2);
	    rightFoot = new ModelRenderer(this, "rightFoot");
	    rightFoot.setRotationPoint(0F, 9F, 1F);
	    setRotation(rightFoot, 0F, 0F, 0F);
	    rightFoot.mirror = true;
	      rightFoot.addBox("rightFoot", -2F, 0F, -3F, 3, 2, 3);
	      rightLowerLeg.addChild(rightFoot);
	      rightUpperLeg.addChild(rightLowerLeg);
	      gallimimus.addChild(rightUpperLeg);
	  }
  
  public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
  {
      super.render(var1, var2, var3, var4, var5, var6, var7);
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaur)var1).isModelized());
      
  	if(Fossil.FossilOptions.GallimimusFeathers)
  	{
		this.crest.isHidden = false;
		this.tailFeather.isHidden = false;
  	}
	else
	{
		this.crest.isHidden = true;
		this.tailFeather.isHidden = true;
	}
  	
  	this.gallimimus.render(var7);
  	this.headpivot.render(var7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
	}

	@Override
	protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean modelized) {

		//Initial Offsets

		this.neck.rotateAngleX = (float)Math.toRadians(15);
	
		//Living animations
		if(!modelized)
		{
        this.headpivot.rotateAngleX =  var5 / (180F / (float)Math.PI);
        this.headpivot.rotateAngleY = var4 / (180F / (float)Math.PI);

        this.tail1.rotateAngleY = 0.15F * MathHelper.sin(var3 * (float)0.1F + (var2 + 1));
        this.tail2.rotateAngleY = 0.15F * MathHelper.sin(var3  * (float)0.1F + var2);
		}
		else
		{
	        this.headpivot.rotateAngleX = 0;
	        this.headpivot.rotateAngleY = 0;

	        this.tail1.rotateAngleY = 0;
	        this.tail2.rotateAngleY = 0;
		}
        
		
		
	}
	
	  public void setLivingAnimations(EntityLivingBase par1EntityLiving, float par2, float par3, float par4)
	  {
		  EntityGallimimus entity = (EntityGallimimus)par1EntityLiving;

		  if (entity.isSitting())// || entity.OrderStatus == EnumOrderType.Stay)
			  this.sitPose();
		  else
			  this.standingPose(par2, par3);
	  }
	  
	  private void sitPose(){
	  
	        this.gallimimus.rotationPointY = 17;
	        this.headpivot.rotationPointY = 3;
	        this.neck.rotationPointY = 3;
	        
	        this.headpivot.rotationPointZ = -9.5F;
	        
			this.leftUpperArm.rotateAngleX = (float)Math.toRadians(25.0);
			this.rightUpperArm.rotateAngleX = (float)Math.toRadians(25.0);
			this.upperBody.rotateAngleX = -0.20943951F;
			this.lowerBody.rotateAngleX = 0;
			
			this.leftLowerArm.rotateAngleX = -(float)Math.toRadians(20.0);
			this.rightLowerArm.rotateAngleX = -(float)Math.toRadians(20.0);
	        
	        this.rightUpperLeg.rotateAngleX = 0;
	        this.leftUpperLeg.rotateAngleX = 0;
	        
	        this.rightLowerLeg.rotateAngleX = (float)Math.toRadians(-80);
	        this.leftLowerLeg.rotateAngleX = (float)Math.toRadians(-80);
			this.leftFoot.rotateAngleX = this.rightFoot.rotateAngleX = (float)Math.toRadians(80);
			
			this.tail1.rotationPointZ = 8.5F;
			this.tail1.rotateAngleX = (float)Math.toRadians(-40);
			this.tail2.rotationPointZ = 5.5F;
			this.tail2.rotateAngleX = (float)Math.toRadians(30);
	  }

	  private void standingPose(float speed, float range){

	        this.gallimimus.rotationPointY = 9 + MathHelper.cos(speed+1) * range/2;
	        this.headpivot.rotationPointY = -3 + MathHelper.cos(speed) * range/2;
	        this.neck.rotationPointY = 3 + MathHelper.cos(speed) * range/2;
	        
	        this.headpivot.rotationPointZ = -12.5F;
	        
	        this.lowerBody.rotateAngleX = (float)Math.toRadians(-4);
	        this.upperBody.rotateAngleX = (float)Math.toRadians(4);
	        
			this.leftUpperArm.rotateAngleX = -(float)Math.toRadians(-4);
			this.rightUpperArm.rotateAngleX = -(float)Math.toRadians(-4);	        
	        
			this.leftLowerArm.rotateAngleX = -(float)Math.toRadians(60.0);
			this.rightLowerArm.rotateAngleX = -(float)Math.toRadians(60.0);
	        
	        this.rightUpperLeg.rotateAngleX = MathHelper.cos(speed * 0.6362F) * 1.0F * range;
	        this.leftUpperLeg.rotateAngleX = MathHelper.cos(speed * 0.6362F + (float)Math.PI) * 1.0F * range;
			this.leftLowerLeg.rotateAngleX = this.rightLowerLeg.rotateAngleX = (float)Math.toRadians(-10);
			this.leftFoot.rotateAngleX = this.rightFoot.rotateAngleX = (float)Math.toRadians(10);
			
			this.tail1.rotationPointZ = 10F;
			this.tail2.rotationPointZ = 6F;
			this.tail1.rotateAngleX = this.tail2.rotateAngleX = 0;
	        
	  }
}
