package fossilsarcheology.server.block;

import fossilsarcheology.server.block.entity.TileEntityFigurine;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.block.FigurineBlockItem;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockFigurine extends BlockContainer implements IBlockItem {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final String[] NAMES = { "figurine_steve_pristine", "figurine_skeleton_pristine", "figurine_zombie_pristine", "figurine_pigzombie_pristine", "figurine_enderman_pristine", "figurine_steve_damaged", "figurine_skeleton_damaged", "figurine_zombie_damaged", "figurine_pigzombie_damaged", "figurine_enderman_damaged", "figurine_steve_broken", "figurine_skeleton_broken", "figurine_zombie_broken", "figurine_pigzombie_broken", "figurine_enderman_broken", "figurine_mysterious", };
    private static final AxisAlignedBB BOUNDS = new AxisAlignedBB(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);

    public BlockFigurine() {
        super(Material.WOOD);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setUnlocalizedName(LocalizationStrings.FIGURINE_NAME);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDS;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> subBlocks) {
        for (int i = 0; i < 16; ++i) {
            subBlocks.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean canProvidePower(IBlockState state) {
        return true;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).ordinal();
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntityFigurine();
    }

    @Override
    public Class<? extends ItemBlock> getItemBlockClass() {
        return FigurineBlockItem.class;
    }
}
