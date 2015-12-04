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

	public static void animateOrSetRotation(Animator animator, boolean animate, MowzieModelRenderer part, float x, float y, float z, boolean override){
		if(animate){
			if(override){
				animator.rotate(part, -part.initRotateAngleX, -part.initRotateAngleY, -part.initRotateAngleZ);
			}else{
				animator.rotate(part, x, y, z);
			}
		}else{
			ModelUtils.setRotateAngle(part, x, y, z);
		}
	}

	public static void animateToPos(Animator animator, boolean animate, MowzieModelRenderer part, float x, float y, float z, boolean override){
		if(animate){
			if(override){
				animator.move(part, x, y, z);

			}else{
				animator.move(part, x == 0 ? 0 : x - part.initRotationPointY, y == 0 ? y : y - part.initRotationPointY,  z == 0 ? z :z - part.initRotationPointZ);
			}
		}
	}

	public static void setPos(Animator animator, boolean animate, MowzieModelRenderer part, float x, float y, float z, boolean override){
		if(!animate){
			if(!override){
				part.setRotationPoint(x, y, z);
			}else{
				part.setRotationPoint(x == 0 ? 0 : x - part.initRotationPointY, y == 0 ? y : y - part.initRotationPointY,  z == 0 ? z :z - part.initRotationPointZ);
			}
		}
	}

	public static void rotate(Animator animator, ModelRenderer box, double x, double y, double z){
		animator.rotate(box, (float)Math.toRadians(x), (float)Math.toRadians(y), (float)Math.toRadians(z));
	}

	public static void rotateToInit(Animator animator, MowzieModelRenderer box){
		animator.rotate(box, box.initRotateAngleX, box.initRotateAngleY, box.initRotateAngleZ);
	}

	public static void rotateAllToInit(Animator animator, List boxList){
		Iterator itr = boxList.iterator();
		while(itr.hasNext()) {
			Object element = itr.next();
			if(element instanceof MowzieModelRenderer){
				MowzieModelRenderer box = (MowzieModelRenderer)element;
				
				animator.rotate(box, box.rotateAngleX == box.initRotateAngleX ? 0 : box.initRotateAngleX,
						box.rotateAngleY == box.initRotateAngleY ? 0 : box.initRotateAngleY,
								box.rotateAngleZ == box.initRotateAngleZ ? 0 : box.initRotateAngleZ);
				animator.move(box, box.rotationPointX == box.initRotationPointX ? 0 : box.initRotationPointX,
						box.rotationPointY == box.initRotationPointY ? 0 : box.initRotationPointY,
								box.rotationPointZ == box.initRotationPointZ ? 0 : box.initRotationPointZ);
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
