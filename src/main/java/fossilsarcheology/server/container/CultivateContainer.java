package fossilsarcheology.server.container;

import fossilsarcheology.server.block.entity.TileEntityCultivate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class CultivateContainer extends Container {
    public static final int INPUT_END = 0, FUEL = 1, OUTPUT_END = 2;
    private TileEntityCultivate cultivate;
    private int cookTime = 0;
    private int burnTime = 0;
    private int itemBurnTime = 0;
    private int dna = 0;

    public CultivateContainer(InventoryPlayer playerInventory, TileEntity tile) {
        this.cultivate = (TileEntityCultivate) tile;
        this.addSlotToContainer(new Slot(this.cultivate, 0, 49, 20)); // input
        this.addSlotToContainer(new Slot(this.cultivate, 1, 81, 54)); // fuel
        this.addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, this.cultivate, 2, 116, 21)); // output
        for (int column = 0; column < 3; ++column) {
            for (int row = 0; row < 9; ++row) {
                this.addSlotToContainer(new Slot(playerInventory, row + column * 9 + 9, 8 + row * 18, 84 + column * 18));
            }
        }
        for (int row = 0; row < 9; ++row) {
            this.addSlotToContainer(new Slot(playerInventory, row, 8 + row * 18, 142));
        }
    }

    @Override
    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendProgressBarUpdate(this, 0, this.cultivate.cultivateTime);
        listener.sendProgressBarUpdate(this, 1, this.cultivate.cultivatePowerTime);
        listener.sendProgressBarUpdate(this, 2, this.cultivate.currentCultivateTime);
        listener.sendProgressBarUpdate(this, 3, this.cultivate.getDNAType());
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (IContainerListener listener : this.listeners) {
            if (this.cookTime != this.cultivate.cultivateTime) {
                listener.sendProgressBarUpdate(this, 0, this.cultivate.cultivateTime);
            }
            if (this.burnTime != this.cultivate.cultivatePowerTime) {
                listener.sendProgressBarUpdate(this, 1, this.cultivate.cultivatePowerTime);
            }
            if (this.itemBurnTime != this.cultivate.currentCultivateTime) {
                listener.sendProgressBarUpdate(this, 2, this.cultivate.currentCultivateTime);
            }
            if (this.dna != this.cultivate.getDNAType()) {
                listener.sendProgressBarUpdate(this, 3, this.cultivate.getDNAType());
            }
        }
        this.cookTime = this.cultivate.cultivateTime;
        this.burnTime = this.cultivate.cultivatePowerTime;
        this.itemBurnTime = this.cultivate.currentCultivateTime;
        this.dna = this.cultivate.getDNAType();
    }

    @Override
    public void updateProgressBar(int key, int value) {
        switch (key) {
            case 0:
                this.cultivate.cultivateTime = value;
                break;
            case 1:
                this.cultivate.cultivatePowerTime = value;
                break;
            case 2:
                this.cultivate.currentCultivateTime = value;
                break;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer var1) {
        return this.cultivate.isUseableByPlayer(var1);
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
                if (stack != null && !this.mergeItemStack(stack, 0, INPUT_END + 1, false)) {
                    return null;
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
