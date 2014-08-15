package mods.fossil.client.model;

import mods.fossil.entity.mob.EntityDinosaur;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTriceratops extends ModelDinosaurs
{

    private ModelRenderer upperBody;
	private ModelRenderer headpivot;
	private ModelRenderer head;
	private ModelRenderer nose;
	private ModelRenderer shortHorn;
	private ModelRenderer frill;
	private ModelRenderer leftHorn1;
	private ModelRenderer leftHorn2;
	private ModelRenderer rightHorn1;
	private ModelRenderer rightHorn2;
	private ModelRenderer frillBones;
	private ModelRenderer leftFrontUpperLeg;
	private ModelRenderer leftFrontLowerLeg;
	private ModelRenderer rightFrontUpperLeg;
	private ModelRenderer rightFrontLowerLeg;
	private ModelRenderer lowerBody;
	private ModelRenderer tail1;
	private ModelRenderer tail2;
	private ModelRenderer leftBackUpperLeg;
	private ModelRenderer leftBackLowerLeg;
	private ModelRenderer rightBackUpperLeg;
	private ModelRenderer rightBackLowerLeg;

	public ModelTriceratops()
  {
    textureWidth = 64;
    textureHeight = 32;
    setTextureOffset("head.head", 0, 0);
    setTextureOffset("nose.nose", 0, 10);
    setTextureOffset("shortHorn.shortHorn", 24, 24);
    setTextureOffset("frill.frill", 20, 0);
    setTextureOffset("leftHorn1.leftHorn1", 24, 27);
    setTextureOffset("leftHorn2.leftHorn2", 33, 27);
    setTextureOffset("rightHorn1.rightHorn1", 24, 27);
    setTextureOffset("rightHorn2.rightHorn2", 33, 27);
    setTextureOffset("frillBones.frillBones", 20, 8);
    setTextureOffset("upperBody.upperBody", 42, 0);
    setTextureOffset("leftFrontUpperLeg.leftFrontUpperLeg", 0, 16);
    setTextureOffset("leftFrontLowerLeg.leftFrontLowerLeg", 16, 19);
    setTextureOffset("rightFrontUpperLeg.rightFrontUpperLeg", 0, 20);
    setTextureOffset("rightFrontLowerLeg.rightFrontLowerLeg", 8, 19);
    setTextureOffset("lowerBody.lowerBody", 48, 10);
    setTextureOffset("tail1.tail1", 54, 17);
    setTextureOffset("tail2.tail2", 54, 21);
    setTextureOffset("leftBackUpperLeg.leftBackUpperLeg", 12, 24);
    setTextureOffset("leftBackLowerLeg.leftBackLowerLeg", 32, 19);
    setTextureOffset("rightBackUpperLeg.rightBackUpperLeg", 0, 24);
    setTextureOffset("rightBackLowerLeg.rightBackLowerLeg", 24, 19);
    
    upperBody = new ModelRenderer(this, "upperBody");
    upperBody.setRotationPoint(0F, 17F, -3F);
    setRotation(upperBody, 0F, 0F, 0F);
    upperBody.mirror = true;
    headpivot = new ModelRenderer(this, "headpivot");
    headpivot.setRotationPoint(0F, 1F, 0F);
    setRotation(headpivot, 0F, 0F, 0F);
    headpivot.mirror = true;
    head = new ModelRenderer(this, "head");
    head.setRotationPoint(0F, 0F, 0F);
    setRotation(head, 0F, 0F, 0F);
    head.mirror = true;
      head.addBox("head", -2F, 0F, -4F, 4, 4, 6);
    nose = new ModelRenderer(this, "nose");
    nose.setRotationPoint(0F, 1F, -4F);
    setRotation(nose, 0F, 0F, 0F);
    nose.mirror = true;
      nose.addBox("nose", -1F, 0F, -3F, 2, 3, 3);
    shortHorn = new ModelRenderer(this, "shortHorn");
    shortHorn.setRotationPoint(0F, 0.5F, -2F);
    setRotation(shortHorn, 0F, 0F, 0F);
    shortHorn.mirror = true;
      shortHorn.addBox("shortHorn", -0.5F, -0.5F, -2F, 1, 1, 2);
      nose.addChild(shortHorn);
      head.addChild(nose);
    frill = new ModelRenderer(this, "frill");
    frill.setRotationPoint(0F, 2F, -2F);
    setRotation(frill, 0F, 0F, 0F);
    frill.mirror = true;
      frill.addBox("frill", -4F, -7F, 0F, 8, 7, 1);
    leftHorn1 = new ModelRenderer(this, "leftHorn1");
    leftHorn1.setRotationPoint(2F, -2.5F, 0F);
    setRotation(leftHorn1, 0F, 0F, 0F);
      leftHorn1.addBox("leftHorn1", -0.5F, -0.5F, -4F, 1, 1, 4);
    leftHorn2 = new ModelRenderer(this, "leftHorn2");
    leftHorn2.setRotationPoint(0F, 0F, -3F);
    setRotation(leftHorn2, 0F, 0F, 0F);
      leftHorn2.addBox("leftHorn2", -0.5F, -0.5F, -4F, 1, 1, 4);
      leftHorn1.addChild(leftHorn2);
      frill.addChild(leftHorn1);
    rightHorn1 = new ModelRenderer(this, "rightHorn1");
    rightHorn1.setRotationPoint(-2F, -2.5F, 0F);
    setRotation(rightHorn1, 0F, 0F, 0F);
      rightHorn1.addBox("rightHorn1", -0.5F, -0.5F, -4F, 1, 1, 4);
    rightHorn2 = new ModelRenderer(this, "rightHorn2");
    rightHorn2.setRotationPoint(0F, 0F, -3F);
    setRotation(rightHorn2, 0F, 0F, 0F);
      rightHorn2.addBox("rightHorn2", -0.5F, -0.5F, -4F, 1, 1, 4);
      rightHorn1.addChild(rightHorn2);
      frill.addChild(rightHorn1);
    frillBones = new ModelRenderer(this, "frillBones");
    frillBones.setRotationPoint(0F, 0F, 0F);
    setRotation(frillBones, 0F, 0F, 0F);
    frillBones.mirror = true;
      frillBones.addBox("frillBones", -5F, -8F, 0F, 10, 8, 1);
      frill.addChild(frillBones);
      head.addChild(frill);
      headpivot.addChild(head);
      upperBody.addChild(headpivot);
      upperBody.addBox("upperBody", -3F, 0F, 0F, 6, 5, 5);
    leftFrontUpperLeg = new ModelRenderer(this, "leftFrontUpperLeg");
    leftFrontUpperLeg.mirror = false;
    leftFrontUpperLeg.setRotationPoint(1.8F, 3F, 0F);
    setRotation(leftFrontUpperLeg, 0F, 0F, 0F);
      leftFrontUpperLeg.addBox("leftFrontUpperLeg", 0F, 0F, -1F, 2, 2, 2);
    leftFrontLowerLeg = new ModelRenderer(this, "leftFrontLowerLeg");
    leftFrontLowerLeg.setRotationPoint(1F, 1F, 0F);
    setRotation(leftFrontLowerLeg, 0F, 0F, 0F);
    leftFrontLowerLeg.mirror = true;
      leftFrontLowerLeg.addBox("leftFrontLowerLeg", -0.5F, -0.5F, -3F, 1, 2, 3);
      leftFrontUpperLeg.addChild(leftFrontLowerLeg);
      upperBody.addChild(leftFrontUpperLeg);
    rightFrontUpperLeg = new ModelRenderer(this, "rightFrontUpperLeg");
    rightFrontUpperLeg.mirror = false;
    rightFrontUpperLeg.setRotationPoint(-1.8F, 3F, 0F);
    setRotation(rightFrontUpperLeg, 0F, 0F, 0F);
      rightFrontUpperLeg.addBox("rightFrontUpperLeg", -2F, 0F, -1F, 2, 2, 2);
    rightFrontLowerLeg = new ModelRenderer(this, "rightFrontLowerLeg");
    rightFrontLowerLeg.setRotationPoint(-1F, 1F, 0F);
    setRotation(rightFrontLowerLeg, 0F, 0F, 0F);
    rightFrontLowerLeg.mirror = true;
      rightFrontLowerLeg.addBox("rightFrontLowerLeg", -0.5F, -0.5F, -3F, 1, 2, 3);
      rightFrontUpperLeg.addChild(rightFrontLowerLeg);
      upperBody.addChild(rightFrontUpperLeg);
    lowerBody = new ModelRenderer(this, "lowerBody");
    lowerBody.setRotationPoint(0F, 1F, 5F);
    setRotation(lowerBody, 0F, 0F, 0F);
    lowerBody.mirror = true;
      lowerBody.addBox("lowerBody", -2.5F, -0.2F, 0F, 5, 4, 3);
    tail1 = new ModelRenderer(this, "tail1");
    tail1.setRotationPoint(0F, 1F, 3F);
    setRotation(tail1, 0F, 0F, 0F);
    tail1.mirror = true;
      tail1.addBox("tail1", -1.5F, 0F, 0F, 3, 2, 2);
    tail2 = new ModelRenderer(this, "tail2");
    tail2.setRotationPoint(0F, 1F, 2F);
    setRotation(tail2, 0F, 0F, 0F);
    tail2.mirror = true;
      tail2.addBox("tail2", -1F, 0F, -0.5F, 2, 1, 3);
      tail1.addChild(tail2);
      lowerBody.addChild(tail1);
    leftBackUpperLeg = new ModelRenderer(this, "leftBackUpperLeg");
    leftBackUpperLeg.mirror = false;
    leftBackUpperLeg.setRotationPoint(2F, 1F, 5F);
    setRotation(leftBackUpperLeg, 0F, 0F, 0F);
      leftBackUpperLeg.addBox("leftBackUpperLeg", 0F, 0F, -2F, 2, 4, 4);
    leftBackLowerLeg = new ModelRenderer(this, "leftBackLowerLeg");
    leftBackLowerLeg.setRotationPoint(1F, 3.5F, 0F);
    setRotation(leftBackLowerLeg, 0F, 0F, 0F);
    leftBackLowerLeg.mirror = true;
      leftBackLowerLeg.addBox("leftBackLowerLeg", -0.5F, -1F, -3F, 1, 2, 3);
      leftBackUpperLeg.addChild(leftBackLowerLeg);
      upperBody.addChild(leftBackUpperLeg);
    rightBackUpperLeg = new ModelRenderer(this, "rightBackUpperLeg");
    rightBackUpperLeg.mirror = false;
    rightBackUpperLeg.setRotationPoint(-2F, 1F, 5F);
    setRotation(rightBackUpperLeg, 0F, 0F, 0F);
      rightBackUpperLeg.addBox("rightBackUpperLeg", -2F, 0F, -2F, 2, 4, 4);
    rightBackLowerLeg = new ModelRenderer(this, "rightBackLowerLeg");
    rightBackLowerLeg.setRotationPoint(-1F, 3.5F, 0F);
    setRotation(rightBackLowerLeg, 0F, 0F, 0F);
    rightBackLowerLeg.mirror = false;
      rightBackLowerLeg.addBox("rightBackLowerLeg", -0.5F, -1F, -3F, 1, 2, 3);
      rightBackUpperLeg.addChild(rightBackLowerLeg);
      upperBody.addChild(rightBackUpperLeg);
      upperBody.addChild(lowerBody);
  }
	
    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaur)var1).isModelized());
        this.upperBody.render(var7);
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean isModelized)
    {
    	
    	this.head.rotateAngleX = (float)Math.toRadians(8);
    	this.nose.rotateAngleX = (float)Math.toRadians(40);
    	this.shortHorn.rotateAngleX = (float)Math.toRadians(-105);
    	this.frill.rotateAngleX = (float)Math.toRadians(-30);
    	
    	this.lowerBody.rotateAngleX = (float)Math.toRadians(-15);
    	this.tail1.rotateAngleX = (float)Math.toRadians(-10);
    	this.tail2.rotateAngleX = (float)Math.toRadians(10);
    	
    	this.leftFrontLowerLeg.rotateAngleX = (float)Math.toRadians(90);
    	this.rightFrontLowerLeg.rotateAngleX = (float)Math.toRadians(90);
    	
    	this.leftBackLowerLeg.rotateAngleX = (float)Math.toRadians(90);
    	this.rightBackLowerLeg.rotateAngleX = (float)Math.toRadians(90);


    	
    	
        if (!isModelized)
        {
	        this.headpivot.rotateAngleX = (var5*0.25F) / (180F / (float)Math.PI);
	        this.headpivot.rotateAngleY = (var4*0.25F) / (180F / (float)Math.PI);
	        
	        this.leftFrontUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 1.0F * var2;
	        this.rightFrontUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI) * 1.0F * var2;
	        this.leftBackUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI + 2) * 1.0F * var2;
	        this.rightBackUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 1.0F * var2;
	        
	        this.tail1.rotateAngleY = 0.06F * MathHelper.sin(var3 * (float)0.1F + (var2+1));
	        this.tail2.rotateAngleY = 0.07F * MathHelper.sin(var3 * (float)0.1F + (var2));
        }
        else
        {
	        this.headpivot.rotateAngleX = 0;
	        this.headpivot.rotateAngleY = 0;
	        
	        this.leftFrontUpperLeg.rotateAngleX = 0;
	        this.rightFrontUpperLeg.rotateAngleX = 0;
	        this.leftBackUpperLeg.rotateAngleX = 0;
	        this.rightBackUpperLeg.rotateAngleX = 0;
	        
	    	this.leftFrontLowerLeg.rotateAngleX = (float)Math.toRadians(90);
	    	this.rightFrontLowerLeg.rotateAngleX = (float)Math.toRadians(90);
	    	
	    	this.leftBackLowerLeg.rotateAngleX = (float)Math.toRadians(90);
	    	this.rightBackLowerLeg.rotateAngleX = (float)Math.toRadians(90);
	        
	        this.tail1.rotateAngleY = 0;
	        this.tail2.rotateAngleY = 0;
        }
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
    }
}