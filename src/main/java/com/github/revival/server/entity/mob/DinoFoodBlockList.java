package com.github.revival.server.entity.mob;

import com.github.revival.server.enums.EnumDinoFoodBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class DinoFoodBlockList {
    public int index;
    EnumDinoFoodBlock[] Blocks;

    public DinoFoodBlockList() {
        index = 0;
        this.Blocks = new EnumDinoFoodBlock[100];
    }

    public void addblock(EnumDinoFoodBlock block) {
        this.Blocks[index] = block;
        index++;
    }

    public boolean CheckBlock(Block item) {
        for (int i = 0; i < index; i++) {
            if (Item.getItemFromBlock(Blocks[i].block) == Item.getItemFromBlock(item)) {
                return true;
            }
        }

        return false;
    }

    public int getBlockFood(Item ID) {
        for (int i = 0; i < index; i++) {
            if (Blocks[i].block == Block.getBlockFromItem(ID)) {
                return Blocks[i].FoodValue;
            }
        }

        return 0;
    }

    public int getBlockHeal(Block ID) {
        for (int i = 0; i < index; i++) {
            if (Blocks[i].block == ID) {
                return Blocks[i].HealValue;
            }
        }

        return 0;
    }

    public Block getBlock(int ID) {
        if (ID >= 0 && ID < index) {
            return Blocks[ID].block;
        }

        return null;
    }

    public boolean IsEmpty() {
        return index == 0;
    }
}
