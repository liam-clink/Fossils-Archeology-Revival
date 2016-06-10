package com.github.revival.server.enums;

import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.entity.mob.*;
import com.github.revival.server.item.BirdEggItem;
import com.github.revival.server.item.DinoEggItem;
import com.github.revival.server.item.ItemFish;
import com.github.revival.server.item.MammalEmbryoItem;
import com.github.revival.server.item.forge.ForgeFoodItem;

import cpw.mods.fml.common.registry.GameRegistry;
import fossilsarcheology.api.EnumDiet;
import io.netty.util.internal.ThreadLocalRandom;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.*;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum EnumPrehistoric {

    Nautilus(EntityNautilus.class, EnumMobType.FISH, EnumTimePeriod.MESOZOIC, EnumDiet.NONE, I.NOTHING, true, 0XC55F47, 0XF5F5F5), Coelacanth(EntityCoelacanth.class, EnumMobType.FISH, EnumTimePeriod.MESOZOIC, EnumDiet.NONE, I.NOTHING, true, 0X363941, 0X9BA1A9), Alligator_Gar(EntityAlligatorGar.class, EnumMobType.FISH, EnumTimePeriod.MESOZOIC, EnumDiet.NONE, I.NOTHING, true, 0X43462A, 0XAF4231), Sturgeon(EntitySturgeon.class, EnumMobType.FISH, EnumTimePeriod.MESOZOIC, EnumDiet.NONE, I.NOTHING, true, 0X655D5B, 0XE6E3E3), Triceratops(EntityTriceratops.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.HERBIVORE, I.MODEL | I.TAME | I.RIDE | I.HERBIVORE, true, 0X64352D, 0X251A17, 0.8F), Velociraptor(EntityVelociraptor.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.CARNIVORE_EGG, I.TAME | I.CARNIVORE, true, 0X4A0D04, 0XC9C9C9, 0.5F), Tyrannosaurus(EntityTyrannosaurus.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.CARNIVORE, I.MODEL | I.TAME | I.RIDE | I.CARNIVORE, true, 0X9D8A74, 0X4C3116, 0.9F), Pterosaur(EntityPterosaur.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.PISCIVORE, I.MODEL | I.TAME | I.CARNIVORE, true, 0XD6D6D6, 0X3B3B3B, 0.4F), Plesiosaur(EntityPlesiosaurus.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.PISCIVORE, I.MODEL | I.TAME | I.RIDE | I.CARNIVORE, true, 0XE4A86E, 0XE17920), Mosasaurus(EntityMosasaurus.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.PISCCARNIVORE, I.MODEL | I.CARNIVORE, true, 0X888D90, 0X3A4C52), Stegosaurus(EntityStegosaurus.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.HERBIVORE, I.MODEL | I.TAME | I.HERBIVORE, true, 0X9C8138, 0X651817, 0.7F), Dilophosaurus(EntityDilophosaurus.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.CARNIVORE, I.TAME | I.CARNIVORE, true, 0X4E5931, 0XF25314, 0.5F), Brachiosaurus(EntityBrachiosaurus.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.HERBIVORE, I.MODEL | I.TAME | I.RIDE | I.HERBIVORE, true, 0X52523E, 0X222114), Spinosaurus(EntitySpinosaurus.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.PISCCARNIVORE, I.MODEL | I.CARNIVORE, true, 0X84512A, 0X562F20, 0.8F), Compsognathus(EntityCompsognathus.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.CARNIVORE, I.MODEL | I.TAME | I.CARNIVORE, true, 0XCBC7C4, 0X3A312C, 0.2F), Ankylosaurus(EntityAnkylosaurus.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.HERBIVORE, I.MODEL | I.TAME | I.RIDE | I.HERBIVORE, true, 0X8A5B49, 0X211B13, 0.7F), Pachycephalosaurus(EntityPachycephalosaurus.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.HERBIVORE, I.TAME | I.HERBIVORE, true, 0XB6A989, 0X7D5E3A, 0.6F), Deinonychus(EntityDeinonychus.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.CARNIVORE_EGG, I.MODEL | I.TAME | I.CARNIVORE, true, 0X2B2424, 0XC8C8C8, 0.6F), Gallimimus(EntityGallimimus.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.OMNIVORE, I.MODEL | I.TAME | I.RIDE | I.HERB_CARN, true, 0X66412B, 0X5E2518, 0.5F), Liopleurodon(EntityLiopleurodon.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.PISCCARNIVORE, I.MODEL | I.CARNIVORE, true, 0XBFC7C2, 0X1D211E), Allosaurus(EntityAllosaurus.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.CARNIVORE, I.MODEL | I.TAME | I.RIDE | I.CARNIVORE, true, 0X907B6C, 0X5F422D, 0.8F), Sarcosuchus(EntitySarcosuchus.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.PISCCARNIVORE, I.TAME | I.CARNIVORE, true, 0X4B4929, 0X8D8C65, 0.7F), Ceratosaurus(EntityCeratosaurus.class, EnumMobType.DINOSAUR, EnumTimePeriod.MESOZOIC, EnumDiet.CARNIVORE, I.MODEL | I.TAME | I.RIDE | I.CARNIVORE, true, 0XB4B4A7, 0X776446, 0.6F), Confuciusornis(EntityConfuciusornis.class, EnumMobType.BIRD, EnumTimePeriod.MESOZOIC, EnumDiet.HERBIVORE, I.TAME | I.HERBIVORE, true, 0XDAE5E9, 0X8B8B8D), Dodo(EntityDodo.class, EnumMobType.BIRD, EnumTimePeriod.CENOZOIC, EnumDiet.HERBIVORE, I.TAME | I.HERBIVORE, true, 0X655751, 0XBEA47B), Gastornis(EntityGastornis.class, EnumMobType.BIRD, EnumTimePeriod.CENOZOIC, EnumDiet.HERBIVORE, I.TAME, true, 0X346C5E, 0XC8C8C8), Kelenken(EntityKelenken.class, EnumMobType.BIRD, EnumTimePeriod.CENOZOIC, EnumDiet.CARNIVORE, I.TAME, true, 0X392F24, 0XF2EBD5), Phorusrhacos(EntityPhorusrhacos.class, EnumMobType.BIRD, EnumTimePeriod.CENOZOIC, EnumDiet.CARNIVORE, I.TAME, true, 0X5F4E3E, 0XD4D4D4), Titanis(EntityTitanis.class, EnumMobType.BIRD, EnumTimePeriod.CENOZOIC, EnumDiet.CARNIVORE, I.TAME, true, 0X484848, 0XEFEFEF), Mammoth(EntityMammoth.class, EnumMobType.MAMMAL, EnumTimePeriod.CENOZOIC, EnumDiet.HERBIVORE, I.TAME | I.RIDE | I.HERBIVORE, true, 0X3D2E19, 0X24170B), Smilodon(EntitySmilodon.class, EnumMobType.MAMMAL, EnumTimePeriod.CENOZOIC, EnumDiet.CARNIVORE, I.TAME | I.CARNIVORE, true, 0XB88C64, 0XECDFCE), Quagga(EntityQuagga.class, EnumMobType.MAMMAL, EnumTimePeriod.CENOZOIC, EnumDiet.HERBIVORE, I.TAME | I.RIDE | I.HERBIVORE, true, 0X763C24, 0XD3B9AB), Elasmotherium(EntityElasmotherium.class, EnumMobType.MAMMAL, EnumTimePeriod.CENOZOIC, EnumDiet.HERBIVORE, I.TAME | I.RIDE | I.HERBIVORE, true, 0X6B321B, 0X666666), Pig(EntityPig.class, EnumMobType.VANILLA, EnumTimePeriod.CURRENT, EnumDiet.OMNIVORE, I.NOTHING, false, 0, 0), Cow(EntityCow.class, EnumMobType.VANILLA, EnumTimePeriod.CURRENT, EnumDiet.HERBIVORE, I.NOTHING, false, 0, 0), Sheep(EntitySheep.class, EnumMobType.VANILLA, EnumTimePeriod.CURRENT, EnumDiet.HERBIVORE, I.NOTHING, false, 0, 0), Horse(EntityHorse.class, EnumMobType.VANILLA, EnumTimePeriod.CURRENT, EnumDiet.HERBIVORE, I.NOTHING, false, 0, 0), Chicken(EntityChicken.class, EnumMobType.CHICKEN, EnumTimePeriod.CURRENT, EnumDiet.HERBIVORE, I.NOTHING, false, 0, 0);

    private static float sizeBaby = 1;
    private static float sizeTeen = 1;
    private static float sizeAdult = 1;
    private final Class<? extends Entity> dinoClass;
    public EnumMobType type;
    public EnumDiet diet;
    public EnumTimePeriod timeperiod;
    public int MaxAge = 999;
    public int AdultAge = 6;
    public int TeenAge = 3;
    public double Health0 = 20;
    public double HealthMax = 20;
    public double Strength0 = 2;
    public double StrengthMax = 2;
    public double Speed0 = 0.25D;
    public double SpeedMax = 0.3D;
    public int BreedingTicks = 3000;
    public int AgingTicks = 12000;
    public int MaxHunger = 100;
    public float HungryLevel = 0.8f;
    public float Exp0 = 1.0f;
    public float ExpInc = 0.2f;
    public int Flags = 0;
    public Item orderItem;
    public Item fishItem;
    public Item foodItem;
    public Item cookedFoodItem;
    public Item DNAItem;
    public Item eggItem;
    public Item embryoItem;
    public Item birdEggItem;
    public Item bestBirdEggItem;
    public int growTime = 100;
    public int mainSpawnColor;
    public int secondSpawnColor;
    public float eggScale;

    EnumPrehistoric(Class class0, EnumMobType animalType, EnumTimePeriod timeperiod, EnumDiet diet, int f0, boolean init, int mainSpawnColor, int secondSpawnColor) {
        this.dinoClass = class0;
        this.type = animalType;
        this.timeperiod = timeperiod;
        this.diet = diet;
        this.Flags = f0;
        this.mainSpawnColor = mainSpawnColor;
        this.secondSpawnColor = secondSpawnColor;
        this.eggScale = 1;
    }

    EnumPrehistoric(Class class0, EnumMobType animalType, EnumTimePeriod timeperiod, EnumDiet diet, int f0, boolean init, int mainSpawnColor, int secondSpawnColor, float eggScale) {
        this.dinoClass = class0;
        this.type = animalType;
        this.timeperiod = timeperiod;
        this.diet = diet;
        this.Flags = f0;
        this.mainSpawnColor = mainSpawnColor;
        this.secondSpawnColor = secondSpawnColor;
        this.eggScale = eggScale;
    }

    public static void init() {

        for (int i = 0; i < EnumPrehistoric.values().length; i++) {
            EnumPrehistoric.values()[i].DNAItem = new Item().setUnlocalizedName("dna" + EnumPrehistoric.values()[i].name()).setTextureName("fossil:prehistoric/dna/" + EnumPrehistoric.values()[i].name() + "_DNA").setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
            GameRegistry.registerItem(EnumPrehistoric.values()[i].DNAItem, "dna" + EnumPrehistoric.values()[i].name());
        }
        for (int i = 0; i < EnumPrehistoric.values().length; i++) {
            if (EnumPrehistoric.values()[i].type == EnumMobType.FISH) {
                EnumPrehistoric.values()[i].eggItem = new ItemFish(EnumPrehistoric.values()[i], true).setUnlocalizedName("egg" + EnumPrehistoric.values()[i].name()).setTextureName("fossil:prehistoric/dinoEggs/" + EnumPrehistoric.values()[i].name() + "_Egg").setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
                GameRegistry.registerItem(EnumPrehistoric.values()[i].eggItem, "egg" + EnumPrehistoric.values()[i].name());
            }
            if (EnumPrehistoric.values()[i].type == EnumMobType.DINOSAUR) {
                EnumPrehistoric.values()[i].eggItem = new DinoEggItem(EnumPrehistoric.values()[i]).setUnlocalizedName("egg" + EnumPrehistoric.values()[i].name()).setTextureName("fossil:prehistoric/dinoEggs/" + EnumPrehistoric.values()[i].name() + "_Egg").setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
                GameRegistry.registerItem(EnumPrehistoric.values()[i].eggItem, "egg" + EnumPrehistoric.values()[i].name());
            }
        }
        for (int i = 0; i < EnumPrehistoric.values().length; i++) {
            if (EnumPrehistoric.values()[i].type == EnumMobType.MAMMAL || EnumPrehistoric.values()[i].type == EnumMobType.VANILLA) {
                EnumPrehistoric.values()[i].embryoItem = new MammalEmbryoItem(i).setUnlocalizedName("embryo" + EnumPrehistoric.values()[i].name()).setTextureName("fossil:prehistoric/embryos/" + EnumPrehistoric.values()[i].name() + "_Syringe").setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
                GameRegistry.registerItem(EnumPrehistoric.values()[i].embryoItem, "embryo" + EnumPrehistoric.values()[i].name());
            }
        }
        for (int i = 0; i < EnumPrehistoric.values().length; i++) {
            if (EnumPrehistoric.values()[i].type == EnumMobType.FISH) {
                EnumPrehistoric.values()[i].fishItem = new ItemFish(EnumPrehistoric.values()[i], false).setUnlocalizedName("fish" + EnumPrehistoric.values()[i].name()).setTextureName("fossil:prehistoric/embryos/" + EnumPrehistoric.values()[i].name() + "_Syringe").setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
                GameRegistry.registerItem(EnumPrehistoric.values()[i].fishItem, "fish" + EnumPrehistoric.values()[i].name());
            }
        }
        for (int i = 0; i < EnumPrehistoric.values().length; i++) {
            if (EnumPrehistoric.values()[i].type == EnumMobType.BIRD) {
                EnumPrehistoric.values()[i].birdEggItem = new BirdEggItem(EnumPrehistoric.values()[i], false).setUnlocalizedName("egg" + EnumPrehistoric.values()[i].name()).setTextureName("fossil:prehistoric/birdEggs/Egg_" + EnumPrehistoric.values()[i].name()).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
                GameRegistry.registerItem(EnumPrehistoric.values()[i].birdEggItem, "egg" + EnumPrehistoric.values()[i].name());
            }
        }
        for (int i = 0; i < EnumPrehistoric.values().length; i++) {
            if (EnumPrehistoric.values()[i].type == EnumMobType.BIRD || EnumPrehistoric.values()[i].type == EnumMobType.CHICKEN) {
                EnumPrehistoric.values()[i].bestBirdEggItem = new BirdEggItem(EnumPrehistoric.values()[i], true).setUnlocalizedName("eggCultivated" + EnumPrehistoric.values()[i].name()).setTextureName("fossil:prehistoric/birdEggs/Egg_Cultivated_" + EnumPrehistoric.values()[i].name()).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
                GameRegistry.registerItem(EnumPrehistoric.values()[i].bestBirdEggItem, "eggCultivated" + EnumPrehistoric.values()[i].name());
            }
        }
        for (int i = 0; i < EnumPrehistoric.values().length; i++) {
            if (EnumPrehistoric.values()[i].timeperiod != EnumTimePeriod.CURRENT) {
                if (EnumPrehistoric.values()[i].type != EnumMobType.FISH) {
                    EnumPrehistoric.values()[i].foodItem = new ForgeFoodItem(3, 0.3F, true, "prehistoric/food/" + EnumPrehistoric.values()[i].name() + "_Meat").setUnlocalizedName("raw" + EnumPrehistoric.values()[i].name()).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
                    GameRegistry.registerItem(EnumPrehistoric.values()[i].foodItem, "raw" + EnumPrehistoric.values()[i].name());
                }
            }
        }
        for (int i = 0; i < EnumPrehistoric.values().length; i++) {
            if (EnumPrehistoric.values()[i].timeperiod != EnumTimePeriod.CURRENT && EnumPrehistoric.values()[i] != Nautilus) {
                EnumPrehistoric.values()[i].cookedFoodItem = new ForgeFoodItem(8, 0.8F, true, "prehistoric/cookedFood/" + EnumPrehistoric.values()[i].name() + "_Meat").setUnlocalizedName("cooked" + EnumPrehistoric.values()[i].name()).setCreativeTab(FATabRegistry.INSTANCE.tabFItems);
                GameRegistry.registerItem(EnumPrehistoric.values()[i].cookedFoodItem, "cooked" + EnumPrehistoric.values()[i].name());
            }
        }
    }

    public static boolean isDNA(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].DNAItem == i0) {
                return true;
            }
        }

        return false;
    }

    public static boolean isDinoEgg(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].type == EnumMobType.DINOSAUR) {
                if (values()[i].eggItem == i0) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * takes an Item and returns if it is a dino meat drop
     */
    public static boolean isFoodItem(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].foodItem == i0) {
                return true;
            }
        }

        return false;
    }

    /**
     * takes an item, if it is a dinos dropItem or EggItem, it returns the
     * corresponding DNA Item
     */
    public static Item getDNA(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].bestBirdEggItem == i0 || values()[i].birdEggItem == i0 || values()[i].embryoItem == i0 || values()[i].foodItem == i0 || values()[i].eggItem == i0) {
                return values()[i].DNAItem;
            }
        }

        return null;
    }

    public static boolean isEmbryo(Item item) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].type == EnumMobType.MAMMAL) {
                if (values()[i].embryoItem == item) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isBirdEgg(Item item) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].type == EnumMobType.BIRD) {

                if (values()[i].birdEggItem == item) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isBestBirdEgg(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].type == EnumMobType.BIRD || values()[i].type == EnumMobType.CHICKEN) {

                if (values()[i].bestBirdEggItem == i0) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * takes an item, if it is a dinos DNAItem or EggItem, it returns the
     * corresponding Drop Item
     */
    public static Item getFoodItem(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].bestBirdEggItem == i0 || values()[i].birdEggItem == i0 || values()[i].embryoItem == i0 || values()[i].DNAItem == i0 || values()[i].eggItem == i0) {
                return values()[i].foodItem;
            }
        }
        return null;
    }

    /**
     * takes an item, if it is a dinos DNAItem or DropItem, it returns the
     * corresponding Egg Item
     */
    public static Item getEgg(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].type == EnumMobType.DINOSAUR) {

                if (values()[i].foodItem == i0 || values()[i].DNAItem == i0) {
                    return values()[i].eggItem;
                }
            }
        }

        return null;
    }

    public static Item getEmbryo(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].type == EnumMobType.MAMMAL) {
                if (values()[i].DNAItem == i0 || values()[i].foodItem == i0) {
                    return values()[i].embryoItem;
                }
            }
        }

        return null;
    }

    public static Item getBirdEgg(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].type == EnumMobType.BIRD) {
                if (values()[i].bestBirdEggItem == i0 || values()[i].DNAItem == i0 || values()[i].foodItem == i0) {
                    return values()[i].birdEggItem;
                }
            }
        }

        return null;
    }

    public static Item getBestBirdEgg(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].type == EnumMobType.BIRD || values()[i].type == EnumMobType.CHICKEN) {

                if (values()[i].birdEggItem == i0 || values()[i].DNAItem == i0 || values()[i].foodItem == i0) {
                    return values()[i].bestBirdEggItem;
                }
            }
        }

        return null;
    }

    /**
     * takes an drop-,dna- or eggitem and gives the index, -1 means not found
     */
    public static int getIndex(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].bestBirdEggItem == i0 || values()[i].embryoItem == i0 || values()[i].birdEggItem == i0 || values()[i].DNAItem == i0 || values()[i].foodItem == i0 || values()[i].eggItem == i0) {
                return i;
            }
        }

        return -1;
    }

    public static EnumPrehistoric getRandomMezoic() {
        List<EnumPrehistoric> list = new ArrayList<EnumPrehistoric>();
        for (int i = 0; i < values().length; i++) {
            if (values()[i].timeperiod == EnumTimePeriod.MESOZOIC) {
                list.add(values()[i]);
            }
        }
        int index = new Random().nextInt(list.size());
        return list.get(index);

    }

    public static Item getRandomMesozoicDNA() {
        List<Item> list = new ArrayList<Item>();
        for (int i = 0; i < values().length; i++) {
            if (values()[i].timeperiod == EnumTimePeriod.MESOZOIC) {
                list.add(values()[i].DNAItem);
            }
        }
        int index = new Random().nextInt(list.size());
        return list.get(index);

    }

    public static EnumPrehistoric getRandomCenozoic() {
        List<EnumPrehistoric> list = new ArrayList<EnumPrehistoric>();
        for (int i = 0; i < values().length; i++) {
            if (values()[i].timeperiod == EnumTimePeriod.CENOZOIC) {
                list.add(values()[i]);
            }
        }
        int index = new Random().nextInt(list.size());
        return list.get(index);

    }

    public static EnumPrehistoric getRandom() {
        List<EnumPrehistoric> list = new ArrayList<EnumPrehistoric>();
        for (int i = 0; i < values().length; i++) {
            list.add(values()[i]);
        }
        int index = ThreadLocalRandom.current().nextInt(list.size());
        return list.get(index);

    }

    public Entity invokeClass(World world) {
        Entity entity = null;
        if (Entity.class.isAssignableFrom(dinoClass)) {
            try {
                entity = dinoClass.getDeclaredConstructor(World.class).newInstance(world);
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }
        return entity;
    }

    public static int getBones() {
        List<EnumPrehistoric> list = new ArrayList<EnumPrehistoric>();
        for (int i = 0; i < values().length; i++) {
            if (values()[i].timeperiod != EnumTimePeriod.CURRENT || values()[i].type != EnumMobType.FISH) {
                list.add(values()[i]);
            }
        }
        return list.size();

    }

    /**
     * sets the OrderItem,DropItem,DNAItem and EggItem for the Dino
     */
    private void setOrderItem(Item order) {
        this.orderItem = order;
    }

    private void setAges(int Teen, int Adult, int Max) {
        if (Teen > 0) {
            this.TeenAge = Teen;
        }

        if (Adult > 0) {
            this.AdultAge = Adult;
        }

        if (Max > 0) {
            this.MaxAge = Max;
        }
    }

    private void setDinoSize(float sizeBaby, float sizeTeen, float sizeAdult) {
        EnumPrehistoric.sizeBaby = sizeBaby;
        EnumPrehistoric.sizeTeen = sizeTeen;
        EnumPrehistoric.sizeAdult = sizeAdult;
    }

    /**
     * sets the min/max values for Health, Attack Damage, Speed, and the Max
     * Hunger Value
     */
    private void setProperties(double H0, double HMax, double Str0, double StrMax, double Sp0, double SpMax, int Hunger) {
        if (H0 > 0) {
            this.Health0 = H0;
        }

        if (Str0 > 0) {
            this.Strength0 = Str0;
        }

        if (Sp0 > 0) {
            this.Speed0 = Sp0;
        }

        if (HMax > 0) {
            this.HealthMax = HMax;
        }

        if (StrMax > 0) {
            this.StrengthMax = StrMax;
        }

        if (SpMax > 0) {
            this.SpeedMax = SpMax;
        }

        if (Hunger > 0) {
            this.MaxHunger = Hunger;
        }
    }

    /**
     * sets the breeding time, the aging time and the hungry-level Hungry level
     * h:below h*MaxHunger, the dinos starts looking for food, below
     * (1-h)*Maxhunger, the dino is starving
     */
    private void setAddProperties(int Breed, int Age, float HLevel) {
        if (Breed > 0) {
            this.BreedingTicks = Breed;
        }

        if (Age > 0) {
            this.AgingTicks = Age;
        }

        if (HLevel > 0) {
            this.HungryLevel = HLevel;
        }
    }

    public boolean isAquatic() {
        return this == Plesiosaur || this == Mosasaurus || this == Liopleurodon;
    }

    /**
     * sets the breeding time, the aging time and the hungry-level Hungry level
     * h:below h*MaxHunger, the dinos starts looking for food, below
     * (1-h)*Maxhunger, the dino is starving
     */
    private void setExperience(float E0, float EInc) {
        if (E0 > 0) {
            this.Exp0 = E0;
        }

        if (EInc > 0) {
            this.ExpInc = EInc;
        }
    }

    public Class getDinoClass() {
        return this.dinoClass;
    }

    public boolean isModelable() {
        return (this.Flags & I.MODEL) != 0;
    }

    public boolean isTameable() {
        return (this.Flags & I.TAME) != 0;
    }

    public boolean isRideable() {
        return (this.Flags & I.RIDE) != 0;
    }

    public boolean canCarryItems() {
        return (this.Flags & I.CARRY) != 0;
    }

    public boolean useFeeder() {
        return this.diet != EnumDiet.NONE && this.diet != EnumDiet.INSECTIVORE && this.diet != EnumDiet.PISCIVORE;
    }

    public boolean isHerbivore() {
        return (this.Flags & I.HERBIVORE) != 0;
    }

    public boolean isCarnivore() {
        return (this.Flags & I.CARNIVORE) != 0;
    }
}

interface I {
    int NOTHING = 0;

    int NO_FEEDER = 0;// Bits 0+1: Dinos Can't use Feeder at all
    int HERBIVORE = 1;// Bit 0: Dino can use Herbivore Part of Feeder
    int CARNIVORE = 2;// Bit 1: Dino can use Carnivore Part of Feeder
    int HERB_CARN = 3;// Bits 0+1: Dinos can use Herbivore and Carnivore Part of
    // Feeder

    int MODEL = 1 << 2; // Bit 2: Dino is Modelable
    int TAME = 1 << 3; // Bit 3: Dino is Tameable
    int RIDE = 1 << 4; // Bit 4: Dino is Rideable
    int CARRY = 1 << 5; // Bit 5: Dino can Carry Items

}
