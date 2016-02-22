package com.github.revival.client.gui;

import com.github.revival.common.container.ContainerAnalyzer;
import com.github.revival.common.tileentity.TileEntityAnalyzer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiAnalyzer extends GuiContainer {
    private static final ResourceLocation loc = new ResourceLocation("fossil:textures/gui/Analyser.png");
    private TileEntityAnalyzer analyzerInventory;

    public GuiAnalyzer(InventoryPlayer playerInventory, TileEntity tile) {
        super(new ContainerAnalyzer(playerInventory, tile));
        this.analyzerInventory = (TileEntityAnalyzer) tile;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String customName = this.analyzerInventory.hasCustomInventoryName() ? this.analyzerInventory.getInventoryName() : I18n.format(this.analyzerInventory.getInventoryName());
        this.fontRendererObj.drawString(customName, this.xSize / 2 - this.fontRendererObj.getStringWidth(customName) / 2, 6, 4210752);

        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        //int var4 = this.mc.renderEngine.getTexture("/fossil/textures/UIAnalyzer.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(loc);
        int drawX = (this.width - this.xSize) / 2;
        int drawY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(drawX, drawY, 0, 0, this.xSize, this.ySize);
        int progress = this.analyzerInventory.getAnalyzeProgressScaled(21);
        this.drawTexturedModalRect(drawX + 80, drawY + 22, 177, 18, progress + 1, 9);
    }
}
