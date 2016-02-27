package com.github.revival.client.gui;

import com.github.revival.server.block.entity.TileEntityCultivate;
import com.github.revival.server.container.CultivateContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiCultivate extends GuiContainer {
    private static final ResourceLocation loc = new ResourceLocation("fossil:textures/gui/Cultivate.png");
    private TileEntityCultivate cultivateInventory;

    public GuiCultivate(InventoryPlayer playerInventory, TileEntity tile) {
        super(new CultivateContainer(playerInventory, tile));
        this.cultivateInventory = (TileEntityCultivate) tile;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String customName = this.cultivateInventory.isInvNameLocalized() ? this.cultivateInventory.getInvName() : I18n.format(this.cultivateInventory.getInvName());
        this.fontRendererObj.drawString(customName, this.xSize / 2 - this.fontRendererObj.getStringWidth(customName) / 2, 6, 4210752);

        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        //int var4 = this.mc.renderEngine.getTexture("/fossil/textures/UICultivate.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(loc);
        int drawX = (this.width - this.xSize) / 2;
        int drawY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(drawX, drawY, 0, 0, this.xSize, this.ySize);
        int scaledProgress;

        if (this.cultivateInventory.isBurning()) {
            scaledProgress = this.cultivateInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(drawX + 82, drawY + 36 + 12 - scaledProgress, 176, 12 - scaledProgress, 14, scaledProgress + 2);
        }

        scaledProgress = this.cultivateInventory.getCultivateProgressScaled(24);
        this.drawTexturedModalRect(drawX + 79, drawY + 18, 176, 14, scaledProgress + 1, 16);
    }
}
