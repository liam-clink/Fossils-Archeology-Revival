package com.github.revival.client.renderer.entity;

import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderPrehistoric extends RenderLiving {

	public RenderPrehistoric(ModelBase model) {
		super(model, 0.3F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		if (entity instanceof EntityNewPrehistoric) {
			EntityNewPrehistoric prehistoric = (EntityNewPrehistoric) entity;
			return new ResourceLocation(prehistoric.getTexture());
		} else {
			return null;
		}
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f) {
		EntityNewPrehistoric dino = (EntityNewPrehistoric) entity;
		GL11.glScalef(dino.getAgeScale(), dino.getAgeScale(), dino.getAgeScale());
		GL11.glScalef(dino.getGender() == 1 ? dino.getMaleSize() : 1, dino.getGender() == 1 ? dino.getMaleSize() : 1, dino.getGender() == 1 ? dino.getMaleSize() : 1);

	}

	public void superRenderEquippedItems(EntityLivingBase entity, float i) {
		super.renderEquippedItems(entity, i);
	}

	public RenderManager getRenderManager() {
		return this.renderManager;
	}
}
