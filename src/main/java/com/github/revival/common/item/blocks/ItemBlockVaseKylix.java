package com.github.revival.common.item.blocks;

import com.github.revival.common.block.BlockVaseKylix;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockVaseKylix extends ItemBlockWithMetadata {
    public ItemBlockVaseKylix(Block block) {
        super(block, block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + BlockVaseKylix.shortname[itemstack.getItemDamage()];
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }
}
