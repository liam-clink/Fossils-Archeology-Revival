package mods.fossil.blocks;

import java.util.List;
import java.util.Random;

import mods.fossil.Fossil;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockPalaeSlab extends BlockSlab
{
    public static final String[] woodType = { "palae" };

    public BlockPalaeSlab(boolean par2)
    {
        super(par2, Material.wood);
        this.setLightOpacity(0);
        this.useNeighborBrightness = true;
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("fossil:Palae_Planks");
    }

    public Item getItemDropped(int var1, Random var2, int var3)
    {
        return Item.getItemFromBlock(Fossil.palaeSingleSlab);
    }

    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
        if (par1World.getBlock(par2, par3 - 1, par4) == Fossil.palaeSingleSlab)
        {
            par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
            par1World.setBlock(par2, par3 - 1, par4, Fossil.palaeDoubleSlab);
        }

        if (par1World.getBlock(par2, par3 + 1, par4) == Fossil.palaeSingleSlab)
        {
            par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
            par1World.setBlock(par2, par3 + 1, par4, Fossil.palaeDoubleSlab);
        }
    }

    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(Fossil.palaeSingleSlab, 2, par1 & 7);
    }

    public String func_150002_b(int par1)
    {
        if ((par1 < 0) || (par1 >= woodType.length))
        {
            par1 = 0;
        }

        return super.getUnlocalizedName() + "." + woodType[par1];
    }

    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        if (par1 != Item.getItemFromBlock(Fossil.palaeDoubleSlab))
        {
            par3List.add(new ItemStack(par1, 1, 0));
        }
    }
}
