package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMarble extends Block {
    public BlockMarble() {
        super(Material.ROCK);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setHardness(2.0F);
        this.setHardness(1.5F);
        this.setUnlocalizedName(LocalizationStrings.MARBLE_NAME);
    }
}
