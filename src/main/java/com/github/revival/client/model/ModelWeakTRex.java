package com.github.revival.client.model;

import com.github.revival.client.model.mowzie.MowzieModelBase;
import com.github.revival.client.model.mowzie.MowzieModelRenderer;
import net.minecraft.entity.Entity;

/**
 * TyrannosaurusFeatheredPosture.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelWeakTRex extends MowzieModelBase
{
    public MowzieModelRenderer lowerBody;
    public MowzieModelRenderer rightThigh;
    public MowzieModelRenderer leftThigh;
    public MowzieModelRenderer tail1;
    public MowzieModelRenderer upperBody;
    public MowzieModelRenderer tail2;
    public MowzieModelRenderer tail3;
    public MowzieModelRenderer leftTailFeather;
    public MowzieModelRenderer rightTailFeather;
    public MowzieModelRenderer middleTailFrontFeather;
    public MowzieModelRenderer middleTailBackFeather;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer leftUpperArm;
    public MowzieModelRenderer rightUpperArm;
    public MowzieModelRenderer head;
    public MowzieModelRenderer leftCrest;
    public MowzieModelRenderer rightCrest;
    public MowzieModelRenderer middleCrest;
    public MowzieModelRenderer upperJaw;
    public MowzieModelRenderer lowerJaw;
    public MowzieModelRenderer teeth;
    public MowzieModelRenderer leftLowerArm;
    public MowzieModelRenderer rightLowerArm;
    public MowzieModelRenderer rightLeg;
    public MowzieModelRenderer rightFoot;
    public MowzieModelRenderer leftLeg;
    public MowzieModelRenderer leftFoot;

    public ModelWeakTRex()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.lowerBody = new MowzieModelRenderer(this, 57, 20);
        this.lowerBody.setRotationPoint(0.0F, 13.0F, -1.0F);
        this.lowerBody.addBox(-4.0F, 0.0F, 0.0F, 8, 11, 12, 0.0F);
        this.teeth = new MowzieModelRenderer(this, 44, 18);
        this.teeth.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.teeth.addBox(-2.5F, 0.0F, -6.0F, 5, 1, 7, 0.0F);
        this.tail2 = new MowzieModelRenderer(this, 74, 48);
        this.tail2.setRotationPoint(0.0F, 0.6F, 8.0F);
        this.tail2.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 10, 0.0F);
        this.setRotateAngle(tail2, -0.11833332328521555F, 1.3306390217204767F, 0.0F);
        this.middleTailFrontFeather = new MowzieModelRenderer(this, 10, 53);
        this.middleTailFrontFeather.setRotationPoint(0.0F, 1.2F, 0.0F);
        this.middleTailFrontFeather.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        this.setRotateAngle(middleTailFrontFeather, 0.3269001688985379F, -0.0F, 0.0F);
        this.middleCrest = new MowzieModelRenderer(this, 10, 53);
        this.middleCrest.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.middleCrest.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        this.setRotateAngle(middleCrest, 0.5621705520673735F, -0.0F, 0.0F);
        this.rightLowerArm = new MowzieModelRenderer(this, 34, 33);
        this.rightLowerArm.mirror = true;
        this.rightLowerArm.setRotationPoint(-1.01F, 2.5F, 1.0F);
        this.rightLowerArm.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(rightLowerArm, -1.9198621771937625F, -0.0F, 0.0F);
        this.leftTailFeather = new MowzieModelRenderer(this, 10, 53);
        this.leftTailFeather.setRotationPoint(1.0F, 1.7F, 0.0F);
        this.leftTailFeather.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        this.setRotateAngle(leftTailFeather, 0.1038470904936626F, -0.0F, 0.0F);
        this.upperJaw = new MowzieModelRenderer(this, 28, 0);
        this.upperJaw.setRotationPoint(0.0F, -0.5F, -6.7F);
        this.upperJaw.addBox(-2.5F, -2.0F, -7.0F, 5, 5, 7, 0.0F);
        this.setRotateAngle(upperJaw, 0.03490658503988659F, -0.0F, 0.0F);
        this.leftUpperArm = new MowzieModelRenderer(this, 35, 26);
        this.leftUpperArm.setRotationPoint(3.0F, 2.3F, -9.0F);
        this.leftUpperArm.addBox(0.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(leftUpperArm, 0.2617993877991494F, -0.0F, 0.0F);
        this.rightUpperArm = new MowzieModelRenderer(this, 35, 26);
        this.rightUpperArm.mirror = true;
        this.rightUpperArm.setRotationPoint(-3.0F, 2.3F, -9.0F);
        this.rightUpperArm.addBox(-2.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(rightUpperArm, 0.2617993877991494F, -0.0F, 0.0F);
        this.rightCrest = new MowzieModelRenderer(this, 10, 53);
        this.rightCrest.setRotationPoint(-2.5F, -0.8F, -0.5F);
        this.rightCrest.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        this.setRotateAngle(rightCrest, -0.07068583470577035F, -0.0F, 0.0F);
        this.lowerJaw = new MowzieModelRenderer(this, 27, 12);
        this.lowerJaw.setRotationPoint(0.0F, 2.5F, -7.0F);
        this.lowerJaw.addBox(-2.0F, 0.0F, -6.0F, 4, 2, 6, 0.0F);
        this.setRotateAngle(lowerJaw, 0.02199114857512855F, -0.0F, 0.0F);
        this.neck = new MowzieModelRenderer(this, 52, 0);
        this.neck.setRotationPoint(0.0F, -0.1F, -7.5F);
        this.neck.addBox(-2.5F, -3.0F, -9.0F, 5, 7, 9, 0.0F);
        this.setRotateAngle(neck, 0.24434609527920614F, -0.0F, 0.0F);
        this.upperBody = new MowzieModelRenderer(this, 80, 0);
        this.upperBody.setRotationPoint(0.0F, 3.9F, 2.5F);
        this.upperBody.addBox(-3.0F, -4.0F, -10.0F, 6, 10, 10, 0.0F);
        this.setRotateAngle(upperBody, 0.08726646259971647F, -0.0F, 0.0F);
        this.rightThigh = new MowzieModelRenderer(this, 2, 17);
        this.rightThigh.setRotationPoint(-2.5F, 16.6F, 7.5F);
        this.rightThigh.addBox(-4.0F, -1.0F, -3.0F, 4, 8, 6, 0.0F);
        this.leftLowerArm = new MowzieModelRenderer(this, 34, 33);
        this.leftLowerArm.setRotationPoint(1.01F, 2.5F, 1.0F);
        this.leftLowerArm.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(leftLowerArm, -1.9198621771937625F, 0.0F, 0.0F);
        this.head = new MowzieModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -0.8F, -7.1F);
        this.head.addBox(-3.5F, -3.0F, -7.0F, 7, 8, 7, 0.0F);
        this.setRotateAngle(head, -0.33161255787892263F, -0.0F, 0.0F);
        this.rightFoot = new MowzieModelRenderer(this, 3, 45);
        this.rightFoot.setRotationPoint(0.0F, 8.0F, 1.0F);
        this.rightFoot.addBox(-1.5F, 0.0F, -4.0F, 3, 2, 5, 0.0F);
        this.setRotateAngle(rightFoot, 1.5707963267948966F, -0.0F, 0.0F);
        this.tail3 = new MowzieModelRenderer(this, 103, 49);
        this.tail3.setRotationPoint(-0.5F, 2.7F, 9.0F);
        this.tail3.addBox(-1.0F, 0.0F, 0.0F, 2, 3, 8, 0.0F);
        this.setRotateAngle(tail3, 0.22689280275926282F, 0.6332054526235428F, 0.4363323129985824F);
        this.rightLeg = new MowzieModelRenderer(this, 98, 31);
        this.rightLeg.setRotationPoint(-2.5F, 4.5F, 1.5F);
        this.rightLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 9, 3, 0.0F);
        this.setRotateAngle(rightLeg, -1.5707963267948966F, -0.0F, 0.0F);
        this.middleTailBackFeather = new MowzieModelRenderer(this, 10, 53);
        this.middleTailBackFeather.setRotationPoint(0.0F, 1.5F, 5.0F);
        this.middleTailBackFeather.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        this.setRotateAngle(middleTailBackFeather, 0.1759291886010284F, -0.0F, 0.0F);
        this.leftCrest = new MowzieModelRenderer(this, 10, 53);
        this.leftCrest.setRotationPoint(2.5F, -0.8F, -0.5F);
        this.leftCrest.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        this.setRotateAngle(leftCrest, -0.07068583470577035F, -0.0F, 0.0F);
        this.leftThigh = new MowzieModelRenderer(this, 2, 17);
        this.leftThigh.mirror = true;
        this.leftThigh.setRotationPoint(2.5F, 16.6F, 7.5F);
        this.leftThigh.addBox(0.0F, -1.0F, -3.0F, 4, 8, 6, 0.0F);
        this.leftFoot = new MowzieModelRenderer(this, 3, 45);
        this.leftFoot.setRotationPoint(0.0F, 8.0F, 1.0F);
        this.leftFoot.addBox(-1.5F, 0.0F, -4.0F, 3, 2, 5, 0.0F);
        this.setRotateAngle(leftFoot, 1.5707963267948966F, -0.0F, 0.0F);
        this.leftLeg = new MowzieModelRenderer(this, 98, 31);
        this.leftLeg.setRotationPoint(2.5F, 4.5F, 2.5F);
        this.leftLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 9, 3, 0.0F);
        this.setRotateAngle(leftLeg, -1.5707963267948966F, -0.0F, 0.0F);
        this.rightTailFeather = new MowzieModelRenderer(this, 10, 53);
        this.rightTailFeather.setRotationPoint(-1.0F, 1.7F, 0.0F);
        this.rightTailFeather.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        this.setRotateAngle(rightTailFeather, 0.1038470904936626F, -0.0F, 0.0F);
        this.tail1 = new MowzieModelRenderer(this, 36, 47);
        this.tail1.setRotationPoint(0.0F, 0.2F, 10.6F);
        this.tail1.addBox(-3.0F, 0.0F, 0.0F, 6, 7, 10, 0.0F);
        this.setRotateAngle(tail1, -0.36163222101322506F, 0.49724430389318447F, 0.0F);
        this.upperJaw.addChild(this.teeth);
        this.tail1.addChild(this.tail2);
        this.tail3.addChild(this.middleTailFrontFeather);
        this.head.addChild(this.middleCrest);
        this.rightUpperArm.addChild(this.rightLowerArm);
        this.tail3.addChild(this.leftTailFeather);
        this.head.addChild(this.upperJaw);
        this.upperBody.addChild(this.leftUpperArm);
        this.upperBody.addChild(this.rightUpperArm);
        this.head.addChild(this.rightCrest);
        this.head.addChild(this.lowerJaw);
        this.upperBody.addChild(this.neck);
        this.lowerBody.addChild(this.upperBody);
        this.leftUpperArm.addChild(this.leftLowerArm);
        this.neck.addChild(this.head);
        this.rightLeg.addChild(this.rightFoot);
        this.tail2.addChild(this.tail3);
        this.rightThigh.addChild(this.rightLeg);
        this.tail3.addChild(this.middleTailBackFeather);
        this.head.addChild(this.leftCrest);
        this.leftLeg.addChild(this.leftFoot);
        this.leftThigh.addChild(this.leftLeg);
        this.tail3.addChild(this.rightTailFeather);
        this.lowerBody.addChild(this.tail1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.lowerBody.render(f5);
        this.rightThigh.render(f5);
        this.leftThigh.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(MowzieModelRenderer MowzieModelRenderer, float x, float y, float z)
    {
        MowzieModelRenderer.rotateAngleX = x;
        MowzieModelRenderer.rotateAngleY = y;
        MowzieModelRenderer.rotateAngleZ = z;
    }
}
