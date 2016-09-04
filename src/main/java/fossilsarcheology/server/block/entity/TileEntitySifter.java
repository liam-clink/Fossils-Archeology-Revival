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
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

import javax.annotation.Nullable;

public class TileEntitySifter extends TileEntity implements IInventory, ISidedInventory, ITickable {
    private static final int[] SLOTS_SIDES = new int[] {}; // input
    private static final int[] SLOTS_BOTTOM = new int[] { 1, 2, 3, 4, 5 }; // output
    private static final int[] SLOTS_TOP = new int[] { 0 };// fuel
    public int sifterBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int sifterCookTime = 0;
    private String customName;
    private ItemStack[] slots = new ItemStack[6];
    private int rawIndex = -1;
    private int spaceIndex = -1;

    private static int getItemBurnTime(ItemStack stack) {
        return 100;
    }

    public static boolean isItemFuel(ItemStack stack) {
        return getItemBurnTime(stack) > 0;
    }

    @Override
    public int getSizeInventory() {
        return this.slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.slots[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        return ItemStackHelper.getAndSplit(this.slots, slot, amount);
    }

    @Nullable
    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.slots, index);
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        this.slots[slot] = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "tile." + LocalizationStrings.BLOCK_SIFTER_IDLE + ".name";
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && this.customName.length() > 0;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList itemList = compound.getTagList("Items", 10);
        this.slots = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < itemList.tagCount(); ++i) {
            NBTTagCompound itemTag = itemList.getCompoundTagAt(i);
            byte slot = itemTag.getByte("Slot");
            if (slot >= 0 && slot < this.slots.length) {
                this.slots[slot] = ItemStack.loadItemStackFromNBT(itemTag);
            }
        }
        this.sifterBurnTime = compound.getShort("BurnTime");
        this.sifterCookTime = compound.getShort("CookTime");
        this.currentItemBurnTime = 100;
        if (compound.hasKey("CustomName")) {
            this.customName = compound.getString("CustomName");
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        compound.setShort("BurnTime", (short) this.sifterBurnTime);
        compound.setShort("CookTime", (short) this.sifterCookTime);
        NBTTagList itemsList = new NBTTagList();
        for (int i = 0; i < this.slots.length; ++i) {
            if (this.slots[i] != null) {
                NBTTagCompound itemTag = new NBTTagCompound();
                itemTag.setByte("Slot", (byte) i);
                this.slots[i].writeToNBT(itemTag);
                itemsList.appendTag(itemTag);
            }
        }
        if (this.hasCustomName()) {
            compound.setString("CustomName", this.customName);
        }
        compound.setTag("Items", itemsList);
        return compound;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public int getSiftProgressScaled(int scale) {
        return this.sifterCookTime * scale / 200;
    }

    public int getSiftTimeRemainingScaled(int scale) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = 100;
        }
        return this.sifterBurnTime * scale / this.currentItemBurnTime;
    }

    public boolean isSifting() {
        return this.sifterBurnTime > 0;
    }

    @Override
    public void update() {
        boolean burning = this.sifterBurnTime > 0;
        boolean dirty = false;
        if (this.sifterBurnTime > 0) {
            --this.sifterBurnTime;
        }
        if (!this.worldObj.isRemote) {
            if (this.sifterBurnTime == 0 && this.canSift()) {
                this.currentItemBurnTime = this.sifterBurnTime = 100;
                if (this.sifterBurnTime > 0) {
                    dirty = true;
                }
            }
            if (this.isSifting() && this.canSift()) {
                ++this.sifterCookTime;
                if (this.sifterCookTime == 200) {
                    this.sifterCookTime = 0;
                    this.siftItem();
                    dirty = true;
                }
            } else {
                this.sifterCookTime = 0;
            }
            if (burning != this.sifterBurnTime > 0) {
                dirty = true;
                BlockSifter.setState(this.sifterBurnTime > 0, this.worldObj, this.pos);
            }
        }
        if (dirty) {
            this.markDirty();
        }
    }

    private boolean canSift() {
        this.spaceIndex = -1;
        this.rawIndex = -1;
        for (int i = 0; i < 1; ++i) {
            if (this.slots[i] != null) {
                Item input = this.slots[i].getItem();
                if ((input == Item.getItemFromBlock(Blocks.SAND)) || (input == Item.getItemFromBlock(Blocks.DIRT)) || (input == Item.getItemFromBlock(Blocks.GRAVEL)) || (input == Item.getItemFromBlock(Blocks.CLAY)) || (input == Item.getItemFromBlock(FABlockRegistry.INSTANCE.volcanicAsh))) {
                    this.rawIndex = i;
                    break;
                }
            }
        }
        if (this.rawIndex == -1) {
            return false;
        } else {
            for (int i = 5; i > 0; --i) {
                if (this.slots[i] == null) {
                    this.spaceIndex = i;
                    break;
                }
            }
            return this.spaceIndex != -1 && this.rawIndex != -1;
        }
    }

    public void siftItem() {
        if (this.canSift()) {
            ItemStack result = null;
            int resultRandom = (this.worldObj.rand).nextInt(100);
            double random = (this.worldObj.rand).nextInt(100);
            if (this.slots[this.rawIndex].getItem() == Item.getItemFromBlock(Blocks.SAND) || this.slots[this.rawIndex].getItem() == Item.getItemFromBlock(Blocks.DIRT) || this.slots[this.rawIndex].getItem() == Item.getItemFromBlock(Blocks.GRAVEL) || this.slots[this.rawIndex].getItem() == Item.getItemFromBlock(Blocks.CLAY) || this.slots[this.rawIndex].getItem() == Item.getItemFromBlock(FABlockRegistry.INSTANCE.volcanicAsh)) {
                if (resultRandom < 80) {
                    if (Revival.RELEASE_TYPE.enableDebugging()) {
                        Revival.printDebug("Sifter no result: " + resultRandom);
                    }
                    if (random < 75) {
                        result = null;
                    } else {
                        result = this.slots[this.spaceIndex];
                    }
                } else {
                    if (Revival.RELEASE_TYPE.enableDebugging()) {
                        Revival.printDebug("Sifter successful loot: " + resultRandom);
                    }
                    if (random < 0.4) {
                        result = new ItemStack(FAItemRegistry.INSTANCE.DominicanAmber, 1);
                    } else if (random < 15) {
                        result = new ItemStack(FAItemRegistry.INSTANCE.brokenSapling, 1);
                    } else if (random < 30) {
                        result = new ItemStack(Items.POTATO, 1);
                    } else if (random < 40) {
                        result = new ItemStack(Items.CARROT, 1);
                    } else if (random < 60) {
                        result = new ItemStack(Items.DYE, 1, 15);
                    } else if (random < 80) {
                        result = new ItemStack(Blocks.SAND, 1);
                    } else if (random < 90) {
                        result = new ItemStack(FAItemRegistry.INSTANCE.fernSeed, 2);
                    } else if (random < 95) {
                        result = new ItemStack(FAItemRegistry.INSTANCE.potteryShards, 3);
                    } else if (random <= 100) {
                        int i = this.worldObj.rand.nextInt(15);
                        Item item;
                        if (i == 0) {
                            item = FAItemRegistry.INSTANCE.brokenSapling;
                        } else {
                            item = FAItemRegistry.INSTANCE.biofossil;
                        }
                        result = new ItemStack(item, 1);
                    }
                }
            }
            if (result != null) {
                if (result.stackSize != 0 && this.slots[this.spaceIndex] == null) {
                    this.slots[this.spaceIndex] = result.copy();
                } else if (this.slots[this.spaceIndex].isItemEqual(result)) {
                    this.slots[this.spaceIndex].stackSize += result.stackSize;
                }
            }
            --this.slots[0].stackSize;
            if (this.slots[0].stackSize <= 0) {
                this.slots[0] = null;
            }
        }
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.pos) == this && player.getDistanceSq(this.pos) <= 64.0D;
    }

    @Override
    public void openInventory(EntityPlayer player) {
    }

    @Override
    public void closeInventory(EntityPlayer player) {
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return index == 0 && isItemFuel(stack);
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.slots.length; i++) {
            this.slots[i] = null;
        }
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return side == EnumFacing.DOWN ? SLOTS_BOTTOM : (side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES);
    }

    @Override
    public boolean canInsertItem(int index, ItemStack stack, EnumFacing direction) {
        return this.isItemValidForSlot(index, stack);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        return direction != EnumFacing.DOWN || index != 1 || stack.getItem() == Items.BUCKET;
    }
}
