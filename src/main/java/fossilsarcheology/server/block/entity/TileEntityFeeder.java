package fossilsarcheology.server.block.entity;

import fossilsarcheology.server.block.FeederBlock;
import fossilsarcheology.server.entity.prehistoric.Diet;
import fossilsarcheology.server.entity.prehistoric.EntityPrehistoric;
import fossilsarcheology.server.entity.prehistoric.PrehistoricEntityType;
import fossilsarcheology.server.util.FoodMappings;
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
import net.minecraft.util.text.translation.I18n;

import javax.annotation.Nullable;

/**
 * Created by alexr_000 on 3/4/2017.
 */
public class TileEntityFeeder extends TileEntity implements IInventory, ISidedInventory, ITickable {
    private static final int[] slots_all = new int[]{0, 1};
    public int currentMeat = 0;
    public int maxMeat = 10000;
    public int currentPlant = 0;
    public int maxPlant = 10000;
    private ItemStack[] feederItemStacks = new ItemStack[2];
    private String customName;
    private int ticksExisted;

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return slots_all;
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return isItemValidForSlot(index, itemStackIn);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        return false;
    }

    @Override
    public int getSizeInventory() {
        return this.feederItemStacks.length;
    }

    @Nullable
    @Override
    public ItemStack getStackInSlot(int index) {
        return this.feederItemStacks[index];
    }

    @Nullable
    @Override
    public ItemStack decrStackSize(int index, int count) {
        if (this.feederItemStacks[index] != null) {
            ItemStack stack;

            if (this.feederItemStacks[index].stackSize <= count) {
                stack = this.feederItemStacks[index];
                this.feederItemStacks[index] = null;
                return stack;
            } else {
                stack = this.feederItemStacks[index].splitStack(count);

                if (this.feederItemStacks[index].stackSize == 0) {
                    this.feederItemStacks[index] = null;
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
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
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

        if (this.hasCustomName()) {
            tag.setString("CustomName", this.customName);
        }
        return tag;
    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : I18n.translateToLocal("tile.feederActive.name");
    }

    public void setCustomName(String name) {
        this.customName = name;
    }
    @Override
    public boolean hasCustomName() {
        return this.customName != null && this.customName.length() > 0;
    }

    @Nullable
    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.feederItemStacks, index);
    }


    @Override
    public void setInventorySlotContents(int index, @Nullable ItemStack stack) {
        this.feederItemStacks[index] = stack;

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
        return this.worldObj.getTileEntity(this.pos) == this && player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
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
        if (stack != null && stack.getItem() != null) {
            if(FoodMappings.INSTANCE.getItemFoodAmount(stack, Diet.HERBIVORE) != 0 && index == 1) {
                return true;
            }else if(FoodMappings.INSTANCE.getItemFoodAmount(stack, Diet.CARNIVORE_EGG) != 0 && index == 0){
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty(PrehistoricEntityType type) {
        if (type.diet == Diet.CARNIVORE || type.diet == Diet.CARNIVORE_EGG || type.diet == Diet.PISCCARNIVORE) {
            return currentMeat == 0;
        }
        if (type.diet == Diet.HERBIVORE) {
            return currentPlant == 0;
        }
        return type.diet != Diet.OMNIVORE || currentMeat == 0 && currentPlant == 0;
    }

    public int feedDinosaur(EntityPrehistoric mob) {
        int feedamount = 0;

        if (!this.isEmpty(mob.type)) {
            if (mob.type.diet == Diet.CARNIVORE || mob.type.diet == Diet.CARNIVORE_EGG || mob.type.diet == Diet.PISCCARNIVORE) {
                currentMeat--;
                feedamount++;
            }
            if (mob.type.diet == Diet.HERBIVORE) {
                currentPlant--;
                feedamount++;
            }
            if (mob.type.diet == Diet.OMNIVORE) {
                if (currentMeat == 0 && currentPlant != 0) {
                    currentPlant--;
                    feedamount++;
                }
                if (currentMeat != 0 && currentPlant == 0) {
                    currentMeat--;
                    feedamount++;
                }
            }
            FeederBlock.updateFeederBlockState(this.currentPlant > 0, this.currentMeat > 0, this.worldObj, this.pos);
        }
        mob.setHunger(mob.getHunger() + feedamount);
        return feedamount;
    }
    
    @Override
    public int getField(int id) {
        return id == 0 ? this.currentMeat : this.currentPlant;
    }

    @Override
    public void setField(int id, int value) {
        if(id == 0){
            this.currentMeat = value;
        }else{
            this.currentPlant = value;
        }
    }

    @Override
    public int getFieldCount() {
        return 2;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.feederItemStacks.length; i++) {
            this.feederItemStacks[0] = null;
        }
    }

    @Override
    public void update() {
        ticksExisted++;
        if (ticksExisted % 5 == 0) {
            if (this.feederItemStacks[0] != null && this.feederItemStacks[0].getItem() != null) {
                {
                    if (this.currentMeat < this.maxMeat) {
                        int carnivoreValue = FoodMappings.INSTANCE.getItemFoodAmount(this.feederItemStacks[0], Diet.CARNIVORE_EGG);
                        if (carnivoreValue != 0) {
                            int foodLeft = this.maxMeat - this.currentMeat;
                            if (carnivoreValue > foodLeft) {
                                this.currentMeat = this.maxMeat;
                                this.decrStackSize(0, 1);
                                FeederBlock.updateFeederBlockState(this.currentPlant > 0, this.currentMeat > 0, this.worldObj, this.pos);

                            } else {
                                this.currentMeat += carnivoreValue;
                                this.decrStackSize(0, 1);
                                FeederBlock.updateFeederBlockState(this.currentPlant > 0, this.currentMeat > 0, this.worldObj, this.pos);
                            }
                        }
                    }
                }
            }
            if (this.feederItemStacks[1] != null && this.feederItemStacks[1].getItem() != null) {
                {
                    if (this.currentPlant < this.maxPlant) {
                        int herbivoreValue = FoodMappings.INSTANCE.getItemFoodAmount(this.feederItemStacks[1], Diet.HERBIVORE);
                        if (herbivoreValue != 0) {
                            int foodLeft = this.maxPlant - this.currentPlant;
                            if (herbivoreValue > foodLeft) {
                                this.currentPlant = this.maxPlant;
                                this.decrStackSize(1, 1);
                                FeederBlock.updateFeederBlockState(this.currentPlant > 0, this.currentMeat > 0, this.worldObj, this.pos);
                            } else {
                                this.currentPlant += herbivoreValue;
                                this.decrStackSize(1, 1);
                                FeederBlock.updateFeederBlockState(this.currentPlant > 0, this.currentMeat > 0, this.worldObj, this.pos);
                            }
                        }
                    }
                }
            }
        }
    }
}
