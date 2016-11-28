package fossilsarcheology.server.block;

import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class LimestoneBlock extends Block implements DefaultRenderedItem {

    public LimestoneBlock() {
        super(Material.ROCK);
        setHardness(0.3F);
        setUnlocalizedName("limestone");
        setCreativeTab(FATabRegistry.BLOCKS);
    }
}
