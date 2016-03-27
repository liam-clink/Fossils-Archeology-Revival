package com.github.revival.client.model.prehistoric;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;

public class ModelTerrorBird extends ModelPrehistoric {
    //fields
    private AdvancedModelRenderer Body;
    private AdvancedModelRenderer RightThigh;
    private AdvancedModelRenderer RightLeg;
    private AdvancedModelRenderer LeftThigh;
    private AdvancedModelRenderer LeftLeg;
    private AdvancedModelRenderer Neck;
    private AdvancedModelRenderer Head;
    private AdvancedModelRenderer LowerBeak;
    private AdvancedModelRenderer LeftFoot;
    private AdvancedModelRenderer RightFoot;
    private AdvancedModelRenderer TailFeathers;
    private AdvancedModelRenderer BottomTailFeathers;
    private AdvancedModelRenderer Crest1;
    private AdvancedModelRenderer Crest2;
    private AdvancedModelRenderer RightWing;
    private AdvancedModelRenderer LeftWing;
    private AdvancedModelRenderer headpivot;
    private AdvancedModelRenderer headdummy;

    public ModelTerrorBird() {
        textureWidth = 128;
        textureHeight = 64;
        setTextureOffset("Body.Body", 0, 0);
        setTextureOffset("LeftThigh.LeftThigh", 44, 51);
        setTextureOffset("LeftLeg.LeftLeg", 99, 32);
        setTextureOffset("LeftFoot.LeftFoot", 71, 49);
        setTextureOffset("TailFeathers.TailFeathers", 64, 10);
        setTextureOffset("BottomTailFeathers.BottomTailFeathers", 84, 21);
        setTextureOffset("Neck.Neck", 88, 0);
        setTextureOffset("Head.Head", 0, 26);
        setTextureOffset("Head.Throat", 13, 51);
        setTextureOffset("Head.Mouth", 3, 51);
        setTextureOffset("Crest1.Crest1", 66, 0);
        setTextureOffset("Crest2.Crest2", 62, 10);
        setTextureOffset("Crest2.Crest3", 107, 15);
        setTextureOffset("LowerBeak.LowerBeak", 51, 27);
        setTextureOffset("RightWing.RightWing", 104, 0);
        setTextureOffset("LeftWing.LeftWing", 104, 0);
        setTextureOffset("RightThigh.RightThigh", 44, 51);
        setTextureOffset("RightLeg.RightLeg", 99, 32);
        setTextureOffset("RightFoot.RightFoot", 71, 49);
        setTextureOffset("headdummy.headdummy", 16, 34);
        setTextureOffset("headpivot.headpivot", 16, 27);

        Body = new AdvancedModelRenderer(this, "Body");
        Body.setRotationPoint(0F, 0.5F, -8F);
        setRotateAngle(Body, 0F, 0F, 0F);
        Body.mirror = true;
        Body.addBox("Body", -6F, 0F, 0F, 12, 10, 15);
        LeftThigh = new AdvancedModelRenderer(this, "LeftThigh");
        LeftThigh.setRotationPoint(4.5F, 6F, 10F);
        setRotateAngle(LeftThigh, 0F, 0F, 0F);
        LeftThigh.mirror = true;
        LeftThigh.mirror = true;
        LeftThigh.addBox("LeftThigh", -2F, 0F, -2F, 4, 7, 5);
        LeftThigh.mirror = false;
        LeftLeg = new AdvancedModelRenderer(this, "LeftLeg");
        LeftLeg.setRotationPoint(0F, 5F, 2.5F);
        setRotateAngle(LeftLeg, 0F, 0F, 0F);
        LeftLeg.mirror = true;
        LeftLeg.mirror = true;
        LeftLeg.addBox("LeftLeg", -1.5F, 0F, -2F, 3, 12, 3);
        LeftLeg.mirror = false;
        LeftFoot = new AdvancedModelRenderer(this, "LeftFoot");
        LeftFoot.setRotationPoint(0F, 11.5F, 0F);
        setRotateAngle(LeftFoot, 0F, 0F, 0F);
        LeftFoot.mirror = true;
        LeftFoot.mirror = true;
        LeftFoot.addBox("LeftFoot", -2.2F, -1F, -6F, 4, 2, 6);
        LeftFoot.mirror = false;
        LeftLeg.addChild(LeftFoot);
        LeftThigh.addChild(LeftLeg);
        Body.addChild(LeftThigh);
        TailFeathers = new AdvancedModelRenderer(this, "TailFeathers");
        TailFeathers.setRotationPoint(0F, 0F, 15F);
        setRotateAngle(TailFeathers, 0F, 0F, 0F);
        TailFeathers.mirror = true;
        TailFeathers.addBox("TailFeathers", -2F, 0F, 0F, 4, 1, 10);
        BottomTailFeathers = new AdvancedModelRenderer(this, "BottomTailFeathers");
        BottomTailFeathers.setRotationPoint(0F, 0F, 0F);
        setRotateAngle(BottomTailFeathers, 0F, 0F, 0F);
        BottomTailFeathers.mirror = true;
        BottomTailFeathers.addBox("BottomTailFeathers", -1.5F, 1F, 0F, 3, 2, 4);
        TailFeathers.addChild(BottomTailFeathers);
        Body.addChild(TailFeathers);

        headpivot = new AdvancedModelRenderer(this, "headpivot");
        headpivot.setRotationPoint(0F, 0F, 0.0F);
        //headpivot.addBox("headpivot", 0F, 0F, 0F, 1, 1, 1);
        setRotateAngle(headpivot, 0F, 0F, 0F);

        headdummy = new AdvancedModelRenderer(this, "headdummy");
        headdummy.setRotationPoint(0F, -14F, -1.5F);
        //headdummy.addBox("headdummy", -0.5F, -0.5F, -0.5F, 1, 1, 1);
        setRotateAngle(headpivot, 0F, 0F, 0F);

        Neck = new AdvancedModelRenderer(this, "Neck");
        Neck.setRotationPoint(0F, 5F, 3F);
        setRotateAngle(Neck, 0F, 0F, 0F);
        Neck.mirror = true;
        Neck.addBox("Neck", -2F, -14F, -4F, 4, 14, 4);
        Head = new AdvancedModelRenderer(this, "Head");
        Head.setRotationPoint(0F, 0F, 0F);
        setRotateAngle(Head, 0F, 0F, 0F);
        Head.mirror = true;
        Head.addBox("Head", -4F, -8F, -15F, 8, 8, 16);
        Head.addBox("Throat", -3.5F, -4.5F, -3.9F, 7, 4, 2);
        Head.addBox("Mouth", -3.5F, -3.5F, -13.9F, 7, 1, 10);
        Crest1 = new AdvancedModelRenderer(this, "Crest1");
        Crest1.setRotationPoint(0F, -6F, 0.4F);
        setRotateAngle(Crest1, 0F, 0F, 0F);
        Crest1.mirror = true;
        Crest1.addBox("Crest1", -2F, -2.2F, 0F, 4, 6, 4);
        Crest2 = new AdvancedModelRenderer(this, "Crest2");
        Crest2.setRotationPoint(0F, -1F, 2F);
        setRotateAngle(Crest2, 0F, 0F, 0F);
        Crest2.mirror = true;
        Crest2.addBox("Crest2", -1F, -2F, 0F, 2, 6, 4);
        Crest2.addBox("Crest3", -1F, -1.5F, 4F, 2, 6, 4);
        Crest1.addChild(Crest2);
        Head.addChild(Crest1);
        LowerBeak = new AdvancedModelRenderer(this, "LowerBeak");
        LowerBeak.setRotationPoint(0.5F, 5F, 0F);
        setRotateAngle(LowerBeak, 0F, 0F, 0F);
        LowerBeak.mirror = true;
        LowerBeak.addBox("LowerBeak", -4F, -6.5F, -14.5F, 7, 2, 14);
        Head.addChild(LowerBeak);
        Neck.addChild(headdummy);
        headpivot.addChild(Head);
        Body.addChild(Neck);
        RightWing = new AdvancedModelRenderer(this, "RightWing");
        RightWing.setRotationPoint(-6F, 2F, 6.5F);
        setRotateAngle(RightWing, 0F, 0F, 0F);
        RightWing.mirror = true;
        RightWing.addBox("RightWing", -1F, 0F, -4.5F, 1, 5, 9);
        Body.addChild(RightWing);
        LeftWing = new AdvancedModelRenderer(this, "LeftWing");
        LeftWing.setRotationPoint(6F, 2F, 5.5F);
        setRotateAngle(LeftWing, 0F, 0F, 0F);
        LeftWing.mirror = true;
        LeftWing.mirror = true;
        LeftWing.addBox("LeftWing", 0F, 0F, -4.5F, 1, 5, 9);
        LeftWing.mirror = false;
        Body.addChild(LeftWing);
        RightThigh = new AdvancedModelRenderer(this, "RightThigh");
        RightThigh.setRotationPoint(-4.5F, 6F, 10F);
        setRotateAngle(RightThigh, 0F, 0F, 0F);
        RightThigh.mirror = true;
        RightThigh.addBox("RightThigh", -2F, 0F, -2F, 4, 7, 5);
        RightLeg = new AdvancedModelRenderer(this, "RightLeg");
        RightLeg.setRotationPoint(0F, 5F, 2.5F);
        setRotateAngle(RightLeg, 0F, 0F, 0F);
        RightLeg.mirror = true;
        RightLeg.addBox("RightLeg", -1.5F, 0F, -2F, 3, 12, 3);
        RightFoot = new AdvancedModelRenderer(this, "RightFoot");
        RightFoot.setRotationPoint(0F, 11.5F, 0F);
        setRotateAngle(RightFoot, 0F, 0F, 0F);
        RightFoot.mirror = true;
        RightFoot.addBox("RightFoot", -2F, -1F, -6F, 4, 2, 6);
        RightLeg.addChild(RightFoot);
        RightThigh.addChild(RightLeg);
        Body.addChild(RightThigh);
        doAdvancedStuff(false);
    }

   /* public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7);

//    Body.render(f5);
        //headpivot.render(var7);
        if (this.isChild)
        {
            float babyScale = 2.5F;
            float babyHeadScale = 3F;
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / babyHeadScale, 1.0F / babyHeadScale, 1.0F / babyHeadScale);
            GL11.glTranslatef(0.0F, 40.0F * var7, 1.0F * var7);
            this.headpivot.render(var7);
            GL11.glPopMatrix();

            GL11.glPushMatrix();
            GL11.glScalef(1.0F / babyScale, 1.0F / babyScale, 0.7F / babyScale);
            GL11.glTranslatef(0.0F, 35.0F * var7, 0.0F);
            this.Body.render(var7);
            GL11.glPopMatrix();
        }
        else
        {
            this.Body.render(var7);
            this.headpivot.render(var7);
        }
    }

  /*
    public void setRotationAngles(float time, float speed, float wingAnimation, float headPitch, float headYaw, float scale)
    {
        this.headpivot.rotateAngleX = headYaw / (180F / (float) Math.PI);
        this.headpivot.rotateAngleY = headPitch / (180F / (float) Math.PI);

        this.RightWing.rotateAngleZ = wingAnimation;
        this.LeftWing.rotateAngleZ = -wingAnimation;
    }*/

    /*
    public void setLivingAnimations(EntityLivingBase entityBase, float time, float speed, float extraAnim)
    {
        EntityTerrorBird entity = (EntityTerrorBird) entityBase;


        if (entity.isAngry())
        {
            this.RightWing.rotateAngleZ = (float) Math.toRadians(45F);
            this.LeftWing.rotateAngleZ = (float) Math.toRadians(45F);
            this.Neck.rotateAngleX = (float) Math.toRadians(60F);
            this.headpivot.rotationPointY = this.headdummy.rotationPointY + 15;
            this.headpivot.rotationPointZ = this.headdummy.rotationPointZ - 15;
        }
        else
        {
            this.RightWing.rotateAngleZ = extraAnim;
            this.LeftWing.rotateAngleZ = -extraAnim;
            this.Neck.rotateAngleX = (float) Math.toRadians(26F);
            this.headpivot.rotationPointY = this.headdummy.rotationPointY + 10;
            this.headpivot.rotationPointZ = this.headdummy.rotationPointZ - 11;
        }

        if (entity.isSitting())
        {
            this.headpivot.rotationPointX = this.headdummy.rotationPointX;
            this.headpivot.rotationPointY = this.headdummy.rotationPointY + 22;
            this.headpivot.rotationPointZ = this.headdummy.rotationPointZ - 8;

            this.Neck.rotateAngleX = (float) Math.toRadians(10F);
            this.RightThigh.rotateAngleX = (float) Math.toRadians(45F);
            this.LeftThigh.rotateAngleX = (float) Math.toRadians(45F);
            this.RightLeg.rotateAngleX = (float) Math.toRadians(-135F);
            this.LeftLeg.rotateAngleX = (float) Math.toRadians(-135F);
            this.RightFoot.rotateAngleX = (float) Math.toRadians(-92F);
            this.LeftFoot.rotateAngleX = (float) Math.toRadians(-92F);
            this.TailFeathers.rotateAngleX = (float) Math.toRadians(-10F);
            this.BottomTailFeathers.rotateAngleX = (float) Math.toRadians(-10F);

            this.Body.rotationPointY = 12.5F;
            this.LeftLeg.rotationPointY = 5.5F;
            this.RightLeg.rotationPointY = 5.5F;
            this.LeftLeg.rotationPointX = -0.75F;
            this.RightLeg.rotationPointX = 0.75F;
        }
        else
        {
            this.headpivot.rotationPointX = this.headdummy.rotationPointX;

            //this.Neck.rotateAngleX = (float) Math.toRadians(26F);
            this.RightThigh.rotateAngleX = 0;
            this.LeftThigh.rotateAngleX = 0;
            this.RightLeg.rotateAngleX = (float) Math.toRadians(-8F);
            this.LeftLeg.rotateAngleX = (float) Math.toRadians(-8F);
            this.RightFoot.rotateAngleX = (float) Math.toRadians(8F);
            this.LeftFoot.rotateAngleX = (float) Math.toRadians(8F);
            this.TailFeathers.rotateAngleX = (float) Math.toRadians(-10F);
            this.BottomTailFeathers.rotateAngleX = (float) Math.toRadians(-10F);

            this.RightThigh.rotateAngleX = MathHelper.cos(time * 0.6662F) * 1.4F * speed;
            this.LeftThigh.rotateAngleX = MathHelper.cos(time * 0.6662F + (float) Math.PI) * 1.4F * speed;

            this.Body.rotationPointY = 0.5F;
            this.LeftLeg.rotationPointY = 5F;
            this.RightLeg.rotationPointY = 5F;
            this.LeftLeg.rotationPointZ = 0;
            this.RightLeg.rotationPointZ = 0;
        }


        this.headpivot.rotateAngleZ = entity.getInterestedAngle(extraAnim);
    }
    */

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

}
