package com.github.revival.server.handler;

import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.item.FAItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class FossilOreDictionary {
    public static void oreRegistration() {
        OreDictionary.registerOre("plankWood", new ItemStack(FABlockRegistry.palaePlanks));
        OreDictionary.registerOre("logWood", new ItemStack(FABlockRegistry.palmLog));
        OreDictionary.registerOre("treeLeaves", new ItemStack(FABlockRegistry.palmLeaves));
        OreDictionary.registerOre("slabWood", new ItemStack(FABlockRegistry.palaeSingleSlab));
        OreDictionary.registerOre("stairWood", new ItemStack(FABlockRegistry.palaeStairs));
        OreDictionary.registerOre("treeSapling", new ItemStack(FABlockRegistry.palmSap));
        OreDictionary.registerOre("record", new ItemStack(FAItemRegistry.fossilrecordBones));
        OreDictionary.registerOre("oreFossil", new ItemStack(FABlockRegistry.blockFossil));

        OreDictionary.registerOre("artifact", new ItemStack(FAItemRegistry.relic));
        OreDictionary.registerOre("fossil", new ItemStack(FAItemRegistry.biofossil));
        OreDictionary.registerOre("gemScarab", new ItemStack(FAItemRegistry.gem));
        OreDictionary.registerOre("gemScarabBlue", new ItemStack(FAItemRegistry.gem_blue));
        OreDictionary.registerOre("dinosaurClaw", new ItemStack(FAItemRegistry.claw, 1, 1));
        OreDictionary.registerOre("dinosaurClaw", new ItemStack(FAItemRegistry.claw, 1, 8));
        OreDictionary.registerOre("dinosaurClaw", new ItemStack(FAItemRegistry.claw, 1, 11));
        OreDictionary.registerOre("dinosaurClaw", new ItemStack(FAItemRegistry.claw, 1, 14));
        OreDictionary.registerOre("dinosaurClaw", new ItemStack(FAItemRegistry.claw, 1, 15));

        OreDictionary.registerOre("dinosaurSkull", new ItemStack(FAItemRegistry.skull, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("dinosaurLegBone", new ItemStack(FAItemRegistry.legBone, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("dinosaurArmBone", new ItemStack(FAItemRegistry.armBone, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("dinosaurVertebrae", new ItemStack(FAItemRegistry.vertebrae, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("dinosaurRibCage", new ItemStack(FAItemRegistry.dinoRibCage, 1, OreDictionary.WILDCARD_VALUE));

        //OreDictionary.registerOre("foodEgg", FAItemRegistry.dodoEgg);
        //OreDictionary.registerOre("foodEgg", FAItemRegistry.cultivatedDodoEgg);
        //OreDictionary.registerOre("foodEgg", new ItemStack(FAItemRegistry.terrorBirdEgg, 1, OreDictionary.WILDCARD_VALUE));

        //for (int i = 0; i < EnumPrehistoric.values().length; i++)
        //    OreDictionary.registerOre("foodEgg", EnumPrehistoric.values()[i].eggItem);


    }
}
