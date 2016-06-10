package com.github.revival.server.item;

import com.github.revival.server.block.FABlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class SlabVolcanicItem extends ItemSlab {

	public SlabVolcanicItem(Block block) {
		super(block, (BlockSlab) FABlockRegistry.INSTANCE.volcanicSingleSlab, (BlockSlab) FABlockRegistry.INSTANCE.volcanicDoubleSlab, false);
	}
}
