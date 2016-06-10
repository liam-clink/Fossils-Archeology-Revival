package com.github.revival.server.item;

import com.github.revival.server.block.FABlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class SlabAncientWoodItem extends ItemSlab {

    public SlabAncientWoodItem(Block block) {
        super(block, (BlockSlab) FABlockRegistry.INSTANCE.ancientWoodSingleSlab, (BlockSlab) FABlockRegistry.INSTANCE.ancientWoodDoubleSlab, false);
    }
}
