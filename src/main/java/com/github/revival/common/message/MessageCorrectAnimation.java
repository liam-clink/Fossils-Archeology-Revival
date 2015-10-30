package com.github.revival.common.message;

import io.netty.buffer.ByteBuf;
import net.ilexiconn.llibrary.common.animation.IAnimated;
import net.ilexiconn.llibrary.common.message.AbstractMessage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;

public class MessageCorrectAnimation extends AbstractMessage<MessageCorrectAnimation>{
	
	private byte animID;
	private int entityID;
	
	public MessageCorrectAnimation() {
	}
	
	public MessageCorrectAnimation(byte anim, int entity) {
		animID = anim;
		entityID = entity;
	}
	
	@Override
	public void toBytes( ByteBuf buffer) {
		buffer.writeByte(animID);
		buffer.writeInt(entityID);
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		animID = buffer.readByte();
		entityID = buffer.readInt();
	}

	@Override
	public void handleClientMessage(MessageCorrectAnimation message, EntityPlayer player) {
		 IAnimated entity = (IAnimated) player.worldObj.getEntityByID(message.entityID);
	        if (entity != null && message.animID != 0)
	        {
	            entity.setAnimation(entity.animations()[message.animID]);
	            entity.setAnimationTick(0);
	        }
	}

	@Override
	public void handleServerMessage(MessageCorrectAnimation message, EntityPlayer player) {
		
	}
}
