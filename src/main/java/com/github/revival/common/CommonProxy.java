package com.github.revival.common;

import com.github.revival.common.block.FABlockRegistry;
import com.github.revival.common.item.FAItemRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

import java.util.Random;

public class CommonProxy
{
    public void init()
    {
        Blocks.fire.setFireInfo(FABlockRegistry.palmLeaves, 30, 60);
        Blocks.fire.setFireInfo(FABlockRegistry.palmLog, 5, 20);
        Blocks.fire.setFireInfo(FABlockRegistry.palaePlanks, 5, 20);
        Blocks.fire.setFireInfo(FABlockRegistry.palaeStairs, 5, 20);
        Blocks.fire.setFireInfo(FABlockRegistry.palaeSingleSlab, 5, 20);
        Blocks.fire.setFireInfo(FABlockRegistry.palaeDoubleSlab, 5, 20);
        Blocks.fire.setFireInfo(FABlockRegistry.blockworktableIdle, 5, 20);
        Blocks.fire.setFireInfo(FABlockRegistry.blockworktableActive, 5, 20);
        Blocks.fire.setFireInfo(FABlockRegistry.ancientWood, 5, 20);
        Blocks.fire.setFireInfo(FABlockRegistry.ancientWoodPillar, 5, 20);
        Blocks.fire.setFireInfo(FABlockRegistry.ancientWoodPlate, 5, 20);
        Blocks.fire.setFireInfo(FABlockRegistry.ancientWoodStairs, 5, 20);
        Blocks.fire.setFireInfo(FABlockRegistry.ancientWoodSingleSlab, 5, 20);
        Blocks.fire.setFireInfo(FABlockRegistry.ancientWoodDoubleSlab, 5, 20);
        Blocks.fire.setFireInfo(FABlockRegistry.ferns, 30, 60);
        Blocks.fire.setFireInfo(FABlockRegistry.bennettitales_large, 60, 100);
        Blocks.fire.setFireInfo(FABlockRegistry.bennettitales_small, 60, 100);
        Blocks.fire.setFireInfo(FABlockRegistry.cephalotaxus, 60, 100);
        Blocks.fire.setFireInfo(FABlockRegistry.dillhoffia, 60, 100);
        Blocks.fire.setFireInfo(FABlockRegistry.horsetail_large, 60, 100);
        Blocks.fire.setFireInfo(FABlockRegistry.horsetail_small, 60, 100);
        Blocks.fire.setFireInfo(FABlockRegistry.licopodiophyta, 60, 100);
        Blocks.fire.setFireInfo(FABlockRegistry.mutantPlant, 60, 100);
        Blocks.fire.setFireInfo(FABlockRegistry.paleopanax, 60, 100);
        Blocks.fire.setFireInfo(FABlockRegistry.sarracina, 60, 100);
        Blocks.fire.setFireInfo(FABlockRegistry.welwitschia, 60, 100);
        Blocks.fire.setFireInfo(FABlockRegistry.zamites, 60, 100);
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

    public void spawnAnuParticle(World world, double posX, double posY, double posZ)
    {

    }

	public void animate(int animateID) {}
}
