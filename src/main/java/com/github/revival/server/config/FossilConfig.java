package com.github.revival.server.config;

import net.ilexiconn.llibrary.server.config.ConfigEntry;

public class FossilConfig {
    @ConfigEntry(category = "generation")
    public static boolean generatePalaeoraphe = false;
    @ConfigEntry(category = "generation")
    public static boolean generateHellShips = true;
    @ConfigEntry(category = "generation")
    public static boolean generateAcademy = true;
    @ConfigEntry(category = "generation")
    public static boolean generateShips = true;
    @ConfigEntry(category = "generation")
    public static boolean generateTemple = true;
    @ConfigEntry(category = "generation")
    public static boolean generateFossils = true;
    @ConfigEntry(category = "generation")
    public static boolean generatePermafrost = true;
    @ConfigEntry(category = "generation")
    public static boolean generateVolcanicRock = true;

    @ConfigEntry
    public static boolean allowFlying = false;
    @ConfigEntry
    public static boolean healingDinos = true;
    @ConfigEntry
    public static boolean starvingDinos = true;
    @ConfigEntry
    public static boolean dinoBlockBreaking = true;
    @ConfigEntry
    public static boolean skullOverlay = true;
    @ConfigEntry
    public static boolean loginMessage = true;
    @ConfigEntry
    public static boolean anuSpawn = false;
    @ConfigEntry
    public static boolean anuAllowedOverworld = false;
    @ConfigEntry
    public static boolean allowTableEnchantments = true;
    @ConfigEntry
    public static boolean allowBookEnchantments = true;
    @ConfigEntry
    public static boolean allowBreeding = true;
    @ConfigEntry
    public static boolean customMainMenu = true;

    @ConfigEntry(category = "dinosaurs")
    public static boolean featheredTRex = false;
    @ConfigEntry(category = "dinosaurs")
    public static boolean featheredDeinonychus = false;
    @ConfigEntry(category = "dinosaurs")
    public static boolean featheredGallimimus = false;
    @ConfigEntry(category = "dinosaurs")
    public static boolean featheredCompsognathus = false;
    @ConfigEntry(category = "dinosaurs")
    public static boolean quilledTriceratops = true;
    @ConfigEntry(category = "dinosaurs")
    public static boolean featheredVelociraptor = false;

    @ConfigEntry(category = "ids")
    public static int biomeIDDarknessLair = 128;
    @ConfigEntry(category = "ids")
    public static int biomeIDTreasure = 127;
    @ConfigEntry(category = "ids")
    public static int dimensionIDDarknessLair = -23;
    @ConfigEntry(category = "ids")
    public static int dimensionIDTreasure = -34;

    @ConfigEntry(category = "ids")
    public static int enchantmentIDArcheology = 91;
    @ConfigEntry(category = "ids")
    public static int enchantmentIDPaleontology = 90;
}
