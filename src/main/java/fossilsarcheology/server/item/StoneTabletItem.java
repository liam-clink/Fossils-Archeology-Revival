package fossilsarcheology.server.item;

import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.entity.StoneTabletEntity;
import fossilsarcheology.server.tab.FATabRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StoneTabletItem extends Item implements DefaultRenderedItem {
    public StoneTabletItem() {
        super();
        this.setUnlocalizedName("stone_tablet");
        this.setCreativeTab(FATabRegistry.ITEMS);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        BlockPos placePos = pos.offset(facing);
        if (facing != EnumFacing.DOWN && facing != EnumFacing.UP && player.canPlayerEdit(placePos, facing, stack)) {
            StoneTabletEntity entity = new StoneTabletEntity(world, placePos, facing);
            if (entity.onValidSurface()) {
                if (!world.isRemote) {
                    entity.playPlaceSound();
                    world.spawnEntity(entity);
                }
                --stack.stackSize;
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }
}
