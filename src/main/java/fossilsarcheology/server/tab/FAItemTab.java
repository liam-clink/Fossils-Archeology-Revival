package fossilsarcheology.server.tab;

import fossilsarcheology.server.item.FAItemRegistry;
import fossilsarcheology.server.localization.Localizations;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FAItemTab extends CreativeTabs {
    public FAItemTab() {
        super("Fossil Items");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return FAItemRegistry.BIOFOSSIL;
    }

    @Override
    public String getTranslatedTabLabel() {
        return Localizations.TAB_ITEMS;
    }
}
