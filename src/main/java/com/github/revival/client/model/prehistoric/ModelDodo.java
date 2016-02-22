package com.github.revival.client.model.prehistoric;

import com.github.revival.client.model.prehistoric.test.ModelNewPrehistoric;
import com.github.revival.server.entity.mob.EntityDodo;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.llibrary.common.animation.Animator;
import net.ilexiconn.llibrary.common.animation.IAnimated;
import net.minecraft.entity.Entity;

public class ModelDodo extends ModelNewPrehistoric {
    public MowzieModelRenderer body;
    public MowzieModelRenderer rightLeg;
    public MowzieModelRenderer leftLeg;
    public MowzieModelRenderer tail;
    public MowzieModelRenderer rightWing;
    public MowzieModelRenderer leftWing;
    public MowzieModelRenderer bottom;
    public MowzieModelRenderer neck;
    public MowzieModelRenderer head;
    public MowzieModelRenderer beakUpper;
    public MowzieModelRenderer beakLower;
    public MowzieModelRenderer rightFoot;
    public MowzieModelRenderer leftFoot;
    private Animator animator;

    public ModelDodo() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.leftWing = new MowzieModelRenderer(this, 34, 25);
        this.leftWing.setRotationPoint(3.5F, 3.0F, 3.0F);
        this.leftWing.addBox(0.0F, -1.0F, -2.0F, 1, 3, 4, 0.0F);
        this.leftFoot = new MowzieModelRenderer(this, 22, 24);
        this.leftFoot.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.leftFoot.addBox(-1.5F, 0.0F, -3.0F, 3, 0, 3, 0.0F);
        this.neck = new MowzieModelRenderer(this, 0, 16);
        this.neck.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.neck.addBox(-2.0F, -8.0F, -1.5F, 4, 8, 3, 0.0F);
        this.setRotateAngle(neck, -0.33161255787892263F, 0.0F, 0.0F);
        this.beakUpper = new MowzieModelRenderer(this, 48, 13);
        this.beakUpper.setRotationPoint(0.0F, -1.0F, -4.0F);
        this.beakUpper.addBox(-1.5F, -1.0F, -5.0F, 3, 2, 5, 0.0F);
        this.leftLeg = new MowzieModelRenderer(this, 28, 27);
        this.leftLeg.setRotationPoint(1.5F, 21.0F, 0.0F);
        this.leftLeg.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 0, 0.0F);
        this.beakLower = new MowzieModelRenderer(this, 48, 20);
        this.beakLower.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.beakLower.addBox(-1.5F, 0.0F, -5.0F, 3, 1, 5, 0.0F);
        this.body = new MowzieModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0F, 13.0F, -6.0F);
        this.body.addBox(-3.5F, 0.0F, 0.0F, 7, 7, 9, 0.0F);
        this.rightFoot = new MowzieModelRenderer(this, 22, 24);
        this.rightFoot.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.rightFoot.addBox(-1.5F, 0.0F, -3.0F, 3, 0, 3, 0.0F);
        this.rightWing = new MowzieModelRenderer(this, 34, 25);
        this.rightWing.setRotationPoint(-3.5F, 3.0F, 3.0F);
        this.rightWing.addBox(-1.0F, -1.0F, -2.0F, 1, 3, 4, 0.0F);
        this.bottom = new MowzieModelRenderer(this, 0, 27);
        this.bottom.setRotationPoint(0.0F, 7.0F, 5.0F);
        this.bottom.addBox(-3.5F, 0.0F, -2.0F, 7, 1, 4, 0.0F);
        this.tail = new MowzieModelRenderer(this, 14, 16);
        this.tail.setRotationPoint(0.0F, 1.0F, 6.5F);
        this.tail.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(tail, -0.18587756533739608F, -0.0F, 0.0F);
        this.rightLeg = new MowzieModelRenderer(this, 28, 27);
        this.rightLeg.setRotationPoint(-1.5F, 21.0F, 0.0F);
        this.rightLeg.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 0, 0.0F);
        this.head = new MowzieModelRenderer(this, 35, 5);
        this.head.setRotationPoint(0.0F, -6.0F, 0.3F);
        this.head.addBox(-2.5F, -3.0F, -4.0F, 5, 4, 4, 0.0F);
        this.setRotateAngle(head, 0.33161255787892263F, 0.0F, 0.0F);
        this.body.addChild(this.leftWing);
        this.leftLeg.addChild(this.leftFoot);
        this.body.addChild(this.neck);
        this.head.addChild(this.beakUpper);
        this.head.addChild(this.beakLower);
        this.rightLeg.addChild(this.rightFoot);
        this.body.addChild(this.rightWing);
        this.body.addChild(this.bottom);
        this.body.addChild(this.tail);
        this.neck.addChild(this.head);
        this.setInitPose();
        animator = new Animator(this);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animate((IAnimated) entity, f, f1, f2, f3, f4, f5);
        this.body.render(f5);
        this.leftLeg.render(f5);
        this.rightLeg.render(f5);

    }

    public void animate(IAnimated entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animator.update(entity);
        this.setToInitPose();
        setRotationAngles(f, f1, f2, f3, f4, f5, (Entity) entity);
        animator.setAnimationId(EntityNewPrehistoric.animation_speak.animationId);
        animator.startPhase(EntityDodo.getSpeakLength() / 2);
        ModelUtils.rotate(animator, beakLower, 29, 0, 0);
        animator.endPhase();
        animator.resetPhase(EntityDodo.getSpeakLength() / 2);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        MowzieModelRenderer[] tailParts = {this.tail};
        MowzieModelRenderer[] neckParts = {this.neck, this.head};
        EntityDodo dodo = (EntityDodo) entity;
        float speed = 1.8F;
        float speed2 = 0.1F;
        float sitProgress = ((EntityNewPrehistoric) (entity)).sitProgress;
        faceTarget(head, 1, f3, f4);
        this.bob(body, speed2, -0.4F, false, entity.ticksExisted, 1);
        this.walk(leftLeg, speed, 1.9F, false, 0F, 0F, f, f1);
        this.walk(rightLeg, speed, 1.9F, true, 0F, 0F, f, f1);
        this.walk(leftFoot, speed, 1.9F, true, 0.3F, 0F, f, f1);
        this.walk(rightFoot, speed, 1.9F, false, 0.3F, 0F, f, f1);
        this.chainWave(tailParts, speed2, 0.05F, -3, entity.ticksExisted, 1);
        this.chainSwing(tailParts, speed2, 0.15F, -3, entity.ticksExisted, 1);
        this.chainWave(neckParts, speed2, 0.1F, -3, entity.ticksExisted, 1);
        this.chainWave(neckParts, speed, 0.4F, -3, f, f1);
        sitAnimationRotation(neck, sitProgress, -((float) Math.toRadians(16.0D)), 0, 0);
        sitAnimationRotation(rightLeg, sitProgress, -((float) Math.toRadians(90.0D)), 0, 0);
        sitAnimationRotation(rightFoot, sitProgress, (float) Math.toRadians(90.0D), 0, 0);
        sitAnimationRotation(leftLeg, sitProgress, -((float) Math.toRadians(90.0D)), 0, 0);
        sitAnimationRotation(leftFoot, sitProgress, (float) Math.toRadians(90.0D), 0, 0);
        sitAnimationRotation(tail, sitProgress, -((float) Math.toRadians(10.65D)), 0, 0);
        sitAnimationRotation(head, sitProgress, (float) Math.toRadians(16.0D), 0, 0);
        sitAnimationPos(body, sitProgress, 0, 3F, 0);
        sitAnimationPos(rightLeg, sitProgress, 0, 3F, 0);
        sitAnimationPos(leftLeg, sitProgress, 0, 3F, 0);
        if (dodo.getFat() > 0) {
            float scale = 1 + (dodo.getFat() * 0.1F);
            body.setScale(scale, scale, scale);
        }
    }
}
