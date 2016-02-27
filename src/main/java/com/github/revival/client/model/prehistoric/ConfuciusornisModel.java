package com.github.revival.client.model.prehistoric;

import com.github.revival.client.model.base.PrehistoricModel;
import com.github.revival.server.entity.mob.test.NewPrehistoricEntity;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;

public class ConfuciusornisModel extends PrehistoricModel {
    public MowzieModelRenderer rightLeg;
    public MowzieModelRenderer rightFoot;
    public MowzieModelRenderer leftLeg;
    public MowzieModelRenderer body;
    public MowzieModelRenderer leftFoot;
    public MowzieModelRenderer rightWing;
    public MowzieModelRenderer leftWing;
    public MowzieModelRenderer tailFeathers;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer leftTail1;
    public MowzieModelRenderer rightTail1;
    public MowzieModelRenderer Headpivot;
    public MowzieModelRenderer head;
    public MowzieModelRenderer headFeathers;
    public MowzieModelRenderer upperBeak;
    public MowzieModelRenderer lowerBeak;
    public MowzieModelRenderer leftTail2;
    public MowzieModelRenderer leftTail3;
    public MowzieModelRenderer leftTailFan;
    public MowzieModelRenderer rightTail2;
    public MowzieModelRenderer rightTail3;
    public MowzieModelRenderer rightTailFan;

    public ConfuciusornisModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.rightTail3 = new MowzieModelRenderer(this, 50, 20);
        this.rightTail3.setRotationPoint(0.0F, 0.0F, 2.9F);
        this.rightTail3.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 12, 0.0F);
        this.setRotateAngle(rightTail3, 0.08726646259971647F, 0.006981317007977318F, 0.0F);
        this.headFeathers = new MowzieModelRenderer(this, 35, 0);
        this.headFeathers.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.headFeathers.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(headFeathers, -1.1897909510845344F, -0.0F, 0.0F);
        this.body = new MowzieModelRenderer(this, 0, 7);
        this.body.setRotationPoint(0.0F, 19.2F, 0.5F);
        this.body.addBox(-2.0F, -2.0F, -7.0F, 4, 4, 8, 0.0F);
        this.setRotateAngle(body, -0.2638937829015426F, 0.0F, 0.0F);
        this.rightWing = new MowzieModelRenderer(this, 27, 15);
        this.rightWing.setRotationPoint(-2.0F, 0.5F, -6.0F);
        this.rightWing.addBox(-1.0F, -1.0F, -1.0F, 1, 7, 3, 0.0F);
        this.setRotateAngle(rightWing, 1.5053464798451093F, -0.003490658503988659F, 0.0F);
        this.tailFeathers = new MowzieModelRenderer(this, 15, 20);
        this.tailFeathers.setRotationPoint(0.0F, -0.5F, 0.9F);
        this.tailFeathers.addBox(-2.0F, 0.0F, 0.2F, 4, 3, 1, 0.0F);
        this.setRotateAngle(tailFeathers, 1.435944321646531F, -0.0F, 0.0F);
        this.rightTail2 = new MowzieModelRenderer(this, 54, 28);
        this.rightTail2.setRotationPoint(0.0F, 0.0F, 3.2F);
        this.rightTail2.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rightTail2, 0.07365289443416069F, 0.013962634015954637F, 0.0F);
        this.rightLeg = new MowzieModelRenderer(this, 16, 6);
        this.rightLeg.setRotationPoint(-1.5F, 21.0F, -1.0F);
        this.rightLeg.addBox(-0.6F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rightLeg, 0.0F, -0.0F, 0.017453292519943295F);
        this.leftFoot = new MowzieModelRenderer(this, 22, 12);
        this.leftFoot.mirror = true;
        this.leftFoot.setRotationPoint(0.0F, 2.8F, 0.5F);
        this.leftFoot.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
        this.leftTail2 = new MowzieModelRenderer(this, 54, 28);
        this.leftTail2.setRotationPoint(0.0F, 0.0F, 3.2F);
        this.leftTail2.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(leftTail2, 0.07365289443416069F, 0.0F, 0.0F);
        this.leftTail3 = new MowzieModelRenderer(this, 50, 20);
        this.leftTail3.setRotationPoint(0.0F, 0.0F, 2.9F);
        this.leftTail3.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 12, 0.0F);
        this.setRotateAngle(leftTail3, 0.08726646259971647F, -0.0F, 0.0F);
        this.leftLeg = new MowzieModelRenderer(this, 16, 6);
        this.leftLeg.setRotationPoint(1.5F, 21.0F, -1.0F);
        this.leftLeg.addBox(-0.4F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(leftLeg, 0.0F, -0.0F, 0.017453292519943295F);
        this.head = new MowzieModelRenderer(this, 25, 1);
        this.head.setRotationPoint(0F, 0F, 0F);
        this.head.addBox(-1.5F, -3.0F, -2.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(head, 0, -0.0F, 0.0F);
        this.Headpivot = new MowzieModelRenderer(this, 0, 0);
        this.Headpivot.setRotationPoint(0.0F, -1.5F, -0.5F);
        this.Headpivot.addBox(0F, 0F, 0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(Headpivot, -0.3141592653589793F, -0.0F, 0.0F);
        this.upperBeak = new MowzieModelRenderer(this, 49, 4);
        this.upperBeak.setRotationPoint(0.0F, -1.2F, -0.8F);
        this.upperBeak.addBox(-1.0F, -1.0F, -3.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(upperBeak, 0.14870205226991687F, -0.0F, 0.0F);
        this.leftTail1 = new MowzieModelRenderer(this, 0, 0);
        this.leftTail1.setRotationPoint(1.4F, 0.3F, 0.5F);
        this.leftTail1.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(leftTail1, -0.05899212871740834F, -0.0F, 0.0F);
        this.rightTail1 = new MowzieModelRenderer(this, 0, 0);
        this.rightTail1.setRotationPoint(-1.4F, 0.3F, 0.5F);
        this.rightTail1.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(rightTail1, -0.05899212871740834F, 0.0F, 0.0F);
        this.leftTailFan = new MowzieModelRenderer(this, 15, 29);
        this.leftTailFan.setRotationPoint(0.0F, 0.1F, 12.0F);
        this.leftTailFan.addBox(-1.0F, -0.1F, 0.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(leftTailFan, 0.017453292519943295F, -0.0F, 0.0F);
        this.rightTailFan = new MowzieModelRenderer(this, 15, 29);
        this.rightTailFan.mirror = true;
        this.rightTailFan.setRotationPoint(0.0F, 0.1F, 12.0F);
        this.rightTailFan.addBox(-1.0F, -0.1F, 0.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(rightTailFan, 0.0F, -0.0F, 0.04206243497306334F);
        this.rightFoot = new MowzieModelRenderer(this, 22, 12);
        this.rightFoot.setRotationPoint(0.0F, 2.8F, 0.5F);
        this.rightFoot.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
        this.leftWing = new MowzieModelRenderer(this, 27, 15);
        this.leftWing.setRotationPoint(2.0F, 0.5F, -6.0F);
        this.leftWing.addBox(0.0F, -1.0F, -1.0F, 1, 7, 3, 0.0F);
        this.setRotateAngle(leftWing, 1.5053464798451093F, 0.003490658503988659F, 0.0F);
        this.lowerBeak = new MowzieModelRenderer(this, 38, 4);
        this.lowerBeak.setRotationPoint(0.0F, -1.1F, -0.8F);
        this.lowerBeak.addBox(-1.0F, 0.0F, -3.5F, 2, 1, 3, 0.0F);
        this.neck = new MowzieModelRenderer(this, 15, 1);
        this.neck.setRotationPoint(0.0F, -0.5F, -6.5F);
        this.neck.addBox(-1.0F, -2.5F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(neck, 0.5846852994181004F, -0.0F, 0.0F);
        this.rightTail2.addChild(this.rightTail3);
        this.head.addChild(this.headFeathers);
        this.body.addChild(this.rightWing);
        this.body.addChild(this.tailFeathers);
        this.rightTail1.addChild(this.rightTail2);
        this.leftLeg.addChild(this.leftFoot);
        this.leftTail1.addChild(this.leftTail2);
        this.leftTail2.addChild(this.leftTail3);
        this.neck.addChild(this.Headpivot);
        this.Headpivot.addChild(this.head);
        this.head.addChild(this.upperBeak);
        this.body.addChild(this.leftTail1);
        this.body.addChild(this.rightTail1);
        this.leftTail3.addChild(this.leftTailFan);
        this.rightTail3.addChild(this.rightTailFan);
        this.rightLeg.addChild(this.rightFoot);
        this.body.addChild(this.leftWing);
        this.head.addChild(this.lowerBeak);
        this.body.addChild(this.neck);
        doMowzieStuff(false);
    }

/*
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
    {
        this.head.rotateAngleX = par5 / (180F / (float) Math.PI);
        this.head.rotateAngleY = par4 / (180F / (float) Math.PI);
        this.rightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        this.leftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 1.4F * par2;
    }
*/

    @Override
    public void renderFossil(NewPrehistoricEntity entity, float f, float f1,
                             float f2, float f3, float f4, float f5) {
        // TODO Auto-generated method stub

    }

    @Override
    public void renderLiving(NewPrehistoricEntity entity, float f, float f1,
                             float f2, float f3, float f4, float f5) {
        // TODO Auto-generated method stub

    }

    @Override
    public void renderSleeping(NewPrehistoricEntity entity, float f, float f1,
                               float f2, float f3, float f4, float f5) {
        // TODO Auto-generated method stub

    }
}
