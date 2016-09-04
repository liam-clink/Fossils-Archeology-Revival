package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockFossilStairs extends BlockStairs {
    public BlockFossilStairs(IBlockState block) {
        super(block);
        this.setLightOpacity(0);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}
