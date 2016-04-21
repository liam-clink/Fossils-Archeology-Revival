package com.github.revival.server.item;

import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.entity.BehaviorJavelinDispense;
import com.github.revival.server.handler.BucketEvent;
import com.github.revival.server.handler.LocalizationStrings;
import com.github.revival.server.item.forge.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockDispenser;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

import java.lang.reflect.Field;

public enum FAItemRegistry {
    INSTANCE;

    public ItemArmor.ArmorMaterial bone = EnumHelper.addArmorMaterial("Bone", 25, new int[]{2, 7, 6, 2}, 15);
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
    public Item chickenEss;
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
    public Item fossilrecordBones;
    public Item recordNano_Anu;
    public Item skull;
    public Item dinoRibCage;
    public Item claw;
    public Item armBone;
    public Item vertebrae;
    public Item legBone;
    public Item foot;
    public Item dinosaurModels;
    public Item toyBall;

    public void init() {
        biofossil = new BioFossilItem();
        DominicanAmber = new DominicanAmberItem();
        gem_blue = new AquaticScarabGemItem().setUnlocalizedName("AquaticScarabGem");
        relic = new ForgeItemItem("Relic_Scrap").setUnlocalizedName(LocalizationStrings.RELIC_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        stoneboard = new StoneBoardItem();
        ancientSword = new AncientSwordItem().setUnlocalizedName(LocalizationStrings.ANCIENT_SWORD_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        brokenSword = new ForgeItemItem("Broken_Ancient_Sword").setMaxStackSize(1).setUnlocalizedName(LocalizationStrings.BROKEN_SWORD_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        fernSeed = new FernSeedItem(FABlockRegistry.INSTANCE.ferns);
        ancienthelmet = new AncientHelmetItem(ItemArmor.ArmorMaterial.IRON, 3, 0).setUnlocalizedName(LocalizationStrings.ANCIENT_HELMET_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        brokenhelmet = new ForgeItemItem("Broken_Ancient_Helm").setMaxStackSize(1).setUnlocalizedName(LocalizationStrings.BROKEN_HELMET_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        skullStick = new ForgeItemItem("Skull_Stick").setUnlocalizedName(LocalizationStrings.SKULL_STICK_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        gem = new ForgeItemItem("Scarab_Gem").setUnlocalizedName(LocalizationStrings.SCARAB_GEM_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        gemAxe = new ForgeAxeItem(scarab, "Gem_Axe").setUnlocalizedName(LocalizationStrings.SCARAB_AXE_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        gemPickaxe = new ForgePickaxeItem(scarab, "Gem_Pickaxe").setUnlocalizedName(LocalizationStrings.SCARAB_PICKAXE_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        gemSword = new ForgeSwordItem(scarab, "Gem_Sword").setUnlocalizedName(LocalizationStrings.SCARAB_SWORD_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        gemHoe = new ForgeHoeItem(scarab, "Gem_Hoe").setUnlocalizedName(LocalizationStrings.SCARAB_HOE_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        gemShovel = new ForgeShovelItem(scarab, "Gem_Shovel").setUnlocalizedName(LocalizationStrings.SCARAB_SHOVEL_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        dinoPedia = new ForgeItemItem("Dinopedia").setUnlocalizedName(LocalizationStrings.DINOPEDIA_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        emptyShell = new ForgeItemItem("Empty_Shell").setUnlocalizedName(LocalizationStrings.EMPTY_SHELL_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        magicConch = new MagicConchItem().setUnlocalizedName(LocalizationStrings.MAGIC_CONCH_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        icedMeat = new IcedMeatItem(Item.ToolMaterial.EMERALD).setUnlocalizedName(LocalizationStrings.ICED_MEAT_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        amber = new AmberItem().setUnlocalizedName(LocalizationStrings.AMBER_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        woodjavelin = new JavelinItem(Item.ToolMaterial.WOOD, "Wooden_Javelin").setUnlocalizedName(LocalizationStrings.WOOD_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        stonejavelin = new JavelinItem(Item.ToolMaterial.STONE, "Stone_Javelin").setUnlocalizedName(LocalizationStrings.STONE_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        ironjavelin = new JavelinItem(Item.ToolMaterial.IRON, "Iron_Javelin").setUnlocalizedName(LocalizationStrings.IRON_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        goldjavelin = new JavelinItem(Item.ToolMaterial.GOLD, "Gold_Javelin").setUnlocalizedName(LocalizationStrings.GOLD_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        diamondjavelin = new JavelinItem(Item.ToolMaterial.EMERALD, "Diamond_Javelin").setUnlocalizedName(LocalizationStrings.DIAMOND_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        ancientJavelin = new JavelinItem(scarab, "Ancient_Javelin").setUnlocalizedName(LocalizationStrings.ANCIENT_JAVELIN_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        toothDagger = new ToothDaggerItem(toothDaggerMaterial).setTextureName("fossil:toothDagger").setUnlocalizedName("toothDagger").setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        whip = new WhipItem().setUnlocalizedName(LocalizationStrings.WHIP_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        legBone = new DinosaurBoneItem("legBone").setUnlocalizedName(LocalizationStrings.LEGBONE_NAME);
        claw = new DinosaurBoneItem("uniqueItem").setUnlocalizedName(LocalizationStrings.CLAW_NAME);
        foot = new DinosaurBoneItem("foot").setUnlocalizedName(LocalizationStrings.FOOT_NAME);
        skull = new DinosaurBoneItem("skull").setUnlocalizedName(LocalizationStrings.SKULL_NAME);
        armBone = new DinosaurBoneItem("armBone").setUnlocalizedName(LocalizationStrings.ARM_BONE_NAME);
        dinoRibCage = new DinosaurBoneItem("dinoRibCage").setUnlocalizedName(LocalizationStrings.DINO_RIB_CAGE_NAME);
        vertebrae = new DinosaurBoneItem("vertebrae").setUnlocalizedName(LocalizationStrings.VERTEBRAE_NAME);
        brokenSapling = new ForgeItemItem("fossilPlant").setUnlocalizedName(LocalizationStrings.BROKEN_SAPLING_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        failuresaurusFlesh = new ForgeItemItem("flesh").setUnlocalizedName(LocalizationStrings.FAILURESAURUS_FLESH_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        potteryShards = new ForgeItemItem("PotteryShard").setUnlocalizedName(LocalizationStrings.POTTERY_SHARDS).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        skullHelmet = new SkullHelmetItem(bone, 3, 0).setUnlocalizedName(LocalizationStrings.SKULL_HELMET_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        ribCage = new RibCageItem(bone, 3, 1).setUnlocalizedName(LocalizationStrings.RIBCAGE_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        femurs = new FemursItem(bone, 3, 2).setUnlocalizedName(LocalizationStrings.FEMURS_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        feet = new FeetItem(bone, 3, 3).setUnlocalizedName(LocalizationStrings.FEET_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        cookedChickenSoup = new ForgeItemItem("Cooked_Chicken_Soup").setUnlocalizedName(LocalizationStrings.COOKED_CHICKEN_SOUP_NAME).setMaxStackSize(1).setContainerItem(Items.bucket).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        rawChickenSoup = new ForgeItemItem("Raw_Chicken_Soup").setUnlocalizedName(LocalizationStrings.RAW_CHICKEN_SOUP_NAME).setMaxStackSize(1).setContainerItem(Items.bucket).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        chickenEss = new ChickenEssItem(10, 0.0F, false, "Essence_Of_Chicken").setUnlocalizedName(LocalizationStrings.EOC_NAME).setContainerItem(Items.glass_bottle).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        cookedEgg = new ForgeFoodItem(4, 2.0F, false, "cooked_egg").setUnlocalizedName("cooked_egg").setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        sjl = new ForgeFoodItem(8, 2.0F, false, "Sio_Chiu_Le").setUnlocalizedName(LocalizationStrings.SJL_NAME).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        fossilrecordBones = new FossilRecordItem(LocalizationStrings.RECORD_BONES_NAME, "fossil:record_bones").setUnlocalizedName(LocalizationStrings.FOSSIL_RECORD_NAME);
        recordNano_Anu = new FossilRecordItem(LocalizationStrings.FOSSIL_RECORD_NANO_ANU, "fossil:record_anu").setUnlocalizedName(LocalizationStrings.RECORD_BONES_NAME);
        fossilSeed_fern = new ForgeItemItem("plants/fossilSeed_fern").setUnlocalizedName("fossilSeed_fern").setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        fossilSeed = new FossilSeedsItem(true).setUnlocalizedName("fossilSeed").setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        seed = new FossilSeedsItem(false).setUnlocalizedName("seed").setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        palaeSaplingFossil = new ForgeItemItem("Palae_Fossil").setUnlocalizedName("fossilSapling_palae").setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        ancientClock = new Item().setTextureName("gold_ingot").setUnlocalizedName("ancientClock").setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        tardrop = new ForgeItemItem("tardrop").setUnlocalizedName("tardrop").setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        tarfossil = new ForgeItemItem("tar_fossil").setUnlocalizedName("tarfossil").setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        tar_bucket = new ItemBucket(FABlockRegistry.INSTANCE.tar).setUnlocalizedName("tar_bucket").setTextureName("fossil:bucket_tar").setContainerItem(Items.bucket).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        toyBall = new ItemToyBall().setUnlocalizedName("toyBall").setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("tar", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(tar_bucket), new ItemStack(Items.bucket));
        BucketEvent.INSTANCE.buckets.put(FABlockRegistry.INSTANCE.tar, tar_bucket);
        MinecraftForge.EVENT_BUS.register(BucketEvent.INSTANCE);
        BlockDispenser.dispenseBehaviorRegistry.putObject(ancientJavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), -1));
        BlockDispenser.dispenseBehaviorRegistry.putObject(woodjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 0));
        BlockDispenser.dispenseBehaviorRegistry.putObject(stonejavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 1));
        BlockDispenser.dispenseBehaviorRegistry.putObject(ironjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 2));
        BlockDispenser.dispenseBehaviorRegistry.putObject(diamondjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 3));
        BlockDispenser.dispenseBehaviorRegistry.putObject(goldjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(), 4));

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
        String name = item.getUnlocalizedName();
        String[] strings = name.split("\\.");
        name = strings[strings.length - 1];

        GameRegistry.registerItem(item, name);
    }
}
