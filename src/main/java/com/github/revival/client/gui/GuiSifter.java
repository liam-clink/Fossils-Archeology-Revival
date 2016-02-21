package com.github.revival.client.gui;

import com.github.revival.Revival;
import com.github.revival.common.container.ContainerSifter;
import com.github.revival.common.tileentity.TileEntitySifter;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiSifter extends GuiContainer {
    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation(Revival.MODID + ":" + "textures/gui/Sifter.png");
    private TileEntitySifter sifterInventory;

    public GuiSifter(InventoryPlayer playerInventory, TileEntitySifter sifterInventory) {
        super(new ContainerSifter(playerInventory, sifterInventory));
        this.sifterInventory = sifterInventory;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String inventoryName = this.sifterInventory.hasCustomInventoryName() ? this.sifterInventory.getInventoryName() : I18n.format(this.sifterInventory.getInventoryName());
        this.fontRendererObj.drawString(inventoryName, this.xSize / 8 - this.fontRendererObj.getStringWidth(inventoryName) / 2, 6, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
        int centerX = (this.width - this.xSize) / 2;
        int centerY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(centerX, centerY, 0, 0, this.xSize, this.ySize);
        int siftTimeRemaining;

        if (this.sifterInventory.isBurning()) {
            siftTimeRemaining = this.sifterInventory.getSiftTimeRemainingScaled(12);
            //this.drawTexturedModalRect(centerX + 70, centerY + 44 - siftTimeRemaining, 176, 12 - siftTimeRemaining, 14, siftTimeRemaining + 2);
            //this.drawTexturedModalRect(centerX + 75, centerY + 33, 181, 2, 31, 31);
        }

        siftTimeRemaining = this.sifterInventory.getSiftProgressScaled(26);
        //this.drawTexturedModalRect(centerX + 79, centerY + 34, 176, 14, siftTimeRemaining + 1, 16);
        this.drawTexturedModalRect(centerX + 75, centerY + 33, 181, 2, 31, siftTimeRemaining + 1);

    }
}
