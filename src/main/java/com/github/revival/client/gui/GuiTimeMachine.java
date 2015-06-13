package com.github.revival.client.gui;

import com.github.revival.common.container.ContainerTimeMachine;
import com.github.revival.common.handler.LocalizationStrings;
import com.github.revival.common.tileentity.TileEntityTimeMachine;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiTimeMachine extends GuiContainer
{
    private static final ResourceLocation loc = new ResourceLocation("fossil:textures/gui/Timemachine.png");
    final int SQR_WIDTH = 34;
    final int SQR_HEIGHT = 13;
    final int SQR_POSX = 131;
    private TileEntityTimeMachine timeMachineInstance;

    public GuiTimeMachine(InventoryPlayer var1, TileEntityTimeMachine var2)
    {
        super(new ContainerTimeMachine(var1, var2));
        this.timeMachineInstance = var2;
        this.ySize = 188;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        super.initGui();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        //int var1 = 16711680;
        String var2 = this.timeMachineInstance.getChargeLevel() / 10 + "%";
        int var3 = (34 - this.fontRendererObj.getStringWidth(var2)) / 2;
        this.fontRendererObj.drawString(StatCollector.translateToLocal("tile.timeMachine.name"), 70 - StatCollector.translateToLocal(LocalizationStrings.BLOCK_TIMEMACHINE_NAME).length(), 6, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
        // this.fontRendererObj.drawString(var2, 131 + var3, 40, 16711680);
        if (this.timeMachineInstance.isCharged())
        {
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
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        boolean var4 = true;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(loc);
        int var6 = (this.width - this.xSize) / 2;
        int var7 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var6, var7, 0, 0, this.xSize, this.ySize);
        this.timeMachineInstance.getClass();
        float var10000 = (float) (1000 - this.timeMachineInstance.getChargeLevel());
        this.timeMachineInstance.getClass();
        float var9 = var10000 / 1000.0F;//14
        int var8 = (int) (var9 * 75.0F);
        this.drawTexturedModalRect(var6 + 5, var7 + 17, 176, 2, 75, var8);
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton var1)
    {
        switch (var1.id)
        {
            case 1:
                if (this.timeMachineInstance.isCharged() && !this.timeMachineInstance.isRestoring)
                {
                    this.timeMachineInstance.startWork();
                }

            case 2:
                if (!this.timeMachineInstance.isRestoring)
                {
                    this.timeMachineInstance.startMemory();
                }

            default:
        }
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();
        //((GuiButton)this.controlList.get(0)).enabled = this.timeMachineInstance.isCharged() && !this.timeMachineInstance.isRestoring;
        //((GuiButton)this.controlList.get(1)).enabled = !this.timeMachineInstance.isRestoring;
    }
}
