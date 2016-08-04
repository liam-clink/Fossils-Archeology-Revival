package fossilsarcheology.server.item;

import fossilsarcheology.server.entity.mob.projectile.EntityBirdEgg;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BirdEggItem extends Item {
    PrehistoricEntityType creature;
    boolean cultivated;

    public BirdEggItem(PrehistoricEntityType creature, boolean cultivated) {
        super();
        this.creature = creature;
        this.cultivated = cultivated;
        this.maxStackSize = 16;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is
     * pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par3EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }

        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        par2World.spawnEntityInWorld(new EntityBirdEgg(par2World, par3EntityPlayer, creature, cultivated, this));

        return par1ItemStack;
    }

}
