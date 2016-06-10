package com.github.revival.server.item;

import com.github.revival.server.item.forge.ForgeFoodItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ChickenEssItem extends ForgeFoodItem {
    public ChickenEssItem(int var2, float var3, boolean var4, String textname) {
        super(var2, var3, var4, textname);
    }

    @Override
    public void onFoodEaten(ItemStack var1, World var2, EntityPlayer var3) {
        if (!var3.capabilities.isCreativeMode) {
            var3.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
        }
        // return super.onFoodEaten(var1, var2, var3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean i) {
        list.add("Feed this to your dinosaurs to make them grow!");
    }
}
