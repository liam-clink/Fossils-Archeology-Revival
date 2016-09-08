package fossilsarcheology.server.item;

import fossilsarcheology.server.entity.toy.EntityToyTetheredLog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemToyTetheredLog extends Item {
    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (facing == EnumFacing.DOWN && world.isAirBlock(pos.down(2))) {
            EntityToyTetheredLog tetheredLog = new EntityToyTetheredLog(world);
            tetheredLog.setLocationAndAngles(pos.getX() + 0.5, pos.getY() - 1.9, pos.getZ() + 0.5, 0, 0);
            if (!world.isRemote) {
                world.spawnEntityInWorld(tetheredLog);
            }
            tetheredLog.rotationYaw = player.rotationYawHead;
            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }
}
