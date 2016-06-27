package fossilsarcheology.server.handler;

import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.FossilPlayerProperites;
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
        FossilPlayerProperites.get(event.original).saveNBTData(compound);
        FossilPlayerProperites.get(event.entityPlayer).loadNBTData(compound);
    }

    @SubscribeEvent
    public void onEntityConstructing(EntityConstructing event) {
        if (event.entity instanceof EntityPlayer && FossilPlayerProperites.get((EntityPlayer) event.entity) == null) {
            FossilPlayerProperites.register((EntityPlayer) event.entity);
        }
        if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(FossilPlayerProperites.EXT_PROP_NAME) == null) {
            event.entity.registerExtendedProperties(FossilPlayerProperites.EXT_PROP_NAME, new FossilPlayerProperites((EntityPlayer) event.entity));
        }
    }

    @SubscribeEvent
    public void onBreakBlock(BlockEvent.BreakEvent event) {
        if (event.world.provider.dimensionId == Revival.CONFIG.dimensionIDDarknessLair && event.block != Blocks.obsidian && !FossilPlayerProperites.get(event.getPlayer()).isKilledAnu()) {
            Revival.messagePlayer(StatCollector.translateToLocal("anu.breakblock"), event.getPlayer());
            event.setCanceled(true);
        }
    }

}
