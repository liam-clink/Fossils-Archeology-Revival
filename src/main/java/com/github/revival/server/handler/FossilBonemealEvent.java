package com.github.revival.server.handler;

import com.github.revival.server.block.BlockPalmSapling;
import com.github.revival.server.block.FABlockRegistry;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class FossilBonemealEvent {
	@SubscribeEvent
	public void onUseBonemeal(BonemealEvent event) {
		if (event.block == FABlockRegistry.INSTANCE.palmSap) {
			if (!event.world.isRemote) {
				((BlockPalmSapling) FABlockRegistry.INSTANCE.palmSap).generateTree(event.world, event.x, event.y, event.z, event.world.rand);
				event.setResult(Event.Result.ALLOW);
			}
		}
	}
}
