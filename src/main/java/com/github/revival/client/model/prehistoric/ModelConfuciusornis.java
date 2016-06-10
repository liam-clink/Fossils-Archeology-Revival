package com.github.revival.client.model.prehistoric;

import com.github.revival.client.model.prehistoric.test.ModelNewPrehistoric;
import com.github.revival.server.entity.mob.EntityPterosaur;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;

public class ModelConfuciusornis extends ModelNewPrehistoric {
    public AdvancedModelRenderer rightLeg;
    public AdvancedModelRenderer rightFoot;
    public AdvancedModelRenderer leftLeg;
    public AdvancedModelRenderer body;
    public AdvancedModelRenderer leftFoot;
    public AdvancedModelRenderer rightWing;
    public AdvancedModelRenderer leftWing;
    public AdvancedModelRenderer tailFeathers;
    public AdvancedModelRenderer neck;
    public AdvancedModelRenderer leftTail1;
    public AdvancedModelRenderer rightTail1;
    public AdvancedModelRenderer head;
    public AdvancedModelRenderer headFeathers;
    public AdvancedModelRenderer upperBeak;
    public AdvancedModelRenderer lowerBeak;
    public AdvancedModelRenderer leftTail2;
    public AdvancedModelRenderer leftTail3;
    public AdvancedModelRenderer leftTailFan;
    public AdvancedModelRenderer rightTail2;
    public AdvancedModelRenderer rightTail3;
    public AdvancedModelRenderer rightTailFan;
    private ModelAnimator animator;

    public ModelConfuciusornis() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.leftTail1 = new AdvancedModelRenderer(this, 0, 21);
        this.leftTail1.setRotationPoint(1.4F, 0.3F, 0.5F);
        this.leftTail1.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(leftTail1, -0.05899212871740834F, -0.0F, 0.0F);
        this.rightTail3 = new AdvancedModelRenderer(this, 0, 20);
        this.rightTail3.setRotationPoint(0.0F, 0.0F, 2.9F);
        this.rightTail3.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 12, 0.0F);
        this.setRotateAngle(rightTail3, 0.08726646259971647F, -0.0F, 0.0F);
        this.body = new AdvancedModelRenderer(this, 0, 7);
        this.body.setRotationPoint(0.0F, 19.2F, 0.5F);
        this.body.addBox(-2.0F, -2.0F, -7.0F, 4, 4, 8, 0.0F);
        this.setRotateAngle(body, -0.2638937829015426F, 0.0F, 0.0F);
        this.head = new AdvancedModelRenderer(this, 25, 1);
        this.head.setRotationPoint(0.0F, -1.5F, -0.5F);
        this.head.addBox(-1.5F, -3.0F, -2.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(head, -0.3141592653589793F, -0.0F, 0.0F);
        this.rightWing = new AdvancedModelRenderer(this, 27, 15);
        this.rightWing.setRotationPoint(-2.0F, 0.5F, -6.0F);
        this.rightWing.addBox(-1.0F, -1.0F, -1.0F, 1, 7, 3, 0.0F);
        this.setRotateAngle(rightWing, 1.5053464798451093F, -0.0F, 0.0F);
        this.tailFeathers = new AdvancedModelRenderer(this, 15, 20);
        this.tailFeathers.setRotationPoint(0.0F, -0.5F, 0.9F);
        this.tailFeathers.addBox(-2.0F, 0.0F, 0.2F, 4, 3, 1, 0.0F);
        this.setRotateAngle(tailFeathers, 1.435944321646531F, -0.0F, 0.0F);
        this.rightLeg = new AdvancedModelRenderer(this, 16, 6);
        this.rightLeg.setRotationPoint(-1.5F, 21.0F, -1.0F);
        this.rightLeg.addBox(-0.6F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rightLeg, 0.0F, -0.0F, 0.017453292519943295F);
        this.leftTail2 = new AdvancedModelRenderer(this, 0, 26);
        this.leftTail2.setRotationPoint(0.0F, 0.0F, 3.2F);
        this.leftTail2.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(leftTail2, 0.07365289443416069F, 0.0F, 0.0F);
        this.leftWing = new AdvancedModelRenderer(this, 27, 15);
        this.leftWing.setRotationPoint(2.0F, 0.5F, -6.0F);
        this.leftWing.addBox(0.0F, -1.0F, -1.0F, 1, 7, 3, 0.0F);
        this.setRotateAngle(leftWing, 1.5053464798451093F, -0.0F, 0.0F);
        this.leftLeg = new AdvancedModelRenderer(this, 16, 6);
        this.leftLeg.setRotationPoint(1.5F, 21.0F, -1.0F);
        this.leftLeg.addBox(-0.4F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(leftLeg, 0.0F, -0.0F, 0.017453292519943295F);
        this.leftTail3 = new AdvancedModelRenderer(this, 0, 20);
        this.leftTail3.setRotationPoint(0.0F, 0.0F, 2.9F);
        this.leftTail3.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 12, 0.0F);
        this.setRotateAngle(leftTail3, 0.08726646259971647F, -0.0F, 0.0F);
        this.rightTail1 = new AdvancedModelRenderer(this, 0, 21);
        this.rightTail1.setRotationPoint(-1.4F, 0.3F, 0.5F);
        this.rightTail1.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(rightTail1, -0.05899212871740834F, 0.0F, 0.0F);
        this.leftTailFan = new AdvancedModelRenderer(this, 15, 29);
        this.leftTailFan.setRotationPoint(0.0F, 0.1F, 9.2F);
        this.leftTailFan.addBox(-1.0F, -0.1F, 2.8F, 2, 1, 3, 0.0F);
        this.setRotateAngle(leftTailFan, 0.017453292519943295F, -0.0F, 0.0F);
        this.neck = new AdvancedModelRenderer(this, 15, 1);
        this.neck.setRotationPoint(0.0F, -0.5F, -6.5F);
        this.neck.addBox(-1.0F, -2.5F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(neck, 0.5846852994181004F, -0.0F, 0.0F);
        this.rightTailFan = new AdvancedModelRenderer(this, 15, 29);
        this.rightTailFan.mirror = true;
        this.rightTailFan.setRotationPoint(0.0F, 0.1F, 9.2F);
        this.rightTailFan.addBox(-1.0F, -0.1F, 2.8F, 2, 1, 3, 0.0F);
        this.setRotateAngle(rightTailFan, 0.017453292519943295F, -0.0F, 0.0F);
        this.rightFoot = new AdvancedModelRenderer(this, 22, 12);
        this.rightFoot.setRotationPoint(0.0F, 2.8F, 0.5F);
        this.rightFoot.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
        this.lowerBeak = new AdvancedModelRenderer(this, 38, 4);
        this.lowerBeak.setRotationPoint(0.0F, -0.9F, -0.8F);
        this.lowerBeak.addBox(-1.0F, 0.0F, -3.5F, 2, 1, 3, 0.0F);
        this.leftFoot = new AdvancedModelRenderer(this, 22, 12);
        this.leftFoot.mirror = true;
        this.leftFoot.setRotationPoint(0.0F, 2.8F, 0.5F);
        this.leftFoot.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
        this.rightTail2 = new AdvancedModelRenderer(this, 0, 26);
        this.rightTail2.setRotationPoint(0.0F, 0.0F, 3.2F);
        this.rightTail2.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rightTail2, 0.07365289443416069F, -0.0F, 0.0F);
        this.headFeathers = new AdvancedModelRenderer(this, 35, 0);
        this.headFeathers.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.headFeathers.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(headFeathers, -1.1897909510845344F, -0.0F, 0.0F);
        this.upperBeak = new AdvancedModelRenderer(this, 49, 4);
        this.upperBeak.setRotationPoint(0.0F, -1.0F, -0.8F);
        this.upperBeak.addBox(-1.0F, -1.0F, -3.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(upperBeak, 0.14870205226991687F, -0.0F, 0.0F);
        this.body.addChild(this.leftTail1);
        this.rightTail2.addChild(this.rightTail3);
        this.neck.addChild(this.head);
        this.body.addChild(this.rightWing);
        this.body.addChild(this.tailFeathers);
        this.leftTail1.addChild(this.leftTail2);
        this.body.addChild(this.leftWing);
        this.leftTail2.addChild(this.leftTail3);
        this.body.addChild(this.rightTail1);
        this.leftTail3.addChild(this.leftTailFan);
        this.body.addChild(this.neck);
        this.rightTail3.addChild(this.rightTailFan);
        this.rightLeg.addChild(this.rightFoot);
        this.head.addChild(this.lowerBeak);
        this.leftLeg.addChild(this.leftFoot);
        this.rightTail1.addChild(this.rightTail2);
        this.head.addChild(this.headFeathers);
        this.head.addChild(this.upperBeak);
        this.updateDefaultPose();
        animator = ModelAnimator.create();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
        this.body.render(f5);
        this.rightLeg.render(f5);
        this.leftLeg.render(f5);
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animator.update(entity);
        blockMovement(f, f1, f2, f3, f4, f5, (Entity) entity);
        this.resetToDefaultPose();
        setRotationAngles(f, f1, f2, f3, f4, f5, (Entity) entity);
        animator.setAnimation(EntityPterosaur.ATTACK_ANIMATION);
        animator.startKeyframe(10);
        ModelUtils.rotate(animator, neck, -41, 0, 0);
        ModelUtils.rotate(animator, head, 57, 0, 0);
        animator.endKeyframe();
        animator.startKeyframe(5);
        ModelUtils.rotate(animator, neck, 6, 0, 0);
        ModelUtils.rotate(animator, head, -14, 0, 0);
        animator.endKeyframe();
        animator.resetKeyframe(10);
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        AdvancedModelRenderer[] neckParts = {this.neck, this.head};
        ModelUtils.faceTargetMod(neck, f3, f4, 0.5F);
        ModelUtils.faceTargetMod(head, f3, f4, 0.5F);
        float speed = 0.1F;
        float speed2 = 0.6F;
        float speed3 = 0.2F;
        this.bob(body, speed, -0.3F, false, entity.ticksExisted, 1);
        this.chainWave(neckParts, speed, 0.15F, 3, entity.ticksExisted, 1);
    }

}
