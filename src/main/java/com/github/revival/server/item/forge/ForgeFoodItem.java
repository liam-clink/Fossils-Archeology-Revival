package com.github.revival.server.item.forge;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;

public class ForgeFoodItem extends ItemFood {
	String TextureFileName;

	public ForgeFoodItem(int par2, float par3, boolean par4, String TextureFileName0) {
		super(par2, par3, par4);
		this.TextureFileName = TextureFileName0;
	}

	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("fossil:" + TextureFileName);
	}
}
