package fossilsarcheology.client.gui;

import fossilsarcheology.server.block.entity.TileEntityFeeder;
import fossilsarcheology.server.container.FeederContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class FeederGUI extends GuiContainer {
    private static final ResourceLocation TEXTURE = new ResourceLocation("fossil:textures/gui/Feeder.png");

    private TileEntityFeeder tile;

    public FeederGUI(InventoryPlayer playerInventory, TileEntity tile) {
        super(new FeederContainer(playerInventory, tile));
        this.tile = (TileEntityFeeder) tile;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String customName = this.tile.hasCustomInventoryName() ? this.tile.getInventoryName() : I18n.format(this.tile.getInventoryName());
        this.fontRendererObj.drawString(customName, this.xSize / 6 - this.fontRendererObj.getStringWidth(customName) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        int left = this.guiLeft;
        int top = this.guiTop;
        this.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        super.drawScreen(mouseX, mouseY, partialTicks);
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) left, (float) top, 0.0F);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        short lightX = 240;
        short lightY = 240;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) lightX / 1.0F, (float) lightY / 1.0F);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        InventoryPlayer playerInventory = this.mc.thePlayer.inventory;
        if (playerInventory.getItemStack() != null) {
            GlStateManager.translate(0.0F, 0.0F, 32.0F);
            this.zLevel = 200.0F;
            itemRender.zLevel = 200.0F;
            itemRender.renderItemAndEffectIntoGUI(playerInventory.getItemStack(), mouseX - left - 8, mouseY - top - 8);
            itemRender.renderItemOverlayIntoGUI(this.fontRendererObj, playerInventory.getItemStack(), mouseX - left - 8, mouseY - top - 8, "");
            this.zLevel = 0.0F;
            itemRender.zLevel = 0.0F;
        }
        this.fontRendererObj.drawString(String.valueOf(this.tile.getCurrentMeat()), 23, 32, 0xFF0000);
        this.fontRendererObj.drawString(String.valueOf(this.tile.getCurrentPlant()), 120, 32, 0x3B703);
        GlStateManager.popMatrix();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderHelper.enableStandardItemLighting();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(TEXTURE);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        int meat = this.tile.getMeatBarScaled(46);
        this.drawTexturedModalRect(x + 66, y + 55 - meat, 176, 46 - meat, 3, meat);
        int vegetation = this.tile.getVegBarScaled(46);
        this.drawTexturedModalRect(x + 110, y + 55 - vegetation, 176, 46 - vegetation, 3, vegetation);
    }
}
