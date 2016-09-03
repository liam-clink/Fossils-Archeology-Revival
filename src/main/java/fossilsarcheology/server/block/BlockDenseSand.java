package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;

public class BlockDenseSand extends BlockFalling {
    public BlockDenseSand() {
        this.setHardness(3.0F);
        this.setResistance(15F);
        this.setUnlocalizedName("denseSand");
        this.setSoundType(SoundType.SAND);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
    }
}