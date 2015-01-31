package mods.fossil.tabs;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabFFood extends CreativeTabs
{
    public TabFFood(String par2Str)
    {
        super(par2Str);
    }

    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
    	return Fossil.cookedChickenSoup;
    }

    public String getTranslatedTabLabel()
    {
        return LocalizationStrings.FFOOD_NAME;
    }
}
