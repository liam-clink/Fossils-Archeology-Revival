package fossilsarcheology.server.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ChickenEssenceItem extends ItemFood {
    public ChickenEssenceItem(int hunger, float saturation, boolean isWolfFood) {
        super(hunger, saturation, isWolfFood);
    }

    @Override
    public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> text, boolean advanced) {
        text.add("Feed this to your dinosaurs to make them grow!");
    }
}
