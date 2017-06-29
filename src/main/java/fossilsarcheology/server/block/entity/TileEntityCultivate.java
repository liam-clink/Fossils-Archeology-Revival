package fossilsarcheology.server.block.entity;

import fossilsarcheology.Revival;
import fossilsarcheology.server.block.CultivateBlock;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.entity.prehistoric.PrehistoricEntityType;
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
    private static final int[] slots_top = new int[] { 0 }; // input
    private static final int[] slots_bottom = new int[] { 2, 1 }; // output
    private static final int[] slots_sides = new int[] { 1 }; // fuel
    public int furnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int furnaceCookTime = 0;
    public boolean isActive;
    private ItemStack[] cultivateItemStacks = new ItemStack[3];
    private String customName;

    private static int getItemBurnTime(ItemStack itemstack) {
        if (itemstack != null) {
            Item output = itemstack.getItem();

            if (output == FAItemRegistry.BIOFOSSIL) {
                return 300;
            }

            if (output == Items.PORKCHOP) {
                return 3000;
            }

            if (output == Items.FISH) {
                return 3000;
            }

            if (output == Items.BEEF) {
                return 4000;
            }

            if (output == Items.CHICKEN) {
                return 1500;
            }

            if (output == Items.EGG) {
                return 1000;
            }

            if (output instanceof BirdEggItem) {
                return 1000;
            }

            if (output instanceof ItemFood && ((ItemFood) output).isWolfsFavoriteMeat()) {
                return 1500;
            }

            if (output == Items.SLIME_BALL) {
                return 800;
            }

            if (output == Items.MILK_BUCKET) {
                return 6000;
            }
        }

        return 0;
    }

    public static boolean isItemFuel(ItemStack par0ItemStack) {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    @Override
    public int getSizeInventory() {
        return this.cultivateItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return this.cultivateItemStacks[i];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        if (this.cultivateItemStacks[slot] != null) {
            ItemStack var3;

            if (this.cultivateItemStacks[slot].stackSize <= amount) {
                var3 = this.cultivateItemStacks[slot];
                this.cultivateItemStacks[slot] = null;
                return var3;
            } else {
                var3 = this.cultivateItemStacks[slot].splitStack(amount);

                if (this.cultivateItemStacks[slot].stackSize == 0) {
                    this.cultivateItemStacks[slot] = null;
                }

                return var3;
            }
        } else {
            return null;
        }
    }

    @Nullable
    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.cultivateItemStacks, index);
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        this.cultivateItemStacks[slot] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList var2 = nbt.getTagList("Items", 10);
        this.cultivateItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3) {
            NBTTagCompound var4 = var2.getCompoundTagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.cultivateItemStacks.length) {
                this.cultivateItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.furnaceBurnTime = nbt.getShort("BurnTime");
        this.furnaceCookTime = nbt.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.cultivateItemStacks[1]);

        if (nbt.hasKey("CustomName")) {
            this.customName = nbt.getString("CustomName");
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setShort("BurnTime", (short) this.furnaceBurnTime);
        nbt.setShort("CookTime", (short) this.furnaceCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.cultivateItemStacks.length; ++var3) {
            if (this.cultivateItemStacks[var3] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte) var3);
                this.cultivateItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        nbt.setTag("Items", var2);

        if (customName != null) {
            nbt.setString("CustomName", this.customName);
        }
        return nbt;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public int getCultivateProgressScaled(int prog) {
        return this.furnaceCookTime * prog / 6000;
    }

    public int getBurnTimeRemainingScaled(int prog) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = 6000;
        }

        return this.furnaceBurnTime * prog / this.currentItemBurnTime;
    }

    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }

    @Override
    public void update() {
        boolean var1 = this.furnaceCookTime > 0;
        boolean var2 = false;
        int cookValue;

        if (Revival.RELEASE_TYPE.enableDebugging()) {
            cookValue = 300;
        } else {

            cookValue = 6000;
        }
        isActive = this.furnaceCookTime > 0;

        if (this.furnaceBurnTime > 0) {
            --this.furnaceBurnTime;
        }

        if (!this.world.isRemote) {
            if (this.furnaceBurnTime == 0 && this.canSmelt()) {
                this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.cultivateItemStacks[1]);

                if (this.furnaceBurnTime > 0) {
                    var2 = true;

                    if (this.cultivateItemStacks[1] != null) {
                        if (this.cultivateItemStacks[1].getItem().hasContainerItem(null)) {
                            this.cultivateItemStacks[1] = new ItemStack(this.cultivateItemStacks[1].getItem().getContainerItem());
                        } else {
                            --this.cultivateItemStacks[1].stackSize;
                        }

                        if (this.cultivateItemStacks[1].stackSize == 0) {
                            this.cultivateItemStacks[1] = null;
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt()) {
                ++this.furnaceCookTime;

                if (this.furnaceCookTime == cookValue) {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            } else if (this.furnaceCookTime != 0 && !this.canSmelt()) {
                this.furnaceCookTime = 0;
            }

            if (var1 != this.furnaceCookTime > 0) {
                var2 = true;
                CultivateBlock.setState(this.furnaceCookTime > 0, this.world, this.pos);

            }
        }

        if (var2) {
            this.markDirty();
        }
        if (this.furnaceCookTime == 3001 && (new Random()).nextInt(100) < 20) {
            ((CultivateBlock) FABlockRegistry.CULTIVATE_IDLE).onBlockRemovalLost(world, pos, true);
        }
    }

    private boolean canSmelt() {
        if (this.cultivateItemStacks[0] == null) {
            return false;
        } else {
            ItemStack var1 = this.checkSmelt(this.cultivateItemStacks[0]);
            return var1 != null && (this.cultivateItemStacks[2] == null || (this.cultivateItemStacks[2].isItemEqual(var1) && (this.cultivateItemStacks[2].stackSize < this.getInventoryStackLimit() && this.cultivateItemStacks[2].stackSize < this.cultivateItemStacks[2].getMaxStackSize() || this.cultivateItemStacks[2].stackSize < var1.getMaxStackSize())));
        }
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack var1 = this.checkSmelt(this.cultivateItemStacks[0]);

            if (this.cultivateItemStacks[2] == null) {
                if (var1 != null) {
                    this.cultivateItemStacks[2] = var1.copy();
                }
            } else if (this.cultivateItemStacks[2] == var1) {
                this.cultivateItemStacks[2].stackSize += var1.stackSize;
            }

            if (this.cultivateItemStacks[0].getItem().hasContainerItem(null)) {
                this.cultivateItemStacks[0] = new ItemStack(this.cultivateItemStacks[0].getItem().getContainerItem());
            } else {
                --this.cultivateItemStacks[0].stackSize;
            }

            if (this.cultivateItemStacks[0].stackSize <= 0) {
                this.cultivateItemStacks[0] = null;
            }
        }
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer var1) {
        return this.world.getTileEntity(this.pos) == this && var1.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    public void setCustomName(String name) {
        this.customName = name;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return slot != 2 && (slot != 1 || isItemFuel(stack));
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

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return side == EnumFacing.DOWN ? slots_bottom : (side == EnumFacing.UP ? slots_top : slots_sides);
    }

    @Override
    public boolean canInsertItem(int par1, ItemStack par2ItemStack, EnumFacing direction) {
        return this.isItemValidForSlot(par1, par2ItemStack);
    }

    @Override
    public boolean canExtractItem(int par1, ItemStack par2ItemStack, EnumFacing direction) {
        return direction != EnumFacing.UP || par1 != 1 || par2ItemStack.getItem() == Items.BUCKET;
    }

    @Override
    public String getName() {
        return this.customName != null ? this.customName : "tile.cultivate.name";
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && this.customName.length() > 0;
    }


    private ItemStack checkSmelt(ItemStack itemstack) {
        if (itemstack.getItem() == FAItemRegistry.FOSSIL_SEED_FERN) {
            return new ItemStack(FAItemRegistry.FERN_SEED, 1);
        }
        if (itemstack.getItem() == FAItemRegistry.PALAE_SAPLING_FOSSIL) {
            return new ItemStack(FABlockRegistry.PALM_SAPLING, 1);
        }
        if (itemstack.getItem() == FAItemRegistry.FOSSIL_SEED) {
            return new ItemStack(FAItemRegistry.SEED, 1, itemstack.getItemDamage());
        }

        if (PrehistoricEntityType.getEgg(itemstack.getItem()) != null) {
            return new ItemStack(PrehistoricEntityType.getEgg(itemstack.getItem()), 1);

        }

        if (PrehistoricEntityType.getEmbryo(itemstack.getItem()) != null) {
            return new ItemStack(PrehistoricEntityType.getEmbryo(itemstack.getItem()), 1);
        }
        if (PrehistoricEntityType.getBestBirdEgg(itemstack.getItem()) != null) {
            return new ItemStack(PrehistoricEntityType.getBestBirdEgg(itemstack.getItem()), 1);
        }

        return null;
    }


}
