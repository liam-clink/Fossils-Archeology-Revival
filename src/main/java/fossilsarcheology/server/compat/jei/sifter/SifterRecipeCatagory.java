package fossilsarcheology.server.compat.jei.sifter;

import fossilsarcheology.server.compat.jei.FAJEIPlugin;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.util.text.translation.I18n;

public class SifterRecipeCatagory implements IRecipeCategory<SifterRecipeWrapper> {

    private int chance;

    @Override
    public String getUid() {
        return FAJEIPlugin.SIFTER_UID;
    }

    @SuppressWarnings("deprecation")
    @Override
    public String getTitle() {
        return I18n.translateToLocal("tile.sifter.name");
    }

    @Override
    public String getModName() {
        return "Fossils and Archeology Revival";
    }

    @Override
    public IDrawable getBackground() {
        return new SifterDrawable(chance);
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, SifterRecipeWrapper recipeWrapper, IIngredients ingredients) {
        IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
        guiItemStacks.init(0, true, 76, 5);
        for (int i = 0; i < 5; ++i) {
            guiItemStacks.init(1 + i, false, 40 + 18 * i, 57);
        }
        this.chance = recipeWrapper.getRecipeSifter().getOutputChance();
        guiItemStacks.set(ingredients);
    }
}
