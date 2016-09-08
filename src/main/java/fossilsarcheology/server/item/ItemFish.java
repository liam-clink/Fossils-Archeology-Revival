package fossilsarcheology.server.item;

import fossilsarcheology.server.entity.EntityFishBase;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemFish extends Item {
    private PrehistoricEntityType dino;
    public boolean isEggs;

    public ItemFish(PrehistoricEntityType dino, boolean isEggs) {
        super();
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.dino = dino;
        this.isEggs = isEggs;
    }

    public boolean spawnFish(World world, PrehistoricEntityType prehistoricEnum, double x, double y, double z) {
        Entity egg = prehistoricEnum.invokeClass(world);
        if (egg != null) {
            egg.setLocationAndAngles(x, y + 1, z, world.rand.nextFloat() * 360.0F, 0.0F);
            if (egg instanceof EntityFishBase) {
                EntityFishBase prehistoric = (EntityFishBase) egg;
                if (isEggs) {
                    prehistoric.setGrowingAge(-24000);
                } else {
                    prehistoric.setGrowingAge(12000);
                }
                if (!world.isRemote) {
                    world.spawnEntityInWorld(egg);
                }
            }
        }
        return egg != null;
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        boolean success = this.spawnFish(world, dino, pos.getX() + 0.5F, pos.getY(), pos.getZ());
        if (success && !player.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        return success ? EnumActionResult.SUCCESS : EnumActionResult.FAIL;
    }
}
