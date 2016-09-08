package fossilsarcheology.server.block;

import fossilsarcheology.server.block.entity.TileEntityVase;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.block.VaseAmphoraBlockItem;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
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

public class BlockVaseAmphora extends BlockContainer implements IBlockItem {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final String[] NAMES = { "damaged_amphora", "restored_amphora", "redFigure_amphora", "blackFigure_amphora", "porcelain_amphora", };

    private static final AxisAlignedBB BOUNDS = new AxisAlignedBB(0.15F, 0.0F, 0.15F, 0.85F, 1.3F, 0.85F);

    private int dropMeta;

    public BlockVaseAmphora() {
        super(Material.CLAY);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setUnlocalizedName(LocalizationStrings.VASE_AMPHORA);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> subBlocks) {
        for (int i = 0; i < NAMES.length; ++i) {
            subBlocks.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDS;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(world, pos, state, placer, stack);
        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof TileEntityVase) {
            TileEntityVase vase = (TileEntityVase) tile;
            vase.setVaseTypeMeta(stack.getItemDamage());
            vase.setVaseType(1);
            vase.setVaseRotation(1);
        }
    }

    @Override
    public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase entity) {
        return super.onBlockPlaced(world, pos, facing, hitX, hitY, hitZ, meta, entity).withProperty(FACING, EnumFacing.fromAngle(entity.rotationYaw));
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        this.dropMeta = this.getMeta(world, pos);
        super.breakBlock(world, pos, state);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityVase();
    }

    @Override
    public int damageDropped(IBlockState meta) {
        return this.dropMeta;
    }

    @Override
    public Class<? extends ItemBlock> getItemBlockClass() {
        return VaseAmphoraBlockItem.class;
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

    private int getMeta(World world, BlockPos pos) {
        TileEntity tile = world.getTileEntity(pos);
        return tile instanceof TileEntityVase ? ((TileEntityVase) tile).getVaseTypeMeta() : 0;
    }
}
