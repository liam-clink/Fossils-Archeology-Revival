package com.github.revival.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class BlockVaseKylixItem extends ItemBlockWithMetadata
{
    private Block itemBlock;

    public BlockVaseKylixItem(Block block)
    {
        super(block, block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        return getUnlocalizedName() + "." + BlockVaseKylix.shortname[itemstack.getItemDamage()];

    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }
}
