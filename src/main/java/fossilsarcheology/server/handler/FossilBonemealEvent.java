package fossilsarcheology.server.handler;

import fossilsarcheology.server.block.BlockPalmSapling;
import fossilsarcheology.server.block.FABlockRegistry;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FossilBonemealEvent {
    @SubscribeEvent
    public void onUseBonemeal(BonemealEvent event) {
        if (event.block == FABlockRegistry.INSTANCE.palmSap) {
            if (!event.world.isRemote) {
                ((BlockPalmSapling) FABlockRegistry.INSTANCE.palmSap).generateTree(event.world, event.x, event.y, event.z, event.world.rand);
                event.setResult(Event.Result.ALLOW);
            }
        }
    }
}
