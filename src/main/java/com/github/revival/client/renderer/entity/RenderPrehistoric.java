package com.github.revival.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.github.revival.client.model.prehistoric.test.ModelNewPrehistoric;
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
	
	public void superRenderEquippedItems(EntityLivingBase entity, float i)
    {
       super.renderEquippedItems(entity, i);
    }
	public void renderEquippedItems(EntityLivingBase entity, float i)
    {
        if(this.mainModel instanceof ModelNewPrehistoric){
        	((ModelNewPrehistoric)this.mainModel).renderHeldItem(this, (EntityLiving)entity, i);
        }
    }

	public RenderManager getRenderManager() {
		return this.renderManager;
	}
}
