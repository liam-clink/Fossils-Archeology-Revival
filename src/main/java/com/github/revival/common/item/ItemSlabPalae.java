package com.github.revival.common.item;

import com.github.revival.common.block.FABlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabPalae extends ItemSlab {

    public ItemSlabPalae(Block block) {
        super(block, (BlockSlab) FABlockRegistry.palaeSingleSlab, (BlockSlab) FABlockRegistry.palaeDoubleSlab, false);
    }
}
