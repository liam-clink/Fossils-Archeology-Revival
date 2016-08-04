package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class BlockAncientStoneSlab extends BlockSlab {
    public static final String[] blockStepTypes = { "ancientStone" };
    private IIcon icon;

    public BlockAncientStoneSlab(boolean doubleSlabbed) {
        super(doubleSlabbed, Material.ROCK);
        this.setLightOpacity(0);
        this.useNeighborBrightness = true;
        setHardness(1.4F);
        setResistance(7.5F);
        setSoundType(SoundType.WOOD);
        if (doubleSlabbed) {
            setUnlocalizedName(LocalizationStrings.ANCIENT_STONE_DOUBLESLAB_NAME);
        } else {
            setUnlocalizedName(LocalizationStrings.ANCIENT_STONE_SINGLESLAB_NAME);
            setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        }
    }

    @Override
    public Item getItemDropped(int var1, Random rand, int var3) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.ancientStoneSingleSlab);
    }

    @Override
    protected ItemStack createStackedBlock(int meta) {
        return new ItemStack(FABlockRegistry.INSTANCE.ancientStoneSingleSlab, 2, meta & 7);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, BlockPos pos) {
        return Item.getItemFromBlock(this);
    }

    /**
     * Returns the slab block name with step type.
     */
    // 1.6.4 - getFullSlabName
    @Override
    public String func_150002_b(int meta) {
        if (meta < 0 || meta >= blockStepTypes.length) {
            meta = 0;
        }

        return super.getUnlocalizedName() + "." + blockStepTypes[meta];
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood
     * returns 4 blocks)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List subBlocks) {
        if (item != Item.getItemFromBlock(FABlockRegistry.INSTANCE.ancientStoneDoubleSlab)) {
            subBlocks.add(new ItemStack(item, 1, 0));
        }
    }

}
