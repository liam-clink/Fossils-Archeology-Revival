package com.github.revival.common.entity.mobs;

import net.minecraft.item.Item;

public enum EnumEdibleFoodstuff
{

    ;

    private Item item;
    private int baseHungerHeal;
    private float baseHealthHeal;

    private EnumEdibleFoodstuff(Item item, int baseHungerHeal, float baseHealthHeal)
    {
        this.item = item;
        this.baseHungerHeal = baseHungerHeal;
        this.baseHealthHeal = baseHealthHeal;
    }

    public static EnumEdibleFoodstuff getFromItem(Item item)
    {
        for (EnumEdibleFoodstuff food : EnumEdibleFoodstuff.values())
        {
            if (food.isItem(item))
            {
                return food;
            }
        }
        return null;
    }

    public int getBaseHungerHeal()
    {
        return baseHungerHeal;
    }

    public float getBaseHealthHeal()
    {
        return baseHealthHeal;
    }

    public boolean isItem(Item item)
    {
        return this.item.equals(item);
    }

}
