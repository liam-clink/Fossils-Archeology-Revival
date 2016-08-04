package fossilsarcheology.client.render.entity;

import fossilsarcheology.client.model.ModelDinoEgg;
import fossilsarcheology.server.entity.EntityDinosaurEgg;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderDinoEgg extends RenderLiving {

    public RenderDinoEgg(float var1) {
        super(new ModelDinoEgg(), var1);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float f) {
        GlStateManager.scale(((EntityDinosaurEgg) entity).selfType.eggScale, ((EntityDinosaurEgg) entity).selfType.eggScale, ((EntityDinosaurEgg) entity).selfType.eggScale);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return new ResourceLocation(((EntityDinosaurEgg) entity).getTexture());
    }

}
