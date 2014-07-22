package mods.fossil.client.model;

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
    ModelRenderer Body;
    ModelRenderer Head;
    ModelRenderer Lower_Beak;
    ModelRenderer Upper_Beak;
    ModelRenderer Tail;
    ModelRenderer Tail2;
    ModelRenderer Upper_Body;
    ModelRenderer Upper_Arm_Right;
    ModelRenderer Lower_Arm_Right;
    ModelRenderer Upper_Arm_Left;
    ModelRenderer Lower_Arm_Left;
    ModelRenderer Neck;
    ModelRenderer Upper_Leg_Left;
    ModelRenderer Upper_Leg_Right;
    ModelRenderer Lower_Leg_Left;
    ModelRenderer Lower_Leg_Right;
    ModelRenderer Foot_Left;
    ModelRenderer Foot_Right;
  
  public ModelGallimimus()
  {
    textureWidth = 64;
    textureHeight = 32;
    setTextureOffset("Body.Body", 0, 15);
    setTextureOffset("Head.Head", 46, 11);
    setTextureOffset("Lower_Beak.Lower_Beak", 52, 0);
    setTextureOffset("Upper_Beak.Upper_Beak", 52, 5);
    setTextureOffset("Tail.Tail", 22, 0);
    setTextureOffset("Tail2.Tail2", 0, 5);
    setTextureOffset("Upper_Body.Upper_Body", 42, 20);
    setTextureOffset("Upper_Arm_Right.Upper_Arm_Right", 0, 0);
    setTextureOffset("Lower_Arm_Right.Lower_Arm_Right", 8, 0);
    setTextureOffset("Neck.Neck", 42, 0);
    setTextureOffset("Upper_Arm_Left.Upper_Arm_Left", 0, 0);
    setTextureOffset("Lower_Arm_Left.Lower_Arm_Left", 8, 0);
    setTextureOffset("Upper_Leg_Left.Upper_Leg_Left", 0, 12);
    setTextureOffset("Lower_Leg_Left.Lower_Leg_Left", 0, 0);
    setTextureOffset("Foot_Left.Foot_Left", 22, 10);
    setTextureOffset("Upper_Leg_Right.Upper_Leg_Right", 0, 12);
    setTextureOffset("Lower_Leg_Right.Lower_Leg_Right", 0, 0);
    setTextureOffset("Foot_Right.Foot_Right", 22, 10);
    
    Body = new ModelRenderer(this, "Body");
    Body.setRotationPoint(0F, 9F, -3F);
    setRotation(Body, 0F, 0F, 0F);
    Body.mirror = true;
      Body.addBox("Body", -4F, -3F, 0F, 8, 7, 10);
    Head = new ModelRenderer(this, "Head");
//    Head.setRotationPoint(1F, 1F, 1F);
//    Head.addBox("Head", -2F, -4F, -5F, 4, 5, 5);
    Head.setRotationPoint(0F, -4F, -5F);
    setRotation(Head, 0F, 0F, 0F);
    Head.addBox("Head", -2F, -4F, -5F, 4, 5, 5);
    Head.mirror = true;
    Lower_Beak = new ModelRenderer(this, "Lower_Beak");
    Lower_Beak.setRotationPoint(0F, -0.5F, -5F);
    setRotation(Lower_Beak, 0F, 0F, 0F);
    Lower_Beak.mirror = true;
      Lower_Beak.addBox("Lower_Beak", -1F, 0F, -4F, 2, 1, 4);
      Head.addChild(Lower_Beak);
    Upper_Beak = new ModelRenderer(this, "Upper_Beak");
    Upper_Beak.setRotationPoint(0F, -1.5F, -5F);
    setRotation(Upper_Beak, 0F, 0F, 0F);
    Upper_Beak.mirror = true;
      Upper_Beak.addBox("Upper_Beak", -1F, -1F, -4F, 2, 2, 4);
      Head.addChild(Upper_Beak);
    Tail = new ModelRenderer(this, "Tail");
    Tail.setRotationPoint(0F, -1F, 10F);
    setRotation(Tail, 0F, 0F, 0F);
    Tail.mirror = true;
      Tail.addBox("Tail", -2F, -2F, 0F, 4, 4, 6);
    Tail2 = new ModelRenderer(this, "Tail2");
    Tail2.setRotationPoint(0F, 0F, 6F);
    setRotation(Tail2, 0F, 0F, 0F);
    Tail2.mirror = true;
      Tail2.addBox("Tail2", -1F, -1F, 0F, 2, 2, 18);
      Tail.addChild(Tail2);
      Body.addChild(Tail);
    Upper_Body = new ModelRenderer(this, "Upper_Body");
    Upper_Body.setRotationPoint(0F, 0F, 2F);
    setRotation(Upper_Body, 0F, 0F, 0F);
    Upper_Body.mirror = true;
      Upper_Body.addBox("Upper_Body", -2.5F, -3F, -6F, 5, 6, 6);
    Upper_Arm_Right = new ModelRenderer(this, "Upper_Arm_Right");
    Upper_Arm_Right.setRotationPoint(-2.5F, -1F, -5.4F);
    setRotation(Upper_Arm_Right, 0F, 0F, 0F);
    Upper_Arm_Right.mirror = true;
      Upper_Arm_Right.addBox("Upper_Arm_Right", -2F, 0F, -1F, 2, 5, 2);
    Lower_Arm_Right = new ModelRenderer(this, "Lower_Arm_Right");
    Lower_Arm_Right.setRotationPoint(-1F, 4F, 0F);
    setRotation(Lower_Arm_Right, 0F, 0F, 0F);
    Lower_Arm_Right.mirror = true;
      Lower_Arm_Right.addBox("Lower_Arm_Right", -1F, 0F, 0F, 2, 5, 2);
      Upper_Arm_Right.addChild(Lower_Arm_Right);
      Upper_Body.addChild(Upper_Arm_Right);
    Neck = new ModelRenderer(this, "Neck");
    Neck.setRotationPoint(-1F, -14F, -5F);
    setRotation(Neck, 0F, 0F, 0F);
    Neck.mirror = true;
      Neck.addBox("Neck", 0F, 0F, 0F, 2, 14, 2);
//      Neck.addChild(Head);
      Upper_Body.addChild(Neck);
    Upper_Arm_Left = new ModelRenderer(this, "Upper_Arm_Left");
    Upper_Arm_Left.setRotationPoint(1.5F, -1F, -5.6F);
    setRotation(Upper_Arm_Left, 0F, 0F, 0F);
    Upper_Arm_Left.mirror = true;
      Upper_Arm_Left.addBox("Upper_Arm_Left", 1F, 0F, -1F, 2, 5, 2);
    Lower_Arm_Left = new ModelRenderer(this, "Lower_Arm_Left");
    Lower_Arm_Left.setRotationPoint(2F, 4F, 0F);
    setRotation(Lower_Arm_Left, 0F, 0F, 0F);
    Lower_Arm_Left.mirror = true;
      Lower_Arm_Left.mirror = true;
      Lower_Arm_Left.addBox("Lower_Arm_Left", -1F, 0F, 0F, 2, 5, 2);
      Lower_Arm_Left.mirror = false;
      Upper_Arm_Left.addChild(Lower_Arm_Left);
      Upper_Body.addChild(Upper_Arm_Left);
      Body.addChild(Upper_Body);
    Upper_Leg_Left = new ModelRenderer(this, "Upper_Leg_Left");
    Upper_Leg_Left.setRotationPoint(3F, 0F, 9F);
    setRotation(Upper_Leg_Left, 0F, 0F, 0F);
    Upper_Leg_Left.mirror = true;
      Upper_Leg_Left.addBox("Upper_Leg_Left", 1F, 0F, -4F, 3, 6, 5);
    Lower_Leg_Left = new ModelRenderer(this, "Lower_Leg_Left");
    Lower_Leg_Left.setRotationPoint(2F, 4F, 0F);
    setRotation(Lower_Leg_Left, 0F, 0F, 0F);
    Lower_Leg_Left.mirror = true;
      Lower_Leg_Left.addBox("Lower_Leg_Left", -1F, 0F, 0F, 2, 10, 2);
    Foot_Left = new ModelRenderer(this, "Foot_Left");
    Foot_Left.setRotationPoint(0F, 9F, 1F);
    setRotation(Foot_Left, 0F, 0F, 0F);
    Foot_Left.mirror = true;
      Foot_Left.addBox("Foot_Left", -1F, 0F, -3F, 3, 2, 3);
      Lower_Leg_Left.addChild(Foot_Left);
      Upper_Leg_Left.addChild(Lower_Leg_Left);
      Body.addChild(Upper_Leg_Left);
    Upper_Leg_Right = new ModelRenderer(this, "Upper_Leg_Right");
    Upper_Leg_Right.setRotationPoint(-3F, 0F, 9F);
    setRotation(Upper_Leg_Right, 0F, 0F, 0F);
    Upper_Leg_Right.mirror = true;
      Upper_Leg_Right.addBox("Upper_Leg_Right", -4F, 0F, -4F, 3, 6, 5);
    Lower_Leg_Right = new ModelRenderer(this, "Lower_Leg_Right");
    Lower_Leg_Right.setRotationPoint(-2F, 4F, 0F);
    setRotation(Lower_Leg_Right, 0F, 0F, 0F);
    Lower_Leg_Right.mirror = true;
      Lower_Leg_Right.addBox("Lower_Leg_Right", -1F, 0F, 0F, 2, 10, 2);
    Foot_Right = new ModelRenderer(this, "Foot_Right");
    Foot_Right.setRotationPoint(0F, 9F, 1F);
    setRotation(Foot_Right, 0F, 0F, 0F);
    Foot_Right.mirror = true;
      Foot_Right.addBox("Foot_Right", -2F, 0F, -3F, 3, 2, 3);
      Lower_Leg_Right.addChild(Foot_Right);
      Upper_Leg_Right.addChild(Lower_Leg_Right);
      Body.addChild(Upper_Leg_Right);
  }
  
  public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
  {
      super.render(var1, var2, var3, var4, var5, var6, var7);
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaur)var1).isModelized());
    Body.render(var7);
    Head.render(var7);
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
		this.Upper_Body.rotateAngleX = -0.20943951F;
		this.Neck.rotateAngleX = -0.20943951F;
		this.Head.offsetZ = 0.15F;
		this.Upper_Arm_Left.rotateAngleX = (float)Math.toRadians(25.0);
		this.Upper_Arm_Right.rotateAngleX = (float)Math.toRadians(25.0);


		
		//Living animations
		if(!modelized)
		{
        this.Head.rotateAngleX =  var5 / (180F / (float)Math.PI);
        this.Head.rotateAngleY = var4 / (180F / (float)Math.PI);

        this.Tail.rotateAngleY = 0.15F * MathHelper.sin(var3 * (float)0.1F + (var2 + 1));
        this.Tail2.rotateAngleY = 0.15F * MathHelper.sin(var3  * (float)0.1F + var2);
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
	  
	        this.Body.rotationPointY = 17;
	        this.Head.rotationPointY = 4;
	      //  this.Neck.rotationPointY = -14 + MathHelper.cos(speed) * range/2;
	        
			this.Lower_Arm_Left.rotateAngleX = -(float)Math.toRadians(20.0);
			this.Lower_Arm_Right.rotateAngleX = -(float)Math.toRadians(20.0);
	        
	        this.Upper_Leg_Right.rotateAngleX = 0;
	        this.Upper_Leg_Left.rotateAngleX = 0;
	        
	        this.Lower_Leg_Right.rotateAngleX = (float)Math.toRadians(-80);
	        this.Lower_Leg_Left.rotateAngleX = (float)Math.toRadians(-80);
			this.Foot_Left.rotateAngleX = this.Foot_Right.rotateAngleX = (float)Math.toRadians(80);
			
			this.Tail.rotationPointZ = 8.5F;
			this.Tail.rotateAngleX = (float)Math.toRadians(-40);
			this.Tail2.rotationPointZ = 5.5F;
			this.Tail2.rotateAngleX = (float)Math.toRadians(30);
	  }

	  private void standingPose(float speed, float range){

	        this.Body.rotationPointY = 9 + MathHelper.cos(speed+1) * range/2;
	        this.Head.rotationPointY = -4 + MathHelper.cos(speed) * range/2;
	        this.Neck.rotationPointY = -14 + MathHelper.cos(speed) * range/2;
	        
			this.Lower_Arm_Left.rotateAngleX = -(float)Math.toRadians(60.0);
			this.Lower_Arm_Right.rotateAngleX = -(float)Math.toRadians(60.0);
	        
	        this.Upper_Leg_Right.rotateAngleX = MathHelper.cos(speed * 0.6362F) * 1.0F * range;
	        this.Upper_Leg_Left.rotateAngleX = MathHelper.cos(speed * 0.6362F + (float)Math.PI) * 1.0F * range;
			this.Lower_Leg_Left.rotateAngleX = this.Lower_Leg_Right.rotateAngleX = (float)Math.toRadians(-10);
			this.Foot_Left.rotateAngleX = this.Foot_Right.rotateAngleX = (float)Math.toRadians(10);
			
			this.Tail.rotationPointZ = 10F;
			this.Tail2.rotationPointZ = 6F;
			this.Tail.rotateAngleX = this.Tail2.rotateAngleX = 0;
	        
	  }
}
