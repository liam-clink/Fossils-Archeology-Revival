package fossilsarcheology.server.compat.jei.analyzer;

import net.minecraft.item.ItemStack;

public class RecipeAnalyzer {

    private ItemStack input;
    private ItemStack output;
    private int chance;

    public RecipeAnalyzer(ItemStack input, ItemStack output, int chance){
        this.input = input;
        this.output = output;
        this.chance = chance;
    }

    public ItemStack getInput() {
        return input;
    }

    public ItemStack getOutput() {
        return output;
    }

    public int getOutputChance() {
        return chance;
    }
}
