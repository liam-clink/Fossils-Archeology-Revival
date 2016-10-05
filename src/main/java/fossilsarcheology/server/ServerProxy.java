package fossilsarcheology.server;

import fossilsarcheology.server.item.FAItemRegistry;

public class ServerProxy {
    public void onPreInit() {
        FAItemRegistry.register();
    }

    public void onInit() {

    }

    public void onPostInit() {

    }
}
