package com.github.revival.server.util;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.entity.mob.EntityAlligatorGar;
import com.github.revival.server.entity.mob.EntityAllosaurus;
import com.github.revival.server.entity.mob.EntityAnkylosaurus;
import com.github.revival.server.entity.mob.EntityBrachiosaurus;
import com.github.revival.server.entity.mob.EntityCeratosaurus;
import com.github.revival.server.entity.mob.EntityCoelacanth;
import com.github.revival.server.entity.mob.EntityCompsognathus;
import com.github.revival.server.entity.mob.EntityConfuciusornis;
import com.github.revival.server.entity.mob.EntityDeinonychus;
import com.github.revival.server.entity.mob.EntityDilophosaurus;
import com.github.revival.server.entity.mob.EntityDodo;
import com.github.revival.server.entity.mob.EntityElasmotherium;
import com.github.revival.server.entity.mob.EntityGallimimus;
import com.github.revival.server.entity.mob.EntityKelenken;
import com.github.revival.server.entity.mob.EntityLiopleurodon;
import com.github.revival.server.entity.mob.EntityMammoth;
import com.github.revival.server.entity.mob.EntityMosasaurus;
import com.github.revival.server.entity.mob.EntityNautilus;
import com.github.revival.server.entity.mob.EntityPachycephalosaurus;
import com.github.revival.server.entity.mob.EntityPhorusrhacos;
import com.github.revival.server.entity.mob.EntityPterosaur;
import com.github.revival.server.entity.mob.EntityQuagga;
import com.github.revival.server.entity.mob.EntitySarcosuchus;
import com.github.revival.server.entity.mob.EntitySpinosaurus;
import com.github.revival.server.entity.mob.EntityStegosaurus;
import com.github.revival.server.entity.mob.EntitySturgeon;
import com.github.revival.server.entity.mob.EntityTitanis;
import com.github.revival.server.entity.mob.EntityTriceratops;
import com.github.revival.server.entity.mob.EntityTyrannosaurus;
import com.github.revival.server.entity.mob.EntityVelociraptor;
import com.github.revival.server.enums.EnumMobType;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumTimePeriod;
import com.github.revival.server.item.FAItemRegistry;

import fossilsarcheology.api.EnumDiet;
import fossilsarcheology.api.FoodMappings;

public class FossilFoodMappings {

    public static void init() {
        FoodMappings.instance().addPlant(Items.reeds, 15);
        FoodMappings.instance().addPlant(Items.wheat, 13);
        FoodMappings.instance().addPlant(Items.melon, 10);
        FoodMappings.instance().addPlant(Items.apple, 20);
        FoodMappings.instance().addPlant(Items.baked_potato, 35);
        FoodMappings.instance().addPlant(Items.cake, 50);
        FoodMappings.instance().addPlant(Items.carrot, 15);
        FoodMappings.instance().addPlant(Items.cookie, 10);
        FoodMappings.instance().addPlant(Items.pumpkin_pie, 25);
        FoodMappings.instance().addPlant(Items.sugar, 7);
        FoodMappings.instance().addPlant(Items.bread, 25);
        FoodMappings.instance().addPlant(Items.wheat_seeds, 5);
        FoodMappings.instance().addPlant(Items.melon_seeds, 5);
        FoodMappings.instance().addPlant(Items.pumpkin_seeds, 5);
        FoodMappings.instance().addPlant(Blocks.cake, 35);
        FoodMappings.instance().addPlant(Blocks.carrots, 20);
        FoodMappings.instance().addPlant(Blocks.wheat, 10);
        FoodMappings.instance().addPlant(Blocks.leaves, 20);
        FoodMappings.instance().addPlant(Blocks.melon_block, 65);
        FoodMappings.instance().addPlant(Blocks.brown_mushroom, 15);
        FoodMappings.instance().addPlant(Blocks.red_mushroom, 15);
        FoodMappings.instance().addPlant(Blocks.red_flower, 5);
        FoodMappings.instance().addPlant(Blocks.yellow_flower, 5);
        FoodMappings.instance().addPlant(Blocks.potatoes, 25);
        FoodMappings.instance().addPlant(Blocks.pumpkin, 30);
        FoodMappings.instance().addPlant(Blocks.reeds, 15);
        FoodMappings.instance().addPlant(Blocks.sapling, 15);
        FoodMappings.instance().addPlant(Blocks.tallgrass, 5);
        FoodMappings.instance().addPlant(FABlockRegistry.INSTANCE.ferns, 55);
        FoodMappings.instance().addPlant(FABlockRegistry.INSTANCE.palmLeaves, 40);
        
        FoodMappings.instance().addFish(Items.fish, 30);
        FoodMappings.instance().addFish(Items.cooked_fished, 45);
        FoodMappings.instance().addFish(FAItemRegistry.INSTANCE.sjl, 65);
        
        FoodMappings.instance().addMeat(Items.cooked_beef, 60);
        FoodMappings.instance().addMeat(Items.beef, 40);
        FoodMappings.instance().addMeat(Items.cooked_chicken, 15);
        FoodMappings.instance().addMeat(Items.chicken, 10);
        FoodMappings.instance().addMeat(Items.porkchop, 35);
        FoodMappings.instance().addMeat(Items.cooked_porkchop, 55);
        FoodMappings.instance().addMeat(FAItemRegistry.INSTANCE.failuresaurusFlesh, 15);

        FoodMappings.instance().addEgg(Items.egg, 7);

        for (int i = 0; i < EnumPrehistoric.values().length; i++) {
            if (EnumPrehistoric.values()[i].timeperiod != EnumTimePeriod.CURRENT) {
                if (EnumPrehistoric.values()[i].type != EnumMobType.FISH) {
                    FoodMappings.instance().addMeat(EnumPrehistoric.values()[i].foodItem, 35);
                    FoodMappings.instance().addMeat(EnumPrehistoric.values()[i].cookedFoodItem, 7);
                } else {
                    FoodMappings.instance().addFish(EnumPrehistoric.values()[i].eggItem, 35);
                    FoodMappings.instance().addFish(EnumPrehistoric.values()[i].fishItem, 35);
                    FoodMappings.instance().addFish(EnumPrehistoric.values()[i].cookedFoodItem, 75);
                }
            }
            if (EnumPrehistoric.values()[i].type == EnumMobType.BIRD || EnumPrehistoric.values()[i].type == EnumMobType.CHICKEN) {
                FoodMappings.instance().addEgg(EnumPrehistoric.values()[i].bestBirdEggItem, 15);
                if (EnumPrehistoric.values()[i].type != EnumMobType.CHICKEN) {
                    FoodMappings.instance().addEgg(EnumPrehistoric.values()[i].birdEggItem, 10);
                }
            }
        }

        FoodMappings.instance().addMeat(EntityPlayer.class, 27);
        FoodMappings.instance().addMeat(EntityVillager.class, 27);
        FoodMappings.instance().addMeat(EntityZombie.class, 23);
        FoodMappings.instance().addMeat(EntityChicken.class, 5);
        FoodMappings.instance().addMeat(EntityCow.class, 40);
        FoodMappings.instance().addMeat(EntityHorse.class, 55);
        FoodMappings.instance().addMeat(EntityPig.class, 20);
        FoodMappings.instance().addMeat(EntitySheep.class, 35);
        FoodMappings.instance().addMeat(EntitySquid.class, 30);
        FoodMappings.instance().addMeat(EntityNautilus.class, 100);
        FoodMappings.instance().addMeat(EntityTriceratops.class, 50);
        FoodMappings.instance().addMeat(EntityVelociraptor.class, 20);
        FoodMappings.instance().addMeat(EntityTyrannosaurus.class, 70);
        FoodMappings.instance().addMeat(EntityPterosaur.class, 35);
        FoodMappings.instance().addMeat(EntityMosasaurus.class, 50);
        FoodMappings.instance().addMeat(EntitySarcosuchus.class, 50);
        FoodMappings.instance().addMeat(EntityLiopleurodon.class, 50);
        FoodMappings.instance().addMeat(EntityStegosaurus.class, 50);
        FoodMappings.instance().addMeat(EntityDilophosaurus.class, 25);
        FoodMappings.instance().addMeat(EntityBrachiosaurus.class, 90);
        FoodMappings.instance().addMeat(EntitySpinosaurus.class, 70);
        FoodMappings.instance().addMeat(EntityCompsognathus.class, 10);
        FoodMappings.instance().addMeat(EntityAnkylosaurus.class, 50);
        FoodMappings.instance().addMeat(EntityPachycephalosaurus.class, 50);
        FoodMappings.instance().addMeat(EntityDeinonychus.class, 35);
        FoodMappings.instance().addMeat(EntityGallimimus.class, 40);
        FoodMappings.instance().addMeat(EntityAllosaurus.class, 25);
        FoodMappings.instance().addMeat(EntityDodo.class, 20);
        FoodMappings.instance().addMeat(EntityQuagga.class, 50);
        FoodMappings.instance().addMeat(EntityTitanis.class, 40);
        FoodMappings.instance().addMeat(EntityPhorusrhacos.class, 40);
        FoodMappings.instance().addMeat(EntityKelenken.class, 40);
        FoodMappings.instance().addMeat(EntityTitanis.class, 40);
        FoodMappings.instance().addMeat(EntityMammoth.class, 100);
        FoodMappings.instance().addMeat(EntityElasmotherium.class, 80);
        FoodMappings.instance().addMeat(EntityConfuciusornis.class, 15);
        FoodMappings.instance().addMeat(EntityCeratosaurus.class, 25);

        FoodMappings.instance().addFish(EntityCoelacanth.class, 20);
        FoodMappings.instance().addFish(EntitySturgeon.class, 20);
        FoodMappings.instance().addFish(EntityAlligatorGar.class, 20);

        
        FoodMappings.instance().removeItemMapping(EnumPrehistoric.Horse.embryoItem, EnumDiet.CARNIVORE_EGG);
    }
}
