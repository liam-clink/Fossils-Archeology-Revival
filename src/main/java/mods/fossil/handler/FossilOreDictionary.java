package mods.fossil.handler;

import mods.fossil.Fossil;
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
    }
}
