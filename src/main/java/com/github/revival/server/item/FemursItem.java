package com.github.revival.server.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class FemursItem extends ItemArmor {
    public FemursItem(ArmorMaterial par2ArmorMaterial, int par3, int par4) {
        super(par2ArmorMaterial, par3, par4);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon("fossil:Bone_Legs");
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == FAItemRegistry.INSTANCE.skullHelmet || stack.getItem() == FAItemRegistry.INSTANCE.ribCage || stack.getItem() == FAItemRegistry.INSTANCE.feet) {
            return "fossil:textures/armor/bone_1.png";
        }

        if (stack.getItem() == FAItemRegistry.INSTANCE.femurs) {
            return "fossil:textures/armor/bone_2.png";
        }

        return "fossil:textures/armor/bone_2.png";
    }
}