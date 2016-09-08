package fossilsarcheology.server.item.block;

import fossilsarcheology.server.block.BlockFigurine;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class FigurineBlockItem extends ItemBlock {
    public FigurineBlockItem(Block block) {
        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + BlockFigurine.NAMES[itemstack.getItemDamage()];
    }
}
