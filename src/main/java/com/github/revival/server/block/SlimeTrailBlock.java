package com.github.revival.server.block;

import net.minecraft.block.BlockRail;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Random;

public class SlimeTrailBlock extends BlockRail {

    public SlimeTrailBlock() {
        super();
        this.slipperiness = 1.12F;

    }

    public Item getItemDropped(int var1, Random var2, int var3) {
        if (var2.nextInt(3) == 0) {
            return Items.slime_ball;
        } else {
            return Item.getItemById(0);

        }

    }

}
