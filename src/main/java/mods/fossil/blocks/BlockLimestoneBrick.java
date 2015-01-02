package mods.fossil.blocks;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockLimestoneBrick extends Block {

	public BlockLimestoneBrick(Material material) {
		super(material.rock);
		setHardness(3.0F);
		this.setCreativeTab(Fossil.tabFTest);
		setBlockName(LocalizationStrings.BLOCK_LIMESTONEBRICK_NAME);
	}
	
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("fossil:Limestone_Brick");
	}

}
