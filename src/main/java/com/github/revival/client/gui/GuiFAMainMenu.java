package com.github.revival.client.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.apache.commons.io.Charsets;
import org.lwjgl.opengl.GL11;

import com.github.revival.Revival;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiFAMainMenu extends GuiMainMenu {
    public static final int LAYER_COUNT = 2;
    public static final ResourceLocation splash = new ResourceLocation("fossil:splashes.txt");
    private ResourceLocation[] layerTextures = new ResourceLocation[GuiFAMainMenu.LAYER_COUNT];
    private int layerTick;
    private int backAdd;
    private int frontAdd;
    
    public GuiFAMainMenu(){
    	super();
    	backAdd = new Random().nextInt(1027);
    	frontAdd = new Random().nextInt(2047);

        BufferedReader bufferedreader = null;
    	 try
         {
             ArrayList arraylist = new ArrayList();
             bufferedreader = new BufferedReader(new InputStreamReader(Minecraft.getMinecraft().getResourceManager().getResource(splash).getInputStream(), Charsets.UTF_8));
             String s;

             while ((s = bufferedreader.readLine()) != null)
             {
                 s = s.trim();

                 if (!s.isEmpty())
                 {
                     arraylist.add(s);
                 }
             }

             if (!arraylist.isEmpty())
             {
                 do
                 {
                     this.splashText = (String)arraylist.get(rand.nextInt(arraylist.size()));
                 }
                 while (this.splashText.hashCode() == 125780783);
             }
         }
         catch (IOException ioexception1)
         {
             ;
         }
         finally
         {
             if (bufferedreader != null)
             {
                 try
                 {
                     bufferedreader.close();
                 }
                 catch (IOException ioexception)
                 {
                     ;
                 }
             }
         }

    }
    
    @Override
    public void drawCenteredString(FontRenderer fontrender, String sting, int x, int y, int color)
    {
    	if(sting.equals(splashText)){
            fontrender.drawStringWithShadow(sting, x - fontrender.getStringWidth(sting) / 2, y, 0XF1E961);
    	}else{
            fontrender.drawStringWithShadow(sting, x - fontrender.getStringWidth(sting) / 2, y, color);
    	}
    }

    @Override
    public void initGui() {
        super.initGui();

        for (int i = 0; i < this.layerTextures.length; i++) {
            this.layerTextures[i] = new ResourceLocation(Revival.MODID, "textures/gui/parallax/layer" + i + ".png");
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();

        this.layerTick++;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL11.GL_BLEND);
        for (int i = 0; i < this.layerTextures.length; i++) {
            ResourceLocation layerTexture = this.layerTextures[i];
            this.mc.getTextureManager().bindTexture(layerTexture);
            drawTexturedModalRect(0, 0, (i == 1 ? backAdd : frontAdd) + (layerTick / (float) (this.layerTextures.length - i)) + partialTicks / (float) (i + 1) + 2048 * i / 4.0F, 0, this.width, this.height, 2048 / (this.layerTextures.length - i) * (this.height / 128.0F), this.height, this.zLevel);
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void drawTexturedModalRect(double x, double y, double u, double v, double width, double height, double textureWidth, double textureHeight, double zLevel) {
        double f = 1.0F / textureWidth;
        double f1 = 1.0F / textureHeight;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x + 0, y + height, zLevel, (u) * f, (v + height) * f1);
        tessellator.addVertexWithUV(x + width, y + height, zLevel, (u + width) * f, (v + height) * f1);
        tessellator.addVertexWithUV(x + width, y + 0, zLevel, (u + width) * f, v * f1);
        tessellator.addVertexWithUV(x + 0, y + 0, zLevel, u * f, v * f1);
        tessellator.draw();
    }

    @Override
    public void renderSkybox(int mouseX, int mouseY, float partialTicks) {

    }
}
