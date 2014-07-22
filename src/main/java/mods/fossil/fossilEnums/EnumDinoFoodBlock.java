package mods.fossil.fossilEnums;

import mods.fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public enum EnumDinoFoodBlock
{
    Cake(Blocks.cake, 25, 5),
    Carrot(Blocks.carrots, 25, 3),
    Crops(Blocks.wheat, 10, 2),
    Leaves(Blocks.leaves, 15, 2),
    Melon(Blocks.melon_block, 60, 4),
    BrownMushroom(Blocks.brown_mushroom, 15, 1),
    RedMushroom(Blocks.red_mushroom, 15, 1),
    RedFlower(Blocks.red_flower, 10, 1),
    YellowFlower(Blocks.yellow_flower, 10, 1),
    Potato(Blocks.potatoes, 25, 2),
    Pumpkin(Blocks.pumpkin, 20, 1),
    Reed(Blocks.reeds, 10, 1),
    Sapling(Blocks.sapling, 10, 1),
    TallGrass(Blocks.tallgrass, 10, 1),
    Ferns(Fossil.ferns, 50, 3),
    Palae(Fossil.palmLeaves, 15, 2)
    ;
    public Block block;
    public int FoodValue;
    public int HealValue;

    private EnumDinoFoodBlock(Block Block, int Food, int Heal)
    {
        block = Block;
        FoodValue = Food;
        HealValue = Heal;
    }
    /**
     *
     * Takes the itemid and gives the food value
     */
    public static int getBlockFood(Item i0)
    {
        for (int i = 0; i < EnumDinoFoodBlock.values().length; i++)
        {
            if (Item.getItemFromBlock(EnumDinoFoodBlock.values()[i].block) == i0)
            {
                return EnumDinoFoodBlock.values()[i].FoodValue;
            }
        }

        return 0;
    }
}
