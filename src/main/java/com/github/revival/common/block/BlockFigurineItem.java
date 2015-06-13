package com.github.revival.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class BlockFigurineItem extends ItemBlockWithMetadata
{
    public BlockFigurineItem(Block block)
    {
        super(block, block);
    }

    public String getUnlocalizedName(ItemStack itemstack)
    {
        return getUnlocalizedName() + "." + BlockFigurine.shortname[itemstack.getItemDamage()];
    }
}
