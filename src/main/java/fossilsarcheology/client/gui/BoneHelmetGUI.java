package fossilsarcheology.client.gui;

import fossilsarcheology.Revival;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class BoneHelmetGUI extends Gui {
    private static final Minecraft MC = Minecraft.getMinecraft();

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRenderExperienceBar(RenderGameOverlayEvent event) {
        if (event.isCancelable() || event.getType() != ElementType.EXPERIENCE) {
            return;
        }
        if (!Revival.CONFIG.skullOverlay) {
            return;
        }
        ItemStack helmet = Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(3);
        if (MC.gameSettings.thirdPersonView == 0 && helmet != null && helmet.getItem() == FAItemRegistry.INSTANCE.skullHelmet) {
            ScaledResolution scale = new ScaledResolution(Minecraft.getMinecraft());
            int width = scale.getScaledWidth();
            int height = scale.getScaledHeight();
            GlStateManager.enableBlend();
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glDepthMask(false);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 0.3F);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            MC.getTextureManager().bindTexture(new ResourceLocation("fossil:textures/gui/skullhelmetblur.png"));
            this.drawFullTexturedRect(0, 0, width, height);
            GL11.glDepthMask(true);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_BLEND);
        }
    }

    public void drawFullTexturedRect(int x, int y, int width, int height) {
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer buffer = tessellator.getBuffer();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        buffer.pos(x, y + height, 0).tex(0.0, 1.0).endVertex();
        buffer.pos(x + width, y + height, 0).tex(1.0, 1.0).endVertex();
        buffer.pos(x + width, y, 0).tex(1.0, 0.0).endVertex();
        buffer.pos(x, y, 0).tex(0.0, 0.0).endVertex();
        tessellator.draw();
    }
}