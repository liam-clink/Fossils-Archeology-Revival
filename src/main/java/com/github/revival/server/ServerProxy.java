package com.github.revival.server;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.item.FAItemRegistry;

public class ServerProxy {
    public void init() {

    }

    public ModelBiped getArmorModel(int id) {
        return null;
    }

    public void registerChestLoot() {
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent((new ItemStack(FABlockRegistry.INSTANCE.figurineBlock, 1, new Random().nextInt(16))), 1, 1, 5));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(FAItemRegistry.INSTANCE.gem), 1, 1, 1));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(FAItemRegistry.INSTANCE.whip), 1, 1, 50));
        ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(FAItemRegistry.INSTANCE.biofossil), 3, 9, 10));
        ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(FAItemRegistry.INSTANCE.biofossil), 3, 12, 40));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(FAItemRegistry.INSTANCE.fossilrecordBones), 1, 1, 5));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(FAItemRegistry.INSTANCE.fossilrecordBones), 1, 1, 5));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(FAItemRegistry.INSTANCE.fossilrecordBones), 1, 1, 5));
    }

    public void playSound(String soundName) {

    }

    public void stopSound() {

    }

    public void spawnAnuParticle(World world, double posX, double posY, double posZ) {
    }

    public void spawnSleepParticle(World world, double posX, double posY, double posZ) {
    }

    public void animate(int animateID) {
    }

    public void doChainBuffer(Object buffer, EntityLivingBase entity) {
    }

    public Object getChainBuffer(int tailsegments) {
        return null;
    }

    public void spawnTarParticle(World world, double posX, double posY, double posZ) {
    }
    
    public void spawnPacketHeartParticles(World world, float f, float f1, float f2, double motionX, double motionY, double motionZ){}
    
    public void spawnPacketItemParticles(World world, float f, float f1, float f2, double motionX, double motionY, double motionZ, Item item){}
    
    public void spawnPacketBlockParticles(World world, float f, float f1, float f2, double motionX, double motionY, double motionZ, Block block){}
}
