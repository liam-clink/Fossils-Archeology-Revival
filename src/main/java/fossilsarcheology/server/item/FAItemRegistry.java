package fossilsarcheology.server.item;

import fossilsarcheology.Revival;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FAItemRegistry {
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final BioFossilItem BIOFOSSIL = new BioFossilItem(false);
    public static final BioFossilItem TAR_FOSSIL = new BioFossilItem(true);

    public static void register() {
        try {
            for (Field f : FAItemRegistry.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof Item) {
                    FAItemRegistry.registerItem((Item) obj);
                } else if (obj instanceof Item[]) {
                    for (Item item : (Item[]) obj) {
                        FAItemRegistry.registerItem(item);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void registerItem(Item item) {
        String name = item.getUnlocalizedName().substring("item.".length());
        GameRegistry.register(item, new ResourceLocation(Revival.MODID, name));
        ITEMS.add(item);
    }
}
