package com.github.revival.client.model.prehistoric.test;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

import com.github.revival.client.renderer.entity.RenderPrehistoric;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public abstract class ModelNewPrehistoric extends MowzieModelBase{

	public ModelNewPrehistoric(){
	}
	
	public void carryOutPoses(Entity entity){
		if(entity instanceof EntityNewPrehistoric){
			EntityNewPrehistoric prehistoric = (EntityNewPrehistoric)entity;
			if(prehistoric.isSitting()){
				sitPose(false);
			}
			else if(prehistoric.isSleeping()){
				sleepPose(false);
			}
		}
	}

	public abstract void sleepPose(boolean animate);
	
	public abstract void sitPose(boolean animate);

	public void hurtPose(boolean animate){}

	public void renderHeldItem(RenderPrehistoric renderPrehistoric, EntityLiving entity, float i) {}

}
