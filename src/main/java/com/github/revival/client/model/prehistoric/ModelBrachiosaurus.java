package com.github.revival.client.model.prehistoric;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.llibrary.common.animation.Animator;
import net.ilexiconn.llibrary.common.animation.IAnimated;
import net.minecraft.entity.Entity;

import com.github.revival.client.model.prehistoric.test.ModelNewPrehistoric;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public class ModelBrachiosaurus extends ModelNewPrehistoric
{
	public MowzieModelRenderer BackThighRight;
    public MowzieModelRenderer BackThighLeft;
    public MowzieModelRenderer FrontThighRight;
    public MowzieModelRenderer FrontThighLeft;
    public MowzieModelRenderer LowerBody;
    public MowzieModelRenderer BackLegRight;
    public MowzieModelRenderer BackLegLeft;
    public MowzieModelRenderer FrontLegRight;
    public MowzieModelRenderer FrontLegLeft;
    public MowzieModelRenderer MidBody;
    public MowzieModelRenderer Tail;
    public MowzieModelRenderer UpperBody;
    public MowzieModelRenderer Neck1;
    public MowzieModelRenderer Neck2;
    public MowzieModelRenderer Neck3;
    public MowzieModelRenderer Neck4;
    public MowzieModelRenderer Neck5;
    public MowzieModelRenderer headpivot;
    public MowzieModelRenderer Head;
    public MowzieModelRenderer TopJaw;
    public MowzieModelRenderer Crest;
    public MowzieModelRenderer JawBottom;
    public MowzieModelRenderer Tail2;
    public MowzieModelRenderer Tail3;
	private Animator animator;

    public ModelBrachiosaurus() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.BackThighRight = new MowzieModelRenderer(this, 50, 21);
        this.BackThighRight.mirror = true;
        this.BackThighRight.setRotationPoint(3.0F, 14.1F, 7.0F);
        this.BackThighRight.addBox(-1.0F, -1.5F, -2.0F, 3, 7, 4, 0.0F);
        this.BackThighLeft = new MowzieModelRenderer(this, 50, 21);
        this.BackThighLeft.setRotationPoint(-3.0F, 14.1F, 7.0F);
        this.BackThighLeft.addBox(-2.0F, -1.5F, -2.0F, 3, 7, 4, 0.0F);
        this.headpivot = new MowzieModelRenderer(this, 0, 0);
        this.headpivot.setRotationPoint(0.0F, -0.6F, -2.6F);
        this.setRotateAngle(headpivot, 1.0927506446736497F, 0.0F, 0.0F);
        this.Head = new MowzieModelRenderer(this, 66, 0);
        this.Head.addBox(-2.0F, -1.0F, -3.7F, 4, 3, 4, 0.0F);
        this.FrontLegRight = new MowzieModelRenderer(this, 0, 24);
        this.FrontLegRight.mirror = true;
        this.FrontLegRight.setRotationPoint(1.5F, 5.0F, 0.5F);
        this.FrontLegRight.addBox(-1.0F, 0.0F, -1.5F, 2, 5, 3, 0.0F);
        this.JawBottom = new MowzieModelRenderer(this, 55, 10);
        this.JawBottom.setRotationPoint(0.0F, 0.9F, -2.9F);
        this.JawBottom.addBox(-1.0F, 0.0F, -3.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(JawBottom, -0.22759093446006054F, -0.0F, 0.0F);
        this.Neck2 = new MowzieModelRenderer(this, 0, 45);
        this.Neck2.setRotationPoint(0.0F, -1.4F, -2.9F);
        this.Neck2.addBox(-2.0F, -1.5F, -3.2F, 4, 5, 4, 0.0F);
        this.setRotateAngle(Neck2, -0.091106186954104F, -0.0F, 0.0F);
        this.Tail3 = new MowzieModelRenderer(this, 34, 10);
        this.Tail3.setRotationPoint(0.0F, 0.9F, 4.3F);
        this.Tail3.addBox(-1.0F, -1.5F, 0.0F, 2, 3, 6, 0.0F);
        this.setRotateAngle(Tail3, 0.04293509959906051F, 0.0F, 0.0F);
        this.BackLegRight = new MowzieModelRenderer(this, 0, 24);
        this.BackLegRight.mirror = true;
        this.BackLegRight.setRotationPoint(0.5F, 5.0F, 0.0F);
        this.BackLegRight.addBox(-1.0F, 0.0F, -1.5F, 2, 5, 3, 0.0F);
        this.Neck1 = new MowzieModelRenderer(this, 0, 33);
        this.Neck1.setRotationPoint(0.0F, -1.1F, -5.8F);
        this.Neck1.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 5, 0.0F);
        this.setRotateAngle(Neck1, -0.27314402793711257F, -0.0F, 0.0F);
        this.Tail = new MowzieModelRenderer(this, 0, 13);
        this.Tail.setRotationPoint(0.0F, -2.5F, 4.3F);
        this.Tail.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 5, 0.0F);
        this.setRotateAngle(Tail, -0.136659280431156F, 0.045553093477052F, 0.0F);
        this.Crest = new MowzieModelRenderer(this, 52, 0);
        this.Crest.setRotationPoint(0.0F, 0.9F, -2.8F);
        this.Crest.addBox(-1.0F, -3.7F, -2.6F, 2, 4, 4, 0.0F);
        this.setRotateAngle(Crest, -0.5918411493512771F, 0.0F, 0.0F);
        this.MidBody = new MowzieModelRenderer(this, 44, 34);
        this.MidBody.setRotationPoint(0.0F, -0.7F, 0.9F);
        this.MidBody.addBox(-3.5F, -4.5F, -3.9F, 7, 9, 4, 0.0F);
        this.BackLegLeft = new MowzieModelRenderer(this, 0, 24);
        this.BackLegLeft.setRotationPoint(-0.5F, 5.0F, 0.0F);
        this.BackLegLeft.addBox(-1.0F, 0.0F, -1.5F, 2, 5, 3, 0.0F);
        this.Neck5 = new MowzieModelRenderer(this, 23, 33);
        this.Neck5.setRotationPoint(0.0F, -0.05F, -6.4F);
        this.Neck5.addBox(-1.0F, -1.5F, -3.0F, 2, 3, 3, 0.0F);
        this.setRotateAngle(Neck5, 0.23806290997202653F, -0.0F, 0.0F);
        this.LowerBody = new MowzieModelRenderer(this, 73, 48);
        this.LowerBody.setRotationPoint(0.0F, 14.6F, 3.4F);
        this.LowerBody.addBox(-3.0F, -5.0F, 0.0F, 6, 8, 5, 0.0F);
        this.setRotateAngle(LowerBody, -0.31869712141416456F, -0.0F, 0.0F);
        this.TopJaw = new MowzieModelRenderer(this, 67, 8);
        this.TopJaw.setRotationPoint(0.0F, 0.0F, -2.7F);
        this.TopJaw.addBox(-1.5F, -1.0F, -3.3F, 3, 2, 4, 0.0F);
        this.setRotateAngle(TopJaw, -0.136659280431156F, -0.0F, 0.0F);
        this.FrontThighRight = new MowzieModelRenderer(this, 50, 21);
        this.FrontThighRight.mirror = true;
        this.FrontThighRight.setRotationPoint(2.5F, 14.0F, -3.0F);
        this.FrontThighRight.addBox(0.0F, -2.0F, -1.5F, 3, 7, 4, 0.0F);
        this.Neck4 = new MowzieModelRenderer(this, 18, 41);
        this.Neck4.setRotationPoint(0.0F, -0.4F, -6.6F);
        this.Neck4.addBox(-1.5F, -1.5F, -7.0F, 3, 3, 7, 0.0F);
        this.setRotateAngle(Neck4, -0.07365289443416069F, -0.0F, 0.0F);
        this.UpperBody = new MowzieModelRenderer(this, 44, 48);
        this.UpperBody.setRotationPoint(0.0F, 0.0F, -3.6F);
        this.UpperBody.addBox(-4.0F, -4.5F, -6.0F, 8, 9, 6, 0.0F);
        this.setRotateAngle(UpperBody, -0.045553093477052F, -0.0F, 0.0F);
        this.Neck3 = new MowzieModelRenderer(this, 17, 53);
        this.Neck3.setRotationPoint(0.0F, 0.9F, -3.1F);
        this.Neck3.addBox(-2.0F, -2.0F, -7.0F, 4, 4, 7, 0.0F);
        this.setRotateAngle(Neck3, -0.06981317007977318F, -0.0F, 0.0F);
        this.FrontThighLeft = new MowzieModelRenderer(this, 50, 21);
        this.FrontThighLeft.setRotationPoint(-2.5F, 14.0F, -3.0F);
        this.FrontThighLeft.addBox(-3.0F, -2.0F, -1.5F, 3, 7, 4, 0.0F);
        this.FrontLegLeft = new MowzieModelRenderer(this, 0, 24);
        this.FrontLegLeft.setRotationPoint(-1.5F, 5.0F, 0.5F);
        this.FrontLegLeft.addBox(-1.0F, 0.0F, -1.5F, 2, 5, 3, 0.0F);
        this.Tail2 = new MowzieModelRenderer(this, 17, 1);
        this.Tail2.setRotationPoint(0.0F, -1.3F, 4.4F);
        this.Tail2.addBox(-1.5F, -1.0F, 0.0F, 3, 4, 5, 0.0F);
        this.setRotateAngle(Tail2, 0.18203784098300857F, 0.05044001538263612F, 0.0F);
        this.Neck5.addChild(this.headpivot);
        this.headpivot.addChild(this.Head);
        this.FrontThighRight.addChild(this.FrontLegRight);
        this.Head.addChild(this.JawBottom);
        this.Neck1.addChild(this.Neck2);
        this.Tail2.addChild(this.Tail3);
        this.BackThighRight.addChild(this.BackLegRight);
        this.UpperBody.addChild(this.Neck1);
        this.LowerBody.addChild(this.Tail);
        this.Head.addChild(this.Crest);
        this.LowerBody.addChild(this.MidBody);
        this.BackThighLeft.addChild(this.BackLegLeft);
        this.Neck4.addChild(this.Neck5);
        this.Head.addChild(this.TopJaw);
        this.Neck3.addChild(this.Neck4);
        this.MidBody.addChild(this.UpperBody);
        this.Neck2.addChild(this.Neck3);
        this.FrontThighLeft.addChild(this.FrontLegLeft);
        this.Tail.addChild(this.Tail2);
        this.setInitPose();
		animator = new Animator(this);
    }
    
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
		animate((IAnimated)entity, f, f1, f2, f3, f4, f5);
        this.BackThighRight.render(f5);
        this.BackThighLeft.render(f5);
        this.LowerBody.render(f5);
        this.FrontThighRight.render(f5);
        this.FrontThighLeft.render(f5);
    }

    public void animate(IAnimated entity, float f, float f1, float f2, float f3, float f4, float f5) {
		animator.update(entity);
		this.setToInitPose();
		setRotationAngles(f, f1, f2, f3, f4, f5, (Entity)entity);
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		MowzieModelRenderer[] tailParts = {this.Tail, this.Tail2, this.Tail3};
		MowzieModelRenderer[] neckParts = {this.Neck1, this.Neck2, this.Neck3, this.Neck4, this.Neck5, this.Head};
		this.faceTarget(Head, 1, f3, f4);
		float speed = 0.1F;
		float speed2 = 0.6F;
		float sitProgress = ((EntityNewPrehistoric)(entity)).sitProgress;
		this.chainWave(tailParts, speed, 0.05F, -3, entity.ticksExisted, 1);
		this.chainSwing(tailParts, speed, 0.15F, -2, entity.ticksExisted, 1);
		this.chainWave(neckParts, speed, 0.05F, 3, entity.ticksExisted, 1);
		this.bob(LowerBody, speed, 0.7F, false, entity.ticksExisted, 1);
		this.walk(UpperBody, speed, 0.05F, true, 0F, 0F, entity.ticksExisted, 1);
		this.walk(MidBody, speed, 0.05F, true, 0F, 0F, entity.ticksExisted, 1);
		this.walk(FrontThighLeft, speed2, 0.8F, true, 0F, -0.4F, f, f1);
		this.walk(FrontThighRight, speed2, 0.8F, false, 0F, -0.4F, f, f1);
		this.walk(BackThighLeft, speed2, 0.8F, false, 0F, 0.4F, f, f1);
		this.walk(BackThighRight, speed2, 0.8F, true, 0F, 0.4F, f, f1);
		this.walk(FrontLegLeft, speed2, 0.6F, true, 0F, 0.4F, f, f1);
		this.walk(FrontLegRight, speed2, 0.6F, false, 0F, 0.4F, f, f1);
		this.walk(BackLegLeft, speed2, 0.6F, false, 0F, 0.4F, f, f1);
		this.walk(BackLegRight, speed2, 0.6F, true, 0F, 0.4F, f, f1);
		sitAnimationRotation(Neck3, sitProgress, -((float)Math.toRadians(2.0D)), 0, 0);
        sitAnimationRotation(BackLegLeft, sitProgress, (float)Math.toRadians(58.0D), 0, 0);
        sitAnimationRotation(Neck2, sitProgress, -((float)Math.toRadians(5.22D)), 0, 0);
        sitAnimationRotation(FrontLegRight, sitProgress, -((float)Math.toRadians(25.0D)), 0, 0);
        sitAnimationRotation(Tail2, sitProgress, (float)Math.toRadians(3D), 0, 0);
        sitAnimationRotation(FrontThighRight, sitProgress, -((float)Math.toRadians(66.0D)), 0, 0);
        sitAnimationRotation(BackThighLeft, sitProgress, (float)Math.toRadians(55.0D), 0, 0);
        sitAnimationRotation(BackLegRight, sitProgress, (float)Math.toRadians(58.0D), 0, 0);
        sitAnimationRotation(BackThighRight, sitProgress, (float)Math.toRadians(55.0D), 0, 0);
        sitAnimationRotation(Tail3, sitProgress, (float)Math.toRadians(2.46D), 0, 0);
        sitAnimationRotation(LowerBody, sitProgress, -((float)Math.toRadians(13.04D)), 0, 0);
        sitAnimationRotation(FrontThighLeft, sitProgress, -((float)Math.toRadians(66.0D)), 0, 0);
        sitAnimationRotation(Neck1, sitProgress, -((float)Math.toRadians(5.43D)), 0, 0);
        sitAnimationRotation(Neck5, sitProgress, (float)Math.toRadians(3.64D), 0, 0);
        sitAnimationRotation(headpivot, sitProgress, (float)Math.toRadians(20D), 0, 0);
        sitAnimationRotation(FrontLegLeft, sitProgress, -((float)Math.toRadians(25.0D)), 0, 0);
        sitAnimationRotation(MidBody, sitProgress, (float)Math.toRadians(5.22D), 0, 0);
        sitAnimationRotation(UpperBody, sitProgress, -((float)Math.toRadians(2.61D)), 0, 0);
        sitAnimationRotation(Tail, sitProgress, ((float)Math.toRadians(15.65D)), 0, 0);
        sitAnimationRotation(Neck4, sitProgress, -((float)Math.toRadians(4.22D)), 0, 0);
        sitAnimationPos(LowerBody, sitProgress, 0, 5.8F, 3.4F);
        sitAnimationPos(FrontThighLeft, sitProgress, 0F, 4F, 2F);
        sitAnimationPos(FrontThighRight, sitProgress, 0F, 4F, 2F);
        sitAnimationPos(BackThighLeft, sitProgress, 0F, 5.1F, 2F);
        sitAnimationPos(BackThighRight, sitProgress, 0F, 5.1F, 2F);

	}
	
   
}
