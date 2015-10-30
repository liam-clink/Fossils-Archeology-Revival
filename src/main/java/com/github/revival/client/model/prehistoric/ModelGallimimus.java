package com.github.revival.client.model.prehistoric;

import com.github.revival.common.entity.mob.EntityGallimimus;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGallimimus extends MowzieModelBase
{
	public MowzieModelRenderer lowerBody;
	public MowzieModelRenderer rightThigh;
	public MowzieModelRenderer leftThigh;
	public MowzieModelRenderer upperBody;
	public MowzieModelRenderer tail1;
	public MowzieModelRenderer rightUpperArm;
	public MowzieModelRenderer leftUpperArm;
	public MowzieModelRenderer neck;
	public MowzieModelRenderer rightLowerArm;
	public MowzieModelRenderer rightUpperArmFeather;
	public MowzieModelRenderer rightLowerArmFeather;
	public MowzieModelRenderer leftLowerArm;
	public MowzieModelRenderer leftUpperArmFeather;
	public MowzieModelRenderer leftLowerArmFeather;
	public MowzieModelRenderer headPivot;
	public MowzieModelRenderer head;
	public MowzieModelRenderer crest_right;
	public MowzieModelRenderer upperJaw;
	public MowzieModelRenderer lowerJaw;
	public MowzieModelRenderer crest_left;
	public MowzieModelRenderer tail2;
	public MowzieModelRenderer tail3;
	public MowzieModelRenderer tailCrest;
	public MowzieModelRenderer rightLeg;
	public MowzieModelRenderer rightFoot;
	public MowzieModelRenderer leftLeg;
	public MowzieModelRenderer leftFoot;

	public ModelGallimimus() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.leftUpperArmFeather = new MowzieModelRenderer(this, 32, 13);
		this.leftUpperArmFeather.mirror = true;
		this.leftUpperArmFeather.setRotationPoint(1.5F, 3.0F, 1.0F);
		this.leftUpperArmFeather.addBox(-0.5F, -3.0F, 0.0F, 1, 6, 4, 0.0F);
		this.crest_left = new MowzieModelRenderer(this, 68, 1);
		this.crest_left.setRotationPoint(0.5F, -1.0F, 0.0F);
		this.crest_left.addBox(0.5F, -2.0F, 0.0F, 0, 4, 3, 0.0F);
		ModelUtils.setRotateAngle(crest_left, 0.0F, 0.31869712141416456F, 0.0F);
		this.leftLowerArm = new MowzieModelRenderer(this, 8, 0);
		this.leftLowerArm.setRotationPoint(-0.2F, 4.0F, -0.4F);
		this.leftLowerArm.addBox(0.1F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
		ModelUtils.setRotateAngle(leftLowerArm, -0.2617993877991494F, -0.0F, 0.0F);
		this.tailCrest = new MowzieModelRenderer(this, 67, 18);
		this.tailCrest.setRotationPoint(0.0F, 1.0F, 7.0F);
		this.tailCrest.addBox(0.0F, -1.0F, 0.0F, 1, 3, 10, 0.0F);
		this.tail2 = new MowzieModelRenderer(this, 13, 21);
		this.tail2.setRotationPoint(0.0F, 0.5F, 5.9F);
		this.tail2.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 8, 0.0F);
		ModelUtils.setRotateAngle(tail2, 0.03490658503988659F, -0.0F, 0.0F);
		this.rightFoot = new MowzieModelRenderer(this, 22, 10);
		this.rightFoot.setRotationPoint(0.0F, 9.5F, -0.5F);
		this.rightFoot.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 3, 0.0F);
		ModelUtils.setRotateAngle(rightFoot, 0.17453292519943295F, -0.0F, 0.0F);
		this.rightLowerArmFeather = new MowzieModelRenderer(this, 32, 13);
		this.rightLowerArmFeather.setRotationPoint(-0.4F, 3.0F, 1.6F);
		this.rightLowerArmFeather.addBox(-0.5F, -3.0F, 0.0F, 1, 6, 4, 0.0F);
		this.headPivot = new MowzieModelRenderer(this, 0, 0);
		this.headPivot.setRotationPoint(0.0F, -11.5F, 0.5F);
		this.headPivot.addBox(0F, 0F, 0F, 0, 0, 0, 0.0F);
		ModelUtils.setRotateAngle(headPivot, -0.2040289895581371F, -0.0F, 0.0F);
		this.head = new MowzieModelRenderer(this, 46, 12);
		this.head.setRotationPoint(0.0F, 0F, 0.0F);
		this.head.addBox(-1.5F, -3.0F, -4.0F, 3, 4, 4, 0.0F);
		ModelUtils.setRotateAngle(head, 0F, -0.0F, 0.0F);
		this.lowerJaw = new MowzieModelRenderer(this, 52, 0);
		this.lowerJaw.setRotationPoint(0.0F, 0.0F, -4.0F);
		this.lowerJaw.addBox(-1.0F, 0.0F, -4.0F, 2, 1, 4, 0.0F);
		this.rightThigh = new MowzieModelRenderer(this, 1, 13);
		this.rightThigh.mirror = true;
		this.rightThigh.setRotationPoint(-3.5F, 10.0F, 5.0F);
		this.rightThigh.addBox(-3.0F, -1.0F, -2.0F, 3, 6, 4, 0.0F);
		this.leftThigh = new MowzieModelRenderer(this, 1, 13);
		this.leftThigh.setRotationPoint(3.5F, 10.0F, 5.0F);
		this.leftThigh.addBox(0.0F, -1.0F, -2.0F, 3, 6, 4, 0.0F);
		this.leftLeg = new MowzieModelRenderer(this, 0, 0);
		this.leftLeg.setRotationPoint(1.1F, 3.0F, 2.0F);
		this.leftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
		ModelUtils.setRotateAngle(leftLeg, -0.17453292519943295F, -0.0F, 0.0F);
		this.lowerBody = new MowzieModelRenderer(this, 3, 36);
		this.lowerBody.setRotationPoint(0.0F, 6.0F, -3.0F);
		this.lowerBody.addBox(-3.5F, 0.0F, 0.0F, 7, 7, 10, 0.0F);
		ModelUtils.setRotateAngle(lowerBody, -0.056897733615015135F, -0.0F, 0.0F);
		this.neck = new MowzieModelRenderer(this, 42, 0);
		this.neck.setRotationPoint(0.0F, 1.0F, -6.5F);
		this.neck.addBox(-1.0F, -14.0F, -1.0F, 2, 14, 2, 0.0F);
		ModelUtils.setRotateAngle(neck, 0.2214822820780804F, -0.0F, 0.0F);
		this.rightLowerArm = new MowzieModelRenderer(this, 8, 0);
		this.rightLowerArm.mirror = true;
		this.rightLowerArm.setRotationPoint(-0.9F, 4.0F, -0.4F);
		this.rightLowerArm.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
		ModelUtils.setRotateAngle(rightLowerArm, -0.2617993877991494F, -0.0F, 0.0F);
		this.rightLeg = new MowzieModelRenderer(this, 0, 0);
		this.rightLeg.mirror = true;
		this.rightLeg.setRotationPoint(-1.1F, 3.0F, 2.0F);
		this.rightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
		ModelUtils.setRotateAngle(rightLeg, -0.17453292519943295F, -0.0F, 0.0F);
		this.crest_right = new MowzieModelRenderer(this, 68, 1);
		this.crest_right.setRotationPoint(0.5F, -1.0F, 0.0F);
		this.crest_right.addBox(-1.5F, -2.0F, 0.0F, 0, 4, 3, 0.0F);
		ModelUtils.setRotateAngle(crest_right, 0.0F, -0.31869712141416456F, 0.0F);
		this.tail1 = new MowzieModelRenderer(this, 22, 0);
		this.tail1.setRotationPoint(0.0F, 0.2F, 9.9F);
		this.tail1.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 6, 0.0F);
		ModelUtils.setRotateAngle(tail1, 0.017453292519943295F, -0.0F, 0.0F);
		this.leftUpperArm = new MowzieModelRenderer(this, 0, 24);
		this.leftUpperArm.setRotationPoint(2.5F, -0.5F, -5.4F);
		this.leftUpperArm.addBox(0.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
		ModelUtils.setRotateAngle(leftUpperArm, -0.06824237375297829F, -0.0F, 0.0F);
		this.upperJaw = new MowzieModelRenderer(this, 52, 5);
		this.upperJaw.setRotationPoint(0.0F, -1.0F, -4.0F);
		this.upperJaw.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
		this.leftFoot = new MowzieModelRenderer(this, 22, 10);
		this.leftFoot.setRotationPoint(0.0F, 9.5F, -0.5F);
		this.leftFoot.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 3, 0.0F);
		ModelUtils.setRotateAngle(leftFoot, 0.17453292519943295F, -0.0F, 0.0F);
		this.tail3 = new MowzieModelRenderer(this, 28, 45);
		this.tail3.setRotationPoint(0.0F, 0.5F, 7.0F);
		this.tail3.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 11, 0.0F);
		ModelUtils.setRotateAngle(tail3, -0.10471975511965977F, 0.0F, 0.0F);
		this.rightUpperArm = new MowzieModelRenderer(this, 0, 24);
		this.rightUpperArm.mirror = true;
		this.rightUpperArm.setRotationPoint(-2.5F, -0.5F, -5.4F);
		this.rightUpperArm.addBox(-2.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
		ModelUtils.setRotateAngle(rightUpperArm, -0.06824237375297829F, -0.0F, 0.0F);
		this.rightUpperArmFeather = new MowzieModelRenderer(this, 32, 13);
		this.rightUpperArmFeather.setRotationPoint(-1.5F, 3.0F, 1.0F);
		this.rightUpperArmFeather.addBox(-0.5F, -3.0F, 0.0F, 1, 6, 4, 0.0F);
		this.upperBody = new MowzieModelRenderer(this, 42, 22);
		this.upperBody.setRotationPoint(0.0F, 2.0F, 1.0F);
		this.upperBody.addBox(-2.5F, -2.0F, -7.0F, 5, 6, 7, 0.0F);
		ModelUtils.setRotateAngle(upperBody, 0.13805554383275148F, -0.0F, 0.0F);
		this.leftLowerArmFeather = new MowzieModelRenderer(this, 32, 13);
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
		ModelUtils.doMowzieStuff(false, boxList);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		ModelUtils.doMowzieStuff(true, boxList);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		ModelUtils.renderAll(boxList);
	}
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		MowzieModelRenderer[] tailParts = {this.tail1, this.tail2, this.tail3};
		MowzieModelRenderer[] neckParts = {this.neck, this.head};
		MowzieModelRenderer[] leftArmParts = {this.leftUpperArm, this.leftLowerArm};
		MowzieModelRenderer[] rightArmParts = {this.rightUpperArm, this.rightLowerArm};

		faceTarget(head, 2, f3, f4);
		faceTarget(neck, 2, f3, f4);
		float speed = 0.1F;
		float speed2 = 0.5F;

		this.bob(lowerBody, speed, 0.5F, false, entity.ticksExisted, 1);
		this.walk(leftThigh, speed2, 0.8F, false, 0F, 0.4F, f, f1);
		this.walk(leftLeg, speed2, 0.2F, false, 0F, -0.6F, f, f1);
		this.walk(leftFoot, speed2, -0.4F, false, 4.5F, 0.4F, f, f1);
		this.walk(rightThigh, speed2, 0.8F, true, 0F, 0.4F, f, f1);
		this.walk(rightLeg, speed2, 0.2F, true, 0F, -0.6F, f, f1);
		this.walk(rightFoot, speed2, -0.4F, true, 4.5F, 0.4F, f, f1);
		this.chainWave(tailParts, speed, 0.05F, -3, entity.ticksExisted, 1);
		this.chainWave(leftArmParts, speed, -0.15F, -3, entity.ticksExisted, 1);
		this.chainWave(rightArmParts, speed,  -0.15F, -3, entity.ticksExisted, 1);
		this.chainSwing(tailParts, speed, 0.15F, -3, entity.ticksExisted, 1);
		this.chainSwing(tailParts, speed2, 0.25F, -3, f, f1);
		this.chainWave(neckParts, speed, 0.05F, 3, entity.ticksExisted, 1);
		this.chainWave(neckParts, speed, 0.15F, 3, f, f1);
		((EntityGallimimus)entity).tailbuffer.applyChainSwingBuffer(tailParts);

	}



	/*public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity f6)
	{
		MowzieModelRenderer[] tail = new MowzieModelRenderer[]{tail1, tail2, tail3};

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


	public void sanic_walk(MowzieModelRenderer box, float speed, float degree, boolean invert, float offset, float weight, float f, float f1)
	{
		int inverted = 1;
		if (invert)
			inverted = -1;
		box.rotateAngleX += f * degree * inverted * f1 + weight * f1;
	}
}
