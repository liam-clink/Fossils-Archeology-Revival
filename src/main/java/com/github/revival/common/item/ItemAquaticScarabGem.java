package com.github.revival.common.item;

import com.github.revival.common.creativetab.FATabRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemAquaticScarabGem extends Item
{

    public ItemAquaticScarabGem()
    {
        super();
        this.maxStackSize = 64;
        this.setCreativeTab(FATabRegistry.tabFItems);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("fossil:scarab_blue");
    }
}
