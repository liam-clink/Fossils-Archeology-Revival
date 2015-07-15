package com.github.revival.client.gui;

import com.github.revival.Revival;
import com.github.revival.client.gui.elements.FossilGuiButton;
import com.github.revival.client.gui.elements.FossilGuiPage;
import com.github.revival.common.container.ContainerPedia;
import com.github.revival.common.entity.EntityDinoEgg;
import com.github.revival.common.entity.mob.*;
import com.github.revival.common.enums.EnumPrehistoric;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
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
public class GuiPedia extends GuiContainer
{
    public static final int rightIndent = 150; //Left aligntment position for text on the RIGHT page of the pedia
    public static final int leftIndent = 30; //Left aligntment position for text on the LEFT page of the pedia
    private static final ResourceLocation background_image = new ResourceLocation("fossil:textures/gui/Dinopedia.png");
    public final int xGui = 256;
    public final int yGui = 174;
    public FossilGuiPage buttonNextPage;
    public FossilGuiPage buttonPreviousPage;
    public int BookPages;
    public int BookPagesTotal = 1;
    public FossilGuiButton buttonIcon;
    public EnumPrehistoric SelfType = null;
    int update = 0;
    int left;//counter for text added on the left side
    int right;//same for the right side
    int items;//counter for the minipics down
    private RenderItem itemRender;
    private float mouseX;

    private float mouseY;
    
    public GuiPedia(/*InventoryPlayer var1*/)
    {
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
    public void initGui()
    {
        buttonList.clear();
        int var1 = (this.width - this.xGui) / 2;
        int var2 = (this.height - this.yGui) / 2;
        this.buttonList.add(this.buttonNextPage = new FossilGuiPage(0, var1 + 212, var2 + 115, true, BookPages));
        this.buttonList.add(this.buttonPreviousPage = new FossilGuiPage(1, var1 + 7, var2 + 115, false, BookPages));
        this.itemRender = new RenderItem();
        addButtonByPage(BookPages);
        super.initGui();
    }
    
    /**
     * Resets the y-offset for left and right side
     */
    public void reset()
    {
        this.left = 0;
        this.right = 0;
        this.items = 0;
    }

    /**
     * Print a String to left or Right, starting with line 0
     */
    public void PrintStringLR(String str0, boolean left0, int line)
    {
        this.fontRendererObj.drawString(str0, 70 + (left0 ? 0 : 81), 12 * (line + 1), 4210752);
    }

    public void PrintStringLR(String str0, boolean left0, int line, int r, int g, int b)
    {
        int col = (r << 16) | (g << 8) | b;
        this.fontRendererObj.drawString(str0, 70 + (left0 ? 0 : 81), 12 * (line + 1), col);
    }

    /**
     * Add a String to the left or right side, starting with 0
     */
    public void AddStringLR(String str0, boolean left0)
    {
        this.fontRendererObj.drawString(str0, 30 + (left0 ? 0 : 121), 12 * ((left0 ? this.left++ : this.right++) + 1), 4210752);
    }
    
    /**
     * Add a String to the left or right side, starting with 0
     * Also set the offset for margin position. Useful when using odd sized text.
     */
    public void AddStringLR(String str0, int marginOffset, boolean left0)
    {
        this.fontRendererObj.drawString(str0, 30 + (left0 ? 0 + marginOffset : 121 + marginOffset), 12 * ((left0 ? this.left++ : this.right++) + 1), 4210752);
    }
    
    public void AddStringLR(String str0, boolean left0, int r, int g, int b)
    {
        int col = (r << 16) | (g << 8) | b;
        this.fontRendererObj.drawString(str0, 30 + (left0 ? 0 : 121), 12 * ((left0 ? this.left++ : this.right++) + 1), col);
    }
    
    /**
     * Print a String to X,Y
     */
    public void PrintStringXY(String str0, int x0, int y0)
    {
        this.fontRendererObj.drawString(str0, x0, y0, 4210752);
    }

    public void PrintStringXY(String str0, int x0, int y0, int r, int g, int b)
    {
        int col = (r << 16) | (g << 8) | b;
        this.fontRendererObj.drawString(str0, x0, y0, col);
    }

    /**
     * Print a Symbol at X,Y with zoom factor zoom: x*16 pixels. 0 means 8,-1 means 4
     */
    public void PrintItemXY(Item it0, int x0, int y0)
    {

        this.PrintItemXY(it0, x0, y0, 1);
    }

    public void PrintItemXY(Item it0, int x0, int y0, int zoom)
    {

        ScaledResolution scaledResolution = new ScaledResolution(mc.getMinecraft(), mc.getMinecraft().displayWidth, mc.getMinecraft().displayHeight);

        final int width = scaledResolution.getScaledWidth();
        final int height = scaledResolution.getScaledHeight();
        final int guiLeft = (width - this.xSize) / 2;
        final int guiTop = (height - this.ySize) / 2;
        final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
        final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;

        TextureManager r0 = Minecraft.getMinecraft().renderEngine;
        int i = zoom * 16;

        if (i < 0)
        {
            i = 4;
        }

        if (i == 0)
        {
            i = 8;
        }

        if (i > 160)
        {
            i = 160;
        }

        GL11.glDisable(GL11.GL_LIGHTING);
        this.mc.getTextureManager().bindTexture(TextureMap.locationItemsTexture);
        RenderItem r = new RenderItem();
        ItemStack it = new ItemStack(it0, 1);
        IIcon icon = it.getIconIndex();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.drawTexturedModelRectFromIcon(x0, y0, icon, i, i);
        GL11.glEnable(GL11.GL_LIGHTING);
        
        if (mouseX > x0 && mouseX < x0 + i)
        {
            if (mouseY > y0 && mouseY < y0 + i)
            {
                List list = new ArrayList();
                list.add((new ItemStack(it0)).getDisplayName());
                this.drawHoveringText(list, rightIndent - 8, 130 + 24, fontRendererObj);
            }
        }
        
    }
    
    public void drawToolTip()
    {
    }

    /**
     * Places a half-sized item at the bottom of dinopedia
     */
    public void AddMiniItem(Item it0)
    {


        this.PrintItemXY(it0, rightIndent + 8 * (items % 8), 130 - 8 * (items / 8), 0);
        items++;
    }

    /**
     * Print a Picture at X,Y
     */
    public void PrintPictXY(ResourceLocation str0, int x0, int y0, int width, int height)
    {
        this.mc.getTextureManager().bindTexture(str0);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.2F);
        Tessellator var9 = Tessellator.instance;
        var9.startDrawingQuads();
        var9.addVertexWithUV((double) x0, (double) (y0 + height), 0D, 0D, 1D);
        var9.addVertexWithUV((double) (x0 + width), (double) (y0 + height), 0D, 1D, 1D);
        var9.addVertexWithUV((double) (x0 + width), (double) y0, 0D, 1D, 0D);
        var9.addVertexWithUV((double) x0, (double) y0, 0D, 0D, 0D);
        var9.draw();
    }
    
    public void drawScreen(int par1, int par2, float par3)
    {
        this.mouseX = (float) par1;
        this.mouseY = (float) par2;
        super.drawScreen(par1, par2, par3);
        this.drawToolTip();
    }
    
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int var1, int var2)
    {


        if (BookPages == 0)
        {
            if (Revival.toPedia instanceof EntityDinosaur)
            {
                ((EntityDinosaur) Revival.toPedia).ShowPedia(this);
            }

            if (Revival.toPedia instanceof EntityDinoEgg)
            {
                ((EntityDinoEgg) Revival.toPedia).ShowPedia(this);
            }

            if (Revival.toPedia instanceof EntityPregnantCow)
            {
                ((EntityPregnantCow) Revival.toPedia).ShowPedia(this);
            }

            if (Revival.toPedia instanceof EntityPregnantPig)
            {
                ((EntityPregnantPig) Revival.toPedia).ShowPedia(this);
            }

            if (Revival.toPedia instanceof EntityPregnantHorse)
            {
                ((EntityPregnantHorse) Revival.toPedia).ShowPedia(this);
            }

            if (Revival.toPedia instanceof EntityPregnantSheep)
            {
                ((EntityPregnantSheep) Revival.toPedia).ShowPedia(this);
            }

            if (Revival.toPedia instanceof EntityMammoth)
            {
                ((EntityMammoth) Revival.toPedia).ShowPedia(this);
            }

            if (Revival.toPedia instanceof EntityElasmotherium)
            {
                ((EntityElasmotherium) Revival.toPedia).ShowPedia(this);
            }

            if (Revival.toPedia instanceof EntitySmilodon)
            {
                ((EntitySmilodon) Revival.toPedia).ShowPedia(this);
            }

            if (Revival.toPedia instanceof EntityDodo)
            {
                ((EntityDodo) Revival.toPedia).ShowPedia(this);
            }
            if (Revival.toPedia instanceof EntityConfuciusornis)
            {
                ((EntityConfuciusornis) Revival.toPedia).ShowPedia(this);
            }
            if (Revival.toPedia instanceof EntityCoelacanth)
            {
                ((EntityCoelacanth) Revival.toPedia).ShowPedia(this);
            }

            if (Revival.toPedia instanceof EntityNautilus)
            {
                ((EntityNautilus) Revival.toPedia).ShowPedia(this);
            }

            if (Revival.toPedia instanceof EntityQuagga)
            {
                ((EntityQuagga) Revival.toPedia).ShowPedia(this);
            }

            if (Revival.toPedia instanceof EntityTerrorBird)
            {
                ((EntityTerrorBird) Revival.toPedia).ShowPedia(this);
            }
        }
        else
        {
            if (Revival.toPedia instanceof EntityDinosaur)
            {
                ((EntityDinosaur) Revival.toPedia).ShowPedia2(this);
            }

            if (Revival.toPedia instanceof EntityElasmotherium)
            {
                ((EntityElasmotherium) Revival.toPedia).ShowPedia2(this);
            }

            if (Revival.toPedia instanceof EntityMammoth)
            {
                ((EntityMammoth) Revival.toPedia).ShowPedia2(this);
            }

            if (Revival.toPedia instanceof EntitySmilodon)
            {
                ((EntitySmilodon) Revival.toPedia).ShowPedia2(this);
            }

            if (Revival.toPedia instanceof EntityDodo)
            {
                ((EntityDodo) Revival.toPedia).ShowPedia2(this);
            }
            if (Revival.toPedia instanceof EntityConfuciusornis)
            {
                ((EntityConfuciusornis) Revival.toPedia).ShowPedia2(this);
            }
            if (Revival.toPedia instanceof EntityCoelacanth)
            {
                ((EntityCoelacanth) Revival.toPedia).ShowPedia2(this);
            }

            if (Revival.toPedia instanceof EntityNautilus)
            {
                ((EntityNautilus) Revival.toPedia).ShowPedia2(this);
            }

            if (Revival.toPedia instanceof EntityQuagga)
            {
                ((EntityQuagga) Revival.toPedia).ShowPedia2(this);
            }

            if (Revival.toPedia instanceof EntityTerrorBird)
            {
                ((EntityTerrorBird) Revival.toPedia).ShowPedia2(this);
            }
        }
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        int x = var2;
        int y = var3;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(background_image);
        int posX = (this.width - this.xGui) / 2;
        int posY = (this.height - this.yGui) / 2;
        this.drawTexturedModalRect(posX, posY, 0, 0, this.xGui, this.yGui);
        /*
        addTextByPage(BookPages);
        if (BookPages == 0)
        {
            this.drawTexturedModalRect(((this.width - this.xGui) / 2) + 22, ((this.height - this.yGui) / 2) + 11, 0, 240, 136, 15);
        }

        if (BookPages >= 9)
        {
            var3 = 4;
        }
        */
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed()
    {
        super.onGuiClosed();
    }

    
    public void addTextByPage(int page)
    {
        int var1 = MathHelper.floor_float((this.width - this.xGui) / 2.2F);
        int var2 = MathHelper.floor_float((this.height - this.yGui) / 2.2F);
        int var3 = MathHelper.floor_float((this.width - this.xGui) / 2.0F + 10);
        int var4 = MathHelper.floor_float((this.height - this.yGui) / 1.2F);
        GL11.glPushMatrix();
        GL11.glScalef(1.10F, 1.10F, 1.10F);
        GL11.glPopMatrix();

        if (page == 1)
        {
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

    public void addButtonByPage(int page)
    {
        int var1 = (this.width - this.xGui) / 2;
        int var2 = (this.height - this.yGui) / 2;

        if (page == 0)
        {
            this.buttonList.add(this.buttonIcon = new FossilGuiButton(2, var1 + 35, var2 + 55, 0));
            this.buttonList.add(this.buttonIcon = new FossilGuiButton(3, var1 + 75, var2 + 55, 2));
            this.buttonList.add(this.buttonIcon = new FossilGuiButton(4, var1 + 115, var2 + 55, 4));
            this.buttonList.add(this.buttonIcon = new FossilGuiButton(5, var1 + 55, var2 + 95, 6));
            this.buttonList.add(this.buttonIcon = new FossilGuiButton(6, var1 + 95, var2 + 95, 8));
        }
    }

    public void triggerButtons(GuiButton button)
    {
        switch (button.id)
        {
            case 2:
                this.BookPages = 1;
                break;

            case 3:
                this.BookPages = 2;
                break;
        }
    }

    @Override
    public void actionPerformed(GuiButton button)
    {
        if (button.id == 0 && BookPages < BookPagesTotal)
        {
            BookPages += 1;
        }
        else
        {
        }

        if (button.id == 1 && BookPages > 0)
        {
            BookPages -= 1;
        }
        else
        {
        }

        this.triggerButtons(button);
        this.initGui();
        this.updateScreen();
    }
}
