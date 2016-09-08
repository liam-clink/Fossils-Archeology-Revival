package fossilsarcheology.server.block.entity;

import fossilsarcheology.api.Diet;
import fossilsarcheology.api.FoodMappings;
import fossilsarcheology.server.block.BlockFeeder;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import fossilsarcheology.server.handler.LocalizationStrings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEntityFeeder extends TileEntity implements IInventory, ISidedInventory, ITickable {
    private static final int[] SLOTS_CARNIVORE = new int[] { 0 };
    private static final int[] SLOTS_HERBIVORE = new int[] { 1 };

    public int currentMeat = 0;
    public int maxMeat = 10000;
    public int currentPlant = 0;
    public int maxPlant = 10000;
    private ItemStack[] slots = new ItemStack[2];
    private String customName;
    private int ticksExisted;

    @Override
    public int getSizeInventory() {
        return this.slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.slots[index];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        return ItemStackHelper.getAndSplit(this.slots, slot, amount);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.slots, index);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList itemsList = compound.getTagList("Items", 10);
        this.slots = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < itemsList.tagCount(); ++i) {
            NBTTagCompound itemTag = itemsList.getCompoundTagAt(i);
            byte slot = itemTag.getByte("Slot");
            if (slot >= 0 && slot < this.slots.length) {
                this.slots[slot] = ItemStack.loadItemStackFromNBT(itemTag);
            }
        }
        this.currentMeat = compound.getShort("MeatCurrent");
        this.currentPlant = compound.getShort("VegCurrent");
        if (compound.hasKey("CustomName")) {
            this.customName = compound.getString("CustomName");
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        NBTTagList itemsList = new NBTTagList();
        for (int slot = 0; slot < this.slots.length; ++slot) {
            if (this.slots[slot] != null) {
                NBTTagCompound itemTag = new NBTTagCompound();
                itemTag.setByte("Slot", (byte) slot);
                this.slots[slot].writeToNBT(itemTag);
                itemsList.appendTag(itemTag);
            }
        }
        compound.setTag("Items", itemsList);
        compound.setInteger("MeatCurrent", this.currentMeat);
        compound.setInteger("VegCurrent", this.currentPlant);
        if (this.hasCustomName()) {
            compound.setString("CustomName", this.customName);
        }
        return compound;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.slots[index] = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    public int getMeatBarScaled(int i) {
        return this.currentMeat * i / this.maxMeat;
    }

    public int getVegBarScaled(int i) {
        return this.currentPlant * i / this.maxPlant;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
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

    public int getCurrentMeat() {
        return this.currentMeat;
    }

    public int getCurrentPlant() {
        return this.currentPlant;
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (stack != null) {
            if (index == 1) {
                return FoodMappings.INSTANCE.getItemFoodAmount(stack.getItem(), Diet.CARNIVORE_EGG) != 0;
            } else {
                return FoodMappings.INSTANCE.getItemFoodAmount(stack.getItem(), Diet.HERBIVORE) != 0;
            }
        }
        return false;
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

    public boolean isEmpty(PrehistoricEntityType type) {
        if (type.diet == Diet.CARNIVORE || type.diet == Diet.CARNIVORE_EGG || type.diet == Diet.PISCCARNIVORE) {
            return currentMeat == 0;
        } else if (type.diet == Diet.HERBIVORE) {
            return currentPlant == 0;
        }
        return type.diet != Diet.OMNIVORE || currentMeat == 0 && currentPlant == 0;
    }

    public int feedDinosaur(EntityPrehistoric entity) {
        int amount = 0;
        if (!this.isEmpty(entity.type)) {
            if (entity.type.diet == Diet.CARNIVORE || entity.type.diet == Diet.CARNIVORE_EGG || entity.type.diet == Diet.PISCCARNIVORE) {
                currentMeat--;
                amount++;
            }
            if (entity.type.diet == Diet.HERBIVORE) {
                currentPlant--;
                amount++;
            }
            if (entity.type.diet == Diet.OMNIVORE) {
                if (currentMeat == 0 && currentPlant != 0) {
                    currentPlant--;
                    amount++;
                }
                if (currentMeat != 0 && currentPlant == 0) {
                    currentMeat--;
                    amount++;
                }
            }
            BlockFeeder.updateFeederBlockState(this.currentPlant > 0, this.currentMeat > 0, this.worldObj, this.pos);
        }
        entity.setHunger(entity.getHunger() + amount);
        return amount;
    }

    @Override
    public void update() {
        this.ticksExisted++;
        if (ticksExisted % 5 == 0) {
            if (this.slots[0] != null && this.slots[0].getItem() != null) {
                if (this.currentMeat < this.maxMeat) {
                    int carnivoreValue = FoodMappings.INSTANCE.getItemFoodAmount(this.slots[0].getItem(), Diet.CARNIVORE_EGG);
                    if (carnivoreValue != 0) {
                        int foodLeft = this.maxMeat - this.currentMeat;
                        if (carnivoreValue > foodLeft) {
                            this.currentMeat = this.maxMeat;
                            this.decrStackSize(0, 1);
                            BlockFeeder.updateFeederBlockState(this.currentPlant > 0, this.currentMeat > 0, this.worldObj, this.pos);
                        } else {
                            this.currentMeat += carnivoreValue;
                            this.decrStackSize(0, 1);
                            BlockFeeder.updateFeederBlockState(this.currentPlant > 0, this.currentMeat > 0, this.worldObj, this.pos);
                        }
                    }
                }
            }
            if (this.slots[1] != null && this.slots[1].getItem() != null) {
                if (this.currentPlant < this.maxPlant) {
                    int herbivoreValue = FoodMappings.INSTANCE.getItemFoodAmount(this.slots[1].getItem(), Diet.HERBIVORE);
                    if (herbivoreValue != 0) {
                        int foodLeft = this.maxPlant - this.currentPlant;
                        if (herbivoreValue > foodLeft) {
                            this.currentPlant = this.maxPlant;
                            this.decrStackSize(1, 1);
                            BlockFeeder.updateFeederBlockState(this.currentPlant > 0, this.currentMeat > 0, this.worldObj, this.pos);
                        } else {
                            this.currentPlant += herbivoreValue;
                            this.decrStackSize(1, 1);
                            BlockFeeder.updateFeederBlockState(this.currentPlant > 0, this.currentMeat > 0, this.worldObj, this.pos);
                        }
                    }
                }
            }
        }
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return side == EnumFacing.UP ? SLOTS_HERBIVORE : SLOTS_CARNIVORE;
    }

    @Override
    public boolean canInsertItem(int index, ItemStack stack, EnumFacing direction) {
        return this.isItemValidForSlot(index, stack);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        return false;
    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "tile." + LocalizationStrings.FEEDER_ACTIVE_NAME + ".name";
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && this.customName.length() > 0;
    }
}
