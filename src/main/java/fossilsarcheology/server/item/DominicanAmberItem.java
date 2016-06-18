package fossilsarcheology.server.item;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class DominicanAmberItem extends Item {

    public DominicanAmberItem() {
        setUnlocalizedName(LocalizationStrings.DOMINICAN_AMBER_NAME);
        setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:dominican_amber");
    }
}
