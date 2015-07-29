package com.github.revival.client.renderer.entity;

import com.github.revival.client.model.ModelConfuciusornis;
import com.github.revival.client.model.ModelFlyingConfuciusornis;
import com.github.revival.common.entity.mob.EntityConfuciusornis;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderConfuciusornis
        extends RenderLiving
{
    private static final ResourceLocation textureAdult = new ResourceLocation("fossil:textures/mob/Confuciusornis.png");
    private static final ResourceLocation textureBaby = new ResourceLocation("fossil:textures/mob/Confuciusornis_Baby.png");

    public RenderConfuciusornis()
    {
        super(new ModelConfuciusornis(), 0.3F);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        if (par1EntityLivingBase.isChild())
        {
            GL11.glScalef(0.3F, 0.3F, 0.3F);
            super.preRenderCallback(par1EntityLivingBase, par2);

        }
        else
        {
            GL11.glScalef(0.6F, 0.6F, 0.6F);
            super.preRenderCallback(par1EntityLivingBase, par2);
        }
        if (!((EntityConfuciusornis) par1EntityLivingBase).checkGround((EntityConfuciusornis) par1EntityLivingBase))
        {
            if (!(this.mainModel instanceof ModelFlyingConfuciusornis))
            {
                this.mainModel = new ModelFlyingConfuciusornis();
            }
        }
        else if (this.mainModel instanceof ModelFlyingConfuciusornis)
        {
            this.mainModel = new ModelConfuciusornis();
        }
    }

    protected ResourceLocation getEntityTextures(EntityConfuciusornis mob)
    {
        if (mob.isChild())
        {
            return textureBaby;

        }
        else
        {
            return textureAdult;
        }

    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return getEntityTextures((EntityConfuciusornis) entity);
    }
}
