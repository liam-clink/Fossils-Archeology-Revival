package com.github.revival.server.block;

import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockAncientWood extends Block {
	public BlockAncientWood() {
		super(Material.wood);
		this.setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
		setHardness(2.0F);
		setBlockName(LocalizationStrings.ANCIENT_WOOD_NAME);
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("fossil:Ancient_Wood");
	}
}
