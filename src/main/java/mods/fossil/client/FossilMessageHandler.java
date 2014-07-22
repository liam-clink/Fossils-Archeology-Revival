package mods.fossil.client;

import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.Packet;

public class FossilMessageHandler 
{
    public Packet serverChat(NetHandlerPlayServer var1, Packet var2)
    {
        return var2;
    }

    public Packet clientChat(NetHandlerPlayServer var1, Packet var2)
    {
        return var2;
    }
}
