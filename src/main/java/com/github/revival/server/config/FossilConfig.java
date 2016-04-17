package com.github.revival.server.config;

import cpw.mods.fml.relauncher.Side;
import net.ilexiconn.llibrary.server.config.ConfigEntry;

public class FossilConfig {
    @ConfigEntry(category = "generation")
    public boolean generatePalaeoraphe = false;
    @ConfigEntry(category = "generation")
    public boolean generateHellShips = true;
    @ConfigEntry(category = "generation")
    public boolean generateAcademy = true;
    @ConfigEntry(category = "generation")
    public boolean generateShips = true;
    @ConfigEntry(category = "generation")
    public boolean generateTemple = true;
    @ConfigEntry(category = "generation")
    public boolean generateFossils = true;
    @ConfigEntry(category = "generation")
    public boolean generatePermafrost = true;
    @ConfigEntry(category = "generation")
    public boolean generateVolcanicRock = true;

    @ConfigEntry
    public boolean allowFlying = false;
    @ConfigEntry
    public boolean healingDinos = true;
    @ConfigEntry
    public boolean starvingDinos = true;
    @ConfigEntry
    public boolean dinoBlockBreaking = true;
    @ConfigEntry
    public boolean skullOverlay = true;
    @ConfigEntry
    public boolean loginMessage = true;
    @ConfigEntry
    public boolean anuSpawn = false;
    @ConfigEntry
    public boolean anuAllowedOverworld = false;
    @ConfigEntry
    public boolean allowTableEnchantments = true;
    @ConfigEntry
    public boolean allowBookEnchantments = true;
    @ConfigEntry
    public boolean allowBreeding = true;
    @ConfigEntry(side = Side.CLIENT, category = "client")
    public boolean customMainMenu = true;

    @ConfigEntry(category = "dinosaurs")
    public boolean featheredTRex = false;
    @ConfigEntry(category = "dinosaurs")
    public boolean featheredDeinonychus = false;
    @ConfigEntry(category = "dinosaurs")
    public boolean featheredGallimimus = false;
    @ConfigEntry(category = "dinosaurs")
    public boolean featheredCompsognathus = false;
    @ConfigEntry(category = "dinosaurs")
    public boolean quilledTriceratops = true;
    @ConfigEntry(category = "dinosaurs")
    public boolean featheredVelociraptor = false;

    @ConfigEntry(category = "ids")
    public int biomeIDDarknessLair = 128;
    @ConfigEntry(category = "ids")
    public int biomeIDTreasure = 127;
    @ConfigEntry(category = "ids")
    public int dimensionIDDarknessLair = -23;
    @ConfigEntry(category = "ids")
    public int dimensionIDTreasure = -34;

    @ConfigEntry(category = "ids")
    public int enchantmentIDArcheology = 91;
    @ConfigEntry(category = "ids")
    public int enchantmentIDPaleontology = 90;
}
