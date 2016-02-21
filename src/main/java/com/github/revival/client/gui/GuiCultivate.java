package com.github.revival.client.gui;

import com.github.revival.common.container.ContainerCultivate;
import com.github.revival.common.tileentity.TileEntityCultivate;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiCultivate extends GuiContainer {
    private static final ResourceLocation loc = new ResourceLocation("fossil:textures/gui/Cultivate.png");
    private TileEntityCultivate cultivateInventory;

    public GuiCultivate(InventoryPlayer var1, TileEntity var2) {
        super(new ContainerCultivate(var1, var2));
        this.cultivateInventory = (TileEntityCultivate) var2;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String customName = this.cultivateInventory.isInvNameLocalized() ? this.cultivateInventory.getInvName() : I18n.format(this.cultivateInventory.getInvName());
        this.fontRendererObj.drawString(customName, this.xSize / 2 - this.fontRendererObj.getStringWidth(customName) / 2, 6, 4210752);

        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        //int var4 = this.mc.renderEngine.getTexture("/fossil/textures/UICultivate.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(loc);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7;

        if (this.cultivateInventory.isBurning()) {
            var7 = this.cultivateInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(var5 + 82, var6 + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
        }

        var7 = this.cultivateInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(var5 + 79, var6 + 18, 176, 14, var7 + 1, 16);
    }
}
