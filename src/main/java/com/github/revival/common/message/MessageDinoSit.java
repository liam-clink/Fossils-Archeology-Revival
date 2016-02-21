package com.github.revival.common.message;

import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;
import io.netty.buffer.ByteBuf;
import net.ilexiconn.llibrary.common.message.AbstractMessage;
import net.minecraft.entity.player.EntityPlayer;

public class MessageDinoSit extends AbstractMessage<MessageDinoSit> {

    private int entityID;
    private float sitProgress;

    public MessageDinoSit() {
    }

    public MessageDinoSit(int entityID, float sitProgress) {
        this.entityID = entityID;
        this.sitProgress = sitProgress;
    }

    @Override
    public void toBytes(ByteBuf buffer) {
        buffer.writeInt(entityID);
        buffer.writeFloat(sitProgress);
    }

    @Override
    public void fromBytes(ByteBuf buffer) {
        entityID = buffer.readInt();
        sitProgress = buffer.readFloat();
    }

    @Override
    public void handleClientMessage(MessageDinoSit message, EntityPlayer player) {
    }

    @Override
    public void handleServerMessage(MessageDinoSit message, EntityPlayer player) {
        EntityNewPrehistoric entity = (EntityNewPrehistoric) player.worldObj.getEntityByID(message.entityID);
        if (entity != null) {
            entity.sitProgress = message.sitProgress;
            if (entity.sitProgress > 0) {
                entity.setSitting(true);
            } else {
                entity.setSitting(false);
            }
        }
    }
}
