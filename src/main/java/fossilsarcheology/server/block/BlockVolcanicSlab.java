package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class BlockVolcanicSlab extends BlockSlab {
    public static final String[] blockStepTypes = { "volcanicBrick" };
    private IIcon theIcon;

    public BlockVolcanicSlab(boolean doubleSlabbed) {
        super(doubleSlabbed, Material.rock);
        this.setLightOpacity(0);
        this.useNeighborBrightness = true;
        setHardness(1.4F);
        setResistance(7.5F);
        setSoundType(Block.soundTypeStone);
        if (doubleSlabbed) {
            setUnlocalizedName(LocalizationStrings.VOLCANIC_DOUBLESLAB_NAME);
        } else {
            setUnlocalizedName(LocalizationStrings.VOLCANIC_SINGLESLAB_NAME);
            setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        }
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("fossil:Volcanic_Brick");
        this.theIcon = par1IconRegister.registerIcon("fossil:Volcanic_Brick");
    }

    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.volcanicSingleSlab);
    }

    @Override
    protected ItemStack createStackedBlock(int par1) {
        return new ItemStack(FABlockRegistry.INSTANCE.volcanicSingleSlab, 2, par1 & 7);
    }

    /**
     * Returns the slab block name with step type.
     */
    // 1.6.4 - getFullSlabName
    @Override
    public String func_150002_b(int par1) {
        if (par1 < 0 || par1 >= blockStepTypes.length) {
            par1 = 0;
        }

        return super.getUnlocalizedName() + "." + blockStepTypes[par1];
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
        if (par1 != Item.getItemFromBlock(FABlockRegistry.INSTANCE.volcanicDoubleSlab)) {
            par3List.add(new ItemStack(par1, 1, 0));
        }
    }
}
