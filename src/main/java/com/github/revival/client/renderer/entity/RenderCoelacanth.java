package com.github.revival.client.renderer.entity;

import com.github.revival.common.entity.mob.EntityCoelacanth;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderCoelacanth extends RenderLiving
{
    private static final ResourceLocation coelacanthOcean = new ResourceLocation("fossil:textures/mob/Coelacanth_Ocean.png");
    private static final ResourceLocation coelacanthRiver = new ResourceLocation("fossil:textures/mob/Coelacanth_River.png");
    private static final ResourceLocation coelacanthSwamp = new ResourceLocation("fossil:textures/mob/Coelacanth_Swamp.png");

    public RenderCoelacanth(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    public void renderCoelacanth(EntityCoelacanth par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(par1Entity, par2, par4, par6, par8, par9);
    }

    /**
     * Applies the scale to the transform matrix
     */
    protected void preRenderScale(EntityCoelacanth entityCoelacant, float par2)
    {
        GL11.glScalef(2.5F, 2.5F, 2.5F);
        GL11.glTranslatef(0, 0.25F, 0);
    }
    
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderScale((EntityCoelacanth) par1EntityLivingBase, par2);
    }
    
    protected ResourceLocation func_110919_a(EntityCoelacanth par1Entity)
    {
        switch (par1Entity.getSkin())
        {
            case 0:
            default:
                return coelacanthOcean;
            case 1:
                return coelacanthRiver;
            case 2:
                return coelacanthSwamp;
        }
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderCoelacanth((EntityCoelacanth) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110919_a((EntityCoelacanth) par1Entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderCoelacanth((EntityCoelacanth) par1Entity, par2, par4, par6, par8, par9);
    }
}
