package mods.fossil.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mods.fossil.Fossil;
import mods.fossil.entity.mob.EntityPregnantCow;
import mods.fossil.entity.mob.EntityPregnantHorse;
import mods.fossil.entity.mob.EntityPregnantPig;
import mods.fossil.entity.mob.EntityPregnantSheep;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class FossilInteractEvent {

	@SubscribeEvent
	public void onEntityInteract(EntityInteractEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
		EntityPlayer player = (EntityPlayer) event.entity;
			if (event.target != null)
			{
				if(event.target instanceof EntityHorse){
					if(player.getHeldItem().getItem() == Fossil.dinoPedia)
					{
						EntityPregnantHorse props = EntityPregnantHorse.get((EntityHorse) event.target);
						
						if(props.Embryo != null){
							props.setPedia();
				            player.openGui(Fossil.instance, 4, event.target.worldObj, (int)event.target.posX, (int)event.target.posY, (int)event.target.posZ);
						}
					}
					else
					{
						((EntityHorse)event.target).interact(player);
					}
				}
				
				if(event.target instanceof EntityCow){
					if(player.getHeldItem().getItem() == Fossil.dinoPedia)
					{
						EntityPregnantCow props = EntityPregnantCow.get((EntityCow) event.target);
						
						if(props.Embryo != null){
							props.setPedia();
				            player.openGui(Fossil.instance, 4, event.target.worldObj, (int)event.target.posX, (int)event.target.posY, (int)event.target.posZ);
						}
					}
					else
					{
						((EntityCow)event.target).interact(player);
					}
				}
				
				if(event.target instanceof EntityPig){
					if(player.getHeldItem().getItem() == Fossil.dinoPedia)
					{
						EntityPregnantPig props = EntityPregnantPig.get((EntityPig) event.target);
						
						if(props.Embryo != null){
							props.setPedia();
				            player.openGui(Fossil.instance, 4, event.target.worldObj, (int)event.target.posX, (int)event.target.posY, (int)event.target.posZ);
						}
					}
					else
					{
						((EntityPig)event.target).interact(player);
					}
				}
				
				if(event.target instanceof EntitySheep){
					if(player.getHeldItem().getItem() == Fossil.dinoPedia)
					{
						EntityPregnantSheep props = EntityPregnantSheep.get((EntitySheep) event.target);
						
						if(props.Embryo != null){
							props.setPedia();
				            player.openGui(Fossil.instance, 4, event.target.worldObj, (int)event.target.posX, (int)event.target.posY, (int)event.target.posZ);
						}
					}
					else
					{
						((EntitySheep)event.target).interact(player);
					}
				}
			}
		}
	}
}
