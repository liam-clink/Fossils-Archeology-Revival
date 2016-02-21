package com.github.revival.common.block;

import com.github.revival.common.creativetab.FATabRegistry;
import com.github.revival.common.handler.LocalizationStrings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockAncientWood extends Block {
    public BlockAncientWood() {
        super(Material.wood);
        this.setCreativeTab(FATabRegistry.tabFBlocks);
        setHardness(2.0F);
        setBlockName(LocalizationStrings.ANCIENT_WOOD_NAME);
    }

    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("fossil:Ancient_Wood");
    }
}
