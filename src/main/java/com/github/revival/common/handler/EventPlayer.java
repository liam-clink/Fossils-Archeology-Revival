package com.github.revival.common.handler;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;

import com.github.revival.Revival;
import com.github.revival.common.config.FossilConfig;
import com.github.revival.common.entity.EntityFAPlayer;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventPlayer {
	@SubscribeEvent
	public void onClonePlayer(PlayerEvent.Clone event)
	{
		NBTTagCompound compound = new NBTTagCompound();
		EntityFAPlayer.get(event.original).saveNBTData(compound);
		EntityFAPlayer.get(event.entityPlayer).loadNBTData(compound);
	}

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer && EntityFAPlayer.get((EntityPlayer) event.entity) == null){
			EntityFAPlayer.register((EntityPlayer) event.entity);
		}
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(EntityFAPlayer.EXT_PROP_NAME) == null)
			event.entity.registerExtendedProperties(EntityFAPlayer.EXT_PROP_NAME, new EntityFAPlayer((EntityPlayer) event.entity));
	}
	
	@SubscribeEvent
	public void onBreakBlock(BlockEvent.BreakEvent event)
	{
		if(event.world.provider.dimensionId == FossilConfig.dimIdDarknessLair && event.block != Blocks.obsidian && !EntityFAPlayer.get(event.getPlayer()).isKilledAnu()){
			Revival.showMessage(StatCollector.translateToLocal("anu.breakblock"), event.getPlayer());
			event.setCanceled(true);
		}
	}

}
