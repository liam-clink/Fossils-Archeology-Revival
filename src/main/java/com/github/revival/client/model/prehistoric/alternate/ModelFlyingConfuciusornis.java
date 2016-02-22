package com.github.revival.client.model.prehistoric.alternate;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;

public class ModelFlyingConfuciusornis extends ModelPrehistoric {
    public MowzieModelRenderer rightLeg;
    public MowzieModelRenderer leftLeg;
    public MowzieModelRenderer body;
    public MowzieModelRenderer rightFoot;
    public MowzieModelRenderer leftFoot;
    public MowzieModelRenderer tailFeathers;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer leftWing1;
    public MowzieModelRenderer rightWing1;
    public MowzieModelRenderer leftTail1;
    public MowzieModelRenderer rightTail1;
    public MowzieModelRenderer headPivot;
    public MowzieModelRenderer head;
    public MowzieModelRenderer headFeathers;
    public MowzieModelRenderer upperBeak;
    public MowzieModelRenderer lowerBeak;
    public MowzieModelRenderer leftWing2;
    public MowzieModelRenderer rightWing2;
    public MowzieModelRenderer leftTail2;
    public MowzieModelRenderer leftTail3;
    public MowzieModelRenderer leftTail4;
    public MowzieModelRenderer leftTail5;
    public MowzieModelRenderer leftTailFan;
    public MowzieModelRenderer rightTail2;
    public MowzieModelRenderer rightTail3;
    public MowzieModelRenderer rightTail4;
    public MowzieModelRenderer rightTail5;
    public MowzieModelRenderer rightTailFan;
    public MowzieModelRenderer leftWingPivot;
    public MowzieModelRenderer rightWingPivot;

    public ModelFlyingConfuciusornis() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.headPivot = new MowzieModelRenderer(this, 0, 0);
        this.headPivot.setRotationPoint(0.0F, -3.0F, 1.1F);
        this.headPivot.addBox(0F, 0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(headPivot, -0.017453292519943295F, -0.0F, 0.0F);
        this.head = new MowzieModelRenderer(this, 25, 1);
        this.head.setRotationPoint(0.0F, 0F, 0F);
        this.head.addBox(-1.5F, -2.0F, -2.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(head, 0F, -0.0F, 0.0F);
        this.leftTail2 = new MowzieModelRenderer(this, 0, 26);
        this.leftTail2.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.leftTail2.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.neck = new MowzieModelRenderer(this, 15, 1);
        this.neck.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.neck.addBox(-1.0F, -2.5F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(neck, 1.5987215948268056F, -0.0F, 0.0F);
        this.rightTail1 = new MowzieModelRenderer(this, 0, 21);
        this.rightTail1.setRotationPoint(-1.5F, 0.0F, 1.0F);
        this.rightTail1.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.rightTail3 = new MowzieModelRenderer(this, 6, 21);
        this.rightTail3.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.rightTail3.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.leftTail3 = new MowzieModelRenderer(this, 6, 21);
        this.leftTail3.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.leftTail3.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.rightTail5 = new MowzieModelRenderer(this, 0, 26);
        this.rightTail5.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.rightTail5.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.leftWingPivot = new MowzieModelRenderer(this, 0, 0);
        this.leftWingPivot.mirror = true;
        this.leftWingPivot.setRotationPoint(2.0F, -1.0F, -5.0F);
        this.leftWingPivot.addBox(0.0F, 0F, 0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(leftWingPivot, -0.18587756533739608F, -0.0F, -1.5987215948268056F);
        this.leftWing1 = new MowzieModelRenderer(this, 37, 14);
        this.leftWing1.mirror = true;
        this.leftWing1.setRotationPoint(0F, 0F, 0F);
        this.leftWing1.addBox(0.0F, -0.4F, -1.0F, 1, 7, 4, 0.0F);
        this.setRotateAngle(leftWing1, -0F, -0.0F, 0F);
        this.leftTail4 = new MowzieModelRenderer(this, 2, 21);
        this.leftTail4.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.leftTail4.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
        this.upperBeak = new MowzieModelRenderer(this, 49, 4);
        this.upperBeak.setRotationPoint(0.0F, -1.3F, -0.9F);
        this.upperBeak.addBox(-1.0F, -1.0F, -3.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(upperBeak, -1.4220942745249796F, -0.0F, 0.0F);
        this.leftLeg = new MowzieModelRenderer(this, 16, 6);
        this.leftLeg.setRotationPoint(1.5F, 20.0F, -1.0F);
        this.leftLeg.addBox(-0.3F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(leftLeg, 1.1897909510845344F, -0.0F, 0.017453292519943295F);
        this.rightTail4 = new MowzieModelRenderer(this, 2, 21);
        this.rightTail4.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.rightTail4.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
        this.leftWing2 = new MowzieModelRenderer(this, 48, 14);
        this.leftWing2.setRotationPoint(0F, 6.0F, 0.0F);
        this.leftWing2.addBox(0.1F, 0F, -1.0F, 1, 7, 4, 0.0F);
        this.setRotateAngle(leftWing2, 0.3755948550291797F, 0.0F, 0F);
        this.leftTail1 = new MowzieModelRenderer(this, 0, 21);
        this.leftTail1.setRotationPoint(1.5F, 0.0F, 1.0F);
        this.leftTail1.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.lowerBeak = new MowzieModelRenderer(this, 38, 4);
        this.lowerBeak.setRotationPoint(0.0F, -1.3F, -0.8F);
        this.lowerBeak.addBox(-1.0F, 0.1F, -3.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(lowerBeak, -1.570970859720096F, -0.0F, 0.0F);
        this.rightFoot = new MowzieModelRenderer(this, 22, 12);
        this.rightFoot.setRotationPoint(-0.5F, 2.6F, 0.5F);
        this.rightFoot.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(rightFoot, 0.055326937288220246F, -0.0F, 0.0F);
        this.rightTail2 = new MowzieModelRenderer(this, 0, 26);
        this.rightTail2.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.rightTail2.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.tailFeathers = new MowzieModelRenderer(this, 15, 20);
        this.tailFeathers.setRotationPoint(0.0F, -0.8F, 0.94F);
        this.tailFeathers.addBox(-2.0F, 0.0F, 0.2F, 4, 3, 1, 0.0F);
        this.setRotateAngle(tailFeathers, 1.5243705686918474F, -0.0F, 0.0F);
        this.leftFoot = new MowzieModelRenderer(this, 22, 12);
        this.leftFoot.mirror = true;
        this.leftFoot.setRotationPoint(0.5F, 2.5F, 0.5F);
        this.leftFoot.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(leftFoot, 0.055326937288220246F, -0.0F, -0.1220127387905809F);
        this.body = new MowzieModelRenderer(this, 0, 7);
        this.body.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.body.addBox(-2.0F, -2.0F, -7.0F, 4, 4, 8, 0.0F);
        this.rightWingPivot = new MowzieModelRenderer(this, 0, 0);
        this.rightWingPivot.setRotationPoint(-2.0F, -1.0F, -5.0F);
        this.rightWingPivot.addBox(0F, 0F, 0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(rightWingPivot, -0.18587756533739608F, -0.0F, 1.5987215948268056F);
        this.rightWing1 = new MowzieModelRenderer(this, 37, 14);
        this.rightWing1.setRotationPoint(0F, 0F, 0F);
        this.rightWing1.addBox(-1.0F, -0.4F, -1.0F, 1, 7, 4, 0.0F);
        this.setRotateAngle(rightWing1, 0F, -0.0F, 0F);
        this.leftTailFan = new MowzieModelRenderer(this, 15, 29);
        this.leftTailFan.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.leftTailFan.addBox(-1.0F, -0.1F, 0.0F, 2, 1, 3, 0.0F);
        this.headFeathers = new MowzieModelRenderer(this, 35, 0);
        this.headFeathers.setRotationPoint(0.0F, 0.0F, 0.5F);
        this.headFeathers.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(headFeathers, -2.3881340155038413F, -0.0F, 0.0F);
        this.rightLeg = new MowzieModelRenderer(this, 16, 6);
        this.rightLeg.setRotationPoint(-1.5F, 20.0F, -1.0F);
        this.rightLeg.addBox(-0.6F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rightLeg, 1.1897909510845344F, -0.0F, 0.017453292519943295F);
        this.rightTailFan = new MowzieModelRenderer(this, 15, 29);
        this.rightTailFan.mirror = true;
        this.rightTailFan.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.rightTailFan.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 3, 0.0F);
        this.rightWing2 = new MowzieModelRenderer(this, 48, 14);
        this.rightWing2.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.rightWing2.addBox(-1.1F, 0.0F, -1.0F, 1, 7, 4, 0.0F);
        this.setRotateAngle(rightWing2, 0.3755948550291797F, -0.0F, 0.0F);
        this.leftTail5 = new MowzieModelRenderer(this, 0, 26);
        this.leftTail5.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.leftTail5.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.neck.addChild(this.headPivot);
        this.headPivot.addChild(head);
        this.leftTail1.addChild(this.leftTail2);
        this.body.addChild(this.neck);
        this.body.addChild(this.rightTail1);
        this.rightTail2.addChild(this.rightTail3);
        this.leftTail2.addChild(this.leftTail3);
        this.rightTail4.addChild(this.rightTail5);
        this.body.addChild(this.leftWingPivot);
        this.leftWingPivot.addChild(this.leftWing1);
        this.leftTail3.addChild(this.leftTail4);
        this.head.addChild(this.upperBeak);
        this.rightTail3.addChild(this.rightTail4);
        this.leftWing1.addChild(this.leftWing2);
        this.body.addChild(this.leftTail1);
        this.head.addChild(this.lowerBeak);
        this.rightLeg.addChild(this.rightFoot);
        this.rightTail1.addChild(this.rightTail2);
        this.body.addChild(this.tailFeathers);
        this.leftLeg.addChild(this.leftFoot);
        this.body.addChild(this.rightWingPivot);
        this.leftTail5.addChild(this.leftTailFan);
        this.head.addChild(this.headFeathers);
        this.rightTail5.addChild(this.rightTailFan);
        this.rightWingPivot.addChild(this.rightWing1);
        this.rightWing1.addChild(this.rightWing2);
        this.leftTail4.addChild(this.leftTail5);
    }

    @Override
    public void renderFossil(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {

    }

    @Override
    public void renderLiving(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {

    }

    @Override
    public void renderSleeping(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {

    }

  /*public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
    {
        this.head.rotateAngleX = par5 / (180F / (float) Math.PI);
        this.head.rotateAngleZ = par4 / (180F / (float) Math.PI);
        //this.rightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        //this.leftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        this.leftWing1.rotateAngleZ = (0.4F * -MathHelper.cos(par1 * (float) 0.2F + par2));
        this.rightWing1.rotateAngleZ = (-0.4F * -MathHelper.cos(par1 * (float) 0.2F + par2));
        this.leftWing2.rotateAngleZ = (0.2F * -MathHelper.cos(par1 * (float) 0.2F + par2));
        this.rightWing2.rotateAngleZ = (-0.2F * -MathHelper.cos(par1 * (float) 0.2F + par2));
        this.leftTail1.rotateAngleX = 0.1F * MathHelper.sin(par3 * (float) 0.1F + (par2 + 2));
        this.leftTail2.rotateAngleX = -0.06F * MathHelper.sin(par3 * (float) 0.1F + (par2 + 2));
        this.leftTail3.rotateAngleX = 0.06F * MathHelper.sin(par3 * (float) 0.1F + (par2 + 2));
        this.leftTail4.rotateAngleX = -0.06F * MathHelper.sin(par3 * (float) 0.1F + (par2 + 2));
        this.rightTail1.rotateAngleX = 0.1F * MathHelper.sin(par3 * (float) 0.1F + (par2 + 2));
        this.rightTail2.rotateAngleX = -0.06F * MathHelper.sin(par3 * (float) 0.1F + (par2 + 2));
        this.rightTail3.rotateAngleX = 0.06F * MathHelper.sin(par3 * (float) 0.1F + (par2 + 2));
        this.rightTail4.rotateAngleX = -0.06F * MathHelper.sin(par3 * (float) 0.1F + (par2 + 2));
    }
*/
}
