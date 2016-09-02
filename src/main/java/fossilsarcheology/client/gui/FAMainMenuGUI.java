package fossilsarcheology.client.gui;

import fossilsarcheology.Revival;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.io.Charsets;
import org.lwjgl.opengl.GL11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

@SideOnly(Side.CLIENT)
public class FAMainMenuGUI extends GuiMainMenu {
    public static final int LAYER_COUNT = 2;
    public static final ResourceLocation SPLASHES = new ResourceLocation("fossil:splashes.txt");

    private ResourceLocation[] layerTextures = new ResourceLocation[FAMainMenuGUI.LAYER_COUNT];

    private int layerTick;
    private int backAdd;
    private int frontAdd;
    private Random rand = new Random();

    public FAMainMenuGUI() {
        super();
        this.backAdd = new Random().nextInt(1027);
        this.frontAdd = new Random().nextInt(2047);

        BufferedReader splashReader = null;
        try {
            ArrayList splashes = new ArrayList();
            splashReader = new BufferedReader(new InputStreamReader(mc.getResourceManager().getResource(SPLASHES).getInputStream(), Charsets.UTF_8));
            String splash;
            while ((splash = splashReader.readLine()) != null) {
                splash = splash.trim();
                if (!splash.isEmpty()) {
                    splashes.add(splash);
                }
            }
            if (!splashes.isEmpty()) {
                do {
                    this.splashText = (String) splashes.get(rand.nextInt(splashes.size()));
                } while (this.splashText.hashCode() == 125780783);
            }
        } catch (IOException e) {
        } finally {
            if (splashReader != null) {
                try {
                    splashReader.close();
                } catch (IOException ioexception) {
                }
            }
        }
    }

    @Override
    public void drawCenteredString(FontRenderer fontRenderer, String text, int x, int y, int color) {
        if (text.equals(splashText)) {
            fontRenderer.drawStringWithShadow(text, x - fontRenderer.getStringWidth(text) / 2, y, 0xF1E961);
        } else {
            fontRenderer.drawStringWithShadow(text, x - fontRenderer.getStringWidth(text) / 2, y, color);
        }
    }

    @Override
    public void initGui() {
        super.initGui();
        for (int layer = 0; layer < this.layerTextures.length; layer++) {
            this.layerTextures[layer] = new ResourceLocation(Revival.MODID, "textures/gui/parallax/layer" + layer + ".png");
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        this.layerTick++;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GlStateManager.enableTexture2D();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.enableBlend();
        for (int i = 0; i < this.layerTextures.length; i++) {
            ResourceLocation layerTexture = this.layerTextures[i];
            this.mc.getTextureManager().bindTexture(layerTexture);
            this.drawTexturedRect(0, 0, (i == 1 ? backAdd : frontAdd) + (layerTick / (float) (this.layerTextures.length - i)) + partialTicks / (float) (i + 1) + 2048 * i / 4.0F, 0, this.width, this.height, 2048 / (this.layerTextures.length - i) * (this.height / 128.0F), this.height, this.zLevel);
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void drawTexturedRect(double x, double y, double u, double v, double width, double height, double textureWidth, double textureHeight, double zLevel) {
        double widthScale = 1.0F / textureWidth;
        double heightScale = 1.0F / textureHeight;
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer buffer = tessellator.getBuffer();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        buffer.pos(x + 0, y + height, zLevel).tex(u * widthScale, (v + height) * heightScale);
        buffer.pos(x + width, y + height, zLevel).tex((u + width) * widthScale, (v + height) * heightScale);
        buffer.pos(x + width, y + 0, zLevel).tex((u + width) * widthScale, v * heightScale);
        buffer.pos(x + 0, y + 0, zLevel).tex(u * widthScale, v * heightScale);
        tessellator.draw();
    }

    @Override
    public void renderSkybox(int mouseX, int mouseY, float partialTicks) {

    }
}
