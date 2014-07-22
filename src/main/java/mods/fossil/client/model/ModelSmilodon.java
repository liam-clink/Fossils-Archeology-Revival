package mods.fossil.client.model;

import mods.fossil.Fossil;
import mods.fossil.entity.mob.EntitySmilodon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

public class ModelSmilodon extends ModelBase
{
    protected float field_40331_g = 4.0F;
    protected float field_40332_n = 2.0F;
    ModelRenderer Head = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 32);
    ModelRenderer Nose;
    ModelRenderer UpperJaw;
    ModelRenderer LowerJaw;
    ModelRenderer ToothUpperRight;
    ModelRenderer ToothUpperLeft;
    ModelRenderer ToothLowerRight;
    ModelRenderer ToothLowerLeft;
    ModelRenderer UpperBody;
    ModelRenderer LowerBody;
    ModelRenderer Tail;
    ModelRenderer Front_ThighRight;
    ModelRenderer Front_ThighLeft;
    ModelRenderer Back_ThighRight;
    ModelRenderer Back_ThighLeft;
    ModelRenderer EarRight;
    ModelRenderer EarLeft;
    ModelRenderer C1;
    ModelRenderer C2;

    public ModelSmilodon()
    {
        this.Head.addBox(-2.5F, -1.5F, -4.0F, 5, 4, 4);
        this.Head.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
        this.Head.mirror = true;
        this.Nose = (new ModelRenderer(this, 18, 0)).setTextureSize(64, 32);
        this.Nose.addBox(-1.0F, -1.0F, -7.0F, 2, 1, 3);
        this.Nose.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.Nose, 0.0F, 0.0F, 0.0F);
        this.Nose.mirror = true;
        this.UpperJaw = (new ModelRenderer(this, 18, 5)).setTextureSize(64, 32);
        this.UpperJaw.addBox(-2.0F, 0.0F, -7.0F, 4, 2, 3);
        this.UpperJaw.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.UpperJaw, 0.0F, 0.0F, 0.0F);
        this.UpperJaw.mirror = true;
        this.LowerJaw = (new ModelRenderer(this, 48, 7)).setTextureSize(64, 32);
        this.LowerJaw.addBox(-1.0F, 0.0F, -3.5F, 2, 1, 3);
        this.LowerJaw.setRotationPoint(0.0F, 1.5F, -3.0F);
        this.setRotation(this.LowerJaw, 0.1745329F, 0.0F, 0.0F);
        this.LowerJaw.mirror = true;
        UpperJaw.addChild(LowerJaw);
        this.ToothUpperRight = (new ModelRenderer(this, 44, 14)).setTextureSize(64, 32);
        this.ToothUpperRight.addBox(-1.5F, 2.0F, -6.0F, 1, 2, 1);
        this.ToothUpperRight.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.ToothUpperRight, 0.0F, 0.0F, 0.0F);
        this.ToothUpperRight.mirror = true;
        this.ToothUpperLeft = (new ModelRenderer(this, 44, 14)).setTextureSize(64, 32);
        this.ToothUpperLeft.addBox(0.5F, 2.0F, -6.0F, 1, 2, 1);
        this.ToothUpperLeft.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.ToothUpperLeft, 0.0F, 0.0F, 0.0F);
        this.ToothUpperLeft.mirror = true;
        this.ToothLowerRight = (new ModelRenderer(this, 44, 17)).setTextureSize(64, 32);
        this.ToothLowerRight.addBox(-1.5F, 4.0F, -6.0F, 1, 2, 1);
        this.ToothLowerRight.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.ToothLowerRight, 0.0F, 0.0F, 0.0F);
        this.ToothLowerRight.mirror = true;
        this.ToothLowerLeft = (new ModelRenderer(this, 44, 17)).setTextureSize(64, 32);
        this.ToothLowerLeft.addBox(0.5F, 4.0F, -6.0F, 1, 2, 1);
        this.ToothLowerLeft.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.ToothLowerLeft, 0.0F, 0.0F, 0.0F);
        this.ToothLowerLeft.mirror = true;
        this.UpperBody = (new ModelRenderer(this, 0, 11)).setTextureSize(64, 32);
        this.UpperBody.addBox(-3.5F, -2.5F, -3.0F, 7, 6, 4);
        this.UpperBody.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.setRotation(this.UpperBody, 0.0F, 0.0F, 0.0F);
        this.UpperBody.mirror = true;
        this.LowerBody = (new ModelRenderer(this, 0, 21)).setTextureSize(64, 32);
        this.LowerBody.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 6);
        this.LowerBody.setRotationPoint(0.0F, 16.0F, 1.0F);
        this.setRotation(this.LowerBody, 0.0F, 0.0F, 0.0F);
        this.LowerBody.mirror = true;
        this.Tail = (new ModelRenderer(this, 44, 7)).setTextureSize(64, 32);
        this.Tail.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
        this.Tail.setRotationPoint(0.0F, 14.0F, 6.5F);
        this.setRotation(this.Tail, 0.5576792F, 0.0F, 0.0F);
        this.Tail.mirror = true;
        this.Front_ThighRight = (new ModelRenderer(this, 40, 0)).setTextureSize(64, 32);
        this.Front_ThighRight.addBox(-1.0F, -0.5F, -1.0F, 2, 5, 2);
        this.Front_ThighRight.setRotationPoint(-1.5F, 19.0F, -2.0F);
        this.setRotation(this.Front_ThighRight, 0.0F, 0.0F, 0.0F);
        this.Front_ThighRight.mirror = true;
        this.Front_ThighLeft = (new ModelRenderer(this, 32, 0)).setTextureSize(64, 32);
        this.Front_ThighLeft.addBox(-1.0F, -0.5F, -1.0F, 2, 5, 2);
        this.Front_ThighLeft.setRotationPoint(1.5F, 19.0F, -2.0F);
        this.setRotation(this.Front_ThighLeft, 0.0F, 0.0F, 0.0F);
        this.Front_ThighLeft.mirror = true;
        this.Back_ThighRight = (new ModelRenderer(this, 56, 0)).setTextureSize(64, 32);
        this.Back_ThighRight.addBox(-1.0F, -0.5F, -1.0F, 2, 5, 2);
        this.Back_ThighRight.setRotationPoint(-1.5F, 19.0F, 6.0F);
        this.setRotation(this.Back_ThighRight, 0.0F, 0.0F, 0.0F);
        this.Back_ThighRight.mirror = true;
        this.Back_ThighLeft = (new ModelRenderer(this, 48, 0)).setTextureSize(64, 32);
        this.Back_ThighLeft.addBox(-1.0F, -0.5F, -1.0F, 2, 5, 2);
        this.Back_ThighLeft.setRotationPoint(1.5F, 19.0F, 6.0F);
        this.setRotation(this.Back_ThighLeft, 0.0F, 0.0F, 0.0F);
        this.Back_ThighLeft.mirror = true;
        this.EarRight = (new ModelRenderer(this, 6, 8)).setTextureSize(64, 32);
        this.EarRight.addBox(-2.5F, -2.5F, -3.0F, 1, 1, 2);
        this.EarRight.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.EarRight, 0.0F, 0.0F, 0.0F);
        this.EarRight.mirror = true;
        this.EarLeft = (new ModelRenderer(this, 0, 8)).setTextureSize(64, 32);
        this.EarLeft.addBox(1.5F, -2.5F, -3.0F, 1, 1, 2);
        this.EarLeft.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.EarLeft, 0.0F, 0.0F, 0.0F);
        this.EarLeft.mirror = true;
        this.C1 = (new ModelRenderer(this, 22, 20)).setTextureSize(64, 32);
        this.C1.addBox(-4.0F, -3.0F, -3.5F, 8, 7, 5);
        this.C1.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.setRotation(this.C1, 0.0F, 0.0F, 0.0F);
        this.C1.mirror = true;
        this.C2 = (new ModelRenderer(this, 22, 10)).setTextureSize(64, 32);
        this.C2.addBox(-3.0F, -2.0F, -4.5F, 6, 5, 5);
        this.C2.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.C2, 0.0F, 0.0F, 0.0F);
        this.C2.mirror = true;
    }



    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
        float var8 = 2.0F;

        if (this.isChild)
        {
            float var9 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 0.0F, 0.0F);
            this.Head.render(var7);
            this.Nose.render(var7);
            this.UpperJaw.render(var7);
           // this.LowerJaw.render(var7);
            this.ToothUpperRight.render(var7);
            this.ToothUpperLeft.render(var7);
            this.ToothLowerRight.render(var7);
            this.ToothLowerLeft.render(var7);
            this.EarRight.render(var7);
            this.EarLeft.render(var7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(2.0F / var9, 2.0F / var9, 2.0F / var9);
            GL11.glTranslatef(0.0F, 0.0F, 0.0F);
            this.UpperBody.render(var7);
            this.LowerBody.render(var7);
            this.Tail.render(var7);
            this.Front_ThighRight.render(var7);
            this.Front_ThighLeft.render(var7);
            this.Back_ThighRight.render(var7);
            this.Back_ThighLeft.render(var7);
            this.C1.render(var7);
            this.C2.render(var7);
            GL11.glPopMatrix();
        }
        else
        {
            GL11.glPushMatrix();
            GL11.glScalef(2.0F, 2.0F, 2.0F);
            GL11.glTranslatef(0.0F, -0.8F, 0.0F);
            this.Head.render(var7);
            this.Nose.render(var7);
            this.UpperJaw.render(var7);
          //  this.LowerJaw.render(var7);
            this.ToothUpperRight.render(var7);
            this.ToothUpperLeft.render(var7);
            this.ToothLowerRight.render(var7);
            this.ToothLowerLeft.render(var7);
            this.UpperBody.render(var7);
            this.LowerBody.render(var7);
            this.Tail.render(var7);
            this.Front_ThighRight.render(var7);
            this.Front_ThighLeft.render(var7);
            this.Back_ThighRight.render(var7);
            this.Back_ThighLeft.render(var7);
            this.EarRight.render(var7);
            this.EarLeft.render(var7);
            this.C1.render(var7);
            this.C2.render(var7);
            GL11.glPopMatrix();
        }
    }


    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }
    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7)
    {
    	
        super.setRotationAngles(var1, var2, var3, var4, var5, var6, var7);
        this.Head.rotateAngleX = var5 / (180F / (float)Math.PI);

        
        this.EarLeft.rotateAngleX = this.EarRight.rotateAngleX 
        		= this.Nose.rotateAngleX = this.UpperJaw.rotateAngleX
        		= this.ToothUpperRight.rotateAngleX = this.ToothUpperLeft.rotateAngleX
        		= this.ToothLowerRight.rotateAngleX = this.ToothLowerLeft.rotateAngleX = this.Head.rotateAngleX;
        this.Head.rotateAngleY = var4 / (180F / (float)Math.PI);
        this.EarLeft.rotateAngleY = this.EarRight.rotateAngleY 
		= this.Nose.rotateAngleY = this.UpperJaw.rotateAngleY 
		= this.ToothUpperRight.rotateAngleY = this.ToothUpperLeft.rotateAngleY
		= this.ToothLowerRight.rotateAngleY = this.ToothLowerLeft.rotateAngleY = this.Head.rotateAngleY;
     //   this.Tail.rotateAngleX = var3;
        
     //   this.Front_ThighLeft.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 1.0F * var2;
     //   this.Front_ThighRight.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI) * 1.0F * var2;
     //   this.Back_ThighLeft.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float)Math.PI + 2) * 1.0F * var2;
     //   this.Back_ThighRight.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 1.0F * var2;
    }

    
    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLivingBase var1, float var2, float var3, float var4)
    {
        EntitySmilodon var5 = (EntitySmilodon)var1;

        if (var5.isAngry())
        {
            this.Tail.rotateAngleY = 0.0F;
        }
        else
        {
            this.Tail.rotateAngleY = MathHelper.cos(var2 * 0.6662F) * 1.4F * var3;
        }

        if (var5.isSitting())
        {
            this.UpperBody.setRotationPoint(0.0F, 17.0F, 0.0F);
            this.UpperBody.rotateAngleX = -0.314F;
            this.UpperBody.rotateAngleY = 0.0F;
            this.C1.setRotationPoint(0.0F, 17.0F, 0.0F);
            this.C1.rotateAngleX = -0.314F;
            this.C1.rotateAngleY = 0.0F;
            this.LowerBody.setRotationPoint(0.0F, 20.0F, -1.0F);
            this.LowerBody.rotateAngleX = -((float)Math.PI / 4F);
            this.Tail.setRotationPoint(0.0F, 23.0F, 4.5F);
            this.Back_ThighRight.setRotationPoint(-1.5F, 25.0F, 1.0F);
            this.Back_ThighRight.rotateAngleX = ((float)Math.PI * 3F / 2F);
            this.Back_ThighLeft.setRotationPoint(1.5F, 25.0F, 1.0F);
            this.Back_ThighLeft.rotateAngleX = ((float)Math.PI * 3F / 2F);
            this.Front_ThighRight.rotateAngleX = 5.811947F;
            this.Front_ThighRight.setRotationPoint(-1.5F, 20.0F, -2.0F);
            this.Front_ThighLeft.rotateAngleX = 5.811947F;
            this.Front_ThighLeft.setRotationPoint(1.5F, 20.0F, -2.0F);
        }
        else
        {
            this.UpperBody.setRotationPoint(0.0F, 15.0F, 0.0F);
            this.LowerBody.setRotationPoint(0.0F, 16.0F, 1.0F);
            this.LowerBody.rotateAngleX = 0.0F;
            this.UpperBody.rotateAngleX = this.LowerBody.rotateAngleX;
            this.C1.setRotationPoint(0.0F, 15.0F, 0.0F);
            this.C1.rotateAngleX = this.UpperBody.rotateAngleX;
            this.Tail.setRotationPoint(0.0F, 14.0F, 6.5F);
            this.Back_ThighRight.setRotationPoint(-1.5F, 19.0F, 6.0F);
            this.Back_ThighLeft.setRotationPoint(1.5F, 19.0F, 6.0F);
            this.Front_ThighRight.setRotationPoint(-1.5F, 19.0F, -2.0F);
            this.Front_ThighLeft.setRotationPoint(1.5F, 19.0F, -2.0F);
            this.Back_ThighRight.rotateAngleX = MathHelper.cos(var2 * 0.6662F) * 1.4F * var3;
            this.Back_ThighLeft.rotateAngleX = MathHelper.cos(var2 * 0.6662F + (float)Math.PI) * 1.4F * var3;
            this.Front_ThighRight.rotateAngleX = MathHelper.cos(var2 * 0.6662F + (float)Math.PI) * 1.4F * var3;
            this.Front_ThighLeft.rotateAngleX = MathHelper.cos(var2 * 0.6662F) * 1.4F * var3;
        }

        float var6 = var5.getInterestedAngle(var4) + var5.getShakeAngle(var4, 0.0F);
        this.Head.rotateAngleZ = this.Nose.rotateAngleZ = this.UpperJaw.rotateAngleZ = this.ToothUpperRight.rotateAngleZ = this.ToothUpperLeft.rotateAngleZ = this.ToothLowerRight.rotateAngleZ = this.ToothLowerLeft.rotateAngleZ = this.EarRight.rotateAngleZ = this.EarLeft.rotateAngleZ = var6;
        this.UpperBody.rotateAngleZ = var5.getShakeAngle(var4, -0.08F);
        this.LowerBody.rotateAngleZ = var5.getShakeAngle(var4, -0.16F);
        this.Tail.rotateAngleZ = var5.getShakeAngle(var4, -0.2F);

        if (var5.getSmilodonShaking())
        {
            float var7 = var5.getBrightness(var4) * var5.getShadingWhileShaking(var4);
            GL11.glColor3f(var7, var7, var7);
        }
    }
}
