package com.github.revival.server.handler;

import com.github.revival.Revival;
import com.github.revival.server.config.FossilConfig;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.ilexiconn.llibrary.server.config.ConfigHandler;
import net.minecraft.entity.player.EntityPlayer;

public class FossilConnectionEvent {

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;

        if (Revival.enableDebugging()) {
            Revival.showMessage("------- DEBUG MODE IS ON. TURN OFF BEFORE RELEASING! --------", player);
        }

        switch (Revival.STATE) {
            case DEV:

                if (Revival.CONFIG.loginMessage) {
                    Revival.showMessage("You are running F/A:Revival Dev Build, " + Revival.VERSION + ".", player);
                    Revival.showMessage("Github: https://github.com/FossilsArcheologyRevival/FossilArcheology1.7", player);
                }
                return;

            case BETA:
                if (Revival.CONFIG.loginMessage) {
                    Revival.showMessage("You are running Fossils and Archaeology Revival " + Revival.VERSION + ".", player);
                    Revival.showMessage("This mod is currently in a BETA state. Be sure to backup worlds.", player);
                    Revival.showMessage("Forum and support: http://www.minecraftforum.net/topic/1708636-", player);
                    Revival.showMessage("Github: https://github.com/FossilsArcheologyRevival/FossilArcheology1.7", player);
                    Revival.CONFIG.loginMessage = false;
                    ConfigHandler.INSTANCE.saveConfigForID(Revival.MODID);
                }
                return;

            case RELEASE:
                if (Revival.CONFIG.loginMessage) {
                    Revival.showMessage("You are running Fossils and Archaeology Revival " + Revival.VERSION + ".", player);
                    Revival.showMessage("Forum and support: http://www.minecraftforum.net/topic/1708636-", player);
                    Revival.showMessage("Github: https://github.com/FossilsArcheologyRevival/FossilArcheology1.7", player);
                    Revival.CONFIG.loginMessage = false;
                    ConfigHandler.INSTANCE.saveConfigForID(Revival.MODID);
                }
                return;

            default:
                return;
        }
    }

}
