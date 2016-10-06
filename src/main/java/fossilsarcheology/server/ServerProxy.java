package fossilsarcheology.server;

import fossilsarcheology.client.sound.FASoundRegistry;
import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.entity.FAEntityRegistry;
import fossilsarcheology.server.entity.prehistoric.PrehistoricEntityType;
import fossilsarcheology.server.item.FAItemRegistry;

public class ServerProxy {
    public void onPreInit() {
        FASoundRegistry.register();

        FAItemRegistry.register();
        FABlockRegistry.register();

        FAEntityRegistry.register();

        PrehistoricEntityType.register();
    }

    public void onInit() {

    }

    public void onPostInit() {

    }
}
