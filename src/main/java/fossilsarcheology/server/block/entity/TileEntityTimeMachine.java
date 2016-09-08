package fossilsarcheology.server.block.entity;

import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

public class TileEntityTimeMachine extends TileEntity implements IInventory, ISidedInventory, ITickable {
    private static Random field_40064_r = new Random();
    public final float RndRound = ((float) Math.PI * 2F);
    public final int MAX_CHARGED = 1000;
    final int MEMORY_WIDTH = 100;
    final int MEMORY_HEIGHT = 256;
    private final int RESTORE_TICK = 10;
    public int field_40068_a;
    public float field_40063_b;
    public float field_40061_d;
    public float field_40062_e;
    public float CurrectFacingAngle;
    public float SendingCurrentFacing;
    public float TargetFacingAngle;
    public boolean PlayerClosing = false;
    public ItemStack[] insideStack = new ItemStack[7];
    public boolean isRestoring = false;
    private String customName;
    private int chargeLevel = 0;
    private int[][][] memoryArray = (int[][][]) null;
    private int[][][] memoryMDArray = (int[][][]) null;
    private int restoringLayer = 60;
    private int restoreTick = 0;

    public boolean isClockInPlace() {
        if (this.getStackInSlot(6) != null) {
            if (this.getStackInSlot(6).getItem() != null) {
                if (this.getStackInSlot(6).getItem() == FAItemRegistry.INSTANCE.ancientClock) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void update() {
        this.UpdateClock();
        if (this.chargeLevel != 0) {
            if (!this.isClockInPlace()) {
                this.chargeLevel = 0;
            }
        }
        if (!this.isRestoring) {

            if (this.isClockInPlace()) {
                this.charge();
            }

            if (this.memoryArray == null || this.memoryMDArray == null) {
                this.startMemory();
            }

            // if (this.memoryArray != null && this.memoryMDArray != null &&
            // this.isCharged())
            // this.startWork();
        } else if (++this.restoreTick == 10) {
            this.restoreProgress();
            this.restoreTick = 0;
        }
    }

    private void restoreProgress() {
        Random var1 = this.worldObj.rand;
        boolean var2 = false;
        boolean var3 = false;

        for (int var4 = 0; var4 < 100; ++var4) {
            for (int var5 = 0; var5 < 100; ++var5) {
                World var10000 = this.worldObj;
                int var10001 = this.xCoord + var4;
                this.getClass();
                var10001 -= 100 / 2;
                int var10002 = this.restoringLayer;
                int var10003 = this.zCoord + var5;
                this.getClass();
                Block var6 = var10000.getBlock(var10001, var10002, var10003 - 100 / 2);

                if (!this.isNonPerserveBlock(var6)) {
                    int var10 = this.memoryArray[var4][this.restoringLayer][var5];
                    int var12 = this.memoryMDArray[var4][this.restoringLayer][var5];
                    var10000 = this.worldObj;
                    var10001 = this.xCoord + var4;
                    this.getClass();
                    var10001 -= 100 / 2;
                    var10002 = this.restoringLayer;
                    var10003 = this.zCoord + var5;
                    this.getClass();
                    var10000.setBlockMetadataWithNotify(var10001, var10002, var10003 - 100 / 2, var10, var12);

                    if (var10 != 0) {
                        var10000 = this.worldObj;
                        var10002 = this.xCoord + var4;
                        this.getClass();
                        double var8 = (double) (var10002 - 100 / 2) + (var1.nextDouble() - 0.5D);
                        double var7 = (double) this.restoringLayer + var1.nextDouble();
                        this.getClass();
                        var10000.spawnParticle("portal", var8, var7, (double) (var5 - 100 / 2) + (var1.nextDouble() - 0.5D), (var1.nextDouble() - 0.5D) * 2.0D, -var1.nextDouble(), (var1.nextDouble() - 0.5D) * 2.0D);
                    }
                }
            }
        }

        this.worldObj.playSoundEffect((double) this.xCoord, (double) this.restoringLayer, (double) this.zCoord, "mob.endermen.portal", 1.0F, 1.0F);
        this.getClass();
        float var9 = (float) this.restoringLayer;
        this.getClass();
        var9 /= 256.0F;
        this.getClass();
        this.chargeLevel = 1000 - (int) (var9 * 1000.0F);
        int var11 = ++this.restoringLayer;
        this.getClass();

        if (var11 >= 256) {
            this.isRestoring = false;
            this.restoringLayer = 0;
            this.chargeLevel = 0;
        }
    }

    public void UpdateClock() {
        this.SendingCurrentFacing = this.CurrectFacingAngle;
        EntityPlayer var1 = this.worldObj.getClosestPlayer((double) ((float) this.xCoord + 0.5F), (double) ((float) this.yCoord + 0.5F), (double) ((float) this.zCoord + 0.5F), 3.0D);

        if (var1 != null) {
            this.PlayerClosing = true;
            double var2 = var1.posX - (double) ((float) this.xCoord + 0.5F);
            double var4 = var1.posZ - (double) ((float) this.zCoord + 0.5F);
            this.TargetFacingAngle = (float) Math.atan2(var4, var2) + ((float) Math.PI / 2F);
        } else {
            this.PlayerClosing = false;
            this.TargetFacingAngle += 0.02F;
        }

        while (this.CurrectFacingAngle >= (float) Math.PI) {
            this.CurrectFacingAngle -= ((float) Math.PI * 2F);
        }

        while (this.CurrectFacingAngle < -(float) Math.PI) {
            this.CurrectFacingAngle += ((float) Math.PI * 2F);
        }

        while (this.TargetFacingAngle >= (float) Math.PI) {
            this.TargetFacingAngle -= ((float) Math.PI * 2F);
        }

        while (this.TargetFacingAngle < -(float) Math.PI) {
            this.TargetFacingAngle += ((float) Math.PI * 2F);
        }

        float var6;

        for (var6 = this.TargetFacingAngle - this.CurrectFacingAngle; var6 >= (float) Math.PI; var6 -= ((float) Math.PI * 2F)) {
        }

        while (var6 < -(float) Math.PI) {
            var6 += ((float) Math.PI * 2F);
        }

        this.CurrectFacingAngle += var6 * 0.4F;
        ++this.field_40068_a;
        float var3 = (this.field_40061_d - this.field_40063_b) * 0.4F;
        float var7 = 0.2F;

        if (var3 < -var7) {
            var3 = -var7;
        }

        if (var3 > var7) {
            var3 = var7;
        }

        this.field_40062_e += (var3 - this.field_40062_e) * 0.9F;
        this.field_40063_b += this.field_40062_e;
    }

    private boolean NotAllowed(Item var1) {
        return var1 == Item.getItemFromBlock(Blocks.diamond_block) || var1 == Item.getItemFromBlock(Blocks.diamond_ore);
    }

    public int getSizeInventorySide(ForgeDirection var1) {
        return 1;
    }

    public int getStartInventorySide(ForgeDirection var1) {
        return var1 == ForgeDirection.DOWN ? 1 : (var1 == ForgeDirection.UP ? 0 : 2);
    }

    /**
     * When some containers are closed they call this on each slot, then drop
     * whatever it returns as an EntityItem - like when you close a workbench
     * GUI.
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int var1) {
        if (this.insideStack[var1] != null) {
            ItemStack var2 = this.insideStack[var1];
            this.insideStack[var1] = null;
            return var2;
        } else {
            return null;
        }
    }

    /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory() {
        return this.insideStack.length;
    }

    /**
     * Returns the stack in slot i
     */
    @Override
    public ItemStack getStackInSlot(int var1) {
        return this.insideStack[var1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number
     * (second arg) of items and returns them in a new stack.
     */
    @Override
    public ItemStack decrStackSize(int var1, int var2) {
        if (this.insideStack[var1] != null) {
            ItemStack var3;

            if (this.insideStack[var1].stackSize <= var2) {
                var3 = this.insideStack[var1];
                this.insideStack[var1] = null;
                return var3;
            } else {
                var3 = this.insideStack[var1].splitStack(var2);

                if (this.insideStack[var1].stackSize == 0) {
                    this.insideStack[var1] = null;
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
        this.insideStack[var1] = var2;

        if (var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
            var2.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be
     * 64, possibly will be extended. *Isn't this more of a set than a get?*
     */
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes
     * with Container
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer var1) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && var1.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    public void openChest() {
    }

    public void closeChest() {
    }

    private void charge() {
        if (!this.isCharged()) {
            ++this.chargeLevel;
        }
    }

    public int getChargeLevel() {
        return this.chargeLevel;
    }

    public boolean isCharged() {
        int var10000 = this.chargeLevel;
        this.getClass();
        return var10000 == 1000;
    }

    public void startWork() {
        if (this.memoryArray != null && this.memoryMDArray != null) {
            if (this.isCharged()) {
                this.isRestoring = true;
            }
        }
    }

    public void startMemory() {
        this.memoryArray = new int[100][256][100];
        this.memoryMDArray = new int[100][256][100];

        for (int var1 = 0; var1 < 100; ++var1) {
            for (int var2 = 0; var2 < 256; ++var2) {
                for (int var3 = 0; var3 < 100; ++var3) {
                    Block var4 = this.worldObj.getBlock(this.xCoord + var1 - 50, var2, this.zCoord + var3 - 50);

                    if (this.isNonPerserveBlock(var4)) {
                        var4 = Blocks.air;
                    }

                    if (var4 != Blocks.air) {
                        this.memoryMDArray[var1][var2][var3] = this.worldObj.getBlockMetadata(this.xCoord + var1 - 50, var2, this.zCoord + var3 - 50);
                    } else {
                        this.memoryMDArray[var1][var2][var3] = 0;
                    }

                    if (var4 == Blocks.dirt) {
                        var4 = FABlockRegistry.INSTANCE.palaePlanks;
                    }

                    // this.memoryArray[var1][var2][var3] = var4.getBlock;
                }
            }
        }
    }

    private boolean isNonPerserveBlock(Block block) {
        return block != null && (block.hasTileEntity(0) || block == Blocks.diamond_block || block == Blocks.diamond_ore);
    }

    @Override
    public void readFromNBT(NBTTagCompound var1) {
        super.readFromNBT(var1);
        NBTTagList var2 = var1.getTagList("Items", 10);
        this.insideStack = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3) {
            NBTTagCompound var4 = var2.getCompoundTagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.insideStack.length) {
                this.insideStack[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.chargeLevel = var1.getShort("chargeLevel");

        if (var1.hasKey("CustomName")) {
            this.customName = var1.getString("CustomName");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound var1) {
        super.writeToNBT(var1);
        var1.setShort("chargeLevel", (short) this.chargeLevel);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.insideStack.length; ++var3) {
            if (this.insideStack[var3] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte) var3);
                this.insideStack[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        var1.setTag("Items", var2);

        if (this.isInvNameLocalized()) {
            var1.setString("CustomName", this.customName);
        }
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        return null;
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j) {
        return false;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        return false;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }

    public String getInvName() {
        return this.isInvNameLocalized() ? this.customName : "tile." + LocalizationStrings.BLOCK_TIMEMACHINE_NAME + ".name";
    }

    @Override
    public String getInventoryName() {
        return this.isInvNameLocalized() ? this.customName : "tile." + LocalizationStrings.BLOCK_TIMEMACHINE_NAME + ".name";
    }

    /**
     * If this returns false, the inventory name will be used as an unlocalized
     * name, and translated into the player's language. Otherwise it will be
     * used directly.
     */
    public boolean isInvNameLocalized() {
        return this.customName != null && this.customName.length() > 0;
    }

}
