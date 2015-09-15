package com.github.revival.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.github.revival.common.entity.mob.EntityAnu;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public class RenderPrehistoric extends RenderLiving{


	public RenderPrehistoric(ModelBase model) {
		super(model, 0.3F);
	}
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		if(entity instanceof EntityNewPrehistoric){
			EntityNewPrehistoric prehistoric = (EntityNewPrehistoric)entity;
			return new ResourceLocation(prehistoric.getTexture());
		}else{
			return null;
		}
	}
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		GL11.glScalef(((EntityNewPrehistoric)entity).getDinosaurSize(), ((EntityNewPrehistoric)entity).getDinosaurSize(), ((EntityNewPrehistoric)entity).getDinosaurSize());
	}
}
