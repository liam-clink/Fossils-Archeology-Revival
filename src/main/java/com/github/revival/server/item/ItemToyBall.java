package com.github.revival.server.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;

public class ItemToyBall extends Item{
	private static final String[] balls = ItemDye.field_150923_a;

	public ItemToyBall(){
        setMaxDamage(0);
        setHasSubtypes(true);
		this.setTextureName("dye_powder_gray");
	}

	@Override
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < balls.length; ++i) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		int meta = itemStack.getItemDamage();
		if (meta < 0 || meta >= balls.length) {
			meta = 0;
		}

		return super.getUnlocalizedName() + "." + balls[meta];
	}
}
