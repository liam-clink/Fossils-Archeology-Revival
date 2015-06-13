package com.github.revival.common.handler;

import com.github.revival.Revival;
import com.github.revival.common.block.FABlockRegistry;
import com.github.revival.common.enums.EnumDinoType;
import com.github.revival.common.item.FAItemRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.Item;

public class PickupHandler
{
    @SubscribeEvent
    public void notifyPickup(PlayerEvent.ItemPickupEvent event)
    {
    }

    @SubscribeEvent
    public void notifyPickup(PlayerEvent.ItemCraftedEvent event)
    {
    }

    @SubscribeEvent
    public void notifyPickup(PlayerEvent.ItemSmeltedEvent event)
    {

        //Analyzer Achievements
        if (Revival.isDNA(event.smelting.getItem()))
        {
            event.player.addStat(FossilAchievementHandler.dinoDna, 1);
        }
        if (event.smelting.getItem() == FAItemRegistry.stoneboard)
        {
            event.player.addStat(FossilAchievementHandler.tablet, 1);
        }
        if (event.smelting.getItem() == FAItemRegistry.fossilSeed || event.smelting.getItem() == FAItemRegistry.fossilSeed_fern)
        {
            event.player.addStat(FossilAchievementHandler.fossilSeeds, 1);
        }
        if (event.smelting.getItem() == FAItemRegistry.failuresaurusFlesh)
        {
            event.player.addStat(FossilAchievementHandler.failuresaurusAnalyzer, 1);
        }

        //Cultivator Achievements
        if (EnumDinoType.isDinoEgg(event.smelting.getItem()))
        {
            event.player.addStat(FossilAchievementHandler.dinoEgg, 1);
        }
        if (event.smelting.getItem() == FAItemRegistry.embryoCow
                || event.smelting.getItem() == FAItemRegistry.embryoElasmotherium
                || event.smelting.getItem() == FAItemRegistry.embryoHorse
                || event.smelting.getItem() == FAItemRegistry.embryoMammoth
                || event.smelting.getItem() == FAItemRegistry.embryoPig
                || event.smelting.getItem() == FAItemRegistry.embryoQuagga
                || event.smelting.getItem() == FAItemRegistry.embryoSheep
                || event.smelting.getItem() == FAItemRegistry.embryoSmilodon)
        {
            event.player.addStat(FossilAchievementHandler.mammalEmbryo, 1);
        }

        if (event.smelting.getItem() == FAItemRegistry.cultivatedChickenEgg
                || event.smelting.getItem() == FAItemRegistry.cultivatedConfuciusornisEgg
                || event.smelting.getItem() == FAItemRegistry.cultivatedDodoEgg
                || event.smelting.getItem() == FAItemRegistry.cultivatedTerrorBirdEgg)
        {
            event.player.addStat(FossilAchievementHandler.birdEgg, 1);
        }


        //Workbench Achievements
        if (event.smelting.getItem() == FAItemRegistry.ancientSword)
        {
            event.player.addStat(FossilAchievementHandler.fixedSword, 1);
        }
        if (event.smelting.getItem() == FAItemRegistry.ancienthelmet)
        {
            event.player.addStat(FossilAchievementHandler.fixedHelmet, 1);
        }
        if (event.smelting.getItem() == Item.getItemFromBlock(FABlockRegistry.vaseAmphoraBlock)
                || event.smelting.getItem() == Item.getItemFromBlock(FABlockRegistry.vaseKylixBlock)
                || event.smelting.getItem() == Item.getItemFromBlock(FABlockRegistry.vaseVoluteBlock))
        {
            event.player.addStat(FossilAchievementHandler.fixedVase, 1);
        }
    }
}