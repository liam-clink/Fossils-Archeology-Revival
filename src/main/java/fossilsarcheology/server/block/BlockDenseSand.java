package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import net.minecraft.block.BlockFalling;

public class BlockDenseSand extends BlockFalling {
    public BlockDenseSand() {
        this.setHardness(3.0F);
        this.setResistance(15F);
        this.setBlockTextureName("fossil:dense_sand");
        this.setUnlocalizedName("denseSand");
        this.setSoundType(soundTypeSand);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
    }
}