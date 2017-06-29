package fossilsarcheology.server.block;

import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class FossilStairsBlock extends BlockStairs implements DefaultRenderedItem {

    protected FossilStairsBlock(IBlockState modelState) {
        super(modelState);
        this.setLightOpacity(0);
        this.setCreativeTab(FATabRegistry.BLOCKS);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}
