package fossilsarcheology.client.render.entity;

import fossilsarcheology.server.entity.EntityPrehistoric;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderPrehistoric extends RenderLiving {

    public RenderPrehistoric(ModelBase model) {
        super(model, 0.3F);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        if (entity instanceof EntityPrehistoric) {
            EntityPrehistoric prehistoric = (EntityPrehistoric) entity;
            return new ResourceLocation(prehistoric.getTexture());
        } else {
            return null;
        }
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float f) {
        EntityPrehistoric dino = (EntityPrehistoric) entity;
        GlStateManager.scale(dino.getAgeScale(), dino.getAgeScale(), dino.getAgeScale());
        GlStateManager.scale(dino.getGender() == 1 ? dino.getMaleSize() : 1, dino.getGender() == 1 ? dino.getMaleSize() : 1, dino.getGender() == 1 ? dino.getMaleSize() : 1);

    }

    public void superRenderEquippedItems(EntityLivingBase entity, float i) {
        super.renderEquippedItems(entity, i);
    }

    public RenderManager getRenderManager() {
        return this.renderManager;
    }
}
