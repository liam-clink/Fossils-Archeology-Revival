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
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAncientStoneSlab extends BlockSlab
{
    public static final String[] blockStepTypes = { "ancientStone" };
    private IIcon theIcon;

    public BlockAncientStoneSlab(boolean par2)
    {
        super(par2, Material.rock);
        this.setLightOpacity(0);
        this.useNeighborBrightness = true;
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("fossil:Ancient_Stonebricks");
        this.theIcon = par1IconRegister.registerIcon("fossil:Ancient_Stonebricks");
    }

    public Item getItemDropped(int var1, Random var2, int var3)
    {
        return Item.getItemFromBlock(Fossil.ancientStoneSingleSlab);
    }

    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(Fossil.ancientStoneSingleSlab, 2, par1 & 7);
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

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        if (par1 != Item.getItemFromBlock(Fossil.ancientStoneDoubleSlab))
        {
            par3List.add(new ItemStack(par1, 1, 0));
        }
    }

}
