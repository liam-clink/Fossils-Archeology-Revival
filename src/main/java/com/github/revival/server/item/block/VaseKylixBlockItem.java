package com.github.revival.server.item.block;

import com.github.revival.server.block.VaseKylixBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class VaseKylixBlockItem extends ItemBlockWithMetadata {
    public VaseKylixBlockItem(Block block) {
        super(block, block);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + VaseKylixBlock.shortname[itemstack.getItemDamage()];
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }
}
