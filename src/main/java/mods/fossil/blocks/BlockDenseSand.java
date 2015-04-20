package mods.fossil.blocks;

import java.util.Random;

import mods.fossil.Fossil;
import net.minecraft.block.BlockFalling;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockDenseSand extends BlockFalling
{
	public BlockDenseSand(){
		this.setHardness(3.0F);
		this.setResistance(15F);
		this.setBlockTextureName("fossil:dense_sand");
		this.setBlockName("denseSand");
		this.setStepSound(soundTypeSand);
		this.setCreativeTab(Fossil.tabFBlocks);
	}
}