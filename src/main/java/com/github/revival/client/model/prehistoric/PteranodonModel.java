package com.github.revival.client.model.prehistoric;

import com.github.revival.client.model.base.PrehistoricModel;
import com.github.revival.server.entity.mob.test.NewPrehistoricEntity;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;

public class PteranodonModel extends PrehistoricModel {
    public MowzieModelRenderer Leg2;
    public MowzieModelRenderer WingL1;
    public MowzieModelRenderer Leg;
    public MowzieModelRenderer WingR1;
    public MowzieModelRenderer Body;
    public MowzieModelRenderer WingL1Child;
    public MowzieModelRenderer WingL1Child_1;
    public MowzieModelRenderer WingR1Child;
    public MowzieModelRenderer WingR1Child_1;
    public MowzieModelRenderer FibreL;
    public MowzieModelRenderer Tail;
    public MowzieModelRenderer Neck1;
    public MowzieModelRenderer Fibre2;
    public MowzieModelRenderer FibreR;
    public MowzieModelRenderer Neck2;
    public MowzieModelRenderer Fibre1;
    public MowzieModelRenderer Head;
    public MowzieModelRenderer Beak2;
    public MowzieModelRenderer Jaw;
    public MowzieModelRenderer CrestBase;
    public MowzieModelRenderer Beak1;
    public MowzieModelRenderer Crest;

    public PteranodonModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.FibreR = new MowzieModelRenderer(this, 34, 34);
        this.FibreR.setRotationPoint(-1.0F, -0.1F, 0.0F);
        this.FibreR.addBox(0.0F, -1.0F, 1.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(FibreR, 0.37175513067479216F, -0.0F, 0.0F);
        this.Leg = new MowzieModelRenderer(this, 20, 45);
        this.Leg.setRotationPoint(-1.5F, 21.0F, 6.5F);
        this.Leg.addBox(-0.3F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.Neck2 = new MowzieModelRenderer(this, 0, 48);
        this.Neck2.setRotationPoint(0.0F, 0.1F, -3.3F);
        this.Neck2.addBox(-1.0F, -1.0F, -4.0F, 2, 3, 4, 0.0F);
        this.setRotateAngle(Neck2, -0.3764675196551769F, -0.0F, 0.0F);
        this.Body = new MowzieModelRenderer(this, 0, 30);
        this.Body.setRotationPoint(0.0F, 16.1F, 0.9F);
        this.Body.addBox(-2.0F, -1.5F, 0.0F, 4, 4, 7, 0.0F);
        this.setRotateAngle(Body, -0.40893064374227134F, -0.0F, 0.0F);
        this.WingR1 = new MowzieModelRenderer(this, 0, 23);
        this.WingR1.setRotationPoint(-2.200000047683716F, 16.600000381469727F, 3.700000047683716F);
        this.WingR1.addBox(-9.5F, -0.5F, -3.0F, 10, 1, 6, 0.0F);
        this.setRotateAngle(WingR1, 0.0F, -0.33161255717277527F, -1.0471975803375244F);
        this.WingL1 = new MowzieModelRenderer(this, 32, 23);
        this.WingL1.setRotationPoint(2.2F, 16.6F, 3.7F);
        this.WingL1.addBox(-0.5F, -0.5F, -3.0F, 10, 1, 6, 0.0F);
        this.setRotateAngle(WingL1, -0.0F, 0.33161255787892263F, 1.0471975511965976F);
        this.Leg2 = new MowzieModelRenderer(this, 20, 45);
        this.Leg2.setRotationPoint(1.5F, 21.0F, 6.5F);
        this.Leg2.addBox(-0.7F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.Head = new MowzieModelRenderer(this, 0, 55);
        this.Head.setRotationPoint(0.0F, -0.6F, -3.4F);
        this.Head.addBox(-2.0F, -3.0F, -5.0F, 4, 4, 5, 0.0F);
        this.setRotateAngle(Head, 1.1383037381507017F, 0.0F, 0.0F);
        this.Beak2 = new MowzieModelRenderer(this, 18, 54);
        this.Beak2.setRotationPoint(0.0F, -2.3F, -5.8F);
        this.Beak2.addBox(-0.99F, 0.0F, -7.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(Beak2, 0.05462880558742251F, -0.0F, 0.0F);
        this.Jaw = new MowzieModelRenderer(this, 38, 55);
        this.Jaw.setRotationPoint(0.0F, 0.5F, -4.8F);
        this.Jaw.addBox(-1.0F, -1.0F, -7.6F, 2, 1, 8, 0.0F);
        this.setRotateAngle(Jaw, 0.0022689280275926286F, -0.0F, 0.0F);
        this.Neck1 = new MowzieModelRenderer(this, 0, 41);
        this.Neck1.setRotationPoint(0.0F, 0.1F, 1.0F);
        this.Neck1.addBox(-1.5F, -1.0F, -4.0F, 3, 3, 4, 0.0F);
        this.setRotateAngle(Neck1, -0.11152653920243764F, 0.0F, 0.0F);
        this.WingL1Child = new MowzieModelRenderer(this, 58, 32);
        this.WingL1Child.setRotationPoint(9.5F, 0.10000000149011612F, -2.5F);
        this.WingL1Child.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(WingL1Child, 0.33161255717277527F, -0.04555309191346169F, -1.0283479690551758F);
        this.Fibre1 = new MowzieModelRenderer(this, 34, 34);
        this.Fibre1.setRotationPoint(0.0F, -0.1F, -0.5F);
        this.Fibre1.addBox(0.0F, -1.9F, -0.3F, 0, 1, 2, 0.0F);
        this.setRotateAngle(Fibre1, 0.7285004297824331F, -0.0F, 0.0F);
        this.CrestBase = new MowzieModelRenderer(this, 31, 52);
        this.CrestBase.setRotationPoint(0.0F, -1.9F, -2.5F);
        this.CrestBase.addBox(-1.0F, -1.2F, -4.5F, 2, 3, 5, 0.0F);
        this.setRotateAngle(CrestBase, 2.777342438698576F, -0.0F, -3.141592653589793F);
        this.WingR1Child = new MowzieModelRenderer(this, 58, 32);
        this.WingR1Child.setRotationPoint(-9.5F, 0.10000000149011612F, -2.5F);
        this.WingR1Child.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(WingR1Child, 0.33161255717277527F, 0.04555309191346169F, 1.0283479690551758F);
        this.Crest = new MowzieModelRenderer(this, 31, 44);
        this.Crest.setRotationPoint(0.0F, -0.6F, -2.5F);
        this.Crest.addBox(-1.0F, 0.2F, -5.8F, 2, 2, 5, 0.0F);
        this.setRotateAngle(Crest, -0.27314402793711257F, 0.0F, 0.0F);
        this.FibreL = new MowzieModelRenderer(this, 34, 34);
        this.FibreL.setRotationPoint(1.0F, -0.1F, 0.0F);
        this.FibreL.addBox(0.0F, -1.0F, 1.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(FibreL, 0.37175513067479216F, -0.0F, 0.0F);
        this.Beak1 = new MowzieModelRenderer(this, 18, 54);
        this.Beak1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Beak1.addBox(-1.01F, 0.0F, -7.0F, 2, 2, 8, 0.0F);
        this.WingL1Child_1 = new MowzieModelRenderer(this, 31, 18);
        this.WingL1Child_1.setRotationPoint(8.800000190734863F, 0.0F, 2.5999999046325684F);
        this.WingL1Child_1.addBox(-0.30000001192092896F, -0.4000000059604645F, -0.699999988079071F, 11, 1, 4, 0.0F);
        this.setRotateAngle(WingL1Child_1, 0.0F, -2.458645343780518F, 0.0F);
        this.WingR1Child_1 = new MowzieModelRenderer(this, 0, 18);
        this.WingR1Child_1.setRotationPoint(-8.8F, 0.0F, 2.6F);
        this.WingR1Child_1.addBox(-10.7F, -0.4F, -0.7F, 11, 1, 4, 0.0F);
        this.setRotateAngle(WingR1Child_1, 0.0F, 2.4586453172844123F, 0.0F);
        this.Tail = new MowzieModelRenderer(this, 22, 32);
        this.Tail.setRotationPoint(0.0F, 0.4F, 6.6F);
        this.Tail.addBox(-2.0F, -1.27F, 0.0F, 4, 3, 2, 0.0F);
        this.setRotateAngle(Tail, -0.29740410453983374F, -0.0F, 0.0F);
        this.Fibre2 = new MowzieModelRenderer(this, 34, 34);
        this.Fibre2.setRotationPoint(0.0F, -0.5F, 3.0F);
        this.Fibre2.addBox(0.0F, -1.0F, 1.0F, 0, 1, 2, 0.0F);
        this.setRotateAngle(Fibre2, 0.37175513067479216F, -0.0F, 0.0F);
        this.Body.addChild(this.FibreR);
        this.Neck1.addChild(this.Neck2);
        this.Neck2.addChild(this.Head);
        this.Head.addChild(this.Beak2);
        this.Head.addChild(this.Jaw);
        this.Body.addChild(this.Neck1);
        this.WingL1.addChild(this.WingL1Child);
        this.Neck1.addChild(this.Fibre1);
        this.Head.addChild(this.CrestBase);
        this.WingR1.addChild(this.WingR1Child);
        this.CrestBase.addChild(this.Crest);
        this.Body.addChild(this.FibreL);
        this.Beak2.addChild(this.Beak1);
        this.WingL1.addChild(this.WingL1Child_1);
        this.WingR1.addChild(this.WingR1Child_1);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.Fibre2);
    }

    @Override
    public void renderFossil(NewPrehistoricEntity entity, float f, float f1,
                             float f2, float f3, float f4, float f5) {

    }

    @Override
    public void renderLiving(NewPrehistoricEntity entity, float f, float f1,
                             float f2, float f3, float f4, float f5) {
        if (entity.isFlying) {

        } else {

        }
    }

    @Override
    public void renderSleeping(NewPrehistoricEntity entity, float f, float f1,
                               float f2, float f3, float f4, float f5) {

    }

}
