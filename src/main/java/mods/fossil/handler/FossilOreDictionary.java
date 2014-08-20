package mods.fossil.handler;

import mods.fossil.Fossil;
import mods.fossil.fossilEnums.EnumDinoType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class FossilOreDictionary
{
    public static void oreRegistration()
    {
        OreDictionary.registerOre("plankWood", new ItemStack(Fossil.palaePlanks));
        OreDictionary.registerOre("logWood", new ItemStack(Fossil.palmLog));
        OreDictionary.registerOre("treeLeaves", new ItemStack(Fossil.palmLeaves));
        OreDictionary.registerOre("slabWood", new ItemStack(Fossil.palaeSingleSlab));
        OreDictionary.registerOre("stairWood", new ItemStack(Fossil.palaeStairs));
        OreDictionary.registerOre("treeSapling", new ItemStack(Fossil.palmSap));
        OreDictionary.registerOre("record", new ItemStack(Fossil.fossilrecordBones));
        OreDictionary.registerOre("oreFossil", new ItemStack(Fossil.biofossil));
        
        OreDictionary.registerOre("dinosaurClaw", new ItemStack(Fossil.claw,1, 1));
        OreDictionary.registerOre("dinosaurClaw", new ItemStack(Fossil.claw,1, 8));
        OreDictionary.registerOre("dinosaurClaw", new ItemStack(Fossil.claw,1, 11));
        OreDictionary.registerOre("dinosaurClaw", new ItemStack(Fossil.claw,1, 14));
        OreDictionary.registerOre("dinosaurClaw", new ItemStack(Fossil.claw,1, 15));
        
        OreDictionary.registerOre("dinosaurSkull", new ItemStack(Fossil.skull,1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("dinosaurLegBone", new ItemStack(Fossil.legBone,1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("dinosaurArmBone", new ItemStack(Fossil.armBone,1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("dinosaurVertebrae", new ItemStack(Fossil.vertebrae,1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("dinosaurRibCage", new ItemStack(Fossil.ribCage,1, OreDictionary.WILDCARD_VALUE));
        
        OreDictionary.registerOre("foodEgg", Fossil.dodoEgg);
        OreDictionary.registerOre("foodEgg", Fossil.cultivatedDodoEgg);
        OreDictionary.registerOre("foodEgg", new ItemStack(Fossil.terrorBirdEgg, 1, OreDictionary.WILDCARD_VALUE));
        
        for (int i = 0; i < EnumDinoType.values().length; i++)
        OreDictionary.registerOre("foodEgg", EnumDinoType.values()[i].EggItem);


    }
}
