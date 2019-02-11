package fossilsarcheology.server.compat.jei.sifter;

import fossilsarcheology.server.block.entity.TileEntitySifter;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.ArrayList;
import java.util.List;

public class SifterRecipes {


    public static List<RecipeSifter> getRecipes(){
        ArrayList<ItemStack> sediment = new ArrayList<>();
        for(Item item : Item.REGISTRY)
            if (item instanceof ItemBlock && TileEntitySifter.getSiftTypeFromStack(new ItemStack(item)) != TileEntitySifter.EnumSiftType.NONE) {
                NonNullList<ItemStack> items = NonNullList.create();
                if(item.getCreativeTab() != null){
                    item.getSubItems(item.getCreativeTab(), items);
                    sediment.addAll(items);
                }
            }
        List<RecipeSifter> list = new ArrayList<>();
        for(ItemStack itemstack : sediment){
            if(itemstack.getItem() == Item.getItemFromBlock(Blocks.SAND)){
                list.add(new RecipeSifter(itemstack, new ItemStack(Blocks.SAND), 25));
            }else{
                list.add(new RecipeSifter(itemstack, new ItemStack(Blocks.SAND), 20));
                list.add(new RecipeSifter(itemstack, itemstack, 5));
            }
            list.add(new RecipeSifter(itemstack, new ItemStack(FAItemRegistry.DOMINICAN_AMBER), 1));
            list.add(new RecipeSifter(itemstack, new ItemStack(FAItemRegistry.PLANT_FOSSIL), 14));
            list.add(new RecipeSifter(itemstack, new ItemStack(Items.POTATO), 15));
            list.add(new RecipeSifter(itemstack, new ItemStack(Items.CARROT), 10));
            list.add(new RecipeSifter(itemstack, new ItemStack(Items.DYE, 1, 15), 20));
            list.add(new RecipeSifter(itemstack, new ItemStack(FAItemRegistry.FERN_SEED), 10));
            list.add(new RecipeSifter(itemstack, new ItemStack(FAItemRegistry.POTTERY_SHARD), 5));
            list.add(new RecipeSifter(itemstack, new ItemStack(FAItemRegistry.BIOFOSSIL), 5));
        }
        return list;
    }
}
