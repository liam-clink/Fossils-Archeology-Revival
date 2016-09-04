package fossilsarcheology.server.block.entity;

import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;

public class TileEntityAncientChest extends TileEntity implements ITickable {
    public float lidAngle;
    public float prevLidAngle;
    public int numPlayersUsing;
    public int chestState = 0;
    public int chestLidCounter;
    public int chestLidCounter2;
    private ItemStack[] slots = new ItemStack[1];
    private int ticksSinceSync;

    public ItemStack getStackInSlot(int slot) {
        return this.slots[slot];
    }

    public ItemStack decrStackSize(int slot, int amount) {
        if (this.slots[slot] != null) {
            ItemStack stack;
            if (this.slots[slot].stackSize <= amount) {
                stack = this.slots[slot];
                this.slots[slot] = null;
                return stack;
            } else {
                stack = this.slots[slot].splitStack(amount);
                if (this.slots[slot].stackSize == 0) {
                    this.slots[slot] = null;
                }
                return stack;
            }
        } else {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int slot) {
        if (this.slots[slot] != null) {
            ItemStack stack = this.slots[slot];
            this.slots[slot] = null;
            return stack;
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int slot, ItemStack stack) {
        this.slots[slot] = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    public void setChestState(int state) {
        chestState = state;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList itemsList = compound.getTagList("Items", 10);
        this.slots = new ItemStack[this.getSizeInventory()];
        this.setChestState(compound.getInteger("chestState"));
        for (int i = 0; i < itemsList.tagCount(); ++i) {
            NBTTagCompound itemTag = itemsList.getCompoundTagAt(i);
            byte slot = itemTag.getByte("Slot");
            if (slot >= 0 && slot < this.slots.length) {
                this.slots[slot] = ItemStack.loadItemStackFromNBT(itemTag);
            }
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        NBTTagList itemList = new NBTTagList();
        compound.setInteger("chestState", chestState);
        for (int i = 0; i < this.slots.length; ++i) {
            if (this.slots[i] != null) {
                NBTTagCompound itemTag = new NBTTagCompound();
                itemTag.setByte("Slot", (byte) i);
                this.slots[i].writeToNBT(itemTag);
                itemList.appendTag(itemTag);
            }
        }
        compound.setTag("Items", itemList);
        return compound;
    }

    public int getSizeInventory() {
        return this.slots.length;
    }

    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public void update() {
        ++this.ticksSinceSync;
        float angleChange;
        if (this.chestState != 3) {
            if (chestLidCounter != 0 && chestLidCounter < 91) {
                chestLidCounter++;
            }
            if (chestLidCounter == 91) {
                this.setChestState(3);
                EntityItem item = new EntityItem(this.worldObj, this.pos.getX() + 0.5, this.pos.getY() + 1, this.pos.getZ() + 0.5, new ItemStack(FAItemRegistry.INSTANCE.ancientClock));
                if (!worldObj.isRemote) {
                    this.worldObj.spawnEntityInWorld(item);
                    item.motionX = 0D;
                    item.motionZ = 0D;
                    item.motionY += 0.1D;
                }
                worldObj.playSound(null, this.pos, SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }
        } else {
            if (chestLidCounter != 0 && chestLidCounter > 0) {
                chestLidCounter--;
            }
            if (chestLidCounter == 0) {
                this.setChestState(0);
            }
        }
        if (!this.worldObj.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + this.pos.toLong()) % 200 == 0) {
            this.numPlayersUsing = 0;
            angleChange = 5.0F;
        }

        this.prevLidAngle = this.lidAngle;
        angleChange = 0.1F;

        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F) {
            this.worldObj.playSound(null, this.pos, SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
        }

        if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F) {
            float prevAngle = this.lidAngle;

            if (this.numPlayersUsing > 0) {
                this.lidAngle += angleChange;
            } else {
                this.lidAngle -= angleChange;
            }

            if (this.lidAngle > 1.0F) {
                this.lidAngle = 1.0F;
            }

            float f2 = 0.5F;

            if (this.lidAngle < f2 && prevAngle >= f2) {
                d2 = (double) this.xCoord + 0.5D;
                double d0 = (double) this.zCoord + 0.5D;
                this.worldObj.playSoundEffect(d2, (double) this.yCoord + 0.5D, d0, "random.chestclosed", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }

            if (this.lidAngle < 0.0F) {
                this.lidAngle = 0.0F;
            }
        }
    }

    @Override
    public boolean receiveClientEvent(int key, int value) {
        if (key == 1) {
            this.numPlayersUsing = value;
            return true;
        } else {
            return super.receiveClientEvent(key, value);
        }
    }

    public void openInventory(EntityPlayer player) {
        if (this.numPlayersUsing < 0) {
            this.numPlayersUsing = 0;
        }

        ++this.numPlayersUsing;
        this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, this.numPlayersUsing);
        this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType());
        this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType());
    }

    public void closeInventory() {
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring
     * stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return true;
    }

    /**
     * invalidates a tile entity
     */
    @Override
    public void invalidate() {
        super.invalidate();
        this.updateContainingBlockInfo();
    }
}