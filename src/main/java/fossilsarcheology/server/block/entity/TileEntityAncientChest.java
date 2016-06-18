package fossilsarcheology.server.block.entity;

import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAncientChest extends TileEntity {
    public float lidAngle;
    /**
     * The angle of the lid last tick
     */
    public float prevLidAngle;
    public int numPlayersUsing;
    public int chestState = 0;
    public int chestLidCounter;
    public int chestLidCounter2;
    private ItemStack[] furnaceItemStacks = new ItemStack[1];
    private int ticksSinceSync;

    public ItemStack getStackInSlot(int p_70301_1_) {
        return this.furnaceItemStacks[p_70301_1_];
    }

    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        if (this.furnaceItemStacks[p_70298_1_] != null) {
            ItemStack itemstack;

            if (this.furnaceItemStacks[p_70298_1_].stackSize <= p_70298_2_) {
                itemstack = this.furnaceItemStacks[p_70298_1_];
                this.furnaceItemStacks[p_70298_1_] = null;
                return itemstack;
            } else {
                itemstack = this.furnaceItemStacks[p_70298_1_].splitStack(p_70298_2_);

                if (this.furnaceItemStacks[p_70298_1_].stackSize == 0) {
                    this.furnaceItemStacks[p_70298_1_] = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        if (this.furnaceItemStacks[p_70304_1_] != null) {
            ItemStack itemstack = this.furnaceItemStacks[p_70304_1_];
            this.furnaceItemStacks[p_70304_1_] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
        this.furnaceItemStacks[p_70299_1_] = p_70299_2_;

        if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit()) {
            p_70299_2_.stackSize = this.getInventoryStackLimit();
        }
    }

    public void setChestState(int state) {
        chestState = state;
    }

    @Override
    public void readFromNBT(NBTTagCompound p_145839_1_) {
        super.readFromNBT(p_145839_1_);
        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];
        this.setChestState(p_145839_1_.getInteger("chestState"));

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.furnaceItemStacks.length) {
                this.furnaceItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound p_145841_1_) {
        super.writeToNBT(p_145841_1_);
        NBTTagList nbttaglist = new NBTTagList();
        p_145841_1_.setInteger("chestState", chestState);
        for (int i = 0; i < this.furnaceItemStacks.length; ++i) {
            if (this.furnaceItemStacks[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                this.furnaceItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        p_145841_1_.setTag("Items", nbttaglist);
    }

    public int getSizeInventory() {
        return this.furnaceItemStacks.length;
    }

    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        ++this.ticksSinceSync;
        float f;
        if (this.chestState != 3) {
            if (chestLidCounter != 0 && chestLidCounter < 91) {
                chestLidCounter++;
            }
            if (chestLidCounter == 91) {
                this.setChestState(3);
                EntityItem item = new EntityItem(this.worldObj, this.xCoord + 0.5, this.yCoord + 1, this.zCoord + 0.5, new ItemStack(FAItemRegistry.INSTANCE.ancientClock));
                if (!worldObj.isRemote) {
                    this.worldObj.spawnEntityInWorld(item);
                    item.motionX = 0D;
                    item.motionZ = 0D;
                    item.motionY += 0.1D;
                }
                worldObj.playSoundEffect(this.xCoord, (double) this.yCoord + 0.5D, this.zCoord, "random.chestclosed", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }
        } else {
            if (chestLidCounter != 0 && chestLidCounter > 0) {
                chestLidCounter--;
            }
            if (chestLidCounter == 0) {
                this.setChestState(0);
            }
        }
        if (!this.worldObj.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + this.xCoord + this.yCoord + this.zCoord) % 200 == 0) {
            this.numPlayersUsing = 0;
            f = 5.0F;
        }

        this.prevLidAngle = this.lidAngle;
        f = 0.1F;
        double d2;

        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F) {
            double d1 = (double) this.xCoord + 0.5D;
            d2 = (double) this.zCoord + 0.5D;
            this.worldObj.playSoundEffect(d1, (double) this.yCoord + 0.5D, d2, "random.chestopen", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
        }

        if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F) {
            float f1 = this.lidAngle;

            if (this.numPlayersUsing > 0) {
                this.lidAngle += f;
            } else {
                this.lidAngle -= f;
            }

            if (this.lidAngle > 1.0F) {
                this.lidAngle = 1.0F;
            }

            float f2 = 0.5F;

            if (this.lidAngle < f2 && f1 >= f2) {
                d2 = (double) this.xCoord + 0.5D;
                double d0 = (double) this.zCoord + 0.5D;
                this.worldObj.playSoundEffect(d2, (double) this.yCoord + 0.5D, d0, "random.chestclosed", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }

            if (this.lidAngle < 0.0F) {
                this.lidAngle = 0.0F;
            }
        }
    }

    /**
     * Called when a client event is received with the event number and
     * argument, see World.sendClientEvent
     */
    @Override
    public boolean receiveClientEvent(int p_145842_1_, int p_145842_2_) {
        if (p_145842_1_ == 1) {
            this.numPlayersUsing = p_145842_2_;
            return true;
        } else {
            return super.receiveClientEvent(p_145842_1_, p_145842_2_);
        }
    }

    public void openInventory() {
        if (this.numPlayersUsing < 0) {
            this.numPlayersUsing = 0;
        }

        ++this.numPlayersUsing;
        this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, this.numPlayersUsing);
        this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType());
        this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType());
    }

    public void closeInventory() {
        /*
		 * if (this.getBlockType() instanceof BlockChest) {
		 * --this.numPlayersUsing; this.worldObj.addBlockEvent(this.xCoord,
		 * this.yCoord, this.zCoord, this.getBlockType(), 1,
		 * this.numPlayersUsing);
		 * this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord,
		 * this.zCoord, this.getBlockType());
		 * this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord -
		 * 1, this.zCoord, this.getBlockType()); }
		 */
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