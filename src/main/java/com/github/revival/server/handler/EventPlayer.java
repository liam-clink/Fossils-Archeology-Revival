package com.github.revival.server.handler;

import com.github.revival.Revival;
import com.github.revival.server.config.FossilConfig;
import com.github.revival.server.entity.FAPlayerEntity;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;

public class EventPlayer {
    @SubscribeEvent
    public void onClonePlayer(PlayerEvent.Clone event) {
        NBTTagCompound compound = new NBTTagCompound();
        FAPlayerEntity.get(event.original).saveNBTData(compound);
        FAPlayerEntity.get(event.entityPlayer).loadNBTData(compound);
    }

    @SubscribeEvent
    public void onEntityConstructing(EntityConstructing event) {
        if (event.entity instanceof EntityPlayer && FAPlayerEntity.get((EntityPlayer) event.entity) == null) {
            FAPlayerEntity.register((EntityPlayer) event.entity);
        }
        if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(FAPlayerEntity.EXT_PROP_NAME) == null) {
            event.entity.registerExtendedProperties(FAPlayerEntity.EXT_PROP_NAME, new FAPlayerEntity((EntityPlayer) event.entity));
        }
    }

    @SubscribeEvent
    public void onBreakBlock(BlockEvent.BreakEvent event) {
        if (event.world.provider.dimensionId == FossilConfig.dimIdDarknessLair && event.block != Blocks.obsidian && !FAPlayerEntity.get(event.getPlayer()).isKilledAnu()) {
            Revival.showMessage(StatCollector.translateToLocal("anu.breakblock"), event.getPlayer());
            event.setCanceled(true);
        }
    }

}
