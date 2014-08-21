package mods.fossil.guiBlocks;

import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.client.LocalizationStrings;
import mods.fossil.entity.mob.EntityTerrorBird;
import mods.fossil.fossilEnums.EnumDinoType;
import mods.fossil.items.ItemLivingCoelacanth;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCultivate extends TileEntity implements IInventory, ISidedInventory
{
    private static final int[] slots_top = new int[] {0}; //input
    private static final int[] slots_bottom = new int[] {2,1}; //output
    private static final int[] slots_sides = new int[] {1};  //fuel
    
    private ItemStack[] cultivateItemStacks = new ItemStack[3];
    public int furnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int furnaceCookTime = 0;
	private String customName;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.cultivateItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int var1)
    {
        return this.cultivateItemStacks[var1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int var1, int var2)
    {
        if (this.cultivateItemStacks[var1] != null)
        {
            ItemStack var3;

            if (this.cultivateItemStacks[var1].stackSize <= var2)
            {
                var3 = this.cultivateItemStacks[var1];
                this.cultivateItemStacks[var1] = null;
                return var3;
            }
            else
            {
                var3 = this.cultivateItemStacks[var1].splitStack(var2);

                if (this.cultivateItemStacks[var1].stackSize == 0)
                {
                    this.cultivateItemStacks[var1] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int var1, ItemStack var2)
    {
        this.cultivateItemStacks[var1] = var2;

        if (var2 != null && var2.stackSize > this.getInventoryStackLimit())
        {
            var2.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound var1)
    {
        super.readFromNBT(var1);
        NBTTagList var2 = var1.getTagList("Items", 10);
        this.cultivateItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.getCompoundTagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.cultivateItemStacks.length)
            {
                this.cultivateItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.furnaceBurnTime = var1.getShort("BurnTime");
        this.furnaceCookTime = var1.getShort("CookTime");
        this.currentItemBurnTime = this.getItemBurnTime(this.cultivateItemStacks[1]);
        
        if (var1.hasKey("CustomName"))
        {
            this.customName = var1.getString("CustomName");
        }
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound var1)
    {
        super.writeToNBT(var1);
        var1.setShort("BurnTime", (short)this.furnaceBurnTime);
        var1.setShort("CookTime", (short)this.furnaceCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.cultivateItemStacks.length; ++var3)
        {
            if (this.cultivateItemStacks[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.cultivateItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        var1.setTag("Items", var2);
        
        if (this.isInvNameLocalized())
        {
        	var1.setString("CustomName", this.customName);
        }
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    public int getCookProgressScaled(int var1)
    {
        return this.furnaceCookTime * var1 / 6000;
    }

    public int getBurnTimeRemainingScaled(int var1)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 6000;
        }

        return this.furnaceBurnTime * var1 / this.currentItemBurnTime;
    }

    public boolean isBurning()
    {
        return this.furnaceBurnTime > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        boolean var1 = this.furnaceCookTime > 0;
        boolean var2 = false;
        int cookValue;

        if (Fossil.DebugMode())
        {
            cookValue = 300;
        }
        else
        {
            cookValue = 6000;
        }

        if (this.furnaceBurnTime > 0)
        {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.furnaceBurnTime == 0 && this.canSmelt())
            {
                this.currentItemBurnTime = this.furnaceBurnTime = this.getItemBurnTime(this.cultivateItemStacks[1]);

                if (this.furnaceBurnTime > 0)
                {
                    var2 = true;

                    if (this.cultivateItemStacks[1] != null)
                    {
                        if (this.cultivateItemStacks[1].getItem().hasContainerItem())
                        {
                            this.cultivateItemStacks[1] = new ItemStack(this.cultivateItemStacks[1].getItem().getContainerItem());
                        }
                        else
                        {
                            --this.cultivateItemStacks[1].stackSize;
                        }

                        if (this.cultivateItemStacks[1].stackSize == 0)
                        {
                            this.cultivateItemStacks[1] = null;
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                ++this.furnaceCookTime;

                if (this.furnaceCookTime == cookValue)
                {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else if (this.furnaceCookTime != 0 && !this.canSmelt())
            {
                this.furnaceCookTime = 0;
            }

            if (var1 != this.furnaceCookTime > 0)
            {
                var2 = true;
                BlockCultivate.updateFurnaceBlockState(this.furnaceCookTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (var2)
        {
            this.markDirty();
        }

        if (this.furnaceCookTime == 3001 && (new Random()).nextInt(100) < 20)
        {
            ((BlockCultivate)Fossil.blockcultivateIdle).onBlockRemovalLost(this.worldObj, this.xCoord, this.yCoord, this.zCoord, true);
        }
    }

    private boolean canSmelt()
    {
        if (this.cultivateItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = this.CheckSmelt(this.cultivateItemStacks[0]);
            return var1 == null ? false : (this.cultivateItemStacks[2] == null ? true : (!this.cultivateItemStacks[2].isItemEqual(var1) ? false : (this.cultivateItemStacks[2].stackSize < this.getInventoryStackLimit() && this.cultivateItemStacks[2].stackSize < this.cultivateItemStacks[2].getMaxStackSize() ? true : this.cultivateItemStacks[2].stackSize < var1.getMaxStackSize())));
        }
    }

    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = this.CheckSmelt(this.cultivateItemStacks[0]);

            if (this.cultivateItemStacks[2] == null)
            {
                this.cultivateItemStacks[2] = var1.copy();
            }
            else if (this.cultivateItemStacks[2] == var1)
            {
                this.cultivateItemStacks[2].stackSize += var1.stackSize;
            }

            if (this.cultivateItemStacks[0].getItem().hasContainerItem())
            {
                this.cultivateItemStacks[0] = new ItemStack(this.cultivateItemStacks[0].getItem().getContainerItem());
            }
            else
            {
                --this.cultivateItemStacks[0].stackSize;
            }

            if (this.cultivateItemStacks[0].stackSize <= 0)
            {
                this.cultivateItemStacks[0] = null;
            }
        }
    }

    private static int getItemBurnTime(ItemStack itemstack)
    {
        if (itemstack != null)
        {
            Item output = itemstack.getItem();

            if (output == Fossil.biofossil)
            {
                return 300;
            }

            if (output == Items.porkchop)
            {
                return 3000;
            }

            if (output == Items.fish)
            {
                return 3000;
            }

            if (output == Items.beef)
            {
                return 4000;
            }

            if (output == Items.chicken)
            {
                return 1500;
            }

            if (output == Items.egg)
            {
                return 1000;
            }
            
            if (output == Fossil.dodoEgg || output == Fossil.terrorBirdEgg)
            {
                return 1000;
            }
            
            if (output == Fossil.dodoWing || output == Fossil.terrorBirdMeat)
            {
                return 1500;
            }

            if (output == Items.slime_ball)
            {
                return 800;
            }

            if (output == Items.milk_bucket)
            {
                return 6000;
            }
        }

        return 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer var1)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : var1.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    private ItemStack CheckSmelt(int var1)
    {
        return null;
    }

    private ItemStack CheckSmelt(ItemStack itemstack)
    {
        if (itemstack.getItem() == Fossil.brokenSapling)
        {
            return new ItemStack(Fossil.palmSap, 1);
        }

        if (itemstack.getItem() == Fossil.dnaSheep)
        {
            return new ItemStack(Fossil.embryoSheep, 1);
        }

        if (itemstack.getItem() == Fossil.dnaCow)
        {
            return new ItemStack(Fossil.embryoCow, 1);
        }
        
        if (itemstack.getItem() == Fossil.dnaHorse)
        {
            return new ItemStack(Fossil.embryoHorse, 1);
        }
        
        if (itemstack.getItem() == Fossil.dnaQuagga)
        {
            return new ItemStack(Fossil.embryoQuagga, 1);
        }

        if (itemstack.getItem() == Fossil.dnaChicken)
        {
            return new ItemStack(Fossil.embryoChicken, 1);
        }

        if (itemstack.getItem() == Fossil.dnaPig)
        {
            return new ItemStack(Fossil.embryoPig, 1);
        }

        if (itemstack.getItem() == Fossil.dnaSmilodon)
        {
            return new ItemStack(Fossil.embryoSmilodon, 1);
        }

        if (itemstack.getItem() == Fossil.dnaMammoth)
        {
            return new ItemStack(Fossil.embryoMammoth, 1);
        }

        if (itemstack.getItem() == Fossil.dnaDodo)
        {
            return new ItemStack(Fossil.cultivatedDodoEgg, 1);
        }
        
        if (itemstack.getItem() == Fossil.dnaTerrorBird)
        {
            return new ItemStack(Fossil.cultivatedTerrorBirdEgg, 1, new Random().nextInt(EntityTerrorBird.names.length));
        }

        if (EnumDinoType.getEgg(itemstack.getItem()) != null)
        {
            return new ItemStack(EnumDinoType.getEgg(itemstack.getItem()), 1);    //converts dino dna to dino egg
        }
        
        if (itemstack.getItem() == Fossil.dnaCoelacanth){
        	return new ItemStack(Fossil.livingCoelacanth, 1, new Random().nextInt(ItemLivingCoelacanth.names.length));
        }

        return null;
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int var1)
    {
        return null;
    }

    
    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
    	return this.isInvNameLocalized() ? this.customName : "tile." + LocalizationStrings.BLOCK_CULTIVATE_IDLE_NAME + ".name";
    }
    
    /**
     * If this returns false, the inventory name will be used as an unlocalized name, and translated into the player's
     * language. Otherwise it will be used directly.
     */
    public boolean isInvNameLocalized()
    {
        return this.customName != null && this.customName.length() > 0;
    }

    /**
     * Return true if item is a fuel source (getItemBurnTime() > 0).
     */
    public static boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }
    
    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack)
    {
        return par1 == 2 ? false : (par1 == 1 ? isItemFuel(par2ItemStack) : true);
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    public int[] getAccessibleSlotsFromSide(int par1)
    {
        return par1 == 0 ? slots_bottom : (par1 == 1 ? slots_top : slots_sides);
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return this.isItemValidForSlot(par1, par2ItemStack);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3)
    {
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
	public void openInventory() {}
	
	@Override
	public void closeInventory() {}
}
