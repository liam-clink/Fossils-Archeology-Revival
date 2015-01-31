package mods.fossil.tabs;

import mods.fossil.Fossil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabFTest extends CreativeTabs {
	
	public TabFTest(String title) {
		super(title);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Fossil.blockTimeMachine);
	}
	
}
