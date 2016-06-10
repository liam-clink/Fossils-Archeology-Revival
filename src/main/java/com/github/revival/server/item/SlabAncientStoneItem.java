package com.github.revival.server.item;

import com.github.revival.server.block.FABlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class SlabAncientStoneItem extends ItemSlab {

    public SlabAncientStoneItem(Block block) {
        super(block, (BlockSlab) FABlockRegistry.INSTANCE.ancientStoneSingleSlab, (BlockSlab) FABlockRegistry.INSTANCE.ancientStoneDoubleSlab, false);
    }
}
