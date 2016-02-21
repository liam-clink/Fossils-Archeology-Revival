package com.github.revival.common.item;

import com.github.revival.common.block.FABlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabAncientStone extends ItemSlab {

    public ItemSlabAncientStone(Block block) {
        super(block, (BlockSlab) FABlockRegistry.ancientStoneSingleSlab, (BlockSlab) FABlockRegistry.ancientStoneDoubleSlab, false);
    }
}
