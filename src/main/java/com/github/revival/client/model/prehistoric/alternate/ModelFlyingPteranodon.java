package com.github.revival.client.model.prehistoric.alternate;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;

public class ModelFlyingPteranodon extends ModelPrehistoric {
    public AdvancedModelRenderer Leg;
    public AdvancedModelRenderer Leg2;
    public AdvancedModelRenderer WingR1;
    public AdvancedModelRenderer Body;
    public AdvancedModelRenderer WingL1;
    public AdvancedModelRenderer WingR2;
    public AdvancedModelRenderer HandR;
    public AdvancedModelRenderer Neck2;
    public AdvancedModelRenderer Body2;
    public AdvancedModelRenderer Fibre;
    public AdvancedModelRenderer Fibre2;
    public AdvancedModelRenderer Fibre3;
    public AdvancedModelRenderer Neck;
    public AdvancedModelRenderer Fibre4;
    public AdvancedModelRenderer Head;
    public AdvancedModelRenderer Beaka;
    public AdvancedModelRenderer Beak2;
    public AdvancedModelRenderer Crest;
    public AdvancedModelRenderer Beakb;
    public AdvancedModelRenderer HandL;
    public AdvancedModelRenderer WingL2;

    public ModelFlyingPteranodon() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Head = new AdvancedModelRenderer(this, 0, 55);
        this.Head.setRotationPoint(0.0F, -0.6F, -3.5F);
        this.Head.addBox(-2.0F, -3.0F, -5.0F, 4, 4, 5);
        this.setRotateAngle(Head, 1.0016444577195458F, -0.0F, 0.0F);
        this.Fibre2 = new AdvancedModelRenderer(this, 34, 34);
        this.Fibre2.setRotationPoint(1.0F, -0.1F, 0.0F);
        this.Fibre2.addBox(0.0F, -1.0F, 1.0F, 0, 1, 2);
        this.setRotateAngle(Fibre2, 0.37175513067479216F, -0.0F, 0.0F);
        this.Body2 = new AdvancedModelRenderer(this, 22, 32);
        this.Body2.setRotationPoint(0.0F, 0.4F, 6.6F);
        this.Body2.addBox(-2.0F, -1.27F, 0.0F, 4, 3, 2);
        this.setRotateAngle(Body2, -0.29740410453983374F, -0.0F, 0.0F);
        this.Fibre3 = new AdvancedModelRenderer(this, 34, 34);
        this.Fibre3.setRotationPoint(0.0F, -0.5F, 3.0F);
        this.Fibre3.addBox(0.0F, -1.0F, 1.0F, 0, 1, 2);
        this.setRotateAngle(Fibre3, 0.37175513067479216F, -0.0F, 0.0F);
        this.Leg2 = new AdvancedModelRenderer(this, 20, 41);
        this.Leg2.setRotationPoint(1.5F, 18.5F, 6.5F);
        this.Leg2.addBox(-0.7F, -0.27F, 0.0F, 1, 1, 3);
        this.setRotateAngle(Leg2, -0.5948082090796675F, -0.0F, 0.0F);
        this.Body = new AdvancedModelRenderer(this, 0, 30);
        this.Body.setRotationPoint(0.0F, 16.1F, 0.5F);
        this.Body.addBox(-2.0F, -1.5F, 0.0F, 4, 4, 7);
        this.setRotateAngle(Body, -0.07435102613495843F, -0.0F, 0.0F);
        this.Neck2 = new AdvancedModelRenderer(this, 0, 41);
        this.Neck2.setRotationPoint(0.0F, 0.1F, 1.0F);
        this.Neck2.addBox(-1.5F, -1.0F, -4.0F, 3, 3, 4);
        this.setRotateAngle(Neck2, -0.22759093446006054F, -0.0F, 0.0F);
        this.Crest = new AdvancedModelRenderer(this, 30, 51);
        this.Crest.setRotationPoint(0.0F, -2.5F, -2.0F);
        this.Crest.addBox(-1.0F, -1.2F, -4.5F, 2, 4, 6);
        this.setRotateAngle(Crest, 2.4651030355167913F, -0.0F, -3.141592653589793F);
        this.WingR2 = new AdvancedModelRenderer(this, 0, 18);
        this.WingR2.setRotationPoint(-8.8F, 0.0F, -2.0F);
        this.WingR2.addBox(-10.7F, -0.4F, -0.7F, 11, 1, 4);
        this.setRotateAngle(WingR2, 0.0F, 0.13962634015954636F, -0.12217304763960307F);
        this.HandR = new AdvancedModelRenderer(this, 58, 32);
        this.HandR.setRotationPoint(-9.5F, 0.1F, -2.5F);
        this.HandR.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1);
        this.setRotateAngle(HandR, 0.33161255787892263F, 0.045553093477052F, 1.0283479952750592F);
        this.Fibre = new AdvancedModelRenderer(this, 34, 34);
        this.Fibre.setRotationPoint(-1.0F, -0.1F, 0.0F);
        this.Fibre.addBox(0.0F, -1.0F, 1.0F, 0, 1, 2);
        this.setRotateAngle(Fibre, 0.37175513067479216F, -0.0F, 0.0F);
        this.WingR1 = new AdvancedModelRenderer(this, 0, 23);
        this.WingR1.setRotationPoint(-2.2F, 16.6F, 3.7F);
        this.WingR1.addBox(-9.5F, -0.5F, -3.0F, 10, 1, 6);
        this.setRotateAngle(WingR1, -0.08726646259971647F, 0.0F, 0.0F);
        this.WingL2 = new AdvancedModelRenderer(this, 31, 18);
        this.WingL2.setRotationPoint(8.8F, 0.0F, -2.0F);
        this.WingL2.addBox(-0.3F, -0.4F, -0.7F, 11, 1, 4);
        this.setRotateAngle(WingL2, 0.0F, -0.13962634015954636F, 0.12217304763960307F);
        this.Fibre4 = new AdvancedModelRenderer(this, 34, 34);
        this.Fibre4.setRotationPoint(0.0F, -0.1F, -0.5F);
        this.Fibre4.addBox(0.0F, -1.9F, -0.3F, 0, 1, 2);
        this.setRotateAngle(Fibre4, 0.7285004297824331F, -0.0F, 0.0F);
        this.Beak2 = new AdvancedModelRenderer(this, 38, 55);
        this.Beak2.setRotationPoint(0.0F, 0.5F, -4.8F);
        this.Beak2.addBox(-1.0F, -1.0F, -7.6F, 2, 1, 8);
        this.setRotateAngle(Beak2, 0.0022689280275926286F, -0.0F, 0.0F);
        this.Neck = new AdvancedModelRenderer(this, 0, 48);
        this.Neck.setRotationPoint(0.0F, 0.1F, -3.3F);
        this.Neck.addBox(-1.0F, -1.0F, -4.0F, 2, 3, 4);
        this.setRotateAngle(Neck, -0.3764675196551769F, -0.0F, 0.0F);
        this.Beaka = new AdvancedModelRenderer(this, 18, 54);
        this.Beaka.setRotationPoint(0.0F, -2.3F, -5.8F);
        this.Beaka.addBox(-0.9999F, 0.0F, -7.0F, 2, 2, 8);
        this.setRotateAngle(Beaka, 0.05462880558742251F, -0.0F, 0.0F);
        this.HandL = new AdvancedModelRenderer(this, 58, 32);
        this.HandL.setRotationPoint(9.5F, 0.1F, -2.5F);
        this.HandL.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1);
        this.WingL1 = new AdvancedModelRenderer(this, 32, 23);
        this.WingL1.setRotationPoint(2.2F, 16.6F, 3.7F);
        this.WingL1.addBox(-0.5F, -0.5F, -3.0F, 10, 1, 6);
        this.setRotateAngle(WingL1, -0.08726646259971647F, 0.0F, 0.0F);
        this.Beakb = new AdvancedModelRenderer(this, 18, 54);
        this.Beakb.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Beakb.addBox(-1.0001F, 0.0F, -7.0F, 2, 2, 8);
        this.Leg = new AdvancedModelRenderer(this, 20, 41);
        this.Leg.setRotationPoint(-1.5F, 18.5F, 6.5F);
        this.Leg.addBox(-0.3F, -0.27F, 0.0F, 1, 1, 3);
        this.setRotateAngle(Leg, -0.5948082090796675F, -0.0F, 0.0F);
        this.Body.addChild(this.Fibre2);
        this.WingL1.addChild(this.HandL);
        this.Body.addChild(this.Body2);
        this.Body.addChild(this.Neck2);
        this.Head.addChild(this.Beaka);
        this.Head.addChild(this.Beak2);
        this.WingL1.addChild(this.WingL2);
        this.Neck2.addChild(this.Neck);
        this.WingR1.addChild(this.HandR);
        this.Neck.addChild(this.Head);
        this.Head.addChild(this.Crest);
        this.Beaka.addChild(this.Beakb);
        this.Neck2.addChild(this.Fibre4);
        this.Body.addChild(this.Fibre3);
        this.Body.addChild(this.Fibre);
        this.WingR1.addChild(this.WingR2);
        doAdvancedStuff(false);

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

/*
    private void setRotationAngles(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, boolean modelized)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if (modelized) return;
        this.WingL1.rotateAngleZ = 0.4F * -MathHelper.cos(f * (float) 0.2F + f1);
        this.WingR1.rotateAngleZ = -0.4F * -MathHelper.cos(f * (float) 0.2F + f1);
        this.WingL2.rotateAngleZ = 0.4F * -MathHelper.cos(f * (float) 0.2F + f1);
        this.WingR2.rotateAngleZ = -0.4F * -MathHelper.cos(f * (float) 0.2F + f1);
    }
*/
}
