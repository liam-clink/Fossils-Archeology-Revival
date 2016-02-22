package com.github.revival.server.handler;

import com.github.revival.server.item.FAItemRegistry;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
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
                    if (Minecraft.getMinecraft().thePlayer.getCurrentArmor(3).getItem() == FAItemRegistry.skullHelmet) {
                        GL11.glPushMatrix();
                        GL11.glDisable(GL11.GL_ALPHA_TEST);
                        GL11.glDepthMask(true);
                        this.mc.getTextureManager().bindTexture(texture2);
                        GL11.glPushMatrix();
                        tessellator.startDrawingQuads();
                        tessellator.addVertexWithUV(0.0D, (double) event.resolution.getScaledHeight(), -90.0D, 0.0D, 1.0D);
                        tessellator.addVertexWithUV((double) event.resolution.getScaledWidth(), (double) event.resolution.getScaledHeight(), -90.0D, 1.0D, 1.0D);
                        tessellator.addVertexWithUV((double) event.resolution.getScaledWidth(), 0.0D, -90.0D, 1.0D, 0.0D);
                        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
                        tessellator.draw();
                        GL11.glPopMatrix();
                        GL11.glEnable(GL11.GL_ALPHA_TEST);
                        GL11.glPopMatrix();
                    }
                }
            }
        }
        if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
            if (Minecraft.getMinecraft().thePlayer.getCurrentArmor(3) != null) {
                if (Minecraft.getMinecraft().thePlayer.getCurrentArmor(3).getItem() != null) {
                    if (Minecraft.getMinecraft().thePlayer.getCurrentArmor(3).getItem() == FAItemRegistry.ancienthelmet) {
                        GL11.glPushMatrix();
                        GL11.glDisable(GL11.GL_ALPHA_TEST);
                        GL11.glDepthMask(true);
                        this.mc.getTextureManager().bindTexture(texture);
                        GL11.glPushMatrix();
                        tessellator.startDrawingQuads();
                        tessellator.addVertexWithUV(0.0D, (double) event.resolution.getScaledHeight(), -90.0D, 0.0D, 1.0D);
                        tessellator.addVertexWithUV((double) event.resolution.getScaledWidth(), (double) event.resolution.getScaledHeight(), -90.0D, 1.0D, 1.0D);
                        tessellator.addVertexWithUV((double) event.resolution.getScaledWidth(), 0.0D, -90.0D, 1.0D, 0.0D);
                        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
                        tessellator.draw();
                        GL11.glPopMatrix();
                        GL11.glEnable(GL11.GL_ALPHA_TEST);
                        GL11.glPopMatrix();
                    }
                }
            }
        }


    }

}
