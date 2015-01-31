package mods.fossil.client.model;

import mods.fossil.entity.mob.EntityDinosaur;
import mods.fossil.entity.mob.EntityPachycephalosaurus;
import mods.fossil.entity.mob.EntityTRex;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import scala.util.parsing.combinator.PackratParsers.Head;

public class ModelTRex extends ModelDinosaurs
{
//fields
	 ModelRenderer LowerBody;
	 private ModelRenderer Tail1;
	 private ModelRenderer Tail2;
	 private ModelRenderer UpperLegLeft;
	 private ModelRenderer Tail3;
	 private ModelRenderer LowerLegLeft;
	 private ModelRenderer FootLeft;
	 private ModelRenderer UpperLegRight;
	 private ModelRenderer LowerLegRight;
	 private ModelRenderer FootRight;
	 private ModelRenderer UpperBody;
	 private ModelRenderer Neck;
	 private ModelRenderer Head;
	 private ModelRenderer UpperJaw;
	 private ModelRenderer LowerJaw;
	 private ModelRenderer UpperArmLeft;
	 private ModelRenderer LowerArmLeft;
	 private ModelRenderer UpperArmRight;
	 private ModelRenderer LowerArmRight;
	 private ModelRenderer HeadFeathers;
	 private ModelRenderer HeadFeathers2;
	private int ringBufferIndex;
	public double[][] ringBuffer = new double[64][3];
	private float partialTicks;
	private boolean isScreaming;
	private ModelRenderer headpivot;
	private ModelRenderer TailFeathers;
	private ModelRenderer TailFeathers2;

public ModelTRex()
{
 textureWidth = 128;
 textureHeight = 64;
 setTextureOffset("LowerBody.LowerBody", 57, 20);
 setTextureOffset("Tail1.Tail1", 36, 47);
 setTextureOffset("Tail2.Tail2", 74, 48);
 setTextureOffset("Tail3.Tail3", 103, 49);
 setTextureOffset("UpperLegLeft.UpperLegLeft", 0, 15);
 setTextureOffset("LowerLegLeft.LowerLegLeft", 98, 31);
 setTextureOffset("FootLeft.FootLeft", 0, 42);
 setTextureOffset("UpperLegRight.UpperLegRight", 0, 15);
 setTextureOffset("LowerLegRight.LowerLegRight", 98, 31);
 setTextureOffset("FootRight.FootRight", 0, 42);
 setTextureOffset("UpperBody.UpperBody", 80, 0);
 setTextureOffset("Neck.Neck", 52, 0);
 setTextureOffset("Head.Head", 0, 0);
 setTextureOffset("UpperJaw.UpperJaw", 28, 0);
 setTextureOffset("LowerJaw.LowerJaw", 27, 12);
 setTextureOffset("UpperArmLeft.UpperArmLeft", 34, 25);
 setTextureOffset("LowerArmLeft.LowerArmLeft", 34, 33);
 setTextureOffset("UpperArmRight.UpperArmRight", 34, 25);
 setTextureOffset("LowerArmRight.LowerArmRight", 34, 33);
 setTextureOffset("HeadFeathers.HeadFeathers1", 10, 53);
 setTextureOffset("HeadFeathers.HeadFeathers3", 10, 53);
 setTextureOffset("HeadFeathers2.HeadFeathers2", 10, 53);
 setTextureOffset("TailFeathers2.TailFeather", 10, 53);
 setTextureOffset("TailFeathers.TailFeather2", 10, 53);
 setTextureOffset("TailFeathers.TailFeather3", 10, 53);
 setTextureOffset("TailFeathers.TailFeather4", 10, 53);
 setTextureOffset("LowerArmLeft.LeftLowerArmFeathers", 22, 31);
 setTextureOffset("LowerArmRight.RightLowerArmFeathers", 22, 31);

 
 LowerBody = new ModelRenderer(this, "LowerBody");
 LowerBody.setRotationPoint(0F, 10F, -2F);
 setRotation(LowerBody, 0F, 0F, 0F);
 LowerBody.mirror = true;
   LowerBody.addBox("LowerBody", -4F, -6F, 0F, 8, 11, 12);
 Tail1 = new ModelRenderer(this, "Tail1");
 Tail1.setRotationPoint(0F, -1.9F, 11F);
 setRotation(Tail1, 0F, 0F, 0F);
 Tail1.mirror = true;
   Tail1.addBox("Tail1", -3F, -4F, 0F, 6, 7, 10);
 Tail2 = new ModelRenderer(this, "Tail2");
 Tail2.setRotationPoint(0F, -1.8F, 8F);
 setRotation(Tail2, 0F, 0F, 0F);
 Tail2.mirror = true;
   Tail2.addBox("Tail2", -2F, -2F, 0F, 4, 5, 10);
 Tail3 = new ModelRenderer(this, "Tail3");
 Tail3.setRotationPoint(0F, -1F, 9F);
 setRotation(Tail3, 0F, 0F, 0F);
 Tail3.mirror = true;
   Tail3.addBox("Tail3", -1F, -1F, 0F, 2, 3, 8);
 TailFeathers = new ModelRenderer(this, "TailFeathers");
 TailFeathers.setRotationPoint(0F, 1F, -1F);
 setRotation(TailFeathers, 0F, 0F, 0F);
 TailFeathers.mirror = true;
   TailFeathers.addBox("TailFeather2", -0.5F, -1.4F, 6F, 1, 4, 6);
   TailFeathers.addBox("TailFeather3", 0.6F, -1.4F, 0.5333334F, 1, 4, 6);
   TailFeathers.addBox("TailFeather4", -1.4F, -1.4F, 0.5333334F, 1, 4, 6);
   
   TailFeathers2 = new ModelRenderer(this, "TailFeathers2");
   TailFeathers2.setRotationPoint(0F, 0F, 0F);
   setRotation(TailFeathers2, 0F, 0F, 0F);
   TailFeathers2.mirror = true;   
   TailFeathers2.addBox("TailFeather", -0.5F, -1.7F, 2F, 1, 4, 6);   
   	
   TailFeathers.addChild(TailFeathers2);
   Tail3.addChild(TailFeathers);
   Tail2.addChild(Tail3);
   Tail1.addChild(Tail2);
   LowerBody.addChild(Tail1);
 UpperLegLeft = new ModelRenderer(this, "UpperLegLeft");
 UpperLegLeft.setRotationPoint(4F, -1F, 6F);
 setRotation(UpperLegLeft, 0F, 0F, 0F);
 UpperLegLeft.mirror = true;
   UpperLegLeft.mirror = true;
   UpperLegLeft.addBox("UpperLegLeft", 0F, 0F, -4F, 4, 8, 8);
   UpperLegLeft.mirror = false;
 LowerLegLeft = new ModelRenderer(this, "LowerLegLeft");
 LowerLegLeft.setRotationPoint(1F, 5F, 4F);
 setRotation(LowerLegLeft, 0F, 0F, 0F);
 LowerLegLeft.mirror = true;
   LowerLegLeft.addBox("LowerLegLeft", -1F, 0F, -1F, 2, 10, 3);
 FootLeft = new ModelRenderer(this, "FootLeft");
 FootLeft.setRotationPoint(0F, 9F, 0F);
 setRotation(FootLeft, 0F, 0F, 0F);
 FootLeft.mirror = true;
   FootLeft.addBox("FootLeft", -1.5F, 0F, -5.5F, 3, 2, 8);
   LowerLegLeft.addChild(FootLeft);
   UpperLegLeft.addChild(LowerLegLeft);
   LowerBody.addChild(UpperLegLeft);
 UpperLegRight = new ModelRenderer(this, "UpperLegRight");
 UpperLegRight.setRotationPoint(-4F, -1F, 6F);
 setRotation(UpperLegRight, 0F, 0F, 0F);
 UpperLegRight.mirror = true;
   UpperLegRight.addBox("UpperLegRight", -4F, 0F, -4F, 4, 8, 8);
 LowerLegRight = new ModelRenderer(this, "LowerLegRight");
 LowerLegRight.setRotationPoint(-1F, 5F, 4F);
 setRotation(LowerLegRight, 0F, 0F, 0F);
 LowerLegRight.mirror = true;
   LowerLegRight.mirror = true;
   LowerLegRight.addBox("LowerLegRight", -1F, 0F, -1F, 2, 10, 3);
   LowerLegRight.mirror = false;
 FootRight = new ModelRenderer(this, "FootRight");
 FootRight.setRotationPoint(0F, 9F, 0F);
 setRotation(FootRight, 0F, 0F, 0F);
 FootRight.mirror = true;
   FootRight.addBox("FootRight", -1.5F, 0F, -5.5F, 3, 2, 8);
   LowerLegRight.addChild(FootRight);
   UpperLegRight.addChild(LowerLegRight);
   LowerBody.addChild(UpperLegRight);
 UpperBody = new ModelRenderer(this, "UpperBody");
 UpperBody.setRotationPoint(0F, -6F, 3F);
 setRotation(UpperBody, 0F, 0F, 0F);
 UpperBody.mirror = true;
   UpperBody.addBox("UpperBody", -3F, 0F, -10F, 6, 10, 10);
 Neck = new ModelRenderer(this, "Neck");
 Neck.setRotationPoint(0F, 6F, -7F);
 setRotation(Neck, 0F, 0F, 0F);
 Neck.mirror = true;
   Neck.addBox("Neck", -2.5F, -5F, -9F, 5, 7, 9);
 headpivot = new ModelRenderer(this, "headpivot");
 headpivot.setRotationPoint(0F, -3F, -8F);
 setRotation(headpivot, 0F, 0F, 0F);
 Head = new ModelRenderer(this, "Head");
 Head.setRotationPoint(0F, 0F, 0F);
 setRotation(Head, 0F, 0F, 0F);
 Head.mirror = true;
 Head.addBox("Head", -3.5F, -2F, -7F, 7, 8, 7);
 HeadFeathers = new ModelRenderer(this, "HeadFeathers");
 HeadFeathers.setRotationPoint(0F, -1.5F, -2F);
 setRotation(HeadFeathers, 0F, 0F, 0F);
 HeadFeathers.mirror = false;
 HeadFeathers.addBox("HeadFeathers3", 2F, -0.4F, 1.5F, 1, 4, 6);  
 HeadFeathers.addBox("HeadFeathers1", -3F, -0.4F, 1.5F, 1, 4, 6);  
 HeadFeathers2 = new ModelRenderer(this, "HeadFeathers2");
 HeadFeathers2.setRotationPoint(0F, 0F, 0F);
 setRotation(HeadFeathers2, 0F, 0F, 0F);
 HeadFeathers2.mirror = false;
 HeadFeathers2.addBox("HeadFeathers2", -0.5F, -0.5F, 0F, 1, 4, 6);      
 HeadFeathers.addChild(HeadFeathers2); 
 Head.addChild(HeadFeathers);  
 UpperJaw = new ModelRenderer(this, "UpperJaw");
 UpperJaw.setRotationPoint(0F, 1F, -6F);
 setRotation(UpperJaw, 0F, 0F, 0F);
 UpperJaw.mirror = true;
   UpperJaw.addBox("UpperJaw", -2.5F, -2F, -7F, 5, 5, 7);
 LowerJaw = new ModelRenderer(this, "LowerJaw");
 LowerJaw.setRotationPoint(0F, 3F, 0F);
 setRotation(LowerJaw, 0F, 0F, 0F);
 LowerJaw.mirror = true;
   LowerJaw.addBox("LowerJaw", -2F, -1F, -6F, 4, 2, 6);
   UpperJaw.addChild(LowerJaw);
   Head.addChild(UpperJaw);
   headpivot.addChild(Head);
   Neck.addChild(headpivot);
   UpperBody.addChild(Neck);
 UpperArmLeft = new ModelRenderer(this, "UpperArmLeft");
 UpperArmLeft.setRotationPoint(3F, 5F, -8F);
 setRotation(UpperArmLeft, 0F, 0F, 0F);
 UpperArmLeft.mirror = true;
   UpperArmLeft.addBox("UpperArmLeft", 0F, -1F, 0F, 2, 2, 5);
 LowerArmLeft = new ModelRenderer(this, "LowerArmLeft");
 LowerArmLeft.setRotationPoint(1.2F, 0F, 4F);
 setRotation(LowerArmLeft, 0F, 0F, 0F);
 LowerArmLeft.mirror = true;
   LowerArmLeft.addBox("LowerArmLeft", -1F, -1F, -4F, 2, 2, 4);
   //LowerArmLeft.addBox("LeftLowerArmFeathers", -0.5F, 1.5F, -2.6F, 1, 2, 5);
   UpperArmLeft.addChild(LowerArmLeft);
   UpperBody.addChild(UpperArmLeft);
 UpperArmRight = new ModelRenderer(this, "UpperArmRight");
 UpperArmRight.setRotationPoint(-3F, 5F, -8F);
 setRotation(UpperArmRight, 0F, 0F, 0F);
 UpperArmRight.mirror = true;
   UpperArmRight.mirror = true;
   UpperArmRight.addBox("UpperArmRight", -2F, -1F, 0F, 2, 2, 5);
   UpperArmRight.mirror = false;
 LowerArmRight = new ModelRenderer(this, "LowerArmRight");
 LowerArmRight.mirror = false;
 LowerArmRight.setRotationPoint(-1.2F, 0F, 4F);
 setRotation(LowerArmRight, 0F, 0F, 0F);
   LowerArmRight.addBox("LowerArmRight", -1F, -1F, -4F, 2, 2, 4);
   //LowerArmRight.addBox("RightLowerArmFeathers", -0.5F, 1.5F, -2.6F, 1, 2, 5);
   UpperArmRight.addChild(LowerArmRight);
   UpperBody.addChild(UpperArmRight);
   LowerBody.addChild(UpperBody);
}

public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
{
    super.render(var1, var2, var3, var4, var5, var6, var7);
    this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaur)var1).isModelized());
    this.LowerBody.render(var7);
}

private void setRotation(ModelRenderer model, float x, float y, float z)
{
 model.rotateAngleX = x;
 model.rotateAngleY = y;
 model.rotateAngleZ = z;
}



protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean modelized)
{
	 
	 this.headpivot.rotateAngleX = (float)Math.toRadians(30);
	 this.Neck.rotateAngleX = (float)Math.toRadians(-30);
	 this.UpperBody.rotateAngleX = (float)Math.toRadians(5);
	 
	 this.HeadFeathers2.rotateAngleX = (float)Math.toRadians(17);
	 
	 this.UpperArmLeft.rotateAngleX = (float)Math.toRadians(-80);
	 this.UpperArmRight.rotateAngleX = (float)Math.toRadians(-80);
	 
	 this.LowerArmLeft.rotateAngleX = (float)Math.toRadians(110);
	 this.LowerArmRight.rotateAngleX = (float)Math.toRadians(110);
	 
	 this.LowerLegLeft.rotateAngleX = (float)Math.toRadians(-25);
	 this.LowerLegRight.rotateAngleX = (float)Math.toRadians(-25);
	 
	 this.FootLeft.rotateAngleX = (float)Math.toRadians(25);
	 this.FootRight.rotateAngleX = (float)Math.toRadians(25);
	 
	 this.Tail1.rotateAngleX = (float)Math.toRadians(-5);
	 this.Tail2.rotateAngleX = (float)Math.toRadians(2);
	 this.Tail3.rotateAngleX = (float)Math.toRadians(-7);
	 
	 this.TailFeathers.rotateAngleX = (float)Math.toRadians(7);
	 this.TailFeathers2.rotateAngleX = (float)Math.toRadians(14);
	 
		if(!modelized)
		{
		     this.Tail1.rotateAngleY = 0.08F * MathHelper.sin(var3 * (float)0.1F + (var2 + 2));
		     this.Tail2.rotateAngleY = 0.10F * MathHelper.sin(var3  * (float)0.1F + var2+1);
		     this.Tail3.rotateAngleY = 0.15F * MathHelper.sin(var3  * (float)0.1F + var2);
		     
		     this.UpperLegRight.rotateAngleX = MathHelper.cos(var1 * 0.5662F) * 1.0F * var2;
		     this.UpperLegLeft.rotateAngleX = MathHelper.cos(var1 * 0.5662F + (float)Math.PI) * 1.0F * var2;
		
		     this.Head.rotateAngleX = (var5 / (180F / (float)Math.PI));
		     this.Head.rotateAngleY = (var4 / (180F / (float)Math.PI));
		}
		else
		{
			standingPose();
			this.LowerJaw.rotateAngleX = (float)Math.toRadians(30);
		}

	 
}

public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
{
    EntityTRex entity = (EntityTRex)par1EntityLivingBase;
    int isRoaring = entity.getTimer();
    this.partialTicks = par4;

    if (isRoaring > 0) {
    	this.mouthOpen(10);
    }
	else
	{
		this.mouthClosed(10);
	}

}


	public void standingPose() {
	     this.Tail1.rotateAngleY = 0;
	     this.Tail2.rotateAngleY = 0;
	     this.Tail3.rotateAngleY = 0;
	     
	     this.UpperLegRight.rotateAngleX = 0;
	     this.UpperLegLeft.rotateAngleX = 0;

	     this.headpivot.rotateAngleX = (float)Math.toRadians(15);
	     this.Head.rotateAngleY = 0;
	}
	
	public void weakPose() {
			
	}
	
	public void mouthClosed(float var1) {
		this.LowerJaw.rotateAngleX = 0;
	}
	
	public void mouthOpen(float var1) {
		this.LowerJaw.rotateAngleX = (float)Math.toRadians(30);
	}
	
}

