package fossilsarcheology.server.block;

import net.minecraft.item.ItemBlock;

public interface IBlockItem {
    Class<? extends ItemBlock> getItemBlockClass();
}
