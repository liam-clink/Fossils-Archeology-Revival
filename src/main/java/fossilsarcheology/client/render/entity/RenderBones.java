package fossilsarcheology.client.render.entity;

import fossilsarcheology.client.model.ModelBones;
import fossilsarcheology.server.entity.mob.EntityBones;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBones extends RenderBiped {
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/skeleton/skeleton.png");

    public RenderBones(RenderManager renderManager) {
        super(renderManager, new ModelBones(), 0.5F);
    }

    protected void scaleSkeleton(EntityBones entity, float par2) {
        GlStateManager.scale(1.2F, 1.2F, 1.2F);
    }

    @Override
    protected void func_82422_c() {
        GlStateManager.translate(0.09375F, 0.1875F, 0.0F);
    }

    protected ResourceLocation func_110860_a(EntityBones entity) {
        return TEXTURE;
    }

    protected ResourceLocation func_110856_a(EntityLiving par1EntityLiving) {
        return this.func_110860_a((EntityBones) par1EntityLiving);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float par2) {
        this.scaleSkeleton((EntityBones) entity, par2);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.func_110860_a((EntityBones) entity);
    }
}
