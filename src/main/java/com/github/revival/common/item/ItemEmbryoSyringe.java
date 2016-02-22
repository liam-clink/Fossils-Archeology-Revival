package com.github.revival.common.item;

import com.github.revival.common.enums.EnumAnimalType;
import net.minecraft.item.Item;

import java.util.Random;

public class ItemEmbryoSyringe extends Item {
    //private String[] ItemNames = new String[] {"EmbyoPig", "EmbyoSheep", "EmbyoCow", "EmbyoSmilodon", "EmbyoMammoth"};
    int AnimalType;
    private EnumAnimalType embryo;
    private Random rand;

    public ItemEmbryoSyringe(int AnimalType0) {
        super();
        //this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.AnimalType = AnimalType0;
        this.rand = new Random();
    }

    public static EnumAnimalType GetEmbryo(int var0) {
        return EnumAnimalType.values()[var0];
    }
}
