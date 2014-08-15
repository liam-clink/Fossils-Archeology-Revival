package mods.fossil.items;

import mods.fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabVolcanic extends ItemSlab{
	
	public ItemSlabVolcanic(Block block) {
		super(block, Fossil.volcanicSingleSlab, Fossil.volcanicDoubleSlab, false);
	}
}
