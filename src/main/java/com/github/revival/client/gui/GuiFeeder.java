package com.github.revival.client.gui;

import com.github.revival.server.block.entity.TileEntityNewFeeder;
import com.github.revival.server.container.FeederContainer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class GuiFeeder extends GuiContainer {
    private static final ResourceLocation loc = new ResourceLocation("fossil:textures/gui/Feeder.png");
    private TileEntityNewFeeder FeederInventory;

    public GuiFeeder(InventoryPlayer var1, TileEntity var2) {
        super(new FeederContainer(var1, var2));
        this.FeederInventory = (TileEntityNewFeeder) var2;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String customName = this.FeederInventory.hasCustomInventoryName() ? this.FeederInventory.getInventoryName() : I18n.format(this.FeederInventory.getInventoryName());
        this.fontRendererObj.drawString(customName, this.xSize / 6 - this.fontRendererObj.getStringWidth(customName) / 2, 6, 4210752);

        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draws the screen and all the components in it.
     */
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
        GL11.glPushMatrix();
        GL11.glTranslatef((float) left, (float) top, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        short lightX = 240;
        short lightY = 240;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) lightX / 1.0F, (float) lightY / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        InventoryPlayer playerInventory = this.mc.thePlayer.inventory;

        if (playerInventory.getItemStack() != null) {
            GL11.glTranslatef(0.0F, 0.0F, 32.0F);
            this.zLevel = 200.0F;
            itemRender.zLevel = 200.0F;
            itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.renderEngine, playerInventory.getItemStack(), mouseX - left - 8, mouseY - top - 8);
            itemRender.renderItemOverlayIntoGUI(this.fontRendererObj, this.mc.renderEngine, playerInventory.getItemStack(), mouseX - left - 8, mouseY - top - 8);
            this.zLevel = 0.0F;
            itemRender.zLevel = 0.0F;
        }

        this.fontRendererObj.drawString("" + this.FeederInventory.getCurrentMeat(), 23, 32, 16711680);
        this.fontRendererObj.drawString("" + this.FeederInventory.getCurrentPlant(), 120, 32, 243459);
        GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderHelper.enableStandardItemLighting();
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        //int var4 = this.mc.renderEngine.getTexture("/fossil/textures/UIFeeder.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(loc);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7 = this.FeederInventory.getMeatBarScaled(46);
        this.drawTexturedModalRect(var5 + 66, var6 + 55 - var7, 176, 46 - var7, 3, var7);
        int var8 = this.FeederInventory.getVegBarScaled(46);
        this.drawTexturedModalRect(var5 + 110, var6 + 55 - var8, 176, 46 - var8, 3, var8);
    }
}
