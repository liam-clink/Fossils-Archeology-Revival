package com.github.revival.common.item;

import net.minecraft.item.ItemSword;

public class ItemToothDagger extends ItemSword
{

    public ItemToothDagger(ToolMaterial var2)
    {
        super(var2);
        this.maxStackSize = 1;
        this.setMaxDamage(250);
    }

}
