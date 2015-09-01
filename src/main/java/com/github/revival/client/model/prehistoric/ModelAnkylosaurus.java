package com.github.revival.client.model.prehistoric;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public class ModelAnkylosaurus extends ModelPrehistoric
{
    public MowzieModelRenderer Tail[];
    //fields
    MowzieModelRenderer Head;
    MowzieModelRenderer Mouth;
    MowzieModelRenderer Head_Block;
    MowzieModelRenderer HeadHorn1;
    MowzieModelRenderer HeadHorn2;
    MowzieModelRenderer HeadHorn3;
    MowzieModelRenderer HeadHorn4;
    MowzieModelRenderer Body;
    MowzieModelRenderer BodySpikes;
    MowzieModelRenderer Neck;
    MowzieModelRenderer Tail1;
    MowzieModelRenderer Tail3;
    MowzieModelRenderer Tail2;
    MowzieModelRenderer Front_ThighLeft;
    MowzieModelRenderer Front_ThighRight;
    MowzieModelRenderer Back_ThighLeft;
    MowzieModelRenderer Back_ThighRight;
    MowzieModelRenderer Front_LowerLegRight;
    MowzieModelRenderer Front_LowerLegLeft;
    MowzieModelRenderer Back_LowerLegRight;
    MowzieModelRenderer Back_LowerLegLeft;

    public ModelAnkylosaurus()
    {
        textureWidth = 128;
        textureHeight = 64;
        Head = new MowzieModelRenderer(this, 0, 0);
        Head.addBox(-4F, 0F, -8F, 8, 7, 8);
        Head.setRotationPoint(0F, 10.5F, -8F);
        Head.setTextureSize(128, 64);
        Head.mirror = true;
        setRotateAngle(Head, 0F, 0F, 0F);
        Head_Block = new MowzieModelRenderer(this, 24, 0);
        Head_Block.addBox(-3.0F, -0.9F, -4.9F, 6, 2, 5);
        Head_Block.setRotationPoint(0F, 10.5F, -8F);
        Head_Block.setTextureSize(128, 64);
        Head_Block.mirror = true;
        setRotateAngle(Head_Block, 0.1745329F, 0F, 0F);
        Mouth = new MowzieModelRenderer(this, 0, 15);
        Mouth.addBox(-2F, -2F, -11F, 4, 6, 4);
        Mouth.setRotationPoint(0F, 10.5F, -8F);
        Mouth.setTextureSize(128, 64);
        Mouth.mirror = true;
        setRotateAngle(Mouth, 0.4363323F, 0F, 0F);
        HeadHorn1 = new MowzieModelRenderer(this, 32, 7);
        HeadHorn1.addBox(3F, -0.9F, -2.9F, 3, 3, 3);
        HeadHorn1.setRotationPoint(0F, 10.5F, -8F);
        HeadHorn1.setTextureSize(128, 64);
        HeadHorn1.mirror = true;
        setRotateAngle(HeadHorn1, 0.1745329F, 0F, 0F);
        HeadHorn2 = new MowzieModelRenderer(this, 44, 7);
        HeadHorn2.addBox(-6F, -0.9F, -2.9F, 3, 3, 3);
        HeadHorn2.setRotationPoint(0F, 10.5F, -8F);
        HeadHorn2.setTextureSize(128, 64);
        HeadHorn2.mirror = true;
        setRotateAngle(HeadHorn2, 0.1745329F, 0F, 0F);
        HeadHorn3 = new MowzieModelRenderer(this, 32, 7);
        HeadHorn3.addBox(3F, 3.5F, -3F, 3, 3, 3);
        HeadHorn3.setRotationPoint(0F, 10.5F, -8F);
        HeadHorn3.setTextureSize(128, 64);
        HeadHorn3.mirror = true;
        setRotateAngle(HeadHorn3, 0F, 0F, 0.1745329F);
        HeadHorn4 = new MowzieModelRenderer(this, 44, 7);
        HeadHorn4.addBox(-6F, 3.5F, -3F, 3, 3, 3);
        HeadHorn4.setRotationPoint(0F, 10.5F, -8F);
        HeadHorn4.setTextureSize(128, 64);
        HeadHorn4.mirror = true;
        setRotateAngle(HeadHorn4, 0F, 0F, -0.1745329F);
        Body = new MowzieModelRenderer(this, 68, 0);
        Body.addBox(0F, 3F, 0F, 14, 10, 16);
        Body.setRotationPoint(-7F, 6F, -7F);
        Body.setTextureSize(128, 64);
        Body.mirror = true;
        setRotateAngle(Body, 0F, 0F, 0F);
        BodySpikes = new MowzieModelRenderer(this, 56, 26);
        BodySpikes.addBox(0F, 3F, 0F, 18, 2, 18);
        BodySpikes.setRotationPoint(-9F, 10F, -8F);
        BodySpikes.setTextureSize(128, 64);
        BodySpikes.mirror = true;
        setRotateAngle(BodySpikes, 0F, 0F, 0F);
        Neck = new MowzieModelRenderer(this, 46, 0);
        Neck.addBox(0F, -9F, -2.5F, 4, 5, 2);
        Neck.setRotationPoint(-2F, 8F, -8F);
        Neck.setTextureSize(128, 64);
        Neck.mirror = true;
        setRotateAngle(Neck, 3F, 0F, 0F);
        Tail1 = new MowzieModelRenderer(this, 104, 46);
        Tail1.addBox(-3F, 3F, 0F, 6, 6, 6);
        Tail1.setRotationPoint(0F, 7F, 8F);
        Tail1.setTextureSize(128, 64);
        Tail1.mirror = true;
        setRotateAngle(Tail1, -0.2617994F, 0F, 0F);
        Tail3 = new MowzieModelRenderer(this, 80, 46);
        Tail3.addBox(-3F, -3F, 0F, 6, 6, 6);
        Tail3.setRotationPoint(0F, 2F, 7F);
        Tail3.setTextureSize(128, 64);
        Tail3.mirror = true;
        setRotateAngle(Tail3, 0F, 0F, 0F);
        Tail2 = new MowzieModelRenderer(this, 56, 46);
        Tail2.addBox(-2F, 0F, 0F, 4, 4, 8);
        Tail2.setRotationPoint(0F, 4F, 5F);
        Tail2.setTextureSize(128, 64);
        Tail2.mirror = true;
        setRotateAngle(Tail2, 0F, 0F, 0F);
        Tail1.addChild(Tail2);
        Tail2.addChild(Tail3);
        Front_ThighRight = new MowzieModelRenderer(this, 18, 24);
        Front_ThighRight.addBox(0F, 3F, -2F, 4, 4, 4);
        Front_ThighRight.setRotationPoint(-9F, 14F, -4F);
        Front_ThighRight.setTextureSize(128, 64);
        Front_ThighRight.mirror = true;
        setRotateAngle(Front_ThighRight, 0F, 0F, 0F);
        Front_ThighLeft = new MowzieModelRenderer(this, 18, 24);
        Front_ThighLeft.addBox(0F, 3F, -2F, 4, 4, 4);
        Front_ThighLeft.setRotationPoint(5F, 14F, -4F);
        Front_ThighLeft.setTextureSize(128, 64);
        Front_ThighLeft.mirror = true;
        setRotateAngle(Front_ThighLeft, 0F, 0F, 0F);
        Back_ThighRight = new MowzieModelRenderer(this, 0, 25);
        Back_ThighRight.addBox(0F, 3F, -2F, 4, 5, 5);
        Back_ThighRight.setRotationPoint(-9F, 13F, 5F);
        Back_ThighRight.setTextureSize(128, 64);
        Back_ThighRight.mirror = true;
        setRotateAngle(Back_ThighRight, 0F, 0F, 0F);
        Back_ThighLeft = new MowzieModelRenderer(this, 0, 25);
        Back_ThighLeft.addBox(0F, 3F, -2F, 4, 5, 5);
        Back_ThighLeft.setRotationPoint(5F, 13F, 5F);
        Back_ThighLeft.setTextureSize(128, 64);
        Back_ThighLeft.mirror = true;
        setRotateAngle(Back_ThighLeft, 0F, 0F, 0F);
        Front_LowerLegRight = new MowzieModelRenderer(this, 0, 35);
        Front_LowerLegRight.addBox(0F, 6F, -1F, 3, 4, 4);
        Front_LowerLegRight.setRotationPoint(0F, 0F, 0F);
        Front_LowerLegRight.setTextureSize(128, 64);
        Front_LowerLegRight.mirror = true;
        setRotateAngle(Front_LowerLegRight, 0F, 0F, 0F);
        Front_LowerLegLeft = new MowzieModelRenderer(this, 0, 35);
        Front_LowerLegLeft.addBox(0F, 6F, -1F, 3, 4, 4);
        Front_LowerLegLeft.setRotationPoint(0F, 0F, 0F);
        Front_LowerLegLeft.setTextureSize(128, 64);
        Front_LowerLegLeft.mirror = true;
        setRotateAngle(Front_LowerLegLeft, 0F, 0F, 0F);
        Back_LowerLegRight = new MowzieModelRenderer(this, 0, 35);
        Back_LowerLegRight.addBox(0F, 7F, 0F, 3, 4, 4);
        Back_LowerLegRight.setRotationPoint(0F, 0F, 0F);
        Back_LowerLegRight.setTextureSize(128, 64);
        Back_LowerLegRight.mirror = true;
        setRotateAngle(Back_LowerLegRight, 0F, 0F, 0F);
        Back_LowerLegLeft = new MowzieModelRenderer(this, 0, 35);
        Back_LowerLegLeft.addBox(0F, 7F, 0F, 3, 4, 4);
        Back_LowerLegLeft.setRotationPoint(0F, 0F, 0F);
        Back_LowerLegLeft.setTextureSize(128, 64);
        Back_LowerLegLeft.mirror = true;
        setRotateAngle(Back_LowerLegLeft, 0F, 0F, 0F);
        Front_ThighRight.addChild(Front_LowerLegRight);
        Front_ThighLeft.addChild(Front_LowerLegLeft);
        Back_ThighRight.addChild(Back_LowerLegRight);
        Back_ThighLeft.addChild(Back_LowerLegLeft);
        this.doMowzieStuff(false);
    }

	@Override
	public void renderFossil(EntityNewPrehistoric entity, float f, float f1,
			float f2, float f3, float f4, float f5) {
		
	}

	@Override
	public void renderLiving(EntityNewPrehistoric entity, float f, float f1,
			float f2, float f3, float f4, float f5) {
		
	}

	@Override
	public void renderSleeping(EntityNewPrehistoric entity, float f, float f1,
			float f2, float f3, float f4, float f5) {
		
	}

   

    /*protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {

        float PI = (float) Math.PI;
        float initialOffset = PI / 2;
        float offset = PI * 2 / 11;
        float currentAngle = 0;
        
        if (!var7)
        {
            //make sure to re-add initial parts offset rotation at the end.
            this.Head.rotateAngleX = var5 / 2 / (180F / (float) Math.PI);
            this.Head.rotateAngleY = var4 / 2 / (180F / (float) Math.PI);
            this.Mouth.rotateAngleX = var5 / 2 / (180F / (float) Math.PI) + 0.4363323F;
            this.HeadHorn1.rotateAngleX = var5 / 2 / (180F / (float) Math.PI) + 0.1745329F;
            this.HeadHorn2.rotateAngleX = var5 / 2 / (180F / (float) Math.PI) + 0.1745329F;
            this.HeadHorn3.rotateAngleX = var5 / 2 / (180F / (float) Math.PI);
            this.HeadHorn4.rotateAngleX = var5 / 2 / (180F / (float) Math.PI);
            this.Head_Block.rotateAngleX = var5 / 2 / (180F / (float) Math.PI) + 0.1745329F;
            this.Mouth.rotateAngleY = var4 / 2 / (180F / (float) Math.PI);
            this.HeadHorn1.rotateAngleY = var4 / 2 / (180F / (float) Math.PI);
            this.HeadHorn2.rotateAngleY = var4 / 2 / (180F / (float) Math.PI);
            this.HeadHorn3.rotateAngleY = var4 / 2 / (180F / (float) Math.PI);
            this.HeadHorn4.rotateAngleY = var4 / 2 / (180F / (float) Math.PI);
            this.Head_Block.rotateAngleY = var4 / 2 / (180F / (float) Math.PI);
            this.Front_ThighLeft.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 1.0F * var2;
            this.Front_ThighRight.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float) Math.PI) * 1.0F * var2;
            this.Back_ThighLeft.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float) Math.PI + 2) * 1.0F * var2;
            this.Back_ThighRight.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 1.0F * var2;
            this.Tail1.rotateAngleY = 0.15F * MathHelper.sin(var3 * (float) 0.1F + (var2 + 2));
            this.Tail2.rotateAngleY = 0.25F * MathHelper.sin(var3 * (float) 0.1F + (var2 + 1));
            this.Tail3.rotateAngleY = 0.15F * MathHelper.sin(var3 * (float) 0.1F + var2);
        }
        else
        {
            this.Head.rotateAngleX = 0;
            this.Head.rotateAngleY = 0;
            this.Mouth.rotateAngleX = 0.4363323F;
            this.HeadHorn1.rotateAngleX = 0.1745329F;
            this.HeadHorn2.rotateAngleX = 0.1745329F;
            this.HeadHorn3.rotateAngleX = 0;
            this.HeadHorn4.rotateAngleX = 0;
            this.Head_Block.rotateAngleX = 0.1745329F;
            this.Mouth.rotateAngleY = 0;
            this.HeadHorn1.rotateAngleY = 0;
            this.HeadHorn2.rotateAngleY = 0;
            this.HeadHorn3.rotateAngleY = 0;
            this.HeadHorn4.rotateAngleY = 0;
            this.Head_Block.rotateAngleY = 0;
            this.Front_ThighLeft.rotateAngleX = 0;
            this.Front_ThighRight.rotateAngleX = 0;
            this.Back_ThighLeft.rotateAngleX = 0;
            this.Back_ThighRight.rotateAngleX = 0;
            this.Tail1.rotateAngleY = 0;
            this.Tail2.rotateAngleY = 0;
            this.Tail3.rotateAngleY = 0;
        }
    }*/
}