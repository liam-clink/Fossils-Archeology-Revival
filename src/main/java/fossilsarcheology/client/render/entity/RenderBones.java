package fossilsarcheology.client.render.entity;

import fossilsarcheology.client.model.ModelBones;
import fossilsarcheology.server.entity.mob.EntityBones;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBones extends RenderBiped {
    private static final ResourceLocation skeletonTextures = new ResourceLocation("textures/entity/skeleton/skeleton.png");
    private static final ResourceLocation witherSkeletonTextures = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");

    public RenderBones() {
        super(new ModelBones(), 0.5F);
    }

    protected void scaleSkeleton(EntityBones par1EntitySkeleton, float par2) {
        // if (par1EntitySkeleton.getSkeletonType() == 1)
        // {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
        // }
    }

    @Override
    protected void func_82422_c() {
        GlStateManager.translate(0.09375F, 0.1875F, 0.0F);
    }

    protected ResourceLocation func_110860_a(EntityBones par1EntitySkeleton) {
        // return par1EntitySkeleton.getSkeletonType() == 1 ?
        // witherSkeletonTextures : skeletonTextures;
        return skeletonTextures;
    }

    protected ResourceLocation func_110856_a(EntityLiving par1EntityLiving) {
        return this.func_110860_a((EntityBones) par1EntityLiving);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before
     * the model is rendered. Args: entityLiving, partialTickTime
     */
    @Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
        this.scaleSkeleton((EntityBones) par1EntityLivingBase, par2);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called
     * unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return this.func_110860_a((EntityBones) par1Entity);
    }
}
