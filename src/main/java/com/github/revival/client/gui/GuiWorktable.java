package com.github.revival.client.gui;

import com.github.revival.server.block.entity.TileEntityWorktable;
import com.github.revival.server.container.WorktableContainer;
import com.github.revival.server.handler.LocalizationStrings;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiWorktable extends GuiContainer {
    private static final ResourceLocation loc = new ResourceLocation("fossil:textures/gui/Workbench.png");
    private TileEntityWorktable tile;

    public GuiWorktable(InventoryPlayer playerInventory, TileEntity tile) {
        super(new WorktableContainer(playerInventory, tile));
        this.tile = (TileEntityWorktable) tile;
    }

    protected void drawGuiContainerForegroundLayer() {
        this.fontRendererObj.drawString(LocalizationStrings.BLOCK_WORKTABLE_IDLE_NAME, 30, 6, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(loc);
        int centerX = (this.width - this.xSize) / 2;
        int centerY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(centerX, centerY, 0, 0, this.xSize, this.ySize);
        int progress;

        if (this.tile.isBurning()) {
            progress = this.tile.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(centerX + 82, centerY + 36 + 12 - progress, 176, 12 - progress, 14, progress + 2);
        }

        progress = this.tile.getCookProgressScaled(24);
        this.drawTexturedModalRect(centerX + 79, centerY + 18, 176, 14, progress + 1, 16);
    }
}
