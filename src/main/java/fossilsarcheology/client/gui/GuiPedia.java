package fossilsarcheology.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fossilsarcheology.Revival;
import fossilsarcheology.api.FoodMappings;
import fossilsarcheology.client.gui.elements.FossilGuiButton;
import fossilsarcheology.client.gui.elements.FossilGuiPage;
import fossilsarcheology.server.entity.EntityDinosaurEgg;
import fossilsarcheology.server.entity.EntityFishBase;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.mob.*;
import fossilsarcheology.server.enums.EnumPrehistoric;
import net.ilexiconn.llibrary.LLibrary;
import net.ilexiconn.llibrary.client.util.ClientUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@SideOnly(Side.CLIENT)
public class GuiPedia extends GuiScreen {
    private static final ResourceLocation background_image = new ResourceLocation("fossil:textures/gui/Dinopedia.png");
    private static final ResourceLocation moods = new ResourceLocation("fossil:textures/gui/dinopedia_mood.png");
    public int xGui = 390;
    public int yGui = 320;
    public FossilGuiPage buttonNextPage;
    public FossilGuiPage buttonPreviousPage;
    public int bookPages;
    public int bookPagesTotal = 1;
    public FossilGuiButton buttonIcon;
    public EnumPrehistoric selfType = null;
    int update = 0;
    int left;// counter for text added on the left side
    int right;// same for the right side
    int items;// counter for the minipics down
    private RenderItem itemRender;
    private float mouseX;
    private float mouseY;
    private FoodSorter sorter;
    protected int xSize = 176;
    protected int ySize = 166;
    protected int guiLeft;
    protected int guiTop;

    public GuiPedia() {
        super();
        left = 0;
        right = 0;
        items = 0;
        xSize = 390;
        ySize = 245;
        sorter = new FoodSorter();
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
    public void initGui() {
        buttonList.clear();
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
        int centerX = (this.width - this.xGui) / 2;
        int centerY = (this.height - this.yGui) / 2;
        this.buttonList.add(this.buttonNextPage = new FossilGuiPage(0, centerX + 350, centerY + 240, true, bookPages));
        this.buttonList.add(this.buttonPreviousPage = new FossilGuiPage(1, centerX + 7, centerY + 240, false, bookPages));
        this.itemRender = new RenderItem();
        addButtonByPage(bookPages);
        super.initGui();
    }

    public void updateScreen() {
        super.updateScreen();
        if (!this.mc.thePlayer.isEntityAlive() || this.mc.thePlayer.isDead) {
            this.mc.thePlayer.closeScreen();
        }
    }

    /*
     * Resets the y-offset for left and right side
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
     * Add a String to the left or right side, starting with 0 Also set the
     * offset for margin position. Useful when using odd sized text.
     */
    public void addStringLR(String string, int marginOffset, boolean left0) {
        this.fontRendererObj.drawString(string, 30 + (left0 ? marginOffset : 121 + marginOffset), 12 * ((left0 ? this.left++ : this.right++) + 1), 0X9D7E67);
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
     * Print a Symbol at X,Y with zoom factor zoom: x*16 pixels. 0 means 8,-1
     * means 4
     */
    public void printItemXY(Item item, int x, int y) {
        this.printItemXY(item, x, y, 100);
    }

    public boolean printItemXY(Item item, int x, int y, int zoom) {
        if (item instanceof ItemBlock) {

        } else {
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
            if (item != null) {
                IIcon icon = item.getIconFromDamage(0);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                if (icon != null) {
                    this.drawTexturedModelRectFromIcon(x, y, icon, drawSize, drawSize);
                }
                GL11.glEnable(GL11.GL_LIGHTING);
                if (mouseX > x && mouseX < x + drawSize) {
                    if (mouseY > y && mouseY < y + drawSize) {
                        List<String> text = new ArrayList<String>();
                        String s1 = (new ItemStack(item)).getDisplayName();
                        text.add(s1);
                        this.drawHoveringText(text, (-this.fontRendererObj.getStringWidth(s1) / 2) + 280, 222, fontRendererObj);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void addMiniItem(Item item) {
        if (this.printItemXY(item, 230 + 16 * (items % 8), 70 + 16 * (items / 8), 1)) {
            items++;
        }
    }

    public void printHappyBar(ResourceLocation resourceLocation, int x, int y, int width, int height, float modifiedU, float modifiedV) {

    }

    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
        this.drawDefaultBackground();
        int k = this.guiLeft;
        int l = this.guiTop;
        this.drawGuiContainerBackgroundLayer(p_73863_3_, p_73863_1_, p_73863_2_);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
        RenderHelper.enableGUIStandardItemLighting();
        GL11.glPushMatrix();
        GL11.glTranslatef((float) k, (float) l, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        short short1 = 240;
        short short2 = 240;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) short1 / 1.0F, (float) short2 / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        this.drawGuiContainerForegroundLayer(p_73863_1_, p_73863_2_);
        GL11.glEnable(GL11.GL_LIGHTING);
        InventoryPlayer inventoryplayer = this.mc.thePlayer.inventory;
        GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderHelper.enableStandardItemLighting();
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        if (Revival.toPedia instanceof EntityPrehistoric || Revival.toPedia instanceof EntityFishBase || Revival.toPedia instanceof EntityQuagga) {
            this.buttonNextPage.enabled = true;
        }
        if (bookPages == 0) {
            if (Revival.toPedia instanceof EntityPregnantHorse && ((EntityPregnantHorse) Revival.toPedia).EmbryoProgress < 10000) {
                EntityHorse entity = ((EntityPregnantHorse) Revival.toPedia).horse;
                String s1 = StatCollector.translateToLocal(entity.getCommandSenderName());
                String s2 = StatCollector.translateToLocal("prehistoric.pregnant");
                int quot = (int) Math.floor(((float) ((EntityPregnantHorse) Revival.toPedia).EmbryoProgress / (float) ((EntityPregnantHorse) Revival.toPedia).Embryo.growTime * 100.0F));
                String s3 = StatCollector.translateToLocal("prehistoric.pregnantTime") + String.valueOf(quot) + "%";
                printStringXY(s3, (-this.fontRendererObj.getStringWidth(s3) / 2) + 100, 110, 157, 126, 103);
                GL11.glScalef(1.5F, 1.5F, 1.5F);
                printStringXY(s2 + StatCollector.translateToLocal(entity.getCommandSenderName()), (-this.fontRendererObj.getStringWidth(s2 + s1) / 2) + 65, 60, 66, 48, 36);
            }
            if (Revival.toPedia instanceof EntityPregnantCow && ((EntityPregnantCow) Revival.toPedia).EmbryoProgress < 10000) {
                EntityCow entity = ((EntityPregnantCow) Revival.toPedia).cow;
                String s1 = StatCollector.translateToLocal(entity.getCommandSenderName());
                String s2 = StatCollector.translateToLocal("prehistoric.pregnant");
                int quot = (int) Math.floor(((float) ((EntityPregnantCow) Revival.toPedia).EmbryoProgress / (float) ((EntityPregnantCow) Revival.toPedia).Embryo.growTime * 100.0F));
                String s3 = StatCollector.translateToLocal("prehistoric.pregnantTime") + String.valueOf(quot) + "%";
                printStringXY(s3, (-this.fontRendererObj.getStringWidth(s3) / 2) + 100, 110, 157, 126, 103);
                GL11.glScalef(1.5F, 1.5F, 1.5F);
                printStringXY(s2 + StatCollector.translateToLocal(entity.getCommandSenderName()), (-this.fontRendererObj.getStringWidth(s2 + s1) / 2) + 65, 60, 66, 48, 36);
            }
            if (Revival.toPedia instanceof EntityPregnantSheep && ((EntityPregnantSheep) Revival.toPedia).EmbryoProgress < 10000) {
                EntitySheep entity = ((EntityPregnantSheep) Revival.toPedia).sheep;
                String s1 = StatCollector.translateToLocal(entity.getCommandSenderName());
                String s2 = StatCollector.translateToLocal("prehistoric.pregnant");
                int quot = (int) Math.floor(((float) ((EntityPregnantSheep) Revival.toPedia).EmbryoProgress / (float) ((EntityPregnantSheep) Revival.toPedia).Embryo.growTime * 100.0F));
                String s3 = StatCollector.translateToLocal("prehistoric.pregnantTime") + String.valueOf(quot) + "%";
                printStringXY(s3, (-this.fontRendererObj.getStringWidth(s3) / 2) + 100, 110, 157, 126, 103);
                GL11.glScalef(1.5F, 1.5F, 1.5F);
                printStringXY(s2 + StatCollector.translateToLocal(entity.getCommandSenderName()), (-this.fontRendererObj.getStringWidth(s2 + s1) / 2) + 65, 60, 66, 48, 36);
            }
            if (Revival.toPedia instanceof EntityPregnantPig && ((EntityPregnantPig) Revival.toPedia).EmbryoProgress < 10000) {
                EntityPig entity = ((EntityPregnantPig) Revival.toPedia).pig;
                String s1 = StatCollector.translateToLocal(entity.getCommandSenderName());
                String s2 = StatCollector.translateToLocal("prehistoric.pregnant");
                int quot = (int) Math.floor(((float) ((EntityPregnantPig) Revival.toPedia).EmbryoProgress / (float) ((EntityPregnantPig) Revival.toPedia).Embryo.growTime * 100.0F));
                String s3 = StatCollector.translateToLocal("prehistoric.pregnantTime") + String.valueOf(quot) + "%";
                printStringXY(s3, (-this.fontRendererObj.getStringWidth(s3) / 2) + 100, 110, 157, 126, 103);
                GL11.glScalef(1.5F, 1.5F, 1.5F);
                printStringXY(s2 + StatCollector.translateToLocal(entity.getCommandSenderName()), (-this.fontRendererObj.getStringWidth(s2 + s1) / 2) + 65, 60, 66, 48, 36);
            }

            if (Revival.toPedia instanceof EntityLivingBase) {
                renderFirstPage((EntityLivingBase) Revival.toPedia);
            } else if (Revival.toPedia instanceof EntityDinosaurEgg) {
                renderFirstPage((EntityDinosaurEgg) Revival.toPedia);
            } else if (Revival.toPedia instanceof EntityFishBase) {
                renderFirstPage((EntityFishBase) Revival.toPedia);
            }
        }
        /*
         * if (Revival.toPedia instanceof EntityDinoEgg) { ((EntityDinoEgg)
		 * Revival.toPedia).showPedia(this); } else if (Revival.toPedia
		 * instanceof EntityPregnantCow) { ((EntityPregnantCow)
		 * Revival.toPedia).showPedia(this); } else if (Revival.toPedia
		 * instanceof EntityPregnantPig) { ((EntityPregnantPig)
		 * Revival.toPedia).showPedia(this); } else if (Revival.toPedia
		 * instanceof EntityPregnantHorse) { ((EntityPregnantHorse)
		 * Revival.toPedia).showPedia(this); } else if (Revival.toPedia
		 * instanceof EntityPregnantSheep) { ((EntityPregnantSheep)
		 * Revival.toPedia).showPedia(this); } else if (Revival.toPedia
		 * instanceof EntityNewPrehistoric) { ((EntityNewPrehistoric)
		 * Revival.toPedia).showPedia(this); } else if (Revival.toPedia
		 * instanceof EntityFishBase) { ((EntityFishBase)
		 * Revival.toPedia).showPedia(this); } else if (Revival.toPedia
		 * instanceof EntityQuagga) { ((EntityQuagga)
		 * Revival.toPedia).showPedia(this); } else if (Revival.toPedia
		 * instanceof EntityTerrorBird) { ((EntityTerrorBird)
		 * Revival.toPedia).showPedia(this); }
		 */
        else {
            if (Revival.toPedia instanceof EntityPrehistoric) {
                showPrehistoricBio(((EntityPrehistoric) Revival.toPedia).type.toString());
            } else if (Revival.toPedia instanceof EntityFishBase) {
                showPrehistoricBio(((EntityFishBase) Revival.toPedia).selfType.toString());
            } else if (Revival.toPedia instanceof EntityQuagga) {
                showPrehistoricBio("Quagga");
            }
        }
    }

    public void showPrehistoricBio(String mobName) {
        this.reset();
        this.addStringLR("", 150, false);
        String translatePath = "assets/fossil/dinopedia/" + Minecraft.getMinecraft().gameSettings.language + "/";
        String bioFile = String.valueOf(mobName) + ".txt";
        if (getClass().getClassLoader().getResourceAsStream(translatePath) == null) {
            translatePath = "assets/fossil/dinopedia/" + "en_US" + "/";
        }

        if (getClass().getClassLoader().getResourceAsStream(translatePath + bioFile) != null) {
            InputStream fileReader = getClass().getClassLoader().getResourceAsStream(translatePath + bioFile);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileReader));
                StringBuilder stringBuffer = new StringBuilder();
                String line;
                int linenumber = 0;
                this.addStringLR("", 250, true);
                while ((line = bufferedReader.readLine()) != null) {
                    GL11.glPushMatrix();
                    GL11.glScalef(0.75F, 0.75F, 0.75F);
                    if (linenumber <= 20) {
                        this.addStringLR(line, -125, false);
                    } else {
                        this.addStringLR(line, 250, true);
                    }
                    linenumber++;
                    GL11.glPopMatrix();
                }
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.addStringLR("File not found.", false);
            GL11.glPushMatrix();
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            this.addStringLR(translatePath + bioFile, 150, false);
            GL11.glPopMatrix();
        }
    }

    public void renderFirstPage(Entity entity) {
        reset();
        int wordLength = 90;
        if (entity instanceof EntityPrehistoric) {
            EntityPrehistoric dino = (EntityPrehistoric) entity;
            renderFirstPageRight(dino);
            GL11.glPushMatrix();
            String s = StatCollector.translateToLocal(entity.getCommandSenderName());
            GL11.glScalef(1.5F, 1.5F, 1.5F);
            printStringXY(StatCollector.translateToLocal(entity.getCommandSenderName()), (-this.fontRendererObj.getStringWidth(s) / 2) + 65, 60, 66, 48, 36);
            GL11.glPopMatrix();
            {
                String s1 = StatCollector.translateToLocal("pedia.age") + " " + dino.getAgeInDays();
                printStringXY(s1, wordLength / 2, 110, 157, 126, 103);
            }
            {
                String s1 = StatCollector.translateToLocal("pedia.health") + " " + Math.min(dino.getHealth(), dino.getMaxHealth()) + "/" + dino.getMaxHealth();
                printStringXY(s1, wordLength / 2, 120, 157, 126, 103);
            }
            {
                String s1 = StatCollector.translateToLocal("pedia.hunger") + " " + dino.getHunger() + "/" + dino.getMaxHunger();
                printStringXY(s1, wordLength / 2, 130, 157, 126, 103);
            }
            {
                ScaledResolution scaledResolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
                final int width = scaledResolution.getScaledWidth();
                final int height = scaledResolution.getScaledHeight();
                final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
                final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;
                String s1 = StatCollector.translateToLocal("pedia.diet") + " " + StatCollector.translateToLocal("pedia.diet." + dino.type.diet.toString().toLowerCase());
                int x = wordLength / 2;
                int y = 140;
                printStringXY(s1, x, y, 157, 126, 103);
                if (mouseX > x && mouseX < x + this.fontRendererObj.getStringWidth(s1)) {
                    if (mouseY > y && mouseY < y + 10) {
                        List<String> text = new ArrayList<String>();
                        text.add(StatCollector.translateToLocal("pedia.diet." + dino.type.diet.toString().toLowerCase() + ".desc"));
                        GL11.glPushMatrix();
                        this.drawHoveringText(text, mouseX, mouseY, fontRendererObj);
                        GL11.glPopMatrix();
                    }
                }
            }
            {
                ScaledResolution scaledResolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
                final int width = scaledResolution.getScaledWidth();
                final int height = scaledResolution.getScaledHeight();
                final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
                final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;
                String s1 = StatCollector.translateToLocal("pedia.temperament") + " " + StatCollector.translateToLocal(dino.getTempermentString());
                int x = wordLength / 2;
                int y = 150;
                printStringXY(s1, x, y, 157, 126, 103);
                if (mouseX > x && mouseX < x + this.fontRendererObj.getStringWidth(s1)) {
                    if (mouseY > y && mouseY < y + 10) {
                        List<String> text = new ArrayList<String>();
                        text.add(StatCollector.translateToLocal(dino.getTempermentString() + ".desc"));
                        GL11.glPushMatrix();
                        this.drawHoveringText(text, mouseX, mouseY, fontRendererObj);
                        GL11.glPopMatrix();
                    }
                }
            }
            {
                String s1 = StatCollector.translateToLocal("pedia.gender") + " " + (dino.getGender() == 0 ? StatCollector.translateToLocal("pedia.gender.female") : StatCollector.translateToLocal("pedia.gender.male"));
                printStringXY(s1, wordLength / 2, 160, 157, 126, 103);
            }
            {
                String name = dino.getOwnerDisplayName();
                String s1 = StatCollector.translateToLocal("pedia.untame");
                String s2 = StatCollector.translateToLocal("pedia.owner") + " " + name;
                printStringXY(!dino.getOwnerDisplayName().equals("") ? s2 : s1, wordLength / 2, 170, 157, 126, 103);
            }
            {
                ScaledResolution scaledResolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
                final int width = scaledResolution.getScaledWidth();
                final int height = scaledResolution.getScaledHeight();
                final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
                final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;
                String s1 = StatCollector.translateToLocal("pedia.order") + " " + StatCollector.translateToLocal("pedia.order." + dino.currentOrder.toString().toLowerCase());
                int x = wordLength / 2;
                int y = 180;
                printStringXY(s1, x, y, 157, 126, 103);
                if (mouseX > x && mouseX < x + this.fontRendererObj.getStringWidth(s1)) {
                    if (mouseY > y && mouseY < y + 10) {
                        List<String> text = new ArrayList<String>();
                        text.add(StatCollector.translateToLocal(StatCollector.translateToLocal("pedia.order." + dino.currentOrder.toString().toLowerCase() + ".desc")));
                        GL11.glPushMatrix();
                        this.drawHoveringText(text, mouseX, mouseY, fontRendererObj);
                        GL11.glPopMatrix();
                    }
                }
            }
            {
                ScaledResolution scaledResolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
                final int width = scaledResolution.getScaledWidth();
                final int height = scaledResolution.getScaledHeight();
                final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
                final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;
                String s1 = StatCollector.translateToLocal("pedia.order.item") + new ItemStack(dino.getOrderItem()).getDisplayName();
                int x = wordLength / 2;
                int y = 190;
                printStringXY(s1, x, y, 157, 126, 103);
            }
            {
                ScaledResolution scaledResolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
                final int width = scaledResolution.getScaledWidth();
                final int height = scaledResolution.getScaledHeight();
                final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
                final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;
                String s1 = StatCollector.translateToLocal("pedia.activity") + " " + StatCollector.translateToLocal("pedia.activity." + dino.aiActivityType().toString().toLowerCase());
                int x = wordLength / 2;
                int y = 200;
                printStringXY(s1, x, y, 157, 126, 103);
                if (mouseX > x && mouseX < x + this.fontRendererObj.getStringWidth(s1)) {
                    if (mouseY > y && mouseY < y + 10) {
                        List<String> text = new ArrayList<String>();
                        text.add(StatCollector.translateToLocal(StatCollector.translateToLocal("pedia.activity." + dino.aiActivityType().toString().toLowerCase() + ".desc")));
                        GL11.glPushMatrix();
                        this.drawHoveringText(text, mouseX, mouseY, fontRendererObj);
                        GL11.glPopMatrix();
                    }
                }
            }
        }
        if (entity instanceof EntityDinosaurEgg) {
            EntityDinosaurEgg egg = (EntityDinosaurEgg) entity;
            GL11.glPushMatrix();
            String s = StatCollector.translateToLocal(egg.selfType.toString() + " " + StatCollector.translateToLocal("pedia.egg"));
            GL11.glScalef(1.5F, 1.5F, 1.5F);
            printStringXY(s, (-this.fontRendererObj.getStringWidth(s) / 2) + 65, 60, 66, 48, 36);
            GL11.glPopMatrix();
            {
                int time = (int) Math.floor(((float) egg.getBirthTick() / (float) egg.totalHatchTime * 100.0F));
                String s1 = StatCollector.translateToLocal("pedia.egg.time") + " " + time + "%";
                printStringXY(s1, wordLength / 2, 120, 157, 126, 103);
            }
            {
                String s1;
                if (egg.isInWater()) {
                    s1 = StatCollector.translateToLocal("pedia.egg.status" + " " + EnumChatFormatting.AQUA + StatCollector.translateToLocal("pedia.egg.status.wet"));
                } else {
                    if ((egg.getBirthTick() >= 0 && egg.getBirthTick() > EntityDinosaurEgg.lastBirthTick) || egg.getBirthTick() >= 100) {
                        s1 = StatCollector.translateToLocal("pedia.egg.status") + " " + EnumChatFormatting.GOLD + StatCollector.translateToLocal("pedia.egg.status.warm");
                    } else {
                        s1 = StatCollector.translateToLocal("pedia.egg.status") + " " + EnumChatFormatting.BLUE + StatCollector.translateToLocal("pedia.egg.status.cold");
                    }
                }
                printStringXY(s1, wordLength / 2, 140, 157, 126, 103);
            }
        }
        if (entity instanceof EntityFishBase) {
            String s1 = StatCollector.translateToLocal(entity.getCommandSenderName());
            GL11.glScalef(1.5F, 1.5F, 1.5F);
            printStringXY(StatCollector.translateToLocal(entity.getCommandSenderName()), (-this.fontRendererObj.getStringWidth(s1) / 2) + 65, 60, 66, 48, 36);
        }
        if (entity instanceof EntityQuagga) {
            String s1 = StatCollector.translateToLocal(entity.getCommandSenderName());
            GL11.glScalef(1.5F, 1.5F, 1.5F);
            printStringXY(StatCollector.translateToLocal(entity.getCommandSenderName()), (-this.fontRendererObj.getStringWidth(s1) / 2) + 65, 60, 66, 48, 36);
        }
    }

    private void renderFirstPageRight(EntityLivingBase entity) {
        if (entity instanceof EntityPrehistoric) {
            EntityPrehistoric dino = (EntityPrehistoric) entity;
            {

                float scale = 1.75F;
                GL11.glPushMatrix();
                GL11.glTranslatef(1F, 0, 0);
                GL11.glScalef(scale, scale, scale);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.renderEngine.bindTexture(moods);
                this.drawTexturedModalRect(160, 7, dino.getMoodFace().uv, 10, 16, 15);
                GL11.glPopMatrix();

            }
            {
                float scale = 0.75F;
                GL11.glPushMatrix();
                GL11.glScalef(scale, scale, scale);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.renderEngine.bindTexture(moods);
                this.drawTexturedModalRect(290, 60, 0, 0, 206, 9);
                GL11.glPopMatrix();
            }
            {
                GL11.glPushMatrix();
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.renderEngine.bindTexture(moods);
                this.drawTexturedModalRect(293 - dino.getScaledMood(), 43, 0, 26, 4, 10);
                GL11.glPopMatrix();
            }

            {
                {
                    ScaledResolution scaledResolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
                    final int width = scaledResolution.getScaledWidth();
                    final int height = scaledResolution.getScaledHeight();
                    final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
                    final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;
                    int x = 218;
                    int y = 40;
                    if (mouseX > x && mouseX < x + 154) {
                        if (mouseY > y && mouseY < y + 13) {
                            List<String> text = new ArrayList<String>();
                            text.add(StatCollector.translateToLocal("pedia.moodstatus") + dino.getMoodFace().color + dino.getMood());
                            GL11.glPushMatrix();
                            this.drawHoveringText(text, mouseX, mouseY, fontRendererObj);
                            GL11.glPopMatrix();
                        }
                    }
                }
                {
                    ScaledResolution scaledResolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
                    final int width = scaledResolution.getScaledWidth();
                    final int height = scaledResolution.getScaledHeight();
                    final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
                    final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;
                    int x = 280;
                    int y = 10;
                    if (mouseX > x && mouseX < x + 28) {
                        if (mouseY > y && mouseY < y + 28) {
                            List<String> text = new ArrayList<String>();
                            text.add(dino.getMoodFace().color + StatCollector.translateToLocal(StatCollector.translateToLocal("pedia.") + dino.getMoodFace().toString().toLowerCase()));
                            text.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal(StatCollector.translateToLocal("pedia.") + dino.getMoodFace().toString().toLowerCase() + StatCollector.translateToLocal(".desc")));
                            GL11.glPushMatrix();
                            this.drawHoveringText(text, mouseX, mouseY, fontRendererObj);
                            GL11.glPopMatrix();
                        }
                    }
                }
            }
            Map<Item, Integer> foodMap = FoodMappings.INSTANCE.getFoodRenderList(dino.type.diet);
            List<Item> keys = Collections.list(Collections.enumeration(foodMap.keySet()));
            Collections.sort(keys, this.sorter);
            Item[] keyArray = keys.toArray(new Item[0]);
            for (Item item : keyArray) {
                if (items < 64 && !(item instanceof ItemBlock)) {
                    addMiniItem(item);
                }
            }

        } else {

        }
    }

    public void renderSecondPage(EntityLivingBase entity) {

    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(background_image);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        func_146110_a(k, l, 0, 0, this.xSize, this.ySize, (390.625F), (390.625F));
        if (bookPages == 0) {
            GL11.glPushMatrix();
            if (Revival.toPedia instanceof EntityPregnantPig) {
                renderDinosaur(k + 100, l + 80, 80, 0, 0, ((EntityPregnantPig) Revival.toPedia).pig);
            }
            if (Revival.toPedia instanceof EntityPregnantCow) {
                renderDinosaur(k + 100, l + 80, 60, 0, 0, ((EntityPregnantCow) Revival.toPedia).cow);
            }
            if (Revival.toPedia instanceof EntityPregnantSheep) {
                renderDinosaur(k + 100, l + 80, 60, 0, 0, ((EntityPregnantSheep) Revival.toPedia).sheep);
            }
            if (Revival.toPedia instanceof EntityPregnantHorse) {
                renderDinosaur(k + 100, l + 80, 50, 0, 0, ((EntityPregnantHorse) Revival.toPedia).horse);
            }
            if (Revival.toPedia instanceof EntityDinosaurEgg) {
                renderEgg(k + 100, l + 80, 150, 0, 0, (EntityDinosaurEgg) Revival.toPedia);
            } else if (Revival.toPedia instanceof EntityLivingBase) {
                if (Revival.toPedia instanceof EntityPrehistoric) {
                    renderDinosaur(k + 100, l + 80, Math.round(2 * ((EntityPrehistoric) Revival.toPedia).pediaScale), 0, 0, (EntityLivingBase) Revival.toPedia);

                } else {
                    if (Revival.toPedia instanceof EntityQuagga) {
                        renderDinosaur(k + 100, l + 80, 50, 0, 0, (EntityLivingBase) Revival.toPedia);
                    } else {
                        renderDinosaur(k + 100, l + 80, 80, 0, 0, (EntityLivingBase) Revival.toPedia);
                    }
                }
            }

            GL11.glPopMatrix();
        }
		/*
		 * addTextByPage(bookPages); if (bookPages == 0) {
		 * this.drawTexturedModalRect(((this.width - this.xGui) / 2) + 22,
		 * ((this.height - this.yGui) / 2) + 11, 0, 240, 136, 15); }
		 * 
		 * if (bookPages >= 9) { var3 = 4; }
		 */
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat
     * events
     */
    @Override
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
        int centerX = (this.width - this.xSize) / 2;
        int centerY = (this.height - this.ySize) / 2;

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

    public static void renderDinosaur(int posX, int posY, int scaleValue, float renderYaw, float renderPitch, EntityLivingBase mob) {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glTranslatef((float) posX, (float) posY, 50.0F);
        scaleValue -= scaleValue * 0.25F;
        if (mob instanceof EntityPrehistoric) {
            GL11.glScalef((float) -scaleValue, -(float) scaleValue, (float) scaleValue);
        } else {
            GL11.glScalef((float) scaleValue, (float) scaleValue, (float) scaleValue);
        }
        GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 0.0F, 0.0F);
        GL11.glRotatef(-((float) Math.atan((double) (renderPitch / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        GL11.glTranslatef(0.0F, mob.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        if (mob instanceof EntityPrehistoric) {
            EntityPrehistoric prehistoric = (EntityPrehistoric) mob;
            GL11.glScalef(1 / prehistoric.getAgeScale(), -1 / prehistoric.getAgeScale(), -1 / prehistoric.getAgeScale());
        }
        GL11.glRotatef(-45.0F, 0.0F, 1.0F, -0.1F);
        float partialTicks = LLibrary.PROXY.getPartialTicks();
        GL11.glRotatef(ClientUtils.interpolate(mob.prevRenderYawOffset, mob.renderYawOffset, partialTicks), 0.0F, 1.0F, 0.0F);
        RenderManager.instance.renderEntityWithPosYaw(mob, 0.0D, 0.0D, 0, 0.0F, partialTicks);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);

    }

    public static void renderEgg(int posX, int posY, int scaleValue, float renderYaw, float renderPitch, Entity mob) {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glTranslatef((float) posX, (float) posY, 50.0F);
        GL11.glScalef((float) (scaleValue), (float) scaleValue, (float) scaleValue);
        float f2 = 0;
        float f3 = 0;
        float f4 = 0;
        float f5 = 0;
        float f6 = 0;
        GL11.glRotatef(-45.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 0.0F, 0.0F);
        GL11.glRotatef(-((float) Math.atan((double) (renderPitch / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        mob.rotationYaw = (float) Math.atan((double) (renderYaw / 40.0F)) * 40.0F;
        mob.rotationPitch = -((float) Math.atan((double) (renderPitch / 40.0F))) * 20.0F;
        GL11.glTranslatef(0.0F, mob.yOffset, 0.0F);
        GL11.glRotatef(mob.ticksExisted, 0.0F, 1.0F, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        RenderManager.instance.renderEntityWithPosYaw(mob, 0.0D, 0.0D, 0.0D, 0.0F, 0F);
        mob.rotationYaw = f3;
        mob.rotationPitch = f4;
        GL11.glDisable(GL11.GL_DEPTH_TEST);

        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);

    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
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

    public class FoodSorter implements Comparator {

        public FoodSorter() {
        }

        public int compareFoods(Item var1, Item var2) {
            double var3 = Item.getIdFromItem(var1);
            double var5 = Item.getIdFromItem(var2);
            return var3 < var5 ? -1 : (var3 > var5 ? 1 : 0);
        }

        @Override
        public int compare(Object var1, Object var2) {
            return this.compareFoods((Item) var1, (Item) var2);
        }
    }
}
