package com.github.revival.client.model.prehistoric.test;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.llibrary.common.animation.Animator;
import net.minecraft.entity.Entity;

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

}
