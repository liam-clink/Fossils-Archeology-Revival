package mods.fossil.client.gui.elements;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class FossilGuiButton extends GuiButton
{
    private int IconIndexHeight;
    private int IconIndexWidth;

    public FossilGuiButton(int id, int xPosition, int yPosition, int par4)
    {
        super(id, xPosition, yPosition, 32, 32, "");

        for (; par4 > 7;)
        {
            par4 -= 8;
            IconIndexHeight++;
        }

        IconIndexWidth = par4;
    }
}