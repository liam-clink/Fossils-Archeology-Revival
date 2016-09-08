package fossilsarcheology.server.block.entity;

import fossilsarcheology.Revival;
import fossilsarcheology.server.block.BlockCultivate;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.BirdEggItem;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

import javax.annotation.Nullable;
import java.util.Random;

public class TileEntityCultivate extends TileEntity implements IInventory, ISidedInventory, ITickable {
    private static final int[] SLOTS_INPUT = new int[] { 0 };
    private static final int[] SLOTS_OUTPUT = new int[] { 2, 1 };
    private static final int[] SLOTS_FUEL = new int[] { 1 };

    public int cultivatePowerTime = 0;
    public int currentCultivateTime = 0;
    public int cultivateTime = 0;
    public boolean isActive;
    private ItemStack[] slots = new ItemStack[3];
    private String customName;

    public TileEntityCultivate() {
    }

    private static int getItemPowerTime(ItemStack stack) {
        if (stack != null) {
            Item output = stack.getItem();
            if (output == FAItemRegistry.INSTANCE.biofossil) {
                return 300;
            } else if (output == Items.PORKCHOP) {
                return 3000;
            } else if (output == Items.FISH) {
                return 3000;
            } else if (output == Items.BEEF) {
                return 4000;
            } else if (output == Items.CHICKEN) {
                return 1500;
            } else if (output == Items.EGG) {
                return 1000;
            } else if (output instanceof BirdEggItem) {
                return 1000;
            } else if (output instanceof ItemFood && ((ItemFood) output).isWolfsFavoriteMeat()) {
                return 1500;
            } else if (output == Items.SLIME_BALL) {
                return 800;
            } else if (output == Items.MILK_BUCKET) {
                return 6000;
            }
        }
        return 0;
    }

    public static boolean isItemFuel(ItemStack stack) {
        return getItemPowerTime(stack) > 0;
    }

    @Override
    public int getSizeInventory() {
        return this.slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.slots[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int amount) {
        return ItemStackHelper.getAndSplit(this.slots, index, amount);
    }

    @Nullable
    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.slots, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.slots[index] = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
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
        this.cultivatePowerTime = compound.getShort("BurnTime");
        this.cultivateTime = compound.getShort("CookTime");
        this.currentCultivateTime = getItemPowerTime(this.slots[1]);
        if (compound.hasKey("CustomName")) {
            this.customName = compound.getString("CustomName");
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        compound.setShort("BurnTime", (short) this.cultivatePowerTime);
        compound.setShort("CookTime", (short) this.cultivateTime);
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
        if (this.hasCustomName()) {
            compound.setString("CustomName", this.customName);
        }
        return compound;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public int getCultivateProgressScaled(int scale) {
        return this.cultivateTime * scale / 6000;
    }

    public int getBurnTimeRemainingScaled(int scale) {
        if (this.currentCultivateTime == 0) {
            this.currentCultivateTime = 6000;
        }

        return this.cultivatePowerTime * scale / this.currentCultivateTime;
    }

    public boolean isBurning() {
        return this.cultivatePowerTime > 0;
    }

    @Override
    public void update() {
        boolean cultivating = this.cultivateTime > 0;
        boolean dirty = false;
        int cookValue;
        if (Revival.RELEASE_TYPE.enableDebugging()) {
            cookValue = 300;
        } else {
            cookValue = 6000;
        }
        isActive = this.cultivateTime > 0;
        if (this.cultivatePowerTime > 0) {
            --this.cultivatePowerTime;
        }
        if (!this.worldObj.isRemote) {
            if (this.cultivatePowerTime == 0 && this.canCultivate()) {
                this.currentCultivateTime = this.cultivatePowerTime = getItemPowerTime(this.slots[1]);
                if (this.cultivatePowerTime > 0) {
                    dirty = true;
                    if (this.slots[1] != null) {
                        if (this.slots[1].getItem().hasContainerItem(null)) {
                            this.slots[1] = new ItemStack(this.slots[1].getItem().getContainerItem());
                        } else {
                            --this.slots[1].stackSize;
                        }

                        if (this.slots[1].stackSize == 0) {
                            this.slots[1] = null;
                        }
                    }
                }
            }
            if (this.isBurning() && this.canCultivate()) {
                ++this.cultivateTime;
                if (this.cultivateTime == cookValue) {
                    this.cultivateTime = 0;
                    this.cultivate();
                    dirty = true;
                }
            } else if (this.cultivateTime != 0 && !this.canCultivate()) {
                this.cultivateTime = 0;
            }
            if (cultivating != this.cultivateTime > 0) {
                dirty = true;
                BlockCultivate.updateState(this.cultivateTime > 0, this.worldObj, this.pos);
            }
        }
        if (dirty) {
            this.markDirty();
        }
        if (this.cultivateTime == 3001 && (new Random()).nextInt(100) < 20) {
            ((BlockCultivate) FABlockRegistry.INSTANCE.CULTIVATE_IDLE).onBlockRemovalLost(this.worldObj, this.pos, true);
        }
    }

    private boolean canCultivate() {
        if (this.slots[0] == null) {
            return false;
        } else {
            ItemStack output = this.getOutput(this.slots[0]);
            return output != null && (this.slots[2] == null || (this.slots[2].isItemEqual(output) && (this.slots[2].stackSize < this.getInventoryStackLimit() && this.slots[2].stackSize < this.slots[2].getMaxStackSize() || this.slots[2].stackSize < output.getMaxStackSize())));
        }
    }

    public void cultivate() {
        if (this.canCultivate()) {
            ItemStack stack = this.getOutput(this.slots[0]);
            if (this.slots[2] == null) {
                if (stack != null) {
                    this.slots[2] = stack.copy();
                }
            } else if (this.slots[2] == stack) {
                this.slots[2].stackSize += stack.stackSize;
            }
            if (this.slots[0].getItem().hasContainerItem(null)) {
                this.slots[0] = new ItemStack(this.slots[0].getItem().getContainerItem());
            } else {
                --this.slots[0].stackSize;
            }
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

    private ItemStack getOutput(ItemStack stack) {
        if (stack.getItem() == FAItemRegistry.INSTANCE.fossilSeed_fern) {
            return new ItemStack(FAItemRegistry.INSTANCE.fernSeed, 1);
        } else if (stack.getItem() == FAItemRegistry.INSTANCE.palaeSaplingFossil) {
            return new ItemStack(FABlockRegistry.INSTANCE.palmSap, 1);
        } else if (stack.getItem() == FAItemRegistry.INSTANCE.fossilSeed) {
            return new ItemStack(FAItemRegistry.INSTANCE.seed, 1, stack.getItemDamage());
        }
        if (PrehistoricEntityType.getEgg(stack.getItem()) != null) {
            return new ItemStack(PrehistoricEntityType.getEgg(stack.getItem()), 1);
        } else if (PrehistoricEntityType.getEmbryo(stack.getItem()) != null) {
            return new ItemStack(PrehistoricEntityType.getEmbryo(stack.getItem()), 1);
        } else if (PrehistoricEntityType.getBestBirdEgg(stack.getItem()) != null) {
            return new ItemStack(PrehistoricEntityType.getBestBirdEgg(stack.getItem()), 1);
        }
        return null;
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return index != 2 && (index != 1 || isItemFuel(stack));
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
    }

    public int getDNAType() {
        if (this.getStackInSlot(0) != null) {
            if (this.getStackInSlot(0).getItem() != null) {
                if (this.getStackInSlot(0).getItem() == PrehistoricEntityType.COELACANTH.dnaItem || this.getStackInSlot(0).getItem() == PrehistoricEntityType.STURGEON.dnaItem || this.getStackInSlot(0).getItem() == PrehistoricEntityType.ALLIGATOR_GAR.dnaItem) {
                    return 1;
                }
                if (this.getStackInSlot(0).getItem() == FAItemRegistry.INSTANCE.fossilSeed_fern || this.getStackInSlot(0).getItem() == FAItemRegistry.INSTANCE.palaeSaplingFossil || this.getStackInSlot(0).getItem() == FAItemRegistry.INSTANCE.fossilSeed) {
                    return 2;
                }
            }
        }
        return 0;
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return side == EnumFacing.DOWN ? SLOTS_OUTPUT : (side == EnumFacing.UP ? SLOTS_INPUT : SLOTS_FUEL);
    }

    @Override
    public boolean canInsertItem(int index, ItemStack stack, EnumFacing direction) {
        return this.isItemValidForSlot(index, stack);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        return direction != EnumFacing.DOWN || index != 1;
    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "tile." + LocalizationStrings.BLOCK_CULTIVATE_IDLE_NAME + ".name";
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && this.customName.length() > 0;
    }
}
