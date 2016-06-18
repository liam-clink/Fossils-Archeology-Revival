package fossilsarcheology.server.item.block;

import fossilsarcheology.server.block.BlockFigurine;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class FigurineBlockItem extends ItemBlockWithMetadata {
    public FigurineBlockItem(Block block) {
        super(block, block);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + BlockFigurine.shortname[itemstack.getItemDamage()];
    }
}
