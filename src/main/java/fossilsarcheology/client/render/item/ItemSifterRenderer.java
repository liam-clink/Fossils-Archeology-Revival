package fossilsarcheology.client.render.item;

import fossilsarcheology.client.model.ModelSifter;
import fossilsarcheology.server.block.entity.TileEntitySifter;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemSifterRenderer implements IItemRenderer {
    TileEntitySpecialRenderer render;
    private ModelSifter modelsifter;

    public ItemSifterRenderer() {
        modelsifter = new ModelSifter();
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
        this.render.renderTileEntityAt(new TileEntitySifter(), 0.0D, 0.0D, 0.0D, 0.0F);
    }
}