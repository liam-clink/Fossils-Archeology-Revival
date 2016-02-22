package com.github.revival.client.renderer.item;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemRenderAnubite implements IItemRenderer {
    TileEntitySpecialRenderer render;
    private TileEntity entity;

    public ItemRenderAnubite(TileEntitySpecialRenderer render, TileEntity entity) {
        this.entity = entity;
        this.render = render;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        if (type == IItemRenderer.ItemRenderType.ENTITY) {
            GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
        }
        if (type == IItemRenderer.ItemRenderType.INVENTORY) {
            GL11.glTranslatef(0, -1F, 0);
            GL11.glScalef(0.6F, 0.6F, 0.6F);
            GL11.glRotatef(-180F, 0, 1, 0);
        }
        float rot = 0;
        GL11.glPushMatrix();
        GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        this.render.renderTileEntityAt(this.entity, 0.0D, 0.0D, 0.0D, 0.0F);
        GL11.glPopAttrib();
        GL11.glPopMatrix();

    }
}