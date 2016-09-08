package fossilsarcheology.server.item;

import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.mob.EntityPlesiosaurus;
import fossilsarcheology.server.enums.OrderType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class MagicConchItem extends Item {
    public MagicConchItem() {
        super();
        this.setMaxDamage(0);
        this.maxStackSize = 1;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        List<EntityPlesiosaurus> entities = world.getEntitiesWithinAABB(EntityPlesiosaurus.class, new AxisAlignedBB(player.posX, player.posY, player.posZ, player.posX + 1.0D, player.posY + 1.0D, player.posZ + 1.0D).expand(30.0D, 4.0D, 30.0D));
        for (EntityPlesiosaurus entity : entities) {
            if (entity.isTamed()) {
                entity.setOrder(OrderType.values()[stack.getItemDamage()]);
                world.spawnParticle(EnumParticleTypes.NOTE, entity.posX, entity.posY + 1.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
            }
        }
        if (!player.worldObj.isRemote) {
            Revival.messagePlayer("Try asking again.", player);
        }
        return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
    }
}
