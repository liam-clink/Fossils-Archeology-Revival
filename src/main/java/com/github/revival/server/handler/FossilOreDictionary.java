package com.github.revival.server.handler;

import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.item.FAItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class FossilOreDictionary {
    public static void oreRegistration() {
        OreDictionary.registerOre("plankWood", new ItemStack(FABlockRegistry.INSTANCE.palaePlanks));
        OreDictionary.registerOre("logWood", new ItemStack(FABlockRegistry.INSTANCE.palmLog));
        OreDictionary.registerOre("treeLeaves", new ItemStack(FABlockRegistry.INSTANCE.palmLeaves));
        OreDictionary.registerOre("slabWood", new ItemStack(FABlockRegistry.INSTANCE.palaeSingleSlab));
        OreDictionary.registerOre("stairWood", new ItemStack(FABlockRegistry.INSTANCE.palaeStairs));
        OreDictionary.registerOre("treeSapling", new ItemStack(FABlockRegistry.INSTANCE.palmSap));
        OreDictionary.registerOre("record", new ItemStack(FAItemRegistry.INSTANCE.fossilrecordBones));
        OreDictionary.registerOre("oreFossil", new ItemStack(FABlockRegistry.INSTANCE.blockFossil));

        OreDictionary.registerOre("artifact", new ItemStack(FAItemRegistry.INSTANCE.relic));
        OreDictionary.registerOre("fossil", new ItemStack(FAItemRegistry.INSTANCE.biofossil));
        OreDictionary.registerOre("gemScarab", new ItemStack(FAItemRegistry.INSTANCE.gem));
        OreDictionary.registerOre("gemScarabBlue", new ItemStack(FAItemRegistry.INSTANCE.gem_blue));
        OreDictionary.registerOre("dinosaurClaw", new ItemStack(FAItemRegistry.INSTANCE.claw, 1, 1));
        OreDictionary.registerOre("dinosaurClaw", new ItemStack(FAItemRegistry.INSTANCE.claw, 1, 8));
        OreDictionary.registerOre("dinosaurClaw", new ItemStack(FAItemRegistry.INSTANCE.claw, 1, 11));
        OreDictionary.registerOre("dinosaurClaw", new ItemStack(FAItemRegistry.INSTANCE.claw, 1, 14));
        OreDictionary.registerOre("dinosaurClaw", new ItemStack(FAItemRegistry.INSTANCE.claw, 1, 15));

        OreDictionary.registerOre("dinosaurSkull", new ItemStack(FAItemRegistry.INSTANCE.skull, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("dinosaurLegBone", new ItemStack(FAItemRegistry.INSTANCE.legBone, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("dinosaurArmBone", new ItemStack(FAItemRegistry.INSTANCE.armBone, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("dinosaurVertebrae", new ItemStack(FAItemRegistry.INSTANCE.vertebrae, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("dinosaurRibCage", new ItemStack(FAItemRegistry.INSTANCE.dinoRibCage, 1, OreDictionary.WILDCARD_VALUE));

        //OreDictionary.registerOre("foodEgg", FAItemRegistry.INSTANCE.dodoEgg);
        //OreDictionary.registerOre("foodEgg", FAItemRegistry.INSTANCE.cultivatedDodoEgg);
        //OreDictionary.registerOre("foodEgg", new ItemStack(FAItemRegistry.INSTANCE.terrorBirdEgg, 1, OreDictionary.WILDCARD_VALUE));

        //for (int i = 0; i < EnumPrehistoric.values().length; i++)
        //    OreDictionary.registerOre("foodEgg", EnumPrehistoric.values()[i].eggItem);


    }
}
