package com.github.revival.server.message;

import io.netty.buffer.ByteBuf;
import net.ilexiconn.llibrary.server.network.AbstractMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import com.github.revival.server.entity.mob.EntityNautilus;

import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageUpdateNautilus extends AbstractMessage<MessageUpdateNautilus> {

	public int dinosaurID;
	public boolean isInShell;

	public MessageUpdateNautilus(int dinosaurID, boolean isInShell) {
		this.dinosaurID = dinosaurID;
		this.isInShell = isInShell;
	}

	public MessageUpdateNautilus() {
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onClientReceived(Minecraft client, MessageUpdateNautilus message, EntityPlayer player, MessageContext messageContext) {
		Entity entity = player.worldObj.getEntityByID(message.dinosaurID);

		if (entity instanceof EntityNautilus) {
			EntityNautilus prehistoric = (EntityNautilus) entity;
			prehistoric.isInShell = message.isInShell;
		}
	}

	@Override
	public void onServerReceived(MinecraftServer server, MessageUpdateNautilus message, EntityPlayer player, MessageContext messageContext) {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		dinosaurID = buf.readInt();
		isInShell = buf.readBoolean();

	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(dinosaurID);
		buf.writeBoolean(isInShell);
	}
}