package fossilsarcheology.server.handler;

import fossilsarcheology.Revival;
import fossilsarcheology.client.gui.FAMainMenuGUI;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventNewMenu {
    @SubscribeEvent
    public void onGuiOpened(GuiOpenEvent event) {
        if (Revival.CONFIG.customMainMenu && event.gui instanceof GuiMainMenu && !(event.gui instanceof FAMainMenuGUI)) {
            event.gui = new FAMainMenuGUI();
        }
    }
}