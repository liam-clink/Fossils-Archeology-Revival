package mods.fossil.client.model;

import mods.fossil.entity.mob.EntityDeinonychus;
import mods.fossil.entity.mob.EntityDinosaur;
import mods.fossil.entity.mob.EntityStegosaurus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import scala.util.parsing.combinator.PackratParsers.Head;



public class ModelStegosaurus extends ModelDinosaurs
{
  //fields
	private ModelRenderer lowerBody;
	private ModelRenderer platesLowerBody;
	private ModelRenderer stegosaurus;
	private ModelRenderer rightBackUpperLeg;
	private ModelRenderer rightBackLowerLeg;
	private ModelRenderer rightFrontUpperLeg;
	private ModelRenderer rightFrontLowerLeg;
	private ModelRenderer upperBody;
	private ModelRenderer platesUpperBody;
	private ModelRenderer neck;
	private ModelRenderer platesNeck;
	private ModelRenderer head;
	private ModelRenderer tail1;
	private ModelRenderer platesTail2;
	private ModelRenderer tail3;
	private ModelRenderer tail2;
	private ModelRenderer leftThagomizer;
	private ModelRenderer rightThagomizer;
	private ModelRenderer platesTail1;
	private ModelRenderer leftFrontUpperLeg;
	private ModelRenderer leftFrontLowerLeg;
	private ModelRenderer leftBackUpperLeg;
	private ModelRenderer leftBackLowerLeg;
	private ModelRenderer headdummy;
	private ModelRenderer headpivot;

  
  public ModelStegosaurus()
  {
	    textureWidth = 128;
	    textureHeight = 64;
	    setTextureOffset("head.head", 0, 0);
	    setTextureOffset("lowerBody.lowerBody", 18, 6);
	    setTextureOffset("platesLowerBody.platesLowerBody", 32, 51);
	    setTextureOffset("tail1.tail1", 0, 23);
	    setTextureOffset("tail2.tail2", 20, 24);
	    setTextureOffset("platesTail2.platesTail2", 71, 42);
	    setTextureOffset("tail3.tail3", 7, 34);
	    setTextureOffset("leftThagomizer.leftThagomizer", 0, 55);
	    setTextureOffset("rightThagomizer.rightThagomizer", 0, 55);
	    setTextureOffset("platesTail1.platesTail1", 20, 55);
	    setTextureOffset("rightBackUpperLeg.rightBackUpperLeg", 14, 46);
	    setTextureOffset("rightBackLowerLeg.rightBackLowerLeg", 0, 38);
	    setTextureOffset("rightFrontUpperLeg.rightFrontUpperLeg", 44, 46);
	    setTextureOffset("rightFrontLowerLeg.rightFrontLowerLeg", 12, 0);
	    setTextureOffset("upperBody.upperBody", 0, 14);
	    setTextureOffset("platesUpperBody.platesUpperBody", 52, 55);
	    setTextureOffset("neck.neck", 0, 8);
	    setTextureOffset("platesNeck.platesNeck", 64, 56);
	    setTextureOffset("leftFrontUpperLeg.leftFrontUpperLeg", 44, 46);
	    setTextureOffset("leftFrontLowerLeg.leftFrontLowerLeg", 12, 0);
	    setTextureOffset("leftBackUpperLeg.leftBackUpperLeg", 14, 46);
	    setTextureOffset("leftBackLowerLeg.leftBackLowerLeg", 0, 38);
	    
	    headpivot = new ModelRenderer(this, "headpivot");
	    headpivot.setRotationPoint(0F, 16.5F, -12.5F);
	    setRotation(headpivot, 0F, 0F, 0F);
	    headpivot.mirror = true;
	    head = new ModelRenderer(this, "head");
	    head.setRotationPoint(0F, 0F, 1F);
	    setRotation(head, 0F, 0F, 0F);
	    head.mirror = true;
	      head.addBox("head", -1F, -1.6F, -5F, 2, 3, 5);
	      headpivot.addChild(head);
	    stegosaurus = new ModelRenderer(this, "stegosaurus");
	    stegosaurus.setRotationPoint(0F, 13F, -6F);
	    setRotation(stegosaurus, 0F, 0F, 0F);
	    stegosaurus.mirror = true;
	    lowerBody = new ModelRenderer(this, "lowerBody");
	    lowerBody.setRotationPoint(0F, 0F, 0F);
	    setRotation(lowerBody, 0F, 0F, 0F);
	    lowerBody.mirror = true;
	      lowerBody.addBox("lowerBody", -3.5F, 0F, 0F, 7, 8, 8);
	    platesLowerBody = new ModelRenderer(this, "platesLowerBody");
	    platesLowerBody.setRotationPoint(0F, 0.5F, 4.5F);
	    setRotation(platesLowerBody, 0F, 0F, 0F);
	    platesLowerBody.mirror = true;
	      platesLowerBody.addBox("platesLowerBody", -1F, -5F, -4F, 2, 5, 8);
	      lowerBody.addChild(platesLowerBody);
	    tail1 = new ModelRenderer(this, "tail1");
	    tail1.setRotationPoint(0F, 2F, 8F);
	    setRotation(tail1, 0F, 0F, 0F);
	    tail1.mirror = true;
	      tail1.addBox("tail1", -2.5F, -1.5F, -1F, 5, 5, 5);
	    tail2 = new ModelRenderer(this, "tail2");
	    tail2.setRotationPoint(0F, 0F, 2.733333F);
	    setRotation(tail2, 0F, 0F, 0F);
	    tail2.mirror = true;
	      tail2.addBox("tail2", -1.5F, -1F, 0.5F, 3, 3, 6);
	    platesTail2 = new ModelRenderer(this, "platesTail2");
	    platesTail2.setRotationPoint(0F, -0.5F, 3F);
	    setRotation(platesTail2, 0F, 0F, 0F);
	    platesTail2.mirror = true;
	      platesTail2.addBox("platesTail2", -0.5F, -5F, -3F, 1, 5, 8);
	      tail2.addChild(platesTail2);
	    tail3 = new ModelRenderer(this, "tail3");
	    tail3.setRotationPoint(0F, -0.9F, 5.5F);
	    setRotation(tail3, 0F, 0F, 0F);
	    tail3.mirror = true;
	      tail3.addBox("tail3", -1F, 0F, 0.5F, 2, 2, 4);
	    leftThagomizer = new ModelRenderer(this, "leftThagomizer");
	    leftThagomizer.setRotationPoint(0.5F, 0.5F, 3F);
	    setRotation(leftThagomizer, 0F, 0F, 0F);
	    leftThagomizer.mirror = true;
	      leftThagomizer.addBox("leftThagomizer", 0F, -5F, -1F, 1, 5, 4);
	      tail3.addChild(leftThagomizer);
	    rightThagomizer = new ModelRenderer(this, "rightThagomizer");
	    rightThagomizer.setRotationPoint(-0.5F, 0.5F, 3F);
	    setRotation(rightThagomizer, 0F, 0F, 0F);
	    rightThagomizer.mirror = false;
	      rightThagomizer.addBox("rightThagomizer", -1F, -5F, -1F, 1, 5, 4);
	      tail3.addChild(rightThagomizer);
	      tail2.addChild(tail3);
	      tail1.addChild(tail2);
	    platesTail1 = new ModelRenderer(this, "platesTail1");
	    platesTail1.setRotationPoint(0F, -1.5F, 1.5F);
	    setRotation(platesTail1, 0F, 0F, 0F);
	    platesTail1.mirror = true;
	      platesTail1.addBox("platesTail1", -1F, -4.5F, -2F, 2, 5, 4);
	      tail1.addChild(platesTail1);
	      lowerBody.addChild(tail1);
	      stegosaurus.addChild(lowerBody);
	    rightBackUpperLeg = new ModelRenderer(this, "rightBackUpperLeg");
	    rightBackUpperLeg.setRotationPoint(-4F, 3.5F, 7F);
	    setRotation(rightBackUpperLeg, 0F, 0F, 0F);
	    rightBackUpperLeg.mirror = true;
	      rightBackUpperLeg.mirror = true;
	      rightBackUpperLeg.addBox("rightBackUpperLeg", -1F, -0.5F, -2F, 2, 5, 4);
	      rightBackUpperLeg.mirror = false;
	    rightBackLowerLeg = new ModelRenderer(this, "rightBackLowerLeg");
	    rightBackLowerLeg.setRotationPoint(0F, 4F, 1F);
	    setRotation(rightBackLowerLeg, 0F, 0F, 0F);
	    rightBackLowerLeg.mirror = true;
	      rightBackLowerLeg.mirror = true;
	      rightBackLowerLeg.addBox("rightBackLowerLeg", -0.5F, -0.5F, -3.5F, 1, 2, 5);
	      rightBackLowerLeg.mirror = false;
	      rightBackUpperLeg.addChild(rightBackLowerLeg);
	      stegosaurus.addChild(rightBackUpperLeg);
	    rightFrontUpperLeg = new ModelRenderer(this, "rightFrontUpperLeg");
	    rightFrontUpperLeg.setRotationPoint(-4F, 5F, 0F);
	    setRotation(rightFrontUpperLeg, 0F, 0F, 0F);
	    rightFrontUpperLeg.mirror = true;
	      rightFrontUpperLeg.mirror = true;
	      rightFrontUpperLeg.addBox("rightFrontUpperLeg", -1F, 0.0F, -1F, 2, 3, 2);
	      rightFrontUpperLeg.mirror = false;
	    rightFrontLowerLeg = new ModelRenderer(this, "rightFrontLowerLeg");
	    rightFrontLowerLeg.setRotationPoint(0F, 3F, -0.5F);
	    setRotation(rightFrontLowerLeg, 0F, 0F, 0F);
	    rightFrontLowerLeg.mirror = true;
	      rightFrontLowerLeg.mirror = true;
	      rightFrontLowerLeg.addBox("rightFrontLowerLeg", -0.5F, 0F, -3F, 1, 2, 3);
	      rightFrontLowerLeg.mirror = false;
	      rightFrontUpperLeg.addChild(rightFrontLowerLeg);
	      stegosaurus.addChild(rightFrontUpperLeg);
	    upperBody = new ModelRenderer(this, "upperBody");
	    upperBody.setRotationPoint(0F, 1F, 0.5F);
	    setRotation(upperBody, 0F, 0F, 0F);
	    upperBody.mirror = true;
	      upperBody.addBox("upperBody", -2.5F, 0F, -4F, 5, 5, 4);
	    platesUpperBody = new ModelRenderer(this, "platesUpperBody");
	    platesUpperBody.setRotationPoint(0F, 0F, -2F);
	    setRotation(platesUpperBody, 0F, 0F, 0F);
	    platesUpperBody.mirror = true;
	      platesUpperBody.mirror = true;
	      platesUpperBody.addBox("platesUpperBody", -1F, -4F, -2F, 2, 5, 4);
	      platesUpperBody.mirror = false;
	      upperBody.addChild(platesUpperBody);
	    neck = new ModelRenderer(this, "neck");
	    neck.setRotationPoint(0F, 3F, -3.5F);
	    setRotation(neck, 0F, 0F, 0F);
	    neck.mirror = true;
	      neck.addBox("neck", -1.5F, -2F, -3F, 3, 3, 3);
	    platesNeck = new ModelRenderer(this, "platesNeck");
	    platesNeck.setRotationPoint(0F, -2F, 0F);
	    setRotation(platesNeck, 0F, 0F, 0F);
	    platesNeck.mirror = true;
	      platesNeck.addBox("platesNeck", -0.5F, -3F, -2.433333F, 1, 4, 4);
	      neck.addChild(platesNeck);
	    headdummy = new ModelRenderer(this, "headdummy");
	    headdummy.setRotationPoint(0F, -0.5F, -2.5F);
	    setRotation(headdummy, 0F, 0F, 0F);
	    headdummy.mirror = true;
	      neck.addChild(headdummy);
	      upperBody.addChild(neck);
	      stegosaurus.addChild(upperBody);
	    leftFrontUpperLeg = new ModelRenderer(this, "leftFrontUpperLeg");
	    leftFrontUpperLeg.setRotationPoint(4F, 5F, 0F);
	    setRotation(leftFrontUpperLeg, 0F, 0F, 0F);
	    leftFrontUpperLeg.mirror = true;
	      leftFrontUpperLeg.addBox("leftFrontUpperLeg", -1F, 0F, -1F, 2, 3, 2);
	    leftFrontLowerLeg = new ModelRenderer(this, "leftFrontLowerLeg");
	    leftFrontLowerLeg.setRotationPoint(0F, 3F, -0.5F);
	    setRotation(leftFrontLowerLeg, 0F, 0F, 0F);
	    leftFrontLowerLeg.mirror = true;
	      leftFrontLowerLeg.addBox("leftFrontLowerLeg", -0.5F, 0F, -3F, 1, 2, 3);
	      leftFrontUpperLeg.addChild(leftFrontLowerLeg);
	      stegosaurus.addChild(leftFrontUpperLeg);
	    leftBackUpperLeg = new ModelRenderer(this, "leftBackUpperLeg");
	    leftBackUpperLeg.setRotationPoint(4F, 3.5F, 7F);
	    setRotation(leftBackUpperLeg, 0F, 0F, 0F);
	    leftBackUpperLeg.mirror = true;
	      leftBackUpperLeg.addBox("leftBackUpperLeg", -1F, -0.5F, -2F, 2, 5, 4);
	    leftBackLowerLeg = new ModelRenderer(this, "leftBackLowerLeg");
	    leftBackLowerLeg.setRotationPoint(0F, 4F, 1F);
	    setRotation(leftBackLowerLeg, 0F, 0F, 0F);
	    leftBackLowerLeg.mirror = true;
	      leftBackLowerLeg.addBox("leftBackLowerLeg", -0.5F, -0.5F, -3.5F, 1, 2, 5);
	      leftBackUpperLeg.addChild(leftBackLowerLeg);
	      stegosaurus.addChild(leftBackUpperLeg);
	  }
  
  
  public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
  {
      super.render(var1, var2, var3, var4, var5, var6, var7);
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaur)var1).isModelized());
    stegosaurus.render(var7);
    headpivot.render(var7);
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
	  this.lowerBody.rotateAngleX = (float)Math.toRadians(5);
	  this.upperBody.rotateAngleX = (float)Math.toRadians(7F);
	  this.neck.rotateAngleX = (float)Math.toRadians(-14F);
	  this.head.rotateAngleX = (float)Math.toRadians(15F);
	  
	  this.leftBackLowerLeg.rotateAngleX = (float)Math.toRadians(90);
	  this.rightBackLowerLeg.rotateAngleX = (float)Math.toRadians(90);
	  this.leftFrontLowerLeg.rotateAngleX = (float)Math.toRadians(90);
	  this.rightFrontLowerLeg.rotateAngleX = (float)Math.toRadians(90);
	  
      this.tail1.rotateAngleX = (float)Math.toRadians(-15);
      this.tail2.rotateAngleX = (float)Math.toRadians(5);
      this.tail3.rotateAngleX = (float)Math.toRadians(3);
      
      this.rightThagomizer.rotateAngleZ = (float)Math.toRadians(-67);
      this.leftThagomizer.rotateAngleZ = (float)Math.toRadians(67);
      
      this.rightThagomizer.rotateAngleY = (float)Math.toRadians(13);
      this.leftThagomizer.rotateAngleY = (float)Math.toRadians(-13);
	  
	  
		//Living animations
		if(!isModelized)
		{
		      this.head.rotateAngleX =  var5 / (180F / (float)Math.PI);
		      this.head.rotateAngleY = var4 / (180F / (float)Math.PI);
		      
		      this.tail1.rotateAngleY = 0.05F * MathHelper.sin(var3 * (float)0.1F + (var2+2));
		      this.tail2.rotateAngleY = 0.1F * MathHelper.sin(var3 * (float)0.1F + (var2+1));
		      this.tail3.rotateAngleY = 0.15F * MathHelper.sin(var3 * (float)0.1F + var2);
		      
		      this.leftFrontUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 0.7F * var2;
		      this.rightFrontUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI) * 0.7F * var2;
		      this.leftBackUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI + 2) * 0.7F * var2;
		      this.rightBackUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 0.7F * var2;
		}
		else
		{
			this.head.rotateAngleX =  0;
			this.head.rotateAngleY = 0;
			
			this.leftFrontUpperLeg	.rotateAngleX = 0;
			this.rightFrontUpperLeg	.rotateAngleX = 0;
			this.leftBackUpperLeg	.rotateAngleX = 0;
			this.rightBackUpperLeg	.rotateAngleX = 0;
			
			this.tail1.rotateAngleY = 0;
			this.tail2.rotateAngleY = 0;
			this.tail3.rotateAngleY = 0;
		}
  }
  

}
