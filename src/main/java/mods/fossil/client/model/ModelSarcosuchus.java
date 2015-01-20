package mods.fossil.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSarcosuchus extends ModelDinosaurs {
	ModelRenderer body;
	ModelRenderer LowerBody;
	ModelRenderer leftHindLeg;
	ModelRenderer leftHindThigh;
	ModelRenderer leftHindFoot;
	ModelRenderer rightLowerBodyOsteoderms;
	ModelRenderer leftLowerBodyOsteoderms;
	ModelRenderer middleLowerBodyOsteoderms;
	ModelRenderer tail1;
	ModelRenderer bottomJawBase;
	ModelRenderer tail2;
	ModelRenderer tail2Osteoderms;
	ModelRenderer tail3;
	ModelRenderer tail3Osteoderms;
	ModelRenderer tail1Osteoderms;
	ModelRenderer rightHindThigh;
	ModelRenderer rightHindFoot;
	ModelRenderer rightHindLeg;
	ModelRenderer upperBody;
	ModelRenderer neck;
	ModelRenderer head;
	ModelRenderer bottomJaw;
	ModelRenderer lowerJaw;
	ModelRenderer upperJaw;
	ModelRenderer teeth;
	ModelRenderer snout;
	ModelRenderer leftFrontThigh;
	ModelRenderer leftFrontLeg;
	ModelRenderer leftFrontFoot;
	ModelRenderer rightFrontThigh;
	ModelRenderer rightFrontLeg;
	ModelRenderer rightFrontFoot;
	ModelRenderer middleBodyOsteoderms;
	ModelRenderer middleUpperBodyOsteoderms;
	ModelRenderer leftUpperBodyOsteoderms;
	ModelRenderer rightUpperBodyOsteoderms;
	ModelRenderer rightBodyOsteoderms;
	ModelRenderer leftBodyOsteoderms;

	public ModelSarcosuchus() {
		textureWidth = 256;
		textureHeight = 128;
		setTextureOffset("body.body", 61, 92);
		setTextureOffset("LowerBody.lowerBody", 1, 81);
		setTextureOffset("leftHindThigh.leftHindThigh", 174, 25);
		setTextureOffset("leftHindLeg.leftHindLeg", 209, 25);
		setTextureOffset("leftHindFoot.leftHindFoot", 210, 39);
		setTextureOffset("rightLowerBodyOsteoderms.rightLowerBodyOsteoderms",
				128, 38);
		setTextureOffset("leftLowerBodyOsteoderms.leftLowerBodyOsteoderms",
				128, 38);
		setTextureOffset("middleLowerBodyOsteoderms.middleLowerBodyOsteoderms",
				128, 38);
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
		setTextureOffset("rightUpperBodyOsteoderms.rightUpperBodyOsteoderms",
				124, 30);
		setTextureOffset("leftUpperBodyOsteoderms.leftUpperBodyOsteoderms",
				124, 30);
		setTextureOffset("middleUpperBodyOsteoderms.middleUpperBodyOsteoderms",
				124, 30);
		setTextureOffset("middleBodyOsteoderms.middleBodyOsteoderms", 117, 23);
		setTextureOffset("rightBodyOsteoderms.rightBodyOsteoderms", 117, 23);
		setTextureOffset("leftBodyOsteoderms.leftBodyOsteoderms", 117, 23);

		body = new ModelRenderer(this, "body");
		body.setRotationPoint(0F, 10F, 13F);
		setRotation(body, 0F, 0F, 0F);
		body.mirror = true;
		body.addBox("body", -9F, 0F, 0F, 18, 13, 21);
		LowerBody = new ModelRenderer(this, "LowerBody");
		LowerBody.setRotationPoint(0F, 1F, 19F);
		setRotation(LowerBody, 0F, 0F, 0F);
		LowerBody.mirror = true;
		LowerBody.addBox("lowerBody", -8.5F, 0F, 0F, 17, 11, 11);
		leftHindThigh = new ModelRenderer(this, "leftHindThigh");
		leftHindThigh.setRotationPoint(8F, 2F, 3.48F);
		setRotation(leftHindThigh, 0F, 0F, 0F);
		leftHindThigh.mirror = true;
		leftHindThigh.addBox("leftHindThigh", 0F, 0F, -3.5F, 6, 5, 7);
		leftHindLeg = new ModelRenderer(this, "leftHindLeg");
		leftHindLeg.setRotationPoint(5.1F, 4.1F, 1.6F);
		setRotation(leftHindLeg, 0F, 0F, 0F);
		leftHindLeg.mirror = true;
		leftHindLeg.addBox("leftHindLeg", -2F, 0F, -2.5F, 4, 7, 5);
		leftHindFoot = new ModelRenderer(this, "leftHindFoot");
		leftHindFoot.setRotationPoint(0F, 5.1F, -2F);
		setRotation(leftHindFoot, 0F, 0F, 0F);
		leftHindFoot.mirror = true;
		leftHindFoot.addBox("leftHindFoot", -2.5F, 0F, -4F, 5, 2, 7);
		leftHindLeg.addChild(leftHindFoot);
		leftHindThigh.addChild(leftHindLeg);
		LowerBody.addChild(leftHindThigh);
		rightLowerBodyOsteoderms = new ModelRenderer(this,
				"rightLowerBodyOsteoderms");
		rightLowerBodyOsteoderms.setRotationPoint(-5F, 4F, 5F);
		setRotation(rightLowerBodyOsteoderms, 0F, 0F, 0F);
		rightLowerBodyOsteoderms.mirror = true;
		rightLowerBodyOsteoderms.addBox("rightLowerBodyOsteoderms", 0F, -5F,
				0F, 1, 5, 9);
		LowerBody.addChild(rightLowerBodyOsteoderms);
		leftLowerBodyOsteoderms = new ModelRenderer(this,
				"leftLowerBodyOsteoderms");
		leftLowerBodyOsteoderms.setRotationPoint(5F, 4F, 5F);
		setRotation(leftLowerBodyOsteoderms, 0F, 0F, 0F);
		leftLowerBodyOsteoderms.mirror = true;
		leftLowerBodyOsteoderms.addBox("leftLowerBodyOsteoderms", 0F, -5F, 0F,
				1, 5, 9);
		LowerBody.addChild(leftLowerBodyOsteoderms);
		middleLowerBodyOsteoderms = new ModelRenderer(this,
				"middleLowerBodyOsteoderms");
		middleLowerBodyOsteoderms.setRotationPoint(0F, 4F, 5F);
		setRotation(middleLowerBodyOsteoderms, 0F, 0F, 0F);
		middleLowerBodyOsteoderms.mirror = true;
		middleLowerBodyOsteoderms.addBox("middleLowerBodyOsteoderms", 0F, -5F,
				0F, 1, 5, 9);
		LowerBody.addChild(middleLowerBodyOsteoderms);
		tail1 = new ModelRenderer(this, "tail1");
		tail1.setRotationPoint(0F, 2.5F, 11F);
		setRotation(tail1, 0F, 0F, 0F);
		tail1.mirror = true;
		tail1.addBox("tail1", -7F, 0F, 0F, 14, 8, 18);
		tail2 = new ModelRenderer(this, "tail2");
		tail2.setRotationPoint(0F, 0F, 18F);
		setRotation(tail2, 0F, 0F, 0F);
		tail2.mirror = true;
		tail2.addBox("tail2", -5F, 1F, 0F, 10, 7, 24);
		tail2Osteoderms = new ModelRenderer(this, "tail2Osteoderms");
		tail2Osteoderms.setRotationPoint(0F, 1F, 3F);
		setRotation(tail2Osteoderms, 0F, 0F, 0F);
		tail2Osteoderms.mirror = true;
		tail2Osteoderms.addBox("tail2Osteoderms", 0F, -5F, 0F, 1, 5, 20);
		tail2.addChild(tail2Osteoderms);
		tail3 = new ModelRenderer(this, "tail3");
		tail3.setRotationPoint(0F, 3F, 24F);
		setRotation(tail3, 0F, 0F, 0F);
		tail3.mirror = true;
		tail3.addBox("tail3", -4F, 0F, 0F, 8, 5, 27);
		tail3Osteoderms = new ModelRenderer(this, "tail3Osteoderms");
		tail3Osteoderms.setRotationPoint(0F, 1F, 0F);
		setRotation(tail3Osteoderms, 0F, 0F, 0F);
		tail3Osteoderms.mirror = true;
		tail3Osteoderms.addBox("tail3Osteoderms", 0F, -5F, 0F, 1, 5, 24);
		tail3.addChild(tail3Osteoderms);
		tail2.addChild(tail3);
		tail1.addChild(tail2);
		tail1Osteoderms = new ModelRenderer(this, "tail1Osteoderms");
		tail1Osteoderms.setRotationPoint(0F, 1F, 0F);
		setRotation(tail1Osteoderms, 0F, 0F, 0F);
		tail1Osteoderms.mirror = true;
		tail1Osteoderms.addBox("tail1Osteoderms", 0F, -5F, 0F, 1, 5, 24);
		tail1.addChild(tail1Osteoderms);
		LowerBody.addChild(tail1);
		rightHindThigh = new ModelRenderer(this, "rightHindThigh");
		rightHindThigh.setRotationPoint(-8F, 2F, 3.5F);
		setRotation(rightHindThigh, 0F, 0F, 0F);
		rightHindThigh.mirror = true;
		rightHindThigh.mirror = true;
		rightHindThigh.addBox("rightHindThigh", -6F, 0F, -3.5F, 6, 5, 7);
		rightHindThigh.mirror = false;
		rightHindLeg = new ModelRenderer(this, "rightHindLeg");
		rightHindLeg.setRotationPoint(-5.1F, 4.1F, 1.6F);
		setRotation(rightHindLeg, 0F, 0F, 0F);
		rightHindLeg.mirror = true;
		rightHindLeg.mirror = true;
		rightHindLeg.addBox("rightHindLeg", -2F, 0F, -2.5F, 4, 7, 5);
		rightHindLeg.mirror = false;
		rightHindFoot = new ModelRenderer(this, "rightHindFoot");
		rightHindFoot.setRotationPoint(0F, 5.1F, -2F);
		setRotation(rightHindFoot, 0F, 0F, 0F);
		rightHindFoot.mirror = true;
		rightHindFoot.addBox("rightHindFoot", -2.5F, 0F, -4F, 5, 2, 7);
		rightHindLeg.addChild(rightHindFoot);
		rightHindThigh.addChild(rightHindLeg);
		LowerBody.addChild(rightHindThigh);
		body.addChild(LowerBody);
		upperBody = new ModelRenderer(this, "upperBody");
		upperBody.setRotationPoint(0F, 1F, 0F);
		setRotation(upperBody, 0F, 0F, 0F);
		upperBody.mirror = true;
		upperBody.addBox("upperBody", -8.5F, 0F, -12F, 17, 11, 12);
		neck = new ModelRenderer(this, "neck");
		neck.setRotationPoint(0F, 1F, -12F);
		setRotation(neck, 0F, 0F, 0F);
		neck.mirror = true;
		neck.addBox("neck", -6.5F, 0F, -8F, 13, 9, 8);
		head = new ModelRenderer(this, "head");
		head.setRotationPoint(0F, 1F, -7F);
		setRotation(head, 0F, 0F, 0F);
		head.mirror = true;
		head.addBox("head", -8F, -3.5F, -9F, 16, 7, 9);
		bottomJawBase = new ModelRenderer(this, "bottomJawBase");
		bottomJawBase.setRotationPoint(-0.5F, 3.5F, -1F);
		setRotation(bottomJawBase, 0F, 0F, 0F);
		bottomJawBase.mirror = true;
		bottomJawBase.addBox("bottomJaw", -6F, 0F, -8F, 13, 4, 8);
		bottomJaw = new ModelRenderer(this, "bottomJaw");
		bottomJaw.setRotationPoint(1F, 1F, -8F);
		setRotation(bottomJaw, 0F, 0F, 0F);
		bottomJaw.mirror = true;
		bottomJaw.addBox("lowerJaw", -4F, 0F, -21F, 7, 3, 21);
		bottomJawBase.addChild(bottomJaw);
		head.addChild(bottomJawBase);
		upperJaw = new ModelRenderer(this, "upperJaw");
		upperJaw.setRotationPoint(0F, -0.5F, -9F);
		setRotation(upperJaw, 0F, 0F, 0F);
		upperJaw.mirror = true;
		upperJaw.addBox("upperJaw", -3.5F, 0F, -18F, 7, 5, 18);
		teeth = new ModelRenderer(this, "teeth");
		teeth.setRotationPoint(0F, 4F, 1F);
		setRotation(teeth, 0F, 0F, 0F);
		teeth.mirror = true;
		teeth.addBox("teeth", -4F, 0F, -24F, 8, 4, 24);
		upperJaw.addChild(teeth);
		snout = new ModelRenderer(this, "snout");
		snout.setRotationPoint(0F, -1F, -17.5F);
		setRotation(snout, 0F, 0F, 0F);
		snout.mirror = true;
		snout.addBox("snout", -5.5F, -1.5F, -6F, 11, 7, 6);
		upperJaw.addChild(snout);
		head.addChild(upperJaw);
		neck.addChild(head);
		upperBody.addChild(neck);
		leftFrontThigh = new ModelRenderer(this, "leftFrontThigh");
		leftFrontThigh.setRotationPoint(8F, 2F, 0F);
		setRotation(leftFrontThigh, 0F, 0F, 0F);
		leftFrontThigh.mirror = true;
		leftFrontThigh.addBox("leftFrontThigh", 0F, 0F, -3.5F, 6, 5, 7);
		leftFrontLeg = new ModelRenderer(this, "leftFrontLeg");
		leftFrontLeg.setRotationPoint(5.1F, 4.1F, 1.6F);
		setRotation(leftFrontLeg, 0F, 0F, 0F);
		leftFrontLeg.mirror = true;
		leftFrontLeg.addBox("leftFrontLeg", -2F, 0F, -2.5F, 4, 7, 5);
		leftFrontFoot = new ModelRenderer(this, "leftFrontFoot");
		leftFrontFoot.setRotationPoint(0F, 5.1F, -2F);
		setRotation(leftFrontFoot, 0F, 0F, 0F);
		leftFrontFoot.mirror = true;
		leftFrontFoot.addBox("leftFrontFoot", -2.5F, 0F, -4F, 5, 2, 7);
		leftFrontLeg.addChild(leftFrontFoot);
		leftFrontThigh.addChild(leftFrontLeg);
		upperBody.addChild(leftFrontThigh);
		rightFrontThigh = new ModelRenderer(this, "rightFrontThigh");
		rightFrontThigh.setRotationPoint(-8F, 2F, 0F);
		setRotation(rightFrontThigh, 0F, 0F, 0F);
		rightFrontThigh.mirror = true;
		rightFrontThigh.mirror = true;
		rightFrontThigh.addBox("rightFrontThigh", -6F, 0F, -3.5F, 6, 5, 7);
		rightFrontThigh.mirror = false;
		rightFrontLeg = new ModelRenderer(this, "rightFrontLeg");
		rightFrontLeg.setRotationPoint(-5.1F, 4.1F, 1.6F);
		setRotation(rightFrontLeg, 0F, 0F, 0F);
		rightFrontLeg.mirror = true;
		rightFrontLeg.mirror = true;
		rightFrontLeg.addBox("rightFrontLeg", -2F, 0F, -2.5F, 4, 7, 5);
		rightFrontLeg.mirror = false;
		rightFrontFoot = new ModelRenderer(this, "rightFrontFoot");
		rightFrontFoot.setRotationPoint(0F, 5.1F, -2F);
		setRotation(rightFrontFoot, 0F, 0F, 0F);
		rightFrontFoot.mirror = true;
		rightFrontFoot.mirror = true;
		rightFrontFoot.addBox("rightFrontFoot", -2.5F, 0F, -4F, 5, 2, 7);
		rightFrontFoot.mirror = false;
		rightFrontLeg.addChild(rightFrontFoot);
		rightFrontThigh.addChild(rightFrontLeg);
		upperBody.addChild(rightFrontThigh);
		rightUpperBodyOsteoderms = new ModelRenderer(this,
				"rightUpperBodyOsteoderms");
		rightUpperBodyOsteoderms.setRotationPoint(-5F, 4F, -17F);
		setRotation(rightUpperBodyOsteoderms, 0F, 0F, 0F);
		rightUpperBodyOsteoderms.mirror = true;
		rightUpperBodyOsteoderms.addBox("rightUpperBodyOsteoderms", 0F, -5F,
				0F, 1, 5, 17);
		upperBody.addChild(rightUpperBodyOsteoderms);
		leftUpperBodyOsteoderms = new ModelRenderer(this,
				"leftUpperBodyOsteoderms");
		leftUpperBodyOsteoderms.setRotationPoint(5F, 4F, -18F);
		setRotation(leftUpperBodyOsteoderms, 0F, 0F, 0F);
		leftUpperBodyOsteoderms.mirror = true;
		leftUpperBodyOsteoderms.addBox("leftUpperBodyOsteoderms", 0F, -5F, 0F,
				1, 5, 17);
		upperBody.addChild(leftUpperBodyOsteoderms);
		middleUpperBodyOsteoderms = new ModelRenderer(this,
				"middleUpperBodyOsteoderms");
		middleUpperBodyOsteoderms.setRotationPoint(0F, 3F, -17F);
		setRotation(middleUpperBodyOsteoderms, 0F, 0F, 0F);
		middleUpperBodyOsteoderms.mirror = true;
		middleUpperBodyOsteoderms.addBox("middleUpperBodyOsteoderms", 0F, -5F,
				0F, 1, 5, 17);
		upperBody.addChild(middleUpperBodyOsteoderms);
		body.addChild(upperBody);
		middleBodyOsteoderms = new ModelRenderer(this, "middleBodyOsteoderms");
		middleBodyOsteoderms.setRotationPoint(0F, 3F, -2F);
		setRotation(middleBodyOsteoderms, 0F, 0F, 0F);
		middleBodyOsteoderms.mirror = true;
		middleBodyOsteoderms.addBox("middleBodyOsteoderms", 0F, -5F, 0F, 1, 5,
				24);
		body.addChild(middleBodyOsteoderms);
		rightBodyOsteoderms = new ModelRenderer(this, "rightBodyOsteoderms");
		rightBodyOsteoderms.setRotationPoint(-5F, 4F, -2F);
		setRotation(rightBodyOsteoderms, 0F, 0F, 0F);
		rightBodyOsteoderms.mirror = true;
		rightBodyOsteoderms
				.addBox("rightBodyOsteoderms", 0F, -5F, 0F, 1, 5, 24);
		body.addChild(rightBodyOsteoderms);
		leftBodyOsteoderms = new ModelRenderer(this, "leftBodyOsteoderms");
		leftBodyOsteoderms.setRotationPoint(5F, 4F, -2F);
		setRotation(leftBodyOsteoderms, 0F, 0F, 0F);
		leftBodyOsteoderms.mirror = true;
		leftBodyOsteoderms.addBox("leftBodyOsteoderms", 0F, -5F, 0F, 1, 5, 24);
		body.addChild(leftBodyOsteoderms);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		body.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
	}

	@Override
	protected void setRotationAngles(float var1, float var2, float var3,
			float var4, float var5, float var6, boolean var7) {
		// TODO Auto-generated method stub

	}

}
