package com.github.revival.server.handler;

import com.github.revival.server.item.FAItemRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

import java.util.Random;

public class FossilTradeHandler implements IVillageTradeHandler {
    @Override
    public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
        recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 3), new ItemStack(FAItemRegistry.biofossil, 1, 0)));
        recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 12), new ItemStack(FAItemRegistry.stonejavelin, 2, 0)));
        recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 14), new ItemStack(FAItemRegistry.chickenEss, 24, 0)));
        // recipeList.add(new MerchantRecipe(new ItemStack(Item.emerald, 2, Revival.relic, 5 ), new ItemStack(Revival.stoneboard, 1, 0)));
        recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 23), new ItemStack(FAItemRegistry.cookedDinoMeat, 4, 0)));
        recipeList.add(new MerchantRecipe(new ItemStack(FAItemRegistry.fernSeed, 13), new ItemStack(Items.emerald, 1, 0)));
    }
}