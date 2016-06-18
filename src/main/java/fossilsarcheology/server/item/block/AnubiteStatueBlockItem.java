package fossilsarcheology.server.item.block;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class AnubiteStatueBlockItem extends ItemBlock {
    public AnubiteStatueBlockItem(Block b) {
        super(b);
    }

    @Override
    public EnumRarity getRarity(ItemStack item) {
        return EnumRarity.rare;
    }
}
