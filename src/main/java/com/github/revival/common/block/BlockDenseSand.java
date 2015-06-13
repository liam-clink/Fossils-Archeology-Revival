package com.github.revival.common.block;

import com.github.revival.common.creativetab.FATabRegistry;
import net.minecraft.block.BlockFalling;

public class BlockDenseSand extends BlockFalling
{
    public BlockDenseSand()
    {
        this.setHardness(3.0F);
        this.setResistance(15F);
        this.setBlockTextureName("fossil:dense_sand");
        this.setBlockName("denseSand");
        this.setStepSound(soundTypeSand);
        this.setCreativeTab(FATabRegistry.tabFBlocks);
    }
}