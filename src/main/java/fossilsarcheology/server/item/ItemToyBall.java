package fossilsarcheology.server.item;

import fossilsarcheology.server.entity.toy.EntityToyBall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class ItemToyBall extends Item {
    private static final int[] COLORS = ItemDye.DYE_COLORS;

    public ItemToyBall() {
        super();
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> stacks) {
        for (int i = 0; i < COLORS.length; ++i) {
            stacks.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            EntityToyBall ball = new EntityToyBall(world);
            ball.setColor(stack.getItemDamage());
            ball.setLocationAndAngles(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 0);
            world.spawnEntityInWorld(ball);
        }
        --stack.stackSize;
        return EnumActionResult.SUCCESS;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage();
        if (meta < 0 || meta >= COLORS.length) {
            meta = 0;
        }
        return super.getUnlocalizedName() + "." + EnumDyeColor.byDyeDamage(meta).getUnlocalizedName();
    }
}
