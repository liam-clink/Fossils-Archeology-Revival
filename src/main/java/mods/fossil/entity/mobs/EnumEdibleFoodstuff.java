package mods.fossil.entity.mobs;

import net.minecraft.item.Item;

public class EnumEdibleFoodstuff {
	
	;
	
	private Item item;
	private int baseHungerHeal;
	private int baseHealthHeal;
	
	private EnumEdibleFoodstuff(Item item, int baseHungerHeal, int baseHealthHeal) {
		this.item = item;
		this.baseHungerHeal = baseHungerHeal;
		this.baseHealthHeal = baseHealthHeal;
	}
	
	public int getBaseHungerHeal() {
		return baseHungerHeal;
	}
	
	public int getBaseHealthHeal() {
		return baseHealthHeal;
	}
	
	public boolean isItem(Item item) {
		return this.item.equals(item);
	}
	
}
