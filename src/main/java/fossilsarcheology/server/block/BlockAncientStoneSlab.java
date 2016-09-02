package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class BlockAncientStoneSlab extends BlockSlab {
    public static final String[] STEP_TYPES = { "ancientStone" };

    private boolean doubleSlabbed;

    public BlockAncientStoneSlab(boolean doubleSlabbed) {
        super(Material.ROCK);
        this.doubleSlabbed = doubleSlabbed;
        this.setLightOpacity(0);
        this.useNeighborBrightness = true;
        this.setHardness(1.4F);
        this.setResistance(7.5F);
        this.setSoundType(SoundType.WOOD);
        if (doubleSlabbed) {
            this.setUnlocalizedName(LocalizationStrings.ANCIENT_STONE_DOUBLESLAB_NAME);
        } else {
            this.setUnlocalizedName(LocalizationStrings.ANCIENT_STONE_SINGLESLAB_NAME);
            this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        }
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
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.ancientStoneSingleSlab);
    }

    @Override
    public String getUnlocalizedName(int meta) {
        if (meta < 0 || meta >= STEP_TYPES.length) {
            meta = 0;
        }
        return super.getUnlocalizedName() + "." + STEP_TYPES[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List subBlocks) {
        if (item != Item.getItemFromBlock(FABlockRegistry.INSTANCE.ancientStoneDoubleSlab)) {
            subBlocks.add(new ItemStack(item, 1, 0));
        }
    }

    @Override
    public boolean isDouble() {
        return this.doubleSlabbed;
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
