package mods.fossil.tabs;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabFCombat extends CreativeTabs
{
    public TabFCombat(String par2Str)
    {
        super(par2Str);
    }

    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
    	return Fossil.ancientSword;
    }

    public String getTranslatedTabLabel()
    {
        return LocalizationStrings.FCOMBAT_NAME;
    }
}
