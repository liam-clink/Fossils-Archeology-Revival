package com.github.revival.common.item.forge;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ForgeItem extends Item
{
    String TextureFileName;

    public ForgeItem(String TextureFileName0)
    {
        this.TextureFileName = TextureFileName0;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("fossil:" + TextureFileName);
    }
}
