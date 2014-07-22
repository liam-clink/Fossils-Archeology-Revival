package mods.fossil.tabs;

import mods.fossil.client.LocalizationStrings;
import mods.fossil.fossilEnums.EnumDinoType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabFMaterial extends CreativeTabs
{
    public TabFMaterial(String par2Str)
    {
        super(par2Str);
    }

    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
    	return EnumDinoType.Brachiosaurus.EggItem;
    }

    public String getTranslatedTabLabel()
    {
        return LocalizationStrings.FMATERIAL_NAME;
    }
}
