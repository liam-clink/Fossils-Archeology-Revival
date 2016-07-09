package fossilsarcheology.server.util;

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
import fossilsarcheology.api.EnumDiet;
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
import fossilsarcheology.server.enums.EnumMobType;
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.enums.EnumTimePeriod;
import fossilsarcheology.server.item.FAItemRegistry;

public class FossilFoodMappings {

    public static void init() {
        FoodMappings.INSTANCE.addPlant(Items.reeds, 15);
        FoodMappings.INSTANCE.addPlant(Items.wheat, 13);
        FoodMappings.INSTANCE.addPlant(Items.melon, 10);
        FoodMappings.INSTANCE.addPlant(Items.apple, 20);
        FoodMappings.INSTANCE.addPlant(Items.potato, 35);
        FoodMappings.INSTANCE.addPlant(Items.baked_potato, 35);
        FoodMappings.INSTANCE.addPlant(Items.cake, 50);
        FoodMappings.INSTANCE.addPlant(Items.carrot, 15);
        FoodMappings.INSTANCE.addPlant(Items.cookie, 10);
        FoodMappings.INSTANCE.addPlant(Items.pumpkin_pie, 25);
        FoodMappings.INSTANCE.addPlant(Items.sugar, 7);
        FoodMappings.INSTANCE.addPlant(Items.bread, 25);
        FoodMappings.INSTANCE.addPlant(Items.wheat_seeds, 5);
        FoodMappings.INSTANCE.addPlant(Items.melon_seeds, 5);
        FoodMappings.INSTANCE.addPlant(Items.pumpkin_seeds, 5);
        FoodMappings.INSTANCE.addPlant(Blocks.cake, 35);
        FoodMappings.INSTANCE.addPlant(Blocks.carrots, 20);
        FoodMappings.INSTANCE.addPlant(Blocks.wheat, 10);
        FoodMappings.INSTANCE.addPlant(Blocks.leaves, 20);
        FoodMappings.INSTANCE.addPlant(Blocks.melon_block, 65);
        FoodMappings.INSTANCE.addPlant(Blocks.brown_mushroom, 15);
        FoodMappings.INSTANCE.addPlant(Blocks.red_mushroom, 15);
        FoodMappings.INSTANCE.addPlant(Blocks.red_flower, 5);
        FoodMappings.INSTANCE.addPlant(Blocks.yellow_flower, 5);
        FoodMappings.INSTANCE.addPlant(Blocks.potatoes, 25);
        FoodMappings.INSTANCE.addPlant(Blocks.pumpkin, 30);
        FoodMappings.INSTANCE.addPlant(Blocks.reeds, 15);
        FoodMappings.INSTANCE.addPlant(Blocks.sapling, 15);
        FoodMappings.INSTANCE.addPlant(Blocks.tallgrass, 5);
        FoodMappings.INSTANCE.addPlant(FABlockRegistry.INSTANCE.ferns, 55);
        FoodMappings.INSTANCE.addPlant(FABlockRegistry.INSTANCE.palmLeaves, 40);
        
        FoodMappings.INSTANCE.addFish(Items.fish, 30);
        FoodMappings.INSTANCE.addFish(Items.cooked_fished, 45);
        FoodMappings.INSTANCE.addFish(FAItemRegistry.INSTANCE.sjl, 65);
        
        FoodMappings.INSTANCE.addMeat(Items.cooked_beef, 60);
        FoodMappings.INSTANCE.addMeat(Items.beef, 40);
        FoodMappings.INSTANCE.addMeat(Items.cooked_chicken, 15);
        FoodMappings.INSTANCE.addMeat(Items.chicken, 10);
        FoodMappings.INSTANCE.addMeat(Items.porkchop, 35);
        FoodMappings.INSTANCE.addMeat(Items.cooked_porkchop, 55);
        FoodMappings.INSTANCE.addMeat(FAItemRegistry.INSTANCE.failuresaurusFlesh, 15);

        FoodMappings.INSTANCE.addEgg(Items.egg, 7);

        for (int i = 0; i < EnumPrehistoric.values().length; i++) {
            if (EnumPrehistoric.values()[i].timeperiod != EnumTimePeriod.CURRENT) {
                if (EnumPrehistoric.values()[i].type != EnumMobType.FISH) {
                    FoodMappings.INSTANCE.addMeat(EnumPrehistoric.values()[i].foodItem, 35);
                    FoodMappings.INSTANCE.addMeat(EnumPrehistoric.values()[i].cookedFoodItem, 7);
                } else {
                    FoodMappings.INSTANCE.addFish(EnumPrehistoric.values()[i].eggItem, 35);
                    FoodMappings.INSTANCE.addFish(EnumPrehistoric.values()[i].fishItem, 35);
                    FoodMappings.INSTANCE.addFish(EnumPrehistoric.values()[i].cookedFoodItem, 75);
                }
            }
            if (EnumPrehistoric.values()[i].type == EnumMobType.BIRD || EnumPrehistoric.values()[i].type == EnumMobType.CHICKEN) {
                FoodMappings.INSTANCE.addEgg(EnumPrehistoric.values()[i].bestBirdEggItem, 15);
                if (EnumPrehistoric.values()[i].type != EnumMobType.CHICKEN) {
                    FoodMappings.INSTANCE.addEgg(EnumPrehistoric.values()[i].birdEggItem, 10);
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

        
        FoodMappings.INSTANCE.removeItemMapping(EnumPrehistoric.Horse.embryoItem, EnumDiet.CARNIVORE_EGG);
    }
}
