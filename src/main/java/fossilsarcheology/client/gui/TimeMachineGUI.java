package fossilsarcheology.client.gui;

import fossilsarcheology.server.block.entity.TileEntityTimeMachine;
import fossilsarcheology.server.container.TimeMachineContainer;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TimeMachineGUI extends GuiContainer {
    private static final ResourceLocation TEXTURE = new ResourceLocation("fossil:textures/gui/Timemachine.png");

    private TileEntityTimeMachine tile;

    public TimeMachineGUI(InventoryPlayer playerInventory, TileEntityTimeMachine tile) {
        super(new TimeMachineContainer(playerInventory, tile));
        this.tile = tile;
        this.ySize = 188;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        String chargeLevel = this.tile.getChargeLevel() / 10 + "%";
        int var3 = (34 - this.fontRendererObj.getStringWidth(chargeLevel)) / 2;
        this.fontRendererObj.drawString(I18n.format("tile.timeMachine.name"), 70 - I18n.format(LocalizationStrings.BLOCK_TIMEMACHINE_NAME).length(), 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
        // this.fontRendererObj.drawString(chargeLevel, 131 + var3, 40,
        // 16711680);
        if (this.tile.isCharged()) {
            String comingSoon = "Coming Soon...";
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.25F, 1.25F, 1.25F);
            this.fontRendererObj.drawString(comingSoon, this.xSize / 2 - comingSoon.length() * 4 + 37, this.ySize - 152 + 2, 0XBF0000, false);
            GlStateManager.popMatrix();
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(TEXTURE);
        int centerX = (this.width - this.xSize) / 2;
        int centerY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(centerX, centerY, 0, 0, this.xSize, this.ySize);
        this.tile.getClass();
        float invertedChargeLevel = (float) (1000 - this.tile.getChargeLevel());
        this.tile.getClass();
        int scaledChargeLevel = (int) ((invertedChargeLevel / 1000.0F) * 75.0F);
        this.drawTexturedModalRect(centerX + 5, centerY + 17, 176, 2, 75, scaledChargeLevel);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 1:
                if (this.tile.isCharged() && !this.tile.isRestoring) {
                    this.tile.startWork();
                }
            case 2:
                if (!this.tile.isRestoring) {
                    this.tile.startMemory();
                }
            default:
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        // ((GuiButton)this.controlList.get(0)).enabled =
        // this.timeMachineInstance.isCharged() &&
        // !this.timeMachineInstance.isRestoring;
        // ((GuiButton)this.controlList.get(1)).enabled =
        // !this.timeMachineInstance.isRestoring;
    }
}
