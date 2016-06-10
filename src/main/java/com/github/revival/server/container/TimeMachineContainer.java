package com.github.revival.server.container;

import com.github.revival.server.block.entity.TileEntityTimeMachine;
import com.github.revival.server.handler.FossilAchievementHandler;
import com.github.revival.server.item.FAItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class TimeMachineContainer extends Container {
	private TileEntityTimeMachine timeMachine;
	private int lastCookTime = 0;
	private int lastBurnTime = 0;
	private int lastItemBurnTime = 0;

	public TimeMachineContainer(InventoryPlayer var1, TileEntityTimeMachine var2) {
		this.timeMachine = var2;
		int var3;
		int var4;

		this.addSlotToContainer(new Slot(var2, 6, 35, 46));

		for (var3 = 0; var3 < 3; ++var3) {
			for (var4 = 0; var4 < 9; ++var4) {
				this.addSlotToContainer(new Slot(var1, var4 + var3 * 9 + 9, 7 + var4 * 18, 107 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3) {
			this.addSlotToContainer(new Slot(var1, var3, 7 + var3 * 18, 165));
		}
	}

	@Override
	public void updateProgressBar(int var1, int var2) {
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return this.timeMachine.isUseableByPlayer(var1);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or
	 * you will crash when someone does that.
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int var2) {
		Slot slot = (Slot) this.inventorySlots.get(var2);

		if (var2 == 6) {
			if (slot.getStack() != null) {
				if (slot.getStack().getItem() != null) {
					if (slot.getStack().getItem() == FAItemRegistry.INSTANCE.ancientClock) {
						par1EntityPlayer.addStat(FossilAchievementHandler.clock, 1);
					}
				}
			}
		}
		return null;
	}
}
