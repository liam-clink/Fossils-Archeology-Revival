package com.github.revival.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.github.revival.common.entity.mob.EntityFishBase;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public class RenderFish extends RenderLiving{


	public RenderFish(ModelBase model) {
		super(model, 0.3F);
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		if(entity instanceof EntityFishBase){
			EntityFishBase prehistoric = (EntityFishBase)entity;
			return new ResourceLocation(prehistoric.getTexture());
		}else{
			return null;
		}
	}



	

}
