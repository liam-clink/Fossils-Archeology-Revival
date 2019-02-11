package fossilsarcheology.server.item;

import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.item.ItemFood;

public class BasicFoodItem extends ItemFood implements DefaultRenderedItem {
	public BasicFoodItem(int amount, float saturation, boolean meat, String name) {
		super(amount, saturation, meat);
		this.setCreativeTab(FATabRegistry.ITEMS);
		this.setTranslationKey(name);
	}
}
