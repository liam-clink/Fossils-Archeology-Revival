package mods.fossil.items;

import java.util.List;

import mods.fossil.Fossil;
import mods.fossil.fossilEnums.EnumDinoType;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDinosaurBones extends Item {

	String itemType;

	public ItemDinosaurBones(String _itemType) {
		super();
		this.itemType = _itemType;
		setMaxDamage(0);

		this.setCreativeTab(Fossil.tabFBones);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + EnumDinoType.values()[itemstack.getItemDamage()].name();
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon[] icons;

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int damage) {
		return icons[damage];	
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon) {
	icons = new IIcon[EnumDinoType.values().length];

		for(int i = 0; i < icons.length; i++) 
		{
			if(i != 4) //Silly Nautilus, bones are for dinosaurs.
			{
			icons[i] = icon.registerIcon(Fossil.modid + ":" + "dinosaur_bones/" + this.itemType + "/" + EnumDinoType.values()[i] + "_" + this.itemType);
			}
		}
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for(int i = 0; i < icons.length; i++) {
			if(i != 4) //Silly Nautilus, bones are for dinosaurs.
			{
				ItemStack itemstack = new ItemStack(item, 1, i);
				list.add(itemstack);
			}
		}
	}
		
}
