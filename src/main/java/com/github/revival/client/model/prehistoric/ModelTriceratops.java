package com.github.revival.client.model.prehistoric;

<<<<<<< HEAD
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.minecraft.entity.Entity;

import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public class ModelTriceratops extends MowzieModelBase {
=======
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public class ModelTriceratops extends ModelPrehistoric {
>>>>>>> origin/master
    public MowzieModelRenderer upperBody;
    public MowzieModelRenderer rightFrontThigh;
    public MowzieModelRenderer leftFrontThigh;
    public MowzieModelRenderer rightHindThigh;
    public MowzieModelRenderer leftHindThigh;
    public MowzieModelRenderer lowerBody;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer tail1;
    public MowzieModelRenderer tail2;
    public MowzieModelRenderer quills;
    public MowzieModelRenderer tail3;
    public MowzieModelRenderer quills_1;
    public MowzieModelRenderer quills_2;
<<<<<<< HEAD
    public MowzieModelRenderer headPivot;
=======
>>>>>>> origin/master
    public MowzieModelRenderer head;
    public MowzieModelRenderer beak;
    public MowzieModelRenderer frill;
    public MowzieModelRenderer leftHorn1;
    public MowzieModelRenderer rightHorn1;
    public MowzieModelRenderer beakbottom;
    public MowzieModelRenderer noseHorn;
    public MowzieModelRenderer frillProtrusions;
    public MowzieModelRenderer leftHorn2;
    public MowzieModelRenderer rightHorn2;
    public MowzieModelRenderer rightFrontLeg;
    public MowzieModelRenderer leftFrontLeg;
    public MowzieModelRenderer rightHindLeg;
    public MowzieModelRenderer leftHindLeg;

    public ModelTriceratops() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.upperBody = new MowzieModelRenderer(this, 77, 0);
        this.upperBody.setRotationPoint(0.0F, 14.6F, 1.0F);
        this.upperBody.addBox(-3.5F, 0.0F, -6.0F, 7, 6, 6, 0.0F);
<<<<<<< HEAD
        ModelUtils.setRotateAngle(upperBody, 0.12217304763960307F, -0.0F, 0.0F);
        this.frillProtrusions = new MowzieModelRenderer(this, 20, 8);
        this.frillProtrusions.setRotationPoint(1.0F, 0.1F, 0.0F);
        this.frillProtrusions.addBox(-6.0F, -7.6F, -0.1F, 10, 8, 1, 0.0F);
        ModelUtils.setRotateAngle(frillProtrusions, 0.0013962634015954637F, -0.0F, 0.0F);
        this.neck = new MowzieModelRenderer(this, 0, 0);
        this.neck.setRotationPoint(0.5F, 0.8F, -5.0F);
        this.neck.addBox(-2.0F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
        ModelUtils.setRotateAngle(neck, -0.06981317007977318F, -0.0F, 0.0F);
        this.beakbottom = new MowzieModelRenderer(this, 14, 43);
        this.beakbottom.setRotationPoint(0.0F, 2.0F, -3.5F);
        this.beakbottom.addBox(-1.0F, -1.0F, -2.7F, 2, 1, 3, 0.0F);
        ModelUtils.setRotateAngle(beakbottom, 0.2513223807039196F, -0.0F, 0.0F);
=======
        this.setRotateAngle(upperBody, 0.12217304763960307F, -0.0F, 0.0F);
        this.frillProtrusions = new MowzieModelRenderer(this, 20, 8);
        this.frillProtrusions.setRotationPoint(1.0F, 0.1F, 0.0F);
        this.frillProtrusions.addBox(-6.0F, -7.6F, -0.1F, 10, 8, 1, 0.0F);
        this.setRotateAngle(frillProtrusions, 0.0013962634015954637F, -0.0F, 0.0F);
        this.neck = new MowzieModelRenderer(this, 0, 0);
        this.neck.setRotationPoint(0.5F, 0.8F, -5.0F);
        this.neck.addBox(-2.0F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(neck, -0.06981317007977318F, -0.0F, 0.0F);
        this.beakbottom = new MowzieModelRenderer(this, 14, 43);
        this.beakbottom.setRotationPoint(0.0F, 2.0F, -3.5F);
        this.beakbottom.addBox(-1.0F, -1.0F, -2.7F, 2, 1, 3, 0.0F);
        this.setRotateAngle(beakbottom, 0.2513223807039196F, -0.0F, 0.0F);
>>>>>>> origin/master
        this.leftHindThigh = new MowzieModelRenderer(this, 12, 24);
        this.leftHindThigh.setRotationPoint(2.4F, 18.0F, 4.0F);
        this.leftHindThigh.addBox(0.0F, -1.0F, -2.0F, 2, 4, 3, 0.0F);
        this.rightHorn2 = new MowzieModelRenderer(this, 33, 27);
        this.rightHorn2.setRotationPoint(0.1F, 0.29F, -3.2F);
        this.rightHorn2.addBox(-0.5F, -0.8F, -4.0F, 1, 1, 4, 0.0F);
<<<<<<< HEAD
        ModelUtils.setRotateAngle(rightHorn2, 0.1832595714594046F, 0.0F, 0.0F);
        this.quills_2 = new MowzieModelRenderer(this, 18, 52);
        this.quills_2.setRotationPoint(-0.5F, 0.7F, 3.5F);
        this.quills_2.addBox(0.0F, -5.0F, -2.0F, 1, 5, 2, 0.0F);
        ModelUtils.setRotateAngle(quills_2, 0.05235987755982988F, 0.0F, 0.0F);
        this.leftFrontThigh = new MowzieModelRenderer(this, 0, 16);
        this.leftFrontThigh.setRotationPoint(2.8F, 19.4F, -3.0F);
        this.leftFrontThigh.addBox(0.0F, -1.0F, -1.0F, 2, 3, 2, 0.0F);
        ModelUtils.setRotateAngle(leftFrontThigh, 0.20943951023931953F, -0.0F, 0.0F);
        this.tail2 = new MowzieModelRenderer(this, 68, 17);
        this.tail2.setRotationPoint(0.0F, 0.6F, 2.5F);
        this.tail2.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
        ModelUtils.setRotateAngle(tail2, -0.05044001538263612F, -0.0F, 0.0F);
        this.quills_1 = new MowzieModelRenderer(this, 10, 51);
        this.quills_1.setRotationPoint(-0.5F, 0.2F, 2.5F);
        this.quills_1.addBox(0.0F, -5.0F, -2.0F, 1, 5, 3, 0.0F);
        ModelUtils.setRotateAngle(quills_1, 0.05235987755982988F, 0.0F, 0.0F);
        this.lowerBody = new MowzieModelRenderer(this, 104, 1);
        this.lowerBody.setRotationPoint(0.0F, 1.98F, -1.5F);
        this.lowerBody.addBox(-3.0F, -2.0F, 0.0F, 6, 6, 6, 0.0F);
        ModelUtils.setRotateAngle(lowerBody, -0.17907078125461823F, 0.0F, 0.0F);
        this.leftFrontLeg = new MowzieModelRenderer(this, 16, 19);
        this.leftFrontLeg.setRotationPoint(1.3F, 1.6F, 0.5F);
        this.leftFrontLeg.addBox(-1.5F, -1.0F, -3.1F, 2, 2, 3, 0.0F);
        ModelUtils.setRotateAngle(leftFrontLeg, 1.3613568165555772F, -0.0F, 0.0F);
=======
        this.setRotateAngle(rightHorn2, 0.1832595714594046F, 0.0F, 0.0F);
        this.quills_2 = new MowzieModelRenderer(this, 18, 52);
        this.quills_2.setRotationPoint(-0.5F, 0.7F, 3.5F);
        this.quills_2.addBox(0.0F, -5.0F, -2.0F, 1, 5, 2, 0.0F);
        this.setRotateAngle(quills_2, 0.05235987755982988F, 0.0F, 0.0F);
        this.leftFrontThigh = new MowzieModelRenderer(this, 0, 16);
        this.leftFrontThigh.setRotationPoint(2.8F, 19.4F, -3.0F);
        this.leftFrontThigh.addBox(0.0F, -1.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(leftFrontThigh, 0.20943951023931953F, -0.0F, 0.0F);
        this.tail2 = new MowzieModelRenderer(this, 68, 17);
        this.tail2.setRotationPoint(0.0F, 0.6F, 2.5F);
        this.tail2.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(tail2, -0.05044001538263612F, -0.0F, 0.0F);
        this.quills_1 = new MowzieModelRenderer(this, 10, 51);
        this.quills_1.setRotationPoint(-0.5F, 0.2F, 2.5F);
        this.quills_1.addBox(0.0F, -5.0F, -2.0F, 1, 5, 3, 0.0F);
        this.setRotateAngle(quills_1, 0.05235987755982988F, 0.0F, 0.0F);
        this.lowerBody = new MowzieModelRenderer(this, 104, 1);
        this.lowerBody.setRotationPoint(0.0F, 1.98F, -1.5F);
        this.lowerBody.addBox(-3.0F, -2.0F, 0.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(lowerBody, -0.17907078125461823F, 0.0F, 0.0F);
        this.leftFrontLeg = new MowzieModelRenderer(this, 16, 19);
        this.leftFrontLeg.setRotationPoint(1.3F, 1.6F, 0.5F);
        this.leftFrontLeg.addBox(-1.5F, -1.0F, -3.1F, 2, 2, 3, 0.0F);
        this.setRotateAngle(leftFrontLeg, 1.3613568165555772F, -0.0F, 0.0F);
>>>>>>> origin/master
        this.rightHindThigh = new MowzieModelRenderer(this, 12, 24);
        this.rightHindThigh.mirror = true;
        this.rightHindThigh.setRotationPoint(-2.4F, 18.0F, 4.0F);
        this.rightHindThigh.addBox(-2.0F, -1.0F, -2.0F, 2, 4, 3, 0.0F);
        this.tail3 = new MowzieModelRenderer(this, 54, 21);
        this.tail3.setRotationPoint(0.0F, 0.5F, 2.5F);
        this.tail3.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
<<<<<<< HEAD
        ModelUtils.setRotateAngle(tail3, 0.2555162024919699F, -0.0F, 0.0F);
=======
        this.setRotateAngle(tail3, 0.2555162024919699F, -0.0F, 0.0F);
>>>>>>> origin/master
        this.rightFrontLeg = new MowzieModelRenderer(this, 16, 19);
        this.rightFrontLeg.mirror = true;
        this.rightFrontLeg.setRotationPoint(-1.3F, 1.6F, 0.5F);
        this.rightFrontLeg.addBox(-0.5F, -1.0F, -3.1F, 2, 2, 3, 0.0F);
<<<<<<< HEAD
        ModelUtils.setRotateAngle(rightFrontLeg, 1.3613568165555772F, -0.0F, 0.0F);
        this.leftHindLeg = new MowzieModelRenderer(this, 32, 19);
        this.leftHindLeg.setRotationPoint(0.4F, 2.0F, 0.3F);
        this.leftHindLeg.addBox(-0.5F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        ModelUtils.setRotateAngle(leftHindLeg, 1.5707963267948966F, -0.0F, 0.0F);
=======
        this.setRotateAngle(rightFrontLeg, 1.3613568165555772F, -0.0F, 0.0F);
        this.leftHindLeg = new MowzieModelRenderer(this, 32, 19);
        this.leftHindLeg.setRotationPoint(0.4F, 2.0F, 0.3F);
        this.leftHindLeg.addBox(-0.5F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(leftHindLeg, 1.5707963267948966F, -0.0F, 0.0F);
>>>>>>> origin/master
        this.rightHindLeg = new MowzieModelRenderer(this, 32, 19);
        this.rightHindLeg.mirror = true;
        this.rightHindLeg.setRotationPoint(-0.4F, 2.0F, 0.3F);
        this.rightHindLeg.addBox(-1.5F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
<<<<<<< HEAD
        ModelUtils.setRotateAngle(rightHindLeg, 1.5707963267948966F, -0.0F, 0.0F);
        this.frill = new MowzieModelRenderer(this, 20, 0);
        this.frill.setRotationPoint(0.0F, -0.8F, -1.2F);
        this.frill.addBox(-4.0F, -7.0F, 0.0F, 8, 7, 1, 0.0F);
        ModelUtils.setRotateAngle(frill, -0.6618288523562498F, -0.0F, 0.0F);
        this.tail1 = new MowzieModelRenderer(this, 48, 10);
        this.tail1.setRotationPoint(0.0F, -1.7F, 5.5F);
        this.tail1.addBox(-2.5F, -0.2F, 0.0F, 5, 4, 3, 0.0F);
        ModelUtils.setRotateAngle(tail1, -0.463210383479295F, -0.0F, 0.0F);
        this.beak = new MowzieModelRenderer(this, 0, 43);
        this.beak.setRotationPoint(0.0F, -0.1F, -3.4F);
        this.beak.addBox(-1.0F, -1.0F, -3.5F, 2, 2, 4, 0.0F);
        ModelUtils.setRotateAngle(beak, 0.2808606942177475F, -0.0F, 0.0F);
        this.rightHorn1 = new MowzieModelRenderer(this, 32, 35);
        this.rightHorn1.setRotationPoint(-1.5F, -1.7F, -1.0F);
        this.rightHorn1.addBox(-0.4F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        ModelUtils.setRotateAngle(rightHorn1, -0.8051203839449842F, 0.06981317007977318F, -0.20943951023931953F);
        this.headPivot = new MowzieModelRenderer(this, 0, 34);
        this.headPivot.setRotationPoint(-0.5F, 1.8F, -2.2F);
        ModelUtils.setRotateAngle(headPivot, 0.20943951023931953F, -0.0F, 0.0F);
        this.head = new MowzieModelRenderer(this, 0, 34);
        this.head.setRotationPoint(0, 0, 0);
        this.head.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 4, 0.0F);
        ModelUtils.setRotateAngle(head, 0F, -0.0F, 0.0F);
=======
        this.setRotateAngle(rightHindLeg, 1.5707963267948966F, -0.0F, 0.0F);
        this.frill = new MowzieModelRenderer(this, 20, 0);
        this.frill.setRotationPoint(0.0F, -0.8F, -1.2F);
        this.frill.addBox(-4.0F, -7.0F, 0.0F, 8, 7, 1, 0.0F);
        this.setRotateAngle(frill, -0.6618288523562498F, -0.0F, 0.0F);
        this.tail1 = new MowzieModelRenderer(this, 48, 10);
        this.tail1.setRotationPoint(0.0F, -1.7F, 5.5F);
        this.tail1.addBox(-2.5F, -0.2F, 0.0F, 5, 4, 3, 0.0F);
        this.setRotateAngle(tail1, -0.463210383479295F, -0.0F, 0.0F);
        this.beak = new MowzieModelRenderer(this, 0, 43);
        this.beak.setRotationPoint(0.0F, -0.1F, -3.4F);
        this.beak.addBox(-1.0F, -1.0F, -3.5F, 2, 2, 4, 0.0F);
        this.setRotateAngle(beak, 0.2808606942177475F, -0.0F, 0.0F);
        this.rightHorn1 = new MowzieModelRenderer(this, 32, 35);
        this.rightHorn1.setRotationPoint(-1.5F, -1.7F, -1.0F);
        this.rightHorn1.addBox(-0.4F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(rightHorn1, -0.8051203839449842F, 0.06981317007977318F, -0.20943951023931953F);
        this.head = new MowzieModelRenderer(this, 0, 34);
        this.head.setRotationPoint(-0.5F, 1.8F, -2.2F);
        this.head.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(head, 0.20943951023931953F, -0.0F, 0.0F);
>>>>>>> origin/master
        this.rightFrontThigh = new MowzieModelRenderer(this, 0, 16);
        this.rightFrontThigh.mirror = true;
        this.rightFrontThigh.setRotationPoint(-2.8F, 19.4F, -3.0F);
        this.rightFrontThigh.addBox(-2.0F, -1.0F, -1.0F, 2, 3, 2, 0.0F);
<<<<<<< HEAD
        ModelUtils.setRotateAngle(rightFrontThigh, 0.20943951023931953F, -0.0F, 0.0F);
        this.leftHorn1 = new MowzieModelRenderer(this, 32, 35);
        this.leftHorn1.setRotationPoint(1.5F, -1.7F, -1.0F);
        this.leftHorn1.addBox(-0.6F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        ModelUtils.setRotateAngle(leftHorn1, -0.8051203839449842F, -0.06981317007977318F, 0.20943951023931953F);
        this.leftHorn2 = new MowzieModelRenderer(this, 33, 27);
        this.leftHorn2.setRotationPoint(-0.1F, 0.29F, -3.6F);
        this.leftHorn2.addBox(-0.5F, -0.8F, -4.0F, 1, 1, 4, 0.0F);
        ModelUtils.setRotateAngle(leftHorn2, 0.1832595714594046F, 0.0F, 0.0F);
        this.quills = new MowzieModelRenderer(this, 0, 50);
        this.quills.setRotationPoint(-0.5F, 1.2F, 2.8F);
        this.quills.addBox(0.0F, -5.0F, -4.0F, 1, 5, 4, 0.0F);
        ModelUtils.setRotateAngle(quills, 0.05235987755982988F, 0.0F, 0.0F);
        this.noseHorn = new MowzieModelRenderer(this, 24, 37);
        this.noseHorn.setRotationPoint(0.0F, -0.2F, -2.0F);
        this.noseHorn.addBox(-0.5F, -0.5F, -2.2F, 1, 1, 2, 0.0F);
        ModelUtils.setRotateAngle(noseHorn, -1.1760028499937791F, -0.0F, 0.0F);
        this.frill.addChild(this.frillProtrusions);
        this.upperBody.addChild(this.neck);
        this.headPivot.addChild(this.head);
=======
        this.setRotateAngle(rightFrontThigh, 0.20943951023931953F, -0.0F, 0.0F);
        this.leftHorn1 = new MowzieModelRenderer(this, 32, 35);
        this.leftHorn1.setRotationPoint(1.5F, -1.7F, -1.0F);
        this.leftHorn1.addBox(-0.6F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(leftHorn1, -0.8051203839449842F, -0.06981317007977318F, 0.20943951023931953F);
        this.leftHorn2 = new MowzieModelRenderer(this, 33, 27);
        this.leftHorn2.setRotationPoint(-0.1F, 0.29F, -3.6F);
        this.leftHorn2.addBox(-0.5F, -0.8F, -4.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(leftHorn2, 0.1832595714594046F, 0.0F, 0.0F);
        this.quills = new MowzieModelRenderer(this, 0, 50);
        this.quills.setRotationPoint(-0.5F, 1.2F, 2.8F);
        this.quills.addBox(0.0F, -5.0F, -4.0F, 1, 5, 4, 0.0F);
        this.setRotateAngle(quills, 0.05235987755982988F, 0.0F, 0.0F);
        this.noseHorn = new MowzieModelRenderer(this, 24, 37);
        this.noseHorn.setRotationPoint(0.0F, -0.2F, -2.0F);
        this.noseHorn.addBox(-0.5F, -0.5F, -2.2F, 1, 1, 2, 0.0F);
        this.setRotateAngle(noseHorn, -1.1760028499937791F, -0.0F, 0.0F);
        this.frill.addChild(this.frillProtrusions);
        this.upperBody.addChild(this.neck);
>>>>>>> origin/master
        this.head.addChild(this.beakbottom);
        this.rightHorn1.addChild(this.rightHorn2);
        this.tail3.addChild(this.quills_2);
        this.tail1.addChild(this.tail2);
        this.tail2.addChild(this.quills_1);
        this.upperBody.addChild(this.lowerBody);
        this.leftFrontThigh.addChild(this.leftFrontLeg);
        this.tail2.addChild(this.tail3);
        this.rightFrontThigh.addChild(this.rightFrontLeg);
        this.leftHindThigh.addChild(this.leftHindLeg);
        this.rightHindThigh.addChild(this.rightHindLeg);
        this.head.addChild(this.frill);
        this.lowerBody.addChild(this.tail1);
        this.head.addChild(this.beak);
        this.head.addChild(this.rightHorn1);
<<<<<<< HEAD
        this.neck.addChild(this.headPivot);
=======
        this.neck.addChild(this.head);
>>>>>>> origin/master
        this.head.addChild(this.leftHorn1);
        this.leftHorn1.addChild(this.leftHorn2);
        this.tail1.addChild(this.quills);
        this.beak.addChild(this.noseHorn);
<<<<<<< HEAD
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

		this.faceTarget(head, 2, f3, f4);
		
		float speed = 0.5F;
		float speed2 = 0.1F;

		this.bob(upperBody, speed2, 0.2F, false, entity.ticksExisted, 1);
		this.walk(leftHindThigh, speed, 0.8F, false, 0F, 0.4F, f, f1);
		this.walk(leftHindLeg, speed, 0.2F, false, 0F, -0.6F, f, f1);
		this.walk(rightHindThigh, speed, 0.8F, true, 0F, 0.4F, f, f1);
		this.walk(rightHindLeg, speed, 0.2F, true, 0F, -0.6F, f, f1);
		this.walk(leftFrontThigh, speed, 0.8F, true, 0F, 0.4F, f, f1);
		this.walk(leftFrontLeg, speed, 0.2F, true, 0F, -0.6F, f, f1);
		this.walk(rightFrontThigh, speed, 0.8F, false, 0F, 0.4F, f, f1);
		this.walk(rightFrontLeg, speed, 0.2F, false, 0F, -0.6F, f, f1);
		this.chainWave(tailParts, speed2, 0.05F, -3, entity.ticksExisted, 1);
		this.chainSwing(tailParts, speed2, 0.35F, -3, entity.ticksExisted, 1);

	}
=======
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
