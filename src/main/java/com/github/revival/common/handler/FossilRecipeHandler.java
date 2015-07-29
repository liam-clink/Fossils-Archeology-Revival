package com.github.revival.common.handler;

import com.github.revival.common.block.FABlockRegistry;
import com.github.revival.common.item.FAItemRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class FossilRecipeHandler
{
    public static void addRecipe()
    {
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.skullLantern, 1), new Object[]{"X", "Y", 'X', FABlockRegistry.blockSkull, 'Y', Blocks.torch});
        GameRegistry.addRecipe(new ItemStack(Items.dye, 5, 15), new Object[]{"X", 'X', FABlockRegistry.blockSkull});
        GameRegistry.addRecipe(new ItemStack(Items.dye, 5, 15), new Object[]{"X", 'X', FABlockRegistry.skullLantern});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.blockanalyzerIdle, 1), new Object[]{"XYX", "XWX", 'X', Items.iron_ingot, 'Y', FAItemRegistry.relic, 'W', FAItemRegistry.biofossil});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.blockworktableIdle, 1), new Object[]{"X", "Y", 'X', Items.paper, 'Y', Blocks.crafting_table});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.blockSifterIdle, 1), new Object[]{"XYX", "YZY", "YXY", 'X', Items.string, 'Y', Blocks.planks, 'Z', Blocks.iron_bars});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.ancientWoodPlate, 3), new Object[]{"XX", 'X', FABlockRegistry.ancientWood});
//        GameRegistry.addRecipe(new ItemStack(Revival.blockcultivateIdle, 1), new Object[] {"XYX", "XWX", "ZZZ", 'X', Blocks.glass, 'Y', new ItemStack(Items.dye, 1, 2), 'W', Items.water_bucket, 'Z', Items.iron_ingot});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.blockTimeMachine, 1), new Object[]{"XYX", "ZUZ", "VXV", 'X', FAItemRegistry.gem, 'Y', Items.nether_star, 'Z', Items.gold_ingot, 'U', Items.ender_pearl, 'V', Blocks.obsidian});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.blockcultivateIdle, 1), new Object[]{"XYX", "XWX", "ZZZ", 'X', Blocks.glass, 'Y', new ItemStack(Items.dye, 1, 2), 'W', Items.water_bucket, 'Z', Items.iron_ingot});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.cake, 1), new Object[]{"MMM", "SES", "WWW", 'M', Items.milk_bucket, 'S', Items.sugar, 'W', Items.wheat, 'E', "foodEgg"}));
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.obsidianSpikes, 4), new Object[]{"A A", "A A", 'A', Blocks.obsidian});
        GameRegistry.addRecipe(new ItemStack(FAItemRegistry.skullStick, 1), new Object[]{"X", "Y", 'X', FABlockRegistry.blockSkull, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.drum, 1), new Object[]{"ZZZ", "XYX", "XXX", 'X', Blocks.planks, 'Y', Items.redstone, 'Z', Items.leather});
        //GameRegistry.addRecipe(new ItemStack(FABlockRegistry.feederActive, 1), new Object[]{"XYX", "ZAB", "BBB", 'X', Items.iron_ingot, 'Y', Blocks.glass, 'Z', Blocks.stone_button, 'A', Items.bucket, 'B', Blocks.stone});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.gemAxe), new Object[]{Items.golden_axe, FAItemRegistry.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.gemAxe), new Object[]{Items.diamond_axe, FAItemRegistry.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.gemPickaxe), new Object[]{Items.golden_pickaxe, FAItemRegistry.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.gemPickaxe), new Object[]{Items.diamond_pickaxe, FAItemRegistry.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.AquaticScarabGem), new Object[]{FAItemRegistry.DominicanAmber, FAItemRegistry.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.gemHoe), new Object[]{Items.golden_hoe, FAItemRegistry.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.gemHoe), new Object[]{Items.diamond_hoe, FAItemRegistry.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.gemSword), new Object[]{Items.golden_sword, FAItemRegistry.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.gemSword), new Object[]{Items.diamond_sword, FAItemRegistry.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.gemShovel), new Object[]{Items.golden_shovel, FAItemRegistry.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.gemShovel), new Object[]{Items.diamond_shovel, FAItemRegistry.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.gemShovel), new Object[]{Items.diamond_shovel, FAItemRegistry.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.denseSand, 2), new Object[]{Items.quartz, Blocks.sand});
       // GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.toothDagger, 1), new Object[]{new ItemStack(FAItemRegistry.claw, 1, EnumDinoType.TRex.ordinal()), Items.stick});

       // for (int i = 0; i < EnumDinoType.values().length; i++)
       //     GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.dinoPedia), new Object[]{Items.book, EnumDinoType.values()[i].DNAItem});
       // GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.dinoPedia), new Object[]{Items.book, FAItemRegistry.dnaCoelacanth});
        //GameRegistry.addShapelessRecipe(new ItemStack(Revival.archNotebook), new Object[] {Item.book, Revival.relic});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.rawChickenSoup, 1, 0), new Object[]{Items.bucket, Items.chicken});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.magicConch, 1, 1), new Object[]{new ItemStack(FAItemRegistry.magicConch, 1, 0)});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.magicConch, 1, 2), new Object[]{new ItemStack(FAItemRegistry.magicConch, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.magicConch, 1, 0), new Object[]{new ItemStack(FAItemRegistry.magicConch, 1, 2)});
        GameRegistry.addRecipe(new ItemStack(FAItemRegistry.chickenEss, 8), new Object[]{"XXX", "XYX", "XXX", 'X', Items.glass_bottle, 'Y', FAItemRegistry.cookedChickenSoup});
        GameRegistry.addRecipe(new ItemStack(FAItemRegistry.whip, 1), new Object[]{"XXS", "XTS", "TXS", 'T', Items.stick, 'S', Items.string});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.volcanicBrick, 4), new Object[]{"VV", "VV", 'V', FABlockRegistry.volcanicRock});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.volcanicSingleSlab, 6), new Object[]{"PPP", 'P', FABlockRegistry.volcanicBrick});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.volcanicStairs, 4), new Object[]{"P  ", "PP ", "PPP", 'P', FABlockRegistry.volcanicBrick});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.volcanicStairs, 4), new Object[]{"  P", " PP", "PPP", 'P', FABlockRegistry.volcanicBrick});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.palaePlanks, 4), new Object[]{"P", 'P', FABlockRegistry.palmLog});
        GameRegistry.addRecipe(new ItemStack(Blocks.wooden_button, 1), new Object[]{"P", 'P', FABlockRegistry.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Items.stick, 3), new Object[]{"P", "P", 'P', FABlockRegistry.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Blocks.wooden_pressure_plate, 1), new Object[]{"PP", 'P', FABlockRegistry.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Items.boat, 1), new Object[]{"PXP", "PPP", 'P', FABlockRegistry.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Items.bowl, 3), new Object[]{"PXP", "XPX", 'P', FABlockRegistry.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Blocks.crafting_table, 1), new Object[]{"PP", "PP", 'P', FABlockRegistry.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_door, 1), new Object[]{"PPX", "PPX", "PPX", 'P', FABlockRegistry.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Blocks.trapdoor, 2), new Object[]{"PPP", "PPP", 'P', FABlockRegistry.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Blocks.chest, 1), new Object[]{"PPP", "PXP", "PPP", 'P', FABlockRegistry.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_shovel, 1), new Object[]{"P", "S", "S", 'P', FABlockRegistry.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_sword, 1), new Object[]{"P", "P", "S", 'P', FABlockRegistry.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_hoe, 1), new Object[]{"PP", "XS", "XS", 'P', FABlockRegistry.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_hoe, 1), new Object[]{"PP", "SX", "SX", 'P', FABlockRegistry.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_axe, 1), new Object[]{"PP", "PS", "XS", 'P', FABlockRegistry.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_axe, 1), new Object[]{"PP", "SP", "SX", 'P', FABlockRegistry.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_pickaxe, 1), new Object[]{"PPP", "XSX", "XSX", 'P', FABlockRegistry.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Blocks.fence_gate, 1), new Object[]{"SPS", "SPS", 'P', FABlockRegistry.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.sign, 3), new Object[]{"PPP", "PPP", "XSX", 'P', FABlockRegistry.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.bed, 1), new Object[]{"WWW", "PPP", 'P', FABlockRegistry.palaePlanks, 'W', FABlockRegistry.blockanalyzerActive});
        GameRegistry.addRecipe(new ItemStack(Blocks.jukebox, 1), new Object[]{"PPP", "PDP", "PPP", 'P', FABlockRegistry.palaePlanks, 'D', Items.diamond});
        GameRegistry.addRecipe(new ItemStack(Blocks.jukebox, 1), new Object[]{"PPP", "PRP", "PPP", 'P', FABlockRegistry.palaePlanks, 'R', Items.redstone});
        GameRegistry.addRecipe(new ItemStack(Blocks.piston, 1), new Object[]{"PPP", "CIC", "CRC", 'P', FABlockRegistry.palaePlanks, 'R', Items.redstone, 'I', Items.iron_ingot, 'C', Blocks.cobblestone});
        GameRegistry.addRecipe(new ItemStack(Blocks.bookshelf, 1), new Object[]{"PPP", "BBB", "PPP", 'P', FABlockRegistry.palaePlanks, 'B', Items.book});
        //GameRegistry.addRecipe(new ItemStack(Revival.palaeSingleSlab, 6), new Object[] {"PPP", 'P', Revival.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.palaeStairs, 4), new Object[]{"P  ", "PP ", "PPP", 'P', FABlockRegistry.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.palaeStairs, 4), new Object[]{"  P", " PP", "PPP", 'P', FABlockRegistry.palaePlanks});
        //GameRegistry.addRecipe(new ItemStack(Revival.ancientWoodSingleSlab, 6), new Object[] {"PPP", 'P', Revival.ancientWood});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.ancientWoodStairs, 4), new Object[]{"P  ", "PP ", "PPP", 'P', FABlockRegistry.ancientWood});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.ancientWoodStairs, 4), new Object[]{"  P", " PP", "PPP", 'P', FABlockRegistry.ancientWood});
        //GameRegistry.addRecipe(new ItemStack(Revival.ancientStoneSingleSlab, 6), new Object[] {"PPP", 'P', Revival.ancientStone});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.ancientStoneStairs, 4), new Object[]{"P  ", "PP ", "PPP", 'P', FABlockRegistry.ancientStone});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.ancientStoneStairs, 4), new Object[]{"  P", " PP", "PPP", 'P', FABlockRegistry.ancientStone});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FAItemRegistry.feet, 1), new Object[]{"* *", "# #", '#', new ItemStack(FAItemRegistry.foot, 1, OreDictionary.WILDCARD_VALUE), '*', "dinosaurClaw"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FAItemRegistry.feet, 1), new Object[]{"   ", "* *", "# #", '#', new ItemStack(FAItemRegistry.foot, 1, OreDictionary.WILDCARD_VALUE), '*', "dinosaurClaw"}));
        GameRegistry.addRecipe(new ItemStack(FAItemRegistry.femurs, 1), new Object[]{"###", "* *", "# #", '#', Items.bone, '*', new ItemStack(FAItemRegistry.legBone, 1, OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FAItemRegistry.ribCage, 1), new Object[]{"B B", " R ", "BVB", 'B', Items.bone, 'R', "dinosaurRibCage", 'V', "dinosaurVertebrae"}));
        GameRegistry.addRecipe(new ItemStack(FAItemRegistry.skullHelmet, 1), new Object[]{"#X#", "# #", '#', Items.bone, 'X', new ItemStack(FAItemRegistry.skull, 1, OreDictionary.WILDCARD_VALUE)});

        //Craft damaged vases
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.vaseVoluteBlock, 1), new Object[]{"X X", "X X", "XXX", 'X', FAItemRegistry.potteryShards});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.vaseAmphoraBlock, 1), new Object[]{"XX ", "XX ", "XX ", 'X', FAItemRegistry.potteryShards});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.vaseAmphoraBlock, 1), new Object[]{" XX", " XX", " XX", 'X', FAItemRegistry.potteryShards});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.vaseKylixBlock, 1), new Object[]{"   ", "XXX", " X ", 'X', FAItemRegistry.potteryShards});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.vaseKylixBlock, 1), new Object[]{"XXX", " X ", "   ", 'X', FAItemRegistry.potteryShards});
        
        //Shapeless vase recipies for dying them metadata > 1 = dye colors
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.vaseVoluteBlock, 1, 2), new Object[]{new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14), new ItemStack(FABlockRegistry.vaseVoluteBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.vaseVoluteBlock, 1, 3), new Object[]{new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14), new ItemStack(Items.dye, 1, 14), new ItemStack(FABlockRegistry.vaseVoluteBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.vaseVoluteBlock, 1, 4), new Object[]{new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15), new ItemStack(FABlockRegistry.vaseVoluteBlock, 1, 1)});
        
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.vaseAmphoraBlock, 1, 2), new Object[]{new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14), new ItemStack(FABlockRegistry.vaseAmphoraBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.vaseAmphoraBlock, 1, 3), new Object[]{new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14), new ItemStack(Items.dye, 1, 14), new ItemStack(FABlockRegistry.vaseAmphoraBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.vaseAmphoraBlock, 1, 4), new Object[]{new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15), new ItemStack(FABlockRegistry.vaseAmphoraBlock, 1, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.vaseKylixBlock, 1, 2), new Object[]{new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14), new ItemStack(FABlockRegistry.vaseKylixBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.vaseKylixBlock, 1, 3), new Object[]{new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14), new ItemStack(Items.dye, 1, 14), new ItemStack(FABlockRegistry.vaseKylixBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.vaseKylixBlock, 1, 4), new Object[]{new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15), new ItemStack(FABlockRegistry.vaseKylixBlock, 1, 1)});

        GameRegistry.addSmelting(FAItemRegistry.rawChickenSoup, new ItemStack(FAItemRegistry.cookedChickenSoup), 3.0F);
        //GameRegistry.addSmelting(EnumDinoType.values()[4].EggItem, new ItemStack(FAItemRegistry.sjl), 3.0F);
        GameRegistry.addSmelting(FABlockRegistry.denseSand, new ItemStack(FABlockRegistry.strongGlass), 3.0F);

       /* for (int i = 0; i < EnumDinoType.values().length; i++)
            if (i != 4) //Nautilus treated specially
            {
                GameRegistry.addSmelting(EnumDinoType.values()[i].DropItem, new ItemStack(FAItemRegistry.cookedDinoMeat), 3.0F);
            }*/

        GameRegistry.addSmelting(FAItemRegistry.icedMeat, new ItemStack(Items.beef), 3.0F);
       // GameRegistry.addSmelting(FAItemRegistry.dodoWing, new ItemStack(FAItemRegistry.dodoWingCooked), 3.0F);
       // GameRegistry.addSmelting(FAItemRegistry.terrorBirdMeat, new ItemStack(FAItemRegistry.terrorBirdMeatCooked), 3.0F);
       // GameRegistry.addSmelting(FAItemRegistry.quaggaMeat, new ItemStack(FAItemRegistry.quaggaMeatCooked), 3.0F);

    }
}
