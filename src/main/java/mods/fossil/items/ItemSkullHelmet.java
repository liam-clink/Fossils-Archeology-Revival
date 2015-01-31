package mods.fossil.items;

import mods.fossil.Fossil;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemSkullHelmet extends ItemArmor
{
    public ItemSkullHelmet(ArmorMaterial par2ArmorMaterial, int par3, int par4)
    {
        super(par2ArmorMaterial, par3, par4);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("fossil:Bone_Helm");
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if (stack.getItem() == Fossil.skullHelmet || stack.getItem() == Fossil.ribCage || stack.getItem() == Fossil.feet)
        {
            return "fossil:textures/armor/bone_1.png";
        }

        if (stack.getItem() == Fossil.femurs)
        {
            return "fossil:textures/armor/bone_2.png";
        }

        return "fossil:textures/armor/bone_2.png";
    }
}