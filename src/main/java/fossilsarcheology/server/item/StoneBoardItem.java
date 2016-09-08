package fossilsarcheology.server.item;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.entity.EntityStoneboard;
import fossilsarcheology.server.handler.FossilAchievementHandler;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StoneBoardItem extends Item {
    public StoneBoardItem() {
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        setUnlocalizedName(LocalizationStrings.TABLET_NAME);
        setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (facing.getAxis() != EnumFacing.Axis.Y) {
            if (player.canPlayerEdit(pos, facing, stack)) {
                EntityStoneboard entity = new EntityStoneboard(world, pos, facing.getHorizontalIndex());
                if (entity.onValidSurface()) {
                    if (!world.isRemote) {
                        world.spawnEntityInWorld(entity);
                    }
                    player.addStat(FossilAchievementHandler.tablet, 1);
                    --stack.stackSize;
                }
                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.PASS;
    }
}
