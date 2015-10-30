package com.github.revival.client.model.prehistoric;

import java.util.Iterator;
import java.util.List;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.ilexiconn.llibrary.common.animation.Animator;
import net.ilexiconn.llibrary.common.animation.Transform;
import net.minecraft.client.model.ModelRenderer;

public class ModelUtils {
	public static void renderAll(List boxList){
		Iterator itr = boxList.iterator();
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
	public static void doMowzieStuff(boolean reset, List boxList){
		Iterator itr = boxList.iterator();
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
	public static void rotate(Animator animator, ModelRenderer box, double x, double y, double z){
		animator.rotate(box, (float)Math.toRadians(x), (float)Math.toRadians(y), (float)Math.toRadians(z));
	}
	public static void rotateToInit(Animator animator, MowzieModelRenderer box){
		animator.rotate(box, box.initRotateAngleX, box.initRotateAngleY, box.initRotateAngleZ);
	}
	public static void setRotateAngle(MowzieModelRenderer MowzieModelRenderer, float x, float y, float z)
    {
        MowzieModelRenderer.rotateAngleX = x;
        MowzieModelRenderer.rotateAngleY = y;
        MowzieModelRenderer.rotateAngleZ = z;
    }
}
