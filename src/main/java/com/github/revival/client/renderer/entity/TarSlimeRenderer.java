package com.github.revival.client.renderer.entity;

import com.github.revival.client.model.TarSlimeModel;
import com.github.revival.client.model.TarSlimeOuterModel;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.ResourceLocation;

public class TarSlimeRenderer extends RenderSlime {

    public TarSlimeRenderer() {
        super(new TarSlimeModel(), new TarSlimeOuterModel(), 0.3F);
    }

    protected ResourceLocation getEntityTexture(EntitySlime entity) {
        return new ResourceLocation("fossil:textures/model/tar_slime.png");
    }
}
