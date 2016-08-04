package fossilsarcheology.server.item;

import fossilsarcheology.Revival;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.enums.EnumDinoBones;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class DinosaurBoneItem extends Item {

    public IIcon[] icons = new IIcon[EnumDinoBones.values().length];
    String itemType;

    public DinosaurBoneItem(String _itemType) {
        super();
        this.itemType = _itemType;
        setMaxDamage(0);

        this.setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + EnumDinoBones.values()[itemstack.getItemDamage()].name();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage) {
        return icons[damage];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icon) {
        for (int i = 0; i < icons.length; i++) {
            icons[i] = icon.registerIcon(Revival.MODID + ":" + "dinosaur_bones/" + this.itemType + "/" + EnumDinoBones.values()[i] + "_" + this.itemType);
        }
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < icons.length; i++) {
            ItemStack itemstack = new ItemStack(item, 1, i);
            list.add(itemstack);
        }
    }

}
