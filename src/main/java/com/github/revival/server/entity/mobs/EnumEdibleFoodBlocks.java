package com.github.revival.server.entity.mobs;

import net.minecraft.block.Block;

public class EnumEdibleFoodBlocks {

    ;

    private Block block;
    private int baseHungerHeal;
    private int baseHealthHeal;

    private EnumEdibleFoodBlocks(Block block, int baseHungerHeal, int baseHealthHeal) {
        this.block = block;
        this.baseHungerHeal = baseHungerHeal;
        this.baseHealthHeal = baseHealthHeal;
    }

    public int getBaseHungerHeal() {
        return baseHungerHeal;
    }

    public int getBaseHealthHeal() {
        return baseHealthHeal;
    }

    public boolean isBlock(Block block) {
        return this.block.equals(block);
    }

}
