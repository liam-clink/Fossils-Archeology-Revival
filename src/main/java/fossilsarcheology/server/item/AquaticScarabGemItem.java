package fossilsarcheology.server.item;

import fossilsarcheology.server.creativetab.FATabRegistry;
import net.minecraft.item.Item;

public class AquaticScarabGemItem extends Item {
    public AquaticScarabGemItem() {
        super();
        this.setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
    }
}
