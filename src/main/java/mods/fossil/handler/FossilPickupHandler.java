package mods.fossil.handler;

import mods.fossil.Fossil;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.stats.AchievementList;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class FossilPickupHandler
{
	@SubscribeEvent
    public void notifyPickup(EntityItem item, EntityPlayer player)
    {
        if (item.getEntityItem().getItem() == Item.getItemFromBlock(Fossil.palmLog))
        {
            player.triggerAchievement(AchievementList.mineWood);
        }

        if (item.getEntityItem().getItem() == Fossil.biofossil)
        {
            player.addStat(FossilAchievementHandler.FoundFossils, 1);
        }
        
        if (item.getEntityItem().getItem() == Fossil.icedMeat)
        {
            player.addStat(FossilAchievementHandler.Permafrost, 1);
        }
    }
}