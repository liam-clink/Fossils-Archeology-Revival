package fossilsarcheology.server.villager;

import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

import java.util.Random;

public class FossilTradeHandler implements EntityVillager.ITradeList {
    @Override
    public void modifyMerchantRecipeList(MerchantRecipeList recipeList, Random random) {
        recipeList.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 3), new ItemStack(FAItemRegistry.INSTANCE.biofossil, 1, 0)));
        recipeList.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 12), new ItemStack(FAItemRegistry.INSTANCE.stonejavelin, 2, 0)));
        recipeList.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 14), new ItemStack(FAItemRegistry.INSTANCE.chickenEssence, 24, 0)));
        // recipeList.add(new MerchantRecipe(new ItemStack(Item.EMERALD, 2,
        // Revival.relic, 5 ), new ItemStack(Revival.stoneboard, 1, 0)));
        recipeList.add(new MerchantRecipe(new ItemStack(FAItemRegistry.INSTANCE.fernSeed, 13), new ItemStack(Items.EMERALD, 1, 0)));
    }
}