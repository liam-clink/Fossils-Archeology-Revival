package com.github.revival.server.item;

import com.github.revival.server.block.FABlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class SlabPalaeItem extends ItemSlab {

    public SlabPalaeItem(Block block) {
        super(block, (BlockSlab) FABlockRegistry.palaeSingleSlab, (BlockSlab) FABlockRegistry.palaeDoubleSlab, false);
    }
}
