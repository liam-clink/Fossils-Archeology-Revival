package com.github.revival.server.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialTar extends Material {

	public MaterialTar(MapColor color) {
		super(color);
		setNoPushMobility();
	}

	@Override
	public boolean isLiquid() {
		return true;
	}

	@Override
	public boolean isSolid() {
		return false;
	}

}
