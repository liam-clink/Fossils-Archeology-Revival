package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAncientStone extends Block {
    public BlockAncientStone() {
        super(Material.ROCK);
        setHardness(1.5F);
        setUnlocalizedName(LocalizationStrings.ANCIENT_STONE_NAME);
        setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
    }
}
