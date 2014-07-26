package mods.fossil.gens.structure;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class ComponentDigSite extends WorldGenerator
{
    int size = 15;

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        while (par1World.isAirBlock(par3, par4, par5) && par4 > 2)
        {
            --par4;
        }

        int l = Block.getIdFromBlock(par1World.getBlock(par3, par4, par5));

        if (l != Block.getIdFromBlock(Blocks.grass))
        {
            return false;
        }
        else
        {
            int i1;
            int j1;

            for (i1 = -2; i1 <= 2; ++i1)
            {
                for (j1 = -2; j1 <= 2; ++j1)
                {
                    if (par1World.isAirBlock(par3 + i1, par4 - 1, par5 + j1) && par1World.isAirBlock(par3 + i1, par4 - 2, par5 + j1))
                    {
                        return false;
                    }
                }
            }

            par1World.setBlock(par3, par4 + 1, par5, Blocks.fence, 1, 2);
            par1World.setBlock(par3 + size, par4 + 1, par5, Blocks.fence, 1, 2);
            par1World.setBlock(par3, par4 + 1, par5 + size, Blocks.fence, 1, 2);
            par1World.setBlock(par3 + size, par4 + 1, par5 + size, Blocks.fence, 1, 2);
            par1World.setBlock(par3, par4 + 2, par5, Blocks.fence, 1, 2);
            par1World.setBlock(par3 + size, par4 + 2, par5, Blocks.fence, 1, 2);
            par1World.setBlock(par3, par4 + 2, par5 + size, Blocks.fence, 1, 2);
            par1World.setBlock(par3 + size, par4 + 2, par5 + size, Blocks.fence, 1, 2);

            for (i1 = 1; i1 <= size - 1; ++i1)
            {
                par1World.setBlock(par3 + i1, par4 + 2, par5, Blocks.tripwire, 0, 2);
                par1World.setBlock(par3, par4 + 2, par5 + i1, Blocks.tripwire, 0, 2);
                par1World.setBlock(par3 + size, par4 + 2, par5 + i1, Blocks.tripwire, 0, 2);
                par1World.setBlock(par3 + i1, par4 + 2, par5 + size, Blocks.tripwire, 0, 2);
            }

            return true;
        }
    }
}
