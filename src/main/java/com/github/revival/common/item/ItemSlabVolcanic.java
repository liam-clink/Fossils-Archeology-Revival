package com.github.revival.common.item;

import com.github.revival.common.block.FABlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabVolcanic extends ItemSlab
{

    public ItemSlabVolcanic(Block block)
    {
        super(block, (BlockSlab) FABlockRegistry.volcanicSingleSlab, (BlockSlab) FABlockRegistry.volcanicDoubleSlab, false);
    }
}
