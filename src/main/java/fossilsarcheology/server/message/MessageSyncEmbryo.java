package fossilsarcheology.server.message;

import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import fossilsarcheology.Revival;
import fossilsarcheology.server.entity.mob.EntityPregnantCow;
import fossilsarcheology.server.entity.mob.EntityPregnantHorse;
import fossilsarcheology.server.entity.mob.EntityPregnantPig;
import fossilsarcheology.server.entity.mob.EntityPregnantSheep;
import fossilsarcheology.server.enums.EnumPrehistoric;
import fossilsarcheology.server.item.FAItemRegistry;
import io.netty.buffer.ByteBuf;
import net.ilexiconn.llibrary.server.network.AbstractMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class MessageSyncEmbryo extends AbstractMessage<MessageSyncEmbryo> {
    private int entityId;
    private EnumPrehistoric embryo;
    private int progress;

    public MessageSyncEmbryo() {
    }

    public MessageSyncEmbryo(Entity entity, EnumPrehistoric embryo, int progress) {
        this.entityId = entity.getEntityId();
        this.embryo = embryo;
        this.progress = progress;
    }

    @Override
    public void onClientReceived(Minecraft client, MessageSyncEmbryo message, EntityPlayer player, MessageContext messageContext) {
        Entity entity = client.theWorld.getEntityByID(message.entityId);
        if (entity != null && player.getHeldItem() != null && player.getHeldItem().getItem() == FAItemRegistry.INSTANCE.dinoPedia) {
            if (entity instanceof EntityHorse) {
                EntityPregnantHorse properties = EntityPregnantHorse.get((EntityHorse) entity);
                properties.embryo = this.embryo;
                properties.embryoProgress = this.progress;
            } else if (entity instanceof EntityCow) {
                EntityPregnantCow properties = EntityPregnantCow.get((EntityCow) entity);
                properties.embryo = this.embryo;
                properties.embryoProgress = this.progress;
            } else if (entity instanceof EntityPig) {
                EntityPregnantPig properties = EntityPregnantPig.get((EntityPig) entity);
                properties.embryo = this.embryo;
                properties.embryoProgress = this.progress;
            } else if (entity instanceof EntitySheep) {
                EntityPregnantSheep properties = EntityPregnantSheep.get((EntitySheep) entity);
                properties.embryo = this.embryo;
                properties.embryoProgress = this.progress;
            }
        }
    }

    @Override
    public void onServerReceived(MinecraftServer server, MessageSyncEmbryo message, EntityPlayer player, MessageContext messageContext) {
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.entityId = buf.readInt();
        this.embryo = EnumPrehistoric.values()[buf.readShort()];
        this.progress = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(entityId).writeShort(embryo.ordinal()).writeInt(progress);
    }
}
