package com.github.revival.server.handler;

import com.github.revival.server.config.FossilConfig;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class EventNewMenu {
    public static final String[] titlePanoramaPaths = new String[]{"titlePanoramaPaths", "field_73978_o"};
    public static final String[] splashTexts = new String[]{"splashTexts", "field_110353_x"};

    public static ResourceLocation splashes = new ResourceLocation("fossil:splashes.txt");
    public static ResourceLocation[] panorama = new ResourceLocation[]{
            new ResourceLocation("fossil:textures/gui/panorama/south.png"),    //0 - north
            new ResourceLocation("fossil:textures/gui/panorama/west.png"),    //1 - west
            new ResourceLocation("fossil:textures/gui/panorama/north.png"),    //2 - south
            new ResourceLocation("fossil:textures/gui/panorama/east.png"),    //3 - east
            new ResourceLocation("fossil:textures/gui/panorama/up.png"),    //4 - up
            new ResourceLocation("fossil:textures/gui/panorama/down.png")};    //5 - down

    @SubscribeEvent
    public void openMainMenu(GuiOpenEvent event) {

        if (event.gui instanceof GuiMainMenu && FossilConfig.customMainMenu) {
            GuiMainMenu mainMenu = (GuiMainMenu) event.gui;
            Field field = ReflectionHelper.findField(GuiMainMenu.class, ObfuscationReflectionHelper.remapFieldNames(GuiMainMenu.class.getName(), titlePanoramaPaths));
            try {
                Field modifier = Field.class.getDeclaredField("modifiers");
                modifier.setAccessible(true);
                modifier.setInt(field, field.getModifiers() & ~Modifier.FINAL);
                field.set(mainMenu, panorama);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Field splashField = ReflectionHelper.findField(GuiMainMenu.class, ObfuscationReflectionHelper.remapFieldNames(GuiMainMenu.class.getName(), splashTexts));
            try {
                Field modifier = Field.class.getDeclaredField("modifiers");
                modifier.setAccessible(true);
                modifier.setInt(splashField, splashField.getModifiers() & ~Modifier.FINAL);
                splashField.set(mainMenu, splashes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}