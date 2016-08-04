package fossilsarcheology.client.render.tileentity;

import fossilsarcheology.client.model.ModelPigBoss;
import fossilsarcheology.client.model.ModelSarcophagus;
import fossilsarcheology.server.block.entity.TileEntitySarcophagus;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntitySarcophagusRender extends TileEntitySpecialRenderer {
    private static final ResourceLocation texture = new ResourceLocation("fossil:textures/blocks/sarcophagus.png");
    private static final ResourceLocation texture_anu = new ResourceLocation("fossil:textures/model/PigBoss.png");
    EntityItem key = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D, new ItemStack(FAItemRegistry.INSTANCE.gem));
    private ModelSarcophagus model = new ModelSarcophagus();
    private ModelPigBoss model_anu = new ModelPigBoss();

    public void renderTileEntityAt(TileEntitySarcophagus chest, double x, double y, double z, float i1) {
        int i = 0;

        if (chest.hasWorldObj()) {
            i = chest.getBlockMetadata();
        }

        this.bindTexture(texture);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x, (float) y + 1.0F, (float) z + 1.0F);
        GlStateManager.scale(1.0F, -1.0F, -1.0F);
        GlStateManager.translate(0.5F, -0.5F, 0.5F);
        short short1 = 0;
        if (i == 2) {
            short1 = 180;
        }

        if (i == 3) {
            short1 = 0;
        }

        if (i == 4) {
            short1 = 90;
        }

        if (i == 5) {
            short1 = -90;
        }
        GlStateManager.pushMatrix();
        GlStateManager.rotate((float) short1, 0.0F, 1.0F, 0.0F);
        float f1;
        if (chest.chestLidCounter > 90) {
            f1 = chest.chestLidCounter2 + chest.chestLidCounter;
        } else {
            f1 = chest.chestLidCounter;
        }
        this.model.hinge.rotateAngleY = -(float) Math.toRadians(f1);
        this.model.renderBlock(0.0625F);
        GlStateManager.popMatrix();
        GlStateManager.popMatrix();
        if (chest.chestState == 1) {
            this.renderItem(pos, i);
        }
        if (chest.chestState != 3) {
            this.bindTexture(texture_anu);
            GlStateManager.pushMatrix();
            GlStateManager.translate((float) x, (float) y + 1.0F, (float) z + 1.0F);
            GlStateManager.scale(0.9F, -0.9F, -0.9F);
            GlStateManager.translate(0.5F, -0.5F, 0.5F);
            if (i == 2) {
                short1 = 180;
            }

            if (i == 3) {
                short1 = 0;
            }

            if (i == 4) {
                short1 = 90;
            }

            if (i == 5) {
                short1 = -90;
            }
            GlStateManager.pushMatrix();
            GlStateManager.rotate((float) short1, 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(0F, -0.0625F, 0.2F);

            this.model_anu.renderBlock(0.0625F);
            GlStateManager.popMatrix();
            GlStateManager.popMatrix();
        }
    }

    public void renderItem(double x, double y, double z, int i) {

        if (i == 2) {
            GlStateManager.pushMatrix();
            float scale = 1F;
            key.hoverStart = 0.0F;
            RenderItem.renderInFrame = true;
            GlStateManager.translate((float) x + 0.5F, (float) y + 1.2F, (float) z);
            GlStateManager.scale(scale, scale, scale * 2F);
            GL11.glDisable(GL11.GL_CULL_FACE);
            RenderManager.instance.renderEntityWithPosYaw(key, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            GL11.glEnable(GL11.GL_CULL_FACE);
            RenderItem.renderInFrame = false;
            GlStateManager.popMatrix();
        }
        if (i == 3) {
            GlStateManager.pushMatrix();
            float scale = 1F;
            key.hoverStart = 0.0F;
            RenderItem.renderInFrame = true;
            GlStateManager.translate((float) x + 0.5F, (float) y + 1.2F, (float) z + 1F);
            GlStateManager.rotate(180, 0F, 1F, 0F);

            GlStateManager.scale(scale, scale, scale * 2F);
            GL11.glDisable(GL11.GL_CULL_FACE);
            RenderManager.instance.renderEntityWithPosYaw(key, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            GL11.glEnable(GL11.GL_CULL_FACE);
            RenderItem.renderInFrame = false;
            GlStateManager.popMatrix();
        }
        if (i == 4) {
            GlStateManager.pushMatrix();
            float scale = 1F;
            key.hoverStart = 0.0F;
            RenderItem.renderInFrame = true;
            GlStateManager.translate((float) x, (float) y + 1.2F, (float) z + 0.5F);
            GlStateManager.rotate((float) -90, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(180, 0F, 1F, 0F);
            GlStateManager.scale(scale, scale, scale * 2F);
            GL11.glDisable(GL11.GL_CULL_FACE);
            RenderManager.instance.renderEntityWithPosYaw(key, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            GL11.glEnable(GL11.GL_CULL_FACE);
            RenderItem.renderInFrame = false;
            GlStateManager.popMatrix();

        }
        if (i == 5) {
            GlStateManager.pushMatrix();
            float scale = 1F;
            key.hoverStart = 0.0F;
            RenderItem.renderInFrame = true;
            GlStateManager.translate((float) x + 1F, (float) y + 1.2F, (float) z + 0.5F);
            GlStateManager.rotate((float) 90, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(-180, 0F, 1F, 0F);
            GlStateManager.scale(scale, scale, scale * 2F);
            GL11.glDisable(GL11.GL_CULL_FACE);
            RenderManager.instance.renderEntityWithPosYaw(key, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            GL11.glEnable(GL11.GL_CULL_FACE);
            RenderItem.renderInFrame = false;
            GlStateManager.popMatrix();
        }

    }

    @Override
    public void renderTileEntityAt(TileEntity chest, double x, double y, double z, float i1) {
        this.renderTileEntityAt((TileEntitySarcophagus) chest, pos, i1);
    }
}