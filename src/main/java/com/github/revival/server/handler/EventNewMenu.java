package com.github.revival.server.handler;

import com.github.revival.Revival;
import com.github.revival.client.gui.GuiFAMainMenu;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;

public class EventNewMenu {
    @SubscribeEvent
    public void onGuiOpened(GuiOpenEvent event) {
        if (Revival.CONFIG.customMainMenu && event.gui instanceof GuiMainMenu && !(event.gui instanceof GuiFAMainMenu)) {
            event.gui = new GuiFAMainMenu();
        }
    }
}