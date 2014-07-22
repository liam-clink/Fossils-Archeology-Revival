/*package mods.fossil.gens;

import java.util.Random;

import mods.fossil.Fossil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenVolcanicRock extends WorldGenerator
{
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        for (int l = 0; l < 2; l++)
        {
            int i1 = par3 + par2Random.nextInt(4);
            int j1 = par4;
            int k1 = par5 + par2Random.nextInt(4);

            if (par1World.isAirBlock(i1, par4, k1) && (par1World.getBlockMaterial(i1 - 1, par4 - 1, k1) == Material.lava || par1World.getBlockMaterial(i1 + 1, par4 - 1, k1) == Material.lava || par1World.getBlockMaterial(i1, par4 - 1, k1 - 1) == Material.lava || par1World.getBlockMaterial(i1, par4 - 1, k1 + 1) == Material.lava))
            {
                for (int x = 0;x<2;x++)
                {
                    if (par1World.getBlock(i1, j1 - 1, k1) == Blocks.dirt || par1World.getBlock(i1, j1 - 1, k1) == Blocks.stone || par1World.getBlock(i1, j1 - 1, k1) == Blocks.sand)
                    {
                        par1World.setBlock(i1, j1 - 1, k1, Fossil.volcanicAsh, 0, 2);
                        par1World.setBlock(i1, j1 - 1, k1 + 1, Fossil.volcanicRock.blockID, 0, 2);
                        par1World.setBlock(i1 + 1, j1 - 1, k1, Fossil.volcanicRock.blockID, 0, 2);
                    }
                }
            }
        }

        return true;
    }
}*/