package mods.fossil.tabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabFBones extends CreativeTabs
{
    public TabFBones(String par2Str)
    {
        super(par2Str);
    }

    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return Fossil.skull;
    }

    public String getTranslatedTabLabel()
    {
        return LocalizationStrings.FBONES_NAME;
    }
}
