package com.github.revival.client.renderer.entity;

import com.github.revival.common.entity.mob.EntityElasmotherium;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderElasmotherium extends RenderLiving
{
    private static final ResourceLocation elasmotheriumBrown = new ResourceLocation("fossil:textures/mob/Elasmotherium/Elasmotherium_Brown.png");
    private static final ResourceLocation elasmotheriumDark = new ResourceLocation("fossil:textures/mob/Elasmotherium/Elasmotherium_Dark.png");
    private static final ResourceLocation elasmotheriumWhite = new ResourceLocation("fossil:textures/mob/Elasmotherium/Elasmotherium_White.png");

    public RenderElasmotherium(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    public void renderElasmotherium(EntityElasmotherium par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(par1Entity, par2, par4, par6, par8, par9);
    }
    
    protected ResourceLocation func_110919_a(EntityElasmotherium par1Entity)
    {
        switch (par1Entity.getSkin())
        {
            case 0:
            default:
                return elasmotheriumBrown;
            case 1:
                return elasmotheriumDark;
            case 2:
                return elasmotheriumWhite;
        }
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderElasmotherium((EntityElasmotherium) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110919_a((EntityElasmotherium) par1Entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderElasmotherium((EntityElasmotherium) par1Entity, par2, par4, par6, par8, par9);
    }
}
