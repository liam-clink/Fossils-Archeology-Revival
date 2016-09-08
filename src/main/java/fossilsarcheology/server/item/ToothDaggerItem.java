package fossilsarcheology.server.item;

import net.minecraft.item.ItemSword;

public class ToothDaggerItem extends ItemSword {
    public ToothDaggerItem(ToolMaterial material) {
        super(material);
        this.maxStackSize = 1;
        this.setMaxDamage(250);
    }
}
