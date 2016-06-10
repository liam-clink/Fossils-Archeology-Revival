package com.github.revival.server.handler;

import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.item.FAItemRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.Item;

public class PickupHandler {
    @SubscribeEvent
    public void notifyPickup(PlayerEvent.ItemPickupEvent event) {
    }

    @SubscribeEvent
    public void notifyPickup(PlayerEvent.ItemCraftedEvent event) {
    }

    @SubscribeEvent
    public void notifyPickup(PlayerEvent.ItemSmeltedEvent event) {

        // Analyzer Achievements
        if (EnumPrehistoric.isDNA(event.smelting.getItem())) {
            event.player.addStat(FossilAchievementHandler.dinoDna, 1);
        }
        if (event.smelting.getItem() == FAItemRegistry.INSTANCE.stoneboard) {
            event.player.addStat(FossilAchievementHandler.tablet, 1);
        }
        if (event.smelting.getItem() == FAItemRegistry.INSTANCE.fossilSeed || event.smelting.getItem() == FAItemRegistry.INSTANCE.fossilSeed_fern) {
            event.player.addStat(FossilAchievementHandler.fossilSeeds, 1);
        }
        if (event.smelting.getItem() == FAItemRegistry.INSTANCE.failuresaurusFlesh) {
            event.player.addStat(FossilAchievementHandler.failuresaurusAnalyzer, 1);
        }

        // Cultivator Achievements
        if (EnumPrehistoric.isDinoEgg(event.smelting.getItem())) {
            event.player.addStat(FossilAchievementHandler.dinoEgg, 1);
        }
        if (EnumPrehistoric.isDNA(event.smelting.getItem())) {
            event.player.addStat(FossilAchievementHandler.mammalEmbryo, 1);
        }

        if (EnumPrehistoric.isBestBirdEgg(event.smelting.getItem())) {
            event.player.addStat(FossilAchievementHandler.birdEgg, 1);
        }

        // Workbench Achievements
        if (event.smelting.getItem() == FAItemRegistry.INSTANCE.ancientSword) {
            event.player.addStat(FossilAchievementHandler.fixedSword, 1);
        }
        if (event.smelting.getItem() == FAItemRegistry.INSTANCE.ancienthelmet) {
            event.player.addStat(FossilAchievementHandler.fixedHelmet, 1);
        }
        if (event.smelting.getItem() == Item.getItemFromBlock(FABlockRegistry.INSTANCE.vaseAmphoraBlock) || event.smelting.getItem() == Item.getItemFromBlock(FABlockRegistry.INSTANCE.vaseKylixBlock) || event.smelting.getItem() == Item.getItemFromBlock(FABlockRegistry.INSTANCE.vaseVoluteBlock)) {
            event.player.addStat(FossilAchievementHandler.fixedVase, 1);
        }
    }
}