package fossilsarcheology.server.handler;

import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class EventOverlay {
    private static final ResourceLocation texture = new ResourceLocation("fossil:textures/gui/ancienthelmetblur.png");
    private static final ResourceLocation texture2 = new ResourceLocation("fossil:textures/gui/skullhelmetblur.png");

    private Minecraft mc;

    public EventOverlay(Minecraft mc) {
        super();

        this.mc = mc;
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onRenderOverlay(RenderGameOverlayEvent event) {
        Tessellator tessellator = Tessellator.instance;

        if (event.type != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }

        if (event.isCancelable()) {

            return;
        }
        if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
            if (Minecraft.getMinecraft().thePlayer.getCurrentArmor(3) != null) {
                if (Minecraft.getMinecraft().thePlayer.getCurrentArmor(3).getItem() != null) {
                    if (Minecraft.getMinecraft().thePlayer.getCurrentArmor(3).getItem() == FAItemRegistry.INSTANCE.skullHelmet) {
                        GlStateManager.pushMatrix();
                        GL11.glDisable(GL11.GL_ALPHA_TEST);
                        GL11.glDepthMask(true);
                        this.mc.getTextureManager().bindTexture(texture2);
                        GlStateManager.pushMatrix();
                        tessellator.startDrawingQuads();
                        tessellator.addVertexWithUV(0.0D, (double) event.resolution.getScaledHeight(), -90.0D, 0.0D, 1.0D);
                        tessellator.addVertexWithUV((double) event.resolution.getScaledWidth(), (double) event.resolution.getScaledHeight(), -90.0D, 1.0D, 1.0D);
                        tessellator.addVertexWithUV((double) event.resolution.getScaledWidth(), 0.0D, -90.0D, 1.0D, 0.0D);
                        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
                        tessellator.draw();
                        GlStateManager.popMatrix();
                        GL11.glEnable(GL11.GL_ALPHA_TEST);
                        GlStateManager.popMatrix();
                    }
                }
            }
        }
        if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
            if (Minecraft.getMinecraft().thePlayer.getCurrentArmor(3) != null) {
                if (Minecraft.getMinecraft().thePlayer.getCurrentArmor(3).getItem() != null) {
                    if (Minecraft.getMinecraft().thePlayer.getCurrentArmor(3).getItem() == FAItemRegistry.INSTANCE.ancienthelmet) {
                        GlStateManager.pushMatrix();
                        GL11.glDisable(GL11.GL_ALPHA_TEST);
                        GL11.glDepthMask(true);
                        this.mc.getTextureManager().bindTexture(texture);
                        GlStateManager.pushMatrix();
                        tessellator.startDrawingQuads();
                        tessellator.addVertexWithUV(0.0D, (double) event.resolution.getScaledHeight(), -90.0D, 0.0D, 1.0D);
                        tessellator.addVertexWithUV((double) event.resolution.getScaledWidth(), (double) event.resolution.getScaledHeight(), -90.0D, 1.0D, 1.0D);
                        tessellator.addVertexWithUV((double) event.resolution.getScaledWidth(), 0.0D, -90.0D, 1.0D, 0.0D);
                        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
                        tessellator.draw();
                        GlStateManager.popMatrix();
                        GL11.glEnable(GL11.GL_ALPHA_TEST);
                        GlStateManager.popMatrix();
                    }
                }
            }
        }

    }

}
