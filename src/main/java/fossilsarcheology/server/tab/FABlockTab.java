package fossilsarcheology.server.tab;

import fossilsarcheology.server.localization.Localizations;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
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
//        return Item.getItemFromBlock(FABlockRegistry.WORKTABLE_ACTIVE);
        return Item.getItemFromBlock(Blocks.STAINED_HARDENED_CLAY);
    }

    @Override
    public String getTranslatedTabLabel() {
        return Localizations.TAB_BLOCKS;
    }
}
