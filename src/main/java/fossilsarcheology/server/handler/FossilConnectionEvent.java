package fossilsarcheology.server.handler;

import fossilsarcheology.Revival;
import net.ilexiconn.llibrary.server.config.ConfigHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class FossilConnectionEvent {

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;

        if (Revival.RELEASE_TYPE.enableDebugging()) {
            Revival.messagePlayer("------- DEBUG MODE IS ON. TURN OFF BEFORE RELEASING! --------", player);
        }

        switch (Revival.RELEASE_TYPE) {
            case DEVELOP:
                if (Revival.CONFIG.loginMessage) {
                    Revival.messagePlayer("You are running F/A:Revival Dev Build, " + Revival.VERSION + ".", player);
                    Revival.messagePlayer("GitHub: https://github.com/FossilsArcheologyRevival/FossilArcheology1.10", player);
                }
                return;
            case BETA:
                if (Revival.CONFIG.loginMessage) {
                    Revival.messagePlayer("You are running Fossils and Archaeology Revival " + Revival.VERSION + ".", player);
                    Revival.messagePlayer("This mod is currently in a BETA state. Be sure to backup worlds.", player);
                    Revival.messagePlayer("Forum and support: http://www.minecraftforum.net/topic/1708636-", player);
                    Revival.messagePlayer("GitHub: https://github.com/FossilsArcheologyRevival/FossilArcheology1.10", player);
                    Revival.CONFIG.loginMessage = false;
                    ConfigHandler.INSTANCE.saveConfigForID(Revival.MODID);
                }
                return;
            case RELEASE:
                if (Revival.CONFIG.loginMessage) {
                    Revival.messagePlayer("You are running Fossils and Archaeology Revival " + Revival.VERSION + ".", player);
                    Revival.messagePlayer("Forum and support: http://www.minecraftforum.net/topic/1708636-", player);
                    Revival.messagePlayer("GitHub: https://github.com/FossilsArcheologyRevival/FossilArcheology1.10", player);
                    Revival.CONFIG.loginMessage = false;
                    ConfigHandler.INSTANCE.saveConfigForID(Revival.MODID);
                }
                return;
            default:
        }
    }
}
