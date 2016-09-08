package fossilsarcheology.server.item;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.enums.EnumDinoBones;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class DinosaurBoneItem extends Item {
    public String itemType;

    public DinosaurBoneItem(String itemType) {
        super();
        this.itemType = itemType;
        this.setMaxDamage(0);
        this.setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName() + "." + EnumDinoBones.values()[stack.getItemDamage()].name();
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (int i = 0; i < EnumDinoBones.values().length; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
