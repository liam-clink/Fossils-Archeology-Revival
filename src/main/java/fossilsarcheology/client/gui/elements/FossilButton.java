package fossilsarcheology.client.gui.elements;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FossilButton extends GuiButton {
    public FossilButton(int id, int xPosition, int yPosition) {
        super(id, xPosition, yPosition, 32, 32, "");
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
    }
}