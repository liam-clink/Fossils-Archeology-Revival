package fossilsarcheology.server.item.block;

import fossilsarcheology.server.block.BlockVaseVolute;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockSpecial;
import net.minecraft.item.ItemStack;

public class VaseVoluteBlockItem extends ItemBlockSpecial {
    public VaseVoluteBlockItem(Block block) {
        super(block);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + BlockVaseVolute.NAMES[itemstack.getItemDamage()];
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }
}
