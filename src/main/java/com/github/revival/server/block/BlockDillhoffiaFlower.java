package com.github.revival.server.block;

import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockDillhoffiaFlower extends BlockBush {

	public BlockDillhoffiaFlower(Material material) {
		super(material);
		this.setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
		setBlockName(LocalizationStrings.BLOCK_DILLHOFFIA_NAME);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("fossil:Dillhoffia");
	}

}
