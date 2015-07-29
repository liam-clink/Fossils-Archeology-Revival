package com.github.revival.common.item;

import com.github.revival.common.block.FABlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabAncientWood extends ItemSlab
{

    public ItemSlabAncientWood(Block block)
    {
        super(block, (BlockSlab) FABlockRegistry.ancientWoodSingleSlab, (BlockSlab) FABlockRegistry.ancientWoodDoubleSlab, false);
    }
}
