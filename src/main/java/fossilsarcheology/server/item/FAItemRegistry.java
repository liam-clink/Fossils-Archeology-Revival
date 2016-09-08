package fossilsarcheology.server.item;

import fossilsarcheology.Revival;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.entity.mob.projectile.BehaviorJavelinDispense;
import fossilsarcheology.server.handler.BucketEvent;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.forge.ForgeAxeItem;
import fossilsarcheology.server.item.forge.ForgeHoeItem;
import fossilsarcheology.server.item.forge.ForgePickaxeItem;
import fossilsarcheology.server.item.forge.ForgeShovelItem;
import fossilsarcheology.server.item.forge.ForgeSwordItem;
import net.minecraft.block.BlockDispenser;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.lang.reflect.Field;

public enum FAItemRegistry {
    INSTANCE;

    public ItemArmor.ArmorMaterial bone = EnumHelper.addArmorMaterial("Bone", "", 25, new int[] { 2, 7, 6, 2 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
    public Item.ToolMaterial scarab = EnumHelper.addToolMaterial("Scarab", 3, 1861, 8.0F, 4.0F, 25);
    public Item.ToolMaterial toothDaggerMaterial = EnumHelper.addToolMaterial("toothDagger", 3, 250, 70.0F, 1.5F, 25);

    public Item biofossil;
    public Item tarfossil;
    public Item relic;
    public Item stoneboard;
    public Item brokenSword;
    public Item ancientSword;
    public Item brokenhelmet;
    public Item ancienthelmet;
    public Item potteryShards;
    public Item skullStick;
    public Item icedMeat;
    public Item brokenSapling;
    public Item fossilSeed;
    public Item fossilSeed_fern;
    public Item palaeSaplingFossil;
    public Item seed;
    public Item fernSeed;
    public Item dinoPedia;
    public Item archNotebook;
    public Item whip;
    public Item failuresaurusFlesh;
    public Item tar_bucket;
    public Item tardrop;
    public Item emptyShell;
    public Item sjl;
    public Item magicConch;
    public Item rawChickenSoup;
    public Item cookedChickenSoup;
    public Item chickenEssence;
    public Item cookedEgg;
    public Item amber;
    public Item DominicanAmber;
    public Item gem;
    public Item gemAxe;
    public Item gemPickaxe;
    public Item gemSword;
    public Item gemHoe;
    public Item gemShovel;
    public Item gem_blue;
    public Item skullHelmet;
    public Item ribCage;
    public Item femurs;
    public Item feet;
    public Item ancientKey;
    public Item ancientClock;
    public Item toothDagger;
    public Item woodjavelin;
    public Item stonejavelin;
    public Item ironjavelin;
    public Item goldjavelin;
    public Item diamondjavelin;
    public Item ancientJavelin;
    public Item toyBall;
    public Item toyTetheredLog;
    public Item toyScratchingPost;
    public Item fossilrecordBones;
    public Item recordNano_Anu;
    public Item recordNano_Scarab;
    public Item recordNano_Discovering;
    public Item skull;
    public Item dinoRibCage;
    public Item claw;
    public Item armBone;
    public Item vertebrae;
    public Item legBone;
    public Item foot;
    public Item dinosaurModels;

    public void init() {
        biofossil = new ItemBioFossil(false);
        tarfossil = new ItemBioFossil(true);
        DominicanAmber = new DominicanAmberItem();
        gem_blue = new AquaticScarabGemItem().setUnlocalizedName("AquaticScarabGem");
        relic = new Item().setUnlocalizedName(LocalizationStrings.RELIC_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        stoneboard = new StoneBoardItem();
        ancientSword = new AncientSwordItem().setUnlocalizedName(LocalizationStrings.ANCIENT_SWORD_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        brokenSword = new Item().setMaxStackSize(1).setUnlocalizedName(LocalizationStrings.BROKEN_SWORD_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        fernSeed = new FernSeedItem(FABlockRegistry.INSTANCE.ferns);
        ancienthelmet = new AncientHelmetItem(ItemArmor.ArmorMaterial.IRON, 3, EntityEquipmentSlot.HEAD).setUnlocalizedName(LocalizationStrings.ANCIENT_HELMET_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        brokenhelmet = new Item().setMaxStackSize(1).setUnlocalizedName(LocalizationStrings.BROKEN_HELMET_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        skullStick = new Item().setUnlocalizedName(LocalizationStrings.SKULL_STICK_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        gem = new Item().setUnlocalizedName(LocalizationStrings.SCARAB_GEM_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        gemAxe = new ForgeAxeItem(scarab).setUnlocalizedName(LocalizationStrings.SCARAB_AXE_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        gemPickaxe = new ForgePickaxeItem(scarab).setUnlocalizedName(LocalizationStrings.SCARAB_PICKAXE_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        gemSword = new ForgeSwordItem(scarab).setUnlocalizedName(LocalizationStrings.SCARAB_SWORD_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        gemHoe = new ForgeHoeItem(scarab).setUnlocalizedName(LocalizationStrings.SCARAB_HOE_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        gemShovel = new ForgeShovelItem(scarab).setUnlocalizedName(LocalizationStrings.SCARAB_SHOVEL_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        dinoPedia = new Item().setUnlocalizedName(LocalizationStrings.DINOPEDIA_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        emptyShell = new Item().setUnlocalizedName(LocalizationStrings.EMPTY_SHELL_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        magicConch = new MagicConchItem().setUnlocalizedName(LocalizationStrings.MAGIC_CONCH_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        icedMeat = new IcedMeatItem(Item.ToolMaterial.DIAMOND).setUnlocalizedName(LocalizationStrings.ICED_MEAT_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        amber = new AmberItem().setUnlocalizedName(LocalizationStrings.AMBER_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        woodjavelin = new JavelinItem(Item.ToolMaterial.WOOD, "Wooden_Javelin").setUnlocalizedName(LocalizationStrings.WOOD_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        stonejavelin = new JavelinItem(Item.ToolMaterial.STONE, "Stone_Javelin").setUnlocalizedName(LocalizationStrings.STONE_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        ironjavelin = new JavelinItem(Item.ToolMaterial.IRON, "Iron_Javelin").setUnlocalizedName(LocalizationStrings.IRON_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        goldjavelin = new JavelinItem(Item.ToolMaterial.GOLD, "Gold_Javelin").setUnlocalizedName(LocalizationStrings.GOLD_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        diamondjavelin = new JavelinItem(Item.ToolMaterial.DIAMOND, "Diamond_Javelin").setUnlocalizedName(LocalizationStrings.DIAMOND_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        ancientJavelin = new JavelinItem(scarab, "Ancient_Javelin").setUnlocalizedName(LocalizationStrings.ANCIENT_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        toothDagger = new ToothDaggerItem(toothDaggerMaterial).setUnlocalizedName("toothDagger").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        whip = new WhipItem().setUnlocalizedName(LocalizationStrings.WHIP_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        legBone = new DinosaurBoneItem("legBone").setUnlocalizedName(LocalizationStrings.LEGBONE_NAME);
        claw = new DinosaurBoneItem("uniqueItem").setUnlocalizedName(LocalizationStrings.CLAW_NAME);
        foot = new DinosaurBoneItem("foot").setUnlocalizedName(LocalizationStrings.FOOT_NAME);
        skull = new DinosaurBoneItem("skull").setUnlocalizedName(LocalizationStrings.SKULL_NAME);
        armBone = new DinosaurBoneItem("armBone").setUnlocalizedName(LocalizationStrings.ARM_BONE_NAME);
        dinoRibCage = new DinosaurBoneItem("dinoRibCage").setUnlocalizedName(LocalizationStrings.DINO_RIB_CAGE_NAME);
        vertebrae = new DinosaurBoneItem("vertebrae").setUnlocalizedName(LocalizationStrings.VERTEBRAE_NAME);
        brokenSapling = new Item().setUnlocalizedName(LocalizationStrings.BROKEN_SAPLING_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        failuresaurusFlesh = new Item().setUnlocalizedName(LocalizationStrings.FAILURESAURUS_FLESH_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        potteryShards = new Item().setUnlocalizedName(LocalizationStrings.POTTERY_SHARDS).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        skullHelmet = new SkullHelmetItem(bone, 3, 0).setUnlocalizedName(LocalizationStrings.SKULL_HELMET_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        ribCage = new RibCageItem(bone, 3, 1).setUnlocalizedName(LocalizationStrings.RIBCAGE_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        femurs = new FemursItem(bone, 3, 2).setUnlocalizedName(LocalizationStrings.FEMURS_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        feet = new FeetItem(bone, 3, EntityEquipmentSlot.FEET).setUnlocalizedName(LocalizationStrings.FEET_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        cookedChickenSoup = new Item().setUnlocalizedName(LocalizationStrings.COOKED_CHICKEN_SOUP_NAME).setMaxStackSize(1).setContainerItem(Items.BUCKET).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        rawChickenSoup = new Item().setUnlocalizedName(LocalizationStrings.RAW_CHICKEN_SOUP_NAME).setMaxStackSize(1).setContainerItem(Items.BUCKET).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        chickenEssence = new ChickenEssenceItem(10, 0.0F, false).setUnlocalizedName(LocalizationStrings.EOC_NAME).setContainerItem(Items.GLASS_BOTTLE).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        cookedEgg = new ItemFood(4, 2.0F, false).setUnlocalizedName("cooked_egg").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        sjl = new ItemFood(8, 2.0F, false).setUnlocalizedName(LocalizationStrings.SJL_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        fossilrecordBones = new FossilRecordItem(LocalizationStrings.RECORD_BONES_NAME, "fossil:record_bones").setUnlocalizedName(LocalizationStrings.FOSSIL_RECORD_NAME);
        recordNano_Anu = new FossilRecordItem(LocalizationStrings.FOSSIL_RECORD_NANO_ANU, "fossil:record_anu").setUnlocalizedName(LocalizationStrings.RECORD_BONES_NAME);
        recordNano_Scarab = new FossilRecordItem("music.scarab", "fossil:record_scarab").setUnlocalizedName("record_scarab");
        recordNano_Discovering = new FossilRecordItem("music.discovery", "fossil:record_discovering").setUnlocalizedName("record_discovery");
        fossilSeed_fern = new Item().setUnlocalizedName("fossilSeed_fern").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        fossilSeed = new FossilSeedsItem(true).setUnlocalizedName("fossilSeed").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        seed = new FossilSeedsItem(false).setUnlocalizedName("seed").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        palaeSaplingFossil = new Item().setUnlocalizedName("fossilSapling_palae").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        ancientKey = new Item().setUnlocalizedName("ancientKey").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        ancientClock = new Item().setUnlocalizedName("ancientClock").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        tardrop = new Item().setUnlocalizedName("tardrop").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        tar_bucket = new ItemBucket(FABlockRegistry.INSTANCE.tar).setUnlocalizedName("tar_bucket").setContainerItem(Items.BUCKET).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        toyBall = new ItemToyBall().setUnlocalizedName("toyBall").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        toyTetheredLog = new ItemToyTetheredLog().setUnlocalizedName("toyTetheredLog").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        toyScratchingPost = new ItemToyScratchingPost().setUnlocalizedName("toyScratchingPost").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("tar", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(tar_bucket), new ItemStack(Items.BUCKET));
        BucketEvent.INSTANCE.buckets.put(FABlockRegistry.INSTANCE.tar.getDefaultState(), tar_bucket);
        MinecraftForge.EVENT_BUS.register(BucketEvent.INSTANCE);
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(ancientJavelin, new BehaviorJavelinDispense(-1));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(woodjavelin, new BehaviorJavelinDispense(0));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(stonejavelin, new BehaviorJavelinDispense(1));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(ironjavelin, new BehaviorJavelinDispense(2));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(diamondjavelin, new BehaviorJavelinDispense(3));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(goldjavelin, new BehaviorJavelinDispense(4));

        try {
            for (Field f : getClass().getDeclaredFields()) {
                Object obj = f.get(this);
                if (obj instanceof Item) {
                    registerItem((Item) obj);
                } else if (obj instanceof Item[]) {
                    for (Item item : (Item[]) obj) {
                        registerItem(item);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void registerItem(Item item) {
        String[] split = item.getUnlocalizedName().split("\\.");
        GameRegistry.register(item, new ResourceLocation(Revival.MODID, split[split.length - 1]));
    }
}
