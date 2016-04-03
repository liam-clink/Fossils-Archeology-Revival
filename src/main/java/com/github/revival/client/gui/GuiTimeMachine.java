package com.github.revival.client.gui;

import com.github.revival.server.block.entity.TileEntityTimeMachine;
import com.github.revival.server.container.TimeMachineContainer;
import com.github.revival.server.handler.LocalizationStrings;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiTimeMachine extends GuiContainer {
    private static final ResourceLocation loc = new ResourceLocation("fossil:textures/gui/Timemachine.png");
    final int SQR_WIDTH = 34;
    final int SQR_HEIGHT = 13;
    final int SQR_POSX = 131;
    private TileEntityTimeMachine timeMachineInstance;

    public GuiTimeMachine(InventoryPlayer playerInventory, TileEntityTimeMachine tile) {
        super(new TimeMachineContainer(playerInventory, tile));
        this.timeMachineInstance = tile;
        this.ySize = 188;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        //int var1 = 16711680;
        String chargeLevel = this.timeMachineInstance.getChargeLevel() / 10 + "%";
        int var3 = (34 - this.fontRendererObj.getStringWidth(chargeLevel)) / 2;
        this.fontRendererObj.drawString(StatCollector.translateToLocal("tile.timeMachine.name"), 70 - StatCollector.translateToLocal(LocalizationStrings.BLOCK_TIMEMACHINE_NAME).length(), 6, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
        // this.fontRendererObj.drawString(chargeLevel, 131 + var3, 40, 16711680);
        if (this.timeMachineInstance.isCharged()) {
            String comingSoon = "Coming Soon...";
            GL11.glPushMatrix();
            GL11.glScalef(1.25F, 1.25F, 1.25F);
            this.fontRendererObj.drawString(comingSoon, this.xSize / 2 - comingSoon.length() * 4 + 37, this.ySize - 152 + 2, 0XBF0000, false);
            GL11.glPopMatrix();
        }
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(loc);
        int centerX = (this.width - this.xSize) / 2;
        int centerY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(centerX, centerY, 0, 0, this.xSize, this.ySize);
        this.timeMachineInstance.getClass();
        float invertedChargeLevel = (float) (1000 - this.timeMachineInstance.getChargeLevel());
        this.timeMachineInstance.getClass();
        int scaledChargeLevel = (int) ((invertedChargeLevel / 1000.0F) * 75.0F);
        this.drawTexturedModalRect(centerX + 5, centerY + 17, 176, 2, 75, scaledChargeLevel);
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    @Override
    protected void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 1:
                if (this.timeMachineInstance.isCharged() && !this.timeMachineInstance.isRestoring) {
                    this.timeMachineInstance.startWork();
                }
            case 2:
                if (!this.timeMachineInstance.isRestoring) {
                    this.timeMachineInstance.startMemory();
                }
            default:
        }
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() {
        super.updateScreen();
        //((GuiButton)this.controlList.get(0)).enabled = this.timeMachineInstance.isCharged() && !this.timeMachineInstance.isRestoring;
        //((GuiButton)this.controlList.get(1)).enabled = !this.timeMachineInstance.isRestoring;
    }
}
