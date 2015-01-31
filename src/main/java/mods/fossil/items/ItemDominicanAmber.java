package mods.fossil.items;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDominicanAmber extends Item {

	public ItemDominicanAmber() {
		setUnlocalizedName(LocalizationStrings.DOMINICAN_AMBER_NAME);
		setCreativeTab(Fossil.tabFTest);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("fossil:dominican_amber");
	}
}
