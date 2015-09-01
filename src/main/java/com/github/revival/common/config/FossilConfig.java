package com.github.revival.common.config;

import com.github.revival.common.handler.LocalizationStrings;
import net.ilexiconn.llibrary.common.config.IConfigHandler;
import net.minecraftforge.common.config.Configuration;

public class FossilConfig implements IConfigHandler
{
    public static boolean generatePalaeoraphe;
    public static boolean generateHellShips;
    public static boolean generateAcademy;
    public static boolean generateShips;
    public static boolean generateTemple;

    public static String serverLang;

    public static boolean allowFlying;
    public static boolean healingDinos;
    public static boolean starvingDinos;
    public static boolean dinoBlockBreaking;
    public static boolean skullOverlay;
    public static boolean loginMessage;
    public static boolean anuSpawn;
    public static boolean anuAllowedOverworld;
    public static boolean featheredTRex;
    public static boolean featheredDeinonychus;
    public static boolean featheredGallimimus;
    public static boolean featheredCompsognathus;
    public static boolean quilledTriceratops;
    public static boolean featheredDilophosaurus;
    public static boolean allowTableEnchantments;
    public static boolean allowBookEnchantments;
    public static boolean allowBreeding;
    public static boolean featheredVelociraptor;
    public static boolean developerSpecials;
    public static boolean customMainMenu;

    public static boolean genFossils;
    public static boolean genPermafrost;
    public static boolean genVolcanicRock;

    public static int biomeIdDarknessLair;
    public static int biomeIdTreasure;
    public static int dimIdDarknessLair;
    public static int dimIdTreasure;
    public static int enchIdArcheology;
    public static int enchIdPaleontology;

    public void loadConfig(Configuration configuration)
    {
        generatePalaeoraphe = configuration.get("option", "Palaeoraphe", false).getBoolean(false);
        generateHellShips = configuration.get("option", "Hell Ships", true).getBoolean(true);
        generateAcademy = configuration.get("option", "Academy", true).getBoolean(true);
        generateShips = configuration.get("option", "Ships", true).getBoolean(true);
        generateTemple = configuration.get("option", "Temple", true).getBoolean(true);
        serverLang = configuration.get("option", "Serverlanguage", "en_US").getString();
        healingDinos = configuration.get("option", "healingDinos", true).getBoolean(true);
        allowFlying = configuration.get("option", "allowFlying", false).getBoolean(false);
        starvingDinos = configuration.get("option", "starvingDinos", true).getBoolean(true);
        dinoBlockBreaking = configuration.get("option", "dinoBlockBreaking", true).getBoolean(true);
        skullOverlay = configuration.get("option", "skullOverlay", true).getBoolean(true);
        loginMessage = configuration.get("option", "Display_Login_Message", true).getBoolean(false);
        anuSpawn = configuration.get("option", "anuSpawn", false).getBoolean(false);
        anuAllowedOverworld = configuration.get("option", "anuAllowedOverworld", false).getBoolean(false);
        allowTableEnchantments = configuration.get("option", "Allow Table Enchantments", true).getBoolean(true);
        allowBookEnchantments = configuration.get("option", "Allow Book Enchantments", true).getBoolean(true);
        allowBreeding = configuration.get("option", "Allow_Dinosaur_Breeding", true).getBoolean(true);

	genFossils = configuration.get("option", "Generate Fossils", true).getBoolean(true);
	genPermafrost = configuration.get("option", "Generate Permafrost", true).getBoolean(true);
	genVolcanicRock = configuration.get("option", "Generate Volcanic Rock", true).getBoolean(true);

        featheredTRex = configuration.get("toggle_scales", "Tyrannosaurus Scales", false).getBoolean(false);
        featheredDeinonychus = configuration.get("toggle_scales", "Deinonychus Scales", false).getBoolean(false);
        featheredGallimimus = configuration.get("toggle_scales", "Gallimimus Scales", false).getBoolean(false);
        featheredCompsognathus = configuration.get("toggle_scales", "Compsognathus Scales", false).getBoolean(false);
        featheredVelociraptor = configuration.get("toggle_scales", "Velociraptor Scales", false).getBoolean(false);
        quilledTriceratops = configuration.get("toggle_quills", "Triceratops Quills", true).getBoolean(true);
        featheredDilophosaurus = configuration.get("toggle_scales", "Dilophosaurus Scales", false).getBoolean(false);

        developerSpecials = configuration.get("option", "(Devs only)Allow Dev Specials", true).getBoolean(true);
        customMainMenu = configuration.get("option", "Custom Main Menu", true).getBoolean(true);

<<<<<<< HEAD
        biomeIdDarknessLair = configuration.get("biome IDs", "Lair of Darkness ID:", 128).getInt();
=======
        biomeIdDarknessLair = configuration.get("biome IDs", "Layer of Darkness ID:", 128).getInt();
>>>>>>> origin/master
        biomeIdTreasure = configuration.get("biome IDs", "Treasure ID:", 127).getInt();

        dimIdDarknessLair = configuration.get("dimension IDs", "Layer of Darkness ID:", -23).getInt();
        dimIdTreasure = configuration.get("dimension IDs", "Ancient Treasure Room ID:", -34).getInt();

        enchIdArcheology = configuration.get(Configuration.CATEGORY_GENERAL, LocalizationStrings.ENCHANTMENT_ARCHEOLOGY, 91).getInt();
        enchIdPaleontology = configuration.get(Configuration.CATEGORY_GENERAL, LocalizationStrings.ENCHANTMENT_PALEONTOLOGY, 90).getInt();
    }
}
