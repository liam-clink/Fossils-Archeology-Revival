package mods.fossil.blocks;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockLimestone extends Block {

	public BlockLimestone(Material material) {
		super(material.rock);
		setHardness(0.3F);
		this.setCreativeTab(Fossil.tabFTest);
		setBlockName(LocalizationStrings.BLOCK_LIMESTONE_NAME);
	}

	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("fossil:Limestone");
	}

}
