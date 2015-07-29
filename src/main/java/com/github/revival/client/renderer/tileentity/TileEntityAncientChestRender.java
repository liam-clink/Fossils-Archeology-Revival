package com.github.revival.client.renderer.tileentity;

import com.github.revival.common.item.FAItemRegistry;
import com.github.revival.common.tileentity.TileEntityAncientChest;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityAncientChestRender extends TileEntitySpecialRenderer
{
    private static final ResourceLocation texture = new ResourceLocation("fossil:textures/blocks/AncientChest.png");
    EntityItem key = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D, new ItemStack(FAItemRegistry.ancientKey));
    private ModelChest model = new ModelChest();

    public void renderTileEntityAt(TileEntityAncientChest chest, double x, double y, double z, float i1)
    {
        int i = 0;

        if (chest.hasWorldObj())
        {
            i = chest.getBlockMetadata();
        }

        this.bindTexture(texture);
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x, (float) y + 1.0F, (float) z + 1.0F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        short short1 = 0;
        if (i == 2)
        {
            short1 = 180;
        }

        if (i == 3)
        {
            short1 = 0;
        }

        if (i == 4)
        {
            short1 = 90;
        }

        if (i == 5)
        {
            short1 = -90;
        }
        GL11.glPushMatrix();
        GL11.glRotatef((float) short1, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        float f1;
        if (chest.chestLidCounter > 90)
        {
            f1 = chest.chestLidCounter2 + chest.chestLidCounter;
        }
        else
        {
            f1 = chest.chestLidCounter;
        }
        this.model.chestLid.rotateAngleX = -(float) Math.toRadians(f1);
        this.model.renderAll();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
        if (chest.chestState == 1)
        {
            this.renderItem(x, y, z, i);
        }
    }

    public void renderItem(double x, double y, double z, int i)
    {

        if (i == 2)
        {
            GL11.glPushMatrix();
            float scale = 1F;
            key.hoverStart = 0.0F;
            RenderItem.renderInFrame = true;
            GL11.glTranslatef((float) x + 0.5F, (float) y + 0.45F, (float) z - 0.3F);
            GL11.glRotatef((float) 180, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(90, 0F, 1F, 0F);
            GL11.glRotatef(45, 0F, 0F, -1F);
            GL11.glScalef(scale, scale, scale);
            GL11.glDisable(GL11.GL_CULL_FACE);
            RenderManager.instance.renderEntityWithPosYaw(key, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            GL11.glEnable(GL11.GL_CULL_FACE);
            RenderItem.renderInFrame = false;
            GL11.glPopMatrix();
        }
        if (i == 3)
        {
            GL11.glPushMatrix();
            float scale = 1F;
            key.hoverStart = 0.0F;
            RenderItem.renderInFrame = true;
            GL11.glTranslatef((float) x + 0.5F, (float) y + 0.45F, (float) z + 1.3F);
            GL11.glRotatef(90, 0F, 1F, 0F);
            GL11.glRotatef(45, 0F, 0F, -1F);
            GL11.glScalef(scale, scale, scale);
            GL11.glDisable(GL11.GL_CULL_FACE);
            RenderManager.instance.renderEntityWithPosYaw(key, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            GL11.glEnable(GL11.GL_CULL_FACE);
            RenderItem.renderInFrame = false;
            GL11.glPopMatrix();
        }
        if (i == 4)
        {
            GL11.glPushMatrix();
            float scale = 1F;
            key.hoverStart = 0.0F;
            RenderItem.renderInFrame = true;
            GL11.glTranslatef((float) x - 0.3F, (float) y + 0.45F, (float) z + 0.5F);
            GL11.glRotatef((float) -90, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(90, 0F, 1F, 0F);
            GL11.glRotatef(45, 0F, 0F, -1F);
            GL11.glScalef(scale, scale, scale);
            GL11.glDisable(GL11.GL_CULL_FACE);
            RenderManager.instance.renderEntityWithPosYaw(key, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            GL11.glEnable(GL11.GL_CULL_FACE);
            RenderItem.renderInFrame = false;
            GL11.glPopMatrix();

        }
        if (i == 5)
        {
            GL11.glPushMatrix();
            float scale = 1F;
            key.hoverStart = 0.0F;
            RenderItem.renderInFrame = true;
            GL11.glTranslatef((float) x + 1.3F, (float) y + 0.45F, (float) z + 0.5F);
            GL11.glRotatef((float) 90, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(90, 0F, 1F, 0F);
            GL11.glRotatef(45, 0F, 0F, -1F);
            GL11.glScalef(scale, scale, scale);
            GL11.glDisable(GL11.GL_CULL_FACE);
            RenderManager.instance.renderEntityWithPosYaw(key, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            GL11.glEnable(GL11.GL_CULL_FACE);
            RenderItem.renderInFrame = false;
            GL11.glPopMatrix();
        }

    }

    public void renderTileEntityAt(TileEntity chest, double x, double y, double z, float i1)
    {
        this.renderTileEntityAt((TileEntityAncientChest) chest, x, y, z, i1);
    }
}