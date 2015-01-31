package mods.fossil.client.renderer.entity;

import mods.fossil.entity.mob.EntityFailuresaurus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderFailuresaurus extends RenderLiving
{
    private static final ResourceLocation failuresaurus_default = new ResourceLocation("fossil:textures/mob/Failuresaurus.png");
    private static final ResourceLocation failuresaurus_creepy = new ResourceLocation("fossil:textures/mob/Failuresaurus_creepy.png");
    private static final ResourceLocation failuresaurus_cute = new ResourceLocation("fossil:textures/mob/Failuresaurus_cute.png");

    public RenderFailuresaurus(ModelBase var1, float var2)
    {
        super(var1, var2);
    }

    protected ResourceLocation getResourceLocation(EntityFailuresaurus entity)
    {
    	switch (entity.getSkin())
        {
            case 0:
            default:
                return failuresaurus_default;

            case 1:
                return failuresaurus_creepy;
                
            case 2:
                return failuresaurus_cute;
        }
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getResourceLocation((EntityFailuresaurus)entity);
    }
}
