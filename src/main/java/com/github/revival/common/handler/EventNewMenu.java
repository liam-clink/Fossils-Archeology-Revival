package com.github.revival.common.handler;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Random;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.util.EnumChatFormatting;
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
    	default: return EnumChatFormatting.WHITE + "Inb4 Laser Scythes!";
    	case 1: return EnumChatFormatting.RED + "Red loves Yee!";
    	case 2: return EnumChatFormatting.WHITE + "Yee!";
    	case 3: return EnumChatFormatting.WHITE + "WILLOSAUR!";
    	case 4: return EnumChatFormatting.WHITE + "SPAAAAAAAAAAAAAAAAAAAAAAAACE!";
    	case 5: return EnumChatFormatting.WHITE + "DoDoge!";
    	case 6: return EnumChatFormatting.WHITE + "Raining Spiders!";
    	case 7: return EnumChatFormatting.WHITE + "4f6f3b!";
    	case 8: return EnumChatFormatting.WHITE + "Pls add *Dinosaur name here*!";
    	case 9: return EnumChatFormatting.WHITE + "Indominus Free!";
    	case 10: return EnumChatFormatting.RED + "Red is Blue?";
    	case 11: return EnumChatFormatting.BLUE + "Blue is Red?";
    	case 12: return EnumChatFormatting.WHITE + "Followers of Spode!";
    	case 13: return EnumChatFormatting.WHITE + "If I Had a Dime...";
    	case 14: return EnumChatFormatting.WHITE + "Quilled and Feathered to Perfection!";
    	case 15: return EnumChatFormatting.WHITE + "Dodo FTW!";
    	case 16: return EnumChatFormatting.RED + "Red is Yee?";
    	case 17: return EnumChatFormatting.WHITE + "No Yee pls!";
    	case 18: return EnumChatFormatting.WHITE + "Clever Girl!";
    	case 19: return EnumChatFormatting.WHITE + "Shoot Her!";
    	case 20: return EnumChatFormatting.WHITE + "I Like Turtles!";
    	case 21: return EnumChatFormatting.WHITE + "Scientifically Accurate!";
    	case 22: return EnumChatFormatting.WHITE + "Woah, Hey Guys!";
    	case 23: return EnumChatFormatting.WHITE + "Welcome to EB Games!";
    	case 24: return EnumChatFormatting.WHITE + "More Cowbell!";
    	case 25: return EnumChatFormatting.WHITE + "Cretaceous Park!";
    	case 26: return EnumChatFormatting.WHITE + "Number of the Beast!?!";
    	case 27: return EnumChatFormatting.WHITE + "Flying Doge Spinosaurus That Spouts Yee!?!";
    	case 28: return EnumChatFormatting.WHITE + "Out You Go on the Dustbin Lid!";
    	case 29: return EnumChatFormatting.WHITE + "It's Mr. Doctor Proffesor Raptor to You!";
    	case 30: return EnumChatFormatting.WHITE + "ALL ALLOOOOOOOOOOOOONE!";
    	case 31: return EnumChatFormatting.WHITE + "YEEEEEEEEEEAAAAAAAAAAAAAAAAAH!";
    	case 32: return EnumChatFormatting.WHITE + "RED HATES CAPS!";
    	case 33: return EnumChatFormatting.WHITE + "You're About to Become the Immediate Past President of the Being Alive Club!";
    	case 34: return EnumChatFormatting.WHITE + "Trey the Explainer!";
    	case 35: return EnumChatFormatting.WHITE + "Increase Anu Damage!";
    	case 36: return EnumChatFormatting.WHITE + "Oviraptor Overload!";
    	case 37: return EnumChatFormatting.WHITE + "Lex's LLib!";
    	case 38: return EnumChatFormatting.WHITE + "A Space Oddysey!";
    	case 39: return EnumChatFormatting.WHITE + "Fossils and ArcheologYEE!";
    	case 40: return "§4M§fo§9d §4B§fl§9e§4s§fs §9A§4m§fe§9r§4i§fc§9a!";

    	}
    }

}