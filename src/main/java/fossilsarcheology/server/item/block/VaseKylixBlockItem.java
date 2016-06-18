package fossilsarcheology.server.item.block;

import fossilsarcheology.server.block.BlockVaseKylix;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class VaseKylixBlockItem extends ItemBlockWithMetadata {
    public VaseKylixBlockItem(Block block) {
        super(block, block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + BlockVaseKylix.shortname[itemstack.getItemDamage()];
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }
}
