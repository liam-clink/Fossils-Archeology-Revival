package mods.fossil.client.gui.elements;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class FossilGuiButton extends GuiButton
{
    private int IconIndexHeight;
    private int IconIndexWidth;

    public FossilGuiButton(int par1, int par2, int par3, int par4)
    {
        super(par1, par2, par3, 32, 32, "");

        for (; par4 > 7;)
        {
            par4 -= 8;
            IconIndexHeight++;
        }

        IconIndexWidth = par4;
    }

    public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
    	/*
        if (this.drawButton)
        {
            boolean var4 = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            par1Minecraft.renderEngine.bindTexture(new ResourceLocation(""));
            int var6 = IconIndexHeight * 32;
            int var5 = IconIndexWidth * 32;

            if (var4)
            {
                var5 += 32;
            }

            this.drawTexturedModalRect(this.xPosition, this.yPosition, var5, var6, 32, 32);
        }
        */
    }
}