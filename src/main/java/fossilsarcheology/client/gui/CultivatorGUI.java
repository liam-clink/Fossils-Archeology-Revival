package fossilsarcheology.client.gui;

import fossilsarcheology.server.block.entity.TileEntityCultivate;
import fossilsarcheology.server.container.CultivateContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CultivatorGUI extends GuiContainer {
    private static final ResourceLocation TEXTURE = new ResourceLocation("fossil:textures/gui/Cultivate.png");

    private TileEntityCultivate tile;

    public CultivatorGUI(InventoryPlayer playerInventory, TileEntity tile) {
        super(new CultivateContainer(playerInventory, tile));
        this.tile = (TileEntityCultivate) tile;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String customName = this.tile.isInvNameLocalized() ? this.tile.getInvName() : I18n.format(this.tile.getInvName());
        this.fontRendererObj.drawString(customName, this.xSize / 2 - this.fontRendererObj.getStringWidth(customName) / 2, 6, 4210752);

        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(TEXTURE);
        int drawX = (this.width - this.xSize) / 2;
        int drawY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(drawX, drawY, 0, 0, this.xSize, this.ySize);
        int scaledProgress;
        if (this.tile.isBurning()) {
            scaledProgress = this.tile.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(drawX + 82, drawY + 36 + 12 - scaledProgress, 176, 12 - scaledProgress, 14, scaledProgress + 2);
        }
        scaledProgress = this.tile.getCultivateProgressScaled(24);
        this.drawTexturedModalRect(drawX + 79, drawY + 18, 176, 14, scaledProgress + 1, 16);
    }
}
