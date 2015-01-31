package mods.fossil.blocks;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockMagnoliaFlower extends BlockBush {

	public BlockMagnoliaFlower(Material material) {
		super(material.plants);
		this.setCreativeTab(Fossil.tabFTest);
		setBlockName(LocalizationStrings.BLOCK_MAGNOLIA_NAME);
	}
	
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("fossil:Magnolia");
	}

}
