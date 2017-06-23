package fossilsarcheology.server.block;

import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class PalmPlanksBlock extends Block {

    public PalmPlanksBlock() {
        super(Material.WOOD);
        setHardness(2.0F);
        setResistance(5.0F);
        setSoundType(SoundType.WOOD);
        setUnlocalizedName("palaeoraphePlanks");
        this.setCreativeTab(FATabRegistry.BLOCKS);
    }

}

