package mods.fossil.client.model;

import mods.fossil.entity.mob.EntityDinosaur;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLiopleurodon extends ModelDinosaurs
{

  
  private ModelRenderer LowerBody;
private ModelRenderer BackFlipper_Right;
private ModelRenderer Tail;
private ModelRenderer Tail1;
private ModelRenderer Tail2;
private ModelRenderer BackFlipper_Left;
private ModelRenderer UpperBody;
private ModelRenderer Neck;
private ModelRenderer Head;
private ModelRenderer JawTop;
private ModelRenderer Teeth;
private ModelRenderer JawBottomBase;
private ModelRenderer JawBottom;
private ModelRenderer FrontFlipper_Right;
private ModelRenderer FrontFlipper_Left;

public ModelLiopleurodon()
  {
	    textureWidth = 128;
	    textureHeight = 64;
	    setTextureOffset("LowerBody.LowerBody", 34, 9);
	    setTextureOffset("BackFlipper_Right.BackFlipper_Right", 59, 49);
	    setTextureOffset("Tail.Tail", 80, 28);
	    setTextureOffset("Tail1.Tail1", 79, 13);
	    setTextureOffset("Tail2.Tail2", 84, 2);
	    setTextureOffset("BackFlipper_Left.BackFlipper_Left", 59, 49);
	    setTextureOffset("UpperBody.UpperBody", 30, 35);
	    setTextureOffset("Neck.Neck", 29, 52);
	    setTextureOffset("Neck.Neck2", 32, 55);
	    setTextureOffset("Head.Head", 0, 0);
	    setTextureOffset("JawTop.JawTop", 0, 12);
	    setTextureOffset("Teeth.Teeth", 0, 51);
	    setTextureOffset("JawBottomBase.JawBottomBase", 0, 27);
	    setTextureOffset("JawBottom.JawBottom", 0, 37);
	    setTextureOffset("FrontFlipper_Right.FrontFlipper_Right", 72, 45);
	    setTextureOffset("FrontFlipper_Left.FrontFlipper_Left", 72, 45);
	    
	    LowerBody = new ModelRenderer(this, "LowerBody");
	    LowerBody.setRotationPoint(0F, 14F, -1F);
	    setRotation(LowerBody, 0F, 0F, 0F);
	    LowerBody.mirror = true;
	      LowerBody.addBox("LowerBody", -4F, -5F, 0F, 8, 10, 14);
	    BackFlipper_Right = new ModelRenderer(this, "BackFlipper_Right");
	    BackFlipper_Right.setRotationPoint(-3.5F, 1F, 13F);
	    setRotation(BackFlipper_Right, 0F, 0F, 0F);
	    BackFlipper_Right.mirror = false;
	      BackFlipper_Right.addBox("BackFlipper_Right", -0.5F, 0F, -2F, 1, 9, 5);
	      LowerBody.addChild(BackFlipper_Right);
	    Tail = new ModelRenderer(this, "Tail");
	    Tail.setRotationPoint(0F, -0.5F, 13F);
	    setRotation(Tail, 0F, 0F, 0F);
	    Tail.mirror = true;
	      Tail.addBox("Tail", -3F, -4F, 0F, 6, 8, 8);
	    Tail1 = new ModelRenderer(this, "Tail1");
	    Tail1.setRotationPoint(0F, -0.5F, 7F);
	    setRotation(Tail1, 0F, 0F, 0F);
	    Tail1.mirror = true;
	      Tail1.addBox("Tail1", -2F, -3F, 0F, 4, 6, 8);
	    Tail2 = new ModelRenderer(this, "Tail2");
	    Tail2.setRotationPoint(0F, -0.5F, 7F);
	    setRotation(Tail2, 0F, 0F, 0F);
	    Tail2.mirror = true;
	      Tail2.addBox("Tail2", -1.5F, -2F, 0F, 3, 4, 6);
	      Tail1.addChild(Tail2);
	      Tail.addChild(Tail1);
	      LowerBody.addChild(Tail);
	    BackFlipper_Left = new ModelRenderer(this, "BackFlipper_Left");
	    BackFlipper_Left.setRotationPoint(3.5F, 1F, 13F);
	    setRotation(BackFlipper_Left, 0F, 0F, 0F);
	    BackFlipper_Left.mirror = true;
	      BackFlipper_Left.addBox("BackFlipper_Left", -0.5F, 0F, -2F, 1, 9, 5);
	      BackFlipper_Left.mirror = false;
	      LowerBody.addChild(BackFlipper_Left);
	    UpperBody = new ModelRenderer(this, "UpperBody");
	    UpperBody.setRotationPoint(0F, -0.5F, -6F);
	    setRotation(UpperBody, 0F, 0F, 0F);
	    UpperBody.mirror = true;
	      UpperBody.addBox("UpperBody", -4F, -4F, 0F, 8, 8, 6);
	    Neck = new ModelRenderer(this, "Neck");
	    Neck.setRotationPoint(0F, 0F, 3F);
	    setRotation(Neck, 0F, 0F, 0F);
	    Neck.mirror = true;
	      Neck.addBox("Neck", -2.5F, -3F, -10F, 5, 6, 5);
	      Neck.addBox("Neck2", -2.5F, -3F, -5F, 5, 6, 2);
	    Head = new ModelRenderer(this, "Head");
	    Head.setRotationPoint(0F, -1.1F, -9F);
	    setRotation(Head, 0F, 0F, 0F);
	    Head.mirror = true;
	      Head.addBox("Head", -3F, -2F, -8F, 6, 4, 8);
	    JawTop = new ModelRenderer(this, "JawTop");
	    JawTop.setRotationPoint(0F, 0F, -6.5F);
	    setRotation(JawTop, 0F, 0F, 0F);
	    JawTop.mirror = true;
	      JawTop.addBox("JawTop", -2F, -1F, -12F, 4, 3, 12);
	    Teeth = new ModelRenderer(this, "Teeth");
	    Teeth.setRotationPoint(0F, 0F, 0F);
	    setRotation(Teeth, 0F, 0F, 0F);
	    Teeth.mirror = true;
	      Teeth.addBox("Teeth", -2F, 2F, -12F, 4, 1, 10);
	      JawTop.addChild(Teeth);
	      Head.addChild(JawTop);
	    JawBottomBase = new ModelRenderer(this, "JawBottomBase");
	    JawBottomBase.setRotationPoint(0F, 3F, -1F);
	    setRotation(JawBottomBase, 0F, 0F, 0F);
	    JawBottomBase.mirror = true;
	      JawBottomBase.addBox("JawBottomBase", -2.5F, -1F, -7F, 5, 3, 7);
	    JawBottom = new ModelRenderer(this, "JawBottom");
	    JawBottom.setRotationPoint(0F, 0F, 0F);
	    setRotation(JawBottom, 0F, 0F, 0F);
	    JawBottom.mirror = true;
	      JawBottom.addBox("JawBottom", -1.5F, -1F, -17.5F, 3, 3, 11);
	      JawBottomBase.addChild(JawBottom);
	      Head.addChild(JawBottomBase);
	      Neck.addChild(Head);
	      UpperBody.addChild(Neck);
	    FrontFlipper_Right = new ModelRenderer(this, "FrontFlipper_Right");
	    FrontFlipper_Right.setRotationPoint(-3.5F, 2F, 3F);
	    setRotation(FrontFlipper_Right, 0F, 0F, 0F);
	    FrontFlipper_Right.mirror = false;
	      FrontFlipper_Right.addBox("FrontFlipper_Right", -0.5F, 0F, -3F, 1, 12, 6);
	      UpperBody.addChild(FrontFlipper_Right);
	    FrontFlipper_Left = new ModelRenderer(this, "FrontFlipper_Left");
	    FrontFlipper_Left.setRotationPoint(3.5F, 2F, 3F);
	    setRotation(FrontFlipper_Left, 0F, 0F, 0F);
	    FrontFlipper_Left.mirror = true;
	      FrontFlipper_Left.mirror = true;
	      FrontFlipper_Left.addBox("FrontFlipper_Left", -0.5F, 0F, -3F, 1, 12, 6);
	      FrontFlipper_Left.mirror = false;
	      UpperBody.addChild(FrontFlipper_Left);
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

protected void setRotationAngles(float var1, float var2, float var3,
		float var4, float var5, float var6, boolean isModelized) {
	
	/////// Setup initial rotations
	/*
	this.FrontFlipper_Left.rotateAngleX = (float)Math.toRadians(10);
	this.FrontFlipper_Left.rotateAngleZ = (float)Math.toRadians(-60);
	
	this.FrontFlipper_Right.rotateAngleX = (float)Math.toRadians(10);
	this.FrontFlipper_Right.rotateAngleZ = (float)Math.toRadians(60);
	
	this.BackFlipper_Left.rotateAngleX = (float)Math.toRadians(30);
	this.BackFlipper_Left.rotateAngleZ = (float)Math.toRadians(-60);
	
	this.BackFlipper_Right.rotateAngleX = (float)Math.toRadians(30);
	this.BackFlipper_Right.rotateAngleZ = (float)Math.toRadians(60);
	*/
	
	this.Tail.rotateAngleX = (float)Math.toRadians(-50);
	this.Tail1.rotateAngleX = (float)Math.toRadians(15);
	this.Tail2.rotateAngleX = (float)Math.toRadians(5);
	
	this.Head.rotateAngleX = (float)Math.toRadians(4);
	this.JawBottomBase.rotateAngleX = -this.Head.rotateAngleX;
	//////////////////////
	
	
	if(!isModelized)
	{
		this.LowerBody.rotateAngleY = 0.1F * MathHelper.cos((var1 * (float)0.4F) + var2+3);
	    this.Tail.rotateAngleY = 0.2F * MathHelper.cos((var1 * (float)0.4F) + var2+2);
	    this.Tail1.rotateAngleY = 0.3F * MathHelper.cos((var1 * (float)0.4F) + var2+1);
		this.JawBottomBase.rotateAngleX = -this.Head.rotateAngleX;
	    this.LowerBody.rotationPointY = 19F; 
	    
	    this.Neck.rotateAngleX = 0;
	    this.LowerBody.rotateAngleX = 0;
		this.Tail.rotateAngleX = (float)Math.toRadians(-6);
		this.Tail1.rotateAngleX = (float)Math.toRadians(4);
		this.Tail2.rotateAngleX = (float)Math.toRadians(2);
		
		this.FrontFlipper_Left.rotateAngleX = (float)Math.toRadians(10);
		this.FrontFlipper_Left.rotateAngleZ = (float)Math.toRadians(-70) + MathHelper.cos(var1 * 0.25F) * var2;
		
		this.FrontFlipper_Right.rotateAngleX = (float)Math.toRadians(10);
		this.FrontFlipper_Right.rotateAngleZ = (float)Math.toRadians(70) + MathHelper.cos(var1 * 0.25F + 3.1415927F) * var2;
		
		this.BackFlipper_Left.rotateAngleX = (float)Math.toRadians(30);
		this.BackFlipper_Left.rotateAngleZ = (float)Math.toRadians(-70) - MathHelper.cos(var1 * 0.25F) * var2;
		
		this.BackFlipper_Right.rotateAngleX = (float)Math.toRadians(30);
		this.BackFlipper_Right.rotateAngleZ = (float)Math.toRadians(70) - MathHelper.cos(var1 * 0.25F + 3.1415927F) * var2;
	}
	else
	{
		this.LowerBody.rotateAngleY = (float)Math.toRadians(-10);;
	    this.Tail.rotateAngleY = (float)Math.toRadians(-10);;
	    this.Tail1.rotateAngleY = (float)Math.toRadians(-10);;
	    this.JawBottomBase.rotateAngleX = (float)Math.toRadians(20);
	    this.LowerBody.rotationPointY = 19F; 
	    
	    this.Neck.rotateAngleX = (float)Math.toRadians(-30);
	    this.LowerBody.rotateAngleX = (float)Math.toRadians(5);
		this.Tail.rotateAngleX = (float)Math.toRadians(-4);
		this.Tail1.rotateAngleX = (float)Math.toRadians(4);
		this.Tail2.rotateAngleX = (float)Math.toRadians(2);
	    
		this.FrontFlipper_Left.rotateAngleZ = (float)Math.toRadians(-70);
		this.FrontFlipper_Right.rotateAngleZ = (float)Math.toRadians(70);
	    
		this.FrontFlipper_Left.rotateAngleX = (float)Math.toRadians(10);
		
		this.FrontFlipper_Right.rotateAngleX = (float)Math.toRadians(10);
		
		this.BackFlipper_Left.rotateAngleX = (float)Math.toRadians(30);
		this.BackFlipper_Left.rotateAngleZ = (float)Math.toRadians(-60);
		
		this.BackFlipper_Right.rotateAngleX = (float)Math.toRadians(30);
		this.BackFlipper_Right.rotateAngleZ = (float)Math.toRadians(60);
	}
	
	
}

}