package fossilsarcheology.server.item;

import net.minecraft.item.ItemSword;

public class ToothDaggerItem extends ItemSword {

    public ToothDaggerItem(ToolMaterial var2) {
        super(var2);
        this.maxStackSize = 1;
        this.setMaxDamage(250);
    }

}
