package fossilsarcheology.server.handler;

import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.enums.MobType;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class FossilRecipes {
    public static String[] dyes = { "Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "LightGray", "Gray", "Pink", "Lime", "Yellow", "LightBlue", "Magenta", "Orange", "White" };

    public static void addRecipe() {
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.skullLantern, 1), "X", "Y", 'X', FABlockRegistry.INSTANCE.blockSkull, 'Y', Blocks.TORCH);
        GameRegistry.addRecipe(new ItemStack(Items.DYE, 5, 15), "X", 'X', FABlockRegistry.INSTANCE.blockSkull);
        GameRegistry.addRecipe(new ItemStack(Items.DYE, 5, 15), "X", 'X', FABlockRegistry.INSTANCE.skullLantern);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FABlockRegistry.INSTANCE.analyzerIdle, 1), "XYX", "XWX", 'X', "ingotIron", 'Y', "artifact", 'W', "fossil"));
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.blockworktableIdle, 1), "X", "Y", 'X', Items.PAPER, 'Y', Blocks.CRAFTING_TABLE);
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.blockSifterIdle, 1), "XYX", "YZY", "YXY", 'X', Items.STRING, 'Y', Blocks.PLANKS, 'Z', Blocks.IRON_BARS);
        // GameRegistry.addRecipe(new
        // ItemStack(FABlockRegistry.INSTANCE.ancientWoodPlate, 3), new
        // Object[]{"XX", 'X', FABlockRegistry.INSTANCE.ancientWood});
        // GameRegistry.addRecipe(new ItemStack(Revival.blockcultivateIdle, 1),
        // new Object[] {"XYX", "XWX", "ZZZ", 'X', Blocks.glass, 'Y', new
        // ItemStack(Items.DYE, 1, 2), 'W', Items.water_bucket, 'Z',
        // Items.iron_ingot});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.blockTimeMachine, 1), "XYX", "ZUZ", "VXV", 'X', FAItemRegistry.INSTANCE.gem, 'Y', Items.NETHER_STAR, 'Z', Items.GOLD_INGOT, 'U', Items.ENDER_PEARL, 'V', Blocks.OBSIDIAN);
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.CULTIVATE_IDLE, 1), "XYX", "XWX", "ZZZ", 'X', Blocks.GLASS, 'Y', new ItemStack(Items.DYE, 1, 2), 'W', Items.WATER_BUCKET, 'Z', Items.IRON_INGOT);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.CAKE, 1), "MMM", "SES", "WWW", 'M', Items.MILK_BUCKET, 'S', Items.SUGAR, 'W', Items.WHEAT, 'E', "foodEgg"));
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.obsidianSpikes, 4), "A A", "A A", 'A', Blocks.OBSIDIAN);
        GameRegistry.addRecipe(new ItemStack(FAItemRegistry.INSTANCE.skullStick, 1), "X", "Y", 'X', FABlockRegistry.INSTANCE.blockSkull, 'Y', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.drum, 1), "ZZZ", "XYX", "XXX", 'X', Blocks.PLANKS, 'Y', Items.REDSTONE, 'Z', Items.LEATHER);
        // GameRegistry.addRecipe(new
        // ItemStack(FABlockRegistry.INSTANCE.feederActive, 1), new
        // Object[]{"XYX", "ZAB", "BBB", 'X', Items.iron_ingot, 'Y',
        // Blocks.glass, 'Z', Blocks.stone_button, 'A', Items.bucket, 'B',
        // Blocks.stone});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemAxe), Items.GOLDEN_AXE, FAItemRegistry.INSTANCE.gem);
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemAxe), Items.DIAMOND_AXE, FAItemRegistry.INSTANCE.gem);
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemPickaxe), Items.GOLDEN_PICKAXE, FAItemRegistry.INSTANCE.gem);
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemPickaxe), Items.DIAMOND_PICKAXE, FAItemRegistry.INSTANCE.gem);
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gem_blue), FAItemRegistry.INSTANCE.DominicanAmber, FAItemRegistry.INSTANCE.gem);
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemHoe), Items.GOLDEN_HOE, FAItemRegistry.INSTANCE.gem);
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemHoe), Items.DIAMOND_HOE, FAItemRegistry.INSTANCE.gem);
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemSword), Items.GOLDEN_SWORD, FAItemRegistry.INSTANCE.gem);
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemSword), Items.DIAMOND_SWORD, FAItemRegistry.INSTANCE.gem);
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemShovel), Items.GOLDEN_SHOVEL, FAItemRegistry.INSTANCE.gem);
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.gemShovel), Items.DIAMOND_SHOVEL, FAItemRegistry.INSTANCE.gem);
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.denseSand, 2), Items.QUARTZ, Blocks.SAND);
        // GameRegistry.addShapelessRecipe(new
        // ItemStack(FAItemRegistry.INSTANCE.toothDagger, 1), new Object[]{new
        // ItemStack(FAItemRegistry.INSTANCE.claw, 1,
        // EnumDinoType.TRex.ordinal()), Items.STICK});
        GameRegistry.addRecipe(new ShapelessOreRecipe(FAItemRegistry.INSTANCE.dinoPedia, Items.BOOK, "fossil"));
        // for (int i = 0; i < EnumDinoType.values().length; i++)
        // GameRegistry.addShapelessRecipe(new
        // ItemStack(FAItemRegistry.INSTANCE.dinoPedia), new
        // Object[]{Items.book, EnumDinoType.values()[i].DNAItem});
        // GameRegistry.addShapelessRecipe(new
        // ItemStack(FAItemRegistry.INSTANCE.dinoPedia), new
        // Object[]{Items.book, FAItemRegistry.INSTANCE.dnaCoelacanth});
        // GameRegistry.addShapelessRecipe(new ItemStack(Revival.archNotebook),
        // new Object[] {Item.book, Revival.relic});
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.tardrop, 4, 0), FAItemRegistry.INSTANCE.tar_bucket);
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.rawChickenSoup, 1, 0), Items.BUCKET, Items.CHICKEN);
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.magicConch, 1, 1), new ItemStack(FAItemRegistry.INSTANCE.magicConch, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.magicConch, 1, 2), new ItemStack(FAItemRegistry.INSTANCE.magicConch, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(FAItemRegistry.INSTANCE.magicConch, 1, 0), new ItemStack(FAItemRegistry.INSTANCE.magicConch, 1, 2));
        GameRegistry.addRecipe(new ItemStack(FAItemRegistry.INSTANCE.chickenEssence, 8), "XXX", "XYX", "XXX", 'X', Items.GLASS_BOTTLE, 'Y', FAItemRegistry.INSTANCE.cookedChickenSoup);
        GameRegistry.addRecipe(new ItemStack(FAItemRegistry.INSTANCE.whip, 1), "XXS", "XTS", "TXS", 'T', Items.STICK, 'S', Items.STRING);
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.volcanicBrick, 4), "VV", "VV", 'V', FABlockRegistry.INSTANCE.volcanicRock);
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.volcanicSingleSlab, 6), "PPP", 'P', FABlockRegistry.INSTANCE.volcanicBrick);
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.volcanicStairs, 4), "P  ", "PP ", "PPP", 'P', FABlockRegistry.INSTANCE.volcanicBrick);
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.volcanicStairs, 4), "  P", " PP", "PPP", 'P', FABlockRegistry.INSTANCE.volcanicBrick);
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.palaePlanks, 4), "P", 'P', FABlockRegistry.INSTANCE.palmLog);
        GameRegistry.addRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 1), "P", 'P', FABlockRegistry.INSTANCE.palaePlanks);
        GameRegistry.addRecipe(new ItemStack(Items.STICK, 3), "P", "P", 'P', FABlockRegistry.INSTANCE.palaePlanks);
        GameRegistry.addRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 1), "PP", 'P', FABlockRegistry.INSTANCE.palaePlanks);
        GameRegistry.addRecipe(new ItemStack(Items.BOAT, 1), "PXP", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks);
        GameRegistry.addRecipe(new ItemStack(Items.BOWL, 3), "PXP", "XPX", 'P', FABlockRegistry.INSTANCE.palaePlanks);
        GameRegistry.addRecipe(new ItemStack(Blocks.CRAFTING_TABLE, 1), "PP", "PP", 'P', FABlockRegistry.INSTANCE.palaePlanks);
        GameRegistry.addRecipe(new ItemStack(Items.OAK_DOOR, 1), "PPX", "PPX", "PPX", 'P', FABlockRegistry.INSTANCE.palaePlanks);
        GameRegistry.addRecipe(new ItemStack(Blocks.TRAPDOOR, 2), "PPP", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks);
        GameRegistry.addRecipe(new ItemStack(Blocks.CHEST, 1), "PPP", "PXP", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks);
        GameRegistry.addRecipe(new ItemStack(Items.WOODEN_SHOVEL, 1), "P", "S", "S", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(Items.WOODEN_SWORD, 1), "P", "P", "S", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(Items.WOODEN_HOE, 1), "PP", "XS", "XS", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(Items.WOODEN_HOE, 1), "PP", "SX", "SX", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(Items.WOODEN_AXE, 1), "PP", "PS", "XS", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(Items.WOODEN_AXE, 1), "PP", "SP", "SX", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(Items.WOODEN_PICKAXE, 1), "PPP", "XSX", "XSX", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(Blocks.OAK_FENCE_GATE, 1), "SPS", "SPS", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(Items.SIGN, 3), "PPP", "PPP", "XSX", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(Items.BED, 1), "WWW", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'W', FABlockRegistry.INSTANCE.analyzerActive);
        GameRegistry.addRecipe(new ItemStack(Blocks.JUKEBOX, 1), "PPP", "PDP", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'D', Items.DIAMOND);
        GameRegistry.addRecipe(new ItemStack(Blocks.NOTEBLOCK, 1), "PPP", "PRP", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'R', Items.REDSTONE);
        GameRegistry.addRecipe(new ItemStack(Blocks.PISTON, 1), "PPP", "CIC", "CRC", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'R', Items.REDSTONE, 'I', Items.IRON_INGOT, 'C', Blocks.COBBLESTONE);
        GameRegistry.addRecipe(new ItemStack(Blocks.BOOKSHELF, 1), "PPP", "BBB", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks, 'B', Items.BOOK);
        // GameRegistry.addRecipe(new ItemStack(Revival.palaeSingleSlab, 6), new
        // Object[] {"PPP", 'P', Revival.palaePlanks});
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.palaeStairs, 4), "P  ", "PP ", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks);
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.palaeStairs, 4), "  P", " PP", "PPP", 'P', FABlockRegistry.INSTANCE.palaePlanks);
        // GameRegistry.addRecipe(new ItemStack(Revival.ancientWoodSingleSlab,
        // 6), new Object[] {"PPP", 'P', Revival.ancientWood});
        // GameRegistry.addRecipe(new
        // ItemStack(FABlockRegistry.INSTANCE.ancientWoodStairs, 4), new
        // Object[]{"P  ", "PP ", "PPP", 'P',
        // FABlockRegistry.INSTANCE.ancientWood});
        // GameRegistry.addRecipe(new
        // ItemStack(FABlockRegistry.INSTANCE.ancientWoodStairs, 4), new
        // Object[]{"  P", " PP", "PPP", 'P',
        // FABlockRegistry.INSTANCE.ancientWood});
        // GameRegistry.addRecipe(new ItemStack(Revival.ancientStoneSingleSlab,
        // 6), new Object[] {"PPP", 'P', Revival.ancientStone});
        // GameRegistry.addRecipe(new
        // ItemStack(FABlockRegistry.INSTANCE.ancientStoneStairs, 4), new
        // Object[]{"P  ", "PP ", "PPP", 'P',
        // FABlockRegistry.INSTANCE.ancientStone});
        // GameRegistry.addRecipe(new
        // ItemStack(FABlockRegistry.INSTANCE.ancientStoneStairs, 4), new
        // Object[]{"  P", " PP", "PPP", 'P',
        // FABlockRegistry.INSTANCE.ancientStone});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FAItemRegistry.INSTANCE.feet, 1), "* *", "# #", '#', new ItemStack(FAItemRegistry.INSTANCE.foot, 1, OreDictionary.WILDCARD_VALUE), '*', "dinosaurClaw"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FAItemRegistry.INSTANCE.feet, 1), "   ", "* *", "# #", '#', new ItemStack(FAItemRegistry.INSTANCE.foot, 1, OreDictionary.WILDCARD_VALUE), '*', "dinosaurClaw"));
        GameRegistry.addRecipe(new ItemStack(FAItemRegistry.INSTANCE.femurs, 1), "###", "* *", "# #", '#', Items.BONE, '*', new ItemStack(FAItemRegistry.INSTANCE.legBone, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FAItemRegistry.INSTANCE.ribCage, 1), "B B", " R ", "BVB", 'B', Items.BONE, 'R', "dinosaurRibCage", 'V', "dinosaurVertebrae"));
        GameRegistry.addRecipe(new ItemStack(FAItemRegistry.INSTANCE.skullHelmet, 1), "#X#", "# #", '#', Items.BONE, 'X', new ItemStack(FAItemRegistry.INSTANCE.skull, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock, 1), "X X", "X X", "XXX", 'X', FAItemRegistry.INSTANCE.potteryShards);
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1), "XX ", "XX ", "XX ", 'X', FAItemRegistry.INSTANCE.potteryShards);
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1), " XX", " XX", " XX", 'X', FAItemRegistry.INSTANCE.potteryShards);
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1), "   ", "XXX", " X ", 'X', FAItemRegistry.INSTANCE.potteryShards);
        GameRegistry.addRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1), "XXX", " X ", "   ", 'X', FAItemRegistry.INSTANCE.potteryShards);
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock, 1, 2), new ItemStack(Items.DYE, 1, 0), new ItemStack(Items.DYE, 1, 0), new ItemStack(Items.DYE, 1, 14), new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock, 1, 3), new ItemStack(Items.DYE, 1, 0), new ItemStack(Items.DYE, 1, 14), new ItemStack(Items.DYE, 1, 14), new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock, 1, 4), new ItemStack(Items.DYE, 1, 4), new ItemStack(Items.DYE, 1, 15), new ItemStack(Items.DYE, 1, 15), new ItemStack(FABlockRegistry.INSTANCE.vaseVoluteBlock, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1, 2), new ItemStack(Items.DYE, 1, 0), new ItemStack(Items.DYE, 1, 0), new ItemStack(Items.DYE, 1, 14), new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1, 3), new ItemStack(Items.DYE, 1, 0), new ItemStack(Items.DYE, 1, 14), new ItemStack(Items.DYE, 1, 14), new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1, 4), new ItemStack(Items.DYE, 1, 4), new ItemStack(Items.DYE, 1, 15), new ItemStack(Items.DYE, 1, 15), new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1, 2), new ItemStack(Items.DYE, 1, 0), new ItemStack(Items.DYE, 1, 0), new ItemStack(Items.DYE, 1, 14), new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1, 3), new ItemStack(Items.DYE, 1, 0), new ItemStack(Items.DYE, 1, 14), new ItemStack(Items.DYE, 1, 14), new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1, 4), new ItemStack(Items.DYE, 1, 4), new ItemStack(Items.DYE, 1, 15), new ItemStack(Items.DYE, 1, 15), new ItemStack(FABlockRegistry.INSTANCE.vaseKylixBlock, 1, 1));
        GameRegistry.addSmelting(FAItemRegistry.INSTANCE.rawChickenSoup, new ItemStack(FAItemRegistry.INSTANCE.cookedChickenSoup), 3.0F);
        GameRegistry.addSmelting(FABlockRegistry.INSTANCE.denseSand, new ItemStack(FABlockRegistry.INSTANCE.strongGlass), 3.0F);

        GameRegistry.addSmelting(Items.EGG, new ItemStack(FAItemRegistry.INSTANCE.cookedEgg), 3.0F);
        for (int i = 0; i < PrehistoricEntityType.values().length; i++) {
            if (PrehistoricEntityType.values()[i].mobType == MobType.DINOSAUR && !PrehistoricEntityType.values()[i].isAquatic()) {
                GameRegistry.addSmelting(PrehistoricEntityType.values()[i].eggItem, new ItemStack(FAItemRegistry.INSTANCE.cookedEgg), 3.0F);
            }
            if (PrehistoricEntityType.values()[i].mobType == MobType.BIRD) {
                GameRegistry.addSmelting(PrehistoricEntityType.values()[i].birdEggItem, new ItemStack(FAItemRegistry.INSTANCE.cookedEgg), 3.0F);
                GameRegistry.addSmelting(PrehistoricEntityType.values()[i].bestBirdEggItem, new ItemStack(FAItemRegistry.INSTANCE.cookedEgg), 3.0F);
            }
            if (PrehistoricEntityType.values()[i].mobType == MobType.CHICKEN) {
                GameRegistry.addSmelting(PrehistoricEntityType.values()[i].bestBirdEggItem, new ItemStack(FAItemRegistry.INSTANCE.cookedEgg), 3.0F);
            }
            if (PrehistoricEntityType.values()[i].foodItem != null) {
                GameRegistry.addSmelting(PrehistoricEntityType.values()[i].foodItem, new ItemStack(PrehistoricEntityType.values()[i].cookedFoodItem), 3.0F);
            }
            if (PrehistoricEntityType.values()[i].fishItem != null) {
                GameRegistry.addSmelting(PrehistoricEntityType.values()[i].fishItem, new ItemStack(PrehistoricEntityType.values()[i].cookedFoodItem), 3.0F);
            }
            /*
             * if(PrehistoricEntityType.values()[i].type == MobType.FISH){
			 * GameRegistry.addRecipe(PrehistoricEntityType.values()[i].eggItem, new
			 * ItemStack(PrehistoricEntityType.values()[i].cookedFoodItem), 3.0F); }
			 */
        }
        GameRegistry.addSmelting(FAItemRegistry.INSTANCE.icedMeat, new ItemStack(Items.BEEF), 3.0F);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FAItemRegistry.INSTANCE.toyBall, 1, 15), "XYX", "YZY", "XYX", 'X', Items.STRING, 'Y', Blocks.WOOL, 'Z', "slimeball"));
        for (int i = 0; i < 16; i++) {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(FAItemRegistry.INSTANCE.toyBall, 1, i), new ItemStack(FAItemRegistry.INSTANCE.toyBall, 1, OreDictionary.WILDCARD_VALUE), "dye" + dyes[i]));
        }
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FAItemRegistry.INSTANCE.toyTetheredLog), "X", "X", "Y", 'X', Items.STRING, 'Y', "logWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FAItemRegistry.INSTANCE.toyScratchingPost), "YYY", "YZY", " X ", 'X', "slabWood", 'Z', "stickWood", 'Y', Blocks.WOOL));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FABlockRegistry.INSTANCE.bubbleMachine), "XYX", "YZY", "XYX", 'X', "nuggetGold", 'Y', "ingotGold", 'Z', Items.WATER_BUCKET));
    }
}
