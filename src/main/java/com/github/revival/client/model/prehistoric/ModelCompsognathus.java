package com.github.revival.client.model.prehistoric;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.llibrary.common.animation.Animator;
import net.ilexiconn.llibrary.common.animation.IAnimated;
import net.minecraft.entity.Entity;

import com.github.revival.client.model.prehistoric.test.ModelNewPrehistoric;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;


public class ModelCompsognathus extends ModelNewPrehistoric {

    public MowzieModelRenderer body;
    public MowzieModelRenderer LeftUpperLeg;
    public MowzieModelRenderer RightUpperLeg;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer tail1;
    public MowzieModelRenderer RightUpperArm;
    public MowzieModelRenderer LeftUpperArm;
    public MowzieModelRenderer head;
    public MowzieModelRenderer headPivot;
    public MowzieModelRenderer headFront;
    public MowzieModelRenderer crest;
    public MowzieModelRenderer headFront_1;
    public MowzieModelRenderer EyeR;
    public MowzieModelRenderer EyeL;
    public MowzieModelRenderer tail2;
    public MowzieModelRenderer RightLowerArm;
    public MowzieModelRenderer RightUpperArmWing;
    public MowzieModelRenderer LeftLowerArm;
    public MowzieModelRenderer LeftUpperArmWing;
    public MowzieModelRenderer LeftLowerLeg;
    public MowzieModelRenderer LeftFoot;
    public MowzieModelRenderer RightLowerLeg;
    public MowzieModelRenderer RightFoot;
	private Animator animator;

    public ModelCompsognathus() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.LeftFoot = new MowzieModelRenderer(this, 38, 0);
        this.LeftFoot.mirror = true;
        this.LeftFoot.setRotationPoint(0.5F, 4.7F, 0.7F);
        this.LeftFoot.addBox(-1.5F, 0.0F, -2.4F, 3, 0, 3, 0.0F);
       ModelUtils.setRotateAngle(LeftFoot, 0.22689280275926282F, 0.0F, 0.0F);
        this.LeftUpperLeg = new MowzieModelRenderer(this, 38, 8);
        this.LeftUpperLeg.mirror = true;
        this.LeftUpperLeg.setRotationPoint(2.0F, 15.2F, 4.0F);
        this.LeftUpperLeg.addBox(0.0F, 0.0F, -1.0F, 1, 5, 2, 0.0F);
        this.RightUpperLeg = new MowzieModelRenderer(this, 38, 8);
        this.RightUpperLeg.mirror = true;
        this.RightUpperLeg.setRotationPoint(-2.0F, 15.2F, 4.0F);
        this.RightUpperLeg.addBox(-1.0F, 0.0F, -1.0F, 1, 5, 2, 0.0F);
        this.LeftLowerLeg = new MowzieModelRenderer(this, 47, 2);
        this.LeftLowerLeg.mirror = true;
        this.LeftLowerLeg.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.LeftLowerLeg.addBox(-0.01F, -0.2F, 0.3F, 1, 5, 1, 0.0F);
       ModelUtils.setRotateAngle(LeftLowerLeg, -0.22689280275926282F, 0.0F, 0.0F);
        this.RightUpperArm = new MowzieModelRenderer(this, 0, 0);
        this.RightUpperArm.setRotationPoint(-2.0F, -1.5F, -1.5F);
        this.RightUpperArm.addBox(-1.01F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
       ModelUtils.setRotateAngle(RightUpperArm, -0.17453292519943295F, 0.0F, 0.0F);
        this.EyeL = new MowzieModelRenderer(this, 16, 14);
        this.EyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.EyeL.addBox(1.51F, -2.3F, -4.3F, 0, 3, 4, 0.0F);
        this.head = new MowzieModelRenderer(this, 16, 2);
        this.head.setRotationPoint(0F, 0F, 0F);
        this.head.addBox(-1.5F, -2.3F, -4.3F, 3, 3, 4, 0.0F);
       ModelUtils.setRotateAngle(head, 0F, 0.0F, 0.0F);
       this.headPivot = new MowzieModelRenderer(this, 0, 0);
       this.headPivot.setRotationPoint(0.0F, -2.4F, 0.2F);
       this.headPivot.addBox(0F, 0F, 0F, 0, 0, 0, 0F);
      ModelUtils.setRotateAngle(headPivot, -0.6829473363053812F, 0.0F, 0.0F);
        this.neck = new MowzieModelRenderer(this, 4, 4);
        this.neck.mirror = true;
        this.neck.setRotationPoint(0.0F, -2.3F, -2.3F);
        this.neck.addBox(-1.0F, -4.0F, -1.5F, 2, 5, 3, 0.0F);
       ModelUtils.setRotateAngle(neck, 0.7853981633974483F, 0.0F, 0.0F);
        this.RightLowerLeg = new MowzieModelRenderer(this, 47, 2);
        this.RightLowerLeg.mirror = true;
        this.RightLowerLeg.setRotationPoint(-0.5F, 4.0F, 0.0F);
        this.RightLowerLeg.addBox(-0.49F, -0.2F, 0.3F, 1, 5, 1, 0.0F);
       ModelUtils.setRotateAngle(RightLowerLeg, -0.22689280275926282F, 0.0F, 0.0F);
        this.headFront_1 = new MowzieModelRenderer(this, 20, 10);
        this.headFront_1.setRotationPoint(0.0F, 0.6F, -2.0F);
        this.headFront_1.addBox(-1.0F, -0.6F, -4.4F, 2, 1, 5, 0.0F);
        this.LeftUpperArm = new MowzieModelRenderer(this, 0, 0);
        this.LeftUpperArm.setRotationPoint(2.0F, -1.5F, -1.5F);
        this.LeftUpperArm.addBox(0.01F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
       ModelUtils.setRotateAngle(LeftUpperArm, -0.17453292519943295F, 0.0F, 0.0F);
        this.RightFoot = new MowzieModelRenderer(this, 38, 0);
        this.RightFoot.mirror = true;
        this.RightFoot.setRotationPoint(0.0F, 4.7F, 0.7F);
        this.RightFoot.addBox(-1.5F, 0.0F, -2.4F, 3, 0, 3, 0.0F);
       ModelUtils.setRotateAngle(RightFoot, 0.22689280275926282F, 0.0F, 0.0F);
        this.headFront = new MowzieModelRenderer(this, 28, 0);
        this.headFront.setRotationPoint(0.0F, -0.7F, -5.1F);
        this.headFront.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
        this.EyeR = new MowzieModelRenderer(this, 16, 14);
        this.EyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.EyeR.addBox(-1.51F, -2.3F, -4.3F, 0, 3, 4, 0.0F);
        this.LeftLowerArm = new MowzieModelRenderer(this, 4, 0);
        this.LeftLowerArm.mirror = true;
        this.LeftLowerArm.setRotationPoint(0.0F, 1.9F, 0.0F);
        this.LeftLowerArm.addBox(-0.01F, -0.6F, -0.6F, 1, 3, 1, 0.0F);
       ModelUtils.setRotateAngle(LeftLowerArm, -0.22689280275926282F, 0.0F, 0.0F);
        this.body = new MowzieModelRenderer(this, 0, 18);
        this.body.mirror = true;
        this.body.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.body.addBox(-2.0F, -4.0F, -3.0F, 4, 5, 8, 0.0F);
        this.tail2 = new MowzieModelRenderer(this, 26, 20);
        this.tail2.mirror = true;
        this.tail2.setRotationPoint(0.0F, 0.8F, 3.9F);
        this.tail2.addBox(-1.0F, -0.6F, 0.0F, 2, 2, 10, 0.0F);
        this.RightLowerArm = new MowzieModelRenderer(this, 4, 0);
        this.RightLowerArm.mirror = true;
        this.RightLowerArm.setRotationPoint(-1.1F, 1.9F, 0.0F);
        this.RightLowerArm.addBox(0.19F, -0.6F, -0.6F, 1, 3, 1, 0.0F);
       ModelUtils.setRotateAngle(RightLowerArm, -0.22689280275926282F, 0.0F, 0.0F);
        this.tail1 = new MowzieModelRenderer(this, 4, 22);
        this.tail1.mirror = true;
        this.tail1.setRotationPoint(0.0F, -4.0F, 4.1F);
        this.tail1.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 5, 0.0F);
       ModelUtils.setRotateAngle(tail1, -0.045553093477052F, 0.0F, 0.0F);
        this.RightUpperArmWing = new MowzieModelRenderer(this, 0, 11);
        this.RightUpperArmWing.mirror = true;
        this.RightUpperArmWing.setRotationPoint(0.5F, 0.2F, -0.5F);
        this.RightUpperArmWing.addBox(-0.4F, -2.1F, 0.3F, 1, 4, 2, 0.0F);
        this.LeftUpperArmWing = new MowzieModelRenderer(this, 0, 11);
        this.LeftUpperArmWing.mirror = true;
        this.LeftUpperArmWing.setRotationPoint(0.5F, 0.2F, -0.5F);
        this.LeftUpperArmWing.addBox(-0.4F, -2.1F, 0.3F, 1, 4, 2, 0.0F);
        this.crest = new MowzieModelRenderer(this, 9, 12);
        this.crest.setRotationPoint(0.0F, -0.6F, -2.4F);
        this.crest.addBox(0.0F, -1.0F, 2.0F, 1, 2, 3, 0.0F);
       ModelUtils.setRotateAngle(crest, 0.31869712141416456F, 0.0F, 0.0F);
        this.LeftLowerLeg.addChild(this.LeftFoot);
        this.LeftUpperLeg.addChild(this.LeftLowerLeg);
        this.body.addChild(this.RightUpperArm);
        this.head.addChild(this.EyeL);
        this.headPivot.addChild(this.head);
        this.neck.addChild(this.headPivot);
        this.body.addChild(this.neck);
        this.RightUpperLeg.addChild(this.RightLowerLeg);
        this.head.addChild(this.headFront_1);
        this.body.addChild(this.LeftUpperArm);
        this.RightLowerLeg.addChild(this.RightFoot);
        this.head.addChild(this.headFront);
        this.head.addChild(this.EyeR);
        this.LeftUpperArm.addChild(this.LeftLowerArm);
        this.tail1.addChild(this.tail2);
        this.RightUpperArm.addChild(this.RightLowerArm);
        this.body.addChild(this.tail1);
        this.RightLowerArm.addChild(this.RightUpperArmWing);
        this.LeftLowerArm.addChild(this.LeftUpperArmWing);
        this.head.addChild(this.crest);
        ModelUtils.doMowzieStuff(false, boxList);
        animator = new Animator(this);
    }
    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		animate((IAnimated)entity, f, f1, f2, f3, f4, f5);
		ModelUtils.renderAll(boxList);
	}

	public void animate(IAnimated entity, float f, float f1, float f2, float f3, float f4, float f5) {
		animator.update(entity);
		ModelUtils.doMowzieStuff(true, boxList);
		setRotationAngles(f, f1, f2, f3, f4, f5, (Entity)entity);
		
		animator.setAnimationId(EntityNewPrehistoric.animation_sit.animationId);
		animator.startPhase(20);
		sitPose(true);
		animator.endPhase();
		
		animator.setAnimationId(EntityNewPrehistoric.animation_getUp.animationId);
		animator.startPhase(0);
		sitPose(true);
		animator.endPhase();
		animator.resetPhase(20);
		animator.endPhase();

	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		MowzieModelRenderer[] tailParts = {this.tail1, this.tail2};
		MowzieModelRenderer[] neckParts = {this.neck, this.head};
		MowzieModelRenderer[] leftArmParts = {this.LeftUpperArm, this.LeftLowerArm};
		MowzieModelRenderer[] rightArmParts = {this.RightUpperArm, this.RightLowerArm};
        ModelUtils.doMowzieStuff(true, boxList);

		this.faceTarget(head, 1, f3, f4);

		float speed = 0.1F;
		float speed2 = 1.5F;
		if(((IAnimated)entity).getAnimation().animationId == 0)
			carryOutPoses(entity);
		this.bob(body, speed, 0.7F, false, entity.ticksExisted, 1);
		this.walk(LeftUpperLeg, speed2, 0.8F, false, 0F, 0.4F, f, f1);
		this.walk(LeftLowerLeg, speed2, 0.2F, false, 0F, -0.6F, f, f1);
		this.walk(LeftFoot, speed2, -0.4F, false, 4.5F, 0.4F, f, f1);
		this.walk(RightUpperLeg, speed2, 0.8F, true, 0F, 0.4F, f, f1);
		this.walk(RightLowerLeg, speed2, 0.2F, true, 0F, -0.6F, f, f1);
		this.walk(RightFoot, speed2, -0.4F, true, 4.5F, 0.4F, f, f1);
		this.chainWave(tailParts, speed, 0.05F, -3, entity.ticksExisted, 1);
		this.chainWave(leftArmParts, speed, 0.15F, -3, entity.ticksExisted, 1);
		this.chainWave(rightArmParts, speed, 0.15F, -3, entity.ticksExisted, 1);
		this.chainSwing(tailParts, speed, 0.15F, -3, entity.ticksExisted, 1);
		this.chainSwing(tailParts, speed2, 0.25F, -3, f, f1);
		this.chainWave(neckParts, speed, 0.15F, 3, entity.ticksExisted, 1);
	}
	@Override
	public void sleepPose(boolean animate) {}
	@Override
	public void sitPose(boolean animate) {
		ModelUtils.animateOrSetRotation(animator, animate, neck, 0.18203784098300857F, 0.0F, 0.0F, false);
        ModelUtils.animateOrSetRotation(animator, animate, RightLowerLeg, 2.0943951023931953F, 0.0F, 0.0F, false);
        ModelUtils.animateOrSetRotation(animator, animate, tail2, 0.091106186954104F, 0.0F, 0.0F, false);
        ModelUtils.animateOrSetRotation(animator, animate, crest, 0.31869712141416456F, 0.0F, 0.0F, false);
        ModelUtils.animateOrSetRotation(animator, animate, RightLowerArm, -0.22689280275926282F, 0.0F, 0.0F, false);
        ModelUtils.animateOrSetRotation(animator, animate, LeftLowerLeg, 2.0943951023931953F, 0.0F, 0.0F, false);
        ModelUtils.animateOrSetRotation(animator, animate, tail1, -0.18203784098300857F, 0.0F, 0.0F, false);
        ModelUtils.animateOrSetRotation(animator, animate, LeftLowerArm, -0.22689280275926282F, 0.0F, 0.0F, false);
        ModelUtils.animateOrSetRotation(animator, animate, LeftFoot, -0.7853981633974483F, 0.0F, 0.0F, false);
        ModelUtils.animateOrSetRotation(animator, animate, RightUpperLeg, -1.0471975511965976F, 0.0F, 0.0F, false);
        ModelUtils.animateOrSetRotation(animator, animate, RightUpperArm, -0.17453292519943295F, 0.0F, 0.7740535232594852F, false);
        ModelUtils.animateOrSetRotation(animator, animate, LeftUpperArm, -0.17453292519943295F, 0.0F, -0.6373942428283291F, false);
        ModelUtils.animateOrSetRotation(animator, animate, LeftUpperLeg, -1.0471975511965976F, 0.0F, 0.0F, false);
        ModelUtils.animateOrSetRotation(animator, animate, RightFoot, -0.7853981633974483F, 0.0F, 0.0F, false);
    	ModelUtils.animateToPos(animator, animate, body, 0F, 22.7F - body.initRotationPointY, 0F, true);
		ModelUtils.animateToPos(animator, animate, RightUpperLeg, 0F, 19.7F - RightUpperLeg.initRotationPointY, 0F, true);
		ModelUtils.animateToPos(animator, animate, LeftUpperLeg, 0F, 19.7F - LeftUpperLeg.initRotationPointY, 0F, true);
		ModelUtils.setPos(animator, animate, body, 0F, 22.7F, -3F, false);
		ModelUtils.setPos(animator, animate, RightUpperLeg, -2F, 19.7F, 4F, false);
		ModelUtils.setPos(animator, animate, LeftUpperLeg, 2F, 19.7F, 4F, false);
	}


}
