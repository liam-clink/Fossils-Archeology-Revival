package com.github.revival.common;

import java.util.Random;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

import com.github.revival.common.block.FABlockRegistry;
import com.github.revival.common.item.FAItemRegistry;

public class CommonProxy
{
    public void init()
    {
      
    }

    public ModelBiped getArmorModel(int id)
    {
        return null;
    }

    public void registerChestLoot()
    {
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent((new ItemStack(FABlockRegistry.figurineBlock, 1, new Random().nextInt(16))), 1, 1, 5));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(FAItemRegistry.gem), 1, 1, 1));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(FAItemRegistry.whip), 1, 1, 50));
        ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(FAItemRegistry.biofossil), 3, 9, 10));
        ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(FAItemRegistry.biofossil), 3, 12, 40));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(FAItemRegistry.fossilrecordBones), 1, 1, 5));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(FAItemRegistry.fossilrecordBones), 1, 1, 5));
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(FAItemRegistry.fossilrecordBones), 1, 1, 5));
    }

    public void playSound(String soundName)
    {

    }

    public void stopSound()
    {

    }

    public void spawnAnuParticle(World world, double posX, double posY, double posZ){}

	public void spawnSleepParticle(World world, double posX, double posY, double posZ){}

	public void animate(int animateID) {}
	
	public void doChainBuffer(Object buffer, EntityLivingBase entity){}
	
	public Object getChainBuffer(int tailsegments){
		return null;
	}

	public void spawnTarParticle(World world, double posX, double posY, double posZ){}
}
