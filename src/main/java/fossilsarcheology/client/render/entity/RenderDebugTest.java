package fossilsarcheology.client.render.entity;

import fossilsarcheology.Revival;
import fossilsarcheology.client.render.obj.AdvancedModelLoader;
import fossilsarcheology.client.render.obj.IModelCustom;
import fossilsarcheology.server.entity.utility.EntityDebugTest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderDebugTest extends RenderLiving<EntityDebugTest> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Revival.MODID, "textures/model/debug/debugtest.png");
    private static final IModelCustom MODEL = AdvancedModelLoader.loadModel(new ResourceLocation(Revival.MODID, "models/debug/debugtest.obj"));

    public RenderDebugTest() {
        super(Minecraft.getMinecraft().getRenderManager(), new ModelChicken(), 0.9F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDebugTest entity) {
        return TEXTURE;
    }

    protected void renderModel(EntityDebugTest entitylivingbaseIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        if (!this.bindEntityTexture(entitylivingbaseIn)) {
            return;
        }
        float bob = (float) (Math.sin(Minecraft.getMinecraft().player.ticksExisted * 0.1F) * 1 * 0.05F - 1 * 0.05F);
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glTranslatef(0, -1F, 0);
        GL11.glTranslatef(0, bob, 0);
        GL11.glDisable(GL11.GL_LIGHTING);
        MODEL.renderAll();
        GL11.glEnable(GL11.GL_LIGHTING);

    }
}
