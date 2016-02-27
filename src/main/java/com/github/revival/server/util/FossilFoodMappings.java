package com.github.revival.server.util;

import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.entity.DinoEggEntity;
import com.github.revival.server.entity.Diet;
import com.github.revival.server.entity.mob.*;
import com.github.revival.server.enums.EnumMobType;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.enums.EnumTimePeriod;
import com.github.revival.server.item.FAItemRegistry;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class FossilFoodMappings {

    public static void init() {
        FoodMappings.instance().addToItemMappings(Items.wheat, 13, Diet.HERBIVORE);
        FoodMappings.instance().addToItemMappings(Items.melon, 10, Diet.HERBIVORE);
        FoodMappings.instance().addToItemMappings(Items.apple, 20, Diet.HERBIVORE);
        FoodMappings.instance().addToItemMappings(Items.baked_potato, 35, Diet.HERBIVORE);
        FoodMappings.instance().addToItemMappings(Items.cake, 50, Diet.HERBIVORE);
        FoodMappings.instance().addToItemMappings(Items.carrot, 15, Diet.HERBIVORE);
        FoodMappings.instance().addToItemMappings(Items.cookie, 10, Diet.HERBIVORE);
        FoodMappings.instance().addToItemMappings(Items.pumpkin_pie, 25, Diet.HERBIVORE);
        FoodMappings.instance().addToItemMappings(Items.sugar, 7, Diet.HERBIVORE);
        FoodMappings.instance().addToItemMappings(Items.bread, 25, Diet.HERBIVORE);
        FoodMappings.instance().addToItemMappings(Items.wheat_seeds, 5, Diet.HERBIVORE);
        FoodMappings.instance().addToItemMappings(Items.melon_seeds, 5, Diet.HERBIVORE);
        FoodMappings.instance().addToItemMappings(Items.pumpkin_seeds, 5, Diet.HERBIVORE);
        FoodMappings.instance().addToItemMappings(Items.fish, 30, Diet.PISCIVORE);
        FoodMappings.instance().addToItemMappings(Items.cooked_fished, 45, Diet.PISCIVORE);
        FoodMappings.instance().addToItemMappings(Items.cooked_beef, 60, Diet.CARNIVORE);
        FoodMappings.instance().addToItemMappings(Items.beef, 40, Diet.CARNIVORE);
        FoodMappings.instance().addToItemMappings(Items.cooked_chicken, 15, Diet.CARNIVORE);
        FoodMappings.instance().addToItemMappings(Items.chicken, 10, Diet.CARNIVORE);
        FoodMappings.instance().addToItemMappings(Items.porkchop, 35, Diet.CARNIVORE);
        FoodMappings.instance().addToItemMappings(Items.cooked_porkchop, 55, Diet.CARNIVORE);
        FoodMappings.instance().addToItemMappings(Items.egg, 7, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToItemMappings(FAItemRegistry.sjl, 65, Diet.PISCIVORE);
        FoodMappings.instance().addToItemMappings(FAItemRegistry.failuresaurusFlesh, 15, Diet.CARNIVORE);
        FoodMappings.instance().addToItemMappings(FAItemRegistry.livingCoelacanth, 35, Diet.PISCIVORE);
        for (int i = 0; i < EnumPrehistoric.values().length; i++) {
            if (EnumPrehistoric.values()[i].timeperiod != EnumTimePeriod.CURRENT) {
                if (EnumPrehistoric.values()[i].type != EnumMobType.FISH) {
                    FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].foodItem, 35, Diet.CARNIVORE);
                } else {

                }
                FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].cookedFoodItem, 75, Diet.CARNIVORE);
            }
            if (EnumPrehistoric.values()[i].type == EnumMobType.BIRD || EnumPrehistoric.values()[i].type == EnumMobType.CHICKEN) {
                FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].bestBirdEggItem, 15, Diet.CARNIVORE_EGG);
                if (EnumPrehistoric.values()[i].type != EnumMobType.CHICKEN) {
                    FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].birdEggItem, 10, Diet.CARNIVORE_EGG);

                }
            }
        }
        FoodMappings.instance().addToItemMappings(Items.wheat, 13, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.melon, 10, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.apple, 20, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.baked_potato, 35, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.cake, 50, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.carrot, 15, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.cookie, 10, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.pumpkin_pie, 25, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.sugar, 7, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.bread, 25, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.wheat_seeds, 5, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.melon_seeds, 5, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.pumpkin_seeds, 5, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.cooked_beef, 60, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.beef, 40, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.cooked_chicken, 15, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.chicken, 10, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.porkchop, 35, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.cooked_porkchop, 55, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(Items.egg, 7, Diet.OMNIVORE);
        FoodMappings.instance().addToItemMappings(FAItemRegistry.failuresaurusFlesh, 15, Diet.OMNIVORE);
        for (int i = 0; i < EnumPrehistoric.values().length; i++) {
            if (EnumPrehistoric.values()[i].timeperiod != EnumTimePeriod.CURRENT) {
                if (EnumPrehistoric.values()[i].type != EnumMobType.FISH) {
                    FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].foodItem, 35, Diet.OMNIVORE);
                } else {

                }
                FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].cookedFoodItem, 75, Diet.OMNIVORE);
            }
            if (EnumPrehistoric.values()[i].type == EnumMobType.BIRD || EnumPrehistoric.values()[i].type == EnumMobType.CHICKEN) {
                FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].bestBirdEggItem, 15, Diet.OMNIVORE);
                if (EnumPrehistoric.values()[i].type != EnumMobType.CHICKEN) {
                    FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].birdEggItem, 10, Diet.OMNIVORE);

                }
            }
        }
        FoodMappings.instance().addToItemMappings(Items.cooked_beef, 60, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToItemMappings(Items.beef, 40, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToItemMappings(Items.cooked_chicken, 15, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToItemMappings(Items.chicken, 10, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToItemMappings(Items.porkchop, 35, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToItemMappings(Items.cooked_porkchop, 55, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToItemMappings(Items.egg, 7, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToItemMappings(FAItemRegistry.failuresaurusFlesh, 15, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToItemMappings(Items.fish, 30, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToItemMappings(Items.cooked_fished, 45, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToItemMappings(FAItemRegistry.livingCoelacanth, 35, Diet.PISCCARNIVORE);
        for (int i = 0; i < EnumPrehistoric.values().length; i++) {
            if (EnumPrehistoric.values()[i].timeperiod != EnumTimePeriod.CURRENT) {
                if (EnumPrehistoric.values()[i].type != EnumMobType.FISH) {
                    FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].foodItem, 35, Diet.PISCCARNIVORE);
                } else {

                }
                FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].cookedFoodItem, 75, Diet.PISCCARNIVORE);
            }
        }
        FoodMappings.instance().addToBlockMappings(Blocks.cake, 35, Diet.HERBIVORE, false);
        FoodMappings.instance().addToBlockMappings(Blocks.carrots, 20, Diet.HERBIVORE, false);
        FoodMappings.instance().addToBlockMappings(Blocks.wheat, 10, Diet.HERBIVORE, false);
        FoodMappings.instance().addToBlockMappings(Blocks.leaves, 20, Diet.HERBIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.melon_block, 65, Diet.HERBIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.brown_mushroom, 15, Diet.HERBIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.red_mushroom, 15, Diet.HERBIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.red_flower, 5, Diet.HERBIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.yellow_flower, 5, Diet.HERBIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.potatoes, 25, Diet.HERBIVORE, false);
        FoodMappings.instance().addToBlockMappings(Blocks.pumpkin, 30, Diet.HERBIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.reeds, 15, Diet.HERBIVORE, false);
        FoodMappings.instance().addToBlockMappings(Blocks.sapling, 15, Diet.HERBIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.tallgrass, 5, Diet.HERBIVORE, true);
        FoodMappings.instance().addToBlockMappings(FABlockRegistry.ferns, 55, Diet.HERBIVORE, false);
        FoodMappings.instance().addToBlockMappings(FABlockRegistry.palmLeaves, 40, Diet.HERBIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.cake, 35, Diet.OMNIVORE, false);
        FoodMappings.instance().addToBlockMappings(Blocks.carrots, 20, Diet.OMNIVORE, false);
        FoodMappings.instance().addToBlockMappings(Blocks.wheat, 10, Diet.OMNIVORE, false);
        FoodMappings.instance().addToBlockMappings(Blocks.leaves, 20, Diet.OMNIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.melon_block, 65, Diet.OMNIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.brown_mushroom, 15, Diet.OMNIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.red_mushroom, 15, Diet.OMNIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.red_flower, 5, Diet.OMNIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.yellow_flower, 5, Diet.OMNIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.potatoes, 25, Diet.OMNIVORE, false);
        FoodMappings.instance().addToBlockMappings(Blocks.pumpkin, 30, Diet.OMNIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.reeds, 15, Diet.OMNIVORE, false);
        FoodMappings.instance().addToBlockMappings(Blocks.sapling, 15, Diet.OMNIVORE, true);
        FoodMappings.instance().addToBlockMappings(Blocks.tallgrass, 5, Diet.OMNIVORE, true);
        FoodMappings.instance().addToBlockMappings(FABlockRegistry.ferns, 55, Diet.OMNIVORE, false);
        FoodMappings.instance().addToBlockMappings(FABlockRegistry.palmLeaves, 40, Diet.OMNIVORE, true);
        FoodMappings.instance().addToEntityMappings(EntityPlayer.class, 27, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityVillager.class, 27, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityZombie.class, 23, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityChicken.class, 5, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityCow.class, 40, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityHorse.class, 55, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityPig.class, 20, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntitySheep.class, 35, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntitySquid.class, 30, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(NautilusEntity.class, 100, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(TriceratopsEntity.class, 50, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(VelociraptorEntity.class, 20, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(TyrannosaurusEntity.class, 70, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(PterosaurEntity.class, 35, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(MosasaurusEntity.class, 50, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(SarcosuchusEntity.class, 50, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(LiopleurodonEntity.class, 50, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(StegosaurusEntity.class, 50, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(DilophosaurusEntity.class, 25, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(BrachiosaurusEntity.class, 90, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(SpinosaurusEntity.class, 70, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(CompsognathusEntity.class, 10, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(AnkylosaurusEntity.class, 50, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(PachycephalosaurusEntity.class, 50, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(DeinonychusEntity.class, 35, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(GallimimusEntity.class, 40, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(AllosaurusEntity.class, 25, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(DodoEntity.class, 20, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(CoelacanthEntity.class, 20, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(QuaggaEntity.class, 50, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(TerrorBirdEntity.class, 40, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(MammothEntity.class, 100, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(ElasmotheriumEntity.class, 80, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(ConfuciusornisEntity.class, 15, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(CeratosaurusEntity.class, 25, Diet.CARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityPlayer.class, 27, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(EntityVillager.class, 27, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(EntityZombie.class, 23, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(EntityChicken.class, 5, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(EntityCow.class, 40, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(EntityHorse.class, 55, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(EntityPig.class, 20, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(EntitySheep.class, 35, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(EntitySquid.class, 30, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(NautilusEntity.class, 100, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(TriceratopsEntity.class, 50, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(VelociraptorEntity.class, 20, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(TyrannosaurusEntity.class, 70, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(PterosaurEntity.class, 35, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(MosasaurusEntity.class, 50, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(SarcosuchusEntity.class, 50, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(LiopleurodonEntity.class, 50, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(StegosaurusEntity.class, 50, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(DilophosaurusEntity.class, 25, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(BrachiosaurusEntity.class, 90, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(SpinosaurusEntity.class, 70, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(CompsognathusEntity.class, 10, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(AnkylosaurusEntity.class, 50, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(PachycephalosaurusEntity.class, 50, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(DeinonychusEntity.class, 35, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(GallimimusEntity.class, 40, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(AllosaurusEntity.class, 25, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(DodoEntity.class, 20, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(CoelacanthEntity.class, 20, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(QuaggaEntity.class, 50, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(TerrorBirdEntity.class, 40, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(MammothEntity.class, 100, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(ElasmotheriumEntity.class, 80, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(ConfuciusornisEntity.class, 15, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(CeratosaurusEntity.class, 25, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(DinoEggEntity.class, 25, Diet.CARNIVORE_EGG);
        FoodMappings.instance().addToEntityMappings(EntityPlayer.class, 27, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityVillager.class, 27, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityZombie.class, 23, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityChicken.class, 5, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityCow.class, 40, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityHorse.class, 55, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityPig.class, 20, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(EntitySheep.class, 35, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(EntitySquid.class, 30, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(NautilusEntity.class, 100, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(TriceratopsEntity.class, 50, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(VelociraptorEntity.class, 20, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(TyrannosaurusEntity.class, 70, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(PterosaurEntity.class, 35, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(MosasaurusEntity.class, 50, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(SarcosuchusEntity.class, 50, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(LiopleurodonEntity.class, 50, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(StegosaurusEntity.class, 50, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(DilophosaurusEntity.class, 25, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(BrachiosaurusEntity.class, 90, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(SpinosaurusEntity.class, 70, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(CompsognathusEntity.class, 10, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(AnkylosaurusEntity.class, 50, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(PachycephalosaurusEntity.class, 50, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(DeinonychusEntity.class, 35, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(GallimimusEntity.class, 40, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(AllosaurusEntity.class, 25, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(DodoEntity.class, 20, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(CoelacanthEntity.class, 20, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(QuaggaEntity.class, 50, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(TerrorBirdEntity.class, 40, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(MammothEntity.class, 100, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(ElasmotheriumEntity.class, 80, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(ConfuciusornisEntity.class, 15, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(CeratosaurusEntity.class, 25, Diet.OMNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityPlayer.class, 27, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityVillager.class, 27, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityZombie.class, 23, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityChicken.class, 5, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityCow.class, 40, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityHorse.class, 55, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntityPig.class, 20, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntitySheep.class, 35, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(EntitySquid.class, 30, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(NautilusEntity.class, 100, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(TriceratopsEntity.class, 50, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(VelociraptorEntity.class, 20, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(TyrannosaurusEntity.class, 70, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(PterosaurEntity.class, 35, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(MosasaurusEntity.class, 50, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(SarcosuchusEntity.class, 50, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(LiopleurodonEntity.class, 50, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(StegosaurusEntity.class, 50, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(DilophosaurusEntity.class, 25, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(BrachiosaurusEntity.class, 90, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(SpinosaurusEntity.class, 70, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(CompsognathusEntity.class, 10, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(AnkylosaurusEntity.class, 50, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(PachycephalosaurusEntity.class, 50, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(DeinonychusEntity.class, 35, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(GallimimusEntity.class, 40, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(AllosaurusEntity.class, 25, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(DodoEntity.class, 20, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(CoelacanthEntity.class, 20, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(QuaggaEntity.class, 50, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(TerrorBirdEntity.class, 40, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(MammothEntity.class, 100, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(ElasmotheriumEntity.class, 80, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(ConfuciusornisEntity.class, 15, Diet.PISCCARNIVORE);
        FoodMappings.instance().addToEntityMappings(CeratosaurusEntity.class, 25, Diet.PISCCARNIVORE);
    }
}
