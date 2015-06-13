package com.github.revival.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemAmber extends Item
{
    public ItemAmber()
    {
        super();
        this.maxStackSize = 64;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("fossil:Amber");
    }
}
