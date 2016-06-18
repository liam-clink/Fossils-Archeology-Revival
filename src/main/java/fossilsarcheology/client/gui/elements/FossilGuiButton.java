package fossilsarcheology.client.gui.elements;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class FossilGuiButton extends GuiButton {
    private int iconIndexHeight;
    private int iconIndexWidth;

    public FossilGuiButton(int id, int xPosition, int yPosition, int width) {
        super(id, xPosition, yPosition, 32, 32, "");

        for (; width > 7; ) {
            width -= 8;
            iconIndexHeight++;
        }

        iconIndexWidth = width;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
    }
}