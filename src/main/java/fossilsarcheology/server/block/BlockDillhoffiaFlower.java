package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;

public class BlockDillhoffiaFlower extends BlockBush {
    public BlockDillhoffiaFlower(Material material) {
        super(material);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setUnlocalizedName(LocalizationStrings.BLOCK_DILLHOFFIA_NAME);
    }
}
