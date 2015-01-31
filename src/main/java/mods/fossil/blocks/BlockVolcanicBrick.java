package mods.fossil.blocks;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockVolcanicBrick extends Block
{
	public BlockVolcanicBrick()
	{
		super(Material.rock);
		setHardness(3.0F);
		setResistance(5.0F);
		setStepSound(Block.soundTypeStone);
		setBlockName(LocalizationStrings.VOLCANIC_BRICK_NAME);
		setCreativeTab(Fossil.tabFBlocks);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("fossil:Volcanic_Brick");
	}
}