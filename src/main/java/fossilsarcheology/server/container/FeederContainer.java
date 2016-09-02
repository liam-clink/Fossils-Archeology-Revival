package fossilsarcheology.server.container;

import fossilsarcheology.api.Diet;
import fossilsarcheology.api.FoodMappings;
import fossilsarcheology.server.block.entity.TileEntityFeeder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FeederContainer extends Container {
    public static final int CARN_INPUT = 0, HERB_INPUT = 1;
    int lastVegValue = 0;
    int lastMeatValue = 0;
    private TileEntityFeeder feeder;

    public FeederContainer(IInventory inventory, TileEntity tile) {
        this.feeder = (TileEntityFeeder) tile;
        this.addSlotToContainer(new Slot(this.feeder, 0, 60, 62));
        this.addSlotToContainer(new Slot(this.feeder, 1, 104, 62));
        for (int vertical = 0; vertical < 3; ++vertical) {
            for (int horizontal = 0; horizontal < 9; ++horizontal) {
                this.addSlotToContainer(new Slot(inventory, horizontal + vertical * 9 + 9, 8 + horizontal * 18, 84 + vertical * 18));
            }
        }
        for (int horizontal = 0; horizontal < 9; ++horizontal) {
            this.addSlotToContainer(new Slot(inventory, horizontal, 8 + horizontal * 18, 142));
        }
    }

    @Override
    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendProgressBarUpdate(this, 0, this.feeder.currentPlant);
        listener.sendProgressBarUpdate(this, 1, this.feeder.currentMeat);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (IContainerListener listener : this.listeners) {
            if (this.lastVegValue != this.feeder.currentPlant) {
                listener.sendProgressBarUpdate(this, 0, this.feeder.currentPlant);
            }
            if (this.lastMeatValue != this.feeder.currentMeat) {
                listener.sendProgressBarUpdate(this, 1, this.feeder.currentMeat);
            }
        }
        this.lastVegValue = this.feeder.currentPlant;
        this.lastMeatValue = this.feeder.currentMeat;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int key, int value) {
        if (key == 0) {
            this.feeder.currentPlant = value;
        }
        if (key == 1) {
            this.feeder.currentMeat = value;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.feeder.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack stack = null;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack newStack = slot.getStack();
            stack = newStack.copy();
            if (index > HERB_INPUT) {
                if (FoodMappings.INSTANCE.getItemFoodAmount(newStack.getItem(), Diet.CARNIVORE_EGG) != 0) {
                    if (!this.mergeItemStack(newStack, 0, 1, false)) {
                        return null;
                    }
                }
                if (FoodMappings.INSTANCE.getItemFoodAmount(newStack.getItem(), Diet.HERBIVORE) != 0) {
                    if (!this.mergeItemStack(newStack, 1, 2, false)) {
                        return null;
                    }
                }
            } else if (index >= HERB_INPUT + 1 && index < HERB_INPUT + 28) {
                if (!this.mergeItemStack(newStack, HERB_INPUT + 28, HERB_INPUT + 37, false)) {
                    return null;
                }
            } else if (index >= HERB_INPUT + 28 && index < HERB_INPUT + 37 && !this.mergeItemStack(newStack, HERB_INPUT + 1, HERB_INPUT + 28, false)) {
                return null;
            }
            if (newStack.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (newStack.stackSize == stack.stackSize) {
                return null;
            }
            slot.onPickupFromSlot(player, newStack);
        }
        return stack;
    }
}
