package com.github.revival.common.item.blocks;

import com.github.revival.common.block.BlockFigurine;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockFigurine extends ItemBlockWithMetadata
{
    public ItemBlockFigurine(Block block)
    {
        super(block, block);
    }

    public String getUnlocalizedName(ItemStack itemstack)
    {
        return getUnlocalizedName() + "." + BlockFigurine.shortname[itemstack.getItemDamage()];
    }
}
