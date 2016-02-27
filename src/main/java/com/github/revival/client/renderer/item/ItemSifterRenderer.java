package com.github.revival.client.renderer.item;

import com.github.revival.client.model.SifterModel;
import com.github.revival.server.block.entity.SifterTile;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemSifterRenderer implements IItemRenderer {
    TileEntitySpecialRenderer render;
    private SifterModel modelsifter;

    public ItemSifterRenderer() {
        modelsifter = new SifterModel();
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
        this.render.renderTileEntityAt(new SifterTile(), 0.0D, 0.0D, 0.0D, 0.0F);
    }
}