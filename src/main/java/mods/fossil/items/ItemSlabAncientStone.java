package mods.fossil.items;

import mods.fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabAncientStone extends ItemSlab{
	
	public ItemSlabAncientStone(Block block) {
		super(block, (BlockSlab) Fossil.ancientStoneSingleSlab, (BlockSlab) Fossil.ancientStoneDoubleSlab, false);
	}
}
