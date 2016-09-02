package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAncientStonebrick extends Block {
    public BlockAncientStonebrick() {
        super(Material.ROCK);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
        setHardness(1.5F);
        setUnlocalizedName(LocalizationStrings.ANCIENT_STONE_BRICK_NAME);
    }
}
