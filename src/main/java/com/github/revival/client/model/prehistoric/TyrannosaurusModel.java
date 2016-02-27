package com.github.revival.client.model.prehistoric;

import com.github.revival.client.model.prehistoric.test.NewPrehistoricModel;
import com.github.revival.server.entity.mob.TyrannosaurusEntity;
import com.github.revival.server.entity.mob.test.NewPrehistoricEntity;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.llibrary.common.animation.Animator;
import net.ilexiconn.llibrary.common.animation.IAnimated;
import net.minecraft.entity.Entity;

public class TyrannosaurusModel extends NewPrehistoricModel {
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
    public MowzieModelRenderer headPivot;
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
    private Animator animator;

    public TyrannosaurusModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.middleCrest = new MowzieModelRenderer(this, 10, 53);
        this.middleCrest.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.middleCrest.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        ModelUtils.setRotateAngle(middleCrest, 0.16074482410867777F, -0.0F, 0.0F);
        this.tail1 = new MowzieModelRenderer(this, 36, 47);
        this.tail1.setRotationPoint(0.0F, 0.2F, 11.0F);
        this.tail1.addBox(-3.0F, 0.0F, 0.0F, 6, 7, 10, 0.0F);
        this.leftTailFeather = new MowzieModelRenderer(this, 10, 53);
        this.leftTailFeather.setRotationPoint(1.0F, 1.7F, 0.0F);
        this.leftTailFeather.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        ModelUtils.setRotateAngle(leftTailFeather, 0.1038470904936626F, -0.0F, 0.0F);
        this.tail3 = new MowzieModelRenderer(this, 103, 49);
        this.tail3.setRotationPoint(0.0F, 0.7F, 10.0F);
        this.tail3.addBox(-1.0F, 0.0F, 0.0F, 2, 3, 8, 0.0F);
        ModelUtils.setRotateAngle(tail3, -0.14800392056911915F, -0.0F, 0.0F);
        this.rightCrest = new MowzieModelRenderer(this, 10, 53);
        this.rightCrest.setRotationPoint(-2.5F, -0.8F, -0.5F);
        this.rightCrest.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        ModelUtils.setRotateAngle(rightCrest, -0.07068583470577035F, -0.0F, 0.0F);
        this.leftThigh = new MowzieModelRenderer(this, 2, 17);
        this.leftThigh.mirror = true;
        this.leftThigh.setRotationPoint(2.5F, 9.6F, 7.5F);
        this.leftThigh.addBox(0.0F, -1.0F, -3.0F, 4, 8, 6, 0.0F);
        this.tail2 = new MowzieModelRenderer(this, 74, 48);
        this.tail2.setRotationPoint(0.0F, 0.6F, 9.0F);
        this.tail2.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 10, 0.0F);
        ModelUtils.setRotateAngle(tail2, 0.03717551306747922F, -0.0F, 0.0F);
        this.leftLeg = new MowzieModelRenderer(this, 98, 31);
        this.leftLeg.setRotationPoint(2.5F, 4.5F, 1.5F);
        this.leftLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 9, 3, 0.0F);
        ModelUtils.setRotateAngle(leftLeg, -0.3270747018237373F, -0.0F, 0.0F);
        this.neck = new MowzieModelRenderer(this, 52, 0);
        this.neck.setRotationPoint(0.0F, -0.1F, -7.5F);
        this.neck.addBox(-2.5F, -3.0F, -9.0F, 5, 7, 9, 0.0F);
        ModelUtils.setRotateAngle(neck, -0.5895722213236846F, -0.0F, 0.0F);
        this.middleTailFrontFeather = new MowzieModelRenderer(this, 10, 53);
        this.middleTailFrontFeather.setRotationPoint(0.0F, 1.2F, 0.0F);
        this.middleTailFrontFeather.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        ModelUtils.setRotateAngle(middleTailFrontFeather, 0.3269001688985379F, -0.0F, 0.0F);
        this.leftUpperArm = new MowzieModelRenderer(this, 35, 26);
        this.leftUpperArm.setRotationPoint(3.0F, 2.3F, -9.0F);
        this.leftUpperArm.addBox(0.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        ModelUtils.setRotateAngle(leftUpperArm, 0.2617993877991494F, -0.0F, 0.0F);
        this.leftFoot = new MowzieModelRenderer(this, 3, 45);
        this.leftFoot.setRotationPoint(0.0F, 8.0F, 1.0F);
        this.leftFoot.addBox(-1.5F, 0.0F, -4.0F, 3, 2, 5, 0.0F);
        ModelUtils.setRotateAngle(leftFoot, 0.33161255787892263F, -0.0F, 0.0F);
        this.rightLeg = new MowzieModelRenderer(this, 98, 31);
        this.rightLeg.setRotationPoint(-2.5F, 4.5F, 1.5F);
        this.rightLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 9, 3, 0.0F);
        ModelUtils.setRotateAngle(rightLeg, -0.3270747018237373F, -0.0F, 0.0F);
        this.rightTailFeather = new MowzieModelRenderer(this, 10, 53);
        this.rightTailFeather.setRotationPoint(-1.0F, 1.7F, 0.0F);
        this.rightTailFeather.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        ModelUtils.setRotateAngle(rightTailFeather, 0.1038470904936626F, -0.0F, 0.0F);
        this.rightUpperArm = new MowzieModelRenderer(this, 35, 26);
        this.rightUpperArm.mirror = true;
        this.rightUpperArm.setRotationPoint(-3.0F, 2.3F, -9.0F);
        this.rightUpperArm.addBox(-2.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        ModelUtils.setRotateAngle(rightUpperArm, 0.2617993877991494F, -0.0F, 0.0F);
        this.leftLowerArm = new MowzieModelRenderer(this, 34, 33);
        this.leftLowerArm.setRotationPoint(1.01F, 2.5F, -0.4F);
        this.leftLowerArm.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        ModelUtils.setRotateAngle(leftLowerArm, -0.5235987755982988F, -0.0F, 0.0F);
        this.lowerJaw = new MowzieModelRenderer(this, 27, 12);
        this.lowerJaw.setRotationPoint(0.0F, 2.5F, -7.0F);
        this.lowerJaw.addBox(-2.0F, 0.0F, -6.0F, 4, 2, 6, 0.0F);
        ModelUtils.setRotateAngle(lowerJaw, 0.02199114857512855F, -0.0F, 0.0F);
        this.lowerBody = new MowzieModelRenderer(this, 57, 20);
        this.lowerBody.setRotationPoint(0.0F, 4.6F, -1.0F);
        this.lowerBody.addBox(-4.0F, 0.0F, 0.0F, 8, 11, 12, 0.0F);
        ModelUtils.setRotateAngle(lowerBody, -0.03490658503988659F, -0.0F, 0.0F);
        this.rightThigh = new MowzieModelRenderer(this, 2, 17);
        this.rightThigh.setRotationPoint(-2.5F, 9.6F, 7.5F);
        this.rightThigh.addBox(-4.0F, -1.0F, -3.0F, 4, 8, 6, 0.0F);
        this.rightFoot = new MowzieModelRenderer(this, 3, 45);
        this.rightFoot.setRotationPoint(0.0F, 8.0F, 1.0F);
        this.rightFoot.addBox(-1.5F, 0.0F, -4.0F, 3, 2, 5, 0.0F);
        ModelUtils.setRotateAngle(rightFoot, 0.33161255787892263F, -0.0F, 0.0F);
        this.leftCrest = new MowzieModelRenderer(this, 10, 53);
        this.leftCrest.setRotationPoint(2.5F, -0.8F, -0.5F);
        this.leftCrest.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        ModelUtils.setRotateAngle(leftCrest, -0.07068583470577035F, -0.0F, 0.0F);
        this.teeth = new MowzieModelRenderer(this, 44, 18);
        this.teeth.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.teeth.addBox(-2.5F, 0.0F, -6.0F, 5, 1, 7, 0.0F);
        this.upperJaw = new MowzieModelRenderer(this, 28, 0);
        this.upperJaw.setRotationPoint(0.0F, -0.5F, -6.7F);
        this.upperJaw.addBox(-2.5F, -2.0F, -7.0F, 5, 5, 7, 0.0F);
        ModelUtils.setRotateAngle(upperJaw, 0.03490658503988659F, -0.0F, 0.0F);
        this.headPivot = new MowzieModelRenderer(this, 0, 0);
        this.headPivot.setRotationPoint(0.0F, -0.8F, -7.1F);
        this.headPivot.addBox(0F, 0F, 0F, 0, 0, 0, 0);
        ModelUtils.setRotateAngle(headPivot, 0.6457718232379019F, -0.0F, 0.0F);
        this.head = new MowzieModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0F, 0F);
        this.head.addBox(-3.5F, -3.0F, -7.0F, 7, 8, 7, 0.0F);
        ModelUtils.setRotateAngle(head, 0F, -0.0F, 0.0F);
        this.rightLowerArm = new MowzieModelRenderer(this, 34, 33);
        this.rightLowerArm.mirror = true;
        this.rightLowerArm.setRotationPoint(-1.01F, 2.5F, -0.4F);
        this.rightLowerArm.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        ModelUtils.setRotateAngle(rightLowerArm, -0.5235987755982988F, -0.0F, 0.0F);
        this.upperBody = new MowzieModelRenderer(this, 80, 0);
        this.upperBody.setRotationPoint(0.0F, 4.0F, 2.5F);
        this.upperBody.addBox(-3.0F, -4.0F, -10.0F, 6, 10, 10, 0.0F);
        ModelUtils.setRotateAngle(upperBody, 0.11309733552923257F, -0.0F, 0.0F);
        this.middleTailBackFeather = new MowzieModelRenderer(this, 10, 53);
        this.middleTailBackFeather.setRotationPoint(0.0F, 1.5F, 5.0F);
        this.middleTailBackFeather.addBox(-0.5F, -2.0F, 0.0F, 1, 4, 6, 0.0F);
        ModelUtils.setRotateAngle(middleTailBackFeather, 0.1759291886010284F, -0.0F, 0.0F);
        this.head.addChild(this.middleCrest);
        this.lowerBody.addChild(this.tail1);
        this.tail3.addChild(this.leftTailFeather);
        this.tail2.addChild(this.tail3);
        this.head.addChild(this.rightCrest);
        this.tail1.addChild(this.tail2);
        this.leftThigh.addChild(this.leftLeg);
        this.upperBody.addChild(this.neck);
        this.tail3.addChild(this.middleTailFrontFeather);
        this.upperBody.addChild(this.leftUpperArm);
        this.leftLeg.addChild(this.leftFoot);
        this.rightThigh.addChild(this.rightLeg);
        this.tail3.addChild(this.rightTailFeather);
        this.upperBody.addChild(this.rightUpperArm);
        this.leftUpperArm.addChild(this.leftLowerArm);
        this.head.addChild(this.lowerJaw);
        this.rightLeg.addChild(this.rightFoot);
        this.head.addChild(this.leftCrest);
        this.upperJaw.addChild(this.teeth);
        this.head.addChild(this.upperJaw);
        this.headPivot.addChild(this.head);
        this.neck.addChild(this.headPivot);
        this.rightUpperArm.addChild(this.rightLowerArm);
        this.lowerBody.addChild(this.upperBody);
        this.tail3.addChild(this.middleTailBackFeather);
        this.setInitPose();
        animator = new Animator(this);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animate((IAnimated) entity, f, f1, f2, f3, f4, f5);
        this.rightThigh.render(f5);
        this.lowerBody.render(f5);
        this.leftThigh.render(f5);

    }

    public void animate(IAnimated entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animator.update(entity);
        this.setToInitPose();
        setRotationAngles(f, f1, f2, f3, f4, f5, (Entity) entity);
        animator.setAnimationId(TyrannosaurusEntity.animation_roar.animationId);
        animator.startPhase(20);
        ModelUtils.rotate(animator, lowerBody, -5.22, 0, 0);
        ModelUtils.rotate(animator, neck, -41, 0, 0);
        ModelUtils.rotate(animator, rightThigh, -15, 0, 0);
        ModelUtils.rotate(animator, rightLeg, -31.3, 0, 0);
        ModelUtils.rotate(animator, rightFoot, 46, 0, 0);
        animator.endPhase();
        animator.startPhase(20);
        ModelUtils.rotate(animator, lowerBody, -13.04, 0, 0);
        animator.move(rightThigh, 0F, 1.4F, -1F);
        ModelUtils.rotate(animator, lowerJaw, 39.13, 0, 0);
        TyrannosaurusEntity mob = ((TyrannosaurusEntity) animator.getEntity());
        if (mob.getAnimation() == TyrannosaurusEntity.animation_roar && mob.getAnimationTick() >= 20 && mob.getAnimationTick() <= 60) {
            this.flap(head, 0.4F, 0.1F, false, 0, 0, ((Entity) entity).ticksExisted, 1);
            this.flap(neck, 0.4F, 0.1F, false, 0, 0, ((Entity) entity).ticksExisted, 1);
        }
        ModelUtils.rotate(animator, tail1, -13.04, 0, 0);
        ModelUtils.rotate(animator, tail2, 7.83, 0, 0);
        ModelUtils.rotate(animator, tail3, -2.61, 0, 0);
        animator.endPhase();
        animator.startPhase(20);
        ModelUtils.rotateToInit(animator, lowerBody);
        ModelUtils.rotateToInit(animator, tail1);
        ModelUtils.rotateToInit(animator, tail2);
        ModelUtils.rotateToInit(animator, tail3);
        ModelUtils.rotateToInit(animator, neck);
        ModelUtils.rotateToInit(animator, head);
        animator.endPhase();
        animator.resetPhase(20);
        animator.endPhase();
        if (mob.getAnimation() == TyrannosaurusEntity.animation_none) {
            this.faceTarget(neck, 1, f3, f4);
        }

//		animator.setAnimationId(NewPrehistoricEntity.animation_sit.animationId);
//		animator.startPhase(20);
//		sitPose(true);
//		animator.endPhase();
//
//		animator.setAnimationId(NewPrehistoricEntity.animation_getUp.animationId);
//		animator.startPhase(0);
//		sitPose(true);
//		animator.endPhase();
//		animator.resetPhase(20);
//		animator.endPhase();
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        MowzieModelRenderer[] tailParts = {this.tail1, this.tail2, this.tail3};
        MowzieModelRenderer[] neckParts = {this.neck, this.head};
        MowzieModelRenderer[] leftArmParts = {this.leftUpperArm, this.leftLowerArm};
        MowzieModelRenderer[] rightArmParts = {this.rightUpperArm, this.rightLowerArm};

        float speed = 0.5F;
        float speed2 = 0.1F;
        float sitProgress = ((NewPrehistoricEntity) (entity)).sitProgress;
        sitAnimationRotation(neck, sitProgress, -((float) Math.toRadians(15D)), 0, 0);
        sitAnimationRotation(leftLowerArm, sitProgress, -((float) Math.toRadians(30.0D)), 0, 0);
        sitAnimationRotation(lowerBody, sitProgress, -((float) Math.toRadians(13.04D)), 0, 0);
        sitAnimationRotation(leftCrest, sitProgress, -((float) Math.toRadians(4.05D)), 0, 0);
        sitAnimationRotation(rightLowerArm, sitProgress, -((float) Math.toRadians(30.0D)), 0, 0);
        sitAnimationRotation(middleTailBackFeather, sitProgress, (float) Math.toRadians(10.08D), 0, 0);
        sitAnimationRotation(tail1, sitProgress, -((float) Math.toRadians(10.43D)), 0, 0);
        sitAnimationRotation(tail3, sitProgress, -((float) Math.toRadians(2.61D)), 0, 0);
        sitAnimationRotation(lowerJaw, sitProgress, (float) Math.toRadians(1.26D), 0, 0);
        sitAnimationRotation(leftTailFeather, sitProgress, (float) Math.toRadians(5.95D), 0, 0);
        sitAnimationRotation(rightLeg, sitProgress, -((float) Math.toRadians(40.0D)), 0, 0);
        sitAnimationRotation(upperBody, sitProgress, (float) Math.toRadians(6.48D), 0, 0);
        sitAnimationRotation(rightCrest, sitProgress, -((float) Math.toRadians(4.05D)), 0, 0);
        sitAnimationRotation(rightThigh, sitProgress, -((float) Math.toRadians(50.0D)), 0, 0);
        sitAnimationRotation(leftLeg, sitProgress, -((float) Math.toRadians(40.0D)), 0, 0);
        sitAnimationRotation(leftFoot, sitProgress, (float) Math.toRadians(90.0D), 0, 0);
        sitAnimationRotation(middleCrest, sitProgress, (float) Math.toRadians(9.21D), 0, 0);
        sitAnimationRotation(head, sitProgress, (float) Math.toRadians(17D), 0, 0);
        sitAnimationRotation(middleTailFrontFeather, sitProgress, (float) Math.toRadians(18.73D), 0, 0);
        sitAnimationRotation(tail2, sitProgress, (float) Math.toRadians(13.04D), 0, 0);
        sitAnimationRotation(rightTailFeather, sitProgress, (float) Math.toRadians(5.95D), 0, 0);
        sitAnimationRotation(rightFoot, sitProgress, (float) Math.toRadians(90.0D), 0, 0);
        sitAnimationRotation(leftThigh, sitProgress, -((float) Math.toRadians(50.0D)), 0, 0);
        sitAnimationRotation(upperJaw, sitProgress, (float) Math.toRadians(2.0D), 0, 0);
        sitAnimationPos(rightThigh, sitProgress, 0F, 16.90F - rightThigh.initRotationPointY, 0F);
        sitAnimationPos(lowerBody, sitProgress, 0F, 10.80F - lowerBody.initRotationPointY, 0F);
        sitAnimationPos(leftThigh, sitProgress, 0F, 16.90F - leftThigh.initRotationPointY, 0F);
        this.walk(upperBody, speed2, 0.05F, false, 1F, 0F, entity.ticksExisted, 1);
        this.bob(lowerBody, speed2, 0.4F, false, entity.ticksExisted, 1);
        this.walk(upperBody, speed2, 0.05F, false, 1F, 0F, entity.ticksExisted, 1);
        this.walk(leftThigh, speed, 0.8F, false, 0F, 0.4F, f, f1);
        this.walk(leftLeg, speed, 0.2F, false, 0F, -0.6F, f, f1);
        this.walk(leftFoot, speed, -0.4F, false, 4.5F, 0.4F, f, f1);
        this.walk(rightThigh, speed, 0.8F, true, 0F, 0.4F, f, f1);
        this.walk(rightLeg, speed, 0.2F, true, 0F, -0.6F, f, f1);
        this.walk(rightFoot, speed, -0.4F, true, 4.5F, 0.4F, f, f1);
        this.chainWave(tailParts, speed2, 0.05F, -3, entity.ticksExisted, 1);
        this.chainWave(leftArmParts, speed2, 0.05F, -3, entity.ticksExisted, 1);
        this.chainWave(rightArmParts, speed2, 0.05F, -3, entity.ticksExisted, 1);
        this.chainSwing(tailParts, speed2, 0.15F, -3, entity.ticksExisted, 1);
        this.chainWave(neckParts, speed2, 0.05F, -3, entity.ticksExisted, 1);
        ((NewPrehistoricEntity) entity).tailbuffer.applyChainSwingBuffer(tailParts);
    }


//	@Override
//	public void sitPose(boolean animate) {
//		ModelUtils.animateOrSetRotation(animator, animate, rightCrest, -0.07068583470577035F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, leftCrest, -0.07068583470577035F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, leftLowerArm, -0.5235987755982988F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, middleCrest, 0.16074482410867777F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, rightLeg, -0.6981317007977318F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, rightThigh, -0.8726646259971648F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, tail2, 0.22759093446006054F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, lowerBody, -0.22759093446006054F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, middleTailBackFeather, 0.1759291886010284F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, neck, -0.5462880558742251F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, middleTailFrontFeather, 0.3269001688985379F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, upperJaw, 0.03490658503988659F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, upperBody, 0.11309733552923257F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, tail1, -0.18203784098300857F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, tail3, -0.045553093477052F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, leftFoot, 1.5707963267948966F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, leftTailFeather, 0.1038470904936626F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, leftThigh, -0.8726646259971648F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, rightTailFeather, 0.1038470904936626F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, headPivot, 1.0016444577195458F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, rightFoot, 1.5707963267948966F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, lowerJaw, 0.02199114857512855F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, rightLowerArm, -0.5235987755982988F, -0.0F, 0.0F, false);
//        ModelUtils.animateOrSetRotation(animator, animate, leftLeg, -0.6981317007977318F, -0.0F, 0.0F, false);
//        ModelUtils.animateToPos(animator, animate, lowerBody, 0F, 10.80F - lowerBody.initRotationPointY, 0F, true);
//		ModelUtils.animateToPos(animator, animate, rightThigh, 0F, 16.90F - rightThigh.initRotationPointY, 0F, true);
//		ModelUtils.animateToPos(animator, animate, leftThigh, 0F, 16.90F - leftThigh.initRotationPointY, 0F, true);
//		ModelUtils.setPos(animator, animate, lowerBody, 0F, 10.80F, -1F, false);
//		ModelUtils.setPos(animator, animate, rightThigh, -2.5F, 16.90F, 7.5F, false);
//		ModelUtils.setPos(animator, animate, leftThigh, 2.5F, 16.90F, 7.5F, false);
//	}

	/* public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity f6)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, f6);
        if (f6 instanceof DinosaurEntity)
        {
            if (!((DinosaurEntity) f6).isModelized())
            {

                tail1.rotateAngleY = 0.08F * MathHelper.sin(f2 * (float) 0.1F + (f1 + 2));
                tail2.rotateAngleY = 0.10F * MathHelper.sin(f2 * (float) 0.1F + f1 + 1);
                tail3.rotateAngleY = 0.15F * MathHelper.sin(f2 * (float) 0.1F + f1);

                // this.UpperLegRight.rotateAngleX = MathHelper.cos(f * 0.5662F) * 1.0F * f1;
                //  this.UpperLegLeft.rotateAngleX = MathHelper.cos(f * 0.5662F + (float)Math.PI) * 1.0F * f1;

                head.rotateAngleX = (f4 / (180F / (float) Math.PI));
                head.rotateAngleY = (f3 / (180F / (float) Math.PI));
                walk(leftThigh, 0.5F * 1, 0.8F, false, 0F, 0.4F, f, f1);
                //	walk(leftLeg, 0.5F * 1, 0.5F, false, 0F, 0F, f, f1);
                //	walk(leftFoot, 0.5F * 1, 1.5F, false, 0.5F, 1F, f, f1);
                walk(rightThigh, 0.5F * 1, 0.8F, true, 0F, 0.4F, f, f1);
                //	walk(rightLeg, 0.5F * 1, 0.5F, true, 0F, 0F, f, f1);
                //	walk(rightFoot, 0.5F * 1, 1.5F, true, 0.5F, 1F, f, f1);

            }
            else
            {
                tail1.rotateAngleY = 0F;
                tail2.rotateAngleY = 0F;
                tail3.rotateAngleY = 0F;

                head.rotateAngleX = 0F;
                head.rotateAngleY = 0F;
                rightThigh.rotateAngleX = 0F;
                leftThigh.rotateAngleX = 0F;
                rightLeg.rotateAngleX = -0.3270747018237373F;
                leftLeg.rotateAngleX = -0.3270747018237373F;
                rightFoot.rotateAngleX = 0.33161255787892263F;
                leftFoot.rotateAngleX = 0.33161255787892263F;
            }
        }
        else
        {

            tail1.rotateAngleY = 0.08F * MathHelper.sin(f2 * (float) 0.1F + (f1 + 2));
            tail2.rotateAngleY = 0.10F * MathHelper.sin(f2 * (float) 0.1F + f1 + 1);
            tail3.rotateAngleY = 0.15F * MathHelper.sin(f2 * (float) 0.1F + f1);

            // this.UpperLegRight.rotateAngleX = MathHelper.cos(f * 0.5662F) * 1.0F * f1;
            //  this.UpperLegLeft.rotateAngleX = MathHelper.cos(f * 0.5662F + (float)Math.PI) * 1.0F * f1;

            head.rotateAngleX = (f4 / (180F / (float) Math.PI));
            head.rotateAngleY = (f3 / (180F / (float) Math.PI));
            walk(leftThigh, 0.5F * 1, 0.8F, false, 0F, 0.4F, f, f1);
            //	walk(leftLeg, 0.5F * 1, 0.5F, false, 0F, 0F, f, f1);
            //	walk(leftFoot, 0.5F * 1, 1.5F, false, 0.5F, 1F, f, f1);
            walk(rightThigh, 0.5F * 1, 0.8F, true, 0F, 0.4F, f, f1);
            //	walk(rightLeg, 0.5F * 1, 0.5F, true, 0F, 0F, f, f1);
            //	walk(rightFoot, 0.5F * 1, 1.5F, true, 0.5F, 1F, f, f1);
        }
    }*/
}
