package com.github.revival.server.item.forge;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ForgeItemItem extends Item {
    String TextureFileName;

    public ForgeItemItem(String TextureFileName0) {
        this.TextureFileName = TextureFileName0;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:" + TextureFileName);
    }
}
