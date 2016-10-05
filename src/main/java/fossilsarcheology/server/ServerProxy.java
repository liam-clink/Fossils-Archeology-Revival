package fossilsarcheology.server;

import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.entity.prehistoric.PrehistoricEntityType;
import fossilsarcheology.server.item.FAItemRegistry;

public class ServerProxy {
    public void onPreInit() {
        FAItemRegistry.register();
        FABlockRegistry.register();

        PrehistoricEntityType.register();
    }

    public void onInit() {

    }

    public void onPostInit() {

    }
}
