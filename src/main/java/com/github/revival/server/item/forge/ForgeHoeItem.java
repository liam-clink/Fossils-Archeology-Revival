package com.github.revival.server.item.forge;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemHoe;

public class ForgeHoeItem extends ItemHoe {
	String TextureFileName;

	public ForgeHoeItem(ToolMaterial par2ToolMaterial, String TextureFileName0) {
		super(par2ToolMaterial);
		this.TextureFileName = TextureFileName0;
	}

	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("fossil:" + TextureFileName);
	}
}
