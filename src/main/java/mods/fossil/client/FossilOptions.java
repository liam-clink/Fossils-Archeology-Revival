package mods.fossil.client;

import net.minecraftforge.common.config.Configuration;

public class FossilOptions
{
    
    public static boolean Gen_Palaeoraphe;
    public static boolean Gen_Academy;
    public static boolean Gen_Ships;
    public static String  Lang_Server;
    public static boolean Heal_Dinos;
    public static boolean Dinos_Starve;
    public static boolean Dino_Block_Breaking;
    public static boolean Skull_Overlay;
    public static boolean LoginMessage;
    public static boolean FossilDebug;
    public static int Debug_Gen_Rate_Academy;
    public static int Debug_Gen_Rate_Shipwreck;
    public static boolean Anu_Spawn;
    public static boolean Anu_Allowed_Overworld;

    public void Load(Configuration config)
    {
        Gen_Palaeoraphe = config.get("option", "Palaeoraphe", false).getBoolean(false);
        Gen_Academy = config.get("option", "Academy", true).getBoolean(true);
        Gen_Ships = config.get("option", "Ships", true).getBoolean(true);
        Lang_Server = config.get("option", "Serverlanguage", "en_US").getString();
        Heal_Dinos = config.get("option", "Heal_Dinos", true).getBoolean(true);
        Dinos_Starve = config.get("option", "Dinos_Starve", true).getBoolean(true);
        Dino_Block_Breaking = config.get("option", "Dino_Block_Breaking", true).getBoolean(true);
        Skull_Overlay = config.get("option", "Skull_Overlay", false).getBoolean(false);
        LoginMessage = config.get("option", "Display_Login_Message", true).getBoolean(false);
        FossilDebug = config.get("debug", "Fossil_Debug", false).getBoolean(false);
        Debug_Gen_Rate_Academy = config.get("debug", "Debug_Gen_RateAcademy", 1).getInt(1);
        Debug_Gen_Rate_Shipwreck = config.get("debug", "Debug_Gen_RateShipwreck", 1).getInt(1);
        Anu_Spawn = config.get("option", "Anu_Spawn", false).getBoolean(false);
        Anu_Allowed_Overworld = config.get("option", "Anu_Allowed_Overworld", false).getBoolean(false);
    }

}
