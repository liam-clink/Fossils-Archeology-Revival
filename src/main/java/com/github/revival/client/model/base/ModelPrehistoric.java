package com.github.revival.client.model.base;

import com.github.revival.client.renderer.entity.RenderPrehistoric;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelPrehistoric extends AdvancedModelBase {
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        doAdvancedStuff(true);
        renderAll();
        if (entity instanceof EntityNewPrehistoric) {
            EntityNewPrehistoric mob = (EntityNewPrehistoric) entity;
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
    public void renderFossil(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {
    }

    /**
     * PreRender and setAngles
     */
    public void renderLiving(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {
    }

    /**
     * PreRender and setAngles
     */
    public void renderSleeping(EntityNewPrehistoric entity, float f, float f1, float f2, float f3, float f4, float f5) {
    }

    public void renderHeldItem(RenderPrehistoric renderPrehistoric, EntityLivingBase entity, float i) {
    }

    public void renderAll() {
        for (Object element : this.boxList) {
            if (element instanceof AdvancedModelRenderer) {
                AdvancedModelRenderer box = (AdvancedModelRenderer) element;
                if (box.getParent() == null) {
                    box.render(0.0625F);
                }
            }
        }
    }

    public void doAdvancedStuff(boolean reset) {
        for (Object element : this.boxList) {
            if (element instanceof AdvancedModelRenderer) {
                AdvancedModelRenderer box = (AdvancedModelRenderer) element;
                if (reset) {
                    box.resetToDefaultPose();
                } else {
                    box.updateDefaultPose();
                }
            }
        }
    }

    public void setRotateAngle(AdvancedModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

