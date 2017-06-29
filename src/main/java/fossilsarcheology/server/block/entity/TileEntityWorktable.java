package fossilsarcheology.server.block.entity;

import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.block.WorktableBlock;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
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

public class TileEntityWorktable extends TileEntity implements IInventory, ISidedInventory, ITickable {
    private static final int[] slots_top = new int[]{}; // input
    private static final int[] slots_bottom = new int[]{}; // output
    private static final int[] slots_sides = new int[]{};// fuel
    public int furnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int furnaceCookTime = 0;
    private ItemStack[] worktableItemStacks = new ItemStack[3];
    private String customName;

    @Override
    public int getSizeInventory() {
        return this.worktableItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int var1) {
        return this.worktableItemStacks[var1];
    }

    @Nullable
    @Override
    public ItemStack decrStackSize(int index, int count) {
        return null;
    }

    @Override
    public void readFromNBT(NBTTagCompound var1) {
        super.readFromNBT(var1);
        NBTTagList var2 = var1.getTagList("Items", 10);
        this.worktableItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3) {
            NBTTagCompound var4 = var2.getCompoundTagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.worktableItemStacks.length) {
                this.worktableItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.furnaceBurnTime = var1.getShort("BurnTime");
        this.furnaceCookTime = var1.getShort("CookTime");
        this.currentItemBurnTime = this.getItemBurnTime(this.worktableItemStacks[1]);

        if (var1.hasKey("CustomName")) {
            this.customName = var1.getString("CustomName");
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return false;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return false;
    }

    @Override
    public int getField(int id) {
        switch (id) {
            case 0:
                return this.furnaceCookTime;
            case 1:
                return this.furnaceBurnTime;
            case 2:
                return this.currentItemBurnTime;
            default:
                return 0;
        }
    }

    @Override
    public void setField(int id, int value) {
        switch (id) {
            case 0:
                this.furnaceCookTime = value;
                break;
            case 1:
                this.furnaceBurnTime = value;
                break;
            case 2:
                this.currentItemBurnTime = value;
                break;
        }
    }
    @Override
    public int getFieldCount() {
        return 3;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.worktableItemStacks.length; i++) {
            this.worktableItemStacks[0] = null;
        }
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

    private int timeToSmelt() {
        if (this.worktableItemStacks[0] == null) {
            return 3000;
        }

        if (this.worktableItemStacks[0].getItem() == FAItemRegistry.BROKEN_HELMET) {
            return 3000;
        }

        if (this.worktableItemStacks[0].getItem() == FAItemRegistry.BROKEN_SWORD) {
            return 3000;
        }

        return 300;
    }

    @Override
    public void update() {
        boolean var1 = this.furnaceBurnTime > 0;
        boolean var2 = false;

        if (this.furnaceBurnTime > 0) {
            --this.furnaceBurnTime;
        }

        if (!this.world.isRemote) {
            if (this.furnaceBurnTime == 0 && this.canSmelt()) {
                this.currentItemBurnTime = this.furnaceBurnTime = this.getItemBurnTime(this.worktableItemStacks[1]);

                if (this.furnaceBurnTime > 0) {
                    var2 = true;

                    if (this.worktableItemStacks[1] != null) {
                        if (this.worktableItemStacks[1].getItem().hasContainerItem(null)) {
                            this.worktableItemStacks[1] = new ItemStack(this.worktableItemStacks[1].getItem().getContainerItem());
                        } else {
                            --this.worktableItemStacks[1].stackSize;
                        }

                        if (this.worktableItemStacks[1].stackSize == 0) {
                            this.worktableItemStacks[1] = null;
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
                WorktableBlock.setState(this.furnaceBurnTime > 0, this.world, pos);
            }
        }

        if (var2) {
            this.markDirty();
        }
    }


    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }

    private ItemStack checkSmelt(ItemStack itemstack) {
        ItemStack output = null;

        if (itemstack.getItem() == FAItemRegistry.BROKEN_SWORD) {
            return new ItemStack(FAItemRegistry.ANCIENT_SWORD);
        }

        if (itemstack.getItem() == FAItemRegistry.BROKEN_HELMET) {
            return new ItemStack(FAItemRegistry.ANCIENT_HELMET);
        }

        if (itemstack.getItem() == FAItemRegistry.ANCIENT_SWORD) {
            output = new ItemStack(FAItemRegistry.ANCIENT_SWORD);
        }

        if (itemstack.getItem() == FAItemRegistry.ANCIENT_HELMET) {
            output = new ItemStack(FAItemRegistry.ANCIENT_HELMET);
        }

        if (itemstack.getItem() == FAItemRegistry.SCARAB_AXE) {
            output = new ItemStack(FAItemRegistry.SCARAB_AXE);
        }

        if (itemstack.getItem() == FAItemRegistry.SCARAB_PICKAXE) {
            output = new ItemStack(FAItemRegistry.SCARAB_PICKAXE);
        }

        if (itemstack.getItem() == FAItemRegistry.SCARAB_SWORD) {
            output = new ItemStack(FAItemRegistry.SCARAB_SWORD);
        }

        if (itemstack.getItem() == FAItemRegistry.SCARAB_HOE) {
            output = new ItemStack(FAItemRegistry.SCARAB_HOE);
        }

        if (itemstack.getItem() == FAItemRegistry.SCARAB_SHOVEL) {
            output = new ItemStack(FAItemRegistry.SCARAB_SHOVEL);
        }

        if (output != null) {
            if (itemstack.getItemDamage() / itemstack.getMaxDamage() >= 0.1F) {
                output.setItemDamage(itemstack.getItemDamage() - (int) (0.1 * itemstack.getMaxDamage()));
            } else {
                output.setItemDamage(0);
            }

            return output;
        }

        if (itemstack.getItem() == FAItemRegistry.WOODEN_JAVELIN) {
            output = new ItemStack(FAItemRegistry.WOODEN_JAVELIN, 1);
        }

        if (itemstack.getItem() == FAItemRegistry.STONE_JAVELIN) {
            output = new ItemStack(FAItemRegistry.STONE_JAVELIN, 1);
        }

        if (itemstack.getItem() == FAItemRegistry.IRON_JAVELIN) {
            output = new ItemStack(FAItemRegistry.IRON_JAVELIN, 1);
        }

        if (itemstack.getItem() == FAItemRegistry.GOLD_JAVELIN) {
            output = new ItemStack(FAItemRegistry.GOLD_JAVELIN, 1);
        }

        if (itemstack.getItem() == FAItemRegistry.DIAMOND_JAVELIN) {
            output = new ItemStack(FAItemRegistry.DIAMOND_JAVELIN, 1);
        }

        if (output != null) {
            if (itemstack.getItemDamage() > 5) {
                output.setItemDamage(itemstack.getItemDamage() - 5);
            } else {
                output.setItemDamage(0);
            }

            return output;
        }

        if (itemstack.getItem() == FAItemRegistry.ANCIENT_JAVELIN) {
            output = new ItemStack(FAItemRegistry.ANCIENT_JAVELIN, 1);

            if (itemstack.getItemDamage() > 3) {
                output.setItemDamage(itemstack.getItemDamage() - 3);
            } else {
                output.setItemDamage(0);
            }

            return output;
        }

        if (itemstack.getItem() == new ItemStack(FABlockRegistry.KYLIX_VASE).getItem() && itemstack.getItemDamage() == 0) {
            output = new ItemStack(FABlockRegistry.KYLIX_VASE, itemstack.stackSize, 1);
            return output;
        }

        if (itemstack.getItem() == new ItemStack(FABlockRegistry.AMPHORA_VASE).getItem() && itemstack.getItemDamage() == 0) {
            output = new ItemStack(FABlockRegistry.AMPHORA_VASE, itemstack.stackSize, 1);
            return output;
        }

        if (itemstack.getItem() == new ItemStack(FABlockRegistry.VOLUTE_VASE).getItem() && itemstack.getItemDamage() == 0) {
            output = new ItemStack(FABlockRegistry.VOLUTE_VASE, itemstack.stackSize, 1);
            return output;
        }

        return null;
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack var1 = this.checkSmelt(this.worktableItemStacks[0]);

            if (this.worktableItemStacks[2] == null) {
                if (var1 != null) {
                    this.worktableItemStacks[2] = var1.copy();
                }
            } else if (this.worktableItemStacks[2] == var1) {
                this.worktableItemStacks[2].stackSize += var1.stackSize;
            }

            if (this.worktableItemStacks[0].getItem().hasContainerItem(null)) {
                this.worktableItemStacks[0] = new ItemStack(this.worktableItemStacks[0].getItem().getContainerItem());
            } else {
                --this.worktableItemStacks[0].stackSize;
            }

            if (this.worktableItemStacks[0].stackSize <= 0) {
                this.worktableItemStacks[0] = null;
            }
        }
    }

    private boolean canSmelt() {
        if (this.worktableItemStacks[0] == null) {
            return false;
        } else {
            // ItemStack var1 =
            // this.CheckSmelt(this.worktableItemStacks[0].getItem());
            ItemStack var1 = this.checkSmelt(this.worktableItemStacks[0]);
            return var1 != null && (this.worktableItemStacks[2] == null || (this.worktableItemStacks[2].isItemEqual(var1) && (this.worktableItemStacks[2].stackSize < this.getInventoryStackLimit() && this.worktableItemStacks[2].stackSize < this.worktableItemStacks[2].getMaxStackSize() || this.worktableItemStacks[2].stackSize < var1.getMaxStackSize())));
        }
    }


    private int getItemBurnTime(ItemStack itemstack) {
        if (itemstack == null) {
            return 0;
        } else {
            Item var2 = itemstack.getItem();
            return var2 == FAItemRegistry.RELIC_SCRAP ? 300 : 0;
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setShort("BurnTime", (short) this.furnaceBurnTime);
        nbt.setShort("CookTime", (short) this.furnaceCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.worktableItemStacks.length; ++var3) {
            if (this.worktableItemStacks[var3] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte) var3);
                this.worktableItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        if (this.customName != null) {
            nbt.setString("CustomName", this.customName);
        }

        nbt.setTag("Items", var2);
        return nbt;
    }

    @Nullable
    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.worktableItemStacks, index);
    }

    @Override
    public void setInventorySlotContents(int index, @Nullable ItemStack stack) {
        this.worktableItemStacks[index] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return side == EnumFacing.DOWN ? slots_bottom : (side == EnumFacing.UP ? slots_top : slots_sides);
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        return direction != EnumFacing.UP || index != 1 || stack.getItem() == Items.BUCKET;
    }

    @Override
    public String getName() {
        return this.customName != null ? this.customName : "tile.worktable.name";
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && this.customName.length() > 0;
    }

}
