package com.github.revival.client.model.prehistoric;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;

public class ModelSarcosuchus extends ModelPrehistoric {
	AdvancedModelRenderer body;
	AdvancedModelRenderer LowerBody;
	AdvancedModelRenderer leftHindLeg;
	AdvancedModelRenderer leftHindThigh;
	AdvancedModelRenderer leftHindFoot;
	AdvancedModelRenderer rightLowerBodyOsteoderms;
	AdvancedModelRenderer leftLowerBodyOsteoderms;
	AdvancedModelRenderer middleLowerBodyOsteoderms;
	AdvancedModelRenderer tail1;
	AdvancedModelRenderer bottomJawBase;
	AdvancedModelRenderer tail2;
	AdvancedModelRenderer tail2Osteoderms;
	AdvancedModelRenderer tail3;
	AdvancedModelRenderer tail3Osteoderms;
	AdvancedModelRenderer tail1Osteoderms;
	AdvancedModelRenderer rightHindThigh;
	AdvancedModelRenderer rightHindFoot;
	AdvancedModelRenderer rightHindLeg;
	AdvancedModelRenderer upperBody;
	AdvancedModelRenderer neck;
	AdvancedModelRenderer head;
	AdvancedModelRenderer bottomJaw;
	AdvancedModelRenderer lowerJaw;
	AdvancedModelRenderer upperJaw;
	AdvancedModelRenderer teeth;
	AdvancedModelRenderer snout;
	AdvancedModelRenderer leftFrontThigh;
	AdvancedModelRenderer leftFrontLeg;
	AdvancedModelRenderer leftFrontFoot;
	AdvancedModelRenderer rightFrontThigh;
	AdvancedModelRenderer rightFrontLeg;
	AdvancedModelRenderer rightFrontFoot;
	AdvancedModelRenderer middleBodyOsteoderms;
	AdvancedModelRenderer middleUpperBodyOsteoderms;
	AdvancedModelRenderer leftUpperBodyOsteoderms;
	AdvancedModelRenderer rightUpperBodyOsteoderms;
	AdvancedModelRenderer rightBodyOsteoderms;
	AdvancedModelRenderer leftBodyOsteoderms;

	public ModelSarcosuchus() {
		textureWidth = 256;
		textureHeight = 128;
		setTextureOffset("body.body", 61, 92);
		setTextureOffset("LowerBody.lowerBody", 1, 81);
		setTextureOffset("leftHindThigh.leftHindThigh", 174, 25);
		setTextureOffset("leftHindLeg.leftHindLeg", 209, 25);
		setTextureOffset("leftHindFoot.leftHindFoot", 210, 39);
		setTextureOffset("rightLowerBodyOsteoderms.rightLowerBodyOsteoderms", 128, 38);
		setTextureOffset("leftLowerBodyOsteoderms.leftLowerBodyOsteoderms", 128, 38);
		setTextureOffset("middleLowerBodyOsteoderms.middleLowerBodyOsteoderms", 128, 38);
		setTextureOffset("tail1.tail1", 145, 86);
		setTextureOffset("tail2.tail2", 181, 53);
		setTextureOffset("tail2Osteoderms.tail2Osteoderms", 118, 52);
		setTextureOffset("tail3.tail3", 186, 92);
		setTextureOffset("tail3Osteoderms.tail3Osteoderms", 113, 23);
		setTextureOffset("tail1Osteoderms.tail1Osteoderms", 117, 23);
		setTextureOffset("rightHindThigh.rightHindThigh", 174, 25);
		setTextureOffset("rightHindLeg.rightHindLeg", 209, 25);
		setTextureOffset("rightHindFoot.rightHindFoot", 210, 39);
		setTextureOffset("upperBody.upperBody", 68, 66);
		setTextureOffset("neck.neck", 1, 110);
		setTextureOffset("head.head", 0, 14);
		setTextureOffset("bottomJawBase.bottomJaw", 193, 0);
		setTextureOffset("bottomJaw.lowerJaw", 76, 0);
		setTextureOffset("upperJaw.upperJaw", 62, 37);
		setTextureOffset("teeth.teeth", 0, 46);
		setTextureOffset("snout.snout", 0, 0);
		setTextureOffset("leftFrontThigh.leftFrontThigh", 174, 25);
		setTextureOffset("leftFrontLeg.leftFrontLeg", 209, 25);
		setTextureOffset("leftFrontFoot.leftFrontFoot", 210, 39);
		setTextureOffset("rightFrontThigh.rightFrontThigh", 174, 25);
		setTextureOffset("rightFrontLeg.rightFrontLeg", 209, 25);
		setTextureOffset("rightFrontFoot.rightFrontFoot", 210, 39);
		setTextureOffset("rightUpperBodyOsteoderms.rightUpperBodyOsteoderms", 124, 30);
		setTextureOffset("leftUpperBodyOsteoderms.leftUpperBodyOsteoderms", 124, 30);
		setTextureOffset("middleUpperBodyOsteoderms.middleUpperBodyOsteoderms", 124, 30);
		setTextureOffset("middleBodyOsteoderms.middleBodyOsteoderms", 117, 23);
		setTextureOffset("rightBodyOsteoderms.rightBodyOsteoderms", 117, 23);
		setTextureOffset("leftBodyOsteoderms.leftBodyOsteoderms", 117, 23);

		body = new AdvancedModelRenderer(this, "body");
		body.setRotationPoint(0F, 10F, 13F);
		setRotateAngle(body, 0F, 0F, 0F);
		body.mirror = true;
		body.addBox("body", -9F, 0F, 0F, 18, 13, 21);
		LowerBody = new AdvancedModelRenderer(this, "LowerBody");
		LowerBody.setRotationPoint(0F, 1F, 19F);
		setRotateAngle(LowerBody, 0F, 0F, 0F);
		LowerBody.mirror = true;
		LowerBody.addBox("lowerBody", -8.5F, 0F, 0F, 17, 11, 11);
		leftHindThigh = new AdvancedModelRenderer(this, "leftHindThigh");
		leftHindThigh.setRotationPoint(8F, 2F, 3.48F);
		setRotateAngle(leftHindThigh, 0F, 0F, 0F);
		leftHindThigh.mirror = true;
		leftHindThigh.addBox("leftHindThigh", 0F, 0F, -3.5F, 6, 5, 7);
		leftHindLeg = new AdvancedModelRenderer(this, "leftHindLeg");
		leftHindLeg.setRotationPoint(5.1F, 4.1F, 1.6F);
		setRotateAngle(leftHindLeg, 0F, 0F, 0F);
		leftHindLeg.mirror = false;
		leftHindLeg.addBox("leftHindLeg", -2F, 0F, -2.5F, 4, 7, 5);
		leftHindFoot = new AdvancedModelRenderer(this, "leftHindFoot");
		leftHindFoot.setRotationPoint(0F, 5.1F, -2F);
		setRotateAngle(leftHindFoot, 0F, 0F, 0F);
		leftHindFoot.mirror = true;
		leftHindFoot.addBox("leftHindFoot", -2.5F, 0F, -4F, 5, 2, 7);
		leftHindLeg.addChild(leftHindFoot);
		leftHindThigh.addChild(leftHindLeg);
		LowerBody.addChild(leftHindThigh);
		rightLowerBodyOsteoderms = new AdvancedModelRenderer(this, "rightLowerBodyOsteoderms");
		rightLowerBodyOsteoderms.setRotationPoint(-5F, 4F, 5F);
		setRotateAngle(rightLowerBodyOsteoderms, 0F, 0F, 0F);
		rightLowerBodyOsteoderms.mirror = true;
		rightLowerBodyOsteoderms.addBox("rightLowerBodyOsteoderms", 0F, -5F, 0F, 1, 5, 9);
		LowerBody.addChild(rightLowerBodyOsteoderms);
		leftLowerBodyOsteoderms = new AdvancedModelRenderer(this, "leftLowerBodyOsteoderms");
		leftLowerBodyOsteoderms.setRotationPoint(5F, 4F, 5F);
		setRotateAngle(leftLowerBodyOsteoderms, 0F, 0F, 0F);
		leftLowerBodyOsteoderms.mirror = true;
		leftLowerBodyOsteoderms.addBox("leftLowerBodyOsteoderms", 0F, -5F, 0F, 1, 5, 9);
		LowerBody.addChild(leftLowerBodyOsteoderms);
		middleLowerBodyOsteoderms = new AdvancedModelRenderer(this, "middleLowerBodyOsteoderms");
		middleLowerBodyOsteoderms.setRotationPoint(0F, 4F, 5F);
		setRotateAngle(middleLowerBodyOsteoderms, 0F, 0F, 0F);
		middleLowerBodyOsteoderms.mirror = true;
		middleLowerBodyOsteoderms.addBox("middleLowerBodyOsteoderms", 0F, -5F, 0F, 1, 5, 9);
		LowerBody.addChild(middleLowerBodyOsteoderms);
		tail1 = new AdvancedModelRenderer(this, "tail1");
		tail1.setRotationPoint(0F, 2.5F, 11F);
		setRotateAngle(tail1, 0F, 0F, 0F);
		tail1.mirror = true;
		tail1.addBox("tail1", -7F, 0F, 0F, 14, 8, 18);
		tail2 = new AdvancedModelRenderer(this, "tail2");
		tail2.setRotationPoint(0F, 0F, 18F);
		setRotateAngle(tail2, 0F, 0F, 0F);
		tail2.mirror = true;
		tail2.addBox("tail2", -5F, 1F, 0F, 10, 7, 24);
		tail2Osteoderms = new AdvancedModelRenderer(this, "tail2Osteoderms");
		tail2Osteoderms.setRotationPoint(0F, 1F, 3F);
		setRotateAngle(tail2Osteoderms, 0F, 0F, 0F);
		tail2Osteoderms.mirror = true;
		tail2Osteoderms.addBox("tail2Osteoderms", 0F, -5F, 0F, 1, 5, 20);
		tail2.addChild(tail2Osteoderms);
		tail3 = new AdvancedModelRenderer(this, "tail3");
		tail3.setRotationPoint(0F, 3F, 24F);
		setRotateAngle(tail3, 0F, 0F, 0F);
		tail3.mirror = true;
		tail3.addBox("tail3", -4F, 0F, 0F, 8, 5, 27);
		tail3Osteoderms = new AdvancedModelRenderer(this, "tail3Osteoderms");
		tail3Osteoderms.setRotationPoint(0F, 1F, 0F);
		setRotateAngle(tail3Osteoderms, 0F, 0F, 0F);
		tail3Osteoderms.mirror = true;
		tail3Osteoderms.addBox("tail3Osteoderms", 0F, -5F, 0F, 1, 5, 24);
		tail3.addChild(tail3Osteoderms);
		tail2.addChild(tail3);
		tail1.addChild(tail2);
		tail1Osteoderms = new AdvancedModelRenderer(this, "tail1Osteoderms");
		tail1Osteoderms.setRotationPoint(0F, 1F, 0F);
		setRotateAngle(tail1Osteoderms, 0F, 0F, 0F);
		tail1Osteoderms.mirror = true;
		tail1Osteoderms.addBox("tail1Osteoderms", 0F, -5F, 0F, 1, 5, 24);
		tail1.addChild(tail1Osteoderms);
		LowerBody.addChild(tail1);
		rightHindThigh = new AdvancedModelRenderer(this, "rightHindThigh");
		rightHindThigh.setRotationPoint(-8F, 2F, 3.5F);
		setRotateAngle(rightHindThigh, 0F, 0F, 0F);
		rightHindThigh.mirror = true;
		rightHindThigh.mirror = true;
		rightHindThigh.addBox("rightHindThigh", -6F, 0F, -3.5F, 6, 5, 7);
		rightHindThigh.mirror = false;
		rightHindLeg = new AdvancedModelRenderer(this, "rightHindLeg");
		rightHindLeg.setRotationPoint(-5.1F, 4.1F, 1.6F);
		setRotateAngle(rightHindLeg, 0F, 0F, 0F);
		rightHindLeg.mirror = true;
		rightHindLeg.mirror = true;
		rightHindLeg.addBox("rightHindLeg", -2F, 0F, -2.5F, 4, 7, 5);
		rightHindLeg.mirror = false;
		rightHindFoot = new AdvancedModelRenderer(this, "rightHindFoot");
		rightHindFoot.setRotationPoint(0F, 5.1F, -2F);
		setRotateAngle(rightHindFoot, 0F, 0F, 0F);
		rightHindFoot.mirror = true;
		rightHindFoot.addBox("rightHindFoot", -2.5F, 0F, -4F, 5, 2, 7);
		rightHindLeg.addChild(rightHindFoot);
		rightHindThigh.addChild(rightHindLeg);
		LowerBody.addChild(rightHindThigh);
		body.addChild(LowerBody);
		upperBody = new AdvancedModelRenderer(this, "upperBody");
		upperBody.setRotationPoint(0F, 1F, 0F);
		setRotateAngle(upperBody, 0F, 0F, 0F);
		upperBody.mirror = true;
		upperBody.addBox("upperBody", -8.5F, 0F, -12F, 17, 11, 12);
		neck = new AdvancedModelRenderer(this, "neck");
		neck.setRotationPoint(0F, 1F, -12F);
		setRotateAngle(neck, 0F, 0F, 0F);
		neck.mirror = true;
		neck.addBox("neck", -6.5F, 0F, -8F, 13, 9, 8);
		head = new AdvancedModelRenderer(this, "head");
		head.setRotationPoint(0F, 1F, -7F);
		setRotateAngle(head, 0F, 0F, 0F);
		head.mirror = true;
		head.addBox("head", -8F, -3.5F, -9F, 16, 7, 9);
		bottomJawBase = new AdvancedModelRenderer(this, "bottomJawBase");
		bottomJawBase.setRotationPoint(-0.5F, 3.5F, -1F);
		setRotateAngle(bottomJawBase, 0F, 0F, 0F);
		bottomJawBase.mirror = true;
		bottomJawBase.addBox("bottomJaw", -6F, 0F, -8F, 13, 4, 8);
		bottomJaw = new AdvancedModelRenderer(this, "bottomJaw");
		bottomJaw.setRotationPoint(1F, 1F, -8F);
		setRotateAngle(bottomJaw, 0F, 0F, 0F);
		bottomJaw.mirror = true;
		bottomJaw.addBox("lowerJaw", -4F, 0F, -21F, 7, 3, 21);
		bottomJawBase.addChild(bottomJaw);
		head.addChild(bottomJawBase);
		upperJaw = new AdvancedModelRenderer(this, "upperJaw");
		upperJaw.setRotationPoint(0F, -0.5F, -9F);
		setRotateAngle(upperJaw, 0F, 0F, 0F);
		upperJaw.mirror = true;
		upperJaw.addBox("upperJaw", -3.5F, 0F, -18F, 7, 5, 18);
		teeth = new AdvancedModelRenderer(this, "teeth");
		teeth.setRotationPoint(0F, 4F, 1F);
		setRotateAngle(teeth, 0F, 0F, 0F);
		teeth.mirror = true;
		teeth.addBox("teeth", -4F, 0F, -24F, 8, 4, 24);
		upperJaw.addChild(teeth);
		snout = new AdvancedModelRenderer(this, "snout");
		snout.setRotationPoint(0F, -1F, -17.5F);
		setRotateAngle(snout, 0F, 0F, 0F);
		snout.mirror = true;
		snout.addBox("snout", -5.5F, -1.5F, -6F, 11, 7, 6);
		upperJaw.addChild(snout);
		head.addChild(upperJaw);
		neck.addChild(head);
		upperBody.addChild(neck);
		leftFrontThigh = new AdvancedModelRenderer(this, "leftFrontThigh");
		leftFrontThigh.setRotationPoint(8F, 2F, 0F);
		setRotateAngle(leftFrontThigh, 0F, 0F, 0F);
		leftFrontThigh.mirror = true;
		leftFrontThigh.addBox("leftFrontThigh", 0F, 0F, -3.5F, 6, 5, 7);
		leftFrontLeg = new AdvancedModelRenderer(this, "leftFrontLeg");
		leftFrontLeg.setRotationPoint(5.1F, 4.1F, 1.6F);
		setRotateAngle(leftFrontLeg, 0F, 0F, 0F);
		leftFrontLeg.mirror = false;
		leftFrontLeg.addBox("leftFrontLeg", -2F, 0F, -2.5F, 4, 7, 5);
		leftFrontFoot = new AdvancedModelRenderer(this, "leftFrontFoot");
		leftFrontFoot.setRotationPoint(0F, 5.1F, -2F);
		setRotateAngle(leftFrontFoot, 0F, 0F, 0F);
		leftFrontFoot.mirror = false;
		leftFrontFoot.addBox("leftFrontFoot", -2.5F, 0F, -4F, 5, 2, 7);
		leftFrontLeg.addChild(leftFrontFoot);
		leftFrontThigh.addChild(leftFrontLeg);
		upperBody.addChild(leftFrontThigh);
		rightFrontThigh = new AdvancedModelRenderer(this, "rightFrontThigh");
		rightFrontThigh.setRotationPoint(-8F, 2F, 0F);
		setRotateAngle(rightFrontThigh, 0F, 0F, 0F);
		rightFrontThigh.mirror = true;
		rightFrontThigh.mirror = true;
		rightFrontThigh.addBox("rightFrontThigh", -6F, 0F, -3.5F, 6, 5, 7);
		rightFrontThigh.mirror = false;
		rightFrontLeg = new AdvancedModelRenderer(this, "rightFrontLeg");
		rightFrontLeg.setRotationPoint(-5.1F, 4.1F, 1.6F);
		setRotateAngle(rightFrontLeg, 0F, 0F, 0F);
		rightFrontLeg.mirror = true;
		rightFrontLeg.mirror = true;
		rightFrontLeg.addBox("rightFrontLeg", -2F, 0F, -2.5F, 4, 7, 5);
		rightFrontLeg.mirror = true;
		rightFrontFoot = new AdvancedModelRenderer(this, "rightFrontFoot");
		rightFrontFoot.setRotationPoint(0F, 5.1F, -2F);
		setRotateAngle(rightFrontFoot, 0F, 0F, 0F);
		rightFrontFoot.mirror = true;
		rightFrontFoot.mirror = true;
		rightFrontFoot.addBox("rightFrontFoot", -2.5F, 0F, -4F, 5, 2, 7);
		rightFrontFoot.mirror = false;
		rightFrontLeg.addChild(rightFrontFoot);
		rightFrontThigh.addChild(rightFrontLeg);
		upperBody.addChild(rightFrontThigh);
		rightUpperBodyOsteoderms = new AdvancedModelRenderer(this, "rightUpperBodyOsteoderms");
		rightUpperBodyOsteoderms.setRotationPoint(-5F, 4F, -17F);
		setRotateAngle(rightUpperBodyOsteoderms, 0F, 0F, 0F);
		rightUpperBodyOsteoderms.mirror = true;
		rightUpperBodyOsteoderms.addBox("rightUpperBodyOsteoderms", 0F, -5F, 0F, 1, 5, 17);
		upperBody.addChild(rightUpperBodyOsteoderms);
		leftUpperBodyOsteoderms = new AdvancedModelRenderer(this, "leftUpperBodyOsteoderms");
		leftUpperBodyOsteoderms.setRotationPoint(5F, 4F, -18F);
		setRotateAngle(leftUpperBodyOsteoderms, 0F, 0F, 0F);
		leftUpperBodyOsteoderms.mirror = true;
		leftUpperBodyOsteoderms.addBox("leftUpperBodyOsteoderms", 0F, -5F, 0F, 1, 5, 17);
		upperBody.addChild(leftUpperBodyOsteoderms);
		middleUpperBodyOsteoderms = new AdvancedModelRenderer(this, "middleUpperBodyOsteoderms");
		middleUpperBodyOsteoderms.setRotationPoint(0F, 3F, -17F);
		setRotateAngle(middleUpperBodyOsteoderms, 0F, 0F, 0F);
		middleUpperBodyOsteoderms.mirror = true;
		middleUpperBodyOsteoderms.addBox("middleUpperBodyOsteoderms", 0F, -5F, 0F, 1, 5, 17);
		upperBody.addChild(middleUpperBodyOsteoderms);
		body.addChild(upperBody);
		middleBodyOsteoderms = new AdvancedModelRenderer(this, "middleBodyOsteoderms");
		middleBodyOsteoderms.setRotationPoint(0F, 3F, -2F);
		setRotateAngle(middleBodyOsteoderms, 0F, 0F, 0F);
		middleBodyOsteoderms.mirror = true;
		middleBodyOsteoderms.addBox("middleBodyOsteoderms", 0F, -5F, 0F, 1, 5, 24);
		body.addChild(middleBodyOsteoderms);
		rightBodyOsteoderms = new AdvancedModelRenderer(this, "rightBodyOsteoderms");
		rightBodyOsteoderms.setRotationPoint(-5F, 4F, -2F);
		setRotateAngle(rightBodyOsteoderms, 0F, 0F, 0F);
		rightBodyOsteoderms.mirror = true;
		rightBodyOsteoderms.addBox("rightBodyOsteoderms", 0F, -5F, 0F, 1, 5, 24);
		body.addChild(rightBodyOsteoderms);
		leftBodyOsteoderms = new AdvancedModelRenderer(this, "leftBodyOsteoderms");
		leftBodyOsteoderms.setRotationPoint(5F, 4F, -2F);
		setRotateAngle(leftBodyOsteoderms, 0F, 0F, 0F);
		leftBodyOsteoderms.mirror = true;
		leftBodyOsteoderms.addBox("leftBodyOsteoderms", 0F, -5F, 0F, 1, 5, 24);
		body.addChild(leftBodyOsteoderms);
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

	/*
	 * public void setRotationAngles(float f, float f1, float f2, float f3,
	 * float f4, float f5, Entity entity) { this.LowerBody.rotateAngleY = 0.1F *
	 * MathHelper.cos((f * (float) 0.4F) + f1 + 3); this.tail1.rotateAngleY =
	 * 0.2F * MathHelper.cos((f * (float) 0.4F) + f1 + 2);
	 * this.tail2.rotateAngleY = 0.3F * MathHelper.cos((f * (float) 0.4F) + f1 +
	 * 1); this.tail3.rotateAngleY = 0.4F * MathHelper.cos(f * (float) 0.4F +
	 * f1); this.LowerBody.rotateAngleX = 0; this.tail1.rotateAngleX = 0;
	 * this.tail2.rotateAngleX = 0; this.rightHindThigh.rotateAngleX =
	 * MathHelper.cos(f * 0.6662F) * 1.4F * f1; this.leftHindThigh.rotateAngleX
	 * = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
	 * this.rightFrontThigh.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)
	 * Math.PI) * 1.4F * f1; this.leftFrontThigh.rotateAngleX = MathHelper.cos(f
	 * * 0.6662F) * 1.4F * f1; this.neck.rotateAngleY = (f3 / (180F / (float)
	 * Math.PI)) / 10; this.head.rotateAngleY = (f3 / (180F / (float) Math.PI))
	 * / 3; this.head.rotateAngleX = (f4 / (180F / (float) Math.PI)) / 12; if
	 * (entity instanceof EntitySarcosuchus) { EntitySarcosuchus sarco =
	 * (EntitySarcosuchus) entity; /**needs a swimming posture
	 */
	/*
	 * if(sarco.isInWater()){ this.rightFrontLeg.rotateAngleX =
	 * 0.16285443490198599F; this.rightFrontLeg.rotateAngleY =
	 * 0.23794311222455211F; this.rightFrontFoot.rotateAngleX =
	 * 0.99483767363676789F; this.rightFrontFoot.rotateAngleY =
	 * 0.5235977559829882F; this.rightFrontFoot.rotateAngleZ =
	 * 1.5707963297948966F;
	 * 
	 * this.leftFrontLeg.rotateAngleX = 0.16285443490198599F;
	 * this.leftFrontLeg.rotateAngleY = -0.23794311222455211F;
	 * this.rightFrontFoot.rotateAngleX = 0.99483767363676789F;
	 * this.rightFrontFoot.rotateAngleY = -0.5235977559829882F;
	 * this.rightFrontFoot.rotateAngleZ = -1.5707963297948966F;
	 * 
	 * this.rightHindLeg.rotateAngleX = 0.16285443490198599F;
	 * this.rightHindLeg.rotateAngleY = 0.23794311222455211F;
	 * this.rightHindLeg.rotateAngleX = 0.99483767363676789F;
	 * this.rightHindLeg.rotateAngleY = 0.5235977559829882F;
	 * this.rightHindLeg.rotateAngleZ = 1.5707963297948966F;
	 * 
	 * this.leftHindLeg.rotateAngleX = 0.16285443490198599F;
	 * this.leftHindLeg.rotateAngleY = -0.23794311222455211F;
	 * this.leftHindLeg.rotateAngleX = 0.99483767363676789F;
	 * this.leftHindLeg.rotateAngleY = -0.5235977559829882F;
	 * this.leftHindLeg.rotateAngleZ = -1.5707963297948966F; }
	 */
}
