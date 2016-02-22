package com.github.revival.common.entity.mob;

import com.github.revival.common.enums.EnumDinoFoodItem;
import net.minecraft.item.Item;

public class DinoFoodItemList {
    public int index;
    EnumDinoFoodItem Items[];

    public DinoFoodItemList() {
        index = 0;
        this.Items = new EnumDinoFoodItem[100];
    }

    public void addItem(EnumDinoFoodItem item) {
        this.Items[index] = item;
        index++;
    }

    public boolean CheckItem(Item ID) {
        for (int i = 0; i < index; i++) {
            if (Items[i].item == ID) {
                return true;
            }
        }

        return false;
    }

    public int getItemFood(Item ID) {
        for (int i = 0; i < index; i++) {
            if (Items[i].item == ID) {
                return Items[i].FoodValue;
            }
        }

        return 0;
    }

    public int getItemHeal(Item ID) {
        for (int i = 0; i < index; i++) {
            if (Items[i].item == ID) {
                //System.out.println("ItemHealValue:"+String.valueOf(Items[i].HealValue));
                return Items[i].HealValue;
            }
        }

        return 0;
    }

    public Item getItem(int ID) {
        if (ID >= 0 && ID < index) {
            return Items[ID].item;
        }

        return null;
    }

    public boolean IsEmpty() {
        return index == 0;
    }
}
