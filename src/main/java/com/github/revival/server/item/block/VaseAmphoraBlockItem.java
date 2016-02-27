package com.github.revival.server.item.block;

import com.github.revival.server.block.VaseAmphoraBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class VaseAmphoraBlockItem extends ItemBlockWithMetadata {
    public VaseAmphoraBlockItem(Block block) {
        super(block, block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + VaseAmphoraBlock.shortname[itemstack.getItemDamage()];
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }
}
