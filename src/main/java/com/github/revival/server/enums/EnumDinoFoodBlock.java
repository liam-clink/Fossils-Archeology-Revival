package com.github.revival.server.enums;

import com.github.revival.server.block.FABlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public enum EnumDinoFoodBlock {
    Cake(Blocks.cake, 50, 8),
    Carrot(Blocks.carrots, 20, 3),
    Crops(Blocks.wheat, 10, 2),
    Leaves(Blocks.leaves, 20, 4),
    Melon(Blocks.melon_block, 65, 6),
    BrownMushroom(Blocks.brown_mushroom, 15, 3),
    RedMushroom(Blocks.red_mushroom, 15, 3),
    RedFlower(Blocks.red_flower, 5, 1),
    YellowFlower(Blocks.yellow_flower, 5, 1),
    Potato(Blocks.potatoes, 25, 5),
    Pumpkin(Blocks.pumpkin, 30, 6),
    Reed(Blocks.reeds, 15, 2),
    Sapling(Blocks.sapling, 15, 1),
    TallGrass(Blocks.tallgrass, 5, 1),
    Ferns(FABlockRegistry.INSTANCE.ferns, 55, 4),
    Palae(FABlockRegistry.INSTANCE.palmLeaves, 40, 4);
    public Block block;
    public int FoodValue;
    public int HealValue;

    EnumDinoFoodBlock(Block Block, int Food, int Heal) {
        block = Block;
        FoodValue = Food;
        HealValue = Heal;
    }

    /**
     * Takes the itemid and gives the food value
     */
    public static int getBlockFood(Item i0) {
        for (int i = 0; i < EnumDinoFoodBlock.values().length; i++) {
            if (Item.getItemFromBlock(EnumDinoFoodBlock.values()[i].block) == i0) {
                return EnumDinoFoodBlock.values()[i].FoodValue;
            }
        }

        return 0;
    }
}
