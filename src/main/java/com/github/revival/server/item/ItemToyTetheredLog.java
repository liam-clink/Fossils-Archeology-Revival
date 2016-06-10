package com.github.revival.server.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.github.revival.server.entity.toy.EntityToyTetheredLog;

public class ItemToyTetheredLog extends Item {

	public ItemToyTetheredLog() {
		super();
		this.setTextureName("dye_powder_gray");
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (side == 0 && world.isAirBlock(x, y - 2, z)) {
			EntityToyTetheredLog ball = new EntityToyTetheredLog(world);
			ball.setLocationAndAngles(x + 0.5, y - 1.9, z + 0.5, 0, 0);
			if (!world.isRemote)
				world.spawnEntityInWorld(ball);
			ball.rotationYaw = player.rotationYawHead;
			if (!player.capabilities.isCreativeMode)
				--stack.stackSize;
			return true;
		}
		return false;
	}
}
