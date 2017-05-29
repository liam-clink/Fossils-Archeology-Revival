package fossilsarcheology.server.item;

import fossilsarcheology.Revival;
import fossilsarcheology.client.sound.FASoundRegistry;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FAItemRegistry {
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final BioFossilItem BIOFOSSIL = new BioFossilItem(false);
    public static final BioFossilItem TAR_FOSSIL = new BioFossilItem(true);
    public static final BasicItem DINOPEDIA = new BasicItem("dinopedia");
    public static final BasicItem FAILURESAURUS_FLESH = new BasicItem("failuresaurus_flesh");
    public static final BasicItem AMBER = new BasicItem("amber");
    public static final BasicItem DOMINICAN_AMBER = new BasicItem("dominican_amber");
    public static final BasicItem CHICKEN_ESSENCE = new BasicItem("chicken_essence");
    public static final BasicItem SCARAB_GEM = new BasicItem("scarab_gem");
    public static final BasicItem AQUATIC_SCARAB_GEM = new BasicItem("aquatic_scarab_gem");
    public static final BasicAxeItem SCARAB_AXE = new BasicAxeItem("scarab_axe");
    public static final BasicPickaxeItem SCARAB_PICKAXE = new BasicPickaxeItem("scarab_pickaxe");
    public static final BasicSwordItem SCARAB_SWORD = new BasicSwordItem("scarab_sword");
    public static final BasicHoeItem SCARAB_HOE = new BasicHoeItem("scarab_hoe");
    public static final BasicShovelItem SCARAB_SHOVEL = new BasicShovelItem("scarab_shovel");
    public static final BasicHelmetItem SKULL_HELMET = new BasicHelmetItem("skull_helmet");
    public static final BasicChestplateItem RIBCAGE_CHESTPLATE = new BasicChestplateItem("skull_helmet");
    public static final BasicLeggingsItem SHIN_LEGGINGS = new BasicLeggingsItem("shin_leggings");
    public static final BasicBootsItem FEET_BOOTS = new BasicBootsItem("feet_boots");
    public static final BasicItem ANCIENT_KEY = new BasicItem("ancient_key");
    public static final BasicItem ANCIENT_CLOCK = new BasicItem("ancient_clock");
    public static final BasicItem SHELL = new BasicItem("shell");
    public static final BasicFoodItem SJL = new BasicFoodItem(8, 2, false, "shell");
    public static final BasicItem MAGIC_CONCH = new BasicItem("magic_conch");
    public static final BasicFoodItem RAW_CHICKEN_SOUP = new BasicFoodItem(4, 2, false, "raw_chicken_soup");
    public static final BasicFoodItem COOKED_CHICKEN_SOUP = new BasicFoodItem(8, 2, false, "cooked_chicken_soup");
    public static final BasicFoodItem COOKED_EGG = new BasicFoodItem(4, 2, false, "cooked_egg");
    public static final BasicItem RELIC_SCRAP = new BasicItem("relic_scrap");
    public static final BasicItem POTTERY_SHARD = new BasicItem("pottery_shard");
    public static final BasicItem PLANT_FOSSIL = new BasicItem("plant_fossil");
    public static final BasicItem SKULL_STICK = new BasicItem("skull_stick");
    public static final BasicItem TOOTH_DAGGER = new BasicItem("tooth_dagger");//TODO
    public static final StoneTabletItem STONE_TABLET = new StoneTabletItem();
    public static final WhipItem WHIP = new WhipItem();
    public static final ToyBallItem TOY_BALL = new ToyBallItem();
    public static final ToyScratchingPost TOY_SCRATCHING_POST = new ToyScratchingPost();
    public static final ToyTetheredLog TOY_TETHERED_LOG = new ToyTetheredLog();
    public static final JavelinItem WOODEN_JAVELIN = new JavelinItem(Item.ToolMaterial.WOOD, "wooden_javelin", false);
    public static final JavelinItem STONE_JAVELIN = new JavelinItem(Item.ToolMaterial.STONE, "stone_javelin", false);
    public static final JavelinItem IRON_JAVELIN = new JavelinItem(Item.ToolMaterial.IRON, "iron_javelin", false);
    public static final JavelinItem GOLD_JAVELIN = new JavelinItem(Item.ToolMaterial.GOLD, "gold_javelin", false);
    public static final JavelinItem DIAMOND_JAVELIN = new JavelinItem(Item.ToolMaterial.DIAMOND, "diamond_javelin", false);
    public static final JavelinItem ANCIENT_JAVELIN = new JavelinItem(null, "ancient_javelin", true);
    public static final BasicItem BROKEN_SWORD = new BasicItem("broken_sword");
    public static final BasicItem BROKEN_HELMET = new BasicItem("broken_helmet");
    public static final IcedMeatItem ICED_MEAT = new IcedMeatItem();
    public static final BasicItem BROKEN_SAPLING = new BasicItem("broken_sapling");
    public static final FossilSeedsItem FOSSIL_SEED = new FossilSeedsItem(true);
    public static final BasicItem FOSSIL_SEED_FERN = new BasicItem("fossilSeed_fern");
    public static final BasicItem PALAE_SAPLING_FOSSIL = new BasicItem("fossilSapling_palae");
    public static final FossilSeedsItem SEED = new FossilSeedsItem(false);
    public static final FernSeedItem FERN_SEED = new FernSeedItem();
    public static final ItemBucket TAR_BUCKET = new ItemBucket(FABlockRegistry.TAR).setUnlocalizedName("tar_bucket").setContainerItem(Items.BUCKET).setCreativeTab(FATabRegistry.ITEMS);
    public static final BasicItem TARDROP = new BasicItem("tardrop");
    public static final FossilRecordItem FOSSIL_RECORD_BONES = new FossilRecordItem("record_bones_desc", FASoundRegistry.RECORD_BONES);
    public static final FossilRecordItem FOSSIL_RECORD_NANO_ANU = new FossilRecordItem("music.anu", FASoundRegistry.RECORD_BONES);
    public static final FossilRecordItem FOSSIL_RECORD_NANO_SCARAB = new FossilRecordItem("music.scarab", FASoundRegistry.RECORD_BONES);
    public static final FossilRecordItem FOSSIL_RECORD_NANO_DISCOVERING = new FossilRecordItem("music.discovery", FASoundRegistry.RECORD_BONES);
    public static final DinosaurBoneItem LEG_BONE = new DinosaurBoneItem("leg_bone");
    public static final DinosaurBoneItem UNIQUE_ITEM = new DinosaurBoneItem("unique_item");
    public static final DinosaurBoneItem FOOT = new DinosaurBoneItem("foot");
    public static final DinosaurBoneItem SKULL = new DinosaurBoneItem("skull");
    public static final DinosaurBoneItem ARM_BONE = new DinosaurBoneItem("arm_bone");
    public static final DinosaurBoneItem RIBCAGE = new DinosaurBoneItem("ribcage");
    public static final DinosaurBoneItem VERTEBRAE = new DinosaurBoneItem("vertebrae");

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
