package com.github.alexthe666.iceandfire.core;

import com.github.alexthe666.iceandfire.enums.EnumDragonEgg;
import com.github.alexthe666.iceandfire.item.ItemDragonEgg;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

	public static Item dragonegg_red;
	public static Item dragonegg_green;
	public static Item dragonegg_bronze;
	public static Item dragonegg_gray;
	public static Item dragonegg_blue;
	public static Item dragonegg_white;

	public static void init(){
		dragonegg_red = new ItemDragonEgg("dragonegg_red", EnumDragonEgg.RED);
		dragonegg_green = new ItemDragonEgg("dragonegg_green", EnumDragonEgg.GREEN);
		dragonegg_bronze = new ItemDragonEgg("dragonegg_bronze", EnumDragonEgg.BRONZE);
		dragonegg_gray = new ItemDragonEgg("dragonegg_gray", EnumDragonEgg.GRAY);
		dragonegg_blue = new ItemDragonEgg("dragonegg_blue", EnumDragonEgg.BLUE);
		dragonegg_white = new ItemDragonEgg("dragonegg_white", EnumDragonEgg.WHITE);
	}
}
