package mods.fossil.blocks;

import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.util.FossilFX;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;

public class BlockSarracenia extends BlockBush
{


	public BlockSarracenia()
	{
		super(Material.plants);
		this.setTickRandomly(true);
		this.setHardness(0.5F);
		this.setStepSound(Block.soundTypeGrass);
		this.setBlockName(LocalizationStrings.SARRACINA_NAME);
		this.setCreativeTab(Fossil.tabFBlocks);
	}

	public void randomDisplayTick(World world, int i, int j, int k, Random random)
	{
		FossilFX.spawnParticle("flies", i + 0.5, j + 1.0, k + 0.5, 0.0D, 1.5D, 0.0D);
		FossilFX.spawnParticle("flies", i + 0.5, j + 0.5, k, 0.0D, 1.5D, 0.0D);
		FossilFX.spawnParticle("flies", i, j + 0.5, k + 0.5, 0.0D, 1.5D, 0.0D);
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random var1)
	{
		return 1;
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IIconRegister)
	{
		this.blockIcon = par1IIconRegister.registerIcon("fossil:Sarracenia");
	}
}