package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockPalaeSlab extends BlockSlab {
    public static final String[] VARIANTS = { "palae" };
    private boolean doubleSlab;

    public BlockPalaeSlab(boolean doubleSlabbed) {
        super(Material.WOOD);
        this.doubleSlab = doubleSlabbed;
        this.setLightOpacity(0);
        this.useNeighborBrightness = true;
        this.setHardness(1.4F);
        this.setResistance(7.5F);
        this.setSoundType(SoundType.WOOD);
        if (doubleSlabbed) {
            this.setUnlocalizedName(LocalizationStrings.PALAE_DOUBLESLAB_NAME);
        } else {
            this.setUnlocalizedName(LocalizationStrings.PALAE_SINGLESLAB_NAME);
            this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.palaeSingleSlab);
    }

    @Override
    protected ItemStack createStackedBlock(IBlockState state) {
        return new ItemStack(FABlockRegistry.INSTANCE.palaeSingleSlab, 2);
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> items) {
        if (item != Item.getItemFromBlock(FABlockRegistry.INSTANCE.palaeDoubleSlab)) {
            items.add(new ItemStack(item, 1, 0));
        }
    }

    @Override
    public String getUnlocalizedName(int meta) {
        if ((meta < 0) || (meta >= VARIANTS.length)) {
            meta = 0;
        }
        return super.getUnlocalizedName() + "." + VARIANTS[meta];
    }

    @Override
    public boolean isDouble() {
        return this.doubleSlab;
    }

    @Override
    public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        IBlockState state = super.onBlockPlaced(world, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        if (!this.isDouble()) {
            if ((facing == EnumFacing.UP || (double) hitY <= 0.5D) && facing != EnumFacing.DOWN) {
                return state;
            } else {
                return state.withProperty(HALF, BlockSlab.EnumBlockHalf.TOP);
            }
        }
        return state;
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return null;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return null;
    }
}
