package mods.fossil.items;

import mods.fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabAncientWood extends ItemSlab{
	
	public ItemSlabAncientWood(Block block) {
		super(block, Fossil.ancientWoodSingleSlab, Fossil.ancientWoodDoubleSlab, false);
	}
}
