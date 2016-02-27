package com.github.revival.server.item.block;

import com.github.revival.server.block.VaseVoluteBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class VaseVoluteBlockItem extends ItemBlockWithMetadata {
    public VaseVoluteBlockItem(Block block) {
        super(block, block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + VaseVoluteBlock.shortname[itemstack.getItemDamage()];
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }
}
