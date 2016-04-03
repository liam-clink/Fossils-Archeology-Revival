package com.github.revival.server.item.block;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class AnuStatueBlockItem extends ItemBlock {
    public AnuStatueBlockItem(Block b) {
        super(b);
    }

    @Override
    public EnumRarity getRarity(ItemStack item) {
        return EnumRarity.epic;
    }
}
