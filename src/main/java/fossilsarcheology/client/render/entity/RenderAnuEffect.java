package fossilsarcheology.client.render.entity;

import fossilsarcheology.client.model.ModelAnuTotem;
import fossilsarcheology.server.entity.EntityAnuEffect;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.util.Random;

@SideOnly(Side.CLIENT)
public class RenderAnuEffect extends RenderLiving {
    private static final ResourceLocation explodingTexture = new ResourceLocation("fossil:textures/blocks/anuTotemExploding.png");
    private static final ResourceLocation texture = new ResourceLocation("fossil:textures/blocks/anuTotem.png");
    protected ModelAnuTotem modelAnuTotem;

    public RenderAnuEffect() {
        super(new ModelAnuTotem(), 0.3F);
        this.modelAnuTotem = (ModelAnuTotem) this.mainModel;
        this.setRenderPassModel(this.mainModel);
    }

    protected void rotateCorpse(EntityAnuEffect entity, float x, float y, float z) {
        float f3 = 0;
        float f4 = 0;
        GlStateManager.rotate(-f3, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(f4 * 10.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.translate(0.0F, 0.0F, 1.0F);

        if (entity.deathTime > 0) {
            float f5 = ((float) entity.deathTime + z - 1.0F) / 20.0F * 1.6F;
            f5 = MathHelper.sqrt_float(f5);

            if (f5 > 1.0F) {
                f5 = 1.0F;
            }

            GlStateManager.rotate(f5 * this.getDeathMaxRotation(entity), 0.0F, 0.0F, 1.0F);
        }
    }

    /**
     * Renders the model in RenderLiving
     */
    protected void renderModel(EntityAnuEffect entity, float x, float y, float z, float i, float j, float u) {
        int i1 = 0;
        if (entity.worldObj != null) {
            i1 = entity.getAnuRotation();
        }
        short short1 = 0;
        if (i1 == 2) {
            GlStateManager.translate(0, 0, -1);
            short1 = 360;
        }

        if (i1 == 3) {
            GlStateManager.translate(0, 0, -1);
            short1 = 180;
        }

        if (i1 == 4) {
            GlStateManager.translate(0, 0, -1);
            short1 = 90;
        }

        if (i1 == 5) {
            GlStateManager.translate(0, 0, -1);
            short1 = -90;
        }

        GlStateManager.rotate(-1 * short1, 0.0F, 1.0F, 0.0F);

        GlStateManager.pushMatrix();
        if (entity.deathTicks > 0) {
            float f6 = (float) entity.deathTicks / 200.0F;
            GL11.glDepthFunc(GL11.GL_LEQUAL);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            GL11.glAlphaFunc(GL11.GL_GREATER, f6);
            this.bindTexture(explodingTexture);
            this.mainModel.render(entity, pos, i, j, u);
            GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
            GL11.glDepthFunc(GL11.GL_EQUAL);
        }
        GlStateManager.popMatrix();

        this.bindEntityTexture(entity);
        this.mainModel.render(entity, pos, i, j, u);

        if (entity.hurtTime > 0) {
            GL11.glDepthFunc(GL11.GL_EQUAL);
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GlStateManager.enableBlend();
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GlStateManager.color(1.0F, 0.0F, 0.0F, 0.5F);
            GlStateManager.translate(0, 0, 1);
            this.mainModel.render(entity, pos, i, j, u);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glDepthFunc(GL11.GL_LEQUAL);
            GlStateManager.popMatrix();

        }
    }

    protected ResourceLocation getEntityTexture(EntityAnuEffect entity) {
        return texture;
    }

    protected void renderEquippedItems(EntityAnuEffect entity, float i1) {
        super.renderEquippedItems(entity, i1);
        Tessellator tessellator = Tessellator.instance;

        if (entity.deathTicks > 0) {
            RenderHelper.disableStandardItemLighting();
            float f1 = ((float) entity.deathTicks + i1) / 200.0F;
            float f2 = 0.0F;

            if (f1 > 0.8F) {
                f2 = (f1 - 0.8F) / 0.2F;
            }

            Random random = new Random(432L);
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glShadeModel(GL11.GL_SMOOTH);
            GlStateManager.enableBlend();
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glEnable(GL11.GL_CULL_FACE);
            GL11.glDepthMask(false);
            GlStateManager.pushMatrix();
            GlStateManager.translate(0, 0.5F, 0);

            for (int i = 0; (float) i < (f1 + f1 * f1) / 2.0F * 60.0F; ++i) {
                GlStateManager.rotate(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
                GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
                GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
                GlStateManager.rotate(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
                GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
                GlStateManager.rotate(random.nextFloat() * 360.0F + f1 * 90.0F, 0.0F, 0.0F, 1.0F);
                tessellator.startDrawing(6);
                float f3 = random.nextFloat() * 20.0F + 5.0F + f2 * 10.0F;
                float f4 = random.nextFloat() * 2.0F + 1.0F + f2 * 2.0F;
                tessellator.setColorRGBA_I(16777215, (int) (255.0F * (1.0F - f2)));
                tessellator.addVertex(0.0D, 0.0D, 0.0D);
                tessellator.setColorRGBA_I(0X070707, 0);
                tessellator.addVertex(-0.866D * (double) f4, (double) f3, (double) (-0.5F * f4));
                tessellator.addVertex(0.866D * (double) f4, (double) f3, (double) (-0.5F * f4));
                tessellator.addVertex(0.0D, (double) f3, (double) (1.0F * f4));
                tessellator.addVertex(-0.866D * (double) f4, (double) f3, (double) (-0.5F * f4));
                tessellator.draw();
            }

            GlStateManager.popMatrix();
            GL11.glDepthMask(true);
            GL11.glDisable(GL11.GL_CULL_FACE);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glShadeModel(GL11.GL_FLAT);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            RenderHelper.enableStandardItemLighting();
        }
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityAnuEffect entity, int x, float i) {
        if (x == 1) {
            GL11.glDepthFunc(GL11.GL_LEQUAL);
        }

        if (x != 0) {
            return -1;
        } else {
            GlStateManager.enableBlend();
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDepthFunc(GL11.GL_EQUAL);
            char c0 = 61680;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j / 1.0F, (float) k / 1.0F);
            GL11.glEnable(GL11.GL_LIGHTING);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            return 1;
        }
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    @Override
    protected int shouldRenderPass(EntityLivingBase entity, int x, float i) {
        return this.shouldRenderPass((EntityAnuEffect) entity, x, i);
    }

    @Override
    protected void renderEquippedItems(EntityLivingBase entity, float i1) {
        this.renderEquippedItems((EntityAnuEffect) entity, i1);
    }

    @Override
    protected void rotateCorpse(EntityLivingBase entity, float x, float y, float z) {
        this.rotateCorpse((EntityAnuEffect) entity, pos);
    }

    /**
     * Renders the model in RenderLiving
     */
    @Override
    protected void renderModel(EntityLivingBase entity, float x, float y, float z, float i, float j, float u) {
        this.renderModel((EntityAnuEffect) entity, pos, i, j, u);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called
     * unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntityAnuEffect) entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method,
     * always casting down its argument and then handing it off to a worker
     * function which does the actual work. In all probabilty, the class Render
     * is generic (Render<T extends Entity) and this method has signature public
     * void func_76986_a(T entity, double d, double d1, double d2, float f,
     * float f1). But JAD is pre 1.5 so doesn't do that.
     */
    @Override
    public void doRender(Entity entity, double x, double y, double z, float i, float j) {
        this.doRender((EntityAnuEffect) entity, pos, i, j);
    }
}