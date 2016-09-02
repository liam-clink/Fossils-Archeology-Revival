package fossilsarcheology.client.gui.elements;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FossilPageButton extends GuiButton {
    private final boolean nextPage;
    private int page;
    private int lastpage = 1;

    public FossilPageButton(int id, int xPos, int yPos, boolean nextPage, int bookpage) {
        super(id, xPos, yPos, 34, 24, "");
        this.nextPage = nextPage;
        page = bookpage;
    }

    @Override
    public void drawButton(Minecraft minecraft, int mouseX, int mouseY) {
        if (this.enabled) {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            minecraft.renderEngine.bindTexture(new ResourceLocation("fossil:textures/gui/Dinopedia.png"));
            int width = 0;
            int height = 223;

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