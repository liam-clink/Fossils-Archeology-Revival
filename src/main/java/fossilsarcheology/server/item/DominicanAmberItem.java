package fossilsarcheology.server.item;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.item.Item;

public class DominicanAmberItem extends Item {
    public DominicanAmberItem() {
        this.setUnlocalizedName(LocalizationStrings.DOMINICAN_AMBER_NAME);
        this.setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
    }
}
