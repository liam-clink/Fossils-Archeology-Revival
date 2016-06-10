package com.github.revival.server.block;

import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockMagnoliaFlower extends BlockBush {

	public BlockMagnoliaFlower(Material material) {
		super(Material.plants);
		this.setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
		setBlockName(LocalizationStrings.BLOCK_MAGNOLIA_NAME);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("fossil:Magnolia");
	}

}
