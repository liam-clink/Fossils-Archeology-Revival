package mods.fossil.blocks;

import mods.fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockPalaePlanks extends Block
{
    public BlockPalaePlanks(Material var2Material)
    {
        super(Material.wood);
        this.setCreativeTab(Fossil.tabFBlocks);
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("fossil:Palae_Planks");
    }
}
