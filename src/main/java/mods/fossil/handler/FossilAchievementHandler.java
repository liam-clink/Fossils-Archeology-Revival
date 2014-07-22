package mods.fossil.handler;

import net.minecraft.init.Items;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class FossilAchievementHandler
{
    public static AchievementPage FossilsAchievementPage;

    public static Achievement FirstEgg;
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
    public static Achievement pigBossOnEarth;

    public static void loadAchievements()
    {   
        FirstEgg = new Achievement("FirstEgg", "FirstEgg", 5, 0, Items.bone, CultVat).registerStat();
        addAchievementName("FirstEgg", "Dawn of the Dinosaurs!");
        addAchievementDesc("FirstEgg", "One small step for a dinosaur,");

        AllEggs = new Achievement("AllEggs", "AllEggs", 5, 1, Items.bone, FirstEgg).registerStat().setSpecial();
        addAchievementName("AllEggs", "Gotta Hatch 'Em All!");
        addAchievementDesc("AllEggs", "One giant leap for Dinosauria.");
        
        FoundFossils = new Achievement("FoundFossils", "FoundFossils", 2, 0, Items.bone, null).registerStat();
        addAchievementName("FoundFossils", "Trace from the past.");
        addAchievementDesc("FoundFossils", "Digging for bones!");
 
        Permafrost = new Achievement("Permafrost", "Permafrost", 0, 1, Items.book, null).registerStat();
        addAchievementName("Permafrost", "Try not to get a cold!");
        addAchievementDesc("Permafrost", "What wonders could be inside it?"); 
        
        ArchWorkbench = new Achievement("ArchWorkbench", "ArchWorkbench", 3, -1, Items.iron_shovel, null).registerStat();
        addAchievementName("ArchWorkbench", "Let's get the party started!");
        addAchievementDesc("ArchWorkbench", "First step in becoming an archaeologist.");         
        
        Analyzer = new Achievement("Analyzer", "Analyzer", 3, 0, Items.book, FoundFossils).registerStat();
        addAchievementName("Analyzer", "For SCIENCE!");
        addAchievementDesc("Analyzer", "Discovering the past!");    
        
        CultVat = new Achievement("CultVat", "CultVat", 4, 0, Items.book, Analyzer).registerStat();
        addAchievementName("CultVat", "Genetic manipulation.");
        addAchievementDesc("CultVat", "Bring history back to live!");
        
        Sifter = new Achievement("Sifter", "Sifter", 4, 1, Items.book, null).registerStat();
        addAchievementName("Sifter", "Cuz' baby I'm a Gold Digger!");
        addAchievementDesc("Sifter", "Even if I have to go through all the dirt!");
        
        Dinopedia = new Achievement("Dinopedia", "Dinopedia", 3, 1, Items.book, Analyzer).registerStat();
        addAchievementName("Dinopedia", "Fill all the pages!");
        addAchievementDesc("Dinopedia", "Find all the dinos!");

        IceAge = new Achievement("IceAge", "IceAge", 3, 1, Items.book, Analyzer).registerStat();
        addAchievementName("IceAge", "I do not know how you'll give birth...");
        addAchievementDesc("IceAge", "However I want the ice age back!");
        
        TheKing = new Achievement("TheKing", "TheKing", 5, -1, Items.book, null).registerStat().setSpecial();
        addAchievementName("TheKing", "Ruler of the Late Cretaceous.");
        addAchievementDesc("TheKing", "Long live the king!");
        
        pigBossOnEarth = new Achievement("pigBossOnEarth", "pigBossOnEarth", 8, -2, Items.book, null).registerStat().setSpecial();
        addAchievementName("pigBossOnEarth", "Hail Anu");
        addAchievementDesc("pigBossOnEarth", "You summoned Anu!");


        AchievementPage FossilsAchievementPage = new AchievementPage("Fossils",
                FirstEgg,
                AllEggs,
                FoundFossils,
                Permafrost,
                ArchWorkbench,
                Analyzer,
                CultVat,
                Sifter,
                Dinopedia,
                IceAge,
                TheKing,
                pigBossOnEarth
        		);
        AchievementPage.registerAchievementPage(FossilsAchievementPage);
    }

    private static void addAchievementName(String ach, String name)
    {
        LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
    }

    private static void addAchievementDesc(String ach, String desc)
    {
        LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
    }
}
