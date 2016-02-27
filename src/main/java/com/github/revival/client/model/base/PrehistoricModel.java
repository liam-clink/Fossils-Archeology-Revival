package com.github.revival.client.model.base;

import com.github.revival.client.renderer.entity.PrehistoricRenderer;
import com.github.revival.server.entity.mob.test.NewPrehistoricEntity;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelBase;
import net.ilexiconn.llibrary.client.model.modelbase.MowzieModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

import java.util.Iterator;

public class PrehistoricModel extends MowzieModelBase {
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        doMowzieStuff(true);
        renderAll();
        if (entity instanceof NewPrehistoricEntity) {
            NewPrehistoricEntity mob = (NewPrehistoricEntity) entity;
            if (mob.isModelized()) {
                renderFossil(mob, f, f1, f2, f3, f4, f5);
            } else {
                if (mob.getSleeping() == 0) {
                    renderLiving(mob, f, f1, f2, f3, f4, f5);
                } else {
                    renderSleeping(mob, f, f1, f2, f3, f4, f5);
                }
            }
        }
    }

    /**
     * PreRender and setAngles
     */
    public void renderFossil(NewPrehistoricEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    }

    /**
     * PreRender and setAngles
     */
    public void renderLiving(NewPrehistoricEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    }

    /**
     * PreRender and setAngles
     */
    public void renderSleeping(NewPrehistoricEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    }

    public void renderHeldItem(PrehistoricRenderer prehistoricRenderer, EntityLivingBase entity, float i) {
    }

    public void renderAll() {
        Iterator itr = this.boxList.iterator();
        while (itr.hasNext()) {
            Object element = itr.next();
            if (element instanceof MowzieModelRenderer) {
                MowzieModelRenderer box = (MowzieModelRenderer) element;
                if (box.getParent() == null) {
                    box.render(0.0625F);
                }
            }
        }
    }

    public void doMowzieStuff(boolean reset) {
        Iterator iterator = this.boxList.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (element instanceof MowzieModelRenderer) {
                MowzieModelRenderer box = (MowzieModelRenderer) element;
                if (reset) {
                    box.setCurrentPoseToInitValues();
                } else {
                    box.setInitValuesToCurrentPose();
                }
            }
        }
    }

    public void setRotateAngle(MowzieModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

