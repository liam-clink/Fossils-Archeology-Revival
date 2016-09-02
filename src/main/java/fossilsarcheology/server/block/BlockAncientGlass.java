package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockAncientGlass extends Block {
    public BlockAncientGlass(Material material) {
        super(material);
        this.setLightOpacity(1);
        this.setUnlocalizedName(LocalizationStrings.ANCIENT_GLASS_NAME);
        this.setSoundType(SoundType.GLASS);
        this.setHardness(1F);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
    }

    @Override
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return world.getBlockState(pos).getBlock() != this && super.shouldSideBeRendered(state, world, pos, side);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
