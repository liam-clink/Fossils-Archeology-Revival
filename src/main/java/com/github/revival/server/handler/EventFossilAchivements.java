package com.github.revival.server.handler;

import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.item.FAItemRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.Item;

public class EventFossilAchivements {
    @SubscribeEvent
    public void onCraftEvent(PlayerEvent.ItemCraftedEvent event) {
        if (event.crafting.getItem() == Item.getItemFromBlock(FABlockRegistry.blockanalyzerIdle)) {
            event.player.addStat(FossilAchievementHandler.analyzer, 1);
        }
        if (event.crafting.getItem() == Item.getItemFromBlock(FABlockRegistry.blockcultivateIdle)) {
            event.player.addStat(FossilAchievementHandler.cultivate, 1);
        }
        if (event.crafting.getItem() == Item.getItemFromBlock(FABlockRegistry.blockSifterIdle)) {
            event.player.addStat(FossilAchievementHandler.sifter, 1);
        }
        if (event.crafting.getItem() == Item.getItemFromBlock(FABlockRegistry.blockworktableIdle)) {
            event.player.addStat(FossilAchievementHandler.arcWorkbench, 1);
        }
        if (event.crafting.getItem() == FAItemRegistry.gem_blue) {
            event.player.addStat(FossilAchievementHandler.blueScarab, 1);
        }
        if (event.crafting.getItem() == FAItemRegistry.gemAxe || event.crafting.getItem() == FAItemRegistry.gemHoe ||
                event.crafting.getItem() == FAItemRegistry.gemSword || event.crafting.getItem() == FAItemRegistry.gemPickaxe
                || event.crafting.getItem() == FAItemRegistry.gemShovel) {
            event.player.addStat(FossilAchievementHandler.scarabTools, 1);
        }
    }

    @SubscribeEvent
    public void onItemEvent(PlayerEvent.ItemPickupEvent event) {

        if (event.pickedUp.getEntityItem().getItem() == FAItemRegistry.gem) {
            event.player.addStat(FossilAchievementHandler.scarab, 1);
        }
        if (event.pickedUp.getEntityItem().getItem() == FAItemRegistry.ancientKey) {
            event.player.addStat(FossilAchievementHandler.key, 1);
        }
        if (event.pickedUp.getEntityItem().getItem() == FAItemRegistry.ancientClock) {
            event.player.addStat(FossilAchievementHandler.clock, 1);
        }
    }
}
