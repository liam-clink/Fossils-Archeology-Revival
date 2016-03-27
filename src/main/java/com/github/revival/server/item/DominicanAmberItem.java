package com.github.revival.server.item;

import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class DominicanAmberItem extends Item {

    public DominicanAmberItem() {
        setUnlocalizedName(LocalizationStrings.DOMINICAN_AMBER_NAME);
        setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:dominican_amber");
    }
}
