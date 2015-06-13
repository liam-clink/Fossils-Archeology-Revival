package com.github.revival.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class BlockVaseVoluteItem extends ItemBlockWithMetadata
{
    private Block itemBlock;

    public BlockVaseVoluteItem(Block block)
    {
        super(block, block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        return getUnlocalizedName() + "." + BlockVaseVolute.shortname[itemstack.getItemDamage()];

    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }
}
