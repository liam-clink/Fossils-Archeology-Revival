package com.github.revival.client.model;

import com.github.revival.common.entity.mob.EntityDinosaur;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * Triceratops - Bluestreak
 * Created using Tabula 4.1.1
 */
public class ModelTriceratops extends ModelDinosaurs
{
    public ModelRenderer upperBody;
    public ModelRenderer rightFrontThigh;
    public ModelRenderer leftFrontThigh;
    public ModelRenderer rightHindThigh;
    public ModelRenderer leftHindThigh;
    public ModelRenderer lowerBody;
    public ModelRenderer neck;
    public ModelRenderer tail1;
    public ModelRenderer tail2;
    public ModelRenderer quills;
    public ModelRenderer tail3;
    public ModelRenderer quills_1;
    public ModelRenderer quills_2;
    public ModelRenderer head;
    public ModelRenderer beak;
    public ModelRenderer frill;
    public ModelRenderer leftHorn1;
    public ModelRenderer rightHorn1;
    public ModelRenderer noseHorn;
    public ModelRenderer frillProtrusions;
    public ModelRenderer leftHorn2;
    public ModelRenderer rightHorn2;
    public ModelRenderer rightFrontLeg;
    public ModelRenderer leftFrontLeg;
    public ModelRenderer rightHindLeg;
    public ModelRenderer leftHindLeg;
    public ModelRenderer headpivot;

    public ModelTriceratops()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.quills = new ModelRenderer(this, 0, 50);
        this.quills.setRotationPoint(-0.5F, 1.2F, 2.8F);
        this.quills.addBox(0.0F, -5.0F, -4.0F, 1, 5, 4, 0.0F);
        this.setRotateAngle(quills, 0.05235987755982988F, 0.0F, 0.0F);
        this.lowerBody = new ModelRenderer(this, 104, 1);
        this.lowerBody.setRotationPoint(0.0F, 1.98F, -1.5F);
        this.lowerBody.addBox(-3.0F, -2.0F, 0.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(lowerBody, -0.17907078125461823F, 0.0F, 0.0F);
        this.tail3 = new ModelRenderer(this, 54, 21);
        this.tail3.setRotationPoint(0.0F, 0.5F, 2.5F);
        this.tail3.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(tail3, 0.2555162024919699F, -0.0F, 0.0F);
        this.frill = new ModelRenderer(this, 20, 0);
        this.frill.setRotationPoint(0.0F, -0.3F, -1.5F);
        this.frill.addBox(-4.0F, -7.0F, 0.0F, 8, 7, 1, 0.0F);
        this.setRotateAngle(frill, -0.6618288523562498F, -0.0F, 0.0F);
        this.leftHorn1 = new ModelRenderer(this, 32, 35);
        this.leftHorn1.setRotationPoint(1.5F, -1.7F, -1.0F);
        this.leftHorn1.addBox(-0.6F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(leftHorn1, -0.8051203839449842F, -0.0F, 0.0F);
        this.rightFrontThigh = new ModelRenderer(this, 0, 16);
        this.rightFrontThigh.mirror = true;
        this.rightFrontThigh.setRotationPoint(-2.8F, 20.0F, -3.0F);
        this.rightFrontThigh.addBox(-2.0F, -1.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tail2 = new ModelRenderer(this, 68, 17);
        this.tail2.setRotationPoint(0.0F, 0.6F, 2.5F);
        this.tail2.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(tail2, -0.05044001538263612F, -0.0F, 0.0F);
        this.upperBody = new ModelRenderer(this, 77, 0);
        this.upperBody.setRotationPoint(0.0F, 14.6F, 1.0F);
        this.upperBody.addBox(-3.5F, 0.0F, -6.0F, 7, 6, 6, 0.0F);
        this.setRotateAngle(upperBody, 0.12217304763960307F, -0.0F, 0.0F);
        this.headpivot = new ModelRenderer(this, 0, 0);
        this.headpivot.setRotationPoint(-0.5F, 1.8F, -2.2F);
        this.headpivot.addBox(0F, 0F, 0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(headpivot, 0.20943951023931953F, -0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 34);
        this.head.setRotationPoint(0F, 0F, 0F);
        this.head.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(head, 0F, -0.0F, 0.0F);
        this.beak = new ModelRenderer(this, 0, 43);
        this.beak.setRotationPoint(0.0F, -0.1F, -2.5F);
        this.beak.addBox(-1.0F, -1.0F, -3.5F, 2, 3, 4, 0.0F);
        this.setRotateAngle(beak, 0.314857397059777F, -0.0F, 0.0F);
        this.leftHindLeg = new ModelRenderer(this, 32, 19);
        this.leftHindLeg.setRotationPoint(1.0F, 2.0F, 0.3F);
        this.leftHindLeg.addBox(-0.5F, -1.0F, -4.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(leftHindLeg, 1.5707963267948966F, -0.0F, 0.0F);
        this.leftFrontThigh = new ModelRenderer(this, 0, 16);
        this.leftFrontThigh.setRotationPoint(2.8F, 20.0F, -3.0F);
        this.leftFrontThigh.addBox(0.0F, -1.0F, -1.0F, 2, 3, 2, 0.0F);
        this.leftFrontLeg = new ModelRenderer(this, 16, 19);
        this.leftFrontLeg.setRotationPoint(1.3F, 1.0F, 0.5F);
        this.leftFrontLeg.addBox(-0.5F, -1.0F, -3.0F, 1, 2, 3, 0.0F);
        this.setRotateAngle(leftFrontLeg, 1.5707963267948966F, -0.0F, 0.0F);
        this.rightHorn2 = new ModelRenderer(this, 33, 27);
        this.rightHorn2.setRotationPoint(0.1F, 0.29F, -3.2F);
        this.rightHorn2.addBox(-0.5F, -0.8F, -4.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(rightHorn2, -0.0022689280275926286F, -0.0F, 0.0F);
        this.leftHorn2 = new ModelRenderer(this, 33, 27);
        this.leftHorn2.setRotationPoint(-0.1F, 0.29F, -3.2F);
        this.leftHorn2.addBox(-0.5F, -0.8F, -4.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(leftHorn2, -0.0022689280275926286F, -0.0F, 0.0F);
        this.noseHorn = new ModelRenderer(this, 24, 37);
        this.noseHorn.setRotationPoint(0.0F, -0.2F, -2.0F);
        this.noseHorn.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(noseHorn, -1.496445300659938F, -0.0F, 0.0F);
        this.rightFrontLeg = new ModelRenderer(this, 16, 19);
        this.rightFrontLeg.mirror = true;
        this.rightFrontLeg.setRotationPoint(-1.3F, 1.0F, 0.5F);
        this.rightFrontLeg.addBox(-0.5F, -1.0F, -3.0F, 1, 2, 3, 0.0F);
        this.setRotateAngle(rightFrontLeg, 1.5707963267948966F, -0.0F, 0.0F);
        this.rightHindLeg = new ModelRenderer(this, 32, 19);
        this.rightHindLeg.mirror = true;
        this.rightHindLeg.setRotationPoint(-1.0F, 2.0F, 0.3F);
        this.rightHindLeg.addBox(-0.5F, -1.0F, -4.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(rightHindLeg, 1.5707963267948966F, -0.0F, 0.0F);
        this.tail1 = new ModelRenderer(this, 48, 10);
        this.tail1.setRotationPoint(0.0F, -1.7F, 5.5F);
        this.tail1.addBox(-2.5F, -0.2F, 0.0F, 5, 4, 3, 0.0F);
        this.setRotateAngle(tail1, -0.463210383479295F, -0.0F, 0.0F);
        this.leftHindThigh = new ModelRenderer(this, 12, 24);
        this.leftHindThigh.setRotationPoint(2.0F, 18.0F, 4.0F);
        this.leftHindThigh.addBox(0.0F, -1.0F, -2.0F, 2, 4, 3, 0.0F);
        this.neck = new ModelRenderer(this, 0, 0);
        this.neck.setRotationPoint(0.5F, 0.8F, -5.0F);
        this.neck.addBox(-2.0F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(neck, -0.06981317007977318F, -0.0F, 0.0F);
        this.frillProtrusions = new ModelRenderer(this, 20, 8);
        this.frillProtrusions.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.frillProtrusions.addBox(-6.0F, -7.6F, -0.1F, 10, 8, 1, 0.0F);
        this.setRotateAngle(frillProtrusions, 0.0013962634015954637F, -0.0F, 0.0F);
        this.quills_2 = new ModelRenderer(this, 18, 52);
        this.quills_2.setRotationPoint(-0.5F, 0.7F, 3.5F);
        this.quills_2.addBox(0.0F, -5.0F, -2.0F, 1, 5, 2, 0.0F);
        this.setRotateAngle(quills_2, 0.05235987755982988F, 0.0F, 0.0F);
        this.rightHorn1 = new ModelRenderer(this, 32, 35);
        this.rightHorn1.setRotationPoint(-1.5F, -1.7F, -1.0F);
        this.rightHorn1.addBox(-0.4F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(rightHorn1, -0.8051203839449842F, -0.0F, 0.0F);
        this.rightHindThigh = new ModelRenderer(this, 12, 24);
        this.rightHindThigh.mirror = true;
        this.rightHindThigh.setRotationPoint(-2.0F, 18.0F, 4.0F);
        this.rightHindThigh.addBox(-2.0F, -1.0F, -2.0F, 2, 4, 3, 0.0F);
        this.quills_1 = new ModelRenderer(this, 10, 51);
        this.quills_1.setRotationPoint(-0.5F, 0.2F, 2.5F);
        this.quills_1.addBox(0.0F, -5.0F, -2.0F, 1, 5, 3, 0.0F);
        this.setRotateAngle(quills_1, 0.05235987755982988F, 0.0F, 0.0F);
        this.tail1.addChild(this.quills);
        this.upperBody.addChild(this.lowerBody);
        this.tail2.addChild(this.tail3);
        this.head.addChild(this.frill);
        this.head.addChild(this.leftHorn1);
        this.tail1.addChild(this.tail2);
        this.neck.addChild(this.headpivot);
        this.headpivot.addChild(head);
        this.head.addChild(this.beak);
        this.leftHindThigh.addChild(this.leftHindLeg);
        this.leftFrontThigh.addChild(this.leftFrontLeg);
        this.rightHorn1.addChild(this.rightHorn2);
        this.leftHorn1.addChild(this.leftHorn2);
        this.beak.addChild(this.noseHorn);
        this.rightFrontThigh.addChild(this.rightFrontLeg);
        this.rightHindThigh.addChild(this.rightHindLeg);
        this.lowerBody.addChild(this.tail1);
        this.upperBody.addChild(this.neck);
        this.frill.addChild(this.frillProtrusions);
        this.tail3.addChild(this.quills_2);
        this.head.addChild(this.rightHorn1);
        this.tail2.addChild(this.quills_1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ((EntityDinosaur) entity).isModelized());
        this.rightFrontThigh.render(f5);
        this.upperBody.render(f5);
        this.leftFrontThigh.render(f5);
        this.leftHindThigh.render(f5);
        this.rightHindThigh.render(f5);
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, boolean isModel)
    {
        if (!isModel)
        {
            this.headpivot.rotateAngleX = (f4 * 0.3F) / (180F / (float) Math.PI);
            this.headpivot.rotateAngleY = (f3 * 0.3F) / (180F / (float) Math.PI);

            this.leftFrontThigh.rotateAngleX = MathHelper.cos((f) * 0.63330555F + 1) * 0.7F * f1;
            this.rightFrontThigh.rotateAngleX = MathHelper.cos((f) * 0.63330555F + (float) Math.PI) * 0.7F * f1;
            this.leftHindThigh.rotateAngleX = MathHelper.cos((f) * 0.63330555F + (float) Math.PI + 2) * 0.7F * f1;
            this.rightHindThigh.rotateAngleX = MathHelper.cos((f) * 0.63330555F + 1) * 0.7F * f1;

            this.tail1.rotateAngleY = 0.06F * MathHelper.sin(f2 * (float) 0.1F + (f1 + 2));
            this.tail2.rotateAngleY = 0.07F * MathHelper.sin(f2 * (float) 0.1F + (f1 + 1));
            this.tail3.rotateAngleY = 0.07F * MathHelper.sin(f2 * (float) 0.1F + (f1));


        }
        else
        {
            this.headpivot.rotateAngleX = 0;
            this.headpivot.rotateAngleY = 0;

            this.leftFrontThigh.rotateAngleX = 0;
            this.rightFrontThigh.rotateAngleX = 0;
            this.leftHindThigh.rotateAngleX = 0;
            this.rightHindThigh.rotateAngleX = 0;

            this.tail1.rotateAngleY = 0;
            this.tail2.rotateAngleY = 0;
            this.tail3.rotateAngleY = 0;
        }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}
