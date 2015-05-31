package mods.fossil.handler;

import mods.fossil.Fossil;
import mods.fossil.gens.feature.WorldGenAnuCastle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class FossilConnectionEvent {

	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
		EntityPlayer player = event.player;

		if(Fossil.DebugMode())
		{
            Fossil.ShowMessage("------- DEBUG MODE IS ON. TURN OFF BEFORE RELEASING! --------",player);
		}
		
        switch (Fossil.modState)
        {
            case 0:

                if (Fossil.FossilOptions.LoginMessage)
                {
                    Fossil.ShowMessage("You are running F/A:Revival Dev Build, " + Fossil.modversion + ".",player);
                    Fossil.ShowMessage("Github: https://github.com/FossilsArcheologyRevival/FossilArcheology1.7", player);
                }
            return;

            case 1:
                if (Fossil.FossilOptions.LoginMessage)
                {
                Fossil.ShowMessage("You are running Fossils and Archaeology Revival " + Fossil.modversion + ".", player);
                Fossil.ShowMessage("This mod is currently in a BETA state. Be sure to backup worlds.", player);
                Fossil.ShowMessage("Forum and support: http://www.minecraftforum.net/topic/1708636-", player);
                Fossil.ShowMessage("Github: https://github.com/FossilsArcheologyRevival/FossilArcheology1.7", player);
                Fossil.instance.config.load();
                Fossil.instance.config.get("option", "Display_Login_Message", false).set(false);
                Fossil.instance.config.save();
                }
                return;

            case 2:
                if (Fossil.FossilOptions.LoginMessage)
                {
                    Fossil.ShowMessage("You are running Fossils and Archaeology Revival " + Fossil.modversion + ".", player);
                    Fossil.ShowMessage("Forum and support: http://www.minecraftforum.net/topic/1708636-", player);
                    Fossil.ShowMessage("Github: https://github.com/FossilsArcheologyRevival/FossilArcheology1.7", player);
                    Fossil.instance.config.load();
                    Fossil.instance.config.get("option", "Display_Login_Message", false).set(false);
                    Fossil.instance.config.save();
                }
                return;

            default:
                return;
        }
	}
	
}
