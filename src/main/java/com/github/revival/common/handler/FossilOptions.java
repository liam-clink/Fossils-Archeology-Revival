package com.github.revival.common.handler;

import net.minecraftforge.common.config.Configuration;

public class FossilOptions
{
    public static boolean Gen_Palaeoraphe;
    public static boolean Gen_HellShips;
    public static boolean Allow_Flying;
    public static boolean Gen_Academy;
    public static boolean Gen_Ships;
    public static boolean Gen_Temple;
    public static String Lang_Server;
    public static boolean Heal_Dinos;
    public static boolean Dinos_Starve;
    public static boolean Dino_Block_Breaking;
    public static boolean Skull_Overlay;
    public static boolean LoginMessage;
    public static boolean Anu_Spawn;
    public static boolean Anu_Allowed_Overworld;
    public static boolean TRexFeathers;
    public static boolean DeinonychusFeathers;
    public static boolean GallimimusFeathers;
    public static boolean CompsognathusFeathers;
    public static boolean TriceratopsQuills;
    public static boolean AllowTableEnchantments;
    public static boolean AllowBookEnchantments;
    public static boolean AllowBreeding;
    public static boolean VelociraptorFeathers;
    public static boolean DeveloperSpecials;
    public static boolean CustomMainMenu;
    public static int biomeIDDarknessLair;
    public static int biomeIDTreasure;
    public static int dimIDDarknessLair;
    public static int dimIDTreasure;

    public void Load(Configuration config)
    {
        Gen_Palaeoraphe = config.get("option", "Palaeoraphe", false).getBoolean(false);
        Gen_HellShips = config.get("option", "Hell Ships", true).getBoolean(true);
        Gen_Academy = config.get("option", "Academy", true).getBoolean(true);
        Gen_Ships = config.get("option", "Ships", true).getBoolean(true);
        Gen_Temple = config.get("option", "Temple", true).getBoolean(true);
        Lang_Server = config.get("option", "Serverlanguage", "en_US").getString();
        Heal_Dinos = config.get("option", "Heal_Dinos", true).getBoolean(true);
        Allow_Flying = config.get("option", "Allow_Flying", false).getBoolean(false);
        Dinos_Starve = config.get("option", "Dinos_Starve", true).getBoolean(true);
        Dino_Block_Breaking = config.get("option", "Dino_Block_Breaking", true).getBoolean(true);
        Skull_Overlay = config.get("option", "Skull_Overlay", true).getBoolean(true);
        LoginMessage = config.get("option", "Display_Login_Message", true).getBoolean(false);
        Anu_Spawn = config.get("option", "Anu_Spawn", false).getBoolean(false);
        Anu_Allowed_Overworld = config.get("option", "Anu_Allowed_Overworld", false).getBoolean(false);
        AllowTableEnchantments = config.get("option", "Allow Table Enchantments", true).getBoolean(true);
        AllowBookEnchantments = config.get("option", "Allow Book Enchantments", true).getBoolean(true);
        AllowBreeding = config.get("option", "Allow_Dinosaur_Breeding", true).getBoolean(true);

        TRexFeathers = config.get("toggle_scales", "Tyrannosaurus Scales", false).getBoolean(false);
        DeinonychusFeathers = config.get("toggle_scales", "Deinonychus Scales", false).getBoolean(false);
        GallimimusFeathers = config.get("toggle_scales", "Gallimimus Scales", false).getBoolean(false);
        CompsognathusFeathers = config.get("toggle_scales", "Compsognathus Scales", false).getBoolean(false);
        VelociraptorFeathers = config.get("toggle_scales", "Velociraptor Scales", false).getBoolean(false);
        TriceratopsQuills = config.get("toggle_quills", "Triceratops Quills", true).getBoolean(true);

        DeveloperSpecials = config.get("option", "(Devs only)Allow Dev Specials", true).getBoolean(true);
        CustomMainMenu = config.get("option", "Custom Main Menu", true).getBoolean(true);

        biomeIDDarknessLair = config.get("biome IDs", "Layer of Darkness ID:", 128).getInt();
        biomeIDTreasure = config.get("biome IDs", "Treasure ID:", 127).getInt();

        dimIDDarknessLair = config.get("dimension IDs", "Layer of Darkness ID:", -23).getInt();
        dimIDTreasure = config.get("dimension IDs", "Ancient Treasure Room ID:", -34).getInt();

    }

}
