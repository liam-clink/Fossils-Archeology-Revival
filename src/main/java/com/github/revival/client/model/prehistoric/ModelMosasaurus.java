package com.github.revival.client.model.prehistoric;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;

public class ModelMosasaurus extends ModelPrehistoric {
    //fields
    MowzieModelRenderer Body;
    private MowzieModelRenderer FrontFlipper_Right;
    private MowzieModelRenderer FrontFlipper_Left;
    private MowzieModelRenderer LowerBody;
    private MowzieModelRenderer Tail;
    private MowzieModelRenderer Tail1;
    private MowzieModelRenderer Lower_Caudal_Left;
    private MowzieModelRenderer Lower_Caudal_Right;
    private MowzieModelRenderer Upper_Caudal;
    private MowzieModelRenderer BackFlipper_Right;
    private MowzieModelRenderer BackFlipper_Left;
    private MowzieModelRenderer Neck;
    private MowzieModelRenderer Head;
    private MowzieModelRenderer JawTop;
    private MowzieModelRenderer Teeth;
    private MowzieModelRenderer JawBottomBase;
    private MowzieModelRenderer JawBottom;

    public ModelMosasaurus() {
        textureWidth = 128;
        textureHeight = 64;
        setTextureOffset("Body.Body", 77, 43);
        setTextureOffset("FrontFlipper_Right.FrontFlipper_Right", 62, 21);
        setTextureOffset("FrontFlipper_Left.FrontFlipper_Left", 62, 21);
        setTextureOffset("LowerBody.LowerBody", 79, 25);
        setTextureOffset("Tail.Tail", 85, 12);
        setTextureOffset("Tail1.Tail1", 59, 0);
        setTextureOffset("Lower_Caudal_Left.Lower_Caudal_Left", 36, 11);
        setTextureOffset("Lower_Caudal_Right.Lower_Caudal_Right", 36, 11);
        setTextureOffset("Upper_Caudal.Upper_Caudal", 21, 11);
        setTextureOffset("BackFlipper_Right.BackFlipper_Right", 50, 24);
        setTextureOffset("BackFlipper_Left.BackFlipper_Left", 50, 24);
        setTextureOffset("Neck.Neck", 52, 50);
        setTextureOffset("Head.Head", 1, 40);
        setTextureOffset("JawTop.JawTop", 27, 40);
        setTextureOffset("Teeth.Teeth", 27, 28);
        setTextureOffset("JawBottomBase.JawBottomBase", 5, 52);
        setTextureOffset("JawBottom.JawBottom", 30, 51);

        Body = new MowzieModelRenderer(this, "Body");
        Body.setRotationPoint(0F, 19F, -6F);
        setRotateAngle(Body, 0F, 0F, 0F);
        Body.mirror = true;
        Body.addBox("Body", -4F, -3F, 0F, 8, 7, 10);
        FrontFlipper_Right = new MowzieModelRenderer(this, "FrontFlipper_Right");
        FrontFlipper_Right.setRotationPoint(-2.5F, 2F, 3F);
        setRotateAngle(FrontFlipper_Right, 0F, 0F, 0F);
        FrontFlipper_Right.mirror = true;
        FrontFlipper_Right.addBox("FrontFlipper_Right", -1F, 0F, -2F, 1, 7, 4);
        Body.addChild(FrontFlipper_Right);
        FrontFlipper_Left = new MowzieModelRenderer(this, "FrontFlipper_Left");
        FrontFlipper_Left.setRotationPoint(2.5F, 2F, 3F);
        setRotateAngle(FrontFlipper_Left, 0F, 0F, 0F);
        FrontFlipper_Left.mirror = true;
        FrontFlipper_Left.mirror = true;
        FrontFlipper_Left.addBox("FrontFlipper_Left", 0F, 0F, -2F, 1, 7, 4);
        FrontFlipper_Left.mirror = false;
        Body.addChild(FrontFlipper_Left);
        LowerBody = new MowzieModelRenderer(this, "LowerBody");
        LowerBody.setRotationPoint(0F, 0.5F, 10F);
        setRotateAngle(LowerBody, 0F, 0F, 0F);
        LowerBody.mirror = true;
        LowerBody.addBox("LowerBody", -3F, -3F, -1F, 6, 6, 10);
        Tail = new MowzieModelRenderer(this, "Tail");
        Tail.setRotationPoint(0F, 0.5F, 9F);
        setRotateAngle(Tail, 0F, 0F, 0F);
        Tail.mirror = true;
        Tail.addBox("Tail", -2F, -3F, -1F, 4, 5, 7);
        Tail1 = new MowzieModelRenderer(this, "Tail1");
        Tail1.setRotationPoint(-0.5F, -0.5F, 6F);
        setRotateAngle(Tail1, 0F, 0F, 0F);
        Tail1.mirror = true;
        Tail1.addBox("Tail1", -1F, -2F, -1F, 3, 4, 9);
        Lower_Caudal_Left = new MowzieModelRenderer(this, "Lower_Caudal_Left");
        Lower_Caudal_Left.setRotationPoint(0.8F, 0.3F, 7.2F);
        setRotateAngle(Lower_Caudal_Left, 0F, 0F, 0F);
        Lower_Caudal_Left.mirror = true;
        Lower_Caudal_Left.addBox("Lower_Caudal_Left", -0.6F, -1F, -2F, 1, 9, 4);
        Tail1.addChild(Lower_Caudal_Left);
        Lower_Caudal_Right = new MowzieModelRenderer(this, "Lower_Caudal_Right");
        Lower_Caudal_Right.setRotationPoint(0.5F, 0.3F, 7.2F);
        setRotateAngle(Lower_Caudal_Right, 0F, 0F, 0F);
        Lower_Caudal_Right.mirror = true;
        Lower_Caudal_Right.addBox("Lower_Caudal_Right", -0.6F, -1F, -2F, 1, 9, 4);
        Tail1.addChild(Lower_Caudal_Right);
        Upper_Caudal = new MowzieModelRenderer(this, "Upper_Caudal");
        Upper_Caudal.setRotationPoint(0.5F, 2F, 8F);
        setRotateAngle(Upper_Caudal, 0F, 0F, 0F);
        Upper_Caudal.mirror = true;
        Upper_Caudal.addBox("Upper_Caudal", -0.5F, -1F, 0F, 1, 5, 4);
        Tail1.addChild(Upper_Caudal);
        Tail.addChild(Tail1);
        LowerBody.addChild(Tail);
        BackFlipper_Right = new MowzieModelRenderer(this, "BackFlipper_Right");
        BackFlipper_Right.setRotationPoint(-1.5F, 1F, 9.5F);
        setRotateAngle(BackFlipper_Right, 0F, 0F, 0F);
        BackFlipper_Right.mirror = true;
        BackFlipper_Right.addBox("BackFlipper_Right", -1F, 0F, -2F, 1, 4, 3);
        LowerBody.addChild(BackFlipper_Right);
        BackFlipper_Left = new MowzieModelRenderer(this, "BackFlipper_Left");
        BackFlipper_Left.setRotationPoint(1.5F, 1F, 9.5F);
        setRotateAngle(BackFlipper_Left, 0F, 0F, 0F);
        BackFlipper_Left.mirror = true;
        BackFlipper_Left.mirror = true;
        BackFlipper_Left.addBox("BackFlipper_Left", 0F, 0F, -2F, 1, 4, 3);
        BackFlipper_Left.mirror = false;
        LowerBody.addChild(BackFlipper_Left);
        Body.addChild(LowerBody);
        Neck = new MowzieModelRenderer(this, "Neck");
        Neck.setRotationPoint(-0.5F, 0.5F, 0F);
        setRotateAngle(Neck, 0F, 0F, 0F);
        Neck.mirror = true;
        Neck.addBox("Neck", -3F, -3F, -4F, 7, 6, 4);
        Head = new MowzieModelRenderer(this, "Head");
        Head.setRotationPoint(0.5F, -0.5F, -4F);
        setRotateAngle(Head, 0F, 0F, 0F);
        Head.mirror = true;
        Head.addBox("Head", -3F, -2F, -6F, 6, 4, 6);
        JawTop = new MowzieModelRenderer(this, "JawTop");
        JawTop.setRotationPoint(0F, 0F, -6F);
        setRotateAngle(JawTop, 0F, 0F, 0F);
        JawTop.mirror = true;
        JawTop.addBox("JawTop", -2F, -1F, -7F, 4, 3, 7);
        Teeth = new MowzieModelRenderer(this, "Teeth");
        Teeth.setRotationPoint(0F, 0F, 0F);
        setRotateAngle(Teeth, 0F, 0F, 0F);
        Teeth.mirror = true;
        Teeth.addBox("Teeth", -2F, 2F, -7F, 4, 1, 7);
        JawTop.addChild(Teeth);
        Head.addChild(JawTop);
        JawBottomBase = new MowzieModelRenderer(this, "JawBottomBase");
        JawBottomBase.setRotationPoint(0F, 1.5F, 0F);
        setRotateAngle(JawBottomBase, 0F, 0F, 0F);
        JawBottomBase.mirror = true;
        JawBottomBase.addBox("JawBottomBase", -2.5F, 0F, -6F, 5, 2, 6);
        JawBottom = new MowzieModelRenderer(this, "JawBottom");
        JawBottom.setRotationPoint(0F, 0F, 0F);
        setRotateAngle(JawBottom, 0F, 0F, 0F);
        JawBottom.mirror = true;
        JawBottom.addBox("JawBottom", -1.5F, 0F, -12.6F, 3, 2, 7);
        JawBottomBase.addChild(JawBottom);
        Head.addChild(JawBottomBase);
        Neck.addChild(Head);
        Body.addChild(Neck);
        doMowzieStuff(false);
    }

    @Override
    public void renderFossil(EntityNewPrehistoric entity, float f, float f1,
                             float f2, float f3, float f4, float f5) {
        // TODO Auto-generated method stub

    }

    @Override
    public void renderLiving(EntityNewPrehistoric entity, float f, float f1,
                             float f2, float f3, float f4, float f5) {
        // TODO Auto-generated method stub

    }

    @Override
    public void renderSleeping(EntityNewPrehistoric entity, float f, float f1,
                               float f2, float f3, float f4, float f5) {
        // TODO Auto-generated method stub

    }

  /*  protected void setRotationAngles(float var1, float var2, float var3,
                                     float var4, float var5, float var6, boolean isModelized)
    {

        /////// Setup initial rotations
        this.FrontFlipper_Left.rotateAngleX = (float) Math.toRadians(30);
        this.FrontFlipper_Left.rotateAngleZ = (float) Math.toRadians(-30);

        this.FrontFlipper_Right.rotateAngleX = (float) Math.toRadians(30);
        this.FrontFlipper_Right.rotateAngleZ = (float) Math.toRadians(30);

        this.BackFlipper_Left.rotateAngleX = (float) Math.toRadians(30);
        this.BackFlipper_Left.rotateAngleZ = (float) Math.toRadians(-30);

        this.BackFlipper_Right.rotateAngleX = (float) Math.toRadians(30);
        this.BackFlipper_Right.rotateAngleZ = (float) Math.toRadians(30);

        this.Upper_Caudal.rotateAngleX = (float) Math.toRadians(108.509);
        this.Lower_Caudal_Left.rotateAngleX = (float) Math.toRadians(64.946);
        this.Lower_Caudal_Right.rotateAngleX = (float) Math.toRadians(64.946);

        this.JawBottomBase.rotateAngleX = 0;
        //////////////////////


        if (!isModelized)
        {
            this.LowerBody.rotateAngleY = 0.1F * MathHelper.cos((var1 * (float) 0.4F) + var2 + 3);
            this.Tail.rotateAngleY = 0.2F * MathHelper.cos((var1 * (float) 0.4F) + var2 + 2);
            this.Tail1.rotateAngleY = 0.3F * MathHelper.cos((var1 * (float) 0.4F) + var2 + 1);
            this.Upper_Caudal.rotateAngleY = 0.4F * MathHelper.cos(var1 * (float) 0.4F + var2);
            this.Lower_Caudal_Left.rotateAngleY = 0.4F * MathHelper.cos(var1 * (float) 0.4F + var2);
            this.Lower_Caudal_Right.rotateAngleY = 0.4F * MathHelper.cos(var1 * (float) 0.4F + var2);
            this.JawBottomBase.rotateAngleX = 0;
            this.Body.rotationPointY = 19F;

            this.Neck.rotateAngleX = 0;
            this.LowerBody.rotateAngleX = 0;
            this.Tail.rotateAngleX = 0;
            this.Tail1.rotateAngleX = 0;
        }
        else
        {
            this.LowerBody.rotateAngleY = (float) Math.toRadians(-10);
            ;
            this.Tail.rotateAngleY = (float) Math.toRadians(-10);
            ;
            this.Tail1.rotateAngleY = (float) Math.toRadians(-10);
            ;
            this.Upper_Caudal.rotateAngleY = (float) Math.toRadians(-10);
            ;
            this.Lower_Caudal_Left.rotateAngleY = (float) Math.toRadians(-10);
            ;
            this.Lower_Caudal_Right.rotateAngleY = (float) Math.toRadians(-10);
            ;
            this.JawBottomBase.rotateAngleX = (float) Math.toRadians(20);
            this.Body.rotationPointY = 19F;

            this.Neck.rotateAngleX = (float) Math.toRadians(-10);
            this.LowerBody.rotateAngleX = (float) Math.toRadians(5);
            this.Tail.rotateAngleX = (float) Math.toRadians(10);
            this.Tail1.rotateAngleX = (float) Math.toRadians(-20);

            this.FrontFlipper_Left.rotateAngleZ = (float) Math.toRadians(-70);
            this.FrontFlipper_Right.rotateAngleZ = (float) Math.toRadians(70);

        }


    }*/
}