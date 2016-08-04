package fossilsarcheology.server.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public enum FAEnchantmentRegistry {
    INSTANCE;

    public Enchantment paleontology;
    public Enchantment archeology;

    public void init() {
        this.paleontology = new PaleontologyEnchantment();
        ForgeRegistries.ENCHANTMENTS.register(this.paleontology);
        this.archeology = new ArcheologyEnchantment();
        ForgeRegistries.ENCHANTMENTS.register(this.archeology);
    }
}
