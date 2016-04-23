package com.github.revival.server.handler;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.enums.EnumMobType;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.item.FAItemRegistry;

import cpw.mods.fml.common.registry.GameRegistry;

public class FossilRecipes {
	public static String[] dyes = {"Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "LightGray", "Gray", "Pink", "Lime", "Yellow", "LightBlue", "Magenta", "Orange", "White"};

	public static void addRecipe() {
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.skullLantern, 1), new Object[]{"X", "Y", 'X', FABlockRegistry.INSTANCE.blockSkull, 'Y', Blocks.torch});
        GameRegistry.addRecipe(new ItemStack(Items.dye, 5, 15), new Object[]{"X", 'X', FABlockRegistry.INSTANCE.blockSkull});
        GameRegistry.addRecipe(new ItemStack(Items.dye, 5, 15), new Object[]{"X", 'X', FABlockRegistry.INSTANCE.skullLantern});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FABlockRegistry.INSTANCE.blockanalyzerIdle, 1), new Object[]{"XYX", "XWX", 'X', "ingotIron", 'Y', "artifact", 'W', "fossil"}));
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.blockworktableIdle, 1), new Object[]{"X", "Y", 'X', Items.paper, 'Y', Blocks.crafting_table});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.blockSifterIdle, 1), new Object[]{"XYX", "YZY", "YXY", 'X', Items.string, 'Y', Blocks.planks, 'Z', Blocks.iron_bars});
        //GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.ancientWoodPlate, 3), new Object[]{"XX", 'X', FABlockRegistry.INSTANCE.ancientWood});
//        GameRegistry.addRecipe(new ItemStack(Revival.blockcultivateIdle, 1), new Object[] {"XYX", "XWX", "ZZZ", 'X', Blocks.glass, 'Y', new ItemStack(Items.dye, 1, 2), 'W', Items.water_bucket, 'Z', Items.iron_ingot});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.blockTimeMachine, 1), new Object[]{"XYX", "ZUZ", "VXV", 'X', FAItemRegistry.INSTANCE.gem, 'Y', Items.nether_star, 'Z', Items.gold_ingot, 'U', Items.ender_pearl, 'V', Blocks.obsidian});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.blockcultivateIdle, 1), new Object[]{"XYX", "XWX", "ZZZ", 'X', Blocks.glass, 'Y', new ItemStack(Items.dye, 1, 2), 'W', Items.water_bucket, 'Z', Items.iron_ingot});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.cake, 1), new Object[]{"MMM", "SES", "WWW", 'M', Items.milk_bucket, 'S', Items.sugar, 'W', Items.wheat, 'E', "foodEgg"}));
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.obsidianSpikes, 4), new Object[]{"A A", "A A", 'A', Blocks.obsidian});
        GameRegistry.addRecipe(new ItemStack(FAItemRegistry.INSTANCE.skullStick, 1), new Object[]{"X", "Y", 'X', FABlockRegistry.INSTANCE.blockSkull, 'Y', Items.stick});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.drum, 1), new Object[]{"ZZZ", "XYX", "XXX", 'X', Blocks.planks, 'Y', Items.redstone, 'Z', Items.leather});
        //GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.feederActive, 1), new Object[]{"XYX", "ZAB", "BBB", 'X', Items.iron_ingot, 'Y', Blocks.glass, 'Z', Blocks.stone_button, 'A', Items.bucket, 'B', Blocks.stone});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemAxe), new Object[]{Items.golden_axe, FAItemRegistry.INSTANCE.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemAxe), new Object[]{Items.diamond_axe, FAItemRegistry.INSTANCE.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemPickaxe), new Object[]{Items.golden_pickaxe, FAItemRegistry.INSTANCE.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemPickaxe), new Object[]{Items.diamond_pickaxe, FAItemRegistry.INSTANCE.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gem_blue), new Object[]{FAItemRegistry.INSTANCE.DominicanAmber, FAItemRegistry.INSTANCE.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemHoe), new Object[]{Items.golden_hoe, FAItemRegistry.INSTANCE.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemHoe), new Object[]{Items.diamond_hoe, FAItemRegistry.INSTANCE.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemSword), new Object[]{Items.golden_sword, FAItemRegistry.INSTANCE.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemSword), new Object[]{Items.diamond_sword, FAItemRegistry.INSTANCE.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemShovel), new Object[]{Items.golden_shovel, FAItemRegistry.INSTANCE.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemShovel), new Object[]{Items.diamond_shovel, FAItemRegistry.INSTANCE.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemShovel), new Object[]{Items.diamond_shovel, FAItemRegistry.INSTANCE.gem});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.denseSand, 2), new Object[]{Items.quartz, Blocks.sand});
        // GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.toothDagger, 1), new Object[]{new ItemStack(FAItemRegistry.INSTANCE.claw, 1, EnumDinoType.TRex.ordinal()), Items.stick});
        GameRegistry.addRecipe(new ShapelessOreRecipe(FAItemRegistry.INSTANCE.dinoPedia, new Object[]{Items.book, "fossil"}));
        // for (int i = 0; i < EnumDinoType.values().length; i++)
        //     GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.dinoPedia), new Object[]{Items.book, EnumDinoType.values()[i].DNAItem});
        // GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.dinoPedia), new Object[]{Items.book, FAItemRegistry.INSTANCE.dnaCoelacanth});
        //GameRegistry.addShapelessRecipe(new ItemStack(Revival.archNotebook), new Object[] {Item.book, Revival.relic});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.tardrop, 4, 0), new Object[]{FAItemRegistry.INSTANCE.tar_bucket});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.rawChickenSoup, 1, 0), new Object[]{Items.bucket, Items.chicken});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.magicConch, 1, 1), new Object[]{new ItemStack(FAItemRegistry.INSTANCE.magicConch, 1, 0)});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.magicConch, 1, 2), new Object[]{new ItemStack(FAItemRegistry.INSTANCE.magicConch, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.magicConch, 1, 0), new Object[]{new ItemStack(FAItemRegistry.INSTANCE.magicConch, 1, 2)});
        GameRegistry.addRecipe(new ItemStack(FAItemRegistry.INSTANCE.chickenEss, 8), new Object[]{"XXX", "XYX", "XXX", 'X', Items.glass_bottle, 'Y', FAItemRegistry.INSTANCE.cookedChickenSoup});
        GameRegistry.addRecipe(new ItemStack(FAItemRegistry.INSTANCE.whip, 1), new Object[]{"XXS", "XTS", "TXS", 'T', Items.stick, 'S', Items.string});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.volcanicBrick, 4), new Object[]{"VV", "VV", 'V', FABlockRegistry.INSTANCE.volcanicRock});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.volcanicSingleSlab, 6), new Object[]{"PPP", 'P', FABlockRegistry.INSTANCE.volcanicBrick});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.volcanicStairs, 4), new Object[]{"P  ", "PP ", "PPP", 'P', FABlockRegistry.INSTANCE.volcanicBrick});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.volcanicStairs, 4), new Object[]{"  P", " PP", "PPP", 'P', FABlockRegistry.INSTANCE.volcanicBrick});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.palaePlanks, 4), new Object[]{"P", 'P', FABlockRegistry.INSTANCE.palmLog});
        GameRegistry.addRecipe(new ItemStack(Blocks.wooden_button, 1), new Object[]{"P", 'P', FABlockRegistry.INSTANCE.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Items.stick, 3), new Object[]{"P", "P", 'P', FABlockRegistry.INSTANCE.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Blocks.wooden_pressure_plate, 1), new Object[]{"PP", 'P', FABlockRegistry.INSTANCE.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Items.boat, 1), new Object[]{"PXP", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Items.bowl, 3), new Object[]{"PXP", "XPX", 'P', FABlockRegistry.INSTANCE.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Blocks.crafting_table, 1), new Object[]{"PP", "PP", 'P', FABlockRegistry.INSTANCE.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_door, 1), new Object[]{"PPX", "PPX", "PPX", 'P', FABlockRegistry.INSTANCE.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Blocks.trapdoor, 2), new Object[]{"PPP", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Blocks.chest, 1), new Object[]{"PPP", "PXP", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_shovel, 1), new Object[]{"P", "S", "S", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_sword, 1), new Object[]{"P", "P", "S", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_hoe, 1), new Object[]{"PP", "XS", "XS", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_hoe, 1), new Object[]{"PP", "SX", "SX", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_axe, 1), new Object[]{"PP", "PS", "XS", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_axe, 1), new Object[]{"PP", "SP", "SX", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.wooden_pickaxe, 1), new Object[]{"PPP", "XSX", "XSX", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Blocks.fence_gate, 1), new Object[]{"SPS", "SPS", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.sign, 3), new Object[]{"PPP", "PPP", "XSX", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Items.bed, 1), new Object[]{"WWW", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'W', FABlockRegistry.INSTANCE.blockanalyzerActive});
        GameRegistry.addRecipe(new ItemStack(Blocks.jukebox, 1), new Object[]{"PPP", "PDP", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'D', Items.diamond});
        GameRegistry.addRecipe(new ItemStack(Blocks.jukebox, 1), new Object[]{"PPP", "PRP", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'R', Items.redstone});
        GameRegistry.addRecipe(new ItemStack(Blocks.piston, 1), new Object[]{"PPP", "CIC", "CRC", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'R', Items.redstone, 'I', Items.iron_ingot, 'C', Blocks.cobblestone});
        GameRegistry.addRecipe(new ItemStack(Blocks.bookshelf, 1), new Object[]{"PPP", "BBB", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'B', Items.book});
        //GameRegistry.addRecipe(new ItemStack(Revival.palaeSingleSlab, 6), new Object[] {"PPP", 'P', Revival.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.palaeStairs, 4), new Object[]{"P  ", "PP ", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.palaeStairs, 4), new Object[]{"  P", " PP", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks});
        //GameRegistry.addRecipe(new ItemStack(Revival.ancientWoodSingleSlab, 6), new Object[] {"PPP", 'P', Revival.ancientWood});
        // GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.ancientWoodStairs, 4), new Object[]{"P  ", "PP ", "PPP", 'P', FABlockRegistry.INSTANCE.ancientWood});
        // GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.ancientWoodStairs, 4), new Object[]{"  P", " PP", "PPP", 'P', FABlockRegistry.INSTANCE.ancientWood});
        //GameRegistry.addRecipe(new ItemStack(Revival.ancientStoneSingleSlab, 6), new Object[] {"PPP", 'P', Revival.ancientStone});
        // GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.ancientStoneStairs, 4), new Object[]{"P  ", "PP ", "PPP", 'P', FABlockRegistry.INSTANCE.ancientStone});
        //  GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.ancientStoneStairs, 4), new Object[]{"  P", " PP", "PPP", 'P', FABlockRegistry.INSTANCE.ancientStone});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FAItemRegistry.INSTANCE.feet, 1), new Object[]{"* *", "# #", '#', new ItemStack(FAItemRegistry.INSTANCE.foot, 1, OreDictionary.WILDCARD_VALUE), '*', "dinosaurClaw"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FAItemRegistry.INSTANCE.feet, 1), new Object[]{"   ", "* *", "# #", '#', new ItemStack(FAItemRegistry.INSTANCE.foot, 1, OreDictionary.WILDCARD_VALUE), '*', "dinosaurClaw"}));
        GameRegistry.addRecipe(new ItemStack(FAItemRegistry.INSTANCE.femurs, 1), new Object[]{"###", "* *", "# #", '#', Items.bone, '*', new ItemStack(FAItemRegistry.INSTANCE.legBone, 1, OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FAItemRegistry.INSTANCE.ribCage, 1), new Object[]{"B B", " R ", "BVB", 'B', Items.bone, 'R', "dinosaurRibCage", 'V', "dinosaurVertebrae"}));
        GameRegistry.addRecipe(new ItemStack(FAItemRegistry.INSTANCE.skullHelmet, 1), new Object[]{"#X#", "# #", '#', Items.bone, 'X', new ItemStack(FAItemRegistry.INSTANCE.skull, 1, OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock, 1), new Object[]{"X X", "X X", "XXX", 'X', FAItemRegistry.INSTANCE.potteryShards});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1), new Object[]{"XX ", "XX ", "XX ", 'X', FAItemRegistry.INSTANCE.potteryShards});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1), new Object[]{" XX", " XX", " XX", 'X', FAItemRegistry.INSTANCE.potteryShards});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1), new Object[]{"   ", "XXX", " X ", 'X', FAItemRegistry.INSTANCE.potteryShards});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1), new Object[]{"XXX", " X ", "   ", 'X', FAItemRegistry.INSTANCE.potteryShards});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock, 1, 2), new Object[]{new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14), new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock, 1, 3), new Object[]{new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14), new ItemStack(Items.dye, 1, 14), new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock, 1, 4), new Object[]{new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15), new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1, 2), new Object[]{new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14), new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1, 3), new Object[]{new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14), new ItemStack(Items.dye, 1, 14), new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1, 4), new Object[]{new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15), new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1, 2), new Object[]{new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14), new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1, 3), new Object[]{new ItemStack(Items.dye, 1, 0), new ItemStack(Items.dye, 1, 14), new ItemStack(Items.dye, 1, 14), new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1, 4), new Object[]{new ItemStack(Items.dye, 1, 4), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15), new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1, 1)});
        GameRegistry.addSmelting(FAItemRegistry.INSTANCE.rawChickenSoup, new ItemStack(FAItemRegistry.INSTANCE.cookedChickenSoup), 3.0F);
        GameRegistry.addSmelting(FABlockRegistry.INSTANCE.denseSand, new ItemStack(FABlockRegistry.INSTANCE.strongGlass), 3.0F);
        
        GameRegistry.addSmelting(Items.egg, new ItemStack(FAItemRegistry.INSTANCE.cookedEgg), 3.0F);
		for (int i = 0; i < EnumPrehistoric.values().length; i++){
			if(EnumPrehistoric.values()[i].type == EnumMobType.DINOSAUR && !EnumPrehistoric.values()[i].isAquatic()){
		        GameRegistry.addSmelting(EnumPrehistoric.values()[i].eggItem, new ItemStack(FAItemRegistry.INSTANCE.cookedEgg), 3.0F);
			}
			if(EnumPrehistoric.values()[i].type == EnumMobType.BIRD){
		        GameRegistry.addSmelting(EnumPrehistoric.values()[i].birdEggItem, new ItemStack(FAItemRegistry.INSTANCE.cookedEgg), 3.0F);
		        GameRegistry.addSmelting(EnumPrehistoric.values()[i].bestBirdEggItem, new ItemStack(FAItemRegistry.INSTANCE.cookedEgg), 3.0F);
			}
			if(EnumPrehistoric.values()[i].type == EnumMobType.CHICKEN){
		        GameRegistry.addSmelting(EnumPrehistoric.values()[i].bestBirdEggItem, new ItemStack(FAItemRegistry.INSTANCE.cookedEgg), 3.0F);
			}
			if(EnumPrehistoric.values()[i].foodItem != null){
		        GameRegistry.addSmelting(EnumPrehistoric.values()[i].foodItem, new ItemStack(EnumPrehistoric.values()[i].cookedFoodItem), 3.0F);
			}
			/*if(EnumPrehistoric.values()[i].type == EnumMobType.FISH){
		        GameRegistry.addSmelting(EnumPrehistoric.values()[i].eggItem, new ItemStack(EnumPrehistoric.values()[i].cookedFoodItem), 3.0F);
			}*/
		}
        GameRegistry.addSmelting(FAItemRegistry.INSTANCE.icedMeat, new ItemStack(Items.beef), 3.0F);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FAItemRegistry.INSTANCE.toyBall, 1, 15), new Object[]{"XYX", "YZY", "XYX", 'X', Items.string, 'Y', Blocks.wool, 'Z', "slimeball"}));
        for(int i = 0; i < 16; i++){
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(FAItemRegistry.INSTANCE.toyBall, 1, i), new ItemStack(FAItemRegistry.INSTANCE.toyBall, 1, OreDictionary.WILDCARD_VALUE), "dye" + dyes[i]));
        }
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FAItemRegistry.INSTANCE.toyTetheredLog), new Object[]{"X", "X", "Y", 'X', Items.string, 'Y', "logWood"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FAItemRegistry.INSTANCE.toyScratchingPost), new Object[]{"YYY", "YZY", " X ", 'X', "slabWood", 'Z', "stickWood", 'Y', Blocks.wool}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FABlockRegistry.INSTANCE.bubbleMachine), new Object[]{"XYX", "YZY", "XYX", 'X', "nuggetGold", 'Y', "ingotGold", 'Z', Items.water_bucket}));
	}
}
