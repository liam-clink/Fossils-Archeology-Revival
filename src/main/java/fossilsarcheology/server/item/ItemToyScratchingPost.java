package fossilsarcheology.server.item;

import fossilsarcheology.server.entity.toy.EntityToyScratchingPost;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemToyScratchingPost extends Item {
    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (facing == EnumFacing.UP && world.isAirBlock(pos.up()) && world.isAirBlock(pos.up(2))) {
            EntityToyScratchingPost ball = new EntityToyScratchingPost(world);
            ball.setLocationAndAngles(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 0);
            if (!world.isRemote) {
                world.spawnEntityInWorld(ball);
            }
            ball.rotationYaw = player.rotationYawHead;
            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }
}
