package com.github.revival.client.model.prehistoric;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;

public class ModelSpinosaurus extends ModelPrehistoric {
    public MowzieModelRenderer headpivot;
    public MowzieModelRenderer headdummy;
    //fields
    private MowzieModelRenderer lowerBody;
    private MowzieModelRenderer sail7_lowerBody;
    private MowzieModelRenderer sail6_lowerBody;
    private MowzieModelRenderer sail5_lowerBody;
    private MowzieModelRenderer sail4_lowerBody;
    private MowzieModelRenderer sail3_lowerBody;
    private MowzieModelRenderer tail1;
    private MowzieModelRenderer tail2;
    private MowzieModelRenderer tail3;
    private MowzieModelRenderer sail8_tail1;
    private MowzieModelRenderer sail9_tail1;
    private MowzieModelRenderer rightUpperLeg;
    private MowzieModelRenderer rightLowerLeg;
    private MowzieModelRenderer rightFoot;
    private MowzieModelRenderer leftUpperLeg;
    private MowzieModelRenderer leftLowerLeg;
    private MowzieModelRenderer leftFoot;
    private MowzieModelRenderer upperBody;
    private MowzieModelRenderer rightLowerArm;
    private MowzieModelRenderer leftUpperArm;
    private MowzieModelRenderer leftLowerArm;
    private MowzieModelRenderer neck;
    private MowzieModelRenderer head;
    private MowzieModelRenderer lowerJaw;
    private MowzieModelRenderer upperJaw;
    private MowzieModelRenderer teeth;
    private MowzieModelRenderer crest;
    private MowzieModelRenderer sail2_upperBody;
    private MowzieModelRenderer sail1_upperBody;
    private MowzieModelRenderer rightUpperArm;

    public ModelSpinosaurus() {
        textureWidth = 64;
        textureHeight = 64;
        setTextureOffset("lowerBody.lowerBody", 0, 46);
        setTextureOffset("sail7_lowerBody.sail7_lowerBody", 40, 52);
        setTextureOffset("sail6_lowerBody.sail6_lowerBody", 46, 52);
        setTextureOffset("sail5_lowerBody.sail5_lowerBody", 46, 52);
        setTextureOffset("sail4_lowerBody.sail4_lowerBody", 46, 52);
        setTextureOffset("sail3_lowerBody.sail3_lowerBody", 40, 52);
        setTextureOffset("tail1.tail1", 40, 0);
        setTextureOffset("tail2.tail2", 42, 13);
        setTextureOffset("tail3.tail3", 50, 24);
        setTextureOffset("sail8_tail1.sail8_tail1", 52, 52);
        setTextureOffset("sail9_tail1.sail9_tail1", 52, 52);
        setTextureOffset("rightUpperLeg.rightUpperLeg", 22, 11);
        setTextureOffset("rightLowerLeg.rightLowerLeg", 30, 2);
        setTextureOffset("rightFoot.rightFoot", 16, 21);
        setTextureOffset("leftUpperLeg.leftUpperLeg", 22, 11);
        setTextureOffset("leftLowerLeg.leftLowerLeg", 30, 2);
        setTextureOffset("leftFoot.leftFoot", 16, 21);
        setTextureOffset("upperBody.upperBody", 0, 27);
        setTextureOffset("rightUpperArm.rightUpperArm", 40, 24);
        setTextureOffset("rightLowerArm.rightLowerArm", 42, 13);
        setTextureOffset("leftUpperArm.leftUpperArm", 40, 24);
        setTextureOffset("leftLowerArm.leftLowerArm", 42, 13);
        setTextureOffset("neck.neck", 22, 30);
        setTextureOffset("head.head", 0, 0);
        setTextureOffset("lowerJaw.lowerJaw", 0, 20);
        setTextureOffset("upperJaw.upperJaw", 0, 10);
        setTextureOffset("teeth.teeth", 15, 0);
        setTextureOffset("crest.crest", 0, 10);
        setTextureOffset("sail2_upperBody.sail2_upperBody", 34, 52);
        setTextureOffset("sail1_upperBody.sail1_upperBody", 34, 52);
        setTextureOffset("headdummy.headdummy", 0, 21);
        setTextureOffset("headpivot.headpivot", 0, 46);

        lowerBody = new MowzieModelRenderer(this, "lowerBody");
        lowerBody.setRotationPoint(0F, 14F, -3F);
        setRotateAngle(lowerBody, 0F, 0F, 0F);
        lowerBody.mirror = true;
        lowerBody.addBox("lowerBody", -3.5F, -4F, 0F, 7, 8, 10);
        sail7_lowerBody = new MowzieModelRenderer(this, "sail7_lowerBody");
        sail7_lowerBody.setRotationPoint(0F, -2.5F, 10F);
        setRotateAngle(sail7_lowerBody, 0F, 0F, 0F);
        sail7_lowerBody.mirror = true;
        sail7_lowerBody.addBox("sail7_lowerBody", -0.5F, -10F, -1F, 1, 10, 2);
        lowerBody.addChild(sail7_lowerBody);
        sail6_lowerBody = new MowzieModelRenderer(this, "sail6_lowerBody");
        sail6_lowerBody.setRotationPoint(0F, -3.5F, 8F);
        setRotateAngle(sail6_lowerBody, 0F, 0F, 0F);
        sail6_lowerBody.mirror = true;
        sail6_lowerBody.addBox("sail6_lowerBody", -0.5F, -10F, -1F, 1, 10, 2);
        lowerBody.addChild(sail6_lowerBody);
        sail5_lowerBody = new MowzieModelRenderer(this, "sail5_lowerBody");
        sail5_lowerBody.setRotationPoint(0F, -3.5F, 6F);
        setRotateAngle(sail5_lowerBody, 0F, 0F, 0F);
        sail5_lowerBody.mirror = true;
        sail5_lowerBody.addBox("sail5_lowerBody", -0.5F, -10F, -1F, 1, 10, 2);
        lowerBody.addChild(sail5_lowerBody);
        sail4_lowerBody = new MowzieModelRenderer(this, "sail4_lowerBody");
        sail4_lowerBody.setRotationPoint(0F, -3.5F, 4F);
        setRotateAngle(sail4_lowerBody, 0F, 0F, 0F);
        sail4_lowerBody.mirror = true;
        sail4_lowerBody.addBox("sail4_lowerBody", -0.5F, -10F, -1F, 1, 10, 2);
        lowerBody.addChild(sail4_lowerBody);
        sail3_lowerBody = new MowzieModelRenderer(this, "sail3_lowerBody");
        sail3_lowerBody.setRotationPoint(0F, -2.5F, 2F);
        setRotateAngle(sail3_lowerBody, 0F, 0F, 0F);
        sail3_lowerBody.mirror = true;
        sail3_lowerBody.addBox("sail3_lowerBody", -0.5F, -10F, -1F, 1, 10, 2);
        lowerBody.addChild(sail3_lowerBody);
        tail1 = new MowzieModelRenderer(this, "tail1");
        tail1.setRotationPoint(0F, -1.03F, 10F);
        setRotateAngle(tail1, 0F, 0F, 0F);
        tail1.mirror = true;
        tail1.addBox("tail1", -2F, -2.5F, 0F, 4, 5, 8);
        tail2 = new MowzieModelRenderer(this, "tail2");
        tail2.setRotationPoint(0F, 0.5F, 7.5F);
        setRotateAngle(tail2, 0F, 0F, 0F);
        tail2.mirror = true;
        tail2.addBox("tail2", -1.5F, -2F, 0F, 3, 3, 8);
        tail3 = new MowzieModelRenderer(this, "tail3");
        tail3.setRotationPoint(0F, 0F, 7F);
        setRotateAngle(tail3, 0F, 0F, 0F);
        tail3.mirror = true;
        tail3.addBox("tail3", -1F, -1F, 0F, 2, 2, 5);
        tail2.addChild(tail3);
        tail1.addChild(tail2);
        sail8_tail1 = new MowzieModelRenderer(this, "sail8_tail1");
        sail8_tail1.setRotationPoint(0F, -0.5F, 2F);
        setRotateAngle(sail8_tail1, 0F, 0F, 0F);
        sail8_tail1.mirror = true;
        sail8_tail1.addBox("sail8_tail1", -0.5F, -10F, -1F, 1, 10, 2);
        tail1.addChild(sail8_tail1);
        sail9_tail1 = new MowzieModelRenderer(this, "sail9_tail1");
        sail9_tail1.setRotationPoint(0F, 1.5F, 4F);
        setRotateAngle(sail9_tail1, 0F, 0F, 0F);
        sail9_tail1.mirror = true;
        sail9_tail1.addBox("sail9_tail1", -0.5F, -10F, -1F, 1, 10, 2);
        tail1.addChild(sail9_tail1);
        lowerBody.addChild(tail1);
        rightUpperLeg = new MowzieModelRenderer(this, "rightUpperLeg");
        rightUpperLeg.setRotationPoint(-3F, -2F, 8F);
        setRotateAngle(rightUpperLeg, 0F, 0F, 0F);
        rightUpperLeg.mirror = true;
        rightUpperLeg.addBox("rightUpperLeg", -3F, 0F, -2F, 3, 6, 4);
        rightLowerLeg = new MowzieModelRenderer(this, "rightLowerLeg");
        rightLowerLeg.setRotationPoint(-1F, 5F, 1.5F);
        setRotateAngle(rightLowerLeg, 0F, 0F, 0F);
        rightLowerLeg.mirror = true;
        rightLowerLeg.addBox("rightLowerLeg", -1F, 0F, -1.5F, 2, 6, 3);
        rightFoot = new MowzieModelRenderer(this, "rightFoot");
        rightFoot.setRotationPoint(0F, 5F, -1F);
        setRotateAngle(rightFoot, 0F, 0F, 0F);
        rightFoot.mirror = true;
        rightFoot.addBox("rightFoot", -1.5F, 0F, -4F, 3, 2, 7);
        rightLowerLeg.addChild(rightFoot);
        rightUpperLeg.addChild(rightLowerLeg);
        lowerBody.addChild(rightUpperLeg);
        leftUpperLeg = new MowzieModelRenderer(this, "leftUpperLeg");
        leftUpperLeg.setRotationPoint(3F, -2F, 8F);
        setRotateAngle(leftUpperLeg, 0F, 0F, 0F);
        leftUpperLeg.mirror = true;
        leftUpperLeg.addBox("leftUpperLeg", 0F, 0F, -2F, 3, 6, 4);
        leftLowerLeg = new MowzieModelRenderer(this, "leftLowerLeg");
        leftLowerLeg.setRotationPoint(1F, 5F, 1.5F);
        setRotateAngle(leftLowerLeg, 0F, 0F, 0F);
        leftLowerLeg.mirror = true;
        leftLowerLeg.addBox("leftLowerLeg", -1F, 0F, -1.5F, 2, 6, 3);
        leftFoot = new MowzieModelRenderer(this, "leftFoot");
        leftFoot.setRotationPoint(0F, 5F, -1F);
        setRotateAngle(leftFoot, 0F, 0F, 0F);
        leftFoot.mirror = true;
        leftFoot.addBox("leftFoot", -1.5F, 0F, -4F, 3, 2, 7);
        leftLowerLeg.addChild(leftFoot);
        leftUpperLeg.addChild(leftLowerLeg);
        lowerBody.addChild(leftUpperLeg);
        upperBody = new MowzieModelRenderer(this, "upperBody");
        upperBody.setRotationPoint(0F, -3.8F, 0F);
        setRotateAngle(upperBody, 0F, 0F, 0F);
        upperBody.mirror = true;
        upperBody.addBox("upperBody", -2.5F, 0F, -6F, 5, 6, 6);
        rightUpperArm = new MowzieModelRenderer(this, "rightUpperArm");
        rightUpperArm.setRotationPoint(-2.5F, 2.8F, -2.5F);
        setRotateAngle(rightUpperArm, 0F, 0F, 0F);
        rightUpperArm.mirror = true;
        rightUpperArm.addBox("rightUpperArm", -2F, 0F, -1.5F, 2, 4, 3);
        rightLowerArm = new MowzieModelRenderer(this, "rightLowerArm");
        rightLowerArm.setRotationPoint(-1F, 3F, 1.5F);
        setRotateAngle(rightLowerArm, 0F, 0F, 0F);
        rightLowerArm.mirror = true;
        rightLowerArm.addBox("rightLowerArm", -1.1F, 0F, -1F, 2, 4, 2);
        rightUpperArm.addChild(rightLowerArm);
        upperBody.addChild(rightUpperArm);
        leftUpperArm = new MowzieModelRenderer(this, "leftUpperArm");
        leftUpperArm.setRotationPoint(2.5F, 2.8F, -2.5F);
        setRotateAngle(leftUpperArm, 0F, 0F, 0F);
        leftUpperArm.mirror = true;
        leftUpperArm.addBox("leftUpperArm", 0F, 0F, -1.5F, 2, 4, 3);
        leftLowerArm = new MowzieModelRenderer(this, "leftLowerArm");
        leftLowerArm.setRotationPoint(1F, 3F, 1.5F);
        setRotateAngle(leftLowerArm, 0F, 0F, 0F);
        leftLowerArm.mirror = true;
        leftLowerArm.addBox("leftLowerArm", -0.9F, 0F, -1F, 2, 4, 2);
        leftUpperArm.addChild(leftLowerArm);
        upperBody.addChild(leftUpperArm);


        headdummy = new MowzieModelRenderer(this, "headdummy");
        headdummy.setRotationPoint(0F, -1.9F, -5F);
        headdummy.addBox("headdummy", -1F, -1F, -1F, 1, 1, 1);
        setRotateAngle(headdummy, 0F, 0F, 0F);

        headpivot = new MowzieModelRenderer(this, "headpivot");
        headpivot.setRotationPoint(0, 0, 0);
        headpivot.addBox("headpivot", -0.5F, -0.5F, -0.5F, 1, 1, 1);
        setRotateAngle(headpivot, 0F, 0F, 0F);

        neck = new MowzieModelRenderer(this, "neck");
        neck.setRotationPoint(0F, 4F, -6F);
        setRotateAngle(neck, 0F, 0F, 0F);
        neck.mirror = true;
        neck.addBox("neck", -2F, -4F, -6F, 4, 4, 6);
        head = new MowzieModelRenderer(this, "head");
        head.setRotationPoint(0F, 0F, 0F);
        setRotateAngle(head, 0F, 0F, 0F);
        head.mirror = true;
        head.addBox("head", -2.5F, -2F, -5F, 5, 5, 5);
        lowerJaw = new MowzieModelRenderer(this, "lowerJaw");
        lowerJaw.setRotationPoint(0F, 2F, -5F);
        setRotateAngle(lowerJaw, 0F, 0F, 0F);
        lowerJaw.mirror = true;
        lowerJaw.addBox("lowerJaw", -1.5F, 0F, -6F, 3, 1, 6);
        head.addChild(lowerJaw);
        upperJaw = new MowzieModelRenderer(this, "upperJaw");
        upperJaw.setRotationPoint(0F, 0.5F, -4.5F);
        setRotateAngle(upperJaw, 0F, 0F, 0F);
        upperJaw.mirror = true;
        upperJaw.addBox("upperJaw", -2F, -1.5F, -7F, 4, 3, 7);
        teeth = new MowzieModelRenderer(this, "teeth");
        teeth.setRotationPoint(0F, 1.5F, -3F);
        setRotateAngle(teeth, 0F, 0F, 0F);
        teeth.mirror = true;
        teeth.addBox("teeth", -2F, 0F, -4F, 4, 1, 4);
        upperJaw.addChild(teeth);
        crest = new MowzieModelRenderer(this, "crest");
        crest.setRotationPoint(0F, -1F, -0.5F);
        setRotateAngle(crest, 0F, 0F, 0F);
        crest.mirror = true;
        crest.addBox("crest", -0.5F, -1F, -2F, 1, 1, 2);
        upperJaw.addChild(crest);
        head.addChild(upperJaw);
        neck.addChild(headdummy);
        headpivot.addChild(head);
        upperBody.addChild(neck);
        sail2_upperBody = new MowzieModelRenderer(this, "sail2_upperBody");
        sail2_upperBody.setRotationPoint(0F, 2.3F, -0.2F);
        setRotateAngle(sail2_upperBody, 0F, 0F, 0F);
        sail2_upperBody.mirror = true;
        sail2_upperBody.addBox("sail2_upperBody", -0.5F, -10F, -1F, 1, 10, 2);
        upperBody.addChild(sail2_upperBody);
        sail1_upperBody = new MowzieModelRenderer(this, "sail1_upperBody");
        sail1_upperBody.setRotationPoint(0F, 4.5F, -2.4F);
        setRotateAngle(sail1_upperBody, 0F, 0F, 0F);
        sail1_upperBody.mirror = true;
        sail1_upperBody.addBox("sail1_upperBody", -0.5F, -10F, -1F, 1, 10, 2);
        upperBody.addChild(sail1_upperBody);
        lowerBody.addChild(upperBody);
        this.headpivot.rotationPointX = this.headdummy.rotationPointX;
        this.headpivot.rotationPointY = this.headdummy.rotationPointY + 12.5F;
        this.headpivot.rotationPointZ = this.headdummy.rotationPointZ - 7;
        this.upperBody.rotateAngleX = (float) Math.toRadians(6);
        this.sail1_upperBody.rotateAngleX = this.sail2_upperBody.rotateAngleX = -(this.upperBody.rotateAngleX);
        this.neck.rotateAngleX = (float) Math.toRadians(-34);
        this.tail2.rotateAngleX = (float) Math.toRadians(-4);
        this.tail3.rotateAngleX = (float) Math.toRadians(2);
        this.leftUpperArm.rotateAngleX = (float) Math.toRadians(-6);
        this.rightUpperArm.rotateAngleX = (float) Math.toRadians(-6);
        this.leftLowerArm.rotateAngleX = (float) Math.toRadians(-30);
        this.rightLowerArm.rotateAngleX = (float) Math.toRadians(-30);
        this.leftUpperLeg.rotateAngleX = (float) Math.toRadians(-15);
        this.rightUpperLeg.rotateAngleX = (float) Math.toRadians(-15);
        this.leftFoot.rotateAngleX = (float) Math.toRadians(15);
        this.rightFoot.rotateAngleX = (float) Math.toRadians(15);
        doMowzieStuff(false);
    }
/*
    @Override
    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean modelized)
    {
        this.headpivot.rotationPointX = this.headdummy.rotationPointX;
        this.headpivot.rotationPointY = this.headdummy.rotationPointY + 12.5F;
        this.headpivot.rotationPointZ = this.headdummy.rotationPointZ - 7;

        this.upperBody.rotateAngleX = (float) Math.toRadians(6);
        this.sail1_upperBody.rotateAngleX = this.sail2_upperBody.rotateAngleX = -(this.upperBody.rotateAngleX);
        this.neck.rotateAngleX = (float) Math.toRadians(-34);
        this.tail2.rotateAngleX = (float) Math.toRadians(-4);
        this.tail3.rotateAngleX = (float) Math.toRadians(2);
        this.leftUpperArm.rotateAngleX = (float) Math.toRadians(-6);
        this.rightUpperArm.rotateAngleX = (float) Math.toRadians(-6);
        this.leftLowerArm.rotateAngleX = (float) Math.toRadians(-30);
        this.rightLowerArm.rotateAngleX = (float) Math.toRadians(-30);
        this.leftUpperLeg.rotateAngleX = (float) Math.toRadians(-15);
        this.rightUpperLeg.rotateAngleX = (float) Math.toRadians(-15);
        this.leftFoot.rotateAngleX = (float) Math.toRadians(15);
        this.rightFoot.rotateAngleX = (float) Math.toRadians(15);

        if (!modelized)
        {
            this.tail1.rotateAngleY = 0.08F * MathHelper.sin(var3 * (float) 0.1F + (var2 + 2));
            this.tail2.rotateAngleY = 0.10F * MathHelper.sin(var3 * (float) 0.1F + var2 + 1);
            this.tail3.rotateAngleY = 0.15F * MathHelper.sin(var3 * (float) 0.1F + var2);

            this.rightUpperLeg.rotateAngleX = (float) Math.toRadians(-15) + MathHelper.cos(var1 * 0.5662F) * 1.0F * var2;
            this.leftUpperLeg.rotateAngleX = (float) Math.toRadians(-15) + MathHelper.cos(var1 * 0.5662F + (float) Math.PI) * 1.0F * var2;

            this.headpivot.rotateAngleX = (var5 / (180F / (float) Math.PI));
            this.headpivot.rotateAngleY = (var4 / (180F / (float) Math.PI));
        }
        else
        {
            this.standingPose();
        }


    }
*/

   /* public void standingPose()
    {
        this.tail1.rotateAngleY = 0;
        this.tail2.rotateAngleY = 0;
        this.tail3.rotateAngleY = 0;

        this.leftUpperLeg.rotateAngleX = (float) Math.toRadians(-15);
        this.rightUpperLeg.rotateAngleX = (float) Math.toRadians(-15);

        this.headpivot.rotateAngleX = (float) Math.toRadians(5);
        this.headpivot.rotateAngleY = 0;
    }*/

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

}
