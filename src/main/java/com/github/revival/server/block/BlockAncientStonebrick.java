package com.github.revival.server.block;

import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockAncientStonebrick extends Block {
    public BlockAncientStonebrick() {
        super(Material.rock);
        this.setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);
        setHardness(1.5F);
        setBlockName(LocalizationStrings.ANCIENT_STONE_BRICK_NAME);
    }

    /**
     * When this method is called, your block should register all the icons it
     * needs with the given IconRegister. This is the only chance you get to
     * register icons.
     */
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("fossil:Ancient_Stonebricks");
    }
}
