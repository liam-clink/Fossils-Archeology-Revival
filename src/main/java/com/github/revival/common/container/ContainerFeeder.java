package com.github.revival.common.container;

import com.github.revival.common.enums.EnumDinoFoodItem;
import com.github.revival.common.tileentity.TileEntityFeeder;
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

public class ContainerFeeder extends Container
{
    public static final int CARN_INPUT = 0, HERB_INPUT = 1;
    int lastVegValue = 0;
    int lastMeatValue = 0;
    private TileEntityFeeder tileEntityFeeder;

    public ContainerFeeder(IInventory var1, TileEntity var2)
    {
        this.tileEntityFeeder = (TileEntityFeeder) var2;
        this.addSlotToContainer(new Slot(this.tileEntityFeeder, 0, 60, 62));
        this.addSlotToContainer(new Slot(this.tileEntityFeeder, 1, 104, 62));
        int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(var1, var4 + var3 * 9 + 9,
                        8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            this.addSlotToContainer(new Slot(var1, var3, 8 + var3 * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting var1)
    {
        super.addCraftingToCrafters(var1);
        var1.sendProgressBarUpdate(this, 0, this.tileEntityFeeder.VegCurrent);
        var1.sendProgressBarUpdate(this, 1, this.tileEntityFeeder.MeatCurrent);
    }

    /**
     * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        Iterator var1 = this.crafters.iterator();

        while (var1.hasNext())
        {
            ICrafting var2 = (ICrafting) var1.next();

            if (this.lastVegValue != this.tileEntityFeeder.VegCurrent)
            {
                var2.sendProgressBarUpdate(this, 0,
                        this.tileEntityFeeder.VegCurrent);
            }

            if (this.lastMeatValue != this.tileEntityFeeder.MeatCurrent)
            {
                var2.sendProgressBarUpdate(this, 1,
                        this.tileEntityFeeder.MeatCurrent);
            }
        }

        this.lastVegValue = this.tileEntityFeeder.VegCurrent;
        this.lastMeatValue = this.tileEntityFeeder.MeatCurrent;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int var1, int var2)
    {
        if (var1 == 0)
        {
            this.tileEntityFeeder.VegCurrent = var2;
        }

        if (var1 == 1)
        {
            this.tileEntityFeeder.MeatCurrent = var2;
        }
    }

    public boolean canInteractWith(EntityPlayer var1)
    {
        return this.tileEntityFeeder.isUseableByPlayer(var1);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or
     * you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer player, int getSlot)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(getSlot);
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            // itemstack is in player inventory, try to place in appropriate
            // furnace slot
            if (getSlot > HERB_INPUT) // if it's not in the INPUT and in player
            // inventory
            {
                // if it can be smelted, place in the input slots
                if (EnumDinoFoodItem.foodtype(itemstack1.getItem()) == EnumDinoFoodItem.ISCARNIVOROUS)
                {
                    // try to place in either Input slot; add 1 to final input
                    // slot because mergeItemStack uses < index
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                if (EnumDinoFoodItem.foodtype(itemstack1.getItem()) == EnumDinoFoodItem.ISHERBIVOROUS)
                {
                    // try to place in either Input slot; add 1 to final input
                    // slot because mergeItemStack uses < index
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
            }
            // item in player's inventory, but not in action bar
            else if (getSlot >= HERB_INPUT + 1 && getSlot < HERB_INPUT + 28)
            {
                // place in action bar
                if (!this.mergeItemStack(itemstack1, HERB_INPUT + 28,
                        HERB_INPUT + 37, false))
                {
                    return null;
                }
            }
            // item in action bar - place in player inventory
            else if (getSlot >= HERB_INPUT + 28
                    && getSlot < HERB_INPUT + 37
                    && !this.mergeItemStack(itemstack1, HERB_INPUT + 1,
                    HERB_INPUT + 28, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack) null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
}
