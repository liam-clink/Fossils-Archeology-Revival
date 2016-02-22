package com.github.revival.server.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class AmberItem extends Item {
    public AmberItem() {
        super();
        this.maxStackSize = 64;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:Amber");
    }
}
