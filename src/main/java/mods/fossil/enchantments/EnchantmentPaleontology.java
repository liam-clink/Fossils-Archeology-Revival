package mods.fossil.enchantments;

import mods.fossil.Fossil;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;

public class EnchantmentPaleontology  extends Enchantment {
	
	public EnchantmentPaleontology(int effectID, int rarity, EnumEnchantmentType enchantmentType) {
		super(effectID, rarity, enchantmentType);
		this.setName("paleontology");
		this.type = enchantmentType;
	}

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int par1)
    {
        return 5 + (par1 - 1) * 10;
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int par1)
    {
        return super.getMinEnchantability(par1) + 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel()
    {
        return 3;
    }
    
    public boolean canApply(ItemStack itemStack)
    {
        return itemStack.isItemStackDamageable() ? true : super.canApply(itemStack);
    }
    
    /**
     * Determines if the enchantment passed can be applyied together with this enchantment.
     */
    
    public boolean canApplyTogether(Enchantment enchantment)
    {
    //    return super.canApplyTogether(par1Enchantment) && par1Enchantment.effectId != archeology.effectId;
    	return super.canApplyTogether(enchantment) && enchantment.effectId != silkTouch.effectId && enchantment.effectId != Fossil.archeology.effectId;
    }
    
    
    
}
