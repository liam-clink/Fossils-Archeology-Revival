package mods.fossil.client.model;

import mods.fossil.entity.mob.EntityDinosaur;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import scala.util.parsing.combinator.PackratParsers.Head;



public class ModelStegosaurus extends ModelDinosaurs
{
  //fields
	private ModelRenderer LowerBody;
	private ModelRenderer LowerBodyPlates;
	private ModelRenderer UpperLegBackLeft;
	private ModelRenderer LowerLegBackLeft;
	private ModelRenderer UpperLegBackRight;
	private ModelRenderer LowerLegBackRight;
	private ModelRenderer Tail1;
	private ModelRenderer Tail2;
	private ModelRenderer Tail3;
	private ModelRenderer Tail3Plates;
	private ModelRenderer Tail1Plates;
	private ModelRenderer UpperBody;
	private ModelRenderer UpperLegFrontLeft;
	private ModelRenderer LowerLegFrontLeft;
	private ModelRenderer UpperLegFrontRight;
	private ModelRenderer LowerLegFrontRight;
	private ModelRenderer Head;
	private ModelRenderer UpperBodyPlates;
  
  public ModelStegosaurus()
  {
    textureWidth = 64;
    textureHeight = 32;
    setTextureOffset("LowerBody.LowerBody", 20, 0);
    setTextureOffset("LowerBodyPlates.LowerBodyPlates", 0, 0);
    setTextureOffset("UpperLegBackLeft.UpperLegBackLeft", 14, 22);
    setTextureOffset("LowerLegBackLeft.LowerLegBackLeft", 24, 16);
    setTextureOffset("UpperLegBackRight.UpperLegBackRight", 0, 22);
    setTextureOffset("LowerLegBackRight.LowerLegBackRight", 24, 21);
    setTextureOffset("Tail1.Tail1", 46, 23);
    setTextureOffset("Tail2.UpperLegFrontLeft", 32, 16);
    setTextureOffset("Tail3.Tail3", 52, 6);
    setTextureOffset("Tail3Plates.Tail3Plates", 0, 0);
    setTextureOffset("Tail1Plates.Tail1Plates", 12, 13);
    setTextureOffset("UpperBody.UpperBody", 46, 14);
    setTextureOffset("UpperLegFrontLeft.UpperLegFrontLeft", 44, 0);
    setTextureOffset("LowerLegFrontLeft.LowerLegFrontLeft", 12, 0);
    setTextureOffset("UpperLegFrontRight.UpperLegFrontRight", 54, 0);
    setTextureOffset("LowerLegFrontRight.LowerLegFrontRight", 20, 0);
    setTextureOffset("Head.Head", 32, 24);
    setTextureOffset("UpperBodyPlates.UpperBodyPlates", 0, 13);
    
    LowerBody = new ModelRenderer(this, "LowerBody");
    LowerBody.setRotationPoint(0F, 22F, 0F);
    setRotation(LowerBody, 0F, 0F, 0F);
    LowerBody.mirror = true;
      LowerBody.addBox("LowerBody", -3.466667F, -8F, -4F, 7, 8, 8);
    LowerBodyPlates = new ModelRenderer(this, "LowerBodyPlates");
    LowerBodyPlates.setRotationPoint(0F, -8F, 0F);
    setRotation(LowerBodyPlates, 0F, 0F, 0F);
    LowerBodyPlates.mirror = true;
      LowerBodyPlates.addBox("LowerBodyPlates", -1F, -5F, -4F, 2, 5, 8);
      LowerBody.addChild(LowerBodyPlates);
    UpperLegBackLeft = new ModelRenderer(this, "UpperLegBackLeft");
    UpperLegBackLeft.setRotationPoint(4F, -3F, 3F);
    setRotation(UpperLegBackLeft, 0F, 0F, 0F);
    UpperLegBackLeft.mirror = true;
      UpperLegBackLeft.addBox("UpperLegBackLeft", -1F, -2.5F, -2F, 2, 5, 5);
    LowerLegBackLeft = new ModelRenderer(this, "LowerLegBackLeft");
    LowerLegBackLeft.setRotationPoint(0F, 2F, 1.5F);
    setRotation(LowerLegBackLeft, 0F, 0F, 0F);
    LowerLegBackLeft.mirror = true;
      LowerLegBackLeft.addBox("LowerLegBackLeft", -0.5F, 0F, -3F, 1, 2, 3);
      UpperLegBackLeft.addChild(LowerLegBackLeft);
      LowerBody.addChild(UpperLegBackLeft);
    UpperLegBackRight = new ModelRenderer(this, "UpperLegBackRight");
    UpperLegBackRight.setRotationPoint(-2F, -3F, 3F);
    setRotation(UpperLegBackRight, 0F, 0F, 0F);
    UpperLegBackRight.mirror = true;
      UpperLegBackRight.addBox("UpperLegBackRight", -2F, -2.5F, -2F, 2, 5, 5);
    LowerLegBackRight = new ModelRenderer(this, "LowerLegBackRight");
    LowerLegBackRight.setRotationPoint(-1F, 2F, 1.5F);
    setRotation(LowerLegBackRight, 0F, 0F, 0F);
    LowerLegBackRight.mirror = true;
      LowerLegBackRight.addBox("LowerLegBackRight", -0.5F, 0F, -3F, 1, 2, 3);
      UpperLegBackRight.addChild(LowerLegBackRight);
      LowerBody.addChild(UpperLegBackRight);
    Tail1 = new ModelRenderer(this, "Tail1");
    Tail1.setRotationPoint(0F, -4F, 3F);
    setRotation(Tail1, 0F, 0F, 0F);
    Tail1.mirror = true;
      Tail1.addBox("Tail1", -2.5F, -2.5F, 0F, 5, 5, 4);
    Tail2 = new ModelRenderer(this, "Tail2");
    Tail2.setRotationPoint(0F, 0F, 4F);
    setRotation(Tail2, 0F, 0F, 0F);
    Tail2.mirror = true;
      Tail2.addBox("UpperLegFrontLeft", -1.5F, -1.5F, -1F, 3, 3, 4);
    Tail3 = new ModelRenderer(this, "Tail3");
    Tail3.setRotationPoint(0F, 0F, 3F);
    setRotation(Tail3, 0F, 0F, 0F);
    Tail3.mirror = true;
      Tail3.addBox("Tail3", -1F, -1F, -1F, 2, 2, 4);
    Tail3Plates = new ModelRenderer(this, "Tail3Plates");
    Tail3Plates.setRotationPoint(0F, -1F, 1F);
    setRotation(Tail3Plates, 0F, 0F, 0F);
    Tail3Plates.mirror = true;
      Tail3Plates.addBox("Tail3Plates", -0.5F, -5F, -1F, 1, 5, 3);
      Tail3.addChild(Tail3Plates);
      Tail2.addChild(Tail3);
      Tail1.addChild(Tail2);
    Tail1Plates = new ModelRenderer(this, "Tail1Plates");
    Tail1Plates.setRotationPoint(0F, -2.5F, 2F);
    setRotation(Tail1Plates, 0F, 0F, 0F);
    Tail1Plates.mirror = true;
      Tail1Plates.addBox("Tail1Plates", -1F, -5F, -2F, 2, 5, 4);
      Tail1.addChild(Tail1Plates);
      LowerBody.addChild(Tail1);
    UpperBody = new ModelRenderer(this, "UpperBody");
    UpperBody.setRotationPoint(0F, -6F, -4F);
    setRotation(UpperBody, 0F, 0F, 0F);
    UpperBody.mirror = true;
      UpperBody.addBox("UpperBody", -2.5F, 0F, -4F, 5, 5, 4);
    UpperLegFrontLeft = new ModelRenderer(this, "UpperLegFrontLeft");
    UpperLegFrontLeft.setRotationPoint(2.5F, -2F, -4F);
    setRotation(UpperLegFrontLeft, 0F, 0F, 0F);
    UpperLegFrontLeft.mirror = true;
      UpperLegFrontLeft.addBox("UpperLegFrontLeft", 0F, -1.5F, -2F, 2, 3, 3);
    LowerLegFrontLeft = new ModelRenderer(this, "LowerLegFrontLeft");
    LowerLegFrontLeft.setRotationPoint(1F, 1F, 0.5F);
    setRotation(LowerLegFrontLeft, 0F, 0F, 0F);
    LowerLegFrontLeft.mirror = true;
      LowerLegFrontLeft.addBox("LowerLegFrontLeft", -0.5F, -1F, -3F, 1, 2, 3);
      UpperLegFrontLeft.addChild(LowerLegFrontLeft);
      LowerBody.addChild(UpperLegFrontLeft);
    UpperLegFrontRight = new ModelRenderer(this, "UpperLegFrontRight");
    UpperLegFrontRight.setRotationPoint(-2.5F, -2F, -4F);
    setRotation(UpperLegFrontRight, 0F, 0F, 0F);
    UpperLegFrontRight.mirror = true;
      UpperLegFrontRight.addBox("UpperLegFrontRight", -2F, -1.5F, -2F, 2, 3, 3);
    LowerLegFrontRight = new ModelRenderer(this, "LowerLegFrontRight");
    LowerLegFrontRight.setRotationPoint(0F, 1F, 0.5F);
    setRotation(LowerLegFrontRight, 0F, 0F, 0F);
    LowerLegFrontRight.mirror = true;
      LowerLegFrontRight.addBox("LowerLegFrontRight", -1.5F, -1F, -3F, 1, 2, 3);
      UpperLegFrontRight.addChild(LowerLegFrontRight);
      LowerBody.addChild(UpperLegFrontRight);
    Head = new ModelRenderer(this, "Head");
    Head.setRotationPoint(0F, 3F, -4F);
    setRotation(Head, 0F, 0F, 0F);
    Head.mirror = true;
      Head.addBox("Head", -1F, -1.5F, -4.533333F, 2, 3, 5);
      UpperBody.addChild(Head);
    UpperBodyPlates = new ModelRenderer(this, "UpperBodyPlates");
    UpperBodyPlates.setRotationPoint(0F, 0F, -0.5F);
    setRotation(UpperBodyPlates, 0F, 0F, 0F);
    UpperBodyPlates.mirror = true;
      UpperBodyPlates.addBox("UpperBodyPlates", -1F, -5F, -2F, 2, 5, 4);
      UpperBody.addChild(UpperBodyPlates);
      LowerBody.addChild(UpperBody);
  }
  
  public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
  {
      super.render(var1, var2, var3, var4, var5, var6, var7);
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaur)var1).isModelized());
    LowerBody.render(var7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  /**
   * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
   * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
   * "far" arms and legs can swing at most.
   */
  protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean isModelized)
  {
	  this.UpperBody.rotateAngleX = (float)Math.toRadians(12);
	  
	  this.LowerLegBackLeft.rotateAngleX = (float)Math.toRadians(90);
	  this.LowerLegBackRight.rotateAngleX = (float)Math.toRadians(90);
	  this.LowerLegFrontLeft.rotateAngleX = (float)Math.toRadians(90);
	  this.LowerLegFrontRight.rotateAngleX = (float)Math.toRadians(90);
	  
	  
		//Living animations
		if(!isModelized)
		{
		      this.Head.rotateAngleX =  var5 / (180F / (float)Math.PI);
		      this.Head.rotateAngleY = var4 / (180F / (float)Math.PI);
		      
		      this.UpperLegFrontLeft.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 1.0F * var2;
		      this.UpperLegFrontRight.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI) * 1.0F * var2;
		      this.UpperLegBackLeft.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI + 2) * 1.0F * var2;
		      this.UpperLegBackRight.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 1.0F * var2;
		      
		      this.Tail1.rotateAngleY = 0.05F * MathHelper.sin(var3 * (float)0.1F + (var2+2));
		      this.Tail2.rotateAngleY = 0.1F * MathHelper.sin(var3 * (float)0.1F + (var2+1));
		      this.Tail3.rotateAngleY = 0.15F * MathHelper.sin(var3 * (float)0.1F + var2);
		      
		      this.Tail1.rotateAngleX = (float)Math.toRadians(-10);
		      this.Tail2.rotateAngleX = (float)Math.toRadians(5);
		      this.Tail3.rotateAngleX = (float)Math.toRadians(5);
		}
		else
		{
			
		}
  }

}
