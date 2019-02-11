package fossilsarcheology.server.compat.jei.worktable;

import fossilsarcheology.server.compat.jei.FAJEIPlugin;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.util.text.translation.I18n;

public class WorktableRecipeCatagory implements IRecipeCategory<WorktableRecipeWrapper> {

    @Override
    public String getUid() {
        return FAJEIPlugin.WORKTABLE_UID;
    }

    @SuppressWarnings("deprecation")
    @Override
    public String getTitle() {
        return I18n.translateToLocal("tile.worktable.name");
    }

    @Override
    public String getModName() {
        return "Fossils and Archeology Revival";
    }

    @Override
    public IDrawable getBackground() {
        return new WorktableDrawable();
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, WorktableRecipeWrapper recipeWrapper, IIngredients ingredients) {
        IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
        guiItemStacks.init(0, true, 45, 15);
        guiItemStacks.init(1, true, 77, 49);
        guiItemStacks.init(2, false, 112, 16);
        guiItemStacks.set(ingredients);
    }
}
