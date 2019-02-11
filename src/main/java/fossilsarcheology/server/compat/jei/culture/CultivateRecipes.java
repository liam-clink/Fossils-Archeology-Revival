package fossilsarcheology.server.compat.jei.culture;

import fossilsarcheology.server.block.entity.TileEntityCultivate;
import fossilsarcheology.server.entity.prehistoric.PrehistoricEntityType;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class CultivateRecipes {

    public static List<RecipeCultivate> getRecipes() {
        List<RecipeCultivate> list = new ArrayList<>();
        for(PrehistoricEntityType type : PrehistoricEntityType.values()){
            addRecipe(list, new ItemStack(type.dnaItem), TileEntityCultivate.getCultivationOutput(new ItemStack(type.dnaItem)));
        }
        for(int i = 0; i < 14; i++){
            addRecipe(list, new ItemStack(FAItemRegistry.FOSSIL_SEED, 1, i), new ItemStack(FAItemRegistry.SEED, 1, i));
        }
        addRecipe(list, new ItemStack(FAItemRegistry.FOSSIL_SEED_FERN), new ItemStack(FAItemRegistry.FERN_SEED));
        return list;
    }

    private static Item[] FUEL = new Item[]{FAItemRegistry.BIOFOSSIL, Items.PORKCHOP, Items.FISH, Items.BEEF, Items.MUTTON, Items.EGG, Items.SLIME_BALL, Items.MILK_BUCKET, Items.RABBIT_FOOT, Items.RABBIT};

    private static void addRecipe(List<RecipeCultivate> list, ItemStack input, ItemStack output){
        for(Item item : FUEL){
            list.add(new RecipeCultivate(input, output, new ItemStack(item)));

        }

    }
}
