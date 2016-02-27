package com.github.revival.client.renderer.entity;

import com.github.revival.client.model.FPZModel;
import com.github.revival.server.entity.mob.FriendlyPigZombieEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class FPZRenderer extends RenderBiped {
    private static final ResourceLocation skeletonTextures = new ResourceLocation("textures/entity/zombie_pigman.png");

    public FPZRenderer() {
        super(new FPZModel(), 0.5F);
    }

    protected void scaleSkeleton(FriendlyPigZombieEntity par1EntitySkeleton, float par2) {
//       if (par1EntitySkeleton.getSkeletonType() == 1)
//       {
        GL11.glScalef(1.2F, 1.2F, 1.2F);
//       }
    }

    protected void func_82422_c() {
        GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
    }

    protected ResourceLocation func_110860_a(FriendlyPigZombieEntity par1EntitySkeleton) {
        //      return par1EntitySkeleton.getSkeletonType() == 1 ? witherSkeletonTextures : skeletonTextures;
        return skeletonTextures;
    }

    protected ResourceLocation func_110856_a(EntityLiving par1EntityLiving) {
        return this.func_110860_a((FriendlyPigZombieEntity) par1EntityLiving);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
        this.scaleSkeleton((FriendlyPigZombieEntity) par1EntityLivingBase, par2);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return this.func_110860_a((FriendlyPigZombieEntity) par1Entity);
    }
}
