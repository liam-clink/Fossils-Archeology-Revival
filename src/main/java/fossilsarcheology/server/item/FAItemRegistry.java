package fossilsarcheology.server.item;

import fossilsarcheology.Revival;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.entity.mob.projectile.BehaviorJavelinDispense;
import fossilsarcheology.server.handler.BucketEvent;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.forge.ForgeAxeItem;
import fossilsarcheology.server.item.forge.ForgeHoeItem;
import fossilsarcheology.server.item.forge.ForgeItemItem;
import fossilsarcheology.server.item.forge.ForgePickaxeItem;
import fossilsarcheology.server.item.forge.ForgeShovelItem;
import fossilsarcheology.server.item.forge.ForgeSwordItem;
import net.minecraft.block.BlockDispenser;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.lang.reflect.Field;

public enum FAItemRegistry {
    INSTANCE;

    public ItemArmor.ArmorMaterial bone = EnumHelper.addArmorMaterial("Bone", 25, new int[] { 2, 7, 6, 2 }, 15);
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
        relic = new ForgeItemItem("Relic_Scrap").setUnlocalizedName(LocalizationStrings.RELIC_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        stoneboard = new StoneBoardItem();
        ancientSword = new AncientSwordItem().setUnlocalizedName(LocalizationStrings.ANCIENT_SWORD_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        brokenSword = new ForgeItemItem("Broken_Ancient_Sword").setMaxStackSize(1).setUnlocalizedName(LocalizationStrings.BROKEN_SWORD_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        fernSeed = new FernSeedItem(FABlockRegistry.INSTANCE.ferns);
        ancienthelmet = new AncientHelmetItem(ItemArmor.ArmorMaterial.IRON, 3, 0).setUnlocalizedName(LocalizationStrings.ANCIENT_HELMET_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        brokenhelmet = new ForgeItemItem("Broken_Ancient_Helm").setMaxStackSize(1).setUnlocalizedName(LocalizationStrings.BROKEN_HELMET_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        skullStick = new ForgeItemItem("Skull_Stick").setUnlocalizedName(LocalizationStrings.SKULL_STICK_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        gem = new ForgeItemItem("Scarab_Gem").setUnlocalizedName(LocalizationStrings.SCARAB_GEM_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        gemAxe = new ForgeAxeItem(scarab, "Gem_Axe").setUnlocalizedName(LocalizationStrings.SCARAB_AXE_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        gemPickaxe = new ForgePickaxeItem(scarab, "Gem_Pickaxe").setUnlocalizedName(LocalizationStrings.SCARAB_PICKAXE_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        gemSword = new ForgeSwordItem(scarab, "Gem_Sword").setUnlocalizedName(LocalizationStrings.SCARAB_SWORD_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        gemHoe = new ForgeHoeItem(scarab, "Gem_Hoe").setUnlocalizedName(LocalizationStrings.SCARAB_HOE_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        gemShovel = new ForgeShovelItem(scarab, "Gem_Shovel").setUnlocalizedName(LocalizationStrings.SCARAB_SHOVEL_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        dinoPedia = new ForgeItemItem("Dinopedia").setUnlocalizedName(LocalizationStrings.DINOPEDIA_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        emptyShell = new ForgeItemItem("Empty_Shell").setUnlocalizedName(LocalizationStrings.EMPTY_SHELL_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        magicConch = new MagicConchItem().setUnlocalizedName(LocalizationStrings.MAGIC_CONCH_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        icedMeat = new IcedMeatItem(Item.ToolMaterial.DIAMOND).setUnlocalizedName(LocalizationStrings.ICED_MEAT_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        amber = new AmberItem().setUnlocalizedName(LocalizationStrings.AMBER_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        woodjavelin = new JavelinItem(Item.ToolMaterial.WOOD, "Wooden_Javelin").setUnlocalizedName(LocalizationStrings.WOOD_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        stonejavelin = new JavelinItem(Item.ToolMaterial.STONE, "Stone_Javelin").setUnlocalizedName(LocalizationStrings.STONE_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        ironjavelin = new JavelinItem(Item.ToolMaterial.IRON, "Iron_Javelin").setUnlocalizedName(LocalizationStrings.IRON_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        goldjavelin = new JavelinItem(Item.ToolMaterial.GOLD, "Gold_Javelin").setUnlocalizedName(LocalizationStrings.GOLD_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        diamondjavelin = new JavelinItem(Item.ToolMaterial.DIAMOND, "Diamond_Javelin").setUnlocalizedName(LocalizationStrings.DIAMOND_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        ancientJavelin = new JavelinItem(scarab, "Ancient_Javelin").setUnlocalizedName(LocalizationStrings.ANCIENT_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        toothDagger = new ToothDaggerItem(toothDaggerMaterial).setTextureName("fossil:toothDagger").setUnlocalizedName("toothDagger").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        whip = new WhipItem().setUnlocalizedName(LocalizationStrings.WHIP_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        legBone = new DinosaurBoneItem("legBone").setUnlocalizedName(LocalizationStrings.LEGBONE_NAME);
        claw = new DinosaurBoneItem("uniqueItem").setUnlocalizedName(LocalizationStrings.CLAW_NAME);
        foot = new DinosaurBoneItem("foot").setUnlocalizedName(LocalizationStrings.FOOT_NAME);
        skull = new DinosaurBoneItem("skull").setUnlocalizedName(LocalizationStrings.SKULL_NAME);
        armBone = new DinosaurBoneItem("armBone").setUnlocalizedName(LocalizationStrings.ARM_BONE_NAME);
        dinoRibCage = new DinosaurBoneItem("dinoRibCage").setUnlocalizedName(LocalizationStrings.DINO_RIB_CAGE_NAME);
        vertebrae = new DinosaurBoneItem("vertebrae").setUnlocalizedName(LocalizationStrings.VERTEBRAE_NAME);
        brokenSapling = new ForgeItemItem("fossilPlant").setUnlocalizedName(LocalizationStrings.BROKEN_SAPLING_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        failuresaurusFlesh = new ForgeItemItem("flesh").setUnlocalizedName(LocalizationStrings.FAILURESAURUS_FLESH_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        potteryShards = new ForgeItemItem("PotteryShard").setUnlocalizedName(LocalizationStrings.POTTERY_SHARDS).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        skullHelmet = new SkullHelmetItem(bone, 3, 0).setUnlocalizedName(LocalizationStrings.SKULL_HELMET_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        ribCage = new RibCageItem(bone, 3, 1).setUnlocalizedName(LocalizationStrings.RIBCAGE_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        femurs = new FemursItem(bone, 3, 2).setUnlocalizedName(LocalizationStrings.FEMURS_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        feet = new FeetItem(bone, 3, 3).setUnlocalizedName(LocalizationStrings.FEET_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        cookedChickenSoup = new ForgeItemItem("Cooked_Chicken_Soup").setUnlocalizedName(LocalizationStrings.COOKED_CHICKEN_SOUP_NAME).setMaxStackSize(1).setContainerItem(Items.bucket).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        rawChickenSoup = new ForgeItemItem("Raw_Chicken_Soup").setUnlocalizedName(LocalizationStrings.RAW_CHICKEN_SOUP_NAME).setMaxStackSize(1).setContainerItem(Items.bucket).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        chickenEssence = new ChickenEssItem(10, 0.0F, false, "Essence_Of_Chicken").setUnlocalizedName(LocalizationStrings.EOC_NAME).setContainerItem(Items.glass_bottle).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        cookedEgg = new ForgeFoodItem(4, 2.0F, false).setUnlocalizedName("cooked_egg").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        sjl = new ForgeFoodItem(8, 2.0F, false).setUnlocalizedName(LocalizationStrings.SJL_NAME).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        fossilrecordBones = new FossilRecordItem(LocalizationStrings.RECORD_BONES_NAME, "fossil:record_bones").setUnlocalizedName(LocalizationStrings.FOSSIL_RECORD_NAME);
        recordNano_Anu = new FossilRecordItem(LocalizationStrings.FOSSIL_RECORD_NANO_ANU, "fossil:record_anu").setUnlocalizedName(LocalizationStrings.RECORD_BONES_NAME);
        recordNano_Scarab = new FossilRecordItem("music.scarab", "fossil:record_scarab").setUnlocalizedName("record_scarab");
        recordNano_Discovering = new FossilRecordItem("music.discovery", "fossil:record_discovering").setUnlocalizedName("record_discovery");
        fossilSeed_fern = new ForgeItemItem("plants/fossilSeed_fern").setUnlocalizedName("fossilSeed_fern").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        fossilSeed = new FossilSeedsItem(true).setUnlocalizedName("fossilSeed").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        seed = new FossilSeedsItem(false).setUnlocalizedName("seed").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        palaeSaplingFossil = new ForgeItemItem("Palae_Fossil").setUnlocalizedName("fossilSapling_palae").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        ancientKey = new Item().setTextureName("fossil:Ancient_Key").setUnlocalizedName("ancientKey").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        ancientClock = new Item().setTextureName("gold_ingot").setUnlocalizedName("ancientClock").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        tardrop = new ForgeItemItem("tardrop").setUnlocalizedName("tardrop").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        tar_bucket = new ItemBucket(FABlockRegistry.INSTANCE.tar).setUnlocalizedName("tar_bucket").setTextureName("fossil:bucket_tar").setContainerItem(Items.bucket).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        toyBall = new ItemToyBall().setUnlocalizedName("toyBall").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        toyTetheredLog = new ItemToyTetheredLog().setUnlocalizedName("toyTetheredLog").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        toyScratchingPost = new ItemToyScratchingPost().setUnlocalizedName("toyScratchingPost").setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("tar", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(tar_bucket), new ItemStack(Items.bucket));
        BucketEvent.INSTANCE.buckets.put(FABlockRegistry.INSTANCE.tar, tar_bucket);
        MinecraftForge.EVENT_BUS.register(BucketEvent.INSTANCE);
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(ancientJavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), -1));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(woodjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 0));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(stonejavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 1));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(ironjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 2));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(diamondjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 3));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(goldjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 4));

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
