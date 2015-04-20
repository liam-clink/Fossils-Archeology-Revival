package mods.fossil.handler;

import mods.fossil.Fossil;
import mods.fossil.core.FossilPlants;
import mods.fossil.fossilEnums.EnumDinoType;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
    public static Achievement clock;


    public static void loadAchievements()
    {   
    	firstFossil =  new Achievement("achievement.firstFossil", "firstFossil",  0, 0, new ItemStack(Fossil.biofossil), (Achievement)null).registerStat();
    	analyzer =  new Achievement("achievement.analyzer", "analyzer",  0, -2, new ItemStack(Fossil.blockanalyzerActive), (Achievement)firstFossil).registerStat();
    	tablet =  new Achievement("achievement.tablet", "tablet",  -2, -2, new ItemStack(Fossil.stoneboard), (Achievement)analyzer).registerStat();
    	dinoDna =  new Achievement("achievement.dinoDna", "dinoDna",  0, -4, new ItemStack(EnumDinoType.TRex.DNAItem), (Achievement)analyzer).registerStat().setSpecial();
    	cultivate =  new Achievement("achievement.cultivate", "cultivate",  2, -4, new ItemStack(Fossil.blockcultivateActive), (Achievement)dinoDna).registerStat();
    	dinoEgg =  new Achievement("achievement.dinoEgg", "dinoEgg",  4, -4, new ItemStack(EnumDinoType.TRex.EggItem), (Achievement)cultivate).registerStat();
    	mammalEmbryo =  new Achievement("achievement.mammalEmbryo", "mammalEmbryo",  4, -6, new ItemStack(Fossil.embryoMammoth), (Achievement)cultivate).registerStat();
    	birdEgg =  new Achievement("achievement.birdEgg", "birdEgg",  4, -2, new ItemStack(Fossil.cultivatedConfuciusornisEgg), (Achievement)cultivate).registerStat();
    	sifter =  new Achievement("achievement.sifter", "sifter",  -2, 0, new ItemStack(Fossil.blockSifterActive), (Achievement)null).registerStat();
    	fossilSeeds =  new Achievement("achievement.fossilSeeds", "fossilSeeds",  -2, -3, new ItemStack(FossilPlants.fossilSeed), (Achievement)analyzer).registerStat();
    	failuresaurus =  new Achievement("achievement.failuresaurus", "failuresaurus",  4, 0, new ItemStack(Fossil.blockSlimeTrail), (Achievement)cultivate).registerStat();
    	failuresaurusAnalyzer =  new Achievement("achievement.failuresaurusAnalyzer", "failuresaurusAnalyzer",  4, 2, new ItemStack(Fossil.failuresaurusFlesh), (Achievement)failuresaurus).registerStat();
    	findAnuTotem =  new Achievement("achievement.findAnuTotem", "findAnuTotem",  -6, 6, new ItemStack(Fossil.anuTotem), (Achievement)null).registerStat();
    	anuPortal =  new Achievement("achievement.anuPortal", "anuPortal",  -4, 5, new ItemStack(Fossil.anuPortal), (Achievement)findAnuTotem).registerStat();
    	anubiteEncounter =  new Achievement("achievement.anubiteEncounter", "anubiteEncounter",  -2, 5, new ItemStack(Fossil.anubiteStatue), (Achievement)anuPortal).registerStat();
    	anuAttack =  new Achievement("achievement.anuAttack", "anuAttack",  0, 5, new ItemStack(Fossil.ancientSword), (Achievement)anubiteEncounter).registerStat();
    	anuDead =  new Achievement("achievement.anuDead", "anuDead",  2, 5, new ItemStack(Fossil.brokenSword), (Achievement)anuAttack).registerStat().setSpecial();
    	arcWorkbench =  new Achievement("achievement.arcWorkbench", "arcWorkbench",  -6, 0, new ItemStack(Fossil.blockworktableActive), (Achievement)null).registerStat();
    	fixedSword =  new Achievement("achievement.fixedSword", "fixedSword",  -6, -2, new ItemStack(Fossil.ancientSword), (Achievement)arcWorkbench).registerStat();
    	fixedHelmet =  new Achievement("achievement.fixedHelmet", "fixedHelmet",  -6, 2, new ItemStack(Fossil.ancienthelmet), (Achievement)arcWorkbench).registerStat();
    	fixedVase =  new Achievement("achievement.fixedVase", "fixedVase",  -4, 0, new ItemStack(Fossil.vaseAmphoraBlock, 1, 1), (Achievement)arcWorkbench).registerStat();
    	dinopedia =  new Achievement("achievement.dinopedia", "dinopedia",  0, -6, new ItemStack(Fossil.dinoPedia), (Achievement)dinoDna).registerStat();
    	scarab =  new Achievement("achievement.scarab", "scarab",  0, 2, new ItemStack(Fossil.gem), (Achievement)firstFossil).registerStat();
    	scarabTools =  new Achievement("achievement.scarabTools", "scarabTools",  2, 2, new ItemStack(Fossil.gemSword), (Achievement)scarab).registerStat();
    	blueScarab =  new Achievement("achievement.blueScarab", "blueScarab",  -2, 2, new ItemStack(Fossil.AquaticScarabGem), (Achievement)scarab).registerStat();
    	key =  new Achievement("achievement.key", "key",  2, 7, new ItemStack(Fossil.ancientKey), (Achievement)anuDead).registerStat();
    	clock =  new Achievement("achievement.clock", "clock",  2, 7, new ItemStack(Fossil.ancientClock), (Achievement)key).registerStat();

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
        		clock
        		}));
    }

}
