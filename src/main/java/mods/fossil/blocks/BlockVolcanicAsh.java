package mods.fossil.blocks;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockVolcanicAsh extends Block
{
	public BlockVolcanicAsh()
	{
		super(Material.cloth);
		this.blockParticleGravity = -0.15F;
		setHardness(0.2F);
		setStepSound(Block.soundTypeGrass);
		setBlockName(LocalizationStrings.VOLCANIC_ASH_NAME);
		setCreativeTab(Fossil.tabFBlocks);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("fossil:Volcanic_Ash");
	}
}