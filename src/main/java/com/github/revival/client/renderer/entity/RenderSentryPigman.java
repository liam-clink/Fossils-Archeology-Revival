package com.github.revival.client.renderer.entity;

import com.github.revival.common.entity.mob.EntitySentryPigman;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSentryPigman extends RenderBiped
{
    private static final ResourceLocation skeletonTextures = new ResourceLocation("fossil:textures/model/sentryPigman.png");

    public RenderSentryPigman()
    {
        super(new ModelZombie(), 0.5F);
    }


    protected void func_82422_c()
    {
        GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntitySentryPigman mob)
    {
        return skeletonTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityLiving mob)
    {
        return this.getEntityTexture((EntitySentryPigman) mob);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity mob)
    {
        return this.getEntityTexture((EntitySentryPigman) mob);
    }
}