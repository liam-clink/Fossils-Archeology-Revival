package com.github.revival.client.renderer.entity;

import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderGlowingPrehistoric extends RenderLiving {

    public ResourceLocation overlay;

    public RenderGlowingPrehistoric(ModelBase model, ResourceLocation overlay) {
        super(model, 0.3F);
        this.overlay = overlay;
        this.setRenderPassModel(model);

    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        if (entity instanceof EntityNewPrehistoric) {
            EntityNewPrehistoric prehistoric = (EntityNewPrehistoric) entity;
            return new ResourceLocation(prehistoric.getTexture());
        } else {
            return null;
        }
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float f) {
        if (entity instanceof EntityNewPrehistoric) {
            EntityNewPrehistoric prehistoric = (EntityNewPrehistoric) entity;
            GL11.glScalef(prehistoric.getDinosaurSize(), prehistoric.getDinosaurSize(), prehistoric.getDinosaurSize());
        }
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase entity, int i, float q) {
        if (i == 2 && entity instanceof EntityNewPrehistoric) {
            this.bindTexture(new ResourceLocation(((EntityNewPrehistoric) entity).getOverlayTexture()));
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
            GL11.glEnable(GL11.GL_ALPHA_TEST);

            return 2;
        } else {

            return -1;
        }

    }

}
