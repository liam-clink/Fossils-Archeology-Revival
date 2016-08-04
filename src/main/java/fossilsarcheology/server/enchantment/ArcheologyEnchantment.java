package fossilsarcheology.server.enchantment;

import fossilsarcheology.Revival;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ArcheologyEnchantment extends Enchantment {
    public ArcheologyEnchantment() {
        super(Rarity.RARE, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND });
        this.setName("archeology");
    }

    @Override
    public int getMinEnchantability(int par1) {
        return 5 + (par1 - 1) * 10;
    }

    @Override
    public int getMaxEnchantability(int par1) {
        return super.getMinEnchantability(par1) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return Revival.CONFIG.allowTableEnchantments && canApply(stack);
    }

    @Override
    public boolean isAllowedOnBooks() {
        return Revival.CONFIG.allowBookEnchantments;
    }

    @Override
    public boolean canApply(ItemStack itemStack) {
        if (itemStack.isItemStackDamageable()) {
            if (itemStack.getItem() instanceof ItemPickaxe) {
                return super.canApply(itemStack);
            }
        }
        return false;
    }

    @Override
    public boolean canApplyTogether(Enchantment enchantment) {
        return super.canApplyTogether(enchantment) && !enchantment.getName().equals("silk_touch") && !enchantment.getName().equals("archeology");
    }
}
