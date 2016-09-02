package fossilsarcheology.server.enums;

import fossilsarcheology.Revival;
import fossilsarcheology.api.Diet;
import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.entity.mob.EntityAlligatorGar;
import fossilsarcheology.server.entity.mob.EntityAllosaurus;
import fossilsarcheology.server.entity.mob.EntityAnkylosaurus;
import fossilsarcheology.server.entity.mob.EntityBrachiosaurus;
import fossilsarcheology.server.entity.mob.EntityCeratosaurus;
import fossilsarcheology.server.entity.mob.EntityCoelacanth;
import fossilsarcheology.server.entity.mob.EntityCompsognathus;
import fossilsarcheology.server.entity.mob.EntityConfuciusornis;
import fossilsarcheology.server.entity.mob.EntityDeinonychus;
import fossilsarcheology.server.entity.mob.EntityDilophosaurus;
import fossilsarcheology.server.entity.mob.EntityDodo;
import fossilsarcheology.server.entity.mob.EntityElasmotherium;
import fossilsarcheology.server.entity.mob.EntityGallimimus;
import fossilsarcheology.server.entity.mob.EntityGastornis;
import fossilsarcheology.server.entity.mob.EntityKelenken;
import fossilsarcheology.server.entity.mob.EntityLiopleurodon;
import fossilsarcheology.server.entity.mob.EntityMammoth;
import fossilsarcheology.server.entity.mob.EntityMosasaurus;
import fossilsarcheology.server.entity.mob.EntityNautilus;
import fossilsarcheology.server.entity.mob.EntityPachycephalosaurus;
import fossilsarcheology.server.entity.mob.EntityPhorusrhacos;
import fossilsarcheology.server.entity.mob.EntityPlesiosaurus;
import fossilsarcheology.server.entity.mob.EntityPterosaur;
import fossilsarcheology.server.entity.mob.EntityQuagga;
import fossilsarcheology.server.entity.mob.EntitySarcosuchus;
import fossilsarcheology.server.entity.mob.EntitySmilodon;
import fossilsarcheology.server.entity.mob.EntitySpinosaurus;
import fossilsarcheology.server.entity.mob.EntityStegosaurus;
import fossilsarcheology.server.entity.mob.EntitySturgeon;
import fossilsarcheology.server.entity.mob.EntityTitanis;
import fossilsarcheology.server.entity.mob.EntityTriceratops;
import fossilsarcheology.server.entity.mob.EntityTyrannosaurus;
import fossilsarcheology.server.entity.mob.EntityVelociraptor;
import fossilsarcheology.server.item.BirdEggItem;
import fossilsarcheology.server.item.DinoEggItem;
import fossilsarcheology.server.item.ItemFish;
import fossilsarcheology.server.item.MammalEmbryoItem;
import io.netty.util.internal.ThreadLocalRandom;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum PrehistoricEntityType {
    NAUTILUS(EntityNautilus.class, MobType.FISH, TimePeriod.MESOZOIC, Diet.NONE, Parameter.NOTHING, 0XC55F47, 0XF5F5F5),
    COELACANTH(EntityCoelacanth.class, MobType.FISH, TimePeriod.MESOZOIC, Diet.NONE, Parameter.NOTHING, 0X363941, 0X9BA1A9),
    ALLIGATOR_GAR(EntityAlligatorGar.class, MobType.FISH, TimePeriod.MESOZOIC, Diet.NONE, Parameter.NOTHING, 0X43462A, 0XAF4231),
    STURGEON(EntitySturgeon.class, MobType.FISH, TimePeriod.MESOZOIC, Diet.NONE, Parameter.NOTHING, 0X655D5B, 0XE6E3E3),
    TRICERATOPS(EntityTriceratops.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE, Parameter.MODEL | Parameter.TAME | Parameter.RIDE | Parameter.HERBIVORE, 0X64352D, 0X251A17, 0.8F),
    VELOCIRAPTOR(EntityVelociraptor.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE_EGG, Parameter.TAME | Parameter.CARNIVORE, 0X4A0D04, 0XC9C9C9, 0.5F),
    TYRANNOSAURUS(EntityTyrannosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE, Parameter.MODEL | Parameter.TAME | Parameter.RIDE | Parameter.CARNIVORE, 0X9D8A74, 0X4C3116, 0.9F),
    PTEROSAUR(EntityPterosaur.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.PISCIVORE, Parameter.MODEL | Parameter.TAME | Parameter.CARNIVORE, 0XD6D6D6, 0X3B3B3B, 0.4F),
    PLESIOSAUR(EntityPlesiosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.PISCIVORE, Parameter.MODEL | Parameter.TAME | Parameter.RIDE | Parameter.CARNIVORE, 0XE4A86E, 0XE17920),
    MOSASAURUS(EntityMosasaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.PISCCARNIVORE, Parameter.MODEL | Parameter.CARNIVORE, 0X888D90, 0X3A4C52),
    STEGOSAURUS(EntityStegosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE, Parameter.MODEL | Parameter.TAME | Parameter.HERBIVORE, 0X9C8138, 0X651817, 0.7F),
    DILOPHOSAURUS(EntityDilophosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE, Parameter.TAME | Parameter.CARNIVORE, 0X4E5931, 0XF25314, 0.5F),
    BRACHIOSAURUS(EntityBrachiosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE, Parameter.MODEL | Parameter.TAME | Parameter.RIDE | Parameter.HERBIVORE, 0X52523E, 0X222114),
    SPINOSAURUS(EntitySpinosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.PISCCARNIVORE, Parameter.MODEL | Parameter.CARNIVORE, 0X84512A, 0X562F20, 0.8F),
    COMPSOGNATHUS(EntityCompsognathus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE, Parameter.MODEL | Parameter.TAME | Parameter.CARNIVORE, 0XCBC7C4, 0X3A312C, 0.2F),
    ANKYLOSAURUS(EntityAnkylosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE, Parameter.MODEL | Parameter.TAME | Parameter.RIDE | Parameter.HERBIVORE, 0X8A5B49, 0X211B13, 0.7F),
    PACHYCEPHALOSAURUS(EntityPachycephalosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE, Parameter.TAME | Parameter.HERBIVORE, 0XB6A989, 0X7D5E3A, 0.6F),
    DEINONYCHUS(EntityDeinonychus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE_EGG, Parameter.MODEL | Parameter.TAME | Parameter.CARNIVORE, 0X2B2424, 0XC8C8C8, 0.6F),
    GALLIMIMUS(EntityGallimimus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.OMNIVORE, Parameter.MODEL | Parameter.TAME | Parameter.RIDE | Parameter.HERB_CARN, 0X66412B, 0X5E2518, 0.5F),
    LIOPLEURODON(EntityLiopleurodon.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.PISCCARNIVORE, Parameter.MODEL | Parameter.CARNIVORE, 0XBFC7C2, 0X1D211E),
    ALLOSAURUS(EntityAllosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE, Parameter.MODEL | Parameter.TAME | Parameter.RIDE | Parameter.CARNIVORE, 0X907B6C, 0X5F422D, 0.8F),
    SARCOSUCHUS(EntitySarcosuchus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.PISCCARNIVORE, Parameter.TAME | Parameter.CARNIVORE, 0X4B4929, 0X8D8C65, 0.7F),
    CERATOSAURUS(EntityCeratosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE, Parameter.MODEL | Parameter.TAME | Parameter.RIDE | Parameter.CARNIVORE, 0XB4B4A7, 0X776446, 0.6F),
    CONFUCIUSORNIS(EntityConfuciusornis.class, MobType.BIRD, TimePeriod.MESOZOIC, Diet.HERBIVORE, Parameter.TAME | Parameter.HERBIVORE, 0XDAE5E9, 0X8B8B8D),
    DODO(EntityDodo.class, MobType.BIRD, TimePeriod.CENOZOIC, Diet.HERBIVORE, Parameter.TAME | Parameter.HERBIVORE, 0X655751, 0XBEA47B),
    GASTORNIS(EntityGastornis.class, MobType.BIRD, TimePeriod.CENOZOIC, Diet.HERBIVORE, Parameter.TAME, 0X346C5E, 0XC8C8C8),
    KELENKEN(EntityKelenken.class, MobType.BIRD, TimePeriod.CENOZOIC, Diet.CARNIVORE, Parameter.TAME, 0X392F24, 0XF2EBD5),
    PHORUSRHACOS(EntityPhorusrhacos.class, MobType.BIRD, TimePeriod.CENOZOIC, Diet.CARNIVORE, Parameter.TAME, 0X5F4E3E, 0XD4D4D4),
    TITANIS(EntityTitanis.class, MobType.BIRD, TimePeriod.CENOZOIC, Diet.CARNIVORE, Parameter.TAME, 0X484848, 0XEFEFEF),
    MAMMOTH(EntityMammoth.class, MobType.MAMMAL, TimePeriod.CENOZOIC, Diet.HERBIVORE, Parameter.TAME | Parameter.RIDE | Parameter.HERBIVORE, 0X3D2E19, 0X24170B),
    SMILODON(EntitySmilodon.class, MobType.MAMMAL, TimePeriod.CENOZOIC, Diet.CARNIVORE, Parameter.TAME | Parameter.CARNIVORE, 0XB88C64, 0XECDFCE),
    QUAGGA(EntityQuagga.class, MobType.MAMMAL, TimePeriod.CENOZOIC, Diet.HERBIVORE, Parameter.TAME | Parameter.RIDE | Parameter.HERBIVORE, 0X763C24, 0XD3B9AB),
    ELASMOTHERIUM(EntityElasmotherium.class, MobType.MAMMAL, TimePeriod.CENOZOIC, Diet.HERBIVORE, Parameter.TAME | Parameter.RIDE | Parameter.HERBIVORE, 0X6B321B, 0X666666),
    PIG(EntityPig.class, MobType.VANILLA, TimePeriod.CURRENT, Diet.OMNIVORE, Parameter.NOTHING, 0, 0),
    COW(EntityCow.class, MobType.VANILLA, TimePeriod.CURRENT, Diet.HERBIVORE, Parameter.NOTHING, 0, 0),
    SHEEP(EntitySheep.class, MobType.VANILLA, TimePeriod.CURRENT, Diet.HERBIVORE, Parameter.NOTHING, 0, 0),
    HORSE(EntityHorse.class, MobType.VANILLA, TimePeriod.CURRENT, Diet.HERBIVORE, Parameter.NOTHING, 0, 0),
    CHICKEN(EntityChicken.class, MobType.CHICKEN, TimePeriod.CURRENT, Diet.HERBIVORE, Parameter.NOTHING, 0, 0);

    private static float sizeBaby = 1;
    private static float sizeTeen = 1;
    private static float sizeAdult = 1;
    private final Class<? extends Entity> entity;
    public MobType mobType;
    public Diet diet;
    public TimePeriod timePeriod;
    public int maximimAge = 999;
    public int adultAge = 6;
    public int teenAge = 3;
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
    public int parameters = 0;
    public Item orderItem;
    public Item fishItem;
    public Item foodItem;
    public Item cookedFoodItem;
    public Item dnaItem;
    public Item eggItem;
    public Item embryoItem;
    public Item birdEggItem;
    public Item bestBirdEggItem;
    public int growTime = 10000;
    public int primaryEggColor;
    public int secondaryEggColor;
    public float eggScale;
    public String friendlyName;

    PrehistoricEntityType(Class entity, MobType mobType, TimePeriod period, Diet diet, int parameters, int primaryEggColor, int secondaryEggColor) {
        this.entity = entity;
        this.mobType = mobType;
        this.timePeriod = period;
        this.diet = diet;
        this.parameters = parameters;
        this.primaryEggColor = primaryEggColor;
        this.secondaryEggColor = secondaryEggColor;
        this.eggScale = 1;
        this.friendlyName = getFriendlyName().toUpperCase().substring(0, 1) + getFriendlyName().toLowerCase().substring(1);
    }

    PrehistoricEntityType(Class entity, MobType mobType, TimePeriod period, Diet diet, int parameters, int primaryEggColor, int secondaryEggColor, float eggScale) {
        this.entity = entity;
        this.mobType = mobType;
        this.timePeriod = period;
        this.diet = diet;
        this.parameters = parameters;
        this.primaryEggColor = primaryEggColor;
        this.secondaryEggColor = secondaryEggColor;
        this.eggScale = eggScale;
    }

    public static void init() {
        for (PrehistoricEntityType type : PrehistoricEntityType.values()) {
            MobType mobType = type.mobType;
            String friendlyName = type.getFriendlyName();
            type.dnaItem = new Item().setUnlocalizedName("dna" + friendlyName).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
            GameRegistry.register(type.dnaItem, new ResourceLocation(Revival.MODID, "dna" + friendlyName));
            if (mobType == MobType.FISH) {
                type.eggItem = new ItemFish(type, true);
                type.fishItem = new ItemFish(type, false).setUnlocalizedName("fish" + friendlyName).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
            } else if (mobType == MobType.DINOSAUR) {
                type.eggItem = new DinoEggItem(type);
            }
            if (type.eggItem != null) {
                type.eggItem.setUnlocalizedName("egg" + friendlyName).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
                GameRegistry.register(type.eggItem, new ResourceLocation(Revival.MODID, "egg" + friendlyName));
            }
            if (mobType == MobType.MAMMAL || mobType == MobType.VANILLA) {
                type.embryoItem = new MammalEmbryoItem(type).setUnlocalizedName("embryo" + friendlyName).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
                GameRegistry.register(type.embryoItem, new ResourceLocation(Revival.MODID, "embryo" + friendlyName));
            }
            if (mobType == MobType.BIRD || mobType == MobType.CHICKEN) {
                if (mobType == MobType.BIRD) {
                    type.birdEggItem = new BirdEggItem(type, false).setUnlocalizedName("egg" + friendlyName).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
                    GameRegistry.register(type.birdEggItem, new ResourceLocation(Revival.MODID, "egg" + friendlyName));
                }
                type.bestBirdEggItem = new BirdEggItem(type, true).setUnlocalizedName("eggCultivated" + friendlyName).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
                GameRegistry.register(type.birdEggItem, new ResourceLocation(Revival.MODID, "eggCultivated" + friendlyName));
            }
            if (type.timePeriod != TimePeriod.CURRENT) {
                if (type.mobType != MobType.FISH) {
                    type.foodItem = new ItemFood(3, 0.3F, true).setUnlocalizedName("raw" + friendlyName).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
                    GameRegistry.register(type.foodItem, new ResourceLocation(Revival.MODID, "raw" + friendlyName));
                }
                if (type != NAUTILUS) {
                    type.cookedFoodItem = new ItemFood(8, 0.8F, true).setUnlocalizedName("cooked" + friendlyName).setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
                    GameRegistry.register(type.cookedFoodItem, new ResourceLocation(Revival.MODID, "cooked" + friendlyName));
                }
            }
        }
    }

    public static boolean isDNA(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].dnaItem == i0) {
                return true;
            }
        }

        return false;
    }

    public static boolean isDinoEgg(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].mobType == MobType.DINOSAUR) {
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
                return values()[i].dnaItem;
            }
        }

        return null;
    }

    public static boolean isEmbryo(Item item) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].mobType == MobType.MAMMAL) {
                if (values()[i].embryoItem == item) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isBirdEgg(Item item) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].mobType == MobType.BIRD) {

                if (values()[i].birdEggItem == item) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isBestBirdEgg(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].mobType == MobType.BIRD || values()[i].mobType == MobType.CHICKEN) {

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
            if (values()[i].bestBirdEggItem == i0 || values()[i].birdEggItem == i0 || values()[i].embryoItem == i0 || values()[i].dnaItem == i0 || values()[i].eggItem == i0) {
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
            if (values()[i].mobType == MobType.DINOSAUR) {
                if (values()[i].foodItem == i0 || values()[i].dnaItem == i0) {
                    return values()[i].eggItem;
                }
            }
            if (values()[i].mobType == MobType.FISH) {
                if (values()[i].dnaItem == i0) {
                    return values()[i].eggItem;
                }
            }
        }

        return null;
    }

    public static Item getEmbryo(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].mobType == MobType.MAMMAL) {
                if (values()[i].dnaItem == i0 || values()[i].foodItem == i0) {
                    return values()[i].embryoItem;
                }
            }
        }

        return null;
    }

    public static Item getBirdEgg(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].mobType == MobType.BIRD) {
                if (values()[i].bestBirdEggItem == i0 || values()[i].dnaItem == i0 || values()[i].foodItem == i0) {
                    return values()[i].birdEggItem;
                }
            }
        }

        return null;
    }

    public static Item getBestBirdEgg(Item i0) {
        for (int i = 0; i < values().length; i++) {
            if (values()[i].mobType == MobType.BIRD || values()[i].mobType == MobType.CHICKEN) {

                if (values()[i].birdEggItem == i0 || values()[i].dnaItem == i0 || values()[i].foodItem == i0) {
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
            if (values()[i].bestBirdEggItem == i0 || values()[i].embryoItem == i0 || values()[i].birdEggItem == i0 || values()[i].dnaItem == i0 || values()[i].foodItem == i0 || values()[i].eggItem == i0) {
                return i;
            }
        }

        return -1;
    }

    public static PrehistoricEntityType getRandomMezoic() {
        List<PrehistoricEntityType> list = new ArrayList<PrehistoricEntityType>();
        for (int i = 0; i < values().length; i++) {
            if (values()[i].timePeriod == TimePeriod.MESOZOIC) {
                list.add(values()[i]);
            }
        }
        int index = new Random().nextInt(list.size());
        return list.get(index);

    }

    public static Item getRandomMesozoicDNA() {
        List<Item> list = new ArrayList<Item>();
        for (int i = 0; i < values().length; i++) {
            if (values()[i].timePeriod == TimePeriod.MESOZOIC) {
                list.add(values()[i].dnaItem);
            }
        }
        int index = new Random().nextInt(list.size());
        return list.get(index);

    }

    public static PrehistoricEntityType getRandomCenozoic() {
        List<PrehistoricEntityType> list = new ArrayList<PrehistoricEntityType>();
        for (int i = 0; i < values().length; i++) {
            if (values()[i].timePeriod == TimePeriod.CENOZOIC) {
                list.add(values()[i]);
            }
        }
        int index = new Random().nextInt(list.size());
        return list.get(index);

    }

    public static PrehistoricEntityType getRandomBioFossil(boolean tar) {
        List<PrehistoricEntityType> list = new ArrayList<PrehistoricEntityType>();
        for (int i = 0; i < values().length; i++) {
            if (values()[i].mobType != MobType.VANILLA && values()[i].mobType != MobType.CHICKEN && values()[i].mobType != MobType.FISH) {
                if (tar) {
                    if (values()[i].timePeriod == TimePeriod.CENOZOIC && EntityPrehistoric.class.isAssignableFrom(values()[i].entity)) {
                        list.add(values()[i]);
                    }
                } else {
                    if (values()[i].timePeriod == TimePeriod.MESOZOIC || values()[i].timePeriod == TimePeriod.PALEOZOIC) {
                        list.add(values()[i]);
                    }
                }
            }
        }
        int index = new Random().nextInt(list.size());
        return list.get(index);

    }


    public static PrehistoricEntityType getRandom() {
        List<PrehistoricEntityType> list = new ArrayList<PrehistoricEntityType>();
        for (int i = 0; i < values().length; i++) {
            list.add(values()[i]);
        }
        int index = ThreadLocalRandom.current().nextInt(list.size());
        return list.get(index);

    }

    public Entity invokeClass(World world) {
        Entity entity = null;
        if (Entity.class.isAssignableFrom(this.entity)) {
            try {
                entity = this.entity.getDeclaredConstructor(World.class).newInstance(world);
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }
        return entity;
    }

    public static int getBones() {
        List<PrehistoricEntityType> list = new ArrayList<PrehistoricEntityType>();
        for (int i = 0; i < values().length; i++) {
            if (values()[i].timePeriod != TimePeriod.CURRENT || values()[i].mobType != MobType.FISH) {
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
            this.teenAge = Teen;
        }

        if (Adult > 0) {
            this.adultAge = Adult;
        }

        if (Max > 0) {
            this.maximimAge = Max;
        }
    }

    private void setDinoSize(float sizeBaby, float sizeTeen, float sizeAdult) {
        PrehistoricEntityType.sizeBaby = sizeBaby;
        PrehistoricEntityType.sizeTeen = sizeTeen;
        PrehistoricEntityType.sizeAdult = sizeAdult;
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
        return this == PLESIOSAUR || this == MOSASAURUS || this == LIOPLEURODON;
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

    public Class getEntity() {
        return this.entity;
    }

    public boolean isModelable() {
        return (this.parameters & Parameter.MODEL) != 0;
    }

    public boolean isTameable() {
        return (this.parameters & Parameter.TAME) != 0;
    }

    public boolean isRideable() {
        return (this.parameters & Parameter.RIDE) != 0;
    }

    public boolean canCarryItems() {
        return (this.parameters & Parameter.CARRY) != 0;
    }

    public boolean useFeeder() {
        return this.diet != Diet.NONE && this.diet != Diet.INSECTIVORE && this.diet != Diet.PISCIVORE;
    }

    public boolean isHerbivore() {
        return (this.parameters & Parameter.HERBIVORE) != 0;
    }

    public boolean isCarnivore() {
        return (this.parameters & Parameter.CARNIVORE) != 0;
    }

    public String getFriendlyName() {
        return friendlyName;
    }
}

interface Parameter {
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
