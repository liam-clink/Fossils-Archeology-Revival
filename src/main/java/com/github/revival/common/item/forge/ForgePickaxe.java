package com.github.revival.common.item.forge;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemPickaxe;

public class ForgePickaxe extends ItemPickaxe {
    String TextureFileName;

    public ForgePickaxe(ToolMaterial par2ToolMaterial, String TextureFileName0) {
        super(par2ToolMaterial);
        this.TextureFileName = TextureFileName0;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:" + TextureFileName);
    }
}
