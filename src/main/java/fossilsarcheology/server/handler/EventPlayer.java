package fossilsarcheology.server.handler;

import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.FossilPlayerProperties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventPlayer {
    @SubscribeEvent
    public void onEntityConstructing(EntityConstructing event) {
        Entity entity = event.getEntity();
        if (entity instanceof EntityPlayer) {
            FossilPlayerProperties.register((EntityPlayer) entity);
        }
    }

    @SubscribeEvent
    public void onBreakBlock(BlockEvent.BreakEvent event) {
        if (event.getWorld().provider.getDimension() == Revival.CONFIG.dimensionIDDarknessLair && event.getState().getBlock() != Blocks.OBSIDIAN && !FossilPlayerProperties.get(event.getPlayer()).isKilledAnu()) {
            Revival.messagePlayer(I18n.translateToLocal("anu.breakblock"), event.getPlayer());
            event.setCanceled(true);
        }
    }

}
