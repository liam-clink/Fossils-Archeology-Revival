package com.github.revival.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BlockAnuItem extends ItemBlock
{

    public BlockAnuItem(Block block)
    {
        super(block);
    }

    public EnumRarity getRarity(ItemStack item)
    {
        return EnumRarity.epic;
    }
}
