package mods.fossil.client.model;

import mods.fossil.entity.mob.EntityDinosaur;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * Dilophosaurus_Remodel_Pivots.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelDilophosaurus extends ModelDinosaurs {
	public ModelRenderer lowerBody;
	public ModelRenderer rightThigh;
	public ModelRenderer leftThigh;
	public ModelRenderer tail1;
	public ModelRenderer upperBody;
	public ModelRenderer tail2;
	public ModelRenderer tail3;
	public ModelRenderer rightUpperArm;
	public ModelRenderer leftUpperArm;
	public ModelRenderer neck;
	public ModelRenderer rightLowerArm;
	public ModelRenderer leftLowerArm;
	public ModelRenderer headPivot;
	public ModelRenderer head;
	public ModelRenderer leftCrest;
	public ModelRenderer rightCrest;
	public ModelRenderer upperJaw;
	public ModelRenderer lowerJaw;
	public ModelRenderer rightLeg;
	public ModelRenderer rightFoot;
	public ModelRenderer leftLeg;
	public ModelRenderer leftFoot;

	public ModelDilophosaurus() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.lowerJaw = new ModelRenderer(this, 1, 10);
		this.lowerJaw.setRotationPoint(0.0F, 1.7F, -4.3F);
		this.lowerJaw.addBox(-1.5F, 0.0F, -7.0F, 3, 1, 7, 0.0F);
		this.setRotateAngle(lowerJaw, 0.004537856055185257F, -0.0F, 0.0F);
		this.leftCrest = new ModelRenderer(this, 18, 11);
		this.leftCrest.setRotationPoint(1.5F, -2.3F, -5.6F);
		this.leftCrest.addBox(0.0F, -4.0F, -5.0F, 0, 4, 10, 0.0F);
		this.setRotateAngle(leftCrest, 0.008028514559173916F, -0.0F, 0.0F);
		this.rightLeg = new ModelRenderer(this, 24, 12);
		this.rightLeg.mirror = true;
		this.rightLeg.setRotationPoint(-1.5F, 3.5F, 2.5F);
		this.rightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(rightLeg, -0.2617993877991494F, -0.0F, 0.0F);
		this.lowerBody = new ModelRenderer(this, 67, 13);
		this.lowerBody.mirror = true;
		this.lowerBody.setRotationPoint(0.0F, 11.5F, -1.0F);
		this.lowerBody.addBox(-4.0F, -3.0F, 0.0F, 8, 7, 8, 0.0F);
		this.rightUpperArm = new ModelRenderer(this, 14, 10);
		this.rightUpperArm.setRotationPoint(-3.0F, 0.0F, -5.0F);
		this.rightUpperArm.addBox(-2.0F, 0.0F, -1.5F, 2, 3, 3, 0.0F);
		this.tail2 = new ModelRenderer(this, 93, 31);
		this.tail2.mirror = true;
		this.tail2.setRotationPoint(0.0F, 0.2F, 5.99F);
		this.tail2.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 6, 0.0F);
		this.setRotateAngle(tail2, 0.0022689280275926286F, -0.0F, 0.0F);
		this.leftLeg = new ModelRenderer(this, 24, 12);
		this.leftLeg.setRotationPoint(1.5F, 3.5F, 2.5F);
		this.leftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(leftLeg, -0.2617993877991494F, -0.0F, 0.0F);
		this.neck = new ModelRenderer(this, 42, 21);
		this.neck.mirror = true;
		this.neck.setRotationPoint(0.0F, 0.4F, -5.3F);
		this.neck.addBox(-2.0F, -2.0F, -7.0F, 4, 4, 7, 0.0F);
		this.setRotateAngle(neck, -0.3361504139341079F, -0.0F, 0.0F);
		this.tail3 = new ModelRenderer(this, 100, 15);
		this.tail3.mirror = true;
		this.tail3.setRotationPoint(0.0F, 0.5F, 6.0F);
		this.tail3.addBox(-1.0F, -0.2F, -0.2F, 2, 2, 12, 0.0F);
		this.setRotateAngle(tail3, 0.017453292519943295F, -0.0F, 0.0F);
		this.leftThigh = new ModelRenderer(this, 24, 0);
		this.leftThigh.mirror = true;
		this.leftThigh.setRotationPoint(3.5F, 12.5F, 3.5F);
		this.leftThigh.addBox(0.0F, -1.0F, -2.5F, 3, 6, 5, 0.0F);
		this.leftLowerArm = new ModelRenderer(this, 0, 10);
		this.leftLowerArm.mirror = true;
		this.leftLowerArm.setRotationPoint(1.0F, 2.0F, 0.5F);
		this.leftLowerArm.addBox(-1.1F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(leftLowerArm, -0.2617993877991494F, -0.0F, 0.0F);
		this.rightFoot = new ModelRenderer(this, 35, 21);
		this.rightFoot.mirror = true;
		this.rightFoot.setRotationPoint(0.0F, 6.1F, 0.5F);
		this.rightFoot.addBox(-1.5F, 0.0F, -3.0F, 3, 2, 4, 0.0F);
		this.setRotateAngle(rightFoot, 0.2617993877991494F, -0.0F, 0.0F);
		this.tail1 = new ModelRenderer(this, 92, 0);
		this.tail1.setRotationPoint(0.0F, -2.9F, 7.0F);
		this.tail1.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 6, 0.0F);
		this.setRotateAngle(tail1, -0.017453292519943295F, -0.0F, 0.0F);
		this.rightThigh = new ModelRenderer(this, 24, 0);
		this.rightThigh.setRotationPoint(-3.5F, 12.5F, 3.5F);
		this.rightThigh.addBox(-3.0F, -1.0F, -2.5F, 3, 6, 5, 0.0F);
		this.upperBody = new ModelRenderer(this, 66, 0);
		this.upperBody.mirror = true;
		this.upperBody.setRotationPoint(0.0F, -0.9F, 0.5F);
		this.upperBody.addBox(-3.0F, -2.0F, -6.0F, 6, 6, 6, 0.0F);
		this.setRotateAngle(upperBody, 0.011344640137963142F, -0.0F, 0.0F);
		this.rightCrest = new ModelRenderer(this, 18, 11);
		this.rightCrest.setRotationPoint(-1.5F, -2.3F, -5.6F);
		this.rightCrest.addBox(0.0F, -4.0F, -5.0F, 0, 4, 10, 0.0F);
		this.setRotateAngle(rightCrest, 0.008028514559173916F, -0.0F, 0.0F);
		headPivot = new ModelRenderer(this, 17, 41);
		headPivot.setRotationPoint(0.0F, -0.6F, -6.4F);
		headPivot.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		setRotateAngle(headPivot, 0.3885102914939378F, 0F, 0F);
		this.head = new ModelRenderer(this, 0, 20);
		this.head.addBox(-3.0F, -3.0F, -6.0F, 6, 6, 6);
		this.head.setRotationPoint(0.0F, 0F, 0F);
		this.setRotateAngle(head, 0, -0.0F, 0.0F);
		this.upperJaw = new ModelRenderer(this, 0, 0);
		this.upperJaw.setRotationPoint(0.0F, -0.3F, -5.8F);
		this.upperJaw.addBox(-2.0F, -2.0F, -6.0F, 4, 4, 6, 0.0F);
		this.setRotateAngle(upperJaw, 0.007330382858376183F, -0.0F, 0.0F);
		this.rightLowerArm = new ModelRenderer(this, 0, 10);
		this.rightLowerArm.setRotationPoint(-1.0F, 2.0F, 0.5F);
		this.rightLowerArm.addBox(-0.9F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(rightLowerArm, -0.2617993877991494F, 0.0F, 0.0F);
		this.leftUpperArm = new ModelRenderer(this, 14, 10);
		this.leftUpperArm.setRotationPoint(3.0F, 0.0F, -5.0F);
		this.leftUpperArm.addBox(0.0F, 0.0F, -1.5F, 2, 3, 3, 0.0F);
		this.leftFoot = new ModelRenderer(this, 35, 21);
		this.leftFoot.setRotationPoint(0.0F, 6.1F, 0.5F);
		this.leftFoot.addBox(-1.5F, 0.0F, -3.0F, 3, 2, 4, 0.0F);
		this.setRotateAngle(leftFoot, 0.2617993877991494F, -0.0F, 0.0F);
		this.head.addChild(this.lowerJaw);
		this.head.addChild(this.leftCrest);
		this.rightThigh.addChild(this.rightLeg);
		this.upperBody.addChild(this.rightUpperArm);
		this.tail1.addChild(this.tail2);
		this.leftThigh.addChild(this.leftLeg);
		this.upperBody.addChild(this.neck);
		this.tail2.addChild(this.tail3);
		this.leftUpperArm.addChild(this.leftLowerArm);
		this.rightLeg.addChild(this.rightFoot);
		this.lowerBody.addChild(this.tail1);
		this.lowerBody.addChild(this.upperBody);
		this.head.addChild(this.rightCrest);
		this.neck.addChild(this.headPivot);
		this.headPivot.addChild(this.head);
		this.head.addChild(this.upperJaw);
		this.rightUpperArm.addChild(this.rightLowerArm);
		this.upperBody.addChild(this.leftUpperArm);
		this.leftLeg.addChild(this.leftFoot);
	}

	public void render(Entity f, float f1, float f2, float f3, float f4, float f5, float f6)
	{
		super.render(f, f1, f2, f3, f4, f5, f6);
		this.setRotationAngles(f1, f2, f3, f4, f5, f6, ((EntityDinosaur)f).isModelized());
		this.lowerBody.render(f6);
		this.leftThigh.render(f6);
		this.rightThigh.render(f6);
	}
	public void renderFollower(float f6){
		this.lowerBody.render(f6);
		this.leftThigh.render(f6);
		this.rightThigh.render(f6);
	}
	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	protected void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, boolean f6) {
		if(!f6){
			this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
			this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
			this.tail1.rotateAngleY = 0.1F * MathHelper.sin(f2 * (float)0.1F + (f1+2));
			this.tail2.rotateAngleY = 0.06F * MathHelper.sin(f2 * (float)0.1F + (f1+2));
			this.tail3.rotateAngleY = 0.06F * MathHelper.sin(f2 * (float)0.1F + (f1+2));
			this.rightThigh.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
			this.leftThigh.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		}else{

			this.neck.rotateAngleY = 0;
			this.tail1.rotateAngleY = 0;
			this.tail2.rotateAngleY = 0;
			this.tail3.rotateAngleY = 0;
			this.rightThigh.rotateAngleX = 0;
			this.leftThigh.rotateAngleX = 0;
		}

	}
}
