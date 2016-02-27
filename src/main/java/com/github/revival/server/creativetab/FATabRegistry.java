package com.github.revival.server.creativetab;

import net.ilexiconn.llibrary.common.content.IContentHandler;
import net.minecraft.creativetab.CreativeTabs;

public class FATabRegistry implements IContentHandler {
    public static CreativeTabs tabFBlocks;
    public static CreativeTabs tabFItems;
    public static CreativeTabs tabFFood;
    public static CreativeTabs tabFCombat;
    public static CreativeTabs tabFTools;
    public static CreativeTabs tabFFigurines;
    public static CreativeTabs tabFBones;

    public void init() {
        tabFBlocks = new FBlocksTab("Fossil Blocks");
        tabFItems = new FItemsTab("Fossil Items");
        tabFFood = new FFoodTab("Fossil Food");
        tabFCombat = new FCombatTab("Fossil Combat");
        tabFTools = new FToolsTab("Fossil Deco");
        tabFFigurines = new FFigurinesTab("Fossil Test");
        tabFBones = new FBonesTab("Fossil Bones");
    }

    public void gameRegistry() throws Exception {

    }
}