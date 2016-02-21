package com.github.revival.common.creativetab;

import com.github.revival.common.enums.EnumPrehistoric;
import com.github.revival.common.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabFMaterial extends CreativeTabs {
    public TabFMaterial(String par2Str) {
        super(par2Str);
    }

    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return EnumPrehistoric.Brachiosaurus.eggItem;
    }

    public String getTranslatedTabLabel() {
        return LocalizationStrings.FMATERIAL_NAME;
    }
}
