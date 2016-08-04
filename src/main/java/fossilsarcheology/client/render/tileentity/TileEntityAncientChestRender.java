package fossilsarcheology.client.render.tileentity;

import fossilsarcheology.server.block.entity.TileEntityAncientChest;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelChest;
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
public class TileEntityAncientChestRender extends TileEntitySpecialRenderer {
    private static final ResourceLocation texture = new ResourceLocation("fossil:textures/blocks/AncientChest.png");
    EntityItem key = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D, new ItemStack(FAItemRegistry.INSTANCE.ancientKey));
    private ModelChest model = new ModelChest();

    public void renderTileEntityAt(TileEntityAncientChest chest, double x, double y, double z, float i1) {
        int i = 0;

        if (chest.hasWorldObj()) {
            i = chest.getBlockMetadata();
        }

        this.bindTexture(texture);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x, (float) y + 1.0F, (float) z + 1.0F);
        GlStateManager.scale(1.0F, -1.0F, -1.0F);
        GlStateManager.translate(0.5F, 0.5F, 0.5F);
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
        GlStateManager.translate(-0.5F, -0.5F, -0.5F);
        float f1;
        if (chest.chestLidCounter > 90) {
            f1 = chest.chestLidCounter2 + chest.chestLidCounter;
        } else {
            f1 = chest.chestLidCounter;
        }
        this.model.chestLid.rotateAngleX = -(float) Math.toRadians(f1);
        this.model.renderAll();
        GlStateManager.popMatrix();
        GlStateManager.popMatrix();
        if (chest.chestState == 1) {
            this.renderItem(pos, i);
        }
    }

    public void renderItem(double x, double y, double z, int i) {

        if (i == 2) {
            GlStateManager.pushMatrix();
            float scale = 1F;
            key.hoverStart = 0.0F;
            RenderItem.renderInFrame = true;
            GlStateManager.translate((float) x + 0.5F, (float) y + 0.45F, (float) z - 0.3F);
            GlStateManager.rotate((float) 180, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(90, 0F, 1F, 0F);
            GlStateManager.rotate(45, 0F, 0F, -1F);
            GlStateManager.scale(scale, scale, scale);
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
            GlStateManager.translate((float) x + 0.5F, (float) y + 0.45F, (float) z + 1.3F);
            GlStateManager.rotate(90, 0F, 1F, 0F);
            GlStateManager.rotate(45, 0F, 0F, -1F);
            GlStateManager.scale(scale, scale, scale);
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
            GlStateManager.translate((float) x - 0.3F, (float) y + 0.45F, (float) z + 0.5F);
            GlStateManager.rotate((float) -90, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(90, 0F, 1F, 0F);
            GlStateManager.rotate(45, 0F, 0F, -1F);
            GlStateManager.scale(scale, scale, scale);
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
            GlStateManager.translate((float) x + 1.3F, (float) y + 0.45F, (float) z + 0.5F);
            GlStateManager.rotate((float) 90, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(90, 0F, 1F, 0F);
            GlStateManager.rotate(45, 0F, 0F, -1F);
            GlStateManager.scale(scale, scale, scale);
            GL11.glDisable(GL11.GL_CULL_FACE);
            RenderManager.instance.renderEntityWithPosYaw(key, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            GL11.glEnable(GL11.GL_CULL_FACE);
            RenderItem.renderInFrame = false;
            GlStateManager.popMatrix();
        }

    }

    @Override
    public void renderTileEntityAt(TileEntity chest, double x, double y, double z, float i1) {
        this.renderTileEntityAt((TileEntityAncientChest) chest, pos, i1);
    }
}