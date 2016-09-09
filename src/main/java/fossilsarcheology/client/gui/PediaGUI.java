package fossilsarcheology.client.gui;

import fossilsarcheology.Revival;
import fossilsarcheology.api.FoodMappings;
import fossilsarcheology.client.gui.elements.FossilButton;
import fossilsarcheology.client.gui.elements.FossilPageButton;
import fossilsarcheology.server.container.PediaContainer;
import fossilsarcheology.server.entity.EntityDinosaurEgg;
import fossilsarcheology.server.entity.EntityFishBase;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.mob.EntityPregnantCow;
import fossilsarcheology.server.entity.mob.EntityPregnantHorse;
import fossilsarcheology.server.entity.mob.EntityPregnantPig;
import fossilsarcheology.server.entity.mob.EntityPregnantSheep;
import fossilsarcheology.server.entity.mob.EntityQuagga;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class PediaGUI extends GuiContainer {
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("fossil:textures/gui/Dinopedia.png");
    private static final ResourceLocation moods = new ResourceLocation("fossil:textures/gui/dinopedia_mood.png");
    private int xGui = 390;
    private int yGui = 320;
    private FossilPageButton buttonNextPage;
    private FossilPageButton buttonPreviousPage;
    private int bookPages;
    private int bookPagesTotal = 1;
    private FossilButton buttonIcon;
    private int left;// counter for text added on the left side
    private int right;// same for the right side
    private int items;// counter for the minipics down
    private FoodSorter sorter;

    public PediaGUI() {
        super(new PediaContainer());
        this.left = 0;
        this.right = 0;
        this.items = 0;
        this.xSize = 390;
        this.ySize = 300;
        this.sorter = new FoodSorter();
    }

    @Override
    public void initGui() {
        buttonList.clear();
        int centerX = (this.width - this.xGui) / 2;
        int centerY = (this.height - this.yGui) / 2;
        this.buttonList.add(this.buttonNextPage = new FossilPageButton(0, centerX + 350, centerY + 210, true, bookPages));
        this.buttonList.add(this.buttonPreviousPage = new FossilPageButton(1, centerX + 7, centerY + 210, false, bookPages));
        this.itemRender = Minecraft.getMinecraft().getRenderItem();
        addButtonByPage(bookPages);
        super.initGui();
    }

    /**
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

    public void printStringXY(String string, int x, int y) {
        this.fontRendererObj.drawString(string, x, y, 4210752);
    }

    public void printStringXY(String str0, int x0, int y0, int r, int g, int b) {
        int col = (r << 16) | (g << 8) | b;
        this.fontRendererObj.drawString(str0, x0, y0, col);
    }

    public void printItemXY(Item item, int x, int y) {
        this.printItemXY(item, x, y, 100);
    }

    public boolean printItemXY(Item item, int x, int y, int zoom) {
        ScaledResolution scaledResolution = new ScaledResolution(mc);
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

        if (item != null) {
            GlStateManager.disableLighting();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            this.mc.getRenderItem().renderItemIntoGUI(new ItemStack(item), x, y);
            GlStateManager.enableLighting();
            if (mouseX > x && mouseX < x + drawSize) {
                if (mouseY > y && mouseY < y + drawSize) {
                    List<String> text = new ArrayList<>();
                    String displayName = new ItemStack(item).getDisplayName();
                    text.add(displayName);
                    this.drawHoveringText(text, -this.fontRendererObj.getStringWidth(displayName) / 2 + 280, 222, fontRendererObj);
                }
            }
            return true;
        }
        return false;
    }

    public void addMiniItem(Item item) {
        if (this.printItemXY(item, 230 + 16 * (items % 8), 70 + 16 * (items / 8), 1)) {
            items++;
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        if (Revival.toPedia instanceof EntityPrehistoric || Revival.toPedia instanceof EntityFishBase || Revival.toPedia instanceof EntityQuagga) {
            this.buttonNextPage.enabled = true;
        }
        if (bookPages == 0) {
            if (Revival.toPedia instanceof EntityPregnantHorse) {
                EntityHorse entity = ((EntityPregnantHorse) Revival.toPedia).horse;
                String s1 = I18n.translateToLocal(entity.getName());
                String s2 = I18n.translateToLocal("prehistoric.pregnant");
                int quot = (int) Math.floor(((float) ((EntityPregnantHorse) Revival.toPedia).EmbryoProgress / (float) ((EntityPregnantHorse) Revival.toPedia).Embryo.growTime * 100.0F));
                String s3 = I18n.translateToLocal("prehistoric.pregnantTime") + String.valueOf(quot) + "%";
                printStringXY(s3, (-this.fontRendererObj.getStringWidth(s3) / 2) + 100, 110, 157, 126, 103);
                GlStateManager.scale(1.5F, 1.5F, 1.5F);
                printStringXY(s2 + I18n.translateToLocal(entity.getName()), (-this.fontRendererObj.getStringWidth(s2 + s1) / 2) + 65, 60, 66, 48, 36);
            }
            if (Revival.toPedia instanceof EntityPregnantCow) {
                EntityCow entity = ((EntityPregnantCow) Revival.toPedia).cow;
                String s1 = I18n.translateToLocal(entity.getName());
                String s2 = I18n.translateToLocal("prehistoric.pregnant");
                int quot = (int) Math.floor(((float) ((EntityPregnantCow) Revival.toPedia).EmbryoProgress / (float) ((EntityPregnantCow) Revival.toPedia).embryo.growTime * 100.0F));
                String s3 = I18n.translateToLocal("prehistoric.pregnantTime") + String.valueOf(quot) + "%";
                printStringXY(s3, (-this.fontRendererObj.getStringWidth(s3) / 2) + 100, 110, 157, 126, 103);
                GlStateManager.scale(1.5F, 1.5F, 1.5F);
                printStringXY(s2 + I18n.translateToLocal(entity.getName()), (-this.fontRendererObj.getStringWidth(s2 + s1) / 2) + 65, 60, 66, 48, 36);
            }
            if (Revival.toPedia instanceof EntityPregnantSheep) {
                EntitySheep entity = ((EntityPregnantSheep) Revival.toPedia).sheep;
                String s1 = I18n.translateToLocal(entity.getName());
                String s2 = I18n.translateToLocal("prehistoric.pregnant");
                int quot = (int) Math.floor(((float) ((EntityPregnantSheep) Revival.toPedia).EmbryoProgress / (float) ((EntityPregnantSheep) Revival.toPedia).embryo.growTime * 100.0F));
                String s3 = I18n.translateToLocal("prehistoric.pregnantTime") + String.valueOf(quot) + "%";
                printStringXY(s3, (-this.fontRendererObj.getStringWidth(s3) / 2) + 100, 110, 157, 126, 103);
                GlStateManager.scale(1.5F, 1.5F, 1.5F);
                printStringXY(s2 + I18n.translateToLocal(entity.getName()), (-this.fontRendererObj.getStringWidth(s2 + s1) / 2) + 65, 60, 66, 48, 36);
            }
            if (Revival.toPedia instanceof EntityPregnantPig) {
                EntityPig entity = ((EntityPregnantPig) Revival.toPedia).pig;
                String s1 = I18n.translateToLocal(entity.getName());
                String s2 = I18n.translateToLocal("prehistoric.pregnant");
                int quot = (int) Math.floor(((float) ((EntityPregnantPig) Revival.toPedia).EmbryoProgress / (float) ((EntityPregnantPig) Revival.toPedia).embryo.growTime * 100.0F));
                String s3 = I18n.translateToLocal("prehistoric.pregnantTime") + String.valueOf(quot) + "%";
                printStringXY(s3, (-this.fontRendererObj.getStringWidth(s3) / 2) + 100, 110, 157, 126, 103);
                GlStateManager.scale(1.5F, 1.5F, 1.5F);
                printStringXY(s2 + I18n.translateToLocal(entity.getName()), (-this.fontRendererObj.getStringWidth(s2 + s1) / 2) + 65, 60, 66, 48, 36);
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
                    GlStateManager.pushMatrix();
                    GlStateManager.scale(0.75F, 0.75F, 0.75F);
                    if (linenumber <= 20) {
                        this.addStringLR(line, -125, false);
                    } else {
                        this.addStringLR(line, 250, true);
                    }
                    linenumber++;
                    GlStateManager.popMatrix();
                }
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.addStringLR("File not found.", false);
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            this.addStringLR(translatePath + bioFile, 150, false);
            GlStateManager.popMatrix();
        }
    }

    public void renderFirstPage(Entity entity) {
        reset();
        int wordLength = 90;
        if (entity instanceof EntityPrehistoric) {
            EntityPrehistoric dino = (EntityPrehistoric) entity;
            renderFirstPageRight(dino);
            GlStateManager.pushMatrix();
            String s = I18n.translateToLocal(entity.getName());
            GlStateManager.scale(1.5F, 1.5F, 1.5F);
            printStringXY(I18n.translateToLocal(entity.getName()), (-this.fontRendererObj.getStringWidth(s) / 2) + 65, 60, 66, 48, 36);
            GlStateManager.popMatrix();
            {
                String s1 = I18n.translateToLocal("pedia.age") + " " + dino.getAgeInDays();
                printStringXY(s1, wordLength / 2, 110, 157, 126, 103);
            }
            {
                String s1 = I18n.translateToLocal("pedia.health") + " " + Math.min(dino.getHealth(), dino.getMaxHealth()) + "/" + dino.getMaxHealth();
                printStringXY(s1, wordLength / 2, 120, 157, 126, 103);
            }
            {
                String s1 = I18n.translateToLocal("pedia.hunger") + " " + dino.getHunger() + "/" + dino.getMaxHunger();
                printStringXY(s1, wordLength / 2, 130, 157, 126, 103);
            }
            {
                ScaledResolution scaledResolution = new ScaledResolution(mc);
                final int width = scaledResolution.getScaledWidth();
                final int height = scaledResolution.getScaledHeight();
                final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
                final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;
                String s1 = I18n.translateToLocal("pedia.diet") + " " + I18n.translateToLocal("pedia.diet." + dino.type.diet.toString().toLowerCase());
                int x = wordLength / 2;
                int y = 140;
                printStringXY(s1, x, y, 157, 126, 103);
                if (mouseX > x && mouseX < x + this.fontRendererObj.getStringWidth(s1)) {
                    if (mouseY > y && mouseY < y + 10) {
                        List<String> text = new ArrayList<String>();
                        text.add(I18n.translateToLocal("pedia.diet." + dino.type.diet.toString().toLowerCase() + ".desc"));
                        GlStateManager.pushMatrix();
                        this.drawHoveringText(text, mouseX, mouseY, fontRendererObj);
                        GlStateManager.popMatrix();
                    }
                }
            }
            {
                ScaledResolution scaledResolution = new ScaledResolution(mc);
                final int width = scaledResolution.getScaledWidth();
                final int height = scaledResolution.getScaledHeight();
                final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
                final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;
                String s1 = I18n.translateToLocal("pedia.temperament") + " " + I18n.translateToLocal(dino.getTempermentString());
                int x = wordLength / 2;
                int y = 150;
                printStringXY(s1, x, y, 157, 126, 103);
                if (mouseX > x && mouseX < x + this.fontRendererObj.getStringWidth(s1)) {
                    if (mouseY > y && mouseY < y + 10) {
                        List<String> text = new ArrayList<String>();
                        text.add(I18n.translateToLocal(dino.getTempermentString() + ".desc"));
                        GlStateManager.pushMatrix();
                        this.drawHoveringText(text, mouseX, mouseY, fontRendererObj);
                        GlStateManager.popMatrix();
                    }
                }
            }
            {
                String s1 = I18n.translateToLocal("pedia.gender") + " " + (dino.getGender() == 0 ? I18n.translateToLocal("pedia.gender.female") : I18n.translateToLocal("pedia.gender.male"));
                printStringXY(s1, wordLength / 2, 160, 157, 126, 103);
            }
            {
                String name = dino.getOwnerName();
                String s1 = I18n.translateToLocal("pedia.untame");
                String s2 = I18n.translateToLocal("pedia.owner") + " " + name;
                printStringXY(!dino.getOwnerName().equals("") ? s2 : s1, wordLength / 2, 170, 157, 126, 103);
            }
            {
                ScaledResolution scaledResolution = new ScaledResolution(mc);
                final int width = scaledResolution.getScaledWidth();
                final int height = scaledResolution.getScaledHeight();
                final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
                final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;
                String s1 = I18n.translateToLocal("pedia.order") + " " + I18n.translateToLocal("pedia.order." + dino.currentOrder.toString().toLowerCase());
                int x = wordLength / 2;
                int y = 180;
                printStringXY(s1, x, y, 157, 126, 103);
                if (mouseX > x && mouseX < x + this.fontRendererObj.getStringWidth(s1)) {
                    if (mouseY > y && mouseY < y + 10) {
                        List<String> text = new ArrayList<String>();
                        text.add(I18n.translateToLocal(I18n.translateToLocal("pedia.order." + dino.currentOrder.toString().toLowerCase() + ".desc")));
                        GlStateManager.pushMatrix();
                        this.drawHoveringText(text, mouseX, mouseY, fontRendererObj);
                        GlStateManager.popMatrix();
                    }
                }
            }
            {
                ScaledResolution scaledResolution = new ScaledResolution(mc);
                final int width = scaledResolution.getScaledWidth();
                final int height = scaledResolution.getScaledHeight();
                final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
                final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;
                String s1 = I18n.translateToLocal("pedia.order.item") + new ItemStack(dino.getOrderItem()).getDisplayName();
                int x = wordLength / 2;
                int y = 190;
                printStringXY(s1, x, y, 157, 126, 103);
            }
            {
                ScaledResolution scaledResolution = new ScaledResolution(mc);
                final int width = scaledResolution.getScaledWidth();
                final int height = scaledResolution.getScaledHeight();
                final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
                final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;
                String s1 = I18n.translateToLocal("pedia.activity") + " " + I18n.translateToLocal("pedia.activity." + dino.getActivityType().toString().toLowerCase());
                int x = wordLength / 2;
                int y = 200;
                printStringXY(s1, x, y, 157, 126, 103);
                if (mouseX > x && mouseX < x + this.fontRendererObj.getStringWidth(s1)) {
                    if (mouseY > y && mouseY < y + 10) {
                        List<String> text = new ArrayList<String>();
                        text.add(I18n.translateToLocal(I18n.translateToLocal("pedia.activity." + dino.getActivityType().toString().toLowerCase() + ".desc")));
                        GlStateManager.pushMatrix();
                        this.drawHoveringText(text, mouseX, mouseY, fontRendererObj);
                        GlStateManager.popMatrix();
                    }
                }
            }
        }
        if (entity instanceof EntityDinosaurEgg) {
            EntityDinosaurEgg egg = (EntityDinosaurEgg) entity;
            GlStateManager.pushMatrix();
            String s = I18n.translateToLocal(egg.selfType.toString() + " " + I18n.translateToLocal("pedia.egg"));
            GlStateManager.scale(1.5F, 1.5F, 1.5F);
            printStringXY(s, (-this.fontRendererObj.getStringWidth(s) / 2) + 65, 60, 66, 48, 36);
            GlStateManager.popMatrix();
            {
                int time = (int) Math.floor(((float) egg.getBirthTick() / (float) egg.totalHatchTime * 100.0F));
                String s1 = I18n.translateToLocal("pedia.egg.time") + " " + time + "%";
                printStringXY(s1, wordLength / 2, 120, 157, 126, 103);
            }
            {
                String s1;
                if (egg.isInWater()) {
                    s1 = I18n.translateToLocal("pedia.egg.status" + " " + TextFormatting.AQUA + I18n.translateToLocal("pedia.egg.status.wet"));
                } else {
                    if ((egg.getBirthTick() >= 0 && egg.getBirthTick() > EntityDinosaurEgg.lastBirthTick) || egg.getBirthTick() >= 100) {
                        s1 = I18n.translateToLocal("pedia.egg.status") + " " + TextFormatting.GOLD + I18n.translateToLocal("pedia.egg.status.warm");
                    } else {
                        s1 = I18n.translateToLocal("pedia.egg.status") + " " + TextFormatting.BLUE + I18n.translateToLocal("pedia.egg.status.cold");
                    }
                }
                printStringXY(s1, wordLength / 2, 140, 157, 126, 103);
            }
        }
        if (entity instanceof EntityFishBase) {
            String s1 = I18n.translateToLocal(entity.getName());
            GlStateManager.scale(1.5F, 1.5F, 1.5F);
            printStringXY(I18n.translateToLocal(entity.getName()), (-this.fontRendererObj.getStringWidth(s1) / 2) + 65, 60, 66, 48, 36);
        }
        if (entity instanceof EntityQuagga) {
            String s1 = I18n.translateToLocal(entity.getName());
            GlStateManager.scale(1.5F, 1.5F, 1.5F);
            printStringXY(I18n.translateToLocal(entity.getName()), (-this.fontRendererObj.getStringWidth(s1) / 2) + 65, 60, 66, 48, 36);
        }
    }

    private void renderFirstPageRight(EntityLivingBase entity) {
        if (entity instanceof EntityPrehistoric) {
            EntityPrehistoric dino = (EntityPrehistoric) entity;
            {

                float scale = 1.75F;
                GlStateManager.pushMatrix();
                GlStateManager.translate(1F, 0, 0);
                GlStateManager.scale(scale, scale, scale);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                mc.renderEngine.bindTexture(moods);
                this.drawTexturedModalRect(160, 7, dino.getMoodFace().uv, 10, 16, 15);
                GlStateManager.popMatrix();
            }
            {
                float scale = 0.75F;
                GlStateManager.pushMatrix();
                GlStateManager.scale(scale, scale, scale);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                mc.renderEngine.bindTexture(moods);
                this.drawTexturedModalRect(290, 60, 0, 0, 206, 9);
                GlStateManager.popMatrix();
            }
            {
                GlStateManager.pushMatrix();
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                mc.renderEngine.bindTexture(moods);
                this.drawTexturedModalRect(293 - dino.getScaledMood(), 43, 0, 26, 4, 10);
                GlStateManager.popMatrix();
            }

            {
                {
                    ScaledResolution scaledResolution = new ScaledResolution(mc);
                    final int width = scaledResolution.getScaledWidth();
                    final int height = scaledResolution.getScaledHeight();
                    final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
                    final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;
                    int x = 218;
                    int y = 40;
                    if (mouseX > x && mouseX < x + 154) {
                        if (mouseY > y && mouseY < y + 13) {
                            List<String> text = new ArrayList<String>();
                            text.add(I18n.translateToLocal("pedia.moodstatus") + dino.getMoodFace().color + dino.getMood());
                            GlStateManager.pushMatrix();
                            this.drawHoveringText(text, mouseX, mouseY, fontRendererObj);
                            GlStateManager.popMatrix();
                        }
                    }
                }
                {
                    ScaledResolution scaledResolution = new ScaledResolution(mc);
                    final int width = scaledResolution.getScaledWidth();
                    final int height = scaledResolution.getScaledHeight();
                    final int mouseX = (Mouse.getX() * width / mc.displayWidth) - guiLeft;
                    final int mouseY = (height - Mouse.getY() * height / mc.displayHeight - 1) - guiTop;
                    int x = 280;
                    int y = 10;
                    if (mouseX > x && mouseX < x + 28) {
                        if (mouseY > y && mouseY < y + 28) {
                            List<String> text = new ArrayList<String>();
                            text.add(dino.getMoodFace().color + I18n.translateToLocal(I18n.translateToLocal("pedia.") + dino.getMoodFace().toString().toLowerCase()));
                            text.add(TextFormatting.GRAY + I18n.translateToLocal(I18n.translateToLocal("pedia.") + dino.getMoodFace().toString().toLowerCase() + I18n.translateToLocal(".desc")));
                            GlStateManager.pushMatrix();
                            this.drawHoveringText(text, mouseX, mouseY, fontRendererObj);
                            GlStateManager.popMatrix();
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

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        drawModalRectWithCustomSizedTexture(x, y, 0, 0, this.xSize, this.ySize, 390.625F, 390.625F);
        if (bookPages == 0) {
            GlStateManager.pushMatrix();
            if (Revival.toPedia instanceof EntityPregnantPig) {
                renderDinosaur(x + 100, y + 80, 80, 0, 0, ((EntityPregnantPig) Revival.toPedia).pig);
            }
            if (Revival.toPedia instanceof EntityPregnantCow) {
                renderDinosaur(x + 100, y + 80, 60, 0, 0, ((EntityPregnantCow) Revival.toPedia).cow);
            }
            if (Revival.toPedia instanceof EntityPregnantSheep) {
                renderDinosaur(x + 100, y + 80, 60, 0, 0, ((EntityPregnantSheep) Revival.toPedia).sheep);
            }
            if (Revival.toPedia instanceof EntityPregnantHorse) {
                renderDinosaur(x + 100, y + 80, 50, 0, 0, ((EntityPregnantHorse) Revival.toPedia).horse);
            }
            if (Revival.toPedia instanceof EntityDinosaurEgg) {
                renderEgg(x + 100, y + 80, 150, 0, 0, (EntityDinosaurEgg) Revival.toPedia);
            } else if (Revival.toPedia instanceof EntityLivingBase) {
                if (Revival.toPedia instanceof EntityPrehistoric) {
                    renderDinosaur(x + 100, y + 80, Math.round(2 * ((EntityPrehistoric) Revival.toPedia).pediaScale), 0, 0, (EntityLivingBase) Revival.toPedia);
                } else {
                    if (Revival.toPedia instanceof EntityQuagga) {
                        renderDinosaur(x + 100, y + 80, 50, 0, 0, (EntityLivingBase) Revival.toPedia);
                    } else {
                        renderDinosaur(x + 100, y + 80, 80, 0, 0, (EntityLivingBase) Revival.toPedia);
                    }
                }
            }

            GlStateManager.popMatrix();
        }
		/*
		 * addTextByPage(bookPages); if (bookPages == 0) {
		 * this.drawTexturedRect(((this.width - this.xGui) / 2) + 22,
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
        GlStateManager.pushMatrix();
        GlStateManager.scale(1.10F, 1.10F, 1.10F);
        GlStateManager.popMatrix();

        if (page == 1) {
        }
        var1 = MathHelper.floor_float((this.width - this.xGui) / 2.4F);
        var2 = MathHelper.floor_float((this.height - this.yGui) / 2.4F);
        var3 = MathHelper.floor_float((this.width - this.xGui) / 1.2F);
        var4 = MathHelper.floor_float((this.height - this.yGui) / 1.2F);
        GlStateManager.pushMatrix();
        GlStateManager.scale(1.20F, 1.20F, 1.20F);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        GlStateManager.popMatrix();
    }

    public void addButtonByPage(int page) {
        int centerX = (this.width - this.xGui) / 2;
        int centerY = (this.height - this.yGui) / 2;

        if (page == 0) {
            this.buttonList.add(this.buttonIcon = new FossilButton(2, centerX + 35, centerY + 55));
            this.buttonList.add(this.buttonIcon = new FossilButton(3, centerX + 75, centerY + 55));
            this.buttonList.add(this.buttonIcon = new FossilButton(4, centerX + 115, centerY + 55));
            this.buttonList.add(this.buttonIcon = new FossilButton(5, centerX + 55, centerY + 95));
            this.buttonList.add(this.buttonIcon = new FossilButton(6, centerX + 95, centerY + 95));
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
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GlStateManager.pushMatrix();
        GlStateManager.enableDepth();
        GlStateManager.translate((float) posX, (float) posY, 50.0F);
        scaleValue -= scaleValue * 0.25F;
        if (mob instanceof EntityPrehistoric) {
            GlStateManager.scale((float) -(scaleValue), -(float) scaleValue, (float) scaleValue);
        } else {
            GlStateManager.scale((float) (scaleValue), (float) scaleValue, (float) scaleValue);
        }
        float yawOffset = 0;
        float yaw = 0;
        float pitch = 0;
        float prevYawHead = 0;
        float yawHead = 0;
        GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 0.0F, 0.0F);
        GlStateManager.rotate(-((float) Math.atan((double) (renderPitch / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        mob.renderYawOffset = (float) Math.atan((double) (renderYaw / 40.0F)) * 20.0F;
        mob.rotationYaw = (float) Math.atan((double) (renderYaw / 40.0F)) * 40.0F;
        mob.rotationPitch = -((float) Math.atan((double) (renderPitch / 40.0F))) * 20.0F;
        mob.rotationYawHead = mob.rotationYaw;
        mob.prevRotationYawHead = mob.rotationYaw;
        GlStateManager.translate(0.0F, mob.getYOffset(), 0.0F);
        renderManager.playerViewY = 180.0F;
        if (mob instanceof EntityPrehistoric) {
            EntityPrehistoric prehistoric = (EntityPrehistoric) mob;
            GlStateManager.scale(1 / prehistoric.getAgeScale(), -1 / prehistoric.getAgeScale(), -1 / prehistoric.getAgeScale());
        }
        GlStateManager.rotate(-45.0F, 0.0F, 1.0F, -0.1F);
        renderManager.doRenderEntity(mob, 0.0D, 0.0D, 0.0D, 0.0F, 0F, false);
        mob.renderYawOffset = yawOffset;
        mob.rotationYaw = yaw;
        mob.rotationPitch = pitch;
        mob.prevRotationYawHead = prevYawHead;
        mob.rotationYawHead = yawHead;
        GlStateManager.disableDepth();
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    public static void renderEgg(int posX, int posY, int scaleValue, float renderYaw, float renderPitch, Entity mob) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GlStateManager.pushMatrix();
        GlStateManager.enableDepth();
        GlStateManager.translate((float) posX, (float) posY, 50.0F);
        GlStateManager.scale((float) scaleValue, (float) scaleValue, (float) scaleValue);
        float yaw = 0;
        float pitch = 0;
        GlStateManager.rotate(-45.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 0.0F, 0.0F);
        GlStateManager.rotate(-((float) Math.atan((double) (renderPitch / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        mob.rotationYaw = (float) Math.atan((double) (renderYaw / 40.0F)) * 40.0F;
        mob.rotationPitch = -((float) Math.atan((double) (renderPitch / 40.0F))) * 20.0F;
        GlStateManager.translate(0.0F, mob.getYOffset(), 0.0F);
        GlStateManager.rotate(mob.ticksExisted, 0.0F, 1.0F, 0.0F);
        renderManager.playerViewY = 180.0F;
        renderManager.doRenderEntity(mob, 0.0D, 0.0D, 0.0D, 0.0F, 0F, false);
        mob.rotationYaw = yaw;
        mob.rotationPitch = pitch;
        GlStateManager.disableDepth();
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
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
