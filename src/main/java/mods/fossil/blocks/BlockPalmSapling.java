package mods.fossil.blocks;

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

        if ((world.getBlockLightValue(i, j + 1, k) >= 9) && (random.nextInt(30) == 0))
        {
            int l = world.getBlockMetadata(i, j, k);

            if (random.nextInt(3) == 0)
            {
                generateTree(world, i, j, k, random, l);
            }
        }
    }

    public void generateTree(World world, int i, int j, int k, Random random, int l)
    {
        world.setBlock(i, j, k, Blocks.air, 0, l);
        WorldGenPalaeoraphe w0 = new WorldGenPalaeoraphe();
        Block j1 = world.getBlock(i, j - 1, k);

        if ((j1 == Blocks.grass || j1 == Blocks.dirt) && j < 128 - 12 - 1)
        {
            w0.generate(world, random, i, j, k);
            world.setBlock(i, j, k, Fossil.palmLog);
        }
    }

	@Override
	public boolean func_149851_a(World var1, int var2, int var3, int var4,
			boolean var5) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean func_149852_a(World var1, Random var2, int var3, int var4,
			int var5) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void func_149853_b(World var1, Random var2, int var3, int var4,
			int var5) {
		// TODO Auto-generated method stub
		
	}
}
