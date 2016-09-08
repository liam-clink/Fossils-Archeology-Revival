package fossilsarcheology.server.handler;

import fossilsarcheology.server.block.FABlockRegistry;
import fossilsarcheology.server.enums.EnumDinoBones;
import fossilsarcheology.server.enums.PrehistoricEntityType;
import fossilsarcheology.server.item.FAItemRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class FossilAchievementHandler {
    public static AchievementPage FossilsAchievementPage;
    public static Achievement firstFossil;
    public static Achievement analyzer;
    public static Achievement tablet;
    public static Achievement dinoDna;
    public static Achievement cultivate;
    public static Achievement dinoEgg;
    public static Achievement mammalEmbryo;
    public static Achievement birdEgg;
    public static Achievement sifter;
    public static Achievement fossilSeeds;
    public static Achievement failuresaurus;
    public static Achievement failuresaurusAnalyzer;
    public static Achievement findAnuTotem;
    public static Achievement anuPortal;
    public static Achievement anubiteEncounter;
    public static Achievement anuAttack;
    public static Achievement anuDead;
    public static Achievement arcWorkbench;
    public static Achievement fixedSword;
    public static Achievement fixedHelmet;
    public static Achievement fixedVase;
    public static Achievement dinopedia;
    public static Achievement scarab;
    public static Achievement scarabTools;
    public static Achievement blueScarab;
    public static Achievement key;
    public static Achievement wtf;
    public static Achievement clock;
    public static Achievement firstDino;
    public static Achievement theKing;
    public static Achievement usurper;
    public static Achievement squire;
    public static Achievement shear;
    public static Achievement deadDodo;
    public static Achievement trexKill;

    public static void loadAchievements() {
        firstFossil = new Achievement("achievement.firstFossil", "firstFossil", 0, 0, new ItemStack(FAItemRegistry.INSTANCE.biofossil), null).registerStat();
        analyzer = new Achievement("achievement.analyzer", "analyzer", 0, -2, new ItemStack(FABlockRegistry.INSTANCE.analyzerActive), firstFossil).registerStat();
        tablet = new Achievement("achievement.tablet", "tablet", -2, -2, new ItemStack(FAItemRegistry.INSTANCE.stoneboard), analyzer).registerStat();
        dinoDna = new Achievement("achievement.dinoDna", "dinoDna", 0, -4, new ItemStack(PrehistoricEntityType.TYRANNOSAURUS.dnaItem), analyzer).registerStat().setSpecial();
        cultivate = new Achievement("achievement.cultivate", "cultivate", 2, -4, new ItemStack(FABlockRegistry.INSTANCE.CULTIVATE_ACTIVE), dinoDna).registerStat();
        dinoEgg = new Achievement("achievement.dinoEgg", "dinoEgg", 4, -4, new ItemStack(PrehistoricEntityType.TYRANNOSAURUS.eggItem), cultivate).registerStat();
        mammalEmbryo = new Achievement("achievement.mammalEmbryo", "mammalEmbryo", 4, -6, new ItemStack(PrehistoricEntityType.MAMMOTH.embryoItem), cultivate).registerStat();
        birdEgg = new Achievement("achievement.birdEgg", "birdEgg", 4, -2, new ItemStack(PrehistoricEntityType.CONFUCIUSORNIS.bestBirdEggItem), cultivate).registerStat();
        sifter = new Achievement("achievement.sifter", "sifter", -2, 0, new ItemStack(FABlockRegistry.INSTANCE.blockSifterActive), null).registerStat();
        fossilSeeds = new Achievement("achievement.fossilSeeds", "fossilSeeds", -2, -3, new ItemStack(FAItemRegistry.INSTANCE.fossilSeed), analyzer).registerStat();
        failuresaurus = new Achievement("achievement.failuresaurus", "failuresaurus", 4, 2, new ItemStack(FABlockRegistry.INSTANCE.blockSlimeTrail), cultivate).registerStat();
        failuresaurusAnalyzer = new Achievement("achievement.failuresaurusAnalyzer", "failuresaurusAnalyzer", 4, 4, new ItemStack(FAItemRegistry.INSTANCE.failuresaurusFlesh), failuresaurus).registerStat();
        findAnuTotem = new Achievement("achievement.findAnuTotem", "findAnuTotem", -6, 6, new ItemStack(FABlockRegistry.INSTANCE.anuTotem), null).registerStat();
        anuPortal = new Achievement("achievement.anuPortal", "anuPortal", -4, 5, new ItemStack(FABlockRegistry.INSTANCE.anuPortal), findAnuTotem).registerStat();
        anubiteEncounter = new Achievement("achievement.anubiteEncounter", "anubiteEncounter", -2, 5, new ItemStack(FABlockRegistry.INSTANCE.anubiteStatue), anuPortal).registerStat();
        anuAttack = new Achievement("achievement.anuAttack", "anuAttack", 0, 5, new ItemStack(FAItemRegistry.INSTANCE.ancientSword), anubiteEncounter).registerStat();
        anuDead = new Achievement("achievement.anuDead", "anuDead", 2, 5, new ItemStack(FAItemRegistry.INSTANCE.brokenSword), anuAttack).registerStat().setSpecial();
        arcWorkbench = new Achievement("achievement.arcWorkbench", "arcWorkbench", -6, 0, new ItemStack(FABlockRegistry.INSTANCE.blockworktableActive), null).registerStat();
        fixedSword = new Achievement("achievement.fixedSword", "fixedSword", -6, -2, new ItemStack(FAItemRegistry.INSTANCE.ancientSword), arcWorkbench).registerStat();
        fixedHelmet = new Achievement("achievement.fixedHelmet", "fixedHelmet", -6, 2, new ItemStack(FAItemRegistry.INSTANCE.ancienthelmet), arcWorkbench).registerStat();
        fixedVase = new Achievement("achievement.fixedVase", "fixedVase", -4, 0, new ItemStack(FABlockRegistry.INSTANCE.vaseAmphoraBlock, 1, 1), arcWorkbench).registerStat();
        dinopedia = new Achievement("achievement.dinopedia", "dinopedia", 0, -6, new ItemStack(FAItemRegistry.INSTANCE.dinoPedia), dinoDna).registerStat();
        scarab = new Achievement("achievement.scarab", "scarab", 0, 2, new ItemStack(FAItemRegistry.INSTANCE.gem), firstFossil).registerStat();
        scarabTools = new Achievement("achievement.scarabTools", "scarabTools", 0, 4, new ItemStack(FAItemRegistry.INSTANCE.gemSword), scarab).registerStat();
        blueScarab = new Achievement("achievement.blueScarab", "blueScarab", -2, 2, new ItemStack(FAItemRegistry.INSTANCE.gem_blue), scarab).registerStat();
        key = new Achievement("achievement.key", "key", 2, 7, new ItemStack(FAItemRegistry.INSTANCE.ancientKey), anuDead).registerStat();
        wtf = new Achievement("achievement.inTreasure", "inTreasure", 4, 7, new ItemStack(Blocks.STONEBRICK), key).registerStat();
        clock = new Achievement("achievement.clock", "clock", 6, 7, new ItemStack(FAItemRegistry.INSTANCE.ancientClock), wtf).registerStat();
        firstDino = new Achievement("achievement.firstDino", "firstDino", 6, -4, new ItemStack(FAItemRegistry.INSTANCE.skull, 1, 0), dinoEgg).registerStat().setSpecial();
        theKing = new Achievement("achievement.theKing", "theKing", 8, -5, new ItemStack(FAItemRegistry.INSTANCE.skull, 1, 2), firstDino).registerStat().setSpecial();
        usurper = new Achievement("achievement.usurper", "usurper", 8, -3, new ItemStack(FAItemRegistry.INSTANCE.skull, 1, EnumDinoBones.Spinosaurus.ordinal()), firstDino).registerStat().setSpecial();
        squire = new Achievement("achievement.squire", "squire", 7, -1, new ItemStack(FAItemRegistry.INSTANCE.skull, 1, 17), firstDino).registerStat();
        shear = new Achievement("achievement.shear", "shear", 6, -6, new ItemStack(Blocks.WOOL, 1, 12), mammalEmbryo).registerStat();
        deadDodo = new Achievement("achievement.deadDodo", "deadDodo", 4, 0, new ItemStack(FAItemRegistry.INSTANCE.skull, 1, EnumDinoBones.Dodo.ordinal()), birdEgg).registerStat();
        trexKill = new Achievement("achievement.trexKill", "trexKill", 8, -7, new ItemStack(FAItemRegistry.INSTANCE.toothDagger), theKing).registerStat();
        AchievementPage.registerAchievementPage(new AchievementPage("Fossils and Archeology", firstFossil, analyzer, tablet, dinoDna, cultivate, dinoEgg, mammalEmbryo, birdEgg, sifter, fossilSeeds, failuresaurus, failuresaurusAnalyzer, findAnuTotem, anuPortal, anubiteEncounter, anuAttack, anuDead, arcWorkbench, fixedSword, fixedHelmet, fixedVase, dinopedia, scarab, scarabTools, blueScarab, key, wtf, clock, firstDino, theKing, usurper, squire, shear, deadDodo, trexKill));
    }

}
