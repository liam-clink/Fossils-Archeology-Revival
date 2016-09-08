package fossilsarcheology.server.container;

import fossilsarcheology.server.block.entity.TileEntityTimeMachine;
import fossilsarcheology.server.handler.FossilAchievementHandler;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class TimeMachineContainer extends Container {
    private TileEntityTimeMachine timeMachine;

    public TimeMachineContainer(InventoryPlayer playerInventory, TileEntityTimeMachine tile) {
        this.timeMachine = tile;

        this.addSlotToContainer(new Slot(tile, 6, 35, 46));

        for (int column = 0; column < 3; ++column) {
            for (int row = 0; row < 9; ++row) {
                this.addSlotToContainer(new Slot(playerInventory, row + column * 9 + 9, 7 + row * 18, 107 + column * 18));
            }
        }

        for (int row = 0; row < 9; ++row) {
            this.addSlotToContainer(new Slot(playerInventory, row, 7 + row * 18, 165));
        }
    }

    @Override
    public void updateProgressBar(int key, int value) {
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.timeMachine.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        Slot slot = this.inventorySlots.get(index);
        if (index == 6) {
            if (slot.getStack() != null) {
                if (slot.getStack().getItem() == FAItemRegistry.INSTANCE.ancientClock) {
                    player.addStat(FossilAchievementHandler.clock, 1);
                }
            }
        }
        return null;
    }
}
