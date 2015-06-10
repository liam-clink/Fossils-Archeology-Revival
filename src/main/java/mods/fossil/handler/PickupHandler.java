package mods.fossil.handler;

import mods.fossil.Fossil;
import mods.fossil.core.FossilPlants;
import mods.fossil.fossilEnums.EnumDinoType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.stats.AchievementList;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class PickupHandler
{
	@SubscribeEvent
    public void notifyPickup(PlayerEvent.ItemPickupEvent event) {}
	
	@SubscribeEvent
    public void notifyPickup(PlayerEvent.ItemCraftedEvent event) {}
	
	@SubscribeEvent
    public void notifyPickup(PlayerEvent.ItemSmeltedEvent event) 
	{
		
		//Analyzer Achievements
		if(Fossil.isDNA(event.smelting.getItem())){
		event.player.addStat(FossilAchievementHandler.dinoDna, 1);
		}
		if(event.smelting.getItem() == Fossil.stoneboard){
			event.player.addStat(FossilAchievementHandler.tablet, 1);
		}
		if(event.smelting.getItem() == FossilPlants.fossilSeed || event.smelting.getItem() == FossilPlants.fossilSeed_fern){
			event.player.addStat(FossilAchievementHandler.fossilSeeds, 1);
		}
		if(event.smelting.getItem() == Fossil.failuresaurusFlesh){
			event.player.addStat(FossilAchievementHandler.failuresaurusAnalyzer, 1);
		}
		
		//Cultivator Achievements
		if(EnumDinoType.isDinoEgg(event.smelting.getItem())){
			event.player.addStat(FossilAchievementHandler.dinoEgg, 1);
		}
		if(event.smelting.getItem() == Fossil.embryoCow 
				|| event.smelting.getItem() == Fossil.embryoElasmotherium
				|| event.smelting.getItem() == Fossil.embryoHorse
				|| event.smelting.getItem() == Fossil.embryoMammoth 
				|| event.smelting.getItem() == Fossil.embryoPig 
				|| event.smelting.getItem() == Fossil.embryoQuagga
				|| event.smelting.getItem() == Fossil.embryoSheep 
				|| event.smelting.getItem() == Fossil.embryoSmilodon){
			event.player.addStat(FossilAchievementHandler.mammalEmbryo, 1);
		}
		
		if(event.smelting.getItem() == Fossil.cultivatedChickenEgg 
				|| event.smelting.getItem() == Fossil.cultivatedConfuciusornisEgg
				|| event.smelting.getItem() == Fossil.cultivatedDodoEgg 
				|| event.smelting.getItem() == Fossil.cultivatedTerrorBirdEgg){
			event.player.addStat(FossilAchievementHandler.birdEgg, 1);
		}
		
		
		//Workbench Achievements
		if(event.smelting.getItem() == Fossil.ancientSword){
			event.player.addStat(FossilAchievementHandler.fixedSword, 1);
		}
		if(event.smelting.getItem() == Fossil.ancienthelmet){
			event.player.addStat(FossilAchievementHandler.fixedHelmet, 1);
		}
		if(event.smelting.getItem() == Item.getItemFromBlock(Fossil.vaseAmphoraBlock) 
				|| event.smelting.getItem() == Item.getItemFromBlock(Fossil.vaseKylixBlock)
				|| event.smelting.getItem() == Item.getItemFromBlock(Fossil.vaseVoluteBlock)){
			event.player.addStat(FossilAchievementHandler.fixedVase, 1);
		}
	}
}