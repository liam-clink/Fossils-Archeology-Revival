package com.github.revival.client.model.prehistoric;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import com.github.revival.common.entity.mob.EntityDodo;

public class ModelDodo extends MowzieModelBase {
	public MowzieModelRenderer body;
	public MowzieModelRenderer leftLeg;
	public MowzieModelRenderer rightLeg;
	public MowzieModelRenderer body_fat;
	public MowzieModelRenderer tail;
	public MowzieModelRenderer rightWing;
	public MowzieModelRenderer leftWing;
	public MowzieModelRenderer bottom;
	public MowzieModelRenderer neck;
	public MowzieModelRenderer head;
	public MowzieModelRenderer beak;

	public ModelDodo() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.head = new MowzieModelRenderer(this, 35, 5);
		this.head.setRotationPoint(0.0F, -6.0F, 0.3F);
		this.head.addBox(-2.5F, -3.0F, -4.0F, 5, 4, 4, 0.0F);
		ModelUtils.setRotateAngle(head, 0.2230530784048753F, -0.0F, 0.0F);
		this.neck = new MowzieModelRenderer(this, 0, 16);
		this.neck.setRotationPoint(0.0F, 3.0F, -1.0F);
		this.neck.addBox(-2.0F, -8.0F, -1.5F, 4, 8, 3, 0.0F);
		ModelUtils.setRotateAngle(neck, -0.2230530784048753F, -0.0F, 0.0F);
		this.leftWing = new MowzieModelRenderer(this, 34, 25);
		this.leftWing.setRotationPoint(3.5F, 3.0F, 3.0F);
		this.leftWing.addBox(0.0F, -1.0F, -2.0F, 1, 3, 4, 0.0F);
		this.body = new MowzieModelRenderer(this, 0, 0);
		this.body.setRotationPoint(0.5F, 13.0F, -6.0F);
		this.body.addBox(-3.5F, 0.0F, 0.0F, 7, 7, 9, 0.0F);
		this.bottom = new MowzieModelRenderer(this, 0, 27);
		this.bottom.setRotationPoint(0.0F, 7.0F, 5.0F);
		this.bottom.addBox(-3.5F, 0.0F, -2.0F, 7, 1, 4, 0.0F);
		this.leftLeg = new MowzieModelRenderer(this, 22, 24);
		this.leftLeg.setRotationPoint(2.5F, 21.0F, 0.0F);
		this.leftLeg.addBox(-1.5F, 0.0F, -3.0F, 3, 3, 3, 0.0F);
		this.rightLeg = new MowzieModelRenderer(this, 22, 24);
		this.rightLeg.setRotationPoint(-1.5F, 21.0F, 0.0F);
		this.rightLeg.addBox(-1.5F, 0.0F, -3.0F, 3, 3, 3, 0.0F);
		this.body_fat = new MowzieModelRenderer(this, 0, 0);
		this.body_fat.setRotationPoint(0.5F, 13.0F, -6.0F);
		this.body_fat.addBox(-3.5F, 0.0F, 0.0F, 7, 7, 9, 0.0F);
		this.tail = new MowzieModelRenderer(this, 14, 16);
		this.tail.setRotationPoint(0F, 1.0F, 6.5F);
		this.tail.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 4, 0.0F);
		ModelUtils.setRotateAngle(tail, -0.18587756533739608F, -0.0F, 0.0F);
		this.rightWing = new MowzieModelRenderer(this, 34, 25);
		this.rightWing.setRotationPoint(-3.5F, 3.0F, 3.0F);
		this.rightWing.addBox(-1.0F, -1.0F, -2.0F, 1, 3, 4, 0.0F);
		this.beak = new MowzieModelRenderer(this, 23, 1);
		this.beak.setRotationPoint(0F, -1.0F, -4.0F);
		this.beak.addBox(-1.5F, -1.0F, -5.0F, 3, 3, 5, 0.0F);
		this.neck.addChild(this.head);
		this.body.addChild(this.neck);
		this.body.addChild(this.leftWing);
		this.body.addChild(this.bottom);
		this.body.addChild(this.tail);
		this.body.addChild(this.rightWing);
		this.head.addChild(this.beak);
		this.setInitPose();
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
		this.setToInitPose();
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.body.render(f5);
		this.leftLeg.render(f5);
		this.rightLeg.render(f5);
		if(this.isChild){
			head.setScale(1.5F, 1.5F, 1.5F);
			beak.setScale(0.5F, 0.5F, 0.5F);
			beak.setRotationPoint(0, -1, -3.5F);
		}
		
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		MowzieModelRenderer[] tailParts = {this.tail};
		MowzieModelRenderer[] neckParts = {this.neck, this.head};	
		EntityDodo dodo = (EntityDodo)entity;
		this.rightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
		float speed = 1.5F;
		float speed2 = 0.1F;
		
		if(dodo.getSleeping() == 1){
			this.sleepPose();
		}else{
			faceTarget(head, 1, f3, f4);
			this.bob(body, speed2, -0.4F, false, entity.ticksExisted, 1);
			//this.bob(bottom, speed2, -0.4F, false, entity.ticksExisted, 1);
			this.walk(leftLeg, speed, 0.2F, false, 0F, -0.6F, f, f1);
			this.walk(rightLeg, speed, 0.2F, true, 0F, -0.6F, f, f1);
			this.chainWave(tailParts, speed2, 0.05F, -3, entity.ticksExisted, 1);
			this.chainSwing(tailParts, speed2, 0.15F, -3, entity.ticksExisted, 1);
			this.chainWave(neckParts, speed2, 0.1F, -3, entity.ticksExisted, 1);
			this.chainWave(neckParts, speed2, 0.2F, -3, f, f1);
			this.bob(body_fat, speed2, -0.4F, false, entity.ticksExisted, 1);
		}
		if(dodo.getFat() > 0){
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, f5 - ((dodo.getFat()) * 0.1F) - 0.2F, 0);
			GL11.glScalef(((dodo.getFat()) * 0.1F) + 1, ((dodo.getFat()) * 0.1F) + 1, ((dodo.getFat()) * 0.1F) + 1);
			this.body_fat.render(f5);
			GL11.glPopMatrix();
			this.bob(body_fat, speed2, 0.4F, false, entity.ticksExisted, 1);
			if(dodo.getFat() > 5){
				ModelUtils.setRotateAngle(neck, 0.7285004297824331F, -0.0F, 0.0F);
				ModelUtils.setRotateAngle(head, -0.7285004297824331F, -0.0F, 0.0F);
				this.chainWave(neckParts, speed2, 0.1F, -3, entity.ticksExisted, 1);
				this.chainWave(neckParts, speed2, 0.2F, -3, f, f1);
				this.walk(leftLeg, 0.7F, 0.7F, true, 0F, 0F, entity.ticksExisted, -1);
				this.walk(rightLeg, 0.7F, 0.7F, true, 0F, 0F, entity.ticksExisted, 1);
			}else{
				neck.setCurrentPoseToInitValues();
				head.setCurrentPoseToInitValues();
			}
		}



	}

	private void sleepPose() {
		ModelUtils.setRotateAngle(tail, -0.18587756533739608F, -0.0F, 0.0F);
		ModelUtils.setRotateAngle(leftLeg, -1.5533430342749532F, -0.0F, 0.0F);
		ModelUtils.setRotateAngle(rightLeg, -1.5533430342749532F, -0.0F, 0.0F);
		ModelUtils.setRotateAngle(neck, -0.8196066167365371F, -0.0F, 0.0F);
		ModelUtils.setRotateAngle(head, 0.8196066167365371F, 0.3520329101272563F, 0.0F);
        this.body.setRotationPoint(0.5F, 16.0F, -6.0F);
        this.leftLeg.setRotationPoint(2.5F, 24.0F, 0.0F);
        this.rightLeg.setRotationPoint(-1.5F, 24.0F, 0.0F);

	}
}
