package mods.fossil.items;

import mods.fossil.Fossil;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemAncientHelmet extends ItemArmor
{
    public ItemAncientHelmet(ArmorMaterial par2ArmorMaterial, int par3, int par4)
    {
        super(par2ArmorMaterial, par3, par4);
        this.setCreativeTab(Fossil.tabFArmor);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return "fossil:textures/armor/TextureAncientHelmet.png";
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("fossil:Ancient_Helm");
    }
}