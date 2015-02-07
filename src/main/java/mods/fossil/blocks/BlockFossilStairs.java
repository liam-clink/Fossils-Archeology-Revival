package mods.fossil.blocks;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockFossilStairs extends BlockStairs
{
	public BlockFossilStairs(Block modelBlockx, int var2)
	{
		super(modelBlockx, var2);
		this.setLightOpacity(0);
		this.setCreativeTab(Fossil.tabFBlocks);

	}

	public boolean isOpaqueCube(){
		return false;
	}
	/*
    @Override
    public void registerBlockIcons(IIconRegister par1IIconRegister)
    {
        this.blockIcon = par1IIconRegister.registerIcon(Fossil.modid + ":" + "Ancient_Wood");
    }
	 */
}
