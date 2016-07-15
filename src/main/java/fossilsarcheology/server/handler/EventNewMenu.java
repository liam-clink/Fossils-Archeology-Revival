package fossilsarcheology.server.handler;

import fossilsarcheology.Revival;
import fossilsarcheology.client.gui.GuiRevivalMenu;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;

public class EventNewMenu {
    @SubscribeEvent
    public void onGuiOpened(GuiOpenEvent event) {
        if (Revival.CONFIG.customMainMenu && event.gui instanceof GuiMainMenu && !(event.gui instanceof GuiRevivalMenu)) {
            event.gui = new GuiRevivalMenu();
        }
    }
}