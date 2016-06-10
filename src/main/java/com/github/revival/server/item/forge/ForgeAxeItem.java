package com.github.revival.server.item.forge;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemAxe;

public class ForgeAxeItem extends ItemAxe {
    String TextureFileName;

    public ForgeAxeItem(ToolMaterial par2ToolMaterial, String TextureFileName0) {
        super(par2ToolMaterial);
        this.TextureFileName = TextureFileName0;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:" + TextureFileName);
    }
}
