package fossilsarcheology.server.item.block;

import fossilsarcheology.server.block.BlockVaseAmphora;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class VaseAmphoraBlockItem extends ItemBlock {
    public VaseAmphoraBlockItem(Block block) {
        super(block);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + BlockVaseAmphora.NAMES[itemstack.getItemDamage()];
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }
}
