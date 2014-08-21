package mods.fossil.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.fossil.Fossil;
import mods.fossil.fossilEnums.EnumDinoType;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class FossilRecipeHandler
{
    public static void addRecipe()
    {
        GameRegistry.addRecipe(new ItemStack(Fossil.skullLantern, 1), new Object[] {"X", "Y", 'X', Fossil.blockSkull, 'Y', Blocks.torch});
        GameRegistry.addRecipe(new ItemStack(Items.dye, 5, 15), new Object[] {"X", 'X', Fossil.blockSkull});
        GameRegistry.addRecipe(new ItemStack(Items.dye, 5, 15), new Object[] {"X", 'X', Fossil.skullLantern});
        GameRegistry.addRecipe(new ItemStack(Fossil.blockcultivateIdle, 1), new Object[] {"XYX", "XWX", "ZZZ", 'X', Blocks.glass, 'Y', new ItemStack(Items.dye, 1, 2), 'W', Items.water_bucket, 'Z', Items.iron_ingot});
        GameRegistry.addRecipe(new ItemStack(Fossil.blockanalyzerIdle, 1), new Object[] {"XYX", "XWX", 'X', Items.iron_ingot, 'Y', Fossil.relic, 'W', Fossil.biofossil});
        GameRegistry.addRecipe(new ItemStack(Fossil.blockworktableIdle, 1), new Object[] {"X", "Y", 'X', Items.paper, 'Y', Blocks.crafting_table});
        GameRegistry.addRecipe(new ItemStack(Fossil.blockSifterIdle, 1), new Object[] {"XYX", "YZY", "YXY", 'X', Items.string, 'Y', Blocks.planks, 'Z', Blocks.iron_bars});
        GameRegistry.addRecipe(new ItemStack(Fossil.ancientWoodPlate, 3), new Object[] {"XX", 'X', Fossil.ancientWood});

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.cake, 1), new Object[] {"MMM", "SES", "WWW", 'M', Items.milk_bucket, 'S', Items.sugar, 'W', Items.wheat, 'E', "foodEgg"}));
 
        GameRegistry.addRecipe(new ItemStack(Fossil.skullStick, 1), new Object[] {"X", "Y", 'X', Fossil.blockSkull, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Fossil.drum, 1), new Object[] {"ZZZ", "XYX", "XXX", 'X', Blocks.planks, 'Y', Items.redstone, 'Z', Items.leather});
        GameRegistry.addRecipe(new ItemStack(Fossil.feederActive, 1), new Object[] {"XYX", "ZAB", "BBB", 'X', Items.iron_ingot, 'Y', Blocks.glass, 'Z', Blocks.stone_button, 'A', Items.bucket, 'B', Blocks.stone});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.gemAxe), new Object[] {Items.golden_axe, Fossil.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.gemAxe), new Object[] {Items.diamond_axe, Fossil.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.gemPickaxe), new Object[] {Items.golden_pickaxe, Fossil.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.gemPickaxe), new Object[] {Items.diamond_pickaxe, Fossil.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.gemHoe), new Object[] {Items.golden_hoe, Fossil.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.gemHoe), new Object[] {Items.diamond_hoe, Fossil.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.gemSword), new Object[] {Items.golden_sword, Fossil.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.gemSword), new Object[] {Items.diamond_sword, Fossil.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.gemShovel), new Object[] {Items.golden_shovel, Fossil.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.gemShovel), new Object[] {Items.diamond_shovel, Fossil.gem});

        for (int i = 0; i < EnumDinoType.values().length; i++)
            GameRegistry.addShapelessRecipe(new ItemStack(Fossil.dinoPedia), new Object[] {Items.book, EnumDinoType.values()[i].DNAItem});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.dinoPedia), new Object[] {Items.book, Fossil.dnaCoelacanth});
        //GameRegistry.addShapelessRecipe(new ItemStack(Fossil.archNotebook), new Object[] {Item.book, Fossil.relic});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.rawChickenSoup, 1, 0), new Object[] {Items.bucket, Items.chicken});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.magicConch, 1, 1), new Object[] {new ItemStack(Fossil.magicConch, 1, 0)});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.magicConch, 1, 2), new Object[] {new ItemStack(Fossil.magicConch, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.magicConch, 1, 0), new Object[] {new ItemStack(Fossil.magicConch, 1, 2)});
        GameRegistry.addRecipe(new ItemStack(Fossil.chickenEss, 8), new Object[] {"XXX", "XYX", "XXX", 'X', Items.glass_bottle, 'Y', Fossil.cookedChickenSoup});
        GameRegistry.addRecipe(new ItemStack(Fossil.whip, 1), new Object[] {"XXS", "XTS", "TXS", 'T', Items.stick, 'S', Items.string});
        GameRegistry.addRecipe(new ItemStack(Fossil.volcanicBrick, 4), new Object[] {"VV", "VV", 'V', Fossil.volcanicRock});
        GameRegistry.addRecipe(new ItemStack(Fossil.volcanicSingleSlab, 6), new Object[] {"PPP", 'P', Fossil.volcanicBrick});
        GameRegistry.addRecipe(new ItemStack(Fossil.volcanicStairs, 4), new Object[] {"P  ", "PP ", "PPP", 'P', Fossil.volcanicBrick});
        GameRegistry.addRecipe(new ItemStack(Fossil.volcanicStairs, 4), new Object[] {"  P", " PP", "PPP", 'P', Fossil.volcanicBrick});
        GameRegistry.addRecipe(new ItemStack(Fossil.palaePlanks, 4), new Object[] {"P", 'P', Fossil.palmLog});
        GameRegistry.addRecipe(new ItemStack(Blocks.wooden_button, 1), new Object[] {"P", 'P', Fossil.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Items.stick, 3), new Object[] { "P", "P", 'P', Fossil.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Blocks.wooden_pressure_plate, 1), new Object[] { "PP", 'P', Fossil.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Items.boat, 1), new Object[] { "PXP", "PPP", 'P', Fossil.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Items.bowl, 3), new Object[] { "PXP", "XPX", 'P', Fossil.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Blocks.crafting_table, 1), new Object[] { "PP", "PP", 'P', Fossil.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_door, 1), new Object[] {"PPX", "PPX", "PPX", 'P', Fossil.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Blocks.trapdoor, 2), new Object[] { "PPP", "PPP", 'P', Fossil.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Blocks.chest, 1), new Object[] {"PPP", "PXP", "PPP", 'P', Fossil.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_shovel, 1), new Object[] {"P", "S", "S", 'P', Fossil.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_sword, 1), new Object[] {"P", "P", "S", 'P', Fossil.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_hoe, 1), new Object[] {"PP", "XS", "XS", 'P', Fossil.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_hoe, 1), new Object[] {"PP", "SX", "SX", 'P', Fossil.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_axe, 1), new Object[] {"PP", "PS", "XS", 'P', Fossil.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_axe, 1), new Object[] {"PP", "SP", "SX", 'P', Fossil.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_pickaxe, 1), new Object[] {"PPP", "XSX", "XSX", 'P', Fossil.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Blocks.fence_gate, 1), new Object[] { "SPS", "SPS", 'P', Fossil.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.sign, 3), new Object[] {"PPP", "PPP", "XSX", 'P', Fossil.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.bed, 1), new Object[] { "WWW", "PPP", 'P', Fossil.palaePlanks, 'W', Fossil.blockanalyzerActive});
        GameRegistry.addRecipe(new ItemStack(Blocks.jukebox, 1), new Object[] {"PPP", "PDP", "PPP", 'P', Fossil.palaePlanks, 'D', Items.diamond});
        GameRegistry.addRecipe(new ItemStack(Blocks.jukebox, 1), new Object[] {"PPP", "PRP", "PPP", 'P', Fossil.palaePlanks, 'R', Items.redstone});
        GameRegistry.addRecipe(new ItemStack(Blocks.piston, 1), new Object[] {"PPP", "CIC", "CRC", 'P', Fossil.palaePlanks, 'R', Items.redstone, 'I', Items.iron_ingot, 'C', Blocks.cobblestone});
        GameRegistry.addRecipe(new ItemStack(Blocks.bookshelf, 1), new Object[] {"PPP", "BBB", "PPP", 'P', Fossil.palaePlanks, 'B', Items.book});
        //GameRegistry.addRecipe(new ItemStack(Fossil.palaeSingleSlab, 6), new Object[] {"PPP", 'P', Fossil.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Fossil.palaeStairs, 4), new Object[] {"P  ", "PP ", "PPP", 'P', Fossil.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Fossil.palaeStairs, 4), new Object[] {"  P", " PP", "PPP", 'P', Fossil.palaePlanks});
        //GameRegistry.addRecipe(new ItemStack(Fossil.ancientWoodSingleSlab, 6), new Object[] {"PPP", 'P', Fossil.ancientWood});
        GameRegistry.addRecipe(new ItemStack(Fossil.ancientWoodStairs, 4), new Object[] {"P  ", "PP ", "PPP", 'P', Fossil.ancientWood});
        GameRegistry.addRecipe(new ItemStack(Fossil.ancientWoodStairs, 4), new Object[] {"  P", " PP", "PPP", 'P', Fossil.ancientWood});
        //GameRegistry.addRecipe(new ItemStack(Fossil.ancientStoneSingleSlab, 6), new Object[] {"PPP", 'P', Fossil.ancientStone});
        GameRegistry.addRecipe(new ItemStack(Fossil.ancientStoneStairs, 4), new Object[] {"P  ", "PP ", "PPP", 'P', Fossil.ancientStone});
        GameRegistry.addRecipe(new ItemStack(Fossil.ancientStoneStairs, 4), new Object[] {"  P", " PP", "PPP", 'P', Fossil.ancientStone});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Fossil.feet, 1), new Object[] {"* *", "# #", '#', new ItemStack(Fossil.foot,1, OreDictionary.WILDCARD_VALUE), '*', "dinosaurClaw"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Fossil.feet, 1), new Object[] {"   ", "* *", "# #", '#', new ItemStack(Fossil.foot,1, OreDictionary.WILDCARD_VALUE), '*', "dinosaurClaw"}));
        GameRegistry.addRecipe(new ItemStack(Fossil.femurs, 1), new Object[] {"###", "* *", "# #", '#', Items.bone, '*', new ItemStack(Fossil.legBone,1, OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Fossil.ribCage, 1), new Object[] {"B B", " R ", "BVB", 'B', Items.bone, 'R', "dinosaurRibCage", 'V', "dinosaurVertebrae"}));
        GameRegistry.addRecipe(new ItemStack(Fossil.skullHelmet, 1), new Object[] {"#X#", "# #", '#', Items.bone, 'X', new ItemStack(Fossil.skull,1, OreDictionary.WILDCARD_VALUE)});

        //Craft damaged vases
        GameRegistry.addRecipe(new ItemStack(Fossil.vaseVoluteBlock, 1), new Object[] {"X X", "X X", "XXX", 'X', Fossil.potteryShards});
        GameRegistry.addRecipe(new ItemStack(Fossil.vaseAmphoraBlock, 1), new Object[] {"XX ", "XX ", "XX ", 'X', Fossil.potteryShards});
        GameRegistry.addRecipe(new ItemStack(Fossil.vaseAmphoraBlock, 1), new Object[] {" XX", " XX", " XX", 'X', Fossil.potteryShards});
        GameRegistry.addRecipe(new ItemStack(Fossil.vaseKylixBlock, 1), new Object[] {"   ", "XXX", " X ", 'X', Fossil.potteryShards});
        GameRegistry.addRecipe(new ItemStack(Fossil.vaseKylixBlock, 1), new Object[] {"XXX", " X ", "   ", 'X', Fossil.potteryShards});
        
        //Shapeless vase recipies for dying them metadata > 1 = dye colors
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.vaseVoluteBlock, 1, 2), new Object[] {new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 0),  new ItemStack(Items.dye, 1, 14),  new ItemStack(Fossil.vaseVoluteBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.vaseVoluteBlock, 1, 3), new Object[] {new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14),  new ItemStack(Items.dye, 1, 14),  new ItemStack(Fossil.vaseVoluteBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.vaseVoluteBlock, 1, 4), new Object[] {new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15), new ItemStack(Fossil.vaseVoluteBlock, 1, 1)});
        
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.vaseAmphoraBlock, 1, 2), new Object[] {new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 0),  new ItemStack(Items.dye, 1, 14),  new ItemStack(Fossil.vaseAmphoraBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.vaseAmphoraBlock, 1, 3), new Object[] {new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14),  new ItemStack(Items.dye, 1, 14),  new ItemStack(Fossil.vaseAmphoraBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.vaseAmphoraBlock, 1, 4), new Object[] {new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15), new ItemStack(Fossil.vaseAmphoraBlock, 1, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.vaseKylixBlock, 1, 2), new Object[] {new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 0),  new ItemStack(Items.dye, 1, 14),  new ItemStack(Fossil.vaseKylixBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.vaseKylixBlock, 1, 3), new Object[] {new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14),  new ItemStack(Items.dye, 1, 14),  new ItemStack(Fossil.vaseKylixBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(Fossil.vaseKylixBlock, 1, 4), new Object[] {new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15), new ItemStack(Fossil.vaseKylixBlock, 1, 1)});
 
        GameRegistry.addSmelting(Fossil.rawChickenSoup, new ItemStack(Fossil.cookedChickenSoup), 3.0F);
        GameRegistry.addSmelting(EnumDinoType.values()[4].EggItem, new ItemStack(Fossil.sjl), 3.0F);

        for (int i = 0; i < EnumDinoType.values().length; i++)
            if (i != 4) //Nautilus treated specially
            {
                GameRegistry.addSmelting(EnumDinoType.values()[i].DropItem, new ItemStack(Fossil.cookedDinoMeat), 3.0F);
            }

        GameRegistry.addSmelting(Fossil.icedMeat, new ItemStack(Items.beef), 3.0F);
        GameRegistry.addSmelting(Fossil.dodoWing, new ItemStack(Fossil.dodoWingCooked), 3.0F);
        GameRegistry.addSmelting(Fossil.terrorBirdMeat, new ItemStack(Fossil.terrorBirdMeatCooked), 3.0F);
        GameRegistry.addSmelting(Fossil.quaggaMeat, new ItemStack(Fossil.quaggaMeatCooked), 3.0F);

    }
}
