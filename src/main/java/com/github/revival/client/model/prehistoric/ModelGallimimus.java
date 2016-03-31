package com.github.revival.client.model.prehistoric;

import com.github.revival.client.model.prehistoric.test.ModelNewPrehistoric;
import com.github.revival.server.entity.mob.EntityDilophosaurus;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;

public class ModelGallimimus extends ModelNewPrehistoric {
    public AdvancedModelRenderer lowerBody;
    public AdvancedModelRenderer rightThigh;
    public AdvancedModelRenderer leftThigh;
    public AdvancedModelRenderer upperBody;
    public AdvancedModelRenderer tail1;
    public AdvancedModelRenderer rightUpperArm;
    public AdvancedModelRenderer leftUpperArm;
    public AdvancedModelRenderer neck;
    public AdvancedModelRenderer rightLowerArm;
    public AdvancedModelRenderer rightUpperArmFeather;
    public AdvancedModelRenderer rightLowerArmFeather;
    public AdvancedModelRenderer leftLowerArm;
    public AdvancedModelRenderer leftUpperArmFeather;
    public AdvancedModelRenderer leftLowerArmFeather;
    public AdvancedModelRenderer headPivot;
    public AdvancedModelRenderer head;
    public AdvancedModelRenderer crest_right;
    public AdvancedModelRenderer upperJaw;
    public AdvancedModelRenderer lowerJaw;
    public AdvancedModelRenderer crest_left;
    public AdvancedModelRenderer tail2;
    public AdvancedModelRenderer tail3;
    public AdvancedModelRenderer tailCrest;
    public AdvancedModelRenderer rightLeg;
    public AdvancedModelRenderer rightFoot;
    public AdvancedModelRenderer leftLeg;
    public AdvancedModelRenderer leftFoot;
    private ModelAnimator animator;

    public ModelGallimimus() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.leftUpperArmFeather = new AdvancedModelRenderer(this, 32, 13);
        this.leftUpperArmFeather.mirror = true;
        this.leftUpperArmFeather.setRotationPoint(1.5F, 3.0F, 1.0F);
        this.leftUpperArmFeather.addBox(-0.5F, -3.0F, 0.0F, 1, 6, 4, 0.0F);
        this.crest_left = new AdvancedModelRenderer(this, 68, 1);
        this.crest_left.setRotationPoint(0.5F, -1.0F, 0.0F);
        this.crest_left.addBox(0.5F, -2.0F, 0.0F, 0, 4, 3, 0.0F);
        ModelUtils.setRotateAngle(crest_left, 0.0F, 0.31869712141416456F, 0.0F);
        this.leftLowerArm = new AdvancedModelRenderer(this, 8, 0);
        this.leftLowerArm.setRotationPoint(-0.2F, 4.0F, -0.4F);
        this.leftLowerArm.addBox(0.1F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        ModelUtils.setRotateAngle(leftLowerArm, -0.2617993877991494F, -0.0F, 0.0F);
        this.tailCrest = new AdvancedModelRenderer(this, 67, 18);
        this.tailCrest.setRotationPoint(0.0F, 1.0F, 7.0F);
        this.tailCrest.addBox(0.0F, -1.0F, 0.0F, 1, 3, 10, 0.0F);
        this.tail2 = new AdvancedModelRenderer(this, 13, 21);
        this.tail2.setRotationPoint(0.0F, 0.5F, 5.9F);
        this.tail2.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 8, 0.0F);
        ModelUtils.setRotateAngle(tail2, 0.03490658503988659F, -0.0F, 0.0F);
        this.rightFoot = new AdvancedModelRenderer(this, 22, 10);
        this.rightFoot.setRotationPoint(0.0F, 9.5F, -0.5F);
        this.rightFoot.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 3, 0.0F);
        ModelUtils.setRotateAngle(rightFoot, 0.17453292519943295F, -0.0F, 0.0F);
        this.rightLowerArmFeather = new AdvancedModelRenderer(this, 32, 13);
        this.rightLowerArmFeather.setRotationPoint(-0.4F, 3.0F, 1.6F);
        this.rightLowerArmFeather.addBox(-0.5F, -3.0F, 0.0F, 1, 6, 4, 0.0F);
        this.headPivot = new AdvancedModelRenderer(this, 0, 0);
        this.headPivot.setRotationPoint(0.0F, -11.5F, 0.5F);
        this.headPivot.addBox(0F, 0F, 0F, 0, 0, 0, 0.0F);
        ModelUtils.setRotateAngle(headPivot, -0.2040289895581371F, -0.0F, 0.0F);
        this.head = new AdvancedModelRenderer(this, 46, 12);
        this.head.setRotationPoint(0.0F, 0F, 0.0F);
        this.head.addBox(-1.5F, -3.0F, -4.0F, 3, 4, 4, 0.0F);
        ModelUtils.setRotateAngle(head, 0F, -0.0F, 0.0F);
        this.lowerJaw = new AdvancedModelRenderer(this, 52, 0);
        this.lowerJaw.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.lowerJaw.addBox(-1.0F, 0.0F, -4.0F, 2, 1, 4, 0.0F);
        this.rightThigh = new AdvancedModelRenderer(this, 1, 13);
        this.rightThigh.mirror = true;
        this.rightThigh.setRotationPoint(-3.5F, 10.0F, 5.0F);
        this.rightThigh.addBox(-3.0F, -1.0F, -2.0F, 3, 6, 4, 0.0F);
        this.leftThigh = new AdvancedModelRenderer(this, 1, 13);
        this.leftThigh.setRotationPoint(3.5F, 10.0F, 5.0F);
        this.leftThigh.addBox(0.0F, -1.0F, -2.0F, 3, 6, 4, 0.0F);
        this.leftLeg = new AdvancedModelRenderer(this, 0, 0);
        this.leftLeg.setRotationPoint(1.1F, 3.0F, 2.0F);
        this.leftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
        ModelUtils.setRotateAngle(leftLeg, -0.17453292519943295F, -0.0F, 0.0F);
        this.lowerBody = new AdvancedModelRenderer(this, 3, 36);
        this.lowerBody.setRotationPoint(0.0F, 6.0F, -3.0F);
        this.lowerBody.addBox(-3.5F, 0.0F, 0.0F, 7, 7, 10, 0.0F);
        ModelUtils.setRotateAngle(lowerBody, -0.056897733615015135F, -0.0F, 0.0F);
        this.neck = new AdvancedModelRenderer(this, 42, 0);
        this.neck.setRotationPoint(0.0F, 1.0F, -6.5F);
        this.neck.addBox(-1.0F, -14.0F, -1.0F, 2, 14, 2, 0.0F);
        ModelUtils.setRotateAngle(neck, 0.2214822820780804F, -0.0F, 0.0F);
        this.rightLowerArm = new AdvancedModelRenderer(this, 8, 0);
        this.rightLowerArm.mirror = true;
        this.rightLowerArm.setRotationPoint(-0.9F, 4.0F, -0.4F);
        this.rightLowerArm.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        ModelUtils.setRotateAngle(rightLowerArm, -0.2617993877991494F, -0.0F, 0.0F);
        this.rightLeg = new AdvancedModelRenderer(this, 0, 0);
        this.rightLeg.mirror = true;
        this.rightLeg.setRotationPoint(-1.1F, 3.0F, 2.0F);
        this.rightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
        ModelUtils.setRotateAngle(rightLeg, -0.17453292519943295F, -0.0F, 0.0F);
        this.crest_right = new AdvancedModelRenderer(this, 68, 1);
        this.crest_right.setRotationPoint(0.5F, -1.0F, 0.0F);
        this.crest_right.addBox(-1.5F, -2.0F, 0.0F, 0, 4, 3, 0.0F);
        ModelUtils.setRotateAngle(crest_right, 0.0F, -0.31869712141416456F, 0.0F);
        this.tail1 = new AdvancedModelRenderer(this, 22, 0);
        this.tail1.setRotationPoint(0.0F, 0.2F, 9.9F);
        this.tail1.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 6, 0.0F);
        ModelUtils.setRotateAngle(tail1, 0.017453292519943295F, -0.0F, 0.0F);
        this.leftUpperArm = new AdvancedModelRenderer(this, 0, 24);
        this.leftUpperArm.setRotationPoint(2.5F, -0.5F, -5.4F);
        this.leftUpperArm.addBox(0.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        ModelUtils.setRotateAngle(leftUpperArm, -0.06824237375297829F, -0.0F, 0.0F);
        this.upperJaw = new AdvancedModelRenderer(this, 52, 5);
        this.upperJaw.setRotationPoint(0.0F, -1.0F, -4.0F);
        this.upperJaw.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        this.leftFoot = new AdvancedModelRenderer(this, 22, 10);
        this.leftFoot.setRotationPoint(0.0F, 9.5F, -0.5F);
        this.leftFoot.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 3, 0.0F);
        ModelUtils.setRotateAngle(leftFoot, 0.17453292519943295F, -0.0F, 0.0F);
        this.tail3 = new AdvancedModelRenderer(this, 28, 45);
        this.tail3.setRotationPoint(0.0F, 0.5F, 7.0F);
        this.tail3.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 11, 0.0F);
        ModelUtils.setRotateAngle(tail3, -0.10471975511965977F, 0.0F, 0.0F);
        this.rightUpperArm = new AdvancedModelRenderer(this, 0, 24);
        this.rightUpperArm.mirror = true;
        this.rightUpperArm.setRotationPoint(-2.5F, -0.5F, -5.4F);
        this.rightUpperArm.addBox(-2.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        ModelUtils.setRotateAngle(rightUpperArm, -0.06824237375297829F, -0.0F, 0.0F);
        this.rightUpperArmFeather = new AdvancedModelRenderer(this, 32, 13);
        this.rightUpperArmFeather.setRotationPoint(-1.5F, 3.0F, 1.0F);
        this.rightUpperArmFeather.addBox(-0.5F, -3.0F, 0.0F, 1, 6, 4, 0.0F);
        this.upperBody = new AdvancedModelRenderer(this, 42, 22);
        this.upperBody.setRotationPoint(0.0F, 2.0F, 1.0F);
        this.upperBody.addBox(-2.5F, -2.0F, -7.0F, 5, 6, 7, 0.0F);
        ModelUtils.setRotateAngle(upperBody, 0.13805554383275148F, -0.0F, 0.0F);
        this.leftLowerArmFeather = new AdvancedModelRenderer(this, 32, 13);
        this.leftLowerArmFeather.mirror = true;
        this.leftLowerArmFeather.setRotationPoint(1.5F, 3.0F, 1.6F);
        this.leftLowerArmFeather.addBox(-0.5F, -3.0F, 0.0F, 1, 6, 4, 0.0F);
        this.leftUpperArm.addChild(this.leftUpperArmFeather);
        this.head.addChild(this.crest_left);
        this.leftUpperArm.addChild(this.leftLowerArm);
        this.tail3.addChild(this.tailCrest);
        this.tail1.addChild(this.tail2);
        this.rightLeg.addChild(this.rightFoot);
        this.rightLowerArm.addChild(this.rightLowerArmFeather);
        this.neck.addChild(this.headPivot);
        this.headPivot.addChild(this.head);
        this.head.addChild(this.lowerJaw);
        this.leftThigh.addChild(this.leftLeg);
        this.upperBody.addChild(this.neck);
        this.rightUpperArm.addChild(this.rightLowerArm);
        this.rightThigh.addChild(this.rightLeg);
        this.head.addChild(this.crest_right);
        this.lowerBody.addChild(this.tail1);
        this.upperBody.addChild(this.leftUpperArm);
        this.head.addChild(this.upperJaw);
        this.leftLeg.addChild(this.leftFoot);
        this.tail2.addChild(this.tail3);
        this.upperBody.addChild(this.rightUpperArm);
        this.rightUpperArm.addChild(this.rightUpperArmFeather);
        this.lowerBody.addChild(this.upperBody);
        this.leftLowerArm.addChild(this.leftLowerArmFeather);
        this.updateDefaultPose();
        animator = ModelAnimator.create();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        this.rightThigh.render(f5);
        this.lowerBody.render(f5);
        this.leftThigh.render(f5);
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animator.update(entity);
        blockMovement(f, f1, f2, f3, f4, f5, (Entity) entity);
        this.resetToDefaultPose();
        setRotationAngles(f, f1, f2, f3, f4, f5, (Entity) entity);
        animator.setAnimation(EntityDilophosaurus.animation_attack);
        animator.startKeyframe(10);
		ModelUtils.rotate(animator, neck, -36, 0, 0);
		ModelUtils.rotate(animator, head, 47, 0, 0);
		ModelUtils.rotate(animator, lowerJaw, 15, 0, 0);
		ModelUtils.rotate(animator, leftUpperArm, 10, 0, -40);
		ModelUtils.rotate(animator, rightUpperArm, 10, 0, 40);
		ModelUtils.rotate(animator, leftLowerArm, -20, 0, 0);
		ModelUtils.rotate(animator, rightLowerArm, -20, 0, 0);
        animator.endKeyframe();
        animator.startKeyframe(5);
		ModelUtils.rotate(animator, neck, 6, 0, 0);
		ModelUtils.rotate(animator, head, -14, 0, 0);
		ModelUtils.rotate(animator, lowerJaw, 15, 0, 0);
		ModelUtils.rotate(animator, leftUpperArm, 10, 0, -40);
		ModelUtils.rotate(animator, rightUpperArm, 10, 0, 40);
		ModelUtils.rotate(animator, leftLowerArm, -20, 0, 0);
		ModelUtils.rotate(animator, rightLowerArm, -20, 0, 0);
        animator.endKeyframe();
        animator.resetKeyframe(10);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        AdvancedModelRenderer[] tailParts = {this.tail1, this.tail2, this.tail3};
        AdvancedModelRenderer[] neckParts = {this.neck, this.head};
        AdvancedModelRenderer[] leftArmParts = {this.leftUpperArm, this.leftLowerArm};
        AdvancedModelRenderer[] rightArmParts = {this.rightUpperArm, this.rightLowerArm};

        ModelUtils.faceTargetMod(neck, f3, f4, 0.5F);
        ModelUtils.faceTargetMod(head, f3, f4, 0.5F);
        
        float speed = 0.1F;
        float speed2 = 0.4F;
        float sitProgress = ((EntityNewPrehistoric) (entity)).sitProgress;
        sitAnimationRotation(tail3, sitProgress, (float) Math.toRadians(5.22D), 0, 0);
        sitAnimationRotation(lowerBody, sitProgress, -((float) Math.toRadians(2.61D)), 0, 0);
        sitAnimationRotation(leftLowerArm, sitProgress, -((float) Math.toRadians(15.0D)), 0, 0);
        sitAnimationRotation(rightLeg, sitProgress, -((float) Math.toRadians(68.0D)), 0, 0);
        sitAnimationRotation(rightLowerArm, sitProgress, -((float) Math.toRadians(15.0D)), 0, 0);
        sitAnimationRotation(leftFoot, sitProgress, (float) Math.toRadians(68.0D), 0, 0);
        sitAnimationRotation(tail2, sitProgress, (float) Math.toRadians(2.61D), 0, 0);
        sitAnimationRotation(upperBody, sitProgress, (float) Math.toRadians(20.87D), 0, 0);
        sitAnimationRotation(neck, sitProgress, -((float) Math.toRadians(2.61D)), 0, 0);
        sitAnimationRotation(tail1, sitProgress, -((float) Math.toRadians(13.04D)), 0, 0);
        sitAnimationRotation(rightUpperArm, sitProgress, -((float) Math.toRadians(20.0D)), -((float) Math.toRadians(5.0D)), (float) Math.toRadians(44.0D));
        sitAnimationRotation(leftLeg, sitProgress, -((float) Math.toRadians(68.0D)), 0, 0);
        sitAnimationRotation(rightFoot, sitProgress, (float) Math.toRadians(68.0D), 0, 0);
        sitAnimationRotation(leftUpperArm, sitProgress, -((float) Math.toRadians(20.0D)), -((float) Math.toRadians(5.0D)), -((float) Math.toRadians(44.0D)));
        sitAnimationPos(lowerBody, sitProgress, 0F, 14.50F - ModelUtils.getDefaultPositionY(lowerBody), 0F);
        sitAnimationPos(rightThigh, sitProgress, 0F, 16.60F - ModelUtils.getDefaultPositionY(rightThigh), 0F);
        sitAnimationPos(leftThigh, sitProgress, 0F, 16.60F - ModelUtils.getDefaultPositionY(leftThigh), 0F);
        this.walk(upperBody, speed, 0.05F, false, 1F, 0F, entity.ticksExisted, 1);
        this.bob(lowerBody, speed, 0.5F, false, entity.ticksExisted, 1);
        this.chainWave(tailParts, speed, 0.05F, -3, entity.ticksExisted, 1);
        this.chainWave(leftArmParts, speed, -0.15F, -3, entity.ticksExisted, 1);
        this.chainWave(rightArmParts, speed, -0.15F, -3, entity.ticksExisted, 1);
        this.chainSwing(tailParts, speed, 0.15F, -3, entity.ticksExisted, 1);
        this.chainSwing(tailParts, speed2, 0.25F, -3, f, f1);
        this.chainWave(neckParts, speed, 0.05F, 3, entity.ticksExisted, 1);
        this.chainWave(neckParts, speed, 0.15F, 3, f, f1);
        this.walk(leftThigh, speed2, 0.8F, false, 0F, -0.4F, f, f1);
		this.walk(leftLeg, speed2, 0.2F, false, 0F, 0.6F, f, f1);
		this.walk(leftFoot, speed2, -0.4F, true, -0.5F, -0.2F, f, f1);
		this.walk(rightThigh, speed2, 0.8F, true, 0F, 0.4F, f, f1);
		this.walk(rightLeg, speed2, 0.2F, true, 0F, -0.6F, f, f1);
		this.walk(rightFoot, speed2, -0.4F, false, -0.5F, -0.2F, f, f1);
		this.chainWave(neckParts, speed2, 0.5F, 4, f, f1);
		this.chainWave(tailParts, speed2, 0.3F, -4, f, f1);
        ((EntityNewPrehistoric)entity).tailbuffer.applyChainSwingBuffer(tailParts);
    }



	/*public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity f6)
    {
		AdvancedModelRenderer[] tail = new AdvancedModelRenderer[]{tail1, tail2, tail3};

		super.setRotationAngles(f, f1, f2, f3, f4, f5, f6);
		if (f6 instanceof EntityDinosaur)
		{
			if (!((EntityDinosaur) f6).isModelized())
			{
				float frame = ((EntityPrehistoric)f6).animation_frame;
				//40=100/x
				update();
				faceTarget(headPivot, 4, f3, f4);
				faceTarget(neck, 8, f3, f4);
				walk(leftThigh, 0.5F, 0.8F, false, 0F, 0.4F, f, f1);
				walk(leftFoot, 0.5F, 0.8F, false, 0F, 0F, f, -f1);
				walk(rightThigh, 0.5F, 0.8F, true, 0F, 0.4F, f, f1);
				walk(rightFoot, 0.5F, 0.8F, true, 0F, 0F, f, -f1);
				walk(neck, -0.25F, 0.2F, false, 0F, 0.4F, f, -f1);
				walk(headPivot, -0.2F, 0.25F, false, 0F, 0.4F, f, f1);
				walk(rightUpperArm, 0.05F, 0.05F, true, 0F, 0F, frame, 1);
				walk(leftUpperArm, 0.05F, 0.05F, true, 0F, 0F, frame, 1);
				walk(rightLowerArm, 0.05F,  0.05F, false, 0F, 0F, frame, -1);
				walk(leftLowerArm, 0.05F,  0.05F, false, 0F, 0F, frame, -1);
				chainSwing(tail, 0.03F, 0.15F, 0, frame, -1);
				chainWave(tail, 0.02F, 0.05F, 0, frame, -1);
				 this.chainWave(tail, 0.1F, -0.05F - (-0.05F), 2, frame, 1.0F - 0.6F);
			}else{
				update();
			}
		}
	}*/


//	@Override
//	public void sitPose(boolean animate) {
//		ModelUtils.animateOrSetRotation(animator, animate, leftFoot, 1.186823891356144F, -0.0F, 0.0F, false);
//		ModelUtils.animateOrSetRotation(animator, animate, rightFoot, 1.186823891356144F, -0.0F, 0.0F, false);
//		ModelUtils.animateOrSetRotation(animator, animate, neck, -0.045553093477052F, -0.0F, 0.0F, false);
//		ModelUtils.animateOrSetRotation(animator, animate, leftUpperArm, -0.3490658503988659F, -0.08726646259971647F, -0.767944870877505F, false);
//		ModelUtils.animateOrSetRotation(animator, animate, leftLeg, -1.186823891356144F, -0.0F, 0.0F, false);
//		ModelUtils.animateOrSetRotation(animator, animate, leftLowerArm, -0.2617993877991494F, -0.0F, 0.0F, false);
//		ModelUtils.animateOrSetRotation(animator, animate, upperBody, 0.36425021489121656F, -0.0F, 0.0F, false);
//		ModelUtils.animateOrSetRotation(animator, animate, lowerBody, -0.045553093477052F, -0.0F, 0.0F, false);
//		ModelUtils.animateOrSetRotation(animator, animate, rightUpperArm, -0.3490658503988659F, -0.08726646259971647F, 0.767944870877505F, false);
//		ModelUtils.animateOrSetRotation(animator, animate, tail3, 0.091106186954104F, 0.0F, 0.0F, false);
//		ModelUtils.animateOrSetRotation(animator, animate, rightLeg, -1.186823891356144F, -0.0F, 0.0F, false);
//		ModelUtils.animateOrSetRotation(animator, animate, tail2, 0.045553093477052F, -0.0F, 0.0F, false);
//		ModelUtils.animateOrSetRotation(animator, animate, tail1, (float)Math.toRadians(-13.04), -0.0F, 0.0F, false);
//		ModelUtils.animateOrSetRotation(animator, animate, rightLowerArm, -0.2617993877991494F, -0.0F, 0.0F, false);
//		ModelUtils.animateToPos(animator, animate, lowerBody, 0F, 14.50F - lowerBody.initRotationPointY, 0F, true);
//		ModelUtils.animateToPos(animator, animate, leftThigh, 0F, 16.60F - leftThigh.initRotationPointY, 0F, true);
//		ModelUtils.animateToPos(animator, animate, rightThigh, 0F, 16.60F - rightThigh.initRotationPointY, 0F, true);
//		ModelUtils.setPos(animator, animate, lowerBody, 0F, 14.50F, -3F, false);
//		ModelUtils.setPos(animator, animate, leftThigh, 3.5F, 16.60F, 5F, false);
//		ModelUtils.setPos(animator, animate, rightThigh, -3.5F, 16.60F, 5F, false);
//	}
}
