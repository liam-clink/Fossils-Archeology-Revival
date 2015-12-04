package com.github.revival.common.message;

import io.netty.buffer.ByteBuf;
import net.ilexiconn.llibrary.common.animation.IAnimated;
import net.ilexiconn.llibrary.common.message.AbstractMessage;
import net.minecraft.entity.player.EntityPlayer;

import com.github.revival.common.entity.mob.test.EntityNewPrehistoric;

public class MessageDinoSit extends AbstractMessage<MessageDinoSit>{
	
	private int entityID;

	public MessageDinoSit() {
	}
	
	public MessageDinoSit(int entity) {
		entityID = entity;
	}
	
	@Override
	public void toBytes( ByteBuf buffer) {
		buffer.writeInt(entityID);
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		entityID = buffer.readInt();
	}

	@Override
	public void handleClientMessage(MessageDinoSit message, EntityPlayer player) {
		 EntityNewPrehistoric entity = (EntityNewPrehistoric)player.worldObj.getEntityByID(message.entityID);
	        if (entity != null && entity.isSitting())
	        {
	            entity.setSitting(true);
	        }
	        if (entity != null && entity.isSitting())
	        {
	            entity.setSitting(false);
	        }
	        if (entity != null && entity.isSleeping())
	        {
	            entity.setSleeping(1);
	        }
	        if (entity != null && entity.isSleeping())
	        {
	            entity.setSleeping(0);
	        }
	}

	@Override
	public void handleServerMessage(MessageDinoSit message, EntityPlayer player) {}
}
