package com.github.revival.misc;

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

import com.github.revival.common.api.EnumDiet;
import com.github.revival.common.api.FoodMappings;
import com.github.revival.common.block.FABlockRegistry;
import com.github.revival.common.entity.EntityDinoEgg;
import com.github.revival.common.entity.mob.EntityAllosaurus;
import com.github.revival.common.entity.mob.EntityAnkylosaurus;
import com.github.revival.common.entity.mob.EntityBrachiosaurus;
import com.github.revival.common.entity.mob.EntityCeratosaurus;
import com.github.revival.common.entity.mob.EntityCoelacanth;
import com.github.revival.common.entity.mob.EntityCompsognathus;
import com.github.revival.common.entity.mob.EntityConfuciusornis;
import com.github.revival.common.entity.mob.EntityDeinonychus;
import com.github.revival.common.entity.mob.EntityDilophosaurus;
import com.github.revival.common.entity.mob.EntityDodo;
import com.github.revival.common.entity.mob.EntityElasmotherium;
import com.github.revival.common.entity.mob.EntityGallimimus;
import com.github.revival.common.entity.mob.EntityLiopleurodon;
import com.github.revival.common.entity.mob.EntityMammoth;
import com.github.revival.common.entity.mob.EntityMosasaurus;
import com.github.revival.common.entity.mob.EntityNautilus;
import com.github.revival.common.entity.mob.EntityPachycephalosaurus;
import com.github.revival.common.entity.mob.EntityPterosaur;
import com.github.revival.common.entity.mob.EntityQuagga;
import com.github.revival.common.entity.mob.EntitySarcosuchus;
import com.github.revival.common.entity.mob.EntitySpinosaurus;
import com.github.revival.common.entity.mob.EntityStegosaurus;
import com.github.revival.common.entity.mob.EntityTerrorBird;
import com.github.revival.common.entity.mob.EntityTriceratops;
import com.github.revival.common.entity.mob.EntityTyrannosaurus;
import com.github.revival.common.entity.mob.EntityVelociraptor;
import com.github.revival.common.enums.EnumMobType;
import com.github.revival.common.enums.EnumPrehistoric;
import com.github.revival.common.enums.EnumTimePeriod;
import com.github.revival.common.item.FAItemRegistry;

public class FossilFoodMappings {

	public static void init(){
		FoodMappings.instance().addToItemMappings(Items.wheat, 13, EnumDiet.HERBIVORE);
		FoodMappings.instance().addToItemMappings(Items.melon, 10, EnumDiet.HERBIVORE);
		FoodMappings.instance().addToItemMappings(Items.apple, 20, EnumDiet.HERBIVORE);
		FoodMappings.instance().addToItemMappings(Items.baked_potato, 35, EnumDiet.HERBIVORE);
		FoodMappings.instance().addToItemMappings(Items.cake, 50, EnumDiet.HERBIVORE);
		FoodMappings.instance().addToItemMappings(Items.carrot, 15, EnumDiet.HERBIVORE);
		FoodMappings.instance().addToItemMappings(Items.cookie, 10, EnumDiet.HERBIVORE);
		FoodMappings.instance().addToItemMappings(Items.pumpkin_pie, 25, EnumDiet.HERBIVORE);
		FoodMappings.instance().addToItemMappings(Items.sugar, 7, EnumDiet.HERBIVORE);
		FoodMappings.instance().addToItemMappings(Items.bread, 25, EnumDiet.HERBIVORE);
		FoodMappings.instance().addToItemMappings(Items.wheat_seeds, 5, EnumDiet.HERBIVORE);
		FoodMappings.instance().addToItemMappings(Items.melon_seeds, 5, EnumDiet.HERBIVORE);
		FoodMappings.instance().addToItemMappings(Items.pumpkin_seeds, 5, EnumDiet.HERBIVORE);
		FoodMappings.instance().addToItemMappings(Items.fish, 30, EnumDiet.PISCIVORE);
		FoodMappings.instance().addToItemMappings(Items.cooked_fished, 45, EnumDiet.PISCIVORE);
		FoodMappings.instance().addToItemMappings(Items.cooked_beef, 60, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToItemMappings(Items.beef, 40, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToItemMappings(Items.cooked_chicken, 15, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToItemMappings(Items.chicken, 10, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToItemMappings(Items.porkchop, 35, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToItemMappings(Items.cooked_porkchop, 55, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToItemMappings(Items.egg, 7, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToItemMappings(FAItemRegistry.sjl, 65, EnumDiet.PISCIVORE);
		FoodMappings.instance().addToItemMappings(FAItemRegistry.failuresaurusFlesh, 15, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToItemMappings(FAItemRegistry.livingCoelacanth, 35, EnumDiet.PISCIVORE);
		for(int i = 0; i < EnumPrehistoric.values().length; i++)
		{
			if(EnumPrehistoric.values()[i].timeperiod != EnumTimePeriod.CURRENT){
				if(EnumPrehistoric.values()[i].type != EnumMobType.FISH){
					FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].foodItem, 35, EnumDiet.CARNIVORE);
				}else{

				}
				FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].cookedFoodItem, 75, EnumDiet.CARNIVORE);
			}
			if(EnumPrehistoric.values()[i].type == EnumMobType.BIRD || EnumPrehistoric.values()[i].type == EnumMobType.CHICKEN){
				FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].bestBirdEggItem, 15, EnumDiet.CARNIVORE_EGG);
				if(EnumPrehistoric.values()[i].type != EnumMobType.CHICKEN){
					FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].birdEggItem, 10, EnumDiet.CARNIVORE_EGG);

				}
			}
		}
		FoodMappings.instance().addToItemMappings(Items.wheat, 13, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.melon, 10, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.apple, 20, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.baked_potato, 35, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.cake, 50, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.carrot, 15, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.cookie, 10, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.pumpkin_pie, 25, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.sugar, 7, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.bread, 25, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.wheat_seeds, 5, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.melon_seeds, 5, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.pumpkin_seeds, 5, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.cooked_beef, 60, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.beef, 40, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.cooked_chicken, 15, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.chicken, 10, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.porkchop, 35, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.cooked_porkchop, 55, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(Items.egg, 7, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToItemMappings(FAItemRegistry.failuresaurusFlesh, 15, EnumDiet.OMNIVORE);
		for(int i = 0; i < EnumPrehistoric.values().length; i++)
		{
			if(EnumPrehistoric.values()[i].timeperiod != EnumTimePeriod.CURRENT){
				if(EnumPrehistoric.values()[i].type != EnumMobType.FISH){
					FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].foodItem, 35, EnumDiet.OMNIVORE);
				}else{

				}
				FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].cookedFoodItem, 75, EnumDiet.OMNIVORE);
			}
			if(EnumPrehistoric.values()[i].type == EnumMobType.BIRD || EnumPrehistoric.values()[i].type == EnumMobType.CHICKEN){
				FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].bestBirdEggItem, 15, EnumDiet.OMNIVORE);
				if(EnumPrehistoric.values()[i].type != EnumMobType.CHICKEN){
					FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].birdEggItem, 10, EnumDiet.OMNIVORE);

				}
			}
		}
		FoodMappings.instance().addToItemMappings(Items.cooked_beef, 60, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToItemMappings(Items.beef, 40, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToItemMappings(Items.cooked_chicken, 15, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToItemMappings(Items.chicken, 10, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToItemMappings(Items.porkchop, 35, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToItemMappings(Items.cooked_porkchop, 55, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToItemMappings(Items.egg, 7, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToItemMappings(FAItemRegistry.failuresaurusFlesh, 15, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToItemMappings(Items.fish, 30, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToItemMappings(Items.cooked_fished, 45, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToItemMappings(FAItemRegistry.livingCoelacanth, 35, EnumDiet.PISCCARNIVORE);
		for(int i = 0; i < EnumPrehistoric.values().length; i++)
		{
			if(EnumPrehistoric.values()[i].timeperiod != EnumTimePeriod.CURRENT){
				if(EnumPrehistoric.values()[i].type != EnumMobType.FISH){
					FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].foodItem, 35, EnumDiet.PISCCARNIVORE);
				}else{

				}
				FoodMappings.instance().addToItemMappings(EnumPrehistoric.values()[i].cookedFoodItem, 75, EnumDiet.PISCCARNIVORE);
			}
		}
		FoodMappings.instance().addToBlockMappings(Blocks.cake, 35, EnumDiet.HERBIVORE, false);
		FoodMappings.instance().addToBlockMappings(Blocks.carrots, 20, EnumDiet.HERBIVORE, false);
		FoodMappings.instance().addToBlockMappings(Blocks.wheat, 10, EnumDiet.HERBIVORE, false);
		FoodMappings.instance().addToBlockMappings(Blocks.leaves, 20, EnumDiet.HERBIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.melon_block, 65, EnumDiet.HERBIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.brown_mushroom, 15, EnumDiet.HERBIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.red_mushroom, 15, EnumDiet.HERBIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.red_flower, 5, EnumDiet.HERBIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.yellow_flower, 5, EnumDiet.HERBIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.potatoes, 25, EnumDiet.HERBIVORE, false);
		FoodMappings.instance().addToBlockMappings(Blocks.pumpkin, 30, EnumDiet.HERBIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.reeds, 15, EnumDiet.HERBIVORE, false);
		FoodMappings.instance().addToBlockMappings(Blocks.sapling, 15, EnumDiet.HERBIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.tallgrass, 5, EnumDiet.HERBIVORE, true);
		FoodMappings.instance().addToBlockMappings(FABlockRegistry.ferns, 55, EnumDiet.HERBIVORE, false);
		FoodMappings.instance().addToBlockMappings(FABlockRegistry.palmLeaves, 40, EnumDiet.HERBIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.cake, 35, EnumDiet.OMNIVORE, false);
		FoodMappings.instance().addToBlockMappings(Blocks.carrots, 20, EnumDiet.OMNIVORE, false);
		FoodMappings.instance().addToBlockMappings(Blocks.wheat, 10, EnumDiet.OMNIVORE, false);
		FoodMappings.instance().addToBlockMappings(Blocks.leaves, 20, EnumDiet.OMNIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.melon_block, 65, EnumDiet.OMNIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.brown_mushroom, 15, EnumDiet.OMNIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.red_mushroom, 15, EnumDiet.OMNIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.red_flower, 5, EnumDiet.OMNIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.yellow_flower, 5, EnumDiet.OMNIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.potatoes, 25, EnumDiet.OMNIVORE, false);
		FoodMappings.instance().addToBlockMappings(Blocks.pumpkin, 30, EnumDiet.OMNIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.reeds, 15, EnumDiet.OMNIVORE, false);
		FoodMappings.instance().addToBlockMappings(Blocks.sapling, 15, EnumDiet.OMNIVORE, true);
		FoodMappings.instance().addToBlockMappings(Blocks.tallgrass, 5, EnumDiet.OMNIVORE, true);
		FoodMappings.instance().addToBlockMappings(FABlockRegistry.ferns, 55, EnumDiet.OMNIVORE, false);
		FoodMappings.instance().addToBlockMappings(FABlockRegistry.palmLeaves, 40, EnumDiet.OMNIVORE, true);
		FoodMappings.instance().addToEntityMappings(EntityPlayer.class, 27, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityVillager.class, 27, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityZombie.class, 23, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityChicken.class, 5, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityCow.class, 40, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityHorse.class, 55, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityPig.class, 20, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntitySheep.class, 35, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntitySquid.class, 30, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityNautilus.class, 100, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityTriceratops.class, 50, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityVelociraptor.class, 20, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityTyrannosaurus.class, 70, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityPterosaur.class, 35, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityMosasaurus.class, 50, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntitySarcosuchus.class, 50, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityLiopleurodon.class, 50, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityStegosaurus.class, 50, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityDilophosaurus.class, 25, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityBrachiosaurus.class, 90, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntitySpinosaurus.class, 70, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityCompsognathus.class, 10, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityAnkylosaurus.class, 50, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityPachycephalosaurus.class, 50, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityDeinonychus.class, 35, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityGallimimus.class, 40, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityAllosaurus.class, 25, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityDodo.class, 20, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityCoelacanth.class, 20, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityQuagga.class, 50, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityTerrorBird.class, 40, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityMammoth.class, 100, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityElasmotherium.class, 80, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityConfuciusornis.class, 15, EnumDiet.CARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityCeratosaurus.class, 25, EnumDiet.CARNIVORE);	
		FoodMappings.instance().addToEntityMappings(EntityPlayer.class, 27, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityVillager.class, 27, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityZombie.class, 23, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityChicken.class, 5, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityCow.class, 40, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityHorse.class, 55, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityPig.class, 20, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntitySheep.class, 35, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntitySquid.class, 30, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityNautilus.class, 100, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityTriceratops.class, 50, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityVelociraptor.class, 20, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityTyrannosaurus.class, 70, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityPterosaur.class, 35, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityMosasaurus.class, 50, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntitySarcosuchus.class, 50, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityLiopleurodon.class, 50, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityStegosaurus.class, 50, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityDilophosaurus.class, 25, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityBrachiosaurus.class, 90, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntitySpinosaurus.class, 70, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityCompsognathus.class, 10, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityAnkylosaurus.class, 50, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityPachycephalosaurus.class, 50, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityDeinonychus.class, 35, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityGallimimus.class, 40, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityAllosaurus.class, 25, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityDodo.class, 20, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityCoelacanth.class, 20, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityQuagga.class, 50, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityTerrorBird.class, 40, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityMammoth.class, 100, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityElasmotherium.class, 80, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityConfuciusornis.class, 15, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityCeratosaurus.class, 25, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityDinoEgg.class, 25, EnumDiet.CARNIVORE_EGG);
		FoodMappings.instance().addToEntityMappings(EntityPlayer.class, 27, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityVillager.class, 27, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityZombie.class, 23, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityChicken.class, 5, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityCow.class, 40, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityHorse.class, 55, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityPig.class, 20, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntitySheep.class, 35, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntitySquid.class, 30, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityNautilus.class, 100, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityTriceratops.class, 50, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityVelociraptor.class, 20, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityTyrannosaurus.class, 70, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityPterosaur.class, 35, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityMosasaurus.class, 50, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntitySarcosuchus.class, 50, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityLiopleurodon.class, 50, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityStegosaurus.class, 50, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityDilophosaurus.class, 25, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityBrachiosaurus.class, 90, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntitySpinosaurus.class, 70, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityCompsognathus.class, 10, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityAnkylosaurus.class, 50, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityPachycephalosaurus.class, 50, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityDeinonychus.class, 35, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityGallimimus.class, 40, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityAllosaurus.class, 25, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityDodo.class, 20, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityCoelacanth.class, 20, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityQuagga.class, 50, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityTerrorBird.class, 40, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityMammoth.class, 100, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityElasmotherium.class, 80, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityConfuciusornis.class, 15, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityCeratosaurus.class, 25, EnumDiet.OMNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityPlayer.class, 27, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityVillager.class, 27, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityZombie.class, 23, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityChicken.class, 5, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityCow.class, 40, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityHorse.class, 55, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityPig.class, 20, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntitySheep.class, 35, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntitySquid.class, 30, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityNautilus.class, 100, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityTriceratops.class, 50, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityVelociraptor.class, 20, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityTyrannosaurus.class, 70, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityPterosaur.class, 35, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityMosasaurus.class, 50, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntitySarcosuchus.class, 50, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityLiopleurodon.class, 50, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityStegosaurus.class, 50, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityDilophosaurus.class, 25, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityBrachiosaurus.class, 90, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntitySpinosaurus.class, 70, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityCompsognathus.class, 10, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityAnkylosaurus.class, 50, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityPachycephalosaurus.class, 50, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityDeinonychus.class, 35, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityGallimimus.class, 40, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityAllosaurus.class, 25, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityDodo.class, 20, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityCoelacanth.class, 20, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityQuagga.class, 50, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityTerrorBird.class, 40, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityMammoth.class, 100, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityElasmotherium.class, 80, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityConfuciusornis.class, 15, EnumDiet.PISCCARNIVORE);
		FoodMappings.instance().addToEntityMappings(EntityCeratosaurus.class, 25, EnumDiet.PISCCARNIVORE);
	}
}
