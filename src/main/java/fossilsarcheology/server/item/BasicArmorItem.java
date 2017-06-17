package fossilsarcheology.server.item;

import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class BasicArmorItem extends ItemArmor {

    public BasicArmorItem(ArmorMaterial material, int renderIndex, EntityEquipmentSlot slot, String name) {
        super(material, renderIndex, slot);
        this.setCreativeTab(FATabRegistry.ITEMS);
        this.setUnlocalizedName(name);
    }
}

