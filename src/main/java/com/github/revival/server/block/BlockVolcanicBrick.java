package com.github.revival.server.block;

import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockVolcanicBrick extends Block {
    public BlockVolcanicBrick() {
        super(Material.rock);
        setHardness(3.0F);
        setResistance(5.0F);
        setStepSound(Block.soundTypeStone);
        setBlockName(LocalizationStrings.VOLCANIC_BRICK_NAME);
        setCreativeTab(FATabRegistry.tabFBlocks);
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("fossil:Volcanic_Brick");
    }
}