package fossilsarcheology.server.item;

import fossilsarcheology.server.block.FABlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class SlabPalaeItem extends ItemSlab {
    public SlabPalaeItem(Block block) {
        super(block, (BlockSlab) FABlockRegistry.INSTANCE.palaeSingleSlab, (BlockSlab) FABlockRegistry.INSTANCE.palaeDoubleSlab);
    }
}
