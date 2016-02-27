package com.github.revival.client.model.prehistoric;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;

public class ModelPlesiosaurus extends ModelPrehistoric {
    //fields
    private MowzieModelRenderer Body;
    private MowzieModelRenderer rightleg;
    private MowzieModelRenderer leftleg;
    private MowzieModelRenderer leftarm;
    private MowzieModelRenderer rightarm;
    private MowzieModelRenderer tail1;
    private MowzieModelRenderer tail2;
    private MowzieModelRenderer tail3;
    private MowzieModelRenderer Neck1;
    private MowzieModelRenderer Neck2;
    private MowzieModelRenderer Neck4;
    private MowzieModelRenderer Neck3;
    private MowzieModelRenderer head;
    private float moveRate;

    public ModelPlesiosaurus() {
        textureWidth = 64;
        textureHeight = 32;
        setTextureOffset("Body.Body", 0, 0);
        setTextureOffset("leftleg.leftleg", 48, 4);
        setTextureOffset("rightleg.rightleg", 48, 0);
        setTextureOffset("leftarm.leftarm", 44, 18);
        setTextureOffset("rightarm.rightarm", 44, 13);
        setTextureOffset("tail1.tail1", 0, 14);
        setTextureOffset("tail2.tail2", 18, 14);
        setTextureOffset("tail3.tail3", 24, 0);
        setTextureOffset("Neck1.Neck1", 20, 23);
        setTextureOffset("Neck2.Neck2", 47, 23);
        setTextureOffset("Neck3.Neck3", 35, 3);
        setTextureOffset("Neck4.Neck4", 35, 3);
        setTextureOffset("head.head", 0, 22);

        Body = new MowzieModelRenderer(this, "Body");
        Body.setRotationPoint(0F, 19F, -4F);
        setRotateAngle(Body, 0F, 0F, 0F);
        Body.mirror = true;
        Body.addBox("Body", -4F, -3F, 0F, 8, 6, 8);
        leftleg = new MowzieModelRenderer(this, "leftleg");
        leftleg.setRotationPoint(4F, 2F, 7F);
        setRotateAngle(leftleg, 0F, 0F, 0F);
        leftleg.mirror = true;
        leftleg.addBox("leftleg", 0F, 0F, -1.5F, 5, 1, 3);
        Body.addChild(leftleg);
        rightleg = new MowzieModelRenderer(this, "rightleg");
        rightleg.setRotationPoint(-3F, 2F, 7F);
        setRotateAngle(rightleg, 0F, 0F, 0F);
        rightleg.mirror = true;
        rightleg.addBox("rightleg", -6F, 0F, -1.5F, 5, 1, 3);
        Body.addChild(rightleg);
        leftarm = new MowzieModelRenderer(this, "leftarm");
        leftarm.setRotationPoint(3F, 2F, 1F);
        setRotateAngle(leftarm, 0F, 0F, 0F);
        leftarm.mirror = true;
        leftarm.addBox("leftarm", 0F, 0F, -4F, 6, 1, 4);
        Body.addChild(leftarm);
        rightarm = new MowzieModelRenderer(this, "rightarm");
        rightarm.setRotationPoint(-3F, 2F, 1F);
        setRotateAngle(rightarm, 0F, 0F, 0F);
        rightarm.mirror = true;
        rightarm.addBox("rightarm", -6F, 0F, -4F, 6, 1, 4);
        Body.addChild(rightarm);
        tail1 = new MowzieModelRenderer(this, "tail1");
        tail1.setRotationPoint(0F, -3F, 8F);
        setRotateAngle(tail1, 0F, 0F, 0F);
        tail1.mirror = true;
        tail1.addBox("tail1", -3F, 0F, 0F, 6, 5, 3);
        tail2 = new MowzieModelRenderer(this, "tail2");
        tail2.setRotationPoint(0F, 3F, 2.5F);
        setRotateAngle(tail2, 0F, 0F, 0F);
        tail2.mirror = true;
        tail2.addBox("tail2", -2F, -2F, 0F, 4, 3, 6);
        tail3 = new MowzieModelRenderer(this, "tail3");
        tail3.setRotationPoint(0F, -1F, 5.5F);
        setRotateAngle(tail3, 0F, 0F, 0F);
        tail3.mirror = true;
        tail3.addBox("tail3", -1F, -1F, 0F, 2, 2, 6);
        tail2.addChild(tail3);
        tail1.addChild(tail2);
        Body.addChild(tail1);
        this.Neck1 = new MowzieModelRenderer(this, "Neck1");
        this.Neck1.setRotationPoint(0F, 0F, 1F);
        this.setRotateAngle(Neck1, 0F, 0F, 0F);
        this.Neck1.mirror = true;
        this.Neck1.addBox("Neck1", -3F, -3F, -4F, 6, 5, 4);
        Neck2 = new MowzieModelRenderer(this, "Neck2");
        Neck2.setRotationPoint(0F, 0F, -3F);
        setRotateAngle(Neck2, (float) Math.toRadians(-60), 0F, 0F);
        Neck2.mirror = true;
        Neck2.addBox("Neck2", -2F, -2F, -5F, 4, 4, 5);
        Neck3 = new MowzieModelRenderer(this, "Neck3");
        Neck3.setRotationPoint(0F, 1F, -4F);
        setRotateAngle(Neck3, 0F, 0F, 0F);
        Neck3.mirror = true;
        Neck3.addBox("Neck3", -1F, -2F, -5F, 2, 3, 5);
        Neck4 = new MowzieModelRenderer(this, "Neck4");
        Neck4.setRotationPoint(0F, 0F, -4F);
        setRotateAngle(Neck4, 0F, 0F, 0F);
        Neck4.mirror = true;
        Neck4.addBox("Neck4", -1F, -2F, -5F, 2, 3, 5);
        head = new MowzieModelRenderer(this, "head");
        head.setRotationPoint(0F, -0.5F, -4F);
        setRotateAngle(head, 0F, 0F, 0F);
        head.mirror = true;
        head.addBox("head", -2F, -2F, -6F, 4, 4, 6);
        Neck4.addChild(head);
        Neck3.addChild(Neck4);
        Neck2.addChild(Neck3);
        Neck1.addChild(Neck2);
        Body.addChild(Neck1);
    }

   /* protected void setRotationAngles(float var1, float var2, float var3,
                                     float var4, float var5, float var6, boolean isModelized)
    {

        //this.Neck1.rotateAngleX = (float)Math.toRadians(-60);
        //this.Neck2.rotateAngleX = (float)Math.toRadians(10);
        //this.Neck3.rotateAngleX = (float)Math.toRadians(10);
        //this.Neck4.rotateAngleX = (float)Math.toRadians(20);

        if (!isModelized)
        {
            this.head.rotateAngleX = (float) Math.toRadians(20) + (var5 / (180F / (float) Math.PI));
            this.head.rotateAngleY = var4 / (180F / (float) Math.PI);

            if (this.Neck1.rotateAngleX > (float) Math.toRadians(-10))
            {
                this.moveRate = 6F;

                this.Neck1.rotateAngleY = 0.01F * MathHelper.cos((var1 * (float) 0.4F) + var2 + 3);
                this.Neck2.rotateAngleY = 0.02F * MathHelper.cos((var1 * (float) 0.4F) + var2 + 2);
                this.Neck3.rotateAngleY = 0.03F * MathHelper.cos((var1 * (float) 0.4F) + var2 + 1);
                this.Neck4.rotateAngleY = 0.04F * MathHelper.cos((var1 * (float) 0.4F) + var2);
                this.head.rotateAngleY = -this.Neck4.rotateAngleY;
            }
            else
                this.moveRate = 2F;

            this.Neck1.rotateAngleX = Math.min(Math.max(((float) Math.toRadians(-60) + ((this.moveRate) * 1.0F * var2)), (float) Math.toRadians(-60)), 0);
            this.Neck2.rotateAngleX = Math.min(Math.max(((float) Math.toRadians(10) - ((this.moveRate * 0.6F) * 1.0F * var2)), (float) Math.toRadians(0)), 10);
            this.Neck3.rotateAngleX = Math.min(Math.max(((float) Math.toRadians(10) - ((this.moveRate * 0.5F) * 1.0F * var2)), (float) Math.toRadians(0)), 10);
            this.Neck4.rotateAngleX = Math.min(Math.max(((float) Math.toRadians(20) - ((this.moveRate * 0.4F) * 1.0F * var2)), (float) Math.toRadians(0)), 20);

            this.leftarm.rotateAngleX = (float) Math.toRadians(25);
            this.leftarm.rotateAngleY = (float) Math.toRadians(-45);
            this.leftarm.rotateAngleZ = (float) Math.toRadians(-0) + MathHelper.cos(var1 * 0.15F) * var2;

            this.rightarm.rotateAngleX = (float) Math.toRadians(25);
            this.rightarm.rotateAngleY = (float) Math.toRadians(45);
            this.rightarm.rotateAngleZ = (float) Math.toRadians(0) + MathHelper.cos(var1 * 0.15F + 3.1415927F) * var2;

            this.leftleg.rotateAngleX = (float) Math.toRadians(25);
            this.leftleg.rotateAngleY = (float) Math.toRadians(-45);
            this.leftleg.rotateAngleZ = (float) Math.toRadians(-0) - MathHelper.cos(var1 * 0.15F) * var2;

            this.rightleg.rotateAngleX = (float) Math.toRadians(25);
            this.rightleg.rotateAngleY = (float) Math.toRadians(45);
            this.rightleg.rotateAngleZ = (float) Math.toRadians(0) - MathHelper.cos(var1 * 0.15F + 3.1415927F) * var2;

            this.tail1.rotateAngleX = (float) Math.toRadians(-25);
            this.tail2.rotateAngleX = (float) Math.toRadians(10);
            this.tail3.rotateAngleX = (float) Math.toRadians(10);

            this.tail1.rotateAngleY = 0.1F * MathHelper.cos((var1 * (float) 0.4F) + var2 + 3);
            this.tail2.rotateAngleY = 0.2F * MathHelper.cos((var1 * (float) 0.4F) + var2 + 2);
            this.tail3.rotateAngleY = 0.3F * MathHelper.cos((var1 * (float) 0.4F) + var2 + 1);
        }
        else
        {
            this.head.rotateAngleX = (float) Math.toRadians(30);
            this.head.rotateAngleY = 0;

            this.Neck1.rotateAngleX = (float) Math.toRadians(-60);
            this.Neck2.rotateAngleX = (float) Math.toRadians(10);
            this.Neck3.rotateAngleX = (float) Math.toRadians(10);
            this.Neck4.rotateAngleX = (float) Math.toRadians(20);

            this.rightarm.rotateAngleX = (float) Math.toRadians(25.0);
            this.rightarm.rotateAngleY = (float) Math.toRadians(45.0);

            this.leftarm.rotateAngleX = (float) Math.toRadians(25.0);
            this.leftarm.rotateAngleY = (float) Math.toRadians(-45.0);

            this.rightleg.rotateAngleX = (float) Math.toRadians(25.0);
            this.rightleg.rotateAngleY = (float) Math.toRadians(45.0);

            this.leftleg.rotateAngleX = (float) Math.toRadians(25.0);
            this.leftleg.rotateAngleY = (float) Math.toRadians(-45.0);

            this.tail1.rotateAngleX = (float) Math.toRadians(-25);
            this.tail2.rotateAngleX = (float) Math.toRadians(10);
            this.tail3.rotateAngleX = (float) Math.toRadians(10);

            this.tail1.rotateAngleY = 0;
            this.tail2.rotateAngleY = 0;
            this.tail3.rotateAngleY = 0;
        }

    }*/

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
