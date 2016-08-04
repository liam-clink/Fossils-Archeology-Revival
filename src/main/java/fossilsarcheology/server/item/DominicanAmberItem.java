package fossilsarcheology.server.item;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DominicanAmberItem extends Item {

    public DominicanAmberItem() {
        setUnlocalizedName(LocalizationStrings.DOMINICAN_AMBER_NAME);
        setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:dominican_amber");
    }
}
