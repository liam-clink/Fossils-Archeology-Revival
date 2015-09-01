package com.github.revival.common.creativetab;

import com.github.revival.common.handler.LocalizationStrings;
import com.github.revival.common.item.FAItemRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabFArmor extends CreativeTabs
{
    public TabFArmor(String par2Str)
    {
        super(par2Str);
    }

    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return FAItemRegistry.ancienthelmet;
    }

    public String getTranslatedTabLabel()
    {
        return LocalizationStrings.FARMOR_NAME;
    }
}
