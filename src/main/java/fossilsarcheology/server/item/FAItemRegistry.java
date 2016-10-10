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

    public static final BasicItem AMBER = new BasicItem("amber");
    public static final BasicItem DOMINICAN_AMBER = new BasicItem("dominican_amber");

    public static final BasicItem SCARAB_GEM = new BasicItem("scarab_gem");
    public static final BasicItem AQUATIC_SCARAB_GEM = new BasicItem("aquatic_scarab_gem");

    public static final BasicItem RELIC_SCRAP = new BasicItem("relic_scrap");
    public static final BasicItem POTTERY_SHARD = new BasicItem("pottery_shard");

    public static final BasicItem PLANT_FOSSIL = new BasicItem("plant_fossil");

    public static final StoneTabletItem STONE_TABLET = new StoneTabletItem();

    public static final JavelinItem WOODEN_JAVELIN = new JavelinItem(Item.ToolMaterial.WOOD, "wooden_javelin", false);
    public static final JavelinItem STONE_JAVELIN = new JavelinItem(Item.ToolMaterial.STONE, "stone_javelin", false);
    public static final JavelinItem IRON_JAVELIN = new JavelinItem(Item.ToolMaterial.IRON, "iron_javelin", false);
    public static final JavelinItem GOLD_JAVELIN = new JavelinItem(Item.ToolMaterial.GOLD, "gold_javelin", false);
    public static final JavelinItem DIAMOND_JAVELIN = new JavelinItem(Item.ToolMaterial.DIAMOND, "diamond_javelin", false);

    public static final JavelinItem ANCIENT_JAVELIN = new JavelinItem(null, "ancient_javelin", true);

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

    public static Item registerItem(Item item) {
        String name = item.getUnlocalizedName().substring("item.".length());
        GameRegistry.register(item, new ResourceLocation(Revival.MODID, name));
        ITEMS.add(item);
        return item;
    }
}
