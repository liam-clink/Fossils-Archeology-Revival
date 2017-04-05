package fossilsarcheology.client.render.entity;

import fossilsarcheology.server.entity.prehistoric.EntityPrehistoric;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerCompsognathusEyes<T extends EntityPrehistoric> implements LayerRenderer<T>
{
    private static final ResourceLocation EYES = new ResourceLocation("fossil:textures/model/compsognathus_0/overlay.png");
    private final RenderGlowingPrehistoric prehistoric;

    public LayerCompsognathusEyes(RenderGlowingPrehistoric spiderRendererIn) {
        this.prehistoric = spiderRendererIn;
    }

    public void doRenderLayer(T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if(!entitylivingbaseIn.isSleeping()) {
            this.prehistoric.bindTexture(EYES);
            GlStateManager.enableBlend();
            GlStateManager.disableAlpha();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);

            if (entitylivingbaseIn.isInvisible()) {
                GlStateManager.depthMask(false);
            } else {
                GlStateManager.depthMask(true);
            }

            int i = 61680;
            int j = i % 65536;
            int k = i / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.prehistoric.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            i = entitylivingbaseIn.getBrightnessForRender(partialTicks);
            j = i % 65536;
            k = i / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);
            this.prehistoric.setLightmap(entitylivingbaseIn, partialTicks);
            GlStateManager.disableBlend();
            GlStateManager.enableAlpha();
        }
    }

    public boolean shouldCombineTextures() {
        return false;
    }
}