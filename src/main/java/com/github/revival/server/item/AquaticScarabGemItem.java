package com.github.revival.server.item;

import com.github.revival.server.creativetab.FATabRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class AquaticScarabGemItem extends Item {

    public AquaticScarabGemItem() {
        super();
        this.maxStackSize = 64;
        this.setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:scarab_blue");
    }
}
