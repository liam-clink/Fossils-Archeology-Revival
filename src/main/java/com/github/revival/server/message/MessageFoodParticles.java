package com.github.revival.server.message;

import com.github.revival.server.entity.mob.test.EntityNewPrehistoric;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.ilexiconn.llibrary.server.network.AbstractMessage;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityBlockDustFX;
import net.minecraft.client.particle.EntityBreakingFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;

import java.util.Random;

public class MessageFoodParticles extends AbstractMessage<MessageFoodParticles> {

    public int dinosaurID;
    public int foodItemID;
    public int blockItemID;

    public MessageFoodParticles(int dinosaurID) {
        this.dinosaurID = dinosaurID;
        foodItemID = 0;
    }

    public MessageFoodParticles(int dinosaurID, int foodItemID) {
        this.dinosaurID = dinosaurID;
        this.foodItemID = foodItemID;
    }

    public MessageFoodParticles(int dinosaurID, Block block) {
        this.dinosaurID = dinosaurID;
        this.blockItemID = Block.getIdFromBlock(block);
    }

    public MessageFoodParticles() {}

    @Override
    @SideOnly(Side.CLIENT)
    public void onClientReceived(Minecraft client, MessageFoodParticles message, EntityPlayer player, MessageContext messageContext) {
        Entity entity = player.worldObj.getEntityByID(message.dinosaurID);

        if (entity instanceof EntityNewPrehistoric) {
            EntityNewPrehistoric prehistoric = (EntityNewPrehistoric) entity;
            if (message.foodItemID == 0 && message.blockItemID == 0) {
                switch (prehistoric.selfType.diet) {
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
            } else {
                if (message.foodItemID != 0) {
                    spawnItemParticle(prehistoric, Item.getItemById(message.foodItemID));
                    spawnItemParticle(prehistoric, Item.getItemById(message.foodItemID));
                    spawnItemParticle(prehistoric, Item.getItemById(message.foodItemID));
                    spawnItemParticle(prehistoric, Item.getItemById(message.foodItemID));
                }
                if (message.blockItemID != 0) {
                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));
                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));
                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));
                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));
                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));
                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));
                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));
                    spawnBlockParticle(prehistoric, Block.getBlockById(message.blockItemID));

                }
            }

        }
    }

    public static final void spawnItemParticle(Entity entity, Item item) {
        Random rand = new Random();
        double motionX = rand.nextGaussian() * 0.07D;
        double motionY = rand.nextGaussian() * 0.07D;
        double motionZ = rand.nextGaussian() * 0.07D;
        float f = (float) (rand.nextFloat() * (entity.boundingBox.maxX - entity.boundingBox.minX) + entity.boundingBox.minX);
        float f1 = (float) (rand.nextFloat() * (entity.boundingBox.maxY - entity.boundingBox.minY) + entity.boundingBox.minY);
        float f2 = (float) (rand.nextFloat() * (entity.boundingBox.maxZ - entity.boundingBox.minZ) + entity.boundingBox.minZ);
        Minecraft.getMinecraft().effectRenderer.addEffect(new EntityBreakingFX(entity.worldObj, f, f1, f2, motionX, motionY, motionZ, item, 0));

    }

    public static final void spawnBlockParticle(Entity entity, Block block) {
        Random rand = new Random();
        double motionX = rand.nextGaussian() * 0.07D;
        double motionY = rand.nextGaussian() * 0.07D;
        double motionZ = rand.nextGaussian() * 0.07D;
        float f = (float) (rand.nextFloat() * (entity.boundingBox.maxX - entity.boundingBox.minX) + entity.boundingBox.minX);
        float f1 = (float) (rand.nextFloat() * (entity.boundingBox.maxY - entity.boundingBox.minY) + entity.boundingBox.minY);
        float f2 = (float) (rand.nextFloat() * (entity.boundingBox.maxZ - entity.boundingBox.minZ) + entity.boundingBox.minZ);
        Minecraft.getMinecraft().effectRenderer.addEffect(new EntityBlockDustFX(entity.worldObj, f, f1, f2, motionX, motionY, motionZ, block, 0));

    }

    @Override
    public void onServerReceived(MinecraftServer server, MessageFoodParticles message, EntityPlayer player, MessageContext messageContext) {

    }

    @Override
    public void fromBytes(ByteBuf buf) {
        dinosaurID = buf.readInt();
        foodItemID = buf.readInt();
        blockItemID = buf.readInt();

    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(dinosaurID);
        buf.writeInt(foodItemID);
        buf.writeInt(blockItemID);

    }
}