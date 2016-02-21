package com.github.revival.common.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SifterRecipies {
    private static final SifterRecipies smeltingBase = new SifterRecipies();

    /**
     * The list of smelting results.
     */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    private SifterRecipies() {
        this.addSmelting(Item.getItemFromBlock(Blocks.sand), new ItemStack(
                Items.iron_ingot), 0.7F);
        this.addSmelting(Item.getItemFromBlock(Blocks.gravel), new ItemStack(
                Items.iron_ingot), 0.7F);
        this.addSmelting(Item.getItemFromBlock(Blocks.clay), new ItemStack(
                Items.gold_ingot), 1.0F);
        this.addSmelting(Items.clay_ball, new ItemStack(Items.gold_ingot), 1.0F);
    }

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final SifterRecipies smelting() {
        return smeltingBase;
    }

    /**
     * Adds a smelting recipe.
     */
    public void addSmelting(Item par1, ItemStack par2ItemStack, float par3) {
        this.smeltingList.put(par1, par2ItemStack);
        this.experienceList.put(par2ItemStack, Float.valueOf(par3));
    }

    /**
     * Returns the smelting result of an item. Deprecated in favor of a metadata
     * sensitive version
     */
    @Deprecated
    public ItemStack getSmeltingResult(int par1) {
        return (ItemStack) this.smeltingList.get(Integer.valueOf(par1));
    }

    public Map getSmeltingList() {
        return this.smeltingList;
    }

    @Deprecated
    // In favor of ItemStack sensitive version
    public float getExperience(int par1) {
        return this.experienceList.containsKey(Integer.valueOf(par1)) ? ((Float) this.experienceList
                .get(Integer.valueOf(par1))).floatValue() : 0.0F;
    }

    /**
     * A metadata sensitive version of adding a furnace recipe.
     */
    public void addSmelting(Item itemID, int metadata, ItemStack itemstack,
                            float experience) {
        metaSmeltingList.put(
                Arrays.asList(Item.getIdFromItem(itemID), metadata), itemstack);
        metaExperience.put(Arrays.asList(
                Item.getIdFromItem(itemstack.getItem()),
                itemstack.getItemDamage()), experience);
    }

    /**
     * Used to get the resulting ItemStack form a source ItemStack
     *
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getSmeltingResult(ItemStack item) {
        if (item == null) {
            return null;
        }
        ItemStack ret = (ItemStack) metaSmeltingList.get(Arrays.asList(item,
                item.getItemDamage()));
        if (ret != null) {
            return ret;
        }
        return (ItemStack) smeltingList.get(item);
    }

    /**
     * Grabs the amount of base experience for this item to give when pulled
     * from the furnace slot.
     */
    public float getExperience(ItemStack itemstack) {
        if (itemstack == null || itemstack.getItem() == null) {
            return 0;
        }
        float ret = itemstack.getItem().getSmeltingExperience(itemstack);
        if (ret < 0
                && metaExperience.containsKey(Arrays.asList(itemstack,
                itemstack.getItemDamage()))) {
            ret = metaExperience.get(Arrays.asList(itemstack,
                    itemstack.getItemDamage()));
        }
        if (ret < 0 && experienceList.containsKey(itemstack)) {
            ret = ((Float) experienceList.get(itemstack)).floatValue();
        }
        return (ret < 0 ? 0 : ret);
    }

    public Map<List<Integer>, ItemStack> getMetaSmeltingList() {
        return metaSmeltingList;
    }
}
