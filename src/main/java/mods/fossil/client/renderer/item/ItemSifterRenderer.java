package mods.fossil.client.renderer.item;

import mods.fossil.client.model.ModelSifter;
import mods.fossil.guiBlocks.TileEntitySifter;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemSifterRenderer implements IItemRenderer
{
    private ModelSifter modelsifter;
    TileEntitySpecialRenderer render;

    public ItemSifterRenderer()
    {
    	modelsifter = new ModelSifter();
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
    	this.render.renderTileEntityAt(new TileEntitySifter(), 0.0D, 0.0D, 0.0D, 0.0F);
    }
}