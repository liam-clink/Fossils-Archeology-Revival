package com.github.revival.client.model.prehistoric;

<<<<<<< HEAD
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.minecraft.entity.Entity;
=======
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;
>>>>>>> origin/master

/**
 * Velociraptor.tcn - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
<<<<<<< HEAD
public class ModelVelociraptor extends MowzieModelBase {
	public MowzieModelRenderer lowerBody;
	public MowzieModelRenderer leftThigh;
	public MowzieModelRenderer rightThigh;
	public MowzieModelRenderer upperBody;
	public MowzieModelRenderer tail1;
	public MowzieModelRenderer neck;
	public MowzieModelRenderer leftUpperArm;
	public MowzieModelRenderer rightUpperArm;
	public MowzieModelRenderer headPivot;
	public MowzieModelRenderer head;
	public MowzieModelRenderer upperJaw;
	public MowzieModelRenderer lowerJaw;
	public MowzieModelRenderer upperCrest;
	public MowzieModelRenderer lowerCrest;
	public MowzieModelRenderer leftUpperArmFeather;
	public MowzieModelRenderer leftLowerArm;
	public MowzieModelRenderer leftLowerArmFeather;
	public MowzieModelRenderer rightUpperArmFeather;
	public MowzieModelRenderer rightLowerArm;
	public MowzieModelRenderer rightLowerArmFeather;
	public MowzieModelRenderer tail2;
	public MowzieModelRenderer tailFeather4;
	public MowzieModelRenderer tail3;
	public MowzieModelRenderer rightToeClaw2;
	public MowzieModelRenderer tailFeather3;
	public MowzieModelRenderer tailFeather1;
	public MowzieModelRenderer tailFeather2;
	public MowzieModelRenderer leftLeg;
	public MowzieModelRenderer leftFoot;
	public MowzieModelRenderer leftToeClaw1;
	public MowzieModelRenderer leftToeClaw2;
	public MowzieModelRenderer rightLeg;
	public MowzieModelRenderer rightFoot;
	public MowzieModelRenderer rightToeClaw1;

	public ModelVelociraptor() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.leftUpperArm = new MowzieModelRenderer(this, 20, 13);
		this.leftUpperArm.mirror = true;
		this.leftUpperArm.setRotationPoint(3.0F, 1.9F, -4.0F);
		this.leftUpperArm.addBox(0.0F, -1.0F, -1.0F, 2, 4, 3, 0.0F);
		ModelUtils.setRotateAngle(leftUpperArm, -0.06981317007977318F, -0.0F, 0.0F);
		this.tailFeather2 = new MowzieModelRenderer(this, 44, 49);
		this.tailFeather2.setRotationPoint(0.0F, -0.2F, -1.3F);
		this.tailFeather2.addBox(-3.0F, 0.5F, 1.1F, 6, 1, 8, 0.0F);
		ModelUtils.setRotateAngle(tailFeather2, -0.004886921905584123F, -0.0F, 0.0F);
		this.tailFeather4 = new MowzieModelRenderer(this, 46, 41);
		this.tailFeather4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailFeather4.addBox(-3.5F, 1.1F, 0.0F, 7, 1, 6, 0.0F);
		this.rightUpperArmFeather = new MowzieModelRenderer(this, 34, 34);
		this.rightUpperArmFeather.setRotationPoint(-1.0F, 0.1F, 0.9F);
		this.rightUpperArmFeather.addBox(-0.6F, -0.1F, -4.7F, 1, 4, 6, 0.0F);
		ModelUtils.setRotateAngle(rightUpperArmFeather, 1.4493214108560915F, -0.0F, 0.0F);
		this.tail2 = new MowzieModelRenderer(this, 90, 13);
		this.tail2.setRotationPoint(0.0F, 0.2F, 6.7F);
		this.tail2.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 5, 0.0F);
		this.lowerCrest = new MowzieModelRenderer(this, 38, 15);
		this.lowerCrest.setRotationPoint(-0.5F, -0.7F, -1.03F);
		this.lowerCrest.addBox(-0.5F, -1.5F, 0.6F, 1, 4, 5, 0.0F);
		ModelUtils.setRotateAngle(lowerCrest, 0.13578661580515886F, 0.0F, 0.0F);
		this.rightToeClaw2 = new MowzieModelRenderer(this, 0, 40);
		this.rightToeClaw2.setRotationPoint(0.0F, 0.2F, -2.5F);
		this.rightToeClaw2.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 1, 0.0F);
		ModelUtils.setRotateAngle(rightToeClaw2, -1.7627825445142729F, -0.0F, 0.0F);
		this.lowerJaw = new MowzieModelRenderer(this, 49, 0);
		this.lowerJaw.setRotationPoint(0.0F, 0.0F, -4.53F);
		this.lowerJaw.addBox(-2.0F, -0.5F, -6.9F, 3, 1, 7, 0.0F);
		ModelUtils.setRotateAngle(lowerJaw, -0.06924167156799095F, 0.0F, 0.0F);
		this.lowerBody = new MowzieModelRenderer(this, 65, 12);
		this.lowerBody.setRotationPoint(0.0F, 9.9F, -2.5F);
		this.lowerBody.addBox(-4.0F, -1.0F, 0.0F, 8, 7, 9, 0.0F);
		ModelUtils.setRotateAngle(lowerBody, -0.15554018104602801F, 0.0F, 0.0F);
		this.rightToeClaw1 = new MowzieModelRenderer(this, 0, 40);
		this.rightToeClaw1.setRotationPoint(0.9F, 0.2F, -1.2F);
		this.rightToeClaw1.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
		ModelUtils.setRotateAngle(rightToeClaw1, -0.8726646259971648F, -0.0F, 0.0F);
		this.upperCrest = new MowzieModelRenderer(this, 38, 15);
		this.upperCrest.mirror = true;
		this.upperCrest.setRotationPoint(-0.51F, -2.5F, -2.03F);
		this.upperCrest.addBox(-0.5F, -1.5F, 0.6F, 1, 4, 5, 0.0F);
		ModelUtils.setRotateAngle(upperCrest, 0.4961971063419879F, -0.0F, 0.0F);
		this.rightLowerArmFeather = new MowzieModelRenderer(this, 34, 34);
		this.rightLowerArmFeather.setRotationPoint(0.0F, -0.2F, 1.6F);
		this.rightLowerArmFeather.addBox(-0.5F, 1.7F, -8.1F, 1, 4, 6, 0.0F);
		ModelUtils.setRotateAngle(rightLowerArmFeather, 6.981317007977319E-4F, -0.0F, 0.0F);
		this.headPivot = new MowzieModelRenderer(this, 0, 0);
		this.headPivot.setRotationPoint(0.5F, 0.8F, -6.03F);
		this.headPivot.addBox(0F, 0, 0, 0, 0, 0, 0.0F);
		ModelUtils.setRotateAngle(headPivot, 0.9955358053375656F, 0.0F, 0.0F);
		this.head = new MowzieModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0, 0, 0);
		this.head.addBox(-3.0F, -4.0F, -5.0F, 5, 5, 6, 0.0F);
		ModelUtils.setRotateAngle(head, 0F, 0.0F, 0.0F);
		this.leftFoot = new MowzieModelRenderer(this, 0, 34);
		this.leftFoot.setRotationPoint(0.2F, 0.9F, -6.3F);
		this.leftFoot.addBox(-1.5F, 0.0F, -3.1F, 3, 2, 4, 0.0F);
		ModelUtils.setRotateAngle(leftFoot, -0.9948376736367678F, -0.0F, 0.0F);
		this.leftToeClaw1 = new MowzieModelRenderer(this, 0, 40);
		this.leftToeClaw1.setRotationPoint(-0.9F, 0.2F, -1.2F);
		this.leftToeClaw1.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
		ModelUtils.setRotateAngle(leftToeClaw1, -0.8726646259971648F, -0.0F, 0.0F);
		this.rightUpperArm = new MowzieModelRenderer(this, 20, 13);
		this.rightUpperArm.setRotationPoint(-3.0F, 1.9F, -4.0F);
		this.rightUpperArm.addBox(-2.0F, -1.0F, -1.0F, 2, 4, 3, 0.0F);
		ModelUtils.setRotateAngle(rightUpperArm, -0.06981317007977318F, -0.0F, 0.0F);
		this.leftLowerArmFeather = new MowzieModelRenderer(this, 34, 34);
		this.leftLowerArmFeather.mirror = true;
		this.leftLowerArmFeather.setRotationPoint(0.0F, -0.2F, 1.6F);
		this.leftLowerArmFeather.addBox(-0.5F, 1.7F, -8.1F, 1, 4, 6, 0.0F);
		ModelUtils.setRotateAngle(leftLowerArmFeather, 6.981317007977319E-4F, -0.0F, 0.0F);
		this.tail3 = new MowzieModelRenderer(this, 49, 16);
		this.tail3.setRotationPoint(0.0F, 0.6F, 4.3F);
		this.tail3.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 12, 0.0F);
		ModelUtils.setRotateAngle(tail3, -0.05253441048502932F, -0.0F, 0.0F);
		this.rightThigh = new MowzieModelRenderer(this, 14, 35);
		this.rightThigh.setRotationPoint(-3.0F, 14.0F, 3.0F);
		this.rightThigh.addBox(-3.0F, -2.5F, -2.0F, 3, 7, 5, 0.0F);
		this.leftUpperArmFeather = new MowzieModelRenderer(this, 34, 34);
		this.leftUpperArmFeather.mirror = true;
		this.leftUpperArmFeather.setRotationPoint(1.0F, 0.1F, 0.9F);
		this.leftUpperArmFeather.addBox(-0.4F, -0.1F, -4.7F, 1, 4, 6, 0.0F);
		ModelUtils.setRotateAngle(leftUpperArmFeather, 1.4493214108560915F, -0.0F, 0.0F);
		this.tailFeather1 = new MowzieModelRenderer(this, 69, 40);
		this.tailFeather1.setRotationPoint(0.0F, -0.2F, -2.5F);
		this.tailFeather1.addBox(-2.5F, 0.5F, 10.1F, 5, 1, 12, 0.0F);
		ModelUtils.setRotateAngle(tailFeather1, -0.004886921905584123F, -0.0F, 0.0F);
		this.leftToeClaw2 = new MowzieModelRenderer(this, 0, 40);
		this.leftToeClaw2.setRotationPoint(0.0F, 0.2F, -2.5F);
		this.leftToeClaw2.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 1, 0.0F);
		ModelUtils.setRotateAngle(leftToeClaw2, -1.7627825445142729F, -0.0F, 0.0F);
		this.tail1 = new MowzieModelRenderer(this, 91, 0);
		this.tail1.setRotationPoint(0.0F, -1.0F, 8.5F);
		this.tail1.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 7, 0.0F);
		ModelUtils.setRotateAngle(tail1, 0.11903145498601327F, -0.0F, 0.0F);
		this.rightFoot = new MowzieModelRenderer(this, 0, 34);
		this.rightFoot.setRotationPoint(-0.2F, 0.9F, -6.3F);
		this.rightFoot.addBox(-1.5F, 0.0F, -3.0F, 3, 2, 4, 0.0F);
		ModelUtils.setRotateAngle(rightFoot, -0.9948376736367678F, -0.0F, 0.0F);
		this.rightLowerArm = new MowzieModelRenderer(this, 20, 21);
		this.rightLowerArm.mirror = true;
		this.rightLowerArm.setRotationPoint(-1.01F, 1.2F, 0.5F);
		this.rightLowerArm.addBox(-1.0F, 0.0F, -6.2F, 2, 2, 5, 0.0F);
		ModelUtils.setRotateAngle(rightLowerArm, 0.8726646259971648F, 0.0F, 0.0F);
		this.leftLeg = new MowzieModelRenderer(this, 2, 25);
		this.leftLeg.mirror = true;
		this.leftLeg.setRotationPoint(1.2F, 2.2F, 2.2F);
		this.leftLeg.addBox(-1.0F, 0.4F, -6.7F, 2, 2, 7, 0.0F);
		ModelUtils.setRotateAngle(leftLeg, 0.9948376736367678F, -0.0F, 0.0F);
		this.upperBody = new MowzieModelRenderer(this, 67, 0);
		this.upperBody.setRotationPoint(0.0F, 1.1F, -0.5F);
		this.upperBody.addBox(-3.0F, -2.0F, -5.0F, 6, 6, 6, 0.0F);
		ModelUtils.setRotateAngle(upperBody, 0.19338248112097173F, -0.0F, 0.0F);
		this.leftLowerArm = new MowzieModelRenderer(this, 20, 21);
		this.leftLowerArm.setRotationPoint(1.01F, 1.2F, 0.5F);
		this.leftLowerArm.addBox(-1.0F, 0.0F, -6.2F, 2, 2, 5, 0.0F);
		ModelUtils.setRotateAngle(leftLowerArm, 0.8726646259971648F, -0.0F, 0.0F);
		this.tailFeather3 = new MowzieModelRenderer(this, 47, 42);
		this.tailFeather3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailFeather3.addBox(-3.5F, 1.0F, -0.9F, 7, 1, 5, 0.0F);
		ModelUtils.setRotateAngle(tailFeather3, -0.004886921905584123F, -0.0F, 0.0F);
		this.leftThigh = new MowzieModelRenderer(this, 14, 35);
		this.leftThigh.mirror = true;
		this.leftThigh.setRotationPoint(3.0F, 14.0F, 3.0F);
		this.leftThigh.addBox(0.0F, -2.5F, -2.0F, 3, 7, 5, 0.0F);
		this.neck = new MowzieModelRenderer(this, 0, 13);
		this.neck.setRotationPoint(0.0F, 0.8F, -3.5F);
		this.neck.addBox(-2.0F, -2.0F, -8.0F, 4, 4, 8, 0.0F);
		ModelUtils.setRotateAngle(neck, -0.84334309456366F, -0.0F, 0.0F);
		this.rightLeg = new MowzieModelRenderer(this, 2, 25);
		this.rightLeg.setRotationPoint(-1.2F, 2.2F, 2.2F);
		this.rightLeg.addBox(-1.0F, 0.4F, -6.7F, 2, 2, 7, 0.0F);
		ModelUtils.setRotateAngle(rightLeg, 0.9948376736367678F, -0.0F, 0.0F);
		this.upperJaw = new MowzieModelRenderer(this, 28, 0);
		this.upperJaw.setRotationPoint(0.0F, -1.0F, -4.93F);
		this.upperJaw.addBox(-2.0F, -2.4F, -6.7F, 3, 3, 7, 0.0F);
		ModelUtils.setRotateAngle(upperJaw, -0.0017453292519943296F, -0.0F, 0.0F);
		this.upperBody.addChild(this.leftUpperArm);
		this.tail3.addChild(this.tailFeather2);
		this.tail1.addChild(this.tailFeather4);
		this.rightUpperArm.addChild(this.rightUpperArmFeather);
		this.tail1.addChild(this.tail2);
		this.head.addChild(this.lowerCrest);
		this.tail2.addChild(this.rightToeClaw2);
		this.head.addChild(this.lowerJaw);
		this.rightFoot.addChild(this.rightToeClaw1);
		this.head.addChild(this.upperCrest);
		this.rightLowerArm.addChild(this.rightLowerArmFeather);
		this.neck.addChild(this.headPivot);
		this.headPivot.addChild(this.head);
		this.leftLeg.addChild(this.leftFoot);
		this.leftFoot.addChild(this.leftToeClaw1);
		this.upperBody.addChild(this.rightUpperArm);
		this.leftLowerArm.addChild(this.leftLowerArmFeather);
		this.tail2.addChild(this.tail3);
		this.leftUpperArm.addChild(this.leftUpperArmFeather);
		this.tail3.addChild(this.tailFeather1);
		this.leftToeClaw1.addChild(this.leftToeClaw2);
		this.lowerBody.addChild(this.tail1);
		this.rightLeg.addChild(this.rightFoot);
		this.rightUpperArm.addChild(this.rightLowerArm);
		this.leftThigh.addChild(this.leftLeg);
		this.lowerBody.addChild(this.upperBody);
		this.leftUpperArm.addChild(this.leftLowerArm);
		this.tail2.addChild(this.tailFeather3);
		this.upperBody.addChild(this.neck);
		this.rightThigh.addChild(this.rightLeg);
		this.head.addChild(this.upperJaw);
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
		MowzieModelRenderer[] neckParts = {this.neck};
		MowzieModelRenderer[] leftArmParts = {this.leftUpperArm, this.leftLowerArm};
		MowzieModelRenderer[] rightArmParts = {this.rightUpperArm, this.rightLowerArm};

		this.faceTarget(head, 1, f3, f4);
		
		float speed = 0.1F;
		float speed2 = 0.5F;

		this.bob(lowerBody, speed, 0.7F, false, entity.ticksExisted, 1);
		this.walk(leftThigh, speed2, 0.8F, false, 0F, 0.4F, f, f1);
		this.walk(leftLeg, speed2, 0.2F, false, 0F, -0.6F, f, f1);
		this.walk(leftFoot, speed2, -0.4F, false, 4.5F, 0.4F, f, f1);
		this.walk(rightThigh, speed2, 0.8F, true, 0F, 0.4F, f, f1);
		this.walk(rightLeg, speed2, 0.2F, true, 0F, -0.6F, f, f1);
		this.walk(rightFoot, speed2, -0.4F, true, 4.5F, 0.4F, f, f1);
		this.chainWave(tailParts, speed, 0.05F, -3, entity.ticksExisted, 1);
		this.chainWave(leftArmParts, speed, 0.05F, -3, entity.ticksExisted, 1);
		this.chainWave(rightArmParts, speed, 0.05F, -3, entity.ticksExisted, 1);
		this.chainSwing(tailParts, speed, 0.15F, -3, entity.ticksExisted, 1);
		this.chainSwing(tailParts, speed2, 0.25F, -3, f, f1);

	}


=======
public class ModelVelociraptor extends ModelPrehistoric {
    public MowzieModelRenderer lowerBody;
    public MowzieModelRenderer leftThigh;
    public MowzieModelRenderer rightThigh;
    public MowzieModelRenderer upperBody;
    public MowzieModelRenderer tail1;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer leftUpperArm;
    public MowzieModelRenderer rightUpperArm;
    public MowzieModelRenderer head;
    public MowzieModelRenderer upperJaw;
    public MowzieModelRenderer lowerJaw;
    public MowzieModelRenderer upperCrest;
    public MowzieModelRenderer lowerCrest;
    public MowzieModelRenderer leftUpperArmFeather;
    public MowzieModelRenderer leftLowerArm;
    public MowzieModelRenderer leftLowerArmFeather;
    public MowzieModelRenderer rightUpperArmFeather;
    public MowzieModelRenderer rightLowerArm;
    public MowzieModelRenderer rightLowerArmFeather;
    public MowzieModelRenderer tail2;
    public MowzieModelRenderer tailFeather4;
    public MowzieModelRenderer tail3;
    public MowzieModelRenderer rightToeClaw2;
    public MowzieModelRenderer tailFeather3;
    public MowzieModelRenderer tailFeather1;
    public MowzieModelRenderer tailFeather2;
    public MowzieModelRenderer leftLeg;
    public MowzieModelRenderer leftFoot;
    public MowzieModelRenderer leftToeClaw1;
    public MowzieModelRenderer leftToeClaw2;
    public MowzieModelRenderer rightLeg;
    public MowzieModelRenderer rightFoot;
    public MowzieModelRenderer rightToeClaw1;

    public ModelVelociraptor() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.leftUpperArm = new MowzieModelRenderer(this, 20, 13);
        this.leftUpperArm.mirror = true;
        this.leftUpperArm.setRotationPoint(3.0F, 1.9F, -4.0F);
        this.leftUpperArm.addBox(0.0F, -1.0F, -1.0F, 2, 4, 3, 0.0F);
        this.setRotateAngle(leftUpperArm, -0.06981317007977318F, -0.0F, 0.0F);
        this.tailFeather2 = new MowzieModelRenderer(this, 44, 49);
        this.tailFeather2.setRotationPoint(0.0F, -0.2F, -1.3F);
        this.tailFeather2.addBox(-3.0F, 0.5F, 1.1F, 6, 1, 8, 0.0F);
        this.setRotateAngle(tailFeather2, -0.004886921905584123F, -0.0F, 0.0F);
        this.tailFeather4 = new MowzieModelRenderer(this, 46, 41);
        this.tailFeather4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailFeather4.addBox(-3.5F, 1.1F, 0.0F, 7, 1, 6, 0.0F);
        this.rightUpperArmFeather = new MowzieModelRenderer(this, 34, 34);
        this.rightUpperArmFeather.setRotationPoint(-1.0F, 0.1F, 0.9F);
        this.rightUpperArmFeather.addBox(-0.6F, -0.1F, -4.7F, 1, 4, 6, 0.0F);
        this.setRotateAngle(rightUpperArmFeather, 1.4493214108560915F, -0.0F, 0.0F);
        this.tail2 = new MowzieModelRenderer(this, 90, 13);
        this.tail2.setRotationPoint(0.0F, 0.2F, 6.7F);
        this.tail2.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 5, 0.0F);
        this.lowerCrest = new MowzieModelRenderer(this, 38, 15);
        this.lowerCrest.setRotationPoint(-0.5F, -0.7F, -1.03F);
        this.lowerCrest.addBox(-0.5F, -1.5F, 0.6F, 1, 4, 5, 0.0F);
        this.setRotateAngle(lowerCrest, 0.13578661580515886F, 0.0F, 0.0F);
        this.rightToeClaw2 = new MowzieModelRenderer(this, 0, 40);
        this.rightToeClaw2.setRotationPoint(0.0F, 0.2F, -2.5F);
        this.rightToeClaw2.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(rightToeClaw2, -1.7627825445142729F, -0.0F, 0.0F);
        this.lowerJaw = new MowzieModelRenderer(this, 49, 0);
        this.lowerJaw.setRotationPoint(0.0F, 0.0F, -4.53F);
        this.lowerJaw.addBox(-2.0F, -0.5F, -6.9F, 3, 1, 7, 0.0F);
        this.setRotateAngle(lowerJaw, -0.06924167156799095F, 0.0F, 0.0F);
        this.lowerBody = new MowzieModelRenderer(this, 65, 12);
        this.lowerBody.setRotationPoint(0.0F, 9.9F, -2.5F);
        this.lowerBody.addBox(-4.0F, -1.0F, 0.0F, 8, 7, 9, 0.0F);
        this.setRotateAngle(lowerBody, -0.15554018104602801F, 0.0F, 0.0F);
        this.rightToeClaw1 = new MowzieModelRenderer(this, 0, 40);
        this.rightToeClaw1.setRotationPoint(0.9F, 0.2F, -1.2F);
        this.rightToeClaw1.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rightToeClaw1, -0.8726646259971648F, -0.0F, 0.0F);
        this.upperCrest = new MowzieModelRenderer(this, 38, 15);
        this.upperCrest.mirror = true;
        this.upperCrest.setRotationPoint(-0.51F, -2.5F, -2.03F);
        this.upperCrest.addBox(-0.5F, -1.5F, 0.6F, 1, 4, 5, 0.0F);
        this.setRotateAngle(upperCrest, 0.4961971063419879F, -0.0F, 0.0F);
        this.rightLowerArmFeather = new MowzieModelRenderer(this, 34, 34);
        this.rightLowerArmFeather.setRotationPoint(0.0F, -0.2F, 1.6F);
        this.rightLowerArmFeather.addBox(-0.5F, 1.7F, -8.1F, 1, 4, 6, 0.0F);
        this.setRotateAngle(rightLowerArmFeather, 6.981317007977319E-4F, -0.0F, 0.0F);
        this.head = new MowzieModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.5F, 0.8F, -6.03F);
        this.head.addBox(-3.0F, -4.0F, -5.0F, 5, 5, 6, 0.0F);
        this.setRotateAngle(head, 0.9955358053375656F, 0.0F, 0.0F);
        this.leftFoot = new MowzieModelRenderer(this, 0, 34);
        this.leftFoot.setRotationPoint(0.2F, 0.9F, -6.3F);
        this.leftFoot.addBox(-1.5F, 0.0F, -3.1F, 3, 2, 4, 0.0F);
        this.setRotateAngle(leftFoot, -0.9948376736367678F, -0.0F, 0.0F);
        this.leftToeClaw1 = new MowzieModelRenderer(this, 0, 40);
        this.leftToeClaw1.setRotationPoint(-0.9F, 0.2F, -1.2F);
        this.leftToeClaw1.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(leftToeClaw1, -0.8726646259971648F, -0.0F, 0.0F);
        this.rightUpperArm = new MowzieModelRenderer(this, 20, 13);
        this.rightUpperArm.setRotationPoint(-3.0F, 1.9F, -4.0F);
        this.rightUpperArm.addBox(-2.0F, -1.0F, -1.0F, 2, 4, 3, 0.0F);
        this.setRotateAngle(rightUpperArm, -0.06981317007977318F, -0.0F, 0.0F);
        this.leftLowerArmFeather = new MowzieModelRenderer(this, 34, 34);
        this.leftLowerArmFeather.mirror = true;
        this.leftLowerArmFeather.setRotationPoint(0.0F, -0.2F, 1.6F);
        this.leftLowerArmFeather.addBox(-0.5F, 1.7F, -8.1F, 1, 4, 6, 0.0F);
        this.setRotateAngle(leftLowerArmFeather, 6.981317007977319E-4F, -0.0F, 0.0F);
        this.tail3 = new MowzieModelRenderer(this, 49, 16);
        this.tail3.setRotationPoint(0.0F, 0.6F, 4.3F);
        this.tail3.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 12, 0.0F);
        this.setRotateAngle(tail3, -0.05253441048502932F, -0.0F, 0.0F);
        this.rightThigh = new MowzieModelRenderer(this, 14, 35);
        this.rightThigh.setRotationPoint(-3.0F, 14.0F, 3.0F);
        this.rightThigh.addBox(-3.0F, -2.5F, -2.0F, 3, 7, 5, 0.0F);
        this.leftUpperArmFeather = new MowzieModelRenderer(this, 34, 34);
        this.leftUpperArmFeather.mirror = true;
        this.leftUpperArmFeather.setRotationPoint(1.0F, 0.1F, 0.9F);
        this.leftUpperArmFeather.addBox(-0.4F, -0.1F, -4.7F, 1, 4, 6, 0.0F);
        this.setRotateAngle(leftUpperArmFeather, 1.4493214108560915F, -0.0F, 0.0F);
        this.tailFeather1 = new MowzieModelRenderer(this, 69, 40);
        this.tailFeather1.setRotationPoint(0.0F, -0.2F, -2.5F);
        this.tailFeather1.addBox(-2.5F, 0.5F, 10.1F, 5, 1, 12, 0.0F);
        this.setRotateAngle(tailFeather1, -0.004886921905584123F, -0.0F, 0.0F);
        this.leftToeClaw2 = new MowzieModelRenderer(this, 0, 40);
        this.leftToeClaw2.setRotationPoint(0.0F, 0.2F, -2.5F);
        this.leftToeClaw2.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(leftToeClaw2, -1.7627825445142729F, -0.0F, 0.0F);
        this.tail1 = new MowzieModelRenderer(this, 91, 0);
        this.tail1.setRotationPoint(0.0F, -1.0F, 8.5F);
        this.tail1.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 7, 0.0F);
        this.setRotateAngle(tail1, 0.11903145498601327F, -0.0F, 0.0F);
        this.rightFoot = new MowzieModelRenderer(this, 0, 34);
        this.rightFoot.setRotationPoint(-0.2F, 0.9F, -6.3F);
        this.rightFoot.addBox(-1.5F, 0.0F, -3.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(rightFoot, -0.9948376736367678F, -0.0F, 0.0F);
        this.rightLowerArm = new MowzieModelRenderer(this, 20, 21);
        this.rightLowerArm.mirror = true;
        this.rightLowerArm.setRotationPoint(-1.01F, 1.2F, 0.5F);
        this.rightLowerArm.addBox(-1.0F, 0.0F, -6.2F, 2, 2, 5, 0.0F);
        this.setRotateAngle(rightLowerArm, 0.8726646259971648F, 0.0F, 0.0F);
        this.leftLeg = new MowzieModelRenderer(this, 2, 25);
        this.leftLeg.mirror = true;
        this.leftLeg.setRotationPoint(1.2F, 2.2F, 2.2F);
        this.leftLeg.addBox(-1.0F, 0.4F, -6.7F, 2, 2, 7, 0.0F);
        this.setRotateAngle(leftLeg, 0.9948376736367678F, -0.0F, 0.0F);
        this.upperBody = new MowzieModelRenderer(this, 67, 0);
        this.upperBody.setRotationPoint(0.0F, 1.1F, -0.5F);
        this.upperBody.addBox(-3.0F, -2.0F, -5.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(upperBody, 0.19338248112097173F, -0.0F, 0.0F);
        this.leftLowerArm = new MowzieModelRenderer(this, 20, 21);
        this.leftLowerArm.setRotationPoint(1.01F, 1.2F, 0.5F);
        this.leftLowerArm.addBox(-1.0F, 0.0F, -6.2F, 2, 2, 5, 0.0F);
        this.setRotateAngle(leftLowerArm, 0.8726646259971648F, -0.0F, 0.0F);
        this.tailFeather3 = new MowzieModelRenderer(this, 47, 42);
        this.tailFeather3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailFeather3.addBox(-3.5F, 1.0F, -0.9F, 7, 1, 5, 0.0F);
        this.setRotateAngle(tailFeather3, -0.004886921905584123F, -0.0F, 0.0F);
        this.leftThigh = new MowzieModelRenderer(this, 14, 35);
        this.leftThigh.mirror = true;
        this.leftThigh.setRotationPoint(3.0F, 14.0F, 3.0F);
        this.leftThigh.addBox(0.0F, -2.5F, -2.0F, 3, 7, 5, 0.0F);
        this.neck = new MowzieModelRenderer(this, 0, 13);
        this.neck.setRotationPoint(0.0F, 0.8F, -3.5F);
        this.neck.addBox(-2.0F, -2.0F, -8.0F, 4, 4, 8, 0.0F);
        this.setRotateAngle(neck, -0.84334309456366F, -0.0F, 0.0F);
        this.rightLeg = new MowzieModelRenderer(this, 2, 25);
        this.rightLeg.setRotationPoint(-1.2F, 2.2F, 2.2F);
        this.rightLeg.addBox(-1.0F, 0.4F, -6.7F, 2, 2, 7, 0.0F);
        this.setRotateAngle(rightLeg, 0.9948376736367678F, -0.0F, 0.0F);
        this.upperJaw = new MowzieModelRenderer(this, 28, 0);
        this.upperJaw.setRotationPoint(0.0F, -1.0F, -4.93F);
        this.upperJaw.addBox(-2.0F, -2.4F, -6.7F, 3, 3, 7, 0.0F);
        this.setRotateAngle(upperJaw, -0.0017453292519943296F, -0.0F, 0.0F);
        this.upperBody.addChild(this.leftUpperArm);
        this.tail3.addChild(this.tailFeather2);
        this.tail1.addChild(this.tailFeather4);
        this.rightUpperArm.addChild(this.rightUpperArmFeather);
        this.tail1.addChild(this.tail2);
        this.head.addChild(this.lowerCrest);
        this.tail2.addChild(this.rightToeClaw2);
        this.head.addChild(this.lowerJaw);
        this.rightFoot.addChild(this.rightToeClaw1);
        this.head.addChild(this.upperCrest);
        this.rightLowerArm.addChild(this.rightLowerArmFeather);
        this.neck.addChild(this.head);
        this.leftLeg.addChild(this.leftFoot);
        this.leftFoot.addChild(this.leftToeClaw1);
        this.upperBody.addChild(this.rightUpperArm);
        this.leftLowerArm.addChild(this.leftLowerArmFeather);
        this.tail2.addChild(this.tail3);
        this.leftUpperArm.addChild(this.leftUpperArmFeather);
        this.tail3.addChild(this.tailFeather1);
        this.leftToeClaw1.addChild(this.leftToeClaw2);
        this.lowerBody.addChild(this.tail1);
        this.rightLeg.addChild(this.rightFoot);
        this.rightUpperArm.addChild(this.rightLowerArm);
        this.leftThigh.addChild(this.leftLeg);
        this.lowerBody.addChild(this.upperBody);
        this.leftUpperArm.addChild(this.leftLowerArm);
        this.tail2.addChild(this.tailFeather3);
        this.upperBody.addChild(this.neck);
        this.rightThigh.addChild(this.rightLeg);
        this.head.addChild(this.upperJaw);
        doMowzieStuff(false);
    }

	@Override
	public void renderFossil(EntityNewPrehistoric entity, float f, float f1,
			float f2, float f3, float f4, float f5) {
		
	}

	@Override
	public void renderLiving(EntityNewPrehistoric entity, float f, float f1,
			float f2, float f3, float f4, float f5) {
		
	}

	@Override
	public void renderSleeping(EntityNewPrehistoric entity, float f, float f1,
			float f2, float f3, float f4, float f5) {
		
	}
>>>>>>> origin/master
}
