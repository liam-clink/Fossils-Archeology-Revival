package mods.fossil.blocks;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockDillhoffiaFlower extends BlockBush {

	public BlockDillhoffiaFlower(Material material) {
		super(material);
		this.setCreativeTab(Fossil.tabFBlocks);
		setBlockName(LocalizationStrings.BLOCK_DILLHOFFIA_NAME);
	}
	
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("fossil:Dillhoffia");
	}

}
