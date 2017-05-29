package fossilsarcheology.client.render.entity;

import fossilsarcheology.client.model.ModelPigBoss;
import fossilsarcheology.client.render.entity.layer.LayerAnuGlow;
import fossilsarcheology.server.entity.monster.EntityAnu;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderPigBoss extends RenderLiving {

    public RenderPigBoss(RenderManager manager) {
        super(manager, new ModelPigBoss(), 0.5F);
        this.addLayer(new LayerHeldItem(this));
        this.addLayer(new LayerAnuGlow(this));

    }

    protected ResourceLocation func_110919_a(EntityAnu par1Entity) {
        return new ResourceLocation("fossil:textures/model/PigBoss.png");
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return this.func_110919_a((EntityAnu) par1Entity);
    }

    protected void preRenderScale(EntityAnu mob, float par2) {
        if (mob.getAttackMode() == 1) {
            GL11.glRotatef(35, 1, 0, 0);
        }
    }

    protected int shouldRenderPass(EntityLivingBase entity, int i, float q) {
        if (((EntityAnu) entity).getAttackMode() == 2) {

            if (i != 0) {
                return -1;
            } else {
                this.bindTexture(new ResourceLocation("fossil:textures/model/PigBoss_overlay.png"));
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glDisable(GL11.GL_ALPHA_TEST);
                GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

                if (entity.isInvisible()) {
                    GL11.glDepthMask(false);
                } else {
                    GL11.glDepthMask(true);
                }

                char c0 = 61680;
                int j = c0 % 65536;
                int k = c0 / 65536;
                OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j / 1.0F, (float) k / 1.0F);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                return 1;
            }
        }
        return -1;
    }

    @Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
        this.preRenderScale((EntityAnu) par1EntityLivingBase, par2);
    }

}
