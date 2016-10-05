package fossilsarcheology.server.tab;

import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.localization.Localizations;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FABlockTab extends CreativeTabs {
    public FABlockTab() {
        super("Fossil Blocks");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return Item.getItemFromBlock(FABlockRegistry.FOSSIL);
    }

    @Override
    public String getTranslatedTabLabel() {
        return Localizations.TAB_BLOCKS;
    }
}
