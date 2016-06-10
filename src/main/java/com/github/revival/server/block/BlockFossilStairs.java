package com.github.revival.server.block;

import com.github.revival.server.creativetab.FATabRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockFossilStairs extends BlockStairs {
    public BlockFossilStairs(Block modelBlockx, int var2) {
        super(modelBlockx, var2);
        this.setLightOpacity(0);
        this.setCreativeTab(FATabRegistry.INSTANCE.tabFBlocks);

    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    /*
	 * @Override public void registerBlockIcons(IIconRegister par1IIconRegister)
	 * { this.blockIcon = par1IIconRegister.registerIcon(Revival.MODID + ":" +
	 * "Ancient_Wood"); }
	 */
}
