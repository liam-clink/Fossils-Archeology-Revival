package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockAncientWoodPillar extends BlockRotatedPillar {
    public BlockAncientWoodPillar() {
        super(Material.WOOD);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setHardness(2.0F);
        this.setUnlocalizedName(LocalizationStrings.ANCIENT_WOOD_PILLAR_NAME);
    }

    @Override
    public boolean canSustainLeaves(IBlockState state, IBlockAccess access, BlockPos pos) {
        return true;
    }

    @Override
    public boolean isWood(IBlockAccess access, BlockPos pos) {
        return true;
    }
}
