package fossilsarcheology.server.compat.jei.analyzer;

import fossilsarcheology.server.compat.jei.FAJEIPlugin;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.util.text.translation.I18n;

public class AnalyzerRecipeCatagory implements IRecipeCategory<AnalyzerRecipeWrapper> {

    private int chance;

    @Override
    public String getUid() {
        return FAJEIPlugin.ANALYZER_UID;
    }

    @SuppressWarnings("deprecation")
    @Override
    public String getTitle() {
        return I18n.translateToLocal("tile.analyzer.name");
    }

    @Override
    public String getModName() {
        return "Fossils and Archeology Revival";
    }

    @Override
    public IDrawable getBackground() {
        return new AnalyzerDrawable(chance);
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, AnalyzerRecipeWrapper recipeWrapper, IIngredients ingredients) {
        IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
        for (int column = 0; column < 3; ++column) {
            for (int row = 0; row < 3; ++row) {
                guiItemStacks.init(row + column * 3, true, 16 + row * 18, 12 + column * 18);
            }
        }
        this.chance = recipeWrapper.getRecipeAnalyzer().getOutputChance();
        guiItemStacks.init(9, false, 112, 16);
        guiItemStacks.set(ingredients);
    }
}
