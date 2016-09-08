package fossilsarcheology.server.util;

import fossilsarcheology.api.Diet;
import fossilsarcheology.api.FoodMappings;
import fossilsarcheology.server.block.FABlockRegistry;
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
import fossilsarcheology.server.entity.mob.EntityKelenken;
import fossilsarcheology.server.entity.mob.EntityLiopleurodon;
import fossilsarcheology.server.entity.mob.EntityMammoth;
import fossilsarcheology.server.entity.mob.EntityMosasaurus;
import fossilsarcheology.server.entity.mob.EntityNautilus;
import fossilsarcheology.server.entity.mob.EntityPachycephalosaurus;
import fossilsarcheology.server.entity.mob.EntityPhorusrhacos;
import fossilsarcheology.server.entity.mob.EntityPterosaur;
import fossilsarcheology.server.entity.mob.EntityQuagga;
import fossilsarcheology.server.entity.mob.EntitySarcosuchus;
import fossilsarcheology.server.entity.mob.EntitySpinosaurus;
import fossilsarcheology.server.entity.mob.EntityStegosaurus;
import fossilsarcheology.server.entity.mob.EntitySturgeon;
import fossilsarcheology.server.entity.mob.EntityTitanis;
import fossilsarcheology.server.entity.mob.EntityTriceratops;
import fossilsarcheology.server.entity.mob.EntityTyrannosaurus;
import fossilsarcheology.server.entity.mob.EntityVelociraptor;
import fossilsarcheology.server.enums.MobType;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import fossilsarcheology.server.enums.TimePeriod;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class FossilFoodMappings {

    public static void init() {
        FoodMappings.INSTANCE.addPlant(Items.REEDS, 15);
        FoodMappings.INSTANCE.addPlant(Items.WHEAT, 13);
        FoodMappings.INSTANCE.addPlant(Items.MELON, 10);
        FoodMappings.INSTANCE.addPlant(Items.APPLE, 20);
        FoodMappings.INSTANCE.addPlant(Items.POTATO, 35);
        FoodMappings.INSTANCE.addPlant(Items.BAKED_POTATO, 35);
        FoodMappings.INSTANCE.addPlant(Items.CAKE, 50);
        FoodMappings.INSTANCE.addPlant(Items.CARROT, 15);
        FoodMappings.INSTANCE.addPlant(Items.COOKIE, 10);
        FoodMappings.INSTANCE.addPlant(Items.PUMPKIN_PIE, 25);
        FoodMappings.INSTANCE.addPlant(Items.SUGAR, 7);
        FoodMappings.INSTANCE.addPlant(Items.BREAD, 25);
        FoodMappings.INSTANCE.addPlant(Items.WHEAT_SEEDS, 5);
        FoodMappings.INSTANCE.addPlant(Items.MELON_SEEDS, 5);
        FoodMappings.INSTANCE.addPlant(Items.PUMPKIN_SEEDS, 5);
        FoodMappings.INSTANCE.addPlant(Blocks.CAKE, 35);
        FoodMappings.INSTANCE.addPlant(Blocks.CARROTS, 20);
        FoodMappings.INSTANCE.addPlant(Blocks.WHEAT, 10);
        FoodMappings.INSTANCE.addPlant(Blocks.LEAVES, 20);
        FoodMappings.INSTANCE.addPlant(Blocks.MELON_BLOCK, 65);
        FoodMappings.INSTANCE.addPlant(Blocks.BROWN_MUSHROOM, 15);
        FoodMappings.INSTANCE.addPlant(Blocks.RED_MUSHROOM, 15);
        FoodMappings.INSTANCE.addPlant(Blocks.RED_FLOWER, 5);
        FoodMappings.INSTANCE.addPlant(Blocks.YELLOW_FLOWER, 5);
        FoodMappings.INSTANCE.addPlant(Blocks.POTATOES, 25);
        FoodMappings.INSTANCE.addPlant(Blocks.PUMPKIN, 30);
        FoodMappings.INSTANCE.addPlant(Blocks.REEDS, 15);
        FoodMappings.INSTANCE.addPlant(Blocks.SAPLING, 15);
        FoodMappings.INSTANCE.addPlant(Blocks.TALLGRASS, 5);
        FoodMappings.INSTANCE.addPlant(FABlockRegistry.INSTANCE.ferns, 55);
        FoodMappings.INSTANCE.addPlant(FABlockRegistry.INSTANCE.palmLeaves, 40);

        FoodMappings.INSTANCE.addFish(Items.FISH, 30);
        FoodMappings.INSTANCE.addFish(Items.COOKED_FISH, 45);
        FoodMappings.INSTANCE.addFish(FAItemRegistry.INSTANCE.sjl, 65);

        FoodMappings.INSTANCE.addMeat(Items.COOKED_BEEF, 60);
        FoodMappings.INSTANCE.addMeat(Items.BEEF, 40);
        FoodMappings.INSTANCE.addMeat(Items.COOKED_CHICKEN, 15);
        FoodMappings.INSTANCE.addMeat(Items.CHICKEN, 10);
        FoodMappings.INSTANCE.addMeat(Items.PORKCHOP, 35);
        FoodMappings.INSTANCE.addMeat(Items.COOKED_PORKCHOP, 55);
        FoodMappings.INSTANCE.addMeat(FAItemRegistry.INSTANCE.failuresaurusFlesh, 15);

        FoodMappings.INSTANCE.addEgg(Items.EGG, 7);

        for (PrehistoricEntityType type : PrehistoricEntityType.values()) {
            if (type.timePeriod != TimePeriod.CURRENT) {
                if (type.mobType != MobType.FISH) {
                    FoodMappings.INSTANCE.addMeat(type.foodItem, 35);
                    FoodMappings.INSTANCE.addMeat(type.cookedFoodItem, 7);
                } else {
                    FoodMappings.INSTANCE.addFish(type.eggItem, 35);
                    FoodMappings.INSTANCE.addFish(type.fishItem, 35);
                    FoodMappings.INSTANCE.addFish(type.cookedFoodItem, 75);
                }
            }
            if (type.mobType == MobType.BIRD || type.mobType == MobType.CHICKEN) {
                FoodMappings.INSTANCE.addEgg(type.bestBirdEggItem, 15);
                if (type.mobType != MobType.CHICKEN) {
                    FoodMappings.INSTANCE.addEgg(type.birdEggItem, 10);
                }
            }
        }

        FoodMappings.INSTANCE.addMeat(EntityPlayer.class, 27);
        FoodMappings.INSTANCE.addMeat(EntityPlayerMP.class, 27);
        FoodMappings.INSTANCE.addMeat(EntityVillager.class, 27);
        FoodMappings.INSTANCE.addMeat(EntityZombie.class, 23);
        FoodMappings.INSTANCE.addMeat(EntityChicken.class, 5);
        FoodMappings.INSTANCE.addMeat(EntityCow.class, 40);
        FoodMappings.INSTANCE.addMeat(EntityHorse.class, 55);
        FoodMappings.INSTANCE.addMeat(EntityPig.class, 20);
        FoodMappings.INSTANCE.addMeat(EntitySheep.class, 35);
        FoodMappings.INSTANCE.addMeat(EntitySquid.class, 30);
        FoodMappings.INSTANCE.addMeat(EntityNautilus.class, 100);
        FoodMappings.INSTANCE.addMeat(EntityTriceratops.class, 50);
        FoodMappings.INSTANCE.addMeat(EntityVelociraptor.class, 20);
        FoodMappings.INSTANCE.addMeat(EntityTyrannosaurus.class, 70);
        FoodMappings.INSTANCE.addMeat(EntityPterosaur.class, 35);
        FoodMappings.INSTANCE.addMeat(EntityMosasaurus.class, 50);
        FoodMappings.INSTANCE.addMeat(EntitySarcosuchus.class, 50);
        FoodMappings.INSTANCE.addMeat(EntityLiopleurodon.class, 50);
        FoodMappings.INSTANCE.addMeat(EntityStegosaurus.class, 50);
        FoodMappings.INSTANCE.addMeat(EntityDilophosaurus.class, 25);
        FoodMappings.INSTANCE.addMeat(EntityBrachiosaurus.class, 90);
        FoodMappings.INSTANCE.addMeat(EntitySpinosaurus.class, 70);
        FoodMappings.INSTANCE.addMeat(EntityCompsognathus.class, 10);
        FoodMappings.INSTANCE.addMeat(EntityAnkylosaurus.class, 50);
        FoodMappings.INSTANCE.addMeat(EntityPachycephalosaurus.class, 50);
        FoodMappings.INSTANCE.addMeat(EntityDeinonychus.class, 35);
        FoodMappings.INSTANCE.addMeat(EntityGallimimus.class, 40);
        FoodMappings.INSTANCE.addMeat(EntityAllosaurus.class, 25);
        FoodMappings.INSTANCE.addMeat(EntityDodo.class, 20);
        FoodMappings.INSTANCE.addMeat(EntityQuagga.class, 50);
        FoodMappings.INSTANCE.addMeat(EntityTitanis.class, 40);
        FoodMappings.INSTANCE.addMeat(EntityPhorusrhacos.class, 40);
        FoodMappings.INSTANCE.addMeat(EntityKelenken.class, 40);
        FoodMappings.INSTANCE.addMeat(EntityTitanis.class, 40);
        FoodMappings.INSTANCE.addMeat(EntityMammoth.class, 100);
        FoodMappings.INSTANCE.addMeat(EntityElasmotherium.class, 80);
        FoodMappings.INSTANCE.addMeat(EntityConfuciusornis.class, 15);
        FoodMappings.INSTANCE.addMeat(EntityCeratosaurus.class, 25);

        FoodMappings.INSTANCE.addFish(EntityCoelacanth.class, 20);
        FoodMappings.INSTANCE.addFish(EntitySturgeon.class, 20);
        FoodMappings.INSTANCE.addFish(EntityAlligatorGar.class, 20);


        FoodMappings.INSTANCE.removeItemMapping(PrehistoricEntityType.HORSE.embryoItem, Diet.CARNIVORE_EGG);
    }
}
