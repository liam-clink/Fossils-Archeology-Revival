package mods.fossil.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockVolcanicAsh extends Block
{
    public BlockVolcanicAsh()
    {
        super(Material.cloth);
        this.blockParticleGravity = -0.15F;
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("fossil:Volcanic_Ash");
    }
}