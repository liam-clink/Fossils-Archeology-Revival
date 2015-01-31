package mods.fossil.client.model;

import mods.fossil.entity.mob.EntityDinosaur;
import mods.fossil.entity.mob.EntityGallimimus;
import mods.fossil.entity.mob.EntityPlesiosaur;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelPlesiosaur extends ModelDinosaurs
{
  //fields
	private ModelRenderer Body;
	private ModelRenderer rightleg;
	private ModelRenderer leftleg;
	private ModelRenderer leftarm;
	private ModelRenderer rightarm;
	private ModelRenderer tail1;
	private ModelRenderer tail2;
	private ModelRenderer tail3;
	private ModelRenderer Neck1;
	private ModelRenderer Neck2;
	private ModelRenderer Neck4;
	private ModelRenderer Neck3;
	private ModelRenderer head;
	private float moveRate;
  
  public ModelPlesiosaur()
  {
    textureWidth = 64;
    textureHeight = 32;
    setTextureOffset("Body.Body", 0, 0);
    setTextureOffset("leftleg.leftleg", 48, 4);
    setTextureOffset("rightleg.rightleg", 48, 0);
    setTextureOffset("leftarm.leftarm", 44, 18);
    setTextureOffset("rightarm.rightarm", 44, 13);
    setTextureOffset("tail1.tail1", 0, 14);
    setTextureOffset("tail2.tail2", 18, 14);
    setTextureOffset("tail3.tail3", 24, 0);
    setTextureOffset("Neck1.Neck1", 20, 23);
    setTextureOffset("Neck2.Neck2", 47, 23);
    setTextureOffset("Neck3.Neck3", 35, 3);
    setTextureOffset("Neck4.Neck4", 35, 3);
    setTextureOffset("head.head", 0, 22);
    
    Body = new ModelRenderer(this, "Body");
    Body.setRotationPoint(0F, 19F, -4F);
    setRotation(Body, 0F, 0F, 0F);
    Body.mirror = true;
      Body.addBox("Body", -4F, -3F, 0F, 8, 6, 8);
    leftleg = new ModelRenderer(this, "leftleg");
    leftleg.setRotationPoint(4F, 2F, 7F);
    setRotation(leftleg, 0F, 0F, 0F);
    leftleg.mirror = true;
      leftleg.addBox("leftleg", 0F, 0F, -1.5F, 5, 1, 3);
      Body.addChild(leftleg);
    rightleg = new ModelRenderer(this, "rightleg");
    rightleg.setRotationPoint(-3F, 2F, 7F);
    setRotation(rightleg, 0F, 0F, 0F);
    rightleg.mirror = true;
      rightleg.addBox("rightleg", -6F, 0F, -1.5F, 5, 1, 3);
      Body.addChild(rightleg);
    leftarm = new ModelRenderer(this, "leftarm");
    leftarm.setRotationPoint(3F, 2F, 1F);
    setRotation(leftarm, 0F, 0F, 0F);
    leftarm.mirror = true;
      leftarm.addBox("leftarm", 0F, 0F, -4F, 6, 1, 4);
      Body.addChild(leftarm);
    rightarm = new ModelRenderer(this, "rightarm");
    rightarm.setRotationPoint(-3F, 2F, 1F);
    setRotation(rightarm, 0F, 0F, 0F);
    rightarm.mirror = true;
      rightarm.addBox("rightarm", -6F, 0F, -4F, 6, 1, 4);
      Body.addChild(rightarm);
    tail1 = new ModelRenderer(this, "tail1");
    tail1.setRotationPoint(0F, -3F, 8F);
    setRotation(tail1, 0F, 0F, 0F);
    tail1.mirror = true;
      tail1.addBox("tail1", -3F, 0F, 0F, 6, 5, 3);
    tail2 = new ModelRenderer(this, "tail2");
    tail2.setRotationPoint(0F, 3F, 2.5F);
    setRotation(tail2, 0F, 0F, 0F);
    tail2.mirror = true;
      tail2.addBox("tail2", -2F, -2F, 0F, 4, 3, 6);
    tail3 = new ModelRenderer(this, "tail3");
    tail3.setRotationPoint(0F, -1F, 5.5F);
    setRotation(tail3, 0F, 0F, 0F);
    tail3.mirror = true;
      tail3.addBox("tail3", -1F, -1F, 0F, 2, 2, 6);
      tail2.addChild(tail3);
      tail1.addChild(tail2);
      Body.addChild(tail1);
    this.Neck1 = new ModelRenderer(this, "Neck1");
    this.Neck1.setRotationPoint(0F, 0F, 1F);
    this.setRotation(Neck1, 0F, 0F, 0F);
    this.Neck1.mirror = true;
    this.Neck1.addBox("Neck1", -3F, -3F, -4F, 6, 5, 4);
    Neck2 = new ModelRenderer(this, "Neck2");
    Neck2.setRotationPoint(0F, 0F, -3F);
    setRotation(Neck2, (float)Math.toRadians(-60), 0F, 0F);
    Neck2.mirror = true;
      Neck2.addBox("Neck2", -2F, -2F, -5F, 4, 4, 5);
    Neck3 = new ModelRenderer(this, "Neck3");
    Neck3.setRotationPoint(0F, 1F, -4F);
    setRotation(Neck3, 0F, 0F, 0F);
    Neck3.mirror = true;
      Neck3.addBox("Neck3", -1F, -2F, -5F, 2, 3, 5);
    Neck4 = new ModelRenderer(this, "Neck4");
    Neck4.setRotationPoint(0F, 0F, -4F);
    setRotation(Neck4, 0F, 0F, 0F);
    Neck4.mirror = true;
      Neck4.addBox("Neck4", -1F, -2F, -5F, 2, 3, 5);
    head = new ModelRenderer(this, "head");
    head.setRotationPoint(0F, -0.5F, -4F);
    setRotation(head, 0F, 0F, 0F);
    head.mirror = true;
      head.addBox("head", -2F, -2F, -6F, 4, 4, 6);
      Neck4.addChild(head);
      Neck3.addChild(Neck4);
      Neck2.addChild(Neck3);
      Neck1.addChild(Neck2);
      Body.addChild(Neck1);
  }
  
  public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
  {
      super.render(var1, var2, var3, var4, var5, var6, var7);
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaur)var1).isModelized());
    this.Body.render(var7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

protected void setRotationAngles(float var1, float var2, float var3,
		float var4, float var5, float var6, boolean isModelized) {

	//this.Neck1.rotateAngleX = (float)Math.toRadians(-60);
	//this.Neck2.rotateAngleX = (float)Math.toRadians(10);
	//this.Neck3.rotateAngleX = (float)Math.toRadians(10);
	//this.Neck4.rotateAngleX = (float)Math.toRadians(20);
	
    if (!isModelized)
    {
        this.head.rotateAngleX =  (float)Math.toRadians(20) + (var5 / (180F / (float)Math.PI));
        this.head.rotateAngleY = var4 / (180F / (float)Math.PI);

        if(this.Neck1.rotateAngleX > (float)Math.toRadians(-10) )
        {
        	this.moveRate = 6F;
        
		this.Neck1.rotateAngleY = 0.01F * MathHelper.cos((var1 * (float)0.4F) + var2+3);
	    this.Neck2.rotateAngleY = 0.02F * MathHelper.cos((var1 * (float)0.4F) + var2+2);
	    this.Neck3.rotateAngleY = 0.03F * MathHelper.cos((var1 * (float)0.4F) + var2+1);
	    this.Neck4.rotateAngleY = 0.04F * MathHelper.cos((var1 * (float)0.4F) + var2);
	    this.head.rotateAngleY = -this.Neck4.rotateAngleY;
        }
        else
        	this.moveRate = 2F;

        this.Neck1.rotateAngleX = Math.min(Math.max(( (float)Math.toRadians(-60) + ((this.moveRate) * 1.0F * var2) ), (float)Math.toRadians(-60)), 0);
        this.Neck2.rotateAngleX = Math.min(Math.max(( (float)Math.toRadians(10) - ((this.moveRate * 0.6F) * 1.0F * var2) ), (float)Math.toRadians(0)), 10);
        this.Neck3.rotateAngleX = Math.min(Math.max(( (float)Math.toRadians(10) - ((this.moveRate* 0.5F) * 1.0F * var2) ), (float)Math.toRadians(0)), 10);
        this.Neck4.rotateAngleX = Math.min(Math.max(( (float)Math.toRadians(20) - ((this.moveRate* 0.4F) * 1.0F * var2) ), (float)Math.toRadians(0)), 20);

		this.leftarm.rotateAngleX = (float)Math.toRadians(25);
    	this.leftarm.rotateAngleY = (float)Math.toRadians(-45);
		this.leftarm.rotateAngleZ = (float)Math.toRadians(-0) + MathHelper.cos(var1 * 0.15F) * var2;
		
		this.rightarm.rotateAngleX = (float)Math.toRadians(25);
    	this.rightarm.rotateAngleY = (float)Math.toRadians(45);
		this.rightarm.rotateAngleZ = (float)Math.toRadians(0) + MathHelper.cos(var1 * 0.15F + 3.1415927F) * var2;
		
		this.leftleg.rotateAngleX = (float)Math.toRadians(25);
    	this.leftleg.rotateAngleY = (float)Math.toRadians(-45);
		this.leftleg.rotateAngleZ = (float)Math.toRadians(-0) - MathHelper.cos(var1 * 0.15F) * var2;
		
		this.rightleg.rotateAngleX = (float)Math.toRadians(25);
    	this.rightleg.rotateAngleY = (float)Math.toRadians(45);
		this.rightleg.rotateAngleZ = (float)Math.toRadians(0) - MathHelper.cos(var1 * 0.15F + 3.1415927F) * var2;
		
    	this.tail1.rotateAngleX = (float)Math.toRadians(-25);
    	this.tail2.rotateAngleX = (float)Math.toRadians(10);
    	this.tail3.rotateAngleX = (float)Math.toRadians(10);
    	
		this.tail1.rotateAngleY = 0.1F * MathHelper.cos((var1 * (float)0.4F) + var2+3);
	    this.tail2.rotateAngleY = 0.2F * MathHelper.cos((var1 * (float)0.4F) + var2+2);
	    this.tail3.rotateAngleY = 0.3F * MathHelper.cos((var1 * (float)0.4F) + var2+1);
    }
    else
    {
        this.head.rotateAngleX =  (float)Math.toRadians(30);
        this.head.rotateAngleY = 0;
        
    	this.Neck1.rotateAngleX = (float)Math.toRadians(-60);
    	this.Neck2.rotateAngleX = (float)Math.toRadians(10);
    	this.Neck3.rotateAngleX = (float)Math.toRadians(10);
    	this.Neck4.rotateAngleX = (float)Math.toRadians(20);
        
    	this.rightarm.rotateAngleX = (float)Math.toRadians(25.0);
    	this.rightarm.rotateAngleY = (float)Math.toRadians(45.0);
    	
    	this.leftarm.rotateAngleX = (float)Math.toRadians(25.0);
    	this.leftarm.rotateAngleY = (float)Math.toRadians(-45.0);
    	
    	this.rightleg.rotateAngleX = (float)Math.toRadians(25.0);
    	this.rightleg.rotateAngleY = (float)Math.toRadians(45.0);
    	
    	this.leftleg.rotateAngleX = (float)Math.toRadians(25.0);
    	this.leftleg.rotateAngleY = (float)Math.toRadians(-45.0);
    	
    	this.tail1.rotateAngleX = (float)Math.toRadians(-25);
    	this.tail2.rotateAngleX = (float)Math.toRadians(10);
    	this.tail3.rotateAngleX = (float)Math.toRadians(10);
    	
		this.tail1.rotateAngleY = 0;
	    this.tail2.rotateAngleY = 0;
	    this.tail3.rotateAngleY = 0;
    }
	
  }

}
