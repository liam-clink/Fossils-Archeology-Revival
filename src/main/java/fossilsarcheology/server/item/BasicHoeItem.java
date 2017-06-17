package fossilsarcheology.server.item;

import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.item.ItemHoe;

public class BasicHoeItem extends ItemHoe {

    public BasicHoeItem(ToolMaterial toolmaterial, String name) {
        super(toolmaterial);
        this.setUnlocalizedName(name);
        this.setCreativeTab(FATabRegistry.ITEMS);
    }
}
