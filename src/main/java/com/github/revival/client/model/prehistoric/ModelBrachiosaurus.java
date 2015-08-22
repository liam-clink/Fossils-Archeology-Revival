package com.github.revival.client.model.prehistoric;

import org.lwjgl.opengl.GL11;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.common.entity.mob.EntityDinosaur;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public class ModelBrachiosaurus extends ModelPrehistoric
{
    public MowzieModelRenderer LowerNeck1;
    public MowzieModelRenderer Body;
    public MowzieModelRenderer Body2;
    public MowzieModelRenderer LowerBody;
    public MowzieModelRenderer Tail;
    public MowzieModelRenderer FrontThighRight;
    public MowzieModelRenderer FrontThighLeft;
    public MowzieModelRenderer BackThighRight;
    public MowzieModelRenderer BackThighLeft;
    public MowzieModelRenderer LowerNeck2;
    public MowzieModelRenderer Tail1;
    public MowzieModelRenderer Tail2;
    public MowzieModelRenderer FrontCalfRight;
    public MowzieModelRenderer FrontCalfLeft;
    public MowzieModelRenderer BackCalfRight;
    public MowzieModelRenderer BackCalfLeft;
    public MowzieModelRenderer Neck1;
    public MowzieModelRenderer Neck2;
    public MowzieModelRenderer Neck3;
    public MowzieModelRenderer Head;
    public MowzieModelRenderer Crest;
    public MowzieModelRenderer Snout;

    public ModelBrachiosaurus()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Body2 = new MowzieModelRenderer(this, 44, 34);
        this.Body2.mirror = true;
        this.Body2.setRotationPoint(0.0F, 13.8F, 1.45F);
        this.Body2.addBox(-4.0F, -4.5F, -0.2F, 8, 9, 4);
        this.setRotateAngle(Body2, -0.24504422698000386F, -0.0F, 0.0F);
        this.LowerBody = new MowzieModelRenderer(this, 73, 48);
        this.LowerBody.mirror = true;
        this.LowerBody.setRotationPoint(0.0F, 15.6F, 4.5F);
        this.LowerBody.addBox(-3.0F, -5.0F, 0.0F, 6, 8, 5);
        this.setRotateAngle(LowerBody, -0.22985986248765322F, -0.0F, 0.0F);
        this.FrontThighLeft = new MowzieModelRenderer(this, 50, 21);
        this.FrontThighLeft.mirror = true;
        this.FrontThighLeft.setRotationPoint(-2.5F, 15.0F, -3.0F);
        this.FrontThighLeft.addBox(-3.0F, -2.0F, -1.5F, 3, 7, 4);
        this.FrontCalfLeft = new MowzieModelRenderer(this, 0, 24);
        this.FrontCalfLeft.mirror = true;
        this.FrontCalfLeft.setRotationPoint(-1.5F, 5.0F, 0.5F);
        this.FrontCalfLeft.addBox(-1.0F, 0.0F, -1.5F, 2, 5, 3);
        this.LowerNeck1 = new MowzieModelRenderer(this, 0, 33);
        this.LowerNeck1.setRotationPoint(0.0F, 11.0F, -3.5F);
        this.LowerNeck1.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 5);
        this.setRotateAngle(LowerNeck1, -0.7349588871002196F, -0.0F, 0.0F);
        this.BackThighLeft = new MowzieModelRenderer(this, 50, 21);
        this.BackThighLeft.mirror = true;
        this.BackThighLeft.setRotationPoint(-3.0F, 15.5F, 7.0F);
        this.BackThighLeft.addBox(-2.0F, -1.5F, -2.0F, 3, 6, 4);
        this.Snout = new MowzieModelRenderer(this, 67, 8);
        this.Snout.mirror = true;
        this.Snout.setRotationPoint(0.0F, 0.6F, -2.5F);
        this.Snout.addBox(-1.5F, -0.7F, -3.3F, 3, 2, 4);
        this.setRotateAngle(Snout, 0.11309733552923257F, -0.0F, 0.0F);
        this.Neck2 = new MowzieModelRenderer(this, 18, 41);
        this.Neck2.mirror = true;
        this.Neck2.setRotationPoint(0.0F, 0.2F, -5.8F);
        this.Neck2.addBox(-1.5F, -1.5F, -7.0F, 3, 3, 7);
        this.setRotateAngle(Neck2, -0.07365289443416069F, -0.0F, 0.0F);
        this.Crest = new MowzieModelRenderer(this, 52, 0);
        this.Crest.mirror = true;
        this.Crest.setRotationPoint(0.0F, 1.0F, -2.8F);
        this.Crest.addBox(-1.0F, -4.0F, -1.7F, 2, 4, 4);
        this.Tail = new MowzieModelRenderer(this, 0, 13);
        this.Tail.mirror = true;
        this.Tail.setRotationPoint(0.0F, 15.2F, 9.3F);
        this.Tail.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 5);
        this.setRotateAngle(Tail, -0.28082347664588764F, -0.0F, 0.0F);
        this.Neck1 = new MowzieModelRenderer(this, 17, 53);
        this.Neck1.mirror = true;
        this.Neck1.setRotationPoint(0.0F, 0.9F, -3.1F);
        this.Neck1.addBox(-2.0F, -2.0F, -7.0F, 4, 4, 7);
        this.setRotateAngle(Neck1, -0.06981317007977318F, -0.0F, 0.0F);
        this.Head = new MowzieModelRenderer(this, 66, 0);
        this.Head.mirror = true;
        this.Head.setRotationPoint(0.0F, -0.6F, -2.6F);
        this.Head.addBox(-2.0F, -1.0F, -3.7F, 4, 3, 4);
        this.setRotateAngle(Head, 0.7853981633974483F, -0.0F, 0.0F);
        this.FrontThighRight = new MowzieModelRenderer(this, 50, 21);
        this.FrontThighRight.mirror = true;
        this.FrontThighRight.setRotationPoint(2.5F, 15.0F, -3.0F);
        this.FrontThighRight.addBox(0.0F, -2.0F, -1.5F, 3, 7, 4);
        this.Tail1 = new MowzieModelRenderer(this, 17, 1);
        this.Tail1.mirror = true;
        this.Tail1.setRotationPoint(0.0F, -0.9F, 4.5F);
        this.Tail1.addBox(-1.5F, -1.0F, 0.0F, 3, 4, 5);
        this.setRotateAngle(Tail1, 0.023212879051524582F, -0.0F, 0.0F);
        this.FrontCalfRight = new MowzieModelRenderer(this, 0, 24);
        this.FrontCalfRight.mirror = true;
        this.FrontCalfRight.setRotationPoint(1.5F, 5.0F, 0.5F);
        this.FrontCalfRight.addBox(-1.0F, 0.0F, -1.5F, 2, 5, 3);
        this.BackCalfRight = new MowzieModelRenderer(this, 0, 24);
        this.BackCalfRight.mirror = true;
        this.BackCalfRight.setRotationPoint(0.5F, 4.5F, 0.0F);
        this.BackCalfRight.addBox(-1.0F, 0.0F, -1.5F, 2, 5, 3);
        this.Tail2 = new MowzieModelRenderer(this, 34, 10);
        this.Tail2.mirror = true;
        this.Tail2.setRotationPoint(0.0F, 0.9F, 4.3F);
        this.Tail2.addBox(-1.0F, -1.5F, 0.0F, 2, 3, 6);
        this.setRotateAngle(Tail2, 0.04293509959906051F, -0.0F, 0.0F);
        this.Neck3 = new MowzieModelRenderer(this, 23, 33);
        this.Neck3.mirror = true;
        this.Neck3.setRotationPoint(0.0F, -0.05F, -6.4F);
        this.Neck3.addBox(-1.0F, -1.5F, -3.0F, 2, 3, 3);
        this.setRotateAngle(Neck3, 0.23806290997202653F, -0.0F, 0.0F);
        this.BackThighRight = new MowzieModelRenderer(this, 50, 21);
        this.BackThighRight.mirror = true;
        this.BackThighRight.setRotationPoint(3.0F, 15.5F, 7.0F);
        this.BackThighRight.addBox(-1.0F, -1.5F, -2.0F, 3, 6, 4);
        this.Body = new MowzieModelRenderer(this, 44, 48);
        this.Body.setRotationPoint(0.0F, 12.0F, -4.2F);
        this.Body.addBox(-4.0F, -4.5F, 0.0F, 8, 9, 6);
        this.setRotateAngle(Body, -0.30351275692181395F, -0.0F, 0.0F);
        this.BackCalfLeft = new MowzieModelRenderer(this, 0, 24);
        this.BackCalfLeft.setRotationPoint(-0.5F, 4.5F, 0.0F);
        this.BackCalfLeft.addBox(-1.0F, 0.0F, -1.5F, 2, 5, 3);
        this.LowerNeck2 = new MowzieModelRenderer(this, 0, 45);
        this.LowerNeck2.mirror = true;
        this.LowerNeck2.setRotationPoint(0.0F, 8.0F, -5.0F);
        this.LowerNeck2.addBox(-2.0F, -1.5F, -3.2F, 4, 5, 4);
        this.setRotateAngle(LowerNeck2, -0.8726646259971648F, -0.0F, 0.0F);

        this.FrontThighLeft.addChild(this.FrontCalfLeft);
        this.Head.addChild(this.Snout);
        this.Neck1.addChild(this.Neck2);
        this.Head.addChild(this.Crest);
        this.LowerNeck2.addChild(this.Neck1);
        this.Neck3.addChild(this.Head);
        this.Tail.addChild(this.Tail1);
        this.FrontThighRight.addChild(this.FrontCalfRight);
        this.BackThighRight.addChild(this.BackCalfRight);
        this.Tail1.addChild(this.Tail2);
        this.Neck2.addChild(this.Neck3);
        this.BackThighLeft.addChild(this.BackCalfLeft);
        doMowzieStuff(false);
    }

  /*    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean isModelized)
    {
        if (!isModelized)
        {
            this.Head.rotateAngleX = var5 / (180F / (float) Math.PI) + 0.7853981633974483F;
            this.Head.rotateAngleY = var4 / (180F / (float) Math.PI);
            this.FrontThighLeft.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 1.0F * var2;
            this.FrontThighRight.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float) Math.PI) * 1.0F * var2;
            this.BackThighLeft.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float) Math.PI + 2) * 1.0F * var2;
            this.BackThighRight.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 1.0F * var2;
            this.Tail.rotateAngleY = 0.05F * MathHelper.sin(var3 * (float) 0.1F + (var2 + 2));
            this.Tail1.rotateAngleY = 0.06F * MathHelper.sin(var3 * (float) 0.1F + (var2 + 1));
            this.Tail2.rotateAngleY = 0.07F * MathHelper.sin(var3 * (float) 0.1F + (var2));
            this.Neck1.rotateAngleX = 0.04F * MathHelper.sin(var3 * (float) 0.1F + (var2)) - 0.06981317007977318F;
            this.Neck2.rotateAngleX = -0.05F * MathHelper.sin(var3 * (float) 0.1F + (var2)) - 0.07365289443416069F;

        }
        else
        {
            this.Head.rotateAngleX = 0.7853981633974483F;
            this.Head.rotateAngleY = 0;
            this.FrontThighLeft.rotateAngleX = 0;
            this.FrontThighRight.rotateAngleX = 0;
            this.BackThighLeft.rotateAngleX = 0;
            this.BackThighRight.rotateAngleX = 0;
            this.Tail.rotateAngleY = 0;
            this.Tail1.rotateAngleY = 0;
            this.Tail2.rotateAngleY = 0;
        }
    }*/

	@Override
	public void renderFossil(EntityNewPrehistoric entity, float f, float f1,
			float f2, float f3, float f4, float f5) {
        GL11.glTranslatef(0, -0.0625F, 0);

	}

	@Override
	public void renderLiving(EntityNewPrehistoric entity, float f, float f1,
			float f2, float f3, float f4, float f5) {
        GL11.glTranslatef(0, -0.0625F, 0);

	}

	@Override
	public void renderSleeping(EntityNewPrehistoric entity, float f, float f1,
			float f2, float f3, float f4, float f5) {
        GL11.glTranslatef(0, -0.0625F, 0);

	}
}
