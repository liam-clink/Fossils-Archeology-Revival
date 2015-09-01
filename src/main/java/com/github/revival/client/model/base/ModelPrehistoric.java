package com.github.revival.client.model.base;

import java.util.Iterator;

import org.lwjgl.opengl.GL11;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public class ModelPrehistoric extends MowzieModelBase{

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		doMowzieStuff(true);
		renderAll();
		if(entity instanceof EntityNewPrehistoric){
			EntityNewPrehistoric mob = (EntityNewPrehistoric)entity;
			if(mob.isModelized()){
				renderFossil(mob, f, f1, f2, f3, f4, f5);
			}else{
				if(mob.getSleeping() == 0){
					renderLiving(mob, f, f1, f2, f3, f4, f5);
				}else{
					renderSleeping(mob, f, f1, f2, f3, f4, f5);

				}
			}
		}
	}
	/**PreRender and setAngles*/
	public void renderFossil(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {
	}
	/**PreRender and setAngles*/
	public void renderLiving(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5){
	}
	/**PreRender and setAngles*/
	public void renderSleeping(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5){
	}

	public void renderAll(){
		Iterator itr = this.boxList.iterator();
		while(itr.hasNext()) {
			Object element = itr.next();
			if(element instanceof MowzieModelRenderer){
				MowzieModelRenderer box = (MowzieModelRenderer)element;
				if(box.getParent() == null){
					box.render(0.0625F);
				}
			}
		}
	}
	public void doMowzieStuff(boolean reset){
		Iterator itr = this.boxList.iterator();
		while(itr.hasNext()) {
			Object element = itr.next();
			if(element instanceof MowzieModelRenderer){
				MowzieModelRenderer box = (MowzieModelRenderer)element;
				if(reset){
					box.setCurrentPoseToInitValues();
				}else{
					box.setInitValuesToCurrentPose();
				}
			}
		}
	}
	public void setRotateAngle(MowzieModelRenderer MowzieModelRenderer, float x, float y, float z)
    {
        MowzieModelRenderer.rotateAngleX = x;
        MowzieModelRenderer.rotateAngleY = y;
        MowzieModelRenderer.rotateAngleZ = z;
    }
}

