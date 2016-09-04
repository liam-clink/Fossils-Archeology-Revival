package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;

public class BlockMagnoliaFlower extends BlockBush {
    public BlockMagnoliaFlower() {
        super(Material.PLANTS);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setUnlocalizedName(LocalizationStrings.BLOCK_MAGNOLIA_NAME);
    }
}
