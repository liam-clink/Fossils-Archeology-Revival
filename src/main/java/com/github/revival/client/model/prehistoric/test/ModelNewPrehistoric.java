package com.github.revival.client.model.prehistoric.test;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
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
			if(prehistoric.isSleeping()){
				sleepPose(false);
			}
		}
	}

	public abstract void sleepPose(boolean animate);
	
	public void hurtPose(boolean animate){}

	public void renderHeldItem(RenderPrehistoric renderPrehistoric, EntityLiving entity, float i) {}

	public void sitAnimationRotation(MowzieModelRenderer modelRenderer, float sitProgress, float rotX, float rotY, float rotZ)
    {
        modelRenderer.rotateAngleX += sitProgress * rotX / 25.0F;
        modelRenderer.rotateAngleY += sitProgress * rotY / 25.0F;
        modelRenderer.rotateAngleZ += sitProgress * rotZ / 25.0F;
    }

	public void sitAnimationPos(MowzieModelRenderer modelRenderer, float sitProgress, float x, float y, float z)
    {
        modelRenderer.rotationPointX += sitProgress * x / 20.0F;
        modelRenderer.rotationPointY += sitProgress * y / 20.0F;
        modelRenderer.rotationPointZ += sitProgress * z / 20.0F;
    }
}
