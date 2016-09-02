package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAncientWood extends Block {
    public BlockAncientWood() {
        super(Material.WOOD);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        this.setHardness(2.0F);
        this.setUnlocalizedName(LocalizationStrings.ANCIENT_WOOD_NAME);
    }
}
