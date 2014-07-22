package mods.fossil.blocks;

import java.util.List;
import java.util.Random;

import mods.fossil.Fossil;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockVolcanicSlab extends BlockSlab
{
    public static final String[] blockStepTypes = { "volcanicBrick" };
    private IIcon theIcon;

    public BlockVolcanicSlab(boolean par2)
    {
        super(par2, Material.rock);
        this.setLightOpacity(0);
        this.useNeighborBrightness = true;
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("fossil:Volcanic_Brick");
        this.theIcon = par1IconRegister.registerIcon("fossil:Volcanic_Brick");
    }

    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return Item.getItemFromBlock(Fossil.volcanicSingleSlab);
    }

    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(Fossil.volcanicSingleSlab, 2, par1 & 7);
    }

    /**
     * Returns the slab block name with step type.
     */
    // 1.6.4 - getFullSlabName
    @Override
    public String func_150002_b(int par1)
    {
        if (par1 < 0 || par1 >= blockStepTypes.length)
        {
            par1 = 0;
        }

        return super.getUnlocalizedName() + "." + blockStepTypes[par1];
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        if (par1 != Item.getItemFromBlock(Fossil.volcanicDoubleSlab))
        {
            par3List.add(new ItemStack(par1, 1, 0));
        }
    }
}
