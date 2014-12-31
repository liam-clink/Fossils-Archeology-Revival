package mods.fossil.blocks;

import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockAmberOre extends Block
{
	public BlockAmberOre()
	{
		super(Material.rock);
		this.setCreativeTab(Fossil.tabFBlocks);
		setHardness(3.0F);
		setBlockName(LocalizationStrings.AMBER_ORE_NAME);
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public Item getItemDropped(int var1, Random var2, int var3)
	{
		return this == Fossil.amberOre ? Fossil.amber : Item.getItemFromBlock(this);
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random)
	{
		return this == Fossil.amberOre ? 2 + par1Random.nextInt(2) : 1;
	}

	/**
	 * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
	 */
	public int quantityDroppedWithBonus(int par1, Random par2Random)
	{
		if (par1 > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, par2Random, par1))
		{
			int j = par2Random.nextInt(par1 + 1) - 1;

			if (j < 0)
			{
				j = 0;
			}

			return this.quantityDropped(par2Random) * (j + 1);
		}
		else
		{
			return this.quantityDropped(par2Random);
		}
	}

	/**
	 * Drops the block items with a specified chance of dropping the specified items
	 */
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
	{
		super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

		if (this.getItemDropped(par5, par1World.rand, par7) != Item.getItemFromBlock(this))
		{
			int j1 = 0;

			if (this == Fossil.amberOre)
			{
				j1 = 1;
			}

			this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
		}
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and wood.
	 */
	public int damageDropped(int par1)
	{
		return this == Fossil.amberOre ? 4 : 0;
	}

	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("fossil:Amber_Ore");
	}
}
