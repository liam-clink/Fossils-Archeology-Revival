package com.github.revival.client.model.prehistoric;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.llibrary.common.animation.Animator;
import net.ilexiconn.llibrary.common.animation.IAnimated;
import net.minecraft.entity.Entity;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;


public class ModelStegosaurus extends ModelPrehistoric
{
	public MowzieModelRenderer lowerBody;
    public MowzieModelRenderer rightFrontThigh;
    public MowzieModelRenderer leftFrontThigh;
    public MowzieModelRenderer rightHindThigh;
    public MowzieModelRenderer leftHindThigh;
    public MowzieModelRenderer upperBody;
    public MowzieModelRenderer tail1;
    public MowzieModelRenderer bodyPlates;
    public MowzieModelRenderer neck1;
    public MowzieModelRenderer neck1Plates;
    public MowzieModelRenderer neck2;
    public MowzieModelRenderer neck2Plates;
    public MowzieModelRenderer head;
    public MowzieModelRenderer head_1;
    public MowzieModelRenderer head_2;
    public MowzieModelRenderer tail2;
    public MowzieModelRenderer tail1Plates;
    public MowzieModelRenderer tail3;
    public MowzieModelRenderer tail2Plates;
    public MowzieModelRenderer leftThagomizer;
    public MowzieModelRenderer rightThagomizer;
    public MowzieModelRenderer rightFrontLeg;
    public MowzieModelRenderer leftFrontLeg;
    public MowzieModelRenderer rightHindLeg;
    public MowzieModelRenderer leftHindLeg;
	private Animator animator;

    public ModelStegosaurus() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.bodyPlates = new MowzieModelRenderer(this, 53, 98);
        this.bodyPlates.setRotationPoint(0.0F, -5.0F, 3.5F);
        this.bodyPlates.addBox(-2.0F, -10.0F, -10.0F, 4, 10, 20, 0.0F);
        this.setRotateAngle(bodyPlates, 0.05235987755982988F, -0.0F, 0.0F);
        this.rightFrontThigh = new MowzieModelRenderer(this, 0, 50);
        this.rightFrontThigh.setRotationPoint(-5.6F, 14.0F, -9.5F);
        this.rightFrontThigh.addBox(-2.0F, -0.5F, -1.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(rightFrontThigh, 0.20943951023931953F, -0.0F, 0.0F);
        this.leftFrontLeg = new MowzieModelRenderer(this, 0, 62);
        this.leftFrontLeg.setRotationPoint(0.9F, 4.2F, 0.5F);
        this.leftFrontLeg.addBox(-1.0F, 0.0F, -1.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(leftFrontLeg, -0.20943951023931953F, -0.0F, 0.0F);
        this.leftThagomizer = new MowzieModelRenderer(this, 163, 110);
        this.leftThagomizer.setRotationPoint(1.0F, 1.3F, 4.0F);
        this.leftThagomizer.addBox(-1.0F, -10.0F, -4.0F, 2, 10, 8, 0.0F);
        this.setRotateAngle(leftThagomizer, -0.20943951023931953F, -0.0879645943005142F, 1.1786208438717707F);
        this.tail1 = new MowzieModelRenderer(this, 42, 30);
        this.tail1.setRotationPoint(0.0F, -7.1F, 13.0F);
        this.tail1.addBox(-5.0F, 0.0F, 0.0F, 10, 8, 10, 0.0F);
        this.setRotateAngle(tail1, -0.03490658503988659F, -0.0F, 0.0F);
        this.rightThagomizer = new MowzieModelRenderer(this, 163, 110);
        this.rightThagomizer.mirror = true;
        this.rightThagomizer.setRotationPoint(-1.0F, 1.3F, 4.0F);
        this.rightThagomizer.addBox(-1.0F, -10.0F, -4.0F, 2, 10, 8, 0.0F);
        this.setRotateAngle(rightThagomizer, -0.20943951023931953F, 0.0879645943005142F, -1.1786208438717707F);
        this.leftHindLeg = new MowzieModelRenderer(this, 16, 68);
        this.leftHindLeg.setRotationPoint(0.3F, 7.7F, 2.0F);
        this.leftHindLeg.addBox(-0.5F, 0.0F, -1.0F, 4, 8, 4, 0.0F);
        this.head = new MowzieModelRenderer(this, 0, 3);
        this.head.setRotationPoint(0.0F, 0.0F, -9.0F);
        this.head.addBox(-2.0F, -3.0F, -7.0F, 4, 6, 7, 0.0F);
        this.setRotateAngle(head, 0.20943951023931953F, 0.0F, 0.0F);
        this.rightFrontLeg = new MowzieModelRenderer(this, 0, 62);
        this.rightFrontLeg.mirror = true;
        this.rightFrontLeg.setRotationPoint(-0.9F, 4.2F, 0.5F);
        this.rightFrontLeg.addBox(-1.0F, 0.0F, -1.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(rightFrontLeg, -0.20943951023931953F, -0.0F, 0.0F);
        this.leftFrontThigh = new MowzieModelRenderer(this, 0, 50);
        this.leftFrontThigh.mirror = true;
        this.leftFrontThigh.setRotationPoint(3.6F, 14.0F, -9.5F);
        this.leftFrontThigh.addBox(0.0F, -0.5F, -1.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(leftFrontThigh, 0.20943951023931953F, -0.0F, 0.0F);
        this.rightHindThigh = new MowzieModelRenderer(this, 16, 50);
        this.rightHindThigh.mirror = true;
        this.rightHindThigh.setRotationPoint(-7.0F, 8.3F, 6.5F);
        this.rightHindThigh.addBox(-2.0F, -0.5F, -1.5F, 4, 10, 6, 0.0F);
        this.neck1Plates = new MowzieModelRenderer(this, 27, 110);
        this.neck1Plates.setRotationPoint(0.0F, -2.5F, -3.5F);
        this.neck1Plates.addBox(-2.0F, -10.0F, -5.0F, 4, 10, 8, 0.0F);
        this.setRotateAngle(neck1Plates, -0.05235987755982988F, -0.0F, 0.0F);
        this.tail2Plates = new MowzieModelRenderer(this, 128, 102);
        this.tail2Plates.setRotationPoint(0.0F, 3.4F, 5.0F);
        this.tail2Plates.addBox(-1.0F, -10.0F, -8.0F, 2, 10, 16, 0.0F);
        this.setRotateAngle(tail2Plates, -0.009075712110370514F, -0.0F, 0.0F);
        this.neck1 = new MowzieModelRenderer(this, 0, 32);
        this.neck1.setRotationPoint(0.0F, -0.2F, -7.3F);
        this.neck1.addBox(-5.0F, -5.0F, -8.0F, 10, 10, 8, 0.0F);
        this.setRotateAngle(neck1, 0.10471975511965977F, -0.0F, 0.0F);
        this.tail2 = new MowzieModelRenderer(this, 82, 30);
        this.tail2.setRotationPoint(0.0F, 0.5F, 10.0F);
        this.tail2.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 12, 0.0F);
        this.setRotateAngle(tail2, -0.06370451769779302F, -0.0F, 0.0F);
        this.neck2 = new MowzieModelRenderer(this, 0, 16);
        this.neck2.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.neck2.addBox(-3.0F, -3.0F, -10.0F, 6, 6, 10, 0.0F);
        this.setRotateAngle(neck2, -0.2844886680750757F, -0.0F, 0.0F);
        this.upperBody = new MowzieModelRenderer(this, 28, 0);
        this.upperBody.setRotationPoint(0.0F, -0.5F, 3.1F);
        this.upperBody.addBox(-6.0F, -7.0F, -10.0F, 12, 14, 10, 0.0F);
        this.setRotateAngle(upperBody, 0.12217304763960307F, 0.0F, 0.0F);
        this.head_2 = new MowzieModelRenderer(this, 65, 1);
        this.head_2.setRotationPoint(0.0F, 0.3F, -5.5F);
        this.head_2.addBox(-1.0F, 0.0F, -5.0F, 2, 2, 5, 0.0F);
        this.setRotateAngle(head_2, 0.13962634015954636F, 0.0F, 0.0F);
        this.head_1 = new MowzieModelRenderer(this, 23, 1);
        this.head_1.setRotationPoint(0.0F, -0.6F, -6.0F);
        this.head_1.addBox(-1.0F, -2.0F, -5.0F, 2, 3, 5, 0.0F);
        this.setRotateAngle(head_1, 0.13962634015954636F, 0.0F, 0.0F);
        this.neck2Plates = new MowzieModelRenderer(this, 0, 112);
        this.neck2Plates.setRotationPoint(0.0F, 2.5F, -6.0F);
        this.neck2Plates.addBox(-1.0F, -8.0F, -5.0F, 2, 8, 10, 0.0F);
        this.setRotateAngle(neck2Plates, 0.017453292519943295F, -0.0F, 0.0F);
        this.rightHindLeg = new MowzieModelRenderer(this, 16, 68);
        this.rightHindLeg.mirror = true;
        this.rightHindLeg.setRotationPoint(-1.3F, 7.7F, 2.0F);
        this.rightHindLeg.addBox(-0.5F, 0.0F, -1.0F, 4, 8, 4, 0.0F);
        this.lowerBody = new MowzieModelRenderer(this, 72, 0);
        this.lowerBody.setRotationPoint(0.0F, 9.7F, -2.5F);
        this.lowerBody.addBox(-7.0F, -8.0F, 0.0F, 14, 16, 14, 0.0F);
        this.setRotateAngle(lowerBody, -0.03490658503988659F, -0.0F, 0.0F);
        this.leftHindThigh = new MowzieModelRenderer(this, 16, 50);
        this.leftHindThigh.setRotationPoint(5.0F, 8.3F, 6.5F);
        this.leftHindThigh.addBox(0.0F, -0.5F, -1.5F, 4, 10, 6, 0.0F);
        this.tail3 = new MowzieModelRenderer(this, 118, 30);
        this.tail3.setRotationPoint(0.0F, 0.5F, 10.5F);
        this.tail3.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 8, 0.0F);
        this.setRotateAngle(tail3, 0.12217304763960307F, -0.0F, 0.0F);
        this.tail1Plates = new MowzieModelRenderer(this, 101, 108);
        this.tail1Plates.setRotationPoint(0.0F, 4.0F, 4.5F);
        this.tail1Plates.addBox(-2.0F, -10.0F, -5.0F, 4, 10, 10, 0.0F);
        this.setRotateAngle(tail1Plates, -0.05235987755982988F, 0.0F, 0.0F);
        this.lowerBody.addChild(this.bodyPlates);
        this.leftFrontThigh.addChild(this.leftFrontLeg);
        this.tail3.addChild(this.leftThagomizer);
        this.lowerBody.addChild(this.tail1);
        this.tail3.addChild(this.rightThagomizer);
        this.leftHindThigh.addChild(this.leftHindLeg);
        this.neck2.addChild(this.head);
        this.rightFrontThigh.addChild(this.rightFrontLeg);
        this.neck1.addChild(this.neck1Plates);
        this.tail2.addChild(this.tail2Plates);
        this.upperBody.addChild(this.neck1);
        this.tail1.addChild(this.tail2);
        this.neck1.addChild(this.neck2);
        this.lowerBody.addChild(this.upperBody);
        this.head.addChild(this.head_2);
        this.head.addChild(this.head_1);
        this.neck2.addChild(this.neck2Plates);
        this.rightHindThigh.addChild(this.rightHindLeg);
        this.tail2.addChild(this.tail3);
        this.tail1.addChild(this.tail1Plates);
        this.setInitPose();
		animator = new Animator(this);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		animate((IAnimated)entity, f, f1, f2, f3, f4, f5);
        this.rightFrontThigh.render(f5);
        this.leftFrontThigh.render(f5);
        this.rightHindThigh.render(f5);
        this.lowerBody.render(f5);
        this.leftHindThigh.render(f5);
    }
    
    public void animate(IAnimated entity, float f, float f1, float f2, float f3, float f4, float f5) {
		animator.update(entity);
		this.setToInitPose();
		setRotationAngles(f, f1, f2, f3, f4, f5, (Entity)entity);
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		MowzieModelRenderer[] tailParts = {this.tail1, this.tail2, this.tail3};
		MowzieModelRenderer[] neckParts = {this.neck1, this.neck2, this.head};
		this.faceTarget(head, 1, f3, f4);
		float speed = 0.1F;
		float speed2 = 1.6F;
		float sitProgress = ((EntityNewPrehistoric)(entity)).sitProgress;
		this.chainWave(tailParts, speed, 0.05F, -3, entity.ticksExisted, 1);
		this.chainSwing(tailParts, speed, 0.15F, -2, entity.ticksExisted, 1);
		this.chainWave(neckParts, speed, 0.05F, 3, entity.ticksExisted, 1);
		this.bob(lowerBody, speed, 0.4F, false, entity.ticksExisted, 1);
		this.walk(leftFrontThigh, speed2, 0.8F, true, 0F, -0.4F, f, f1);
		this.walk(leftFrontThigh, speed2, 0.8F, false, 0F, -0.4F, f, f1);
		this.walk(leftHindThigh, speed2, 0.8F, false, 0F, 0.4F, f, f1);
		this.walk(rightHindThigh, speed2, 0.8F, true, 0F, 0.4F, f, f1);
		this.walk(leftFrontLeg, speed2, 0.6F, true, 0F, -0.4F, f, f1);
		this.walk(rightFrontLeg, speed2, 0.6F, false, 0F, -0.4F, f, f1);
		this.walk(leftHindLeg, speed2, 0.6F, false, 0F, 0.4F, f, f1);
		this.walk(rightHindLeg, speed2, 0.6F, true, 0F, 0.4F, f, f1);
	}

}
