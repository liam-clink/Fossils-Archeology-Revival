package com.github.revival.client.renderer.entity;

import com.github.revival.server.entity.mob.FishBaseEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class FishRenderer extends RenderLiving {


    public FishRenderer(ModelBase model) {
        super(model, 0.3F);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        if (entity instanceof FishBaseEntity) {
            FishBaseEntity prehistoric = (FishBaseEntity) entity;
            return new ResourceLocation(prehistoric.getTexture());
        } else {
            return null;
        }
    }


}
