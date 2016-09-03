package fossilsarcheology.server.block;

import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockLimestoneBrick extends Block {
    public BlockLimestoneBrick() {
        super(Material.ROCK);
        this.setHardness(3.0F);
        this.setResistance(20.0F);
        this.setSoundType(SoundType.STONE);
        this.setUnlocalizedName(LocalizationStrings.BLOCK_LIMESTONEBRICK_NAME);
    }
}
