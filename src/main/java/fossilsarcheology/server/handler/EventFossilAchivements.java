package fossilsarcheology.server.handler;

import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventFossilAchivements {
    @SubscribeEvent
    public void onCraftEvent(PlayerEvent.ItemCraftedEvent event) {
        EntityPlayer player = event.player;
        if (event.crafting.getItem() == Item.getItemFromBlock(FABlockRegistry.INSTANCE.analyzerIdle)) {
            player.addStat(FossilAchievementHandler.analyzer, 1);
        } else if (event.crafting.getItem() == Item.getItemFromBlock(FABlockRegistry.INSTANCE.CULTIVATE_IDLE)) {
            player.addStat(FossilAchievementHandler.cultivate, 1);
        } else if (event.crafting.getItem() == Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockSifterIdle)) {
            player.addStat(FossilAchievementHandler.sifter, 1);
        } else if (event.crafting.getItem() == Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockworktableIdle)) {
            player.addStat(FossilAchievementHandler.arcWorkbench, 1);
        } else if (event.crafting.getItem() == FAItemRegistry.INSTANCE.gem_blue) {
            player.addStat(FossilAchievementHandler.blueScarab, 1);
        } else if (event.crafting.getItem() == FAItemRegistry.INSTANCE.dinoPedia) {
            player.addStat(FossilAchievementHandler.dinopedia, 1);
        } else if (event.crafting.getItem() == FAItemRegistry.INSTANCE.gemAxe || event.crafting.getItem() == FAItemRegistry.INSTANCE.gemHoe || event.crafting.getItem() == FAItemRegistry.INSTANCE.gemSword || event.crafting.getItem() == FAItemRegistry.INSTANCE.gemPickaxe || event.crafting.getItem() == FAItemRegistry.INSTANCE.gemShovel) {
            player.addStat(FossilAchievementHandler.scarabTools, 1);
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
