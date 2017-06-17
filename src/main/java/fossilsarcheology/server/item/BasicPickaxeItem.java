package fossilsarcheology.server.item;

import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.item.ItemPickaxe;

public class BasicPickaxeItem extends ItemPickaxe {

    public BasicPickaxeItem(ToolMaterial toolmaterial, String name) {
        super(toolmaterial);
        this.setUnlocalizedName(name);
        this.setCreativeTab(FATabRegistry.ITEMS);
    }
}
