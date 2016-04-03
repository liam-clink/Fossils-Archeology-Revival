package com.github.revival.server.block.entity;

import com.github.revival.server.block.BlockWorktable;
import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.handler.LocalizationStrings;
import com.github.revival.server.item.FAItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityWorktable extends TileEntity implements IInventory,
        ISidedInventory {

    private static final int[] slots_top = new int[]{}; // input
    private static final int[] slots_bottom = new int[]{}; // output
    private static final int[] slots_sides = new int[]{};// fuel
    public int furnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int furnaceCookTime = 0;
    private ItemStack[] furnaceItemStacks = new ItemStack[3];
    private String customName;

    /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory() {
        return this.furnaceItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    @Override
    public ItemStack getStackInSlot(int var1) {
        return this.furnaceItemStacks[var1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number
     * (second arg) of items and returns them in a new stack.
     */
    @Override
    public ItemStack decrStackSize(int var1, int var2) {
        if (this.furnaceItemStacks[var1] != null) {
            ItemStack var3;

            if (this.furnaceItemStacks[var1].stackSize <= var2) {
                var3 = this.furnaceItemStacks[var1];
                this.furnaceItemStacks[var1] = null;
                return var3;
            } else {
                var3 = this.furnaceItemStacks[var1].splitStack(var2);

                if (this.furnaceItemStacks[var1].stackSize == 0) {
                    this.furnaceItemStacks[var1] = null;
                }

                return var3;
            }
        } else {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be
     * crafting or armor sections).
     */
    @Override
    public void setInventorySlotContents(int var1, ItemStack var2) {
        this.furnaceItemStacks[var1] = var2;

        if (var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
            var2.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName() {
        return this.isInvNameLocalized() ? this.customName : "tile."
                + LocalizationStrings.BLOCK_ANALYZER_IDLE_NAME + ".name";
    }

    /**
     * If this returns false, the inventory name will be used as an unlocalized
     * name, and translated into the player's language. Otherwise it will be
     * used directly.
     */
    public boolean isInvNameLocalized() {
        return this.customName != null && this.customName.length() > 0;
    }

    /**
     * Sets the custom display name to use when opening a GUI linked to this
     * tile entity.
     */
    public void setGuiDisplayName(String par1Str) {
        this.customName = par1Str;
    }

    /**
     * Reads a tile entity from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound var1) {
        super.readFromNBT(var1);
        NBTTagList var2 = var1.getTagList("Items", 10);
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3) {
            NBTTagCompound var4 = (NBTTagCompound) var2.getCompoundTagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.furnaceItemStacks.length) {
                this.furnaceItemStacks[var5] = ItemStack
                        .loadItemStackFromNBT(var4);
            }
        }

        this.furnaceBurnTime = var1.getShort("BurnTime");
        this.furnaceCookTime = var1.getShort("CookTime");
        this.currentItemBurnTime = this
                .getItemBurnTime(this.furnaceItemStacks[1]);

        if (var1.hasKey("CustomName")) {
            this.customName = var1.getString("CustomName");
        }
    }

    /**
     * Writes a tile entity to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound var1) {
        super.writeToNBT(var1);
        var1.setShort("BurnTime", (short) this.furnaceBurnTime);
        var1.setShort("CookTime", (short) this.furnaceCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.furnaceItemStacks.length; ++var3) {
            if (this.furnaceItemStacks[var3] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte) var3);
                this.furnaceItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        if (this.isInvNameLocalized()) {
            var1.setString("CustomName", this.customName);
        }

        var1.setTag("Items", var2);
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be
     * 64, possibly will be extended. *Isn't this more of a set than a get?*
     */
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public int getCookProgressScaled(int var1) {
        return this.furnaceCookTime * var1 / this.timeToSmelt();
    }

    public int getBurnTimeRemainingScaled(int var1) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = timeToSmelt();
        }

        return this.furnaceBurnTime * var1 / this.currentItemBurnTime;
    }

    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses,
     * e.g. the mob spawner uses this to count ticks and creates a new spawn
     * inside its implementation.
     */
    @Override
    public void updateEntity() {
        boolean var1 = this.furnaceBurnTime > 0;
        boolean var2 = false;

        if (this.furnaceBurnTime > 0) {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.isRemote) {
            if (this.furnaceBurnTime == 0 && this.canSmelt()) {
                this.currentItemBurnTime = this.furnaceBurnTime = this
                        .getItemBurnTime(this.furnaceItemStacks[1]);

                if (this.furnaceBurnTime > 0) {
                    var2 = true;

                    if (this.furnaceItemStacks[1] != null) {
                        if (this.furnaceItemStacks[1].getItem()
                                .hasContainerItem(null)) {
                            this.furnaceItemStacks[1] = new ItemStack(
                                    this.furnaceItemStacks[1].getItem()
                                            .getContainerItem());
                        } else {
                            --this.furnaceItemStacks[1].stackSize;
                        }

                        if (this.furnaceItemStacks[1].stackSize == 0) {
                            this.furnaceItemStacks[1] = null;
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt()) {
                ++this.furnaceCookTime;

                if (this.furnaceCookTime == timeToSmelt()) {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            } else {
                this.furnaceCookTime = 0;
            }

            if (var1 != this.furnaceBurnTime > 0) {
                var2 = true;
                BlockWorktable.updateFurnaceBlockState(
                        this.furnaceBurnTime > 0, this.worldObj, this.xCoord,
                        this.yCoord, this.zCoord);
            }
        }

        if (var2) {
            this.markDirty();
        }
    }

    private boolean canSmelt() {
        if (this.furnaceItemStacks[0] == null) {
            return false;
        } else {
            // ItemStack var1 =
            // this.CheckSmelt(this.furnaceItemStacks[0].getItem());
            ItemStack var1 = this.CheckSmelt(this.furnaceItemStacks[0]);
            return var1 != null && (this.furnaceItemStacks[2] == null || (this.furnaceItemStacks[2].isItemEqual(var1) && (this.furnaceItemStacks[2].stackSize < this
                    .getInventoryStackLimit()
                    && this.furnaceItemStacks[2].stackSize < this.furnaceItemStacks[2]
                    .getMaxStackSize() || this.furnaceItemStacks[2].stackSize < var1
                    .getMaxStackSize())));
        }
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack var1 = this.CheckSmelt(this.furnaceItemStacks[0]);

            if (this.furnaceItemStacks[2] == null) {
                if (var1 != null) {
                    this.furnaceItemStacks[2] = var1.copy();
                }
            } else if (this.furnaceItemStacks[2] == var1) {
                this.furnaceItemStacks[2].stackSize += var1.stackSize;
            }

            if (this.furnaceItemStacks[0].getItem().hasContainerItem(null)) {
                this.furnaceItemStacks[0] = new ItemStack(
                        this.furnaceItemStacks[0].getItem().getContainerItem());
            } else {
                --this.furnaceItemStacks[0].stackSize;
            }

            if (this.furnaceItemStacks[0].stackSize <= 0) {
                this.furnaceItemStacks[0] = null;
            }
        }
    }

    private int getItemBurnTime(ItemStack itemstack) {
        if (itemstack == null) {
            return 0;
        } else {
            Item var2 = itemstack.getItem();
            return var2 == FAItemRegistry.INSTANCE.relic ? 300 : 0;
        }
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes
     * with Container
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer var1) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord,
                this.zCoord) == this && var1.getDistanceSq(
                (double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,
                (double) this.zCoord + 0.5D) <= 64.0D;
    }

	/*
     * private ItemStack CheckSmelt(int var1) { return var1 ==
	 * Revival.brokenSword ? new ItemStack(Revival.ancientSword) : (var1 ==
	 * Revival.brokenhelmet ? new ItemStack(Revival.ancienthelmet) : (var1 ==
	 * Revival.gemAxe ? new ItemStack(Revival.gemAxe) : (var1 == Revival.gemPickaxe
	 * ? new ItemStack(Revival.gemPickaxe) : (var1 == Revival.gemSword ? new
	 * ItemStack(Revival.gemSword) : (var1 == Revival.gemHoe ? new
	 * ItemStack(Revival.gemHoe) : (var1 == Revival.gemShovel ? new
	 * ItemStack(Revival.gemShovel) : null)))))); }
	 */

    private ItemStack CheckSmelt(ItemStack itemstack) {
        ItemStack output = null;

        if (itemstack.getItem() == FAItemRegistry.INSTANCE.brokenSword) {
            return new ItemStack(FAItemRegistry.INSTANCE.ancientSword);
        }

        if (itemstack.getItem() == FAItemRegistry.INSTANCE.brokenhelmet) {
            return new ItemStack(FAItemRegistry.INSTANCE.ancienthelmet);
        }

        if (itemstack.getItem() == FAItemRegistry.INSTANCE.ancientSword) {
            output = new ItemStack(FAItemRegistry.INSTANCE.ancientSword);
        }

        if (itemstack.getItem() == FAItemRegistry.INSTANCE.ancienthelmet) {
            output = new ItemStack(FAItemRegistry.INSTANCE.ancienthelmet);
        }

        if (itemstack.getItem() == FAItemRegistry.INSTANCE.gemAxe) {
            output = new ItemStack(FAItemRegistry.INSTANCE.gemAxe);
        }

        if (itemstack.getItem() == FAItemRegistry.INSTANCE.gemPickaxe) {
            output = new ItemStack(FAItemRegistry.INSTANCE.gemPickaxe);
        }

        if (itemstack.getItem() == FAItemRegistry.INSTANCE.gemSword) {
            output = new ItemStack(FAItemRegistry.INSTANCE.gemSword);
        }

        if (itemstack.getItem() == FAItemRegistry.INSTANCE.gemHoe) {
            output = new ItemStack(FAItemRegistry.INSTANCE.gemHoe);
        }

        if (itemstack.getItem() == FAItemRegistry.INSTANCE.gemShovel) {
            output = new ItemStack(FAItemRegistry.INSTANCE.gemShovel);
        }

        if (output != null) {
            if (itemstack.getItemDamage() / itemstack.getMaxDamage() >= 0.1F) {
                output.setItemDamage(itemstack.getItemDamage()
                        - (int) (0.1 * itemstack.getMaxDamage()));
            } else {
                output.setItemDamage(0);
            }

            return output;
        }

        if (itemstack.getItem() == FAItemRegistry.INSTANCE.woodjavelin) {
            output = new ItemStack(FAItemRegistry.INSTANCE.woodjavelin, 1);
        }

        if (itemstack.getItem() == FAItemRegistry.INSTANCE.stonejavelin) {
            output = new ItemStack(FAItemRegistry.INSTANCE.stonejavelin, 1);
        }

        if (itemstack.getItem() == FAItemRegistry.INSTANCE.ironjavelin) {
            output = new ItemStack(FAItemRegistry.INSTANCE.ironjavelin, 1);
        }

        if (itemstack.getItem() == FAItemRegistry.INSTANCE.goldjavelin) {
            output = new ItemStack(FAItemRegistry.INSTANCE.goldjavelin, 1);
        }

        if (itemstack.getItem() == FAItemRegistry.INSTANCE.diamondjavelin) {
            output = new ItemStack(FAItemRegistry.INSTANCE.diamondjavelin, 1);
        }

        if (output != null) {
            if (itemstack.getItemDamage() > 5) {
                output.setItemDamage(itemstack.getItemDamage() - 5);
            } else {
                output.setItemDamage(0);
            }

            return output;
        }

        if (itemstack.getItem() == FAItemRegistry.INSTANCE.ancientJavelin) {
            output = new ItemStack(FAItemRegistry.INSTANCE.ancientJavelin, 1);

            if (itemstack.getItemDamage() > 3) {
                output.setItemDamage(itemstack.getItemDamage() - 3);
            } else {
                output.setItemDamage(0);
            }

            return output;
        }

        if (itemstack.getItem() == new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock)
                .getItem() && itemstack.getItemDamage() == 0) {
            output = new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1, 1);
            return output;
        }

        if (itemstack.getItem() == new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock)
                .getItem() && itemstack.getItemDamage() == 0) {
            output = new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1, 1);
            return output;
        }

        if (itemstack.getItem() == new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock)
                .getItem() && itemstack.getItemDamage() == 0) {
            output = new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock, 1, 1);
            return output;
        }

        return null;
    }

    private int timeToSmelt() {
        if (this.furnaceItemStacks[0] == null) {
            return 3000;
        }

        if (this.furnaceItemStacks[0].getItem() == FAItemRegistry.INSTANCE.brokenSword) {
            return 3000;
        }

        if (this.furnaceItemStacks[0].getItem() == FAItemRegistry.INSTANCE.brokenhelmet) {
            return 3000;
        }

        return 300;
    }

    public void openChest() {
    }

    public void closeChest() {
    }

    public int getSizeInventorySide(ForgeDirection var1) {
        return 1;
    }

    public int getStartInventorySide(ForgeDirection var1) {
        return var1 == ForgeDirection.DOWN ? 1 : (var1 == ForgeDirection.UP ? 0
                : 2);
    }

    /**
     * When some containers are closed they call this on each slot, then drop
     * whatever it returns as an EntityItem - like when you close a workbench
     * GUI.
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int var1) {
        return null;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        return slots_top;
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getInventoryName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void openInventory() {
        // TODO Auto-generated method stub

    }

    @Override
    public void closeInventory() {
        // TODO Auto-generated method stub

    }
}
