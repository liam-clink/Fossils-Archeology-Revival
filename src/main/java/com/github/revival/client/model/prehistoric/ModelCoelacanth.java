package com.github.revival.client.model.prehistoric;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import com.github.revival.client.model.base.ModelPrehistoric;
import com.github.revival.common.entity.mob.EntityCoelacanth;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public class ModelCoelacanth extends ModelPrehistoric
{
	MowzieModelRenderer tail;
	MowzieModelRenderer head;
	MowzieModelRenderer fin2;
	MowzieModelRenderer fin4;
	MowzieModelRenderer DorsalFin2;
	MowzieModelRenderer DorsalFin3;
	MowzieModelRenderer fin1;
	MowzieModelRenderer fin3;
	MowzieModelRenderer DorsalFin1;

	public ModelCoelacanth()
	{
		textureWidth = 64;
		textureHeight = 32;
		setTextureOffset("tail.tail", 20, 0);
		setTextureOffset("fin2.Fin2", 0, 0);
		setTextureOffset("fin4.Fin4", 0, 0);
		setTextureOffset("DorsalFin2.DorsalFin2", 12, 0);
		setTextureOffset("DorsalFin3.DorsalFin3", 12, 0);
		setTextureOffset("head.Body", 0, 0);
		setTextureOffset("fin1.Fin1", 0, 0);
		setTextureOffset("fin3.Fin3", 0, 0);
		setTextureOffset("DorsalFin1.DorsalFin", 18, 0);

		tail = new MowzieModelRenderer(this, "tail");
		tail.setRotationPoint(0F, 15F, 0F);
		setRotation(tail, 0F, 0F, 0F);
		tail.mirror = true;
		tail.addBox("tail", -0.5F, -1F, 0F, 1, 4, 10);
		fin2 = new MowzieModelRenderer(this, "fin2");
		fin2.setRotationPoint(-0.5F, 2F, 1F);
		setRotation(fin2, 0F, 0F, 0F);
		fin2.mirror = true;
		fin2.addBox("Fin2", -1F, -0.3F, 0F, 1, 2, 3);
		tail.addChild(fin2);
		fin4 = new MowzieModelRenderer(this, "fin4");
		fin4.setRotationPoint(0.5F, 2F, 1F);
		setRotation(fin4, 0F, 0F, 0F);
		fin4.mirror = true;
		fin4.addBox("Fin4", 0F, -0.3F, 0F, 1, 2, 3);
		tail.addChild(fin4);
		DorsalFin2 = new MowzieModelRenderer(this, "DorsalFin2");
		DorsalFin2.setRotationPoint(0F, 0F, 0F);
		setRotation(DorsalFin2, 0F, 0F, 0F);
		DorsalFin2.mirror = true;
		DorsalFin2.addBox("DorsalFin2", 0F, 1F, 2F, 0, 2, 3);
		tail.addChild(DorsalFin2);
		DorsalFin3 = new MowzieModelRenderer(this, "DorsalFin3");
		DorsalFin3.setRotationPoint(0F, 0F, 0F);
		setRotation(DorsalFin3, 0F, 0F, 0F);
		DorsalFin3.mirror = true;
		DorsalFin3.addBox("DorsalFin3", 0F, -0.5F, 3F, 0, 2, 3);
		tail.addChild(DorsalFin3);
		head = new MowzieModelRenderer(this, "head");
		head.setRotationPoint(0F, 15F, 0F);
		setRotation(head, 0F, 0F, 0F);
		head.mirror = true;
		head.addBox("Body", -1F, -1F, -7.5F, 2, 5, 8);
		fin1 = new MowzieModelRenderer(this, "fin1");
		fin1.setRotationPoint(0.9333333F, 2F, -2F);
		setRotation(fin1, 0F, 0F, 0F);
		fin1.mirror = true;
		fin1.addBox("Fin1", 0F, 0F, -0.5F, 1, 2, 3);
		head.addChild(fin1);
		fin3 = new MowzieModelRenderer(this, "fin3");
		fin3.setRotationPoint(-1F, 2F, -2F);
		setRotation(fin3, 0F, 0F, 0F);
		fin3.mirror = true;
		fin3.addBox("Fin3", -1F, 0F, -0.5F, 1, 2, 3);
		head.addChild(fin3);
		DorsalFin1 = new MowzieModelRenderer(this, "DorsalFin1");
		DorsalFin1.setRotationPoint(0F, -1F, -1F);
		setRotation(DorsalFin1, -0.6320364F, 0F, 0F);
		DorsalFin1.mirror = true;
		DorsalFin1.addBox("DorsalFin", -0.5F, -1F, -0.5F, 1, 2, 2);
		head.addChild(DorsalFin1);
		doMowzieStuff(false);
	}


	private void setRotation(MowzieModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7)
	{
		super.setRotationAngles(var1, var2, var3, var4, var5, var6, var7);


		
	}

	@Override
	public void renderFossil(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {
		
	}

	@Override
	public void renderLiving(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.DorsalFin1.rotateAngleX = -0.632036082F;
		if (entity.isInWater() || entity.getAir() > 0)
		{
			this.tail.rotateAngleZ = 0F;
			this.head.rotateAngleZ = 0F;
			this.fin1.rotateAngleY = 0.4F * MathHelper.sin(f2 * 0.3F + 2.0F) + 0.4F;
			this.fin3.rotateAngleY = -(0.4F * MathHelper.sin(f2 * 0.3F + 3.0F) + 0.4F);
			this.fin1.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + 3.0F) + 0.4F;
			this.fin3.rotateAngleX = 0.2F * MathHelper.sin(f2 * 0.3F + 3.0F) + 0.4F;

			this.fin4.rotateAngleY = 0.2F * MathHelper.sin(f2 * 0.3F + 3.0F) + 0.1F;
			this.fin2.rotateAngleY = -(0.2F * MathHelper.sin(f2 * 0.3F + 2.0F) + 0.1F);
			this.fin4.rotateAngleX = 0.1F * MathHelper.sin(f2 * 0.3F + 1.0F) + 0.1F;
			this.fin2.rotateAngleX = 0.1F * MathHelper.sin(f2 * 0.3F + 1.0F) + 0.1F;

			this.tail.rotateAngleY = 0.2F * MathHelper.sin(f2 * (float) 0.15F + f1);
		}
		else
		{
			this.tail.rotateAngleZ = 1.57079633F;
			this.head.rotateAngleZ = 1.57079633F;

			this.tail.rotateAngleY = 0.2F * MathHelper.sin(f2 * (float) 1.15F + f1);
			this.head.rotateAngleY = -0.2F * MathHelper.sin(f2 * (float) 1.15F + f1);
		}		
	}

	@Override
	public void renderSleeping(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {
		
	}

}
