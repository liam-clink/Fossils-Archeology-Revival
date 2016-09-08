package fossilsarcheology.server.item;

import fossilsarcheology.server.creativetab.FATabRegistry;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemBioFossil extends Item {
    private boolean tar;

    public ItemBioFossil(boolean tar) {
        this.setMaxDamage(0);
        this.tar = tar;
        this.setUnlocalizedName(tar ? "tar_fossil" : LocalizationStrings.BIO_FOSSIL_NAME);
        this.setCreativeTab(FATabRegistry.INSTANCE.ITEMS);
    }

    public boolean spawnFossil(ItemStack stack, EntityPlayer player, World world, BlockPos pos) {
        if (world.isRemote) {
            return true;
        } else {
            Class<? extends Entity> entityClazz = PrehistoricEntityType.getRandomBioFossil(tar).getEntity();
            try {
                EntityPrehistoric entity = (EntityPrehistoric) entityClazz.getConstructor(World.class).newInstance(world);
                entity.setLocationAndAngles(pos.getX(), pos.getY() + 1, pos.getZ(), world.rand.nextFloat() * 360.0F, 0.0F);
                entity.faceEntity(player, 360.0F, 360.0F);
                entity.setSkeleton(true);
                if (world.checkNoEntityCollision(entity.getEntityBoundingBox()) && world.getCollisionBoxes(entity, entity.getEntityBoundingBox()).size() == 0) {
                    world.spawnEntityInWorld(entity);
                    --stack.stackSize;
                    return true;
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        RayTraceResult rayTraceResult = this.rayTrace(world, player, true);
        if (rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK && world.getBlockState(rayTraceResult.getBlockPos()).getMaterial().isSolid() && this.spawnFossil(stack, player, world, rayTraceResult.getBlockPos())) {
            return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
        }
        return ActionResult.newResult(EnumActionResult.PASS, stack);
    }
}
