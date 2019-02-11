package fossilsarcheology.server.item;

import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemDoor;

public class ItemFossilDoor extends ItemDoor implements DefaultRenderedItem {


    public ItemFossilDoor(Block block, String name) {
        super(block);
        this.setTranslationKey(name);
        this.setCreativeTab(FATabRegistry.BLOCKS);
    }
}
