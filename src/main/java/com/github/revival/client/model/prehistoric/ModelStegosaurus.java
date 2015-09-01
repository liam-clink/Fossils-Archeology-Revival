package com.github.revival.client.model.prehistoric;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.common.entity.mob.EntityDinosaur;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;


public class ModelStegosaurus extends ModelPrehistoric
{
    //fields
    private MowzieModelRenderer lowerBody;
    private MowzieModelRenderer platesLowerBody;
    private MowzieModelRenderer stegosaurus;
    private MowzieModelRenderer rightBackUpperLeg;
    private MowzieModelRenderer rightBackLowerLeg;
    private MowzieModelRenderer rightFrontUpperLeg;
    private MowzieModelRenderer rightFrontLowerLeg;
    private MowzieModelRenderer upperBody;
    private MowzieModelRenderer platesUpperBody;
    private MowzieModelRenderer neck;
    private MowzieModelRenderer platesNeck;
    private MowzieModelRenderer head;
    private MowzieModelRenderer tail1;
    private MowzieModelRenderer platesTail2;
    private MowzieModelRenderer tail3;
    private MowzieModelRenderer tail2;
    private MowzieModelRenderer leftThagomizer;
    private MowzieModelRenderer rightThagomizer;
    private MowzieModelRenderer platesTail1;
    private MowzieModelRenderer leftFrontUpperLeg;
    private MowzieModelRenderer leftFrontLowerLeg;
    private MowzieModelRenderer leftBackUpperLeg;
    private MowzieModelRenderer leftBackLowerLeg;
    private MowzieModelRenderer headdummy;
    private MowzieModelRenderer headpivot;


    public ModelStegosaurus()
    {
        textureWidth = 128;
        textureHeight = 64;
        setTextureOffset("head.head", 0, 0);
        setTextureOffset("lowerBody.lowerBody", 18, 6);
        setTextureOffset("platesLowerBody.platesLowerBody", 32, 51);
        setTextureOffset("tail1.tail1", 0, 23);
        setTextureOffset("tail2.tail2", 20, 24);
        setTextureOffset("platesTail2.platesTail2", 71, 42);
        setTextureOffset("tail3.tail3", 7, 34);
        setTextureOffset("leftThagomizer.leftThagomizer", 0, 55);
        setTextureOffset("rightThagomizer.rightThagomizer", 0, 55);
        setTextureOffset("platesTail1.platesTail1", 20, 55);
        setTextureOffset("rightBackUpperLeg.rightBackUpperLeg", 14, 46);
        setTextureOffset("rightBackLowerLeg.rightBackLowerLeg", 0, 38);
        setTextureOffset("rightFrontUpperLeg.rightFrontUpperLeg", 44, 46);
        setTextureOffset("rightFrontLowerLeg.rightFrontLowerLeg", 12, 0);
        setTextureOffset("upperBody.upperBody", 0, 14);
        setTextureOffset("platesUpperBody.platesUpperBody", 52, 55);
        setTextureOffset("neck.neck", 0, 8);
        setTextureOffset("platesNeck.platesNeck", 64, 56);
        setTextureOffset("leftFrontUpperLeg.leftFrontUpperLeg", 44, 46);
        setTextureOffset("leftFrontLowerLeg.leftFrontLowerLeg", 12, 0);
        setTextureOffset("leftBackUpperLeg.leftBackUpperLeg", 14, 46);
        setTextureOffset("leftBackLowerLeg.leftBackLowerLeg", 0, 38);

        headpivot = new MowzieModelRenderer(this, "headpivot");
        headpivot.setRotationPoint(0F, 16.5F, -12.5F);
        setRotateAngle(headpivot, 0F, 0F, 0F);
        headpivot.mirror = true;
        head = new MowzieModelRenderer(this, "head");
        head.setRotationPoint(0F, 0F, 1F);
        setRotateAngle(head, 0F, 0F, 0F);
        head.mirror = true;
        head.addBox("head", -1F, -1.6F, -5F, 2, 3, 5);
        headpivot.addChild(head);
        stegosaurus = new MowzieModelRenderer(this, "stegosaurus");
        stegosaurus.setRotationPoint(0F, 13F, -6F);
        setRotateAngle(stegosaurus, 0F, 0F, 0F);
        stegosaurus.mirror = true;
        lowerBody = new MowzieModelRenderer(this, "lowerBody");
        lowerBody.setRotationPoint(0F, 0F, 0F);
        setRotateAngle(lowerBody, 0F, 0F, 0F);
        lowerBody.mirror = true;
        lowerBody.addBox("lowerBody", -3.5F, 0F, 0F, 7, 8, 8);
        platesLowerBody = new MowzieModelRenderer(this, "platesLowerBody");
        platesLowerBody.setRotationPoint(0F, 0.5F, 4.5F);
        setRotateAngle(platesLowerBody, 0F, 0F, 0F);
        platesLowerBody.mirror = true;
        platesLowerBody.addBox("platesLowerBody", -1F, -5F, -4F, 2, 5, 8);
        lowerBody.addChild(platesLowerBody);
        tail1 = new MowzieModelRenderer(this, "tail1");
        tail1.setRotationPoint(0F, 2F, 8F);
        setRotateAngle(tail1, 0F, 0F, 0F);
        tail1.mirror = true;
        tail1.addBox("tail1", -2.5F, -1.5F, -1F, 5, 5, 5);
        tail2 = new MowzieModelRenderer(this, "tail2");
        tail2.setRotationPoint(0F, 0F, 2.733333F);
        setRotateAngle(tail2, 0F, 0F, 0F);
        tail2.mirror = true;
        tail2.addBox("tail2", -1.5F, -1F, 0.5F, 3, 3, 6);
        platesTail2 = new MowzieModelRenderer(this, "platesTail2");
        platesTail2.setRotationPoint(0F, -0.5F, 3F);
        setRotateAngle(platesTail2, 0F, 0F, 0F);
        platesTail2.mirror = true;
        platesTail2.addBox("platesTail2", -0.5F, -5F, -3F, 1, 5, 8);
        tail2.addChild(platesTail2);
        tail3 = new MowzieModelRenderer(this, "tail3");
        tail3.setRotationPoint(0F, -0.9F, 5.5F);
        setRotateAngle(tail3, 0F, 0F, 0F);
        tail3.mirror = true;
        tail3.addBox("tail3", -1F, 0F, 0.5F, 2, 2, 4);
        leftThagomizer = new MowzieModelRenderer(this, "leftThagomizer");
        leftThagomizer.setRotationPoint(0.5F, 0.5F, 3F);
        setRotateAngle(leftThagomizer, 0F, 0F, 0F);
        leftThagomizer.mirror = true;
        leftThagomizer.addBox("leftThagomizer", 0F, -5F, -1F, 1, 5, 4);
        tail3.addChild(leftThagomizer);
        rightThagomizer = new MowzieModelRenderer(this, "rightThagomizer");
        rightThagomizer.setRotationPoint(-0.5F, 0.5F, 3F);
        setRotateAngle(rightThagomizer, 0F, 0F, 0F);
        rightThagomizer.mirror = false;
        rightThagomizer.addBox("rightThagomizer", -1F, -5F, -1F, 1, 5, 4);
        tail3.addChild(rightThagomizer);
        tail2.addChild(tail3);
        tail1.addChild(tail2);
        platesTail1 = new MowzieModelRenderer(this, "platesTail1");
        platesTail1.setRotationPoint(0F, -1.5F, 1.5F);
        setRotateAngle(platesTail1, 0F, 0F, 0F);
        platesTail1.mirror = true;
        platesTail1.addBox("platesTail1", -1F, -4.5F, -2F, 2, 5, 4);
        tail1.addChild(platesTail1);
        lowerBody.addChild(tail1);
        stegosaurus.addChild(lowerBody);
        rightBackUpperLeg = new MowzieModelRenderer(this, "rightBackUpperLeg");
        rightBackUpperLeg.setRotationPoint(-4F, 3.5F, 7F);
        setRotateAngle(rightBackUpperLeg, 0F, 0F, 0F);
        rightBackUpperLeg.mirror = true;
        rightBackUpperLeg.mirror = true;
        rightBackUpperLeg.addBox("rightBackUpperLeg", -1F, -0.5F, -2F, 2, 5, 4);
        rightBackUpperLeg.mirror = false;
        rightBackLowerLeg = new MowzieModelRenderer(this, "rightBackLowerLeg");
        rightBackLowerLeg.setRotationPoint(0F, 4F, 1F);
        setRotateAngle(rightBackLowerLeg, 0F, 0F, 0F);
        rightBackLowerLeg.mirror = true;
        rightBackLowerLeg.mirror = true;
        rightBackLowerLeg.addBox("rightBackLowerLeg", -0.5F, -0.5F, -3.5F, 1, 2, 5);
        rightBackLowerLeg.mirror = false;
        rightBackUpperLeg.addChild(rightBackLowerLeg);
        stegosaurus.addChild(rightBackUpperLeg);
        rightFrontUpperLeg = new MowzieModelRenderer(this, "rightFrontUpperLeg");
        rightFrontUpperLeg.setRotationPoint(-4F, 5F, 0F);
        setRotateAngle(rightFrontUpperLeg, 0F, 0F, 0F);
        rightFrontUpperLeg.mirror = true;
        rightFrontUpperLeg.mirror = true;
        rightFrontUpperLeg.addBox("rightFrontUpperLeg", -1F, 0.0F, -1F, 2, 3, 2);
        rightFrontUpperLeg.mirror = false;
        rightFrontLowerLeg = new MowzieModelRenderer(this, "rightFrontLowerLeg");
        rightFrontLowerLeg.setRotationPoint(0F, 3F, -0.5F);
        setRotateAngle(rightFrontLowerLeg, 0F, 0F, 0F);
        rightFrontLowerLeg.mirror = true;
        rightFrontLowerLeg.mirror = true;
        rightFrontLowerLeg.addBox("rightFrontLowerLeg", -0.5F, 0F, -3F, 1, 2, 3);
        rightFrontLowerLeg.mirror = false;
        rightFrontUpperLeg.addChild(rightFrontLowerLeg);
        stegosaurus.addChild(rightFrontUpperLeg);
        upperBody = new MowzieModelRenderer(this, "upperBody");
        upperBody.setRotationPoint(0F, 1F, 0.5F);
        setRotateAngle(upperBody, 0F, 0F, 0F);
        upperBody.mirror = true;
        upperBody.addBox("upperBody", -2.5F, 0F, -4F, 5, 5, 4);
        platesUpperBody = new MowzieModelRenderer(this, "platesUpperBody");
        platesUpperBody.setRotationPoint(0F, 0F, -2F);
        setRotateAngle(platesUpperBody, 0F, 0F, 0F);
        platesUpperBody.mirror = true;
        platesUpperBody.mirror = true;
        platesUpperBody.addBox("platesUpperBody", -1F, -4F, -2F, 2, 5, 4);
        platesUpperBody.mirror = false;
        upperBody.addChild(platesUpperBody);
        neck = new MowzieModelRenderer(this, "neck");
        neck.setRotationPoint(0F, 3F, -3.5F);
        setRotateAngle(neck, 0F, 0F, 0F);
        neck.mirror = true;
        neck.addBox("neck", -1.5F, -2F, -3F, 3, 3, 3);
        platesNeck = new MowzieModelRenderer(this, "platesNeck");
        platesNeck.setRotationPoint(0F, -2F, 0F);
        setRotateAngle(platesNeck, 0F, 0F, 0F);
        platesNeck.mirror = true;
        platesNeck.addBox("platesNeck", -0.5F, -3F, -2.433333F, 1, 4, 4);
        neck.addChild(platesNeck);
        headdummy = new MowzieModelRenderer(this, "headdummy");
        headdummy.setRotationPoint(0F, -0.5F, -2.5F);
        setRotateAngle(headdummy, 0F, 0F, 0F);
        headdummy.mirror = true;
        neck.addChild(headdummy);
        upperBody.addChild(neck);
        stegosaurus.addChild(upperBody);
        leftFrontUpperLeg = new MowzieModelRenderer(this, "leftFrontUpperLeg");
        leftFrontUpperLeg.setRotationPoint(4F, 5F, 0F);
        setRotateAngle(leftFrontUpperLeg, 0F, 0F, 0F);
        leftFrontUpperLeg.mirror = true;
        leftFrontUpperLeg.addBox("leftFrontUpperLeg", -1F, 0F, -1F, 2, 3, 2);
        leftFrontLowerLeg = new MowzieModelRenderer(this, "leftFrontLowerLeg");
        leftFrontLowerLeg.setRotationPoint(0F, 3F, -0.5F);
        setRotateAngle(leftFrontLowerLeg, 0F, 0F, 0F);
        leftFrontLowerLeg.mirror = true;
        leftFrontLowerLeg.addBox("leftFrontLowerLeg", -0.5F, 0F, -3F, 1, 2, 3);
        leftFrontUpperLeg.addChild(leftFrontLowerLeg);
        stegosaurus.addChild(leftFrontUpperLeg);
        leftBackUpperLeg = new MowzieModelRenderer(this, "leftBackUpperLeg");
        leftBackUpperLeg.setRotationPoint(4F, 3.5F, 7F);
        setRotateAngle(leftBackUpperLeg, 0F, 0F, 0F);
        leftBackUpperLeg.mirror = true;
        leftBackUpperLeg.addBox("leftBackUpperLeg", -1F, -0.5F, -2F, 2, 5, 4);
        leftBackLowerLeg = new MowzieModelRenderer(this, "leftBackLowerLeg");
        leftBackLowerLeg.setRotationPoint(0F, 4F, 1F);
        setRotateAngle(leftBackLowerLeg, 0F, 0F, 0F);
        leftBackLowerLeg.mirror = true;
        leftBackLowerLeg.addBox("leftBackLowerLeg", -0.5F, -0.5F, -3.5F, 1, 2, 5);
        leftBackUpperLeg.addChild(leftBackLowerLeg);
        stegosaurus.addChild(leftBackUpperLeg);
        doMowzieStuff(false);
    }


    /*
    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean isModelized)
    {
        this.lowerBody.rotateAngleX = (float) Math.toRadians(5);
        this.upperBody.rotateAngleX = (float) Math.toRadians(7F);
        this.neck.rotateAngleX = (float) Math.toRadians(-14F);
        this.head.rotateAngleX = (float) Math.toRadians(15F);

        this.leftBackLowerLeg.rotateAngleX = (float) Math.toRadians(90);
        this.rightBackLowerLeg.rotateAngleX = (float) Math.toRadians(90);
        this.leftFrontLowerLeg.rotateAngleX = (float) Math.toRadians(90);
        this.rightFrontLowerLeg.rotateAngleX = (float) Math.toRadians(90);

        this.tail1.rotateAngleX = (float) Math.toRadians(-15);
        this.tail2.rotateAngleX = (float) Math.toRadians(5);
        this.tail3.rotateAngleX = (float) Math.toRadians(3);

        this.rightThagomizer.rotateAngleZ = (float) Math.toRadians(-67);
        this.leftThagomizer.rotateAngleZ = (float) Math.toRadians(67);

        this.rightThagomizer.rotateAngleY = (float) Math.toRadians(13);
        this.leftThagomizer.rotateAngleY = (float) Math.toRadians(-13);


        //Living animations
        if (!isModelized)
        {
            this.head.rotateAngleX = var5 / (180F / (float) Math.PI);
            this.head.rotateAngleY = var4 / (180F / (float) Math.PI);

            this.tail1.rotateAngleY = 0.05F * MathHelper.sin(var3 * (float) 0.1F + (var2 + 2));
            this.tail2.rotateAngleY = 0.1F * MathHelper.sin(var3 * (float) 0.1F + (var2 + 1));
            this.tail3.rotateAngleY = 0.15F * MathHelper.sin(var3 * (float) 0.1F + var2);

            this.leftFrontUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 0.7F * var2;
            this.rightFrontUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float) Math.PI) * 0.7F * var2;
            this.leftBackUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + (float) Math.PI + 2) * 0.7F * var2;
            this.rightBackUpperLeg.rotateAngleX = MathHelper.cos((var1) * 0.63330555F + 1) * 0.7F * var2;
        }
        else
        {
            this.head.rotateAngleX = 0;
            this.head.rotateAngleY = 0;

            this.leftFrontUpperLeg.rotateAngleX = 0;
            this.rightFrontUpperLeg.rotateAngleX = 0;
            this.leftBackUpperLeg.rotateAngleX = 0;
            this.rightBackUpperLeg.rotateAngleX = 0;

            this.tail1.rotateAngleY = 0;
            this.tail2.rotateAngleY = 0;
            this.tail3.rotateAngleY = 0;
        }
    }
*/

	@Override
	public void renderFossil(EntityNewPrehistoric entity, float f, float f1,
			float f2, float f3, float f4, float f5) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void renderLiving(EntityNewPrehistoric entity, float f, float f1,
			float f2, float f3, float f4, float f5) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void renderSleeping(EntityNewPrehistoric entity, float f, float f1,
			float f2, float f3, float f4, float f5) {
		// TODO Auto-generated method stub
		
	}


}
