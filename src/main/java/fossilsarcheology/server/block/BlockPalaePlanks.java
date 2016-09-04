package fossilsarcheology.server.block;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockPalaePlanks extends Block {
    public BlockPalaePlanks() {
        super(Material.WOOD);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setSoundType(SoundType.WOOD);
        this.setUnlocalizedName(LocalizationStrings.PALAE_PLANKS_NAME);
        this.setCreativeTab(FATabRegistry.INSTANCE.BLOCKS);
    }
}
