package com.github.revival.client.model.prehistoric;

import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.client.model.ModelRenderer;

import java.lang.reflect.Field;

public class ModelUtils {

    public static void rotate(ModelAnimator animator, ModelRenderer box, double x, double y, double z) {
        animator.rotate(box, (float) Math.toRadians(x), (float) Math.toRadians(y), (float) Math.toRadians(z));
    }

    public static void rotateToInit(ModelAnimator animator, AdvancedModelRenderer box) {
        animator.rotate(box, getDefaultRotationX(box), getDefaultRotationY(box), getDefaultRotationZ(box));
    }

    public static void faceTargetMod(AdvancedModelRenderer part, float f3, float f4, float multi){
    	part.rotateAngleY += f3 / (180F / (float)Math.PI) * multi;
    	part.rotateAngleX += f4 / (180F / (float)Math.PI) * multi;

    }

    public static void setRotateAngle(AdvancedModelRenderer AdvancedModelRenderer, float x, float y, float z) {
        AdvancedModelRenderer.rotateAngleX = x;
        AdvancedModelRenderer.rotateAngleY = y;
        AdvancedModelRenderer.rotateAngleZ = z;
    }

    public static void setRotateAngleAlt(AdvancedModelRenderer AdvancedModelRenderer, float x, float y, float z) {
        AdvancedModelRenderer.rotateAngleX = (float) Math.toRadians(x);
        AdvancedModelRenderer.rotateAngleY = (float) Math.toRadians(y);
        AdvancedModelRenderer.rotateAngleZ = (float) Math.toRadians(z);
    }

    private static Field defaultRotationX;
    private static Field defaultRotationY;
    private static Field defaultRotationZ;
    private static Field defaultPositionX;
    private static Field defaultPositionY;
    private static Field defaultPositionZ;
    static {
        try {
            defaultRotationX = AdvancedModelRenderer.class.getField("defaultRotationX");
            defaultRotationX.setAccessible(true);
            defaultRotationY = AdvancedModelRenderer.class.getField("defaultRotationY");
            defaultRotationY.setAccessible(true);
            defaultRotationZ = AdvancedModelRenderer.class.getField("defaultRotationZ");
            defaultRotationZ.setAccessible(true);
            defaultPositionX = AdvancedModelRenderer.class.getField("defaultPositionX");
            defaultPositionX.setAccessible(true);
            defaultPositionY = AdvancedModelRenderer.class.getField("defaultPositionY");
            defaultPositionY.setAccessible(true);
            defaultPositionZ = AdvancedModelRenderer.class.getField("defaultPositionZ");
            defaultPositionZ.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    public static float getDefaultRotationX(AdvancedModelRenderer box) {
        try {
            return defaultRotationX.getFloat(box);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0.0F;
        }
    }
    public static float getDefaultRotationY(AdvancedModelRenderer box) {
        try {
            return defaultRotationY.getFloat(box);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0.0F;
        }
    }
    public static float getDefaultRotationZ(AdvancedModelRenderer box) {
        try {
            return defaultRotationZ.getFloat(box);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0.0F;
        }
    }
    public static float getDefaultPositionX(AdvancedModelRenderer box) {
        try {
            return defaultPositionX.getFloat(box);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0.0F;
        }
    }
    public static float getDefaultPositionY(AdvancedModelRenderer box) {
        try {
            return defaultPositionY.getFloat(box);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0.0F;
        }
    }
    public static float getDefaultPositionZ(AdvancedModelRenderer box) {
        try {
            return defaultPositionZ.getFloat(box);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0.0F;
        }
    }
}
