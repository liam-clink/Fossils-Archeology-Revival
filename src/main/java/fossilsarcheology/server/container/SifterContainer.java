package fossilsarcheology.server.container;

import fossilsarcheology.server.block.entity.TileEntitySifter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class SifterContainer extends Container {
    public static final int INPUT = 0;
    private TileEntitySifter sifter;
    private int cookTime = 0;
    private int burnTime = 0;
    private int itemBurnTime = 0;

    public SifterContainer(InventoryPlayer playerInventory, TileEntity tile) {
        this.sifter = (TileEntitySifter) tile;

        // Sifter input
        this.addSlotToContainer(new Slot(this.sifter, INPUT, 80, 10));

        for (int index = 0; index < 5; ++index) {
            this.addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, this.sifter, 1 + index, 44 + 18 * index, 62));
        }

        // player inventory
        for (int column = 0; column < 3; ++column) {
            for (int row = 0; row < 9; ++row) {
                this.addSlotToContainer(new Slot(playerInventory, row + column * 9 + 9, 8 + row * 18, 84 + column * 18));
            }
        }

        // player hotbar
        for (int row = 0; row < 9; ++row) {
            this.addSlotToContainer(new Slot(playerInventory, row, 8 + row * 18, 142));
        }
    }

    @Override
    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendProgressBarUpdate(this, 0, this.sifter.sifterCookTime);
        listener.sendProgressBarUpdate(this, 1, this.sifter.sifterBurnTime);
        listener.sendProgressBarUpdate(this, 2, this.sifter.currentItemBurnTime);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (IContainerListener listener : this.listeners) {
            if (this.cookTime != this.sifter.sifterCookTime) {
                listener.sendProgressBarUpdate(this, 0, this.sifter.sifterCookTime);
            }
            if (this.burnTime != this.sifter.sifterBurnTime) {
                listener.sendProgressBarUpdate(this, 1, this.sifter.sifterBurnTime);
            }
            if (this.itemBurnTime != this.sifter.currentItemBurnTime) {
                listener.sendProgressBarUpdate(this, 2, this.sifter.currentItemBurnTime);
            }
        }
        this.cookTime = this.sifter.sifterCookTime;
        this.burnTime = this.sifter.sifterBurnTime;
        this.itemBurnTime = this.sifter.currentItemBurnTime;
    }

    @Override
    public void updateProgressBar(int key, int value) {
        switch (key) {
            case 0:
                this.sifter.sifterCookTime = value;
                break;
            case 1:
                this.sifter.sifterBurnTime = value;
                break;
            case 2:
                this.sifter.currentItemBurnTime = value;
                break;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.sifter.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack transferStack = null;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            transferStack = stack.copy();
            if (index > 0 && index < 6) {
                if (!this.mergeItemStack(stack, 6, 42, true)) {
                    return null;
                }
                slot.onSlotChange(stack, transferStack);
            } else if (index != INPUT) {
                if (stack != null && !this.mergeItemStack(stack, INPUT, INPUT + 1, false)) {
                    return null;
                }
            } else if (index >= 5 + 1 && index < 5 + 28) {
                if (!this.mergeItemStack(stack, 5 + 28, 5 + 37, false)) {
                    return null;
                }
            } else if (index >= 5 + 28 && index < 5 + 37 && !this.mergeItemStack(stack, 5 + 1, 5 + 28, false)) {
                return null;
            } else if (!this.mergeItemStack(stack, 5 + 1, 5 + 37, false)) {
                return null;
            }
            if (stack.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (stack.stackSize == transferStack.stackSize) {
                return null;
            }
            slot.onPickupFromSlot(player, stack);
        }
        return transferStack;
    }
}
