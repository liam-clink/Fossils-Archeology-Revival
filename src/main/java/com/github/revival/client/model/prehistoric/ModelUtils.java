package com.github.revival.client.model.prehistoric;

import java.util.Iterator;
import java.util.List;

import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;

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
	public static void setRotateAngle(MowzieModelRenderer MowzieModelRenderer, float x, float y, float z)
    {
        MowzieModelRenderer.rotateAngleX = x;
        MowzieModelRenderer.rotateAngleY = y;
        MowzieModelRenderer.rotateAngleZ = z;
    }
}
