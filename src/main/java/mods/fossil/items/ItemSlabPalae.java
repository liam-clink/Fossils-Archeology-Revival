package mods.fossil.items;

import mods.fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabPalae extends ItemSlab{
	
	public ItemSlabPalae(Block block) {
		super(block, (BlockSlab) Fossil.palaeSingleSlab, (BlockSlab) Fossil.palaeDoubleSlab, false);
	}
}
