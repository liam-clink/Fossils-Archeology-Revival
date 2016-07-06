package fossilsarcheology.server.block.entity;

import fossilsarcheology.Revival;
import fossilsarcheology.server.block.BlockCultivate;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.handler.LocalizationStrings;
import fossilsarcheology.server.item.BirdEggItem;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

public class TileEntityCultivate extends TileEntity implements IInventory, ISidedInventory {
	private static final int[] slots_top = new int[] { 0 }; // input
	private static final int[] slots_bottom = new int[] { 2, 1 }; // output
	private static final int[] slots_sides = new int[] { 1 }; // fuel
	public int furnaceBurnTime = 0;
	public int currentItemBurnTime = 0;
	public int furnaceCookTime = 0;
	public boolean isActive;
	private ItemStack[] cultivateItemStacks = new ItemStack[3];
	private String customName;

	public TileEntityCultivate() {
	}

	private static int getItemBurnTime(ItemStack itemstack) {
		if (itemstack != null) {
			Item output = itemstack.getItem();

			if (output == FAItemRegistry.INSTANCE.biofossil) {
				return 300;
			}

			if (output == Items.porkchop) {
				return 3000;
			}

			if (output == Items.fish) {
				return 3000;
			}

			if (output == Items.beef) {
				return 4000;
			}

			if (output == Items.chicken) {
				return 1500;
			}

			if (output == Items.egg) {
				return 1000;
			}

			if (output instanceof BirdEggItem) {
				return 1000;
			}

			if (output instanceof ItemFood && ((ItemFood) output).isWolfsFavoriteMeat()) {
				return 1500;
			}

			if (output == Items.slime_ball) {
				return 800;
			}

			if (output == Items.milk_bucket) {
				return 6000;
			}
		}

		return 0;
	}

	/**
	 * Return true if item is a fuel source (getItemBurnTime() > 0).
	 */
	public static boolean isItemFuel(ItemStack par0ItemStack) {
		return getItemBurnTime(par0ItemStack) > 0;
	}

	/**
	 * Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory() {
		return this.cultivateItemStacks.length;
	}

	/**
	 * Returns the stack in slot i
	 */
	@Override
	public ItemStack getStackInSlot(int var1) {
		return this.cultivateItemStacks[var1];
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number
	 * (second arg) of items and returns them in a new stack.
	 */
	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		if (this.cultivateItemStacks[var1] != null) {
			ItemStack var3;

			if (this.cultivateItemStacks[var1].stackSize <= var2) {
				var3 = this.cultivateItemStacks[var1];
				this.cultivateItemStacks[var1] = null;
				return var3;
			} else {
				var3 = this.cultivateItemStacks[var1].splitStack(var2);

				if (this.cultivateItemStacks[var1].stackSize == 0) {
					this.cultivateItemStacks[var1] = null;
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
		this.cultivateItemStacks[var1] = var2;

		if (var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
			var2.stackSize = this.getInventoryStackLimit();
		}
	}

	/**
	 * Reads a tile entity from NBT.
	 */
	@Override
	public void readFromNBT(NBTTagCompound var1) {
		super.readFromNBT(var1);
		NBTTagList var2 = var1.getTagList("Items", 10);
		this.cultivateItemStacks = new ItemStack[this.getSizeInventory()];

		for (int var3 = 0; var3 < var2.tagCount(); ++var3) {
			NBTTagCompound var4 = var2.getCompoundTagAt(var3);
			byte var5 = var4.getByte("Slot");

			if (var5 >= 0 && var5 < this.cultivateItemStacks.length) {
				this.cultivateItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
			}
		}

		this.furnaceBurnTime = var1.getShort("BurnTime");
		this.furnaceCookTime = var1.getShort("CookTime");
		this.currentItemBurnTime = getItemBurnTime(this.cultivateItemStacks[1]);

		if (var1.hasKey("CustomName")) {
			this.customName = var1.getString("CustomName");
		}
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	@Override
	public void writeToNBT(NBTTagCompound var1) {
		super.writeToNBT(var1);
		var1.setShort("BurnTime", (short) this.furnaceBurnTime);
		var1.setShort("CookTime", (short) this.furnaceCookTime);
		NBTTagList var2 = new NBTTagList();

		for (int var3 = 0; var3 < this.cultivateItemStacks.length; ++var3) {
			if (this.cultivateItemStacks[var3] != null) {
				NBTTagCompound var4 = new NBTTagCompound();
				var4.setByte("Slot", (byte) var3);
				this.cultivateItemStacks[var3].writeToNBT(var4);
				var2.appendTag(var4);
			}
		}

		var1.setTag("Items", var2);

		if (this.isInvNameLocalized()) {
			var1.setString("CustomName", this.customName);
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

	public int getCultivateProgressScaled(int var1) {
		return this.furnaceCookTime * var1 / 6000;
	}

	public int getBurnTimeRemainingScaled(int var1) {
		if (this.currentItemBurnTime == 0) {
			this.currentItemBurnTime = 6000;
		}

		return this.furnaceBurnTime * var1 / this.currentItemBurnTime;
	}

	public boolean isBurning() {
		return this.furnaceBurnTime > 0;
	}

	/**
	 * Allows the entity to update its state. Overridden in most subclasses,
	 * e.g. the mob spawner uses this to count ticks and creates a new spawn
	 * inside its implementation.
	 */

	@Override
	public void updateEntity() {
		boolean var1 = this.furnaceCookTime > 0;
		boolean var2 = false;
		int cookValue;

		if (Revival.enableDebugging()) {
			cookValue = 300;
		} else {

			cookValue = 6000;
		}
		isActive = this.furnaceCookTime > 0;

		if (this.furnaceBurnTime > 0) {
			--this.furnaceBurnTime;
		}

		if (!this.worldObj.isRemote) {
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
				BlockCultivate.updateFurnaceBlockState(this.furnaceCookTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);

			}
		}

		if (var2) {
			this.markDirty();
		}
		if (this.furnaceCookTime == 3001 && (new Random()).nextInt(100) < 20) {
			((BlockCultivate) FABlockRegistry.INSTANCE.blockcultivateIdle).onBlockRemovalLost(this.worldObj, this.xCoord, this.yCoord, this.zCoord, true);
		}
	}

	private boolean canSmelt() {
		if (this.cultivateItemStacks[0] == null) {
			return false;
		} else {
			ItemStack var1 = this.CheckSmelt(this.cultivateItemStacks[0]);
			return var1 != null && (this.cultivateItemStacks[2] == null || (this.cultivateItemStacks[2].isItemEqual(var1) && (this.cultivateItemStacks[2].stackSize < this.getInventoryStackLimit() && this.cultivateItemStacks[2].stackSize < this.cultivateItemStacks[2].getMaxStackSize() || this.cultivateItemStacks[2].stackSize < var1.getMaxStackSize())));
		}
	}

	public void smeltItem() {
		if (this.canSmelt()) {
			ItemStack var1 = this.CheckSmelt(this.cultivateItemStacks[0]);

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

	/**
	 * Do not make give this method the name canInteractWith because it clashes
	 * with Container
	 */
	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && var1.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
	}

	private ItemStack CheckSmelt(int var1) {
		return null;
	}

	private ItemStack CheckSmelt(ItemStack itemstack) {
		if (itemstack.getItem() == FAItemRegistry.INSTANCE.fossilSeed_fern) {
			return new ItemStack(FAItemRegistry.INSTANCE.fernSeed, 1);
		}
		if (itemstack.getItem() == FAItemRegistry.INSTANCE.palaeSaplingFossil) {
			return new ItemStack(FABlockRegistry.INSTANCE.palmSap, 1);
		}
		if (itemstack.getItem() == FAItemRegistry.INSTANCE.fossilSeed) {
			return new ItemStack(FAItemRegistry.INSTANCE.seed, 1, itemstack.getItemDamage());
		}

		/*
		 * if (itemstack.getItem() == FAItemRegistry.INSTANCE.dnaTerrorBird) {
		 * return new ItemStack(FAItemRegistry.INSTANCE.cultivatedTerrorBirdEgg,
		 * 1, new Random().nextInt(EntityTerrorBird.names.length)); }
		 */

		if (EnumPrehistoric.getEgg(itemstack.getItem()) != null) {
			return new ItemStack(EnumPrehistoric.getEgg(itemstack.getItem()), 1);

		}

		if (EnumPrehistoric.getEmbryo(itemstack.getItem()) != null) {
			return new ItemStack(EnumPrehistoric.getEmbryo(itemstack.getItem()), 1);
		}
		if (EnumPrehistoric.getBestBirdEgg(itemstack.getItem()) != null) {
			return new ItemStack(EnumPrehistoric.getBestBirdEgg(itemstack.getItem()), 1);
		}

		/*
		 * if (itemstack.getItem() == FAItemRegistry.INSTANCE.dnaCoelacanth) {
		 * return new ItemStack(FAItemRegistry.INSTANCE.livingCoelacanth, 1, new
		 * Random().nextInt(LivingCoelacanthItem.names.length)); }
		 */

		return null;
	}

	/**
	 * When some containers are closed they call this on each slot, then drop
	 * whatever it returns as an EntityItem - like when you close a workbench
	 * GUI.
	 */
	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		return null;
	}

	/**
	 * Returns the name of the inventory.
	 */
	public String getInvName() {
		return this.isInvNameLocalized() ? this.customName : "tile." + LocalizationStrings.BLOCK_CULTIVATE_IDLE_NAME + ".name";
	}

	/**
	 * If this returns false, the inventory name will be used as an unlocalized
	 * name, and translated into the player's language. Otherwise it will be
	 * used directly.
	 */
	public boolean isInvNameLocalized() {
		return this.customName != null && this.customName.length() > 0;
	}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring
	 * stack size) into the given slot.
	 */
	@Override
	public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
		return par1 != 2 && (par1 != 1 || isItemFuel(par2ItemStack));
	}

	/**
	 * Returns an array containing the indices of the slots that can be accessed
	 * by automation on the given side of this block.
	 */
	@Override
	public int[] getAccessibleSlotsFromSide(int par1) {
		return par1 == 0 ? slots_bottom : (par1 == 1 ? slots_top : slots_sides);
	}

	/**
	 * Returns true if automation can insert the given item in the given slot
	 * from the given side. Args: Slot, item, side
	 */
	@Override
	public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3) {
		return this.isItemValidForSlot(par1, par2ItemStack);
	}

	/**
	 * Returns true if automation can extract the given item in the given slot
	 * from the given side. Args: Slot, item, side
	 */
	@Override
	public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3) {
		return par3 != 0 || par1 != 1 || par2ItemStack.getItem() == Items.bucket;
	}

	@Override
	public String getInventoryName() {
		return this.isInvNameLocalized() ? this.customName : "tile." + LocalizationStrings.BLOCK_CULTIVATE_IDLE_NAME + ".name";
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {

	}

	/**
	 * Returns an intiger based on what dna is inside 0 = 4 legged animal 1 =
	 * legless animal 2 = plant 3 = spore 4 = insect
	 */
	public int getDNAType() {
		if (this.getStackInSlot(0) != null) {
			if (this.getStackInSlot(0).getItem() != null) {
				if (this.getStackInSlot(0).getItem() == EnumPrehistoric.Coelacanth.DNAItem || this.getStackInSlot(0).getItem() == EnumPrehistoric.Sturgeon.DNAItem || this.getStackInSlot(0).getItem() == EnumPrehistoric.Alligator_Gar.DNAItem) {
					return 1;
				}
				if (this.getStackInSlot(0).getItem() == FAItemRegistry.INSTANCE.fossilSeed_fern || this.getStackInSlot(0).getItem() == FAItemRegistry.INSTANCE.palaeSaplingFossil || this.getStackInSlot(0).getItem() == FAItemRegistry.INSTANCE.fossilSeed) {
					return 2;
				}

			}
		}
		return 0;
	}
}
