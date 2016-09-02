package fossilsarcheology.client.gui;

import fossilsarcheology.server.entity.mob.EntityQuagga;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class QuaggaInventoryGUI extends GuiContainer {
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/horse.png");

    private IInventory playerInventory;
    private IInventory entityInventory;
    private EntityQuagga entity;
    private float mouseX;
    private float mouseY;

    public QuaggaInventoryGUI(IInventory playerInventory, IInventory entityInventory, EntityQuagga entity, EntityPlayer player) {
        super(new QuaggaContainer(playerInventory, entityInventory, entity, player));
        this.playerInventory = playerInventory;
        this.entityInventory = entityInventory;
        this.entity = entity;
        this.allowUserInput = false;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRendererObj.drawString(this.entityInventory.hasCustomName() ? this.entityInventory.getName() : I18n.format(this.entityInventory.getName()), 8, 6, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.hasCustomName() ? this.playerInventory.getName() : I18n.format(this.playerInventory.getName()), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        int centerX = (this.width - this.xSize) / 2;
        int centerY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(centerX, centerY, 0, 0, this.xSize, this.ySize);
        if (this.entity.isChested()) {
            this.drawTexturedModalRect(centerX + 79, centerY + 17, 0, this.ySize, 90, 54);
        }
        this.drawTexturedModalRect(centerX + 7, centerY + 35, 0, this.ySize + 54, 18, 18);
        GuiInventory.drawEntityOnScreen(centerX + 51, centerY + 60, 17, (float) (centerX + 51) - this.mouseX, (float) (centerY + 75 - 50) - this.mouseY, this.entity);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.mouseX = (float) mouseX;
        this.mouseY = (float) mouseY;
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
