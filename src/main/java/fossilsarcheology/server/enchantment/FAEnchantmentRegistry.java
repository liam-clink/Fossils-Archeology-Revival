package fossilsarcheology.server.enchantment;

import fossilsarcheology.Revival;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public enum FAEnchantmentRegistry {
    INSTANCE;

    public Enchantment paleontology;
    public Enchantment archeology;

    public void init() {
        paleontology = new PaleontologyEnchantment(Revival.CONFIG.enchantmentIDPaleontology, 2, EnumEnchantmentType.digger);
        archeology = new ArcheologyEnchantment(Revival.CONFIG.enchantmentIDArcheology, 2, EnumEnchantmentType.digger);
    }
}
