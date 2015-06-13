package com.github.revival.common.handler;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class EventNewMenu
{
    public static final String[] titlePanoramaPaths = new String[]{"titlePanoramaPaths", "field_73978_o"};
    public static ResourceLocation[] panorama = new ResourceLocation[]{
            new ResourceLocation("fossil:textures/gui/panorama/up.png"),//1
            new ResourceLocation("fossil:textures/gui/panorama/down.png"),//2
            new ResourceLocation("fossil:textures/gui/panorama/north.png"),//3
            new ResourceLocation("fossil:textures/gui/panorama/east.png"),//4
            new ResourceLocation("fossil:textures/gui/panorama/south.png"),//5
            new ResourceLocation("fossil:textures/gui/panorama/west.png")};//6

    @SubscribeEvent
    public void openMainMenu(GuiOpenEvent event)
    {
        if (event.gui instanceof GuiMainMenu && FossilOptions.CustomMainMenu)
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
        }
    }

}