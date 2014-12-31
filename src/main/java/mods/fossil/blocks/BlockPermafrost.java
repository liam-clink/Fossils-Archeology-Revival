package mods.fossil.blocks;

import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPermafrost extends BlockBreakable
{
	public BlockPermafrost()
	{
		super("Permafrost", Material.ice, false);
		this.setTickRandomly(true);
		this.setHarvestLevel("shovel", 2);
		setHardness(0.5F);
		setLightOpacity(3);
		setStepSound(Block.soundTypeGrass);
		setBlockName(LocalizationStrings.BLOCK_PERMAFROST_NAME);
		setCreativeTab(Fossil.tabFBlocks);
	}

	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	public int getRenderBlockPass()
	{
		return 1;
	}

	/**
	 * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
	 * coordinates.  Args: blockAccess, x, y, z, side
	 */
	public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5)
	{
		return super.shouldSideBeRendered(var1, var2, var3, var4, 1 - var5);
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World var1, int var2, int var3, int var4, Random var5)
	{
		if (var1.getSavedLightValue(EnumSkyBlock.Block, var2, var3, var4) <= 11 - this.lightOpacity && (!var1.canBlockSeeTheSky(var2, var3 + 1, var4) || !var1.isDaytime()))
		{
			int var6 = 0;

			while (var6 < 5)
			{
				int var7 = (new Random()).nextInt(3) - 1;
				int var8 = (new Random()).nextInt(3) - 1;
				int var9 = (new Random()).nextInt(3) - 1;

				if (var1.getBlock(var2 + var7, var3 + var8, var4 + var9) != Blocks.flowing_water && var1.getBlock(var2 + var7, var3 + var8, var4 + var9) != Blocks.water)
				{
					if (var1.getBlock(var2 + var7, var3 + var8, var4 + var9) != Blocks.flowing_lava && var1.getBlock(var2 + var7, var3 + var8, var4 + var9) != Blocks.lava && var1.getBlock(var2 + var7, var3 + var8, var4 + var9) != Blocks.fire)
					{
						++var6;
						continue;
					}

					var1.setBlock(var2, var3, var4, Blocks.stone, 0, 2);
					return;
				}

				var1.setBlock(var2 + var7, var3 + var8, var4 + var9, Blocks.ice, 0, 2);
				return;
			}
		}
		else
		{
			var1.setBlock(var2, var3, var4, Blocks.dirt, 0, 2);
		}
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public Item getItemDropped(int var1, Random var2, int var3)
	{
		int var4 = (new Random()).nextInt(20000);
		return var4 >= 0 && var4 < 4000 ? Fossil.fernSeed : (var4 >= 4000 && var4 < 8000 ? Item.getItemFromBlock(Fossil.blockSkull) : (var4 >= 8000 && var4 < 12000 ? Fossil.icedMeat : (var4 >= 12000 && var4 < 16000 ? Items.bone : (var4 >= 16000 && var4 < 20000 ? Items.book : Item.getItemFromBlock(Blocks.dirt)))));
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("fossil:Permafrost");
	}
}