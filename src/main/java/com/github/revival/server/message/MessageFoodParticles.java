package com.github.revival.server.message;

import io.netty.buffer.ByteBuf;

import java.util.Random;

import net.ilexiconn.llibrary.common.message.AbstractMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityBreakingFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;

public class MessageFoodParticles extends AbstractMessage<MessageFoodParticles>{

	public int dinosaurID;

	public MessageFoodParticles(int dinosaurID)
	{
		this.dinosaurID = dinosaurID;
	}

	public MessageFoodParticles()
	{
	}

	public void handleClientMessage(MessageFoodParticles message, EntityPlayer player)
	{
		Entity entity = player.worldObj.getEntityByID(message.dinosaurID);
		
		if(entity instanceof EntityNewPrehistoric){
			EntityNewPrehistoric prehistoric = (EntityNewPrehistoric)entity;
			switch(prehistoric.selfType.diet){
			case HERBIVORE:	
				spawnItemParticle(prehistoric, Items.reeds);
				spawnItemParticle(prehistoric, Items.reeds);
				spawnItemParticle(prehistoric, Items.reeds);
				spawnItemParticle(prehistoric, Items.reeds);
				break;
			case OMNIVORE:
				spawnItemParticle(prehistoric, Items.bread);
				spawnItemParticle(prehistoric, Items.bread);
				spawnItemParticle(prehistoric, Items.bread);
				spawnItemParticle(prehistoric, Items.bread);
				break;
			default:
				spawnItemParticle(prehistoric, Items.beef);
				spawnItemParticle(prehistoric, Items.beef);
				spawnItemParticle(prehistoric, Items.beef);
				spawnItemParticle(prehistoric, Items.beef);
				break;

			}
			
		}
	}

	public static final void spawnItemParticle(Entity entity, Item item){
		System.out.println("i");
		Random rand = new Random();
		double motionX = rand.nextGaussian() * 0.07D;
		double motionY = rand.nextGaussian() * 0.07D;
		double motionZ = rand.nextGaussian() * 0.07D;
		float f = (float)(rand.nextFloat() * (entity.boundingBox.maxX - entity.boundingBox.minX) + entity.boundingBox.minX);
		float f1 = (float)(rand.nextFloat() * (entity.boundingBox.maxY - entity.boundingBox.minY) + entity.boundingBox.minY);
		float f2 = (float)(rand.nextFloat() * (entity.boundingBox.maxZ - entity.boundingBox.minZ) + entity.boundingBox.minZ);
		Minecraft.getMinecraft().effectRenderer.addEffect(new EntityBreakingFX(entity.worldObj, f, f1, f2, motionX, motionY, motionZ, item, 0));

	}

	public void handleServerMessage(MessageFoodParticles message, EntityPlayer player)
	{

	}

	public void fromBytes(ByteBuf buf)
	{
		dinosaurID = buf.readInt();
	}

	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(dinosaurID);
	}
}