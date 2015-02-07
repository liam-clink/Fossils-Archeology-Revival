package mods.fossil.blocks;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockFossilSkull extends BlockDirectional
{
	private boolean isLantern;
	private IIcon Front;
	private IIcon Back;

	public BlockFossilSkull(boolean isLantern)
	{
		super(Material.rock);
		setHardness(1.0F);
		setStepSound(Block.soundTypeStone);
		setCreativeTab(Fossil.tabFBlocks);
		//this.blockIndexInTexture = var2;
		this.setTickRandomly(true);
		this.isLantern = isLantern;
		if(isLantern) {
			setLightLevel(0.9375F);
			setBlockName(LocalizationStrings.SKULL_LANTERN_NAME);
		} else {
			setBlockName(LocalizationStrings.BLOCK_SKULL_NAME);
		}
	}
	/*public int getRenderType()
    {
    	return 2303;
    }*/

	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("fossil:Skull_Side");
		this.Front = this.isLantern ? par1IconRegister.registerIcon("fossil:Skull_Lantern_Front") : par1IconRegister.registerIcon("fossil:Skull_Front");
		this.Back = par1IconRegister.registerIcon("fossil:Skull_Back");//TODO: Bottom!
	}

	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public IIcon getIcon(int par1, int par2)
	{
		return par1 == 1 ? this.Back : (par1 == 0 ? this.blockIcon : (par1 != par2 ? this.blockIcon : this.Front));
	}

	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
		}

		if (l == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
		}

		if (l == 2)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
		}

		if (l == 3)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
		}
	}
}
