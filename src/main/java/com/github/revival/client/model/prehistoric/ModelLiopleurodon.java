package com.github.revival.client.model.prehistoric;

import com.github.revival.client.model.prehistoric.test.ModelNewPrehistoric;
import com.github.revival.server.entity.mob.EntityLiopleurodon;
import com.github.revival.server.entity.mob.EntityMosasaurus;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;

import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLiopleurodon extends ModelNewPrehistoric {
	public AdvancedModelRenderer LowerBody;
	public AdvancedModelRenderer BackFlipper_Right;
	public AdvancedModelRenderer Tail;
	public AdvancedModelRenderer BackFlipper_Left;
	public AdvancedModelRenderer UpperBody;
	public AdvancedModelRenderer Tail1;
	public AdvancedModelRenderer Tail2;
	public AdvancedModelRenderer Neck;
	public AdvancedModelRenderer FrontFlipper_Right;
	public AdvancedModelRenderer FrontFlipper_Left;
	public AdvancedModelRenderer Head;
	public AdvancedModelRenderer JawTop;
	public AdvancedModelRenderer JawBottomBase;
	public AdvancedModelRenderer Teeth;
	public AdvancedModelRenderer JawBottom;
	private ModelAnimator animator;

	public ModelLiopleurodon() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.LowerBody = new AdvancedModelRenderer(this, 34, 9);
		this.LowerBody.mirror = true;
		this.LowerBody.setRotationPoint(0.0F, 18.6F, -1.0F);
		this.LowerBody.addBox(-4.0F, -5.0F, 0.0F, 8, 10, 14, 0.0F);
		this.setRotateAngle(LowerBody, -0.045553093477052F, 0.0F, 0.0F);
		this.BackFlipper_Right = new AdvancedModelRenderer(this, 59, 49);
		this.BackFlipper_Right.setRotationPoint(-3.5F, 1.0F, 13.0F);
		this.BackFlipper_Right.addBox(-0.5F, 0.0F, -2.0F, 1, 10, 5, 0.0F);
		this.setRotateAngle(BackFlipper_Right, 0.5235987755982988F, 0.0F, 1.2217304763960306F);
		this.JawBottom = new AdvancedModelRenderer(this, 0, 37);
		this.JawBottom.mirror = true;
		this.JawBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.JawBottom.addBox(-1.5F, -1.0F, -17.5F, 3, 3, 11, 0.0F);
		this.Tail1 = new AdvancedModelRenderer(this, 79, 13);
		this.Tail1.mirror = true;
		this.Tail1.setRotationPoint(0.0F, -0.5F, 7.0F);
		this.Tail1.addBox(-2.0F, -3.0F, 0.0F, 4, 6, 8, 0.0F);
		this.setRotateAngle(Tail1, -0.045553093477052F, 0.0F, 0.0F);
		this.Head = new AdvancedModelRenderer(this, 0, 0);
		this.Head.mirror = true;
		this.Head.setRotationPoint(0.0F, -1.1F, -9.3F);
		this.Head.addBox(-3.0F, -2.0F, -8.0F, 6, 4, 8, 0.0F);
		this.setRotateAngle(Head, 0.091106186954104F, 0.0F, 0.0F);
		this.FrontFlipper_Left = new AdvancedModelRenderer(this, 72, 45);
		this.FrontFlipper_Left.mirror = true;
		this.FrontFlipper_Left.setRotationPoint(3.5F, 2.0F, -3.0F);
		this.FrontFlipper_Left.addBox(-0.5F, 0.0F, -3.0F, 1, 12, 6, 0.0F);
		this.setRotateAngle(FrontFlipper_Left, 0.17453292519943295F, 0.0F, -1.2217304763960306F);
		this.JawBottomBase = new AdvancedModelRenderer(this, 0, 27);
		this.JawBottomBase.mirror = true;
		this.JawBottomBase.setRotationPoint(0.0F, 2.5F, -0.5F);
		this.JawBottomBase.addBox(-2.5F, -1.0F, -7.0F, 5, 3, 7, 0.0F);
		this.setRotateAngle(JawBottomBase, -0.045553093477052F, 0.0F, 0.0F);
		this.Tail = new AdvancedModelRenderer(this, 80, 28);
		this.Tail.mirror = true;
		this.Tail.setRotationPoint(0.0F, -0.5F, 13.0F);
		this.Tail.addBox(-3.0F, -4.0F, 0.0F, 6, 8, 8, 0.0F);
		this.setRotateAngle(Tail, -0.045553093477052F, 0.0F, 0.0F);
		this.BackFlipper_Left = new AdvancedModelRenderer(this, 59, 49);
		this.BackFlipper_Left.mirror = true;
		this.BackFlipper_Left.setRotationPoint(3.5F, 1.0F, 13.0F);
		this.BackFlipper_Left.addBox(-0.5F, 0.0F, -2.0F, 1, 10, 5, 0.0F);
		this.setRotateAngle(BackFlipper_Left, 0.5235987755982988F, 0.0F, -1.2217304763960306F);
		this.Teeth = new AdvancedModelRenderer(this, 0, 51);
		this.Teeth.mirror = true;
		this.Teeth.setRotationPoint(0.0F, 0.4F, 0.0F);
		this.Teeth.addBox(-2.0F, 1.6F, -12.0F, 4, 1, 10, 0.0F);
		this.Neck = new AdvancedModelRenderer(this, 29, 50);
		this.Neck.mirror = true;
		this.Neck.setRotationPoint(0.0F, 0.0F, -3.0F);
		this.Neck.addBox(-2.5F, -3.0F, -10.0F, 5, 6, 8, 0.0F);
		this.UpperBody = new AdvancedModelRenderer(this, 30, 35);
		this.UpperBody.mirror = true;
		this.UpperBody.setRotationPoint(0.0F, -0.5F, 0.3F);
		this.UpperBody.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F);
		this.setRotateAngle(UpperBody, 0.045553093477052F, 0.0F, 0.0F);
		this.Tail2 = new AdvancedModelRenderer(this, 84, 2);
		this.Tail2.mirror = true;
		this.Tail2.setRotationPoint(0.0F, -0.5F, 7.0F);
		this.Tail2.addBox(-1.5F, -2.0F, 0.0F, 3, 4, 6, 0.0F);
		this.FrontFlipper_Right = new AdvancedModelRenderer(this, 72, 45);
		this.FrontFlipper_Right.setRotationPoint(-3.5F, 2.0F, -3.0F);
		this.FrontFlipper_Right.addBox(-0.5F, 0.0F, -3.0F, 1, 12, 6, 0.0F);
		this.setRotateAngle(FrontFlipper_Right, 0.17453292519943295F, 0.0F, 1.2217304763960306F);
		this.JawTop = new AdvancedModelRenderer(this, 0, 12);
		this.JawTop.mirror = true;
		this.JawTop.setRotationPoint(0.0F, 0.0F, -6.5F);
		this.JawTop.addBox(-2.0F, -1.0F, -12.0F, 4, 3, 12, 0.0F);
		this.LowerBody.addChild(this.BackFlipper_Right);
		this.JawBottomBase.addChild(this.JawBottom);
		this.Tail.addChild(this.Tail1);
		this.Neck.addChild(this.Head);
		this.UpperBody.addChild(this.FrontFlipper_Left);
		this.Head.addChild(this.JawBottomBase);
		this.LowerBody.addChild(this.Tail);
		this.LowerBody.addChild(this.BackFlipper_Left);
		this.JawTop.addChild(this.Teeth);
		this.UpperBody.addChild(this.Neck);
		this.LowerBody.addChild(this.UpperBody);
		this.Tail1.addChild(this.Tail2);
		this.UpperBody.addChild(this.FrontFlipper_Right);
		this.Head.addChild(this.JawTop);
		this.updateDefaultPose();
		animator = ModelAnimator.create();
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, f5);
		this.LowerBody.render(f5);
	}

	public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		animator.update(entity);
		blockMovement(f, f1, f2, f3, f4, f5, (Entity) entity);
		this.resetToDefaultPose();
		setRotationAngles(f, f1, f2, f3, f4, f5, (Entity) entity);
		animator.setAnimation(EntityLiopleurodon.SHAKE_ANIMATION);
		animator.startKeyframe(10);
		ModelUtils.rotate(animator, Neck, 0, -23F, 0);
		ModelUtils.rotate(animator, Head, 0, -23F, 0);
		ModelUtils.rotate(animator, JawBottom, 15F, 0, 0);
		animator.endKeyframe();
		animator.startKeyframe(10);
		ModelUtils.rotate(animator, Neck, 0, 23F, 0);
		ModelUtils.rotate(animator, Head, 0, 23F, 0);
		ModelUtils.rotate(animator, JawBottom, 15F, 0, 0);
		animator.endKeyframe();
		animator.startKeyframe(10);
		ModelUtils.rotate(animator, Neck, 0, -23F, 0);
		ModelUtils.rotate(animator, Head, 0, -23F, 0);
		ModelUtils.rotate(animator, JawBottom, 15F, 0, 0);
		animator.endKeyframe();
		animator.startKeyframe(10);
		ModelUtils.rotate(animator, Neck, 0, 23F, 0);
		ModelUtils.rotate(animator, Head, 0, 23F, 0);
		ModelUtils.rotate(animator, JawBottom, 15F, 0, 0);
		animator.endKeyframe();
		animator.resetKeyframe(10);
		animator.setAnimation(EntityLiopleurodon.ATTACK_ANIMATION);
		animator.startKeyframe(5);
		ModelUtils.rotate(animator, Head, 0, -10F, 0);
		ModelUtils.rotate(animator, JawBottomBase, 35F, 0, 0);
		animator.endKeyframe();
		animator.resetKeyframe(5);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		AdvancedModelRenderer[] tailParts = {this.Tail, this.Tail1, this.Tail2};
		AdvancedModelRenderer[] neckParts = {this.Neck, this.Head};
		if(entity.riddenByEntity == null){
			ModelUtils.faceTargetMod(Neck, f3, f4, 0.5F);
			ModelUtils.faceTargetMod(Head, f3, f4, 0.5F);
		}
		float speed = 0.1F;
		float speed2 = 0.4F;
		this.JawBottomBase.setScale(1.01F, 1.01F, 1.01F);
		this.chainSwing(tailParts, speed2, 0.3F, -3, f, f1);
		this.swing(UpperBody, speed2, 0.1F, true, 0, 0, f, f1);
		this.swing(LowerBody, speed2, 0.1F, true, 0, 0, f, f1);
		this.chainSwing(neckParts, speed2, -0.1F, 2, f, f1);
		this.flap(FrontFlipper_Right, speed2, 0.6F, true, 0, 0, f, f1);
		this.flap(FrontFlipper_Left, speed2, 0.6F, false, 0, 0, f, f1);
		this.flap(BackFlipper_Right, speed2, 0.6F, false, 0, 0, f, f1);
		this.flap(BackFlipper_Left, speed2, 0.6F, true, 0, 0, f, f1);
		((EntityNewPrehistoric) entity).chainBuffer.applyChainSwingBuffer((ModelRenderer[]) tailParts);
	}
}
