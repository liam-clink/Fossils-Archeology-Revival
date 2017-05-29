package fossilsarcheology.client.render.entity;

import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.ResourceLocation;

public class RenderTarSlime extends RenderSlime {

    public RenderTarSlime(RenderManager rendermanager) {
        super(rendermanager, new ModelSlime(1), 0.3F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySlime entity) {
        return new ResourceLocation("fossil:textures/model/tar_slime.png");
    }
}
