package fossilsarcheology.server.container;

import fossilsarcheology.server.block.entity.TileEntityWorktable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class WorktableContainer extends Container {
    public static final int FUEL = 1, INPUT_END = 0, OUTPUT_END = 2;
    private TileEntityWorktable worktable;
    private int cookTime = 0;
    private int burnTime = 0;
    private int itemBurnTime = 0;

    public WorktableContainer(InventoryPlayer inventoryPlayer, TileEntity tile) {
        this.worktable = (TileEntityWorktable) tile;
        this.addSlotToContainer(new Slot(this.worktable, 0, 49, 20));
        this.addSlotToContainer(new Slot(this.worktable, 1, 81, 54));
        this.addSlotToContainer(new SlotFurnaceOutput(inventoryPlayer.player, this.worktable, 2, 116, 21));
        for (int column = 0; column < 3; ++column) {
            for (int row = 0; row < 9; ++row) {
                this.addSlotToContainer(new Slot(inventoryPlayer, row + column * 9 + 9, 8 + row * 18, 84 + column * 18));
            }
        }
        for (int row = 0; row < 9; ++row) {
            this.addSlotToContainer(new Slot(inventoryPlayer, row, 8 + row * 18, 142));
        }
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (IContainerListener listener : this.listeners) {
            if (this.cookTime != this.worktable.furnaceCookTime) {
                listener.sendProgressBarUpdate(this, 0, this.worktable.furnaceCookTime);
            }
            if (this.burnTime != this.worktable.furnaceBurnTime) {
                listener.sendProgressBarUpdate(this, 1, this.worktable.furnaceBurnTime);
            }
            if (this.itemBurnTime != this.worktable.currentItemBurnTime) {
                listener.sendProgressBarUpdate(this, 2, this.worktable.currentItemBurnTime);
            }
        }
        this.cookTime = this.worktable.furnaceCookTime;
        this.burnTime = this.worktable.furnaceBurnTime;
        this.itemBurnTime = this.worktable.currentItemBurnTime;
    }

    @Override
    public void updateProgressBar(int key, int value) {
        switch (key) {
            case 0:
                this.worktable.furnaceCookTime = value;
                break;
            case 1:
                this.worktable.furnaceBurnTime = value;
                break;
            case 2:
                this.worktable.currentItemBurnTime = value;
                break;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.worktable.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack transfer = null;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            transfer = stack.copy();
            if (index > INPUT_END && index < OUTPUT_END + 1 && index != FUEL) {
                if (!this.mergeItemStack(stack, OUTPUT_END + 1, OUTPUT_END + 36 + 1, true)) {
                    return null;
                }
                slot.onSlotChange(stack, transfer);
            } else if (index > INPUT_END + 1) {
                if (stack != null) {
                    if (!this.mergeItemStack(stack, 0, INPUT_END + 1, false)) {
                        return null;
                    }
                }
            } else if (index >= OUTPUT_END + 1 && index < OUTPUT_END + 28) {
                if (!this.mergeItemStack(stack, OUTPUT_END + 28, OUTPUT_END + 37, false)) {
                    return null;
                }
            } else if (index >= OUTPUT_END + 28 && index < OUTPUT_END + 37 && !this.mergeItemStack(stack, OUTPUT_END + 1, OUTPUT_END + 28, false)) {
                return null;
            } else if (!this.mergeItemStack(stack, OUTPUT_END + 1, OUTPUT_END + 37, false)) {
                return null;
            }
            if (stack.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (stack.stackSize == transfer.stackSize) {
                return null;
            }
            slot.onPickupFromSlot(player, stack);
        }
        return transfer;
    }
}
