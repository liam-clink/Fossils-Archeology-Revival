package com.github.revival.client.renderer.item;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemRenderTileEntity implements IItemRenderer
{
    TileEntitySpecialRenderer render;
    private TileEntity entity;

    public ItemRenderTileEntity(TileEntitySpecialRenderer render, TileEntity entity)
    {
        this.entity = entity;
        this.render = render;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        if (type == IItemRenderer.ItemRenderType.ENTITY)
        {
            GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
        }
        GL11.glTranslatef(0, -0.1F, 0);
        GL11.glPushMatrix();
        this.render.renderTileEntityAt(this.entity, 0.0D, 0.0D, 0.0D, 0.0F);
        GL11.glPopMatrix();

    }
}