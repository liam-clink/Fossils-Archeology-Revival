package com.github.revival.client.gui;

import com.github.revival.server.entity.mob.EntityQuagga;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerQuagga extends Container {
    private IInventory inventory;
    private EntityQuagga entity;

    public ContainerQuagga(IInventory playerInventory, IInventory inventory, EntityQuagga entity) {
        this.inventory = inventory;
        this.entity = entity;

        byte b0 = 3;
        inventory.openInventory();

        int i = (b0 - 4) * 18;

        this.addSlotToContainer(new Slot(inventory, 0, 8, 18)); //Sideslot
        this.addSlotToContainer(new Slot(inventory, 1, 8, 36)); //armor

        int j;
        int k;

        if (entity.isChested()) {
            for (j = 0; j < b0; ++j) {
                for (k = 0; k < 5; ++k) {
                    this.addSlotToContainer(new Slot(inventory, 2 + k + j * 5, 80 + k * 18, 18 + j * 18));
                }
            }
        }

        for (j = 0; j < 3; ++j) {
            for (k = 0; k < 9; ++k) {
                this.addSlotToContainer(new Slot(playerInventory, k + j * 9 + 9, 8 + k * 18, 102 + j * 18 + i));
            }
        }

        for (j = 0; j < 9; ++j) {
            this.addSlotToContainer(new Slot(playerInventory, j, 8 + j * 18, 160 + i));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.inventory.isUseableByPlayer(player) && this.entity.isEntityAlive() && this.entity.getDistanceToEntity(player) < 8.0F;
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        ItemStack transferred = null;
        Slot slot = (Slot) this.inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            transferred = stack.copy();

            if (slotIndex < this.inventory.getSizeInventory()) {
                if (!this.mergeItemStack(stack, this.inventory.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return null;
                }
            } else if (this.getSlot(1).isItemValid(stack) && !this.getSlot(1).getHasStack()) {
                if (!this.mergeItemStack(stack, 1, 2, false)) {
                    return null;
                }
            } else if (this.getSlot(0).isItemValid(stack)) {
                if (!this.mergeItemStack(stack, 0, 1, false)) {
                    return null;
                }
            } else if (this.inventory.getSizeInventory() <= 2 || !this.mergeItemStack(stack, 2, this.inventory.getSizeInventory(), false)) {
                return null;
            }

            if (stack.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
        }

        return transferred;
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);
        this.inventory.closeInventory();
    }
}