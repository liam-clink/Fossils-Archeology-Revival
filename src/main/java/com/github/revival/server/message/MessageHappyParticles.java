package com.github.revival.server.message;

import com.github.revival.Revival;
import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.ilexiconn.llibrary.server.network.AbstractMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;

import java.util.Random;

public class MessageHappyParticles extends AbstractMessage<MessageHappyParticles> {

    public int dinosaurID;

    public MessageHappyParticles(int dinosaurID) {
        this.dinosaurID = dinosaurID;
    }

    public MessageHappyParticles() {
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onClientReceived(Minecraft client, MessageHappyParticles message, EntityPlayer player, MessageContext messageContext) {
        Entity entity = player.worldObj.getEntityByID(message.dinosaurID);

        if (entity instanceof EntityNewPrehistoric) {
            EntityNewPrehistoric prehistoric = (EntityNewPrehistoric) entity;

        }
    }

    public static final void spawnParticle(Entity entity, Item item) {
        Random rand = new Random();
        double motionX = rand.nextGaussian() * 0.07D;
        double motionY = rand.nextGaussian() * 0.07D;
        double motionZ = rand.nextGaussian() * 0.07D;
        float f = (float) (rand.nextFloat() * (entity.boundingBox.maxX - entity.boundingBox.minX) + entity.boundingBox.minX);
        float f1 = (float) (rand.nextFloat() * (entity.boundingBox.maxY - entity.boundingBox.minY) + entity.boundingBox.minY);
        float f2 = (float) (rand.nextFloat() * (entity.boundingBox.maxZ - entity.boundingBox.minZ) + entity.boundingBox.minZ);
        Revival.PROXY.spawnPacketHeartParticles(entity.worldObj, f, f1, f2, motionX, motionY, motionZ);

    }

    @Override
    public void onServerReceived(MinecraftServer server, MessageHappyParticles message, EntityPlayer player, MessageContext messageContext) {

    }

    @Override
    public void fromBytes(ByteBuf buf) {
        dinosaurID = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(dinosaurID);
    }
}