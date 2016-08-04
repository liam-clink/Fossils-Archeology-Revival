package fossilsarcheology.server.creativetab;

import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TabFBlocks extends CreativeTabs {
    public TabFBlocks(String par2Str) {
        super(par2Str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockworktableActive);
    }

    @Override
    public String getTranslatedTabLabel() {
        return LocalizationStrings.FBLOCKS_NAME;
    }
}
