package fossilsarcheology.server.item;

import fossilsarcheology.server.entity.toy.EntityToyBall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemToyBall extends Item {
    private static final String[] colors = ItemDye.DYE_COLORS;

    public ItemToyBall() {
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < colors.length; ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, int i, float a, float b, float c) {
        EntityToyBall ball = new EntityToyBall(world);
        ball.setColor(stack.getItemDamage());
        ball.setLocationAndAngles(x + 0.5, y + 1, z + 0.5, 0, 0);
        if (!world.isRemote)
            world.spawnEntityInWorld(ball);
        --stack.stackSize;
        return true;

    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        if (meta < 0 || meta >= colors.length) {
            meta = 0;
        }

        return super.getUnlocalizedName() + "." + colors[meta];
    }
}
