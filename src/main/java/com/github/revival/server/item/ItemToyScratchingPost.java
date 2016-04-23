package com.github.revival.server.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.github.revival.server.entity.toy.EntityToyScratchingPost;

public class ItemToyScratchingPost extends Item{

	public ItemToyScratchingPost(){
		super();
		this.setTextureName("dye_powder_gray");
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
		if(side == 1 && world.isAirBlock(x, y + 1, z) && world.isAirBlock(x, y + 2, z)){
			EntityToyScratchingPost ball = new EntityToyScratchingPost(world);
			ball.setLocationAndAngles(x + 0.5, y + 1, z + 0.5, 0, 0);
			if(!world.isRemote)
				world.spawnEntityInWorld(ball);
			ball.rotationYaw = player.rotationYawHead;
			if(!player.capabilities.isCreativeMode)
				--stack.stackSize;
			return true;
		}
		return false;
	}
}
