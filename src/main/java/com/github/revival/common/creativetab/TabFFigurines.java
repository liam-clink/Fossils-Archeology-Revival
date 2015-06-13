package com.github.revival.common.creativetab;

import com.github.revival.common.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class TabFFigurines extends CreativeTabs
{
    public TabFFigurines(String par2Str)
    {
        super(par2Str);
    }

    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return Items.apple;
    }

    public String getTranslatedTabLabel()
    {
        return LocalizationStrings.FFIGURINES_NAME;
    }
}
