package com.github.revival.common.item.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BlockAnubiteItem extends ItemBlock
{
    public BlockAnubiteItem(Block b)
    {
        super(b);
    }

    public EnumRarity getRarity(ItemStack item)
    {
        return EnumRarity.rare;
    }
}
