package fossilsarcheology.client.render.entity;

import fossilsarcheology.client.model.ModelDinoEgg;
import fossilsarcheology.server.entity.EntityDinoEgg;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderDinoEgg extends RenderLiving {

    public RenderDinoEgg(float var1) {
        super(new ModelDinoEgg(), var1);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float f) {
        GL11.glScalef(((EntityDinoEgg) entity).selfType.eggScale, ((EntityDinoEgg) entity).selfType.eggScale, ((EntityDinoEgg) entity).selfType.eggScale);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return new ResourceLocation(((EntityDinoEgg) entity).getTexture());
    }

}
