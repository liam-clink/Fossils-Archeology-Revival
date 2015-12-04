package com.github.revival.client.model.prehistoric;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.llibrary.common.animation.Animator;
import net.ilexiconn.llibrary.common.animation.IAnimated;
import net.minecraft.entity.Entity;

import com.github.revival.client.model.prehistoric.test.ModelNewPrehistoric;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public class ModelAllosaurus extends ModelNewPrehistoric {
    public MowzieModelRenderer rightUpperLeg;
    public MowzieModelRenderer leftUpperLeg;
    public MowzieModelRenderer lowerBody;
    public MowzieModelRenderer rightLowerLeg;
    public MowzieModelRenderer rightFoot;
    public MowzieModelRenderer leftLowerLeg;
    public MowzieModelRenderer leftFoot;
    public MowzieModelRenderer tail1;
    public MowzieModelRenderer upperBody;
    public MowzieModelRenderer tail2;
    public MowzieModelRenderer tail3;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer leftUpperArm;
    public MowzieModelRenderer rightUpperArm;
    public MowzieModelRenderer head;
    public MowzieModelRenderer headPivot;
    public MowzieModelRenderer rightCrest;
    public MowzieModelRenderer leftCrest;
    public MowzieModelRenderer lowerJaw;
    public MowzieModelRenderer upperJaw;
    public MowzieModelRenderer teeth;
    public MowzieModelRenderer rightLowerArm;
    public MowzieModelRenderer leftLowerArm;
	private Animator animator;

    public ModelAllosaurus() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.rightCrest = new MowzieModelRenderer(this, 100, 0);
        this.rightCrest.mirror = true;
        this.rightCrest.setRotationPoint(-1.5F, -3.0F, -2.0F);
        this.rightCrest.addBox(-0.5F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
        ModelUtils.setRotateAngle(rightCrest, -0.6981316804885863F, 0.0F, -0.3141592741012573F);
        this.teeth = new MowzieModelRenderer(this, 80, 10);
        this.teeth.mirror = true;
        this.teeth.setRotationPoint(0.0F, 4.5F, 0.0F);
        this.teeth.addBox(-1.5F, -0.5F, -5.0F, 3, 1, 5, 0.0F);
        this.tail3 = new MowzieModelRenderer(this, 19, 48);
        this.tail3.mirror = true;
        this.tail3.setRotationPoint(0.0F, -0.20000000298023224F, 9.0F);
        this.tail3.addBox(-1.0F, -1.5F, 0.0F, 2, 3, 10, 0.0F);
        this.neck = new MowzieModelRenderer(this, 100, 18);
        this.neck.mirror = true;
        this.neck.setRotationPoint(0.0F, 2.7F, -5.6F);
        this.neck.addBox(-1.5F, -2.5F, -8.0F, 3, 5, 8, 0.0F);
        ModelUtils.setRotateAngle(neck, -0.5585053606381855F, 0.0F, 0.0F);
        this.lowerBody = new MowzieModelRenderer(this, 96, 41);
        this.lowerBody.mirror = true;
        this.lowerBody.setRotationPoint(0.0F, 8.3F, 0.0F);
        this.lowerBody.addBox(-3.5F, 0.0F, 0.0F, 7, 8, 7, 0.0F);
        ModelUtils.setRotateAngle(lowerBody, -0.03490658503988659F, 0.0F, 0.0F);
        this.leftFoot = new MowzieModelRenderer(this, 50, 23);
        this.leftFoot.mirror = true;
        this.leftFoot.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.leftFoot.addBox(-1.5F, 0.0F, -3.0F, 3, 2, 4, 0.0F);
        ModelUtils.setRotateAngle(leftFoot, 0.3141592741012573F, 0.0F, 0.0F);
        this.upperBody = new MowzieModelRenderer(this, 75, 28);
        this.upperBody.mirror = true;
        this.upperBody.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.upperBody.addBox(-2.5F, 0.0F, -7.0F, 5, 7, 7, 0.0F);
        ModelUtils.setRotateAngle(upperBody, 0.05235987755982988F, 0.0F, 0.0F);
        this.leftUpperArm = new MowzieModelRenderer(this, 10, 9);
        this.leftUpperArm.mirror = true;
        this.leftUpperArm.setRotationPoint(2.5F, 2.5F, -5.5F);
        this.leftUpperArm.addBox(0.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        ModelUtils.setRotateAngle(leftUpperArm, 0.16110743555066584F, 0.0F, 0.0F);
        this.rightUpperLeg = new MowzieModelRenderer(this, 8, 26);
        this.rightUpperLeg.setRotationPoint(-3.0F, 12.3F, 5.5F);
        this.rightUpperLeg.addBox(-3.0F, 0.0F, -2.5F, 3, 6, 5, 0.0F);
        this.tail1 = new MowzieModelRenderer(this, 67, 46);
        this.tail1.mirror = true;
        this.tail1.setRotationPoint(0.0F, 3.2F, 6.0F);
        this.tail1.addBox(-2.5F, -3.0F, 0.0F, 5, 6, 6, 0.0F);
        this.leftCrest = new MowzieModelRenderer(this, 100, 0);
        this.leftCrest.mirror = true;
        this.leftCrest.setRotationPoint(1.5F, -3.0F, -2.0F);
        this.leftCrest.addBox(-0.5F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
        ModelUtils.setRotateAngle(leftCrest, -0.6981316804885863F, 0.0F, 0.3141592741012573F);
        this.head = new MowzieModelRenderer(this, 100, 6);
        this.head.mirror = true;
        this.head.setRotationPoint(0.0F, -0.0F, -0.0F);
        this.head.addBox(-2.0F, -3.0F, -4.0F, 4, 6, 4, 0.0F);
        ModelUtils.setRotateAngle(head, 0F, 0.0F, 0.0F);
        this.headPivot = new MowzieModelRenderer(this, 0, 0);
        this.headPivot.setRotationPoint(0.0F, -0.5F, -6.1F);
        ModelUtils.setRotateAngle(headPivot, 0.8377580409572781F, 0.0F, 0.0F);
        this.lowerJaw = new MowzieModelRenderer(this, 80, 17);
        this.lowerJaw.mirror = true;
        this.lowerJaw.setRotationPoint(0.0F, 2.0F, -3.2F);
        this.lowerJaw.addBox(-1.0F, -0.8F, -5.6F, 2, 2, 5, 0.0F);
        ModelUtils.setRotateAngle(lowerJaw, -0.06430079482153023F, 0.0F, 0.0F);
        this.leftLowerArm = new MowzieModelRenderer(this, 20, 8);
        this.leftLowerArm.mirror = true;
        this.leftLowerArm.setRotationPoint(-1.0F, 2.9F, -0.3F);
        this.leftLowerArm.addBox(-0.9F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        ModelUtils.setRotateAngle(leftLowerArm, -0.6981317007977318F, 0.0F, 0.0F);
        this.rightLowerLeg = new MowzieModelRenderer(this, 35, 26);
        this.rightLowerLeg.mirror = true;
        this.rightLowerLeg.setRotationPoint(-1.4F, 4.0F, 2.5F);
        this.rightLowerLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        ModelUtils.setRotateAngle(rightLowerLeg, -0.3141592653589793F, 0.0F, 0.0F);
        this.rightFoot = new MowzieModelRenderer(this, 50, 23);
        this.rightFoot.mirror = true;
        this.rightFoot.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.rightFoot.addBox(-1.5F, 0.0F, -3.0F, 3, 2, 4, 0.0F);
        ModelUtils.setRotateAngle(rightFoot, 0.3141592741012573F, 0.0F, 0.0F);
        this.rightUpperArm = new MowzieModelRenderer(this, 10, 9);
        this.rightUpperArm.mirror = true;
        this.rightUpperArm.setRotationPoint(-2.5F, 2.5F, -5.5F);
        this.rightUpperArm.addBox(-2.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        ModelUtils.setRotateAngle(rightUpperArm, 0.16109388995907664F, 0.0F, 0.0F);
        this.upperJaw = new MowzieModelRenderer(this, 80, 0);
        this.upperJaw.mirror = true;
        this.upperJaw.setRotationPoint(0.0F, -2.799999952316284F, -4.0F);
        this.upperJaw.addBox(-1.5F, 0.0F, -5.0F, 3, 4, 5, 0.0F);
        this.leftUpperLeg = new MowzieModelRenderer(this, 8, 26);
        this.leftUpperLeg.mirror = true;
        this.leftUpperLeg.setRotationPoint(3.0F, 12.3F, 5.5F);
        this.leftUpperLeg.addBox(0.0F, 0.0F, -2.5F, 3, 6, 5, 0.0F);
        this.leftLowerLeg = new MowzieModelRenderer(this, 35, 26);
        this.leftLowerLeg.mirror = true;
        this.leftLowerLeg.setRotationPoint(1.4F, 4.0F, 2.5F);
        this.leftLowerLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        ModelUtils.setRotateAngle(leftLowerLeg, -0.3141592653589793F, 0.0F, 0.0F);
        this.tail2 = new MowzieModelRenderer(this, 39, 42);
        this.tail2.mirror = true;
        this.tail2.setRotationPoint(0.0F, -0.8F, 6.0F);
        this.tail2.addBox(-1.5F, -2.0F, 0.0F, 3, 4, 9, 0.0F);
        ModelUtils.setRotateAngle(tail2, 0.017453292519943295F, 0.0F, 0.0F);
        this.rightLowerArm = new MowzieModelRenderer(this, 20, 8);
        this.rightLowerArm.setRotationPoint(1.0F, 2.9F, -0.3F);
        this.rightLowerArm.addBox(-1.1F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        ModelUtils.setRotateAngle(rightLowerArm, -0.6981317007977318F, 0.0F, 0.0F);
        this.head.addChild(this.rightCrest);
        this.upperJaw.addChild(this.teeth);
        this.tail2.addChild(this.tail3);
        this.upperBody.addChild(this.neck);
        this.leftLowerLeg.addChild(this.leftFoot);
        this.lowerBody.addChild(this.upperBody);
        this.upperBody.addChild(this.leftUpperArm);
        this.lowerBody.addChild(this.tail1);
        this.head.addChild(this.leftCrest);
        this.neck.addChild(this.headPivot);
        this.headPivot.addChild(this.head);
        this.head.addChild(this.lowerJaw);
        this.rightUpperArm.addChild(this.leftLowerArm);
        this.rightUpperLeg.addChild(this.rightLowerLeg);
        this.rightLowerLeg.addChild(this.rightFoot);
        this.upperBody.addChild(this.rightUpperArm);
        this.head.addChild(this.upperJaw);
        this.leftUpperLeg.addChild(this.leftLowerLeg);
        this.tail1.addChild(this.tail2);
        this.leftUpperArm.addChild(this.rightLowerArm);
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
		MowzieModelRenderer[] tailParts = {this.tail1, this.tail2, this.tail3};
		MowzieModelRenderer[] neckParts = {this.neck, this.head};
		MowzieModelRenderer[] leftArmParts = {this.leftUpperArm, this.leftLowerArm};
		MowzieModelRenderer[] rightArmParts = {this.rightUpperArm, this.rightLowerArm};

		faceTarget(neck, 1, f3, f4);
		
		float speed = 0.1F;
		float speed2 = 0.5F;
		if(((IAnimated)entity).getAnimation().animationId == 0)
			carryOutPoses(entity);
		this.walk(upperBody, speed, 0.05F, false, 1F, 0F, entity.ticksExisted, 1);
		this.bob(lowerBody, speed, 0.7F, false, entity.ticksExisted, 1);
		this.walk(leftUpperLeg, speed2, 0.8F, false, 0F, 0.4F, f, f1);
		this.walk(leftLowerLeg, speed2, 0.2F, false, 0F, -0.6F, f, f1);
		this.walk(leftFoot, speed2, -0.4F, false, 4.5F, 0.4F, f, f1);
		this.walk(rightUpperLeg, speed2, 0.8F, true, 0F, 0.4F, f, f1);
		this.walk(rightLowerLeg, speed2, 0.2F, true, 0F, -0.6F, f, f1);
		this.walk(rightFoot, speed2, -0.4F, true, 4.5F, 0.4F, f, f1);
		this.chainWave(tailParts, speed, 0.05F, -3, entity.ticksExisted, 1);
		this.chainWave(leftArmParts, speed, 0.15F, -3, entity.ticksExisted, 1);
		this.chainWave(rightArmParts, speed, 0.15F, -3, entity.ticksExisted, 1);
		this.chainSwing(tailParts, speed, 0.15F, -3, entity.ticksExisted, 1);
		this.chainSwing(tailParts, speed2, 0.25F, -3, f, f1);
		this.chainWave(neckParts, speed, 0.15F, 3, entity.ticksExisted, 1);
		//((ChainBuffer)((EntityAllosaurus)entity).tailbuffer).applyChainSwingBuffer(tailParts);

	}

	@Override
	public void sleepPose(boolean animate) {
		
        
	}

	@Override
	public void sitPose(boolean animate) {
		ModelUtils.animateOrSetRotation(animator, animate, leftUpperArm, 0.16109388995907664F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, neck, -0.7740535232594852F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, leftUpperLeg, -0.4886921905584123F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, leftLowerLeg, -1.0471975511965976F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, leftFoot, 1.5707963267948966F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, tail3, 0.136659280431156F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, head, 1.1838568316277536F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, lowerBody, -0.03490658503988659F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, lowerJaw, -0.06430079482153023F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, rightFoot, 1.5707963267948966F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, tail2, 0.091106186954104F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, leftLowerArm, -1.53588974175501F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, leftCrest, -0.6981316804885863F, 0.0F, 0.3141592741012573F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, rightUpperLeg, -0.4886921905584123F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, tail1, -0.31869712141416456F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, rightLowerArm, -1.53588974175501F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, rightUpperArm, 0.16109388995907664F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, rightCrest, -0.6981316804885863F, 0.0F, -0.3141592741012573F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, rightLowerLeg, -1.0471975511965976F, 0.0F, 0.0F, false);
    	ModelUtils.animateOrSetRotation(animator, animate, head, -0F, 0.0F, 0.0F, false);
		ModelUtils.animateToPos(animator, animate, lowerBody, 0F, 15.30F - lowerBody.initRotationPointY, 0F, true);
		ModelUtils.animateToPos(animator, animate, rightUpperLeg, 0F, 17.50F - rightUpperLeg.initRotationPointY, 0F, true);
		ModelUtils.animateToPos(animator, animate, leftUpperLeg, 0F, 17.50F - leftUpperLeg.initRotationPointY, 0F, true);
		ModelUtils.setPos(animator, animate, lowerBody, 0F, 15.30F, -3F, false);
		ModelUtils.setPos(animator, animate, rightUpperLeg, -3F, 17.50F, 5.5F, false);
		ModelUtils.setPos(animator, animate, leftUpperLeg, 3F, 17.50F, 5.5F, false);
	}
}
