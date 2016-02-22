package com.github.revival.client.renderer.entity;

import com.github.revival.client.model.ModelTarSlime;
import com.github.revival.client.model.ModelTarSlimeOuter;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.ResourceLocation;

public class RenderTarSlime extends RenderSlime {

    public RenderTarSlime() {
        super(new ModelTarSlime(), new ModelTarSlimeOuter(), 0.3F);
    }

    protected ResourceLocation getEntityTexture(EntitySlime entity) {
        return new ResourceLocation("fossil:textures/model/tar_slime.png");
    }
}
