package fossilsarcheology.server.block.entity;

import fossilsarcheology.server.block.BlockFeeder;
import fossilsarcheology.server.entity.EntityPrehistoric;
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.api.EnumDiet;
import fossilsarcheology.api.FoodMappings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFeeder extends TileEntity implements IInventory, ISidedInventory {

    private static final int[] slots_all = new int[]{0, 1};
    public int currentMeat = 0;
    public int maxMeat = 10000;
    public int currentPlant = 0;
    public int maxPlant = 10000;
    private ItemStack[] feederItemStacks = new ItemStack[2];
    private String customName;
    private int ticksExisted;

    @Override
    public int[] getAccessibleSlotsFromSide(int i) {
        return slots_all;
    }

    @Override
    public boolean canInsertItem(int i, ItemStack stack, int ammount) {
        return isItemValidForSlot(i, stack);
    }

    @Override
    public boolean canExtractItem(int i, ItemStack stack, int ammount) {
        return false;
    }

    @Override
    public int getSizeInventory() {
        return this.feederItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return this.feederItemStacks[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int amount) {
        if (this.feederItemStacks[i] != null) {
            ItemStack stack;

            if (this.feederItemStacks[i].stackSize <= amount) {
                stack = this.feederItemStacks[i];
                this.feederItemStacks[i] = null;
                return stack;
            } else {
                stack = this.feederItemStacks[i].splitStack(amount);

                if (this.feederItemStacks[i].stackSize == 0) {
                    this.feederItemStacks[i] = null;
                }

                return stack;
            }
        } else {
            return null;
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        NBTTagList tag2 = tag.getTagList("Items", 10);
        this.feederItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < tag2.tagCount(); ++i) {
            NBTTagCompound var4 = tag2.getCompoundTagAt(i);
            byte slots = var4.getByte("Slot");

            if (slots >= 0 && slots < this.feederItemStacks.length) {
                this.feederItemStacks[slots] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.currentMeat = tag.getShort("MeatCurrent");
        this.currentPlant = tag.getShort("VegCurrent");

        if (tag.hasKey("CustomName")) {
            this.customName = tag.getString("CustomName");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        NBTTagList tag2 = new NBTTagList();

        for (int i = 0; i < this.feederItemStacks.length; ++i) {
            if (this.feederItemStacks[i] != null) {
                NBTTagCompound tag3 = new NBTTagCompound();
                tag3.setByte("Slot", (byte) i);
                this.feederItemStacks[i].writeToNBT(tag3);
                tag2.appendTag(tag3);
            }
        }

        tag.setTag("Items", tag2);
        tag.setInteger("MeatCurrent", this.currentMeat);
        tag.setInteger("VegCurrent", this.currentPlant);

        if (this.hasCustomInventoryName()) {
            tag.setString("CustomName", this.customName);
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack stack) {
        this.feederItemStacks[i] = stack;

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
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }

    public int getCurrentMeat() {
        return this.currentMeat;
    }

    public int getCurrentPlant() {
        return this.currentPlant;
    }

    public void setGuiDisplayName(String par1Str) {
        this.customName = par1Str;
    }

    @Override
    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.customName : "tile." + LocalizationStrings.FEEDER_ACTIVE_NAME + ".name";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return this.customName != null && this.customName.length() > 0;
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack stack) {
        if (stack != null && stack != null) {
            if(FoodMappings.INSTANCE.getItemFoodAmount(new ItemStack(stack.getItem()), EnumDiet.HERBIVORE) != 0 && i == 1) {
                return true;
            }else if(FoodMappings.INSTANCE.getItemFoodAmount(new ItemStack(stack.getItem()), EnumDiet.CARNIVORE_EGG) != 0 && i == 0){
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty(EnumPrehistoric type) {
        if (type.diet == EnumDiet.CARNIVORE || type.diet == EnumDiet.CARNIVORE_EGG || type.diet == EnumDiet.PISCCARNIVORE) {
            return currentMeat == 0;
        }
        if (type.diet == EnumDiet.HERBIVORE) {
            return currentPlant == 0;
        }
        return type.diet != EnumDiet.OMNIVORE || currentMeat == 0 && currentPlant == 0;
    }

    public int feedDinosaur(EntityPrehistoric mob) {
        int feedamount = 0;

        if (!this.isEmpty(mob.type)) {
            if (mob.type.diet == EnumDiet.CARNIVORE || mob.type.diet == EnumDiet.CARNIVORE_EGG || mob.type.diet == EnumDiet.PISCCARNIVORE) {
                currentMeat--;
                feedamount++;
            }
            if (mob.type.diet == EnumDiet.HERBIVORE) {
                currentPlant--;
                feedamount++;
            }
            if (mob.type.diet == EnumDiet.OMNIVORE) {
                if (currentMeat == 0 && currentPlant != 0) {
                    currentPlant--;
                    feedamount++;
                }
                if (currentMeat != 0 && currentPlant == 0) {
                    currentMeat--;
                    feedamount++;
                }
            }
            BlockFeeder.updateFeederBlockState(this.currentPlant > 0, this.currentMeat > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
        }
        mob.setHunger(mob.getHunger() + feedamount);
        return feedamount;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        ticksExisted++;
        if (ticksExisted % 5 == 0) {
            if (this.feederItemStacks[0] != null && this.feederItemStacks[0].getItem() != null) {
                {
                    if (this.currentMeat < this.maxMeat) {
                        int carnivoreValue = FoodMappings.INSTANCE.getItemFoodAmount(this.feederItemStacks[0], EnumDiet.CARNIVORE_EGG);
                        if (carnivoreValue != 0) {
                            int foodLeft = this.maxMeat - this.currentMeat;
                            if (carnivoreValue > foodLeft) {
                                this.currentMeat = this.maxMeat;
                                this.decrStackSize(0, 1);
                                BlockFeeder.updateFeederBlockState(this.currentPlant > 0, this.currentMeat > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);

                            } else {
                                this.currentMeat += carnivoreValue;
                                this.decrStackSize(0, 1);
                                BlockFeeder.updateFeederBlockState(this.currentPlant > 0, this.currentMeat > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
                            }
                        }
                    }
                }
            }
            if (this.feederItemStacks[1] != null && this.feederItemStacks[1].getItem() != null) {
                {
                    if (this.currentPlant < this.maxPlant) {
                        int herbivoreValue = FoodMappings.INSTANCE.getItemFoodAmount(this.feederItemStacks[1], EnumDiet.HERBIVORE);
                        if (herbivoreValue != 0) {
                            int foodLeft = this.maxPlant - this.currentPlant;
                            if (herbivoreValue > foodLeft) {
                                this.currentPlant = this.maxPlant;
                                this.decrStackSize(1, 1);
                                BlockFeeder.updateFeederBlockState(this.currentPlant > 0, this.currentMeat > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
                            } else {
                                this.currentPlant += herbivoreValue;
                                this.decrStackSize(1, 1);
                                BlockFeeder.updateFeederBlockState(this.currentPlant > 0, this.currentMeat > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
                            }
                        }
                    }
                }
            }
        }
    }
}
