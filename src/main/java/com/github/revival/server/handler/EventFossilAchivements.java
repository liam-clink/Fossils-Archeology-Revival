package com.github.revival.server.handler;

import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.item.FAItemRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.Item;

public class EventFossilAchivements {
    @SubscribeEvent
    public void onCraftEvent(PlayerEvent.ItemCraftedEvent event) {
        if (event.crafting.getItem() == Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockanalyzerIdle)) {
            event.player.addStat(FossilAchievementHandler.analyzer, 1);
        }
        if (event.crafting.getItem() == Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockcultivateIdle)) {
            event.player.addStat(FossilAchievementHandler.cultivate, 1);
        }
        if (event.crafting.getItem() == Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockSifterIdle)) {
            event.player.addStat(FossilAchievementHandler.sifter, 1);
        }
        if (event.crafting.getItem() == Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockworktableIdle)) {
            event.player.addStat(FossilAchievementHandler.arcWorkbench, 1);
        }
        if (event.crafting.getItem() == FAItemRegistry.INSTANCE.gem_blue) {
            event.player.addStat(FossilAchievementHandler.blueScarab, 1);
        }
        if (event.crafting.getItem() == FAItemRegistry.INSTANCE.gemAxe || event.crafting.getItem() == FAItemRegistry.INSTANCE.gemHoe ||
                event.crafting.getItem() == FAItemRegistry.INSTANCE.gemSword || event.crafting.getItem() == FAItemRegistry.INSTANCE.gemPickaxe
                || event.crafting.getItem() == FAItemRegistry.INSTANCE.gemShovel) {
            event.player.addStat(FossilAchievementHandler.scarabTools, 1);
        }
    }

    @SubscribeEvent
    public void onItemEvent(PlayerEvent.ItemPickupEvent event) {

        if (event.pickedUp.getEntityItem().getItem() == FAItemRegistry.INSTANCE.gem) {
            event.player.addStat(FossilAchievementHandler.scarab, 1);
        }
        if (event.pickedUp.getEntityItem().getItem() == FAItemRegistry.INSTANCE.ancientKey) {
            event.player.addStat(FossilAchievementHandler.key, 1);
        }
        if (event.pickedUp.getEntityItem().getItem() == FAItemRegistry.INSTANCE.ancientClock) {
            event.player.addStat(FossilAchievementHandler.clock, 1);
        }
    }
}
