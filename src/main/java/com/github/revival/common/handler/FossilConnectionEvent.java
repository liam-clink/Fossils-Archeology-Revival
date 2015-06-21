package com.github.revival.common.handler;

import com.github.revival.Revival;
import com.github.revival.common.config.FossilConfig;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayer;

public class FossilConnectionEvent
{

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
    {
        EntityPlayer player = event.player;

        if (Revival.enableDebugging())
        {
            Revival.ShowMessage("------- DEBUG MODE IS ON. TURN OFF BEFORE RELEASING! --------", player);
        }

        switch (Revival.modState)
        {
            case DEV:

                if (FossilConfig.loginMessage)
                {
                    Revival.ShowMessage("You are running F/A:Revival Dev Build, ${version}.", player);
                    Revival.ShowMessage("Github: https://github.com/FossilsArcheologyRevival/FossilArcheology1.7", player);
                }
                return;

            case BETA:
                if (FossilConfig.loginMessage)
                {
                    Revival.ShowMessage("You are running Fossils and Archaeology Revival ${version}.", player);
                    Revival.ShowMessage("This mod is currently in a BETA state. Be sure to backup worlds.", player);
                    Revival.ShowMessage("Forum and support: http://www.minecraftforum.net/topic/1708636-", player);
                    Revival.ShowMessage("Github: https://github.com/FossilsArcheologyRevival/FossilArcheology1.7", player);
                    Revival.instance.config.load();
                    Revival.instance.config.get("option", "Display_Login_Message", false).set(false);
                    Revival.instance.config.save();
                }
                return;

            case RELEASE:
                if (FossilConfig.loginMessage)
                {
                    Revival.ShowMessage("You are running Fossils and Archaeology Revival ${version}.", player);
                    Revival.ShowMessage("Forum and support: http://www.minecraftforum.net/topic/1708636-", player);
                    Revival.ShowMessage("Github: https://github.com/FossilsArcheologyRevival/FossilArcheology1.7", player);
                    Revival.instance.config.load();
                    Revival.instance.config.get("option", "Display_Login_Message", false).set(false);
                    Revival.instance.config.save();
                }
                return;

            default:
                return;
        }
    }

}
