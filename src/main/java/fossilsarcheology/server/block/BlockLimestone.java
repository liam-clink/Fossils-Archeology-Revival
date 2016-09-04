package fossilsarcheology.server.block;

import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLimestone extends Block {
    public BlockLimestone() {
        super(Material.ROCK);
        this.setHardness(0.3F);
        this.setUnlocalizedName(LocalizationStrings.BLOCK_LIMESTONE_NAME);
    }
}
