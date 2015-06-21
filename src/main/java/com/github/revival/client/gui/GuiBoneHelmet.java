package com.github.revival.client.gui;

import com.github.revival.common.config.FossilConfig;
import com.github.revival.common.item.FAItemRegistry;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import org.lwjgl.opengl.GL11;

//
// GuiBuffBar implements a simple status bar at the top of the screen which
// shows the current buffs/debuffs applied to the character.
//
public class GuiBoneHelmet extends Gui
{
    private Minecraft mc;

    public GuiBoneHelmet(Minecraft mc)
    {
        super();
        // We need this to invoke the render engine.
        this.mc = mc;
    }

    //
    // This event is called by GuiIngameForge during each frame by
    // GuiIngameForge.pre() and GuiIngameForce.post().
    //
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRenderExperienceBar(RenderGameOverlayEvent event)
    {
        //
        // We draw after the ExperienceBar has drawn.  The event raised by GuiIngameForge.pre()
        // will return true from isCancelable.  If you call event.setCanceled(true) in
        // that case, the portion of rendering which this event represents will be canceled.
        // We want to draw *after* the experience bar is drawn, so we make sure isCancelable() returns
        // false and that the eventType represents the ExperienceBar event.
        if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
        {
            return;
        }

        if (!FossilConfig.skullOverlay)
        {
            return;
        }

        ItemStack helmet = Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(3);

        if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && helmet != null && helmet.getItem() == FAItemRegistry.skullHelmet)
        {
            // Starting position for the buff bar - 2 pixels from the top left corner.
            int xPos = 0;
            int yPos = 0;
            ScaledResolution scale = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
            int width = scale.getScaledWidth();
            int height = scale.getScaledHeight();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glDepthMask(false);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.3F);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            this.mc.getTextureManager().bindTexture(new ResourceLocation("fossil:textures/gui/skullhelmetblur.png"));
            myDrawTexturedModalRect(0, 0, width, height);
            GL11.glDepthMask(true);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_BLEND);
        }
    }

    public void myDrawTexturedModalRect(int x, int y, int width, int height)
    {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x, y + height, 0, 0.0, 1.0);
        tessellator.addVertexWithUV(x + width, y + height, 0, 1.0, 1.0);
        tessellator.addVertexWithUV(x + width, y, 0, 1.0, 0.0);
        tessellator.addVertexWithUV(x, y, 0, 0.0, 0.0);
        tessellator.draw();
    }
}