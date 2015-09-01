package com.github.revival.common.item;

import com.github.revival.Revival;
import com.github.revival.common.creativetab.FATabRegistry;
import com.github.revival.common.enums.EnumDinoBones;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemDinosaurBones extends Item
{

    @SideOnly(Side.CLIENT)
    public IIcon[] icons;
    String itemType;

    public ItemDinosaurBones(String _itemType)
    {
        super();
        this.itemType = _itemType;
        setMaxDamage(0);

        this.setCreativeTab(FATabRegistry.tabFBones);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        return getUnlocalizedName() + "." + EnumDinoBones.values()[itemstack.getItemDamage()].name();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage)
    {
        return icons[damage];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icon)
    {
        icons = new IIcon[EnumDinoBones.values().length];

        for (int i = 0; i < icons.length; i++)
        {
            if (i != 0) //Silly Nautilus, bones are for dinosaurs.
            {
                icons[i] = icon.registerIcon(Revival.modid + ":" + "dinosaur_bones/" + this.itemType + "/" + EnumDinoBones.values()[i] + "_" + this.itemType);
            }
        }
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
        for (int i = 0; i < icons.length; i++)
        {
            if (i != 0) //Silly Nautilus, bones are for dinosaurs.
            {
                ItemStack itemstack = new ItemStack(item, 1, i);
                list.add(itemstack);
            }
        }
    }

}
