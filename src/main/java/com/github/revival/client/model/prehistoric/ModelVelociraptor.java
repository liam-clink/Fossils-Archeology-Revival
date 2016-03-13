package com.github.revival.client.model.prehistoric;

import java.util.UUID;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.llibrary.common.animation.Animator;
import net.ilexiconn.llibrary.common.animation.IAnimated;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.StringUtils;

import org.lwjgl.opengl.GL11;

import com.github.revival.client.model.prehistoric.test.ModelNewPrehistoric;
import com.github.revival.client.renderer.entity.RenderPrehistoric;
import com.github.revival.server.entity.mob.EntityDeinonychus;
import com.github.revival.server.entity.mob.EntityVelociraptor;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import com.mojang.authlib.GameProfile;

public class ModelVelociraptor extends ModelNewPrehistoric {
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
    public Animator animator;

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
        this.rightToeClaw1.addChild(this.rightToeClaw2);
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
        this.setInitPose();
        animator = new Animator(this);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animate((IAnimated) entity, f, f1, f2, f3, f4, f5);
        this.leftThigh.render(f5);
        this.lowerBody.render(f5);
        this.rightThigh.render(f5);
    }

    public void animate(IAnimated entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animator.update(entity);
        this.setToInitPose();
        setRotationAngles(f, f1, f2, f3, f4, f5, (Entity) entity);
        animator.setAnimationId(EntityDeinonychus.animation_attack.animationId);
        animator.startPhase(10);
		animator.move(leftThigh, 0, 3.2F, -0.5F);
		animator.move(rightThigh, 0, 3.2F, -0.5F);
		animator.move(lowerBody, 0, 5.2F, -0.5F);
		ModelUtils.rotate(animator, lowerBody, 15, 0, 0);
		ModelUtils.rotate(animator, rightLeg, -30, 0, 0);
		ModelUtils.rotate(animator, leftLeg, -30, 0, 0);
		ModelUtils.rotate(animator, rightFoot, 30, 0, 0);
		ModelUtils.rotate(animator, leftFoot, 30, 0, 0);
		ModelUtils.rotate(animator, leftUpperArm, 0, 0, -50);
		ModelUtils.rotate(animator, rightUpperArm, 0, 0, 50);
		ModelUtils.rotate(animator, head, -20, 0, 0);
		animator.endPhase();
		animator.setStationaryPhase(5);
        animator.startPhase(5);
		animator.move(leftThigh, 0, -6F, 0F);
		animator.move(rightThigh, 0, -6F, 0F);
		animator.move(lowerBody, 0, -10F, 0F);
		ModelUtils.rotate(animator, lowerBody, -25, 0, 0);
		ModelUtils.rotate(animator, rightThigh, -35, 0, 0);
		ModelUtils.rotate(animator, leftThigh, -35, 0, 0);
		ModelUtils.rotate(animator, rightLeg, -30, 0, 0);
		ModelUtils.rotate(animator, leftLeg, -30, 0, 0);
		ModelUtils.rotate(animator, rightFoot, -55, 0, 0);
		ModelUtils.rotate(animator, leftFoot, -55, 0, 0);
		ModelUtils.rotate(animator, leftUpperArm, 0, 0, -50);
		ModelUtils.rotate(animator, rightUpperArm, 0, 0, 50);
		animator.endPhase();
		animator.setStationaryPhase(5);
		animator.resetPhase(5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        MowzieModelRenderer[] tailParts = {this.tail1, this.tail2, this.tail3};
        MowzieModelRenderer[] neckParts = {this.neck, this.head};
        MowzieModelRenderer[] leftArmParts = {this.leftUpperArm, this.leftLowerArm};
        MowzieModelRenderer[] rightArmParts = {this.rightUpperArm, this.rightLowerArm};
        ModelUtils.faceTargetMod(neck, f3, f4, 0.5F);
        ModelUtils.faceTargetMod(head, f3, f4, 0.5F);

        float speed = 0.1F;
        float speed2 = 0.7F;
        float sitProgress = ((EntityNewPrehistoric) (entity)).sitProgress;
        sitAnimationRotation(rightThigh, sitProgress, -((float) Math.toRadians(75.0D)), 0, 0);
        sitAnimationRotation(leftLowerArm, sitProgress, 0, 0, 0);
        sitAnimationRotation(lowerBody, sitProgress, -((float) Math.toRadians(5.22D)), 0, 0);
        sitAnimationRotation(rightFoot, sitProgress, (float) Math.toRadians(75.0D), 0, 0);
        sitAnimationRotation(head, sitProgress, (float) Math.toRadians(40D), 0, 0);
        sitAnimationRotation(leftFoot, sitProgress, (float) Math.toRadians(75.0D), 0, 0);
        sitAnimationRotation(leftLeg, sitProgress, 0, 0, 0);
        sitAnimationRotation(tail1, sitProgress, -((float) Math.toRadians(5.22D)), 0, 0);
        sitAnimationRotation(rightUpperArm, sitProgress, -((float) Math.toRadians(4.0D)), 0, (float) Math.toRadians(60.0D));
        sitAnimationRotation(leftThigh, sitProgress, -((float) Math.toRadians(75.0D)), 0, 0);
        sitAnimationRotation(rightLeg, sitProgress, 0, 0, 0);
        sitAnimationRotation(leftUpperArm, sitProgress, -((float) Math.toRadians(4.0D)), 0, -((float) Math.toRadians(60.0D)));
        sitAnimationRotation(tail3, sitProgress, (float) Math.toRadians(2.61D), 0, 0);
        sitAnimationRotation(upperBody, sitProgress, (float) Math.toRadians(11.08D), 0, 0);
        sitAnimationRotation(lowerJaw, sitProgress, -((float) Math.toRadians(3.9672555472768707D)), 0, 0);
        sitAnimationRotation(upperJaw, sitProgress, -((float) Math.toRadians(0.1D)), 0, 0);
        sitAnimationRotation(rightLowerArm, sitProgress, 0, 0, 0);
        sitAnimationRotation(neck, sitProgress, -((float) Math.toRadians(40D)), 0, 0);
        sitAnimationPos(lowerBody, sitProgress, 0F, 16.40F - lowerBody.initRotationPointY, 0F);
        sitAnimationPos(rightThigh, sitProgress, 0F, 19.40F - rightThigh.initRotationPointY, 0F);
        sitAnimationPos(leftThigh, sitProgress, 0F, 19.40F - leftThigh.initRotationPointY, 0F);
        this.bob(lowerBody, speed, 0.7F, false, entity.ticksExisted, 1);
        this.walk(leftThigh, speed2, 0.8F, false, 0F, 0.4F, f, f1);
        this.walk(leftLeg, speed2, 0.2F, false, 0F, -0.6F, f, f1);
        this.walk(leftFoot, speed2, -0.4F, true, 2.5F, 0.4F, f, f1);
        this.walk(rightThigh, speed2, 0.8F, true, 0F, 0.4F, f, f1);
        this.walk(rightLeg, speed2, 0.2F, true, 0F, -0.6F, f, f1);
        this.walk(rightFoot, speed2, -0.4F, false, 2.5F, 0.4F, f, f1);
        this.walk(upperBody, speed, 0.1F, false, 0, 0, entity.ticksExisted, 1);
        this.chainWave(tailParts, speed, 0.05F, -3, entity.ticksExisted, 1);
        this.chainWave(leftArmParts, speed, 0.05F, -3, entity.ticksExisted, 1);
        this.chainWave(rightArmParts, speed, 0.05F, -3, entity.ticksExisted, 1);
        this.chainSwing(tailParts, speed, 0.15F, -3, entity.ticksExisted, 1);
        this.chainSwing(tailParts, speed2, 0.25F, -3, f, f1);
        this.chainWave(neckParts, speed, 0.15F, 3, entity.ticksExisted, 1);
        if (((EntityVelociraptor) entity).getAnimation() != EntityVelociraptor.animation_attack && ((EntityVelociraptor) entity).ridingEntity != null) {
            ModelUtils.setRotateAngleAlt(lowerBody, -15, 0, 0);
            ModelUtils.setRotateAngleAlt(leftLeg, 20, 0, 0);
            ModelUtils.setRotateAngleAlt(leftFoot, -20, 0, 0);
            ModelUtils.setRotateAngleAlt(rightLeg, 20, 0, 0);
            ModelUtils.setRotateAngleAlt(rightFoot, -20, 0, 0);
            ModelUtils.setRotateAngleAlt(leftUpperArm, 0, 0, -40);
            ModelUtils.setRotateAngleAlt(rightUpperArm, 0, 0, 40);
            ModelUtils.setRotateAngleAlt(head, 40, 0, 0);
            EntityVelociraptor dino = (EntityVelociraptor) entity;
            float speed3 = 0.5F;
            this.walk(lowerJaw, speed3, -0.3F, true, 0.5F, 0.3F, entity.ticksExisted, 1);
            this.walk(neck, speed3, 0.4F, false, 0F, 0.4F, entity.ticksExisted, 1);
            this.walk(head, speed3, 0.4F, true, 0F, 0.2F, entity.ticksExisted, 1);
            this.flap(leftUpperArm, 0.8F, -0.4F, true, 0.3F, -0.2F, entity.ticksExisted, 1);
            this.flap(rightUpperArm, 0.8F, -0.4F, false, 0.3F, 0.2F, entity.ticksExisted, 1);
        }
        ((EntityNewPrehistoric)entity).tailbuffer.applyChainSwingBuffer(tailParts);
        //((ChainBuffer)((EntityVelociraptor)entity).tailbuffer).applyChainSwingBuffer(tailParts);

    }

    //	@Override
    //	public void sitPose(boolean animate) {
    //		/*ModelUtils.animateOrSetRotation(animator, animate, tailFeather3, -0.004886921905584123F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, lowerJaw, -0.06924167156799095F, 0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, upperCrest, 0.4961971063419879F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, rightUpperArmFeather, 1.4493214108560915F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, rightLowerArmFeather, 6.981317007977319E-4F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, leftLowerArmFeather, 6.981317007977319E-4F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, tailFeather2, -0.004886921905584123F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, rightLowerArm, 0.8726646259971648F, 0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, leftToeClaw2, -1.7627825445142729F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, neck, -1.4114477660878142F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, rightUpperArm, -0.06981317007977318F, -0.0F, 1.0471975511965976F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, leftThigh, -1.1344640137963142F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, tailFeather1, -0.004886921905584123F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, lowerCrest, 0.13578661580515886F, 0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, leftUpperArm, -0.06981317007977318F, -0.0F, -1.0471975511965976F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, leftUpperArmFeather, 1.4493214108560915F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, leftToeClaw1, -0.8726646259971648F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, tail1, -0.091106186954104F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, tail3, 0.045553093477052F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, leftFoot, 0.17453292519943295F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, rightLeg, 0.9948376736367678F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, rightFoot, 0.17453292519943295F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, upperBody, 0.19338248112097173F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, rightToeClaw2, -1.7627825445142729F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, leftLowerArm, 0.8726646259971648F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, leftLeg, 0.9948376736367678F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, rightToeClaw1, -0.8726646259971648F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, upperJaw, -0.0017453292519943296F, -0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, headPivot, 1.5481070465189704F, 0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, lowerBody, -0.091106186954104F, 0.0F, 0.0F, false);
    //        ModelUtils.animateOrSetRotation(animator, animate, rightThigh, -1.1344640137963142F, -0.0F, 0.0F, false);
    //        ModelUtils.animateToPos(animator, animate, lowerBody, 0F, 16.40F - lowerBody.initRotationPointY, 0F, true);
    //		ModelUtils.animateToPos(animator, animate, rightThigh, 0F, 19.40F - rightThigh.initRotationPointY, 0F, true);
    //		ModelUtils.animateToPos(animator, animate, leftThigh, 0F, 19.40F - leftThigh.initRotationPointY, 0F, true);
    //		ModelUtils.setPos(animator, animate, lowerBody, 0F, 16.40F, -2.5F, false);
    //		ModelUtils.setPos(animator, animate, rightThigh, -3F, 19.40F, 3F, false);
    //		ModelUtils.setPos(animator, animate, leftThigh, 3F, 19.40F, 3F, false);*/
    //	}

    public void renderHeldItem(RenderPrehistoric renderPrehistoric, EntityLiving entity, float f) {
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
        renderPrehistoric.superRenderEquippedItems(entity, f);
        ItemStack itemstack = entity.getHeldItem();
        ItemStack itemstack1 = entity.func_130225_q(3);
        Item item;
        float f1;

        if (itemstack1 != null) {
            GL11.glPushMatrix();
            item = itemstack1.getItem();

            net.minecraftforge.client.IItemRenderer customRenderer = net.minecraftforge.client.MinecraftForgeClient.getItemRenderer(itemstack1, net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED);
            boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED, itemstack1, net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D));

            if (item instanceof ItemBlock) {
                if (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(item).getRenderType())) {
                    f1 = 0.625F;
                    GL11.glTranslatef(0.0F, -0.2F, 0.0F);
                    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glScalef(f1, f1, f1);
                }

                renderPrehistoric.getRenderManager().itemRenderer.renderItem(entity, itemstack1, 0);
            } else if (item == Items.skull) {
                f1 = 1.0625F;
                GL11.glScalef(f1, f1, f1);
                GameProfile gameprofile = null;

                if (itemstack1.hasTagCompound()) {
                    NBTTagCompound nbttagcompound = itemstack1.getTagCompound();

                    if (nbttagcompound.hasKey("SkullOwner", 10)) {
                        gameprofile = NBTUtil.func_152459_a(nbttagcompound.getCompoundTag("SkullOwner"));
                    } else if (nbttagcompound.hasKey("SkullOwner", 8) && !StringUtils.isNullOrEmpty(nbttagcompound.getString("SkullOwner"))) {
                        gameprofile = new GameProfile((UUID) null, nbttagcompound.getString("SkullOwner"));
                    }
                }

                TileEntitySkullRenderer.field_147536_b.func_152674_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack1.getItemDamage(), gameprofile);
            }

            GL11.glPopMatrix();
        }

        if (itemstack != null && itemstack.getItem() != null) {
            item = itemstack.getItem();
            GL11.glPushMatrix();
            GL11.glTranslatef(0, 0.55F, -0.55F);
            GL11.glTranslatef(0, -(head.rotateAngleX - neck.rotateAngleX) + 0.75F, 0);

            this.head.postRender(0.0625F);

            net.minecraftforge.client.IItemRenderer customRenderer = net.minecraftforge.client.MinecraftForgeClient.getItemRenderer(itemstack, net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED);
            boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED, itemstack, net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D));

            if (item instanceof ItemBlock && (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(item).getRenderType()))) {
                f1 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                f1 *= 0.75F;
                GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f1, f1, f1);
            } else if (item == Items.bow) {
                f1 = 0.625F;
                GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
                GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f1, f1, f1);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            } else if (item.isFull3D()) {
                f1 = 0.625F;

                if (item.shouldRotateAroundWhenRendering()) {
                    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(0.0F, -0.125F, 0.0F);
                }

                GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
                GL11.glScalef(f1, f1, f1);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            } else {
                f1 = 0.375F;
                GL11.glScalef(f1, f1, f1);
                GL11.glTranslatef(0.4F, 0.2F, -1.8F);
                GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-150.0F, 0.0F, 1.0F, 0.0F);
                float speed = -0.1F;
                float degree = -0.02F;

            }

            float f2;
            int i;
            float f5;
            if (itemstack.getItem().requiresMultipleRenderPasses()) {
                for (i = 0; i < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); ++i) {
                    int j = itemstack.getItem().getColorFromItemStack(itemstack, i);
                    f5 = (float) (j >> 16 & 255) / 255.0F;
                    f2 = (float) (j >> 8 & 255) / 255.0F;
                    float f3 = (float) (j & 255) / 255.0F;
                    GL11.glColor4f(f5, f2, f3, 1.0F);
                    renderPrehistoric.getRenderManager().itemRenderer.renderItem(entity, itemstack, i);
                }
            } else {
                i = itemstack.getItem().getColorFromItemStack(itemstack, 0);
                float f4 = (float) (i >> 16 & 255) / 255.0F;
                f5 = (float) (i >> 8 & 255) / 255.0F;
                f2 = (float) (i & 255) / 255.0F;
                GL11.glColor4f(f4, f5, f2, 1.0F);
                renderPrehistoric.getRenderManager().itemRenderer.renderItem(entity, itemstack, 0);
            }

            GL11.glPopMatrix();
        }
    }
}
