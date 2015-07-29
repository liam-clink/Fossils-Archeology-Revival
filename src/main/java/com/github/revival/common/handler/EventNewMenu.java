package com.github.revival.common.handler;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Random;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;

import com.github.revival.common.config.FossilConfig;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class EventNewMenu
{
    public static final String[] titlePanoramaPaths = new String[]{"titlePanoramaPaths", "field_73978_o"};
    public static final String[] splashText = new String[]{"splashText", "field_73975_c"};

    public static ResourceLocation[] panorama = new ResourceLocation[]{
        new ResourceLocation("fossil:textures/gui/panorama/south.png"),	//0 - north
        new ResourceLocation("fossil:textures/gui/panorama/west.png"),	//1 - west
        new ResourceLocation("fossil:textures/gui/panorama/north.png"),	//2 - south
        new ResourceLocation("fossil:textures/gui/panorama/east.png"),	//3 - east
        new ResourceLocation("fossil:textures/gui/panorama/up.png"),	//4 - up
        new ResourceLocation("fossil:textures/gui/panorama/down.png")};	//5 - down

    @SubscribeEvent
    public void openMainMenu(GuiOpenEvent event)
    {
    	
        if (event.gui instanceof GuiMainMenu && FossilConfig.customMainMenu)
        {
            GuiMainMenu mainMenu = (GuiMainMenu) event.gui;
            Field field = ReflectionHelper.findField(GuiMainMenu.class, ObfuscationReflectionHelper.remapFieldNames(GuiMainMenu.class.getName(), titlePanoramaPaths));
            try
            {
                Field modifier = Field.class.getDeclaredField("modifiers");
                modifier.setAccessible(true);
                modifier.setInt(field, field.getModifiers() & ~Modifier.FINAL);
                field.set(mainMenu, panorama);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            
            Field splashField = ReflectionHelper.findField(GuiMainMenu.class, ObfuscationReflectionHelper.remapFieldNames(GuiMainMenu.class.getName(), splashText));
            try
            {
                Field modifier = Field.class.getDeclaredField("modifiers");
                modifier.setAccessible(true);
                modifier.setInt(splashField, splashField.getModifiers() & ~Modifier.FINAL);
                splashField.set(mainMenu, getSplashText());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    private String getSplashText(){
    	Random rand = new Random();
    	int choice = rand.nextInt(41);
    	switch(choice){
    	default: return "§fInb4 Laser Scythes!";
    	case 1: return "§4Red loves Yee!";
    	case 2: return "§fYee!";
    	case 3: return "§fWILLOSAUR!";
    	case 4: return "§fSPAAAAAAAAAAAAAAAAAAAAAAAACE!";
    	case 5: return "§fDoDoge!";
    	case 6: return "§fRaining Spiders!";
    	case 7: return "§f4f6f3b!";
    	case 8: return "§fPls add *Dinosaur name here*!";
    	case 9: return "§fIndominus Free!";
    	case 10: return "§4Red is Blue?";
    	case 11: return "§1Blue is Red?";
    	case 12: return "§fFollowers of Spode!";
    	case 13: return "§fIf I Had a Dime...";
    	case 14: return "§fQuilled and Feathered to Perfection!";
    	case 15: return "§fDodo FTW!";
    	case 16: return "§4Red is Yee?";
    	case 17: return "§fNo Yee pls!";
    	case 18: return "§fClever Girl!";
    	case 19: return "§fShoot Her!";
    	case 20: return "§fI Like Turtles!";
    	case 21: return "§fScientifically Accurate!";
    	case 22: return "§fWoah, Hey Guys!";
    	case 23: return "§fWelcome to EB Games!";
    	case 24: return "§fMore Cowbell!";
    	case 25: return "§fCretaceous Park!";
    	case 26: return "§fNumber of the Beast!?!";
    	case 27: return "§fFlying Doge Spinosaurus That Spouts Yee!?!";
    	case 28: return "§fOut You Go on the Dustbin Lid!";
    	case 29: return "§fIt's Mr. Doctor Proffesor Raptor to You!";
    	case 30: return "§fALL ALLOOOOOOOOOOOOONE!";
    	case 31: return "§fYEEEEEEEEEEAAAAAAAAAAAAAAAAAH!";
    	case 32: return "§fRED HATES CAPS!";
    	case 33: return "§fYou're About to Become the Immediate Past President of the Being Alive Club!";
    	case 34: return "§fTrey the Explainer!";
    	case 35: return "§fIncrease Anu Damage!";
    	case 36: return "§fOviraptor Overload!";
    	case 37: return "§fLex's LLib!";
    	case 38: return "§fA Space Oddysey!";
    	case 39: return "§fFossils and ArcheologYEE!";
    	case 40: return "§4M§fo§9d §4B§fl§9e§4s§fs §9A§4m§fe§9r§4i§fc§9a!";

    	}
    }

}