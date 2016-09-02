package fossilsarcheology.server.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum  SifterRecipies {
    INSTANCE;

    private Map<Item, ItemStack> recipes = new HashMap<>();
    private Map<ItemStack, Float> experienceAmounts = new HashMap<>();
    private Map<List<Integer>, ItemStack> metaRecipes = new HashMap<>();
    private Map<List<Integer>, Float> metaExperience = new HashMap<>();

    SifterRecipies() {
        this.addRecipe(Item.getItemFromBlock(Blocks.SAND), new ItemStack(Items.IRON_INGOT), 0.7F);
        this.addRecipe(Item.getItemFromBlock(Blocks.GRAVEL), new ItemStack(Items.IRON_INGOT), 0.7F);
        this.addRecipe(Item.getItemFromBlock(Blocks.CLAY), new ItemStack(Items.GOLD_INGOT), 1.0F);
        this.addRecipe(Items.CLAY_BALL, new ItemStack(Items.GOLD_INGOT), 1.0F);
    }

    public void addRecipe(Item input, ItemStack output, float experience) {
        this.recipes.put(input, output);
        this.experienceAmounts.put(output, experience);
    }

    @Deprecated
    public ItemStack getSiftResult(int par1) {
        return this.recipes.get(par1);
    }

    public Map<Item, ItemStack> getRecipes() {
        return this.recipes;
    }

    @Deprecated
    public float getExperience(int par1) {
        return this.experienceAmounts.containsKey(par1) ? (Float) this.experienceAmounts.get(par1) : 0.0F;
    }

    public void addRecipe(Item itemID, int metadata, ItemStack itemstack, float experience) {
        metaRecipes.put(Arrays.asList(Item.getIdFromItem(itemID), metadata), itemstack);
        metaExperience.put(Arrays.asList(Item.getIdFromItem(itemstack.getItem()), itemstack.getItemDamage()), experience);
    }

    public ItemStack getSiftResult(ItemStack item) {
        if (item == null) {
            return null;
        }
        ItemStack ret = metaRecipes.get(Arrays.asList(item, item.getItemDamage()));
        if (ret != null) {
            return ret;
        }
        return recipes.get(item);
    }

    public float getExperience(ItemStack stack) {
        if (stack == null || stack.getItem() == null) {
            return 0;
        }
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret < 0 && metaExperience.containsKey(Arrays.asList(stack, stack.getItemDamage()))) {
            ret = metaExperience.get(Arrays.asList(stack, stack.getItemDamage()));
        }
        if (ret < 0 && experienceAmounts.containsKey(stack)) {
            ret = experienceAmounts.get(stack);
        }
        return (ret < 0 ? 0 : ret);
    }

    public Map<List<Integer>, ItemStack> getMetaRecipes() {
        return metaRecipes;
    }
}
