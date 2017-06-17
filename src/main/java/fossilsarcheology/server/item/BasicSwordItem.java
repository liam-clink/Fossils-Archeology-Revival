package fossilsarcheology.server.item;

import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.item.ItemSword;

public class BasicSwordItem extends ItemSword {

    public BasicSwordItem(ToolMaterial toolmaterial, String name) {
        super(toolmaterial);
        this.setUnlocalizedName(name);
        this.setCreativeTab(FATabRegistry.ITEMS);
    }

}
