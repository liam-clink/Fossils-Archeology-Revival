package fossilsarcheology.client.gui;

import fossilsarcheology.Revival;
import fossilsarcheology.server.block.entity.TileEntitySifter;
import fossilsarcheology.server.container.SifterContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SifterGUI extends GuiContainer {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Revival.MODID + ":" + "textures/gui/Sifter.png");

    private TileEntitySifter tile;

    public SifterGUI(InventoryPlayer playerInventory, TileEntitySifter tile) {
        super(new SifterContainer(playerInventory, tile));
        this.tile = tile;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String inventoryName = this.tile.hasCustomInventoryName() ? this.tile.getInventoryName() : I18n.format(this.tile.getInventoryName());
        this.fontRendererObj.drawString(inventoryName, this.xSize / 8 - this.fontRendererObj.getStringWidth(inventoryName) / 2, 6, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        int centerX = (this.width - this.xSize) / 2;
        int centerY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(centerX, centerY, 0, 0, this.xSize, this.ySize);
        int siftTimeRemaining;

        if (this.tile.isSifting()) {
            siftTimeRemaining = this.tile.getSiftTimeRemainingScaled(12);
            // this.drawTexturedRect(centerX + 70, centerY + 44 -
            // siftTimeRemaining, 176, 12 - siftTimeRemaining, 14,
            // siftTimeRemaining + 2);
            // this.drawTexturedRect(centerX + 75, centerY + 33, 181, 2,
            // 31, 31);
        }

        siftTimeRemaining = this.tile.getSiftProgressScaled(26);
        // this.drawTexturedRect(centerX + 79, centerY + 34, 176, 14,
        // siftTimeRemaining + 1, 16);
        this.drawTexturedModalRect(centerX + 75, centerY + 33, 181, 2, 31, siftTimeRemaining + 1);

    }
}
