package mods.fossil.handler;

import mods.fossil.entity.mob.EntityTRex;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class FossilLivingEvent {

	@SubscribeEvent
	public void onEntityLivingDeath(LivingDeathEvent event)
	{
		if (event.source.getEntity() instanceof EntityPlayerMP) 
		{
			  if (event.source.getEntity() instanceof EntityTRex)
			  { 
				  EntityTRex entity = (EntityTRex) event.entityLiving;
				  
				  entity.openMouth(true);
			
			  }
		 }   
	}
}
