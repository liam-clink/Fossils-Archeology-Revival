package fossilsarcheology.server.creativetab;

import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TabFItems extends CreativeTabs {
    public TabFItems(String par2Str) {
        super(par2Str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return FAItemRegistry.INSTANCE.biofossil;
    }

    @Override
    public String getTranslatedTabLabel() {
        return LocalizationStrings.FITEMS_NAME;
    }
}
