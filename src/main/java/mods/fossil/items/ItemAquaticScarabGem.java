package mods.fossil.items;

import mods.fossil.Fossil;
import mods.fossil.fossilEnums.EnumCoinType;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemAquaticScarabGem extends Item {

	public ItemAquaticScarabGem() {
		super();
		this.maxStackSize = 64;
		this.setCreativeTab(Fossil.tabFTest);
	}

	@Override
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("fossil:AquaticScarabGem");
	}
}
