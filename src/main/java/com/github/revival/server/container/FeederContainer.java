package com.github.revival.server.container;

import com.github.revival.server.block.entity.TileEntityNewFeeder;
import com.github.revival.server.entity.EnumDiet;
import com.github.revival.server.util.FoodMappings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import java.util.Iterator;

public class FeederContainer extends Container {
    public static final int CARN_INPUT = 0, HERB_INPUT = 1;
    int lastVegValue = 0;
    int lastMeatValue = 0;
    private TileEntityNewFeeder feeder;

    public FeederContainer(IInventory var1, TileEntity var2) {
        this.feeder = (TileEntityNewFeeder) var2;
        this.addSlotToContainer(new Slot(this.feeder, 0, 60, 62));
        this.addSlotToContainer(new Slot(this.feeder, 1, 104, 62));
        int var3;

        for (var3 = 0; var3 < 3; ++var3) {
            for (int var4 = 0; var4 < 9; ++var4) {
                this.addSlotToContainer(new Slot(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3) {
            this.addSlotToContainer(new Slot(var1, var3, 8 + var3 * 18, 142));
        }
    }

    @Override
    public void addCraftingToCrafters(ICrafting var1) {
        super.addCraftingToCrafters(var1);
        var1.sendProgressBarUpdate(this, 0, this.feeder.currentPlant);
        var1.sendProgressBarUpdate(this, 1, this.feeder.currentMeat);
    }

    /**
     * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
     */
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (Object crafter : this.crafters) {
            ICrafting var2 = (ICrafting) crafter;

            if (this.lastVegValue != this.feeder.currentPlant) {
                var2.sendProgressBarUpdate(this, 0, this.feeder.currentPlant);
            }

            if (this.lastMeatValue != this.feeder.currentMeat) {
                var2.sendProgressBarUpdate(this, 1, this.feeder.currentMeat);
            }
        }

        this.lastVegValue = this.feeder.currentPlant;
        this.lastMeatValue = this.feeder.currentMeat;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int var1, int var2) {
        if (var1 == 0) {
            this.feeder.currentPlant = var2;
        }

        if (var1 == 1) {
            this.feeder.currentMeat = var2;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer var1) {
        return this.feeder.isUseableByPlayer(var1);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or
     * you will crash when someone does that.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int getSlot) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(getSlot);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            // itemstack is in player inventory, try to place in appropriate
            // furnace slot
            if (getSlot > HERB_INPUT) // if it's not in the INPUT and in player
            // inventory
            {
                // if it can be smelted, place in the input slots
                if (FoodMappings.instance().getItemFoodAmount(itemstack1.getItem(), EnumDiet.CARNIVORE_EGG) != 0) {
                    // try to place in either Input slot; add 1 to final input
                    // slot because mergeItemStack uses < index
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return null;
                    }
                }
                if (FoodMappings.instance().getItemFoodAmount(itemstack1.getItem(), EnumDiet.HERBIVORE) != 0) {
                    // try to place in either Input slot; add 1 to final input
                    // slot because mergeItemStack uses < index
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
                        return null;
                    }
                }
            }
            // item in player's inventory, but not in action bar
            else if (getSlot >= HERB_INPUT + 1 && getSlot < HERB_INPUT + 28) {
                // place in action bar
                if (!this.mergeItemStack(itemstack1, HERB_INPUT + 28, HERB_INPUT + 37, false)) {
                    return null;
                }
            }
            // item in action bar - place in player inventory
            else if (getSlot >= HERB_INPUT + 28 && getSlot < HERB_INPUT + 37 && !this.mergeItemStack(itemstack1, HERB_INPUT + 1, HERB_INPUT + 28, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
}
