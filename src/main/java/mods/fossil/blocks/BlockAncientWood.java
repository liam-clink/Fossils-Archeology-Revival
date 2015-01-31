package mods.fossil.blocks;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockAncientWood extends Block
{
	public BlockAncientWood()
	{
		super(Material.wood);
		this.setCreativeTab(Fossil.tabFBlocks);
		setHardness(2.0F);
		setBlockName(LocalizationStrings.ANCIENT_WOOD_NAME);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("fossil:Ancient_Wood");
	}
}
