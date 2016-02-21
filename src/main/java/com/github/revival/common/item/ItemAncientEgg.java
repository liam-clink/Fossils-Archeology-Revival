package com.github.revival.common.item;

import com.github.revival.common.enums.EnumPrehistoric;
import net.minecraft.item.Item;

public class ItemAncientEgg extends Item {
    public static final int TypeCount = EnumPrehistoric.values().length;
    private int DinoType;

    public ItemAncientEgg(int DinoType0) {
        super();
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.DinoType = DinoType0;
    }

}
