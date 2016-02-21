package com.github.revival.common.item.forge;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSword;

public class ForgeSword extends ItemSword {
    String TextureFileName;

    public ForgeSword(ToolMaterial par2ToolMaterial, String TextureFileName0) {
        super(par2ToolMaterial);
        this.TextureFileName = TextureFileName0;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:" + TextureFileName);
    }
}
