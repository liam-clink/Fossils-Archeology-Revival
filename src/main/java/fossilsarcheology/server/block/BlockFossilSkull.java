package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockFossilSkull extends Block {
    private static final PropertyDirection FACING = BlockHorizontal.FACING;

    public BlockFossilSkull(boolean isActive) {
        super(Material.ROCK);
        this.setTickRandomly(true);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setUnlocalizedName(isActive ? "skullLantern" : "skullBlock");
    }

    @Override
    public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase entity) {
        return super.onBlockPlaced(world, pos, facing, hitX, hitY, hitZ, meta, entity).withProperty(FACING, EnumFacing.fromAngle(entity.rotationYaw));
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
}