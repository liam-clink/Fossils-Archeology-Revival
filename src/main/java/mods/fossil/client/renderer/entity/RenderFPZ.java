package mods.fossil.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.fossil.client.model.ModelBones;
import mods.fossil.client.model.ModelFPZ;
import mods.fossil.entity.mob.EntityFriendlyPigZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderFPZ extends RenderBiped
{
    private static final ResourceLocation skeletonTextures = new ResourceLocation("textures/entity/zombie_pigman.png");

    public RenderFPZ()
    {
        super(new ModelFPZ(), 0.5F);
    }

    protected void scaleSkeleton(EntityFriendlyPigZombie par1EntitySkeleton, float par2)
    {
//       if (par1EntitySkeleton.getSkeletonType() == 1)
//       {
        GL11.glScalef(1.2F, 1.2F, 1.2F);
//       }
    }

    protected void func_82422_c()
    {
        GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
    }

    protected ResourceLocation func_110860_a(EntityFriendlyPigZombie par1EntitySkeleton)
    {
        //      return par1EntitySkeleton.getSkeletonType() == 1 ? witherSkeletonTextures : skeletonTextures;
        return skeletonTextures;
    }

    protected ResourceLocation func_110856_a(EntityLiving par1EntityLiving)
    {
        return this.func_110860_a((EntityFriendlyPigZombie)par1EntityLiving);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSkeleton((EntityFriendlyPigZombie)par1EntityLivingBase, par2);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110860_a((EntityFriendlyPigZombie)par1Entity);
    }
}
