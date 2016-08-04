package fossilsarcheology.server.message;

import fossilsarcheology.server.entity.mob.projectile.EntityJavelin;
import io.netty.buffer.ByteBuf;
import net.ilexiconn.llibrary.server.network.AbstractMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageJavelinType extends AbstractMessage<MessageJavelinType> {

    public int javelinID;
    public int ordinal;

    public MessageJavelinType(int javelinID, int ordinal) {
        this.javelinID = javelinID;
        this.ordinal = ordinal;
    }

    public MessageJavelinType() {
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onClientReceived(Minecraft client, MessageJavelinType message, EntityPlayer player, MessageContext messageContext) {
        Entity entity = player.worldObj.getEntityByID(message.javelinID);
        if (entity instanceof EntityJavelin) {
            EntityJavelin javelin = (EntityJavelin) entity;
            javelin.material = Item.ToolMaterial.values()[message.ordinal];
        }
    }

    @Override
    public void onServerReceived(MinecraftServer server, MessageJavelinType message, EntityPlayer player, MessageContext messageContext) {
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        javelinID = buf.readInt();
        ordinal = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(javelinID);
        buf.writeInt(ordinal);
    }
}