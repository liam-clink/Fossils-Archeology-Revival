package fossilsarcheology.server.item;

import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.item.ItemSpade;

public class BasicShovelItem extends ItemSpade {

    public BasicShovelItem(ToolMaterial toolmaterial, String name) {
        super(toolmaterial);
        this.setUnlocalizedName(name);
        this.setCreativeTab(FATabRegistry.ITEMS);
    }
}
