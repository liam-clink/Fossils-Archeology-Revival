package fossilsarcheology.server.item;

import fossilsarcheology.server.entity.utility.EntityToyTetheredLog;
import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ToyTetheredLog extends Item{

    public ToyTetheredLog() {
        this.setUnlocalizedName("toyTetheredLog");
        this.setCreativeTab(FATabRegistry.ITEMS);
    }

    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (facing == EnumFacing.DOWN && worldIn.isAirBlock(pos.down(1)) && worldIn.isAirBlock(pos.down(2))) {
            EntityToyTetheredLog ball = new EntityToyTetheredLog(worldIn);
            ball.setLocationAndAngles(pos.getX() + 0.5, pos.getY() - 1.9, pos.getZ() + 0.5, 0, 0);
            if (!worldIn.isRemote)
                worldIn.spawnEntityInWorld(ball);
            ball.rotationYaw = playerIn.rotationYawHead;
            if (!playerIn.capabilities.isCreativeMode)
                --stack.stackSize;
        }
        return EnumActionResult.SUCCESS;
    }
}
