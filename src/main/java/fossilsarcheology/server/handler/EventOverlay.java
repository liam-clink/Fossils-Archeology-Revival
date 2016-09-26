package fossilsarcheology.server.handler;

import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class EventOverlay {
    private static final ResourceLocation ANCIENT_HELMET = new ResourceLocation("fossil:textures/gui/ancienthelmetblur.png");
    private static final ResourceLocation SKULL_HELMET = new ResourceLocation("fossil:textures/gui/skullhelmetblur.png");

    private Minecraft mc;

    public EventOverlay(Minecraft mc) {
        super();
        this.mc = mc;
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onRenderOverlay(RenderGameOverlayEvent event) {
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer buffer = tessellator.getBuffer();
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        if (event.isCanceled()) {
            return;
        }
        ScaledResolution resolution = event.getResolution();
        ItemStack helmet = this.mc.thePlayer.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
        if (helmet != null) {
            if (this.mc.gameSettings.thirdPersonView == 0) {
                if (helmet.getItem() == FAItemRegistry.INSTANCE.skullHelmet) {
                    this.mc.getTextureManager().bindTexture(SKULL_HELMET);
                    this.drawOverlay(tessellator, buffer, resolution);
                } else if (helmet.getItem() == FAItemRegistry.INSTANCE.ancienthelmet) {
                    this.mc.getTextureManager().bindTexture(ANCIENT_HELMET);
                    this.drawOverlay(tessellator, buffer, resolution);
                }
            }
        }
    }

    private void drawOverlay(Tessellator tessellator, VertexBuffer buffer, ScaledResolution resolution) {
        GlStateManager.pushMatrix();
        GlStateManager.disableAlpha();
        GlStateManager.depthMask(true);
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        buffer.pos(0.0, resolution.getScaledHeight(), -90.0).tex(0.0, 1.0).endVertex();
        buffer.pos(resolution.getScaledWidth(), resolution.getScaledHeight(), -90.0).tex(1.0, 1.0).endVertex();
        buffer.pos(resolution.getScaledWidth(), 0.0, -90.0).tex(1.0, 0.0).endVertex();
        buffer.pos(0.0, 0.0, -90.0).tex(0.0, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableAlpha();
        GlStateManager.popMatrix();
    }
}
