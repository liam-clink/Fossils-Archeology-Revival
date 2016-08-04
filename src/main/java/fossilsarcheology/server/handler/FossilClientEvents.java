package fossilsarcheology.server.handler;

import fossilsarcheology.server.block.FABlockRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class FossilClientEvents {
    @SubscribeEvent
    public void onBlockOverlay(RenderBlockOverlayEvent event) {
        if (event.getPlayer().worldObj.getBlockState(event.getBlockPos()).getBlock() == FABlockRegistry.INSTANCE.tar) {
            event.setCanceled(true);
            Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("fossil:textures/blocks/Tar.png"));
            Tessellator tessellator = Tessellator.getInstance();
            float f1 = 0.5F;
            GlStateManager.color(f1, f1, f1, 0.7F);
            GlStateManager.enableBlend();
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GlStateManager.pushMatrix();
            float f2 = 4.0F;
            float f3 = -1.0F;
            float f4 = 1.0F;
            float f5 = -1.0F;
            float f6 = 1.0F;
            float f7 = -0.5F;
            float f8 = -Minecraft.getMinecraft().thePlayer.rotationYaw / 64.0F;
            float f9 = Minecraft.getMinecraft().thePlayer.rotationPitch / 64.0F;
            VertexBuffer buffer = tessellator.getBuffer();
            buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
            buffer.pos(f3, f5, f7).tex(f2 + f8, f2 + f9).endVertex();
            buffer.pos(f4, f5, f7).tex(f8, f2 + f9).endVertex();
            buffer.pos(f4, f6, f7).tex(f8, f9).endVertex();
            buffer.pos(f3, f6, f7).tex(f2 + f8, f9).endVertex();
            tessellator.draw();
            GlStateManager.popMatrix();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_BLEND);
        }
    }
}
