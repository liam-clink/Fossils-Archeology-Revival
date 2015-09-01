package com.github.revival.common.item.blocks;

import com.github.revival.common.block.BlockVaseAmphora;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockVaseAmphora extends ItemBlockWithMetadata
{
    public ItemBlockVaseAmphora(Block block)
    {
        super(block, block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        return getUnlocalizedName() + "." + BlockVaseAmphora.shortname[itemstack.getItemDamage()];
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }
}
