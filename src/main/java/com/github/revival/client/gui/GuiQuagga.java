package com.github.revival.client.gui;

import com.github.revival.server.entity.mob.EntityQuagga;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiQuagga extends GuiContainer {
	private static final ResourceLocation gui = new ResourceLocation("textures/gui/container/horse.png");
	private IInventory playerInventory;
	private IInventory entityInventory;
	private EntityQuagga entity;
	private float mouseX;
	private float mouseY;

	public GuiQuagga(IInventory playerInventory, IInventory entityInventory, EntityQuagga entity) {
		super(new ContainerQuagga(playerInventory, entityInventory, entity));
		this.playerInventory = playerInventory;
		this.entityInventory = entityInventory;
		this.entity = entity;
		this.allowUserInput = false;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of
	 * the items)
	 */
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRendererObj.drawString(this.entityInventory.hasCustomInventoryName() ? this.entityInventory.getInventoryName() : I18n.format(this.entityInventory.getInventoryName()), 8, 6, 4210752);
		this.fontRendererObj.drawString(this.playerInventory.hasCustomInventoryName() ? this.playerInventory.getInventoryName() : I18n.format(this.playerInventory.getInventoryName()), 8, this.ySize - 96 + 2, 4210752);
	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the
	 * items)
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(gui);
		int centerX = (this.width - this.xSize) / 2;
		int centerY = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(centerX, centerY, 0, 0, this.xSize, this.ySize);

		if (this.entity.isChested()) {
			this.drawTexturedModalRect(centerX + 79, centerY + 17, 0, this.ySize, 90, 54);
		}

		this.drawTexturedModalRect(centerX + 7, centerY + 35, 0, this.ySize + 54, 18, 18);

		GuiInventory.func_147046_a(centerX + 51, centerY + 60, 17, (float) (centerX + 51) - this.mouseX, (float) (centerY + 75 - 50) - this.mouseY, this.entity);
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.mouseX = (float) mouseX;
		this.mouseY = (float) mouseY;
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
