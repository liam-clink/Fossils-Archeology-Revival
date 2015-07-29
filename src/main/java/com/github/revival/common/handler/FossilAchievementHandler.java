package com.github.revival.common.handler;

import com.github.revival.common.block.FABlockRegistry;
import com.github.revival.common.enums.EnumPrehistoric;
import com.github.revival.common.item.FAItemRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class FossilAchievementHandler
{
    public static AchievementPage FossilsAchievementPage;

    /* public static Achievement FirstEgg;
     public static Achievement AllEggs;
     public static Achievement FoundFossils;
     public static Achievement Permafrost;
     public static Achievement ArchWorkbench;
     public static Achievement Analyzer;
     public static Achievement CultVat;
     public static Achievement Sifter;
     public static Achievement Dinopedia;
     public static Achievement IceAge;
     public static Achievement TheKing;
     public static Achievement pigBossOnEarth;*/
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
    //  public static Achievement usurper;
    public static Achievement squire;
    public static Achievement shear;


    public static void loadAchievements()
    {
        firstFossil = new Achievement("achievement.firstFossil", "firstFossil", 0, 0, new ItemStack(FAItemRegistry.biofossil), (Achievement) null).registerStat();
        analyzer = new Achievement("achievement.analyzer", "analyzer", 0, -2, new ItemStack(FABlockRegistry.blockanalyzerActive), (Achievement) firstFossil).registerStat();
        tablet = new Achievement("achievement.tablet", "tablet", -2, -2, new ItemStack(FAItemRegistry.stoneboard), (Achievement) analyzer).registerStat();
        dinoDna = new Achievement("achievement.dinoDna", "dinoDna", 0, -4, new ItemStack(EnumPrehistoric.Tyrannosaurus.DNAItem), (Achievement) analyzer).registerStat().setSpecial();
        cultivate = new Achievement("achievement.cultivate", "cultivate", 2, -4, new ItemStack(FABlockRegistry.blockcultivateActive), (Achievement) dinoDna).registerStat();
        dinoEgg = new Achievement("achievement.dinoEgg", "dinoEgg", 4, -4, new ItemStack(EnumPrehistoric.Tyrannosaurus.eggItem), (Achievement) cultivate).registerStat();
        mammalEmbryo = new Achievement("achievement.mammalEmbryo", "mammalEmbryo", 4, -6, new ItemStack(EnumPrehistoric.Mammoth.embryoItem), (Achievement) cultivate).registerStat();
        birdEgg = new Achievement("achievement.birdEgg", "birdEgg", 4, -2, new ItemStack(EnumPrehistoric.Confuciusornis.bestBirdEggItem), (Achievement) cultivate).registerStat();
        sifter = new Achievement("achievement.sifter", "sifter", -2, 0, new ItemStack(FABlockRegistry.blockSifterActive), (Achievement) null).registerStat();
        fossilSeeds = new Achievement("achievement.fossilSeeds", "fossilSeeds", -2, -3, new ItemStack(FAItemRegistry.fossilSeed), (Achievement) analyzer).registerStat();
        failuresaurus = new Achievement("achievement.failuresaurus", "failuresaurus", 4, 0, new ItemStack(FABlockRegistry.blockSlimeTrail), (Achievement) cultivate).registerStat();
        failuresaurusAnalyzer = new Achievement("achievement.failuresaurusAnalyzer", "failuresaurusAnalyzer", 4, 2, new ItemStack(FAItemRegistry.failuresaurusFlesh), (Achievement) failuresaurus).registerStat();
        findAnuTotem = new Achievement("achievement.findAnuTotem", "findAnuTotem", -6, 6, new ItemStack(FABlockRegistry.anuTotem), (Achievement) null).registerStat();
        anuPortal = new Achievement("achievement.anuPortal", "anuPortal", -4, 5, new ItemStack(FABlockRegistry.anuPortal), (Achievement) findAnuTotem).registerStat();
        anubiteEncounter = new Achievement("achievement.anubiteEncounter", "anubiteEncounter", -2, 5, new ItemStack(FABlockRegistry.anubiteStatue), (Achievement) anuPortal).registerStat();
        anuAttack = new Achievement("achievement.anuAttack", "anuAttack", 0, 5, new ItemStack(FAItemRegistry.ancientSword), (Achievement) anubiteEncounter).registerStat();
        anuDead = new Achievement("achievement.anuDead", "anuDead", 2, 5, new ItemStack(FAItemRegistry.brokenSword), (Achievement) anuAttack).registerStat().setSpecial();
        arcWorkbench = new Achievement("achievement.arcWorkbench", "arcWorkbench", -6, 0, new ItemStack(FABlockRegistry.blockworktableActive), (Achievement) null).registerStat();
        fixedSword = new Achievement("achievement.fixedSword", "fixedSword", -6, -2, new ItemStack(FAItemRegistry.ancientSword), (Achievement) arcWorkbench).registerStat();
        fixedHelmet = new Achievement("achievement.fixedHelmet", "fixedHelmet", -6, 2, new ItemStack(FAItemRegistry.ancienthelmet), (Achievement) arcWorkbench).registerStat();
        fixedVase = new Achievement("achievement.fixedVase", "fixedVase", -4, 0, new ItemStack(FABlockRegistry.vaseAmphoraBlock, 1, 1), (Achievement) arcWorkbench).registerStat();
        dinopedia = new Achievement("achievement.dinopedia", "dinopedia", 0, -6, new ItemStack(FAItemRegistry.dinoPedia), (Achievement) dinoDna).registerStat();
        scarab = new Achievement("achievement.scarab", "scarab", 0, 2, new ItemStack(FAItemRegistry.gem), (Achievement) firstFossil).registerStat();
        scarabTools = new Achievement("achievement.scarabTools", "scarabTools", 2, 2, new ItemStack(FAItemRegistry.gemSword), (Achievement) scarab).registerStat();
        blueScarab = new Achievement("achievement.blueScarab", "blueScarab", -2, 2, new ItemStack(FAItemRegistry.AquaticScarabGem), (Achievement) scarab).registerStat();
        key = new Achievement("achievement.key", "key", 2, 7, new ItemStack(FAItemRegistry.ancientKey), (Achievement) anuDead).registerStat();
        wtf = new Achievement("achievement.inTreasure", "inTreasure", 4, 7, new ItemStack(Blocks.stonebrick), (Achievement) key).registerStat();
        clock = new Achievement("achievement.clock", "clock", 6, 7, new ItemStack(FAItemRegistry.ancientClock), (Achievement) wtf).registerStat();
        firstDino = new Achievement("achievement.firstDino", "firstDino", 6, -4, new ItemStack(FAItemRegistry.skull, 1, 0), (Achievement) dinoEgg).registerStat().setSpecial();
        theKing = new Achievement("achievement.theKing", "theKing", 8, -5, new ItemStack(FAItemRegistry.skull, 1, 2), (Achievement) firstDino).registerStat().setSpecial();
        //usurper =  new Achievement("achievement.usurper", "usurper",  8, -3, new ItemStack(Revival.skull, 1, 10), (Achievement)firstDino).registerStat().setSpecial();
        squire = new Achievement("achievement.squire", "squire", 7, -1, new ItemStack(FAItemRegistry.skull, 1, 17), (Achievement) firstDino).registerStat();
        shear = new Achievement("achievement.shear", "shear", 6, -6, new ItemStack(Blocks.wool, 1, 12), (Achievement) mammalEmbryo).registerStat();

        AchievementPage.registerAchievementPage(new AchievementPage("Fossils and Archeology",
                new Achievement[]{
                        firstFossil,
                        analyzer,
                        tablet,
                        dinoDna,
                        cultivate,
                        dinoEgg,
                        mammalEmbryo,
                        birdEgg,
                        sifter,
                        fossilSeeds,
                        failuresaurus,
                        failuresaurusAnalyzer,
                        findAnuTotem,
                        anuPortal,
                        anubiteEncounter,
                        anuAttack,
                        anuDead,
                        arcWorkbench,
                        fixedSword,
                        fixedHelmet,
                        fixedVase,
                        dinopedia,
                        scarab,
                        scarabTools,
                        blueScarab,
                        key,
                        wtf,
                        clock,
                        firstDino,
                        theKing,
                        //usurper,
                        squire,
                        shear
                }));
    }

}
