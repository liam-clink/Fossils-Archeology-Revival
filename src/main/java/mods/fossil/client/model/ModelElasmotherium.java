package mods.fossil.client.model;

import org.lwjgl.opengl.GL11;

import mods.fossil.entity.mob.EntityElasmotherium;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.MathHelper;

public class ModelElasmotherium extends ModelBase
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
	private ModelRenderer neck;
	private ModelRenderer headdummy;
	private ModelRenderer upperBody;
	private ModelRenderer lowerJaw;
	private ModelRenderer upperJaw;
	private ModelRenderer torso;
	private ModelRenderer upperHorn;
	private ModelRenderer lowerHorn;
	private ModelRenderer elasmotherium;

    public ModelElasmotherium()
    {
        textureWidth = 256;
        textureHeight = 128;
        setTextureOffset("leftBackUpperLeg.leftBackUpperLeg", 89, 60);
        setTextureOffset("leftBackLowerLeg.leftBackLowerLeg", 68, 98);
        setTextureOffset("rightBackUpperLeg.rightBackUpperLeg", 89, 60);
        setTextureOffset("rightBackLowerLeg.rightBackLowerLeg", 68, 98);
        setTextureOffset("rightFrontUpperLeg.rightFrontUpperLeg", 157, 0);
        setTextureOffset("rightFrontLowerLeg.rightFrontLowerLeg", 68, 98);
        setTextureOffset("leftFrontUpperLeg.leftFrontUpperLeg", 157, 0);
        setTextureOffset("leftFrontLowerLeg.leftFrontLowerLeg", 68, 98);
        setTextureOffset("torso.torso", 0, 0);
        setTextureOffset("upperBody.upperBody", 0, 64);
        setTextureOffset("neck.neck", 0, 102);
        setTextureOffset("head.head", 0, 42);
        setTextureOffset("lowerJaw.lowerJaw", 78, 81);
        setTextureOffset("upperJaw.upperJaw", 86, 42);
        setTextureOffset("lowerHorn.lowerHorn", 57, 61);
        setTextureOffset("upperHorn.upperHorn", 53, 44);
        setTextureOffset("lowerBody.lowerBody", 89, 0);
        setTextureOffset("tail1.tail1", 0, 0);
        
        elasmotherium = new ModelRenderer(this, "elasmotherium");
        elasmotherium.setRotationPoint(0F, 24F, 0F);
        setRotation(elasmotherium, 0F, 0F, 0F);
        elasmotherium.mirror = true;
        leftBackUpperLeg = new ModelRenderer(this, "leftBackUpperLeg");
        leftBackUpperLeg.setRotationPoint(6F, -16.5F, 20.5F);
        setRotation(leftBackUpperLeg, 0F, 0F, 0F);
        leftBackUpperLeg.mirror = true;
          leftBackUpperLeg.mirror = true;
          leftBackUpperLeg.addBox("leftBackUpperLeg", 0F, 0F, -2.9F, 4, 10, 6);
          leftBackUpperLeg.mirror = false;
        leftBackLowerLeg = new ModelRenderer(this, "leftBackLowerLeg");
        leftBackLowerLeg.setRotationPoint(1F, 8F, 2F);
        setRotation(leftBackLowerLeg, 0F, 0F, 0F);
        leftBackLowerLeg.mirror = true;
          leftBackLowerLeg.mirror = true;
          leftBackLowerLeg.addBox("leftBackLowerLeg", -2F, 0.5F, -3.5F, 4, 8, 5);
          leftBackLowerLeg.mirror = false;
          leftBackUpperLeg.addChild(leftBackLowerLeg);
          elasmotherium.addChild(leftBackUpperLeg);
        rightBackUpperLeg = new ModelRenderer(this, "rightBackUpperLeg");
        rightBackUpperLeg.setRotationPoint(-6F, -16.5F, 20.5F);
        setRotation(rightBackUpperLeg, 0F, 0F, 0F);
        rightBackUpperLeg.mirror = true;
          rightBackUpperLeg.addBox("rightBackUpperLeg", -4F, 0F, -2.9F, 4, 10, 6);
        rightBackLowerLeg = new ModelRenderer(this, "rightBackLowerLeg");
        rightBackLowerLeg.setRotationPoint(-1F, 8F, 2F);
        setRotation(rightBackLowerLeg, 0F, 0F, 0F);
        rightBackLowerLeg.mirror = true;
          rightBackLowerLeg.addBox("rightBackLowerLeg", -2F, 0.5F, -3.5F, 4, 8, 5);
          rightBackUpperLeg.addChild(rightBackLowerLeg);
          elasmotherium.addChild(rightBackUpperLeg);
        rightFrontUpperLeg = new ModelRenderer(this, "rightFrontUpperLeg");
        rightFrontUpperLeg.setRotationPoint(-7F, -17.5F, -7F);
        setRotation(rightFrontUpperLeg, 0F, 0F, 0F);
        rightFrontUpperLeg.mirror = true;
          rightFrontUpperLeg.addBox("rightFrontUpperLeg", -3.6F, 0F, -3F, 4, 10, 6);
        rightFrontLowerLeg = new ModelRenderer(this, "rightFrontLowerLeg");
        rightFrontLowerLeg.setRotationPoint(-1F, 9.5F, -0.3F);
        setRotation(rightFrontLowerLeg, 0F, 0F, 0F);
        rightFrontLowerLeg.mirror = true;
          rightFrontLowerLeg.addBox("rightFrontLowerLeg", -2.2F, 0F, -2F, 4, 8, 5);
          rightFrontUpperLeg.addChild(rightFrontLowerLeg);
          elasmotherium.addChild(rightFrontUpperLeg);
        leftFrontUpperLeg = new ModelRenderer(this, "leftFrontUpperLeg");
        leftFrontUpperLeg.setRotationPoint(7F, -17.5F, -7F);
        setRotation(leftFrontUpperLeg, 0F, 0F, 0F);
        leftFrontUpperLeg.mirror = true;
          leftFrontUpperLeg.mirror = true;
          leftFrontUpperLeg.addBox("leftFrontUpperLeg", -0.2F, 0F, -3F, 4, 10, 6);
          leftFrontUpperLeg.mirror = false;
        leftFrontLowerLeg = new ModelRenderer(this, "leftFrontLowerLeg");
        leftFrontLowerLeg.setRotationPoint(1F, 9.5F, -0.3F);
        setRotation(leftFrontLowerLeg, 0F, 0F, 0F);
        leftFrontLowerLeg.mirror = true;
          leftFrontLowerLeg.mirror = true;
          leftFrontLowerLeg.addBox("leftFrontLowerLeg", -1.8F, 0F, -2F, 4, 8, 5);
          leftFrontLowerLeg.mirror = false;
          leftFrontUpperLeg.addChild(leftFrontLowerLeg);
          elasmotherium.addChild(leftFrontUpperLeg);
        torso = new ModelRenderer(this, "torso");
        torso.setRotationPoint(0F, -16.5F, -2.5F);
        setRotation(torso, 0F, 0F, 0F);
        torso.mirror = true;
          torso.addBox("torso", -8F, -11F, 0F, 16, 22, 17);
        upperBody = new ModelRenderer(this, "upperBody");
        upperBody.setRotationPoint(0F, -10.5F, 1F);
        setRotation(upperBody, 0F, 0F, 0F);
        upperBody.mirror = true;
          upperBody.addBox("upperBody", -7F, -1F, -11F, 14, 22, 11);
        neck = new ModelRenderer(this, "neck");
        neck.setRotationPoint(0F, 10.5F, -8F);
        setRotation(neck, 0F, 0F, 0F);
        neck.mirror = true;
          neck.addBox("neck", -5.5F, -8F, -9F, 11, 16, 9);
        head = new ModelRenderer(this, "head");
        head.setRotationPoint(0F, -4F, -9.5F);
        setRotation(head, 0F, 0F, 0F);
        head.mirror = true;
          head.addBox("head", -4.5F, -3F, -4F, 9, 10, 7);
        lowerJaw = new ModelRenderer(this, "lowerJaw");
        lowerJaw.setRotationPoint(0F, 4F, -2.8F);
        setRotation(lowerJaw, 0F, 0F, 0F);
        lowerJaw.mirror = true;
          lowerJaw.addBox("lowerJaw", -1.5F, -1.5F, -7F, 3, 3, 7);
          head.addChild(lowerJaw);
        upperJaw = new ModelRenderer(this, "upperJaw");
        upperJaw.setRotationPoint(0F, 0F, -3F);
        setRotation(upperJaw, 0F, 0F, 0F);
        upperJaw.mirror = true;
          upperJaw.addBox("upperJaw", -2.5F, -3F, -7F, 5, 6, 7);
        lowerHorn = new ModelRenderer(this, "lowerHorn");
        lowerHorn.setRotationPoint(0F, -2.5F, -1F);
        setRotation(lowerHorn, 0F, 0F, 0F);
        lowerHorn.mirror = true;
          lowerHorn.addBox("lowerHorn", -1.5F, -8F, -2F, 3, 8, 4);
        upperHorn = new ModelRenderer(this, "upperHorn");
        upperHorn.setRotationPoint(0F, -5F, 0F);
        setRotation(upperHorn, 0F, 0F, 0F);
        upperHorn.mirror = true;
          upperHorn.addBox("upperHorn", -1F, -12F, -1F, 2, 12, 2);
          lowerHorn.addChild(upperHorn);
          upperJaw.addChild(lowerHorn);
          head.addChild(upperJaw);
          neck.addChild(head);
          upperBody.addChild(neck);
          torso.addChild(upperBody);
        lowerBody = new ModelRenderer(this, "lowerBody");
        lowerBody.setRotationPoint(0F, -9.5F, 16F);
        setRotation(lowerBody, 0F, 0F, 0F);
        lowerBody.mirror = true;
          lowerBody.addBox("lowerBody", -6F, 0F, 0F, 12, 18, 12);
        tail1 = new ModelRenderer(this, "tail1");
        tail1.setRotationPoint(0F, 8F, 12F);
        setRotation(tail1, 0F, 0F, 0F);
        tail1.mirror = true;
          tail1.addBox("tail1", -1F, 0F, -3F, 2, 8, 3);
          lowerBody.addChild(tail1);
          torso.addChild(lowerBody);
          elasmotherium.addChild(torso);
      }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        EntityElasmotherium entity = (EntityElasmotherium)var1;
        this.setRotationAngles(var2, var3, var4, var5, var6, var7);
        
        boolean isAdult = entity.isAdult();
        float childSize = entity.getEntitySize();
        
        GL11.glPushMatrix();

        if (!isAdult)
        {
            GL11.glScalef(childSize, childSize, childSize);
            GL11.glTranslatef(0.0F, 2.0F - childSize * 2, 0.0F);
        }
        else
        {
            GL11.glScalef(1.5F, 1.5F, 1.5F);
            GL11.glTranslatef(0.0F, -0.5F, 0.0F);
        }
        
        this.elasmotherium.render(var7);
        
        GL11.glPopMatrix();
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
    {
    	this.lowerBody.rotateAngleX = (float)Math.toRadians(-5);
    	this.upperBody.rotateAngleX = (float)Math.toRadians(7);
    	//this.neck.rotateAngleX = (float)Math.toRadians(10);
    	this.lowerHorn.rotateAngleX = (float)Math.toRadians(10);
    	this.upperHorn.rotateAngleX = (float)Math.toRadians(-5);
    	this.tail1.rotateAngleX = (float)Math.toRadians(30);


    	
        this.leftFrontUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 0.7F * var2;
        this.rightFrontUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI) * 0.7F * var2;
        this.leftBackUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI + 2) * 0.7F * var2;
        this.rightBackUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 0.7F * var2;
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLivingBase entity, float var2, float var3, float var4)
    {
        EntityElasmotherium elasmotherium = (EntityElasmotherium)entity;
        int attackTimer = elasmotherium.getattackTimer();
        if (attackTimer > 0)
        {
            this.neck.rotateAngleX = (float)Math.toRadians(-30) + 0.125F * this.swingProgress((float)attackTimer - var4, 10.0F);
        }
        else
        {
                this.neck.rotateAngleX = (float)Math.toRadians(10);
        }

    }

    private float swingProgress(float var1, float var2)
    {
        return (Math.abs(var1 % var2 - var2 * 0.5F) - var2 * 0.25F) / (var2 * 0.25F);
    }
}
