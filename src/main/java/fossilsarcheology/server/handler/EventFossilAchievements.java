package fossilsarcheology.server.handler;

import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventFossilAchievements {
    @SubscribeEvent
    public void onCraftEvent(PlayerEvent.ItemCraftedEvent event) {
        EntityPlayer player = event.player;
        Item item = event.crafting.getItem();
        if (item == Item.getItemFromBlock(FABlockRegistry.INSTANCE.analyzerIdle)) {
            player.addStat(FossilAchievementHandler.analyzer, 1);
        } else if (item == Item.getItemFromBlock(FABlockRegistry.INSTANCE.CULTIVATE_IDLE)) {
            player.addStat(FossilAchievementHandler.cultivate, 1);
        } else if (item == Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockSifterIdle)) {
            player.addStat(FossilAchievementHandler.sifter, 1);
        } else if (item == Item.getItemFromBlock(FABlockRegistry.INSTANCE.blockworktableIdle)) {
            player.addStat(FossilAchievementHandler.arcWorkbench, 1);
        } else if (item == FAItemRegistry.INSTANCE.gem_blue) {
            player.addStat(FossilAchievementHandler.blueScarab, 1);
        } else if (item == FAItemRegistry.INSTANCE.dinoPedia) {
            player.addStat(FossilAchievementHandler.dinopedia, 1);
        } else if (item == FAItemRegistry.INSTANCE.gemAxe || item == FAItemRegistry.INSTANCE.gemHoe || item == FAItemRegistry.INSTANCE.gemSword || item == FAItemRegistry.INSTANCE.gemPickaxe || item == FAItemRegistry.INSTANCE.gemShovel) {
            player.addStat(FossilAchievementHandler.scarabTools, 1);
        }
    }

    @SubscribeEvent
    public void onItemEvent(PlayerEvent.ItemPickupEvent event) {
        ItemStack pickedUp = event.pickedUp.getEntityItem();
        if (pickedUp.getItem() == FAItemRegistry.INSTANCE.gem) {
            event.player.addStat(FossilAchievementHandler.scarab, 1);
        }
        if (pickedUp.getItem() == FAItemRegistry.INSTANCE.ancientKey) {
            event.player.addStat(FossilAchievementHandler.key, 1);
        }
        if (pickedUp.getItem() == FAItemRegistry.INSTANCE.ancientClock) {
            event.player.addStat(FossilAchievementHandler.clock, 1);
        }
    }
}
