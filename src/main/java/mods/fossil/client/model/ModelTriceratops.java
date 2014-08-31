package mods.fossil.client.model;

import org.lwjgl.opengl.GL11;

import mods.fossil.entity.mob.EntityDinosaur;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTriceratops extends ModelDinosaurs
{


	private ModelRenderer headpivot;
	private ModelRenderer head;
	private ModelRenderer rightHorn;
	private ModelRenderer leftHorn;
	private ModelRenderer crest;
	private ModelRenderer triceratops;
	private ModelRenderer rightBackUpperLeg;
	private ModelRenderer beakHorn;
	private ModelRenderer beak;
	private ModelRenderer rightBackLowerLeg;
	private ModelRenderer leftBackUpperLeg;
	private ModelRenderer leftBackLowerLeg;
	private ModelRenderer leftFrontUpperLeg;
	private ModelRenderer leftFrontLowerLeg;
	private ModelRenderer rightFrontUpperLeg;
	private ModelRenderer rightFrontLowerLeg;
	private ModelRenderer lowerBody;
	private ModelRenderer tail1;
	private ModelRenderer tail2;
	private ModelRenderer tail3;
	private ModelRenderer neck;
	private ModelRenderer headdummy;
	private ModelRenderer upperBody;

	public ModelTriceratops()
  {
	    textureWidth = 128;
	    textureHeight = 64;
	    setTextureOffset("head.head", 0, 34);
	    setTextureOffset("rightHorn.rightHorn2", 33, 27);
	    setTextureOffset("rightHorn.rightHorn1", 32, 35);
	    setTextureOffset("leftHorn.leftHorn2", 33, 27);
	    setTextureOffset("leftHorn.leftHorn1", 32, 35);
	    setTextureOffset("crest.crest", 20, 0);
	    setTextureOffset("crest.crestHorns", 20, 8);
	    setTextureOffset("beak.beak", 0, 43);
	    setTextureOffset("beakHorn.beakHorn", 24, 37);
	    setTextureOffset("rightBackUpperLeg.rightBackUpperLeg", 12, 24);
	    setTextureOffset("rightBackLowerLeg.rightBackLowerLeg", 32, 19);
	    setTextureOffset("leftBackUpperLeg.leftBackUpperLeg", 12, 24);
	    setTextureOffset("leftBackLowerLeg.leftBackLowerLeg", 32, 19);
	    setTextureOffset("leftFrontUpperLeg.leftFrontUpperLeg", 0, 16);
	    setTextureOffset("leftFrontLowerLeg.leftFrontLowerLeg", 16, 19);
	    setTextureOffset("rightFrontUpperLeg.rightFrontUpperLeg", 0, 16);
	    setTextureOffset("rightFrontLowerLeg.rightFrontLowerLeg", 16, 19);
	    setTextureOffset("lowerBody.lowerBody", 104, 1);
	    setTextureOffset("tail1.tail1", 48, 10);
	    setTextureOffset("tail2.tail2", 68, 17);
	    setTextureOffset("tail3.tail3", 54, 21);
	    setTextureOffset("neck.neck", 0, 0);
	    setTextureOffset("headdummy.headdummy", 0, 0);
	    setTextureOffset("upperBody.upperBody", 77, 0);
	    
	    headpivot = new ModelRenderer(this, "headpivot");
	    headpivot.setRotationPoint(0F, 17.5F, -6F);
	    setRotation(headpivot, 0F, 0F, 0F);
	    headpivot.mirror = true;
	    head = new ModelRenderer(this, "head");
	    head.setRotationPoint(0F, 0F, 0F);
	    setRotation(head, 0F, 0F, 0F);
	    head.mirror = true;
	      head.addBox("head", -2F, -2F, -3.5F, 4, 4, 4);
	    rightHorn = new ModelRenderer(this, "rightHorn");
	    rightHorn.setRotationPoint(-0.9F, -2F, -0.5F);
	    setRotation(rightHorn, 0F, 0F, 0F);
	    rightHorn.mirror = true;
	      rightHorn.addBox("rightHorn2", -1F, 0F, -7.5F, 1, 1, 4);
	      rightHorn.addBox("rightHorn1", -1F, 0F, -3.5F, 1, 1, 4);
	      head.addChild(rightHorn);
	    leftHorn = new ModelRenderer(this, "leftHorn");
	    leftHorn.setRotationPoint(0.9F, -2F, -0.5F);
	    setRotation(leftHorn, 0F, 0F, 0F);
	    leftHorn.mirror = true;
	      leftHorn.addBox("leftHorn2", 0F, 0F, -7.5F, 1, 1, 4);
	      leftHorn.addBox("leftHorn1", 0F, 0F, -3.5F, 1, 1, 4);
	      head.addChild(leftHorn);
	    crest = new ModelRenderer(this, "crest");
	    crest.setRotationPoint(0F, 0F, -1F);
	    setRotation(crest, 0F, 0F, 0F);
	    crest.mirror = true;
	      crest.addBox("crest", -4F, -7F, 0F, 8, 7, 1);
	      crest.addBox("crestHorns", -5F, -7.6F, -0.1F, 10, 8, 1);
	      head.addChild(crest);
	    beak = new ModelRenderer(this, "beak");
	    beak.setRotationPoint(0F, -1F, -3.5F);
	    setRotation(beak, 0F, 0F, 0F);
	    beak.mirror = true;
	      beak.addBox("beak", -1F, 0F, -2.5F, 2, 3, 4);
	    beakHorn = new ModelRenderer(this, "beakHorn");
	    beakHorn.setRotationPoint(0F, 1F, -1F);
	    setRotation(beakHorn, 0F, 0F, 0F);
	    beakHorn.mirror = true;
	      beakHorn.addBox("beakHorn", -0.5F, -0.5F, -2F, 1, 1, 2);
	      beak.addChild(beakHorn);
	      head.addChild(beak);
	      headpivot.addChild(head);
	    triceratops = new ModelRenderer(this, "triceratops");
	    triceratops.setRotationPoint(0F, 16F, 0F);
	    setRotation(triceratops, 0F, 0F, 0F);
	    triceratops.mirror = true;
	    rightBackUpperLeg = new ModelRenderer(this, "rightBackUpperLeg");
	    rightBackUpperLeg.setRotationPoint(-3F, 1.5F, 3F);
	    setRotation(rightBackUpperLeg, 0F, 0F, 0F);
	    rightBackUpperLeg.mirror = true;
	      rightBackUpperLeg.mirror = true;
	      rightBackUpperLeg.addBox("rightBackUpperLeg", -2F, 0F, -1.5F, 2, 4, 3);
	      rightBackUpperLeg.mirror = false;
	    rightBackLowerLeg = new ModelRenderer(this, "rightBackLowerLeg");
	    rightBackLowerLeg.setRotationPoint(-1F, 2F, 0.0F);
	    setRotation(rightBackLowerLeg, 0F, 0F, 0F);
	    rightBackLowerLeg.mirror = true;
	      rightBackLowerLeg.mirror = true;
	      rightBackLowerLeg.addBox("rightBackLowerLeg", -0.5F, 0F, -4F, 1, 2, 4);
	      rightBackLowerLeg.mirror = false;
	      rightBackUpperLeg.addChild(rightBackLowerLeg);
	      triceratops.addChild(rightBackUpperLeg);
	    leftBackUpperLeg = new ModelRenderer(this, "leftBackUpperLeg");
	    leftBackUpperLeg.mirror = false;
	    leftBackUpperLeg.setRotationPoint(3F, 1.5F, 3F);
	    setRotation(leftBackUpperLeg, 0F, 0F, 0F);
	      leftBackUpperLeg.addBox("leftBackUpperLeg", 0F, 0F, -1.5F, 2, 4, 3);
	    leftBackLowerLeg = new ModelRenderer(this, "leftBackLowerLeg");
	    leftBackLowerLeg.setRotationPoint(1F, 2F, 0.0F);
	    setRotation(leftBackLowerLeg, 0F, 0F, 0F);
	    leftBackLowerLeg.mirror = true;
	      leftBackLowerLeg.addBox("leftBackLowerLeg", -0.5F, 0F, -4F, 1, 2, 4);
	      leftBackUpperLeg.addChild(leftBackLowerLeg);
	      triceratops.addChild(leftBackUpperLeg);
	    leftFrontUpperLeg = new ModelRenderer(this, "leftFrontUpperLeg");
	    leftFrontUpperLeg.setRotationPoint(3F, 3F, -3.5F);
	    setRotation(leftFrontUpperLeg, 0F, 0F, 0F);
	    leftFrontUpperLeg.mirror = true;
	      leftFrontUpperLeg.addBox("leftFrontUpperLeg", 0F, 0F, -1F, 2, 3, 2);
	    leftFrontLowerLeg = new ModelRenderer(this, "leftFrontLowerLeg");
	    leftFrontLowerLeg.setRotationPoint(1F, 2F, 0.5F);
	    setRotation(leftFrontLowerLeg, 0F, 0F, 0F);
	    leftFrontLowerLeg.mirror = true;
	      leftFrontLowerLeg.addBox("leftFrontLowerLeg", -0.5F, -1F, -3F, 1, 2, 3);
	      leftFrontUpperLeg.addChild(leftFrontLowerLeg);
	      triceratops.addChild(leftFrontUpperLeg);
	    rightFrontUpperLeg = new ModelRenderer(this, "rightFrontUpperLeg");
	    rightFrontUpperLeg.setRotationPoint(-3F, 3F, -3.5F);
	    setRotation(rightFrontUpperLeg, 0F, 0F, 0F);
	    rightFrontUpperLeg.mirror = true;
	      rightFrontUpperLeg.mirror = true;
	      rightFrontUpperLeg.addBox("rightFrontUpperLeg", -2F, 0F, -1F, 2, 3, 2);
	      rightFrontUpperLeg.mirror = false;
	    rightFrontLowerLeg = new ModelRenderer(this, "rightFrontLowerLeg");
	    rightFrontLowerLeg.setRotationPoint(-1F, 2F, 0.5F);
	    setRotation(rightFrontLowerLeg, 0F, 0F, 0F);
	    rightFrontLowerLeg.mirror = true;
	      rightFrontLowerLeg.mirror = true;
	      rightFrontLowerLeg.addBox("rightFrontLowerLeg", -0.5F, -1F, -3F, 1, 2, 3);
	      rightFrontLowerLeg.mirror = false;
	      rightFrontUpperLeg.addChild(rightFrontLowerLeg);
	      triceratops.addChild(rightFrontUpperLeg);
	    lowerBody = new ModelRenderer(this, "lowerBody");
	    lowerBody.setRotationPoint(0F, -0.1F, -0.5F);
	    setRotation(lowerBody, 0F, 0F, 0F);
	    lowerBody.mirror = true;
	      lowerBody.addBox("lowerBody", -3F, -1F, 0F, 6, 6, 6);
	    tail1 = new ModelRenderer(this, "tail1");
	    tail1.setRotationPoint(0F, 0.5F, 5.5F);
	    setRotation(tail1, 0F, 0F, 0F);
	    tail1.mirror = true;
	      tail1.addBox("tail1", -2.5F, -1.2F, 0F, 5, 4, 3);
	    tail2 = new ModelRenderer(this, "tail2");
	    tail2.setRotationPoint(0F, 0.5F, 3F);
	    setRotation(tail2, 0F, 0F, 0F);
	    tail2.mirror = true;
	      tail2.addBox("tail2", -1.5F, -1F, -0.5F, 3, 3, 3);
	    tail3 = new ModelRenderer(this, "tail3");
	    tail3.setRotationPoint(0F, 0.5F, 2.5F);
	    setRotation(tail3, 0F, 0F, 0F);
	    tail3.mirror = true;
	      tail3.addBox("tail3", -1F, -1F, 0F, 2, 2, 3);
	      tail2.addChild(tail3);
	      tail1.addChild(tail2);
	      lowerBody.addChild(tail1);
	      triceratops.addChild(lowerBody);
	    upperBody = new ModelRenderer(this, "upperBody");
	    upperBody.setRotationPoint(0F, 0F, 0F);
	    setRotation(upperBody, 0F, 0F, 0F);
	    upperBody.mirror = true;
	      upperBody.addBox("upperBody", -3.5F, -1.5F, -5F, 7, 6, 6);
	    neck = new ModelRenderer(this, "neck");
	    neck.setRotationPoint(0F, 3.5F, -5F);
	    setRotation(neck, 0F, 0F, 0F);
	    neck.mirror = true;
	      neck.addBox("neck", -1.5F, -4F, -3F, 3, 4, 3);
	    headdummy = new ModelRenderer(this, "headdummy");
	    headdummy.setRotationPoint(0F, -0.5F, -2.5F);
	    setRotation(headdummy, 0F, 0F, 0F);
	    headdummy.mirror = true;
	      headdummy.addBox("headdummy", -0.5F, -0.5F, -0.5F, 1, 1, 1);
	      neck.addChild(headdummy);
	      upperBody.addChild(neck);
	      triceratops.addChild(upperBody);
	  }
	
    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaur)var1).isModelized());
        this.triceratops.render(var7);
        this.headpivot.render(var7);
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean isModelized)
    {
    	
    	this.head.rotateAngleX = (float)Math.toRadians(19);
    	this.beak.rotateAngleX = (float)Math.toRadians(14);
    	this.beakHorn.rotateAngleX = (float)Math.toRadians(-80);
    	this.crest.rotateAngleX = (float)Math.toRadians(-30);
    	this.leftHorn.rotateAngleX = (float)Math.toRadians(-46);
    	this.rightHorn.rotateAngleX = (float)Math.toRadians(-46);
    	
    	this.upperBody.rotateAngleX = (float)Math.toRadians(9);
    	this.neck.rotateAngleX = (float)Math.toRadians(-25);
    	this.tail1.rotateAngleX = (float)Math.toRadians(-24);
    	this.tail2.rotateAngleX = (float)Math.toRadians(2);
    	this.tail3.rotateAngleX = (float)Math.toRadians(10);
    	
    	this.leftFrontLowerLeg.rotateAngleX = (float)Math.toRadians(90);
    	this.rightFrontLowerLeg.rotateAngleX = (float)Math.toRadians(90);
    	
    	this.leftBackLowerLeg.rotateAngleX = (float)Math.toRadians(90);
    	this.rightBackLowerLeg.rotateAngleX = (float)Math.toRadians(90);



    	
        if (!isModelized)
        {
	        this.headpivot.rotateAngleX = (var5*0.3F) / (180F / (float)Math.PI);
	        this.headpivot.rotateAngleY = (var4*0.3F) / (180F / (float)Math.PI);
	        
	        this.leftFrontUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 0.7F * var2;
	        this.rightFrontUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI) * 0.7F * var2;
	        this.leftBackUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI + 2) * 0.7F * var2;
	        this.rightBackUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 0.7F * var2;
	        
	        this.tail1.rotateAngleY = 0.06F * MathHelper.sin(var3 * (float)0.1F + (var2+2));
	        this.tail2.rotateAngleY = 0.07F * MathHelper.sin(var3 * (float)0.1F + (var2+1));
	        this.tail3.rotateAngleY = 0.07F * MathHelper.sin(var3 * (float)0.1F + (var2));

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
	        this.tail3.rotateAngleY = 0;
        }
        
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
    }
}