package mods.fossil.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class BlockFigurineItem extends ItemBlockWithMetadata
{
	public BlockFigurineItem(Block block)
	{
		super(block, block);
		this.setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return getUnlocalizedName() + "." + BlockFigurine.shortname[itemstack.getItemDamage()];
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
}
