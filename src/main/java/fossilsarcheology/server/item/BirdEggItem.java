package fossilsarcheology.server.item;

import fossilsarcheology.server.api.DefaultRenderedItem;
import fossilsarcheology.server.entity.prehistoric.PrehistoricEntityType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class BirdEggItem extends Item implements DefaultRenderedItem {
    private PrehistoricEntityType creature;
    private boolean cultivated;

    public BirdEggItem(PrehistoricEntityType creature, boolean cultivated) {
        super();
        this.creature = creature;
        this.cultivated = cultivated;
        this.maxStackSize = 16;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        if (!player.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        player.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
//        world.spawnEntityInWorld(new BirdEggEntity(world, player, this.creature, this.cultivated, this)); TODO
        return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
    }
}
