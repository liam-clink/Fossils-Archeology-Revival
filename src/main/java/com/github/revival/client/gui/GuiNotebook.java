package com.github.revival.client.gui;

import com.github.revival.client.gui.elements.FossilGuiButton;
import com.github.revival.client.gui.elements.FossilGuiPage;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiNotebook extends GuiScreen {
    private static final ResourceLocation notebook_background = new ResourceLocation("fossil:textures/gui/Arch_Notebook.png");
    public FossilGuiPage buttonNextPage;
    public FossilGuiPage buttonPreviousPage;
    // The name of the file to open.
    public int bookPages;
    public int bookPagesTotal = 1;
    public FossilGuiButton buttonIcon;
    int update = 0;
    // This will reference one line at a time
    String line = null;
    private RenderItem itemRender;
    private int bookImageWidth = 254;
    private int bookImageHeight = 188;

    @Override
    public void initGui() {
        buttonList.clear();
        int centerX = (this.width - this.bookImageWidth) / 2;
        int centerY = (this.height - this.bookImageHeight) / 2;
        this.buttonList.add(this.buttonNextPage = new FossilGuiPage(0, centerX + 200, centerY + 140, true, bookPages));
        this.buttonList.add(this.buttonPreviousPage = new FossilGuiPage(1, centerX + 30, centerY + 140, false, bookPages));
        this.itemRender = new RenderItem();
        addButtonByPage(bookPages);
    }

    public void addTextByPage(int page) {
        int var1 = MathHelper.floor_float((this.width - this.bookImageWidth) / 2.2F);
        int var2 = MathHelper.floor_float((this.height - this.bookImageHeight) / 2.2F);
        int var3 = MathHelper.floor_float((this.width - this.bookImageWidth) / 2.0F + 10);
        int var4 = MathHelper.floor_float((this.height - this.bookImageHeight) / 1.2F);
        GL11.glPushMatrix();
        GL11.glScalef(1.10F, 1.10F, 1.10F);
        GL11.glPopMatrix();

        if (page == 1) {
            /*
            //TODO
            String[] dinoArrayLeft = PediaDinosaur.ankylosaurus_leftPage;
            String[] dinoArrayRight = PediaDinosaur.ankylosaurus_rightPage;

            for (int i = 0; i < dinoArrayLeft.length; i++)
            {
                fontRenderer.drawString(dinoArrayLeft[i], var3, var4 + (12 * i), 0x2b2b2b, false);
            }

            for (int i2 = 0; i2 < dinoArrayLeft.length; i2++)
            {
                fontRenderer.drawString(dinoArrayRight[i2], var3 + 120, var4 + (12 * i2), 0x2b2b2b, false);
            }
*/
            // fontRenderer.drawString("This needs to be dynamically loaded from a text file.", var3, var4+65, 0x2b2b2b, false);
        }

        var1 = MathHelper.floor_float((this.width - this.bookImageWidth) / 2.4F);
        var2 = MathHelper.floor_float((this.height - this.bookImageHeight) / 2.4F);
        var3 = MathHelper.floor_float((this.width - this.bookImageWidth) / 1.2F);
        var4 = MathHelper.floor_float((this.height - this.bookImageHeight) / 1.2F);
        GL11.glPushMatrix();
        GL11.glScalef(1.20F, 1.20F, 1.20F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(0.6F, 0.6F, 0.6F);
        GL11.glPopMatrix();
    }

    public void addButtonByPage(int page) {
        int centerX = (this.width - this.bookImageWidth) / 2;
        int centerY = (this.height - this.bookImageHeight) / 2;

        /*
        if(page == 6)
        {
            this.buttonList.add(this.buttonIcon = new FossilGuiButton(7, centerX+35, centerY+75, 10));
            this.buttonList.add(this.buttonIcon = new FossilGuiButton(8, centerX+75, centerY+55, 12));
            this.buttonList.add(this.buttonIcon = new FossilGuiButton(9, centerX+115, centerY+75, 14));
            this.buttonList.add(this.buttonIcon = new FossilGuiButton(10, centerX+75, centerY+95, 16));
        }
        */

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
        }

        if (button.id == 1 && bookPages > 0) {
            bookPages -= 1;
        }

        this.triggerButtons(button);
        this.initGui();
        this.updateScreen();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(notebook_background);
        int centerX = (this.width - this.bookImageWidth) / 2;
        int centerY = ((this.height - this.bookImageHeight) / 2) - 10;
        this.drawTexturedModalRect(centerX, centerY, 0, 0, this.bookImageWidth, this.bookImageHeight);
        int pageOffset = 0;
        addTextByPage(bookPages);

        if (bookPages == 0) {
            this.drawTexturedModalRect(((this.width - this.bookImageWidth) / 2) + 22, ((this.height - this.bookImageHeight) / 2) + 11, 0, 240, 136, 15);
        }

        if (bookPages >= 9) {
            pageOffset = 4;
        }

        fontRendererObj.drawString(Integer.toString(bookPages + 1), centerX + 89 - pageOffset, centerY + 155, 0x2b2b2b, false);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }
}