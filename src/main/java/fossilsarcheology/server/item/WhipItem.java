package fossilsarcheology.server.item;

import fossilsarcheology.server.entity.EntityPrehistoric;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemCarrotOnAStick;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WhipItem extends ItemCarrotOnAStick {
    public WhipItem() {
        super();
        this.setMaxDamage(100);
        this.setMaxStackSize(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        if (player.isRiding() && player.getRidingEntity() instanceof EntityPrehistoric) {
            stack.damageItem(1, player);
            player.swingArm(hand);
            player.getRidingEntity().playSound("fossil:whip", 1.0F, 1.0F);
        } else {
            player.swingArm(hand);
            player.playSound("fossil:whip", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
        }
        return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
    }
}