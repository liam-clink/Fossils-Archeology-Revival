package com.github.revival.server.creativetab;

import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabFFigurines extends CreativeTabs {
    public TabFFigurines(String par2Str) {
        super(par2Str);
    }

    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.figurineBlock);
    }

    public String getTranslatedTabLabel() {
        return LocalizationStrings.FFIGURINES_NAME;
    }
}
