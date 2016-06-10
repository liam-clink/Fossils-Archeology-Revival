package com.github.revival.server.handler;

import com.github.revival.server.block.FABlockRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import org.lwjgl.opengl.GL11;

public class FossilClientEvents {
	@SubscribeEvent
	public void onBlockOverlay(RenderBlockOverlayEvent e) {
		if (e.player.worldObj.getBlock(e.blockX, e.blockY, e.blockZ) == FABlockRegistry.INSTANCE.tar) {
			e.setCanceled(true);
			Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("fossil:textures/blocks/Tar.png"));
			Tessellator tessellator = Tessellator.instance;
			float f1 = 0.5F;
			GL11.glColor4f(f1, f1, f1, 0.7F);
			GL11.glEnable(GL11.GL_BLEND);
			OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			GL11.glPushMatrix();
			float f2 = 4.0F;
			float f3 = -1.0F;
			float f4 = 1.0F;
			float f5 = -1.0F;
			float f6 = 1.0F;
			float f7 = -0.5F;
			float f8 = -Minecraft.getMinecraft().thePlayer.rotationYaw / 64.0F;
			float f9 = Minecraft.getMinecraft().thePlayer.rotationPitch / 64.0F;
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV((double) f3, (double) f5, (double) f7, (double) (f2 + f8), (double) (f2 + f9));
			tessellator.addVertexWithUV((double) f4, (double) f5, (double) f7, (double) (0.0F + f8), (double) (f2 + f9));
			tessellator.addVertexWithUV((double) f4, (double) f6, (double) f7, (double) (0.0F + f8), (double) (0.0F + f9));
			tessellator.addVertexWithUV((double) f3, (double) f6, (double) f7, (double) (f2 + f8), (double) (0.0F + f9));
			tessellator.draw();
			GL11.glPopMatrix();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_BLEND);
		}
	}
}
