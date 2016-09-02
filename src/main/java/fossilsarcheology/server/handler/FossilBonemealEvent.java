package fossilsarcheology.server.handler;

import fossilsarcheology.server.block.BlockPalmSapling;
import fossilsarcheology.server.block.FABlockRegistry;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FossilBonemealEvent {
    @SubscribeEvent
    public void onUseBonemeal(BonemealEvent event) {
        if (event.getBlock() == FABlockRegistry.INSTANCE.palmSap) {
            if (!event.getWorld().isRemote) {
                ((BlockPalmSapling) FABlockRegistry.INSTANCE.palmSap).generateTree(event.getWorld(), event.getPos(), event.getWorld().rand);
                event.setResult(Event.Result.ALLOW);
            }
        }
    }
}
