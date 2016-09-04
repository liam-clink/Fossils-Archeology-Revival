package fossilsarcheology.server.block.entity;

import fossilsarcheology.Revival;
import fossilsarcheology.server.block.BlockAnalyzer;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.enums.EnumDinoBones;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import fossilsarcheology.server.handler.FossilAchievementHandler;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.DinosaurBoneItem;
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
import java.util.Random;

public class TileEntityAnalyzer extends TileEntity implements IInventory, ISidedInventory, ITickable {
    private static final int[] SLOTS_TOP = new int[] {}; // input
    private static final int[] SLOTS_BOTTOM = new int[] { 10, 11, 12 }; // output
    private static final int[] SLOTS_SIDES = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 };// fuel
    public int analyzerBurnTime = 0;
    public int currentItemBurnTime = 100;
    public int analyzerCookTime = 0;
    private String customName;
    private ItemStack[] slots;
    private int rawIndex = -1;
    private int spaceIndex = -1;

    public TileEntityAnalyzer() {
        slots = new ItemStack[13];
    }

    private static int getItemBurnTime(ItemStack var1) {
        return 100;
    }

    public static boolean isItemFuel(ItemStack par0ItemStack) {
        return getItemBurnTime(par0ItemStack) > 0;
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

    public void setGuiDisplayName(String par1Str) {
        this.customName = par1Str;
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
        this.analyzerBurnTime = compound.getShort("BurnTime");
        this.analyzerCookTime = compound.getShort("CookTime");
        this.currentItemBurnTime = 100;
        if (compound.hasKey("CustomName")) {
            this.customName = compound.getString("CustomName");
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        compound.setShort("BurnTime", (short) this.analyzerBurnTime);
        compound.setShort("CookTime", (short) this.analyzerCookTime);
        NBTTagList itemList = new NBTTagList();
        for (int i = 0; i < this.slots.length; ++i) {
            if (this.slots[i] != null) {
                NBTTagCompound itemTag = new NBTTagCompound();
                itemTag.setByte("Slot", (byte) i);
                this.slots[i].writeToNBT(itemTag);
                itemList.appendTag(itemTag);
            }
        }
        if (this.hasCustomName()) {
            compound.setString("CustomName", this.customName);
        }
        compound.setTag("Items", itemList);
        return compound;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public int getAnalyzeProgressScaled(int scale) {
        return this.analyzerCookTime * scale / 200;
    }

    public boolean isAnalyzing() {
        return this.analyzerBurnTime > 0;
    }

    @Override
    public void update() {
        for (EntityPlayer player : this.worldObj.playerEntities) {
            if (this.getDistanceSq(player.posX, player.posY, player.posZ) < 40) {
                for (int slot = 12; slot > 8; --slot) {
                    ItemStack stack = this.slots[slot];
                    if (stack != null) {
                        if (stack.getItem() == FAItemRegistry.INSTANCE.stoneboard) {
                            player.addStat(FossilAchievementHandler.tablet, 1);
                        }
                    }
                }
            }
        }
        boolean burning = this.analyzerBurnTime > 0;
        boolean dirty = false;
        if (this.analyzerBurnTime > 0) {
            --this.analyzerBurnTime;
        }
        if (!this.worldObj.isRemote) {
            if (this.analyzerBurnTime == 0 && this.canAnalyze()) {
                this.currentItemBurnTime = this.analyzerBurnTime = 100;
                if (this.analyzerBurnTime > 0) {
                    dirty = true;
                }
            }
            if (this.isAnalyzing() && this.canAnalyze()) {
                ++this.analyzerCookTime;
                if (this.analyzerCookTime == 200) {
                    this.analyzerCookTime = 0;
                    this.analyzeItem();
                    dirty = true;
                }
            } else {
                this.analyzerCookTime = 0;
            }
            if (burning != this.analyzerBurnTime > 0) {
                dirty = true;
                BlockAnalyzer.updateState(this.analyzerBurnTime > 0, this.worldObj, this.pos);
            }
        }
        if (dirty) {
            this.markDirty();
        }
    }

    private boolean canAnalyze() {
        this.spaceIndex = -1;
        this.rawIndex = -1;
        for (int slot = 0; slot < 9; ++slot) {
            if (this.slots[slot] != null) {
                Item item = this.slots[slot].getItem();
                if (PrehistoricEntityType.isFoodItem(this.slots[slot].getItem()) || (item instanceof DinosaurBoneItem) || (item == FAItemRegistry.INSTANCE.biofossil) || (item == FAItemRegistry.INSTANCE.tarfossil) || (item == FAItemRegistry.INSTANCE.tardrop) || (item == FAItemRegistry.INSTANCE.failuresaurusFlesh) || (item == FAItemRegistry.INSTANCE.relic) || (item == Items.PORKCHOP) || (item == Items.BEEF) || (item == Items.EGG) || (item == Items.CHICKEN) || (item == Item.getItemFromBlock(Blocks.WOOL)) || (item == FAItemRegistry.INSTANCE.icedMeat) || (item == Items.LEATHER) || (item == FAItemRegistry.INSTANCE.brokenSapling)) {
                    this.rawIndex = slot;
                    break;
                }
            }
        }
        if (this.rawIndex == -1) {
            return false;
        } else {
            for (int slot = 12; slot > 8; --slot) {
                if (this.slots[slot] == null) {
                    this.spaceIndex = slot;
                    break;
                }
            }
            return this.spaceIndex != -1 && this.rawIndex != -1;
        }
    }

    public void analyzeItem() {
        if (this.canAnalyze()) {
            ItemStack output = null;
            int rand = this.worldObj.rand.nextInt(100);
            Item rawItem = this.slots[this.rawIndex].getItem();

            if (rawItem instanceof DinosaurBoneItem) {
                if (!Revival.RELEASE_TYPE.enableDebugging()) {
                    if (rand > -1 && rand <= 30) {
                        output = new ItemStack(Items.DYE, 3, 15);
                    }
                    if (rand > 30 && rand <= 65) {
                        output = new ItemStack(Items.BONE, 3);
                    }
                    if (rand > 65) {
                        output = new ItemStack(EnumDinoBones.from(EnumDinoBones.values()[this.slots[this.rawIndex].getItemDamage()]).dnaItem, 1);
                    }
                } else {
                    output = new ItemStack(PrehistoricEntityType.getRandomMezoic().dnaItem, 1);
                }
            } else if (rawItem == FAItemRegistry.INSTANCE.biofossil) {
                if (!Revival.RELEASE_TYPE.enableDebugging()) {
                    if (rand > -1 && rand <= 50) {
                        output = new ItemStack(Items.DYE, 3, 15);
                    }
                    if (rand > 50 && rand <= 85) {
                        output = new ItemStack(Blocks.SAND, 1 + new Random().nextInt(2));
                    }
                    if (rand > 85) {
                        output = new ItemStack(PrehistoricEntityType.getRandomMezoic().dnaItem, 1);
                    }
                } else {
                    output = new ItemStack(PrehistoricEntityType.getRandomMezoic().dnaItem, 1);
                }
            } else if (rawItem == FAItemRegistry.INSTANCE.tarfossil) {
                if (rand > -1 && rand <= 50) {
                    output = new ItemStack(Items.DYE, 3, 15);
                }
                if (rand > 50 && rand <= 80) {
                    output = new ItemStack(FABlockRegistry.INSTANCE.volcanicRock, 1);
                }
                if (rand > 80 && rand <= 75) {
                    output = new ItemStack(Blocks.OBSIDIAN, 1);
                }
                if (rand > 75) {
                    output = new ItemStack(PrehistoricEntityType.getRandomCenozoic().dnaItem, 1);
                }
            } else if (rawItem == FAItemRegistry.INSTANCE.tardrop) {
                if (rand >= 0 && rand <= 40) {
                    output = new ItemStack(Items.COAL, new Random().nextInt(2) + 1, new Random().nextInt(1));
                }
                if (rand > 40 && rand <= 85) {
                    output = new ItemStack(FAItemRegistry.INSTANCE.tarfossil, 1);
                }
                if (rand > 85) {
                    output = new ItemStack(FABlockRegistry.INSTANCE.volcanicRock, 1);
                }
            } else if (rawItem == FAItemRegistry.INSTANCE.brokenSapling) {
                if (rand > 0) {
                    output = new ItemStack(Blocks.SAND, 1 + new Random().nextInt(1), 0);
                }
                if (rand > 35 && rand <= 65) {
                    output = new ItemStack(Items.COAL, 1, 0);
                }
                if (rand > 65 && rand <= 75) {
                    output = new ItemStack(FAItemRegistry.INSTANCE.palaeSaplingFossil, 1, 0);
                }
                if (rand > 75 && rand <= 85) {
                    output = new ItemStack(Items.DYE, 1, 2);
                }
                if (rand > 85) {
                    output = new ItemStack(FAItemRegistry.INSTANCE.fossilSeed, 1, new Random().nextInt(14));
                }
            } else if (rawItem == Item.getItemFromBlock(Blocks.WOOL)) {
                if ((new Random()).nextInt(50) <= 30) {
                    output = new ItemStack(Items.STRING, 4);
                } else {
                    output = new ItemStack(PrehistoricEntityType.SHEEP.dnaItem, 1);
                }
            } else if (PrehistoricEntityType.getDNA(rawItem) != null) {
                output = new ItemStack(PrehistoricEntityType.getDNA(rawItem), 1);
            } else if (rawItem == Items.PORKCHOP) {
                output = new ItemStack(PrehistoricEntityType.PIG.dnaItem, 2);
            } else if (rawItem == Items.BEEF) {
                output = new ItemStack(PrehistoricEntityType.COW.dnaItem, 2);
            } else if (rawItem == FAItemRegistry.INSTANCE.failuresaurusFlesh) {
                int randChoice = this.worldObj.rand.nextInt(3);
                if (randChoice == 0) {
                    output = new ItemStack(Items.ROTTEN_FLESH, 1);
                } else {
                    output = new ItemStack(PrehistoricEntityType.getRandom().dnaItem, 1);
                }
            } else if (rawItem == Items.LEATHER) {
                if (new Random().nextInt(10) > 3) {
                    output = new ItemStack(PrehistoricEntityType.COW.dnaItem, 1);
                } else {
                    output = new ItemStack(PrehistoricEntityType.HORSE.dnaItem, 1);
                }
            } else if (rawItem == Items.EGG) {
                output = new ItemStack(PrehistoricEntityType.CHICKEN.dnaItem, 1);
            } else if (rawItem == Items.CHICKEN) {
                output = new ItemStack(PrehistoricEntityType.CHICKEN.dnaItem, 1);
            } else if (rawItem == FAItemRegistry.INSTANCE.icedMeat) {
                if (rand >= 15) {
                    output = new ItemStack(Items.CHICKEN, 1);
                }
                if (rand >= 15 && rand < 30) {
                    output = new ItemStack(Items.CHICKEN, 1);
                }
                if (rand >= 30 && rand < 45) {
                    output = new ItemStack(Items.PORKCHOP, 1);
                }
                if (rand >= 45 && rand < 65) {
                    output = new ItemStack(PrehistoricEntityType.getRandomCenozoic().dnaItem);
                }
                if (rand >= 65 && rand < 85) {
                    output = new ItemStack(FAItemRegistry.INSTANCE.tarfossil);
                }
                if (output == null) {
                    output = new ItemStack(Items.BEEF);
                }
            } else if (rawItem == FAItemRegistry.INSTANCE.relic) {
                if (rand <= 40) {
                    output = new ItemStack(Blocks.GRAVEL, 1 + this.worldObj.rand.nextInt(2));
                }
                if (rand > 40 && rand <= 70) {
                    output = new ItemStack(FAItemRegistry.INSTANCE.stoneboard, 1);
                }
                if (rand > 70 && rand <= 88) {
                    output = new ItemStack(Items.FLINT, 1 + this.worldObj.rand.nextInt(1));
                }
                if (rand > 88 && rand <= 92) {
                    output = new ItemStack(FAItemRegistry.INSTANCE.potteryShards, 1);
                }
                if (rand > 92 && rand <= 96) {
                    if (this.worldObj.rand.nextFloat() < 0.7) {
                        output = new ItemStack(FABlockRegistry.INSTANCE.figurineBlock, 1, this.worldObj.rand.nextInt(5) + 10);
                    } else {
                        output = new ItemStack(FABlockRegistry.INSTANCE.figurineBlock, 1, this.worldObj.rand.nextInt(5) + 5);
                    }
                }
                if (rand > 96) {
                    output = new ItemStack(FAItemRegistry.INSTANCE.brokenSword, 1);
                }
            }
            if (output != null) {
                for (int slot = 9; slot < 13; slot++) {
                    ItemStack stack = this.slots[slot];
                    if (stack != null) {
                        if (stack.isItemEqual(output) && stack.stackSize + output.stackSize < 64) {
                            stack.stackSize += output.stackSize;
                            if (this.slots[this.rawIndex].stackSize > 1) {
                                this.slots[this.rawIndex].stackSize--;
                            } else {
                                this.slots[this.rawIndex] = null;
                            }
                            break;
                        }
                    } else if (stack == null) {
                        this.slots[slot] = output;
                        if (this.slots[this.rawIndex].stackSize > 1) {
                            this.slots[this.rawIndex].stackSize--;
                        } else {
                            this.slots[this.rawIndex] = null;
                        }
                        break;
                    }
                }
            }
        }
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.pos) == this && player.getDistanceSq(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D) <= 64.0D;
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
        for (int i = 0; i < this.slots.length; i++) {
            this.slots[0] = null;
        }
    }

    @Override
    public void openInventory(EntityPlayer player) {
        for (int slots = 12; slots > 8; --slots) {
            if (this.slots[slots] != null) {
                if (this.slots[slots].getItem() == FAItemRegistry.INSTANCE.stoneboard) {
                    player.addStat(FossilAchievementHandler.tablet, 1);
                }
            }
        }
    }

    @Override
    public void closeInventory(EntityPlayer player) {
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
        return direction != EnumFacing.DOWN || index != 1;
    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "tile." + LocalizationStrings.BLOCK_ANALYZER_IDLE_NAME + ".name";
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && this.customName.length() > 0;
    }
}
