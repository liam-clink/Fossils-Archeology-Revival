package fossilsarcheology.server.compat.jei.analyzer;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

public class AnalyzerRecipeWrapper implements IRecipeWrapper {

    private RecipeAnalyzer recipeAnalyzer;

    public AnalyzerRecipeWrapper(RecipeAnalyzer recipeAnalyzer){
       this.recipeAnalyzer = recipeAnalyzer;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInput(ItemStack.class, recipeAnalyzer.getInput());
        ingredients.setOutput(ItemStack.class,recipeAnalyzer.getOutput());
    }

    public RecipeAnalyzer getRecipeAnalyzer() {
        return recipeAnalyzer;
    }
}
