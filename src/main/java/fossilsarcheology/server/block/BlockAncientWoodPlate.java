package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockAncientWoodPlate extends Block {
    public static final AxisAlignedBB[] BOUNDS = new AxisAlignedBB[] {
            new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.0F * 0.125F, 0.0F),
            new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 2.0F * 0.125F, 0.0F),
            new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 3.0F * 0.125F, 0.0F),
            new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 4.0F * 0.125F, 0.0F),
            new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 5.0F * 0.125F, 0.0F),
            new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 6.0F * 0.125F, 0.0F),
            new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 7.0F * 0.125F, 0.0F)
    };
    public static final PropertyInteger HEIGHT = PropertyInteger.create("height", 0, BOUNDS.length);

    public BlockAncientWoodPlate() {
        super(Material.WOOD);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setHardness(0.6F);
        this.setUnlocalizedName(LocalizationStrings.ANCIENT_WOOD_PLATE_NAME);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDS[state.getValue(HEIGHT) & BOUNDS.length];
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block) {
        this.onNeighbourChange(world, pos);
    }

    private boolean onNeighbourChange(World world, BlockPos pos) {
        if (!this.canPlaceBlockAt(world, pos)) {
            this.dropBlockAsItem(world, pos, world.getBlockState(pos), 0);
            world.setBlockToAir(pos);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity tile, @Nullable ItemStack stack) {
        super.harvestBlock(world, player, pos, state, tile, stack);
        world.setBlockToAir(pos);
    }

    @Override
    public int quantityDropped(Random rand) {
        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return side == EnumFacing.UP || super.shouldSideBeRendered(state, world, pos, side);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(HEIGHT, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(HEIGHT);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, HEIGHT);
    }
}