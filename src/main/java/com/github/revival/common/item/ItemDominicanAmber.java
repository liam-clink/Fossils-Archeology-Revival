package com.github.revival.common.item;

import com.github.revival.common.creativetab.FATabRegistry;
import com.github.revival.common.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemDominicanAmber extends Item {

    public ItemDominicanAmber() {
        setUnlocalizedName(LocalizationStrings.DOMINICAN_AMBER_NAME);
        setCreativeTab(FATabRegistry.tabFItems);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:dominican_amber");
    }
}
