package com.github.revival.client.gui.elements;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class FossilGuiPage extends GuiButton {
    private final boolean nextPage;
    private int page;
    private int lastpage = 1;

    public FossilGuiPage(int id, int xPos, int yPos, boolean nextPage, int bookpage) {
        super(id, xPos, yPos, 34, 24, "");
        this.nextPage = nextPage;
        page = bookpage;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if (this.enabled) {
            boolean hovering = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            mc.renderEngine.bindTexture(new ResourceLocation("fossil:textures/gui/Dinopedia.png"));
            int width = 0;
            int height = 223;

            //  if ((hovering) || (this.nextPage && page == lastpage) || (!this.nextPage && page == 0))
            if ((this.nextPage && page == lastpage) || (!this.nextPage && page == 0)) {
                height -= 23;
            }

            if (!this.nextPage) {
                width += 34;
            }

            this.drawTexturedModalRect(this.xPosition, this.yPosition, width, height, 34, 30);
        }
    }
}