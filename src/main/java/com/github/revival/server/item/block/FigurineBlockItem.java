package com.github.revival.server.item.block;

import com.github.revival.server.block.FigurineBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class FigurineBlockItem extends ItemBlockWithMetadata {
    public FigurineBlockItem(Block block) {
        super(block, block);
    }

    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + FigurineBlock.shortname[itemstack.getItemDamage()];
    }
}
