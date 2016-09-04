package fossilsarcheology.server.block;

import net.minecraft.block.BlockRail;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockSlimeTrail extends BlockRail {
    public BlockSlimeTrail() {
        super();
        this.slipperiness = 1.12F;
        this.setSoundType(FABlockRegistry.INSTANCE.soundTypeSlime);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if (rand.nextInt(3) == 0) {
            return Items.SLIME_BALL;
        } else {
            return Item.getItemById(0);
        }
    }
}
