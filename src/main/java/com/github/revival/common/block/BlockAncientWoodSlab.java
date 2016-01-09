package com.github.revival.common.block;

import com.github.revival.common.creativetab.FATabRegistry;
import com.github.revival.common.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockAncientWoodSlab extends BlockSlab
{
    public static final String[] woodType = {"ancientWood"};

    public BlockAncientWoodSlab(boolean doubleSlabbed)
    {
        super(doubleSlabbed, Material.wood);
        setLightOpacity(0);
        useNeighborBrightness = true;
        setHardness(1.4F);
        setResistance(7.5F);
        setStepSound(Block.soundTypeWood);
        if (doubleSlabbed)
        {
            setBlockName(LocalizationStrings.ANCIENT_WOOD_DOUBLESLAB_NAME);
        }
        else
        {
            setBlockName(LocalizationStrings.ANCIENT_WOOD_SINGLESLAB_NAME);
            setCreativeTab(FATabRegistry.tabFBlocks);
        }
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("fossil:Ancient_Wood");
    }

    public Item getItemDropped(int var1, Random var2, int var3)
    {
        return Item.getItemFromBlock(FABlockRegistry.ancientWoodSingleSlab);
    }

    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
        if (par1World.getBlock(par2, par3 - 1, par4) == FABlockRegistry.ancientWoodSingleSlab)
        {
            par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
            par1World.setBlock(par2, par3 - 1, par4, FABlockRegistry.ancientWoodDoubleSlab);
        }

        if (par1World.getBlock(par2, par3 + 1, par4) == FABlockRegistry.ancientWoodSingleSlab)
        {
            par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
            par1World.setBlock(par2, par3 + 1, par4, FABlockRegistry.ancientWoodDoubleSlab);
        }
    }

    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(FABlockRegistry.ancientWoodSingleSlab, 2, par1 & 7);
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
        if (par1 != Item.getItemFromBlock(FABlockRegistry.ancientWoodDoubleSlab))
        {
            par3List.add(new ItemStack(par1, 1, 0));
        }
    }
}
