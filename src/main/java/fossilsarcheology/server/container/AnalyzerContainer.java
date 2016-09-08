package fossilsarcheology.server.container;

import fossilsarcheology.server.block.entity.TileEntityAnalyzer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class AnalyzerContainer extends Container {
    public static final int OUTPUT_END = 12, INPUT_END = 8;
    private TileEntityAnalyzer analyzer;
    private int cookTime = 0;
    private int burnTime = 0;
    private int itemBurnTime = 0;

    public AnalyzerContainer(InventoryPlayer playerInventory, TileEntity tile) {
        this.analyzer = (TileEntityAnalyzer) tile;

        for (int column = 0; column < 3; ++column) {
            for (int row = 0; row < 3; ++row) {
                this.addSlotToContainer(new Slot(this.analyzer, row + column * 3, 20 + row * 18, 17 + column * 18));
            }
        }

        this.addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, this.analyzer, 9, 116, 21));

        for (int slot = 0; slot < 3; ++slot) {
            this.addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, this.analyzer, 10 + slot, 111 + 18 * slot, 53));
        }

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
        listener.sendProgressBarUpdate(this, 0, this.analyzer.analyzerCookTime);
        listener.sendProgressBarUpdate(this, 1, this.analyzer.analyzerBurnTime);
        listener.sendProgressBarUpdate(this, 2, this.analyzer.currentItemBurnTime);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (IContainerListener listener : this.listeners) {
            if (this.cookTime != this.analyzer.analyzerCookTime) {
                listener.sendProgressBarUpdate(this, 0, this.analyzer.analyzerCookTime);
            }
            if (this.burnTime != this.analyzer.analyzerBurnTime) {
                listener.sendProgressBarUpdate(this, 1, this.analyzer.analyzerBurnTime);
            }
            if (this.itemBurnTime != this.analyzer.currentItemBurnTime) {
                listener.sendProgressBarUpdate(this, 2, this.analyzer.currentItemBurnTime);
            }
        }
        this.cookTime = this.analyzer.analyzerCookTime;
        this.burnTime = this.analyzer.analyzerBurnTime;
        this.itemBurnTime = this.analyzer.currentItemBurnTime;
    }

    @Override
    public void updateProgressBar(int key, int value) {
        switch (key) {
            case 0:
                this.analyzer.analyzerCookTime = value;
                break;
            case 1:
                this.analyzer.analyzerBurnTime = value;
                break;
            case 2:
                this.analyzer.currentItemBurnTime = value;
                break;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.analyzer.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack transferredStack = null;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            transferredStack = stack.copy();
            if (index > INPUT_END && index < OUTPUT_END + 1) {
                if (!this.mergeItemStack(stack, OUTPUT_END + 1, OUTPUT_END + 36 + 1, true)) {
                    return null;
                }
                slot.onSlotChange(stack, transferredStack);
            } else if (index > INPUT_END) {
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
            if (stack.stackSize == transferredStack.stackSize) {
                return null;
            }
            slot.onPickupFromSlot(player, stack);
        }
        return transferredStack;
    }
}
