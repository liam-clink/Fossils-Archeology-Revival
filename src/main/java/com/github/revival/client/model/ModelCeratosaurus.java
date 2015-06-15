package com.github.revival.client.model;

import com.github.revival.common.entity.mob.EntityDinosaur;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * Ceratosaurus - Bluestreak
 * Created using Tabula 4.1.1
 */
public class ModelCeratosaurus extends ModelDinosaurs {
    public ModelRenderer leftThigh;
    public ModelRenderer rightThigh;
    public ModelRenderer lowerBody;
    public ModelRenderer leftLeg;
    public ModelRenderer leftFoot;
    public ModelRenderer rightLeg;
    public ModelRenderer rightFoot;
    public ModelRenderer upperBody;
    public ModelRenderer tail1;
    public ModelRenderer leftUpperArm;
    public ModelRenderer rightUpperArm;
    public ModelRenderer neck;
    public ModelRenderer leftLowerArm;
    public ModelRenderer rightLowerArm;
    public ModelRenderer head;
    public ModelRenderer leftHorn;
    public ModelRenderer upperJaw;
    public ModelRenderer lowerJaw;
    public ModelRenderer rightHorn;
    public ModelRenderer frontNasalCrest;
    public ModelRenderer backNasalCrest;
    public ModelRenderer tail2;
    public ModelRenderer tail3;

    public ModelCeratosaurus() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.neck = new ModelRenderer(this, 0, 32);
        this.neck.setRotationPoint(0.0F, -1.2F, -10.0F);
        this.neck.addBox(-3.0F, -3.0F, -9.0F, 6, 7, 9, 0.0F);
        this.setRotateAngle(neck, -0.33161255787892263F, -0.0F, 0.0F);
        this.leftLeg = new ModelRenderer(this, 0, 4);
        this.leftLeg.setRotationPoint(1.5F, 5.0F, 2.0F);
        this.leftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 3, 0.0F);
        this.rightLeg = new ModelRenderer(this, 0, 4);
        this.rightLeg.setRotationPoint(-1.5F, 5.0F, 2.0F);
        this.rightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 3, 0.0F);
        this.rightThigh = new ModelRenderer(this, 0, 17);
        this.rightThigh.setRotationPoint(-4.0F, 7.5F, 8.5F);
        this.rightThigh.addBox(-4.0F, -1.0F, -3.0F, 4, 9, 6, 0.0F);
        this.setRotateAngle(rightThigh, -0.2617993877991494F, -0.0F, 0.0F);
        this.leftFoot = new ModelRenderer(this, 10, 9);
        this.leftFoot.setRotationPoint(-0.5F, 9.4F, 0.5F);
        this.leftFoot.addBox(-1.0F, 0.0F, -4.8F, 3, 2, 6, 0.0F);
        this.setRotateAngle(leftFoot, 0.2617993877991494F, -0.0F, 0.0F);
        this.rightLowerArm = new ModelRenderer(this, 20, 25);
        this.rightLowerArm.mirror = true;
        this.rightLowerArm.setRotationPoint(-0.9F, 1.6F, -0.5F);
        this.rightLowerArm.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(rightLowerArm, -0.7391469382195985F, -0.0F, 0.0F);
        this.leftThigh = new ModelRenderer(this, 0, 17);
        this.leftThigh.setRotationPoint(4.0F, 7.5F, 8.5F);
        this.leftThigh.addBox(0.0F, -1.0F, -3.0F, 4, 9, 6, 0.0F);
        this.setRotateAngle(leftThigh, -0.2617993877991494F, -0.0F, 0.0F);
        this.lowerJaw = new ModelRenderer(this, 23, 42);
        this.lowerJaw.setRotationPoint(0.0F, 2.2F, -6.7F);
        this.lowerJaw.addBox(-2.0F, 0.0F, -8.0F, 4, 1, 8, 0.0F);
        this.upperJaw = new ModelRenderer(this, 30, 51);
        this.upperJaw.setRotationPoint(0.0F, -0.8F, -8.0F);
        this.upperJaw.addBox(-2.5F, -3.0F, -7.0F, 5, 6, 7, 0.0F);
        this.rightHorn = new ModelRenderer(this, 47, 46);
        this.rightHorn.setRotationPoint(-2.2F, -2.9F, -4.5F);
        this.rightHorn.addBox(0.0F, -2.0F, -1.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(rightHorn, 0.24644049038159932F, -0.239459173373622F, -0.4242895411598215F);
        this.rightUpperArm = new ModelRenderer(this, 20, 18);
        this.rightUpperArm.setRotationPoint(-4.0F, 3.0F, -11.2F);
        this.rightUpperArm.addBox(-2.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(rightUpperArm, 0.35220744305245566F, -0.0F, 0.0F);
        this.leftHorn = new ModelRenderer(this, 47, 46);
        this.leftHorn.setRotationPoint(2.2F, -2.9F, -4.5F);
        this.leftHorn.addBox(-1.0F, -2.0F, -1.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(leftHorn, 0.6304129258203518F, 0.239459173373622F, 0.4242895411598215F);
        this.leftUpperArm = new ModelRenderer(this, 20, 18);
        this.leftUpperArm.setRotationPoint(4.0F, 3.0F, -11.2F);
        this.leftUpperArm.addBox(0.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(leftUpperArm, 0.3633775502652194F, -0.0F, 0.0F);
        this.tail3 = new ModelRenderer(this, 28, 5);
        this.tail3.setRotationPoint(0.0F, 0.8F, 9.0F);
        this.tail3.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 10, 0.0F);
        this.setRotateAngle(tail3, -0.10471975511965977F, -0.0F, 0.0F);
        this.backNasalCrest = new ModelRenderer(this, 103, 50);
        this.backNasalCrest.setRotationPoint(-0.5F, -1.35F, -5.1F);
        this.backNasalCrest.addBox(0.0F, -3.0F, -1.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(backNasalCrest, -0.8199556825869361F, -0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 48);
        this.head.setRotationPoint(0.0F, 0.8F, -7.5F);
        this.head.addBox(-3.5F, -4.0F, -8.0F, 7, 8, 8, 0.0F);
        this.setRotateAngle(head, 0.3839724354387525F, -0.0F, 0.0F);
        this.frontNasalCrest = new ModelRenderer(this, 95, 52);
        this.frontNasalCrest.setRotationPoint(-0.5F, -1.1F, -4.6F);
        this.frontNasalCrest.addBox(0.0F, -2.0F, 0.0F, 1, 2, 3, 0.0F);
        this.setRotateAngle(frontNasalCrest, 0.9309586230137754F, 0.0F, 0.0F);
        this.rightFoot = new ModelRenderer(this, 10, 9);
        this.rightFoot.setRotationPoint(0.5F, 9.4F, 0.5F);
        this.rightFoot.addBox(-2.0F, 0.0F, -4.8F, 3, 2, 6, 0.0F);
        this.setRotateAngle(rightFoot, 0.2617993877991494F, -0.0F, 0.0F);
        this.upperBody = new ModelRenderer(this, 21, 19);
        this.upperBody.setRotationPoint(0.0F, 3.0F, 4.0F);
        this.upperBody.addBox(-4.0F, -4.0F, -12.0F, 8, 10, 12, 0.0F);
        this.setRotateAngle(upperBody, 0.08342673824532895F, -0.0F, 0.0F);
        this.leftLowerArm = new ModelRenderer(this, 20, 25);
        this.leftLowerArm.setRotationPoint(0.9F, 1.6F, -0.5F);
        this.leftLowerArm.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(leftLowerArm, -0.7391469382195985F, -0.0F, 0.0F);
        this.lowerBody = new ModelRenderer(this, 54, 43);
        this.lowerBody.setRotationPoint(0.0F, 4.0F, 1.0F);
        this.lowerBody.addBox(-5.0F, -1.0F, 0.0F, 10, 11, 10, 0.0F);
        this.setRotateAngle(lowerBody, -0.03490658503988659F, -0.0F, 0.0F);
        this.tail2 = new ModelRenderer(this, 49, 12);
        this.tail2.setRotationPoint(0.0F, 0.3F, 8.3F);
        this.tail2.addBox(-2.5F, 0.0F, 0.0F, 5, 6, 9, 0.0F);
        this.setRotateAngle(tail2, 0.06981317007977318F, 0.0F, 0.0F);
        this.tail1 = new ModelRenderer(this, 61, 27);
        this.tail1.setRotationPoint(0.0F, -0.7F, 10.0F);
        this.tail1.addBox(-4.0F, 0.0F, 0.0F, 8, 7, 9, 0.0F);
        this.setRotateAngle(tail1, -0.017453292519943295F, -0.0F, 0.0F);
        this.upperBody.addChild(this.neck);
        this.leftThigh.addChild(this.leftLeg);
        this.rightThigh.addChild(this.rightLeg);
        this.leftLeg.addChild(this.leftFoot);
        this.rightUpperArm.addChild(this.rightLowerArm);
        this.head.addChild(this.lowerJaw);
        this.head.addChild(this.upperJaw);
        this.head.addChild(this.rightHorn);
        this.upperBody.addChild(this.rightUpperArm);
        this.head.addChild(this.leftHorn);
        this.upperBody.addChild(this.leftUpperArm);
        this.tail2.addChild(this.tail3);
        this.upperJaw.addChild(this.backNasalCrest);
        this.neck.addChild(this.head);
        this.upperJaw.addChild(this.frontNasalCrest);
        this.rightLeg.addChild(this.rightFoot);
        this.lowerBody.addChild(this.upperBody);
        this.leftUpperArm.addChild(this.leftLowerArm);
        this.tail1.addChild(this.tail2);
        this.lowerBody.addChild(this.tail1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, ((EntityDinosaur) entity).isModelized());
        this.lowerBody.render(f5);
        this.leftThigh.render(f5);
        this.rightThigh.render(f5);
    }

    @Override
    protected void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, boolean f6)
    {
        if (!f6)
        {
            this.head.rotateAngleX = f4 / (180F / (float) Math.PI) + 0.3839724354387525F;
            this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
            this.tail1.rotateAngleY = 0.08F * MathHelper.sin(f2 * (float) 0.1F + (f1 + 2));
            this.tail2.rotateAngleY = 0.10F * MathHelper.sin(f2 * (float) 0.1F + f1 + 1);
            this.tail3.rotateAngleY = 0.15F * MathHelper.sin(f2 * (float) 0.1F + f1);
            this.rightThigh.rotateAngleX = (MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1) - 0.2617993877991494F;
            this.leftThigh.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 1.4F * f1) - 0.2617993877991494F;
        }
        else
        {
            this.head.rotateAngleX = 0;
            this.head.rotateAngleY = 0;
            this.tail1.rotateAngleY = 0;
            this.tail2.rotateAngleY = 0;
            this.tail3.rotateAngleY = 0;
            this.rightThigh.rotateAngleX = -0.2617993877991494F;
            this.leftThigh.rotateAngleX = -0.2617993877991494F;
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