package mods.fossil.items;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;

public class ItemToothDagger extends ItemSword{

	 public ItemToothDagger(ToolMaterial var2)
	    {
	        super(var2);
	        this.maxStackSize = 1;
	        this.setMaxDamage(250);
	    }

}
