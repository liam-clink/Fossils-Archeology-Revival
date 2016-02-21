package com.github.revival.client.gui;

import com.github.revival.Revival;
import com.github.revival.client.gui.elements.FossilGuiButton;
import com.github.revival.client.gui.elements.FossilGuiPage;
import com.github.revival.common.container.ContainerPedia;
import com.github.revival.common.entity.EntityDinoEgg;
import com.github.revival.common.entity.mob.*;
import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;
import com.github.revival.common.enums.EnumPrehistoric;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class GuiPedia extends GuiContainer {
    public static final int rightIndent = 150; //Left aligntment position for text on the RIGHT page of the pedia
    public static final int leftIndent = 30; //Left aligntment position for text on the LEFT page of the pedia
    private static final ResourceLocation background_image = new ResourceLocation("fossil:textures/gui/Dinopedia.png");
    public final int xGui = 256;
    public final int yGui = 174;
    public FossilGuiPage buttonNextPage;
    public FossilGuiPage buttonPreviousPage;
    public int bookPages;
    public int bookPagesTotal = 1;
    public FossilGuiButton buttonIcon;
    public EnumPrehistoric selfType = null;
    int update = 0;
    int left;//counter for text added on the left side
    int right;//same for the right side
    int items;//counter for the minipics down
    private RenderItem itemRender;
    private float mouseX;

    private float mouseY;

    public GuiPedia(/*InventoryPlayer var1*/) {
        super(new ContainerPedia());
        this.xSize = 280;
        this.ySize = 174;
        left = 0;
        right = 0;
        items = 0;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui() {
        buttonList.clear();
        int centerX = (this.width - this.xGui) / 2;
        int centerY = (this.height - this.yGui) / 2;
        this.buttonList.add(this.buttonNextPage = new FossilGuiPage(0, centerX + 212, centerY + 115, true, bookPages));
        this.buttonList.add(this.buttonPreviousPage = new FossilGuiPage(1, centerX + 7, centerY + 115, false, bookPages));
        this.itemRender = new RenderItem();
        addButtonByPage(bookPages);
        super.initGui();
    }

    /* Resets the y-offset for left and right side
    */
    public void reset() {
        this.left = 0;
        this.right = 0;
        this.items = 0;
    }

    /**
     * Print a String to left or Right, starting with line 0
     */
    public void printStringLR(String string, boolean left0, int line) {
        this.fontRendererObj.drawString(string, 70 + (left0 ? 0 : 81), 12 * (line + 1), 4210752);
    }

    public void printStringLR(String string, boolean left0, int line, int r, int g, int b) {
        int col = (r << 16) | (g << 8) | b;
        this.fontRendererObj.drawString(string, 70 + (left0 ? 0 : 81), 12 * (line + 1), col);
    }

    /**
     * Add a String to the left or right side, starting with 0
     */
    public void addStringLR(String string, boolean left0) {
        this.fontRendererObj.drawString(string, 30 + (left0 ? 0 : 121), 12 * ((left0 ? this.left++ : this.right++) + 1), 4210752);
    }

    /**
     * Add a String to the left or right side, starting with 0
     * Also set the offset for margin position. Useful when using odd sized text.
     */
    public void addStringLR(String string, int marginOffset, boolean left0) {
        this.fontRendererObj.drawString(string, 30 + (left0 ? 0 + marginOffset : 121 + marginOffset), 12 * ((left0 ? this.left++ : this.right++) + 1), 4210752);
    }

    public void addStringLR(String string, boolean left0, int r, int g, int b) {
        int col = (r << 16) | (g << 8) | b;
        this.fontRendererObj.drawString(string, 30 + (left0 ? 0 : 121), 12 * ((left0 ? this.left++ : this.right++) + 1), col);
    }

    /**
     * Print a String to X,Y
     */
    public void printStringXY(String string, int x, int y) {
        this.fontRendererObj.drawString(string, x, y, 4210752);
    }

    public void printStringXY(String str0, int x0, int y0, int r, int g, int b) {
        int col = (r << 16) | (g << 8) | b;
        this.fontRendererObj.drawString(str0, x0, y0, col);
    }

    /**
     * Print a Symbol at X,Y with zoom factor zoom: x*16 pixels. 0 means 8,-1 means 4
     */
    public void printItemXY(Item item, int x, int y) {
        this.printItemXY(item, x, y, 1);
    }

    public void printItemXY(Item item, int x, int y, int zoom) {

        ScaledResolution scaledResolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);

        final int width = scaledResolution.getScaledWidth();
        final int height = scaledResolution.getScaledHeight();
        final int guiLeft = (width - this.xSize) / 2;
        final int guiTop = (height - this.ySize) / 2;
        final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
        final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;

        int drawSize = zoom * 16;

        if (drawSize < 0) {
            drawSize = 4;
        }

        if (drawSize == 0) {
            drawSize = 8;
        }

        if (drawSize > 160) {
            drawSize = 160;
        }

        GL11.glDisable(GL11.GL_LIGHTING);
        this.mc.getTextureManager().bindTexture(TextureMap.locationItemsTexture);
        ItemStack it = new ItemStack(item, 1);
        IIcon icon = it.getIconIndex();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.drawTexturedModelRectFromIcon(x, y, icon, drawSize, drawSize);
        GL11.glEnable(GL11.GL_LIGHTING);

        if (mouseX > x && mouseX < x + drawSize) {
            if (mouseY > y && mouseY < y + drawSize) {
                List<String> text = new ArrayList<String>();
                text.add((new ItemStack(item)).getDisplayName());
                this.drawHoveringText(text, rightIndent - 8, 130 + 24, fontRendererObj);
            }
        }
    }

    public void drawToolTip() {
    }

    /**
     * Places a half-sized item at the bottom of dinopedia
     */
    public void addMiniItem(Item item) {
        this.printItemXY(item, rightIndent + 8 * (items % 8), 130 - 8 * (items / 8), 0);
        items++;
    }

    /**
     * Print a Picture at X,Y
     */
    public void printPicture(ResourceLocation resourceLocation, int x, int y, int width, int height) {
        this.mc.getTextureManager().bindTexture(resourceLocation);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.2F);
        Tessellator tesselator = Tessellator.instance;
        tesselator.startDrawingQuads();
        tesselator.addVertexWithUV((double) x, (double) (y + height), 0D, 0D, 1D);
        tesselator.addVertexWithUV((double) (x + width), (double) (y + height), 0D, 1D, 1D);
        tesselator.addVertexWithUV((double) (x + width), (double) y, 0D, 1D, 0D);
        tesselator.addVertexWithUV((double) x, (double) y, 0D, 0D, 0D);
        tesselator.draw();
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.mouseX = (float) mouseX;
        this.mouseY = (float) mouseY;
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.drawToolTip();
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        if (bookPages == 0) {
            if (Revival.toPedia instanceof EntityDinoEgg) {
                ((EntityDinoEgg) Revival.toPedia).showPedia(this);
            } else if (Revival.toPedia instanceof EntityPregnantCow) {
                ((EntityPregnantCow) Revival.toPedia).showPedia(this);
            } else if (Revival.toPedia instanceof EntityPregnantPig) {
                ((EntityPregnantPig) Revival.toPedia).showPedia(this);
            } else if (Revival.toPedia instanceof EntityPregnantHorse) {
                ((EntityPregnantHorse) Revival.toPedia).showPedia(this);
            } else if (Revival.toPedia instanceof EntityPregnantSheep) {
                ((EntityPregnantSheep) Revival.toPedia).showPedia(this);
            } else if (Revival.toPedia instanceof EntityNewPrehistoric) {
                ((EntityNewPrehistoric) Revival.toPedia).showPedia(this);
            } else if (Revival.toPedia instanceof EntityFishBase) {
                ((EntityFishBase) Revival.toPedia).showPedia(this);
            } else if (Revival.toPedia instanceof EntityQuagga) {
                ((EntityQuagga) Revival.toPedia).showPedia(this);
            } else if (Revival.toPedia instanceof EntityTerrorBird) {
                ((EntityTerrorBird) Revival.toPedia).showPedia(this);
            }
        } else {
            if (Revival.toPedia instanceof EntityNewPrehistoric) {
                ((EntityNewPrehistoric) Revival.toPedia).showPedia2(this, ((EntityNewPrehistoric) Revival.toPedia).selfType.toString());
            } else if (Revival.toPedia instanceof EntityFishBase) {
                ((EntityFishBase) Revival.toPedia).showPedia2(this);
            } else if (Revival.toPedia instanceof EntityQuagga) {
                ((EntityQuagga) Revival.toPedia).showPedia2(this);
            } else if (Revival.toPedia instanceof EntityTerrorBird) {
                ((EntityTerrorBird) Revival.toPedia).showPedia2(this);
            }
        }
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen() {
        super.updateScreen();
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(background_image);
        int posX = (this.width - this.xGui) / 2;
        int posY = (this.height - this.yGui) / 2;
        this.drawTexturedModalRect(posX, posY, 0, 0, this.xGui, this.yGui);
        /*
        addTextByPage(bookPages);
        if (bookPages == 0)
        {
            this.drawTexturedModalRect(((this.width - this.xGui) / 2) + 22, ((this.height - this.yGui) / 2) + 11, 0, 240, 136, 15);
        }

        if (bookPages >= 9)
        {
            var3 = 4;
        }
        */
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed() {
        super.onGuiClosed();
    }

    public void addTextByPage(int page) {
        int var1 = MathHelper.floor_float((this.width - this.xGui) / 2.2F);
        int var2 = MathHelper.floor_float((this.height - this.yGui) / 2.2F);
        int var3 = MathHelper.floor_float((this.width - this.xGui) / 2.0F + 10);
        int var4 = MathHelper.floor_float((this.height - this.yGui) / 1.2F);
        GL11.glPushMatrix();
        GL11.glScalef(1.10F, 1.10F, 1.10F);
        GL11.glPopMatrix();

        if (page == 1) {
            //TODO
        }

        var1 = MathHelper.floor_float((this.width - this.xGui) / 2.4F);
        var2 = MathHelper.floor_float((this.height - this.yGui) / 2.4F);
        var3 = MathHelper.floor_float((this.width - this.xGui) / 1.2F);
        var4 = MathHelper.floor_float((this.height - this.yGui) / 1.2F);
        GL11.glPushMatrix();
        GL11.glScalef(1.20F, 1.20F, 1.20F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(0.6F, 0.6F, 0.6F);
        GL11.glPopMatrix();
    }

    public void addButtonByPage(int page) {
        int centerX = (this.width - this.xGui) / 2;
        int centerY = (this.height - this.yGui) / 2;

        if (page == 0) {
            this.buttonList.add(this.buttonIcon = new FossilGuiButton(2, centerX + 35, centerY + 55, 0));
            this.buttonList.add(this.buttonIcon = new FossilGuiButton(3, centerX + 75, centerY + 55, 2));
            this.buttonList.add(this.buttonIcon = new FossilGuiButton(4, centerX + 115, centerY + 55, 4));
            this.buttonList.add(this.buttonIcon = new FossilGuiButton(5, centerX + 55, centerY + 95, 6));
            this.buttonList.add(this.buttonIcon = new FossilGuiButton(6, centerX + 95, centerY + 95, 8));
        }
    }

    public void triggerButtons(GuiButton button) {
        switch (button.id) {
            case 2:
                this.bookPages = 1;
                break;

            case 3:
                this.bookPages = 2;
                break;
        }
    }

    @Override
    public void actionPerformed(GuiButton button) {
        if (button.id == 0 && bookPages < bookPagesTotal) {
            bookPages += 1;
        } else if (button.id == 1 && bookPages > 0) {
            bookPages -= 1;
        }

        this.triggerButtons(button);
        this.initGui();
        this.updateScreen();
    }
}
