package mods.fossil.blocks;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;

import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.gens.WorldGenPalaeoraphe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockPalmSapling extends BlockBush implements IGrowable
{
	public static final String[] WOOD_TYPES = new String[] {"palmSapling"};

	public BlockPalmSapling()
	{
		super();
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(Fossil.tabFBlocks);
		this.setStepSound(Block.soundTypeGrass);
		this.setHardness(0.2F);
		this.setResistance(1F);
		this.setBlockName(LocalizationStrings.PALAE_SAP_NAME);
	}

	/**
	 * When this method is called, your block should register all the icons it needs with the given IIconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerBlockIcons(IIconRegister var1)
	{
		this.blockIcon = var1.registerIcon("fossil:Palae_Sapling");
	}

	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public IIcon getIcon(int var1, int var2)
	{
		return this.blockIcon;
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World world, int i, int j, int k, Random random)
	{
		super.updateTick(world, i, j, k, random);

		if (((world.getBlockLightValue(i, j + 1, k) >= 9) && (random.nextInt(30) == 0)))
		{
			int y;
			if (random.nextInt(3) == 0)
			{
				generateTree(world, i, j, k, random);
			}
		}
	}
	public boolean canGenerate(World world, int x, int y, int z){
		int i;
		for(i = 0; i< 13; i++){
			if(world.getBlock(x, y + i, z).isOpaqueCube()){
				return true;
			}
		}
		return false;
	}
	public void generateTree(World world, int i, int j, int k, Random random)
	{
		WorldGenPalaeoraphe w0 = new WorldGenPalaeoraphe();
		Block j1 = world.getBlock(i, j - 1, k);

		if (!canGenerate(world, i, j, k) && (j1 == Blocks.grass || j1 == Blocks.dirt) && j < 128 - 12 - 1)
		{
			w0.generate(world, random, i, j, k);
			world.setBlock(i, j, k, Fossil.palmLog);
		}
	}
    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
    {
        return true;
    }
    public void func_149879_c(World p_149879_1_, int p_149879_2_, int p_149879_3_, int p_149879_4_, Random p_149879_5_)
    {
          this.generateTree(p_149879_1_, p_149879_2_, p_149879_3_, p_149879_4_, p_149879_5_);
    }
    public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_)
    {
        return (double)p_149852_1_.rand.nextFloat() < 0.45D;
    }

    public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_)
    {
        this.func_149879_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, p_149853_2_);
    }
}
