package mods.fossil.guiBlocks;

import mods.fossil.Fossil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerSifter extends Container
{
    private TileEntitySifter sifter;
    private int cookTime = 0;
    private int burnTime = 0;
    private int itemBurnTime = 0;

    


    public static final int INPUT = 0;
    
    /*
     * INPUT = 0
     * OUTPUT = 1-5
     * 
     */
 
    public ContainerSifter(InventoryPlayer var1, TileEntity var2)
    {
        this.sifter = (TileEntitySifter)var2;
        int var3;
        int var4;

        //Sifter input
        this.addSlotToContainer(new Slot(this.sifter, INPUT, 80, 10));

        //Sifter output
        for (var3 = 0; var3 < 5; ++var3)
        {
            this.addSlotToContainer(new SlotFurnace(var1.player, this.sifter, 1 + var3, 44 + 18 * var3, 62));
        }

        //player inventory
        for (var3 = 0; var3 < 3; ++var3)
        {
            for (var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        //player hotbar
        for (var3 = 0; var3 < 9; ++var3)
        {
            this.addSlotToContainer(new Slot(var1, var3, 8 + var3 * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting var1)
    {
        super.addCraftingToCrafters(var1);
        var1.sendProgressBarUpdate(this, 0, this.sifter.sifterCookTime);
        var1.sendProgressBarUpdate(this, 1, this.sifter.sifterBurnTime);
        var1.sendProgressBarUpdate(this, 2, this.sifter.currentItemBurnTime);
    }

    /**
     * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int var1 = 0; var1 < this.crafters.size(); ++var1)
        {
            ICrafting var2 = (ICrafting)this.crafters.get(var1);

            if (this.cookTime != this.sifter.sifterCookTime)
            {
                var2.sendProgressBarUpdate(this, 0, this.sifter.sifterCookTime);
            }

            if (this.burnTime != this.sifter.sifterBurnTime)
            {
                var2.sendProgressBarUpdate(this, 1, this.sifter.sifterBurnTime);
            }

            if (this.itemBurnTime != this.sifter.currentItemBurnTime)
            {
                var2.sendProgressBarUpdate(this, 2, this.sifter.currentItemBurnTime);
            }
        }

        this.cookTime = this.sifter.sifterCookTime;
        this.burnTime = this.sifter.sifterBurnTime;
        this.itemBurnTime = this.sifter.currentItemBurnTime;
    }

    public void updateProgressBar(int var1, int var2)
    {
        if (var1 == 0)
        {
            this.sifter.sifterCookTime = var2;
        }

        if (var1 == 1)
        {
            this.sifter.sifterBurnTime = var2;
        }

        if (var1 == 2)
        {
            this.sifter.currentItemBurnTime = var2;
        }
    }

    public boolean canInteractWith(EntityPlayer var1)
    {
        return this.sifter.isUseableByPlayer(var1);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 > 0 && par2 < 6) // If slot is equal to Output (1-5).
            {
            	//Place INTO inventory, only check output.
                if (!this.mergeItemStack(itemstack1, 6, 42, true)) // 6 is first slot after the outputs, 42 is last inventory slot
                {
                    return null;
                }
                
                slot.onSlotChange(itemstack1, itemstack);
            }
    		// itemstack is in player inventory, try to place in appropriate furnace slot
    		else if (par2 != INPUT) // if it's not in the INPUT
    		{
    			// if it can be smelted, place in the input slots
    			if (itemstack1 != null)
    			{
    				// try to place in either Input slot; add 1 to final input slot because mergeItemStack uses < index
    				if (!this.mergeItemStack(itemstack1, INPUT, INPUT+1, false))
    				{
    					return null;
    				}
    			}
    		}
			// item in player's inventory, but not in action bar
			else if(par2 >= 5+1 && par2 < 5+28)
			{
				// place in action bar
				if (!this.mergeItemStack(itemstack1, 5+28, 5+37, false))
				{
					return null;
				}
			}
			// item in action bar - place in player inventory
			else if (par2 >= 5+28 && par2 < 5+37 && !this.mergeItemStack(itemstack1, 5+1, 5+28, false))
			{
				return null;
			}
            
    		// In one of the output slots; try to place in player inventory / action bar
			else if (!this.mergeItemStack(itemstack1, 5+1, 5+37, false))
			{
				return null;
			}
    		
            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }
}
