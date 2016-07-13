package fossilsarcheology.server.block.entity;

import fossilsarcheology.Revival;
import fossilsarcheology.server.block.BlockSifter;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

public class TileEntitySifter extends TileEntity implements IInventory, ISidedInventory {

    private static final int[] slots_sides = new int[]{}; // input
    private static final int[] slots_bottom = new int[]{1, 2, 3, 4, 5}; // output
    private static final int[] slots_top = new int[]{0};// fuel
    public int sifterBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int sifterCookTime = 0;
    private String customName;
    private ItemStack[] sifterItemStacks;
    private int RawIndex = -1;
    private int SpaceIndex = -1;

    public TileEntitySifter() {
        sifterItemStacks = new ItemStack[6];
    }

    private static int getItemBurnTime(ItemStack var1) {
        return 100;
    }

    /**
     * Return true if item is a fuel source (getItemBurnTime() > 0).
     */
    public static boolean isItemFuel(ItemStack par0ItemStack) {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory() {
        return this.sifterItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    @Override
    public ItemStack getStackInSlot(int var1) {
        return this.sifterItemStacks[var1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number
     * (second arg) of items and returns them in a new stack.
     */
    @Override
    public ItemStack decrStackSize(int var1, int var2) {
        if (this.sifterItemStacks[var1] != null) {
            ItemStack var3;

            if (this.sifterItemStacks[var1].stackSize <= var2) {
                var3 = this.sifterItemStacks[var1];
                this.sifterItemStacks[var1] = null;
                return var3;
            } else {
                var3 = this.sifterItemStacks[var1].splitStack(var2);

                if (this.sifterItemStacks[var1].stackSize == 0) {
                    this.sifterItemStacks[var1] = null;
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
        this.sifterItemStacks[var1] = var2;

        if (var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
            var2.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.customName : "tile." + LocalizationStrings.BLOCK_SIFTER_IDLE + ".name";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return this.customName != null && this.customName.length() > 0;
    }

    /**
     * Reads a tile entity from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound var1) {
        super.readFromNBT(var1);
        NBTTagList var2 = var1.getTagList("Items", 10);
        this.sifterItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3) {
            NBTTagCompound var4 = var2.getCompoundTagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.sifterItemStacks.length) {
                this.sifterItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.sifterBurnTime = var1.getShort("BurnTime");
        this.sifterCookTime = var1.getShort("CookTime");
        this.currentItemBurnTime = 100;

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
        var1.setShort("BurnTime", (short) this.sifterBurnTime);
        var1.setShort("CookTime", (short) this.sifterCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.sifterItemStacks.length; ++var3) {
            if (this.sifterItemStacks[var3] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte) var3);
                this.sifterItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        if (this.hasCustomInventoryName()) {
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

    public int getSiftProgressScaled(int var1) {
        return this.sifterCookTime * var1 / 200;
    }

    public int getSiftTimeRemainingScaled(int var1) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = 100;
        }

        return this.sifterBurnTime * var1 / this.currentItemBurnTime;
    }

    public boolean isBurning() {
        return this.sifterBurnTime > 0;
    }

	/*
     * Where the items that they player can receive are added
	 */

    /**
     * Allows the entity to update its state. Overridden in most subclasses,
     * e.g. the mob spawner uses this to count ticks and creates a new spawn
     * inside its implementation.
     */
    @Override
    public void updateEntity() {
        boolean var1 = this.sifterBurnTime > 0;
        boolean var2 = false;
        if (this.sifterBurnTime > 0) {
            --this.sifterBurnTime;
        }

        if (!this.worldObj.isRemote) {
            if (this.sifterBurnTime == 0 && this.canSmelt()) {
                this.currentItemBurnTime = this.sifterBurnTime = 100;

                if (this.sifterBurnTime > 0) {
                    var2 = true;
                }
            }

            if (this.isBurning() && this.canSmelt()) {
                ++this.sifterCookTime;

                if (this.sifterCookTime == 200) {
                    this.sifterCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            } else {
                this.sifterCookTime = 0;
            }

            if (var1 != this.sifterBurnTime > 0) {
                var2 = true;
                BlockSifter.updateFurnaceBlockState(this.sifterBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (var2) {
            this.markDirty();
        }
    }

    private boolean canSmelt() {
        this.SpaceIndex = -1;
        this.RawIndex = -1;
        int var1;

        for (var1 = 0; var1 < 1; ++var1) {
            if (this.sifterItemStacks[var1] != null) {
                Item input = this.sifterItemStacks[var1].getItem();

                ItemStack itemstack = this.sifterItemStacks[var1];

                if ((input == Item.getItemFromBlock(Blocks.sand)) || (input == Item.getItemFromBlock(Blocks.dirt)) || (input == Item.getItemFromBlock(Blocks.gravel)) || (input == Item.getItemFromBlock(Blocks.clay)) || (input == Item.getItemFromBlock(FABlockRegistry.INSTANCE.volcanicAsh))) {
                    this.RawIndex = var1;
                    break;
                }
            }
        }

        if (this.RawIndex == -1) {
            return false;
        } else {
            for (var1 = 5; var1 > 0; --var1) {
                if (this.sifterItemStacks[var1] == null) {
                    this.SpaceIndex = var1;
                    break;
                }
            }

            return this.SpaceIndex != -1 && this.RawIndex != -1;
        }
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack result = null;
            int randomloot = (new Random()).nextInt(100);
            double random = (new Random()).nextInt(100);
            int var3;

            if (this.sifterItemStacks[this.RawIndex].getItem() == Item.getItemFromBlock(Blocks.sand) || this.sifterItemStacks[this.RawIndex].getItem() == Item.getItemFromBlock(Blocks.dirt) || this.sifterItemStacks[this.RawIndex].getItem() == Item.getItemFromBlock(Blocks.gravel) || this.sifterItemStacks[this.RawIndex].getItem() == Item.getItemFromBlock(Blocks.clay) || this.sifterItemStacks[this.RawIndex].getItem() == Item.getItemFromBlock(FABlockRegistry.INSTANCE.volcanicAsh)

                    ) {
                if (randomloot < 80) {
                    if (Revival.RELEASE_TYPE.enableDebugging()) {
                        Revival.printDebug("Sifter no result: " + randomloot);
                    }
                    if (random < 75) {
                        result = null;
                    } else {
                        result = this.sifterItemStacks[this.SpaceIndex];
                    }
                } else {
                    if (Revival.RELEASE_TYPE.enableDebugging()) {
                        Revival.printDebug("Sifter successful loot: " + randomloot);
                    }
                    if (random < 0.4) {
                        result = new ItemStack(FAItemRegistry.INSTANCE.DominicanAmber, 1);
                    } else if (random < 15) {
                        result = new ItemStack(FAItemRegistry.INSTANCE.brokenSapling, 1);
                    } else if (random < 30) {
                        result = new ItemStack(Items.potato, 1);
                    } else if (random < 40) {
                        result = new ItemStack(Items.carrot, 1);
                    } else if (random < 60) {
                        result = new ItemStack(Items.dye, 1, 15);
                    } else if (random < 80) {
                        result = new ItemStack(Blocks.sand, 1);
                    } else if (random < 90) {
                        result = new ItemStack(FAItemRegistry.INSTANCE.fernSeed, 2);
                    } else if (random < 95) {
                        result = new ItemStack(FAItemRegistry.INSTANCE.potteryShards, 3);
                    } else if (random <= 100) {
                        int i = (new Random()).nextInt(15);
                        // for
                        // the
                        // sapling
                        Item i0 = null;

                        if (i == 0) {
                            i0 = FAItemRegistry.INSTANCE.brokenSapling;
                        } else {
                            i0 = FAItemRegistry.INSTANCE.biofossil;
                        }

                        result = new ItemStack(i0, 1);
                    }
                }
            }
            if (result != null) {
                if (result.stackSize != 0 && this.sifterItemStacks[this.SpaceIndex] == null) {
                    this.sifterItemStacks[this.SpaceIndex] = result.copy();
                } else if (this.sifterItemStacks[this.SpaceIndex].isItemEqual(result)) {
                    sifterItemStacks[this.SpaceIndex].stackSize += result.stackSize;
                }
            }

            --this.sifterItemStacks[0].stackSize;

            if (this.sifterItemStacks[0].stackSize <= 0) {
                this.sifterItemStacks[0] = null;
            }

        }
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes
     * with Container
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer var1) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && var1.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring
     * stack size) into the given slot.
     */
    public boolean isStackValidForSlot(int par1, ItemStack par2ItemStack) {
        return par1 <= 8 && (par1 >= 8 || isItemFuel(par2ItemStack));
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

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring
     * stack size) into the given slot.
     */
    @Override
    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
        return par1 == 0 && isItemFuel(par2ItemStack);
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed
     * by automation on the given side of this block.
     */
    @Override
    public int[] getAccessibleSlotsFromSide(int par1) {
        return par1 == 0 ? slots_bottom : (par1 == 1 ? slots_top : slots_sides);
    }

    /**
     * Returns true if automation can insert the given item in the given slot
     * from the given side. Args: Slot, item, side
     */
    @Override
    public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3) {
        return this.isItemValidForSlot(par1, par2ItemStack);
    }

    /**
     * Returns true if automation can extract the given item in the given slot
     * from the given side. Args: Slot, item, side
     */
    @Override
    public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3) {
        return par3 != 0 || par1 != 1 || par2ItemStack.getItem() == Items.bucket;
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
